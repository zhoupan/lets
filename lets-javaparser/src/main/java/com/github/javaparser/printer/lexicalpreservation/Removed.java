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

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.printer.concretesyntaxmodel.CsmElement;
import com.github.javaparser.printer.concretesyntaxmodel.CsmToken;

public class Removed implements DifferenceElement {

  private final CsmElement element;

  Removed(CsmElement element) {
    this.element = element;
  }

  @Override
  public String toString() {
    return "Removed{" + element + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Removed removed = (Removed) o;
    return element.equals(removed.element);
  }

  @Override
  public int hashCode() {
    return element.hashCode();
  }

  @Override
  public CsmElement getElement() {
    return element;
  }

  public Node getChild() {
    if (isChild()) {
      LexicalDifferenceCalculator.CsmChild csmChild =
          (LexicalDifferenceCalculator.CsmChild) element;
      return csmChild.getChild();
    }
    throw new IllegalStateException(
        "Removed is not a " + LexicalDifferenceCalculator.CsmChild.class.getSimpleName());
  }

  public int getTokenType() {
    if (isToken()) {
      CsmToken csmToken = (CsmToken) element;
      return csmToken.getTokenType();
    }
    throw new IllegalStateException("Removed is not a " + CsmToken.class.getSimpleName());
  }

  @Override
  public boolean isAdded() {
    return false;
  }

  @Override
  public boolean isRemoved() {
    return true;
  }

  @Override
  public boolean isKept() {
    return false;
  }

  public boolean isToken() {
    return element instanceof CsmToken;
  }

  public boolean isPrimitiveType() {
    if (isChild()) {
      LexicalDifferenceCalculator.CsmChild csmChild =
          (LexicalDifferenceCalculator.CsmChild) element;
      return csmChild.getChild() instanceof PrimitiveType;
    }
    return false;
  }

  public boolean isWhiteSpace() {
    if (isToken()) {
      CsmToken csmToken = (CsmToken) element;
      return csmToken.isWhiteSpace();
    }
    return false;
  }

  public boolean isWhiteSpaceNotEol() {
    if (isToken()) {
      CsmToken csmToken = (CsmToken) element;
      return csmToken.isWhiteSpaceNotEol();
    }
    return false;
  }

  public boolean isNewLine() {
    if (isToken()) {
      CsmToken csmToken = (CsmToken) element;
      return csmToken.isNewLine();
    }
    return false;
  }
}
