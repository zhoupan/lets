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
import com.github.javaparser.ast.body.AnnotationDeclaration;
import com.github.javaparser.ast.body.AnnotationMemberDeclaration;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.*;
import com.github.javaparser.resolution.model.typesystem.ReferenceTypeImpl;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.logic.AbstractTypeDeclaration;
import java.lang.annotation.Inherited;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Federico Tomassetti
 */
public class JavaParserAnnotationDeclaration extends AbstractTypeDeclaration
    implements ResolvedAnnotationDeclaration {

  private com.github.javaparser.ast.body.AnnotationDeclaration wrappedNode;
  private TypeSolver typeSolver;
  private JavaParserTypeAdapter<AnnotationDeclaration> javaParserTypeAdapter;

  public JavaParserAnnotationDeclaration(AnnotationDeclaration wrappedNode, TypeSolver typeSolver) {
    this.wrappedNode = wrappedNode;
    this.typeSolver = typeSolver;
    this.javaParserTypeAdapter = new JavaParserTypeAdapter<>(wrappedNode, typeSolver);
  }

  @Override
  public List<ResolvedReferenceType> getAncestors(boolean acceptIncompleteList) {
    List<ResolvedReferenceType> ancestors = new ArrayList<>();
    ancestors.add(new ReferenceTypeImpl(typeSolver.solveType("java.lang.annotation.Annotation")));
    return ancestors;
  }

  @Override
  public Set<ResolvedReferenceTypeDeclaration> internalTypes() {
    return javaParserTypeAdapter.internalTypes();
  }

  @Override
  public List<ResolvedFieldDeclaration> getAllFields() {
    return wrappedNode.getFields().stream()
        .flatMap(field -> field.getVariables().stream())
        .map(var -> new JavaParserFieldDeclaration(var, typeSolver))
        .collect(Collectors.toList());
  }

  @Override
  public Set<ResolvedMethodDeclaration> getDeclaredMethods() {
    // TODO #1838
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isAssignableBy(ResolvedType type) {
    // TODO #1836
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isAssignableBy(ResolvedReferenceTypeDeclaration other) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean hasDirectlyAnnotation(String canonicalName) {
    return AstResolutionUtils.hasDirectlyAnnotation(wrappedNode, typeSolver, canonicalName);
  }

  /*
   * Returns a set of the declared annotation on this type
   */
  @Override
  public Set<ResolvedAnnotationDeclaration> getDeclaredAnnotations() {
    return javaParserTypeAdapter.getDeclaredAnnotations();
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
    String containerName =
        AstResolutionUtils.containerName(wrappedNode.getParentNode().orElse(null));
    if (containerName.isEmpty()) {
      return wrappedNode.getName().getId();
    }
    return containerName + "." + wrappedNode.getName();
  }

  @Override
  public String getName() {
    return wrappedNode.getName().getId();
  }

  /**
   * Annotation declarations cannot have type parameters and hence this method always returns an
   * empty list.
   *
   * @return An empty list.
   */
  @Override
  public List<ResolvedTypeParameterDeclaration> getTypeParameters() {
    // Annotation declarations cannot have type parameters - i.e. we can always return an empty
    // list.
    return Collections.emptyList();
  }

  @Override
  public Optional<ResolvedReferenceTypeDeclaration> containerType() {
    // TODO #1841
    throw new UnsupportedOperationException(
        "containerType is not supported for " + this.getClass().getCanonicalName());
  }

  @Override
  public List<ResolvedAnnotationMemberDeclaration> getAnnotationMembers() {
    return wrappedNode.getMembers().stream()
        .filter(m -> m instanceof AnnotationMemberDeclaration)
        .map(
            m ->
                new JavaParserAnnotationMemberDeclaration(
                    (AnnotationMemberDeclaration) m, typeSolver))
        .collect(Collectors.toList());
  }

  @Override
  public List<ResolvedConstructorDeclaration> getConstructors() {
    return Collections.emptyList();
  }

  @Override
  public boolean isInheritable() {
    return wrappedNode.getAnnotationByClass(Inherited.class).isPresent();
  }

  @Override
  public Optional<Node> toAst() {
    return Optional.of(wrappedNode);
  }
}
