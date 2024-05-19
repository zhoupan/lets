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

import static com.github.javaparser.StaticJavaParser.parseType;
import static com.github.javaparser.utils.Utils.assertNonEmpty;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.type.Type;

/**
 * A node with a type.
 *
 * <p>The main reason for this interface is to permit users to manipulate homogeneously all nodes
 * with getType/setType methods
 *
 * @since 2.3.1
 */
public interface NodeWithType<N extends Node, T extends Type> {

  /**
   * Gets the type
   *
   * @return the type
   */
  T getType();

  /**
   * Sets the type
   *
   * @param type the type
   * @return this
   */
  N setType(T type);

  void tryAddImportToParentCompilationUnit(Class<?> clazz);

  /**
   * Sets this type to this class and try to import it to the {@link CompilationUnit} if needed
   *
   * @param typeClass the type
   * @return this
   */
  @SuppressWarnings("unchecked")
  default N setType(Class<?> typeClass) {
    tryAddImportToParentCompilationUnit(typeClass);
    return setType((T) parseType(typeClass.getSimpleName()));
  }

  @SuppressWarnings("unchecked")
  default N setType(final String typeString) {
    assertNonEmpty(typeString);
    return setType((T) parseType(typeString));
  }

  default String getTypeAsString() {
    return getType().asString();
  }
}
