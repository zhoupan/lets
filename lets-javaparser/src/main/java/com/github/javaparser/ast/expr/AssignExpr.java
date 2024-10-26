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
import com.github.javaparser.metamodel.AssignExprMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.printer.Stringable;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * An assignment expression. It supports the operators that are found the AssignExpr.Operator enum.
 * <br>
 * {@code a=5} <br>
 * {@code time+=500} <br>
 * {@code watch.time+=500} <br>
 * {@code (((time)))=100*60} <br>
 * {@code peanut[a]=true}
 *
 * @author Julio Vilmar Gesser
 */
public class AssignExpr extends Expression {

  public enum Operator implements Stringable {
    ASSIGN("="),
    PLUS("+="),
    MINUS("-="),
    MULTIPLY("*="),
    DIVIDE("/="),
    BINARY_AND("&="),
    BINARY_OR("|="),
    XOR("^="),
    REMAINDER("%="),
    LEFT_SHIFT("<<="),
    SIGNED_RIGHT_SHIFT(">>="),
    UNSIGNED_RIGHT_SHIFT(">>>=");

    private final String codeRepresentation;

    Operator(String codeRepresentation) {
      this.codeRepresentation = codeRepresentation;
    }

    public String asString() {
      return codeRepresentation;
    }

    public Optional<BinaryExpr.Operator> toBinaryOperator() {
      switch (this) {
        case PLUS:
          return Optional.of(BinaryExpr.Operator.PLUS);
        case MINUS:
          return Optional.of(BinaryExpr.Operator.MINUS);
        case MULTIPLY:
          return Optional.of(BinaryExpr.Operator.MULTIPLY);
        case DIVIDE:
          return Optional.of(BinaryExpr.Operator.DIVIDE);
        case BINARY_AND:
          return Optional.of(BinaryExpr.Operator.BINARY_AND);
        case BINARY_OR:
          return Optional.of(BinaryExpr.Operator.BINARY_OR);
        case XOR:
          return Optional.of(BinaryExpr.Operator.XOR);
        case REMAINDER:
          return Optional.of(BinaryExpr.Operator.REMAINDER);
        case LEFT_SHIFT:
          return Optional.of(BinaryExpr.Operator.LEFT_SHIFT);
        case SIGNED_RIGHT_SHIFT:
          return Optional.of(BinaryExpr.Operator.SIGNED_RIGHT_SHIFT);
        case UNSIGNED_RIGHT_SHIFT:
          return Optional.of(BinaryExpr.Operator.UNSIGNED_RIGHT_SHIFT);
        default:
          return Optional.empty();
      }
    }
  }

  private Expression target;

  private Expression value;

  private Operator operator;

  public AssignExpr() {
    this(null, new NameExpr(), new StringLiteralExpr(), Operator.ASSIGN);
  }

  @AllFieldsConstructor
  public AssignExpr(Expression target, Expression value, Operator operator) {
    this(null, target, value, operator);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public AssignExpr(TokenRange tokenRange, Expression target, Expression value, Operator operator) {
    super(tokenRange);
    setTarget(target);
    setValue(value);
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
  public Operator getOperator() {
    return operator;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Expression getTarget() {
    return target;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Expression getValue() {
    return value;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public AssignExpr setOperator(final Operator operator) {
    assertNotNull(operator);
    if (operator == this.operator) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.OPERATOR, this.operator, operator);
    this.operator = operator;
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public AssignExpr setTarget(final Expression target) {
    assertNotNull(target);
    if (target == this.target) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.TARGET, this.target, target);
    if (this.target != null) this.target.setParentNode(null);
    this.target = target;
    setAsParentNodeOf(target);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public AssignExpr setValue(final Expression value) {
    assertNotNull(value);
    if (value == this.value) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.VALUE, this.value, value);
    if (this.value != null) this.value.setParentNode(null);
    this.value = value;
    setAsParentNodeOf(value);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public AssignExpr clone() {
    return (AssignExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public AssignExprMetaModel getMetaModel() {
    return JavaParserMetaModel.assignExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == target) {
      setTarget((Expression) replacementNode);
      return true;
    }
    if (node == value) {
      setValue((Expression) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isAssignExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public AssignExpr asAssignExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifAssignExpr(Consumer<AssignExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<AssignExpr> toAssignExpr() {
    return Optional.of(this);
  }

  /*
   * Returns true if the expression is an assignment context
   * https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.2
   * 5.2. Assignment Contexts: Assignment contexts allow the value of an expression to be assigned (§15.26) to a variable;...
   */
  @Override
  protected boolean isAssignmentContext() {
    return true;
  }
}
