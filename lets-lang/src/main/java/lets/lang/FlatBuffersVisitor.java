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
 * FlatBuffersParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface FlatBuffersVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#schema}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSchema(FlatBuffersParser.SchemaContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#include_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInclude_(FlatBuffersParser.Include_Context ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#namespace_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNamespace_decl(FlatBuffersParser.Namespace_declContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#attribute_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAttribute_decl(FlatBuffersParser.Attribute_declContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#type_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType_decl(FlatBuffersParser.Type_declContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#enum_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnum_decl(FlatBuffersParser.Enum_declContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#union_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnion_decl(FlatBuffersParser.Union_declContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#root_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRoot_decl(FlatBuffersParser.Root_declContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#field_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitField_decl(FlatBuffersParser.Field_declContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#rpc_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRpc_decl(FlatBuffersParser.Rpc_declContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#rpc_method}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRpc_method(FlatBuffersParser.Rpc_methodContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#type_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType_(FlatBuffersParser.Type_Context ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#enumval_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnumval_decl(FlatBuffersParser.Enumval_declContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#commasep_enumval_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCommasep_enumval_decl(FlatBuffersParser.Commasep_enumval_declContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#unionval_with_opt_alias}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnionval_with_opt_alias(FlatBuffersParser.Unionval_with_opt_aliasContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#commasep_unionval_with_opt_alias}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCommasep_unionval_with_opt_alias(
      FlatBuffersParser.Commasep_unionval_with_opt_aliasContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#ident_with_opt_single_value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdent_with_opt_single_value(FlatBuffersParser.Ident_with_opt_single_valueContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#commasep_ident_with_opt_single_value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCommasep_ident_with_opt_single_value(
      FlatBuffersParser.Commasep_ident_with_opt_single_valueContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#metadata}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMetadata(FlatBuffersParser.MetadataContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#scalar}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitScalar(FlatBuffersParser.ScalarContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#object_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitObject_(FlatBuffersParser.Object_Context ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#ident_with_value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdent_with_value(FlatBuffersParser.Ident_with_valueContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#commasep_ident_with_value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCommasep_ident_with_value(FlatBuffersParser.Commasep_ident_with_valueContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#single_value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSingle_value(FlatBuffersParser.Single_valueContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue(FlatBuffersParser.ValueContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#commasep_value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCommasep_value(FlatBuffersParser.Commasep_valueContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#file_extension_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFile_extension_decl(FlatBuffersParser.File_extension_declContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#file_identifier_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFile_identifier_decl(FlatBuffersParser.File_identifier_declContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#ns_ident}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNs_ident(FlatBuffersParser.Ns_identContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#integer_const}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInteger_const(FlatBuffersParser.Integer_constContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#identifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdentifier(FlatBuffersParser.IdentifierContext ctx);

  /**
   * Visit a parse tree produced by {@link FlatBuffersParser#keywords}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitKeywords(FlatBuffersParser.KeywordsContext ctx);
}
