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

public abstract class AstObserverAdapter implements AstObserver {

  @Override
  public void propertyChange(
      Node observedNode, ObservableProperty property, Object oldValue, Object newValue) {
    // do nothing
  }

  @Override
  public void parentChange(Node observedNode, Node previousParent, Node newParent) {
    // do nothing
  }

  @Override
  public void listChange(
      NodeList<?> observedNode, ListChangeType type, int index, Node nodeAddedOrRemoved) {
    // do nothing
  }

  @Override
  public void listReplacement(NodeList<?> observedNode, int index, Node oldNode, Node newNode) {
    // do nothing
  }
}
