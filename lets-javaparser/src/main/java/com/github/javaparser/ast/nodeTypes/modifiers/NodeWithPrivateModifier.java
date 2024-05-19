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

import static com.github.javaparser.ast.Modifier.Keyword.PRIVATE;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.nodeTypes.NodeWithModifiers;

/** A node that can be private. */
public interface NodeWithPrivateModifier<N extends Node> extends NodeWithModifiers<N> {

  default boolean isPrivate() {
    return hasModifier(PRIVATE);
  }

  @SuppressWarnings("unchecked")
  default N setPrivate(boolean set) {
    return setModifier(PRIVATE, set);
  }
}
