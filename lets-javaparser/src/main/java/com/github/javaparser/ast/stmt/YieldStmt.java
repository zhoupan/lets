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
package com.github.javaparser.ast.stmt;

import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithExpression;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.YieldStmtMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 *
 *
 * <h1>The yield statement</h1>
 *
 * <h2>Java 1.0-11</h2>
 *
 * Does not exist.
 *
 * <h2>Java 12</h2>
 *
 * Yields an expression to be used in the switch-expression: <br>
 * {@code yield 123+456;} <br>
 * {@code yield "more or less";}
 */
public class YieldStmt extends Statement implements NodeWithExpression {

  private Expression expression;

  public YieldStmt() {
    this(null, new NameExpr());
  }

  @AllFieldsConstructor
  public YieldStmt(final Expression expression) {
    this(null, expression);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public YieldStmt(TokenRange tokenRange, Expression expression) {
    super(tokenRange);
    setExpression(expression);
    customInitialization();
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Expression getExpression() {
    return expression;
  }

  /**
   * Sets the label
   *
   * @param expression the label or the expression, can be null
   * @return this, the YieldStmt
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public YieldStmt setExpression(final Expression expression) {
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
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isYieldStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public YieldStmt asYieldStmt() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<YieldStmt> toYieldStmt() {
    return Optional.of(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifYieldStmt(Consumer<YieldStmt> action) {
    action.accept(this);
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
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public YieldStmt clone() {
    return (YieldStmt) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public YieldStmtMetaModel getMetaModel() {
    return JavaParserMetaModel.yieldStmtMetaModel;
  }
}
