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

/**
 * Node with a declaration representable as a String.
 *
 * @author Federico Tomassetti
 * @since July 2014
 */
public interface NodeWithDeclaration {

  /**
   * As {@link NodeWithDeclaration#getDeclarationAsString(boolean, boolean, boolean)} including the
   * modifiers, the throws clause and the parameters with both type and name.
   *
   * @return String representation of declaration
   */
  default String getDeclarationAsString() {
    return getDeclarationAsString(true, true, true);
  }

  /**
   * As {@link NodeWithDeclaration#getDeclarationAsString(boolean, boolean, boolean)} including the
   * parameters with both type and name. The method declaration is returned without comment.
   *
   * @param includingModifiers flag to include the modifiers (if present) in the string produced
   * @param includingThrows flag to include the throws clause (if present) in the string produced
   * @return String representation of declaration based on parameter flags
   */
  default String getDeclarationAsString(boolean includingModifiers, boolean includingThrows) {
    return getDeclarationAsString(includingModifiers, includingThrows, true);
  }

  /**
   * A simple representation of the element declaration. It should fit one string.
   *
   * @param includingModifiers flag to include the modifiers (if present) in the string produced
   * @param includingThrows flag to include the throws clause (if present) in the string produced
   * @param includingParameterName flag to include the parameter name (while the parameter type is
   *     always included) in the string produced
   * @return String representation of declaration based on parameter flags
   */
  String getDeclarationAsString(
      boolean includingModifiers, boolean includingThrows, boolean includingParameterName);
}
