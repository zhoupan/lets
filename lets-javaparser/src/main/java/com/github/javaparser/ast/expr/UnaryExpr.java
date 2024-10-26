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
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.DerivedProperty;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.UnaryExprMetaModel;
import com.github.javaparser.printer.Stringable;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * An expression where an operator is applied to a single expression. It supports the operators that
 * are found in the UnaryExpr.Operator enum. <br>
 * {@code 11++} <br>
 * {@code ++11} <br>
 * {@code ~1} <br>
 * {@code -333}
 *
 * @author Julio Vilmar Gesser
 */
public class UnaryExpr extends Expression implements NodeWithExpression<UnaryExpr> {

  public enum Operator implements Stringable {
    PLUS("+", false),
    MINUS("-", false),
    PREFIX_INCREMENT("++", false),
    PREFIX_DECREMENT("--", false),
    LOGICAL_COMPLEMENT("!", false),
    BITWISE_COMPLEMENT("~", false),
    POSTFIX_INCREMENT("++", true),
    POSTFIX_DECREMENT("--", true);

    private final String codeRepresentation;

    private final boolean isPostfix;

    Operator(String codeRepresentation, boolean isPostfix) {
      this.codeRepresentation = codeRepresentation;
      this.isPostfix = isPostfix;
    }

    public String asString() {
      return codeRepresentation;
    }

    public boolean isPostfix() {
      return isPostfix;
    }

    public boolean isPrefix() {
      return !isPostfix();
    }
  }

  private Expression expression;

  private Operator operator;

  public UnaryExpr() {
    this(null, new IntegerLiteralExpr(), Operator.POSTFIX_INCREMENT);
  }

  @AllFieldsConstructor
  public UnaryExpr(final Expression expression, final Operator operator) {
    this(null, expression, operator);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public UnaryExpr(TokenRange tokenRange, Expression expression, Operator operator) {
    super(tokenRange);
    setExpression(expression);
    setOperator(operator);
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
  public Operator getOperator() {
    return operator;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public UnaryExpr setExpression(final Expression expression) {
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
  public UnaryExpr setOperator(final Operator operator) {
    assertNotNull(operator);
    if (operator == this.operator) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.OPERATOR, this.operator, operator);
    this.operator = operator;
    return this;
  }

  @DerivedProperty
  public boolean isPostfix() {
    return operator.isPostfix();
  }

  @DerivedProperty
  public boolean isPrefix() {
    return !isPostfix();
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public UnaryExpr clone() {
    return (UnaryExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public UnaryExprMetaModel getMetaModel() {
    return JavaParserMetaModel.unaryExprMetaModel;
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
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isUnaryExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public UnaryExpr asUnaryExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifUnaryExpr(Consumer<UnaryExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<UnaryExpr> toUnaryExpr() {
    return Optional.of(this);
  }
}
