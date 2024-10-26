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

import static com.github.javaparser.TokenTypes.eolTokenKind;
import static com.github.javaparser.TokenTypes.spaceTokenKind;

import com.github.javaparser.GeneratedJavaParserConstants;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.printer.SourcePrinter;
import com.github.javaparser.printer.lexicalpreservation.TextElement;
import com.github.javaparser.utils.LineSeparator;
import java.util.Arrays;
import java.util.List;

public interface CsmElement {

  void prettyPrint(Node node, SourcePrinter printer);

  static CsmElement child(ObservableProperty property) {
    return new CsmSingleReference(property);
  }

  static CsmElement attribute(ObservableProperty property) {
    return new CsmAttribute(property);
  }

  static CsmElement sequence(CsmElement... elements) {
    return new CsmSequence(Arrays.asList(elements));
  }

  static CsmElement string(int tokenType, String content) {
    return new CsmToken(tokenType, content);
  }

  static CsmElement string(int tokenType) {
    return new CsmToken(tokenType);
  }

  static CsmElement stringToken(ObservableProperty property) {
    return new CsmString(property);
  }

  static CsmElement textBlockToken(ObservableProperty property) {
    return new CsmString(property);
  }

  static CsmElement charToken(ObservableProperty property) {
    return new CsmChar(property);
  }

  static CsmElement token(int tokenType) {
    return new CsmToken(tokenType);
  }

  static CsmElement conditional(
      ObservableProperty property, CsmConditional.Condition condition, CsmElement thenElement) {
    return new CsmConditional(property, condition, thenElement);
  }

  static CsmElement conditional(
      ObservableProperty property,
      CsmConditional.Condition condition,
      CsmElement thenElement,
      CsmElement elseElement) {
    return new CsmConditional(property, condition, thenElement, elseElement);
  }

  static CsmElement conditional(
      List<ObservableProperty> properties,
      CsmConditional.Condition condition,
      CsmElement thenElement,
      CsmElement elseElement) {
    return new CsmConditional(properties, condition, thenElement, elseElement);
  }

  static CsmElement space() {
    return new CsmToken(spaceTokenKind(), " ");
  }

  static CsmElement semicolon() {
    return new CsmToken(GeneratedJavaParserConstants.SEMICOLON);
  }

  static CsmElement comment() {
    return new CsmComment();
  }

  static CsmElement newline() {
    return newline(LineSeparator.SYSTEM);
  }

  static CsmElement newline(LineSeparator lineSeparator) {
    return new CsmToken(eolTokenKind(lineSeparator), lineSeparator.asRawString());
  }

  static CsmElement none() {
    return new CsmNone();
  }

  static CsmElement comma() {
    return new CsmToken(GeneratedJavaParserConstants.COMMA);
  }

  static CsmElement list(ObservableProperty property) {
    return new CsmList(property);
  }

  static CsmElement list(ObservableProperty property, CsmElement separator) {
    return new CsmList(property, CsmElement.none(), separator, new CsmNone(), new CsmNone());
  }

  static CsmElement list(
      ObservableProperty property,
      CsmElement separator,
      CsmElement preceeding,
      CsmElement following) {
    return new CsmList(property, none(), separator, preceeding, following);
  }

  static CsmElement list(
      ObservableProperty property,
      CsmElement separatorPre,
      CsmElement separatorPost,
      CsmElement preceeding,
      CsmElement following) {
    return new CsmList(property, separatorPre, separatorPost, preceeding, following);
  }

  static CsmElement orphanCommentsEnding() {
    return new CsmOrphanCommentsEnding();
  }

  static CsmElement orphanCommentsBeforeThis() {
    // FIXME
    return new CsmNone();
  }

  static CsmElement indent() {
    return new CsmIndent();
  }

  static CsmElement unindent() {
    return new CsmUnindent();
  }

  static CsmElement block(CsmElement content) {
    return sequence(
        token(GeneratedJavaParserConstants.LBRACE),
        indent(),
        content,
        unindent(),
        token(GeneratedJavaParserConstants.RBRACE));
  }

  /*
   * Verifies if the content of the {@code CsmElement} is the same as the provided {@code TextElement}
   */
  default boolean isCorrespondingElement(TextElement textElement) {
    return false;
  }
}
