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

abstract class CSharpLexerBase extends Lexer {
  protected CSharpLexerBase(CharStream input) {
    super(input);
  }

  protected int interpolatedStringLevel;
  protected final Deque<Boolean> interpolatedVerbatiums = new ArrayDeque<>();
  protected final Deque<Integer> curlyLevels = new ArrayDeque<>();
  protected boolean verbatium;

  protected void OnInterpolatedRegularStringStart() {
    interpolatedStringLevel++;
    interpolatedVerbatiums.push(false);
    verbatium = false;
  }

  protected void OnInterpolatedVerbatiumStringStart() {
    interpolatedStringLevel++;
    interpolatedVerbatiums.push(true);
    verbatium = true;
  }

  protected void OnOpenBrace() {
    if (interpolatedStringLevel > 0) {
      curlyLevels.push(curlyLevels.pop() + 1);
    }
  }

  protected void OnCloseBrace() {

    if (interpolatedStringLevel > 0) {
      curlyLevels.push(curlyLevels.pop() - 1);
      if (curlyLevels.peek() == 0) {
        curlyLevels.pop();
        skip();
        popMode();
      }
    }
  }

  protected void OnColon() {

    if (interpolatedStringLevel > 0) {
      int ind = 1;
      boolean switchToFormatString = true;
      while ((char) _input.LA(ind) != '}') {
        if (_input.LA(ind) == ':' || _input.LA(ind) == ')') {
          switchToFormatString = false;
          break;
        }
        ind++;
      }
      if (switchToFormatString) {
        mode(CSharpLexer.INTERPOLATION_FORMAT);
      }
    }
  }

  protected void OpenBraceInside() {
    curlyLevels.push(1);
  }

  protected void OnDoubleQuoteInside() {
    interpolatedStringLevel--;
    interpolatedVerbatiums.pop();
    verbatium = (interpolatedVerbatiums.size() > 0 ? interpolatedVerbatiums.peek() : false);
  }

  protected void OnCloseBraceInside() {
    curlyLevels.pop();
  }

  protected boolean IsRegularCharInside() {
    return !verbatium;
  }

  protected boolean IsVerbatiumDoubleQuoteInside() {
    return verbatium;
  }
}
