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
package com.github.javaparser.ast.validator.language_level_validations.chunks;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.validator.ProblemReporter;
import com.github.javaparser.ast.validator.VisitorValidator;

public class UnderscoreKeywordValidator extends VisitorValidator {

  @Override
  public void visit(Name n, ProblemReporter arg) {
    validateIdentifier(n, n.getIdentifier(), arg);
    super.visit(n, arg);
  }

  @Override
  public void visit(SimpleName n, ProblemReporter arg) {
    validateIdentifier(n, n.getIdentifier(), arg);
    super.visit(n, arg);
  }

  private static void validateIdentifier(Node n, String id, ProblemReporter arg) {
    if ("_".equals(id)) {
      arg.report(n, "'_' is a reserved keyword.");
    }
  }
}
