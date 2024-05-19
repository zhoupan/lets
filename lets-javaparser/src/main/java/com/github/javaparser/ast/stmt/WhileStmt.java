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
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.nodeTypes.NodeWithBody;
import com.github.javaparser.ast.nodeTypes.NodeWithCondition;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.WhileStmtMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A while statement. <br>
 * {@code while(true) { ... }}
 *
 * @author Julio Vilmar Gesser
 */
public class WhileStmt extends Statement
    implements NodeWithBody<WhileStmt>, NodeWithCondition<WhileStmt> {

  private Expression condition;

  private Statement body;

  public WhileStmt() {
    this(null, new BooleanLiteralExpr(), new ReturnStmt());
  }

  @AllFieldsConstructor
  public WhileStmt(final Expression condition, final Statement body) {
    this(null, condition, body);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public WhileStmt(TokenRange tokenRange, Expression condition, Statement body) {
    super(tokenRange);
    setCondition(condition);
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
  public Statement getBody() {
    return body;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Expression getCondition() {
    return condition;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public WhileStmt setBody(final Statement body) {
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

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public WhileStmt setCondition(final Expression condition) {
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

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public WhileStmt clone() {
    return (WhileStmt) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public WhileStmtMetaModel getMetaModel() {
    return JavaParserMetaModel.whileStmtMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == body) {
      setBody((Statement) replacementNode);
      return true;
    }
    if (node == condition) {
      setCondition((Expression) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isWhileStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public WhileStmt asWhileStmt() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifWhileStmt(Consumer<WhileStmt> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<WhileStmt> toWhileStmt() {
    return Optional.of(this);
  }
}
