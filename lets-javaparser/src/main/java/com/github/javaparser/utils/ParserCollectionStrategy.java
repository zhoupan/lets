/*
 * Copyright (c) 2007-2010 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.utils;

import static java.nio.file.FileVisitResult.*;

import com.github.javaparser.ParserConfiguration;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * A brute force {@link CollectionStrategy} for discovering a project structure. It will search
 * through the given project root path for Java files, look at their package declarations, and
 * figure out the root directories for those files. No project definition files like pom.xml or
 * build.gradle are used. This strategy is crude, but can work for many cases. Note that any build
 * artifacts will also be detected: jar files in target directories and so on. Note that if your
 * project has a module-info.java file, ensure that you have set the language level to at least 9.
 */
public class ParserCollectionStrategy implements CollectionStrategy {

  private final ParserConfiguration parserConfiguration;

  public ParserCollectionStrategy() {
    this(new ParserConfiguration());
  }

  public ParserCollectionStrategy(ParserConfiguration parserConfiguration) {
    this.parserConfiguration = parserConfiguration;
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

            Path current_root;

            final PathMatcher javaMatcher = getPathMatcher("glob:**.java");

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
              if ("module-info.java".equals(file.getFileName().toString())) {
                // module-info.java is useless for finding the source root, since it can be placed
                // within any directory.
                return CONTINUE;
              }
              if (javaMatcher.matches(file)) {
                current_root = getRoot(file).orElse(null);
                if (current_root != null) {
                  return SKIP_SIBLINGS;
                }
              }
              return CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException {
              if (Files.isHidden(dir) || (current_root != null && dir.startsWith(current_root))) {
                return SKIP_SUBTREE;
              }
              return CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
              if (current_root != null && Files.isSameFile(dir, current_root)) {
                projectRoot.addSourceRoot(dir);
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
