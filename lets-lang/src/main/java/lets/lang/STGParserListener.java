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

/** This interface defines a complete listener for a parse tree produced by {@link STGParser}. */
public interface STGParserListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link STGParser#group}.
   *
   * @param ctx the parse tree
   */
  void enterGroup(STGParser.GroupContext ctx);

  /**
   * Exit a parse tree produced by {@link STGParser#group}.
   *
   * @param ctx the parse tree
   */
  void exitGroup(STGParser.GroupContext ctx);

  /**
   * Enter a parse tree produced by {@link STGParser#delimiters}.
   *
   * @param ctx the parse tree
   */
  void enterDelimiters(STGParser.DelimitersContext ctx);

  /**
   * Exit a parse tree produced by {@link STGParser#delimiters}.
   *
   * @param ctx the parse tree
   */
  void exitDelimiters(STGParser.DelimitersContext ctx);

  /**
   * Enter a parse tree produced by {@link STGParser#imports}.
   *
   * @param ctx the parse tree
   */
  void enterImports(STGParser.ImportsContext ctx);

  /**
   * Exit a parse tree produced by {@link STGParser#imports}.
   *
   * @param ctx the parse tree
   */
  void exitImports(STGParser.ImportsContext ctx);

  /**
   * Enter a parse tree produced by {@link STGParser#template_}.
   *
   * @param ctx the parse tree
   */
  void enterTemplate_(STGParser.Template_Context ctx);

  /**
   * Exit a parse tree produced by {@link STGParser#template_}.
   *
   * @param ctx the parse tree
   */
  void exitTemplate_(STGParser.Template_Context ctx);

  /**
   * Enter a parse tree produced by {@link STGParser#formalArgs}.
   *
   * @param ctx the parse tree
   */
  void enterFormalArgs(STGParser.FormalArgsContext ctx);

  /**
   * Exit a parse tree produced by {@link STGParser#formalArgs}.
   *
   * @param ctx the parse tree
   */
  void exitFormalArgs(STGParser.FormalArgsContext ctx);

  /**
   * Enter a parse tree produced by {@link STGParser#formalArg}.
   *
   * @param ctx the parse tree
   */
  void enterFormalArg(STGParser.FormalArgContext ctx);

  /**
   * Exit a parse tree produced by {@link STGParser#formalArg}.
   *
   * @param ctx the parse tree
   */
  void exitFormalArg(STGParser.FormalArgContext ctx);

  /**
   * Enter a parse tree produced by {@link STGParser#dict_}.
   *
   * @param ctx the parse tree
   */
  void enterDict_(STGParser.Dict_Context ctx);

  /**
   * Exit a parse tree produced by {@link STGParser#dict_}.
   *
   * @param ctx the parse tree
   */
  void exitDict_(STGParser.Dict_Context ctx);

  /**
   * Enter a parse tree produced by {@link STGParser#dictPairs}.
   *
   * @param ctx the parse tree
   */
  void enterDictPairs(STGParser.DictPairsContext ctx);

  /**
   * Exit a parse tree produced by {@link STGParser#dictPairs}.
   *
   * @param ctx the parse tree
   */
  void exitDictPairs(STGParser.DictPairsContext ctx);

  /**
   * Enter a parse tree produced by {@link STGParser#keyValuePair}.
   *
   * @param ctx the parse tree
   */
  void enterKeyValuePair(STGParser.KeyValuePairContext ctx);

  /**
   * Exit a parse tree produced by {@link STGParser#keyValuePair}.
   *
   * @param ctx the parse tree
   */
  void exitKeyValuePair(STGParser.KeyValuePairContext ctx);

  /**
   * Enter a parse tree produced by {@link STGParser#defaultValuePair}.
   *
   * @param ctx the parse tree
   */
  void enterDefaultValuePair(STGParser.DefaultValuePairContext ctx);

  /**
   * Exit a parse tree produced by {@link STGParser#defaultValuePair}.
   *
   * @param ctx the parse tree
   */
  void exitDefaultValuePair(STGParser.DefaultValuePairContext ctx);

  /**
   * Enter a parse tree produced by {@link STGParser#keyValue}.
   *
   * @param ctx the parse tree
   */
  void enterKeyValue(STGParser.KeyValueContext ctx);

  /**
   * Exit a parse tree produced by {@link STGParser#keyValue}.
   *
   * @param ctx the parse tree
   */
  void exitKeyValue(STGParser.KeyValueContext ctx);
}
