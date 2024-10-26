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
 * This validator validates according to Java 12 syntax rules -- including incubator/preview/second
 * preview features.
 *
 * @see <a
 *     href="https://openjdk.java.net/projects/jdk/12/">https://openjdk.java.net/projects/jdk/12/</a>
 */
public class Java12PreviewValidator extends Java12Validator {

  public Java12PreviewValidator() {
    super();
    // Incubator
    // No new incubator language features added within Java 12
    // Preview
    {
      /*
       * Switch Expressions (Preview) - first preview within Java 12 - https://openjdk.java.net/jeps/325
       * <ul>
       *     <li>Switch permissions are added within this preview.</li>
       *     <li>Multiple labels is NOT YET PERMITTED -- introduced within Java 14 release.</li>
       *     <li>Yield keyword is NOT YET PERMITTED -- introduced within Java 13 preview.</li>
       * </ul>
       */
      remove(noSwitchExpressions);
      remove(onlyOneLabelInSwitchCase);
    }
    // 2nd Preview
    // No new 2nd preview language features added within Java 12
  }
}
