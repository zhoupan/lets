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
import com.github.javaparser.ast.nodeTypes.NodeWithCondition;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.ConditionalExprMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * The ternary conditional expression. In {@code b==0?x:y}, b==0 is the condition, x is thenExpr,
 * and y is elseExpr.
 *
 * @author Julio Vilmar Gesser
 */
public class ConditionalExpr extends Expression implements NodeWithCondition<ConditionalExpr> {

  private Expression condition;

  private Expression thenExpr;

  private Expression elseExpr;

  public ConditionalExpr() {
    this(null, new BooleanLiteralExpr(), new StringLiteralExpr(), new StringLiteralExpr());
  }

  @AllFieldsConstructor
  public ConditionalExpr(Expression condition, Expression thenExpr, Expression elseExpr) {
    this(null, condition, thenExpr, elseExpr);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public ConditionalExpr(
      TokenRange tokenRange, Expression condition, Expression thenExpr, Expression elseExpr) {
    super(tokenRange);
    setCondition(condition);
    setThenExpr(thenExpr);
    setElseExpr(elseExpr);
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
  public Expression getCondition() {
    return condition;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Expression getElseExpr() {
    return elseExpr;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Expression getThenExpr() {
    return thenExpr;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ConditionalExpr setCondition(final Expression condition) {
    assertNotNull(condition);
    if (condition == this.condition) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.CONDITION, this.condition, condition);
    if (this.condition != null) this.condition.setParentNode(null);
    this.condition = condition;
    setAsParentNodeOf(condition);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ConditionalExpr setElseExpr(final Expression elseExpr) {
    assertNotNull(elseExpr);
    if (elseExpr == this.elseExpr) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.ELSE_EXPR, this.elseExpr, elseExpr);
    if (this.elseExpr != null) this.elseExpr.setParentNode(null);
    this.elseExpr = elseExpr;
    setAsParentNodeOf(elseExpr);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ConditionalExpr setThenExpr(final Expression thenExpr) {
    assertNotNull(thenExpr);
    if (thenExpr == this.thenExpr) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.THEN_EXPR, this.thenExpr, thenExpr);
    if (this.thenExpr != null) this.thenExpr.setParentNode(null);
    this.thenExpr = thenExpr;
    setAsParentNodeOf(thenExpr);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public ConditionalExpr clone() {
    return (ConditionalExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public ConditionalExprMetaModel getMetaModel() {
    return JavaParserMetaModel.conditionalExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == condition) {
      setCondition((Expression) replacementNode);
      return true;
    }
    if (node == elseExpr) {
      setElseExpr((Expression) replacementNode);
      return true;
    }
    if (node == thenExpr) {
      setThenExpr((Expression) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isConditionalExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ConditionalExpr asConditionalExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifConditionalExpr(Consumer<ConditionalExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ConditionalExpr> toConditionalExpr() {
    return Optional.of(this);
  }

  /*
   * A reference conditional expression is a poly expression if it appears in an assignment context or an invocation context (§5.2. §5.3).
   * Otherwise, it is a standalone expression.
   */
  @Override
  public boolean isPolyExpression() {
    return appearsInAssignmentContext() || appearsInInvocationContext();
  }
}
