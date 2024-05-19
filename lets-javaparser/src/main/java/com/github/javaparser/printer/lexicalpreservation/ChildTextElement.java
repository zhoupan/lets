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

import com.github.javaparser.Range;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.Comment;
import java.util.Optional;

/** Represent the position of a child node in the NodeText of its parent. */
public class ChildTextElement extends TextElement {

  private final Node child;

  ChildTextElement(Node child) {
    this.child = child;
  }

  @Override
  public String expand() {
    return LexicalPreservingPrinter.print(child);
  }

  public Node getChild() {
    return child;
  }

  @Override
  public boolean isToken(int tokenKind) {
    return false;
  }

  @Override
  public boolean isNode(Node node) {
    return node == child;
  }

  NodeText getNodeTextForWrappedNode() {
    return LexicalPreservingPrinter.getOrCreateNodeText(child);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ChildTextElement that = (ChildTextElement) o;
    return child.equals(that.child);
  }

  @Override
  public int hashCode() {
    return child.hashCode();
  }

  @Override
  public String toString() {
    return "ChildTextElement{" + child + '}';
  }

  @Override
  public boolean isWhiteSpace() {
    return false;
  }

  @Override
  public boolean isSpaceOrTab() {
    return false;
  }

  @Override
  public boolean isNewline() {
    return false;
  }

  @Override
  public boolean isComment() {
    return child instanceof Comment;
  }

  @Override
  public boolean isSeparator() {
    return false;
  }

  @Override
  public boolean isIdentifier() {
    return false;
  }

  @Override
  public boolean isKeyword() {
    return false;
  }

  @Override
  public boolean isPrimitive() {
    return false;
  }

  @Override
  public boolean isLiteral() {
    return false;
  }

  @Override
  public boolean isChildOfClass(Class<? extends Node> nodeClass) {
    return nodeClass.isInstance(child);
  }

  @Override
  Optional<Range> getRange() {
    return child.getRange();
  }

  @Override
  public void accept(LexicalPreservingVisitor visitor) {
    NodeText nodeText = getNodeTextForWrappedNode();
    nodeText.getElements().forEach(element -> element.accept(visitor));
  }
}
