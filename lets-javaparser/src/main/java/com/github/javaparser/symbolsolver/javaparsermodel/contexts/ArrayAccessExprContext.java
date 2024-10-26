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

import com.github.javaparser.ast.expr.ArrayAccessExpr;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;

/**
 * Required to prevent recursive access to the "parent node" (not necessarily the same as the
 * "parent context").
 *
 * <p>Consider, for example, this code where the cursor is currently at the node of type {@code
 * ArrayAccessExpr}:
 *
 * <pre>{@code
 * var1.perPriority[index].recovered
 * ^^^^^^^^^^^^^^^^^^^^^^^             - ArrayAccessExpr
 * }</pre>
 *
 * <p><b>The AST for this snippet:</b>
 *
 * <pre>{@code
 *                         FieldAccessExpr                       // This FieldAccessExpr is accessing the field `recovered`
 *                          /           \
 *            **ArrayAccessExpr**      SimpleName(recovered)
 *               /          \
 *       FieldAccessExpr  NameExpr(index)                        // This FieldAccessExpr is accessing the field `perPriority`
 *         /         \
 * NameExpr(var1)   SimpleName (perPriority)
 * }</pre>
 *
 * <p><b>In this example:</b>
 *
 * <ul>
 *   <li>The parent node for {@code ArrayAccessExpr} is {@code FieldAccessExpr} ({@code
 *       variable1.perPriority[index].recovered}).
 *       <pre>{@code
 * // "Parent Node" of the ArrayAccessExpr
 * var.perPriority[index].recovered
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^   - FieldAccessExpr
 * ^^^^^^^^^^^^^^^^^^^^^^             - ArrayAccessExpr
 *                        ^^^^^^^^^   - SimpleName
 * }</pre>
 *   <li>The parent context is the {@code FieldAccessExpr} to the left of the outer array-access,
 *       which is actually a child node.
 *       <pre>{@code
 * // "Parent Context" of the ArrayAccessExpr
 * var1.perPriority[index].recovered
 * ^^^^^^^^^^^^^^^^^^^^^^^             - ArrayAccessExpr
 * ^^^^^^^^^^^^^^^^                    - FieldAccessExpr
 *                  ^^^^^              - NameExpr
 * }</pre>
 * </ul>
 *
 * @author Roger Howell
 */
public class ArrayAccessExprContext extends AbstractJavaParserContext<ArrayAccessExpr> {

  public ArrayAccessExprContext(ArrayAccessExpr wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
  }

  public SymbolReference<? extends ResolvedValueDeclaration> solveSymbolInParentContext(
      String name) {
    /*
     * Simple implementation, included explicitly here for clarity:
     * - Delegate to parent context per the documentation for ArrayAccessExprContext
     * - Required to prevent recursive access to the "parent node" (not necessarily the same as the "parent context")
     */
    return super.solveSymbolInParentContext(name);
  }
}
