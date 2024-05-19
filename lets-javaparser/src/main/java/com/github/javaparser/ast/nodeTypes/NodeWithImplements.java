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

/** A node that implements other types. */
public interface NodeWithImplements<N extends Node> {

  NodeList<ClassOrInterfaceType> getImplementedTypes();

  default ClassOrInterfaceType getImplementedTypes(int i) {
    return getImplementedTypes().get(i);
  }

  N setImplementedTypes(NodeList<ClassOrInterfaceType> implementsList);

  void tryAddImportToParentCompilationUnit(Class<?> clazz);

  @SuppressWarnings("unchecked")
  default N setImplementedType(int i, ClassOrInterfaceType implement) {
    getImplementedTypes().set(i, implement);
    return (N) this;
  }

  @SuppressWarnings("unchecked")
  default N addImplementedType(ClassOrInterfaceType implement) {
    getImplementedTypes().add(implement);
    return (N) this;
  }

  /**
   * @deprecated use addImplementedType instead
   */
  default N addImplements(String name) {
    return addImplementedType(name);
  }

  /**
   * @deprecated use addImplementedType instead
   */
  default N addImplements(Class<?> clazz) {
    return addImplementedType(clazz);
  }

  /**
   * Add an implements to this
   *
   * @param name the name of the type to extends from
   * @return this
   */
  @SuppressWarnings("unchecked")
  default N addImplementedType(String name) {
    getImplementedTypes().add(parseClassOrInterfaceType(name));
    return (N) this;
  }

  /**
   * Add an implements to this and automatically add the import
   *
   * @param clazz the type to implements from
   * @return this
   */
  default N addImplementedType(Class<?> clazz) {
    tryAddImportToParentCompilationUnit(clazz);
    return addImplementedType(clazz.getSimpleName());
  }
}
