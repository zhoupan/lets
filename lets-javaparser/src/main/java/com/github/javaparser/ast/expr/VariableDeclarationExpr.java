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

import static com.github.javaparser.ast.NodeList.nodeList;
import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.nodeTypes.NodeWithVariables;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithFinalModifier;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.NonEmptyProperty;
import com.github.javaparser.metamodel.VariableDeclarationExprMetaModel;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * A declaration of variables. It is an expression, so it can be put in places like the initializer
 * of a for loop, or the resources part of the try statement. <br>
 * {@code final int x=3, y=55} <br>
 * All annotations preceding the type will be set on this object, not on the type. JavaParser
 * doesn't know if it they are applicable to the method or the type.
 *
 * @author Julio Vilmar Gesser
 */
public class VariableDeclarationExpr extends Expression
    implements NodeWithFinalModifier<VariableDeclarationExpr>,
        NodeWithAnnotations<VariableDeclarationExpr>,
        NodeWithVariables<VariableDeclarationExpr> {

  private NodeList<Modifier> modifiers;

  private NodeList<AnnotationExpr> annotations;

  @NonEmptyProperty private NodeList<VariableDeclarator> variables;

  public VariableDeclarationExpr() {
    this(null, new NodeList<>(), new NodeList<>(), new NodeList<>());
  }

  public VariableDeclarationExpr(final Type type, String variableName) {
    this(
        null,
        new NodeList<>(),
        new NodeList<>(),
        nodeList(new VariableDeclarator(type, variableName)));
  }

  public VariableDeclarationExpr(VariableDeclarator var) {
    this(null, new NodeList<>(), new NodeList<>(), nodeList(var));
  }

  public VariableDeclarationExpr(final Type type, String variableName, Modifier... modifiers) {
    this(
        null,
        Arrays.stream(modifiers).collect(Collectors.toCollection(() -> new NodeList<>())),
        new NodeList<>(),
        nodeList(new VariableDeclarator(type, variableName)));
  }

  public VariableDeclarationExpr(VariableDeclarator var, Modifier... modifiers) {
    this(
        null,
        Arrays.stream(modifiers).collect(Collectors.toCollection(() -> new NodeList<>())),
        new NodeList<>(),
        nodeList(var));
  }

  public VariableDeclarationExpr(final NodeList<VariableDeclarator> variables) {
    this(null, new NodeList<>(), new NodeList<>(), variables);
  }

  public VariableDeclarationExpr(
      final NodeList<Modifier> modifiers, final NodeList<VariableDeclarator> variables) {
    this(null, modifiers, new NodeList<>(), variables);
  }

  @AllFieldsConstructor
  public VariableDeclarationExpr(
      final NodeList<Modifier> modifiers,
      final NodeList<AnnotationExpr> annotations,
      final NodeList<VariableDeclarator> variables) {
    this(null, modifiers, annotations, variables);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public VariableDeclarationExpr(
      TokenRange tokenRange,
      NodeList<Modifier> modifiers,
      NodeList<AnnotationExpr> annotations,
      NodeList<VariableDeclarator> variables) {
    super(tokenRange);
    setModifiers(modifiers);
    setAnnotations(annotations);
    setVariables(variables);
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
  public NodeList<AnnotationExpr> getAnnotations() {
    return annotations;
  }

  /**
   * Return the modifiers of this variable declaration.
   *
   * @return modifiers
   * @see Modifier
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public NodeList<Modifier> getModifiers() {
    return modifiers;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public NodeList<VariableDeclarator> getVariables() {
    return variables;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public VariableDeclarationExpr setAnnotations(final NodeList<AnnotationExpr> annotations) {
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

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public VariableDeclarationExpr setModifiers(final NodeList<Modifier> modifiers) {
    assertNotNull(modifiers);
    if (modifiers == this.modifiers) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.MODIFIERS, this.modifiers, modifiers);
    if (this.modifiers != null) this.modifiers.setParentNode(null);
    this.modifiers = modifiers;
    setAsParentNodeOf(modifiers);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public VariableDeclarationExpr setVariables(final NodeList<VariableDeclarator> variables) {
    assertNotNull(variables);
    if (variables == this.variables) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.VARIABLES, this.variables, variables);
    if (this.variables != null) this.variables.setParentNode(null);
    this.variables = variables;
    setAsParentNodeOf(variables);
    return this;
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
    for (int i = 0; i < modifiers.size(); i++) {
      if (modifiers.get(i) == node) {
        modifiers.remove(i);
        return true;
      }
    }
    for (int i = 0; i < variables.size(); i++) {
      if (variables.get(i) == node) {
        variables.remove(i);
        return true;
      }
    }
    return super.remove(node);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public VariableDeclarationExpr clone() {
    return (VariableDeclarationExpr) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public VariableDeclarationExprMetaModel getMetaModel() {
    return JavaParserMetaModel.variableDeclarationExprMetaModel;
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
    for (int i = 0; i < modifiers.size(); i++) {
      if (modifiers.get(i) == node) {
        modifiers.set(i, (Modifier) replacementNode);
        return true;
      }
    }
    for (int i = 0; i < variables.size(); i++) {
      if (variables.get(i) == node) {
        variables.set(i, (VariableDeclarator) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isVariableDeclarationExpr() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public VariableDeclarationExpr asVariableDeclarationExpr() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifVariableDeclarationExpr(Consumer<VariableDeclarationExpr> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<VariableDeclarationExpr> toVariableDeclarationExpr() {
    return Optional.of(this);
  }
}
