/*
 * Copyright (c) 2011-2013 zhoupan (https://github.com/zhoupan).
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
 * This validator validates according to Java 19 syntax rules.
 *
 * @see <a
 *     href="https://openjdk.java.net/projects/jdk/19/">https://openjdk.java.net/projects/jdk/19/</a>
 */
public class Java19Validator extends Java18Validator {

  public Java19Validator() {
    super();
  }
}
