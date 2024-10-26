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
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.*;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.resolution.model.Value;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.resolution.types.ResolvedTypeVariable;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserTypeParameter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author Federico Tomassetti
 */
public class ClassOrInterfaceDeclarationContext
    extends AbstractJavaParserContext<ClassOrInterfaceDeclaration> {

  private JavaParserTypeDeclarationAdapter javaParserTypeDeclarationAdapter;

  ///
  /// Constructors
  ///
  public ClassOrInterfaceDeclarationContext(
      ClassOrInterfaceDeclaration wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
    this.javaParserTypeDeclarationAdapter =
        new JavaParserTypeDeclarationAdapter(wrappedNode, typeSolver, getDeclaration(), this);
  }

  ///
  /// Public methods
  ///
  @Override
  public SymbolReference<? extends ResolvedValueDeclaration> solveSymbol(String name) {
    if (typeSolver == null) throw new IllegalArgumentException();
    if (this.getDeclaration().hasVisibleField(name)) {
      return SymbolReference.solved(this.getDeclaration().getVisibleField(name));
    }
    // then to parent
    return solveSymbolInParentContext(name);
  }

  @Override
  public Optional<Value> solveSymbolAsValue(String name) {
    if (typeSolver == null) throw new IllegalArgumentException();
    if (this.getDeclaration().hasField(name)) {
      return Optional.of(Value.from(this.getDeclaration().getField(name)));
    }
    // then to parent
    return solveSymbolAsValueInParentContext(name);
  }

  @Override
  public Optional<ResolvedType> solveGenericType(String name) {
    // First check if the method-like declaration has type parameters defined.
    // For example: {@code public <T> boolean containsAll(Collection<T> c);}
    for (TypeParameter tp : wrappedNode.getTypeParameters()) {
      if (tp.getName().getId().equals(name)) {
        return Optional.of(new ResolvedTypeVariable(new JavaParserTypeParameter(tp, typeSolver)));
      }
    }
    // If no generic types on the method declaration, continue to solve as usual.
    return solveGenericTypeInParentContext(name);
  }

  @Override
  public SymbolReference<ResolvedTypeDeclaration> solveType(
      String name, List<ResolvedType> typeArguments) {
    return javaParserTypeDeclarationAdapter.solveType(name, typeArguments);
  }

  @Override
  public SymbolReference<ResolvedMethodDeclaration> solveMethod(
      String name, List<ResolvedType> argumentsTypes, boolean staticOnly) {
    return javaParserTypeDeclarationAdapter.solveMethod(name, argumentsTypes, staticOnly);
  }

  public SymbolReference<ResolvedConstructorDeclaration> solveConstructor(
      List<ResolvedType> argumentsTypes) {
    return javaParserTypeDeclarationAdapter.solveConstructor(argumentsTypes);
  }

  @Override
  public List<ResolvedFieldDeclaration> fieldsExposedToChild(Node child) {
    List<ResolvedFieldDeclaration> fields = new LinkedList<>();
    fields.addAll(this.wrappedNode.resolve().getDeclaredFields());
    this.wrappedNode
        .getExtendedTypes()
        .forEach(
            i -> fields.addAll(i.resolve().asReferenceType().getAllFieldsVisibleToInheritors()));
    this.wrappedNode
        .getImplementedTypes()
        .forEach(
            i -> fields.addAll(i.resolve().asReferenceType().getAllFieldsVisibleToInheritors()));
    return fields;
  }

  ///
  /// Private methods
  ///
  private ResolvedReferenceTypeDeclaration getDeclaration() {
    return JavaParserFacade.get(typeSolver).getTypeDeclaration(this.wrappedNode);
  }
}
