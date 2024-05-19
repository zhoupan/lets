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

import com.github.javaparser.ast.type.VarType;
import com.github.javaparser.ast.validator.SingleNodeTypeValidator;
import com.github.javaparser.ast.validator.Validator;
import com.github.javaparser.ast.validator.language_level_validations.chunks.VarValidator;

/**
 * This validator validates according to Java 10 syntax rules.
 *
 * @see <a
 *     href="https://openjdk.java.net/projects/jdk/10/">https://openjdk.java.net/projects/jdk/10/</a>
 */
public class Java10Validator extends Java9Validator {

  final Validator varOnlyOnLocalVariableDefinitionAndForAndTry =
      new SingleNodeTypeValidator<>(VarType.class, new VarValidator(false));

  public Java10Validator() {
    super();
    // Released Language Features
    {
      /*
       * Java 10 released local variable type inference in for and try-with (JEP286).
       * Java 11 released local variable type inference for lambda parameters also (JEP323)
       */
      add(varOnlyOnLocalVariableDefinitionAndForAndTry);
    }
  }
}
