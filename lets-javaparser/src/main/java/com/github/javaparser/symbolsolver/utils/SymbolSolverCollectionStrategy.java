/*
 * Copyright (c) 2015-2016 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.symbolsolver.utils;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.SKIP_SUBTREE;

import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.github.javaparser.utils.CollectionStrategy;
import com.github.javaparser.utils.Log;
import com.github.javaparser.utils.ProjectRoot;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * {@link CollectionStrategy} which collects all SourceRoots and initialises the TypeSolver and
 * returns the SourceRoots configured with the TypeSolver in a ProjectRoot object.
 */
public class SymbolSolverCollectionStrategy implements CollectionStrategy {

  private final ParserConfiguration parserConfiguration;

  private final CombinedTypeSolver typeSolver =
      new CombinedTypeSolver(new ReflectionTypeSolver(false));

  public SymbolSolverCollectionStrategy() {
    this(new ParserConfiguration());
  }

  public SymbolSolverCollectionStrategy(ParserConfiguration parserConfiguration) {
    // Allow the symbol resolver to be set via the given parser configuration
    this.parserConfiguration = parserConfiguration;
    if (!parserConfiguration.getSymbolResolver().isPresent()) {
      this.parserConfiguration.setSymbolResolver(new JavaSymbolSolver(typeSolver));
    }
  }

  @Override
  public ParserConfiguration getParserConfiguration() {
    return parserConfiguration;
  }

  @Override
  public ProjectRoot collect(Path path) {
    ProjectRoot projectRoot = new ProjectRoot(path, parserConfiguration);
    try {
      Files.walkFileTree(
          path,
          new SimpleFileVisitor<Path>() {

            private Path current_root;

            private Path currentProjectDir;

            private String previousSourceDirectory;

            private final PathMatcher javaMatcher = getPathMatcher("glob:**.java");

            private final PathMatcher jarMatcher = getPathMatcher("glob:**.jar");

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                throws IOException {
              if (javaMatcher.matches(file)) {
                String parent = file.getParent().toString();
                // This is not a very elegant or powerful solution but it works and it allows to
                // unblock users :-(
                // We are trying to verify the current_root directory for each package.
                // Sometime (for exemple https://github.com/apache/logging-log4j1) we can have java
                // packages directly under a base directory
                // and source directory under the same base package.
                // for exemple:
                // logging-log4j1\examples\customLevel\XLevel.java <- examples is a package (the
                // root source directory is logging-log4j1)
                // logging-log4j1\src\main\java\org\apache\log4j\Appender.java <- org is a package
                // (the root source directory is logging-log4j1\src\main\java)
                if (!parent.equals(previousSourceDirectory)) {
                  Log.info("Trying to compute the source root from %s", () -> file.toString());
                  previousSourceDirectory = parent;
                  currentProjectDir = getRoot(file).orElse(null);
                }
                if (current_root == null
                    || (currentProjectDir != null && !currentProjectDir.equals(current_root))) {
                  current_root = currentProjectDir;
                  if (current_root != null)
                    Log.info("New current source root is %s", () -> current_root.toString());
                }
              } else if (jarMatcher.matches(file)) {
                Log.info("Jar file is found %s", () -> file.toString());
                typeSolver.add(new JarTypeSolver(file.toString()));
              }
              return CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException {
              if (Files.isHidden(dir)) {
                Log.info("Skipping sub-tree %s", () -> dir.toString());
                return SKIP_SUBTREE;
              }
              return CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
              if (current_root != null && Files.isSameFile(dir, current_root)) {
                Log.info("Adding source root %s", () -> dir.toString());
                projectRoot.addSourceRoot(dir);
                typeSolver.add(
                    new JavaParserTypeSolver(current_root.toFile(), parserConfiguration));
                current_root = null;
              }
              return CONTINUE;
            }
          });
    } catch (IOException e) {
      Log.error(e, "Unable to walk %s", () -> path);
    }
    return projectRoot;
  }
}
