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
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.AssertStmtMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.OptionalProperty;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A usage of the keyword "assert" <br>
 * In {@code assert dead : "Wasn't expecting to be dead here";} the check is "dead" and the message
 * is the string.
 *
 * @author Julio Vilmar Gesser
 */
public class AssertStmt extends Statement {

  private Expression check;

  @OptionalProperty private Expression message;

  public AssertStmt() {
    this(null, new BooleanLiteralExpr(), null);
  }

  public AssertStmt(final Expression check) {
    this(null, check, null);
  }

  @AllFieldsConstructor
  public AssertStmt(final Expression check, final Expression message) {
    this(null, check, message);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public AssertStmt(TokenRange tokenRange, Expression check, Expression message) {
    super(tokenRange);
    setCheck(check);
    setMessage(message);
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
  public Expression getCheck() {
    return check;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Optional<Expression> getMessage() {
    return Optional.ofNullable(message);
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public AssertStmt setCheck(final Expression check) {
    assertNotNull(check);
    if (check == this.check) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.CHECK, this.check, check);
    if (this.check != null) this.check.setParentNode(null);
    this.check = check;
    setAsParentNodeOf(check);
    return this;
  }

  /**
   * Sets the message
   *
   * @param message the message, can be null
   * @return this, the AssertStmt
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public AssertStmt setMessage(final Expression message) {
    if (message == this.message) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.MESSAGE, this.message, message);
    if (this.message != null) this.message.setParentNode(null);
    this.message = message;
    setAsParentNodeOf(message);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    if (message != null) {
      if (node == message) {
        removeMessage();
        return true;
      }
    }
    return super.remove(node);
  }

  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public AssertStmt removeMessage() {
    return setMessage((Expression) null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public AssertStmt clone() {
    return (AssertStmt) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public AssertStmtMetaModel getMetaModel() {
    return JavaParserMetaModel.assertStmtMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == check) {
      setCheck((Expression) replacementNode);
      return true;
    }
    if (message != null) {
      if (node == message) {
        setMessage((Expression) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isAssertStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public AssertStmt asAssertStmt() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifAssertStmt(Consumer<AssertStmt> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<AssertStmt> toAssertStmt() {
    return Optional.of(this);
  }
}
