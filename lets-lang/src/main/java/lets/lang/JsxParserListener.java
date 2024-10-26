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

/** This interface defines a complete listener for a parse tree produced by {@link JsxParser}. */
public interface JsxParserListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link JsxParser#program}.
   *
   * @param ctx the parse tree
   */
  void enterProgram(JsxParser.ProgramContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#program}.
   *
   * @param ctx the parse tree
   */
  void exitProgram(JsxParser.ProgramContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#sourceElement}.
   *
   * @param ctx the parse tree
   */
  void enterSourceElement(JsxParser.SourceElementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#sourceElement}.
   *
   * @param ctx the parse tree
   */
  void exitSourceElement(JsxParser.SourceElementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#statement}.
   *
   * @param ctx the parse tree
   */
  void enterStatement(JsxParser.StatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#statement}.
   *
   * @param ctx the parse tree
   */
  void exitStatement(JsxParser.StatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#block}.
   *
   * @param ctx the parse tree
   */
  void enterBlock(JsxParser.BlockContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#block}.
   *
   * @param ctx the parse tree
   */
  void exitBlock(JsxParser.BlockContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#statementList}.
   *
   * @param ctx the parse tree
   */
  void enterStatementList(JsxParser.StatementListContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#statementList}.
   *
   * @param ctx the parse tree
   */
  void exitStatementList(JsxParser.StatementListContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#importStatement}.
   *
   * @param ctx the parse tree
   */
  void enterImportStatement(JsxParser.ImportStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#importStatement}.
   *
   * @param ctx the parse tree
   */
  void exitImportStatement(JsxParser.ImportStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#importFromBlock}.
   *
   * @param ctx the parse tree
   */
  void enterImportFromBlock(JsxParser.ImportFromBlockContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#importFromBlock}.
   *
   * @param ctx the parse tree
   */
  void exitImportFromBlock(JsxParser.ImportFromBlockContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#moduleItems}.
   *
   * @param ctx the parse tree
   */
  void enterModuleItems(JsxParser.ModuleItemsContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#moduleItems}.
   *
   * @param ctx the parse tree
   */
  void exitModuleItems(JsxParser.ModuleItemsContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#importDefault}.
   *
   * @param ctx the parse tree
   */
  void enterImportDefault(JsxParser.ImportDefaultContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#importDefault}.
   *
   * @param ctx the parse tree
   */
  void exitImportDefault(JsxParser.ImportDefaultContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#importNamespace}.
   *
   * @param ctx the parse tree
   */
  void enterImportNamespace(JsxParser.ImportNamespaceContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#importNamespace}.
   *
   * @param ctx the parse tree
   */
  void exitImportNamespace(JsxParser.ImportNamespaceContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#importFrom}.
   *
   * @param ctx the parse tree
   */
  void enterImportFrom(JsxParser.ImportFromContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#importFrom}.
   *
   * @param ctx the parse tree
   */
  void exitImportFrom(JsxParser.ImportFromContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#aliasName}.
   *
   * @param ctx the parse tree
   */
  void enterAliasName(JsxParser.AliasNameContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#aliasName}.
   *
   * @param ctx the parse tree
   */
  void exitAliasName(JsxParser.AliasNameContext ctx);

  /**
   * Enter a parse tree produced by the {@code ExportDeclaration} labeled alternative in {@link
   * JsxParser#exportStatement}.
   *
   * @param ctx the parse tree
   */
  void enterExportDeclaration(JsxParser.ExportDeclarationContext ctx);

  /**
   * Exit a parse tree produced by the {@code ExportDeclaration} labeled alternative in {@link
   * JsxParser#exportStatement}.
   *
   * @param ctx the parse tree
   */
  void exitExportDeclaration(JsxParser.ExportDeclarationContext ctx);

  /**
   * Enter a parse tree produced by the {@code ExportDefaultDeclaration} labeled alternative in
   * {@link JsxParser#exportStatement}.
   *
   * @param ctx the parse tree
   */
  void enterExportDefaultDeclaration(JsxParser.ExportDefaultDeclarationContext ctx);

  /**
   * Exit a parse tree produced by the {@code ExportDefaultDeclaration} labeled alternative in
   * {@link JsxParser#exportStatement}.
   *
   * @param ctx the parse tree
   */
  void exitExportDefaultDeclaration(JsxParser.ExportDefaultDeclarationContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#exportFromBlock}.
   *
   * @param ctx the parse tree
   */
  void enterExportFromBlock(JsxParser.ExportFromBlockContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#exportFromBlock}.
   *
   * @param ctx the parse tree
   */
  void exitExportFromBlock(JsxParser.ExportFromBlockContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#declaration}.
   *
   * @param ctx the parse tree
   */
  void enterDeclaration(JsxParser.DeclarationContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#declaration}.
   *
   * @param ctx the parse tree
   */
  void exitDeclaration(JsxParser.DeclarationContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#variableStatement}.
   *
   * @param ctx the parse tree
   */
  void enterVariableStatement(JsxParser.VariableStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#variableStatement}.
   *
   * @param ctx the parse tree
   */
  void exitVariableStatement(JsxParser.VariableStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#variableDeclarationList}.
   *
   * @param ctx the parse tree
   */
  void enterVariableDeclarationList(JsxParser.VariableDeclarationListContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#variableDeclarationList}.
   *
   * @param ctx the parse tree
   */
  void exitVariableDeclarationList(JsxParser.VariableDeclarationListContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#variableDeclaration}.
   *
   * @param ctx the parse tree
   */
  void enterVariableDeclaration(JsxParser.VariableDeclarationContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#variableDeclaration}.
   *
   * @param ctx the parse tree
   */
  void exitVariableDeclaration(JsxParser.VariableDeclarationContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#emptyStatement_}.
   *
   * @param ctx the parse tree
   */
  void enterEmptyStatement_(JsxParser.EmptyStatement_Context ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#emptyStatement_}.
   *
   * @param ctx the parse tree
   */
  void exitEmptyStatement_(JsxParser.EmptyStatement_Context ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#expressionStatement}.
   *
   * @param ctx the parse tree
   */
  void enterExpressionStatement(JsxParser.ExpressionStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#expressionStatement}.
   *
   * @param ctx the parse tree
   */
  void exitExpressionStatement(JsxParser.ExpressionStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#ifStatement}.
   *
   * @param ctx the parse tree
   */
  void enterIfStatement(JsxParser.IfStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#ifStatement}.
   *
   * @param ctx the parse tree
   */
  void exitIfStatement(JsxParser.IfStatementContext ctx);

  /**
   * Enter a parse tree produced by the {@code DoStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   */
  void enterDoStatement(JsxParser.DoStatementContext ctx);

  /**
   * Exit a parse tree produced by the {@code DoStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   */
  void exitDoStatement(JsxParser.DoStatementContext ctx);

  /**
   * Enter a parse tree produced by the {@code WhileStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   */
  void enterWhileStatement(JsxParser.WhileStatementContext ctx);

  /**
   * Exit a parse tree produced by the {@code WhileStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   */
  void exitWhileStatement(JsxParser.WhileStatementContext ctx);

  /**
   * Enter a parse tree produced by the {@code ForStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   */
  void enterForStatement(JsxParser.ForStatementContext ctx);

  /**
   * Exit a parse tree produced by the {@code ForStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   */
  void exitForStatement(JsxParser.ForStatementContext ctx);

  /**
   * Enter a parse tree produced by the {@code ForInStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   */
  void enterForInStatement(JsxParser.ForInStatementContext ctx);

  /**
   * Exit a parse tree produced by the {@code ForInStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   */
  void exitForInStatement(JsxParser.ForInStatementContext ctx);

  /**
   * Enter a parse tree produced by the {@code ForOfStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   */
  void enterForOfStatement(JsxParser.ForOfStatementContext ctx);

  /**
   * Exit a parse tree produced by the {@code ForOfStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   */
  void exitForOfStatement(JsxParser.ForOfStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#varModifier}.
   *
   * @param ctx the parse tree
   */
  void enterVarModifier(JsxParser.VarModifierContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#varModifier}.
   *
   * @param ctx the parse tree
   */
  void exitVarModifier(JsxParser.VarModifierContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#continueStatement}.
   *
   * @param ctx the parse tree
   */
  void enterContinueStatement(JsxParser.ContinueStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#continueStatement}.
   *
   * @param ctx the parse tree
   */
  void exitContinueStatement(JsxParser.ContinueStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#breakStatement}.
   *
   * @param ctx the parse tree
   */
  void enterBreakStatement(JsxParser.BreakStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#breakStatement}.
   *
   * @param ctx the parse tree
   */
  void exitBreakStatement(JsxParser.BreakStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#returnStatement}.
   *
   * @param ctx the parse tree
   */
  void enterReturnStatement(JsxParser.ReturnStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#returnStatement}.
   *
   * @param ctx the parse tree
   */
  void exitReturnStatement(JsxParser.ReturnStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#yieldStatement}.
   *
   * @param ctx the parse tree
   */
  void enterYieldStatement(JsxParser.YieldStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#yieldStatement}.
   *
   * @param ctx the parse tree
   */
  void exitYieldStatement(JsxParser.YieldStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#withStatement}.
   *
   * @param ctx the parse tree
   */
  void enterWithStatement(JsxParser.WithStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#withStatement}.
   *
   * @param ctx the parse tree
   */
  void exitWithStatement(JsxParser.WithStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#switchStatement}.
   *
   * @param ctx the parse tree
   */
  void enterSwitchStatement(JsxParser.SwitchStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#switchStatement}.
   *
   * @param ctx the parse tree
   */
  void exitSwitchStatement(JsxParser.SwitchStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#caseBlock}.
   *
   * @param ctx the parse tree
   */
  void enterCaseBlock(JsxParser.CaseBlockContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#caseBlock}.
   *
   * @param ctx the parse tree
   */
  void exitCaseBlock(JsxParser.CaseBlockContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#caseClauses}.
   *
   * @param ctx the parse tree
   */
  void enterCaseClauses(JsxParser.CaseClausesContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#caseClauses}.
   *
   * @param ctx the parse tree
   */
  void exitCaseClauses(JsxParser.CaseClausesContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#caseClause}.
   *
   * @param ctx the parse tree
   */
  void enterCaseClause(JsxParser.CaseClauseContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#caseClause}.
   *
   * @param ctx the parse tree
   */
  void exitCaseClause(JsxParser.CaseClauseContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#defaultClause}.
   *
   * @param ctx the parse tree
   */
  void enterDefaultClause(JsxParser.DefaultClauseContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#defaultClause}.
   *
   * @param ctx the parse tree
   */
  void exitDefaultClause(JsxParser.DefaultClauseContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#labelledStatement}.
   *
   * @param ctx the parse tree
   */
  void enterLabelledStatement(JsxParser.LabelledStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#labelledStatement}.
   *
   * @param ctx the parse tree
   */
  void exitLabelledStatement(JsxParser.LabelledStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#throwStatement}.
   *
   * @param ctx the parse tree
   */
  void enterThrowStatement(JsxParser.ThrowStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#throwStatement}.
   *
   * @param ctx the parse tree
   */
  void exitThrowStatement(JsxParser.ThrowStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#tryStatement}.
   *
   * @param ctx the parse tree
   */
  void enterTryStatement(JsxParser.TryStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#tryStatement}.
   *
   * @param ctx the parse tree
   */
  void exitTryStatement(JsxParser.TryStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#catchProduction}.
   *
   * @param ctx the parse tree
   */
  void enterCatchProduction(JsxParser.CatchProductionContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#catchProduction}.
   *
   * @param ctx the parse tree
   */
  void exitCatchProduction(JsxParser.CatchProductionContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#finallyProduction}.
   *
   * @param ctx the parse tree
   */
  void enterFinallyProduction(JsxParser.FinallyProductionContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#finallyProduction}.
   *
   * @param ctx the parse tree
   */
  void exitFinallyProduction(JsxParser.FinallyProductionContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#debuggerStatement}.
   *
   * @param ctx the parse tree
   */
  void enterDebuggerStatement(JsxParser.DebuggerStatementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#debuggerStatement}.
   *
   * @param ctx the parse tree
   */
  void exitDebuggerStatement(JsxParser.DebuggerStatementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#functionDeclaration}.
   *
   * @param ctx the parse tree
   */
  void enterFunctionDeclaration(JsxParser.FunctionDeclarationContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#functionDeclaration}.
   *
   * @param ctx the parse tree
   */
  void exitFunctionDeclaration(JsxParser.FunctionDeclarationContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#classDeclaration}.
   *
   * @param ctx the parse tree
   */
  void enterClassDeclaration(JsxParser.ClassDeclarationContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#classDeclaration}.
   *
   * @param ctx the parse tree
   */
  void exitClassDeclaration(JsxParser.ClassDeclarationContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#classTail}.
   *
   * @param ctx the parse tree
   */
  void enterClassTail(JsxParser.ClassTailContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#classTail}.
   *
   * @param ctx the parse tree
   */
  void exitClassTail(JsxParser.ClassTailContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#classElement}.
   *
   * @param ctx the parse tree
   */
  void enterClassElement(JsxParser.ClassElementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#classElement}.
   *
   * @param ctx the parse tree
   */
  void exitClassElement(JsxParser.ClassElementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#methodDefinition}.
   *
   * @param ctx the parse tree
   */
  void enterMethodDefinition(JsxParser.MethodDefinitionContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#methodDefinition}.
   *
   * @param ctx the parse tree
   */
  void exitMethodDefinition(JsxParser.MethodDefinitionContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#formalParameterList}.
   *
   * @param ctx the parse tree
   */
  void enterFormalParameterList(JsxParser.FormalParameterListContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#formalParameterList}.
   *
   * @param ctx the parse tree
   */
  void exitFormalParameterList(JsxParser.FormalParameterListContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#formalParameterArg}.
   *
   * @param ctx the parse tree
   */
  void enterFormalParameterArg(JsxParser.FormalParameterArgContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#formalParameterArg}.
   *
   * @param ctx the parse tree
   */
  void exitFormalParameterArg(JsxParser.FormalParameterArgContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#lastFormalParameterArg}.
   *
   * @param ctx the parse tree
   */
  void enterLastFormalParameterArg(JsxParser.LastFormalParameterArgContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#lastFormalParameterArg}.
   *
   * @param ctx the parse tree
   */
  void exitLastFormalParameterArg(JsxParser.LastFormalParameterArgContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#functionBody}.
   *
   * @param ctx the parse tree
   */
  void enterFunctionBody(JsxParser.FunctionBodyContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#functionBody}.
   *
   * @param ctx the parse tree
   */
  void exitFunctionBody(JsxParser.FunctionBodyContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#sourceElements}.
   *
   * @param ctx the parse tree
   */
  void enterSourceElements(JsxParser.SourceElementsContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#sourceElements}.
   *
   * @param ctx the parse tree
   */
  void exitSourceElements(JsxParser.SourceElementsContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#arrayLiteral}.
   *
   * @param ctx the parse tree
   */
  void enterArrayLiteral(JsxParser.ArrayLiteralContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#arrayLiteral}.
   *
   * @param ctx the parse tree
   */
  void exitArrayLiteral(JsxParser.ArrayLiteralContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#elementList}.
   *
   * @param ctx the parse tree
   */
  void enterElementList(JsxParser.ElementListContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#elementList}.
   *
   * @param ctx the parse tree
   */
  void exitElementList(JsxParser.ElementListContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#arrayElement}.
   *
   * @param ctx the parse tree
   */
  void enterArrayElement(JsxParser.ArrayElementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#arrayElement}.
   *
   * @param ctx the parse tree
   */
  void exitArrayElement(JsxParser.ArrayElementContext ctx);

  /**
   * Enter a parse tree produced by the {@code PropertyExpressionAssignment} labeled alternative in
   * {@link JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   */
  void enterPropertyExpressionAssignment(JsxParser.PropertyExpressionAssignmentContext ctx);

  /**
   * Exit a parse tree produced by the {@code PropertyExpressionAssignment} labeled alternative in
   * {@link JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   */
  void exitPropertyExpressionAssignment(JsxParser.PropertyExpressionAssignmentContext ctx);

  /**
   * Enter a parse tree produced by the {@code ComputedPropertyExpressionAssignment} labeled
   * alternative in {@link JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   */
  void enterComputedPropertyExpressionAssignment(
      JsxParser.ComputedPropertyExpressionAssignmentContext ctx);

  /**
   * Exit a parse tree produced by the {@code ComputedPropertyExpressionAssignment} labeled
   * alternative in {@link JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   */
  void exitComputedPropertyExpressionAssignment(
      JsxParser.ComputedPropertyExpressionAssignmentContext ctx);

  /**
   * Enter a parse tree produced by the {@code FunctionProperty} labeled alternative in {@link
   * JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   */
  void enterFunctionProperty(JsxParser.FunctionPropertyContext ctx);

  /**
   * Exit a parse tree produced by the {@code FunctionProperty} labeled alternative in {@link
   * JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   */
  void exitFunctionProperty(JsxParser.FunctionPropertyContext ctx);

  /**
   * Enter a parse tree produced by the {@code PropertyGetter} labeled alternative in {@link
   * JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   */
  void enterPropertyGetter(JsxParser.PropertyGetterContext ctx);

  /**
   * Exit a parse tree produced by the {@code PropertyGetter} labeled alternative in {@link
   * JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   */
  void exitPropertyGetter(JsxParser.PropertyGetterContext ctx);

  /**
   * Enter a parse tree produced by the {@code PropertySetter} labeled alternative in {@link
   * JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   */
  void enterPropertySetter(JsxParser.PropertySetterContext ctx);

  /**
   * Exit a parse tree produced by the {@code PropertySetter} labeled alternative in {@link
   * JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   */
  void exitPropertySetter(JsxParser.PropertySetterContext ctx);

  /**
   * Enter a parse tree produced by the {@code PropertyShorthand} labeled alternative in {@link
   * JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   */
  void enterPropertyShorthand(JsxParser.PropertyShorthandContext ctx);

  /**
   * Exit a parse tree produced by the {@code PropertyShorthand} labeled alternative in {@link
   * JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   */
  void exitPropertyShorthand(JsxParser.PropertyShorthandContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#propertyName}.
   *
   * @param ctx the parse tree
   */
  void enterPropertyName(JsxParser.PropertyNameContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#propertyName}.
   *
   * @param ctx the parse tree
   */
  void exitPropertyName(JsxParser.PropertyNameContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#arguments}.
   *
   * @param ctx the parse tree
   */
  void enterArguments(JsxParser.ArgumentsContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#arguments}.
   *
   * @param ctx the parse tree
   */
  void exitArguments(JsxParser.ArgumentsContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#argument}.
   *
   * @param ctx the parse tree
   */
  void enterArgument(JsxParser.ArgumentContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#argument}.
   *
   * @param ctx the parse tree
   */
  void exitArgument(JsxParser.ArgumentContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#expressionSequence}.
   *
   * @param ctx the parse tree
   */
  void enterExpressionSequence(JsxParser.ExpressionSequenceContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#expressionSequence}.
   *
   * @param ctx the parse tree
   */
  void exitExpressionSequence(JsxParser.ExpressionSequenceContext ctx);

  /**
   * Enter a parse tree produced by the {@code TemplateStringExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterTemplateStringExpression(JsxParser.TemplateStringExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code TemplateStringExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitTemplateStringExpression(JsxParser.TemplateStringExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code TernaryExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterTernaryExpression(JsxParser.TernaryExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code TernaryExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitTernaryExpression(JsxParser.TernaryExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code LogicalAndExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterLogicalAndExpression(JsxParser.LogicalAndExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code LogicalAndExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitLogicalAndExpression(JsxParser.LogicalAndExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code PowerExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterPowerExpression(JsxParser.PowerExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code PowerExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitPowerExpression(JsxParser.PowerExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code PreIncrementExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterPreIncrementExpression(JsxParser.PreIncrementExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code PreIncrementExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitPreIncrementExpression(JsxParser.PreIncrementExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code ObjectLiteralExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterObjectLiteralExpression(JsxParser.ObjectLiteralExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code ObjectLiteralExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitObjectLiteralExpression(JsxParser.ObjectLiteralExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code MetaExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterMetaExpression(JsxParser.MetaExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code MetaExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitMetaExpression(JsxParser.MetaExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code InExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterInExpression(JsxParser.InExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code InExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitInExpression(JsxParser.InExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code LogicalOrExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterLogicalOrExpression(JsxParser.LogicalOrExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code LogicalOrExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitLogicalOrExpression(JsxParser.LogicalOrExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code NotExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterNotExpression(JsxParser.NotExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code NotExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitNotExpression(JsxParser.NotExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code PreDecreaseExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterPreDecreaseExpression(JsxParser.PreDecreaseExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code PreDecreaseExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitPreDecreaseExpression(JsxParser.PreDecreaseExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code jsxElementExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterJsxElementExpression(JsxParser.JsxElementExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code jsxElementExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitJsxElementExpression(JsxParser.JsxElementExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code ArgumentsExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterArgumentsExpression(JsxParser.ArgumentsExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code ArgumentsExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitArgumentsExpression(JsxParser.ArgumentsExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code AwaitExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterAwaitExpression(JsxParser.AwaitExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code AwaitExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitAwaitExpression(JsxParser.AwaitExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code ThisExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterThisExpression(JsxParser.ThisExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code ThisExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitThisExpression(JsxParser.ThisExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code FunctionExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterFunctionExpression(JsxParser.FunctionExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code FunctionExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitFunctionExpression(JsxParser.FunctionExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code UnaryMinusExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterUnaryMinusExpression(JsxParser.UnaryMinusExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code UnaryMinusExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitUnaryMinusExpression(JsxParser.UnaryMinusExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code AssignmentExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterAssignmentExpression(JsxParser.AssignmentExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code AssignmentExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitAssignmentExpression(JsxParser.AssignmentExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code PostDecreaseExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterPostDecreaseExpression(JsxParser.PostDecreaseExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code PostDecreaseExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitPostDecreaseExpression(JsxParser.PostDecreaseExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code TypeofExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterTypeofExpression(JsxParser.TypeofExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code TypeofExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitTypeofExpression(JsxParser.TypeofExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code InstanceofExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterInstanceofExpression(JsxParser.InstanceofExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code InstanceofExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitInstanceofExpression(JsxParser.InstanceofExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code UnaryPlusExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterUnaryPlusExpression(JsxParser.UnaryPlusExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code UnaryPlusExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitUnaryPlusExpression(JsxParser.UnaryPlusExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code DeleteExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterDeleteExpression(JsxParser.DeleteExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code DeleteExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitDeleteExpression(JsxParser.DeleteExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code ImportExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterImportExpression(JsxParser.ImportExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code ImportExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitImportExpression(JsxParser.ImportExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code EqualityExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterEqualityExpression(JsxParser.EqualityExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code EqualityExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitEqualityExpression(JsxParser.EqualityExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code BitXOrExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterBitXOrExpression(JsxParser.BitXOrExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code BitXOrExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitBitXOrExpression(JsxParser.BitXOrExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code SuperExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterSuperExpression(JsxParser.SuperExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code SuperExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitSuperExpression(JsxParser.SuperExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code MultiplicativeExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterMultiplicativeExpression(JsxParser.MultiplicativeExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code MultiplicativeExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitMultiplicativeExpression(JsxParser.MultiplicativeExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code BitShiftExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterBitShiftExpression(JsxParser.BitShiftExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code BitShiftExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitBitShiftExpression(JsxParser.BitShiftExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code ParenthesizedExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterParenthesizedExpression(JsxParser.ParenthesizedExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code ParenthesizedExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitParenthesizedExpression(JsxParser.ParenthesizedExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code AdditiveExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterAdditiveExpression(JsxParser.AdditiveExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code AdditiveExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitAdditiveExpression(JsxParser.AdditiveExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code RelationalExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterRelationalExpression(JsxParser.RelationalExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code RelationalExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitRelationalExpression(JsxParser.RelationalExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code PostIncrementExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterPostIncrementExpression(JsxParser.PostIncrementExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code PostIncrementExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitPostIncrementExpression(JsxParser.PostIncrementExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code YieldExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterYieldExpression(JsxParser.YieldExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code YieldExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitYieldExpression(JsxParser.YieldExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code BitNotExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterBitNotExpression(JsxParser.BitNotExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code BitNotExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitBitNotExpression(JsxParser.BitNotExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code NewExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterNewExpression(JsxParser.NewExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code NewExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitNewExpression(JsxParser.NewExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code LiteralExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterLiteralExpression(JsxParser.LiteralExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code LiteralExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitLiteralExpression(JsxParser.LiteralExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code ArrayLiteralExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterArrayLiteralExpression(JsxParser.ArrayLiteralExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code ArrayLiteralExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitArrayLiteralExpression(JsxParser.ArrayLiteralExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code MemberDotExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterMemberDotExpression(JsxParser.MemberDotExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code MemberDotExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitMemberDotExpression(JsxParser.MemberDotExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code ClassExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterClassExpression(JsxParser.ClassExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code ClassExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitClassExpression(JsxParser.ClassExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code MemberIndexExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterMemberIndexExpression(JsxParser.MemberIndexExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code MemberIndexExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitMemberIndexExpression(JsxParser.MemberIndexExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code IdentifierExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterIdentifierExpression(JsxParser.IdentifierExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code IdentifierExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitIdentifierExpression(JsxParser.IdentifierExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code BitAndExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterBitAndExpression(JsxParser.BitAndExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code BitAndExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitBitAndExpression(JsxParser.BitAndExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code BitOrExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterBitOrExpression(JsxParser.BitOrExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code BitOrExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitBitOrExpression(JsxParser.BitOrExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code AssignmentOperatorExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterAssignmentOperatorExpression(JsxParser.AssignmentOperatorExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code AssignmentOperatorExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitAssignmentOperatorExpression(JsxParser.AssignmentOperatorExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code VoidExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterVoidExpression(JsxParser.VoidExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code VoidExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitVoidExpression(JsxParser.VoidExpressionContext ctx);

  /**
   * Enter a parse tree produced by the {@code CoalesceExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void enterCoalesceExpression(JsxParser.CoalesceExpressionContext ctx);

  /**
   * Exit a parse tree produced by the {@code CoalesceExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   */
  void exitCoalesceExpression(JsxParser.CoalesceExpressionContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxElements}.
   *
   * @param ctx the parse tree
   */
  void enterJsxElements(JsxParser.JsxElementsContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxElements}.
   *
   * @param ctx the parse tree
   */
  void exitJsxElements(JsxParser.JsxElementsContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxElementBegin}.
   *
   * @param ctx the parse tree
   */
  void enterJsxElementBegin(JsxParser.JsxElementBeginContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxElementBegin}.
   *
   * @param ctx the parse tree
   */
  void exitJsxElementBegin(JsxParser.JsxElementBeginContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxElement}.
   *
   * @param ctx the parse tree
   */
  void enterJsxElement(JsxParser.JsxElementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxElement}.
   *
   * @param ctx the parse tree
   */
  void exitJsxElement(JsxParser.JsxElementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxSelfClosingElement}.
   *
   * @param ctx the parse tree
   */
  void enterJsxSelfClosingElement(JsxParser.JsxSelfClosingElementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxSelfClosingElement}.
   *
   * @param ctx the parse tree
   */
  void exitJsxSelfClosingElement(JsxParser.JsxSelfClosingElementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxOpeningElement}.
   *
   * @param ctx the parse tree
   */
  void enterJsxOpeningElement(JsxParser.JsxOpeningElementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxOpeningElement}.
   *
   * @param ctx the parse tree
   */
  void exitJsxOpeningElement(JsxParser.JsxOpeningElementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxClosingElement}.
   *
   * @param ctx the parse tree
   */
  void enterJsxClosingElement(JsxParser.JsxClosingElementContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxClosingElement}.
   *
   * @param ctx the parse tree
   */
  void exitJsxClosingElement(JsxParser.JsxClosingElementContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxChildren}.
   *
   * @param ctx the parse tree
   */
  void enterJsxChildren(JsxParser.JsxChildrenContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxChildren}.
   *
   * @param ctx the parse tree
   */
  void exitJsxChildren(JsxParser.JsxChildrenContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxSelfClosingElementName}.
   *
   * @param ctx the parse tree
   */
  void enterJsxSelfClosingElementName(JsxParser.JsxSelfClosingElementNameContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxSelfClosingElementName}.
   *
   * @param ctx the parse tree
   */
  void exitJsxSelfClosingElementName(JsxParser.JsxSelfClosingElementNameContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxOpeningElementName}.
   *
   * @param ctx the parse tree
   */
  void enterJsxOpeningElementName(JsxParser.JsxOpeningElementNameContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxOpeningElementName}.
   *
   * @param ctx the parse tree
   */
  void exitJsxOpeningElementName(JsxParser.JsxOpeningElementNameContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxClosingElementName}.
   *
   * @param ctx the parse tree
   */
  void enterJsxClosingElementName(JsxParser.JsxClosingElementNameContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxClosingElementName}.
   *
   * @param ctx the parse tree
   */
  void exitJsxClosingElementName(JsxParser.JsxClosingElementNameContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxAttributes}.
   *
   * @param ctx the parse tree
   */
  void enterJsxAttributes(JsxParser.JsxAttributesContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxAttributes}.
   *
   * @param ctx the parse tree
   */
  void exitJsxAttributes(JsxParser.JsxAttributesContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxSpreadAttribute}.
   *
   * @param ctx the parse tree
   */
  void enterJsxSpreadAttribute(JsxParser.JsxSpreadAttributeContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxSpreadAttribute}.
   *
   * @param ctx the parse tree
   */
  void exitJsxSpreadAttribute(JsxParser.JsxSpreadAttributeContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxAttribute}.
   *
   * @param ctx the parse tree
   */
  void enterJsxAttribute(JsxParser.JsxAttributeContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxAttribute}.
   *
   * @param ctx the parse tree
   */
  void exitJsxAttribute(JsxParser.JsxAttributeContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxAttributeName}.
   *
   * @param ctx the parse tree
   */
  void enterJsxAttributeName(JsxParser.JsxAttributeNameContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxAttributeName}.
   *
   * @param ctx the parse tree
   */
  void exitJsxAttributeName(JsxParser.JsxAttributeNameContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#jsxAttributeValue}.
   *
   * @param ctx the parse tree
   */
  void enterJsxAttributeValue(JsxParser.JsxAttributeValueContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#jsxAttributeValue}.
   *
   * @param ctx the parse tree
   */
  void exitJsxAttributeValue(JsxParser.JsxAttributeValueContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#assignable}.
   *
   * @param ctx the parse tree
   */
  void enterAssignable(JsxParser.AssignableContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#assignable}.
   *
   * @param ctx the parse tree
   */
  void exitAssignable(JsxParser.AssignableContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#objectLiteral}.
   *
   * @param ctx the parse tree
   */
  void enterObjectLiteral(JsxParser.ObjectLiteralContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#objectLiteral}.
   *
   * @param ctx the parse tree
   */
  void exitObjectLiteral(JsxParser.ObjectLiteralContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#openBrace}.
   *
   * @param ctx the parse tree
   */
  void enterOpenBrace(JsxParser.OpenBraceContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#openBrace}.
   *
   * @param ctx the parse tree
   */
  void exitOpenBrace(JsxParser.OpenBraceContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#objectExpressionSequence}.
   *
   * @param ctx the parse tree
   */
  void enterObjectExpressionSequence(JsxParser.ObjectExpressionSequenceContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#objectExpressionSequence}.
   *
   * @param ctx the parse tree
   */
  void exitObjectExpressionSequence(JsxParser.ObjectExpressionSequenceContext ctx);

  /**
   * Enter a parse tree produced by the {@code FunctionDecl} labeled alternative in {@link
   * JsxParser#anoymousFunction}.
   *
   * @param ctx the parse tree
   */
  void enterFunctionDecl(JsxParser.FunctionDeclContext ctx);

  /**
   * Exit a parse tree produced by the {@code FunctionDecl} labeled alternative in {@link
   * JsxParser#anoymousFunction}.
   *
   * @param ctx the parse tree
   */
  void exitFunctionDecl(JsxParser.FunctionDeclContext ctx);

  /**
   * Enter a parse tree produced by the {@code AnoymousFunctionDecl} labeled alternative in {@link
   * JsxParser#anoymousFunction}.
   *
   * @param ctx the parse tree
   */
  void enterAnoymousFunctionDecl(JsxParser.AnoymousFunctionDeclContext ctx);

  /**
   * Exit a parse tree produced by the {@code AnoymousFunctionDecl} labeled alternative in {@link
   * JsxParser#anoymousFunction}.
   *
   * @param ctx the parse tree
   */
  void exitAnoymousFunctionDecl(JsxParser.AnoymousFunctionDeclContext ctx);

  /**
   * Enter a parse tree produced by the {@code ArrowFunction} labeled alternative in {@link
   * JsxParser#anoymousFunction}.
   *
   * @param ctx the parse tree
   */
  void enterArrowFunction(JsxParser.ArrowFunctionContext ctx);

  /**
   * Exit a parse tree produced by the {@code ArrowFunction} labeled alternative in {@link
   * JsxParser#anoymousFunction}.
   *
   * @param ctx the parse tree
   */
  void exitArrowFunction(JsxParser.ArrowFunctionContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#arrowFunctionParameters}.
   *
   * @param ctx the parse tree
   */
  void enterArrowFunctionParameters(JsxParser.ArrowFunctionParametersContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#arrowFunctionParameters}.
   *
   * @param ctx the parse tree
   */
  void exitArrowFunctionParameters(JsxParser.ArrowFunctionParametersContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#arrowFunctionBody}.
   *
   * @param ctx the parse tree
   */
  void enterArrowFunctionBody(JsxParser.ArrowFunctionBodyContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#arrowFunctionBody}.
   *
   * @param ctx the parse tree
   */
  void exitArrowFunctionBody(JsxParser.ArrowFunctionBodyContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#assignmentOperator}.
   *
   * @param ctx the parse tree
   */
  void enterAssignmentOperator(JsxParser.AssignmentOperatorContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#assignmentOperator}.
   *
   * @param ctx the parse tree
   */
  void exitAssignmentOperator(JsxParser.AssignmentOperatorContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#literal}.
   *
   * @param ctx the parse tree
   */
  void enterLiteral(JsxParser.LiteralContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#literal}.
   *
   * @param ctx the parse tree
   */
  void exitLiteral(JsxParser.LiteralContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#templateStringLiteral}.
   *
   * @param ctx the parse tree
   */
  void enterTemplateStringLiteral(JsxParser.TemplateStringLiteralContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#templateStringLiteral}.
   *
   * @param ctx the parse tree
   */
  void exitTemplateStringLiteral(JsxParser.TemplateStringLiteralContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#templateStringAtom}.
   *
   * @param ctx the parse tree
   */
  void enterTemplateStringAtom(JsxParser.TemplateStringAtomContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#templateStringAtom}.
   *
   * @param ctx the parse tree
   */
  void exitTemplateStringAtom(JsxParser.TemplateStringAtomContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#numericLiteral}.
   *
   * @param ctx the parse tree
   */
  void enterNumericLiteral(JsxParser.NumericLiteralContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#numericLiteral}.
   *
   * @param ctx the parse tree
   */
  void exitNumericLiteral(JsxParser.NumericLiteralContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#bigintLiteral}.
   *
   * @param ctx the parse tree
   */
  void enterBigintLiteral(JsxParser.BigintLiteralContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#bigintLiteral}.
   *
   * @param ctx the parse tree
   */
  void exitBigintLiteral(JsxParser.BigintLiteralContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#getter}.
   *
   * @param ctx the parse tree
   */
  void enterGetter(JsxParser.GetterContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#getter}.
   *
   * @param ctx the parse tree
   */
  void exitGetter(JsxParser.GetterContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#setter}.
   *
   * @param ctx the parse tree
   */
  void enterSetter(JsxParser.SetterContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#setter}.
   *
   * @param ctx the parse tree
   */
  void exitSetter(JsxParser.SetterContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#identifierName}.
   *
   * @param ctx the parse tree
   */
  void enterIdentifierName(JsxParser.IdentifierNameContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#identifierName}.
   *
   * @param ctx the parse tree
   */
  void exitIdentifierName(JsxParser.IdentifierNameContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#identifier}.
   *
   * @param ctx the parse tree
   */
  void enterIdentifier(JsxParser.IdentifierContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#identifier}.
   *
   * @param ctx the parse tree
   */
  void exitIdentifier(JsxParser.IdentifierContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#reservedWord}.
   *
   * @param ctx the parse tree
   */
  void enterReservedWord(JsxParser.ReservedWordContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#reservedWord}.
   *
   * @param ctx the parse tree
   */
  void exitReservedWord(JsxParser.ReservedWordContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#keyword}.
   *
   * @param ctx the parse tree
   */
  void enterKeyword(JsxParser.KeywordContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#keyword}.
   *
   * @param ctx the parse tree
   */
  void exitKeyword(JsxParser.KeywordContext ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#let_}.
   *
   * @param ctx the parse tree
   */
  void enterLet_(JsxParser.Let_Context ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#let_}.
   *
   * @param ctx the parse tree
   */
  void exitLet_(JsxParser.Let_Context ctx);

  /**
   * Enter a parse tree produced by {@link JsxParser#eos}.
   *
   * @param ctx the parse tree
   */
  void enterEos(JsxParser.EosContext ctx);

  /**
   * Exit a parse tree produced by {@link JsxParser#eos}.
   *
   * @param ctx the parse tree
   */
  void exitEos(JsxParser.EosContext ctx);
}
