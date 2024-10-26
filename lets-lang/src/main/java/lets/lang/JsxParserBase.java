/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
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
package lets.lang;

import java.util.ArrayDeque;
import java.util.Deque;
import org.antlr.v4.runtime.*;

/**
 * All parser methods that used in grammar (p, prev, notLineTerminator, etc.) should start with
 * lower case char similar to parser rules.
 */
public abstract class JsxParserBase extends Parser {
  // 2020/10/27 for jsx
  private final Deque<String> _tagNames = new ArrayDeque<>();

  public JsxParserBase(TokenStream input) {
    super(input);
  }

  /** Short form for prev(String str) */
  protected boolean p(String str) {
    return prev(str);
  }

  /** Whether the previous token value equals to @param str */
  protected boolean prev(String str) {
    return _input.LT(-1).getText().equals(str);
  }

  /** Short form for next(String str) */
  protected boolean n(String str) {
    return next(str);
  }

  /** Whether the next token value equals to @param str */
  protected boolean next(String str) {
    return _input.LT(1).getText().equals(str);
  }

  protected boolean notLineTerminator() {
    return !here(JsxParser.LineTerminator);
  }

  protected boolean notOpenBraceAndNotFunction() {
    int nextTokenType = _input.LT(1).getType();
    return nextTokenType != JsxParser.OpenBrace && nextTokenType != JsxParser.Function_;
  }

  protected boolean closeBrace() {
    return _input.LT(1).getType() == JsxParser.CloseBrace;
  }

  /**
   * Returns {@code true} iff on the current index of the parser's token stream a token of the given
   * {@code type} exists on the {@code HIDDEN} channel.
   *
   * @param type the type of the token on the {@code HIDDEN} channel to check.
   * @return {@code true} iff on the current index of the parser's token stream a token of the given
   *     {@code type} exists on the {@code HIDDEN} channel.
   */
  private boolean here(final int type) {

    // Get the token ahead of the current index.
    int possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 1;
    Token ahead = _input.get(possibleIndexEosToken);

    // Check if the token resides on the HIDDEN channel and if it's of the
    // provided type.
    return (ahead.getChannel() == Lexer.HIDDEN) && (ahead.getType() == type);
  }

  /**
   * Returns {@code true} iff on the current index of the parser's token stream a token exists on
   * the {@code HIDDEN} channel which either is a line terminator, or is a multi line comment that
   * contains a line terminator.
   *
   * @return {@code true} iff on the current index of the parser's token stream a token exists on
   *     the {@code HIDDEN} channel which either is a line terminator, or is a multi line comment
   *     that contains a line terminator.
   */
  protected boolean lineTerminatorAhead() {

    // Get the token ahead of the current index.
    int possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 1;
    Token ahead = _input.get(possibleIndexEosToken);

    if (ahead.getChannel() != Lexer.HIDDEN) {
      // We're only interested in tokens on the HIDDEN channel.
      return false;
    }

    if (ahead.getType() == JsxParser.LineTerminator) {
      // There is definitely a line terminator ahead.
      return true;
    }

    if (ahead.getType() == JsxParser.WhiteSpaces) {
      // Get the token ahead of the current whitespaces.
      possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 2;
      ahead = _input.get(possibleIndexEosToken);
    }

    // Get the token's text and type.
    String text = ahead.getText();
    int type = ahead.getType();

    // Check if the token is, or contains a line terminator.
    return (type == JsxParser.MultiLineComment && (text.contains("\r") || text.contains("\n")))
        || (type == JsxParser.LineTerminator);
  }

  // 2020/10/27 for jsx
  protected void pushHtmlTagName(String tagName) {
    _tagNames.push(tagName);
  }

  protected boolean popHtmlTagName(String tagName) {
    //        return String.Equals(_tagNames.pop(), tagName, StringComparison.InvariantCulture);
    return tagName.equalsIgnoreCase(_tagNames.pop());
  }
}
