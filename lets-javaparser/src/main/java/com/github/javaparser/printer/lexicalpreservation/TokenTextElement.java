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

import com.github.javaparser.JavaToken;
import com.github.javaparser.JavaToken.Kind;
import com.github.javaparser.Range;
import com.github.javaparser.ast.Node;
import java.util.Optional;

public class TokenTextElement extends TextElement {

  private final JavaToken token;

  TokenTextElement(JavaToken token) {
    this.token = token;
  }

  TokenTextElement(int tokenKind, String text) {
    this(new JavaToken(tokenKind, text));
  }

  TokenTextElement(int tokenKind) {
    this(new JavaToken(tokenKind));
  }

  @Override
  public String expand() {
    return token.getText();
  }

  // Visible for testing
  public String getText() {
    return token.getText();
  }

  public int getTokenKind() {
    return token.getKind();
  }

  public JavaToken getToken() {
    return token;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TokenTextElement that = (TokenTextElement) o;
    return token.equals(that.token);
  }

  @Override
  public int hashCode() {
    return token.hashCode();
  }

  @Override
  public String toString() {
    return token.toString();
  }

  @Override
  boolean isToken(int tokenKind) {
    return token.getKind() == tokenKind;
  }

  @Override
  boolean isNode(Node node) {
    return false;
  }

  @Override
  public boolean isWhiteSpace() {
    return token.getCategory().isWhitespace();
  }

  @Override
  public boolean isSpaceOrTab() {
    return token.getCategory().isWhitespaceButNotEndOfLine();
  }

  @Override
  public boolean isComment() {
    return token.getCategory().isComment();
  }

  @Override
  public boolean isSeparator() {
    return token.getCategory().isSeparator();
  }

  @Override
  public boolean isNewline() {
    return token.getCategory().isEndOfLine();
  }

  @Override
  public boolean isChildOfClass(Class<? extends Node> nodeClass) {
    return false;
  }

  @Override
  public boolean isIdentifier() {
    return getToken().getCategory().isIdentifier();
  }

  @Override
  public boolean isKeyword() {
    return getToken().getCategory().isKeyword();
  }

  @Override
  public boolean isLiteral() {
    return getToken().getCategory().isLiteral();
  }

  @Override
  public boolean isPrimitive() {
    return Kind.valueOf(getTokenKind()).isPrimitive();
  }

  @Override
  Optional<Range> getRange() {
    return token.getRange();
  }

  @Override
  public void accept(LexicalPreservingVisitor visitor) {
    visitor.visit(this);
  }
}
