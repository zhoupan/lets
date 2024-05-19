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
 * This validator validates according to Java 14 syntax rules -- including incubator/preview/second
 * preview features.
 *
 * @see <a
 *     href="https://openjdk.java.net/projects/jdk/14/">https://openjdk.java.net/projects/jdk/14/</a>
 */
public class Java14PreviewValidator extends Java14Validator {

  public Java14PreviewValidator() {
    super();
    // Incubator
    // No new incubator language features added within Java 14
    // Preview
    // Pattern Matching for instanceof - first preview within Java 14 -
    // https://openjdk.java.net/jeps/305
    remove(noPatternMatchingInstanceOf);
    {
      // first preview within Java 14 - https://openjdk.java.net/jeps/359
      remove(noRecordDeclaration);
      add(recordAsTypeIdentifierNotAllowed);
      add(recordDeclarationValidator);
    }
    // 2nd Preview
    // Text Block Literals - 2nd preview within Java 14 - https://openjdk.java.net/jeps/378
    remove(noTextBlockLiteral);
  }
}
