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
package com.github.javaparser.printer.lexicalpreservation.changes;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.observer.ObservableProperty;
import java.util.Optional;

/** The Addition of an element to a list. */
public class ListAdditionChange implements Change {

  private final ObservableProperty observableProperty;

  private final int index;

  private final Node nodeAdded;

  public ListAdditionChange(ObservableProperty observableProperty, int index, Node nodeAdded) {
    this.observableProperty = observableProperty;
    this.index = index;
    this.nodeAdded = nodeAdded;
  }

  @Override
  public Object getValue(ObservableProperty property, Node node) {
    if (property == observableProperty) {
      Object currentRawValue = new NoChange().getValue(property, node);
      if (currentRawValue instanceof Optional) {
        Optional<?> optional = (Optional<?>) currentRawValue;
        currentRawValue = optional.orElse(null);
      }
      if (!(currentRawValue instanceof NodeList)) {
        throw new IllegalStateException(
            "Expected NodeList, found " + currentRawValue.getClass().getCanonicalName());
      }
      NodeList<Node> currentNodeList = (NodeList<Node>) currentRawValue;
      // Note: When adding to a node list children get assigned the list's parent, thus we must set
      // the list's parent before adding children (#2592).
      NodeList<Node> newNodeList = new NodeList<>();
      newNodeList.setParentNode(currentNodeList.getParentNodeForChildren());
      newNodeList.addAll(currentNodeList);
      // Perform modification -- add to the list
      newNodeList.add(index, nodeAdded);
      return newNodeList;
    }
    return new NoChange().getValue(property, node);
  }

  @Override
  public ObservableProperty getProperty() {
    return observableProperty;
  }
}
