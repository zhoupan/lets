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
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.LabeledStmtMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A statement that is labeled, like {@code label123: println("continuing");}
 *
 * @author Julio Vilmar Gesser
 */
public class LabeledStmt extends Statement {

  private SimpleName label;

  private Statement statement;

  public LabeledStmt() {
    this(null, new SimpleName(), new ReturnStmt());
  }

  public LabeledStmt(final String label, final Statement statement) {
    this(null, new SimpleName(label), statement);
  }

  @AllFieldsConstructor
  public LabeledStmt(final SimpleName label, final Statement statement) {
    this(null, label, statement);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public LabeledStmt(TokenRange tokenRange, SimpleName label, Statement statement) {
    super(tokenRange);
    setLabel(label);
    setStatement(statement);
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
  public Statement getStatement() {
    return statement;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public LabeledStmt setStatement(final Statement statement) {
    assertNotNull(statement);
    if (statement == this.statement) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.STATEMENT, this.statement, statement);
    if (this.statement != null) this.statement.setParentNode(null);
    this.statement = statement;
    setAsParentNodeOf(statement);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public SimpleName getLabel() {
    return label;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public LabeledStmt setLabel(final SimpleName label) {
    assertNotNull(label);
    if (label == this.label) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.LABEL, this.label, label);
    if (this.label != null) this.label.setParentNode(null);
    this.label = label;
    setAsParentNodeOf(label);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public LabeledStmt clone() {
    return (LabeledStmt) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public LabeledStmtMetaModel getMetaModel() {
    return JavaParserMetaModel.labeledStmtMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == label) {
      setLabel((SimpleName) replacementNode);
      return true;
    }
    if (node == statement) {
      setStatement((Statement) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isLabeledStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public LabeledStmt asLabeledStmt() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifLabeledStmt(Consumer<LabeledStmt> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<LabeledStmt> toLabeledStmt() {
    return Optional.of(this);
  }
}
