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
package com.github.javaparser.ast.validator;

import static com.github.javaparser.utils.CodeGenerationUtils.f;

import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.SimpleName;

/**
 * Validates that identifiers are not keywords - this for the few keywords that the parser accepts
 * because they were added after Java 1.0.
 */
public class ReservedKeywordValidator extends VisitorValidator {

  private final String keyword;

  private final String error;

  public ReservedKeywordValidator(String keyword) {
    this.keyword = keyword;
    error = f("'%s' cannot be used as an identifier as it is a keyword.", keyword);
  }

  @Override
  public void visit(Name n, ProblemReporter arg) {
    if (n.getIdentifier().equals(keyword)) {
      arg.report(n, error);
    }
    super.visit(n, arg);
  }

  @Override
  public void visit(SimpleName n, ProblemReporter arg) {
    if (n.getIdentifier().equals(keyword)) {
      arg.report(n, error);
    }
    super.visit(n, arg);
  }
}
