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
package com.github.javaparser.printer.lexicalpreservation;

import com.github.javaparser.printer.concretesyntaxmodel.CsmElement;
import com.github.javaparser.printer.concretesyntaxmodel.CsmMix;
import com.github.javaparser.printer.concretesyntaxmodel.CsmToken;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Elements in a CsmMix have been reshuffled. It could also mean that some new elements have been
 * added or removed to the mix.
 */
public class Reshuffled implements DifferenceElement {

  private final CsmMix previousOrder;

  private final CsmMix nextOrder;

  Reshuffled(CsmMix previousOrder, CsmMix nextOrder) {
    this.previousOrder = previousOrder;
    this.nextOrder = nextOrder;
  }

  @Override
  public String toString() {
    return "Reshuffled{" + nextOrder + ", previous=" + previousOrder + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Reshuffled that = (Reshuffled) o;
    if (!previousOrder.equals(that.previousOrder)) return false;
    return nextOrder.equals(that.nextOrder);
  }

  @Override
  public int hashCode() {
    int result = previousOrder.hashCode();
    result = 31 * result + nextOrder.hashCode();
    return result;
  }

  @Override
  public CsmMix getElement() {
    return nextOrder;
  }

  public CsmMix getPreviousOrder() {
    return previousOrder;
  }

  public CsmMix getNextOrder() {
    return nextOrder;
  }

  @Override
  public boolean isAdded() {
    return false;
  }

  @Override
  public boolean isRemoved() {
    return false;
  }

  @Override
  public boolean isKept() {
    return false;
  }

  /*
   * If the {@code DifferenceElement} wraps an EOL token then this method returns a new {@code DifferenceElement}
   * with all eof token replaced by the specified line separator. The line separator parameter must be a CsmToken with a valid line separator.
   */
  @Override
  public DifferenceElement replaceEolTokens(CsmElement lineSeparator) {
    CsmMix modifiedNextOrder = new CsmMix(replaceTokens(nextOrder.getElements(), lineSeparator));
    CsmMix modifiedPreviousOrder =
        new CsmMix(replaceTokens(previousOrder.getElements(), lineSeparator));
    return new Reshuffled(modifiedPreviousOrder, modifiedNextOrder);
  }

  /*
   * Replaces all eol tokens in the list by the specified line separator token
   */
  private List<CsmElement> replaceTokens(List<CsmElement> elements, CsmElement lineSeparator) {
    return elements.stream()
        .map(element -> isNewLineToken(element) ? lineSeparator : element)
        .collect(Collectors.toList());
  }

  /*
   * Return true if the wrapped {@code CsmElement} is a new line token
   */
  private boolean isNewLineToken(CsmElement element) {
    return isToken(element) && ((CsmToken) element).isNewLine();
  }

  private boolean isToken(CsmElement element) {
    return element instanceof CsmToken;
  }
}
