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
 * WebIDLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface WebIDLVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link WebIDLParser#webIDL}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitWebIDL(WebIDLParser.WebIDLContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#definitions}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDefinitions(WebIDLParser.DefinitionsContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#definition}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDefinition(WebIDLParser.DefinitionContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#argumentNameKeyword}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArgumentNameKeyword(WebIDLParser.ArgumentNameKeywordContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#callbackOrInterfaceOrMixin}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCallbackOrInterfaceOrMixin(WebIDLParser.CallbackOrInterfaceOrMixinContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#interfaceOrMixin}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInterfaceOrMixin(WebIDLParser.InterfaceOrMixinContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#interfaceRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInterfaceRest(WebIDLParser.InterfaceRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#partial}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPartial(WebIDLParser.PartialContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#partialDefinition}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPartialDefinition(WebIDLParser.PartialDefinitionContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#partialInterfaceOrPartialMixin}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPartialInterfaceOrPartialMixin(WebIDLParser.PartialInterfaceOrPartialMixinContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#partialInterfaceRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPartialInterfaceRest(WebIDLParser.PartialInterfaceRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#interfaceMembers}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInterfaceMembers(WebIDLParser.InterfaceMembersContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#interfaceMember}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInterfaceMember(WebIDLParser.InterfaceMemberContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#partialInterfaceMembers}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPartialInterfaceMembers(WebIDLParser.PartialInterfaceMembersContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#partialInterfaceMember}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPartialInterfaceMember(WebIDLParser.PartialInterfaceMemberContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#inheritance}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInheritance(WebIDLParser.InheritanceContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#mixinRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMixinRest(WebIDLParser.MixinRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#mixinMembers}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMixinMembers(WebIDLParser.MixinMembersContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#mixinMember}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMixinMember(WebIDLParser.MixinMemberContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#includesStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIncludesStatement(WebIDLParser.IncludesStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#callbackRestOrInterface}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCallbackRestOrInterface(WebIDLParser.CallbackRestOrInterfaceContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#callbackInterfaceMembers}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCallbackInterfaceMembers(WebIDLParser.CallbackInterfaceMembersContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#callbackInterfaceMember}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCallbackInterfaceMember(WebIDLParser.CallbackInterfaceMemberContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#const_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConst_(WebIDLParser.Const_Context ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#constValue}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstValue(WebIDLParser.ConstValueContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#booleanLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBooleanLiteral(WebIDLParser.BooleanLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#floatLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFloatLiteral(WebIDLParser.FloatLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#constType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstType(WebIDLParser.ConstTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#readonlyMember}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitReadonlyMember(WebIDLParser.ReadonlyMemberContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#readonlyMemberRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitReadonlyMemberRest(WebIDLParser.ReadonlyMemberRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#readWriteAttribute}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitReadWriteAttribute(WebIDLParser.ReadWriteAttributeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#inheritAttribute}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInheritAttribute(WebIDLParser.InheritAttributeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#attributeRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAttributeRest(WebIDLParser.AttributeRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#attributeName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAttributeName(WebIDLParser.AttributeNameContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#attributeNameKeyword}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAttributeNameKeyword(WebIDLParser.AttributeNameKeywordContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#optionalReadOnly}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOptionalReadOnly(WebIDLParser.OptionalReadOnlyContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#defaultValue}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDefaultValue(WebIDLParser.DefaultValueContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#operation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOperation(WebIDLParser.OperationContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#regularOperation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRegularOperation(WebIDLParser.RegularOperationContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#specialOperation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSpecialOperation(WebIDLParser.SpecialOperationContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#special}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSpecial(WebIDLParser.SpecialContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#operationRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOperationRest(WebIDLParser.OperationRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#optionalOperationName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOptionalOperationName(WebIDLParser.OptionalOperationNameContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#operationName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOperationName(WebIDLParser.OperationNameContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#operationNameKeyword}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOperationNameKeyword(WebIDLParser.OperationNameKeywordContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#argumentList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArgumentList(WebIDLParser.ArgumentListContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#arguments}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArguments(WebIDLParser.ArgumentsContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#argument}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArgument(WebIDLParser.ArgumentContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#argumentRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArgumentRest(WebIDLParser.ArgumentRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#argumentName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArgumentName(WebIDLParser.ArgumentNameContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#ellipsis}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEllipsis(WebIDLParser.EllipsisContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#constructor}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstructor(WebIDLParser.ConstructorContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#stringifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStringifier(WebIDLParser.StringifierContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#stringifierRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStringifierRest(WebIDLParser.StringifierRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#staticMember}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStaticMember(WebIDLParser.StaticMemberContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#staticMemberRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStaticMemberRest(WebIDLParser.StaticMemberRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#iterable}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIterable(WebIDLParser.IterableContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#optionalType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOptionalType(WebIDLParser.OptionalTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#asyncIterable}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAsyncIterable(WebIDLParser.AsyncIterableContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#optionalArgumentList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOptionalArgumentList(WebIDLParser.OptionalArgumentListContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#readWriteMaplike}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitReadWriteMaplike(WebIDLParser.ReadWriteMaplikeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#maplikeRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMaplikeRest(WebIDLParser.MaplikeRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#readWriteSetlike}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitReadWriteSetlike(WebIDLParser.ReadWriteSetlikeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#setlikeRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSetlikeRest(WebIDLParser.SetlikeRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#namespace_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNamespace_(WebIDLParser.Namespace_Context ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#namespaceMembers}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNamespaceMembers(WebIDLParser.NamespaceMembersContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#namespaceMember}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNamespaceMember(WebIDLParser.NamespaceMemberContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#dictionary}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDictionary(WebIDLParser.DictionaryContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#dictionaryMembers}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDictionaryMembers(WebIDLParser.DictionaryMembersContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#dictionaryMember}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDictionaryMember(WebIDLParser.DictionaryMemberContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#dictionaryMemberRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDictionaryMemberRest(WebIDLParser.DictionaryMemberRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#partialDictionary}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPartialDictionary(WebIDLParser.PartialDictionaryContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#default_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDefault_(WebIDLParser.Default_Context ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#enum_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnum_(WebIDLParser.Enum_Context ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#enumValueList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnumValueList(WebIDLParser.EnumValueListContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#enumValueListComma}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnumValueListComma(WebIDLParser.EnumValueListCommaContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#enumValueListString}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnumValueListString(WebIDLParser.EnumValueListStringContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#callbackRest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCallbackRest(WebIDLParser.CallbackRestContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#typedef_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypedef_(WebIDLParser.Typedef_Context ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#type_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType_(WebIDLParser.Type_Context ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#typeWithExtendedAttributes}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeWithExtendedAttributes(WebIDLParser.TypeWithExtendedAttributesContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#singleType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSingleType(WebIDLParser.SingleTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#unionType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnionType(WebIDLParser.UnionTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#unionMemberType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnionMemberType(WebIDLParser.UnionMemberTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#unionMemberTypes}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnionMemberTypes(WebIDLParser.UnionMemberTypesContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#distinguishableType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDistinguishableType(WebIDLParser.DistinguishableTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#primitiveType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrimitiveType(WebIDLParser.PrimitiveTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#unrestrictedFloatType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnrestrictedFloatType(WebIDLParser.UnrestrictedFloatTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#floatType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFloatType(WebIDLParser.FloatTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#unsignedIntegerType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnsignedIntegerType(WebIDLParser.UnsignedIntegerTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#integerType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIntegerType(WebIDLParser.IntegerTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#optionalLong}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOptionalLong(WebIDLParser.OptionalLongContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#stringType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStringType(WebIDLParser.StringTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#promiseType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPromiseType(WebIDLParser.PromiseTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#recordType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRecordType(WebIDLParser.RecordTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#null_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNull_(WebIDLParser.Null_Context ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#bufferRelatedType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBufferRelatedType(WebIDLParser.BufferRelatedTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#extendedAttributeList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExtendedAttributeList(WebIDLParser.ExtendedAttributeListContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#extendedAttributes}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExtendedAttributes(WebIDLParser.ExtendedAttributesContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#extendedAttribute}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExtendedAttribute(WebIDLParser.ExtendedAttributeContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#other}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOther(WebIDLParser.OtherContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#otherOrComma}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOtherOrComma(WebIDLParser.OtherOrCommaContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#identifierList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdentifierList(WebIDLParser.IdentifierListContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#identifiers}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdentifiers(WebIDLParser.IdentifiersContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#extendedAttributeNoArgs}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExtendedAttributeNoArgs(WebIDLParser.ExtendedAttributeNoArgsContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#extendedAttributeArgList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExtendedAttributeArgList(WebIDLParser.ExtendedAttributeArgListContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#extendedAttributeIdent}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExtendedAttributeIdent(WebIDLParser.ExtendedAttributeIdentContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#extendedAttributeIdentList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExtendedAttributeIdentList(WebIDLParser.ExtendedAttributeIdentListContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#extendedAttributeNamedArgList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExtendedAttributeNamedArgList(WebIDLParser.ExtendedAttributeNamedArgListContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#extendedAttributeString}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExtendedAttributeString(WebIDLParser.ExtendedAttributeStringContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#extendedAttributeStringList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExtendedAttributeStringList(WebIDLParser.ExtendedAttributeStringListContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#stringList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStringList(WebIDLParser.StringListContext ctx);

  /**
   * Visit a parse tree produced by {@link WebIDLParser#strings}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStrings(WebIDLParser.StringsContext ctx);
}
