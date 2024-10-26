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
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedEnumConstantDeclaration;
import com.github.javaparser.resolution.model.typesystem.ReferenceTypeImpl;
import com.github.javaparser.resolution.types.ResolvedType;
import java.util.Optional;

/**
 * @author Federico Tomassetti
 */
public class JavaParserEnumConstantDeclaration implements ResolvedEnumConstantDeclaration {

  private TypeSolver typeSolver;

  private com.github.javaparser.ast.body.EnumConstantDeclaration wrappedNode;

  public JavaParserEnumConstantDeclaration(
      com.github.javaparser.ast.body.EnumConstantDeclaration wrappedNode, TypeSolver typeSolver) {
    this.wrappedNode = wrappedNode;
    this.typeSolver = typeSolver;
  }

  @Override
  public ResolvedType getType() {
    return new ReferenceTypeImpl(
        new JavaParserEnumDeclaration((EnumDeclaration) demandParentNode(wrappedNode), typeSolver));
  }

  @Override
  public String getName() {
    return wrappedNode.getName().getId();
  }

  /**
   * Returns the JavaParser node associated with this JavaParserEnumConstantDeclaration.
   *
   * @return A visitable JavaParser node wrapped by this object.
   */
  public com.github.javaparser.ast.body.EnumConstantDeclaration getWrappedNode() {
    return wrappedNode;
  }

  @Override
  public Optional<Node> toAst() {
    return Optional.of(wrappedNode);
  }
}
