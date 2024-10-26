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
 * FlatBuffersParser}.
 */
public interface FlatBuffersListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#schema}.
   *
   * @param ctx the parse tree
   */
  void enterSchema(FlatBuffersParser.SchemaContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#schema}.
   *
   * @param ctx the parse tree
   */
  void exitSchema(FlatBuffersParser.SchemaContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#include_}.
   *
   * @param ctx the parse tree
   */
  void enterInclude_(FlatBuffersParser.Include_Context ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#include_}.
   *
   * @param ctx the parse tree
   */
  void exitInclude_(FlatBuffersParser.Include_Context ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#namespace_decl}.
   *
   * @param ctx the parse tree
   */
  void enterNamespace_decl(FlatBuffersParser.Namespace_declContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#namespace_decl}.
   *
   * @param ctx the parse tree
   */
  void exitNamespace_decl(FlatBuffersParser.Namespace_declContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#attribute_decl}.
   *
   * @param ctx the parse tree
   */
  void enterAttribute_decl(FlatBuffersParser.Attribute_declContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#attribute_decl}.
   *
   * @param ctx the parse tree
   */
  void exitAttribute_decl(FlatBuffersParser.Attribute_declContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#type_decl}.
   *
   * @param ctx the parse tree
   */
  void enterType_decl(FlatBuffersParser.Type_declContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#type_decl}.
   *
   * @param ctx the parse tree
   */
  void exitType_decl(FlatBuffersParser.Type_declContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#enum_decl}.
   *
   * @param ctx the parse tree
   */
  void enterEnum_decl(FlatBuffersParser.Enum_declContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#enum_decl}.
   *
   * @param ctx the parse tree
   */
  void exitEnum_decl(FlatBuffersParser.Enum_declContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#union_decl}.
   *
   * @param ctx the parse tree
   */
  void enterUnion_decl(FlatBuffersParser.Union_declContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#union_decl}.
   *
   * @param ctx the parse tree
   */
  void exitUnion_decl(FlatBuffersParser.Union_declContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#root_decl}.
   *
   * @param ctx the parse tree
   */
  void enterRoot_decl(FlatBuffersParser.Root_declContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#root_decl}.
   *
   * @param ctx the parse tree
   */
  void exitRoot_decl(FlatBuffersParser.Root_declContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#field_decl}.
   *
   * @param ctx the parse tree
   */
  void enterField_decl(FlatBuffersParser.Field_declContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#field_decl}.
   *
   * @param ctx the parse tree
   */
  void exitField_decl(FlatBuffersParser.Field_declContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#rpc_decl}.
   *
   * @param ctx the parse tree
   */
  void enterRpc_decl(FlatBuffersParser.Rpc_declContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#rpc_decl}.
   *
   * @param ctx the parse tree
   */
  void exitRpc_decl(FlatBuffersParser.Rpc_declContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#rpc_method}.
   *
   * @param ctx the parse tree
   */
  void enterRpc_method(FlatBuffersParser.Rpc_methodContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#rpc_method}.
   *
   * @param ctx the parse tree
   */
  void exitRpc_method(FlatBuffersParser.Rpc_methodContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#type_}.
   *
   * @param ctx the parse tree
   */
  void enterType_(FlatBuffersParser.Type_Context ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#type_}.
   *
   * @param ctx the parse tree
   */
  void exitType_(FlatBuffersParser.Type_Context ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#enumval_decl}.
   *
   * @param ctx the parse tree
   */
  void enterEnumval_decl(FlatBuffersParser.Enumval_declContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#enumval_decl}.
   *
   * @param ctx the parse tree
   */
  void exitEnumval_decl(FlatBuffersParser.Enumval_declContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#commasep_enumval_decl}.
   *
   * @param ctx the parse tree
   */
  void enterCommasep_enumval_decl(FlatBuffersParser.Commasep_enumval_declContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#commasep_enumval_decl}.
   *
   * @param ctx the parse tree
   */
  void exitCommasep_enumval_decl(FlatBuffersParser.Commasep_enumval_declContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#unionval_with_opt_alias}.
   *
   * @param ctx the parse tree
   */
  void enterUnionval_with_opt_alias(FlatBuffersParser.Unionval_with_opt_aliasContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#unionval_with_opt_alias}.
   *
   * @param ctx the parse tree
   */
  void exitUnionval_with_opt_alias(FlatBuffersParser.Unionval_with_opt_aliasContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#commasep_unionval_with_opt_alias}.
   *
   * @param ctx the parse tree
   */
  void enterCommasep_unionval_with_opt_alias(
      FlatBuffersParser.Commasep_unionval_with_opt_aliasContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#commasep_unionval_with_opt_alias}.
   *
   * @param ctx the parse tree
   */
  void exitCommasep_unionval_with_opt_alias(
      FlatBuffersParser.Commasep_unionval_with_opt_aliasContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#ident_with_opt_single_value}.
   *
   * @param ctx the parse tree
   */
  void enterIdent_with_opt_single_value(FlatBuffersParser.Ident_with_opt_single_valueContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#ident_with_opt_single_value}.
   *
   * @param ctx the parse tree
   */
  void exitIdent_with_opt_single_value(FlatBuffersParser.Ident_with_opt_single_valueContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#commasep_ident_with_opt_single_value}.
   *
   * @param ctx the parse tree
   */
  void enterCommasep_ident_with_opt_single_value(
      FlatBuffersParser.Commasep_ident_with_opt_single_valueContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#commasep_ident_with_opt_single_value}.
   *
   * @param ctx the parse tree
   */
  void exitCommasep_ident_with_opt_single_value(
      FlatBuffersParser.Commasep_ident_with_opt_single_valueContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#metadata}.
   *
   * @param ctx the parse tree
   */
  void enterMetadata(FlatBuffersParser.MetadataContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#metadata}.
   *
   * @param ctx the parse tree
   */
  void exitMetadata(FlatBuffersParser.MetadataContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#scalar}.
   *
   * @param ctx the parse tree
   */
  void enterScalar(FlatBuffersParser.ScalarContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#scalar}.
   *
   * @param ctx the parse tree
   */
  void exitScalar(FlatBuffersParser.ScalarContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#object_}.
   *
   * @param ctx the parse tree
   */
  void enterObject_(FlatBuffersParser.Object_Context ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#object_}.
   *
   * @param ctx the parse tree
   */
  void exitObject_(FlatBuffersParser.Object_Context ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#ident_with_value}.
   *
   * @param ctx the parse tree
   */
  void enterIdent_with_value(FlatBuffersParser.Ident_with_valueContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#ident_with_value}.
   *
   * @param ctx the parse tree
   */
  void exitIdent_with_value(FlatBuffersParser.Ident_with_valueContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#commasep_ident_with_value}.
   *
   * @param ctx the parse tree
   */
  void enterCommasep_ident_with_value(FlatBuffersParser.Commasep_ident_with_valueContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#commasep_ident_with_value}.
   *
   * @param ctx the parse tree
   */
  void exitCommasep_ident_with_value(FlatBuffersParser.Commasep_ident_with_valueContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#single_value}.
   *
   * @param ctx the parse tree
   */
  void enterSingle_value(FlatBuffersParser.Single_valueContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#single_value}.
   *
   * @param ctx the parse tree
   */
  void exitSingle_value(FlatBuffersParser.Single_valueContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#value}.
   *
   * @param ctx the parse tree
   */
  void enterValue(FlatBuffersParser.ValueContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#value}.
   *
   * @param ctx the parse tree
   */
  void exitValue(FlatBuffersParser.ValueContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#commasep_value}.
   *
   * @param ctx the parse tree
   */
  void enterCommasep_value(FlatBuffersParser.Commasep_valueContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#commasep_value}.
   *
   * @param ctx the parse tree
   */
  void exitCommasep_value(FlatBuffersParser.Commasep_valueContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#file_extension_decl}.
   *
   * @param ctx the parse tree
   */
  void enterFile_extension_decl(FlatBuffersParser.File_extension_declContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#file_extension_decl}.
   *
   * @param ctx the parse tree
   */
  void exitFile_extension_decl(FlatBuffersParser.File_extension_declContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#file_identifier_decl}.
   *
   * @param ctx the parse tree
   */
  void enterFile_identifier_decl(FlatBuffersParser.File_identifier_declContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#file_identifier_decl}.
   *
   * @param ctx the parse tree
   */
  void exitFile_identifier_decl(FlatBuffersParser.File_identifier_declContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#ns_ident}.
   *
   * @param ctx the parse tree
   */
  void enterNs_ident(FlatBuffersParser.Ns_identContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#ns_ident}.
   *
   * @param ctx the parse tree
   */
  void exitNs_ident(FlatBuffersParser.Ns_identContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#integer_const}.
   *
   * @param ctx the parse tree
   */
  void enterInteger_const(FlatBuffersParser.Integer_constContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#integer_const}.
   *
   * @param ctx the parse tree
   */
  void exitInteger_const(FlatBuffersParser.Integer_constContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#identifier}.
   *
   * @param ctx the parse tree
   */
  void enterIdentifier(FlatBuffersParser.IdentifierContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#identifier}.
   *
   * @param ctx the parse tree
   */
  void exitIdentifier(FlatBuffersParser.IdentifierContext ctx);

  /**
   * Enter a parse tree produced by {@link FlatBuffersParser#keywords}.
   *
   * @param ctx the parse tree
   */
  void enterKeywords(FlatBuffersParser.KeywordsContext ctx);

  /**
   * Exit a parse tree produced by {@link FlatBuffersParser#keywords}.
   *
   * @param ctx the parse tree
   */
  void exitKeywords(FlatBuffersParser.KeywordsContext ctx);
}
