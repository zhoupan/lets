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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by {@link PropertiesParser}.
 */
public interface PropertiesParserListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link PropertiesParser#propertiesFile}.
   *
   * @param ctx the parse tree
   */
  void enterPropertiesFile(PropertiesParser.PropertiesFileContext ctx);

  /**
   * Exit a parse tree produced by {@link PropertiesParser#propertiesFile}.
   *
   * @param ctx the parse tree
   */
  void exitPropertiesFile(PropertiesParser.PropertiesFileContext ctx);

  /**
   * Enter a parse tree produced by {@link PropertiesParser#row}.
   *
   * @param ctx the parse tree
   */
  void enterRow(PropertiesParser.RowContext ctx);

  /**
   * Exit a parse tree produced by {@link PropertiesParser#row}.
   *
   * @param ctx the parse tree
   */
  void exitRow(PropertiesParser.RowContext ctx);

  /**
   * Enter a parse tree produced by {@link PropertiesParser#line}.
   *
   * @param ctx the parse tree
   */
  void enterLine(PropertiesParser.LineContext ctx);

  /**
   * Exit a parse tree produced by {@link PropertiesParser#line}.
   *
   * @param ctx the parse tree
   */
  void exitLine(PropertiesParser.LineContext ctx);

  /**
   * Enter a parse tree produced by {@link PropertiesParser#key}.
   *
   * @param ctx the parse tree
   */
  void enterKey(PropertiesParser.KeyContext ctx);

  /**
   * Exit a parse tree produced by {@link PropertiesParser#key}.
   *
   * @param ctx the parse tree
   */
  void exitKey(PropertiesParser.KeyContext ctx);

  /**
   * Enter a parse tree produced by {@link PropertiesParser#eol}.
   *
   * @param ctx the parse tree
   */
  void enterEol(PropertiesParser.EolContext ctx);

  /**
   * Exit a parse tree produced by {@link PropertiesParser#eol}.
   *
   * @param ctx the parse tree
   */
  void exitEol(PropertiesParser.EolContext ctx);

  /**
   * Enter a parse tree produced by {@link PropertiesParser#comment}.
   *
   * @param ctx the parse tree
   */
  void enterComment(PropertiesParser.CommentContext ctx);

  /**
   * Exit a parse tree produced by {@link PropertiesParser#comment}.
   *
   * @param ctx the parse tree
   */
  void exitComment(PropertiesParser.CommentContext ctx);
}
