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

import static com.github.javaparser.utils.Utils.assertNonEmpty;
import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.nodeTypes.NodeWithIdentifier;
import com.github.javaparser.ast.nodeTypes.NodeWithTypeArguments;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.MethodReferenceExprMetaModel;
import com.github.javaparser.metamodel.NonEmptyProperty;
import com.github.javaparser.metamodel.OptionalProperty;
import com.github.javaparser.resolution.Resolvable;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Method reference expressions introduced in Java 8 specifically designed to simplify lambda
 * Expressions. Note that the field "identifier", indicating the word to the right of the ::, is not
 * always a method name, it can be "new". <br>
 * In {@code System.out::println;} the scope is System.out and the identifier is "println" <br>
 * {@code (test ? stream.map(String::trim) : stream)::toArray;} <br>
 * In {@code Bar<String>::<Integer>new} the String type argument is on the scope, and the Integer
 * type argument is on this MethodReferenceExpr.
 *
 * @author Raquel Pau
 */
public class MethodReferenceExpr extends Expression
    implements NodeWithTypeArguments<MethodReferenceExpr>,
        NodeWithIdentifier<MethodReferenceExpr>,
        Resolvable<ResolvedMethodDeclaration> {

  private Expression scope;

  @OptionalProperty private NodeList<Type> typeArguments;

  @NonEmptyProperty private String identifier;

  public MethodReferenceExpr() {
    this(null, new ClassExpr(), null, "empty");
  }

  @AllFieldsConstructor
  public MethodReferenceExpr(Expression scope, NodeList<Type> typeArguments, String identifier) {
    this(null, scope, typeArguments, identifier);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public MethodReferenceExpr(
      TokenRange tokenRange, Expression scope, NodeList<Type> typeArguments, String identifier) {
    super(tokenRange);
    setScope(scope);
    setTypeArguments(typeArguments);
    setIdentifier(identifier);
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
  public Expression getScope() {
    return scope;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public MethodReferenceExpr setScope(final Expression scope) {
    assertNotNull(scope);
    if (scope == this.scope) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.SCOPE, this.scope, scope);
    if (this.scope != null) this.scope.setParentNode(null);
    this.scope = scope;
    setAsParentNodeOf(scope);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Optional<NodeList<Type>> getTypeArguments() {
    return Optional.ofNullable(typeArguments);
  }

  /**
   * Sets the typeArguments
   *
   * @param typeArguments the typeArguments, can be null
   * @return this, the MethodReferenceExpr
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public MethodReferenceExpr setTypeArguments(final NodeList<Type> typeArguments) {
    if (typeArguments == this.typeArguments) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.TYPE_ARGUMENTS, this.typeArguments, typeArguments);
    if (this.typeArguments != null) this.typeArguments.setParentNode(null);
    this.typeArguments = typeArguments;
    setAsParentNodeOf(typeArguments);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public String getIdentifier() {
    return identifier;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public MethodReferenceExpr setIdentifier(final String identifier) {
    assertNonEmpty(identifier);
    if (identifier == this.identifier) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.IDENTIFIER, this.identifier, identifier);
    this.identifier = identifier;
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    if (typeArguments != null) {
      for (int i = 0; i < typeArguments.size(); i++) {
        if (typeArguments.get(i) == node) {
          typeArguments.remove(i);
          return true;
        }
      }
    }
    return super.remove(node);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public MethodReferenceExpr clone() {
    return (MethodReferenceExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public MethodReferenceExprMetaModel getMetaModel() {
    return JavaParserMetaModel.methodReferenceExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == scope) {
      setScope((Expression) replacementNode);
      return true;
    }
    if (typeArguments != null) {
      for (int i = 0; i < typeArguments.size(); i++) {
        if (typeArguments.get(i) == node) {
          typeArguments.set(i, (Type) replacementNode);
          return true;
        }
      }
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isMethodReferenceExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public MethodReferenceExpr asMethodReferenceExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifMethodReferenceExpr(Consumer<MethodReferenceExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<MethodReferenceExpr> toMethodReferenceExpr() {
    return Optional.of(this);
  }

  /**
   * @return the method declaration this method reference is referencing.
   */
  @Override
  public ResolvedMethodDeclaration resolve() {
    return getSymbolResolver().resolveDeclaration(this, ResolvedMethodDeclaration.class);
  }

  /*
   * Method reference expressions are always poly expressions
   * (https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html 15.13. Method Reference Expressions)
   */
  @Override
  public boolean isPolyExpression() {
    return true;
  }
}
