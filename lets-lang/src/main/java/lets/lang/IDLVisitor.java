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
 * This interface defines a complete generic visitor for a parse tree produced by {@link IDLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface IDLVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link IDLParser#specification}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSpecification(IDLParser.SpecificationContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#definition}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDefinition(IDLParser.DefinitionContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#module}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModule(IDLParser.ModuleContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#interface_or_forward_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInterface_or_forward_decl(IDLParser.Interface_or_forward_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#interface_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInterface_decl(IDLParser.Interface_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#forward_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitForward_decl(IDLParser.Forward_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#interface_header}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInterface_header(IDLParser.Interface_headerContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#interface_body}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInterface_body(IDLParser.Interface_bodyContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#export_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExport_(IDLParser.Export_Context ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#interface_inheritance_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInterface_inheritance_spec(IDLParser.Interface_inheritance_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#interface_name}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInterface_name(IDLParser.Interface_nameContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#a_scoped_name}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitA_scoped_name(IDLParser.A_scoped_nameContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#scoped_name}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitScoped_name(IDLParser.Scoped_nameContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue(IDLParser.ValueContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#value_forward_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue_forward_decl(IDLParser.Value_forward_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#value_box_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue_box_decl(IDLParser.Value_box_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#value_abs_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue_abs_decl(IDLParser.Value_abs_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#value_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue_decl(IDLParser.Value_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#value_header}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue_header(IDLParser.Value_headerContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#value_inheritance_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue_inheritance_spec(IDLParser.Value_inheritance_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#value_name}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue_name(IDLParser.Value_nameContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#value_element}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue_element(IDLParser.Value_elementContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#state_member}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitState_member(IDLParser.State_memberContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#init_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInit_decl(IDLParser.Init_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#init_param_decls}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInit_param_decls(IDLParser.Init_param_declsContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#init_param_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInit_param_decl(IDLParser.Init_param_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#init_param_attribute}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInit_param_attribute(IDLParser.Init_param_attributeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#const_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConst_decl(IDLParser.Const_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#const_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConst_type(IDLParser.Const_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#const_exp}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConst_exp(IDLParser.Const_expContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#or_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOr_expr(IDLParser.Or_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#xor_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitXor_expr(IDLParser.Xor_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#and_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnd_expr(IDLParser.And_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#shift_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitShift_expr(IDLParser.Shift_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#add_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAdd_expr(IDLParser.Add_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#mult_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMult_expr(IDLParser.Mult_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#unary_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnary_expr(IDLParser.Unary_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#unary_operator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnary_operator(IDLParser.Unary_operatorContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#primary_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrimary_expr(IDLParser.Primary_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#literal}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteral(IDLParser.LiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#positive_int_const}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPositive_int_const(IDLParser.Positive_int_constContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#type_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType_decl(IDLParser.Type_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#type_declarator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType_declarator(IDLParser.Type_declaratorContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#type_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType_spec(IDLParser.Type_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#simple_type_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSimple_type_spec(IDLParser.Simple_type_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#bitfield_type_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBitfield_type_spec(IDLParser.Bitfield_type_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#base_type_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBase_type_spec(IDLParser.Base_type_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#template_type_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTemplate_type_spec(IDLParser.Template_type_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#constr_type_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstr_type_spec(IDLParser.Constr_type_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#simple_declarators}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSimple_declarators(IDLParser.Simple_declaratorsContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#declarators}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDeclarators(IDLParser.DeclaratorsContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#declarator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDeclarator(IDLParser.DeclaratorContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#simple_declarator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSimple_declarator(IDLParser.Simple_declaratorContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#complex_declarator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComplex_declarator(IDLParser.Complex_declaratorContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#floating_pt_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFloating_pt_type(IDLParser.Floating_pt_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#integer_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInteger_type(IDLParser.Integer_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#signed_int}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSigned_int(IDLParser.Signed_intContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#signed_tiny_int}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSigned_tiny_int(IDLParser.Signed_tiny_intContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#signed_short_int}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSigned_short_int(IDLParser.Signed_short_intContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#signed_long_int}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSigned_long_int(IDLParser.Signed_long_intContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#signed_longlong_int}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSigned_longlong_int(IDLParser.Signed_longlong_intContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#unsigned_int}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnsigned_int(IDLParser.Unsigned_intContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#unsigned_tiny_int}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnsigned_tiny_int(IDLParser.Unsigned_tiny_intContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#unsigned_short_int}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnsigned_short_int(IDLParser.Unsigned_short_intContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#unsigned_long_int}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnsigned_long_int(IDLParser.Unsigned_long_intContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#unsigned_longlong_int}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnsigned_longlong_int(IDLParser.Unsigned_longlong_intContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#char_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitChar_type(IDLParser.Char_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#wide_char_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitWide_char_type(IDLParser.Wide_char_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#boolean_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBoolean_type(IDLParser.Boolean_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#octet_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOctet_type(IDLParser.Octet_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#any_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAny_type(IDLParser.Any_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#object_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitObject_type(IDLParser.Object_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#annotation_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation_decl(IDLParser.Annotation_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#annotation_def}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation_def(IDLParser.Annotation_defContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#annotation_header}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation_header(IDLParser.Annotation_headerContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#annotation_inheritance_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation_inheritance_spec(IDLParser.Annotation_inheritance_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#annotation_body}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation_body(IDLParser.Annotation_bodyContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#annotation_member}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation_member(IDLParser.Annotation_memberContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#annotation_forward_dcl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation_forward_dcl(IDLParser.Annotation_forward_dclContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#bitset_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBitset_type(IDLParser.Bitset_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#bitfield}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBitfield(IDLParser.BitfieldContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#bitfield_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBitfield_spec(IDLParser.Bitfield_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#bitmask_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBitmask_type(IDLParser.Bitmask_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#bit_values}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBit_values(IDLParser.Bit_valuesContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#struct_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStruct_type(IDLParser.Struct_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#member_list}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMember_list(IDLParser.Member_listContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#member}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMember(IDLParser.MemberContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#union_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnion_type(IDLParser.Union_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#switch_type_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSwitch_type_spec(IDLParser.Switch_type_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#switch_body}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSwitch_body(IDLParser.Switch_bodyContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#case_stmt}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCase_stmt(IDLParser.Case_stmtContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#case_label}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCase_label(IDLParser.Case_labelContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#element_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitElement_spec(IDLParser.Element_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#enum_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnum_type(IDLParser.Enum_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#enumerator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnumerator(IDLParser.EnumeratorContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#sequence_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSequence_type(IDLParser.Sequence_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#set_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSet_type(IDLParser.Set_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#map_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMap_type(IDLParser.Map_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#string_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitString_type(IDLParser.String_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#wide_string_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitWide_string_type(IDLParser.Wide_string_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#array_declarator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArray_declarator(IDLParser.Array_declaratorContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#fixed_array_size}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFixed_array_size(IDLParser.Fixed_array_sizeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#attr_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAttr_decl(IDLParser.Attr_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#except_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExcept_decl(IDLParser.Except_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#op_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOp_decl(IDLParser.Op_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#op_attribute}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOp_attribute(IDLParser.Op_attributeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#op_type_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOp_type_spec(IDLParser.Op_type_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#parameter_decls}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParameter_decls(IDLParser.Parameter_declsContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#param_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParam_decl(IDLParser.Param_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#param_attribute}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParam_attribute(IDLParser.Param_attributeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#raises_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRaises_expr(IDLParser.Raises_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#context_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitContext_expr(IDLParser.Context_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#param_type_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParam_type_spec(IDLParser.Param_type_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#fixed_pt_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFixed_pt_type(IDLParser.Fixed_pt_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#fixed_pt_const_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFixed_pt_const_type(IDLParser.Fixed_pt_const_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#value_base_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue_base_type(IDLParser.Value_base_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#constr_forward_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstr_forward_decl(IDLParser.Constr_forward_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#import_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImport_decl(IDLParser.Import_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#imported_scope}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImported_scope(IDLParser.Imported_scopeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#type_id_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType_id_decl(IDLParser.Type_id_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#type_prefix_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType_prefix_decl(IDLParser.Type_prefix_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#readonly_attr_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitReadonly_attr_spec(IDLParser.Readonly_attr_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#readonly_attr_declarator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitReadonly_attr_declarator(IDLParser.Readonly_attr_declaratorContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#attr_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAttr_spec(IDLParser.Attr_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#attr_declarator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAttr_declarator(IDLParser.Attr_declaratorContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#attr_raises_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAttr_raises_expr(IDLParser.Attr_raises_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#get_excep_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitGet_excep_expr(IDLParser.Get_excep_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#set_excep_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSet_excep_expr(IDLParser.Set_excep_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#exception_list}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitException_list(IDLParser.Exception_listContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#component}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComponent(IDLParser.ComponentContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#component_forward_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComponent_forward_decl(IDLParser.Component_forward_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#component_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComponent_decl(IDLParser.Component_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#component_header}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComponent_header(IDLParser.Component_headerContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#supported_interface_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSupported_interface_spec(IDLParser.Supported_interface_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#component_inheritance_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComponent_inheritance_spec(IDLParser.Component_inheritance_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#component_body}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComponent_body(IDLParser.Component_bodyContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#component_export}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComponent_export(IDLParser.Component_exportContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#provides_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitProvides_decl(IDLParser.Provides_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#interface_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInterface_type(IDLParser.Interface_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#uses_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUses_decl(IDLParser.Uses_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#emits_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEmits_decl(IDLParser.Emits_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#publishes_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPublishes_decl(IDLParser.Publishes_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#consumes_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConsumes_decl(IDLParser.Consumes_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#home_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitHome_decl(IDLParser.Home_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#home_header}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitHome_header(IDLParser.Home_headerContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#home_inheritance_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitHome_inheritance_spec(IDLParser.Home_inheritance_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#primary_key_spec}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrimary_key_spec(IDLParser.Primary_key_specContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#home_body}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitHome_body(IDLParser.Home_bodyContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#home_export}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitHome_export(IDLParser.Home_exportContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#factory_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFactory_decl(IDLParser.Factory_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#finder_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFinder_decl(IDLParser.Finder_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#event}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEvent(IDLParser.EventContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#event_forward_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEvent_forward_decl(IDLParser.Event_forward_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#event_abs_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEvent_abs_decl(IDLParser.Event_abs_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#event_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEvent_decl(IDLParser.Event_declContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#event_header}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEvent_header(IDLParser.Event_headerContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#annapps}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnapps(IDLParser.AnnappsContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#annotation_appl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation_appl(IDLParser.Annotation_applContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#annotation_appl_params}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation_appl_params(IDLParser.Annotation_appl_paramsContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#annotation_appl_param}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation_appl_param(IDLParser.Annotation_appl_paramContext ctx);

  /**
   * Visit a parse tree produced by {@link IDLParser#identifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdentifier(IDLParser.IdentifierContext ctx);
}
