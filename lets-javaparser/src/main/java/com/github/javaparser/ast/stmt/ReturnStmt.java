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

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.OptionalProperty;
import com.github.javaparser.metamodel.ReturnStmtMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * The return statement, with an optional expression to return. <br>
 * {@code return 5 * 5;}
 *
 * @author Julio Vilmar Gesser
 */
public class ReturnStmt extends Statement {

  @OptionalProperty private Expression expression;

  public ReturnStmt() {
    this(null, null);
  }

  @AllFieldsConstructor
  public ReturnStmt(final Expression expression) {
    this(null, expression);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public ReturnStmt(TokenRange tokenRange, Expression expression) {
    super(tokenRange);
    setExpression(expression);
    customInitialization();
  }

  /** Will create a NameExpr with the string param */
  public ReturnStmt(String expression) {
    this(null, new NameExpr(expression));
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
  public Optional<Expression> getExpression() {
    return Optional.ofNullable(expression);
  }

  /**
   * Sets the expression
   *
   * @param expression the expression, can be null
   * @return this, the ReturnStmt
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ReturnStmt setExpression(final Expression expression) {
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
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    if (expression != null) {
      if (node == expression) {
        removeExpression();
        return true;
      }
    }
    return super.remove(node);
  }

  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public ReturnStmt removeExpression() {
    return setExpression((Expression) null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public ReturnStmt clone() {
    return (ReturnStmt) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public ReturnStmtMetaModel getMetaModel() {
    return JavaParserMetaModel.returnStmtMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (expression != null) {
      if (node == expression) {
        setExpression((Expression) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isReturnStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ReturnStmt asReturnStmt() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifReturnStmt(Consumer<ReturnStmt> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ReturnStmt> toReturnStmt() {
    return Optional.of(this);
  }
}
