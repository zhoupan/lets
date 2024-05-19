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

public interface DifferenceElement {

  static DifferenceElement added(CsmElement element) {
    return new Added(element);
  }

  static DifferenceElement removed(CsmElement element) {
    return new Removed(element);
  }

  static DifferenceElement kept(CsmElement element) {
    return new Kept(element);
  }

  /** Return the CsmElement considered in this DifferenceElement. */
  CsmElement getElement();

  boolean isAdded();

  boolean isRemoved();

  boolean isKept();

  default boolean isChild() {
    return getElement() instanceof LexicalDifferenceCalculator.CsmChild;
  }

  /*
   * If the {@code DifferenceElement} wraps an EOL token then this method returns a new wrapped {@code CsmElement}
   * with the specified line separator. The line separator parameter must be a {@code CsmToken} with a valid line
   * separator. By default this method returns the instance itself.
   */
  default DifferenceElement replaceEolTokens(CsmElement lineSeparator) {
    return this;
  }
}
