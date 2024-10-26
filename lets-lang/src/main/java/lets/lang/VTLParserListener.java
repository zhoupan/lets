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

/** This interface defines a complete listener for a parse tree produced by {@link VTLParser}. */
public interface VTLParserListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link VTLParser#parse}.
   *
   * @param ctx the parse tree
   */
  void enterParse(VTLParser.ParseContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#parse}.
   *
   * @param ctx the parse tree
   */
  void exitParse(VTLParser.ParseContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#block}.
   *
   * @param ctx the parse tree
   */
  void enterBlock(VTLParser.BlockContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#block}.
   *
   * @param ctx the parse tree
   */
  void exitBlock(VTLParser.BlockContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#atom}.
   *
   * @param ctx the parse tree
   */
  void enterAtom(VTLParser.AtomContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#atom}.
   *
   * @param ctx the parse tree
   */
  void exitAtom(VTLParser.AtomContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#formal}.
   *
   * @param ctx the parse tree
   */
  void enterFormal(VTLParser.FormalContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#formal}.
   *
   * @param ctx the parse tree
   */
  void exitFormal(VTLParser.FormalContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#variable}.
   *
   * @param ctx the parse tree
   */
  void enterVariable(VTLParser.VariableContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#variable}.
   *
   * @param ctx the parse tree
   */
  void exitVariable(VTLParser.VariableContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#property_or_method}.
   *
   * @param ctx the parse tree
   */
  void enterProperty_or_method(VTLParser.Property_or_methodContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#property_or_method}.
   *
   * @param ctx the parse tree
   */
  void exitProperty_or_method(VTLParser.Property_or_methodContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#formal_property_or_method}.
   *
   * @param ctx the parse tree
   */
  void enterFormal_property_or_method(VTLParser.Formal_property_or_methodContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#formal_property_or_method}.
   *
   * @param ctx the parse tree
   */
  void exitFormal_property_or_method(VTLParser.Formal_property_or_methodContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#directive}.
   *
   * @param ctx the parse tree
   */
  void enterDirective(VTLParser.DirectiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#directive}.
   *
   * @param ctx the parse tree
   */
  void exitDirective(VTLParser.DirectiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#property_end}.
   *
   * @param ctx the parse tree
   */
  void enterProperty_end(VTLParser.Property_endContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#property_end}.
   *
   * @param ctx the parse tree
   */
  void exitProperty_end(VTLParser.Property_endContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#expressions}.
   *
   * @param ctx the parse tree
   */
  void enterExpressions(VTLParser.ExpressionsContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#expressions}.
   *
   * @param ctx the parse tree
   */
  void exitExpressions(VTLParser.ExpressionsContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#set_directive}.
   *
   * @param ctx the parse tree
   */
  void enterSet_directive(VTLParser.Set_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#set_directive}.
   *
   * @param ctx the parse tree
   */
  void exitSet_directive(VTLParser.Set_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#if_directive}.
   *
   * @param ctx the parse tree
   */
  void enterIf_directive(VTLParser.If_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#if_directive}.
   *
   * @param ctx the parse tree
   */
  void exitIf_directive(VTLParser.If_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#elseif_directive}.
   *
   * @param ctx the parse tree
   */
  void enterElseif_directive(VTLParser.Elseif_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#elseif_directive}.
   *
   * @param ctx the parse tree
   */
  void exitElseif_directive(VTLParser.Elseif_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#else_directive}.
   *
   * @param ctx the parse tree
   */
  void enterElse_directive(VTLParser.Else_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#else_directive}.
   *
   * @param ctx the parse tree
   */
  void exitElse_directive(VTLParser.Else_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#foreach_directive}.
   *
   * @param ctx the parse tree
   */
  void enterForeach_directive(VTLParser.Foreach_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#foreach_directive}.
   *
   * @param ctx the parse tree
   */
  void exitForeach_directive(VTLParser.Foreach_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#break_directive}.
   *
   * @param ctx the parse tree
   */
  void enterBreak_directive(VTLParser.Break_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#break_directive}.
   *
   * @param ctx the parse tree
   */
  void exitBreak_directive(VTLParser.Break_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#stop_directive}.
   *
   * @param ctx the parse tree
   */
  void enterStop_directive(VTLParser.Stop_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#stop_directive}.
   *
   * @param ctx the parse tree
   */
  void exitStop_directive(VTLParser.Stop_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#custom_directive}.
   *
   * @param ctx the parse tree
   */
  void enterCustom_directive(VTLParser.Custom_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#custom_directive}.
   *
   * @param ctx the parse tree
   */
  void exitCustom_directive(VTLParser.Custom_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#macro_directive}.
   *
   * @param ctx the parse tree
   */
  void enterMacro_directive(VTLParser.Macro_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#macro_directive}.
   *
   * @param ctx the parse tree
   */
  void exitMacro_directive(VTLParser.Macro_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#parse_directive}.
   *
   * @param ctx the parse tree
   */
  void enterParse_directive(VTLParser.Parse_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#parse_directive}.
   *
   * @param ctx the parse tree
   */
  void exitParse_directive(VTLParser.Parse_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#define_directive}.
   *
   * @param ctx the parse tree
   */
  void enterDefine_directive(VTLParser.Define_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#define_directive}.
   *
   * @param ctx the parse tree
   */
  void exitDefine_directive(VTLParser.Define_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#include_directive}.
   *
   * @param ctx the parse tree
   */
  void enterInclude_directive(VTLParser.Include_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#include_directive}.
   *
   * @param ctx the parse tree
   */
  void exitInclude_directive(VTLParser.Include_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#evaluate_directive}.
   *
   * @param ctx the parse tree
   */
  void enterEvaluate_directive(VTLParser.Evaluate_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#evaluate_directive}.
   *
   * @param ctx the parse tree
   */
  void exitEvaluate_directive(VTLParser.Evaluate_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#macro_call_directive}.
   *
   * @param ctx the parse tree
   */
  void enterMacro_call_directive(VTLParser.Macro_call_directiveContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#macro_call_directive}.
   *
   * @param ctx the parse tree
   */
  void exitMacro_call_directive(VTLParser.Macro_call_directiveContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#end}.
   *
   * @param ctx the parse tree
   */
  void enterEnd(VTLParser.EndContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#end}.
   *
   * @param ctx the parse tree
   */
  void exitEnd(VTLParser.EndContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#expression}.
   *
   * @param ctx the parse tree
   */
  void enterExpression(VTLParser.ExpressionContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#expression}.
   *
   * @param ctx the parse tree
   */
  void exitExpression(VTLParser.ExpressionContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#list}.
   *
   * @param ctx the parse tree
   */
  void enterList(VTLParser.ListContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#list}.
   *
   * @param ctx the parse tree
   */
  void exitList(VTLParser.ListContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#map}.
   *
   * @param ctx the parse tree
   */
  void enterMap(VTLParser.MapContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#map}.
   *
   * @param ctx the parse tree
   */
  void exitMap(VTLParser.MapContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#map_entries}.
   *
   * @param ctx the parse tree
   */
  void enterMap_entries(VTLParser.Map_entriesContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#map_entries}.
   *
   * @param ctx the parse tree
   */
  void exitMap_entries(VTLParser.Map_entriesContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#map_entry}.
   *
   * @param ctx the parse tree
   */
  void enterMap_entry(VTLParser.Map_entryContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#map_entry}.
   *
   * @param ctx the parse tree
   */
  void exitMap_entry(VTLParser.Map_entryContext ctx);

  /**
   * Enter a parse tree produced by {@link VTLParser#id}.
   *
   * @param ctx the parse tree
   */
  void enterId(VTLParser.IdContext ctx);

  /**
   * Exit a parse tree produced by {@link VTLParser#id}.
   *
   * @param ctx the parse tree
   */
  void exitId(VTLParser.IdContext ctx);
}
