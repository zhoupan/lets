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
 * This interface defines a complete generic visitor for a parse tree produced by {@link VTLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface VTLParserVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link VTLParser#parse}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParse(VTLParser.ParseContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#block}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBlock(VTLParser.BlockContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#atom}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAtom(VTLParser.AtomContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#formal}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFormal(VTLParser.FormalContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#variable}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVariable(VTLParser.VariableContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#property_or_method}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitProperty_or_method(VTLParser.Property_or_methodContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#formal_property_or_method}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFormal_property_or_method(VTLParser.Formal_property_or_methodContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDirective(VTLParser.DirectiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#property_end}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitProperty_end(VTLParser.Property_endContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#expressions}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpressions(VTLParser.ExpressionsContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#set_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSet_directive(VTLParser.Set_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#if_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIf_directive(VTLParser.If_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#elseif_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitElseif_directive(VTLParser.Elseif_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#else_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitElse_directive(VTLParser.Else_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#foreach_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitForeach_directive(VTLParser.Foreach_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#break_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBreak_directive(VTLParser.Break_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#stop_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStop_directive(VTLParser.Stop_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#custom_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCustom_directive(VTLParser.Custom_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#macro_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMacro_directive(VTLParser.Macro_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#parse_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParse_directive(VTLParser.Parse_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#define_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDefine_directive(VTLParser.Define_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#include_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInclude_directive(VTLParser.Include_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#evaluate_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEvaluate_directive(VTLParser.Evaluate_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#macro_call_directive}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMacro_call_directive(VTLParser.Macro_call_directiveContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#end}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnd(VTLParser.EndContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#expression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpression(VTLParser.ExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#list}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitList(VTLParser.ListContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#map}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMap(VTLParser.MapContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#map_entries}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMap_entries(VTLParser.Map_entriesContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#map_entry}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMap_entry(VTLParser.Map_entryContext ctx);

  /**
   * Visit a parse tree produced by {@link VTLParser#id}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitId(VTLParser.IdContext ctx);
}
