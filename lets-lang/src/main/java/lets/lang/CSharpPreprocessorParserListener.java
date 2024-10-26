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
 * CSharpPreprocessorParser}.
 */
public interface CSharpPreprocessorParserListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by the {@code preprocessorDeclaration} labeled alternative in
   * {@link CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void enterPreprocessorDeclaration(CSharpPreprocessorParser.PreprocessorDeclarationContext ctx);

  /**
   * Exit a parse tree produced by the {@code preprocessorDeclaration} labeled alternative in {@link
   * CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void exitPreprocessorDeclaration(CSharpPreprocessorParser.PreprocessorDeclarationContext ctx);

  /**
   * Enter a parse tree produced by the {@code preprocessorConditional} labeled alternative in
   * {@link CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void enterPreprocessorConditional(CSharpPreprocessorParser.PreprocessorConditionalContext ctx);

  /**
   * Exit a parse tree produced by the {@code preprocessorConditional} labeled alternative in {@link
   * CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void exitPreprocessorConditional(CSharpPreprocessorParser.PreprocessorConditionalContext ctx);

  /**
   * Enter a parse tree produced by the {@code preprocessorLine} labeled alternative in {@link
   * CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void enterPreprocessorLine(CSharpPreprocessorParser.PreprocessorLineContext ctx);

  /**
   * Exit a parse tree produced by the {@code preprocessorLine} labeled alternative in {@link
   * CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void exitPreprocessorLine(CSharpPreprocessorParser.PreprocessorLineContext ctx);

  /**
   * Enter a parse tree produced by the {@code preprocessorDiagnostic} labeled alternative in {@link
   * CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void enterPreprocessorDiagnostic(CSharpPreprocessorParser.PreprocessorDiagnosticContext ctx);

  /**
   * Exit a parse tree produced by the {@code preprocessorDiagnostic} labeled alternative in {@link
   * CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void exitPreprocessorDiagnostic(CSharpPreprocessorParser.PreprocessorDiagnosticContext ctx);

  /**
   * Enter a parse tree produced by the {@code preprocessorRegion} labeled alternative in {@link
   * CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void enterPreprocessorRegion(CSharpPreprocessorParser.PreprocessorRegionContext ctx);

  /**
   * Exit a parse tree produced by the {@code preprocessorRegion} labeled alternative in {@link
   * CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void exitPreprocessorRegion(CSharpPreprocessorParser.PreprocessorRegionContext ctx);

  /**
   * Enter a parse tree produced by the {@code preprocessorPragma} labeled alternative in {@link
   * CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void enterPreprocessorPragma(CSharpPreprocessorParser.PreprocessorPragmaContext ctx);

  /**
   * Exit a parse tree produced by the {@code preprocessorPragma} labeled alternative in {@link
   * CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void exitPreprocessorPragma(CSharpPreprocessorParser.PreprocessorPragmaContext ctx);

  /**
   * Enter a parse tree produced by the {@code preprocessorNullable} labeled alternative in {@link
   * CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void enterPreprocessorNullable(CSharpPreprocessorParser.PreprocessorNullableContext ctx);

  /**
   * Exit a parse tree produced by the {@code preprocessorNullable} labeled alternative in {@link
   * CSharpPreprocessorParser#preprocessor_directive}.
   *
   * @param ctx the parse tree
   */
  void exitPreprocessorNullable(CSharpPreprocessorParser.PreprocessorNullableContext ctx);

  /**
   * Enter a parse tree produced by {@link CSharpPreprocessorParser#directive_new_line_or_sharp}.
   *
   * @param ctx the parse tree
   */
  void enterDirective_new_line_or_sharp(
      CSharpPreprocessorParser.Directive_new_line_or_sharpContext ctx);

  /**
   * Exit a parse tree produced by {@link CSharpPreprocessorParser#directive_new_line_or_sharp}.
   *
   * @param ctx the parse tree
   */
  void exitDirective_new_line_or_sharp(
      CSharpPreprocessorParser.Directive_new_line_or_sharpContext ctx);

  /**
   * Enter a parse tree produced by {@link CSharpPreprocessorParser#preprocessor_expression}.
   *
   * @param ctx the parse tree
   */
  void enterPreprocessor_expression(CSharpPreprocessorParser.Preprocessor_expressionContext ctx);

  /**
   * Exit a parse tree produced by {@link CSharpPreprocessorParser#preprocessor_expression}.
   *
   * @param ctx the parse tree
   */
  void exitPreprocessor_expression(CSharpPreprocessorParser.Preprocessor_expressionContext ctx);
}
