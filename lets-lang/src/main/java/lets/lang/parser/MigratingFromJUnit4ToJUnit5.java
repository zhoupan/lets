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
package lets.lang.parser;

import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import java.io.File;
import java.nio.charset.Charset;
import java.util.*;
import lets.core.CoreUtils;
import lets.core.DataResultSupport;
import lets.core.StringUtils;
import lets.core.file.FindFileSupport;
import lets.core.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Migrating from JUnit4 to JUnit5.
 *
 * <p>1. Given CompilationUnit, if import JUnit4? No: IllegalStateException("No JUnit4 imports"); 2.
 * Replace JUnit4 to JUnit5 2.1 JUnit4 imports to JUnit5 "org.junit.Test" ->
 * "org.junit.jupiter.api.Test" "org.junit.Assert" -> "org.junit.jupiter.api.Assertions.*" 2.2
 * "@BeforeClass" -> "@BeforeAll" "@AfterClass" -> "@AfterAll" "@Before" -> "@BeforeEach" "@After"
 * -> "@AfterEach" "@Category" ->"@Tag" "@Ignore" -> "@Disabled"
 */
public class MigratingFromJUnit4ToJUnit5 extends VoidVisitorAdapter<Void> {
  public final Logger logger = LoggerFactory.getLogger(MigratingFromJUnit4ToJUnit5.class);

  private String[] junit4Imports = new String[] {"org.junit", "org.junit.Test", "org.junit.Assert"};
  private Map<String, String> junit4To5AnnotationMapping = new HashMap<String, String>();

  public String[] getJunit4Imports() {
    return junit4Imports;
  }

  public void setJunit4Imports(String[] junit4Imports) {
    this.junit4Imports = junit4Imports;
  }

  public Map<String, String> getJunit4To5AnnotationMapping() {
    return junit4To5AnnotationMapping;
  }

  public void setJunit4To5AnnotationMapping(Map<String, String> junit4To5AnnotationMapping) {
    this.junit4To5AnnotationMapping = junit4To5AnnotationMapping;
  }

  public MigratingFromJUnit4ToJUnit5() {
    this.junit4To5AnnotationMapping.put("BeforeClass", "BeforeAll");
    this.junit4To5AnnotationMapping.put("AfterClass", "AfterAll");
    this.junit4To5AnnotationMapping.put("Before", "BeforeEach");
    this.junit4To5AnnotationMapping.put("After", "AfterEach");
    this.junit4To5AnnotationMapping.put("Ignore", "Disabled");
    this.junit4To5AnnotationMapping.put("Category", "Tag");
  }

  public DataResultSupport<CompilationUnit> process(CompilationUnit sourceUnit) {
    DataResultSupport<CompilationUnit> resultSupport = new DataResultSupport<CompilationUnit>();
    try {
      resultSupport = JavaParserUtils.compilationUnitFrom(sourceUnit);
      resultSupport.checkState();
      // Updating testing classes and methods with new annotations
      // junit4: import org.junit.Assert;
      // junit5: import static org.junit.jupiter.Assertions.*;
      // junit4: import org.junit.Test;
      // junit5: import org.junit.jupiter.api.Test
      CompilationUnit unit = resultSupport.getData();
      NodeList<ImportDeclaration> list = unit.getImports();
      List<ImportDeclaration> toRemoveList = new ArrayList<ImportDeclaration>();
      for (ImportDeclaration listItem : list) {
        logger.info("Import: {}", listItem.getName());
        // Remove Import: JUnit4 test.
        if (StringUtils.containsAny(listItem.getNameAsString(), junit4Imports)) {
          logger.info("JUnit4 imports: {}", listItem.getNameAsString());
          toRemoveList.add(listItem);
        }
        // Remove Import: JUnit4 annotations.
        for (Iterator<Map.Entry<String, String>> it =
                this.junit4To5AnnotationMapping.entrySet().iterator();
            it.hasNext(); ) {
          Map.Entry<String, String> entry = it.next();
          String junit4 = String.format("org.junit.%s", entry.getKey());
          if (StringUtils.equals(junit4, listItem.getNameAsString())) {
            toRemoveList.add(listItem);
          }
        }
      }

      CoreUtils.checkState(toRemoveList.size() > 0, "No JUnit4 imports.");
      // Remove JUnit4 imports.
      unit.getImports().removeAll(toRemoveList);
      // Add JUnit5 imports.
      unit.addImport("org.junit.jupiter.api", false, true);
      unit.addImport("org.junit.jupiter.api.Assertions", true, true);
      // Replace Annotations.
      this.visit(unit, null);
      // Replace Assert to Assertions static imports.
      String source = unit.toString();
      source = StringUtils.remove(source, "Assert.");
      return JavaParserUtils.compilationUnitFromCode(source);
    } catch (Throwable e) {
      resultSupport.onException(e);
    }
    return resultSupport;
  }

