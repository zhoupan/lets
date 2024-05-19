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

import static com.github.javaparser.resolution.Navigator.demandParentNode;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import java.util.Optional;

/**
 * @author Federico Tomassetti
 */
public class JavaParserVariableDeclaration implements ResolvedValueDeclaration {

  private VariableDeclarator variableDeclarator;
  private VariableDeclarationExpr wrappedNode;
  private TypeSolver typeSolver;

  public JavaParserVariableDeclaration(
      VariableDeclarator variableDeclarator, TypeSolver typeSolver) {
    if (typeSolver == null) {
      throw new IllegalArgumentException("typeSolver should not be null");
    }
    this.variableDeclarator = variableDeclarator;
    this.typeSolver = typeSolver;
    if (!(demandParentNode(variableDeclarator) instanceof VariableDeclarationExpr)) {
      throw new IllegalStateException(
          demandParentNode(variableDeclarator).getClass().getCanonicalName());
    }
    this.wrappedNode = (VariableDeclarationExpr) demandParentNode(variableDeclarator);
  }

  @Override
  public ResolvedType getType() {
    return JavaParserFacade.get(typeSolver).convert(variableDeclarator.getType(), wrappedNode);
  }

  @Override
  public String getName() {
    return variableDeclarator.getName().getId();
  }

  @Override
  public boolean isVariable() {
    return true;
  }

  /**
   * Returns the JavaParser node associated with this JavaParserFieldDeclaration.
   *
   * @return A visitable JavaParser node wrapped by this object.
   */
  public VariableDeclarationExpr getWrappedNode() {
    return wrappedNode;
  }

  public VariableDeclarator getVariableDeclarator() {
    return variableDeclarator;
  }

  @Override
  public String toString() {
    return "JavaParserVariableDeclaration{" + getName() + "}";
  }

  @Override
  public Optional<Node> toAst() {
    return Optional.of(wrappedNode);
  }
}
