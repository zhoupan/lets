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

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link
 * PropertiesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface PropertiesParserVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link PropertiesParser#propertiesFile}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPropertiesFile(PropertiesParser.PropertiesFileContext ctx);

  /**
   * Visit a parse tree produced by {@link PropertiesParser#row}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRow(PropertiesParser.RowContext ctx);

  /**
   * Visit a parse tree produced by {@link PropertiesParser#line}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLine(PropertiesParser.LineContext ctx);

  /**
   * Visit a parse tree produced by {@link PropertiesParser#key}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitKey(PropertiesParser.KeyContext ctx);

  /**
   * Visit a parse tree produced by {@link PropertiesParser#eol}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEol(PropertiesParser.EolContext ctx);

  /**
   * Visit a parse tree produced by {@link PropertiesParser#comment}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComment(PropertiesParser.CommentContext ctx);
}
