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
 * This interface defines a complete generic visitor for a parse tree produced by {@link OCLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface OCLVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link OCLParser#specification}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSpecification(OCLParser.SpecificationContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#expressions}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpressions(OCLParser.ExpressionsContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#classifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassifier(OCLParser.ClassifierContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#interfaceDefinition}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInterfaceDefinition(OCLParser.InterfaceDefinitionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#classDefinition}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassDefinition(OCLParser.ClassDefinitionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#classBody}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassBody(OCLParser.ClassBodyContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#classBodyElement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassBodyElement(OCLParser.ClassBodyElementContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#attributeDefinition}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAttributeDefinition(OCLParser.AttributeDefinitionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#operationDefinition}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOperationDefinition(OCLParser.OperationDefinitionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#parameterDeclarations}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParameterDeclarations(OCLParser.ParameterDeclarationsContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#parameterDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParameterDeclaration(OCLParser.ParameterDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#idList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdList(OCLParser.IdListContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#usecaseDefinition}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUsecaseDefinition(OCLParser.UsecaseDefinitionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#usecaseBody}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUsecaseBody(OCLParser.UsecaseBodyContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#usecaseBodyElement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUsecaseBodyElement(OCLParser.UsecaseBodyElementContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#invariant}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInvariant(OCLParser.InvariantContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#stereotype}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStereotype(OCLParser.StereotypeContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#enumeration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnumeration(OCLParser.EnumerationContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#enumerationLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnumerationLiteral(OCLParser.EnumerationLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType(OCLParser.TypeContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#expressionList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpressionList(OCLParser.ExpressionListContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#expression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpression(OCLParser.ExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#basicExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBasicExpression(OCLParser.BasicExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#conditionalExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConditionalExpression(OCLParser.ConditionalExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#lambdaExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLambdaExpression(OCLParser.LambdaExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#letExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLetExpression(OCLParser.LetExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#logicalExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLogicalExpression(OCLParser.LogicalExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#equalityExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEqualityExpression(OCLParser.EqualityExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#additiveExpr1ession}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAdditiveExpression(OCLParser.AdditiveExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#factorExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFactorExpression(OCLParser.FactorExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#factor2Expression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFactor2Expression(OCLParser.Factor2ExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#setExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSetExpression(OCLParser.SetExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#statement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStatement(OCLParser.StatementContext ctx);

  /**
   * Visit a parse tree produced by {@link OCLParser#identifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdentifier(OCLParser.IdentifierContext ctx);
}
