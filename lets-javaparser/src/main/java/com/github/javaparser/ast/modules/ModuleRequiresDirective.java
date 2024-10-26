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

import static com.github.javaparser.ast.Modifier.Keyword.STATIC;
import static com.github.javaparser.ast.Modifier.Keyword.TRANSITIVE;
import static com.github.javaparser.utils.Utils.assertNotNull;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import com.github.javaparser.ast.nodeTypes.modifiers.NodeWithStaticModifier;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.ast.visitor.CloneVisitor;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.metamodel.ModuleRequiresDirectiveMetaModel;
import java.util.Optional;
import java.util.function.Consumer;

/** A require directive in module-info.java. {@code require a.b.C;} */
public class ModuleRequiresDirective extends ModuleDirective
    implements NodeWithStaticModifier<ModuleRequiresDirective>,
        NodeWithName<ModuleRequiresDirective> {

  private NodeList<Modifier> modifiers;

  private Name name;

  public ModuleRequiresDirective() {
    this(null, new NodeList<>(), new Name());
  }

  @AllFieldsConstructor
  public ModuleRequiresDirective(NodeList<Modifier> modifiers, Name name) {
    this(null, modifiers, name);
  }

  /** This constructor is used by the parser and is considered private. */
  @Generated("com.github.javaparser.generator.core.node.MainConstructorGenerator")
  public ModuleRequiresDirective(TokenRange tokenRange, NodeList<Modifier> modifiers, Name name) {
    super(tokenRange);
    setModifiers(modifiers);
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
  public NodeList<Modifier> getModifiers() {
    return modifiers;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ModuleRequiresDirective setModifiers(final NodeList<Modifier> modifiers) {
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
  public Name getName() {
    return name;
  }

  @Generated("com.github.javaparser.generator.core.node.PropertyGenerator")
  public ModuleRequiresDirective setName(final Name name) {
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

  /*
   * A requires static directive indicates that a module is required at compile time, but is optional at runtime.
   */
  public boolean isStatic() {
    return hasModifier(STATIC);
  }

  /*
   * Requires transitive—implied readability.
   * To specify a dependency on another module and to ensure that other modules reading your module also read that dependency
   */
  public boolean isTransitive() {
    return hasModifier(TRANSITIVE);
  }

  public ModuleRequiresDirective setTransitive(boolean set) {
    return setModifier(TRANSITIVE, set);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.RemoveMethodGenerator")
  public boolean remove(Node node) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < modifiers.size(); i++) {
      if (modifiers.get(i) == node) {
        modifiers.remove(i);
        return true;
      }
    }
    return super.remove(node);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.CloneGenerator")
  public ModuleRequiresDirective clone() {
    return (ModuleRequiresDirective) accept(new CloneVisitor(), null);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.ReplaceMethodGenerator")
  public boolean replace(Node node, Node replacementNode) {
    if (node == null) {
      return false;
    }
    for (int i = 0; i < modifiers.size(); i++) {
      if (modifiers.get(i) == node) {
        modifiers.set(i, (Modifier) replacementNode);
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
  public boolean isModuleRequiresStmt() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ModuleRequiresDirective asModuleRequiresStmt() {
    return this;
  }

  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifModuleRequiresStmt(Consumer<ModuleRequiresDirective> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ModuleRequiresDirective> toModuleRequiresStmt() {
    return Optional.of(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public boolean isModuleRequiresDirective() {
    return true;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public ModuleRequiresDirective asModuleRequiresDirective() {
    return this;
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public Optional<ModuleRequiresDirective> toModuleRequiresDirective() {
    return Optional.of(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.TypeCastingGenerator")
  public void ifModuleRequiresDirective(Consumer<ModuleRequiresDirective> action) {
    action.accept(this);
  }

  @Override
  @Generated("com.github.javaparser.generator.core.node.GetMetaModelGenerator")
  public ModuleRequiresDirectiveMetaModel getMetaModel() {
    return JavaParserMetaModel.moduleRequiresDirectiveMetaModel;
  }
}
