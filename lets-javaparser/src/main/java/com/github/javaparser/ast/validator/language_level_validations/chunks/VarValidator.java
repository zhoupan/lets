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
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.ArrayInitializerExpr;
import com.github.javaparser.ast.expr.LambdaExpr;
import com.github.javaparser.ast.expr.NullLiteralExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.TryStmt;
import com.github.javaparser.ast.type.VarType;
import com.github.javaparser.ast.validator.ProblemReporter;
import com.github.javaparser.ast.validator.TypedValidator;
import java.util.Optional;

public class VarValidator implements TypedValidator<VarType> {

  private boolean varAllowedInLambdaParameters;

  public VarValidator(boolean varAllowedInLambdaParameters) {
    this.varAllowedInLambdaParameters = varAllowedInLambdaParameters;
  }

  @Override
  public void accept(VarType node, ProblemReporter reporter) {
    // All allowed locations are within a VariableDeclaration inside a VariableDeclarationExpr
    // inside something else.
    Optional<VariableDeclarator> variableDeclarator = node.findAncestor(VariableDeclarator.class);
    if (!variableDeclarator.isPresent()) {
      // Java 11's var in lambda's
      if (varAllowedInLambdaParameters) {
        boolean valid =
            node.findAncestor(Parameter.class)
                .flatMap(Node::getParentNode)
                .map((Node p) -> p instanceof LambdaExpr)
                .orElse(false);
        if (valid) {
          return;
        }
      }
      reportIllegalPosition(node, reporter);
      return;
    }
    variableDeclarator.ifPresent(
        vd -> {
          if (vd.getType().isArrayType()) {
            reporter.report(vd, "\"var\" cannot have extra array brackets.");
          }
          Optional<Node> variableDeclarationExpr = vd.getParentNode();
          if (!variableDeclarationExpr.isPresent()) {
            reportIllegalPosition(node, reporter);
            return;
          }
          variableDeclarationExpr.ifPresent(
              vdeNode -> {
                if (!(vdeNode instanceof VariableDeclarationExpr)) {
                  reportIllegalPosition(node, reporter);
                  return;
                }
                VariableDeclarationExpr vde = (VariableDeclarationExpr) vdeNode;
                if (vde.getVariables().size() > 1) {
                  reporter.report(vde, "\"var\" only takes a single variable.");
                }
                Optional<Node> container = vdeNode.getParentNode();
                if (!container.isPresent()) {
                  reportIllegalPosition(node, reporter);
                  return;
                }
                container.ifPresent(
                    c -> {
                      boolean positionIsFine =
                          c instanceof ForStmt
                              || c instanceof ForEachStmt
                              || c instanceof ExpressionStmt
                              || c instanceof TryStmt;
                      if (!positionIsFine) {
                        reportIllegalPosition(node, reporter);
                      }
                      // A local variable declaration ends up inside an ExpressionStmt.
                      if (c instanceof ExpressionStmt) {
                        if (!vd.getInitializer().isPresent()) {
                          reporter.report(node, "\"var\" needs an initializer.");
                        }
                        vd.getInitializer()
                            .ifPresent(
                                initializer -> {
                                  if (initializer instanceof NullLiteralExpr) {
                                    reporter.report(
                                        node, "\"var\" cannot infer type from just null.");
                                  }
                                  if (initializer instanceof ArrayInitializerExpr) {
                                    reporter.report(node, "\"var\" cannot infer array types.");
                                  }
                                });
                      }
                    });
              });
        });
  }

  private void reportIllegalPosition(VarType n, ProblemReporter reporter) {
    reporter.report(n, "\"var\" is not allowed here.");
  }
}
