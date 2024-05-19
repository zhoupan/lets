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
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.MemberValuePairMetaModel;

/**
 * A value for a member of an annotation. In {@code @Counters(a=15)} a=15 is a MemberValuePair. Its
 * name is a, and its value is 15.
 *
 * @author Julio Vilmar Gesser
 */
public class MemberValuePair extends Node implements NodeWithSimpleName<MemberValuePair> {

  private SimpleName name;

  private Expression value;

  public MemberValuePair() {
    this(null, new SimpleName(), new StringLiteralExpr());
  }

  public MemberValuePair(final String name, final Expression value) {
    this(null, new SimpleName(name), value);
  }

  @AllFieldsConstructor
  public MemberValuePair(final SimpleName name, final Expression value) {
    this(null, name, value);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public MemberValuePair(TokenRange tokenRange, SimpleName name, Expression value) {
    super(tokenRange);
    setName(name);
    setValue(value);
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
  public SimpleName getName() {
    return name;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Expression getValue() {
    return value;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public MemberValuePair setName(final SimpleName name) {
    assertNotNull(name);
    if (name == this.name) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.NAME, this.name, name);
    if (this.name != null) this.name.setParentNode(null);
    this.name = name;
    setAsParentNodeOf(name);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public MemberValuePair setValue(final Expression value) {
    assertNotNull(value);
    if (value == this.value) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.VALUE, this.value, value);
    if (this.value != null) this.value.setParentNode(null);
    this.value = value;
    setAsParentNodeOf(value);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public MemberValuePair clone() {
    return (MemberValuePair) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public MemberValuePairMetaModel getMetaModel() {
    return JavaParserMetaModel.memberValuePairMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == name) {
      setName((SimpleName) replacementNode);
      return true;
    }
    if (node == value) {
      setValue((Expression) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }
}
