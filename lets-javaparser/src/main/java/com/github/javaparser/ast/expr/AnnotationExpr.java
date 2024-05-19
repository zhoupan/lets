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
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.metamodel.AnnotationExprMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.resolution.Resolvable;
import com.github.javaparser.resolution.UnsolvedSymbolException;
import com.github.javaparser.resolution.declarations.ResolvedAnnotationDeclaration;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A base class for the different types of annotations.
 *
 * @author Julio Vilmar Gesser
 */
public abstract class AnnotationExpr extends Expression
    implements NodeWithName<AnnotationExpr>, Resolvable<ResolvedAnnotationDeclaration> {

  protected Name name;

  public AnnotationExpr() {
    this(null, new Name());
  }

  @AllFieldsConstructor
  public AnnotationExpr(Name name) {
    this(null, name);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public AnnotationExpr(TokenRange tokenRange, Name name) {
    super(tokenRange);
    setName(name);
    customInitialization();
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Name getName() {
    return name;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public AnnotationExpr setName(final Name name) {
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

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public AnnotationExpr clone() {
    return (AnnotationExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public AnnotationExprMetaModel getMetaModel() {
    return JavaParserMetaModel.annotationExprMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == name) {
      setName((Name) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isAnnotationExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public AnnotationExpr asAnnotationExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifAnnotationExpr(Consumer<AnnotationExpr> action) {
    action.accept(this);
  }

  /**
   * Attempts to resolve the declaration corresponding to the annotation expression. If successful,
   * a {@link ResolvedAnnotationDeclaration} representing the declaration of the annotation
   * referenced by this {@code AnnotationExpr} is returned. Otherwise, an {@link
   * UnsolvedSymbolException} is thrown.
   *
   * @return a {@link ResolvedAnnotationDeclaration} representing the declaration of the annotation
   *     expression.
   * @throws UnsolvedSymbolException if the declaration corresponding to the annotation expression
   *     could not be resolved.
   */
  @Override
  public ResolvedAnnotationDeclaration resolve() {
    return getSymbolResolver().resolveDeclaration(this, ResolvedAnnotationDeclaration.class);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<AnnotationExpr> toAnnotationExpr() {
    return Optional.of(this);
  }
}
