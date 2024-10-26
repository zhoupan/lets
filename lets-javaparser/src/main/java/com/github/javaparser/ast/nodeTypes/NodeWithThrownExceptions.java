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
import com.github.javaparser.ast.type.ReferenceType;

/** A node that declares the types of exception it throws. */
public interface NodeWithThrownExceptions<N extends Node> {

  N setThrownExceptions(NodeList<ReferenceType> thrownExceptions);

  NodeList<ReferenceType> getThrownExceptions();

  void tryAddImportToParentCompilationUnit(Class<?> clazz);

  default ReferenceType getThrownException(int i) {
    return getThrownExceptions().get(i);
  }

  /**
   * Adds this type to the throws clause
   *
   * @param throwType the exception type
   * @return this
   */
  @SuppressWarnings("unchecked")
  default N addThrownException(ReferenceType throwType) {
    getThrownExceptions().add(throwType);
    return (N) this;
  }

  /**
   * Adds this class to the throws clause
   *
   * @param clazz the exception class
   * @return this
   */
  default N addThrownException(Class<? extends Throwable> clazz) {
    tryAddImportToParentCompilationUnit(clazz);
    return addThrownException(parseClassOrInterfaceType(clazz.getSimpleName()));
  }

  /**
   * Check whether this elements throws this exception class. Note that this is simply a text
   * compare of the simple name of the class, no actual type resolution takes place.
   *
   * @param clazz the class of the exception
   * @return true if found in throws clause, false if not
   */
  default boolean isThrown(Class<? extends Throwable> clazz) {
    return isThrown(clazz.getSimpleName());
  }

  /**
   * Check whether this elements throws this exception class Note that this is simply a text
   * compare, no actual type resolution takes place.
   *
   * @param throwableName the class of the exception
   * @return true if found in throws clause, false if not
   */
  default boolean isThrown(String throwableName) {
    return getThrownExceptions().stream().anyMatch(t -> t.toString().equals(throwableName));
  }
}
