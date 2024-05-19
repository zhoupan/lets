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
package com.github.javaparser.generator.core.other;

import com.github.javaparser.generator.Generator;
import com.github.javaparser.utils.Log;
import com.github.javaparser.utils.SourceRoot;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/** Generates the bnd.bnd file in javaparser-core. */
public class BndGenerator extends Generator {

  public BndGenerator(SourceRoot sourceRoot) {
    super(sourceRoot);
  }

  @Override
  public void generate() throws IOException {
    Log.info("Running %s", () -> getClass().getSimpleName());
    Path root = sourceRoot.getRoot();
    Path projectRoot = root.getParent().getParent().getParent();
    String lineSeparator = System.getProperty("line.separator");
    try (Stream<Path> stream = Files.walk(root)) {
      String packagesList =
          stream
              .filter(Files::isRegularFile)
              .map(path -> getPackageName(root, path))
              .distinct()
              .sorted()
              .reduce(
                  null,
                  (packageList, packageName) ->
                      concatPackageName(packageName, packageList, lineSeparator));
      Path output = projectRoot.resolve("bnd.bnd");
      try (Writer writer = Files.newBufferedWriter(output)) {
        Path templateFile = projectRoot.resolve("bnd.bnd.template");
        String template = new String(Files.readAllBytes(templateFile), StandardCharsets.UTF_8);
        writer.write(template.replace("{exportedPackages}", packagesList));
      }
      Log.info("Written " + output);
    }
  }

  private String concatPackageName(String packageName, String packageList, String lineSeparator) {
    return (packageList == null ? ("\\" + lineSeparator) : (packageList + ", \\" + lineSeparator))
        + "    "
        + packageName;
  }

  private static String getPackageName(Path root, Path path) {
    return root.relativize(path.getParent()).toString().replace(File.separatorChar, '.');
  }
}
