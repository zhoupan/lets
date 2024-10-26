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
package com.github.javaparser.ast.expr;

import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithFinalModifier;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.ReferenceType;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.TypePatternExprMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 *
 *
 * <h1>The instanceof statement</h1>
 *
 * <h2>Java 1.0 to 13</h2>
 *
 * Not available. <br>
 *
 * <h2>Java 14</h2>
 *
 * Since JDK14, it is possible to bind a variable that is cast to the type being tested against.
 * This is referred to as a {@code Pattern} within <a
 * href="https://bugs.openjdk.java.net/browse/JDK-8181287">JEP305</a>, and avoids the need to cast
 * to the desired type. <br>
 * Example: <br>
 *
 * <pre>{@code
 * tool instanceof Drill d
 *                 ^^^^^^^
 *                 Pattern
 * }</pre>
 *
 * <br>
 * Note: While this is exclusively used within {@code instanceof} operators for now, JEP305 suggests
 * this might be used more widely in the future (e.g. in switch expressions/statements). <br>
 * <br>
 *
 * <h3>JDK14 Grammar</h3>
 *
 * Per JEP305 (not currently listed within the JLS): <br>
 *
 * <pre>{@code Pattern:
 *      ReferenceType Identifier}</pre>
 *
 * @author Roger Howell
 * @see com.github.javaparser.ast.expr.InstanceOfExpr
 * @see <a href="https://bugs.openjdk.java.net/browse/JDK-8181287">JEP305:
 *     https://bugs.openjdk.java.net/browse/JDK-8181287</a>
 * @see <a
 *     href="https://docs.oracle.com/javase/specs/jls/se11/html/jls-15.html#jls-15.20">https://docs.oracle.com/javase/specs/jls/se11/html/jls-15.html#jls-15.20</a>
 */
public class TypePatternExpr extends PatternExpr
    implements NodeWithSimpleName<TypePatternExpr>, NodeWithFinalModifier<TypePatternExpr> {

  private NodeList<Modifier> modifiers;

  private SimpleName name;

  public TypePatternExpr() {
    this(null, new NodeList<>(), new ClassOrInterfaceType(), new SimpleName());
  }

  @AllFieldsConstructor
  public TypePatternExpr(
      final NodeList<Modifier> modifiers, final ReferenceType type, SimpleName name) {
    this(null, modifiers, type, name);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public TypePatternExpr(
      TokenRange tokenRange, NodeList<Modifier> modifiers, ReferenceType type, SimpleName name) {
    super(tokenRange, type);
    setModifiers(modifiers);
    setName(name);
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
  public SimpleName getName() {
    return name;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public TypePatternExpr setName(final SimpleName name) {
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

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
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
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public TypePatternExpr clone() {
    return (TypePatternExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public TypePatternExprMetaModel getMetaModel() {
    return JavaParserMetaModel.typePatternExprMetaModel;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public NodeList<Modifier> getModifiers() {
    return modifiers;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public TypePatternExpr setModifiers(final NodeList<Modifier> modifiers) {
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

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
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
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isTypePatternExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public TypePatternExpr asTypePatternExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<TypePatternExpr> toTypePatternExpr() {
    return Optional.of(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifTypePatternExpr(Consumer<TypePatternExpr> action) {
    action.accept(this);
  }
}
