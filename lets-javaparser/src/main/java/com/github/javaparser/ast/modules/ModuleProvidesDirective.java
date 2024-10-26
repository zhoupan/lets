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
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.ModuleProvidesDirectiveMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/** A provides directive in module-info.java. {@code provides X.Y with Z1.Z2, Z3.Z4;} */
public class ModuleProvidesDirective extends ModuleDirective
    implements NodeWithName<ModuleProvidesDirective> {

  private Name name;

  private NodeList<Name> with;

  public ModuleProvidesDirective() {
    this(null, new Name(), new NodeList<>());
  }

  @AllFieldsConstructor
  public ModuleProvidesDirective(Name name, NodeList<Name> with) {
    this(null, name, with);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public ModuleProvidesDirective(TokenRange tokenRange, Name name, NodeList<Name> with) {
    super(tokenRange);
    setName(name);
    setWith(with);
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
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < with.size(); i++) {
      if (with.get(i) == node) {
        with.remove(i);
        return true;
      }
    }
    return super.remove(node);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public ModuleProvidesDirective clone() {
    return (ModuleProvidesDirective) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isModuleProvidesStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ModuleProvidesDirective asModuleProvidesStmt() {
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifModuleProvidesStmt(Consumer<ModuleProvidesDirective> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ModuleProvidesDirective> toModuleProvidesStmt() {
    return Optional.of(this);
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Name getName() {
    return name;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ModuleProvidesDirective setName(final Name name) {
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

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ModuleProvidesDirective setWith(final NodeList<Name> with) {
    assertNotNull(with);
    if (with == this.with) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.WITH, this.with, with);
    if (this.with != null) this.with.setParentNode(null);
    this.with = with;
    setAsParentNodeOf(with);
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public NodeList<Name> getWith() {
    return with;
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
    for (int i = 0; i < with.size(); i++) {
      if (with.get(i) == node) {
        with.set(i, (Name) replacementNode);
        return true;
      }
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isModuleProvidesDirective() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ModuleProvidesDirective asModuleProvidesDirective() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ModuleProvidesDirective> toModuleProvidesDirective() {
    return Optional.of(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifModuleProvidesDirective(Consumer<ModuleProvidesDirective> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public ModuleProvidesDirectiveMetaModel getMetaModel() {
    return JavaParserMetaModel.moduleProvidesDirectiveMetaModel;
  }
}
