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
import com.github.javaparser.ast.nodeTypes.NodeWithExpression;
import com.github.javaparser.ast.nodeTypes.NodeWithType;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.CastExprMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A typecast. The (long) in {@code (long)15}
 *
 * @author Julio Vilmar Gesser
 */
public class CastExpr extends Expression
    implements NodeWithType<CastExpr, Type>, NodeWithExpression<CastExpr> {

  private Type type;

  private Expression expression;

  public CastExpr() {
    this(null, new ClassOrInterfaceType(), new NameExpr());
  }

  @AllFieldsConstructor
  public CastExpr(Type type, Expression expression) {
    this(null, type, expression);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public CastExpr(TokenRange tokenRange, Type type, Expression expression) {
    super(tokenRange);
    setType(type);
    setExpression(expression);
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
  public Expression getExpression() {
    return expression;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Type getType() {
    return type;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public CastExpr setExpression(final Expression expression) {
    assertNotNull(expression);
    if (expression == this.expression) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.EXPRESSION, this.expression, expression);
    if (this.expression != null) this.expression.setParentNode(null);
    this.expression = expression;
    setAsParentNodeOf(expression);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public CastExpr setType(final Type type) {
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
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public CastExpr clone() {
    return (CastExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public CastExprMetaModel getMetaModel() {
    return JavaParserMetaModel.castExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == expression) {
      setExpression((Expression) replacementNode);
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
  public boolean isCastExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public CastExpr asCastExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifCastExpr(Consumer<CastExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<CastExpr> toCastExpr() {
    return Optional.of(this);
  }
}
