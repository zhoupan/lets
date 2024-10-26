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
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.printer.SourcePrinter;

public class CsmTextBlock implements CsmElement {

  private final ObservableProperty property;

  public CsmTextBlock(ObservableProperty property) {
    this.property = property;
  }

  public ObservableProperty getProperty() {
    return property;
  }

  @Override
  public void prettyPrint(Node node, SourcePrinter printer) {
    printer.print("\"\"\"");
    // Per https://openjdk.java.net/jeps/378#1--Line-terminators, any 'CRLF' and 'CR' are turned
    // into 'LF' before interpreting the text
    printer.println();
    // TODO: Confirm if we need to force this to use {@code \n} separators
    printer.print(property.getValueAsStringAttribute(node));
    printer.print("\"\"\"");
  }

  @Override
  public String toString() {
    return String.format("%s(property:%s)", this.getClass().getSimpleName(), getProperty());
  }
}
