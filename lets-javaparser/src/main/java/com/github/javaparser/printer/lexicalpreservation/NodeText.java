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
import java.util.LinkedList;
import java.util.List;

/**
 * This contains the lexical information for a single node. It is basically a list of tokens and
 * children.
 */
class NodeText {

  private final List<TextElement> elements;

  public static final int NOT_FOUND = -1;

  //
  // Constructors
  //
  NodeText(List<TextElement> elements) {
    this.elements = elements;
  }

  /** Initialize with an empty list of elements. */
  NodeText() {
    this(new LinkedList<>());
  }

  //
  // Adding elements
  //
  /** Add an element at the end. */
  void addElement(TextElement nodeTextElement) {
    this.elements.add(nodeTextElement);
  }

  /** Add an element at the given position. */
  void addElement(int index, TextElement nodeTextElement) {
    this.elements.add(index, nodeTextElement);
  }

  void addChild(Node child) {
    addElement(new ChildTextElement(child));
  }

  void addChild(int index, Node child) {
    addElement(index, new ChildTextElement(child));
  }

  void addToken(int tokenKind, String text) {
    elements.add(new TokenTextElement(tokenKind, text));
  }

  void addToken(int index, int tokenKind, String text) {
    elements.add(index, new TokenTextElement(tokenKind, text));
  }

  //
  // Finding elements
  //
  int findElement(TextElementMatcher matcher) {
    return findElement(matcher, 0);
  }

  int findElement(TextElementMatcher matcher, int from) {
    int res = tryToFindElement(matcher, from);
    if (res == NOT_FOUND) {
      throw new IllegalArgumentException(
          String.format(
              "I could not find child '%s' from position %d. Elements: %s",
              matcher, from, elements));
    }
    return res;
  }

  int tryToFindElement(TextElementMatcher matcher, int from) {
    for (int i = from; i < elements.size(); i++) {
      TextElement element = elements.get(i);
      if (matcher.match(element)) {
        return i;
      }
    }
    return NOT_FOUND;
  }

  int findChild(Node child) {
    return findChild(child, 0);
  }

  int findChild(Node child, int from) {
    return findElement(TextElementMatchers.byNode(child), from);
  }

  int tryToFindChild(Node child) {
    return tryToFindChild(child, 0);
  }

  int tryToFindChild(Node child, int from) {
    return tryToFindElement(TextElementMatchers.byNode(child), from);
  }

  //
  // Removing single elements
  //
  public void remove(TextElementMatcher matcher, boolean potentiallyFollowingWhitespace) {
    int i = 0;
    for (TextElement e : elements) {
      if (matcher.match(e)) {
        elements.remove(e);
        if (potentiallyFollowingWhitespace) {
          if (i < elements.size()) {
            if (elements.get(i).isWhiteSpace()) {
              elements.remove(i);
            }
          } else {
            throw new UnsupportedOperationException("There is no element to remove!");
          }
        }
        return;
      }
    }
    throw new IllegalArgumentException();
  }

  //
  // Removing sequences
  //
  void removeElement(int index) {
    elements.remove(index);
  }

  //
  // Replacing elements
  //
  void replace(TextElementMatcher position, TextElement newElement) {
    int index = findElement(position, 0);
    elements.remove(index);
    elements.add(index, newElement);
  }

  //
  // Other methods
  //
  /** Generate the corresponding string. */
  String expand() {
    StringBuffer sb = new StringBuffer();
    elements.forEach(e -> sb.append(e.expand()));
    return sb.toString();
  }

  // Visible for testing
  int numberOfElements() {
    return elements.size();
  }

  // Visible for testing
  TextElement getTextElement(int index) {
    return elements.get(index);
  }

  // Visible for testing
  List<TextElement> getElements() {
    return elements;
  }

  @Override
  public String toString() {
    return "NodeText{" + elements + '}';
  }
}
