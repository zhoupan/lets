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
package com.github.javaparser.ast.stmt;

import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.LocalClassDeclarationStmtMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/**
 *
 *
 * <h1>A class declaration inside a method.</h1>
 *
 * <h2>Java 1.0</h2>
 *
 * Not available.
 *
 * <h2>Java 1.1+</h2>
 *
 * A statement consisting of a class declaration. <br>
 * <code>class X { void m() { <b>class Y { }</b> } }</code>
 *
 * @see ClassOrInterfaceDeclaration
 * @author Julio Vilmar Gesser
 */
public class LocalClassDeclarationStmt extends Statement {

  private ClassOrInterfaceDeclaration classDeclaration;

  public LocalClassDeclarationStmt() {
    this(null, new ClassOrInterfaceDeclaration());
  }

  @AllFieldsConstructor
  public LocalClassDeclarationStmt(final ClassOrInterfaceDeclaration classDeclaration) {
    this(null, classDeclaration);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public LocalClassDeclarationStmt(
      TokenRange tokenRange, ClassOrInterfaceDeclaration classDeclaration) {
    super(tokenRange);
    setClassDeclaration(classDeclaration);
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
  public ClassOrInterfaceDeclaration getClassDeclaration() {
    return classDeclaration;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public LocalClassDeclarationStmt setClassDeclaration(
      final ClassOrInterfaceDeclaration classDeclaration) {
    assertNotNull(classDeclaration);
    if (classDeclaration == this.classDeclaration) {
      return this;
    }
    notifyPropertyChange(
        ObservableProperty.CLASS_DECLARATION, this.classDeclaration, classDeclaration);
    if (this.classDeclaration != null) this.classDeclaration.setParentNode(null);
    this.classDeclaration = classDeclaration;
    setAsParentNodeOf(classDeclaration);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public LocalClassDeclarationStmt clone() {
    return (LocalClassDeclarationStmt) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public LocalClassDeclarationStmtMetaModel getMetaModel() {
    return JavaParserMetaModel.localClassDeclarationStmtMetaModel;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    if (node == classDeclaration) {
      setClassDeclaration((ClassOrInterfaceDeclaration) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isLocalClassDeclarationStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public LocalClassDeclarationStmt asLocalClassDeclarationStmt() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifLocalClassDeclarationStmt(Consumer<LocalClassDeclarationStmt> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<LocalClassDeclarationStmt> toLocalClassDeclarationStmt() {
    return Optional.of(this);
  }
}
