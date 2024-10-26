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

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.stmt.SwitchEntry;
import java.util.Optional;

/**
 * The common interface of {@link com.github.javaparser.ast.expr.SwitchExpr} and {@link
 * com.github.javaparser.ast.stmt.SwitchStmt}
 */
public interface SwitchNode {

  NodeList<SwitchEntry> getEntries();

  SwitchEntry getEntry(int i);

  Expression getSelector();

  SwitchNode setEntries(NodeList<SwitchEntry> entries);

  SwitchNode setSelector(Expression selector);

  boolean remove(Node node);

  SwitchNode clone();

  boolean replace(Node node, Node replacementNode);

  Optional<Comment> getComment();

  /**
   * @return true if there are no labels or anything contained in this switch.
   */
  default boolean isEmpty() {
    return getEntries().isEmpty();
  }
  // Too bad Node isn't an interface, or this could have easily inherited all of its methods.
  // Add more when required.
}
