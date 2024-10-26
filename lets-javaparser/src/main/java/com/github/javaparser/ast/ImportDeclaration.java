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

import static com.github.javaparser.StaticJavaParser.parseName;
import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.ImportDeclarationMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;

/**
 * An import declaration. <br>
 * {@code import com.github.javaparser.JavaParser;} <br>
 * {@code import com.github.javaparser.*;} <br>
 * {@code import com.github.javaparser.JavaParser.*; } <br>
 * {@code import static com.github.javaparser.JavaParser.*;} <br>
 * {@code import static com.github.javaparser.JavaParser.parse;}
 *
 * <p>The name does not include the asterisk or the static keyword.
 *
 * @author Julio Vilmar Gesser
 */
public class ImportDeclaration extends Node implements NodeWithName<ImportDeclaration> {

  private Name name;

  private boolean isStatic;

  private boolean isAsterisk;

  private SimpleName asName;

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public SimpleName getAsName() {
    return asName;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ImportDeclaration setAsName(final SimpleName asName) {
    assertNotNull(asName);
    if (asName == this.asName) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.NAME, this.asName, asName);
    if (this.asName != null) this.asName.setParentNode(null);
    this.asName = asName;
    setAsParentNodeOf(asName);
    return this;
  }

  public ImportDeclaration(String name, boolean isStatic, boolean isAsterisk) {
    this(null, parseName(name), isStatic, isAsterisk);
  }

  @AllFieldsConstructor
  public ImportDeclaration(Name name, boolean isStatic, boolean isAsterisk, SimpleName asName) {
    this(null, name, isStatic, isAsterisk, null);
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public boolean isAsterisk() {
    return isAsterisk;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ImportDeclaration setAsterisk(final boolean isAsterisk) {
    if (isAsterisk == this.isAsterisk) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.ASTERISK, this.isAsterisk, isAsterisk);
    this.isAsterisk = isAsterisk;
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public boolean isStatic() {
    return isStatic;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ImportDeclaration setStatic(final boolean isStatic) {
    if (isStatic == this.isStatic) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.STATIC, this.isStatic, isStatic);
    this.isStatic = isStatic;
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Name getName() {
    return name;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ImportDeclaration setName(final Name name) {
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
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public ImportDeclaration clone() {
    return (ImportDeclaration) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public ImportDeclarationMetaModel getMetaModel() {
    return JavaParserMetaModel.importDeclarationMetaModel;
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public ImportDeclaration(TokenRange tokenRange, Name name, boolean isStatic, boolean isAsterisk) {
    super(tokenRange);
    setName(name);
    setStatic(isStatic);
    setAsterisk(isAsterisk);
    customInitialization();
  }

  public ImportDeclaration(
      TokenRange tokenRange, Name name, boolean isStatic, boolean isAsterisk, SimpleName asName) {
    this(tokenRange, name, isStatic, isAsterisk);
    setAsName(asName);
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
}
