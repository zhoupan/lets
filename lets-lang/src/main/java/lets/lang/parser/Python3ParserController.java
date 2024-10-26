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

import com.github.javaparser.ast.CompilationUnit;
import lets.lang.Python3Lexer;
import lets.lang.Python3Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Python3ParserController extends Antlr4Support<Python3Lexer, Python3Parser> {

  protected CompilationUnit compilationUnit = new CompilationUnit();

  public CompilationUnit getCompilationUnit() {
    return compilationUnit;
  }

  public void setCompilationUnit(CompilationUnit compilationUnit) {
    this.compilationUnit = compilationUnit;
  }

  @Override
  public Python3Lexer newLexer(CharStream input) {
    return new Python3Lexer(input);
  }

  @Override
  public Python3Parser newParser(TokenStream input) {
    return new Python3Parser(input);
  }

  public Python3Visitor visit(ParseTree tree) {
    Python3Visitor visitor = new Python3Visitor();
    visitor.visit(tree);
    return visitor;
  }
}
