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

import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.LiteralStringValueExpr;
import com.github.javaparser.ast.expr.LongLiteralExpr;
import com.github.javaparser.ast.validator.ProblemReporter;
import com.github.javaparser.ast.validator.VisitorValidator;

public class NoBinaryIntegerLiteralsValidator extends VisitorValidator {

  @Override
  public void visit(IntegerLiteralExpr n, ProblemReporter arg) {
    validate(n, arg);
    super.visit(n, arg);
  }

  @Override
  public void visit(LongLiteralExpr n, ProblemReporter arg) {
    validate(n, arg);
    super.visit(n, arg);
  }

  private static void validate(LiteralStringValueExpr n, ProblemReporter arg) {
    if (n.getValue().toUpperCase().startsWith("0B")) {
      arg.report(n, "Binary literal values are not supported.");
    }
  }
}
