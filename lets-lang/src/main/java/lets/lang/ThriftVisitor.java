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
 * ThriftParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface ThriftVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link ThriftParser#document}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDocument(ThriftParser.DocumentContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#header}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitHeader(ThriftParser.HeaderContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#include_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInclude_(ThriftParser.Include_Context ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#namespace_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNamespace_(ThriftParser.Namespace_Context ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#cpp_include}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCpp_include(ThriftParser.Cpp_includeContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#definition}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDefinition(ThriftParser.DefinitionContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#const_rule}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConst_rule(ThriftParser.Const_ruleContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#typedef_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypedef_(ThriftParser.Typedef_Context ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#enum_rule}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnum_rule(ThriftParser.Enum_ruleContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#enum_field}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnum_field(ThriftParser.Enum_fieldContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#senum}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSenum(ThriftParser.SenumContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#struct_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStruct_(ThriftParser.Struct_Context ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#union_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnion_(ThriftParser.Union_Context ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#exception}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitException(ThriftParser.ExceptionContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#service}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitService(ThriftParser.ServiceContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#field}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitField(ThriftParser.FieldContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#field_id}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitField_id(ThriftParser.Field_idContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#field_req}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitField_req(ThriftParser.Field_reqContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#function_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunction_(ThriftParser.Function_Context ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#oneway}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOneway(ThriftParser.OnewayContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#function_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunction_type(ThriftParser.Function_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#throws_list}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitThrows_list(ThriftParser.Throws_listContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#type_annotations}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType_annotations(ThriftParser.Type_annotationsContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#type_annotation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType_annotation(ThriftParser.Type_annotationContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#annotation_value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation_value(ThriftParser.Annotation_valueContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#field_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitField_type(ThriftParser.Field_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#base_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBase_type(ThriftParser.Base_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#container_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitContainer_type(ThriftParser.Container_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#map_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMap_type(ThriftParser.Map_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#set_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSet_type(ThriftParser.Set_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#list_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitList_type(ThriftParser.List_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#cpp_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCpp_type(ThriftParser.Cpp_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#const_value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConst_value(ThriftParser.Const_valueContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#integer}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInteger(ThriftParser.IntegerContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#const_list}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConst_list(ThriftParser.Const_listContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#const_map_entry}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConst_map_entry(ThriftParser.Const_map_entryContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#const_map}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConst_map(ThriftParser.Const_mapContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#list_separator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitList_separator(ThriftParser.List_separatorContext ctx);

  /**
   * Visit a parse tree produced by {@link ThriftParser#real_base_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitReal_base_type(ThriftParser.Real_base_typeContext ctx);
}
