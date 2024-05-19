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
package com.github.javaparser.symbolsolver.javaparsermodel.declarations;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.TypePatternExpr;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedPatternDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import java.util.Optional;

/**
 * WARNING: Implemented fairly blindly. Unsure if required or even appropriate. Use with extreme
 * caution.
 *
 * @author Roger Howell
 */
public class JavaParserPatternDeclaration implements ResolvedPatternDeclaration {

  private final TypePatternExpr wrappedNode;
  private final TypeSolver typeSolver;

  public JavaParserPatternDeclaration(TypePatternExpr wrappedNode, TypeSolver typeSolver) {
    this.wrappedNode = wrappedNode;
    this.typeSolver = typeSolver;
  }

  @Override
  public String getName() {
    return wrappedNode.getName().getId();
  }

  @Override
  public ResolvedType getType() {
    return JavaParserFacade.get(typeSolver).convert(wrappedNode.getType(), wrappedNode);
  }

  /**
   * Returns the JavaParser node associated with this JavaParserPatternDeclaration.
   *
   * @return A visitable JavaParser node wrapped by this object.
   */
  public TypePatternExpr getWrappedNode() {
    return wrappedNode;
  }

  @Override
  public Optional<Node> toAst() {
    return Optional.of(wrappedNode);
  }
}
