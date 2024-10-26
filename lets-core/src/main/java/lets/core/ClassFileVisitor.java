/*
 * Copyright (c) 2023 zhoupan (https://github.com/zhoupan).
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

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassFileVisitor extends SimpleFileVisitor<Path> {

  private static final Logger logger = LoggerFactory.getLogger(ClassFileVisitor.class);

  public static final String CLASS_FILE_SUFFIX = ".class";
  private static final String PACKAGE_INFO_FILE_NAME = "package-info" + CLASS_FILE_SUFFIX;
  private static final String MODULE_INFO_FILE_NAME = "module-info" + CLASS_FILE_SUFFIX;

  private final Consumer<Path> classFileConsumer;

  public ClassFileVisitor(Consumer<Path> classFileConsumer) {
    this.classFileConsumer = classFileConsumer;
  }

  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
    if (isNotPackageInfo(file) && isNotModuleInfo(file) && isClassFile(file)) {
      classFileConsumer.accept(file);
    }
    return CONTINUE;
  }

  @Override
  public FileVisitResult visitFileFailed(Path file, IOException ex) {
    logger.warn("I/O error visiting file: {}", file, ex);
    return CONTINUE;
  }

  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException ex) {
    if (ex != null) {
      logger.warn("I/O error visiting directory: {}", dir, ex);
    }
    return CONTINUE;
  }

  public static boolean isNotPackageInfo(Path path) {
    return !path.endsWith(PACKAGE_INFO_FILE_NAME);
  }

  public static boolean isNotModuleInfo(Path path) {
    return !path.endsWith(MODULE_INFO_FILE_NAME);
  }

  public static boolean isClassFile(Path file) {
    return file.getFileName().toString().endsWith(CLASS_FILE_SUFFIX);
  }
}
