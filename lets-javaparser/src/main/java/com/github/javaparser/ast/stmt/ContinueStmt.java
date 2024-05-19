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
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.nodeTypes.NodeWithOptionalLabel;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.ContinueStmtMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.OptionalProperty;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A continue statement with an optional label; <br>
 * {@code continue brains;} <br>
 * {@code continue;}
 *
 * @author Julio Vilmar Gesser
 */
public class ContinueStmt extends Statement implements NodeWithOptionalLabel<ContinueStmt> {

  @OptionalProperty private SimpleName label;

  public ContinueStmt() {
    this(null, null);
  }

  public ContinueStmt(final String label) {
    this(null, new SimpleName(label));
  }

  @AllFieldsConstructor
  public ContinueStmt(final SimpleName label) {
    this(null, label);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public ContinueStmt(TokenRange tokenRange, SimpleName label) {
    super(tokenRange);
    setLabel(label);
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
  public Optional<SimpleName> getLabel() {
    return Optional.ofNullable(label);
  }

  /**
   * Sets the label
   *
   * @param label the label, can be null
   * @return this, the ContinueStmt
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ContinueStmt setLabel(final SimpleName label) {
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
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    if (label != null) {
      if (node == label) {
        removeLabel();
        return true;
      }
    }
    return super.remove(node);
  }

  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public ContinueStmt removeLabel() {
    return setLabel((SimpleName) null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public ContinueStmt clone() {
    return (ContinueStmt) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public ContinueStmtMetaModel getMetaModel() {
    return JavaParserMetaModel.continueStmtMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (label != null) {
      if (node == label) {
        setLabel((SimpleName) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isContinueStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ContinueStmt asContinueStmt() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifContinueStmt(Consumer<ContinueStmt> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ContinueStmt> toContinueStmt() {
    return Optional.of(this);
  }
}
