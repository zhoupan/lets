/*
 * Copyright (c) 2021 zhoupan (https://github.com/zhoupan).
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

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.SimpleName;

/**
 * Validates that "record" cannot be used as identifier for type declarations (e.g., classes, enums,
 * and records). For details, see <a href="https://openjdk.java.net/jeps/395">JEP 395</a>
 */
public class RecordAsTypeIdentifierNotAllowed extends VisitorValidator {

  private final String error;

  public RecordAsTypeIdentifierNotAllowed() {
    error = "'record' is a restricted identifier and cannot be used for type declarations";
  }

  @Override
  public void visit(Name n, ProblemReporter arg) {
    if ("record".equals(n.getIdentifier()) && !validUsage(n)) {
      arg.report(n, error);
    }
    super.visit(n, arg);
  }

  @Override
  public void visit(SimpleName n, ProblemReporter arg) {
    if ("record".equals(n.getIdentifier()) && !validUsage(n)) {
      arg.report(n, error);
    }
    super.visit(n, arg);
  }

  private boolean validUsage(Node node) {
    if (!node.getParentNode().isPresent()) {
      return true;
    }
    Node parent = node.getParentNode().get();
    return !(parent instanceof TypeDeclaration);
  }
}
