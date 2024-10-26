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
 * This interface defines a complete listener for a parse tree produced by {@link
 * DesktopEntryParser}.
 */
public interface DesktopEntryParserListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#desktop_entry}.
   *
   * @param ctx the parse tree
   */
  void enterDesktop_entry(DesktopEntryParser.Desktop_entryContext ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#desktop_entry}.
   *
   * @param ctx the parse tree
   */
  void exitDesktop_entry(DesktopEntryParser.Desktop_entryContext ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#group}.
   *
   * @param ctx the parse tree
   */
  void enterGroup(DesktopEntryParser.GroupContext ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#group}.
   *
   * @param ctx the parse tree
   */
  void exitGroup(DesktopEntryParser.GroupContext ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#group_header}.
   *
   * @param ctx the parse tree
   */
  void enterGroup_header(DesktopEntryParser.Group_headerContext ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#group_header}.
   *
   * @param ctx the parse tree
   */
  void exitGroup_header(DesktopEntryParser.Group_headerContext ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#group_name}.
   *
   * @param ctx the parse tree
   */
  void enterGroup_name(DesktopEntryParser.Group_nameContext ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#group_name}.
   *
   * @param ctx the parse tree
   */
  void exitGroup_name(DesktopEntryParser.Group_nameContext ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#entry}.
   *
   * @param ctx the parse tree
   */
  void enterEntry(DesktopEntryParser.EntryContext ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#entry}.
   *
   * @param ctx the parse tree
   */
  void exitEntry(DesktopEntryParser.EntryContext ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#key}.
   *
   * @param ctx the parse tree
   */
  void enterKey(DesktopEntryParser.KeyContext ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#key}.
   *
   * @param ctx the parse tree
   */
  void exitKey(DesktopEntryParser.KeyContext ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#locale}.
   *
   * @param ctx the parse tree
   */
  void enterLocale(DesktopEntryParser.LocaleContext ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#locale}.
   *
   * @param ctx the parse tree
   */
  void exitLocale(DesktopEntryParser.LocaleContext ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#language_}.
   *
   * @param ctx the parse tree
   */
  void enterLanguage_(DesktopEntryParser.Language_Context ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#language_}.
   *
   * @param ctx the parse tree
   */
  void exitLanguage_(DesktopEntryParser.Language_Context ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#country}.
   *
   * @param ctx the parse tree
   */
  void enterCountry(DesktopEntryParser.CountryContext ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#country}.
   *
   * @param ctx the parse tree
   */
  void exitCountry(DesktopEntryParser.CountryContext ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#encoding}.
   *
   * @param ctx the parse tree
   */
  void enterEncoding(DesktopEntryParser.EncodingContext ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#encoding}.
   *
   * @param ctx the parse tree
   */
  void exitEncoding(DesktopEntryParser.EncodingContext ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#modifier}.
   *
   * @param ctx the parse tree
   */
  void enterModifier(DesktopEntryParser.ModifierContext ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#modifier}.
   *
   * @param ctx the parse tree
   */
  void exitModifier(DesktopEntryParser.ModifierContext ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#value}.
   *
   * @param ctx the parse tree
   */
  void enterValue(DesktopEntryParser.ValueContext ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#value}.
   *
   * @param ctx the parse tree
   */
  void exitValue(DesktopEntryParser.ValueContext ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#string_}.
   *
   * @param ctx the parse tree
   */
  void enterString_(DesktopEntryParser.String_Context ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#string_}.
   *
   * @param ctx the parse tree
   */
  void exitString_(DesktopEntryParser.String_Context ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#number}.
   *
   * @param ctx the parse tree
   */
  void enterNumber(DesktopEntryParser.NumberContext ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#number}.
   *
   * @param ctx the parse tree
   */
  void exitNumber(DesktopEntryParser.NumberContext ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#true_}.
   *
   * @param ctx the parse tree
   */
  void enterTrue_(DesktopEntryParser.True_Context ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#true_}.
   *
   * @param ctx the parse tree
   */
  void exitTrue_(DesktopEntryParser.True_Context ctx);

  /**
   * Enter a parse tree produced by {@link DesktopEntryParser#false_}.
   *
   * @param ctx the parse tree
   */
  void enterFalse_(DesktopEntryParser.False_Context ctx);

  /**
   * Exit a parse tree produced by {@link DesktopEntryParser#false_}.
   *
   * @param ctx the parse tree
   */
  void exitFalse_(DesktopEntryParser.False_Context ctx);
}
