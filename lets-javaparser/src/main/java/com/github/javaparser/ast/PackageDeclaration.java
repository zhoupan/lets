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
package com.github.javaparser.ast;

import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.PackageDeclarationMetaModel;

/**
 * A package declaration. <br>
 * {@code package com.github.javaparser.ast;} <br>
 * {@code @Wonderful package anything.can.be.annotated.nowadays;}
 *
 * @author Julio Vilmar Gesser
 */
public class PackageDeclaration extends Node
    implements NodeWithAnnotations<PackageDeclaration>, NodeWithName<PackageDeclaration> {

  private NodeList<AnnotationExpr> annotations = new NodeList<>();

  private Name name;

  public PackageDeclaration() {
    this(null, new NodeList<>(), new Name());
  }

  public PackageDeclaration(Name name) {
    this(null, new NodeList<>(), name);
  }

  @AllFieldsConstructor
  public PackageDeclaration(NodeList<AnnotationExpr> annotations, Name name) {
    this(null, annotations, name);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public PackageDeclaration(
      TokenRange tokenRange, NodeList<AnnotationExpr> annotations, Name name) {
    super(tokenRange);
    setAnnotations(annotations);
    setName(name);
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

  /**
   * Retrieves the list of annotations declared before the package declaration. Return {@code null}
   * if there are no annotations.
   *
   * @return list of annotations or {@code null}
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public NodeList<AnnotationExpr> getAnnotations() {
    return annotations;
  }

  /**
   * Return the name expression of the package.
   *
   * @return the name of the package
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Name getName() {
    return name;
  }

  /**
   * @param annotations the annotations to set
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public PackageDeclaration setAnnotations(final NodeList<AnnotationExpr> annotations) {
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
   * Sets the name of this package declaration.
   *
   * @param name the name to set
   */
  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public PackageDeclaration setName(final Name name) {
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

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public PackageDeclaration clone() {
    return (PackageDeclaration) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public PackageDeclarationMetaModel getMetaModel() {
    return JavaParserMetaModel.packageDeclarationMetaModel;
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
    if (node == name) {
      setName((Name) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }
}
