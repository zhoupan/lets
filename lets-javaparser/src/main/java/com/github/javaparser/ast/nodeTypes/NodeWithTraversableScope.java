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

import com.github.javaparser.ast.expr.Expression;
import java.util.Optional;

/**
 * Represents a node which has a scope expression that can be traversed/walked. This unifies scope
 * access for NodeWithScope and NodeWithOptionalScope.
 */
public interface NodeWithTraversableScope {

  /**
   * @return the scope of this node, regardless of optionality. An optional scope is returned
   *     directly. A required scope is returned in an "Optional", but will never be empty.
   */
  Optional<Expression> traverseScope();
}
