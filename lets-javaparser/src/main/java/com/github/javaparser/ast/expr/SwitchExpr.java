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
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.nodeTypes.SwitchNode;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.stmt.SwitchEntry;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.SwitchExprMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 *
 *
 * <h1>The switch expression</h1>
 *
 * <h2>Java 1.0-11</h2>
 *
 * Not available.
 *
 * <h2>Java 12</h2>
 *
 * Like {@link com.github.javaparser.ast.stmt.SwitchStmt}, but can also be used as an expression.
 * <br>
 * <br>
 * {@code int a = switch(x) { case 5,6 -> 20; case 9 -> 30; default -> 40; };} <br>
 * {@code int a = switch(x) { case 5,6: break 20; default: break 5+5; };}
 *
 * <h2>Java 13</h2>
 *
 * The break statement has been reverted to what it was before Java 12, and break-with-value is now
 * the YieldStatement. <br>
 * {@code int a = switch(x) { case 5,6: yield 20; default: yield 5+5; };}
 *
 * @see SwitchEntry
 * @see com.github.javaparser.ast.stmt.SwitchStmt
 * @see SwitchNode
 * @see com.github.javaparser.ast.stmt.BreakStmt
 * @see com.github.javaparser.ast.stmt.YieldStmt
 */
public class SwitchExpr extends Expression implements SwitchNode {

  private Expression selector;

  private NodeList<SwitchEntry> entries;

  public SwitchExpr() {
    this(null, new NameExpr(), new NodeList<>());
  }

  @AllFieldsConstructor
  public SwitchExpr(final Expression selector, final NodeList<SwitchEntry> entries) {
    this(null, selector, entries);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public SwitchExpr(TokenRange tokenRange, Expression selector, NodeList<SwitchEntry> entries) {
    super(tokenRange);
    setSelector(selector);
    setEntries(entries);
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
  public NodeList<SwitchEntry> getEntries() {
    return entries;
  }

  public SwitchEntry getEntry(int i) {
    return getEntries().get(i);
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Expression getSelector() {
    return selector;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public SwitchExpr setEntries(final NodeList<SwitchEntry> entries) {
    assertNotNull(entries);
    if (entries == this.entries) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.ENTRIES, this.entries, entries);
    if (this.entries != null) this.entries.setParentNode(null);
    this.entries = entries;
    setAsParentNodeOf(entries);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public SwitchExpr setSelector(final Expression selector) {
    assertNotNull(selector);
    if (selector == this.selector) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.SELECTOR, this.selector, selector);
    if (this.selector != null) this.selector.setParentNode(null);
    this.selector = selector;
    setAsParentNodeOf(selector);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < entries.size(); i++) {
      if (entries.get(i) == node) {
        entries.remove(i);
        return true;
      }
    }
    return super.remove(node);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public SwitchExpr clone() {
    return (SwitchExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < entries.size(); i++) {
      if (entries.get(i) == node) {
        entries.set(i, (SwitchEntry) replacementNode);
        return true;
      }
    }
    if (node == selector) {
      setSelector((Expression) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isSwitchExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public SwitchExpr asSwitchExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<SwitchExpr> toSwitchExpr() {
    return Optional.of(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifSwitchExpr(Consumer<SwitchExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public SwitchExprMetaModel getMetaModel() {
    return JavaParserMetaModel.switchExprMetaModel;
  }
}
