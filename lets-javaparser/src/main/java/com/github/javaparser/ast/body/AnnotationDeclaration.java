/*
 * Copyright (c) 2007-2010 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.ast.body;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithAbstractModifier;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.AnnotationDeclarationMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.resolution.Resolvable;
import com.github.javaparser.resolution.declarations.ResolvedAnnotationDeclaration;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * An annotation type declaration.<br>
 * {@code @interface X { ... }}
 *
 * @author Julio Vilmar Gesser
 */
public class AnnotationDeclaration extends TypeDeclaration<AnnotationDeclaration>
    implements NodeWithAbstractModifier<AnnotationDeclaration>,
        Resolvable<ResolvedAnnotationDeclaration> {

  public AnnotationDeclaration() {
    this(null, new NodeList<>(), new NodeList<>(), new SimpleName(), new NodeList<>());
  }

  public AnnotationDeclaration(NodeList<Modifier> modifiers, String name) {
    this(null, modifiers, new NodeList<>(), new SimpleName(name), new NodeList<>());
  }

  @AllFieldsConstructor
  public AnnotationDeclaration(
      NodeList<Modifier> modifiers,
      NodeList<AnnotationExpr> annotations,
      SimpleName name,
      NodeList<BodyDeclaration<?>> members) {
    this(null, modifiers, annotations, name, members);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public AnnotationDeclaration(
      TokenRange tokenRange,
      NodeList<Modifier> modifiers,
      NodeList<AnnotationExpr> annotations,
      SimpleName name,
      NodeList<BodyDeclaration<?>> members) {
    super(tokenRange, modifiers, annotations, name, members);
    customInitialization();
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
  public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) {
    return v.visit(this, arg);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.AcceptGenerator")
  public <A> void accept(final VoidVisitor<A> v, final A arg) {
    v.visit(this, arg);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public AnnotationDeclaration clone() {
    return (AnnotationDeclaration) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public AnnotationDeclarationMetaModel getMetaModel() {
    return JavaParserMetaModel.annotationDeclarationMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isAnnotationDeclaration() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public AnnotationDeclaration asAnnotationDeclaration() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifAnnotationDeclaration(Consumer<AnnotationDeclaration> action) {
    action.accept(this);
  }

  @Override
  public ResolvedAnnotationDeclaration resolve() {
    return getSymbolResolver().resolveDeclaration(this, ResolvedAnnotationDeclaration.class);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<AnnotationDeclaration> toAnnotationDeclaration() {
    return Optional.of(this);
  }

  @Override
  public FieldDeclaration addField(Type type, String name, Modifier.Keyword... modifiers) {
    throw new IllegalStateException("Cannot add a field to an annotation declaration.");
  }
}
