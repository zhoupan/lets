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
import com.github.javaparser.metamodel.DoStmtMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A do-while. <br>
 * {@code do { ... } while ( a==0 );}
 *
 * @author Julio Vilmar Gesser
 */
public class DoStmt extends Statement implements NodeWithBody<DoStmt>, NodeWithCondition<DoStmt> {

  private Statement body;

  private Expression condition;

  public DoStmt() {
    this(null, new ReturnStmt(), new BooleanLiteralExpr());
  }

  @AllFieldsConstructor
  public DoStmt(final Statement body, final Expression condition) {
    this(null, body, condition);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public DoStmt(TokenRange tokenRange, Statement body, Expression condition) {
    super(tokenRange);
    setBody(body);
    setCondition(condition);
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
  public DoStmt setBody(final Statement body) {
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
  public DoStmt setCondition(final Expression condition) {
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
  public DoStmt clone() {
    return (DoStmt) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public DoStmtMetaModel getMetaModel() {
    return JavaParserMetaModel.doStmtMetaModel;
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
  public boolean isDoStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public DoStmt asDoStmt() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifDoStmt(Consumer<DoStmt> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<DoStmt> toDoStmt() {
    return Optional.of(this);
  }
}
