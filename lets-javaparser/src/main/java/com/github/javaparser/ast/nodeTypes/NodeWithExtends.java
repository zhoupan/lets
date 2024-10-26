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
package com.github.javaparser.ast.nodeTypes;

import static com.github.javaparser.StaticJavaParser.parseClassOrInterfaceType;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.type.ClassOrInterfaceType;

/** A node that explicitly extends other types, using the {@code extends} keyword. */
public interface NodeWithExtends<N extends Node> {

  /**
   * @return All extended types that have been explicitly added (thus exist within the AST). Note
   *     that this can contain more than one item if this is an interface. Note that this will not
   *     include {@code java.lang.Object} unless it is explicitly added (e.g. {@code class X extends
   *     Object {}}) If you want the implicitly extended types, you will need a resolved reference.
   */
  NodeList<ClassOrInterfaceType> getExtendedTypes();

  void tryAddImportToParentCompilationUnit(Class<?> clazz);

  default ClassOrInterfaceType getExtendedTypes(int i) {
    return getExtendedTypes().get(i);
  }

  N setExtendedTypes(NodeList<ClassOrInterfaceType> extendsList);

  @SuppressWarnings("unchecked")
  default N setExtendedType(int i, ClassOrInterfaceType extend) {
    getExtendedTypes().set(i, extend);
    return (N) this;
  }

  @SuppressWarnings("unchecked")
  default N addExtendedType(ClassOrInterfaceType extend) {
    getExtendedTypes().add(extend);
    return (N) this;
  }

  /**
   * @deprecated use addExtendedType
   */
  @Deprecated
  default N addExtends(Class<?> clazz) {
    return addExtendedType(clazz);
  }

  /**
   * @deprecated use addExtendedType
   */
  @Deprecated
  default N addExtends(String name) {
    return addExtendedType(name);
  }

  /**
   * Add an "extends" to this and automatically add the import
   *
   * @param clazz the class to extend from
   * @return this
   */
  default N addExtendedType(Class<?> clazz) {
    tryAddImportToParentCompilationUnit(clazz);
    return addExtendedType(clazz.getSimpleName());
  }

  /**
   * Add an "extends" to this
   *
   * @param name the name of the type to extends from
   * @return this
   */
  @SuppressWarnings("unchecked")
  default N addExtendedType(String name) {
    getExtendedTypes().add(parseClassOrInterfaceType(name));
    return (N) this;
  }
}
