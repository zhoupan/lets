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

import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.nodeTypes.NodeWithJavadoc;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.nodeTypes.NodeWithType;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithAbstractModifier;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithPublicModifier;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.AnnotationMemberDeclarationMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.OptionalProperty;
import com.github.javaparser.resolution.Resolvable;
import com.github.javaparser.resolution.declarations.ResolvedAnnotationMemberDeclaration;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * The "int id();" in {@code @interface X { int id(); }}
 *
 * <p><br>
 * All annotations preceding the type will be set on this object, not on the type. JavaParser
 * doesn't know if it they are applicable to the method or the type.
 *
 * @author Julio Vilmar Gesser
 */
public class AnnotationMemberDeclaration extends BodyDeclaration<AnnotationMemberDeclaration>
    implements NodeWithJavadoc<AnnotationMemberDeclaration>,
        NodeWithSimpleName<AnnotationMemberDeclaration>,
        NodeWithType<AnnotationMemberDeclaration, Type>,
        NodeWithPublicModifier<AnnotationMemberDeclaration>,
        NodeWithAbstractModifier<AnnotationMemberDeclaration>,
        Resolvable<ResolvedAnnotationMemberDeclaration> {

  private NodeList<Modifier> modifiers;

  private Type type;

  private SimpleName name;

  @OptionalProperty private Expression defaultValue;

  public AnnotationMemberDeclaration() {
    this(
        null,
        new NodeList<>(),
        new NodeList<>(),
        new ClassOrInterfaceType(),
        new SimpleName(),
        null);
  }

  public AnnotationMemberDeclaration(
      NodeList<Modifier> modifiers, Type type, String name, Expression defaultValue) {
    this(null, modifiers, new NodeList<>(), type, new SimpleName(name), defaultValue);
  }

  @AllFieldsConstructor
  public AnnotationMemberDeclaration(
      NodeList<Modifier> modifiers,
      NodeList<AnnotationExpr> annotations,
      Type type,
      SimpleName name,
      Expression defaultValue) {
    this(null, modifiers, annotations, type, name, defaultValue);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public AnnotationMemberDeclaration(
      TokenRange tokenRange,
      NodeList<Modifier> modifiers,
      NodeList<AnnotationExpr> annotations,
      Type type,
      SimpleName name,
      Expression defaultValue) {
    super(tokenRange, annotations);
    setModifiers(modifiers);
    setType(type);
    setName(name);
    setDefaultValue(defaultValue);
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

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Optional<Expression> getDefaultValue() {
    return Optional.ofNullable(defaultValue);
  }

  /**
   * Return the modifiers of this member declaration.
   *
   * @return modifiers
   * @see Modifier
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public NodeList<Modifier> getModifiers() {
    return modifiers;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public SimpleName getName() {
    return name;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Type getType() {
    return type;
  }

  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public AnnotationMemberDeclaration removeDefaultValue() {
    return setDefaultValue((Expression) null);
  }

  /**
   * Sets the default value
   *
   * @param defaultValue the default value, can be null
   * @return this, the AnnotationMemberDeclaration
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public AnnotationMemberDeclaration setDefaultValue(final Expression defaultValue) {
    if (defaultValue == this.defaultValue) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.DEFAULT_VALUE, this.defaultValue, defaultValue);
    if (this.defaultValue != null) this.defaultValue.setParentNode(null);
    this.defaultValue = defaultValue;
    setAsParentNodeOf(defaultValue);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public AnnotationMemberDeclaration setModifiers(final NodeList<Modifier> modifiers) {
    assertNotNull(modifiers);
    if (modifiers == this.modifiers) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.MODIFIERS, this.modifiers, modifiers);
    if (this.modifiers != null) this.modifiers.setParentNode(null);
    this.modifiers = modifiers;
    setAsParentNodeOf(modifiers);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public AnnotationMemberDeclaration setName(final SimpleName name) {
    assertNotNull(name);
    if (name == this.name) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.NAME, this.name, name);
    if (this.name != null) this.name.setParentNode(null);
    this.name = name;
    setAsParentNodeOf(name);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public AnnotationMemberDeclaration setType(final Type type) {
    assertNotNull(type);
    if (type == this.type) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.TYPE, this.type, type);
    if (this.type != null) this.type.setParentNode(null);
    this.type = type;
    setAsParentNodeOf(type);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    if (defaultValue != null) {
      if (node == defaultValue) {
        removeDefaultValue();
        return true;
      }
    }
    for (int i = 0; i < modifiers.size(); i++) {
      if (modifiers.get(i) == node) {
        modifiers.remove(i);
        return true;
      }
    }
    return super.remove(node);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public AnnotationMemberDeclaration clone() {
    return (AnnotationMemberDeclaration) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public AnnotationMemberDeclarationMetaModel getMetaModel() {
    return JavaParserMetaModel.annotationMemberDeclarationMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (defaultValue != null) {
      if (node == defaultValue) {
        setDefaultValue((Expression) replacementNode);
        return true;
      }
    }
    for (int i = 0; i < modifiers.size(); i++) {
      if (modifiers.get(i) == node) {
        modifiers.set(i, (Modifier) replacementNode);
        return true;
      }
    }
    if (node == name) {
      setName((SimpleName) replacementNode);
      return true;
    }
    if (node == type) {
      setType((Type) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isAnnotationMemberDeclaration() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public AnnotationMemberDeclaration asAnnotationMemberDeclaration() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifAnnotationMemberDeclaration(Consumer<AnnotationMemberDeclaration> action) {
    action.accept(this);
  }

  @Override
  public ResolvedAnnotationMemberDeclaration resolve() {
    return getSymbolResolver().resolveDeclaration(this, ResolvedAnnotationMemberDeclaration.class);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<AnnotationMemberDeclaration> toAnnotationMemberDeclaration() {
    return Optional.of(this);
  }
}
