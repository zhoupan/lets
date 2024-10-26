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

import static com.github.javaparser.StaticJavaParser.parseName;
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
import com.github.javaparser.metamodel.ModuleExportsDirectiveMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/** An exports directive in module-info.java. {@code exports R.S to T1.U1, T2.U2;} */
public class ModuleExportsDirective extends ModuleDirective
    implements NodeWithName<ModuleExportsDirective> {

  private Name name;

  private NodeList<Name> moduleNames;

  public ModuleExportsDirective() {
    this(null, new Name(), new NodeList<>());
  }

  @AllFieldsConstructor
  public ModuleExportsDirective(Name name, NodeList<Name> moduleNames) {
    this(null, name, moduleNames);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public ModuleExportsDirective(TokenRange tokenRange, Name name, NodeList<Name> moduleNames) {
    super(tokenRange);
    setName(name);
    setModuleNames(moduleNames);
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
    for (int i = 0; i < moduleNames.size(); i++) {
      if (moduleNames.get(i) == node) {
        moduleNames.remove(i);
        return true;
      }
    }
    return super.remove(node);
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public Name getName() {
    return name;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ModuleExportsDirective setName(final Name name) {
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
  public NodeList<Name> getModuleNames() {
    return moduleNames;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ModuleExportsDirective setModuleNames(final NodeList<Name> moduleNames) {
    assertNotNull(moduleNames);
    if (moduleNames == this.moduleNames) {
      return this;
    }
    notifyPropertyChange(ObservableProperty.MODULE_NAMES, this.moduleNames, moduleNames);
    if (this.moduleNames != null) this.moduleNames.setParentNode(null);
    this.moduleNames = moduleNames;
    setAsParentNodeOf(moduleNames);
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public ModuleExportsDirective clone() {
    return (ModuleExportsDirective) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < moduleNames.size(); i++) {
      if (moduleNames.get(i) == node) {
        moduleNames.set(i, (Name) replacementNode);
        return true;
      }
    }
    if (node == name) {
      setName((Name) replacementNode);
      return true;
    }
    return super.replace(node, replacementNode);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isModuleExportsStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ModuleExportsDirective asModuleExportsStmt() {
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifModuleExportsStmt(Consumer<ModuleExportsDirective> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ModuleExportsDirective> toModuleExportsStmt() {
    return Optional.of(this);
  }

  public ModuleExportsDirective addModuleName(String name) {
    moduleNames.add(parseName(name));
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isModuleExportsDirective() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ModuleExportsDirective asModuleExportsDirective() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ModuleExportsDirective> toModuleExportsDirective() {
    return Optional.of(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifModuleExportsDirective(Consumer<ModuleExportsDirective> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public ModuleExportsDirectiveMetaModel getMetaModel() {
    return JavaParserMetaModel.moduleExportsDirectiveMetaModel;
  }
}
