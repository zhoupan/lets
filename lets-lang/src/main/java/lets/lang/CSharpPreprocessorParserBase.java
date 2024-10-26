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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import org.antlr.v4.runtime.*;

abstract class CSharpPreprocessorParserBase extends Parser {
  protected CSharpPreprocessorParserBase(TokenStream input) {
    super(input);
    conditions.push(true);
    ConditionalSymbols.add("DEBUG");
  }

  private final Deque<Boolean> conditions = new ArrayDeque<>();
  public HashSet<String> ConditionalSymbols = new HashSet<String>();

  protected Boolean AllConditions() {
    for (Boolean condition : conditions) {
      if (!condition) return false;
    }
    return true;
  }

  protected void OnPreprocessorDirectiveDefine() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorDeclarationContext d =
        (CSharpPreprocessorParser.PreprocessorDeclarationContext) c;
    ConditionalSymbols.add(d.CONDITIONAL_SYMBOL().getText());
    d.value = AllConditions();
  }

  protected void OnPreprocessorDirectiveUndef() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorDeclarationContext d =
        (CSharpPreprocessorParser.PreprocessorDeclarationContext) c;
    ConditionalSymbols.remove(d.CONDITIONAL_SYMBOL().getText());
    d.value = AllConditions();
  }

  protected void OnPreprocessorDirectiveIf() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorConditionalContext d =
        (CSharpPreprocessorParser.PreprocessorConditionalContext) c;
    d.value = d.expr.value.equals("true") && AllConditions();
    conditions.push(d.expr.value.equals("true"));
  }

  protected void OnPreprocessorDirectiveElif() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorConditionalContext d =
        (CSharpPreprocessorParser.PreprocessorConditionalContext) c;
    if (!conditions.peek()) {
      conditions.pop();
      d.value = d.expr.value.equals("true") && AllConditions();
      conditions.push(d.expr.value.equals("true"));
    } else {
      d.value = false;
    }
  }

  protected void OnPreprocessorDirectiveElse() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorConditionalContext d =
        (CSharpPreprocessorParser.PreprocessorConditionalContext) c;
    if (!conditions.peek()) {
      conditions.pop();
      d.value = true && AllConditions();
      conditions.push(true);
    } else {
      d.value = false;
    }
  }

  protected void OnPreprocessorDirectiveEndif() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorConditionalContext d =
        (CSharpPreprocessorParser.PreprocessorConditionalContext) c;
    conditions.pop();
    d.value = conditions.peek();
  }

  protected void OnPreprocessorDirectiveLine() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorLineContext d =
        (CSharpPreprocessorParser.PreprocessorLineContext) c;
    d.value = AllConditions();
  }

  protected void OnPreprocessorDirectiveError() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorDiagnosticContext d =
        (CSharpPreprocessorParser.PreprocessorDiagnosticContext) c;
    d.value = AllConditions();
  }

  protected void OnPreprocessorDirectiveWarning() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorDiagnosticContext d =
        (CSharpPreprocessorParser.PreprocessorDiagnosticContext) c;
    d.value = AllConditions();
  }

  protected void OnPreprocessorDirectiveRegion() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorRegionContext d =
        (CSharpPreprocessorParser.PreprocessorRegionContext) c;
    d.value = AllConditions();
  }

  protected void OnPreprocessorDirectiveEndregion() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorRegionContext d =
        (CSharpPreprocessorParser.PreprocessorRegionContext) c;
    d.value = AllConditions();
  }

  protected void OnPreprocessorDirectivePragma() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorPragmaContext d =
        (CSharpPreprocessorParser.PreprocessorPragmaContext) c;
    d.value = AllConditions();
  }

  protected void OnPreprocessorDirectiveNullable() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.PreprocessorNullableContext d =
        (CSharpPreprocessorParser.PreprocessorNullableContext) c;
    d.value = AllConditions();
  }

  protected void OnPreprocessorExpressionTrue() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.Preprocessor_expressionContext d =
        (CSharpPreprocessorParser.Preprocessor_expressionContext) c;
    d.value = "true";
  }

  protected void OnPreprocessorExpressionFalse() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.Preprocessor_expressionContext d =
        (CSharpPreprocessorParser.Preprocessor_expressionContext) c;
    d.value = "false";
  }

  protected void OnPreprocessorExpressionConditionalSymbol() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.Preprocessor_expressionContext d =
        (CSharpPreprocessorParser.Preprocessor_expressionContext) c;
    d.value = ConditionalSymbols.contains(d.CONDITIONAL_SYMBOL().getText()) ? "true" : "false";
  }

  protected void OnPreprocessorExpressionConditionalOpenParens() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.Preprocessor_expressionContext d =
        (CSharpPreprocessorParser.Preprocessor_expressionContext) c;
    d.value = d.expr.value;
  }

  protected void OnPreprocessorExpressionConditionalBang() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.Preprocessor_expressionContext d =
        (CSharpPreprocessorParser.Preprocessor_expressionContext) c;
    d.value = d.expr.value.equals("true") ? "false" : "true";
  }

  protected void OnPreprocessorExpressionConditionalEq() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.Preprocessor_expressionContext d =
        (CSharpPreprocessorParser.Preprocessor_expressionContext) c;
    d.value = (d.expr1.value == d.expr2.value ? "true" : "false");
  }

  protected void OnPreprocessorExpressionConditionalNe() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.Preprocessor_expressionContext d =
        (CSharpPreprocessorParser.Preprocessor_expressionContext) c;
    d.value = (d.expr1.value != d.expr2.value ? "true" : "false");
  }

  protected void OnPreprocessorExpressionConditionalAnd() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.Preprocessor_expressionContext d =
        (CSharpPreprocessorParser.Preprocessor_expressionContext) c;
    d.value = (d.expr1.value.equals("true") && d.expr2.value.equals("true") ? "true" : "false");
  }

  protected void OnPreprocessorExpressionConditionalOr() {
    ParserRuleContext c = this._ctx;
    CSharpPreprocessorParser.Preprocessor_expressionContext d =
        (CSharpPreprocessorParser.Preprocessor_expressionContext) c;
    d.value = (d.expr1.value.equals("true") || d.expr2.value.equals("true") ? "true" : "false");
  }
}
