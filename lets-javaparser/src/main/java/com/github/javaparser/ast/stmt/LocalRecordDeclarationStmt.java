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
import com.github.javaparser.ast.body.RecordDeclaration;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.LocalRecordDeclarationStmtMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 *
 *
 * <h1>A record declaration inside a method.</h1>
 *
 * @author Roger Howell
 * @see RecordDeclaration
 */
public class LocalRecordDeclarationStmt extends Statement {

  private RecordDeclaration recordDeclaration;

  public LocalRecordDeclarationStmt() {
    this(null, new RecordDeclaration());
  }

  @AllFieldsConstructor
  public LocalRecordDeclarationStmt(final RecordDeclaration recordDeclaration) {
    this(null, recordDeclaration);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public LocalRecordDeclarationStmt(TokenRange tokenRange, RecordDeclaration recordDeclaration) {
    super(tokenRange);
    setRecordDeclaration(recordDeclaration);
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
  public RecordDeclaration getRecordDeclaration() {
    return recordDeclaration;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public LocalRecordDeclarationStmt setRecordDeclaration(
      final RecordDeclaration recordDeclaration) {
    assertNotNull(recordDeclaration);
    if (recordDeclaration == this.recordDeclaration) {
      return this;
    }
    notifyPropertyChange(
        ObservableProperty.RECORD_DECLARATION, this.recordDeclaration, recordDeclaration);
    if (this.recordDeclaration != null) this.recordDeclaration.setParentNode(null);
    this.recordDeclaration = recordDeclaration;
    setAsParentNodeOf(recordDeclaration);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public LocalRecordDeclarationStmt clone() {
    return (LocalRecordDeclarationStmt) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public LocalRecordDeclarationStmtMetaModel getMetaModel() {
    return JavaParserMetaModel.localRecordDeclarationStmtMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == recordDeclaration) {
      setRecordDeclaration((RecordDeclaration) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isLocalRecordDeclarationStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public LocalRecordDeclarationStmt asLocalRecordDeclarationStmt() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifLocalRecordDeclarationStmt(Consumer<LocalRecordDeclarationStmt> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<LocalRecordDeclarationStmt> toLocalRecordDeclarationStmt() {
    return Optional.of(this);
  }
}
