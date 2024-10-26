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

import static com.github.javaparser.StaticJavaParser.parseClassOrInterfaceType;
import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.PrimitiveTypeMetaModel;
import com.github.javaparser.resolution.Context;
import com.github.javaparser.resolution.types.ResolvedPrimitiveType;
import com.github.javaparser.resolution.types.ResolvedType;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A primitive type. <br>
 * {@code int} <br>
 * {@code boolean} <br>
 * {@code short}
 *
 * @author Julio Vilmar Gesser
 */
public class PrimitiveType extends Type implements NodeWithAnnotations<PrimitiveType> {

  public static PrimitiveType booleanType() {
    return new PrimitiveType(Primitive.BOOLEAN);
  }

  public static PrimitiveType charType() {
    return new PrimitiveType(Primitive.CHAR);
  }

  public static PrimitiveType byteType() {
    return new PrimitiveType(Primitive.BYTE);
  }

  public static PrimitiveType shortType() {
    return new PrimitiveType(Primitive.SHORT);
  }

  public static PrimitiveType intType() {
    return new PrimitiveType(Primitive.INT);
  }

  public static PrimitiveType longType() {
    return new PrimitiveType(Primitive.LONG);
  }

  public static PrimitiveType floatType() {
    return new PrimitiveType(Primitive.FLOAT);
  }

  public static PrimitiveType doubleType() {
    return new PrimitiveType(Primitive.DOUBLE);
  }

  public enum Primitive {
    BOOLEAN("Boolean", "Z"),
    CHAR("Character", "C"),
    BYTE("Byte", "B"),
    SHORT("Short", "S"),
    INT("Integer", "I"),
    LONG("Long", "J"),
    FLOAT("Float", "F"),
    DOUBLE("Double", "D");

    final String nameOfBoxedType;

    final String descriptor;

    private String codeRepresentation;

    /*
     * Returns the Primitive constant corresponding to the specified type name (e.g. "boolean", "int",
     * "long").
     */
    public static Optional<Primitive> byTypeName(String name) {
      for (Primitive primitive : values()) {
        if (primitive.name().toLowerCase().equals(name)) {
          return Optional.of(primitive);
        }
      }
      return Optional.empty();
    }

    /*
     * Returns the Primitive constant corresponding to the specified boxed type name (e.g. "Boolean", "Integer",
     * "Long").
     */
    public static Optional<Primitive> byBoxedTypeName(String simpleName) {
      return Optional.ofNullable(unboxMap.getOrDefault(simpleName, null));
    }

    public ClassOrInterfaceType toBoxedType() {
      return parseClassOrInterfaceType(nameOfBoxedType);
    }

    public String asString() {
      return codeRepresentation;
    }

    public String toDescriptor() {
      return descriptor;
    }

    Primitive(String nameOfBoxedType, String descriptor) {
      this.nameOfBoxedType = nameOfBoxedType;
      this.codeRepresentation = name().toLowerCase();
      this.descriptor = descriptor;
    }
  }

  static final HashMap<String, Primitive> unboxMap = new HashMap<>();

  static {
    for (Primitive unboxedType : Primitive.values()) {
      unboxMap.put(unboxedType.nameOfBoxedType, unboxedType);
    }
  }

  private Primitive type;

  public PrimitiveType() {
    this(null, Primitive.INT, new NodeList<>());
  }

  public PrimitiveType(final Primitive type) {
    this(null, type, new NodeList<>());
  }

  @AllFieldsConstructor
  public PrimitiveType(final Primitive type, NodeList<AnnotationExpr> annotations) {
    this(null, type, annotations);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public PrimitiveType(
      TokenRange tokenRange, Primitive type, NodeList<AnnotationExpr> annotations) {
    super(tokenRange, annotations);
    setType(type);
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
  public Primitive getType() {
    return type;
  }

  public ClassOrInterfaceType toBoxedType() {
    return type.toBoxedType();
  }

  @Override
  public String toDescriptor() {
    return type.toDescriptor();
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public PrimitiveType setType(final Primitive type) {
    assertNotNull(type);
    if (type == this.type) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.TYPE, this.type, type);
    this.type = type;
    return this;
  }

  @Override
  public String asString() {
    return type.asString();
  }

  @Override
  public PrimitiveType setAnnotations(NodeList<AnnotationExpr> annotations) {
    return (PrimitiveType) super.setAnnotations(annotations);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public PrimitiveType clone() {
    return (PrimitiveType) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public PrimitiveTypeMetaModel getMetaModel() {
    return JavaParserMetaModel.primitiveTypeMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isPrimitiveType() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public PrimitiveType asPrimitiveType() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifPrimitiveType(Consumer<PrimitiveType> action) {
    action.accept(this);
  }

  @Override
  public ResolvedPrimitiveType resolve() {
    return getSymbolResolver().toResolvedType(this, ResolvedPrimitiveType.class);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<PrimitiveType> toPrimitiveType() {
    return Optional.of(this);
  }

  @Override
  public ResolvedType convertToUsage(Context context) {
    return ResolvedPrimitiveType.byName(getType().name());
  }
}
