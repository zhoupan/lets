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
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.resolution.Context;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.UnsolvedSymbolException;
import com.github.javaparser.resolution.declarations.*;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.resolution.model.typesystem.ReferenceTypeImpl;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.logic.AbstractTypeDeclaration;
import java.util.*;

/**
 * @author Federico Tomassetti
 */
public class JavaParserTypeVariableDeclaration extends AbstractTypeDeclaration {

  private TypeParameter wrappedNode;

  private TypeSolver typeSolver;

  public JavaParserTypeVariableDeclaration(TypeParameter wrappedNode, TypeSolver typeSolver) {
    this.wrappedNode = wrappedNode;
    this.typeSolver = typeSolver;
  }

  @Override
  public boolean isAssignableBy(ResolvedReferenceTypeDeclaration other) {
    return isAssignableBy(new ReferenceTypeImpl(other));
  }

  @Override
  public String getPackageName() {
    return AstResolutionUtils.getPackageName(wrappedNode);
  }

  @Override
  public String getClassName() {
    return AstResolutionUtils.getClassName("", wrappedNode);
  }

  @Override
  public String getQualifiedName() {
    return getName();
  }

  public Context getContext() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String toString() {
    return "JavaParserTypeVariableDeclaration{" + wrappedNode.getName() + '}';
  }

  public SymbolReference<ResolvedMethodDeclaration> solveMethod(
      String name, List<ResolvedType> parameterTypes) {
    throw new UnsupportedOperationException();
  }

  public ResolvedType getUsage(Node node) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isAssignableBy(ResolvedType type) {
    if (type.isTypeVariable()) {
      throw new UnsupportedOperationException(
          "Is this type variable declaration assignable by " + type.describe());
    }
    throw new UnsupportedOperationException(
        "Is this type variable declaration assignable by " + type);
  }

  @Override
  public boolean isTypeParameter() {
    return true;
  }

  @Override
  public ResolvedFieldDeclaration getField(String name) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean hasField(String name) {
    return false;
  }

  @Override
  public List<ResolvedFieldDeclaration> getAllFields() {
    return new ArrayList<>();
  }

  @Override
  public List<ResolvedReferenceType> getAncestors(boolean acceptIncompleteList) {
    if (wrappedNode.getTypeBound().isEmpty()) {
      // Every type variable declared as a type parameter has a bound.
      // If no bound is declared for a type variable, Object is assumed.
      // https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.4
      return Collections.singletonList(new ReferenceTypeImpl(typeSolver.getSolvedJavaLangObject()));
    }
    List<ResolvedReferenceType> ancestors = new ArrayList<>();
    for (ClassOrInterfaceType type : wrappedNode.getTypeBound()) {
      try {
        ResolvedType resolvedType = JavaParserFacade.get(typeSolver).convertToUsage(type);
        ancestors.add(resolvedType.asReferenceType());
      } catch (UnsolvedSymbolException e) {
        if (!acceptIncompleteList) {
          // Only throw if an incomplete ancestor list is unacceptable.
          throw e;
        }
      }
    }
    return ancestors;
  }

  @Override
  public Set<ResolvedMethodDeclaration> getDeclaredMethods() {
    return Collections.emptySet();
  }

  @Override
  public String getName() {
    return wrappedNode.getName().getId();
  }

  @Override
  public boolean isType() {
    return true;
  }

  @Override
  public boolean hasDirectlyAnnotation(String canonicalName) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isClass() {
    return false;
  }

  @Override
  public boolean isInterface() {
    return false;
  }

  @Override
  public List<ResolvedTypeParameterDeclaration> getTypeParameters() {
    return Collections.emptyList();
  }

  @Override
  public ResolvedTypeParameterDeclaration asTypeParameter() {
    return new JavaParserTypeParameter(this.wrappedNode, typeSolver);
  }

  /**
   * Returns the JavaParser node associated with this JavaParserTypeVariableDeclaration.
   *
   * @return A visitable JavaParser node wrapped by this object.
   */
  public TypeParameter getWrappedNode() {
    return wrappedNode;
  }

  @Override
  public Optional<ResolvedReferenceTypeDeclaration> containerType() {
    return asTypeParameter().containerType();
  }

  @Override
  public List<ResolvedConstructorDeclaration> getConstructors() {
    return Collections.emptyList();
  }

  @Override
  public Optional<Node> toAst() {
    return Optional.of(wrappedNode);
  }
}
