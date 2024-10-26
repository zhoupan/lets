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

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link GraphQLListener}, which can be extended to
 * create a listener which only needs to handle a subset of the available methods.
 */
@SuppressWarnings("CheckReturnValue")
public class GraphQLBaseListener implements GraphQLListener {
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterDocument(GraphQLParser.DocumentContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitDocument(GraphQLParser.DocumentContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterDefinition(GraphQLParser.DefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitDefinition(GraphQLParser.DefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterExecutableDocument(GraphQLParser.ExecutableDocumentContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitExecutableDocument(GraphQLParser.ExecutableDocumentContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterExecutableDefinition(GraphQLParser.ExecutableDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitExecutableDefinition(GraphQLParser.ExecutableDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterOperationDefinition(GraphQLParser.OperationDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitOperationDefinition(GraphQLParser.OperationDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterOperationType(GraphQLParser.OperationTypeContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitOperationType(GraphQLParser.OperationTypeContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterSelectionSet(GraphQLParser.SelectionSetContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitSelectionSet(GraphQLParser.SelectionSetContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterSelection(GraphQLParser.SelectionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitSelection(GraphQLParser.SelectionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterField(GraphQLParser.FieldContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitField(GraphQLParser.FieldContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterArguments(GraphQLParser.ArgumentsContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitArguments(GraphQLParser.ArgumentsContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterArgument(GraphQLParser.ArgumentContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitArgument(GraphQLParser.ArgumentContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterAlias(GraphQLParser.AliasContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitAlias(GraphQLParser.AliasContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterFragmentSpread(GraphQLParser.FragmentSpreadContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitFragmentSpread(GraphQLParser.FragmentSpreadContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterFragmentDefinition(GraphQLParser.FragmentDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitFragmentDefinition(GraphQLParser.FragmentDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterFragmentName(GraphQLParser.FragmentNameContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitFragmentName(GraphQLParser.FragmentNameContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterTypeCondition(GraphQLParser.TypeConditionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitTypeCondition(GraphQLParser.TypeConditionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterInlineFragment(GraphQLParser.InlineFragmentContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitInlineFragment(GraphQLParser.InlineFragmentContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterValue(GraphQLParser.ValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitValue(GraphQLParser.ValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterIntValue(GraphQLParser.IntValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitIntValue(GraphQLParser.IntValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterFloatValue(GraphQLParser.FloatValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitFloatValue(GraphQLParser.FloatValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterBooleanValue(GraphQLParser.BooleanValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitBooleanValue(GraphQLParser.BooleanValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterStringValue(GraphQLParser.StringValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitStringValue(GraphQLParser.StringValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterNullValue(GraphQLParser.NullValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitNullValue(GraphQLParser.NullValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterEnumValue(GraphQLParser.EnumValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitEnumValue(GraphQLParser.EnumValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterListValue(GraphQLParser.ListValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitListValue(GraphQLParser.ListValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterObjectValue(GraphQLParser.ObjectValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitObjectValue(GraphQLParser.ObjectValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterObjectField(GraphQLParser.ObjectFieldContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitObjectField(GraphQLParser.ObjectFieldContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterVariable(GraphQLParser.VariableContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitVariable(GraphQLParser.VariableContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterVariableDefinitions(GraphQLParser.VariableDefinitionsContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitVariableDefinitions(GraphQLParser.VariableDefinitionsContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterVariableDefinition(GraphQLParser.VariableDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitVariableDefinition(GraphQLParser.VariableDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterDefaultValue(GraphQLParser.DefaultValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitDefaultValue(GraphQLParser.DefaultValueContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterType_(GraphQLParser.Type_Context ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitType_(GraphQLParser.Type_Context ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterNamedType(GraphQLParser.NamedTypeContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitNamedType(GraphQLParser.NamedTypeContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterListType(GraphQLParser.ListTypeContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitListType(GraphQLParser.ListTypeContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterDirectives(GraphQLParser.DirectivesContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitDirectives(GraphQLParser.DirectivesContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterDirective(GraphQLParser.DirectiveContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitDirective(GraphQLParser.DirectiveContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterTypeSystemDocument(GraphQLParser.TypeSystemDocumentContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitTypeSystemDocument(GraphQLParser.TypeSystemDocumentContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterTypeSystemDefinition(GraphQLParser.TypeSystemDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitTypeSystemDefinition(GraphQLParser.TypeSystemDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterTypeSystemExtensionDocument(
      GraphQLParser.TypeSystemExtensionDocumentContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitTypeSystemExtensionDocument(
      GraphQLParser.TypeSystemExtensionDocumentContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterTypeSystemExtension(GraphQLParser.TypeSystemExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitTypeSystemExtension(GraphQLParser.TypeSystemExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterSchemaDefinition(GraphQLParser.SchemaDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitSchemaDefinition(GraphQLParser.SchemaDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterRootOperationTypeDefinition(
      GraphQLParser.RootOperationTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitRootOperationTypeDefinition(
      GraphQLParser.RootOperationTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterSchemaExtension(GraphQLParser.SchemaExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitSchemaExtension(GraphQLParser.SchemaExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterDescription(GraphQLParser.DescriptionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitDescription(GraphQLParser.DescriptionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterTypeDefinition(GraphQLParser.TypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitTypeDefinition(GraphQLParser.TypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterTypeExtension(GraphQLParser.TypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitTypeExtension(GraphQLParser.TypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterScalarTypeDefinition(GraphQLParser.ScalarTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitScalarTypeDefinition(GraphQLParser.ScalarTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterScalarTypeExtension(GraphQLParser.ScalarTypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitScalarTypeExtension(GraphQLParser.ScalarTypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterObjectTypeDefinition(GraphQLParser.ObjectTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitObjectTypeDefinition(GraphQLParser.ObjectTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterImplementsInterfaces(GraphQLParser.ImplementsInterfacesContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitImplementsInterfaces(GraphQLParser.ImplementsInterfacesContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterFieldsDefinition(GraphQLParser.FieldsDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitFieldsDefinition(GraphQLParser.FieldsDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterFieldDefinition(GraphQLParser.FieldDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitFieldDefinition(GraphQLParser.FieldDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterArgumentsDefinition(GraphQLParser.ArgumentsDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitArgumentsDefinition(GraphQLParser.ArgumentsDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterInputValueDefinition(GraphQLParser.InputValueDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitInputValueDefinition(GraphQLParser.InputValueDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterObjectTypeExtension(GraphQLParser.ObjectTypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitObjectTypeExtension(GraphQLParser.ObjectTypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterInterfaceTypeDefinition(GraphQLParser.InterfaceTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitInterfaceTypeDefinition(GraphQLParser.InterfaceTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterInterfaceTypeExtension(GraphQLParser.InterfaceTypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitInterfaceTypeExtension(GraphQLParser.InterfaceTypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterUnionTypeDefinition(GraphQLParser.UnionTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitUnionTypeDefinition(GraphQLParser.UnionTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterUnionMemberTypes(GraphQLParser.UnionMemberTypesContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitUnionMemberTypes(GraphQLParser.UnionMemberTypesContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterUnionTypeExtension(GraphQLParser.UnionTypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitUnionTypeExtension(GraphQLParser.UnionTypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterEnumTypeDefinition(GraphQLParser.EnumTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitEnumTypeDefinition(GraphQLParser.EnumTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterEnumValuesDefinition(GraphQLParser.EnumValuesDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitEnumValuesDefinition(GraphQLParser.EnumValuesDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterEnumValueDefinition(GraphQLParser.EnumValueDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitEnumValueDefinition(GraphQLParser.EnumValueDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterEnumTypeExtension(GraphQLParser.EnumTypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitEnumTypeExtension(GraphQLParser.EnumTypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterInputObjectTypeDefinition(GraphQLParser.InputObjectTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitInputObjectTypeDefinition(GraphQLParser.InputObjectTypeDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterInputFieldsDefinition(GraphQLParser.InputFieldsDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitInputFieldsDefinition(GraphQLParser.InputFieldsDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterInputObjectTypeExtension(GraphQLParser.InputObjectTypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitInputObjectTypeExtension(GraphQLParser.InputObjectTypeExtensionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterDirectiveDefinition(GraphQLParser.DirectiveDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitDirectiveDefinition(GraphQLParser.DirectiveDefinitionContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterDirectiveLocations(GraphQLParser.DirectiveLocationsContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitDirectiveLocations(GraphQLParser.DirectiveLocationsContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterDirectiveLocation(GraphQLParser.DirectiveLocationContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitDirectiveLocation(GraphQLParser.DirectiveLocationContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterExecutableDirectiveLocation(
      GraphQLParser.ExecutableDirectiveLocationContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitExecutableDirectiveLocation(
      GraphQLParser.ExecutableDirectiveLocationContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterTypeSystemDirectiveLocation(
      GraphQLParser.TypeSystemDirectiveLocationContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitTypeSystemDirectiveLocation(
      GraphQLParser.TypeSystemDirectiveLocationContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterName(GraphQLParser.NameContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitName(GraphQLParser.NameContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void enterEveryRule(ParserRuleContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void exitEveryRule(ParserRuleContext ctx) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void visitTerminal(TerminalNode node) {}

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.
   */
  @Override
  public void visitErrorNode(ErrorNode node) {}
}
