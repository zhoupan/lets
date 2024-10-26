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
import com.github.javaparser.printer.SourcePrinter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CsmSequence implements CsmElement {

  private List<CsmElement> elements;

  public CsmSequence(List<CsmElement> elements) {
    if (elements == null) {
      throw new NullPointerException();
    }
    if (elements.stream().anyMatch(Objects::isNull)) {
      throw new IllegalArgumentException("Null element in the sequence");
    }
    this.elements = elements;
  }

  public List<CsmElement> getElements() {
    return elements;
  }

  @Override
  public void prettyPrint(Node node, SourcePrinter printer) {
    elements.forEach(e -> e.prettyPrint(node, printer));
  }

  @Override
  public String toString() {
    return elements.stream()
        .map(e -> e.toString())
        .collect(Collectors.joining(",", "CsmSequence[", "]"));
  }
}
