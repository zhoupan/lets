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
package com.github.javaparser.ast.observer;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;

/** An Observer for an AST element (either a Node or a NodeList). */
public interface AstObserver {

  /** Type of change occurring on a List */
  enum ListChangeType {
    ADDITION,
    REMOVAL
  }

  /**
   * The value of a property is changed
   *
   * @param observedNode owner of the property
   * @param property property changed
   * @param oldValue value of the property before the change
   * @param newValue value of the property after the change
   */
  void propertyChange(
      Node observedNode, ObservableProperty property, Object oldValue, Object newValue);

  /**
   * The parent of a node is changed
   *
   * @param observedNode node of which the parent is changed
   * @param previousParent previous parent
   * @param newParent new parent
   */
  void parentChange(Node observedNode, Node previousParent, Node newParent);

  /**
   * A list is changed
   *
   * @param observedNode list changed
   * @param type type of change
   * @param index position at which the changed occurred
   * @param nodeAddedOrRemoved element added or removed
   */
  void listChange(
      NodeList<?> observedNode, ListChangeType type, int index, Node nodeAddedOrRemoved);

  void listReplacement(NodeList<?> observedNode, int index, Node oldNode, Node newNode);
}
