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

import static com.github.javaparser.StaticJavaParser.parseName;
import static com.github.javaparser.utils.Utils.assertNonEmpty;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.Name;

/**
 * A node with a (qualified) name.
 *
 * <p>The main reason for this interface is to permit users to manipulate homogeneously all nodes
 * with a getName method.
 *
 * @since 2.0.1
 */
public interface NodeWithName<N extends Node> {

  Name getName();

  N setName(Name name);

  @SuppressWarnings("unchecked")
  default N setName(String name) {
    assertNonEmpty(name);
    return setName(parseName(name));
  }

  default String getNameAsString() {
    return getName().asString();
  }
}
