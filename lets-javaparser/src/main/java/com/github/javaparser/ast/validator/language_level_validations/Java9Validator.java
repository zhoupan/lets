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

import com.github.javaparser.ast.stmt.TryStmt;
import com.github.javaparser.ast.validator.SingleNodeTypeValidator;
import com.github.javaparser.ast.validator.Validator;
import com.github.javaparser.ast.validator.language_level_validations.chunks.ModifierValidator;
import com.github.javaparser.ast.validator.language_level_validations.chunks.UnderscoreKeywordValidator;

/**
 * This validator validates according to Java 9 syntax rules.
 *
 * @see <a
 *     href="https://openjdk.java.net/projects/jdk9/">https://openjdk.java.net/projects/jdk9/</a>
 */
public class Java9Validator extends Java8Validator {

  final Validator underscoreKeywordValidator = new UnderscoreKeywordValidator();

  final Validator modifiers = new ModifierValidator(true, true, true);

  final SingleNodeTypeValidator<TryStmt> tryWithResources =
      new SingleNodeTypeValidator<>(
          TryStmt.class,
          (n, reporter) -> {
            if (n.getCatchClauses().isEmpty()
                && n.getResources().isEmpty()
                && !n.getFinallyBlock().isPresent()) {
              reporter.report(n, "Try has no finally, no catch, and no resources.");
            }
          });

  public Java9Validator() {
    super();
    // Released Language Features
    /*
     * Note there is no validator that validates that "var" is not used in Java 9 and lower, since
     * the parser will never create a VarType node (that is done by the Java 10 post-processor).
     * You can add the node by hand, but that is obscure enough to ignore.
     */
    add(underscoreKeywordValidator);
    remove(noModules);
    replace(modifiersWithoutPrivateInterfaceMethods, modifiers);
    replace(tryWithLimitedResources, tryWithResources);
  }
}
