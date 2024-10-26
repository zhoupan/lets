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
package com.github.javaparser.ast.nodeTypes.modifiers;

import static com.github.javaparser.ast.Modifier.Keyword.STATIC;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.nodeTypes.NodeWithModifiers;

/** A node that can be static. */
public interface NodeWithStaticModifier<N extends Node> extends NodeWithModifiers<N> {

  /**
   * @return true, if the modifier {@code static} is explicitly added to this node. If the node is
   *     implicitly static without an explicit modifier (e.g. nested records), this method should be
   *     overridden.
   */
  default boolean isStatic() {
    return hasModifier(STATIC);
  }

  @SuppressWarnings("unchecked")
  default N setStatic(boolean set) {
    return setModifier(STATIC, set);
  }
}
