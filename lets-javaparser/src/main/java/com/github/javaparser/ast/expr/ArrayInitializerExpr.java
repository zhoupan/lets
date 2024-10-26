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
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.ArrayInitializerExprMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * The initialization of an array. In the following sample, the outer { } is an
 * ArrayInitializerExpr. It has two expressions inside: two ArrayInitializerExprs. These have two
 * expressions each, one has 1 and 1, the other two and two. <br>
 * {@code new int[][]{{1, 1}, {2, 2}};}
 *
 * @author Julio Vilmar Gesser
 */
public class ArrayInitializerExpr extends Expression {

  private NodeList<Expression> values;

  public ArrayInitializerExpr() {
    this(null, new NodeList<>());
  }

  @AllFieldsConstructor
  public ArrayInitializerExpr(NodeList<Expression> values) {
    this(null, values);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public ArrayInitializerExpr(TokenRange tokenRange, NodeList<Expression> values) {
    super(tokenRange);
    setValues(values);
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
  public NodeList<Expression> getValues() {
    return values;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ArrayInitializerExpr setValues(final NodeList<Expression> values) {
    assertNotNull(values);
    if (values == this.values) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.VALUES, this.values, values);
    if (this.values != null) this.values.setParentNode(null);
    this.values = values;
    setAsParentNodeOf(values);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < values.size(); i++) {
      if (values.get(i) == node) {
        values.remove(i);
        return true;
      }
    }
    return super.remove(node);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public ArrayInitializerExpr clone() {
    return (ArrayInitializerExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public ArrayInitializerExprMetaModel getMetaModel() {
    return JavaParserMetaModel.arrayInitializerExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < values.size(); i++) {
      if (values.get(i) == node) {
        values.set(i, (Expression) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isArrayInitializerExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ArrayInitializerExpr asArrayInitializerExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifArrayInitializerExpr(Consumer<ArrayInitializerExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ArrayInitializerExpr> toArrayInitializerExpr() {
    return Optional.of(this);
  }
}
