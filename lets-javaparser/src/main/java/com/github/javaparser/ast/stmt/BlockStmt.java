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
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.nodeTypes.NodeWithStatements;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.BlockStmtMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Statements in between { and }.
 *
 * @author Julio Vilmar Gesser
 */
public class BlockStmt extends Statement implements NodeWithStatements<BlockStmt> {

  private NodeList<Statement> statements;

  public BlockStmt() {
    this(null, new NodeList<>());
  }

  @AllFieldsConstructor
  public BlockStmt(final NodeList<Statement> statements) {
    this(null, statements);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public BlockStmt(TokenRange tokenRange, NodeList<Statement> statements) {
    super(tokenRange);
    setStatements(statements);
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
  public NodeList<Statement> getStatements() {
    return statements;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public BlockStmt setStatements(final NodeList<Statement> statements) {
    assertNotNull(statements);
    if (statements == this.statements) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.STATEMENTS, this.statements, statements);
    if (this.statements != null) this.statements.setParentNode(null);
    this.statements = statements;
    setAsParentNodeOf(statements);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < statements.size(); i++) {
      if (statements.get(i) == node) {
        statements.remove(i);
        return true;
      }
    }
    return super.remove(node);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public BlockStmt clone() {
    return (BlockStmt) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public BlockStmtMetaModel getMetaModel() {
    return JavaParserMetaModel.blockStmtMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < statements.size(); i++) {
      if (statements.get(i) == node) {
        statements.set(i, (Statement) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isBlockStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public BlockStmt asBlockStmt() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifBlockStmt(Consumer<BlockStmt> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<BlockStmt> toBlockStmt() {
    return Optional.of(this);
  }
}
