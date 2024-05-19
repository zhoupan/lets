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
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.VoidTypeMetaModel;
import com.github.javaparser.resolution.Context;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.resolution.types.ResolvedVoidType;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * The return type of a {@link com.github.javaparser.ast.body.MethodDeclaration} when it returns
 * void. <br>
 * <code><b>void</b> helloWorld() { ... }</code>
 *
 * @author Julio Vilmar Gesser
 */
public class VoidType extends Type implements NodeWithAnnotations<VoidType> {

  @AllFieldsConstructor
  public VoidType() {
    this(null);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public VoidType(TokenRange tokenRange) {
    super(tokenRange);
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

  @Override
  public VoidType setAnnotations(NodeList<AnnotationExpr> annotations) {
    return (VoidType) super.setAnnotations(annotations);
  }

  @Override
  public String asString() {
    return "void";
  }

  @Override
  public String toDescriptor() {
    return "V";
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public VoidType clone() {
    return (VoidType) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public VoidTypeMetaModel getMetaModel() {
    return JavaParserMetaModel.voidTypeMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isVoidType() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public VoidType asVoidType() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifVoidType(Consumer<VoidType> action) {
    action.accept(this);
  }

  @Override
  public ResolvedVoidType resolve() {
    return getSymbolResolver().toResolvedType(this, ResolvedVoidType.class);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<VoidType> toVoidType() {
    return Optional.of(this);
  }

  @Override
  public ResolvedType convertToUsage(Context context) {
    return ResolvedVoidType.INSTANCE;
  }
}
