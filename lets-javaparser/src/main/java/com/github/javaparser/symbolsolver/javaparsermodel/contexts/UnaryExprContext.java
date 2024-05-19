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

import com.github.javaparser.ast.expr.PatternExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.resolution.Context;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFactory;
import java.util.ArrayList;
import java.util.List;

public class UnaryExprContext extends AbstractJavaParserContext<UnaryExpr> {

  public UnaryExprContext(UnaryExpr wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
  }

  @Override
  public List<PatternExpr> patternExprsExposedFromChildren() {
    List<PatternExpr> results = new ArrayList<>();

    // Propagate any pattern expressions "up"
    if (wrappedNode.getOperator() == UnaryExpr.Operator.LOGICAL_COMPLEMENT) {
      Context innerContext = JavaParserFactory.getContext(wrappedNode.getExpression(), typeSolver);

      // Avoid infinite loop
      if (!this.equals(innerContext)) {
        // Note that `UnaryExpr.Operator.LOGICAL_COMPLEMENT` is `!`
        // Previously negated pattern expressions are now available (double negatives) -- e.g.
        // if(!!("a" instanceof String s)) {}
        results.addAll(innerContext.negatedPatternExprsExposedFromChildren());
      }
    }

    return results;
  }

  @Override
  public List<PatternExpr> negatedPatternExprsExposedFromChildren() {
    List<PatternExpr> results = new ArrayList<>();

    // Propagate any pattern expressions "up"
    if (wrappedNode.getOperator() == UnaryExpr.Operator.LOGICAL_COMPLEMENT) {
      Context innerContext = JavaParserFactory.getContext(wrappedNode.getExpression(), typeSolver);

      if (!this.equals(innerContext)) {
        // Note that `UnaryExpr.Operator.LOGICAL_COMPLEMENT` is `!`
        // Previously available pattern expressions are now negated (double negatives) -- e.g.
        // if(!("a" instanceof String s)) {}
        results.addAll(innerContext.patternExprsExposedFromChildren());
      }
    }

    return results;
  }
}
