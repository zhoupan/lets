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
import com.github.javaparser.metamodel.NameMetaModel;
import com.github.javaparser.metamodel.NonEmptyProperty;
import com.github.javaparser.metamodel.OptionalProperty;
import java.util.Optional;

/**
 * A name that may consist of multiple identifiers. In other words: it.may.contain.dots.
 *
 * <p>The rightmost identifier is "identifier", The one to the left of it is "qualifier.identifier",
 * etc.
 *
 * <p>You can construct one from a String with the name(...) method.
 *
 * @author Julio Vilmar Gesser
 * @see SimpleName
 */
public class Name extends Node implements NodeWithIdentifier<Name> {

  @NonEmptyProperty private String identifier;

  @OptionalProperty private Name qualifier;

  public Name() {
    this(null, null, "empty");
  }

  public Name(final String identifier) {
    this(null, null, identifier);
  }

  @AllFieldsConstructor
  public Name(Name qualifier, final String identifier) {
    this(null, qualifier, identifier);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public Name(TokenRange tokenRange, Name qualifier, String identifier) {
    super(tokenRange);
    setQualifier(qualifier);
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
  public Name setIdentifier(final String identifier) {
    assertNonEmpty(identifier);
    if (identifier == this.identifier) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.IDENTIFIER, this.identifier, identifier);
    this.identifier = identifier;
    return this;
  }

  /**
   * @return the complete qualified name. Only the identifiers and the dots, so no comments or
   *     whitespace.
   */
  public String asString() {
    if (qualifier != null) {
      return qualifier.asString() + "." + identifier;
    }
    return identifier;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Optional<Name> getQualifier() {
    return Optional.ofNullable(qualifier);
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Name setQualifier(final Name qualifier) {
    if (qualifier == this.qualifier) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.QUALIFIER, this.qualifier, qualifier);
    if (this.qualifier != null) this.qualifier.setParentNode(null);
    this.qualifier = qualifier;
    setAsParentNodeOf(qualifier);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    if (qualifier != null) {
      if (node == qualifier) {
        removeQualifier();
        return true;
      }
    }
    return super.remove(node);
  }

  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public Name removeQualifier() {
    return setQualifier((Name) null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public Name clone() {
    return (Name) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public NameMetaModel getMetaModel() {
    return JavaParserMetaModel.nameMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (qualifier != null) {
      if (node == qualifier) {
        setQualifier((Name) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  /** A top level name is a name that is not contained in a larger Name instance. */
  public boolean isTopLevel() {
    return !isInternal();
  }

  /** An internal name is a name that constitutes a part of a larger Name instance. */
  public boolean isInternal() {
    return getParentNode().filter(parent -> parent instanceof Name).isPresent();
  }
}
