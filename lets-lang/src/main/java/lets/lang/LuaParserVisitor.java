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
 * This interface defines a complete generic visitor for a parse tree produced by {@link LuaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface LuaParserVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link LuaParser#start_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStart_(LuaParser.Start_Context ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#chunk}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitChunk(LuaParser.ChunkContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#block}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBlock(LuaParser.BlockContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#stat}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStat(LuaParser.StatContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#attnamelist}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAttnamelist(LuaParser.AttnamelistContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#attrib}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAttrib(LuaParser.AttribContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#retstat}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRetstat(LuaParser.RetstatContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#label}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLabel(LuaParser.LabelContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#funcname}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFuncname(LuaParser.FuncnameContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#varlist}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVarlist(LuaParser.VarlistContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#namelist}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNamelist(LuaParser.NamelistContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#explist}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExplist(LuaParser.ExplistContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#exp}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExp(LuaParser.ExpContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#var}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVar(LuaParser.VarContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#prefixexp}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrefixexp(LuaParser.PrefixexpContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#functioncall}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctioncall(LuaParser.FunctioncallContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#args}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArgs(LuaParser.ArgsContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#functiondef}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctiondef(LuaParser.FunctiondefContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#funcbody}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFuncbody(LuaParser.FuncbodyContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#parlist}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParlist(LuaParser.ParlistContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#tableconstructor}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTableconstructor(LuaParser.TableconstructorContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#fieldlist}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFieldlist(LuaParser.FieldlistContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#field}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitField(LuaParser.FieldContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#fieldsep}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFieldsep(LuaParser.FieldsepContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#number}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNumber(LuaParser.NumberContext ctx);

  /**
   * Visit a parse tree produced by {@link LuaParser#string}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitString(LuaParser.StringContext ctx);
}
