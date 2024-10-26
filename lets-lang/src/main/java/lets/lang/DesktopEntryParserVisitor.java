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
 * DesktopEntryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface DesktopEntryParserVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#desktop_entry}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDesktop_entry(DesktopEntryParser.Desktop_entryContext ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#group}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitGroup(DesktopEntryParser.GroupContext ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#group_header}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitGroup_header(DesktopEntryParser.Group_headerContext ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#group_name}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitGroup_name(DesktopEntryParser.Group_nameContext ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#entry}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEntry(DesktopEntryParser.EntryContext ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#key}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitKey(DesktopEntryParser.KeyContext ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#locale}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLocale(DesktopEntryParser.LocaleContext ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#language_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLanguage_(DesktopEntryParser.Language_Context ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#country}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCountry(DesktopEntryParser.CountryContext ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#encoding}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEncoding(DesktopEntryParser.EncodingContext ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#modifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModifier(DesktopEntryParser.ModifierContext ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue(DesktopEntryParser.ValueContext ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#string_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitString_(DesktopEntryParser.String_Context ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#number}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNumber(DesktopEntryParser.NumberContext ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#true_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTrue_(DesktopEntryParser.True_Context ctx);

  /**
   * Visit a parse tree produced by {@link DesktopEntryParser#false_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFalse_(DesktopEntryParser.False_Context ctx);
}
