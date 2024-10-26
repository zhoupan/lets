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
import com.github.javaparser.ast.body.AnnotationMemberDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.resolution.Context;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedAnnotationMemberDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFactory;
import java.util.Optional;

/**
 * @author Federico Tomassetti
 */
public class JavaParserAnnotationMemberDeclaration implements ResolvedAnnotationMemberDeclaration {

  private com.github.javaparser.ast.body.AnnotationMemberDeclaration wrappedNode;

  private TypeSolver typeSolver;

  public AnnotationMemberDeclaration getWrappedNode() {
    return wrappedNode;
  }

  public JavaParserAnnotationMemberDeclaration(
      AnnotationMemberDeclaration wrappedNode, TypeSolver typeSolver) {
    this.wrappedNode = wrappedNode;
    this.typeSolver = typeSolver;
  }

  @Override
  public Expression getDefaultValue() {
    return wrappedNode.getDefaultValue().orElse(null);
  }

  @Override
  public ResolvedType getType() {
    return JavaParserFacade.get(typeSolver).convert(wrappedNode.getType(), getContext());
  }

  @Override
  public String getName() {
    return wrappedNode.getNameAsString();
  }

  private Context getContext() {
    return JavaParserFactory.getContext(wrappedNode, typeSolver);
  }

  @Override
  public Optional<Node> toAst() {
    return Optional.of(wrappedNode);
  }
}
