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

import com.github.javaparser.ast.expr.EnclosedExpr;
import com.github.javaparser.ast.expr.PatternExpr;
import com.github.javaparser.resolution.Context;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFactory;
import java.util.ArrayList;
import java.util.List;

public class EnclosedExprContext extends AbstractJavaParserContext<EnclosedExpr> {

  public EnclosedExprContext(EnclosedExpr wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
  }

  @Override
  public List<PatternExpr> patternExprsExposedFromChildren() {
    List<PatternExpr> results = new ArrayList<>();
    /*
     * Test for an assignment expression
     * Example:
     *     while ((numChars = reader.read(buffer, 0, buffer.length)) > 0) {
     *         result.append(buffer, 0, numChars);
     *     }
     */
    if (!wrappedNode.getInner().isAssignExpr()) {
      // Propagate any pattern expressions "up" without modification
      Context innerContext = JavaParserFactory.getContext(wrappedNode.getInner(), typeSolver);
      if (!this.equals(innerContext)) {
        results = new ArrayList<>(innerContext.patternExprsExposedFromChildren());
      }
    }
    return results;
  }

  @Override
  public List<PatternExpr> negatedPatternExprsExposedFromChildren() {
    List<PatternExpr> results = new ArrayList<>();
    /*
     * Test for an assignment expression
     * Example:
     *     while ((numChars = reader.read(buffer, 0, buffer.length)) > 0) {
     *         result.append(buffer, 0, numChars);
     *     }
     */
    if (!wrappedNode.getInner().isAssignExpr()) {
      // Propagate any pattern expressions "up" without modification
      Context innerContext = JavaParserFactory.getContext(wrappedNode.getInner(), typeSolver);
      if (!this.equals(innerContext)) {
        results = new ArrayList<>(innerContext.negatedPatternExprsExposedFromChildren());
      }
    }
    return results;
  }
}
