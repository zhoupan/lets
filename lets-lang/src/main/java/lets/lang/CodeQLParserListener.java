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

/** This interface defines a complete listener for a parse tree produced by {@link CodeQLParser}. */
public interface CodeQLParserListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link CodeQLParser#literalId}.
   *
   * @param ctx the parse tree
   */
  void enterLiteralId(CodeQLParser.LiteralIdContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#literalId}.
   *
   * @param ctx the parse tree
   */
  void exitLiteralId(CodeQLParser.LiteralIdContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#keywordAllowed}.
   *
   * @param ctx the parse tree
   */
  void enterKeywordAllowed(CodeQLParser.KeywordAllowedContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#keywordAllowed}.
   *
   * @param ctx the parse tree
   */
  void exitKeywordAllowed(CodeQLParser.KeywordAllowedContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#keywordPredCallAllowed}.
   *
   * @param ctx the parse tree
   */
  void enterKeywordPredCallAllowed(CodeQLParser.KeywordPredCallAllowedContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#keywordPredCallAllowed}.
   *
   * @param ctx the parse tree
   */
  void exitKeywordPredCallAllowed(CodeQLParser.KeywordPredCallAllowedContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#varname}.
   *
   * @param ctx the parse tree
   */
  void enterVarname(CodeQLParser.VarnameContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#varname}.
   *
   * @param ctx the parse tree
   */
  void exitVarname(CodeQLParser.VarnameContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#ql}.
   *
   * @param ctx the parse tree
   */
  void enterQl(CodeQLParser.QlContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#ql}.
   *
   * @param ctx the parse tree
   */
  void exitQl(CodeQLParser.QlContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#module}.
   *
   * @param ctx the parse tree
   */
  void enterModule(CodeQLParser.ModuleContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#module}.
   *
   * @param ctx the parse tree
   */
  void exitModule(CodeQLParser.ModuleContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#parameters}.
   *
   * @param ctx the parse tree
   */
  void enterParameters(CodeQLParser.ParametersContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#parameters}.
   *
   * @param ctx the parse tree
   */
  void exitParameters(CodeQLParser.ParametersContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#implements}.
   *
   * @param ctx the parse tree
   */
  void enterImplements(CodeQLParser.ImplementsContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#implements}.
   *
   * @param ctx the parse tree
   */
  void exitImplements(CodeQLParser.ImplementsContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#moduleBody}.
   *
   * @param ctx the parse tree
   */
  void enterModuleBody(CodeQLParser.ModuleBodyContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#moduleBody}.
   *
   * @param ctx the parse tree
   */
  void exitModuleBody(CodeQLParser.ModuleBodyContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#importDeclaration}.
   *
   * @param ctx the parse tree
   */
  void enterImportDeclaration(CodeQLParser.ImportDeclarationContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#importDeclaration}.
   *
   * @param ctx the parse tree
   */
  void exitImportDeclaration(CodeQLParser.ImportDeclarationContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#simpleId}.
   *
   * @param ctx the parse tree
   */
  void enterSimpleId(CodeQLParser.SimpleIdContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#simpleId}.
   *
   * @param ctx the parse tree
   */
  void exitSimpleId(CodeQLParser.SimpleIdContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#qualId}.
   *
   * @param ctx the parse tree
   */
  void enterQualId(CodeQLParser.QualIdContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#qualId}.
   *
   * @param ctx the parse tree
   */
  void exitQualId(CodeQLParser.QualIdContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#importModuleExpr}.
   *
   * @param ctx the parse tree
   */
  void enterImportModuleExpr(CodeQLParser.ImportModuleExprContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#importModuleExpr}.
   *
   * @param ctx the parse tree
   */
  void exitImportModuleExpr(CodeQLParser.ImportModuleExprContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#arguments}.
   *
   * @param ctx the parse tree
   */
  void enterArguments(CodeQLParser.ArgumentsContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#arguments}.
   *
   * @param ctx the parse tree
   */
  void exitArguments(CodeQLParser.ArgumentsContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#argument}.
   *
   * @param ctx the parse tree
   */
  void enterArgument(CodeQLParser.ArgumentContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#argument}.
   *
   * @param ctx the parse tree
   */
  void exitArgument(CodeQLParser.ArgumentContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#signature}.
   *
   * @param ctx the parse tree
   */
  void enterSignature(CodeQLParser.SignatureContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#signature}.
   *
   * @param ctx the parse tree
   */
  void exitSignature(CodeQLParser.SignatureContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#predicateSignature}.
   *
   * @param ctx the parse tree
   */
  void enterPredicateSignature(CodeQLParser.PredicateSignatureContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#predicateSignature}.
   *
   * @param ctx the parse tree
   */
  void exitPredicateSignature(CodeQLParser.PredicateSignatureContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#typeSignature}.
   *
   * @param ctx the parse tree
   */
  void enterTypeSignature(CodeQLParser.TypeSignatureContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#typeSignature}.
   *
   * @param ctx the parse tree
   */
  void exitTypeSignature(CodeQLParser.TypeSignatureContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#moduleSignature}.
   *
   * @param ctx the parse tree
   */
  void enterModuleSignature(CodeQLParser.ModuleSignatureContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#moduleSignature}.
   *
   * @param ctx the parse tree
   */
  void exitModuleSignature(CodeQLParser.ModuleSignatureContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#moduleSignatureBody}.
   *
   * @param ctx the parse tree
   */
  void enterModuleSignatureBody(CodeQLParser.ModuleSignatureBodyContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#moduleSignatureBody}.
   *
   * @param ctx the parse tree
   */
  void exitModuleSignatureBody(CodeQLParser.ModuleSignatureBodyContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#signaturePredicate}.
   *
   * @param ctx the parse tree
   */
  void enterSignaturePredicate(CodeQLParser.SignaturePredicateContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#signaturePredicate}.
   *
   * @param ctx the parse tree
   */
  void exitSignaturePredicate(CodeQLParser.SignaturePredicateContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#defaultPredicate}.
   *
   * @param ctx the parse tree
   */
  void enterDefaultPredicate(CodeQLParser.DefaultPredicateContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#defaultPredicate}.
   *
   * @param ctx the parse tree
   */
  void exitDefaultPredicate(CodeQLParser.DefaultPredicateContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#signatureType}.
   *
   * @param ctx the parse tree
   */
  void enterSignatureType(CodeQLParser.SignatureTypeContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#signatureType}.
   *
   * @param ctx the parse tree
   */
  void exitSignatureType(CodeQLParser.SignatureTypeContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#select}.
   *
   * @param ctx the parse tree
   */
  void enterSelect(CodeQLParser.SelectContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#select}.
   *
   * @param ctx the parse tree
   */
  void exitSelect(CodeQLParser.SelectContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#as_exprs}.
   *
   * @param ctx the parse tree
   */
  void enterAs_exprs(CodeQLParser.As_exprsContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#as_exprs}.
   *
   * @param ctx the parse tree
   */
  void exitAs_exprs(CodeQLParser.As_exprsContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#as_expr}.
   *
   * @param ctx the parse tree
   */
  void enterAs_expr(CodeQLParser.As_exprContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#as_expr}.
   *
   * @param ctx the parse tree
   */
  void exitAs_expr(CodeQLParser.As_exprContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#orderbys}.
   *
   * @param ctx the parse tree
   */
  void enterOrderbys(CodeQLParser.OrderbysContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#orderbys}.
   *
   * @param ctx the parse tree
   */
  void exitOrderbys(CodeQLParser.OrderbysContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#orderby}.
   *
   * @param ctx the parse tree
   */
  void enterOrderby(CodeQLParser.OrderbyContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#orderby}.
   *
   * @param ctx the parse tree
   */
  void exitOrderby(CodeQLParser.OrderbyContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#dtName}.
   *
   * @param ctx the parse tree
   */
  void enterDtName(CodeQLParser.DtNameContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#dtName}.
   *
   * @param ctx the parse tree
   */
  void exitDtName(CodeQLParser.DtNameContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#dtBranches}.
   *
   * @param ctx the parse tree
   */
  void enterDtBranches(CodeQLParser.DtBranchesContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#dtBranches}.
   *
   * @param ctx the parse tree
   */
  void exitDtBranches(CodeQLParser.DtBranchesContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#dtBranche}.
   *
   * @param ctx the parse tree
   */
  void enterDtBranche(CodeQLParser.DtBrancheContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#dtBranche}.
   *
   * @param ctx the parse tree
   */
  void exitDtBranche(CodeQLParser.DtBrancheContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#dtBranchName}.
   *
   * @param ctx the parse tree
   */
  void enterDtBranchName(CodeQLParser.DtBranchNameContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#dtBranchName}.
   *
   * @param ctx the parse tree
   */
  void exitDtBranchName(CodeQLParser.DtBranchNameContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#datatype}.
   *
   * @param ctx the parse tree
   */
  void enterDatatype(CodeQLParser.DatatypeContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#datatype}.
   *
   * @param ctx the parse tree
   */
  void exitDatatype(CodeQLParser.DatatypeContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#unionBranches}.
   *
   * @param ctx the parse tree
   */
  void enterUnionBranches(CodeQLParser.UnionBranchesContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#unionBranches}.
   *
   * @param ctx the parse tree
   */
  void exitUnionBranches(CodeQLParser.UnionBranchesContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#typeunion}.
   *
   * @param ctx the parse tree
   */
  void enterTypeunion(CodeQLParser.TypeunionContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#typeunion}.
   *
   * @param ctx the parse tree
   */
  void exitTypeunion(CodeQLParser.TypeunionContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#predicate}.
   *
   * @param ctx the parse tree
   */
  void enterPredicate(CodeQLParser.PredicateContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#predicate}.
   *
   * @param ctx the parse tree
   */
  void exitPredicate(CodeQLParser.PredicateContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#annotations}.
   *
   * @param ctx the parse tree
   */
  void enterAnnotations(CodeQLParser.AnnotationsContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#annotations}.
   *
   * @param ctx the parse tree
   */
  void exitAnnotations(CodeQLParser.AnnotationsContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#annotation}.
   *
   * @param ctx the parse tree
   */
  void enterAnnotation(CodeQLParser.AnnotationContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#annotation}.
   *
   * @param ctx the parse tree
   */
  void exitAnnotation(CodeQLParser.AnnotationContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#simpleAnnotation}.
   *
   * @param ctx the parse tree
   */
  void enterSimpleAnnotation(CodeQLParser.SimpleAnnotationContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#simpleAnnotation}.
   *
   * @param ctx the parse tree
   */
  void exitSimpleAnnotation(CodeQLParser.SimpleAnnotationContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#pragmaArg}.
   *
   * @param ctx the parse tree
   */
  void enterPragmaArg(CodeQLParser.PragmaArgContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#pragmaArg}.
   *
   * @param ctx the parse tree
   */
  void exitPragmaArg(CodeQLParser.PragmaArgContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#argsAnnotation}.
   *
   * @param ctx the parse tree
   */
  void enterArgsAnnotation(CodeQLParser.ArgsAnnotationContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#argsAnnotation}.
   *
   * @param ctx the parse tree
   */
  void exitArgsAnnotation(CodeQLParser.ArgsAnnotationContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#head}.
   *
   * @param ctx the parse tree
   */
  void enterHead(CodeQLParser.HeadContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#head}.
   *
   * @param ctx the parse tree
   */
  void exitHead(CodeQLParser.HeadContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#optbody}.
   *
   * @param ctx the parse tree
   */
  void enterOptbody(CodeQLParser.OptbodyContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#optbody}.
   *
   * @param ctx the parse tree
   */
  void exitOptbody(CodeQLParser.OptbodyContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#class_}.
   *
   * @param ctx the parse tree
   */
  void enterClass_(CodeQLParser.Class_Context ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#class_}.
   *
   * @param ctx the parse tree
   */
  void exitClass_(CodeQLParser.Class_Context ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#member}.
   *
   * @param ctx the parse tree
   */
  void enterMember(CodeQLParser.MemberContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#member}.
   *
   * @param ctx the parse tree
   */
  void exitMember(CodeQLParser.MemberContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#character}.
   *
   * @param ctx the parse tree
   */
  void enterCharacter(CodeQLParser.CharacterContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#character}.
   *
   * @param ctx the parse tree
   */
  void exitCharacter(CodeQLParser.CharacterContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#field}.
   *
   * @param ctx the parse tree
   */
  void enterField(CodeQLParser.FieldContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#field}.
   *
   * @param ctx the parse tree
   */
  void exitField(CodeQLParser.FieldContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#moduleExpr}.
   *
   * @param ctx the parse tree
   */
  void enterModuleExpr(CodeQLParser.ModuleExprContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#moduleExpr}.
   *
   * @param ctx the parse tree
   */
  void exitModuleExpr(CodeQLParser.ModuleExprContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#moduleSignatureExpr}.
   *
   * @param ctx the parse tree
   */
  void enterModuleSignatureExpr(CodeQLParser.ModuleSignatureExprContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#moduleSignatureExpr}.
   *
   * @param ctx the parse tree
   */
  void exitModuleSignatureExpr(CodeQLParser.ModuleSignatureExprContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#signatureExpr}.
   *
   * @param ctx the parse tree
   */
  void enterSignatureExpr(CodeQLParser.SignatureExprContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#signatureExpr}.
   *
   * @param ctx the parse tree
   */
  void exitSignatureExpr(CodeQLParser.SignatureExprContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#type}.
   *
   * @param ctx the parse tree
   */
  void enterType(CodeQLParser.TypeContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#type}.
   *
   * @param ctx the parse tree
   */
  void exitType(CodeQLParser.TypeContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#exprs}.
   *
   * @param ctx the parse tree
   */
  void enterExprs(CodeQLParser.ExprsContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#exprs}.
   *
   * @param ctx the parse tree
   */
  void exitExprs(CodeQLParser.ExprsContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#alias}.
   *
   * @param ctx the parse tree
   */
  void enterAlias(CodeQLParser.AliasContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#alias}.
   *
   * @param ctx the parse tree
   */
  void exitAlias(CodeQLParser.AliasContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#var_decls}.
   *
   * @param ctx the parse tree
   */
  void enterVar_decls(CodeQLParser.Var_declsContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#var_decls}.
   *
   * @param ctx the parse tree
   */
  void exitVar_decls(CodeQLParser.Var_declsContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#var_decl}.
   *
   * @param ctx the parse tree
   */
  void enterVar_decl(CodeQLParser.Var_declContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#var_decl}.
   *
   * @param ctx the parse tree
   */
  void exitVar_decl(CodeQLParser.Var_declContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#formula}.
   *
   * @param ctx the parse tree
   */
  void enterFormula(CodeQLParser.FormulaContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#formula}.
   *
   * @param ctx the parse tree
   */
  void exitFormula(CodeQLParser.FormulaContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#formula_base}.
   *
   * @param ctx the parse tree
   */
  void enterFormula_base(CodeQLParser.Formula_baseContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#formula_base}.
   *
   * @param ctx the parse tree
   */
  void exitFormula_base(CodeQLParser.Formula_baseContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#conjunction_formula}.
   *
   * @param ctx the parse tree
   */
  void enterConjunction_formula(CodeQLParser.Conjunction_formulaContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#conjunction_formula}.
   *
   * @param ctx the parse tree
   */
  void exitConjunction_formula(CodeQLParser.Conjunction_formulaContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#implies_formula}.
   *
   * @param ctx the parse tree
   */
  void enterImplies_formula(CodeQLParser.Implies_formulaContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#implies_formula}.
   *
   * @param ctx the parse tree
   */
  void exitImplies_formula(CodeQLParser.Implies_formulaContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#fparen}.
   *
   * @param ctx the parse tree
   */
  void enterFparen(CodeQLParser.FparenContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#fparen}.
   *
   * @param ctx the parse tree
   */
  void exitFparen(CodeQLParser.FparenContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#ifthen}.
   *
   * @param ctx the parse tree
   */
  void enterIfthen(CodeQLParser.IfthenContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#ifthen}.
   *
   * @param ctx the parse tree
   */
  void exitIfthen(CodeQLParser.IfthenContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#negated}.
   *
   * @param ctx the parse tree
   */
  void enterNegated(CodeQLParser.NegatedContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#negated}.
   *
   * @param ctx the parse tree
   */
  void exitNegated(CodeQLParser.NegatedContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#quantified}.
   *
   * @param ctx the parse tree
   */
  void enterQuantified(CodeQLParser.QuantifiedContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#quantified}.
   *
   * @param ctx the parse tree
   */
  void exitQuantified(CodeQLParser.QuantifiedContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#comparison}.
   *
   * @param ctx the parse tree
   */
  void enterComparison(CodeQLParser.ComparisonContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#comparison}.
   *
   * @param ctx the parse tree
   */
  void exitComparison(CodeQLParser.ComparisonContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#compop}.
   *
   * @param ctx the parse tree
   */
  void enterCompop(CodeQLParser.CompopContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#compop}.
   *
   * @param ctx the parse tree
   */
  void exitCompop(CodeQLParser.CompopContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#instanceof}.
   *
   * @param ctx the parse tree
   */
  void enterInstanceof(CodeQLParser.InstanceofContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#instanceof}.
   *
   * @param ctx the parse tree
   */
  void exitInstanceof(CodeQLParser.InstanceofContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#inrange}.
   *
   * @param ctx the parse tree
   */
  void enterInrange(CodeQLParser.InrangeContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#inrange}.
   *
   * @param ctx the parse tree
   */
  void exitInrange(CodeQLParser.InrangeContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#call}.
   *
   * @param ctx the parse tree
   */
  void enterCall(CodeQLParser.CallContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#call}.
   *
   * @param ctx the parse tree
   */
  void exitCall(CodeQLParser.CallContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#closure}.
   *
   * @param ctx the parse tree
   */
  void enterClosure(CodeQLParser.ClosureContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#closure}.
   *
   * @param ctx the parse tree
   */
  void exitClosure(CodeQLParser.ClosureContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#expr}.
   *
   * @param ctx the parse tree
   */
  void enterExpr(CodeQLParser.ExprContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#expr}.
   *
   * @param ctx the parse tree
   */
  void exitExpr(CodeQLParser.ExprContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#multExpr}.
   *
   * @param ctx the parse tree
   */
  void enterMultExpr(CodeQLParser.MultExprContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#multExpr}.
   *
   * @param ctx the parse tree
   */
  void exitMultExpr(CodeQLParser.MultExprContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#unaryExpr}.
   *
   * @param ctx the parse tree
   */
  void enterUnaryExpr(CodeQLParser.UnaryExprContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#unaryExpr}.
   *
   * @param ctx the parse tree
   */
  void exitUnaryExpr(CodeQLParser.UnaryExprContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#nonOpExpr}.
   *
   * @param ctx the parse tree
   */
  void enterNonOpExpr(CodeQLParser.NonOpExprContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#nonOpExpr}.
   *
   * @param ctx the parse tree
   */
  void exitNonOpExpr(CodeQLParser.NonOpExprContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#primary}.
   *
   * @param ctx the parse tree
   */
  void enterPrimary(CodeQLParser.PrimaryContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#primary}.
   *
   * @param ctx the parse tree
   */
  void exitPrimary(CodeQLParser.PrimaryContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#primaryPostfixOp}.
   *
   * @param ctx the parse tree
   */
  void enterPrimaryPostfixOp(CodeQLParser.PrimaryPostfixOpContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#primaryPostfixOp}.
   *
   * @param ctx the parse tree
   */
  void exitPrimaryPostfixOp(CodeQLParser.PrimaryPostfixOpContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#callwithresults_nomember}.
   *
   * @param ctx the parse tree
   */
  void enterCallwithresults_nomember(CodeQLParser.Callwithresults_nomemberContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#callwithresults_nomember}.
   *
   * @param ctx the parse tree
   */
  void exitCallwithresults_nomember(CodeQLParser.Callwithresults_nomemberContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#primaryBase}.
   *
   * @param ctx the parse tree
   */
  void enterPrimaryBase(CodeQLParser.PrimaryBaseContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#primaryBase}.
   *
   * @param ctx the parse tree
   */
  void exitPrimaryBase(CodeQLParser.PrimaryBaseContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#none}.
   *
   * @param ctx the parse tree
   */
  void enterNone(CodeQLParser.NoneContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#none}.
   *
   * @param ctx the parse tree
   */
  void exitNone(CodeQLParser.NoneContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#eparen}.
   *
   * @param ctx the parse tree
   */
  void enterEparen(CodeQLParser.EparenContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#eparen}.
   *
   * @param ctx the parse tree
   */
  void exitEparen(CodeQLParser.EparenContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#literal}.
   *
   * @param ctx the parse tree
   */
  void enterLiteral(CodeQLParser.LiteralContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#literal}.
   *
   * @param ctx the parse tree
   */
  void exitLiteral(CodeQLParser.LiteralContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#unop}.
   *
   * @param ctx the parse tree
   */
  void enterUnop(CodeQLParser.UnopContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#unop}.
   *
   * @param ctx the parse tree
   */
  void exitUnop(CodeQLParser.UnopContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#variable}.
   *
   * @param ctx the parse tree
   */
  void enterVariable(CodeQLParser.VariableContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#variable}.
   *
   * @param ctx the parse tree
   */
  void exitVariable(CodeQLParser.VariableContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#super_expr}.
   *
   * @param ctx the parse tree
   */
  void enterSuper_expr(CodeQLParser.Super_exprContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#super_expr}.
   *
   * @param ctx the parse tree
   */
  void exitSuper_expr(CodeQLParser.Super_exprContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#cast}.
   *
   * @param ctx the parse tree
   */
  void enterCast(CodeQLParser.CastContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#cast}.
   *
   * @param ctx the parse tree
   */
  void exitCast(CodeQLParser.CastContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#aggregation}.
   *
   * @param ctx the parse tree
   */
  void enterAggregation(CodeQLParser.AggregationContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#aggregation}.
   *
   * @param ctx the parse tree
   */
  void exitAggregation(CodeQLParser.AggregationContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#expression_pragma}.
   *
   * @param ctx the parse tree
   */
  void enterExpression_pragma(CodeQLParser.Expression_pragmaContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#expression_pragma}.
   *
   * @param ctx the parse tree
   */
  void exitExpression_pragma(CodeQLParser.Expression_pragmaContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#expression_pragma_type}.
   *
   * @param ctx the parse tree
   */
  void enterExpression_pragma_type(CodeQLParser.Expression_pragma_typeContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#expression_pragma_type}.
   *
   * @param ctx the parse tree
   */
  void exitExpression_pragma_type(CodeQLParser.Expression_pragma_typeContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#aggid}.
   *
   * @param ctx the parse tree
   */
  void enterAggid(CodeQLParser.AggidContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#aggid}.
   *
   * @param ctx the parse tree
   */
  void exitAggid(CodeQLParser.AggidContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#aggorderbys}.
   *
   * @param ctx the parse tree
   */
  void enterAggorderbys(CodeQLParser.AggorderbysContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#aggorderbys}.
   *
   * @param ctx the parse tree
   */
  void exitAggorderbys(CodeQLParser.AggorderbysContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#aggorderby}.
   *
   * @param ctx the parse tree
   */
  void enterAggorderby(CodeQLParser.AggorderbyContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#aggorderby}.
   *
   * @param ctx the parse tree
   */
  void exitAggorderby(CodeQLParser.AggorderbyContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#any}.
   *
   * @param ctx the parse tree
   */
  void enterAny(CodeQLParser.AnyContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#any}.
   *
   * @param ctx the parse tree
   */
  void exitAny(CodeQLParser.AnyContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#range}.
   *
   * @param ctx the parse tree
   */
  void enterRange(CodeQLParser.RangeContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#range}.
   *
   * @param ctx the parse tree
   */
  void exitRange(CodeQLParser.RangeContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#setliteral}.
   *
   * @param ctx the parse tree
   */
  void enterSetliteral(CodeQLParser.SetliteralContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#setliteral}.
   *
   * @param ctx the parse tree
   */
  void exitSetliteral(CodeQLParser.SetliteralContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#modulename}.
   *
   * @param ctx the parse tree
   */
  void enterModulename(CodeQLParser.ModulenameContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#modulename}.
   *
   * @param ctx the parse tree
   */
  void exitModulename(CodeQLParser.ModulenameContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#moduleSignatureName}.
   *
   * @param ctx the parse tree
   */
  void enterModuleSignatureName(CodeQLParser.ModuleSignatureNameContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#moduleSignatureName}.
   *
   * @param ctx the parse tree
   */
  void exitModuleSignatureName(CodeQLParser.ModuleSignatureNameContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#classname}.
   *
   * @param ctx the parse tree
   */
  void enterClassname(CodeQLParser.ClassnameContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#classname}.
   *
   * @param ctx the parse tree
   */
  void exitClassname(CodeQLParser.ClassnameContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#dbbasetype}.
   *
   * @param ctx the parse tree
   */
  void enterDbbasetype(CodeQLParser.DbbasetypeContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#dbbasetype}.
   *
   * @param ctx the parse tree
   */
  void exitDbbasetype(CodeQLParser.DbbasetypeContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#predicateRef}.
   *
   * @param ctx the parse tree
   */
  void enterPredicateRef(CodeQLParser.PredicateRefContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#predicateRef}.
   *
   * @param ctx the parse tree
   */
  void exitPredicateRef(CodeQLParser.PredicateRefContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#predicateName}.
   *
   * @param ctx the parse tree
   */
  void enterPredicateName(CodeQLParser.PredicateNameContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#predicateName}.
   *
   * @param ctx the parse tree
   */
  void exitPredicateName(CodeQLParser.PredicateNameContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#predicateCallName}.
   *
   * @param ctx the parse tree
   */
  void enterPredicateCallName(CodeQLParser.PredicateCallNameContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#predicateCallName}.
   *
   * @param ctx the parse tree
   */
  void exitPredicateCallName(CodeQLParser.PredicateCallNameContext ctx);

  /**
   * Enter a parse tree produced by {@link CodeQLParser#parameterName}.
   *
   * @param ctx the parse tree
   */
  void enterParameterName(CodeQLParser.ParameterNameContext ctx);

  /**
   * Exit a parse tree produced by {@link CodeQLParser#parameterName}.
   *
   * @param ctx the parse tree
   */
  void exitParameterName(CodeQLParser.ParameterNameContext ctx);
}