  public DataResultSupport<File> process(
      File sourceFile, Charset sourceCharset, File targetFile, Charset targetCharset) {
    DataResultSupport<File> result = new DataResultSupport<File>();
    try {
      DataResultSupport<CompilationUnit> source =
          JavaParserUtils.compilationUnitFrom(sourceFile, sourceCharset);
      source.checkState();
      DataResultSupport<CompilationUnit> target = this.process(source.getData());
      target.checkState();
      FileUtils.writeStringToFile(targetFile, target.getData().toString(), targetCharset);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public DataResultSupport<File> process(File sourceFile, Charset charset) {
    return process(sourceFile, charset, sourceFile, charset);
  }

  public DataResultSupport<List<File>> process(FindFileSupport finder, Charset charset) {
    DataResultSupport<List<File>> result = new DataResultSupport<List<File>>();
    List<File> items = new ArrayList<File>();
    result.setData(items);
    try {
      finder.withIncludeWildcard("**/*.java");
      List<File> files = finder.findAll();
      for (File file : files) {
        DataResultSupport<File> process = this.process(file, charset);
        if (process.isSuccess()) {
          items.add(file);
          this.logger.info("Process: File={} Success.", file);
        } else {
          this.logger.error("Process: File={} Error={}", file, process.getMessage());
        }
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  @Override
  public void visit(ClassOrInterfaceDeclaration n, Void arg) {
    super.visit(n, arg);
    this.logger.info("Visit: ClassOrInterfaceDeclaration={}", n.getNameAsString());
    NodeList<AnnotationExpr> as = n.getAnnotations();
    List<AnnotationExpr> toRemoveList = new ArrayList<AnnotationExpr>();
    // @Category
    for (AnnotationExpr ae : as) {
      this.logger.info("Visit: AnnotationExpr={}", ae.getNameAsString());
      if (StringUtils.equals("Category", ae.getNameAsString())) {
        toRemoveList.add(ae);
      }
    }
    as.removeAll(toRemoveList);
  }

  @Override
  public void visit(MethodDeclaration n, Void arg) {
    super.visit(n, arg);
    this.logger.info("Visit: MethodDeclaration={}", n.getNameAsString());
    NodeList<AnnotationExpr> as = n.getAnnotations();
    for (AnnotationExpr ae : as) {
      this.logger.info("Visit: AnnotationExpr={}", ae.getNameAsString());
      for (Iterator<Map.Entry<String, String>> it =
              this.junit4To5AnnotationMapping.entrySet().iterator();
          it.hasNext(); ) {
        Map.Entry<String, String> entry = it.next();
        String junit4 = entry.getKey();
        String junit5 = entry.getValue();
        if (StringUtils.equals(junit4, ae.getNameAsString())) {
          this.logger.info("Migrating Annotation: JUnit4(@{}) To JUnit5(@{})", junit4, junit5);
          ae.setName(junit5);
        }
      }
    }
  }

  @Override
  public void visit(MethodCallExpr n, Void arg) {
    super.visit(n, arg);
    // Assert.assertTrue("works",true);
    // Assert.assertFalse("not works",false);
    String name = n.getName().asString();
    if (StringUtils.containsAny(name, "assertTrue", "assertFalse")) {
      NodeList<Expression> args = n.getArguments();
      // Swap arguments.
      if (args.size() == 2) {
        Optional<Expression> first = args.getFirst();
        Optional<Expression> last = args.getLast();
        n.getArguments().clear();
        n.getArguments().add(last.get());
        n.getArguments().add(first.get());
      }
    }
  }
}
