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
package com.github.javaparser.ast.modules;

import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.AllFieldsConstructor;
import com.github.javaparser.ast.Generated;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.ModuleUsesDirectiveMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/** A uses directive in module-info.java. {@code uses V.W;} */
public class ModuleUsesDirective extends ModuleDirective
    implements NodeWithName<ModuleUsesDirective> {

  private Name name;

  public ModuleUsesDirective() {
    this(null, new Name());
  }

  @AllFieldsConstructor
  public ModuleUsesDirective(Name name) {
    this(null, name);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public ModuleUsesDirective(TokenRange tokenRange, Name name) {
    super(tokenRange);
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

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ModuleUsesDirective setType(final Name name) {
    assertNotNull(name);
    if (name == this.name) {
      return (ModuleUsesDirective) this;
    }
    notifyPropertyChange(ObservableProperty.TYPE, this.name, name);
    if (this.name != null) this.name.setParentNode(null);
    this.name = name;
    setAsParentNodeOf(name);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public ModuleUsesDirective clone() {
    return (ModuleUsesDirective) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isModuleUsesStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ModuleUsesDirective asModuleUsesStmt() {
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifModuleUsesStmt(Consumer<ModuleUsesDirective> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ModuleUsesDirective> toModuleUsesStmt() {
    return Optional.of(this);
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Name getName() {
    return name;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ModuleUsesDirective setName(final Name name) {
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
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isModuleUsesDirective() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ModuleUsesDirective asModuleUsesDirective() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ModuleUsesDirective> toModuleUsesDirective() {
    return Optional.of(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifModuleUsesDirective(Consumer<ModuleUsesDirective> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public ModuleUsesDirectiveMetaModel getMetaModel() {
    return JavaParserMetaModel.moduleUsesDirectiveMetaModel;
  }
}
