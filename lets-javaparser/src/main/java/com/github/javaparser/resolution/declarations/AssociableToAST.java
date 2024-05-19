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
package com.github.javaparser.resolution.declarations;

import com.github.javaparser.ast.Node;
import java.util.Optional;

/** A declaration that can be potentially associated with an AST node. */
public interface AssociableToAST {

  /**
   * If the declaration is associated to an AST node return it, otherwise it return empty.
   * Declaration based on source code have an AST node associated while others don't. Example of
   * other declarations are declarations coming from reflection or JARs.
   *
   * <p>You may wonder how this method is different from the various getWrappedNode. The difference
   * is that toAst is present in all Resolved* declarations (such as ResolvedAnnotationDeclaration),
   * while getWrappedNode is present only on the subclasses of the Resolved* declarations that
   * derive from JP AST nodes (such as JavaParserClassDeclaration). Therefore one which has a
   * Resolved* declaration need to do a downcast before being able to use getWrappedNode.
   *
   * <p>Now, this means that toAst could potentially replace getWrappedNode (but not the other way
   * around!). However toAst return an Optional, which is less convenient than getting the direct
   * node. Also, toAst sometimes have to return a more generic node. This is the case for subclasses
   * of ResolvedClassDeclaration. In those cases toAst return a Node. Why? Because both anonymous
   * class declarations and standard class declarations are subclasses of that. In one case the
   * underlying AST node is an ObjectCreationExpr, while in the other case it is
   * ClassOrInterfaceDeclaration. In these cases getWrappedNode is particularly nice because it
   * returns the right type of AST node, not just a Node.
   */
  default Optional<Node> toAst() {
    return Optional.empty();
  }

  /**
   * If the declaration is associated to an AST node and the type matches the expected {@link Class}
   * return it, otherwise it returns empty.
   *
   * @param clazz The expected class of the AST Node.
   * @param <N> The expected type of AST Node.
   * @return The declaration with the expected {@link Class}.
   * @see AssociableToAST#toAst()
   */
  default <N extends Node> Optional<N> toAst(Class<N> clazz) {
    return toAst().filter(clazz::isInstance).map(clazz::cast);
  }
}
