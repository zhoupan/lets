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
 * This interface defines a complete generic visitor for a parse tree produced by {@link STGParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface STGParserVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link STGParser#group}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitGroup(STGParser.GroupContext ctx);

  /**
   * Visit a parse tree produced by {@link STGParser#delimiters}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDelimiters(STGParser.DelimitersContext ctx);

  /**
   * Visit a parse tree produced by {@link STGParser#imports}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImports(STGParser.ImportsContext ctx);

  /**
   * Visit a parse tree produced by {@link STGParser#template_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTemplate_(STGParser.Template_Context ctx);

  /**
   * Visit a parse tree produced by {@link STGParser#formalArgs}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFormalArgs(STGParser.FormalArgsContext ctx);

  /**
   * Visit a parse tree produced by {@link STGParser#formalArg}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFormalArg(STGParser.FormalArgContext ctx);

  /**
   * Visit a parse tree produced by {@link STGParser#dict_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDict_(STGParser.Dict_Context ctx);

  /**
   * Visit a parse tree produced by {@link STGParser#dictPairs}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDictPairs(STGParser.DictPairsContext ctx);

  /**
   * Visit a parse tree produced by {@link STGParser#keyValuePair}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitKeyValuePair(STGParser.KeyValuePairContext ctx);

  /**
   * Visit a parse tree produced by {@link STGParser#defaultValuePair}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDefaultValuePair(STGParser.DefaultValuePairContext ctx);

  /**
   * Visit a parse tree produced by {@link STGParser#keyValue}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitKeyValue(STGParser.KeyValueContext ctx);
}
