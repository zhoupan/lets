/*
 * Copyright (c) 2015-2016 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.symbolsolver.javaparsermodel.contexts;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.PatternExpr;
import com.github.javaparser.ast.expr.TypePatternExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserSymbolDeclaration;
import java.util.Collections;
import java.util.List;

/**
 * @author Federico Tomassetti
 */
public class VariableDeclarationExprContext
    extends AbstractJavaParserContext<VariableDeclarationExpr> {

  public VariableDeclarationExprContext(
      VariableDeclarationExpr wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
  }

  public SymbolReference<? extends ResolvedValueDeclaration> solveSymbol(String name) {
    List<PatternExpr> patternExprs = patternExprsExposedFromChildren();
    for (int i = 0; i < patternExprs.size(); i++) {
      if (patternExprs.get(i).isTypePatternExpr()) {
        TypePatternExpr typePatternExpr = patternExprs.get(i).asTypePatternExpr();
        if (typePatternExpr.getNameAsString().equals(name)) {
          return SymbolReference.solved(
              JavaParserSymbolDeclaration.patternVar(typePatternExpr, typeSolver));
        }
      }
    }
    // Default to solving in parent context if unable to solve directly here.
    return solveSymbolInParentContext(name);
  }

  @Override
  public List<VariableDeclarator> localVariablesExposedToChild(Node child) {
    for (int i = 0; i < wrappedNode.getVariables().size(); i++) {
      if (child == wrappedNode.getVariable(i)) {
        return wrappedNode.getVariables().subList(0, i);
      }
    }
    // TODO: Consider pattern exprs
    return Collections.emptyList();
  }

  @Override
  public List<PatternExpr> patternExprsExposedFromChildren() {
    // Variable declarations never make pattern expressions available.
    return Collections.emptyList();
  }

  @Override
  public List<PatternExpr> negatedPatternExprsExposedFromChildren() {
    // Variable declarations never make pattern expressions available.
    return Collections.emptyList();
  }
}
