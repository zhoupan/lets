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
package com.github.javaparser.ast.body;

import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.nodeTypes.*;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithAccessModifiers;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.ReferenceType;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.ConstructorDeclarationMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.resolution.Resolvable;
import com.github.javaparser.resolution.declarations.ResolvedConstructorDeclaration;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * A constructor declaration: {@code class X { X() { } }} where X(){} is the constructor
 * declaration.
 *
 * <p><br>
 * All annotations preceding the name will be set on this object, not on the class. JavaParser
 * doesn't know if it they are applicable to the method or the class.
 *
 * @author Julio Vilmar Gesser
 */
public class ConstructorDeclaration extends CallableDeclaration<ConstructorDeclaration>
    implements NodeWithBlockStmt<ConstructorDeclaration>,
        NodeWithAccessModifiers<ConstructorDeclaration>,
        NodeWithJavadoc<ConstructorDeclaration>,
        NodeWithSimpleName<ConstructorDeclaration>,
        NodeWithParameters<ConstructorDeclaration>,
        NodeWithThrownExceptions<ConstructorDeclaration>,
        NodeWithTypeParameters<ConstructorDeclaration>,
        Resolvable<ResolvedConstructorDeclaration> {

  private BlockStmt body;

  public ConstructorDeclaration() {
    this(
        null,
        new NodeList<>(),
        new NodeList<>(),
        new NodeList<>(),
        new SimpleName(),
        new NodeList<>(),
        new NodeList<>(),
        new BlockStmt(),
        null);
  }

  public ConstructorDeclaration(String name) {
    this(
        null,
        new NodeList<>(new Modifier()),
        new NodeList<>(),
        new NodeList<>(),
        new SimpleName(name),
        new NodeList<>(),
        new NodeList<>(),
        new BlockStmt(),
        null);
  }

  public ConstructorDeclaration(NodeList<Modifier> modifiers, String name) {
    this(
        null,
        modifiers,
        new NodeList<>(),
        new NodeList<>(),
        new SimpleName(name),
        new NodeList<>(),
        new NodeList<>(),
        new BlockStmt(),
        null);
  }

  public ConstructorDeclaration(
      NodeList<Modifier> modifiers,
      NodeList<AnnotationExpr> annotations,
      NodeList<TypeParameter> typeParameters,
      SimpleName name,
      NodeList<Parameter> parameters,
      NodeList<ReferenceType> thrownExceptions,
      BlockStmt body) {
    this(
        null,
        modifiers,
        annotations,
        typeParameters,
        name,
        parameters,
        thrownExceptions,
        body,
        null);
  }

  @AllFieldsConstructor
  public ConstructorDeclaration(
      NodeList<Modifier> modifiers,
      NodeList<AnnotationExpr> annotations,
      NodeList<TypeParameter> typeParameters,
      SimpleName name,
      NodeList<Parameter> parameters,
      NodeList<ReferenceType> thrownExceptions,
      BlockStmt body,
      ReceiverParameter receiverParameter) {
    this(
        null,
        modifiers,
        annotations,
        typeParameters,
        name,
        parameters,
        thrownExceptions,
        body,
        receiverParameter);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public ConstructorDeclaration(
      TokenRange tokenRange,
      NodeList<Modifier> modifiers,
      NodeList<AnnotationExpr> annotations,
      NodeList<TypeParameter> typeParameters,
      SimpleName name,
      NodeList<Parameter> parameters,
      NodeList<ReferenceType> thrownExceptions,
      BlockStmt body,
      ReceiverParameter receiverParameter) {
    super(
        tokenRange,
        modifiers,
        annotations,
        typeParameters,
        name,
        parameters,
        thrownExceptions,
        receiverParameter);
    setBody(body);
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
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public BlockStmt getBody() {
    return body;
  }

  /**
   * Sets the body
   *
   * @param body the body, can not be null
   * @return this, the ConstructorDeclaration
   */
  @Override
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ConstructorDeclaration setBody(final BlockStmt body) {
    assertNotNull(body);
    if (body == this.body) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.BODY, this.body, body);
    if (this.body != null) this.body.setParentNode(null);
    this.body = body;
    setAsParentNodeOf(body);
    return this;
  }

  @Override
  public ConstructorDeclaration setModifiers(final NodeList<Modifier> modifiers) {
    return super.setModifiers(modifiers);
  }

  @Override
  public ConstructorDeclaration setName(final SimpleName name) {
    return super.setName(name);
  }

  @Override
  public ConstructorDeclaration setParameters(final NodeList<Parameter> parameters) {
    return super.setParameters(parameters);
  }

  @Override
  public ConstructorDeclaration setThrownExceptions(
      final NodeList<ReferenceType> thrownExceptions) {
    return super.setThrownExceptions(thrownExceptions);
  }

  @Override
  public ConstructorDeclaration setTypeParameters(final NodeList<TypeParameter> typeParameters) {
    return super.setTypeParameters(typeParameters);
  }

  /**
   * The declaration returned has this schema:
   *
   * <p>[accessSpecifier] className ([paramType [paramName]]) [throws exceptionsList]
   */
  @Override
  public String getDeclarationAsString(
      boolean includingModifiers, boolean includingThrows, boolean includingParameterName) {
    StringBuilder sb = new StringBuilder();
    if (includingModifiers) {
      AccessSpecifier accessSpecifier = getAccessSpecifier();
      sb.append(accessSpecifier.asString()).append(" ");
    }
    sb.append(getName());
    sb.append("(");
    boolean firstParam = true;
    for (Parameter param : getParameters()) {
      if (firstParam) {
        firstParam = false;
      } else {
        sb.append(", ");
      }
      if (includingParameterName) {
        sb.append(param.toString(prettyPrinterNoCommentsConfiguration));
      } else {
        sb.append(param.getType().toString(prettyPrinterNoCommentsConfiguration));
      }
    }
    sb.append(")");
    sb.append(appendThrowsIfRequested(includingThrows));
    return sb.toString();
  }

  /*
   * Returns the constructor descriptor
   */
  public String toDescriptor() {
    StringBuilder sb = new StringBuilder();
    sb.append('(');
    for (int i = 0; i < getParameters().size(); i++) {
      sb.append(getParameter(i).getType().toDescriptor());
    }
    return sb.append(")V").toString();
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public ConstructorDeclaration clone() {
    return (ConstructorDeclaration) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public ConstructorDeclarationMetaModel getMetaModel() {
    return JavaParserMetaModel.constructorDeclarationMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == body) {
      setBody((BlockStmt) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isConstructorDeclaration() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ConstructorDeclaration asConstructorDeclaration() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifConstructorDeclaration(Consumer<ConstructorDeclaration> action) {
    action.accept(this);
  }

  @Override
  public ResolvedConstructorDeclaration resolve() {
    return getSymbolResolver().resolveDeclaration(this, ResolvedConstructorDeclaration.class);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ConstructorDeclaration> toConstructorDeclaration() {
    return Optional.of(this);
  }
}
