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
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.ArrayAccessExprMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Array brackets [] being used to get a value from an array. In <br>
 * {@code getNames()[15*15]} the name expression is getNames() and the index expression is 15*15.
 *
 * @author Julio Vilmar Gesser
 */
public class ArrayAccessExpr extends Expression {

  private Expression name;

  private Expression index;

  public ArrayAccessExpr() {
    this(null, new NameExpr(), new IntegerLiteralExpr());
  }

  @AllFieldsConstructor
  public ArrayAccessExpr(Expression name, Expression index) {
    this(null, name, index);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public ArrayAccessExpr(TokenRange tokenRange, Expression name, Expression index) {
    super(tokenRange);
    setName(name);
    setIndex(index);
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
  public Expression getIndex() {
    return index;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Expression getName() {
    return name;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ArrayAccessExpr setIndex(final Expression index) {
    assertNotNull(index);
    if (index == this.index) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.INDEX, this.index, index);
    if (this.index != null) this.index.setParentNode(null);
    this.index = index;
    setAsParentNodeOf(index);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ArrayAccessExpr setName(final Expression name) {
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
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public ArrayAccessExpr clone() {
    return (ArrayAccessExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public ArrayAccessExprMetaModel getMetaModel() {
    return JavaParserMetaModel.arrayAccessExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == index) {
      setIndex((Expression) replacementNode);
      return true;
    }
    if (node == name) {
      setName((Expression) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isArrayAccessExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ArrayAccessExpr asArrayAccessExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifArrayAccessExpr(Consumer<ArrayAccessExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ArrayAccessExpr> toArrayAccessExpr() {
    return Optional.of(this);
  }
}
