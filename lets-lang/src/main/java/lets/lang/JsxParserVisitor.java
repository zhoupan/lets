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
 * This interface defines a complete generic visitor for a parse tree produced by {@link JsxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface JsxParserVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link JsxParser#program}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitProgram(JsxParser.ProgramContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#sourceElement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSourceElement(JsxParser.SourceElementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#statement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStatement(JsxParser.StatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#block}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBlock(JsxParser.BlockContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#statementList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStatementList(JsxParser.StatementListContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#importStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImportStatement(JsxParser.ImportStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#importFromBlock}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImportFromBlock(JsxParser.ImportFromBlockContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#moduleItems}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModuleItems(JsxParser.ModuleItemsContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#importDefault}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImportDefault(JsxParser.ImportDefaultContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#importNamespace}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImportNamespace(JsxParser.ImportNamespaceContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#importFrom}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImportFrom(JsxParser.ImportFromContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#aliasName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAliasName(JsxParser.AliasNameContext ctx);

  /**
   * Visit a parse tree produced by the {@code ExportDeclaration} labeled alternative in {@link
   * JsxParser#exportStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExportDeclaration(JsxParser.ExportDeclarationContext ctx);

  /**
   * Visit a parse tree produced by the {@code ExportDefaultDeclaration} labeled alternative in
   * {@link JsxParser#exportStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExportDefaultDeclaration(JsxParser.ExportDefaultDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#exportFromBlock}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExportFromBlock(JsxParser.ExportFromBlockContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#declaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDeclaration(JsxParser.DeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#variableStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVariableStatement(JsxParser.VariableStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#variableDeclarationList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVariableDeclarationList(JsxParser.VariableDeclarationListContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#variableDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVariableDeclaration(JsxParser.VariableDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#emptyStatement_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEmptyStatement_(JsxParser.EmptyStatement_Context ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#expressionStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpressionStatement(JsxParser.ExpressionStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#ifStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIfStatement(JsxParser.IfStatementContext ctx);

  /**
   * Visit a parse tree produced by the {@code DoStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDoStatement(JsxParser.DoStatementContext ctx);

  /**
   * Visit a parse tree produced by the {@code WhileStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitWhileStatement(JsxParser.WhileStatementContext ctx);

  /**
   * Visit a parse tree produced by the {@code ForStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitForStatement(JsxParser.ForStatementContext ctx);

  /**
   * Visit a parse tree produced by the {@code ForInStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitForInStatement(JsxParser.ForInStatementContext ctx);

  /**
   * Visit a parse tree produced by the {@code ForOfStatement} labeled alternative in {@link
   * JsxParser#iterationStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitForOfStatement(JsxParser.ForOfStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#varModifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVarModifier(JsxParser.VarModifierContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#continueStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitContinueStatement(JsxParser.ContinueStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#breakStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBreakStatement(JsxParser.BreakStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#returnStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitReturnStatement(JsxParser.ReturnStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#yieldStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitYieldStatement(JsxParser.YieldStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#withStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitWithStatement(JsxParser.WithStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#switchStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSwitchStatement(JsxParser.SwitchStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#caseBlock}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCaseBlock(JsxParser.CaseBlockContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#caseClauses}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCaseClauses(JsxParser.CaseClausesContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#caseClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCaseClause(JsxParser.CaseClauseContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#defaultClause}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDefaultClause(JsxParser.DefaultClauseContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#labelledStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLabelledStatement(JsxParser.LabelledStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#throwStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitThrowStatement(JsxParser.ThrowStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#tryStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTryStatement(JsxParser.TryStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#catchProduction}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCatchProduction(JsxParser.CatchProductionContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#finallyProduction}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFinallyProduction(JsxParser.FinallyProductionContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#debuggerStatement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDebuggerStatement(JsxParser.DebuggerStatementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#functionDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionDeclaration(JsxParser.FunctionDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#classDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassDeclaration(JsxParser.ClassDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#classTail}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassTail(JsxParser.ClassTailContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#classElement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassElement(JsxParser.ClassElementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#methodDefinition}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMethodDefinition(JsxParser.MethodDefinitionContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#formalParameterList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFormalParameterList(JsxParser.FormalParameterListContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#formalParameterArg}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFormalParameterArg(JsxParser.FormalParameterArgContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#lastFormalParameterArg}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLastFormalParameterArg(JsxParser.LastFormalParameterArgContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#functionBody}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionBody(JsxParser.FunctionBodyContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#sourceElements}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSourceElements(JsxParser.SourceElementsContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#arrayLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArrayLiteral(JsxParser.ArrayLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#elementList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitElementList(JsxParser.ElementListContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#arrayElement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArrayElement(JsxParser.ArrayElementContext ctx);

  /**
   * Visit a parse tree produced by the {@code PropertyExpressionAssignment} labeled alternative in
   * {@link JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPropertyExpressionAssignment(JsxParser.PropertyExpressionAssignmentContext ctx);

  /**
   * Visit a parse tree produced by the {@code ComputedPropertyExpressionAssignment} labeled
   * alternative in {@link JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComputedPropertyExpressionAssignment(
      JsxParser.ComputedPropertyExpressionAssignmentContext ctx);

  /**
   * Visit a parse tree produced by the {@code FunctionProperty} labeled alternative in {@link
   * JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionProperty(JsxParser.FunctionPropertyContext ctx);

  /**
   * Visit a parse tree produced by the {@code PropertyGetter} labeled alternative in {@link
   * JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPropertyGetter(JsxParser.PropertyGetterContext ctx);

  /**
   * Visit a parse tree produced by the {@code PropertySetter} labeled alternative in {@link
   * JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPropertySetter(JsxParser.PropertySetterContext ctx);

  /**
   * Visit a parse tree produced by the {@code PropertyShorthand} labeled alternative in {@link
   * JsxParser#propertyAssignment}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPropertyShorthand(JsxParser.PropertyShorthandContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#propertyName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPropertyName(JsxParser.PropertyNameContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#arguments}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArguments(JsxParser.ArgumentsContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#argument}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArgument(JsxParser.ArgumentContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#expressionSequence}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpressionSequence(JsxParser.ExpressionSequenceContext ctx);

  /**
   * Visit a parse tree produced by the {@code TemplateStringExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTemplateStringExpression(JsxParser.TemplateStringExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code TernaryExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTernaryExpression(JsxParser.TernaryExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code LogicalAndExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLogicalAndExpression(JsxParser.LogicalAndExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code PowerExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPowerExpression(JsxParser.PowerExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code PreIncrementExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPreIncrementExpression(JsxParser.PreIncrementExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code ObjectLiteralExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitObjectLiteralExpression(JsxParser.ObjectLiteralExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code MetaExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMetaExpression(JsxParser.MetaExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code InExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInExpression(JsxParser.InExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code LogicalOrExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLogicalOrExpression(JsxParser.LogicalOrExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code NotExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNotExpression(JsxParser.NotExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code PreDecreaseExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPreDecreaseExpression(JsxParser.PreDecreaseExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code jsxElementExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxElementExpression(JsxParser.JsxElementExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code ArgumentsExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArgumentsExpression(JsxParser.ArgumentsExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code AwaitExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAwaitExpression(JsxParser.AwaitExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code ThisExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitThisExpression(JsxParser.ThisExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code FunctionExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionExpression(JsxParser.FunctionExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code UnaryMinusExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnaryMinusExpression(JsxParser.UnaryMinusExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code AssignmentExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAssignmentExpression(JsxParser.AssignmentExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code PostDecreaseExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPostDecreaseExpression(JsxParser.PostDecreaseExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code TypeofExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeofExpression(JsxParser.TypeofExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code InstanceofExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInstanceofExpression(JsxParser.InstanceofExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code UnaryPlusExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnaryPlusExpression(JsxParser.UnaryPlusExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code DeleteExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDeleteExpression(JsxParser.DeleteExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code ImportExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImportExpression(JsxParser.ImportExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code EqualityExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEqualityExpression(JsxParser.EqualityExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code BitXOrExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBitXOrExpression(JsxParser.BitXOrExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code SuperExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSuperExpression(JsxParser.SuperExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code MultiplicativeExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMultiplicativeExpression(JsxParser.MultiplicativeExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code BitShiftExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBitShiftExpression(JsxParser.BitShiftExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code ParenthesizedExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParenthesizedExpression(JsxParser.ParenthesizedExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code AdditiveExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAdditiveExpression(JsxParser.AdditiveExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code RelationalExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRelationalExpression(JsxParser.RelationalExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code PostIncrementExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPostIncrementExpression(JsxParser.PostIncrementExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code YieldExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitYieldExpression(JsxParser.YieldExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code BitNotExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBitNotExpression(JsxParser.BitNotExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code NewExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNewExpression(JsxParser.NewExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code LiteralExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteralExpression(JsxParser.LiteralExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code ArrayLiteralExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArrayLiteralExpression(JsxParser.ArrayLiteralExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code MemberDotExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMemberDotExpression(JsxParser.MemberDotExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code ClassExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassExpression(JsxParser.ClassExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code MemberIndexExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMemberIndexExpression(JsxParser.MemberIndexExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code IdentifierExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdentifierExpression(JsxParser.IdentifierExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code BitAndExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBitAndExpression(JsxParser.BitAndExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code BitOrExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBitOrExpression(JsxParser.BitOrExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code AssignmentOperatorExpression} labeled alternative in
   * {@link JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAssignmentOperatorExpression(JsxParser.AssignmentOperatorExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code VoidExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVoidExpression(JsxParser.VoidExpressionContext ctx);

  /**
   * Visit a parse tree produced by the {@code CoalesceExpression} labeled alternative in {@link
   * JsxParser#singleExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCoalesceExpression(JsxParser.CoalesceExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxElements}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxElements(JsxParser.JsxElementsContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxElementBegin}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxElementBegin(JsxParser.JsxElementBeginContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxElement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxElement(JsxParser.JsxElementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxSelfClosingElement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxSelfClosingElement(JsxParser.JsxSelfClosingElementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxOpeningElement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxOpeningElement(JsxParser.JsxOpeningElementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxClosingElement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxClosingElement(JsxParser.JsxClosingElementContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxChildren}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxChildren(JsxParser.JsxChildrenContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxSelfClosingElementName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxSelfClosingElementName(JsxParser.JsxSelfClosingElementNameContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxOpeningElementName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxOpeningElementName(JsxParser.JsxOpeningElementNameContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxClosingElementName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxClosingElementName(JsxParser.JsxClosingElementNameContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxAttributes}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxAttributes(JsxParser.JsxAttributesContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxSpreadAttribute}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxSpreadAttribute(JsxParser.JsxSpreadAttributeContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxAttribute}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxAttribute(JsxParser.JsxAttributeContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxAttributeName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxAttributeName(JsxParser.JsxAttributeNameContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#jsxAttributeValue}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJsxAttributeValue(JsxParser.JsxAttributeValueContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#assignable}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAssignable(JsxParser.AssignableContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#objectLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitObjectLiteral(JsxParser.ObjectLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#openBrace}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOpenBrace(JsxParser.OpenBraceContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#objectExpressionSequence}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitObjectExpressionSequence(JsxParser.ObjectExpressionSequenceContext ctx);

  /**
   * Visit a parse tree produced by the {@code FunctionDecl} labeled alternative in {@link
   * JsxParser#anoymousFunction}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionDecl(JsxParser.FunctionDeclContext ctx);

  /**
   * Visit a parse tree produced by the {@code AnoymousFunctionDecl} labeled alternative in {@link
   * JsxParser#anoymousFunction}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnoymousFunctionDecl(JsxParser.AnoymousFunctionDeclContext ctx);

  /**
   * Visit a parse tree produced by the {@code ArrowFunction} labeled alternative in {@link
   * JsxParser#anoymousFunction}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArrowFunction(JsxParser.ArrowFunctionContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#arrowFunctionParameters}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArrowFunctionParameters(JsxParser.ArrowFunctionParametersContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#arrowFunctionBody}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArrowFunctionBody(JsxParser.ArrowFunctionBodyContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#assignmentOperator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAssignmentOperator(JsxParser.AssignmentOperatorContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#literal}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteral(JsxParser.LiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#templateStringLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTemplateStringLiteral(JsxParser.TemplateStringLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#templateStringAtom}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTemplateStringAtom(JsxParser.TemplateStringAtomContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#numericLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNumericLiteral(JsxParser.NumericLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#bigintLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBigintLiteral(JsxParser.BigintLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#getter}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitGetter(JsxParser.GetterContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#setter}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSetter(JsxParser.SetterContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#identifierName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdentifierName(JsxParser.IdentifierNameContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#identifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdentifier(JsxParser.IdentifierContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#reservedWord}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitReservedWord(JsxParser.ReservedWordContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#keyword}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitKeyword(JsxParser.KeywordContext ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#let_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLet_(JsxParser.Let_Context ctx);

  /**
   * Visit a parse tree produced by {@link JsxParser#eos}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEos(JsxParser.EosContext ctx);
}
