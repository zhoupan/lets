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
package com.github.javaparser.printer.concretesyntaxmodel;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.printer.SourcePrinter;
import java.util.Arrays;
import java.util.List;

public class CsmConditional implements CsmElement {

  private final Condition condition;

  private final List<ObservableProperty> properties;

  private final CsmElement thenElement;

  private final CsmElement elseElement;

  public Condition getCondition() {
    return condition;
  }

  public ObservableProperty getProperty() {
    if (properties.size() > 1) {
      throw new IllegalStateException();
    }
    return properties.get(0);
  }

  public List<ObservableProperty> getProperties() {
    return properties;
  }

  public CsmElement getThenElement() {
    return thenElement;
  }

  public CsmElement getElseElement() {
    return elseElement;
  }

  public enum Condition {
    IS_EMPTY {

      @Override
      boolean evaluate(Node node, ObservableProperty property) {
        NodeList<? extends Node> value = property.getValueAsMultipleReference(node);
        return value == null || value.isEmpty();
      }
    },
    IS_NOT_EMPTY {

      @Override
      boolean evaluate(Node node, ObservableProperty property) {
        NodeList<? extends Node> value = property.getValueAsMultipleReference(node);
        return value != null && !value.isEmpty();
      }
    },
    IS_PRESENT {

      @Override
      boolean evaluate(Node node, ObservableProperty property) {
        return !property.isNullOrNotPresent(node);
      }
    },
    FLAG {

      @Override
      boolean evaluate(Node node, ObservableProperty property) {
        return property.getValueAsBooleanAttribute(node);
      }
    };

    abstract boolean evaluate(Node node, ObservableProperty property);
  }

  public CsmConditional(
      ObservableProperty property,
      Condition condition,
      CsmElement thenElement,
      CsmElement elseElement) {
    this.properties = Arrays.asList(property);
    this.condition = condition;
    this.thenElement = thenElement;
    this.elseElement = elseElement;
  }

  public CsmConditional(
      List<ObservableProperty> properties,
      Condition condition,
      CsmElement thenElement,
      CsmElement elseElement) {
    if (properties.size() < 1) {
      throw new IllegalArgumentException();
    }
    this.properties = properties;
    this.condition = condition;
    this.thenElement = thenElement;
    this.elseElement = elseElement;
  }

  public CsmConditional(ObservableProperty property, Condition condition, CsmElement thenElement) {
    this(property, condition, thenElement, new CsmNone());
  }

  @Override
  public void prettyPrint(Node node, SourcePrinter printer) {
    boolean test = false;
    for (ObservableProperty prop : properties) {
      test = test || condition.evaluate(node, prop);
    }
    if (test) {
      thenElement.prettyPrint(node, printer);
    } else {
      elseElement.prettyPrint(node, printer);
    }
  }
}
