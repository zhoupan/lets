/*
 * Copyright (c) 2015-2021 zhoupan (https://github.com/zhoupan).
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
package lets.core;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
import lets.core.function.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClasspathScanner {

  private static final Logger logger = LoggerFactory.getLogger(ClasspathScanner.class);

  private static final char CLASSPATH_RESOURCE_PATH_SEPARATOR = '/';
  private static final String CLASSPATH_RESOURCE_PATH_SEPARATOR_STRING =
      String.valueOf(CLASSPATH_RESOURCE_PATH_SEPARATOR);
  private static final char PACKAGE_SEPARATOR_CHAR = '.';
  private static final String PACKAGE_SEPARATOR_STRING = String.valueOf(PACKAGE_SEPARATOR_CHAR);

  /** Malformed class name InternalError like reported in #401. */
  private static final String MALFORMED_CLASS_NAME_ERROR_MESSAGE = "Malformed class name";

  private final Supplier<ClassLoader> classLoaderSupplier;

  private final BiFunction<String, ClassLoader, Try<Class<?>>> loadClass;

  public ClasspathScanner(
      Supplier<ClassLoader> classLoaderSupplier,
      BiFunction<String, ClassLoader, Try<Class<?>>> loadClass) {

    this.classLoaderSupplier = classLoaderSupplier;
    this.loadClass = loadClass;
  }

  public List<Class<?>> scanForClassesInPackage(String basePackageName, ClassFilter classFilter) {
    CoreUtils.checkState(
        PackageUtils.DEFAULT_PACKAGE_NAME.equals(basePackageName)
            || CoreUtils.isNotBlank(basePackageName),
        "basePackageName must not be null or blank");
    CoreUtils.checkNotNull(classFilter, "classFilter must not be null");
    basePackageName = basePackageName.trim();

    return findClassesForUris(
        getRootUrisForPackageNameOnClassPathAndModulePath(basePackageName),
        basePackageName,
        classFilter);
  }

  public List<Class<?>> scanForClassesInClasspathRoot(URI root, ClassFilter classFilter) {
    CoreUtils.checkNotNull(root, "root must not be null");
    CoreUtils.checkNotNull(classFilter, "classFilter must not be null");

    return findClassesForUri(root, PackageUtils.DEFAULT_PACKAGE_NAME, classFilter);
  }

  /** Recursively scan for classes in all of the supplied source directories. */
  private List<Class<?>> findClassesForUris(
      List<URI> baseUris, String basePackageName, ClassFilter classFilter) {
    // @formatter:off
    return baseUris.stream()
        .map(baseUri -> findClassesForUri(baseUri, basePackageName, classFilter))
        .flatMap(Collection::stream)
        .distinct()
        .collect(toList());
    // @formatter:on
  }

  private List<Class<?>> findClassesForUri(
      URI baseUri, String basePackageName, ClassFilter classFilter) {
    try (CloseablePath closeablePath = CloseablePath.create(baseUri)) {
      Path baseDir = closeablePath.getPath();
      return findClassesForPath(baseDir, basePackageName, classFilter);
    } catch (Throwable ex) {
      logger.warn("Error scanning files for URI {}", baseUri, ex);
      return emptyList();
    }
  }

  private List<Class<?>> findClassesForPath(
      Path baseDir, String basePackageName, ClassFilter classFilter) {
    CoreUtils.checkState(Files.exists(baseDir), "baseDir must exist: %s", baseDir);
    List<Class<?>> classes = new ArrayList<>();
    try {
      Files.walkFileTree(
          baseDir,
          new ClassFileVisitor(
              classFile ->
                  processClassFileSafely(
                      baseDir, basePackageName, classFilter, classFile, classes::add)));
    } catch (IOException ex) {
      logger.warn("I/O error scanning files in {}", baseDir, ex);
    }
    return classes;
  }

  private void processClassFileSafely(
      Path baseDir,
      String basePackageName,
      ClassFilter classFilter,
      Path classFile,
      Consumer<Class<?>> classConsumer) {
    try {
      String fullyQualifiedClassName =
          determineFullyQualifiedClassName(baseDir, basePackageName, classFile);
      if (classFilter.match(fullyQualifiedClassName)) {
        try {
          // @formatter:off
          loadClass
              .apply(fullyQualifiedClassName, getClassLoader())
              .toOptional()
              .filter(
                  classFilter) // Always use ".filter(classFilter)" to include future predicates.
              .ifPresent(classConsumer);
          // @formatter:on
        } catch (InternalError internalError) {
          handleInternalError(classFile, fullyQualifiedClassName, internalError);
        }
      }
    } catch (Throwable throwable) {
      handleThrowable(classFile, throwable);
    }
  }

  private String determineFullyQualifiedClassName(
      Path baseDir, String basePackageName, Path classFile) {
    // @formatter:off
    return Stream.of(
            basePackageName,
            determineSubpackageName(baseDir, classFile),
            determineSimpleClassName(classFile))
        .filter(value -> !value.isEmpty()) // Handle default package appropriately.
        .collect(joining(PACKAGE_SEPARATOR_STRING));
    // @formatter:on
  }

  private String determineSimpleClassName(Path classFile) {
    String fileName = classFile.getFileName().toString();
    return fileName.substring(0, fileName.length() - ClassFileVisitor.CLASS_FILE_SUFFIX.length());
  }

  private String determineSubpackageName(Path baseDir, Path classFile) {
    Path relativePath = baseDir.relativize(classFile.getParent());
    String pathSeparator = baseDir.getFileSystem().getSeparator();
    String subpackageName =
        relativePath.toString().replace(pathSeparator, PACKAGE_SEPARATOR_STRING);
    if (subpackageName.endsWith(pathSeparator)) {
      // Workaround for JDK bug: https://bugs.openjdk.java.net/browse/JDK-8153248
      subpackageName =
          subpackageName.substring(0, subpackageName.length() - pathSeparator.length());
    }
    return subpackageName;
  }

  private void handleInternalError(
      Path classFile, String fullyQualifiedClassName, InternalError ex) {
    if (MALFORMED_CLASS_NAME_ERROR_MESSAGE.equals(ex.getMessage())) {
      logMalformedClassName(classFile, fullyQualifiedClassName, ex);
    } else {
      logGenericFileProcessingException(classFile, ex);
    }
  }

  private void handleThrowable(Path classFile, Throwable throwable) {
    ExceptionUtils.rethrowIfUnrecoverable(throwable);
    logGenericFileProcessingException(classFile, throwable);
  }

  private void logMalformedClassName(
      Path classFile, String fullyQualifiedClassName, InternalError ex) {
    try {
      logger.debug(
          "The java.lang.Class loaded from path [{}] has a malformed class name [{}].",
          classFile.toAbsolutePath(),
          fullyQualifiedClassName,
          ex);
    } catch (Throwable t) {
      ExceptionUtils.rethrowIfUnrecoverable(t);
      ex.addSuppressed(t);
      logGenericFileProcessingException(classFile, ex);
    }
  }

  private void logGenericFileProcessingException(Path classFile, Throwable throwable) {
    logger.debug(
        "Failed to load java.lang.Class for path [{}] during classpath scanning.",
        classFile.toAbsolutePath(),
        throwable);
  }

  private ClassLoader getClassLoader() {
    return this.classLoaderSupplier.get();
  }

  private List<URI> getRootUrisForPackageNameOnClassPathAndModulePath(String basePackageName) {
    Set<URI> uriSet = new LinkedHashSet<>(getRootUrisForPackage(basePackageName));
    if (!basePackageName.isEmpty() && !basePackageName.endsWith(PACKAGE_SEPARATOR_STRING)) {
      getRootUrisForPackage(basePackageName + PACKAGE_SEPARATOR_STRING).stream() //
          .map(ClasspathScanner::removeTrailingClasspathResourcePathSeparator) //
          .forEach(uriSet::add);
    }
    return new ArrayList<>(uriSet);
  }

  private static URI removeTrailingClasspathResourcePathSeparator(URI uri) {
    String string = uri.toString();
    if (string.endsWith(CLASSPATH_RESOURCE_PATH_SEPARATOR_STRING)) {
      return URI.create(string.substring(0, string.length() - 1));
    }
    return uri;
  }

  private static String packagePath(String packageName) {
    if (packageName.isEmpty()) {
      return "";
    }
    return packageName.replace(PACKAGE_SEPARATOR_CHAR, CLASSPATH_RESOURCE_PATH_SEPARATOR);
  }

  private List<URI> getRootUrisForPackage(String basePackageName) {
    try {
      Enumeration<URL> resources = getClassLoader().getResources(packagePath(basePackageName));
      List<URI> uris = new ArrayList<>();
      while (resources.hasMoreElements()) {
        URL resource = resources.nextElement();
        uris.add(resource.toURI());
      }
      return uris;
    } catch (Exception ex) {
      logger.warn("Error reading URIs from class loader for base package {}", basePackageName, ex);
      return emptyList();
    }
  }
}
