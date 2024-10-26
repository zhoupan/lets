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

import org.antlr.v4.runtime.*;

/**
 * All parser methods that used in grammar (p, prev, notLineTerminator, etc.) should start with
 * lower case char similar to parser rules.
 */
public abstract class GoParserBase extends Parser {
  protected GoParserBase(TokenStream input) {
    super(input);
  }

  /** Returns true if the current Token is a closing bracket (")" or "}") */
  protected boolean closingBracket() {
    BufferedTokenStream stream = (BufferedTokenStream) _input;
    int prevTokenType = stream.LA(1);

    return prevTokenType == GoParser.R_CURLY || prevTokenType == GoParser.R_PAREN;
  }
}
