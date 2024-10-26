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
import com.github.javaparser.ast.nodeTypes.NodeWithBlockStmt;
import com.github.javaparser.ast.nodeTypes.NodeWithExpression;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.SynchronizedStmtMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Usage of the synchronized keyword. <br>
 * In {@code synchronized (a123) { ... }} the expression is a123 and { ... } is the body
 *
 * @author Julio Vilmar Gesser
 */
public class SynchronizedStmt extends Statement
    implements NodeWithBlockStmt<SynchronizedStmt>, NodeWithExpression<SynchronizedStmt> {

  private Expression expression;

  private BlockStmt body;

  public SynchronizedStmt() {
    this(null, new NameExpr(), new BlockStmt());
  }

  @AllFieldsConstructor
  public SynchronizedStmt(final Expression expression, final BlockStmt body) {
    this(null, expression, body);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public SynchronizedStmt(TokenRange tokenRange, Expression expression, BlockStmt body) {
    super(tokenRange);
    setExpression(expression);
    setBody(body);
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
  public SynchronizedStmt setExpression(final Expression expression) {
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
  public BlockStmt getBody() {
    return body;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public SynchronizedStmt setBody(final BlockStmt body) {
    assertNotNull(body);
    if (body == this.body) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.BODY, this.body, body);
    if (this.body != null) this.body.setParentNode(null);
    this.body = body;
    setAsParentNodeOf(body);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public SynchronizedStmt clone() {
    return (SynchronizedStmt) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public SynchronizedStmtMetaModel getMetaModel() {
    return JavaParserMetaModel.synchronizedStmtMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == body) {
      setBody((BlockStmt) replacementNode);
      return true;
    }
    if (node == expression) {
      setExpression((Expression) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isSynchronizedStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public SynchronizedStmt asSynchronizedStmt() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifSynchronizedStmt(Consumer<SynchronizedStmt> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<SynchronizedStmt> toSynchronizedStmt() {
    return Optional.of(this);
  }
}
