/*
 * Copyright (c) 2013-2024 zhoupan (https://github.com/zhoupan).
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

import com.github.javaparser.ast.expr.InstanceOfExpr;
import com.github.javaparser.ast.expr.PatternExpr;
import com.github.javaparser.ast.expr.TypePatternExpr;
import com.github.javaparser.resolution.Context;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserPatternDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserSymbolDeclaration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Roger Howell
 */
public class InstanceOfExprContext extends AbstractJavaParserContext<InstanceOfExpr> {

  public InstanceOfExprContext(InstanceOfExpr wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
  }

  @Override
  public SymbolReference<? extends ResolvedValueDeclaration> solveSymbol(String name) {
    // TODO: Add PatternExprContext and solve in that
    Optional<PatternExpr> optionalPatternExpr = wrappedNode.getPattern();
    if (optionalPatternExpr.isPresent() && (optionalPatternExpr.get().isTypePatternExpr())) {
      TypePatternExpr typePatternExpr = optionalPatternExpr.get().asTypePatternExpr();
      if (typePatternExpr.getNameAsString().equals(name)) {
        JavaParserPatternDeclaration decl =
            JavaParserSymbolDeclaration.patternVar(typePatternExpr, typeSolver);
        return SymbolReference.solved(decl);
      }
    }

    Optional<Context> optionalParentContext = getParent();
    if (!optionalParentContext.isPresent()) {
      return SymbolReference.unsolved();
    }

    Context parentContext = optionalParentContext.get();
    if (parentContext instanceof BinaryExprContext) {
      Optional<PatternExpr> optionalPatternExpr1 = parentContext.patternExprInScope(name);
      if (optionalPatternExpr1.isPresent() && (optionalPatternExpr1.get().isTypePatternExpr())) {
        TypePatternExpr typePatternExpr = optionalPatternExpr1.get().asTypePatternExpr();
        JavaParserPatternDeclaration decl =
            JavaParserSymbolDeclaration.patternVar(typePatternExpr, typeSolver);
        return SymbolReference.solved(decl);
      }
    } // TODO: Also consider unary expr context

    // if nothing is found we should ask the parent context
    return solveSymbolInParentContext(name);
  }

  @Override
  public List<PatternExpr> patternExprsExposedFromChildren() {
    List<PatternExpr> results = new ArrayList<>();

    // If this instanceof expression has a pattern, add it to the list.
    wrappedNode.getPattern().ifPresent(results::add);

    return results;
  }
}
