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

import com.github.javaparser.ast.validator.ReservedKeywordValidator;
import com.github.javaparser.ast.validator.Validator;

/**
 * This validator validates according to Java 17 syntax rules.
 *
 * @see <a
 *     href="https://openjdk.java.net/projects/jdk/17/">https://openjdk.java.net/projects/jdk/17/</a>
 */
public class Java17Validator extends Java16Validator {

  final Validator sealedNotAllowedAsIdentifier = new ReservedKeywordValidator("sealed");

  final Validator permitsNotAllowedAsIdentifier = new ReservedKeywordValidator("permits");

  public Java17Validator() {
    super();
    // Released Language Features
    // Sealed Classes - https://openjdk.java.net/jeps/409
    add(sealedNotAllowedAsIdentifier);
    add(permitsNotAllowedAsIdentifier);
    remove(noSealedClasses);
    remove(noPermitsListInClasses);
  }
}
