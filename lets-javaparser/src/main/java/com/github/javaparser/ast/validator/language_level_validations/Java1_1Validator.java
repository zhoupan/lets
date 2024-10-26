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

import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.stmt.LocalClassDeclarationStmt;
import com.github.javaparser.ast.validator.SingleNodeTypeValidator;
import com.github.javaparser.ast.validator.Validator;

/** This validator validates according to Java 1.1 syntax rules. */
public class Java1_1Validator extends Java1_0Validator {

  final Validator innerClasses =
      new SingleNodeTypeValidator<>(
          ClassOrInterfaceDeclaration.class,
          (n, reporter) ->
              n.getParentNode()
                  .ifPresent(
                      p -> {
                        if (p instanceof LocalClassDeclarationStmt && n.isInterface())
                          reporter.report(
                              n,
                              new UpgradeJavaMessage(
                                  "There is no such thing as a local interface.",
                                  ParserConfiguration.LanguageLevel.JAVA_16));
                      }));

  public Java1_1Validator() {
    super();
    replace(noInnerClasses, innerClasses);
    remove(noReflection);
  }
}
