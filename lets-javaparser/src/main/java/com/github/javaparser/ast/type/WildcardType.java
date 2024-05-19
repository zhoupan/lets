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
package com.github.javaparser.ast.type;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.OptionalProperty;
import com.github.javaparser.metamodel.WildcardTypeMetaModel;
import com.github.javaparser.resolution.Context;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.resolution.types.ResolvedWildcard;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A wildcard type argument. Examples: <br>
 * {@code void printCollection(Collection<}<b>{@code ?}</b>{@code > c) { ... }} <br>
 * {@code boolean addAll(Collection<}<b>{@code ? extends E}</b>{@code > c)} <br>
 * {@code Reference(T referent, ReferenceQueue<}<b>{@code ? super T}</b>{@code > queue)}
 *
 * @author Julio Vilmar Gesser
 */
public class WildcardType extends Type implements NodeWithAnnotations<WildcardType> {

  @OptionalProperty private ReferenceType extendedType;

  @OptionalProperty private ReferenceType superType;

  public WildcardType() {
    this(null, null, null, new NodeList<>());
  }

  public WildcardType(final ReferenceType extendedType) {
    this(null, extendedType, null, new NodeList<>());
  }

  @AllFieldsConstructor
  public WildcardType(
      final ReferenceType extendedType,
      final ReferenceType superType,
      final NodeList<AnnotationExpr> annotations) {
    this(null, extendedType, superType, annotations);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public WildcardType(
      TokenRange tokenRange,
      ReferenceType extendedType,
      ReferenceType superType,
      NodeList<AnnotationExpr> annotations) {
    super(tokenRange, annotations);
    setExtendedType(extendedType);
    setSuperType(superType);
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
  public Optional<ReferenceType> getExtendedType() {
    return Optional.ofNullable(extendedType);
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Optional<ReferenceType> getSuperType() {
    return Optional.ofNullable(superType);
  }

  /**
   * Sets the extended type
   *
   * @param extendedType the extends, can be null
   * @return this, the WildcardType
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public WildcardType setExtendedType(final ReferenceType extendedType) {
    if (extendedType == this.extendedType) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.EXTENDED_TYPE, this.extendedType, extendedType);
    if (this.extendedType != null) this.extendedType.setParentNode(null);
    this.extendedType = extendedType;
    setAsParentNodeOf(extendedType);
    return this;
  }

  /**
   * Sets the supertype
   *
   * @param superType the super, can be null
   * @return this, the WildcardType
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public WildcardType setSuperType(final ReferenceType superType) {
    if (superType == this.superType) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.SUPER_TYPE, this.superType, superType);
    if (this.superType != null) this.superType.setParentNode(null);
    this.superType = superType;
    setAsParentNodeOf(superType);
    return this;
  }

  @Override
  public WildcardType setAnnotations(NodeList<AnnotationExpr> annotations) {
    return (WildcardType) super.setAnnotations(annotations);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    if (extendedType != null) {
      if (node == extendedType) {
        removeExtendedType();
        return true;
      }
    }
    if (superType != null) {
      if (node == superType) {
        removeSuperType();
        return true;
      }
    }
    return super.remove(node);
  }

  @Override
  public String asString() {
    StringBuilder str = new StringBuilder("?");
    getExtendedType().ifPresent(t -> str.append(" extends ").append(t.asString()));
    getSuperType().ifPresent(t -> str.append(" super ").append(t.asString()));
    return str.toString();
  }

  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public WildcardType removeExtendedType() {
    return setExtendedType((ReferenceType) null);
  }

  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public WildcardType removeSuperType() {
    return setSuperType((ReferenceType) null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public WildcardType clone() {
    return (WildcardType) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public WildcardTypeMetaModel getMetaModel() {
    return JavaParserMetaModel.wildcardTypeMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (extendedType != null) {
      if (node == extendedType) {
        setExtendedType((ReferenceType) replacementNode);
        return true;
      }
    }
    if (superType != null) {
      if (node == superType) {
        setSuperType((ReferenceType) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public WildcardType(TokenRange tokenRange, ReferenceType extendedType, ReferenceType superType) {
    super(tokenRange);
    setExtendedType(extendedType);
    setSuperType(superType);
    customInitialization();
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isWildcardType() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public WildcardType asWildcardType() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifWildcardType(Consumer<WildcardType> action) {
    action.accept(this);
  }

  @Override
  public ResolvedWildcard resolve() {
    return getSymbolResolver().toResolvedType(this, ResolvedWildcard.class);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<WildcardType> toWildcardType() {
    return Optional.of(this);
  }

  /**
   * Convert a {@link WildcardType} into a {@link ResolvedType}.
   *
   * @param wildcardType The wildcard type to be converted.
   * @param context The current context.
   * @return The type resolved.
   */
  @Override
  public ResolvedType convertToUsage(Context context) {
    if (getExtendedType().isPresent() && !getSuperType().isPresent()) {
      return ResolvedWildcard.extendsBound(
          getExtendedType().get().convertToUsage(context)); // removed (ReferenceTypeImpl)
    }
    if (!getExtendedType().isPresent() && getSuperType().isPresent()) {
      return ResolvedWildcard.superBound(
          getSuperType().get().convertToUsage(context)); // removed (ReferenceTypeImpl)
    }
    if (!getExtendedType().isPresent() && !getSuperType().isPresent()) {
      return ResolvedWildcard.UNBOUNDED;
    }
    throw new UnsupportedOperationException(toString());
  }
}
