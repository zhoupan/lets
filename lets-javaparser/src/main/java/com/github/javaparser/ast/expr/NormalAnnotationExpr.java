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
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.NormalAnnotationExprMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * An annotation that has zero or more key-value pairs.<br>
 * {@code @Mapping(a=5, d=10)}
 *
 * @author Julio Vilmar Gesser
 */
public class NormalAnnotationExpr extends AnnotationExpr {

  private NodeList<MemberValuePair> pairs;

  public NormalAnnotationExpr() {
    this(null, new Name(), new NodeList<>());
  }

  @AllFieldsConstructor
  public NormalAnnotationExpr(final Name name, final NodeList<MemberValuePair> pairs) {
    this(null, name, pairs);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public NormalAnnotationExpr(TokenRange tokenRange, Name name, NodeList<MemberValuePair> pairs) {
    super(tokenRange, name);
    setPairs(pairs);
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
  public NodeList<MemberValuePair> getPairs() {
    return pairs;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public NormalAnnotationExpr setPairs(final NodeList<MemberValuePair> pairs) {
    assertNotNull(pairs);
    if (pairs == this.pairs) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.PAIRS, this.pairs, pairs);
    if (this.pairs != null) this.pairs.setParentNode(null);
    this.pairs = pairs;
    setAsParentNodeOf(pairs);
    return this;
  }

  /**
   * adds a pair to this annotation
   *
   * @return this, the {@link NormalAnnotationExpr}
   */
  public NormalAnnotationExpr addPair(String key, String value) {
    return addPair(key, new NameExpr(value));
  }

  /**
   * adds a pair to this annotation
   *
   * @return this, the {@link NormalAnnotationExpr}
   */
  public NormalAnnotationExpr addPair(String key, Expression value) {
    MemberValuePair memberValuePair = new MemberValuePair(key, value);
    getPairs().add(memberValuePair);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < pairs.size(); i++) {
      if (pairs.get(i) == node) {
        pairs.remove(i);
        return true;
      }
    }
    return super.remove(node);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public NormalAnnotationExpr clone() {
    return (NormalAnnotationExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public NormalAnnotationExprMetaModel getMetaModel() {
    return JavaParserMetaModel.normalAnnotationExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < pairs.size(); i++) {
      if (pairs.get(i) == node) {
        pairs.set(i, (MemberValuePair) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isNormalAnnotationExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public NormalAnnotationExpr asNormalAnnotationExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifNormalAnnotationExpr(Consumer<NormalAnnotationExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<NormalAnnotationExpr> toNormalAnnotationExpr() {
    return Optional.of(this);
  }
}
