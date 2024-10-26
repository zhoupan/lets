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
import com.github.javaparser.printer.concretesyntaxmodel.CsmIndent;
import com.github.javaparser.printer.concretesyntaxmodel.CsmToken;
import com.github.javaparser.printer.concretesyntaxmodel.CsmUnindent;

public class Added implements DifferenceElement {

  private final CsmElement element;

  Added(CsmElement element) {
    this.element = element;
  }

  @Override
  public String toString() {
    return "Added{" + element + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Added added = (Added) o;
    return element.equals(added.element);
  }

  @Override
  public int hashCode() {
    return element.hashCode();
  }

  @Override
  public CsmElement getElement() {
    return element;
  }

  @Override
  public boolean isAdded() {
    return true;
  }

  @Override
  public boolean isRemoved() {
    return false;
  }

  @Override
  public boolean isKept() {
    return false;
  }

  public boolean isIndent() {
    return element instanceof CsmIndent;
  }

  public boolean isUnindent() {
    return element instanceof CsmUnindent;
  }

  private boolean isToken() {
    return element instanceof CsmToken;
  }

  public TextElement toTextElement() {
    if (element instanceof LexicalDifferenceCalculator.CsmChild) {
      return new ChildTextElement(((LexicalDifferenceCalculator.CsmChild) element).getChild());
    }
    if (element instanceof CsmToken) {
      return new TokenTextElement(
          ((CsmToken) element).getTokenType(), ((CsmToken) element).getContent());
    }
    throw new UnsupportedOperationException(
        "Unsupported element type: " + element.getClass().getSimpleName());
  }

  /*
   * If the {@code DifferenceElement} wraps an EOL token then this method returns a new wrapped {@code CsmElement}
   * with the specified line separator. The line separator parameter must be a CsmToken with a valid line separator.
   */
  @Override
  public DifferenceElement replaceEolTokens(CsmElement lineSeparator) {
    return isNewLine() ? new Added(lineSeparator) : this;
  }

  /*
   * Return true if the wrapped {@code CsmElement} is a new line token
   */
  public boolean isNewLine() {
    return isToken() && ((CsmToken) element).isNewLine();
  }
}
