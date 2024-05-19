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

import static com.github.javaparser.utils.CodeGenerationUtils.f;
import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.TypeMetaModel;
import com.github.javaparser.resolution.Resolvable;
import com.github.javaparser.resolution.types.ResolvedType;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Base class for types.
 *
 * @author Julio Vilmar Gesser
 */
public abstract class Type extends Node implements Resolvable<ResolvedType>, ConvertibleToUsage {

  private NodeList<AnnotationExpr> annotations;

  /** Several sub classes do not support annotations. This is a support constructor for them. */
  protected Type(TokenRange range) {
    this(range, new NodeList<>());
  }

  @AllFieldsConstructor
  public Type(NodeList<AnnotationExpr> annotations) {
    this(null, annotations);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public Type(TokenRange tokenRange, NodeList<AnnotationExpr> annotations) {
    super(tokenRange);
    setAnnotations(annotations);
    customInitialization();
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public NodeList<AnnotationExpr> getAnnotations() {
    return annotations;
  }

  public AnnotationExpr getAnnotation(int i) {
    return getAnnotations().get(i);
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Type setAnnotations(final NodeList<AnnotationExpr> annotations) {
    assertNotNull(annotations);
    if (annotations == this.annotations) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.ANNOTATIONS, this.annotations, annotations);
    if (this.annotations != null) this.annotations.setParentNode(null);
    this.annotations = annotations;
    setAsParentNodeOf(annotations);
    return this;
  }

  /**
   * Finds the element type, meaning: the type without ArrayTypes around it.
   *
   * <p>In "{@code int[] a[];}", the element type is int.
   */
  public Type getElementType() {
    return this;
  }

  /*
   * returns the array level that is 0 for non array type.
   */
  public int getArrayLevel() {
    return 0;
  }

  public String toDescriptor() {
    return "";
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < annotations.size(); i++) {
      if (annotations.get(i) == node) {
        annotations.remove(i);
        return true;
      }
    }
    return super.remove(node);
  }

  public abstract String asString();

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public Type clone() {
    return (Type) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public TypeMetaModel getMetaModel() {
    return JavaParserMetaModel.typeMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < annotations.size(); i++) {
      if (annotations.get(i) == node) {
        annotations.set(i, (AnnotationExpr) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isArrayType() {
    return false;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ArrayType asArrayType() {
    throw new IllegalStateException(
        f("%s is not ArrayType, it is %s", this, this.getClass().getSimpleName()));
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isClassOrInterfaceType() {
    return false;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ClassOrInterfaceType asClassOrInterfaceType() {
    throw new IllegalStateException(
        f("%s is not ClassOrInterfaceType, it is %s", this, this.getClass().getSimpleName()));
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isIntersectionType() {
    return false;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public IntersectionType asIntersectionType() {
    throw new IllegalStateException(
        f("%s is not IntersectionType, it is %s", this, this.getClass().getSimpleName()));
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isPrimitiveType() {
    return false;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public PrimitiveType asPrimitiveType() {
    throw new IllegalStateException(
        f("%s is not PrimitiveType, it is %s", this, this.getClass().getSimpleName()));
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isReferenceType() {
    return false;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ReferenceType asReferenceType() {
    throw new IllegalStateException(
        f("%s is not ReferenceType, it is %s", this, this.getClass().getSimpleName()));
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isTypeParameter() {
    return false;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public TypeParameter asTypeParameter() {
    throw new IllegalStateException(
        f("%s is not TypeParameter, it is %s", this, this.getClass().getSimpleName()));
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isUnionType() {
    return false;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public UnionType asUnionType() {
    throw new IllegalStateException(
        f("%s is not UnionType, it is %s", this, this.getClass().getSimpleName()));
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isUnknownType() {
    return false;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public UnknownType asUnknownType() {
    throw new IllegalStateException(
        f("%s is not UnknownType, it is %s", this, this.getClass().getSimpleName()));
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isVoidType() {
    return false;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public VoidType asVoidType() {
    throw new IllegalStateException(
        f("%s is not VoidType, it is %s", this, this.getClass().getSimpleName()));
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isWildcardType() {
    return false;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public WildcardType asWildcardType() {
    throw new IllegalStateException(
        f("%s is not WildcardType, it is %s", this, this.getClass().getSimpleName()));
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifArrayType(Consumer<ArrayType> action) {}

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifClassOrInterfaceType(Consumer<ClassOrInterfaceType> action) {}

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifIntersectionType(Consumer<IntersectionType> action) {}

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifPrimitiveType(Consumer<PrimitiveType> action) {}

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifReferenceType(Consumer<ReferenceType> action) {}

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifTypeParameter(Consumer<TypeParameter> action) {}

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifUnionType(Consumer<UnionType> action) {}

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifUnknownType(Consumer<UnknownType> action) {}

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifVoidType(Consumer<VoidType> action) {}

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifWildcardType(Consumer<WildcardType> action) {}

  @Override
  public abstract ResolvedType resolve();

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ArrayType> toArrayType() {
    return Optional.empty();
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ClassOrInterfaceType> toClassOrInterfaceType() {
    return Optional.empty();
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<IntersectionType> toIntersectionType() {
    return Optional.empty();
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<PrimitiveType> toPrimitiveType() {
    return Optional.empty();
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ReferenceType> toReferenceType() {
    return Optional.empty();
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<TypeParameter> toTypeParameter() {
    return Optional.empty();
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<UnionType> toUnionType() {
    return Optional.empty();
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<UnknownType> toUnknownType() {
    return Optional.empty();
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<VoidType> toVoidType() {
    return Optional.empty();
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<WildcardType> toWildcardType() {
    return Optional.empty();
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isVarType() {
    return false;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public VarType asVarType() {
    throw new IllegalStateException(
        f("%s is not VarType, it is %s", this, this.getClass().getSimpleName()));
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<VarType> toVarType() {
    return Optional.empty();
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifVarType(Consumer<VarType> action) {}
}
