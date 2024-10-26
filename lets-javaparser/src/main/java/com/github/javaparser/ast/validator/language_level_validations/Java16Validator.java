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
package com.github.javaparser.ast.validator.language_level_validations;

/**
 * This validator validates according to Java 16 syntax rules.
 *
 * @see <a
 *     href="https://openjdk.java.net/projects/jdk/16/">https://openjdk.java.net/projects/jdk/16/</a>
 */
public class Java16Validator extends Java15Validator {

  public Java16Validator() {
    super();
    // Released Language Features
    // Pattern Matching for instanceof released within Java 16 - https://openjdk.java.net/jeps/305
    remove(noPatternMatchingInstanceOf);
    {
      // Records released within Java 16 - https://openjdk.java.net/jeps/395
      remove(noRecordDeclaration);
      add(recordAsTypeIdentifierNotAllowed);
      add(recordDeclarationValidator);
    }
  }
}
