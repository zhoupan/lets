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
import com.github.javaparser.ast.validator.language_level_validations.chunks.ModifierValidator;

/** This validator validates according to Java 1.2 syntax rules. */
public class Java1_2Validator extends Java1_1Validator {

  final Validator modifiersWithoutDefaultAndStaticInterfaceMethodsAndPrivateInterfaceMethods =
      new ModifierValidator(true, false, false);

  final Validator strictfpNotAllowed = new ReservedKeywordValidator("strictfp");

  public Java1_2Validator() {
    super();
    replace(
        modifiersWithoutStrictfpAndDefaultAndStaticInterfaceMethodsAndPrivateInterfaceMethods,
        modifiersWithoutDefaultAndStaticInterfaceMethodsAndPrivateInterfaceMethods);
    add(strictfpNotAllowed);
  }
}
