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

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.validator.SingleNodeTypeValidator;
import com.github.javaparser.ast.validator.Validator;
import com.github.javaparser.ast.validator.language_level_validations.chunks.ModifierValidator;

/**
 * This validator validates according to Java 8 syntax rules.
 *
 * @see <a
 *     href="https://openjdk.java.net/projects/jdk8/">https://openjdk.java.net/projects/jdk8/</a>
 * @see <a
 *     href="https://openjdk.java.net/projects/jdk8/features">https://openjdk.java.net/projects/jdk8/features</a>
 */
public class Java8Validator extends Java7Validator {

  final Validator modifiersWithoutPrivateInterfaceMethods =
      new ModifierValidator(true, true, false);

  final Validator defaultMethodsInInterface =
      new SingleNodeTypeValidator<>(
          ClassOrInterfaceDeclaration.class,
          (n, reporter) -> {
            if (n.isInterface()) {
              n.getMethods()
                  .forEach(
                      m -> {
                        if (m.isDefault() && !m.getBody().isPresent()) {
                          reporter.report(m, "'default' methods must have a body.");
                        }
                      });
            }
          });

  public Java8Validator() {
    super();
    replace(
        modifiersWithoutDefaultAndStaticInterfaceMethodsAndPrivateInterfaceMethods,
        modifiersWithoutPrivateInterfaceMethods);
    add(defaultMethodsInInterface);
    remove(noLambdas);
    // TODO validate more annotation locations http://openjdk.java.net/jeps/104
    // TODO validate repeating annotations http://openjdk.java.net/jeps/120
  }
}
