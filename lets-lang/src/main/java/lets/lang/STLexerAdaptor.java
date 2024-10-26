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

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;

public abstract class STLexerAdaptor extends Lexer {

  public char lDelim = '<';
  public char rDelim = '>';

  public int subtemplateDepth;

  public STLexerAdaptor(CharStream input) {
    super(input);
  }

  // look for "{ args ID (',' ID)* '|' ..."
  public boolean startsSubTemplate() {
    subtemplateDepth++;
    return false;
  }

  // if last RBrace, continue with mode Outside
  public boolean endsSubTemplate() {
    if (subtemplateDepth > 0) {
      subtemplateDepth--;
      mode(1); // STLexer.Inside
    }
    return true;
  }

  public void setDelimiters(char lDelim, char rDelim) {
    this.lDelim = lDelim;
    this.rDelim = rDelim;
  }

  public boolean isLDelim() {
    return lDelim == _input.LA(1);
  }

  public boolean isRDelim() {
    return rDelim == _input.LA(1);
  }

  public boolean isLTmplComment() {
    return isLDelim() && _input.LA(2) == '!';
  }

  public boolean isRTmplComment() {
    return isRDelim() && _input.LA(-1) == '!';
  }

  public boolean adjText() {
    int c1 = _input.LA(1);
    if (c1 == '\\') {
      int c2 = _input.LA(2);
      if (c2 == '\\') {
        _input.consume(); // convert \\ to \
      } else if (c2 == lDelim || c2 == '}') {
        _input.consume();
      }
    }
    return true;
  }
}
