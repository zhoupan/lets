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

import static com.github.javaparser.utils.Utils.assertNonEmpty;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.nodeTypes.NodeWithIdentifier;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.NonEmptyProperty;
import com.github.javaparser.metamodel.SimpleNameMetaModel;

/**
 * A name that consists of a single identifier. In other words: it.does.NOT.contain.dots.
 *
 * @see Name
 */
public class SimpleName extends Node implements NodeWithIdentifier<SimpleName> {

  @NonEmptyProperty private String identifier;

  public SimpleName() {
    this(null, "empty");
  }

  @AllFieldsConstructor
  public SimpleName(final String identifier) {
    this(null, identifier);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public SimpleName(TokenRange tokenRange, String identifier) {
    super(tokenRange);
    setIdentifier(identifier);
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
  public String getIdentifier() {
    return identifier;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public SimpleName setIdentifier(final String identifier) {
    assertNonEmpty(identifier);
    if (identifier == this.identifier) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.IDENTIFIER, this.identifier, identifier);
    this.identifier = identifier;
    return this;
  }

  public String asString() {
    return identifier;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public SimpleName clone() {
    return (SimpleName) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public SimpleNameMetaModel getMetaModel() {
    return JavaParserMetaModel.simpleNameMetaModel;
  }
}
