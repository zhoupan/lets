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

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.OptionalProperty;
import com.github.javaparser.metamodel.SuperExprMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * An occurrence of the "super" keyword. <br>
 * {@code World.super.greet()} is a MethodCallExpr of method name greet, and scope "World.super"
 * which is a SuperExpr with typeName "World". <br>
 * {@code super.name} is a FieldAccessExpr of field greet, and a SuperExpr as its scope. This
 * SuperExpr has no typeName.
 *
 * @author Julio Vilmar Gesser
 * @see com.github.javaparser.ast.stmt.ExplicitConstructorInvocationStmt
 * @see ThisExpr
 */
public class SuperExpr extends Expression {

  @OptionalProperty private Name typeName;

  public SuperExpr() {
    this(null, null);
  }

  @AllFieldsConstructor
  public SuperExpr(final Name typeName) {
    this(null, typeName);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public SuperExpr(TokenRange tokenRange, Name typeName) {
    super(tokenRange);
    setTypeName(typeName);
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
  public Optional<Name> getTypeName() {
    return Optional.ofNullable(typeName);
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public SuperExpr setTypeName(final Name typeName) {
    if (typeName == this.typeName) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.TYPE_NAME, this.typeName, typeName);
    if (this.typeName != null) this.typeName.setParentNode(null);
    this.typeName = typeName;
    setAsParentNodeOf(typeName);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    if (typeName != null) {
      if (node == typeName) {
        removeTypeName();
        return true;
      }
    }
    return super.remove(node);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public SuperExpr clone() {
    return (SuperExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public SuperExprMetaModel getMetaModel() {
    return JavaParserMetaModel.superExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isSuperExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public SuperExpr asSuperExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifSuperExpr(Consumer<SuperExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<SuperExpr> toSuperExpr() {
    return Optional.of(this);
  }

  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public SuperExpr removeClassName() {
    return setTypeName((Name) null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (typeName != null) {
      if (node == typeName) {
        setTypeName((Name) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public SuperExpr removeTypeName() {
    return setTypeName((Name) null);
  }
}
