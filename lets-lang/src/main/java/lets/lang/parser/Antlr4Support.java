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
package lets.lang.parser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.antlr.v4.runtime.*;

public abstract class Antlr4Support<TLexer extends Lexer, TParser extends Parser> {

  public TParser newParserFromFile(File input) throws IOException {
    return newParser(CharStreams.fromFileName(input.getAbsolutePath()));
  }

  public TParser newParserFromFile(File input, Charset charset) throws IOException {
    return newParser(CharStreams.fromFileName(input.getAbsolutePath(), charset));
  }

  public TParser newParserFromString(String input) {
    return newParser(CharStreams.fromString(input));
  }

  public TParser newParser(CharStream inputStream) {
    TLexer lexer = newLexer(inputStream);
    CommonTokenStream tokenStream = new CommonTokenStream(lexer);
    return this.newParser(tokenStream);
  }

  public abstract TLexer newLexer(CharStream input);

  public abstract TParser newParser(TokenStream input);
}
