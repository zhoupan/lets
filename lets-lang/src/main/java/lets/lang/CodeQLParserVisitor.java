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
 * CodeQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface CodeQLParserVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link CodeQLParser#literalId}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteralId(CodeQLParser.LiteralIdContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#keywordAllowed}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitKeywordAllowed(CodeQLParser.KeywordAllowedContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#keywordPredCallAllowed}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitKeywordPredCallAllowed(CodeQLParser.KeywordPredCallAllowedContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#varname}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVarname(CodeQLParser.VarnameContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#ql}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitQl(CodeQLParser.QlContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#module}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModule(CodeQLParser.ModuleContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#parameters}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParameters(CodeQLParser.ParametersContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#implements}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImplements(CodeQLParser.ImplementsContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#moduleBody}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModuleBody(CodeQLParser.ModuleBodyContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#importDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImportDeclaration(CodeQLParser.ImportDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#simpleId}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSimpleId(CodeQLParser.SimpleIdContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#qualId}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitQualId(CodeQLParser.QualIdContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#importModuleExpr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImportModuleExpr(CodeQLParser.ImportModuleExprContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#arguments}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArguments(CodeQLParser.ArgumentsContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#argument}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArgument(CodeQLParser.ArgumentContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#signature}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSignature(CodeQLParser.SignatureContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#predicateSignature}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPredicateSignature(CodeQLParser.PredicateSignatureContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#typeSignature}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeSignature(CodeQLParser.TypeSignatureContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#moduleSignature}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModuleSignature(CodeQLParser.ModuleSignatureContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#moduleSignatureBody}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModuleSignatureBody(CodeQLParser.ModuleSignatureBodyContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#signaturePredicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSignaturePredicate(CodeQLParser.SignaturePredicateContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#defaultPredicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDefaultPredicate(CodeQLParser.DefaultPredicateContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#signatureType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSignatureType(CodeQLParser.SignatureTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#select}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSelect(CodeQLParser.SelectContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#as_exprs}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAs_exprs(CodeQLParser.As_exprsContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#as_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAs_expr(CodeQLParser.As_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#orderbys}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOrderbys(CodeQLParser.OrderbysContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#orderby}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOrderby(CodeQLParser.OrderbyContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#dtName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDtName(CodeQLParser.DtNameContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#dtBranches}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDtBranches(CodeQLParser.DtBranchesContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#dtBranche}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDtBranche(CodeQLParser.DtBrancheContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#dtBranchName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDtBranchName(CodeQLParser.DtBranchNameContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#datatype}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDatatype(CodeQLParser.DatatypeContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#unionBranches}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnionBranches(CodeQLParser.UnionBranchesContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#typeunion}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeunion(CodeQLParser.TypeunionContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#predicate}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPredicate(CodeQLParser.PredicateContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#annotations}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotations(CodeQLParser.AnnotationsContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#annotation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation(CodeQLParser.AnnotationContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#simpleAnnotation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSimpleAnnotation(CodeQLParser.SimpleAnnotationContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#pragmaArg}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPragmaArg(CodeQLParser.PragmaArgContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#argsAnnotation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArgsAnnotation(CodeQLParser.ArgsAnnotationContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#head}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitHead(CodeQLParser.HeadContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#optbody}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitOptbody(CodeQLParser.OptbodyContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#class_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClass_(CodeQLParser.Class_Context ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#member}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMember(CodeQLParser.MemberContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#character}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCharacter(CodeQLParser.CharacterContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#field}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitField(CodeQLParser.FieldContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#moduleExpr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModuleExpr(CodeQLParser.ModuleExprContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#moduleSignatureExpr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModuleSignatureExpr(CodeQLParser.ModuleSignatureExprContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#signatureExpr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSignatureExpr(CodeQLParser.SignatureExprContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType(CodeQLParser.TypeContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#exprs}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExprs(CodeQLParser.ExprsContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#alias}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAlias(CodeQLParser.AliasContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#var_decls}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVar_decls(CodeQLParser.Var_declsContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#var_decl}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVar_decl(CodeQLParser.Var_declContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#formula}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFormula(CodeQLParser.FormulaContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#formula_base}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFormula_base(CodeQLParser.Formula_baseContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#conjunction_formula}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConjunction_formula(CodeQLParser.Conjunction_formulaContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#implies_formula}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImplies_formula(CodeQLParser.Implies_formulaContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#fparen}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFparen(CodeQLParser.FparenContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#ifthen}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIfthen(CodeQLParser.IfthenContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#negated}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNegated(CodeQLParser.NegatedContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#quantified}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitQuantified(CodeQLParser.QuantifiedContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#comparison}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComparison(CodeQLParser.ComparisonContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#compop}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCompop(CodeQLParser.CompopContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#instanceof}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInstanceof(CodeQLParser.InstanceofContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#inrange}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInrange(CodeQLParser.InrangeContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#call}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCall(CodeQLParser.CallContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#closure}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClosure(CodeQLParser.ClosureContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpr(CodeQLParser.ExprContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#multExpr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMultExpr(CodeQLParser.MultExprContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#unaryExpr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnaryExpr(CodeQLParser.UnaryExprContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#nonOpExpr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNonOpExpr(CodeQLParser.NonOpExprContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#primary}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrimary(CodeQLParser.PrimaryContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#primaryPostfixOp}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrimaryPostfixOp(CodeQLParser.PrimaryPostfixOpContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#callwithresults_nomember}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCallwithresults_nomember(CodeQLParser.Callwithresults_nomemberContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#primaryBase}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrimaryBase(CodeQLParser.PrimaryBaseContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#none}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNone(CodeQLParser.NoneContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#eparen}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEparen(CodeQLParser.EparenContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#literal}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteral(CodeQLParser.LiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#unop}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnop(CodeQLParser.UnopContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#variable}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVariable(CodeQLParser.VariableContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#super_expr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSuper_expr(CodeQLParser.Super_exprContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#cast}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCast(CodeQLParser.CastContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#aggregation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAggregation(CodeQLParser.AggregationContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#expression_pragma}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpression_pragma(CodeQLParser.Expression_pragmaContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#expression_pragma_type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpression_pragma_type(CodeQLParser.Expression_pragma_typeContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#aggid}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAggid(CodeQLParser.AggidContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#aggorderbys}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAggorderbys(CodeQLParser.AggorderbysContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#aggorderby}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAggorderby(CodeQLParser.AggorderbyContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#any}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAny(CodeQLParser.AnyContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#range}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRange(CodeQLParser.RangeContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#setliteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSetliteral(CodeQLParser.SetliteralContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#modulename}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModulename(CodeQLParser.ModulenameContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#moduleSignatureName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModuleSignatureName(CodeQLParser.ModuleSignatureNameContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#classname}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassname(CodeQLParser.ClassnameContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#dbbasetype}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDbbasetype(CodeQLParser.DbbasetypeContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#predicateRef}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPredicateRef(CodeQLParser.PredicateRefContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#predicateName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPredicateName(CodeQLParser.PredicateNameContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#predicateCallName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPredicateCallName(CodeQLParser.PredicateCallNameContext ctx);

  /**
   * Visit a parse tree produced by {@link CodeQLParser#parameterName}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParameterName(CodeQLParser.ParameterNameContext ctx);
}
