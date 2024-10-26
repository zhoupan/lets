/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package lets.antlr4;

import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import lets.core.file.FindFileSupport;
import org.antlr.v4.Tool;
import org.antlr.v4.codegen.CodeGenerator;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.tool.Grammar;
import org.slf4j.Logger;

public class Antlr4Tool {

  // First, let's deal with the options that the ANTLR tool itself
  // can be configured by.
  //

  org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Antlr4Tool.class);

  /**
   * Creates the MD5 checksum for the given file.
   *
   * @param file the file.
   * @return the checksum.
   */
  public static byte[] checksum(File file) throws IOException {
    try {
      InputStream in = new FileInputStream(file);
      byte[] buffer = new byte[2048];
      MessageDigest complete = MessageDigest.getInstance("MD5");

      try {
        int n;

        do {
          n = in.read(buffer);

          if (n > 0) {
            complete.update(buffer, 0, n);
          }
        } while (n != -1);
      } finally {
        in.close();
      }

      return complete.digest();
    } catch (NoSuchAlgorithmException ex) {
      throw new IOException("Could not create checksum " + file, ex);
    }
  }

  /**
   * Given the source directory File object and the full PATH to a grammar, produce the path to the
   * named grammar file in relative terms to the {@code sourceDirectory}. This will then allow ANTLR
   * to produce output relative to the base of the output directory and reflect the input
   * organization of the grammar files.
   *
   * @param sourceDirectory The source directory {@link File} object
   * @param grammarFile The full path to the input grammar file
   * @return The path to the grammar file relative to the source directory
   */
  public static String findSourceSubdir(File sourceDirectory, File grammarFile) {
    String srcPath = sourceDirectory.getPath() + File.separator;
    String path = grammarFile.getPath();

    if (!path.startsWith(srcPath)) {
      throw new IllegalArgumentException(
          "expected " + path + " to be prefixed with " + sourceDirectory);
    }

    File unprefixedGrammarFileName = new File(path.substring(srcPath.length()));

    if (unprefixedGrammarFileName.getParent() == null) {
      return "";
    }

    return unprefixedGrammarFileName.getParent() + File.separator;
  }

  public Antlr4Tool(File projectDir, String buildDir) {
    this.withProjectDir(projectDir, buildDir);
  }

  public void execute() throws Exception {

    Logger log = getLogger();

    outputEncoding = validateEncoding(outputEncoding);

    for (String e : excludes) {
      log.info("ANTLR: Exclude: " + e);
    }

    for (String e : includes) {
      log.info("ANTLR: Include: " + e);
    }

    log.info("ANTLR: Output: " + outputDirectory);
    log.info("ANTLR: Library: " + libDirectory);

    if (!antlr4GrammarDirectory.isDirectory()) {
      log.info("No ANTLR 4 grammars to compile in " + antlr4GrammarDirectory.getAbsolutePath());
      return;
    }

    // Ensure that the output directory path is all in tact so that
    // ANTLR can just write into it.
    //
    File outputDir = getOutputDirectory();

    if (!outputDir.exists()) {
      outputDir.mkdirs();
    }

    GrammarDependencies dependencies =
        new GrammarDependencies(
            antlr4GrammarDirectory,
            libDirectory,
            arguments,
            getDependenciesStatusFile(),
            getLogger());

    // Now pick up all the files and process them with the Tool
    //

    List<List<String>> argumentSets;
    Set<File> grammarFiles;
    Set<File> importGrammarFiles;
    try {
      List<String> args = getCommandArguments();
      grammarFiles = getGrammarFiles(antlr4GrammarDirectory);
      for (File grammarFile : grammarFiles) {
        log.info("getGrammarFiles: {}", grammarFile);
      }
      importGrammarFiles = getImportFiles(antlr4GrammarDirectory);
      for (File importGrammarFile : importGrammarFiles) {
        log.info("importGrammarFiles: {}", importGrammarFile);
      }
      argumentSets = processGrammarFiles(args, grammarFiles, dependencies, antlr4GrammarDirectory);
    } catch (Exception e) {
      log.error("", e);
      throw new Exception(
          "Fatal error occured while evaluating the names of the grammar files to analyze", e);
    }

    log.debug("Output directory base will be " + outputDirectory.getAbsolutePath());
    log.info("ANTLR 4: Processing source directory " + antlr4GrammarDirectory.getAbsolutePath());
    for (List<String> args : argumentSets) {
      try {
        // Create an instance of the ANTLR 4 build tool
        tool = new CustomTool(args.toArray(new String[0]));
      } catch (Exception e) {
        log.error(
            "The attempt to create the ANTLR 4 build tool failed, see exception report for details",
            e);
        throw new Exception("Error creating an instanceof the ANTLR tool.", e);
      }

      try {
        dependencies.analyze(grammarFiles, importGrammarFiles, tool);
      } catch (Exception e) {
        log.error("Dependency analysis failed, see exception report for details", e);
        throw new Exception("Dependency analysis failed.", e);
      }

      // Set working directory for ANTLR to be the base source directory
      tool.inputDirectory = antlr4GrammarDirectory;

      tool.processGrammarsOnCommandLine();

      // If any of the grammar files caused errors but did nto throw exceptions
      // then we should have accumulated errors in the counts
      if (tool.getNumErrors() > 0) {
        throw new Exception("ANTLR 4 caught " + tool.getNumErrors() + " build errors.");
      }
    }

    //    if (project != null) {
    //      // Tell Maven that there are some new source files underneath the output directory.
    //      addSourceRoot(this.getOutputDirectory());
    //    }

    try {
      dependencies.save();
    } catch (IOException ex) {
      log.warn("Could not save grammar dependency status", ex);
    }
  }

  public Antlr4Tool withProjectDir(File projectDir, String buildDir) {
    this.projectDir = projectDir;
    this.antlr4GrammarDirectory = new File(this.projectDir, "src/main/antlr4");
    this.buildDirectory = new File(this.projectDir, buildDir);
    this.outputDirectory = new File(this.buildDirectory, "generated-sources/antlr4");
    this.statusDirectory = new File(this.buildDirectory, "maven-status/antlr4");
    this.libDirectory = new File(this.projectDir, "src/main/antlr4/imports");
    return this;
  }

  public Antlr4Tool withOption(String name, String value) {
    this.options.put(name, value);
    return this;
  }

  public Antlr4Tool withLanguage(String language) {
    return withOption("language", language);
  }

  public Antlr4Tool withLanguageJava() {
    return withLanguage("Java");
  }

  public Antlr4Tool withArguments(String... args) {
    if (args != null) {
      for (String arg : args) {
        this.arguments.add(arg);
      }
    }
    return this;
  }

  /**
   * If set to true then the ANTLR tool will generate a description of the ATN for each rule in <a
   * href="http://www.graphviz.org">Dot format</a>.
   */
  // @Parameter(property = "antlr4.atn", defaultValue = "false")
  protected boolean atn;

  /** specify grammar file encoding; e.g., euc-jp */
  // @Parameter(property = "project.build.sourceEncoding")
  protected String inputEncoding = "UTF-8";

  /** specify output file encoding; defaults to source encoding */
  // @Parameter(property = "project.build.sourceEncoding")
  protected String outputEncoding = "UTF-8";

  /** Generate parse tree listener interface and base class. */
  // @Parameter(property = "antlr4.listener", defaultValue = "true")
  protected boolean listener = true;

  /** Generate parse tree visitor interface and base class. */
  // @Parameter(property = "antlr4.visitor", defaultValue = "false")
  protected boolean visitor = true;

  /** Treat warnings as errors. */
  // @Parameter(property = "antlr4.treatWarningsAsErrors", defaultValue = "false")
  protected boolean treatWarningsAsErrors;

  /** Use the ATN simulator for all predictions. */
  // @Parameter(property = "antlr4.forceATN", defaultValue = "false")
  protected boolean forceATN;

  /**
   * A list of grammar options to explicitly specify to the tool. These options are passed to the
   * tool using the <code>-D&lt;option&gt;=&lt;value&gt;</code> syntax.
   */
  // @Parameter
  protected Map<String, String> options = new HashMap<String, String>();

  /** A list of additional command line arguments to pass to the ANTLR tool. */
  // @Parameter
  protected List<String> arguments = new ArrayList<String>();

  /* --------------------------------------------------------------------
   * The following are Maven specific parameters, rather than specific
   * options that the ANTLR tool can use.
   */

  /**
   * Provides an explicit list of all the grammars that should be included in the generate phase of
   * the plugin. Note that the plugin is smart enough to realize that imported grammars should be
   * included but not acted upon directly by the ANTLR Tool.
   *
   * <p>A set of Ant-like inclusion patterns used to select files from the source directory for
   * processing. By default, the pattern <code>**&#47;*.g4</code> is used to select grammar files.
   */
  // @Parameter
  protected Set<String> includes = new HashSet<String>();

  /**
   * A set of Ant-like exclusion patterns used to prevent certain files from being processed. By
   * default, this set is empty such that no files are excluded.
   */
  // @Parameter
  protected Set<String> excludes = new HashSet<String>();

  /** The current Maven project. */
  // @Parameter(property = "project", required = true, readonly = true)
  // protected MavenProject project;
  protected File projectDir;

  /** Specifies whether sources are added to the {@code compile} or {@code test} scope. */
  // @Parameter(property = "antlr4.generateTestSources", defaultValue = "false")
  private boolean generateTestSources;

  /** The directory where the ANTLR grammar files ({@code *.g4}) are located. */
  // @Parameter(defaultValue = "${basedir}/src/main/antlr4")
  private File antlr4GrammarDirectory;

  private File buildDirectory;

  /** Specify output directory where the Java files are generated. */
  // @Parameter(defaultValue = "${project.build.directory}/generated-sources/antlr4")
  private File outputDirectory;

  /** Specify location of imported grammars and tokens files. */
  // @Parameter(defaultValue = "${basedir}/src/main/antlr4/imports")
  private File libDirectory;

  /** The directory where build status information is located. */
  // @Parameter(defaultValue = "${project.build.directory}/maven-status/antlr4", readonly = true)
  private File statusDirectory;

  public File getAntlr4GrammarDirectory() {
    return antlr4GrammarDirectory;
  }

  public File getOutputDirectory() {
    return outputDirectory;
  }

  public File getLibDirectory() {
    return libDirectory;
  }

  /** An instance of the ANTLR tool build */
  protected Tool tool;

  public boolean isAtn() {
    return atn;
  }

  public void setAtn(boolean atn) {
    this.atn = atn;
  }

  public String getInputEncoding() {
    return inputEncoding;
  }

  public void setInputEncoding(String inputEncoding) {
    this.inputEncoding = inputEncoding;
  }

  public String getOutputEncoding() {
    return outputEncoding;
  }

  public void setOutputEncoding(String outputEncoding) {
    this.outputEncoding = outputEncoding;
  }

  public boolean isListener() {
    return listener;
  }

  public void setListener(boolean listener) {
    this.listener = listener;
  }

  public boolean isVisitor() {
    return visitor;
  }

  public void setVisitor(boolean visitor) {
    this.visitor = visitor;
  }

  public boolean isTreatWarningsAsErrors() {
    return treatWarningsAsErrors;
  }

  public void setTreatWarningsAsErrors(boolean treatWarningsAsErrors) {
    this.treatWarningsAsErrors = treatWarningsAsErrors;
  }

  public boolean isForceATN() {
    return forceATN;
  }

  public void setForceATN(boolean forceATN) {
    this.forceATN = forceATN;
  }

  public Map<String, String> getOptions() {
    return options;
  }

  public void setOptions(Map<String, String> options) {
    this.options = options;
  }

  public List<String> getArguments() {
    return arguments;
  }

  public void setArguments(List<String> arguments) {
    this.arguments = arguments;
  }

  public Set<String> getIncludes() {
    return includes;
  }

  public void setIncludes(Set<String> includes) {
    this.includes = includes;
  }

  public Set<String> getExcludes() {
    return excludes;
  }

  public void setExcludes(Set<String> excludes) {
    this.excludes = excludes;
  }

  public File getProjectDir() {
    return projectDir;
  }

  public void setProjectDir(File projectDir) {
    this.projectDir = projectDir;
  }

  public boolean isGenerateTestSources() {
    return generateTestSources;
  }

  public void setGenerateTestSources(boolean generateTestSources) {
    this.generateTestSources = generateTestSources;
  }

  public void setAntlr4GrammarDirectory(File antlr4GrammarDirectory) {
    this.antlr4GrammarDirectory = antlr4GrammarDirectory;
  }

  public File getBuildDirectory() {
    return buildDirectory;
  }

  public void setBuildDirectory(File buildDirectory) {
    this.buildDirectory = buildDirectory;
  }

  public void setOutputDirectory(File outputDirectory) {
    this.outputDirectory = outputDirectory;
  }

  public void setLibDirectory(File libDirectory) {
    this.libDirectory = libDirectory;
  }

  public File getStatusDirectory() {
    return statusDirectory;
  }

  public void setStatusDirectory(File statusDirectory) {
    this.statusDirectory = statusDirectory;
  }

  public Tool getTool() {
    return tool;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

  public Logger getLogger() {
    return logger;
  }

  public void setLogger(Logger logger) {
    this.logger = logger;
  }

  private List<String> getCommandArguments() {
    List<String> args = new ArrayList<String>();

    if (getOutputDirectory() != null) {
      args.add("-o");
      args.add(outputDirectory.getAbsolutePath());
    }

    // Where do we want ANTLR to look for .tokens and import grammars?
    if (getLibDirectory() != null && getLibDirectory().isDirectory()) {
      args.add("-lib");
      args.add(libDirectory.getAbsolutePath());
    }

    // Next we need to set the options given to us in the pom into the
    // tool instance we have created.
    if (atn) {
      args.add("-atn");
    }

    if (inputEncoding != null && !inputEncoding.isEmpty()) {
      args.add("-encoding");
      outputEncoding = inputEncoding;
      args.add(inputEncoding);
    }

    if (listener) {
      args.add("-listener");
    } else {
      args.add("-no-listener");
    }

    if (visitor) {
      args.add("-visitor");
    } else {
      args.add("-no-visitor");
    }

    if (treatWarningsAsErrors) {
      args.add("-Werror");
    }

    if (forceATN) {
      args.add("-Xforce-atn");
    }

    if (options != null) {
      for (Map.Entry<String, String> option : options.entrySet()) {
        args.add(String.format("-D%s=%s", option.getKey(), option.getValue()));
      }
    }

    if (arguments != null) {
      args.addAll(arguments);
    }

    return args;
  }

  /**
   * @param sourceDirectory
   */
  private List<List<String>> processGrammarFiles(
      List<String> args,
      Set<File> grammarFiles,
      GrammarDependencies dependencies,
      File sourceDirectory)
      throws IOException {

    // We don't want the plugin to run for every grammar, regardless of whether
    // it's changed since the last compilation. Check the mtime of the tokens vs
    // the grammar file mtime to determine whether we even need to execute.
    Set<File> grammarFilesToProcess = new HashSet<File>();

    for (File grammarFile : grammarFiles) {
      String tokensFileName = grammarFile.getName().split("\\.")[0] + ".tokens";
      File outputFile = new File(outputDirectory, tokensFileName);
      if ((!outputFile.exists())
          || outputFile.lastModified() <= grammarFile.lastModified()
          || dependencies.isDependencyChanged(grammarFile)) {
        grammarFilesToProcess.add(grammarFile);
      }
    }

    grammarFiles = grammarFilesToProcess;

    if (grammarFiles.isEmpty()) {
      getLogger().info("No grammars to process");
      return Collections.emptyList();
    }

    MultiMap<String, File> grammarFileByFolder = new MultiMap<String, File>();
    // Iterate each grammar file we were given and add it into the tool's list of
    // grammars to process.
    for (File grammarFile : grammarFiles) {

      getLogger().debug("Grammar file '" + grammarFile.getPath() + "' detected.");

      String relPathBase = Antlr4Tool.findSourceSubdir(sourceDirectory, grammarFile);
      String relPath = relPathBase + grammarFile.getName();
      getLogger().debug("  ... relative path is: " + relPath);

      grammarFileByFolder.map(relPathBase, grammarFile);
    }

    List<List<String>> result = new ArrayList<List<String>>();
    for (Map.Entry<String, List<File>> entry : grammarFileByFolder.entrySet()) {
      List<String> folderArgs = new ArrayList<String>(args);
      if (!folderArgs.contains("-package") && !entry.getKey().isEmpty()) {
        folderArgs.add("-package");
        folderArgs.add(getPackageName(entry.getKey()));
      }

      for (File file : entry.getValue()) {
        folderArgs.add(entry.getKey() + file.getName());
      }

      result.add(folderArgs);
    }

    return result;
  }

  private Set<File> getImportFiles(File sourceDirectory) {
    if (!libDirectory.exists()) return Collections.emptySet();

    Set<String> includes = new HashSet<String>();
    includes.add("*.g4");
    includes.add("*.tokens");
    FindFileSupport findFileSupport = new FindFileSupport();
    findFileSupport.withRecursive(false);
    findFileSupport.withSearchPath(sourceDirectory);
    findFileSupport.withIncludeWildcard(includes);
    return findFileSupport.findAllSet();
  }

  private Set<File> getGrammarFiles(File sourceDirectory) {
    // Which files under the source set should we be looking for as grammar files
    // SourceMapping mapping = new SuffixMapping("g4", Collections.<String>emptySet());

    // What are the sets of includes (defaulted or otherwise).
    Set<String> includes = getIncludesPatterns();

    // Now, to the excludes, we need to add the imports directory
    // as this is autoscanned for imported grammars and so is auto-excluded from the
    // set of grammar fields we should be analyzing.
    excludes.add("imports/**");

    FindFileSupport findFileSupport = new FindFileSupport();
    findFileSupport.withSearchPath(sourceDirectory);
    findFileSupport.withRecursive(true).withIncludeDirs(false);
    // findFileSupport.withExcludeWildcard(excludes);
    findFileSupport.withIncludeWildcard(includes);
    return findFileSupport.findAllSet();
  }

  private static String getPackageName(String relativeFolderPath) {
    if (relativeFolderPath.contains("..")) {
      throw new UnsupportedOperationException("Cannot handle relative paths containing '..'");
    }

    List<String> parts =
        new ArrayList<String>(Arrays.asList(relativeFolderPath.split("[/\\\\\\.]+")));
    while (parts.remove("")) {
      // intentionally blank
    }

    return Utils.join(parts.iterator(), ".");
  }

  public Set<String> getIncludesPatterns() {
    if (includes == null || includes.isEmpty()) {
      return Collections.singleton("**/*.g4");
    }
    return includes;
  }

  private File getDependenciesStatusFile() {
    File statusFile = new File(statusDirectory, "dependencies.ser");

    if (!statusFile.getParentFile().exists()) {
      statusFile.getParentFile().mkdirs();
    }

    return statusFile;
  }

  private final class CustomTool extends Tool {

    public CustomTool(String[] args) {
      super(args);
      addListener(new Antlr4ErrorLog(this, getLogger()));
    }

    @Override
    public void process(Grammar g, boolean gencode) {
      getLogger().info("Processing grammar: " + g.fileName + "gencode: " + gencode);
      super.process(g, gencode);
    }

    @Override
    public Writer getOutputFileWriter(Grammar g, String fileName) throws IOException {
      getLogger().info("getOutputFileWriter: fileName={}", fileName);
      if (outputDirectory == null) {
        getLogger().warn("getOutputFileWriter: outputDirectory == null");
        return new StringWriter();
      }
      // output directory is a function of where the grammar file lives
      // for subdir/T.g4, you get subdir here.  Well, depends on -o etc...
      // But, if this is a .tokens file, then we force the output to
      // be the base output directory (or current directory if there is not a -o)
      //
      File outputDir;
      if (fileName.endsWith(CodeGenerator.VOCAB_FILE_EXTENSION)) {
        outputDir = new File(outputDirectory);
      } else {
        outputDir = getOutputDirectory(g.fileName);
      }
      getLogger().info("outputDir: {}", outputDir);
      File outputFile = new File(outputDir, fileName);
      if (!outputDir.exists()) {
        outputDir.mkdirs();
      }
      getLogger().info("outputFile: {}", outputFile);
      URI relativePath = Antlr4Tool.this.projectDir.toURI().relativize(outputFile.toURI());
      Antlr4Tool.this.getLogger().info("  Writing file: " + relativePath);
      OutputStream outputStream = new FileOutputStream(outputFile);
      if (outputEncoding != null && !outputEncoding.isEmpty()) {
        return new BufferedWriter(new OutputStreamWriter(outputStream, outputEncoding));
      } else {
        return new BufferedWriter(new OutputStreamWriter(outputStream));
      }
    }
  }

  /**
   * Validates the given encoding.
   *
   * @return the validated encoding. If {@code null} was provided, returns the platform default
   *     encoding.
   */
  private String validateEncoding(String encoding) {
    return (encoding == null)
        ? Charset.defaultCharset().name()
        : Charset.forName(encoding.trim()).name();
  }
}
