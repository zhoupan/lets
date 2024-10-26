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

import java.util.List;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CodeQLParser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int AND = 1,
      ANY = 2,
      AS = 3,
      ASC = 4,
      AVG = 5,
      BOOLEAN = 6,
      BY = 7,
      CLASS_ = 8,
      CONCAT = 9,
      COUNT = 10,
      DATE = 11,
      DESC = 12,
      ELSE = 13,
      EXISTS = 14,
      EXTENDS = 15,
      FALSE = 16,
      FLOAT = 17,
      FORALL = 18,
      FOREX = 19,
      FROM = 20,
      IF = 21,
      IMPLIES = 22,
      IMPORT = 23,
      IN = 24,
      INSTANCEOF = 25,
      INT = 26,
      MAX = 27,
      MIN = 28,
      MODULE = 29,
      NEWTYPE = 30,
      NONE = 31,
      NOT = 32,
      OR = 33,
      ORDER = 34,
      PREDICATE = 35,
      RANK = 36,
      RESULT = 37,
      SELECT = 38,
      STRICTCONCAT = 39,
      STRICTCOUNT = 40,
      STRICTSUM = 41,
      STRING = 42,
      SUM = 43,
      SUPER = 44,
      THEN = 45,
      THIS = 46,
      TRUE = 47,
      UNIQUE = 48,
      WHERE = 49,
      IMPLEMENTS = 50,
      SIGNATURE = 51,
      DEFAULT = 52,
      ABSTRACT = 53,
      CACHED = 54,
      EXTERNAL = 55,
      EXTENSIBLE = 56,
      FINAL = 57,
      TRANSIENT = 58,
      LIBRARY = 59,
      PRIVATE = 60,
      DEPRECATED = 61,
      OVERRIDE = 62,
      ADDITIONAL = 63,
      QUERY = 64,
      PRAGMA = 65,
      INLINE = 66,
      INLINE_LATE = 67,
      NOINLINE = 68,
      NOMAGIC = 69,
      NOOPT = 70,
      ASSUME_SMALL_DELTA = 71,
      LANGUAGE = 72,
      MONOTONICAGGREGATES = 73,
      BINDINGSET = 74,
      ONLY_BIND_OUT = 75,
      ONLY_BIND_INTO = 76,
      LT = 77,
      LE = 78,
      ASSIGN = 79,
      GT = 80,
      GE = 81,
      SUB = 82,
      DONTCARE = 83,
      COMMA = 84,
      SEMI = 85,
      NOTEQUAL = 86,
      DIV = 87,
      DOT = 88,
      DOTDOT = 89,
      LPAREN = 90,
      RPAREN = 91,
      LBRACE = 92,
      RBRACE = 93,
      LBRACK = 94,
      RBRACK = 95,
      MUL = 96,
      MOD = 97,
      ADD = 98,
      BITOR = 99,
      COLONCOLON = 100,
      INT_LITERAL = 101,
      FLOAT_LITERAL = 102,
      STRING_LITERAL = 103,
      AT = 104,
      WS = 105,
      COMMENT = 106,
      QL_DOC = 107,
      LINE_COMMENT = 108,
      LOWERID = 109,
      UPPERID = 110,
      ATLOWERID = 111;
  public static final int RULE_literalId = 0,
      RULE_keywordAllowed = 1,
      RULE_keywordPredCallAllowed = 2,
      RULE_varname = 3,
      RULE_ql = 4,
      RULE_module = 5,
      RULE_parameters = 6,
      RULE_implements = 7,
      RULE_moduleBody = 8,
      RULE_importDeclaration = 9,
      RULE_simpleId = 10,
      RULE_qualId = 11,
      RULE_importModuleExpr = 12,
      RULE_arguments = 13,
      RULE_argument = 14,
      RULE_signature = 15,
      RULE_predicateSignature = 16,
      RULE_typeSignature = 17,
      RULE_moduleSignature = 18,
      RULE_moduleSignatureBody = 19,
      RULE_signaturePredicate = 20,
      RULE_defaultPredicate = 21,
      RULE_signatureType = 22,
      RULE_select = 23,
      RULE_as_exprs = 24,
      RULE_as_expr = 25,
      RULE_orderbys = 26,
      RULE_orderby = 27,
      RULE_dtName = 28,
      RULE_dtBranches = 29,
      RULE_dtBranche = 30,
      RULE_dtBranchName = 31,
      RULE_datatype = 32,
      RULE_unionBranches = 33,
      RULE_typeunion = 34,
      RULE_predicate = 35,
      RULE_annotations = 36,
      RULE_annotation = 37,
      RULE_simpleAnnotation = 38,
      RULE_pragmaArg = 39,
      RULE_argsAnnotation = 40,
      RULE_head = 41,
      RULE_optbody = 42,
      RULE_class_ = 43,
      RULE_member = 44,
      RULE_character = 45,
      RULE_field = 46,
      RULE_moduleExpr = 47,
      RULE_moduleSignatureExpr = 48,
      RULE_signatureExpr = 49,
      RULE_type = 50,
      RULE_exprs = 51,
      RULE_alias = 52,
      RULE_var_decls = 53,
      RULE_var_decl = 54,
      RULE_formula = 55,
      RULE_formula_base = 56,
      RULE_conjunction_formula = 57,
      RULE_implies_formula = 58,
      RULE_fparen = 59,
      RULE_ifthen = 60,
      RULE_negated = 61,
      RULE_quantified = 62,
      RULE_comparison = 63,
      RULE_compop = 64,
      RULE_instanceof = 65,
      RULE_inrange = 66,
      RULE_call = 67,
      RULE_closure = 68,
      RULE_expr = 69,
      RULE_multExpr = 70,
      RULE_unaryExpr = 71,
      RULE_nonOpExpr = 72,
      RULE_primary = 73,
      RULE_primaryPostfixOp = 74,
      RULE_callwithresults_nomember = 75,
      RULE_primaryBase = 76,
      RULE_none = 77,
      RULE_eparen = 78,
      RULE_literal = 79,
      RULE_unop = 80,
      RULE_variable = 81,
      RULE_super_expr = 82,
      RULE_cast = 83,
      RULE_aggregation = 84,
      RULE_expression_pragma = 85,
      RULE_expression_pragma_type = 86,
      RULE_aggid = 87,
      RULE_aggorderbys = 88,
      RULE_aggorderby = 89,
      RULE_any = 90,
      RULE_range = 91,
      RULE_setliteral = 92,
      RULE_modulename = 93,
      RULE_moduleSignatureName = 94,
      RULE_classname = 95,
      RULE_dbbasetype = 96,
      RULE_predicateRef = 97,
      RULE_predicateName = 98,
      RULE_predicateCallName = 99,
      RULE_parameterName = 100;

  private static String[] makeRuleNames() {
    return new String[] {
      "literalId",
      "keywordAllowed",
      "keywordPredCallAllowed",
      "varname",
      "ql",
      "module",
      "parameters",
      "implements",
      "moduleBody",
      "importDeclaration",
      "simpleId",
      "qualId",
      "importModuleExpr",
      "arguments",
      "argument",
      "signature",
      "predicateSignature",
      "typeSignature",
      "moduleSignature",
      "moduleSignatureBody",
      "signaturePredicate",
      "defaultPredicate",
      "signatureType",
      "select",
      "as_exprs",
      "as_expr",
      "orderbys",
      "orderby",
      "dtName",
      "dtBranches",
      "dtBranche",
      "dtBranchName",
      "datatype",
      "unionBranches",
      "typeunion",
      "predicate",
      "annotations",
      "annotation",
      "simpleAnnotation",
      "pragmaArg",
      "argsAnnotation",
      "head",
      "optbody",
      "class_",
      "member",
      "character",
      "field",
      "moduleExpr",
      "moduleSignatureExpr",
      "signatureExpr",
      "type",
      "exprs",
      "alias",
      "var_decls",
      "var_decl",
      "formula",
      "formula_base",
      "conjunction_formula",
      "implies_formula",
      "fparen",
      "ifthen",
      "negated",
      "quantified",
      "comparison",
      "compop",
      "instanceof",
      "inrange",
      "call",
      "closure",
      "expr",
      "multExpr",
      "unaryExpr",
      "nonOpExpr",
      "primary",
      "primaryPostfixOp",
      "callwithresults_nomember",
      "primaryBase",
      "none",
      "eparen",
      "literal",
      "unop",
      "variable",
      "super_expr",
      "cast",
      "aggregation",
      "expression_pragma",
      "expression_pragma_type",
      "aggid",
      "aggorderbys",
      "aggorderby",
      "any",
      "range",
      "setliteral",
      "modulename",
      "moduleSignatureName",
      "classname",
      "dbbasetype",
      "predicateRef",
      "predicateName",
      "predicateCallName",
      "parameterName"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null,
      "'and'",
      "'any'",
      "'as'",
      "'asc'",
      "'avg'",
      "'boolean'",
      "'by'",
      "'class'",
      "'concat'",
      "'count'",
      "'date'",
      "'desc'",
      "'else'",
      "'exists'",
      "'extends'",
      "'false'",
      "'float'",
      "'forall'",
      "'forex'",
      "'from'",
      "'if'",
      "'implies'",
      "'import'",
      "'in'",
      "'instanceof'",
      "'int'",
      "'max'",
      "'min'",
      "'module'",
      "'newtype'",
      "'none'",
      "'not'",
      "'or'",
      "'order'",
      "'predicate'",
      "'rank'",
      "'result'",
      "'select'",
      "'strictconcat'",
      "'strictcount'",
      "'strictsum'",
      "'string'",
      "'sum'",
      "'super'",
      "'then'",
      "'this'",
      "'true'",
      "'unique'",
      "'where'",
      "'implements'",
      "'signature'",
      "'default'",
      "'abstract'",
      "'cached'",
      "'external'",
      "'extensible'",
      "'final'",
      "'transient'",
      "'library'",
      "'private'",
      "'deprecated'",
      "'override'",
      "'additional'",
      "'query'",
      "'pragma'",
      "'inline'",
      "'inline_late'",
      "'noinline'",
      "'nomagic'",
      "'noopt'",
      "'assume_small_delta'",
      "'language'",
      "'monotonicAggregates'",
      "'bindingset'",
      "'only_bind_out'",
      "'only_bind_into'",
      "'<'",
      "'<='",
      "'='",
      "'>'",
      "'>='",
      "'-'",
      "'_'",
      "','",
      "';'",
      "'!='",
      "'/'",
      "'.'",
      "'..'",
      "'('",
      "')'",
      "'{'",
      "'}'",
      "'['",
      "']'",
      "'*'",
      "'%'",
      "'+'",
      "'|'",
      "'::'",
      null,
      null,
      null,
      "'@'"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      "AND",
      "ANY",
      "AS",
      "ASC",
      "AVG",
      "BOOLEAN",
      "BY",
      "CLASS_",
      "CONCAT",
      "COUNT",
      "DATE",
      "DESC",
      "ELSE",
      "EXISTS",
      "EXTENDS",
      "FALSE",
      "FLOAT",
      "FORALL",
      "FOREX",
      "FROM",
      "IF",
      "IMPLIES",
      "IMPORT",
      "IN",
      "INSTANCEOF",
      "INT",
      "MAX",
      "MIN",
      "MODULE",
      "NEWTYPE",
      "NONE",
      "NOT",
      "OR",
      "ORDER",
      "PREDICATE",
      "RANK",
      "RESULT",
      "SELECT",
      "STRICTCONCAT",
      "STRICTCOUNT",
      "STRICTSUM",
      "STRING",
      "SUM",
      "SUPER",
      "THEN",
      "THIS",
      "TRUE",
      "UNIQUE",
      "WHERE",
      "IMPLEMENTS",
      "SIGNATURE",
      "DEFAULT",
      "ABSTRACT",
      "CACHED",
      "EXTERNAL",
      "EXTENSIBLE",
      "FINAL",
      "TRANSIENT",
      "LIBRARY",
      "PRIVATE",
      "DEPRECATED",
      "OVERRIDE",
      "ADDITIONAL",
      "QUERY",
      "PRAGMA",
      "INLINE",
      "INLINE_LATE",
      "NOINLINE",
      "NOMAGIC",
      "NOOPT",
      "ASSUME_SMALL_DELTA",
      "LANGUAGE",
      "MONOTONICAGGREGATES",
      "BINDINGSET",
      "ONLY_BIND_OUT",
      "ONLY_BIND_INTO",
      "LT",
      "LE",
      "ASSIGN",
      "GT",
      "GE",
      "SUB",
      "DONTCARE",
      "COMMA",
      "SEMI",
      "NOTEQUAL",
      "DIV",
      "DOT",
      "DOTDOT",
      "LPAREN",
      "RPAREN",
      "LBRACE",
      "RBRACE",
      "LBRACK",
      "RBRACK",
      "MUL",
      "MOD",
      "ADD",
      "BITOR",
      "COLONCOLON",
      "INT_LITERAL",
      "FLOAT_LITERAL",
      "STRING_LITERAL",
      "AT",
      "WS",
      "COMMENT",
      "QL_DOC",
      "LINE_COMMENT",
      "LOWERID",
      "UPPERID",
      "ATLOWERID"
    };
  }

  private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated public static final String[] tokenNames;

  static {
    tokenNames = new String[_SYMBOLIC_NAMES.length];
    for (int i = 0; i < tokenNames.length; i++) {
      tokenNames[i] = VOCABULARY.getLiteralName(i);
      if (tokenNames[i] == null) {
        tokenNames[i] = VOCABULARY.getSymbolicName(i);
      }

      if (tokenNames[i] == null) {
        tokenNames[i] = "<INVALID>";
      }
    }
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return tokenNames;
  }

  @Override
  public Vocabulary getVocabulary() {
    return VOCABULARY;
  }

  @Override
  public String getGrammarFileName() {
    return "CodeQLParser.g4";
  }

  @Override
  public String[] getRuleNames() {
    return ruleNames;
  }

  @Override
  public String getSerializedATN() {
    return _serializedATN;
  }

  @Override
  public ATN getATN() {
    return _ATN;
  }

  public CodeQLParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LiteralIdContext extends ParserRuleContext {
    public TerminalNode LOWERID() {
      return getToken(CodeQLParser.LOWERID, 0);
    }

    public TerminalNode ATLOWERID() {
      return getToken(CodeQLParser.ATLOWERID, 0);
    }

    public TerminalNode UPPERID() {
      return getToken(CodeQLParser.UPPERID, 0);
    }

    public TerminalNode NONE() {
      return getToken(CodeQLParser.NONE, 0);
    }

    public TerminalNode ANY() {
      return getToken(CodeQLParser.ANY, 0);
    }

    public KeywordAllowedContext keywordAllowed() {
      return getRuleContext(KeywordAllowedContext.class, 0);
    }

    public LiteralIdContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_literalId;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterLiteralId(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitLiteralId(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitLiteralId(this);
      else return visitor.visitChildren(this);
    }
  }

  public final LiteralIdContext literalId() throws RecognitionException {
    LiteralIdContext _localctx = new LiteralIdContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_literalId);
    try {
      setState(208);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case LOWERID:
          enterOuterAlt(_localctx, 1);
          {
            setState(202);
            match(LOWERID);
          }
          break;
        case ATLOWERID:
          enterOuterAlt(_localctx, 2);
          {
            setState(203);
            match(ATLOWERID);
          }
          break;
        case UPPERID:
          enterOuterAlt(_localctx, 3);
          {
            setState(204);
            match(UPPERID);
          }
          break;
        case NONE:
          enterOuterAlt(_localctx, 4);
          {
            setState(205);
            match(NONE);
          }
          break;
        case ANY:
          enterOuterAlt(_localctx, 5);
          {
            setState(206);
            match(ANY);
          }
          break;
        case UNIQUE:
        case IMPLEMENTS:
        case SIGNATURE:
        case DEFAULT:
        case ABSTRACT:
        case CACHED:
        case EXTERNAL:
        case EXTENSIBLE:
        case FINAL:
        case TRANSIENT:
        case LIBRARY:
        case PRIVATE:
        case DEPRECATED:
        case OVERRIDE:
        case ADDITIONAL:
        case QUERY:
        case PRAGMA:
        case INLINE:
        case INLINE_LATE:
        case NOINLINE:
        case NOMAGIC:
        case NOOPT:
        case ASSUME_SMALL_DELTA:
        case LANGUAGE:
        case MONOTONICAGGREGATES:
        case BINDINGSET:
        case ONLY_BIND_OUT:
        case ONLY_BIND_INTO:
          enterOuterAlt(_localctx, 6);
          {
            setState(207);
            keywordAllowed();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class KeywordAllowedContext extends ParserRuleContext {
    public TerminalNode UNIQUE() {
      return getToken(CodeQLParser.UNIQUE, 0);
    }

    public TerminalNode IMPLEMENTS() {
      return getToken(CodeQLParser.IMPLEMENTS, 0);
    }

    public TerminalNode SIGNATURE() {
      return getToken(CodeQLParser.SIGNATURE, 0);
    }

    public TerminalNode DEFAULT() {
      return getToken(CodeQLParser.DEFAULT, 0);
    }

    public TerminalNode ABSTRACT() {
      return getToken(CodeQLParser.ABSTRACT, 0);
    }

    public TerminalNode CACHED() {
      return getToken(CodeQLParser.CACHED, 0);
    }

    public TerminalNode EXTERNAL() {
      return getToken(CodeQLParser.EXTERNAL, 0);
    }

    public TerminalNode EXTENSIBLE() {
      return getToken(CodeQLParser.EXTENSIBLE, 0);
    }

    public TerminalNode FINAL() {
      return getToken(CodeQLParser.FINAL, 0);
    }

    public TerminalNode TRANSIENT() {
      return getToken(CodeQLParser.TRANSIENT, 0);
    }

    public TerminalNode LIBRARY() {
      return getToken(CodeQLParser.LIBRARY, 0);
    }

    public TerminalNode PRIVATE() {
      return getToken(CodeQLParser.PRIVATE, 0);
    }

    public TerminalNode DEPRECATED() {
      return getToken(CodeQLParser.DEPRECATED, 0);
    }

    public TerminalNode OVERRIDE() {
      return getToken(CodeQLParser.OVERRIDE, 0);
    }

    public TerminalNode ADDITIONAL() {
      return getToken(CodeQLParser.ADDITIONAL, 0);
    }

    public TerminalNode QUERY() {
      return getToken(CodeQLParser.QUERY, 0);
    }

    public TerminalNode PRAGMA() {
      return getToken(CodeQLParser.PRAGMA, 0);
    }

    public TerminalNode INLINE() {
      return getToken(CodeQLParser.INLINE, 0);
    }

    public TerminalNode INLINE_LATE() {
      return getToken(CodeQLParser.INLINE_LATE, 0);
    }

    public TerminalNode NOINLINE() {
      return getToken(CodeQLParser.NOINLINE, 0);
    }

    public TerminalNode NOMAGIC() {
      return getToken(CodeQLParser.NOMAGIC, 0);
    }

    public TerminalNode NOOPT() {
      return getToken(CodeQLParser.NOOPT, 0);
    }

    public TerminalNode ASSUME_SMALL_DELTA() {
      return getToken(CodeQLParser.ASSUME_SMALL_DELTA, 0);
    }

    public TerminalNode LANGUAGE() {
      return getToken(CodeQLParser.LANGUAGE, 0);
    }

    public TerminalNode MONOTONICAGGREGATES() {
      return getToken(CodeQLParser.MONOTONICAGGREGATES, 0);
    }

    public TerminalNode BINDINGSET() {
      return getToken(CodeQLParser.BINDINGSET, 0);
    }

    public TerminalNode ONLY_BIND_OUT() {
      return getToken(CodeQLParser.ONLY_BIND_OUT, 0);
    }

    public TerminalNode ONLY_BIND_INTO() {
      return getToken(CodeQLParser.ONLY_BIND_INTO, 0);
    }

    public KeywordAllowedContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_keywordAllowed;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterKeywordAllowed(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitKeywordAllowed(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitKeywordAllowed(this);
      else return visitor.visitChildren(this);
    }
  }

  public final KeywordAllowedContext keywordAllowed() throws RecognitionException {
    KeywordAllowedContext _localctx = new KeywordAllowedContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_keywordAllowed);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(210);
        _la = _input.LA(1);
        if (!(((((_la - 48)) & ~0x3f) == 0 && ((1L << (_la - 48)) & 536870909L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class KeywordPredCallAllowedContext extends ParserRuleContext {
    public KeywordAllowedContext keywordAllowed() {
      return getRuleContext(KeywordAllowedContext.class, 0);
    }

    public TerminalNode ANY() {
      return getToken(CodeQLParser.ANY, 0);
    }

    public TerminalNode NONE() {
      return getToken(CodeQLParser.NONE, 0);
    }

    public KeywordPredCallAllowedContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_keywordPredCallAllowed;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterKeywordPredCallAllowed(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitKeywordPredCallAllowed(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitKeywordPredCallAllowed(this);
      else return visitor.visitChildren(this);
    }
  }

  public final KeywordPredCallAllowedContext keywordPredCallAllowed() throws RecognitionException {
    KeywordPredCallAllowedContext _localctx = new KeywordPredCallAllowedContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_keywordPredCallAllowed);
    try {
      setState(215);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case UNIQUE:
        case IMPLEMENTS:
        case SIGNATURE:
        case DEFAULT:
        case ABSTRACT:
        case CACHED:
        case EXTERNAL:
        case EXTENSIBLE:
        case FINAL:
        case TRANSIENT:
        case LIBRARY:
        case PRIVATE:
        case DEPRECATED:
        case OVERRIDE:
        case ADDITIONAL:
        case QUERY:
        case PRAGMA:
        case INLINE:
        case INLINE_LATE:
        case NOINLINE:
        case NOMAGIC:
        case NOOPT:
        case ASSUME_SMALL_DELTA:
        case LANGUAGE:
        case MONOTONICAGGREGATES:
        case BINDINGSET:
        case ONLY_BIND_OUT:
        case ONLY_BIND_INTO:
          enterOuterAlt(_localctx, 1);
          {
            setState(212);
            keywordAllowed();
          }
          break;
        case ANY:
          enterOuterAlt(_localctx, 2);
          {
            setState(213);
            match(ANY);
          }
          break;
        case NONE:
          enterOuterAlt(_localctx, 3);
          {
            setState(214);
            match(NONE);
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class VarnameContext extends ParserRuleContext {
    public TerminalNode LOWERID() {
      return getToken(CodeQLParser.LOWERID, 0);
    }

    public KeywordAllowedContext keywordAllowed() {
      return getRuleContext(KeywordAllowedContext.class, 0);
    }

    public VarnameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_varname;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterVarname(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitVarname(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitVarname(this);
      else return visitor.visitChildren(this);
    }
  }

  public final VarnameContext varname() throws RecognitionException {
    VarnameContext _localctx = new VarnameContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_varname);
    try {
      setState(219);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case LOWERID:
          enterOuterAlt(_localctx, 1);
          {
            setState(217);
            match(LOWERID);
          }
          break;
        case UNIQUE:
        case IMPLEMENTS:
        case SIGNATURE:
        case DEFAULT:
        case ABSTRACT:
        case CACHED:
        case EXTERNAL:
        case EXTENSIBLE:
        case FINAL:
        case TRANSIENT:
        case LIBRARY:
        case PRIVATE:
        case DEPRECATED:
        case OVERRIDE:
        case ADDITIONAL:
        case QUERY:
        case PRAGMA:
        case INLINE:
        case INLINE_LATE:
        case NOINLINE:
        case NOMAGIC:
        case NOOPT:
        case ASSUME_SMALL_DELTA:
        case LANGUAGE:
        case MONOTONICAGGREGATES:
        case BINDINGSET:
        case ONLY_BIND_OUT:
        case ONLY_BIND_INTO:
          enterOuterAlt(_localctx, 2);
          {
            setState(218);
            keywordAllowed();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class QlContext extends ParserRuleContext {
    public ModuleBodyContext moduleBody() {
      return getRuleContext(ModuleBodyContext.class, 0);
    }

    public TerminalNode EOF() {
      return getToken(CodeQLParser.EOF, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public QlContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ql;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener) ((CodeQLParserListener) listener).enterQl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener) ((CodeQLParserListener) listener).exitQl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitQl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final QlContext ql() throws RecognitionException {
    QlContext _localctx = new QlContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_ql);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(222);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
          case 1:
            {
              setState(221);
              match(QL_DOC);
            }
            break;
        }
        setState(224);
        moduleBody();
        setState(225);
        match(EOF);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ModuleContext extends ParserRuleContext {
    public TerminalNode MODULE() {
      return getToken(CodeQLParser.MODULE, 0);
    }

    public ModulenameContext modulename() {
      return getRuleContext(ModulenameContext.class, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(CodeQLParser.LBRACE, 0);
    }

    public ModuleBodyContext moduleBody() {
      return getRuleContext(ModuleBodyContext.class, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(CodeQLParser.RBRACE, 0);
    }

    public List<AnnotationContext> annotation() {
      return getRuleContexts(AnnotationContext.class);
    }

    public AnnotationContext annotation(int i) {
      return getRuleContext(AnnotationContext.class, i);
    }

    public ParametersContext parameters() {
      return getRuleContext(ParametersContext.class, 0);
    }

    public ImplementsContext implements_() {
      return getRuleContext(ImplementsContext.class, 0);
    }

    public ModuleContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_module;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterModule(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitModule(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitModule(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ModuleContext module() throws RecognitionException {
    ModuleContext _localctx = new ModuleContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_module);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(230);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & 2629631L) != 0)) {
          {
            {
              setState(227);
              annotation();
            }
          }
          setState(232);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(233);
        match(MODULE);
        setState(234);
        modulename();
        setState(236);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LT) {
          {
            setState(235);
            parameters();
          }
        }

        setState(239);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == IMPLEMENTS) {
          {
            setState(238);
            implements_();
          }
        }

        setState(241);
        match(LBRACE);
        setState(242);
        moduleBody();
        setState(243);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ParametersContext extends ParserRuleContext {
    public TerminalNode LT() {
      return getToken(CodeQLParser.LT, 0);
    }

    public List<SignatureExprContext> signatureExpr() {
      return getRuleContexts(SignatureExprContext.class);
    }

    public SignatureExprContext signatureExpr(int i) {
      return getRuleContext(SignatureExprContext.class, i);
    }

    public List<ParameterNameContext> parameterName() {
      return getRuleContexts(ParameterNameContext.class);
    }

    public ParameterNameContext parameterName(int i) {
      return getRuleContext(ParameterNameContext.class, i);
    }

    public TerminalNode GT() {
      return getToken(CodeQLParser.GT, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public ParametersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_parameters;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterParameters(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitParameters(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitParameters(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ParametersContext parameters() throws RecognitionException {
    ParametersContext _localctx = new ParametersContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_parameters);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(245);
        match(LT);
        setState(246);
        signatureExpr();
        setState(247);
        parameterName();
        setState(254);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(248);
              match(COMMA);
              setState(249);
              signatureExpr();
              setState(250);
              parameterName();
            }
          }
          setState(256);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(257);
        match(GT);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ImplementsContext extends ParserRuleContext {
    public TerminalNode IMPLEMENTS() {
      return getToken(CodeQLParser.IMPLEMENTS, 0);
    }

    public List<ModuleSignatureExprContext> moduleSignatureExpr() {
      return getRuleContexts(ModuleSignatureExprContext.class);
    }

    public ModuleSignatureExprContext moduleSignatureExpr(int i) {
      return getRuleContext(ModuleSignatureExprContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public ImplementsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_implements;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterImplements(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitImplements(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitImplements(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ImplementsContext implements_() throws RecognitionException {
    ImplementsContext _localctx = new ImplementsContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_implements);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(259);
        match(IMPLEMENTS);
        setState(260);
        moduleSignatureExpr();
        setState(265);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(261);
              match(COMMA);
              setState(262);
              moduleSignatureExpr();
            }
          }
          setState(267);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ModuleBodyContext extends ParserRuleContext {
    public List<ImportDeclarationContext> importDeclaration() {
      return getRuleContexts(ImportDeclarationContext.class);
    }

    public ImportDeclarationContext importDeclaration(int i) {
      return getRuleContext(ImportDeclarationContext.class, i);
    }

    public List<PredicateContext> predicate() {
      return getRuleContexts(PredicateContext.class);
    }

    public PredicateContext predicate(int i) {
      return getRuleContext(PredicateContext.class, i);
    }

    public List<SignatureContext> signature() {
      return getRuleContexts(SignatureContext.class);
    }

    public SignatureContext signature(int i) {
      return getRuleContext(SignatureContext.class, i);
    }

    public List<DatatypeContext> datatype() {
      return getRuleContexts(DatatypeContext.class);
    }

    public DatatypeContext datatype(int i) {
      return getRuleContext(DatatypeContext.class, i);
    }

    public List<TypeunionContext> typeunion() {
      return getRuleContexts(TypeunionContext.class);
    }

    public TypeunionContext typeunion(int i) {
      return getRuleContext(TypeunionContext.class, i);
    }

    public List<Class_Context> class_() {
      return getRuleContexts(Class_Context.class);
    }

    public Class_Context class_(int i) {
      return getRuleContext(Class_Context.class, i);
    }

    public List<ModuleContext> module() {
      return getRuleContexts(ModuleContext.class);
    }

    public ModuleContext module(int i) {
      return getRuleContext(ModuleContext.class, i);
    }

    public List<AliasContext> alias() {
      return getRuleContexts(AliasContext.class);
    }

    public AliasContext alias(int i) {
      return getRuleContext(AliasContext.class, i);
    }

    public List<SelectContext> select() {
      return getRuleContexts(SelectContext.class);
    }

    public SelectContext select(int i) {
      return getRuleContext(SelectContext.class, i);
    }

    public ModuleBodyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_moduleBody;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterModuleBody(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitModuleBody(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitModuleBody(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ModuleBodyContext moduleBody() throws RecognitionException {
    ModuleBodyContext _localctx = new ModuleBodyContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_moduleBody);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(279);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6187740516185792L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 255086697645315L) != 0)) {
          {
            setState(277);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 9, _ctx)) {
              case 1:
                {
                  setState(268);
                  importDeclaration();
                }
                break;
              case 2:
                {
                  setState(269);
                  predicate();
                }
                break;
              case 3:
                {
                  setState(270);
                  signature();
                }
                break;
              case 4:
                {
                  setState(271);
                  datatype();
                }
                break;
              case 5:
                {
                  setState(272);
                  typeunion();
                }
                break;
              case 6:
                {
                  setState(273);
                  class_();
                }
                break;
              case 7:
                {
                  setState(274);
                  module();
                }
                break;
              case 8:
                {
                  setState(275);
                  alias();
                }
                break;
              case 9:
                {
                  setState(276);
                  select();
                }
                break;
            }
          }
          setState(281);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ImportDeclarationContext extends ParserRuleContext {
    public AnnotationsContext annotations() {
      return getRuleContext(AnnotationsContext.class, 0);
    }

    public TerminalNode IMPORT() {
      return getToken(CodeQLParser.IMPORT, 0);
    }

    public ImportModuleExprContext importModuleExpr() {
      return getRuleContext(ImportModuleExprContext.class, 0);
    }

    public TerminalNode AS() {
      return getToken(CodeQLParser.AS, 0);
    }

    public ModulenameContext modulename() {
      return getRuleContext(ModulenameContext.class, 0);
    }

    public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_importDeclaration;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterImportDeclaration(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitImportDeclaration(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitImportDeclaration(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ImportDeclarationContext importDeclaration() throws RecognitionException {
    ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_importDeclaration);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(282);
        annotations();
        setState(283);
        match(IMPORT);
        setState(284);
        importModuleExpr(0);
        setState(287);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == AS) {
          {
            setState(285);
            match(AS);
            setState(286);
            modulename();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SimpleIdContext extends ParserRuleContext {
    public TerminalNode LOWERID() {
      return getToken(CodeQLParser.LOWERID, 0);
    }

    public TerminalNode UPPERID() {
      return getToken(CodeQLParser.UPPERID, 0);
    }

    public SimpleIdContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_simpleId;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterSimpleId(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitSimpleId(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitSimpleId(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SimpleIdContext simpleId() throws RecognitionException {
    SimpleIdContext _localctx = new SimpleIdContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_simpleId);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(289);
        _la = _input.LA(1);
        if (!(_la == LOWERID || _la == UPPERID)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class QualIdContext extends ParserRuleContext {
    public SimpleIdContext simpleId() {
      return getRuleContext(SimpleIdContext.class, 0);
    }

    public QualIdContext qualId() {
      return getRuleContext(QualIdContext.class, 0);
    }

    public TerminalNode DOT() {
      return getToken(CodeQLParser.DOT, 0);
    }

    public QualIdContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_qualId;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterQualId(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitQualId(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitQualId(this);
      else return visitor.visitChildren(this);
    }
  }

  public final QualIdContext qualId() throws RecognitionException {
    return qualId(0);
  }

  private QualIdContext qualId(int _p) throws RecognitionException {
    ParserRuleContext _parentctx = _ctx;
    int _parentState = getState();
    QualIdContext _localctx = new QualIdContext(_ctx, _parentState);
    QualIdContext _prevctx = _localctx;
    int _startState = 22;
    enterRecursionRule(_localctx, 22, RULE_qualId, _p);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        {
          setState(292);
          simpleId();
        }
        _ctx.stop = _input.LT(-1);
        setState(299);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (_parseListeners != null) triggerExitRuleEvent();
            _prevctx = _localctx;
            {
              {
                _localctx = new QualIdContext(_parentctx, _parentState);
                pushNewRecursionContext(_localctx, _startState, RULE_qualId);
                setState(294);
                if (!(precpred(_ctx, 1)))
                  throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                setState(295);
                match(DOT);
                setState(296);
                simpleId();
              }
            }
          }
          setState(301);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ImportModuleExprContext extends ParserRuleContext {
    public QualIdContext qualId() {
      return getRuleContext(QualIdContext.class, 0);
    }

    public ImportModuleExprContext importModuleExpr() {
      return getRuleContext(ImportModuleExprContext.class, 0);
    }

    public TerminalNode COLONCOLON() {
      return getToken(CodeQLParser.COLONCOLON, 0);
    }

    public ModulenameContext modulename() {
      return getRuleContext(ModulenameContext.class, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public ImportModuleExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_importModuleExpr;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterImportModuleExpr(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitImportModuleExpr(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitImportModuleExpr(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ImportModuleExprContext importModuleExpr() throws RecognitionException {
    return importModuleExpr(0);
  }

  private ImportModuleExprContext importModuleExpr(int _p) throws RecognitionException {
    ParserRuleContext _parentctx = _ctx;
    int _parentState = getState();
    ImportModuleExprContext _localctx = new ImportModuleExprContext(_ctx, _parentState);
    ImportModuleExprContext _prevctx = _localctx;
    int _startState = 24;
    enterRecursionRule(_localctx, 24, RULE_importModuleExpr, _p);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        {
          setState(303);
          qualId(0);
        }
        _ctx.stop = _input.LT(-1);
        setState(313);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 14, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (_parseListeners != null) triggerExitRuleEvent();
            _prevctx = _localctx;
            {
              {
                _localctx = new ImportModuleExprContext(_parentctx, _parentState);
                pushNewRecursionContext(_localctx, _startState, RULE_importModuleExpr);
                setState(305);
                if (!(precpred(_ctx, 1)))
                  throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                setState(306);
                match(COLONCOLON);
                setState(307);
                modulename();
                setState(309);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 13, _ctx)) {
                  case 1:
                    {
                      setState(308);
                      arguments();
                    }
                    break;
                }
              }
            }
          }
          setState(315);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 14, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArgumentsContext extends ParserRuleContext {
    public TerminalNode LT() {
      return getToken(CodeQLParser.LT, 0);
    }

    public List<ArgumentContext> argument() {
      return getRuleContexts(ArgumentContext.class);
    }

    public ArgumentContext argument(int i) {
      return getRuleContext(ArgumentContext.class, i);
    }

    public TerminalNode GT() {
      return getToken(CodeQLParser.GT, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public ArgumentsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_arguments;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterArguments(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitArguments(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitArguments(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentsContext arguments() throws RecognitionException {
    ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_arguments);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(316);
        match(LT);
        setState(317);
        argument();
        setState(322);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(318);
              match(COMMA);
              setState(319);
              argument();
            }
          }
          setState(324);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(325);
        match(GT);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArgumentContext extends ParserRuleContext {
    public ModuleExprContext moduleExpr() {
      return getRuleContext(ModuleExprContext.class, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public PredicateRefContext predicateRef() {
      return getRuleContext(PredicateRefContext.class, 0);
    }

    public TerminalNode DIV() {
      return getToken(CodeQLParser.DIV, 0);
    }

    public TerminalNode INT_LITERAL() {
      return getToken(CodeQLParser.INT_LITERAL, 0);
    }

    public ArgumentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_argument;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterArgument(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitArgument(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitArgument(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgumentContext argument() throws RecognitionException {
    ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_argument);
    try {
      setState(333);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(327);
            moduleExpr(0);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(328);
            type();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(329);
            predicateRef();
            setState(330);
            match(DIV);
            setState(331);
            match(INT_LITERAL);
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SignatureContext extends ParserRuleContext {
    public PredicateSignatureContext predicateSignature() {
      return getRuleContext(PredicateSignatureContext.class, 0);
    }

    public TypeSignatureContext typeSignature() {
      return getRuleContext(TypeSignatureContext.class, 0);
    }

    public ModuleSignatureContext moduleSignature() {
      return getRuleContext(ModuleSignatureContext.class, 0);
    }

    public SignatureContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_signature;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterSignature(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitSignature(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitSignature(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SignatureContext signature() throws RecognitionException {
    SignatureContext _localctx = new SignatureContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_signature);
    try {
      setState(338);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 17, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(335);
            predicateSignature();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(336);
            typeSignature();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(337);
            moduleSignature();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PredicateSignatureContext extends ParserRuleContext {
    public TerminalNode SIGNATURE() {
      return getToken(CodeQLParser.SIGNATURE, 0);
    }

    public HeadContext head() {
      return getRuleContext(HeadContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(CodeQLParser.SEMI, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public List<AnnotationContext> annotation() {
      return getRuleContexts(AnnotationContext.class);
    }

    public AnnotationContext annotation(int i) {
      return getRuleContext(AnnotationContext.class, i);
    }

    public PredicateSignatureContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_predicateSignature;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterPredicateSignature(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitPredicateSignature(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitPredicateSignature(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PredicateSignatureContext predicateSignature() throws RecognitionException {
    PredicateSignatureContext _localctx = new PredicateSignatureContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_predicateSignature);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(341);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == QL_DOC) {
          {
            setState(340);
            match(QL_DOC);
          }
        }

        setState(346);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & 2629631L) != 0)) {
          {
            {
              setState(343);
              annotation();
            }
          }
          setState(348);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(349);
        match(SIGNATURE);
        setState(350);
        head();
        setState(351);
        match(SEMI);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeSignatureContext extends ParserRuleContext {
    public AnnotationsContext annotations() {
      return getRuleContext(AnnotationsContext.class, 0);
    }

    public TerminalNode SIGNATURE() {
      return getToken(CodeQLParser.SIGNATURE, 0);
    }

    public TerminalNode CLASS_() {
      return getToken(CodeQLParser.CLASS_, 0);
    }

    public ClassnameContext classname() {
      return getRuleContext(ClassnameContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(CodeQLParser.SEMI, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(CodeQLParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(CodeQLParser.RBRACE, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public TerminalNode EXTENDS() {
      return getToken(CodeQLParser.EXTENDS, 0);
    }

    public List<TypeContext> type() {
      return getRuleContexts(TypeContext.class);
    }

    public TypeContext type(int i) {
      return getRuleContext(TypeContext.class, i);
    }

    public List<SignaturePredicateContext> signaturePredicate() {
      return getRuleContexts(SignaturePredicateContext.class);
    }

    public SignaturePredicateContext signaturePredicate(int i) {
      return getRuleContext(SignaturePredicateContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public TypeSignatureContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeSignature;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterTypeSignature(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitTypeSignature(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitTypeSignature(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TypeSignatureContext typeSignature() throws RecognitionException {
    TypeSignatureContext _localctx = new TypeSignatureContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_typeSignature);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(354);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == QL_DOC) {
          {
            setState(353);
            match(QL_DOC);
          }
        }

        setState(356);
        annotations();
        setState(357);
        match(SIGNATURE);
        setState(358);
        match(CLASS_);
        setState(359);
        classname();
        setState(369);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == EXTENDS) {
          {
            setState(360);
            match(EXTENDS);
            setState(361);
            type();
            setState(366);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == COMMA) {
              {
                {
                  setState(362);
                  match(COMMA);
                  setState(363);
                  type();
                }
              }
              setState(368);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }

        setState(380);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case SEMI:
            {
              setState(371);
              match(SEMI);
            }
            break;
          case LBRACE:
            {
              setState(372);
              match(LBRACE);
              setState(376);
              _errHandler.sync(this);
              _la = _input.LA(1);
              while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9002766781249472L) != 0)
                  || ((((_la - 64)) & ~0x3f) == 0
                      && ((1L << (_la - 64)) & 255086697645315L) != 0)) {
                {
                  {
                    setState(373);
                    signaturePredicate();
                  }
                }
                setState(378);
                _errHandler.sync(this);
                _la = _input.LA(1);
              }
              setState(379);
              match(RBRACE);
            }
            break;
          default:
            throw new NoViableAltException(this);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ModuleSignatureContext extends ParserRuleContext {
    public TerminalNode SIGNATURE() {
      return getToken(CodeQLParser.SIGNATURE, 0);
    }

    public TerminalNode MODULE() {
      return getToken(CodeQLParser.MODULE, 0);
    }

    public ModuleSignatureNameContext moduleSignatureName() {
      return getRuleContext(ModuleSignatureNameContext.class, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(CodeQLParser.LBRACE, 0);
    }

    public ModuleSignatureBodyContext moduleSignatureBody() {
      return getRuleContext(ModuleSignatureBodyContext.class, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(CodeQLParser.RBRACE, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public List<AnnotationContext> annotation() {
      return getRuleContexts(AnnotationContext.class);
    }

    public AnnotationContext annotation(int i) {
      return getRuleContext(AnnotationContext.class, i);
    }

    public ParametersContext parameters() {
      return getRuleContext(ParametersContext.class, 0);
    }

    public ModuleSignatureContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_moduleSignature;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterModuleSignature(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitModuleSignature(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitModuleSignature(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ModuleSignatureContext moduleSignature() throws RecognitionException {
    ModuleSignatureContext _localctx = new ModuleSignatureContext(_ctx, getState());
    enterRule(_localctx, 36, RULE_moduleSignature);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(383);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == QL_DOC) {
          {
            setState(382);
            match(QL_DOC);
          }
        }

        setState(388);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & 2629631L) != 0)) {
          {
            {
              setState(385);
              annotation();
            }
          }
          setState(390);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(391);
        match(SIGNATURE);
        setState(392);
        match(MODULE);
        setState(393);
        moduleSignatureName();
        setState(395);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LT) {
          {
            setState(394);
            parameters();
          }
        }

        setState(397);
        match(LBRACE);
        setState(398);
        moduleSignatureBody();
        setState(399);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ModuleSignatureBodyContext extends ParserRuleContext {
    public List<SignaturePredicateContext> signaturePredicate() {
      return getRuleContexts(SignaturePredicateContext.class);
    }

    public SignaturePredicateContext signaturePredicate(int i) {
      return getRuleContext(SignaturePredicateContext.class, i);
    }

    public List<DefaultPredicateContext> defaultPredicate() {
      return getRuleContexts(DefaultPredicateContext.class);
    }

    public DefaultPredicateContext defaultPredicate(int i) {
      return getRuleContext(DefaultPredicateContext.class, i);
    }

    public List<SignatureTypeContext> signatureType() {
      return getRuleContexts(SignatureTypeContext.class);
    }

    public SignatureTypeContext signatureType(int i) {
      return getRuleContext(SignatureTypeContext.class, i);
    }

    public ModuleSignatureBodyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_moduleSignatureBody;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterModuleSignatureBody(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitModuleSignatureBody(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitModuleSignatureBody(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ModuleSignatureBodyContext moduleSignatureBody() throws RecognitionException {
    ModuleSignatureBodyContext _localctx = new ModuleSignatureBodyContext(_ctx, getState());
    enterRule(_localctx, 38, RULE_moduleSignatureBody);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(406);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4499167153878720L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 255086697645315L) != 0)) {
          {
            setState(404);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 28, _ctx)) {
              case 1:
                {
                  setState(401);
                  signaturePredicate();
                }
                break;
              case 2:
                {
                  setState(402);
                  defaultPredicate();
                }
                break;
              case 3:
                {
                  setState(403);
                  signatureType();
                }
                break;
            }
          }
          setState(408);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SignaturePredicateContext extends ParserRuleContext {
    public AnnotationsContext annotations() {
      return getRuleContext(AnnotationsContext.class, 0);
    }

    public HeadContext head() {
      return getRuleContext(HeadContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(CodeQLParser.SEMI, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public SignaturePredicateContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_signaturePredicate;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterSignaturePredicate(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitSignaturePredicate(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitSignaturePredicate(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SignaturePredicateContext signaturePredicate() throws RecognitionException {
    SignaturePredicateContext _localctx = new SignaturePredicateContext(_ctx, getState());
    enterRule(_localctx, 40, RULE_signaturePredicate);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(410);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == QL_DOC) {
          {
            setState(409);
            match(QL_DOC);
          }
        }

        setState(412);
        annotations();
        setState(413);
        head();
        setState(414);
        match(SEMI);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DefaultPredicateContext extends ParserRuleContext {
    public AnnotationsContext annotations() {
      return getRuleContext(AnnotationsContext.class, 0);
    }

    public TerminalNode DEFAULT() {
      return getToken(CodeQLParser.DEFAULT, 0);
    }

    public HeadContext head() {
      return getRuleContext(HeadContext.class, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(CodeQLParser.LBRACE, 0);
    }

    public FormulaContext formula() {
      return getRuleContext(FormulaContext.class, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(CodeQLParser.RBRACE, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public DefaultPredicateContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_defaultPredicate;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterDefaultPredicate(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitDefaultPredicate(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitDefaultPredicate(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DefaultPredicateContext defaultPredicate() throws RecognitionException {
    DefaultPredicateContext _localctx = new DefaultPredicateContext(_ctx, getState());
    enterRule(_localctx, 42, RULE_defaultPredicate);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(417);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == QL_DOC) {
          {
            setState(416);
            match(QL_DOC);
          }
        }

        setState(419);
        annotations();
        setState(420);
        match(DEFAULT);
        setState(421);
        head();
        setState(422);
        match(LBRACE);
        setState(423);
        formula();
        setState(424);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SignatureTypeContext extends ParserRuleContext {
    public AnnotationsContext annotations() {
      return getRuleContext(AnnotationsContext.class, 0);
    }

    public TerminalNode CLASS_() {
      return getToken(CodeQLParser.CLASS_, 0);
    }

    public ClassnameContext classname() {
      return getRuleContext(ClassnameContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(CodeQLParser.SEMI, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(CodeQLParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(CodeQLParser.RBRACE, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public TerminalNode EXTENDS() {
      return getToken(CodeQLParser.EXTENDS, 0);
    }

    public List<TypeContext> type() {
      return getRuleContexts(TypeContext.class);
    }

    public TypeContext type(int i) {
      return getRuleContext(TypeContext.class, i);
    }

    public List<SignaturePredicateContext> signaturePredicate() {
      return getRuleContexts(SignaturePredicateContext.class);
    }

    public SignaturePredicateContext signaturePredicate(int i) {
      return getRuleContext(SignaturePredicateContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public SignatureTypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_signatureType;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterSignatureType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitSignatureType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitSignatureType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SignatureTypeContext signatureType() throws RecognitionException {
    SignatureTypeContext _localctx = new SignatureTypeContext(_ctx, getState());
    enterRule(_localctx, 44, RULE_signatureType);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(427);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == QL_DOC) {
          {
            setState(426);
            match(QL_DOC);
          }
        }

        setState(429);
        annotations();
        setState(430);
        match(CLASS_);
        setState(431);
        classname();
        setState(441);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == EXTENDS) {
          {
            setState(432);
            match(EXTENDS);
            setState(433);
            type();
            setState(438);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == COMMA) {
              {
                {
                  setState(434);
                  match(COMMA);
                  setState(435);
                  type();
                }
              }
              setState(440);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }

        setState(452);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case SEMI:
            {
              setState(443);
              match(SEMI);
            }
            break;
          case LBRACE:
            {
              setState(444);
              match(LBRACE);
              setState(448);
              _errHandler.sync(this);
              _la = _input.LA(1);
              while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9002766781249472L) != 0)
                  || ((((_la - 64)) & ~0x3f) == 0
                      && ((1L << (_la - 64)) & 255086697645315L) != 0)) {
                {
                  {
                    setState(445);
                    signaturePredicate();
                  }
                }
                setState(450);
                _errHandler.sync(this);
                _la = _input.LA(1);
              }
              setState(451);
              match(RBRACE);
            }
            break;
          default:
            throw new NoViableAltException(this);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SelectContext extends ParserRuleContext {
    public TerminalNode SELECT() {
      return getToken(CodeQLParser.SELECT, 0);
    }

    public As_exprsContext as_exprs() {
      return getRuleContext(As_exprsContext.class, 0);
    }

    public TerminalNode FROM() {
      return getToken(CodeQLParser.FROM, 0);
    }

    public Var_declsContext var_decls() {
      return getRuleContext(Var_declsContext.class, 0);
    }

    public TerminalNode WHERE() {
      return getToken(CodeQLParser.WHERE, 0);
    }

    public FormulaContext formula() {
      return getRuleContext(FormulaContext.class, 0);
    }

    public TerminalNode ORDER() {
      return getToken(CodeQLParser.ORDER, 0);
    }

    public TerminalNode BY() {
      return getToken(CodeQLParser.BY, 0);
    }

    public OrderbysContext orderbys() {
      return getRuleContext(OrderbysContext.class, 0);
    }

    public SelectContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_select;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterSelect(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitSelect(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitSelect(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SelectContext select() throws RecognitionException {
    SelectContext _localctx = new SelectContext(_ctx, getState());
    enterRule(_localctx, 46, RULE_select);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(456);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == FROM) {
          {
            setState(454);
            match(FROM);
            setState(455);
            var_decls();
          }
        }

        setState(460);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == WHERE) {
          {
            setState(458);
            match(WHERE);
            setState(459);
            formula();
          }
        }

        setState(462);
        match(SELECT);
        setState(463);
        as_exprs();
        setState(467);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == ORDER) {
          {
            setState(464);
            match(ORDER);
            setState(465);
            match(BY);
            setState(466);
            orderbys();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class As_exprsContext extends ParserRuleContext {
    public List<As_exprContext> as_expr() {
      return getRuleContexts(As_exprContext.class);
    }

    public As_exprContext as_expr(int i) {
      return getRuleContext(As_exprContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public As_exprsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_as_exprs;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterAs_exprs(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitAs_exprs(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitAs_exprs(this);
      else return visitor.visitChildren(this);
    }
  }

  public final As_exprsContext as_exprs() throws RecognitionException {
    As_exprsContext _localctx = new As_exprsContext(_ctx, getState());
    enterRule(_localctx, 48, RULE_as_exprs);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(469);
        as_expr();
        setState(474);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(470);
              match(COMMA);
              setState(471);
              as_expr();
            }
          }
          setState(476);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class As_exprContext extends ParserRuleContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public TerminalNode AS() {
      return getToken(CodeQLParser.AS, 0);
    }

    public TerminalNode LOWERID() {
      return getToken(CodeQLParser.LOWERID, 0);
    }

    public As_exprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_as_expr;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterAs_expr(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitAs_expr(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitAs_expr(this);
      else return visitor.visitChildren(this);
    }
  }

  public final As_exprContext as_expr() throws RecognitionException {
    As_exprContext _localctx = new As_exprContext(_ctx, getState());
    enterRule(_localctx, 50, RULE_as_expr);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(477);
        expr();
        setState(480);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == AS) {
          {
            setState(478);
            match(AS);
            setState(479);
            match(LOWERID);
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class OrderbysContext extends ParserRuleContext {
    public List<OrderbyContext> orderby() {
      return getRuleContexts(OrderbyContext.class);
    }

    public OrderbyContext orderby(int i) {
      return getRuleContext(OrderbyContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public OrderbysContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_orderbys;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterOrderbys(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitOrderbys(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitOrderbys(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OrderbysContext orderbys() throws RecognitionException {
    OrderbysContext _localctx = new OrderbysContext(_ctx, getState());
    enterRule(_localctx, 52, RULE_orderbys);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(482);
        orderby();
        setState(487);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(483);
              match(COMMA);
              setState(484);
              orderby();
            }
          }
          setState(489);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class OrderbyContext extends ParserRuleContext {
    public TerminalNode LOWERID() {
      return getToken(CodeQLParser.LOWERID, 0);
    }

    public TerminalNode ASC() {
      return getToken(CodeQLParser.ASC, 0);
    }

    public TerminalNode DESC() {
      return getToken(CodeQLParser.DESC, 0);
    }

    public OrderbyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_orderby;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterOrderby(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitOrderby(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitOrderby(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OrderbyContext orderby() throws RecognitionException {
    OrderbyContext _localctx = new OrderbyContext(_ctx, getState());
    enterRule(_localctx, 54, RULE_orderby);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(490);
        match(LOWERID);
        setState(492);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == ASC || _la == DESC) {
          {
            setState(491);
            _la = _input.LA(1);
            if (!(_la == ASC || _la == DESC)) {
              _errHandler.recoverInline(this);
            } else {
              if (_input.LA(1) == Token.EOF) matchedEOF = true;
              _errHandler.reportMatch(this);
              consume();
            }
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DtNameContext extends ParserRuleContext {
    public TerminalNode UPPERID() {
      return getToken(CodeQLParser.UPPERID, 0);
    }

    public DtNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_dtName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterDtName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitDtName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitDtName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DtNameContext dtName() throws RecognitionException {
    DtNameContext _localctx = new DtNameContext(_ctx, getState());
    enterRule(_localctx, 56, RULE_dtName);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(494);
        match(UPPERID);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DtBranchesContext extends ParserRuleContext {
    public List<DtBrancheContext> dtBranche() {
      return getRuleContexts(DtBrancheContext.class);
    }

    public DtBrancheContext dtBranche(int i) {
      return getRuleContext(DtBrancheContext.class, i);
    }

    public List<TerminalNode> OR() {
      return getTokens(CodeQLParser.OR);
    }

    public TerminalNode OR(int i) {
      return getToken(CodeQLParser.OR, i);
    }

    public DtBranchesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_dtBranches;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterDtBranches(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitDtBranches(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitDtBranches(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DtBranchesContext dtBranches() throws RecognitionException {
    DtBranchesContext _localctx = new DtBranchesContext(_ctx, getState());
    enterRule(_localctx, 58, RULE_dtBranches);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(496);
        dtBranche();
        setState(501);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == OR) {
          {
            {
              setState(497);
              match(OR);
              setState(498);
              dtBranche();
            }
          }
          setState(503);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DtBrancheContext extends ParserRuleContext {
    public DtBranchNameContext dtBranchName() {
      return getRuleContext(DtBranchNameContext.class, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public Var_declsContext var_decls() {
      return getRuleContext(Var_declsContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(CodeQLParser.LBRACE, 0);
    }

    public FormulaContext formula() {
      return getRuleContext(FormulaContext.class, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(CodeQLParser.RBRACE, 0);
    }

    public DtBrancheContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_dtBranche;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterDtBranche(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitDtBranche(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitDtBranche(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DtBrancheContext dtBranche() throws RecognitionException {
    DtBrancheContext _localctx = new DtBrancheContext(_ctx, getState());
    enterRule(_localctx, 60, RULE_dtBranche);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(504);
        dtBranchName();
        setState(505);
        match(LPAREN);
        setState(506);
        var_decls();
        setState(507);
        match(RPAREN);
        setState(512);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LBRACE) {
          {
            setState(508);
            match(LBRACE);
            setState(509);
            formula();
            setState(510);
            match(RBRACE);
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DtBranchNameContext extends ParserRuleContext {
    public TerminalNode UPPERID() {
      return getToken(CodeQLParser.UPPERID, 0);
    }

    public DtBranchNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_dtBranchName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterDtBranchName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitDtBranchName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitDtBranchName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DtBranchNameContext dtBranchName() throws RecognitionException {
    DtBranchNameContext _localctx = new DtBranchNameContext(_ctx, getState());
    enterRule(_localctx, 62, RULE_dtBranchName);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(514);
        match(UPPERID);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DatatypeContext extends ParserRuleContext {
    public AnnotationsContext annotations() {
      return getRuleContext(AnnotationsContext.class, 0);
    }

    public TerminalNode NEWTYPE() {
      return getToken(CodeQLParser.NEWTYPE, 0);
    }

    public DtNameContext dtName() {
      return getRuleContext(DtNameContext.class, 0);
    }

    public TerminalNode ASSIGN() {
      return getToken(CodeQLParser.ASSIGN, 0);
    }

    public DtBranchesContext dtBranches() {
      return getRuleContext(DtBranchesContext.class, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public DatatypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_datatype;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterDatatype(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitDatatype(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitDatatype(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DatatypeContext datatype() throws RecognitionException {
    DatatypeContext _localctx = new DatatypeContext(_ctx, getState());
    enterRule(_localctx, 64, RULE_datatype);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(517);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == QL_DOC) {
          {
            setState(516);
            match(QL_DOC);
          }
        }

        setState(519);
        annotations();
        setState(520);
        match(NEWTYPE);
        setState(521);
        dtName();
        setState(522);
        match(ASSIGN);
        setState(523);
        dtBranches();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UnionBranchesContext extends ParserRuleContext {
    public List<TypeContext> type() {
      return getRuleContexts(TypeContext.class);
    }

    public TypeContext type(int i) {
      return getRuleContext(TypeContext.class, i);
    }

    public List<TerminalNode> OR() {
      return getTokens(CodeQLParser.OR);
    }

    public TerminalNode OR(int i) {
      return getToken(CodeQLParser.OR, i);
    }

    public UnionBranchesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unionBranches;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterUnionBranches(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitUnionBranches(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitUnionBranches(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UnionBranchesContext unionBranches() throws RecognitionException {
    UnionBranchesContext _localctx = new UnionBranchesContext(_ctx, getState());
    enterRule(_localctx, 66, RULE_unionBranches);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(525);
        type();
        setState(530);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == OR) {
          {
            {
              setState(526);
              match(OR);
              setState(527);
              type();
            }
          }
          setState(532);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeunionContext extends ParserRuleContext {
    public AnnotationsContext annotations() {
      return getRuleContext(AnnotationsContext.class, 0);
    }

    public TerminalNode CLASS_() {
      return getToken(CodeQLParser.CLASS_, 0);
    }

    public TerminalNode UPPERID() {
      return getToken(CodeQLParser.UPPERID, 0);
    }

    public TerminalNode ASSIGN() {
      return getToken(CodeQLParser.ASSIGN, 0);
    }

    public UnionBranchesContext unionBranches() {
      return getRuleContext(UnionBranchesContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(CodeQLParser.SEMI, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public TypeunionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_typeunion;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterTypeunion(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitTypeunion(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitTypeunion(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TypeunionContext typeunion() throws RecognitionException {
    TypeunionContext _localctx = new TypeunionContext(_ctx, getState());
    enterRule(_localctx, 68, RULE_typeunion);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(534);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == QL_DOC) {
          {
            setState(533);
            match(QL_DOC);
          }
        }

        setState(536);
        annotations();
        setState(537);
        match(CLASS_);
        setState(538);
        match(UPPERID);
        setState(539);
        match(ASSIGN);
        setState(540);
        unionBranches();
        setState(541);
        match(SEMI);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PredicateContext extends ParserRuleContext {
    public AnnotationsContext annotations() {
      return getRuleContext(AnnotationsContext.class, 0);
    }

    public HeadContext head() {
      return getRuleContext(HeadContext.class, 0);
    }

    public OptbodyContext optbody() {
      return getRuleContext(OptbodyContext.class, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public PredicateContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_predicate;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterPredicate(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitPredicate(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitPredicate(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PredicateContext predicate() throws RecognitionException {
    PredicateContext _localctx = new PredicateContext(_ctx, getState());
    enterRule(_localctx, 70, RULE_predicate);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(544);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == QL_DOC) {
          {
            setState(543);
            match(QL_DOC);
          }
        }

        setState(546);
        annotations();
        setState(547);
        head();
        setState(548);
        optbody();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AnnotationsContext extends ParserRuleContext {
    public List<AnnotationContext> annotation() {
      return getRuleContexts(AnnotationContext.class);
    }

    public AnnotationContext annotation(int i) {
      return getRuleContext(AnnotationContext.class, i);
    }

    public AnnotationsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_annotations;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterAnnotations(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitAnnotations(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitAnnotations(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AnnotationsContext annotations() throws RecognitionException {
    AnnotationsContext _localctx = new AnnotationsContext(_ctx, getState());
    enterRule(_localctx, 72, RULE_annotations);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(553);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & 2629631L) != 0)) {
          {
            {
              setState(550);
              annotation();
            }
          }
          setState(555);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AnnotationContext extends ParserRuleContext {
    public SimpleAnnotationContext simpleAnnotation() {
      return getRuleContext(SimpleAnnotationContext.class, 0);
    }

    public ArgsAnnotationContext argsAnnotation() {
      return getRuleContext(ArgsAnnotationContext.class, 0);
    }

    public AnnotationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_annotation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterAnnotation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitAnnotation(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitAnnotation(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AnnotationContext annotation() throws RecognitionException {
    AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
    enterRule(_localctx, 74, RULE_annotation);
    try {
      setState(558);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case ABSTRACT:
        case CACHED:
        case EXTERNAL:
        case EXTENSIBLE:
        case FINAL:
        case TRANSIENT:
        case LIBRARY:
        case PRIVATE:
        case DEPRECATED:
        case OVERRIDE:
        case ADDITIONAL:
        case QUERY:
          enterOuterAlt(_localctx, 1);
          {
            setState(556);
            simpleAnnotation();
          }
          break;
        case PRAGMA:
        case LANGUAGE:
        case BINDINGSET:
          enterOuterAlt(_localctx, 2);
          {
            setState(557);
            argsAnnotation();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SimpleAnnotationContext extends ParserRuleContext {
    public TerminalNode ABSTRACT() {
      return getToken(CodeQLParser.ABSTRACT, 0);
    }

    public TerminalNode CACHED() {
      return getToken(CodeQLParser.CACHED, 0);
    }

    public TerminalNode EXTERNAL() {
      return getToken(CodeQLParser.EXTERNAL, 0);
    }

    public TerminalNode EXTENSIBLE() {
      return getToken(CodeQLParser.EXTENSIBLE, 0);
    }

    public TerminalNode FINAL() {
      return getToken(CodeQLParser.FINAL, 0);
    }

    public TerminalNode TRANSIENT() {
      return getToken(CodeQLParser.TRANSIENT, 0);
    }

    public TerminalNode LIBRARY() {
      return getToken(CodeQLParser.LIBRARY, 0);
    }

    public TerminalNode PRIVATE() {
      return getToken(CodeQLParser.PRIVATE, 0);
    }

    public TerminalNode DEPRECATED() {
      return getToken(CodeQLParser.DEPRECATED, 0);
    }

    public TerminalNode OVERRIDE() {
      return getToken(CodeQLParser.OVERRIDE, 0);
    }

    public TerminalNode ADDITIONAL() {
      return getToken(CodeQLParser.ADDITIONAL, 0);
    }

    public TerminalNode QUERY() {
      return getToken(CodeQLParser.QUERY, 0);
    }

    public SimpleAnnotationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_simpleAnnotation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterSimpleAnnotation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitSimpleAnnotation(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitSimpleAnnotation(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SimpleAnnotationContext simpleAnnotation() throws RecognitionException {
    SimpleAnnotationContext _localctx = new SimpleAnnotationContext(_ctx, getState());
    enterRule(_localctx, 76, RULE_simpleAnnotation);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(560);
        _la = _input.LA(1);
        if (!(((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & 4095L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PragmaArgContext extends ParserRuleContext {
    public TerminalNode INLINE() {
      return getToken(CodeQLParser.INLINE, 0);
    }

    public TerminalNode INLINE_LATE() {
      return getToken(CodeQLParser.INLINE_LATE, 0);
    }

    public TerminalNode NOINLINE() {
      return getToken(CodeQLParser.NOINLINE, 0);
    }

    public TerminalNode NOMAGIC() {
      return getToken(CodeQLParser.NOMAGIC, 0);
    }

    public TerminalNode NOOPT() {
      return getToken(CodeQLParser.NOOPT, 0);
    }

    public TerminalNode ASSUME_SMALL_DELTA() {
      return getToken(CodeQLParser.ASSUME_SMALL_DELTA, 0);
    }

    public PragmaArgContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_pragmaArg;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterPragmaArg(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitPragmaArg(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitPragmaArg(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PragmaArgContext pragmaArg() throws RecognitionException {
    PragmaArgContext _localctx = new PragmaArgContext(_ctx, getState());
    enterRule(_localctx, 78, RULE_pragmaArg);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(562);
        _la = _input.LA(1);
        if (!(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 63L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ArgsAnnotationContext extends ParserRuleContext {
    public TerminalNode PRAGMA() {
      return getToken(CodeQLParser.PRAGMA, 0);
    }

    public TerminalNode LBRACK() {
      return getToken(CodeQLParser.LBRACK, 0);
    }

    public List<PragmaArgContext> pragmaArg() {
      return getRuleContexts(PragmaArgContext.class);
    }

    public PragmaArgContext pragmaArg(int i) {
      return getRuleContext(PragmaArgContext.class, i);
    }

    public TerminalNode RBRACK() {
      return getToken(CodeQLParser.RBRACK, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public TerminalNode LANGUAGE() {
      return getToken(CodeQLParser.LANGUAGE, 0);
    }

    public TerminalNode MONOTONICAGGREGATES() {
      return getToken(CodeQLParser.MONOTONICAGGREGATES, 0);
    }

    public TerminalNode BINDINGSET() {
      return getToken(CodeQLParser.BINDINGSET, 0);
    }

    public List<VariableContext> variable() {
      return getRuleContexts(VariableContext.class);
    }

    public VariableContext variable(int i) {
      return getRuleContext(VariableContext.class, i);
    }

    public ArgsAnnotationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_argsAnnotation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterArgsAnnotation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitArgsAnnotation(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitArgsAnnotation(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ArgsAnnotationContext argsAnnotation() throws RecognitionException {
    ArgsAnnotationContext _localctx = new ArgsAnnotationContext(_ctx, getState());
    enterRule(_localctx, 80, RULE_argsAnnotation);
    int _la;
    try {
      setState(593);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case PRAGMA:
          enterOuterAlt(_localctx, 1);
          {
            setState(564);
            match(PRAGMA);
            setState(565);
            match(LBRACK);
            setState(566);
            pragmaArg();
            setState(571);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == COMMA) {
              {
                {
                  setState(567);
                  match(COMMA);
                  setState(568);
                  pragmaArg();
                }
              }
              setState(573);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
            setState(574);
            match(RBRACK);
          }
          break;
        case LANGUAGE:
          enterOuterAlt(_localctx, 2);
          {
            setState(576);
            match(LANGUAGE);
            setState(577);
            match(LBRACK);
            setState(578);
            match(MONOTONICAGGREGATES);
            setState(579);
            match(RBRACK);
          }
          break;
        case BINDINGSET:
          enterOuterAlt(_localctx, 3);
          {
            setState(580);
            match(BINDINGSET);
            setState(581);
            match(LBRACK);
            setState(590);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -773918747000832L) != 0)
                || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 35184372097023L) != 0)) {
              {
                setState(582);
                variable();
                setState(587);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                  {
                    {
                      setState(583);
                      match(COMMA);
                      setState(584);
                      variable();
                    }
                  }
                  setState(589);
                  _errHandler.sync(this);
                  _la = _input.LA(1);
                }
              }
            }

            setState(592);
            match(RBRACK);
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class HeadContext extends ParserRuleContext {
    public PredicateNameContext predicateName() {
      return getRuleContext(PredicateNameContext.class, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public Var_declsContext var_decls() {
      return getRuleContext(Var_declsContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public TerminalNode PREDICATE() {
      return getToken(CodeQLParser.PREDICATE, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public HeadContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_head;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterHead(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitHead(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitHead(this);
      else return visitor.visitChildren(this);
    }
  }

  public final HeadContext head() throws RecognitionException {
    HeadContext _localctx = new HeadContext(_ctx, getState());
    enterRule(_localctx, 82, RULE_head);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(597);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case PREDICATE:
            {
              setState(595);
              match(PREDICATE);
            }
            break;
          case BOOLEAN:
          case DATE:
          case FLOAT:
          case INT:
          case STRING:
          case LOWERID:
          case UPPERID:
          case ATLOWERID:
            {
              setState(596);
              type();
            }
            break;
          default:
            throw new NoViableAltException(this);
        }
        setState(599);
        predicateName();
        setState(600);
        match(LPAREN);
        setState(601);
        var_decls();
        setState(602);
        match(RPAREN);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class OptbodyContext extends ParserRuleContext {
    public TerminalNode SEMI() {
      return getToken(CodeQLParser.SEMI, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(CodeQLParser.LBRACE, 0);
    }

    public FormulaContext formula() {
      return getRuleContext(FormulaContext.class, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(CodeQLParser.RBRACE, 0);
    }

    public TerminalNode ASSIGN() {
      return getToken(CodeQLParser.ASSIGN, 0);
    }

    public LiteralIdContext literalId() {
      return getRuleContext(LiteralIdContext.class, 0);
    }

    public List<TerminalNode> LPAREN() {
      return getTokens(CodeQLParser.LPAREN);
    }

    public TerminalNode LPAREN(int i) {
      return getToken(CodeQLParser.LPAREN, i);
    }

    public List<TerminalNode> RPAREN() {
      return getTokens(CodeQLParser.RPAREN);
    }

    public TerminalNode RPAREN(int i) {
      return getToken(CodeQLParser.RPAREN, i);
    }

    public List<PredicateRefContext> predicateRef() {
      return getRuleContexts(PredicateRefContext.class);
    }

    public PredicateRefContext predicateRef(int i) {
      return getRuleContext(PredicateRefContext.class, i);
    }

    public List<TerminalNode> DIV() {
      return getTokens(CodeQLParser.DIV);
    }

    public TerminalNode DIV(int i) {
      return getToken(CodeQLParser.DIV, i);
    }

    public List<TerminalNode> INT_LITERAL() {
      return getTokens(CodeQLParser.INT_LITERAL);
    }

    public TerminalNode INT_LITERAL(int i) {
      return getToken(CodeQLParser.INT_LITERAL, i);
    }

    public ExprsContext exprs() {
      return getRuleContext(ExprsContext.class, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public OptbodyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_optbody;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterOptbody(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitOptbody(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitOptbody(this);
      else return visitor.visitChildren(this);
    }
  }

  public final OptbodyContext optbody() throws RecognitionException {
    OptbodyContext _localctx = new OptbodyContext(_ctx, getState());
    enterRule(_localctx, 84, RULE_optbody);
    int _la;
    try {
      setState(634);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case SEMI:
          enterOuterAlt(_localctx, 1);
          {
            setState(604);
            match(SEMI);
          }
          break;
        case LBRACE:
          enterOuterAlt(_localctx, 2);
          {
            setState(605);
            match(LBRACE);
            setState(606);
            formula();
            setState(607);
            match(RBRACE);
          }
          break;
        case ASSIGN:
          enterOuterAlt(_localctx, 3);
          {
            setState(609);
            match(ASSIGN);
            setState(610);
            literalId();
            setState(611);
            match(LPAREN);
            setState(625);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -844422782648316L) != 0)
                || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 246290604630015L) != 0)) {
              {
                setState(612);
                predicateRef();
                setState(613);
                match(DIV);
                setState(614);
                match(INT_LITERAL);
                setState(622);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                  {
                    {
                      setState(615);
                      match(COMMA);
                      setState(616);
                      predicateRef();
                      setState(617);
                      match(DIV);
                      setState(618);
                      match(INT_LITERAL);
                    }
                  }
                  setState(624);
                  _errHandler.sync(this);
                  _la = _input.LA(1);
                }
              }
            }

            setState(627);
            match(RPAREN);
            setState(628);
            match(LPAREN);
            setState(630);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -598475305447836L) != 0)
                || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 247270998810623L) != 0)) {
              {
                setState(629);
                exprs();
              }
            }

            setState(632);
            match(RPAREN);
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Class_Context extends ParserRuleContext {
    public AnnotationsContext annotations() {
      return getRuleContext(AnnotationsContext.class, 0);
    }

    public TerminalNode CLASS_() {
      return getToken(CodeQLParser.CLASS_, 0);
    }

    public ClassnameContext classname() {
      return getRuleContext(ClassnameContext.class, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(CodeQLParser.LBRACE, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(CodeQLParser.RBRACE, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public TerminalNode EXTENDS() {
      return getToken(CodeQLParser.EXTENDS, 0);
    }

    public List<TypeContext> type() {
      return getRuleContexts(TypeContext.class);
    }

    public TypeContext type(int i) {
      return getRuleContext(TypeContext.class, i);
    }

    public TerminalNode INSTANCEOF() {
      return getToken(CodeQLParser.INSTANCEOF, 0);
    }

    public List<MemberContext> member() {
      return getRuleContexts(MemberContext.class);
    }

    public MemberContext member(int i) {
      return getRuleContext(MemberContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public Class_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_class_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterClass_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitClass_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitClass_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Class_Context class_() throws RecognitionException {
    Class_Context _localctx = new Class_Context(_ctx, getState());
    enterRule(_localctx, 86, RULE_class_);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(637);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == QL_DOC) {
          {
            setState(636);
            match(QL_DOC);
          }
        }

        setState(639);
        annotations();
        setState(640);
        match(CLASS_);
        setState(641);
        classname();
        setState(651);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == EXTENDS) {
          {
            setState(642);
            match(EXTENDS);
            setState(643);
            type();
            setState(648);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == COMMA) {
              {
                {
                  setState(644);
                  match(COMMA);
                  setState(645);
                  type();
                }
              }
              setState(650);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }

        setState(662);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == INSTANCEOF) {
          {
            setState(653);
            match(INSTANCEOF);
            setState(654);
            type();
            setState(659);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == COMMA) {
              {
                {
                  setState(655);
                  match(COMMA);
                  setState(656);
                  type();
                }
              }
              setState(661);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }

        setState(664);
        match(LBRACE);
        setState(668);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9002766781249472L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 255086697645315L) != 0)) {
          {
            {
              setState(665);
              member();
            }
          }
          setState(670);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(671);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MemberContext extends ParserRuleContext {
    public CharacterContext character() {
      return getRuleContext(CharacterContext.class, 0);
    }

    public PredicateContext predicate() {
      return getRuleContext(PredicateContext.class, 0);
    }

    public FieldContext field() {
      return getRuleContext(FieldContext.class, 0);
    }

    public MemberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_member;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterMember(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitMember(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitMember(this);
      else return visitor.visitChildren(this);
    }
  }

  public final MemberContext member() throws RecognitionException {
    MemberContext _localctx = new MemberContext(_ctx, getState());
    enterRule(_localctx, 88, RULE_member);
    try {
      setState(676);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 67, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(673);
            character();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(674);
            predicate();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(675);
            field();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CharacterContext extends ParserRuleContext {
    public AnnotationsContext annotations() {
      return getRuleContext(AnnotationsContext.class, 0);
    }

    public ClassnameContext classname() {
      return getRuleContext(ClassnameContext.class, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public TerminalNode LBRACE() {
      return getToken(CodeQLParser.LBRACE, 0);
    }

    public FormulaContext formula() {
      return getRuleContext(FormulaContext.class, 0);
    }

    public TerminalNode RBRACE() {
      return getToken(CodeQLParser.RBRACE, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public CharacterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_character;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterCharacter(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitCharacter(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitCharacter(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CharacterContext character() throws RecognitionException {
    CharacterContext _localctx = new CharacterContext(_ctx, getState());
    enterRule(_localctx, 90, RULE_character);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(679);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == QL_DOC) {
          {
            setState(678);
            match(QL_DOC);
          }
        }

        setState(681);
        annotations();
        setState(682);
        classname();
        setState(683);
        match(LPAREN);
        setState(684);
        match(RPAREN);
        setState(685);
        match(LBRACE);
        setState(686);
        formula();
        setState(687);
        match(RBRACE);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FieldContext extends ParserRuleContext {
    public AnnotationsContext annotations() {
      return getRuleContext(AnnotationsContext.class, 0);
    }

    public Var_declContext var_decl() {
      return getRuleContext(Var_declContext.class, 0);
    }

    public TerminalNode SEMI() {
      return getToken(CodeQLParser.SEMI, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public FieldContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_field;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterField(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitField(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitField(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FieldContext field() throws RecognitionException {
    FieldContext _localctx = new FieldContext(_ctx, getState());
    enterRule(_localctx, 92, RULE_field);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(690);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == QL_DOC) {
          {
            setState(689);
            match(QL_DOC);
          }
        }

        setState(692);
        annotations();
        setState(693);
        var_decl();
        setState(694);
        match(SEMI);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ModuleExprContext extends ParserRuleContext {
    public ModulenameContext modulename() {
      return getRuleContext(ModulenameContext.class, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public ModuleExprContext moduleExpr() {
      return getRuleContext(ModuleExprContext.class, 0);
    }

    public TerminalNode COLONCOLON() {
      return getToken(CodeQLParser.COLONCOLON, 0);
    }

    public ModuleExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_moduleExpr;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterModuleExpr(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitModuleExpr(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitModuleExpr(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ModuleExprContext moduleExpr() throws RecognitionException {
    return moduleExpr(0);
  }

  private ModuleExprContext moduleExpr(int _p) throws RecognitionException {
    ParserRuleContext _parentctx = _ctx;
    int _parentState = getState();
    ModuleExprContext _localctx = new ModuleExprContext(_ctx, _parentState);
    ModuleExprContext _prevctx = _localctx;
    int _startState = 94;
    enterRecursionRule(_localctx, 94, RULE_moduleExpr, _p);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        {
          setState(697);
          modulename();
          setState(699);
          _errHandler.sync(this);
          switch (getInterpreter().adaptivePredict(_input, 70, _ctx)) {
            case 1:
              {
                setState(698);
                arguments();
              }
              break;
          }
        }
        _ctx.stop = _input.LT(-1);
        setState(709);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 72, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (_parseListeners != null) triggerExitRuleEvent();
            _prevctx = _localctx;
            {
              {
                _localctx = new ModuleExprContext(_parentctx, _parentState);
                pushNewRecursionContext(_localctx, _startState, RULE_moduleExpr);
                setState(701);
                if (!(precpred(_ctx, 1)))
                  throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                setState(702);
                match(COLONCOLON);
                setState(703);
                modulename();
                setState(705);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 71, _ctx)) {
                  case 1:
                    {
                      setState(704);
                      arguments();
                    }
                    break;
                }
              }
            }
          }
          setState(711);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 72, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      unrollRecursionContexts(_parentctx);
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ModuleSignatureExprContext extends ParserRuleContext {
    public ModuleSignatureNameContext moduleSignatureName() {
      return getRuleContext(ModuleSignatureNameContext.class, 0);
    }

    public ModuleExprContext moduleExpr() {
      return getRuleContext(ModuleExprContext.class, 0);
    }

    public TerminalNode COLONCOLON() {
      return getToken(CodeQLParser.COLONCOLON, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public ModuleSignatureExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_moduleSignatureExpr;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterModuleSignatureExpr(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitModuleSignatureExpr(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitModuleSignatureExpr(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ModuleSignatureExprContext moduleSignatureExpr() throws RecognitionException {
    ModuleSignatureExprContext _localctx = new ModuleSignatureExprContext(_ctx, getState());
    enterRule(_localctx, 96, RULE_moduleSignatureExpr);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(715);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 73, _ctx)) {
          case 1:
            {
              setState(712);
              moduleExpr(0);
              setState(713);
              match(COLONCOLON);
            }
            break;
        }
        setState(717);
        moduleSignatureName();
        setState(719);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LT) {
          {
            setState(718);
            arguments();
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SignatureExprContext extends ParserRuleContext {
    public SimpleIdContext simpleId() {
      return getRuleContext(SimpleIdContext.class, 0);
    }

    public ModuleExprContext moduleExpr() {
      return getRuleContext(ModuleExprContext.class, 0);
    }

    public TerminalNode COLONCOLON() {
      return getToken(CodeQLParser.COLONCOLON, 0);
    }

    public TerminalNode DIV() {
      return getToken(CodeQLParser.DIV, 0);
    }

    public TerminalNode INT_LITERAL() {
      return getToken(CodeQLParser.INT_LITERAL, 0);
    }

    public ArgumentsContext arguments() {
      return getRuleContext(ArgumentsContext.class, 0);
    }

    public SignatureExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_signatureExpr;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterSignatureExpr(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitSignatureExpr(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitSignatureExpr(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SignatureExprContext signatureExpr() throws RecognitionException {
    SignatureExprContext _localctx = new SignatureExprContext(_ctx, getState());
    enterRule(_localctx, 98, RULE_signatureExpr);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(724);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 75, _ctx)) {
          case 1:
            {
              setState(721);
              moduleExpr(0);
              setState(722);
              match(COLONCOLON);
            }
            break;
        }
        setState(726);
        simpleId();
        setState(730);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case DIV:
            {
              setState(727);
              match(DIV);
              setState(728);
              match(INT_LITERAL);
            }
            break;
          case LT:
            {
              setState(729);
              arguments();
            }
            break;
          case LOWERID:
          case UPPERID:
            break;
          default:
            break;
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TypeContext extends ParserRuleContext {
    public ClassnameContext classname() {
      return getRuleContext(ClassnameContext.class, 0);
    }

    public ModuleExprContext moduleExpr() {
      return getRuleContext(ModuleExprContext.class, 0);
    }

    public TerminalNode COLONCOLON() {
      return getToken(CodeQLParser.COLONCOLON, 0);
    }

    public DbbasetypeContext dbbasetype() {
      return getRuleContext(DbbasetypeContext.class, 0);
    }

    public TerminalNode BOOLEAN() {
      return getToken(CodeQLParser.BOOLEAN, 0);
    }

    public TerminalNode DATE() {
      return getToken(CodeQLParser.DATE, 0);
    }

    public TerminalNode FLOAT() {
      return getToken(CodeQLParser.FLOAT, 0);
    }

    public TerminalNode INT() {
      return getToken(CodeQLParser.INT, 0);
    }

    public TerminalNode STRING() {
      return getToken(CodeQLParser.STRING, 0);
    }

    public TypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_type;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterType(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitType(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitType(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TypeContext type() throws RecognitionException {
    TypeContext _localctx = new TypeContext(_ctx, getState());
    enterRule(_localctx, 100, RULE_type);
    try {
      setState(744);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case LOWERID:
        case UPPERID:
          enterOuterAlt(_localctx, 1);
          {
            setState(735);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 77, _ctx)) {
              case 1:
                {
                  setState(732);
                  moduleExpr(0);
                  setState(733);
                  match(COLONCOLON);
                }
                break;
            }
            setState(737);
            classname();
          }
          break;
        case ATLOWERID:
          enterOuterAlt(_localctx, 2);
          {
            setState(738);
            dbbasetype();
          }
          break;
        case BOOLEAN:
          enterOuterAlt(_localctx, 3);
          {
            setState(739);
            match(BOOLEAN);
          }
          break;
        case DATE:
          enterOuterAlt(_localctx, 4);
          {
            setState(740);
            match(DATE);
          }
          break;
        case FLOAT:
          enterOuterAlt(_localctx, 5);
          {
            setState(741);
            match(FLOAT);
          }
          break;
        case INT:
          enterOuterAlt(_localctx, 6);
          {
            setState(742);
            match(INT);
          }
          break;
        case STRING:
          enterOuterAlt(_localctx, 7);
          {
            setState(743);
            match(STRING);
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExprsContext extends ParserRuleContext {
    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public ExprsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_exprs;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterExprs(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitExprs(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitExprs(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExprsContext exprs() throws RecognitionException {
    ExprsContext _localctx = new ExprsContext(_ctx, getState());
    enterRule(_localctx, 102, RULE_exprs);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(746);
        expr();
        setState(751);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(747);
              match(COMMA);
              setState(748);
              expr();
            }
          }
          setState(753);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AliasContext extends ParserRuleContext {
    public AnnotationsContext annotations() {
      return getRuleContext(AnnotationsContext.class, 0);
    }

    public TerminalNode PREDICATE() {
      return getToken(CodeQLParser.PREDICATE, 0);
    }

    public PredicateNameContext predicateName() {
      return getRuleContext(PredicateNameContext.class, 0);
    }

    public TerminalNode ASSIGN() {
      return getToken(CodeQLParser.ASSIGN, 0);
    }

    public PredicateRefContext predicateRef() {
      return getRuleContext(PredicateRefContext.class, 0);
    }

    public TerminalNode DIV() {
      return getToken(CodeQLParser.DIV, 0);
    }

    public TerminalNode INT_LITERAL() {
      return getToken(CodeQLParser.INT_LITERAL, 0);
    }

    public TerminalNode SEMI() {
      return getToken(CodeQLParser.SEMI, 0);
    }

    public TerminalNode QL_DOC() {
      return getToken(CodeQLParser.QL_DOC, 0);
    }

    public TerminalNode CLASS_() {
      return getToken(CodeQLParser.CLASS_, 0);
    }

    public ClassnameContext classname() {
      return getRuleContext(ClassnameContext.class, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public TerminalNode MODULE() {
      return getToken(CodeQLParser.MODULE, 0);
    }

    public ModulenameContext modulename() {
      return getRuleContext(ModulenameContext.class, 0);
    }

    public ModuleExprContext moduleExpr() {
      return getRuleContext(ModuleExprContext.class, 0);
    }

    public AliasContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_alias;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterAlias(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitAlias(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitAlias(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AliasContext alias() throws RecognitionException {
    AliasContext _localctx = new AliasContext(_ctx, getState());
    enterRule(_localctx, 104, RULE_alias);
    int _la;
    try {
      setState(786);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 83, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(755);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == QL_DOC) {
              {
                setState(754);
                match(QL_DOC);
              }
            }

            setState(757);
            annotations();
            setState(758);
            match(PREDICATE);
            setState(759);
            predicateName();
            setState(760);
            match(ASSIGN);
            setState(761);
            predicateRef();
            setState(762);
            match(DIV);
            setState(763);
            match(INT_LITERAL);
            setState(764);
            match(SEMI);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(767);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == QL_DOC) {
              {
                setState(766);
                match(QL_DOC);
              }
            }

            setState(769);
            annotations();
            setState(770);
            match(CLASS_);
            setState(771);
            classname();
            setState(772);
            match(ASSIGN);
            setState(773);
            type();
            setState(774);
            match(SEMI);
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(777);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == QL_DOC) {
              {
                setState(776);
                match(QL_DOC);
              }
            }

            setState(779);
            annotations();
            setState(780);
            match(MODULE);
            setState(781);
            modulename();
            setState(782);
            match(ASSIGN);
            setState(783);
            moduleExpr(0);
            setState(784);
            match(SEMI);
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Var_declsContext extends ParserRuleContext {
    public List<Var_declContext> var_decl() {
      return getRuleContexts(Var_declContext.class);
    }

    public Var_declContext var_decl(int i) {
      return getRuleContext(Var_declContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public Var_declsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_var_decls;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterVar_decls(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitVar_decls(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitVar_decls(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Var_declsContext var_decls() throws RecognitionException {
    Var_declsContext _localctx = new Var_declsContext(_ctx, getState());
    enterRule(_localctx, 106, RULE_var_decls);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(796);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4398113753152L) != 0)
            || ((((_la - 109)) & ~0x3f) == 0 && ((1L << (_la - 109)) & 7L) != 0)) {
          {
            setState(788);
            var_decl();
            setState(793);
            _errHandler.sync(this);
            _la = _input.LA(1);
            while (_la == COMMA) {
              {
                {
                  setState(789);
                  match(COMMA);
                  setState(790);
                  var_decl();
                }
              }
              setState(795);
              _errHandler.sync(this);
              _la = _input.LA(1);
            }
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Var_declContext extends ParserRuleContext {
    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public VarnameContext varname() {
      return getRuleContext(VarnameContext.class, 0);
    }

    public Var_declContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_var_decl;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterVar_decl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitVar_decl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitVar_decl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Var_declContext var_decl() throws RecognitionException {
    Var_declContext _localctx = new Var_declContext(_ctx, getState());
    enterRule(_localctx, 108, RULE_var_decl);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(798);
        type();
        setState(799);
        varname();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FormulaContext extends ParserRuleContext {
    public Conjunction_formulaContext conjunction_formula() {
      return getRuleContext(Conjunction_formulaContext.class, 0);
    }

    public List<TerminalNode> OR() {
      return getTokens(CodeQLParser.OR);
    }

    public TerminalNode OR(int i) {
      return getToken(CodeQLParser.OR, i);
    }

    public List<FormulaContext> formula() {
      return getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(int i) {
      return getRuleContext(FormulaContext.class, i);
    }

    public FormulaContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_formula;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterFormula(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitFormula(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitFormula(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FormulaContext formula() throws RecognitionException {
    FormulaContext _localctx = new FormulaContext(_ctx, getState());
    enterRule(_localctx, 110, RULE_formula);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(801);
        conjunction_formula();
        setState(806);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 86, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(802);
                match(OR);
                setState(803);
                formula();
              }
            }
          }
          setState(808);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 86, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Formula_baseContext extends ParserRuleContext {
    public FparenContext fparen() {
      return getRuleContext(FparenContext.class, 0);
    }

    public IfthenContext ifthen() {
      return getRuleContext(IfthenContext.class, 0);
    }

    public NegatedContext negated() {
      return getRuleContext(NegatedContext.class, 0);
    }

    public QuantifiedContext quantified() {
      return getRuleContext(QuantifiedContext.class, 0);
    }

    public ComparisonContext comparison() {
      return getRuleContext(ComparisonContext.class, 0);
    }

    public InstanceofContext instanceof_() {
      return getRuleContext(InstanceofContext.class, 0);
    }

    public InrangeContext inrange() {
      return getRuleContext(InrangeContext.class, 0);
    }

    public CallContext call() {
      return getRuleContext(CallContext.class, 0);
    }

    public Formula_baseContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_formula_base;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterFormula_base(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitFormula_base(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitFormula_base(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Formula_baseContext formula_base() throws RecognitionException {
    Formula_baseContext _localctx = new Formula_baseContext(_ctx, getState());
    enterRule(_localctx, 112, RULE_formula_base);
    try {
      setState(817);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 87, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(809);
            fparen();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(810);
            ifthen();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(811);
            negated();
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(812);
            quantified();
          }
          break;
        case 5:
          enterOuterAlt(_localctx, 5);
          {
            setState(813);
            comparison();
          }
          break;
        case 6:
          enterOuterAlt(_localctx, 6);
          {
            setState(814);
            instanceof_();
          }
          break;
        case 7:
          enterOuterAlt(_localctx, 7);
          {
            setState(815);
            inrange();
          }
          break;
        case 8:
          enterOuterAlt(_localctx, 8);
          {
            setState(816);
            call();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Conjunction_formulaContext extends ParserRuleContext {
    public Implies_formulaContext implies_formula() {
      return getRuleContext(Implies_formulaContext.class, 0);
    }

    public List<TerminalNode> AND() {
      return getTokens(CodeQLParser.AND);
    }

    public TerminalNode AND(int i) {
      return getToken(CodeQLParser.AND, i);
    }

    public List<FormulaContext> formula() {
      return getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(int i) {
      return getRuleContext(FormulaContext.class, i);
    }

    public Conjunction_formulaContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_conjunction_formula;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterConjunction_formula(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitConjunction_formula(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitConjunction_formula(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Conjunction_formulaContext conjunction_formula() throws RecognitionException {
    Conjunction_formulaContext _localctx = new Conjunction_formulaContext(_ctx, getState());
    enterRule(_localctx, 114, RULE_conjunction_formula);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(819);
        implies_formula();
        setState(824);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 88, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(820);
                match(AND);
                setState(821);
                formula();
              }
            }
          }
          setState(826);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 88, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Implies_formulaContext extends ParserRuleContext {
    public Formula_baseContext formula_base() {
      return getRuleContext(Formula_baseContext.class, 0);
    }

    public List<TerminalNode> IMPLIES() {
      return getTokens(CodeQLParser.IMPLIES);
    }

    public TerminalNode IMPLIES(int i) {
      return getToken(CodeQLParser.IMPLIES, i);
    }

    public List<FormulaContext> formula() {
      return getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(int i) {
      return getRuleContext(FormulaContext.class, i);
    }

    public Implies_formulaContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_implies_formula;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterImplies_formula(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitImplies_formula(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitImplies_formula(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Implies_formulaContext implies_formula() throws RecognitionException {
    Implies_formulaContext _localctx = new Implies_formulaContext(_ctx, getState());
    enterRule(_localctx, 116, RULE_implies_formula);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(827);
        formula_base();
        setState(832);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 89, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(828);
                match(IMPLIES);
                setState(829);
                formula();
              }
            }
          }
          setState(834);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 89, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class FparenContext extends ParserRuleContext {
    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public FormulaContext formula() {
      return getRuleContext(FormulaContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public FparenContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_fparen;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterFparen(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitFparen(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitFparen(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FparenContext fparen() throws RecognitionException {
    FparenContext _localctx = new FparenContext(_ctx, getState());
    enterRule(_localctx, 118, RULE_fparen);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(835);
        match(LPAREN);
        setState(836);
        formula();
        setState(837);
        match(RPAREN);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class IfthenContext extends ParserRuleContext {
    public TerminalNode IF() {
      return getToken(CodeQLParser.IF, 0);
    }

    public List<FormulaContext> formula() {
      return getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(int i) {
      return getRuleContext(FormulaContext.class, i);
    }

    public TerminalNode THEN() {
      return getToken(CodeQLParser.THEN, 0);
    }

    public TerminalNode ELSE() {
      return getToken(CodeQLParser.ELSE, 0);
    }

    public IfthenContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_ifthen;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterIfthen(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitIfthen(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitIfthen(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IfthenContext ifthen() throws RecognitionException {
    IfthenContext _localctx = new IfthenContext(_ctx, getState());
    enterRule(_localctx, 120, RULE_ifthen);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(839);
        match(IF);
        setState(840);
        formula();
        setState(841);
        match(THEN);
        setState(842);
        formula();
        setState(843);
        match(ELSE);
        setState(844);
        formula();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class NegatedContext extends ParserRuleContext {
    public TerminalNode NOT() {
      return getToken(CodeQLParser.NOT, 0);
    }

    public FormulaContext formula() {
      return getRuleContext(FormulaContext.class, 0);
    }

    public NegatedContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_negated;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterNegated(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitNegated(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitNegated(this);
      else return visitor.visitChildren(this);
    }
  }

  public final NegatedContext negated() throws RecognitionException {
    NegatedContext _localctx = new NegatedContext(_ctx, getState());
    enterRule(_localctx, 122, RULE_negated);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(846);
        match(NOT);
        setState(847);
        formula();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class QuantifiedContext extends ParserRuleContext {
    public TerminalNode EXISTS() {
      return getToken(CodeQLParser.EXISTS, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public Var_declsContext var_decls() {
      return getRuleContext(Var_declsContext.class, 0);
    }

    public List<TerminalNode> BITOR() {
      return getTokens(CodeQLParser.BITOR);
    }

    public TerminalNode BITOR(int i) {
      return getToken(CodeQLParser.BITOR, i);
    }

    public List<FormulaContext> formula() {
      return getRuleContexts(FormulaContext.class);
    }

    public FormulaContext formula(int i) {
      return getRuleContext(FormulaContext.class, i);
    }

    public TerminalNode FORALL() {
      return getToken(CodeQLParser.FORALL, 0);
    }

    public TerminalNode FOREX() {
      return getToken(CodeQLParser.FOREX, 0);
    }

    public QuantifiedContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_quantified;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterQuantified(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitQuantified(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitQuantified(this);
      else return visitor.visitChildren(this);
    }
  }

  public final QuantifiedContext quantified() throws RecognitionException {
    QuantifiedContext _localctx = new QuantifiedContext(_ctx, getState());
    enterRule(_localctx, 124, RULE_quantified);
    int _la;
    try {
      setState(889);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 94, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(849);
            match(EXISTS);
            setState(850);
            match(LPAREN);
            setState(851);
            expr();
            setState(852);
            match(RPAREN);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(854);
            match(EXISTS);
            setState(855);
            match(LPAREN);
            setState(856);
            var_decls();
            setState(859);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 90, _ctx)) {
              case 1:
                {
                  setState(857);
                  match(BITOR);
                  setState(858);
                  formula();
                }
                break;
            }
            setState(863);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == BITOR) {
              {
                setState(861);
                match(BITOR);
                setState(862);
                formula();
              }
            }

            setState(865);
            match(RPAREN);
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(867);
            match(FORALL);
            setState(868);
            match(LPAREN);
            setState(869);
            var_decls();
            setState(872);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 92, _ctx)) {
              case 1:
                {
                  setState(870);
                  match(BITOR);
                  setState(871);
                  formula();
                }
                break;
            }
            setState(874);
            match(BITOR);
            setState(875);
            formula();
            setState(876);
            match(RPAREN);
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(878);
            match(FOREX);
            setState(879);
            match(LPAREN);
            setState(880);
            var_decls();
            setState(883);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 93, _ctx)) {
              case 1:
                {
                  setState(881);
                  match(BITOR);
                  setState(882);
                  formula();
                }
                break;
            }
            setState(885);
            match(BITOR);
            setState(886);
            formula();
            setState(887);
            match(RPAREN);
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ComparisonContext extends ParserRuleContext {
    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class, i);
    }

    public CompopContext compop() {
      return getRuleContext(CompopContext.class, 0);
    }

    public ComparisonContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_comparison;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterComparison(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitComparison(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitComparison(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ComparisonContext comparison() throws RecognitionException {
    ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
    enterRule(_localctx, 126, RULE_comparison);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(891);
        expr();
        setState(892);
        compop();
        setState(893);
        expr();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CompopContext extends ParserRuleContext {
    public TerminalNode ASSIGN() {
      return getToken(CodeQLParser.ASSIGN, 0);
    }

    public TerminalNode NOTEQUAL() {
      return getToken(CodeQLParser.NOTEQUAL, 0);
    }

    public TerminalNode LT() {
      return getToken(CodeQLParser.LT, 0);
    }

    public TerminalNode GT() {
      return getToken(CodeQLParser.GT, 0);
    }

    public TerminalNode LE() {
      return getToken(CodeQLParser.LE, 0);
    }

    public TerminalNode GE() {
      return getToken(CodeQLParser.GE, 0);
    }

    public CompopContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_compop;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterCompop(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitCompop(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitCompop(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CompopContext compop() throws RecognitionException {
    CompopContext _localctx = new CompopContext(_ctx, getState());
    enterRule(_localctx, 128, RULE_compop);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(895);
        _la = _input.LA(1);
        if (!(((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 543L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InstanceofContext extends ParserRuleContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public TerminalNode INSTANCEOF() {
      return getToken(CodeQLParser.INSTANCEOF, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public InstanceofContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_instanceof;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterInstanceof(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitInstanceof(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitInstanceof(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InstanceofContext instanceof_() throws RecognitionException {
    InstanceofContext _localctx = new InstanceofContext(_ctx, getState());
    enterRule(_localctx, 130, RULE_instanceof);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(897);
        expr();
        setState(898);
        match(INSTANCEOF);
        setState(899);
        type();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class InrangeContext extends ParserRuleContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public TerminalNode IN() {
      return getToken(CodeQLParser.IN, 0);
    }

    public RangeContext range() {
      return getRuleContext(RangeContext.class, 0);
    }

    public SetliteralContext setliteral() {
      return getRuleContext(SetliteralContext.class, 0);
    }

    public InrangeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_inrange;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterInrange(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitInrange(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitInrange(this);
      else return visitor.visitChildren(this);
    }
  }

  public final InrangeContext inrange() throws RecognitionException {
    InrangeContext _localctx = new InrangeContext(_ctx, getState());
    enterRule(_localctx, 132, RULE_inrange);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(901);
        expr();
        setState(902);
        match(IN);
        setState(905);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 95, _ctx)) {
          case 1:
            {
              setState(903);
              range();
            }
            break;
          case 2:
            {
              setState(904);
              setliteral();
            }
            break;
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CallContext extends ParserRuleContext {
    public PredicateRefContext predicateRef() {
      return getRuleContext(PredicateRefContext.class, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public ClosureContext closure() {
      return getRuleContext(ClosureContext.class, 0);
    }

    public ExprsContext exprs() {
      return getRuleContext(ExprsContext.class, 0);
    }

    public PrimaryContext primary() {
      return getRuleContext(PrimaryContext.class, 0);
    }

    public TerminalNode DOT() {
      return getToken(CodeQLParser.DOT, 0);
    }

    public PredicateNameContext predicateName() {
      return getRuleContext(PredicateNameContext.class, 0);
    }

    public CallContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_call;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterCall(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitCall(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitCall(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CallContext call() throws RecognitionException {
    CallContext _localctx = new CallContext(_ctx, getState());
    enterRule(_localctx, 134, RULE_call);
    int _la;
    try {
      setState(929);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 100, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(907);
            predicateRef();
            setState(909);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == MUL || _la == ADD) {
              {
                setState(908);
                closure();
              }
            }

            setState(911);
            match(LPAREN);
            setState(913);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -598475305447836L) != 0)
                || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 247270998810623L) != 0)) {
              {
                setState(912);
                exprs();
              }
            }

            setState(915);
            match(RPAREN);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(917);
            primary();
            setState(918);
            match(DOT);
            setState(919);
            predicateName();
            setState(921);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == MUL || _la == ADD) {
              {
                setState(920);
                closure();
              }
            }

            setState(923);
            match(LPAREN);
            setState(925);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -598475305447836L) != 0)
                || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 247270998810623L) != 0)) {
              {
                setState(924);
                exprs();
              }
            }

            setState(927);
            match(RPAREN);
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ClosureContext extends ParserRuleContext {
    public TerminalNode MUL() {
      return getToken(CodeQLParser.MUL, 0);
    }

    public TerminalNode ADD() {
      return getToken(CodeQLParser.ADD, 0);
    }

    public ClosureContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_closure;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterClosure(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitClosure(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitClosure(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ClosureContext closure() throws RecognitionException {
    ClosureContext _localctx = new ClosureContext(_ctx, getState());
    enterRule(_localctx, 136, RULE_closure);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(931);
        _la = _input.LA(1);
        if (!(_la == MUL || _la == ADD)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ExprContext extends ParserRuleContext {
    public List<MultExprContext> multExpr() {
      return getRuleContexts(MultExprContext.class);
    }

    public MultExprContext multExpr(int i) {
      return getRuleContext(MultExprContext.class, i);
    }

    public List<TerminalNode> ADD() {
      return getTokens(CodeQLParser.ADD);
    }

    public TerminalNode ADD(int i) {
      return getToken(CodeQLParser.ADD, i);
    }

    public List<TerminalNode> SUB() {
      return getTokens(CodeQLParser.SUB);
    }

    public TerminalNode SUB(int i) {
      return getToken(CodeQLParser.SUB, i);
    }

    public ExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expr;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterExpr(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitExpr(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitExpr(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExprContext expr() throws RecognitionException {
    ExprContext _localctx = new ExprContext(_ctx, getState());
    enterRule(_localctx, 138, RULE_expr);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(933);
        multExpr();
        setState(938);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 101, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(934);
                _la = _input.LA(1);
                if (!(_la == SUB || _la == ADD)) {
                  _errHandler.recoverInline(this);
                } else {
                  if (_input.LA(1) == Token.EOF) matchedEOF = true;
                  _errHandler.reportMatch(this);
                  consume();
                }
                setState(935);
                multExpr();
              }
            }
          }
          setState(940);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 101, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class MultExprContext extends ParserRuleContext {
    public List<UnaryExprContext> unaryExpr() {
      return getRuleContexts(UnaryExprContext.class);
    }

    public UnaryExprContext unaryExpr(int i) {
      return getRuleContext(UnaryExprContext.class, i);
    }

    public List<TerminalNode> MUL() {
      return getTokens(CodeQLParser.MUL);
    }

    public TerminalNode MUL(int i) {
      return getToken(CodeQLParser.MUL, i);
    }

    public List<TerminalNode> DIV() {
      return getTokens(CodeQLParser.DIV);
    }

    public TerminalNode DIV(int i) {
      return getToken(CodeQLParser.DIV, i);
    }

    public List<TerminalNode> MOD() {
      return getTokens(CodeQLParser.MOD);
    }

    public TerminalNode MOD(int i) {
      return getToken(CodeQLParser.MOD, i);
    }

    public MultExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_multExpr;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterMultExpr(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitMultExpr(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitMultExpr(this);
      else return visitor.visitChildren(this);
    }
  }

  public final MultExprContext multExpr() throws RecognitionException {
    MultExprContext _localctx = new MultExprContext(_ctx, getState());
    enterRule(_localctx, 140, RULE_multExpr);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(941);
        unaryExpr();
        setState(946);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 102, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(942);
                _la = _input.LA(1);
                if (!(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 1537L) != 0))) {
                  _errHandler.recoverInline(this);
                } else {
                  if (_input.LA(1) == Token.EOF) matchedEOF = true;
                  _errHandler.reportMatch(this);
                  consume();
                }
                setState(943);
                unaryExpr();
              }
            }
          }
          setState(948);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 102, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UnaryExprContext extends ParserRuleContext {
    public NonOpExprContext nonOpExpr() {
      return getRuleContext(NonOpExprContext.class, 0);
    }

    public UnopContext unop() {
      return getRuleContext(UnopContext.class, 0);
    }

    public UnaryExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unaryExpr;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterUnaryExpr(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitUnaryExpr(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitUnaryExpr(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UnaryExprContext unaryExpr() throws RecognitionException {
    UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
    enterRule(_localctx, 142, RULE_unaryExpr);
    try {
      setState(951);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case ANY:
        case AVG:
        case BOOLEAN:
        case CONCAT:
        case COUNT:
        case DATE:
        case FALSE:
        case FLOAT:
        case INT:
        case MAX:
        case MIN:
        case NONE:
        case RANK:
        case RESULT:
        case STRICTCONCAT:
        case STRICTCOUNT:
        case STRICTSUM:
        case STRING:
        case SUM:
        case SUPER:
        case THIS:
        case TRUE:
        case UNIQUE:
        case IMPLEMENTS:
        case SIGNATURE:
        case DEFAULT:
        case ABSTRACT:
        case CACHED:
        case EXTERNAL:
        case EXTENSIBLE:
        case FINAL:
        case TRANSIENT:
        case LIBRARY:
        case PRIVATE:
        case DEPRECATED:
        case OVERRIDE:
        case ADDITIONAL:
        case QUERY:
        case PRAGMA:
        case INLINE:
        case INLINE_LATE:
        case NOINLINE:
        case NOMAGIC:
        case NOOPT:
        case ASSUME_SMALL_DELTA:
        case LANGUAGE:
        case MONOTONICAGGREGATES:
        case BINDINGSET:
        case ONLY_BIND_OUT:
        case ONLY_BIND_INTO:
        case DONTCARE:
        case LPAREN:
        case LBRACK:
        case INT_LITERAL:
        case FLOAT_LITERAL:
        case STRING_LITERAL:
        case LOWERID:
        case UPPERID:
        case ATLOWERID:
          enterOuterAlt(_localctx, 1);
          {
            setState(949);
            nonOpExpr();
          }
          break;
        case SUB:
        case ADD:
          enterOuterAlt(_localctx, 2);
          {
            setState(950);
            unop();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class NonOpExprContext extends ParserRuleContext {
    public TerminalNode DONTCARE() {
      return getToken(CodeQLParser.DONTCARE, 0);
    }

    public CastContext cast() {
      return getRuleContext(CastContext.class, 0);
    }

    public PrimaryContext primary() {
      return getRuleContext(PrimaryContext.class, 0);
    }

    public NonOpExprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_nonOpExpr;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterNonOpExpr(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitNonOpExpr(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitNonOpExpr(this);
      else return visitor.visitChildren(this);
    }
  }

  public final NonOpExprContext nonOpExpr() throws RecognitionException {
    NonOpExprContext _localctx = new NonOpExprContext(_ctx, getState());
    enterRule(_localctx, 144, RULE_nonOpExpr);
    try {
      setState(956);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 104, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(953);
            match(DONTCARE);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(954);
            cast();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(955);
            primary();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PrimaryContext extends ParserRuleContext {
    public PrimaryBaseContext primaryBase() {
      return getRuleContext(PrimaryBaseContext.class, 0);
    }

    public List<PrimaryPostfixOpContext> primaryPostfixOp() {
      return getRuleContexts(PrimaryPostfixOpContext.class);
    }

    public PrimaryPostfixOpContext primaryPostfixOp(int i) {
      return getRuleContext(PrimaryPostfixOpContext.class, i);
    }

    public PrimaryContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_primary;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterPrimary(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitPrimary(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitPrimary(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PrimaryContext primary() throws RecognitionException {
    PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
    enterRule(_localctx, 146, RULE_primary);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(958);
        primaryBase();
        setState(962);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 105, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(959);
                primaryPostfixOp();
              }
            }
          }
          setState(964);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 105, _ctx);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PrimaryPostfixOpContext extends ParserRuleContext {
    public TerminalNode DOT() {
      return getToken(CodeQLParser.DOT, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public PredicateNameContext predicateName() {
      return getRuleContext(PredicateNameContext.class, 0);
    }

    public ClosureContext closure() {
      return getRuleContext(ClosureContext.class, 0);
    }

    public ExprsContext exprs() {
      return getRuleContext(ExprsContext.class, 0);
    }

    public PrimaryPostfixOpContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_primaryPostfixOp;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterPrimaryPostfixOp(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitPrimaryPostfixOp(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitPrimaryPostfixOp(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PrimaryPostfixOpContext primaryPostfixOp() throws RecognitionException {
    PrimaryPostfixOpContext _localctx = new PrimaryPostfixOpContext(_ctx, getState());
    enterRule(_localctx, 148, RULE_primaryPostfixOp);
    int _la;
    try {
      setState(981);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 108, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(965);
            match(DOT);
            setState(966);
            match(LPAREN);
            setState(967);
            type();
            setState(968);
            match(RPAREN);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(970);
            match(DOT);
            setState(971);
            predicateName();
            setState(973);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == MUL || _la == ADD) {
              {
                setState(972);
                closure();
              }
            }

            setState(975);
            match(LPAREN);
            setState(977);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -598475305447836L) != 0)
                || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 247270998810623L) != 0)) {
              {
                setState(976);
                exprs();
              }
            }

            setState(979);
            match(RPAREN);
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Callwithresults_nomemberContext extends ParserRuleContext {
    public PredicateRefContext predicateRef() {
      return getRuleContext(PredicateRefContext.class, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public ClosureContext closure() {
      return getRuleContext(ClosureContext.class, 0);
    }

    public ExprsContext exprs() {
      return getRuleContext(ExprsContext.class, 0);
    }

    public Callwithresults_nomemberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_callwithresults_nomember;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterCallwithresults_nomember(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitCallwithresults_nomember(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitCallwithresults_nomember(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Callwithresults_nomemberContext callwithresults_nomember()
      throws RecognitionException {
    Callwithresults_nomemberContext _localctx =
        new Callwithresults_nomemberContext(_ctx, getState());
    enterRule(_localctx, 150, RULE_callwithresults_nomember);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(983);
        predicateRef();
        setState(985);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == MUL || _la == ADD) {
          {
            setState(984);
            closure();
          }
        }

        setState(987);
        match(LPAREN);
        setState(989);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -598475305447836L) != 0)
            || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 247270998810623L) != 0)) {
          {
            setState(988);
            exprs();
          }
        }

        setState(991);
        match(RPAREN);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PrimaryBaseContext extends ParserRuleContext {
    public EparenContext eparen() {
      return getRuleContext(EparenContext.class, 0);
    }

    public LiteralContext literal() {
      return getRuleContext(LiteralContext.class, 0);
    }

    public VariableContext variable() {
      return getRuleContext(VariableContext.class, 0);
    }

    public Super_exprContext super_expr() {
      return getRuleContext(Super_exprContext.class, 0);
    }

    public AggregationContext aggregation() {
      return getRuleContext(AggregationContext.class, 0);
    }

    public Expression_pragmaContext expression_pragma() {
      return getRuleContext(Expression_pragmaContext.class, 0);
    }

    public Callwithresults_nomemberContext callwithresults_nomember() {
      return getRuleContext(Callwithresults_nomemberContext.class, 0);
    }

    public AnyContext any() {
      return getRuleContext(AnyContext.class, 0);
    }

    public NoneContext none() {
      return getRuleContext(NoneContext.class, 0);
    }

    public RangeContext range() {
      return getRuleContext(RangeContext.class, 0);
    }

    public SetliteralContext setliteral() {
      return getRuleContext(SetliteralContext.class, 0);
    }

    public PrimaryBaseContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_primaryBase;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterPrimaryBase(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitPrimaryBase(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitPrimaryBase(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PrimaryBaseContext primaryBase() throws RecognitionException {
    PrimaryBaseContext _localctx = new PrimaryBaseContext(_ctx, getState());
    enterRule(_localctx, 152, RULE_primaryBase);
    try {
      setState(1004);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 111, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(993);
            eparen();
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(994);
            literal();
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(995);
            variable();
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(996);
            super_expr();
          }
          break;
        case 5:
          enterOuterAlt(_localctx, 5);
          {
            setState(997);
            aggregation();
          }
          break;
        case 6:
          enterOuterAlt(_localctx, 6);
          {
            setState(998);
            expression_pragma();
          }
          break;
        case 7:
          enterOuterAlt(_localctx, 7);
          {
            setState(999);
            callwithresults_nomember();
          }
          break;
        case 8:
          enterOuterAlt(_localctx, 8);
          {
            setState(1000);
            any();
          }
          break;
        case 9:
          enterOuterAlt(_localctx, 9);
          {
            setState(1001);
            none();
          }
          break;
        case 10:
          enterOuterAlt(_localctx, 10);
          {
            setState(1002);
            range();
          }
          break;
        case 11:
          enterOuterAlt(_localctx, 11);
          {
            setState(1003);
            setliteral();
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class NoneContext extends ParserRuleContext {
    public TerminalNode NONE() {
      return getToken(CodeQLParser.NONE, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public NoneContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_none;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterNone(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitNone(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitNone(this);
      else return visitor.visitChildren(this);
    }
  }

  public final NoneContext none() throws RecognitionException {
    NoneContext _localctx = new NoneContext(_ctx, getState());
    enterRule(_localctx, 154, RULE_none);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1006);
        match(NONE);
        setState(1007);
        match(LPAREN);
        setState(1008);
        match(RPAREN);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class EparenContext extends ParserRuleContext {
    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public EparenContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_eparen;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterEparen(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitEparen(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitEparen(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EparenContext eparen() throws RecognitionException {
    EparenContext _localctx = new EparenContext(_ctx, getState());
    enterRule(_localctx, 156, RULE_eparen);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1010);
        match(LPAREN);
        setState(1011);
        expr();
        setState(1012);
        match(RPAREN);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class LiteralContext extends ParserRuleContext {
    public TerminalNode FALSE() {
      return getToken(CodeQLParser.FALSE, 0);
    }

    public TerminalNode TRUE() {
      return getToken(CodeQLParser.TRUE, 0);
    }

    public TerminalNode INT_LITERAL() {
      return getToken(CodeQLParser.INT_LITERAL, 0);
    }

    public TerminalNode FLOAT_LITERAL() {
      return getToken(CodeQLParser.FLOAT_LITERAL, 0);
    }

    public TerminalNode STRING_LITERAL() {
      return getToken(CodeQLParser.STRING_LITERAL, 0);
    }

    public LiteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_literal;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterLiteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitLiteral(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitLiteral(this);
      else return visitor.visitChildren(this);
    }
  }

  public final LiteralContext literal() throws RecognitionException {
    LiteralContext _localctx = new LiteralContext(_ctx, getState());
    enterRule(_localctx, 158, RULE_literal);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1014);
        _la = _input.LA(1);
        if (!(_la == FALSE
            || _la == TRUE
            || ((((_la - 101)) & ~0x3f) == 0 && ((1L << (_la - 101)) & 7L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UnopContext extends ParserRuleContext {
    public TerminalNode ADD() {
      return getToken(CodeQLParser.ADD, 0);
    }

    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public TerminalNode SUB() {
      return getToken(CodeQLParser.SUB, 0);
    }

    public UnopContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_unop;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterUnop(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitUnop(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitUnop(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UnopContext unop() throws RecognitionException {
    UnopContext _localctx = new UnopContext(_ctx, getState());
    enterRule(_localctx, 160, RULE_unop);
    try {
      setState(1020);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case ADD:
          enterOuterAlt(_localctx, 1);
          {
            setState(1016);
            match(ADD);
            setState(1017);
            expr();
          }
          break;
        case SUB:
          enterOuterAlt(_localctx, 2);
          {
            setState(1018);
            match(SUB);
            setState(1019);
            expr();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class VariableContext extends ParserRuleContext {
    public VarnameContext varname() {
      return getRuleContext(VarnameContext.class, 0);
    }

    public TerminalNode THIS() {
      return getToken(CodeQLParser.THIS, 0);
    }

    public TerminalNode RESULT() {
      return getToken(CodeQLParser.RESULT, 0);
    }

    public VariableContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_variable;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterVariable(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitVariable(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitVariable(this);
      else return visitor.visitChildren(this);
    }
  }

  public final VariableContext variable() throws RecognitionException {
    VariableContext _localctx = new VariableContext(_ctx, getState());
    enterRule(_localctx, 162, RULE_variable);
    try {
      setState(1025);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case UNIQUE:
        case IMPLEMENTS:
        case SIGNATURE:
        case DEFAULT:
        case ABSTRACT:
        case CACHED:
        case EXTERNAL:
        case EXTENSIBLE:
        case FINAL:
        case TRANSIENT:
        case LIBRARY:
        case PRIVATE:
        case DEPRECATED:
        case OVERRIDE:
        case ADDITIONAL:
        case QUERY:
        case PRAGMA:
        case INLINE:
        case INLINE_LATE:
        case NOINLINE:
        case NOMAGIC:
        case NOOPT:
        case ASSUME_SMALL_DELTA:
        case LANGUAGE:
        case MONOTONICAGGREGATES:
        case BINDINGSET:
        case ONLY_BIND_OUT:
        case ONLY_BIND_INTO:
        case LOWERID:
          enterOuterAlt(_localctx, 1);
          {
            setState(1022);
            varname();
          }
          break;
        case THIS:
          enterOuterAlt(_localctx, 2);
          {
            setState(1023);
            match(THIS);
          }
          break;
        case RESULT:
          enterOuterAlt(_localctx, 3);
          {
            setState(1024);
            match(RESULT);
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Super_exprContext extends ParserRuleContext {
    public TerminalNode SUPER() {
      return getToken(CodeQLParser.SUPER, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public TerminalNode DOT() {
      return getToken(CodeQLParser.DOT, 0);
    }

    public Super_exprContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_super_expr;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterSuper_expr(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitSuper_expr(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitSuper_expr(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Super_exprContext super_expr() throws RecognitionException {
    Super_exprContext _localctx = new Super_exprContext(_ctx, getState());
    enterRule(_localctx, 164, RULE_super_expr);
    try {
      setState(1032);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case SUPER:
          enterOuterAlt(_localctx, 1);
          {
            setState(1027);
            match(SUPER);
          }
          break;
        case BOOLEAN:
        case DATE:
        case FLOAT:
        case INT:
        case STRING:
        case LOWERID:
        case UPPERID:
        case ATLOWERID:
          enterOuterAlt(_localctx, 2);
          {
            setState(1028);
            type();
            setState(1029);
            match(DOT);
            setState(1030);
            match(SUPER);
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class CastContext extends ParserRuleContext {
    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public TypeContext type() {
      return getRuleContext(TypeContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public CastContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_cast;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterCast(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitCast(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitCast(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CastContext cast() throws RecognitionException {
    CastContext _localctx = new CastContext(_ctx, getState());
    enterRule(_localctx, 166, RULE_cast);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1034);
        match(LPAREN);
        setState(1035);
        type();
        setState(1036);
        match(RPAREN);
        setState(1037);
        expr();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AggregationContext extends ParserRuleContext {
    public AggidContext aggid() {
      return getRuleContext(AggidContext.class, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public Var_declsContext var_decls() {
      return getRuleContext(Var_declsContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public TerminalNode LBRACK() {
      return getToken(CodeQLParser.LBRACK, 0);
    }

    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public TerminalNode RBRACK() {
      return getToken(CodeQLParser.RBRACK, 0);
    }

    public List<TerminalNode> BITOR() {
      return getTokens(CodeQLParser.BITOR);
    }

    public TerminalNode BITOR(int i) {
      return getToken(CodeQLParser.BITOR, i);
    }

    public FormulaContext formula() {
      return getRuleContext(FormulaContext.class, 0);
    }

    public As_exprsContext as_exprs() {
      return getRuleContext(As_exprsContext.class, 0);
    }

    public TerminalNode ORDER() {
      return getToken(CodeQLParser.ORDER, 0);
    }

    public TerminalNode BY() {
      return getToken(CodeQLParser.BY, 0);
    }

    public AggorderbysContext aggorderbys() {
      return getRuleContext(AggorderbysContext.class, 0);
    }

    public TerminalNode UNIQUE() {
      return getToken(CodeQLParser.UNIQUE, 0);
    }

    public AggregationContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_aggregation;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterAggregation(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitAggregation(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitAggregation(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AggregationContext aggregation() throws RecognitionException {
    AggregationContext _localctx = new AggregationContext(_ctx, getState());
    enterRule(_localctx, 168, RULE_aggregation);
    int _la;
    try {
      setState(1094);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 124, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(1039);
            aggid();
            setState(1044);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == LBRACK) {
              {
                setState(1040);
                match(LBRACK);
                setState(1041);
                expr();
                setState(1042);
                match(RBRACK);
              }
            }

            setState(1046);
            match(LPAREN);
            setState(1047);
            var_decls();
            setState(1061);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == BITOR) {
              {
                setState(1048);
                match(BITOR);
                setState(1050);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -598471007580572L) != 0)
                    || ((((_la - 64)) & ~0x3f) == 0
                        && ((1L << (_la - 64)) & 247270998810623L) != 0)) {
                  {
                    setState(1049);
                    formula();
                  }
                }

                setState(1059);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == BITOR) {
                  {
                    setState(1052);
                    match(BITOR);
                    setState(1053);
                    as_exprs();
                    setState(1057);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == ORDER) {
                      {
                        setState(1054);
                        match(ORDER);
                        setState(1055);
                        match(BY);
                        setState(1056);
                        aggorderbys();
                      }
                    }
                  }
                }
              }
            }

            setState(1063);
            match(RPAREN);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(1065);
            aggid();
            setState(1070);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == LBRACK) {
              {
                setState(1066);
                match(LBRACK);
                setState(1067);
                expr();
                setState(1068);
                match(RBRACK);
              }
            }

            setState(1072);
            match(LPAREN);
            setState(1073);
            as_exprs();
            setState(1077);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == ORDER) {
              {
                setState(1074);
                match(ORDER);
                setState(1075);
                match(BY);
                setState(1076);
                aggorderbys();
              }
            }

            setState(1079);
            match(RPAREN);
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(1081);
            match(UNIQUE);
            setState(1082);
            match(LPAREN);
            setState(1083);
            var_decls();
            setState(1084);
            match(BITOR);
            setState(1086);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -598471007580572L) != 0)
                || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 247270998810623L) != 0)) {
              {
                setState(1085);
                formula();
              }
            }

            setState(1090);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == BITOR) {
              {
                setState(1088);
                match(BITOR);
                setState(1089);
                as_exprs();
              }
            }

            setState(1092);
            match(RPAREN);
          }
          break;
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Expression_pragmaContext extends ParserRuleContext {
    public TerminalNode PRAGMA() {
      return getToken(CodeQLParser.PRAGMA, 0);
    }

    public TerminalNode LBRACK() {
      return getToken(CodeQLParser.LBRACK, 0);
    }

    public Expression_pragma_typeContext expression_pragma_type() {
      return getRuleContext(Expression_pragma_typeContext.class, 0);
    }

    public TerminalNode RBRACK() {
      return getToken(CodeQLParser.RBRACK, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public Expression_pragmaContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expression_pragma;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterExpression_pragma(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitExpression_pragma(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitExpression_pragma(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Expression_pragmaContext expression_pragma() throws RecognitionException {
    Expression_pragmaContext _localctx = new Expression_pragmaContext(_ctx, getState());
    enterRule(_localctx, 170, RULE_expression_pragma);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1096);
        match(PRAGMA);
        setState(1097);
        match(LBRACK);
        setState(1098);
        expression_pragma_type();
        setState(1099);
        match(RBRACK);
        setState(1100);
        match(LPAREN);
        setState(1101);
        expr();
        setState(1102);
        match(RPAREN);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Expression_pragma_typeContext extends ParserRuleContext {
    public TerminalNode ONLY_BIND_OUT() {
      return getToken(CodeQLParser.ONLY_BIND_OUT, 0);
    }

    public TerminalNode ONLY_BIND_INTO() {
      return getToken(CodeQLParser.ONLY_BIND_INTO, 0);
    }

    public Expression_pragma_typeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expression_pragma_type;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterExpression_pragma_type(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitExpression_pragma_type(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitExpression_pragma_type(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Expression_pragma_typeContext expression_pragma_type() throws RecognitionException {
    Expression_pragma_typeContext _localctx = new Expression_pragma_typeContext(_ctx, getState());
    enterRule(_localctx, 172, RULE_expression_pragma_type);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1104);
        _la = _input.LA(1);
        if (!(_la == ONLY_BIND_OUT || _la == ONLY_BIND_INTO)) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AggidContext extends ParserRuleContext {
    public TerminalNode AVG() {
      return getToken(CodeQLParser.AVG, 0);
    }

    public TerminalNode CONCAT() {
      return getToken(CodeQLParser.CONCAT, 0);
    }

    public TerminalNode COUNT() {
      return getToken(CodeQLParser.COUNT, 0);
    }

    public TerminalNode MAX() {
      return getToken(CodeQLParser.MAX, 0);
    }

    public TerminalNode MIN() {
      return getToken(CodeQLParser.MIN, 0);
    }

    public TerminalNode RANK() {
      return getToken(CodeQLParser.RANK, 0);
    }

    public TerminalNode STRICTCONCAT() {
      return getToken(CodeQLParser.STRICTCONCAT, 0);
    }

    public TerminalNode STRICTCOUNT() {
      return getToken(CodeQLParser.STRICTCOUNT, 0);
    }

    public TerminalNode STRICTSUM() {
      return getToken(CodeQLParser.STRICTSUM, 0);
    }

    public TerminalNode SUM() {
      return getToken(CodeQLParser.SUM, 0);
    }

    public AggidContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_aggid;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterAggid(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitAggid(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitAggid(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AggidContext aggid() throws RecognitionException {
    AggidContext _localctx = new AggidContext(_ctx, getState());
    enterRule(_localctx, 174, RULE_aggid);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1106);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 12713505850912L) != 0))) {
          _errHandler.recoverInline(this);
        } else {
          if (_input.LA(1) == Token.EOF) matchedEOF = true;
          _errHandler.reportMatch(this);
          consume();
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AggorderbysContext extends ParserRuleContext {
    public List<AggorderbyContext> aggorderby() {
      return getRuleContexts(AggorderbyContext.class);
    }

    public AggorderbyContext aggorderby(int i) {
      return getRuleContext(AggorderbyContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public AggorderbysContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_aggorderbys;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterAggorderbys(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitAggorderbys(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitAggorderbys(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AggorderbysContext aggorderbys() throws RecognitionException {
    AggorderbysContext _localctx = new AggorderbysContext(_ctx, getState());
    enterRule(_localctx, 176, RULE_aggorderbys);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1108);
        aggorderby();
        setState(1113);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(1109);
              match(COMMA);
              setState(1110);
              aggorderby();
            }
          }
          setState(1115);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AggorderbyContext extends ParserRuleContext {
    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public TerminalNode ASC() {
      return getToken(CodeQLParser.ASC, 0);
    }

    public TerminalNode DESC() {
      return getToken(CodeQLParser.DESC, 0);
    }

    public AggorderbyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_aggorderby;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterAggorderby(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitAggorderby(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitAggorderby(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AggorderbyContext aggorderby() throws RecognitionException {
    AggorderbyContext _localctx = new AggorderbyContext(_ctx, getState());
    enterRule(_localctx, 178, RULE_aggorderby);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1116);
        expr();
        setState(1118);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == ASC || _la == DESC) {
          {
            setState(1117);
            _la = _input.LA(1);
            if (!(_la == ASC || _la == DESC)) {
              _errHandler.recoverInline(this);
            } else {
              if (_input.LA(1) == Token.EOF) matchedEOF = true;
              _errHandler.reportMatch(this);
              consume();
            }
          }
        }
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class AnyContext extends ParserRuleContext {
    public TerminalNode ANY() {
      return getToken(CodeQLParser.ANY, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(CodeQLParser.LPAREN, 0);
    }

    public Var_declsContext var_decls() {
      return getRuleContext(Var_declsContext.class, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(CodeQLParser.RPAREN, 0);
    }

    public List<TerminalNode> BITOR() {
      return getTokens(CodeQLParser.BITOR);
    }

    public TerminalNode BITOR(int i) {
      return getToken(CodeQLParser.BITOR, i);
    }

    public FormulaContext formula() {
      return getRuleContext(FormulaContext.class, 0);
    }

    public ExprContext expr() {
      return getRuleContext(ExprContext.class, 0);
    }

    public AnyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_any;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterAny(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener) ((CodeQLParserListener) listener).exitAny(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitAny(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AnyContext any() throws RecognitionException {
    AnyContext _localctx = new AnyContext(_ctx, getState());
    enterRule(_localctx, 180, RULE_any);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1120);
        match(ANY);
        setState(1121);
        match(LPAREN);
        setState(1122);
        var_decls();
        setState(1131);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == BITOR) {
          {
            setState(1123);
            match(BITOR);
            setState(1125);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -598471007580572L) != 0)
                || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 247270998810623L) != 0)) {
              {
                setState(1124);
                formula();
              }
            }

            setState(1129);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == BITOR) {
              {
                setState(1127);
                match(BITOR);
                setState(1128);
                expr();
              }
            }
          }
        }

        setState(1133);
        match(RPAREN);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class RangeContext extends ParserRuleContext {
    public TerminalNode LBRACK() {
      return getToken(CodeQLParser.LBRACK, 0);
    }

    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class, i);
    }

    public TerminalNode DOTDOT() {
      return getToken(CodeQLParser.DOTDOT, 0);
    }

    public TerminalNode RBRACK() {
      return getToken(CodeQLParser.RBRACK, 0);
    }

    public RangeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_range;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterRange(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitRange(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitRange(this);
      else return visitor.visitChildren(this);
    }
  }

  public final RangeContext range() throws RecognitionException {
    RangeContext _localctx = new RangeContext(_ctx, getState());
    enterRule(_localctx, 182, RULE_range);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1135);
        match(LBRACK);
        setState(1136);
        expr();
        setState(1137);
        match(DOTDOT);
        setState(1138);
        expr();
        setState(1139);
        match(RBRACK);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class SetliteralContext extends ParserRuleContext {
    public TerminalNode LBRACK() {
      return getToken(CodeQLParser.LBRACK, 0);
    }

    public List<ExprContext> expr() {
      return getRuleContexts(ExprContext.class);
    }

    public ExprContext expr(int i) {
      return getRuleContext(ExprContext.class, i);
    }

    public TerminalNode RBRACK() {
      return getToken(CodeQLParser.RBRACK, 0);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(CodeQLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(CodeQLParser.COMMA, i);
    }

    public SetliteralContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_setliteral;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterSetliteral(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitSetliteral(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitSetliteral(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SetliteralContext setliteral() throws RecognitionException {
    SetliteralContext _localctx = new SetliteralContext(_ctx, getState());
    enterRule(_localctx, 184, RULE_setliteral);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(1141);
        match(LBRACK);
        setState(1142);
        expr();
        setState(1147);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 130, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(1143);
                match(COMMA);
                setState(1144);
                expr();
              }
            }
          }
          setState(1149);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 130, _ctx);
        }
        setState(1151);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == COMMA) {
          {
            setState(1150);
            match(COMMA);
          }
        }

        setState(1153);
        match(RBRACK);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ModulenameContext extends ParserRuleContext {
    public SimpleIdContext simpleId() {
      return getRuleContext(SimpleIdContext.class, 0);
    }

    public ModulenameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_modulename;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterModulename(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitModulename(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitModulename(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ModulenameContext modulename() throws RecognitionException {
    ModulenameContext _localctx = new ModulenameContext(_ctx, getState());
    enterRule(_localctx, 186, RULE_modulename);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1155);
        simpleId();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ModuleSignatureNameContext extends ParserRuleContext {
    public TerminalNode UPPERID() {
      return getToken(CodeQLParser.UPPERID, 0);
    }

    public ModuleSignatureNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_moduleSignatureName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterModuleSignatureName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitModuleSignatureName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitModuleSignatureName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ModuleSignatureNameContext moduleSignatureName() throws RecognitionException {
    ModuleSignatureNameContext _localctx = new ModuleSignatureNameContext(_ctx, getState());
    enterRule(_localctx, 188, RULE_moduleSignatureName);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1157);
        match(UPPERID);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ClassnameContext extends ParserRuleContext {
    public TerminalNode UPPERID() {
      return getToken(CodeQLParser.UPPERID, 0);
    }

    public ClassnameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_classname;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterClassname(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitClassname(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitClassname(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ClassnameContext classname() throws RecognitionException {
    ClassnameContext _localctx = new ClassnameContext(_ctx, getState());
    enterRule(_localctx, 190, RULE_classname);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1159);
        match(UPPERID);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DbbasetypeContext extends ParserRuleContext {
    public TerminalNode ATLOWERID() {
      return getToken(CodeQLParser.ATLOWERID, 0);
    }

    public DbbasetypeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_dbbasetype;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterDbbasetype(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitDbbasetype(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitDbbasetype(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DbbasetypeContext dbbasetype() throws RecognitionException {
    DbbasetypeContext _localctx = new DbbasetypeContext(_ctx, getState());
    enterRule(_localctx, 192, RULE_dbbasetype);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1161);
        match(ATLOWERID);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PredicateRefContext extends ParserRuleContext {
    public PredicateCallNameContext predicateCallName() {
      return getRuleContext(PredicateCallNameContext.class, 0);
    }

    public ModuleExprContext moduleExpr() {
      return getRuleContext(ModuleExprContext.class, 0);
    }

    public TerminalNode COLONCOLON() {
      return getToken(CodeQLParser.COLONCOLON, 0);
    }

    public PredicateRefContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_predicateRef;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterPredicateRef(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitPredicateRef(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitPredicateRef(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PredicateRefContext predicateRef() throws RecognitionException {
    PredicateRefContext _localctx = new PredicateRefContext(_ctx, getState());
    enterRule(_localctx, 194, RULE_predicateRef);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1166);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 132, _ctx)) {
          case 1:
            {
              setState(1163);
              moduleExpr(0);
              setState(1164);
              match(COLONCOLON);
            }
            break;
        }
        setState(1168);
        predicateCallName();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PredicateNameContext extends ParserRuleContext {
    public TerminalNode LOWERID() {
      return getToken(CodeQLParser.LOWERID, 0);
    }

    public KeywordAllowedContext keywordAllowed() {
      return getRuleContext(KeywordAllowedContext.class, 0);
    }

    public PredicateNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_predicateName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterPredicateName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitPredicateName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitPredicateName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PredicateNameContext predicateName() throws RecognitionException {
    PredicateNameContext _localctx = new PredicateNameContext(_ctx, getState());
    enterRule(_localctx, 196, RULE_predicateName);
    try {
      setState(1172);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case LOWERID:
          enterOuterAlt(_localctx, 1);
          {
            setState(1170);
            match(LOWERID);
          }
          break;
        case UNIQUE:
        case IMPLEMENTS:
        case SIGNATURE:
        case DEFAULT:
        case ABSTRACT:
        case CACHED:
        case EXTERNAL:
        case EXTENSIBLE:
        case FINAL:
        case TRANSIENT:
        case LIBRARY:
        case PRIVATE:
        case DEPRECATED:
        case OVERRIDE:
        case ADDITIONAL:
        case QUERY:
        case PRAGMA:
        case INLINE:
        case INLINE_LATE:
        case NOINLINE:
        case NOMAGIC:
        case NOOPT:
        case ASSUME_SMALL_DELTA:
        case LANGUAGE:
        case MONOTONICAGGREGATES:
        case BINDINGSET:
        case ONLY_BIND_OUT:
        case ONLY_BIND_INTO:
          enterOuterAlt(_localctx, 2);
          {
            setState(1171);
            keywordAllowed();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PredicateCallNameContext extends ParserRuleContext {
    public TerminalNode LOWERID() {
      return getToken(CodeQLParser.LOWERID, 0);
    }

    public TerminalNode ATLOWERID() {
      return getToken(CodeQLParser.ATLOWERID, 0);
    }

    public TerminalNode UPPERID() {
      return getToken(CodeQLParser.UPPERID, 0);
    }

    public KeywordPredCallAllowedContext keywordPredCallAllowed() {
      return getRuleContext(KeywordPredCallAllowedContext.class, 0);
    }

    public PredicateCallNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_predicateCallName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterPredicateCallName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitPredicateCallName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitPredicateCallName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PredicateCallNameContext predicateCallName() throws RecognitionException {
    PredicateCallNameContext _localctx = new PredicateCallNameContext(_ctx, getState());
    enterRule(_localctx, 198, RULE_predicateCallName);
    try {
      setState(1178);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case LOWERID:
          enterOuterAlt(_localctx, 1);
          {
            setState(1174);
            match(LOWERID);
          }
          break;
        case ATLOWERID:
          enterOuterAlt(_localctx, 2);
          {
            setState(1175);
            match(ATLOWERID);
          }
          break;
        case UPPERID:
          enterOuterAlt(_localctx, 3);
          {
            setState(1176);
            match(UPPERID);
          }
          break;
        case ANY:
        case NONE:
        case UNIQUE:
        case IMPLEMENTS:
        case SIGNATURE:
        case DEFAULT:
        case ABSTRACT:
        case CACHED:
        case EXTERNAL:
        case EXTENSIBLE:
        case FINAL:
        case TRANSIENT:
        case LIBRARY:
        case PRIVATE:
        case DEPRECATED:
        case OVERRIDE:
        case ADDITIONAL:
        case QUERY:
        case PRAGMA:
        case INLINE:
        case INLINE_LATE:
        case NOINLINE:
        case NOMAGIC:
        case NOOPT:
        case ASSUME_SMALL_DELTA:
        case LANGUAGE:
        case MONOTONICAGGREGATES:
        case BINDINGSET:
        case ONLY_BIND_OUT:
        case ONLY_BIND_INTO:
          enterOuterAlt(_localctx, 4);
          {
            setState(1177);
            keywordPredCallAllowed();
          }
          break;
        default:
          throw new NoViableAltException(this);
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ParameterNameContext extends ParserRuleContext {
    public SimpleIdContext simpleId() {
      return getRuleContext(SimpleIdContext.class, 0);
    }

    public ParameterNameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_parameterName;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).enterParameterName(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof CodeQLParserListener)
        ((CodeQLParserListener) listener).exitParameterName(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof CodeQLParserVisitor)
        return ((CodeQLParserVisitor<? extends T>) visitor).visitParameterName(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ParameterNameContext parameterName() throws RecognitionException {
    ParameterNameContext _localctx = new ParameterNameContext(_ctx, getState());
    enterRule(_localctx, 200, RULE_parameterName);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(1180);
        simpleId();
      }
    } catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    } finally {
      exitRule();
    }
    return _localctx;
  }

  public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
    switch (ruleIndex) {
      case 11:
        return qualId_sempred((QualIdContext) _localctx, predIndex);
      case 12:
        return importModuleExpr_sempred((ImportModuleExprContext) _localctx, predIndex);
      case 47:
        return moduleExpr_sempred((ModuleExprContext) _localctx, predIndex);
    }
    return true;
  }

  private boolean qualId_sempred(QualIdContext _localctx, int predIndex) {
    switch (predIndex) {
      case 0:
        return precpred(_ctx, 1);
    }
    return true;
  }

  private boolean importModuleExpr_sempred(ImportModuleExprContext _localctx, int predIndex) {
    switch (predIndex) {
      case 1:
        return precpred(_ctx, 1);
    }
    return true;
  }

  private boolean moduleExpr_sempred(ModuleExprContext _localctx, int predIndex) {
    switch (predIndex) {
      case 2:
        return precpred(_ctx, 1);
    }
    return true;
  }

  public static final String _serializedATN =
      "\u0004\u0001o\u049f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
          + "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"
          + "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"
          + "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"
          + "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"
          + "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"
          + "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"
          + "\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"
          + "\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"
          + "\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"
          + "\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"
          + "#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"
          + "(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"
          + "-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"
          + "2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"
          + "7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"
          + "<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"
          + "A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"
          + "F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"
          + "K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"
          + "P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"
          + "U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007Y\u0002"
          + "Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007^\u0002"
          + "_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007c\u0002"
          + "d\u0007d\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"
          + "\u0000\u0003\u0000\u00d1\b\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001"
          + "\u0002\u0001\u0002\u0003\u0002\u00d8\b\u0002\u0001\u0003\u0001\u0003\u0003"
          + "\u0003\u00dc\b\u0003\u0001\u0004\u0003\u0004\u00df\b\u0004\u0001\u0004"
          + "\u0001\u0004\u0001\u0004\u0001\u0005\u0005\u0005\u00e5\b\u0005\n\u0005"
          + "\f\u0005\u00e8\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"
          + "\u00ed\b\u0005\u0001\u0005\u0003\u0005\u00f0\b\u0005\u0001\u0005\u0001"
          + "\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"
          + "\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00fd\b\u0006\n"
          + "\u0006\f\u0006\u0100\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"
          + "\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0108\b\u0007\n\u0007\f\u0007"
          + "\u010b\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"
          + "\u0001\b\u0001\b\u0005\b\u0116\b\b\n\b\f\b\u0119\t\b\u0001\t\u0001\t\u0001"
          + "\t\u0001\t\u0001\t\u0003\t\u0120\b\t\u0001\n\u0001\n\u0001\u000b\u0001"
          + "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u012a"
          + "\b\u000b\n\u000b\f\u000b\u012d\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f"
          + "\u0001\f\u0001\f\u0001\f\u0003\f\u0136\b\f\u0005\f\u0138\b\f\n\f\f\f\u013b"
          + "\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0141\b\r\n\r\f\r\u0144\t"
          + "\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"
          + "\u000e\u0001\u000e\u0003\u000e\u014e\b\u000e\u0001\u000f\u0001\u000f\u0001"
          + "\u000f\u0003\u000f\u0153\b\u000f\u0001\u0010\u0003\u0010\u0156\b\u0010"
          + "\u0001\u0010\u0005\u0010\u0159\b\u0010\n\u0010\f\u0010\u015c\t\u0010\u0001"
          + "\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0003\u0011\u0163"
          + "\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"
          + "\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u016d\b\u0011\n\u0011\f\u0011"
          + "\u0170\t\u0011\u0003\u0011\u0172\b\u0011\u0001\u0011\u0001\u0011\u0001"
          + "\u0011\u0005\u0011\u0177\b\u0011\n\u0011\f\u0011\u017a\t\u0011\u0001\u0011"
          + "\u0003\u0011\u017d\b\u0011\u0001\u0012\u0003\u0012\u0180\b\u0012\u0001"
          + "\u0012\u0005\u0012\u0183\b\u0012\n\u0012\f\u0012\u0186\t\u0012\u0001\u0012"
          + "\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u018c\b\u0012\u0001\u0012"
          + "\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"
          + "\u0005\u0013\u0195\b\u0013\n\u0013\f\u0013\u0198\t\u0013\u0001\u0014\u0003"
          + "\u0014\u019b\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"
          + "\u0015\u0003\u0015\u01a2\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"
          + "\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0003\u0016\u01ac"
          + "\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"
          + "\u0016\u0001\u0016\u0005\u0016\u01b5\b\u0016\n\u0016\f\u0016\u01b8\t\u0016"
          + "\u0003\u0016\u01ba\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016"
          + "\u01bf\b\u0016\n\u0016\f\u0016\u01c2\t\u0016\u0001\u0016\u0003\u0016\u01c5"
          + "\b\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u01c9\b\u0017\u0001\u0017"
          + "\u0001\u0017\u0003\u0017\u01cd\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017"
          + "\u0001\u0017\u0001\u0017\u0003\u0017\u01d4\b\u0017\u0001\u0018\u0001\u0018"
          + "\u0001\u0018\u0005\u0018\u01d9\b\u0018\n\u0018\f\u0018\u01dc\t\u0018\u0001"
          + "\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u01e1\b\u0019\u0001\u001a\u0001"
          + "\u001a\u0001\u001a\u0005\u001a\u01e6\b\u001a\n\u001a\f\u001a\u01e9\t\u001a"
          + "\u0001\u001b\u0001\u001b\u0003\u001b\u01ed\b\u001b\u0001\u001c\u0001\u001c"
          + "\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u01f4\b\u001d\n\u001d"
          + "\f\u001d\u01f7\t\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"
          + "\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0201\b\u001e"
          + "\u0001\u001f\u0001\u001f\u0001 \u0003 \u0206\b \u0001 \u0001 \u0001 \u0001"
          + " \u0001 \u0001 \u0001!\u0001!\u0001!\u0005!\u0211\b!\n!\f!\u0214\t!\u0001"
          + "\"\u0003\"\u0217\b\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"
          + "\"\u0001#\u0003#\u0221\b#\u0001#\u0001#\u0001#\u0001#\u0001$\u0005$\u0228"
          + "\b$\n$\f$\u022b\t$\u0001%\u0001%\u0003%\u022f\b%\u0001&\u0001&\u0001\'"
          + "\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0005(\u023a\b(\n(\f(\u023d"
          + "\t(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"
          + "(\u0001(\u0005(\u024a\b(\n(\f(\u024d\t(\u0003(\u024f\b(\u0001(\u0003("
          + "\u0252\b(\u0001)\u0001)\u0003)\u0256\b)\u0001)\u0001)\u0001)\u0001)\u0001"
          + ")\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"
          + "*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0005*\u026d\b*\n*\f*\u0270"
          + "\t*\u0003*\u0272\b*\u0001*\u0001*\u0001*\u0003*\u0277\b*\u0001*\u0001"
          + "*\u0003*\u027b\b*\u0001+\u0003+\u027e\b+\u0001+\u0001+\u0001+\u0001+\u0001"
          + "+\u0001+\u0001+\u0005+\u0287\b+\n+\f+\u028a\t+\u0003+\u028c\b+\u0001+"
          + "\u0001+\u0001+\u0001+\u0005+\u0292\b+\n+\f+\u0295\t+\u0003+\u0297\b+\u0001"
          + "+\u0001+\u0005+\u029b\b+\n+\f+\u029e\t+\u0001+\u0001+\u0001,\u0001,\u0001"
          + ",\u0003,\u02a5\b,\u0001-\u0003-\u02a8\b-\u0001-\u0001-\u0001-\u0001-\u0001"
          + "-\u0001-\u0001-\u0001-\u0001.\u0003.\u02b3\b.\u0001.\u0001.\u0001.\u0001"
          + ".\u0001/\u0001/\u0001/\u0003/\u02bc\b/\u0001/\u0001/\u0001/\u0001/\u0003"
          + "/\u02c2\b/\u0005/\u02c4\b/\n/\f/\u02c7\t/\u00010\u00010\u00010\u00030"
          + "\u02cc\b0\u00010\u00010\u00030\u02d0\b0\u00011\u00011\u00011\u00031\u02d5"
          + "\b1\u00011\u00011\u00011\u00011\u00031\u02db\b1\u00012\u00012\u00012\u0003"
          + "2\u02e0\b2\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u00032\u02e9"
          + "\b2\u00013\u00013\u00013\u00053\u02ee\b3\n3\f3\u02f1\t3\u00014\u00034"
          + "\u02f4\b4\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u0001"
          + "4\u00014\u00034\u0300\b4\u00014\u00014\u00014\u00014\u00014\u00014\u0001"
          + "4\u00014\u00034\u030a\b4\u00014\u00014\u00014\u00014\u00014\u00014\u0001"
          + "4\u00034\u0313\b4\u00015\u00015\u00015\u00055\u0318\b5\n5\f5\u031b\t5"
          + "\u00035\u031d\b5\u00016\u00016\u00016\u00017\u00017\u00017\u00057\u0325"
          + "\b7\n7\f7\u0328\t7\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001"
          + "8\u00038\u0332\b8\u00019\u00019\u00019\u00059\u0337\b9\n9\f9\u033a\t9"
          + "\u0001:\u0001:\u0001:\u0005:\u033f\b:\n:\f:\u0342\t:\u0001;\u0001;\u0001"
          + ";\u0001;\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001=\u0001"
          + "=\u0001=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0001"
          + ">\u0001>\u0003>\u035c\b>\u0001>\u0001>\u0003>\u0360\b>\u0001>\u0001>\u0001"
          + ">\u0001>\u0001>\u0001>\u0001>\u0003>\u0369\b>\u0001>\u0001>\u0001>\u0001"
          + ">\u0001>\u0001>\u0001>\u0001>\u0001>\u0003>\u0374\b>\u0001>\u0001>\u0001"
          + ">\u0001>\u0003>\u037a\b>\u0001?\u0001?\u0001?\u0001?\u0001@\u0001@\u0001"
          + "A\u0001A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001B\u0003B\u038a\bB\u0001"
          + "C\u0001C\u0003C\u038e\bC\u0001C\u0001C\u0003C\u0392\bC\u0001C\u0001C\u0001"
          + "C\u0001C\u0001C\u0001C\u0003C\u039a\bC\u0001C\u0001C\u0003C\u039e\bC\u0001"
          + "C\u0001C\u0003C\u03a2\bC\u0001D\u0001D\u0001E\u0001E\u0001E\u0005E\u03a9"
          + "\bE\nE\fE\u03ac\tE\u0001F\u0001F\u0001F\u0005F\u03b1\bF\nF\fF\u03b4\t"
          + "F\u0001G\u0001G\u0003G\u03b8\bG\u0001H\u0001H\u0001H\u0003H\u03bd\bH\u0001"
          + "I\u0001I\u0005I\u03c1\bI\nI\fI\u03c4\tI\u0001J\u0001J\u0001J\u0001J\u0001"
          + "J\u0001J\u0001J\u0001J\u0003J\u03ce\bJ\u0001J\u0001J\u0003J\u03d2\bJ\u0001"
          + "J\u0001J\u0003J\u03d6\bJ\u0001K\u0001K\u0003K\u03da\bK\u0001K\u0001K\u0003"
          + "K\u03de\bK\u0001K\u0001K\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001"
          + "L\u0001L\u0001L\u0001L\u0001L\u0003L\u03ed\bL\u0001M\u0001M\u0001M\u0001"
          + "M\u0001N\u0001N\u0001N\u0001N\u0001O\u0001O\u0001P\u0001P\u0001P\u0001"
          + "P\u0003P\u03fd\bP\u0001Q\u0001Q\u0001Q\u0003Q\u0402\bQ\u0001R\u0001R\u0001"
          + "R\u0001R\u0001R\u0003R\u0409\bR\u0001S\u0001S\u0001S\u0001S\u0001S\u0001"
          + "T\u0001T\u0001T\u0001T\u0001T\u0003T\u0415\bT\u0001T\u0001T\u0001T\u0001"
          + "T\u0003T\u041b\bT\u0001T\u0001T\u0001T\u0001T\u0001T\u0003T\u0422\bT\u0003"
          + "T\u0424\bT\u0003T\u0426\bT\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001"
          + "T\u0003T\u042f\bT\u0001T\u0001T\u0001T\u0001T\u0001T\u0003T\u0436\bT\u0001"
          + "T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0003T\u043f\bT\u0001T\u0001"
          + "T\u0003T\u0443\bT\u0001T\u0001T\u0003T\u0447\bT\u0001U\u0001U\u0001U\u0001"
          + "U\u0001U\u0001U\u0001U\u0001U\u0001V\u0001V\u0001W\u0001W\u0001X\u0001"
          + "X\u0001X\u0005X\u0458\bX\nX\fX\u045b\tX\u0001Y\u0001Y\u0003Y\u045f\bY"
          + "\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0003Z\u0466\bZ\u0001Z\u0001Z\u0003"
          + "Z\u046a\bZ\u0003Z\u046c\bZ\u0001Z\u0001Z\u0001[\u0001[\u0001[\u0001[\u0001"
          + "[\u0001[\u0001\\\u0001\\\u0001\\\u0001\\\u0005\\\u047a\b\\\n\\\f\\\u047d"
          + "\t\\\u0001\\\u0003\\\u0480\b\\\u0001\\\u0001\\\u0001]\u0001]\u0001^\u0001"
          + "^\u0001_\u0001_\u0001`\u0001`\u0001a\u0001a\u0001a\u0003a\u048f\ba\u0001"
          + "a\u0001a\u0001b\u0001b\u0003b\u0495\bb\u0001c\u0001c\u0001c\u0001c\u0003"
          + "c\u049b\bc\u0001d\u0001d\u0001d\u0000\u0003\u0016\u0018^e\u0000\u0002"
          + "\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"
          + " \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"
          + "\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"
          + "\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"
          + "\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u0000\f\u0002\u0000"
          + "002L\u0001\u0000mn\u0002\u0000\u0004\u0004\f\f\u0001\u00005@\u0001\u0000"
          + "BG\u0002\u0000MQVV\u0002\u0000``bb\u0002\u0000RRbb\u0002\u0000WW`a\u0003"
          + "\u0000\u0010\u0010//eg\u0001\u0000KL\u0006\u0000\u0005\u0005\t\n\u001b"
          + "\u001c$$\')++\u04ef\u0000\u00d0\u0001\u0000\u0000\u0000\u0002\u00d2\u0001"
          + "\u0000\u0000\u0000\u0004\u00d7\u0001\u0000\u0000\u0000\u0006\u00db\u0001"
          + "\u0000\u0000\u0000\b\u00de\u0001\u0000\u0000\u0000\n\u00e6\u0001\u0000"
          + "\u0000\u0000\f\u00f5\u0001\u0000\u0000\u0000\u000e\u0103\u0001\u0000\u0000"
          + "\u0000\u0010\u0117\u0001\u0000\u0000\u0000\u0012\u011a\u0001\u0000\u0000"
          + "\u0000\u0014\u0121\u0001\u0000\u0000\u0000\u0016\u0123\u0001\u0000\u0000"
          + "\u0000\u0018\u012e\u0001\u0000\u0000\u0000\u001a\u013c\u0001\u0000\u0000"
          + "\u0000\u001c\u014d\u0001\u0000\u0000\u0000\u001e\u0152\u0001\u0000\u0000"
          + "\u0000 \u0155\u0001\u0000\u0000\u0000\"\u0162\u0001\u0000\u0000\u0000"
          + "$\u017f\u0001\u0000\u0000\u0000&\u0196\u0001\u0000\u0000\u0000(\u019a"
          + "\u0001\u0000\u0000\u0000*\u01a1\u0001\u0000\u0000\u0000,\u01ab\u0001\u0000"
          + "\u0000\u0000.\u01c8\u0001\u0000\u0000\u00000\u01d5\u0001\u0000\u0000\u0000"
          + "2\u01dd\u0001\u0000\u0000\u00004\u01e2\u0001\u0000\u0000\u00006\u01ea"
          + "\u0001\u0000\u0000\u00008\u01ee\u0001\u0000\u0000\u0000:\u01f0\u0001\u0000"
          + "\u0000\u0000<\u01f8\u0001\u0000\u0000\u0000>\u0202\u0001\u0000\u0000\u0000"
          + "@\u0205\u0001\u0000\u0000\u0000B\u020d\u0001\u0000\u0000\u0000D\u0216"
          + "\u0001\u0000\u0000\u0000F\u0220\u0001\u0000\u0000\u0000H\u0229\u0001\u0000"
          + "\u0000\u0000J\u022e\u0001\u0000\u0000\u0000L\u0230\u0001\u0000\u0000\u0000"
          + "N\u0232\u0001\u0000\u0000\u0000P\u0251\u0001\u0000\u0000\u0000R\u0255"
          + "\u0001\u0000\u0000\u0000T\u027a\u0001\u0000\u0000\u0000V\u027d\u0001\u0000"
          + "\u0000\u0000X\u02a4\u0001\u0000\u0000\u0000Z\u02a7\u0001\u0000\u0000\u0000"
          + "\\\u02b2\u0001\u0000\u0000\u0000^\u02b8\u0001\u0000\u0000\u0000`\u02cb"
          + "\u0001\u0000\u0000\u0000b\u02d4\u0001\u0000\u0000\u0000d\u02e8\u0001\u0000"
          + "\u0000\u0000f\u02ea\u0001\u0000\u0000\u0000h\u0312\u0001\u0000\u0000\u0000"
          + "j\u031c\u0001\u0000\u0000\u0000l\u031e\u0001\u0000\u0000\u0000n\u0321"
          + "\u0001\u0000\u0000\u0000p\u0331\u0001\u0000\u0000\u0000r\u0333\u0001\u0000"
          + "\u0000\u0000t\u033b\u0001\u0000\u0000\u0000v\u0343\u0001\u0000\u0000\u0000"
          + "x\u0347\u0001\u0000\u0000\u0000z\u034e\u0001\u0000\u0000\u0000|\u0379"
          + "\u0001\u0000\u0000\u0000~\u037b\u0001\u0000\u0000\u0000\u0080\u037f\u0001"
          + "\u0000\u0000\u0000\u0082\u0381\u0001\u0000\u0000\u0000\u0084\u0385\u0001"
          + "\u0000\u0000\u0000\u0086\u03a1\u0001\u0000\u0000\u0000\u0088\u03a3\u0001"
          + "\u0000\u0000\u0000\u008a\u03a5\u0001\u0000\u0000\u0000\u008c\u03ad\u0001"
          + "\u0000\u0000\u0000\u008e\u03b7\u0001\u0000\u0000\u0000\u0090\u03bc\u0001"
          + "\u0000\u0000\u0000\u0092\u03be\u0001\u0000\u0000\u0000\u0094\u03d5\u0001"
          + "\u0000\u0000\u0000\u0096\u03d7\u0001\u0000\u0000\u0000\u0098\u03ec\u0001"
          + "\u0000\u0000\u0000\u009a\u03ee\u0001\u0000\u0000\u0000\u009c\u03f2\u0001"
          + "\u0000\u0000\u0000\u009e\u03f6\u0001\u0000\u0000\u0000\u00a0\u03fc\u0001"
          + "\u0000\u0000\u0000\u00a2\u0401\u0001\u0000\u0000\u0000\u00a4\u0408\u0001"
          + "\u0000\u0000\u0000\u00a6\u040a\u0001\u0000\u0000\u0000\u00a8\u0446\u0001"
          + "\u0000\u0000\u0000\u00aa\u0448\u0001\u0000\u0000\u0000\u00ac\u0450\u0001"
          + "\u0000\u0000\u0000\u00ae\u0452\u0001\u0000\u0000\u0000\u00b0\u0454\u0001"
          + "\u0000\u0000\u0000\u00b2\u045c\u0001\u0000\u0000\u0000\u00b4\u0460\u0001"
          + "\u0000\u0000\u0000\u00b6\u046f\u0001\u0000\u0000\u0000\u00b8\u0475\u0001"
          + "\u0000\u0000\u0000\u00ba\u0483\u0001\u0000\u0000\u0000\u00bc\u0485\u0001"
          + "\u0000\u0000\u0000\u00be\u0487\u0001\u0000\u0000\u0000\u00c0\u0489\u0001"
          + "\u0000\u0000\u0000\u00c2\u048e\u0001\u0000\u0000\u0000\u00c4\u0494\u0001"
          + "\u0000\u0000\u0000\u00c6\u049a\u0001\u0000\u0000\u0000\u00c8\u049c\u0001"
          + "\u0000\u0000\u0000\u00ca\u00d1\u0005m\u0000\u0000\u00cb\u00d1\u0005o\u0000"
          + "\u0000\u00cc\u00d1\u0005n\u0000\u0000\u00cd\u00d1\u0005\u001f\u0000\u0000"
          + "\u00ce\u00d1\u0005\u0002\u0000\u0000\u00cf\u00d1\u0003\u0002\u0001\u0000"
          + "\u00d0\u00ca\u0001\u0000\u0000\u0000\u00d0\u00cb\u0001\u0000\u0000\u0000"
          + "\u00d0\u00cc\u0001\u0000\u0000\u0000\u00d0\u00cd\u0001\u0000\u0000\u0000"
          + "\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000"
          + "\u00d1\u0001\u0001\u0000\u0000\u0000\u00d2\u00d3\u0007\u0000\u0000\u0000"
          + "\u00d3\u0003\u0001\u0000\u0000\u0000\u00d4\u00d8\u0003\u0002\u0001\u0000"
          + "\u00d5\u00d8\u0005\u0002\u0000\u0000\u00d6\u00d8\u0005\u001f\u0000\u0000"
          + "\u00d7\u00d4\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000"
          + "\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d8\u0005\u0001\u0000\u0000\u0000"
          + "\u00d9\u00dc\u0005m\u0000\u0000\u00da\u00dc\u0003\u0002\u0001\u0000\u00db"
          + "\u00d9\u0001\u0000\u0000\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc"
          + "\u0007\u0001\u0000\u0000\u0000\u00dd\u00df\u0005k\u0000\u0000\u00de\u00dd"
          + "\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00e0"
          + "\u0001\u0000\u0000\u0000\u00e0\u00e1\u0003\u0010\b\u0000\u00e1\u00e2\u0005"
          + "\u0000\u0000\u0001\u00e2\t\u0001\u0000\u0000\u0000\u00e3\u00e5\u0003J"
          + "%\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e8\u0001\u0000\u0000"
          + "\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000"
          + "\u0000\u00e7\u00e9\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000"
          + "\u0000\u00e9\u00ea\u0005\u001d\u0000\u0000\u00ea\u00ec\u0003\u00ba]\u0000"
          + "\u00eb\u00ed\u0003\f\u0006\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ec"
          + "\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ef\u0001\u0000\u0000\u0000\u00ee"
          + "\u00f0\u0003\u000e\u0007\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00ef"
          + "\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1"
          + "\u00f2\u0005\\\u0000\u0000\u00f2\u00f3\u0003\u0010\b\u0000\u00f3\u00f4"
          + "\u0005]\u0000\u0000\u00f4\u000b\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005"
          + "M\u0000\u0000\u00f6\u00f7\u0003b1\u0000\u00f7\u00fe\u0003\u00c8d\u0000"
          + "\u00f8\u00f9\u0005T\u0000\u0000\u00f9\u00fa\u0003b1\u0000\u00fa\u00fb"
          + "\u0003\u00c8d\u0000\u00fb\u00fd\u0001\u0000\u0000\u0000\u00fc\u00f8\u0001"
          + "\u0000\u0000\u0000\u00fd\u0100\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001"
          + "\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0101\u0001"
          + "\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0101\u0102\u0005"
          + "P\u0000\u0000\u0102\r\u0001\u0000\u0000\u0000\u0103\u0104\u00052\u0000"
          + "\u0000\u0104\u0109\u0003`0\u0000\u0105\u0106\u0005T\u0000\u0000\u0106"
          + "\u0108\u0003`0\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u010b\u0001"
          + "\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001"
          + "\u0000\u0000\u0000\u010a\u000f\u0001\u0000\u0000\u0000\u010b\u0109\u0001"
          + "\u0000\u0000\u0000\u010c\u0116\u0003\u0012\t\u0000\u010d\u0116\u0003F"
          + "#\u0000\u010e\u0116\u0003\u001e\u000f\u0000\u010f\u0116\u0003@ \u0000"
          + "\u0110\u0116\u0003D\"\u0000\u0111\u0116\u0003V+\u0000\u0112\u0116\u0003"
          + "\n\u0005\u0000\u0113\u0116\u0003h4\u0000\u0114\u0116\u0003.\u0017\u0000"
          + "\u0115\u010c\u0001\u0000\u0000\u0000\u0115\u010d\u0001\u0000\u0000\u0000"
          + "\u0115\u010e\u0001\u0000\u0000\u0000\u0115\u010f\u0001\u0000\u0000\u0000"
          + "\u0115\u0110\u0001\u0000\u0000\u0000\u0115\u0111\u0001\u0000\u0000\u0000"
          + "\u0115\u0112\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000"
          + "\u0115\u0114\u0001\u0000\u0000\u0000\u0116\u0119\u0001\u0000\u0000\u0000"
          + "\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000"
          + "\u0118\u0011\u0001\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000"
          + "\u011a\u011b\u0003H$\u0000\u011b\u011c\u0005\u0017\u0000\u0000\u011c\u011f"
          + "\u0003\u0018\f\u0000\u011d\u011e\u0005\u0003\u0000\u0000\u011e\u0120\u0003"
          + "\u00ba]\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000"
          + "\u0000\u0000\u0120\u0013\u0001\u0000\u0000\u0000\u0121\u0122\u0007\u0001"
          + "\u0000\u0000\u0122\u0015\u0001\u0000\u0000\u0000\u0123\u0124\u0006\u000b"
          + "\uffff\uffff\u0000\u0124\u0125\u0003\u0014\n\u0000\u0125\u012b\u0001\u0000"
          + "\u0000\u0000\u0126\u0127\n\u0001\u0000\u0000\u0127\u0128\u0005X\u0000"
          + "\u0000\u0128\u012a\u0003\u0014\n\u0000\u0129\u0126\u0001\u0000\u0000\u0000"
          + "\u012a\u012d\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000"
          + "\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u0017\u0001\u0000\u0000\u0000"
          + "\u012d\u012b\u0001\u0000\u0000\u0000\u012e\u012f\u0006\f\uffff\uffff\u0000"
          + "\u012f\u0130\u0003\u0016\u000b\u0000\u0130\u0139\u0001\u0000\u0000\u0000"
          + "\u0131\u0132\n\u0001\u0000\u0000\u0132\u0133\u0005d\u0000\u0000\u0133"
          + "\u0135\u0003\u00ba]\u0000\u0134\u0136\u0003\u001a\r\u0000\u0135\u0134"
          + "\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0138"
          + "\u0001\u0000\u0000\u0000\u0137\u0131\u0001\u0000\u0000\u0000\u0138\u013b"
          + "\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000\u0139\u013a"
          + "\u0001\u0000\u0000\u0000\u013a\u0019\u0001\u0000\u0000\u0000\u013b\u0139"
          + "\u0001\u0000\u0000\u0000\u013c\u013d\u0005M\u0000\u0000\u013d\u0142\u0003"
          + "\u001c\u000e\u0000\u013e\u013f\u0005T\u0000\u0000\u013f\u0141\u0003\u001c"
          + "\u000e\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0141\u0144\u0001\u0000"
          + "\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000"
          + "\u0000\u0000\u0143\u0145\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000"
          + "\u0000\u0000\u0145\u0146\u0005P\u0000\u0000\u0146\u001b\u0001\u0000\u0000"
          + "\u0000\u0147\u014e\u0003^/\u0000\u0148\u014e\u0003d2\u0000\u0149\u014a"
          + "\u0003\u00c2a\u0000\u014a\u014b\u0005W\u0000\u0000\u014b\u014c\u0005e"
          + "\u0000\u0000\u014c\u014e\u0001\u0000\u0000\u0000\u014d\u0147\u0001\u0000"
          + "\u0000\u0000\u014d\u0148\u0001\u0000\u0000\u0000\u014d\u0149\u0001\u0000"
          + "\u0000\u0000\u014e\u001d\u0001\u0000\u0000\u0000\u014f\u0153\u0003 \u0010"
          + "\u0000\u0150\u0153\u0003\"\u0011\u0000\u0151\u0153\u0003$\u0012\u0000"
          + "\u0152\u014f\u0001\u0000\u0000\u0000\u0152\u0150\u0001\u0000\u0000\u0000"
          + "\u0152\u0151\u0001\u0000\u0000\u0000\u0153\u001f\u0001\u0000\u0000\u0000"
          + "\u0154\u0156\u0005k\u0000\u0000\u0155\u0154\u0001\u0000\u0000\u0000\u0155"
          + "\u0156\u0001\u0000\u0000\u0000\u0156\u015a\u0001\u0000\u0000\u0000\u0157"
          + "\u0159\u0003J%\u0000\u0158\u0157\u0001\u0000\u0000\u0000\u0159\u015c\u0001"
          + "\u0000\u0000\u0000\u015a\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001"
          + "\u0000\u0000\u0000\u015b\u015d\u0001\u0000\u0000\u0000\u015c\u015a\u0001"
          + "\u0000\u0000\u0000\u015d\u015e\u00053\u0000\u0000\u015e\u015f\u0003R)"
          + "\u0000\u015f\u0160\u0005U\u0000\u0000\u0160!\u0001\u0000\u0000\u0000\u0161"
          + "\u0163\u0005k\u0000\u0000\u0162\u0161\u0001\u0000\u0000\u0000\u0162\u0163"
          + "\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0165"
          + "\u0003H$\u0000\u0165\u0166\u00053\u0000\u0000\u0166\u0167\u0005\b\u0000"
          + "\u0000\u0167\u0171\u0003\u00be_\u0000\u0168\u0169\u0005\u000f\u0000\u0000"
          + "\u0169\u016e\u0003d2\u0000\u016a\u016b\u0005T\u0000\u0000\u016b\u016d"
          + "\u0003d2\u0000\u016c\u016a\u0001\u0000\u0000\u0000\u016d\u0170\u0001\u0000"
          + "\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000"
          + "\u0000\u0000\u016f\u0172\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000"
          + "\u0000\u0000\u0171\u0168\u0001\u0000\u0000\u0000\u0171\u0172\u0001\u0000"
          + "\u0000\u0000\u0172\u017c\u0001\u0000\u0000\u0000\u0173\u017d\u0005U\u0000"
          + "\u0000\u0174\u0178\u0005\\\u0000\u0000\u0175\u0177\u0003(\u0014\u0000"
          + "\u0176\u0175\u0001\u0000\u0000\u0000\u0177\u017a\u0001\u0000\u0000\u0000"
          + "\u0178\u0176\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000"
          + "\u0179\u017b\u0001\u0000\u0000\u0000\u017a\u0178\u0001\u0000\u0000\u0000"
          + "\u017b\u017d\u0005]\u0000\u0000\u017c\u0173\u0001\u0000\u0000\u0000\u017c"
          + "\u0174\u0001\u0000\u0000\u0000\u017d#\u0001\u0000\u0000\u0000\u017e\u0180"
          + "\u0005k\u0000\u0000\u017f\u017e\u0001\u0000\u0000\u0000\u017f\u0180\u0001"
          + "\u0000\u0000\u0000\u0180\u0184\u0001\u0000\u0000\u0000\u0181\u0183\u0003"
          + "J%\u0000\u0182\u0181\u0001\u0000\u0000\u0000\u0183\u0186\u0001\u0000\u0000"
          + "\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0184\u0185\u0001\u0000\u0000"
          + "\u0000\u0185\u0187\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000\u0000"
          + "\u0000\u0187\u0188\u00053\u0000\u0000\u0188\u0189\u0005\u001d\u0000\u0000"
          + "\u0189\u018b\u0003\u00bc^\u0000\u018a\u018c\u0003\f\u0006\u0000\u018b"
          + "\u018a\u0001\u0000\u0000\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c"
          + "\u018d\u0001\u0000\u0000\u0000\u018d\u018e\u0005\\\u0000\u0000\u018e\u018f"
          + "\u0003&\u0013\u0000\u018f\u0190\u0005]\u0000\u0000\u0190%\u0001\u0000"
          + "\u0000\u0000\u0191\u0195\u0003(\u0014\u0000\u0192\u0195\u0003*\u0015\u0000"
          + "\u0193\u0195\u0003,\u0016\u0000\u0194\u0191\u0001\u0000\u0000\u0000\u0194"
          + "\u0192\u0001\u0000\u0000\u0000\u0194\u0193\u0001\u0000\u0000\u0000\u0195"
          + "\u0198\u0001\u0000\u0000\u0000\u0196\u0194\u0001\u0000\u0000\u0000\u0196"
          + "\u0197\u0001\u0000\u0000\u0000\u0197\'\u0001\u0000\u0000\u0000\u0198\u0196"
          + "\u0001\u0000\u0000\u0000\u0199\u019b\u0005k\u0000\u0000\u019a\u0199\u0001"
          + "\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000\u0000\u019b\u019c\u0001"
          + "\u0000\u0000\u0000\u019c\u019d\u0003H$\u0000\u019d\u019e\u0003R)\u0000"
          + "\u019e\u019f\u0005U\u0000\u0000\u019f)\u0001\u0000\u0000\u0000\u01a0\u01a2"
          + "\u0005k\u0000\u0000\u01a1\u01a0\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001"
          + "\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a4\u0003"
          + "H$\u0000\u01a4\u01a5\u00054\u0000\u0000\u01a5\u01a6\u0003R)\u0000\u01a6"
          + "\u01a7\u0005\\\u0000\u0000\u01a7\u01a8\u0003n7\u0000\u01a8\u01a9\u0005"
          + "]\u0000\u0000\u01a9+\u0001\u0000\u0000\u0000\u01aa\u01ac\u0005k\u0000"
          + "\u0000\u01ab\u01aa\u0001\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000"
          + "\u0000\u01ac\u01ad\u0001\u0000\u0000\u0000\u01ad\u01ae\u0003H$\u0000\u01ae"
          + "\u01af\u0005\b\u0000\u0000\u01af\u01b9\u0003\u00be_\u0000\u01b0\u01b1"
          + "\u0005\u000f\u0000\u0000\u01b1\u01b6\u0003d2\u0000\u01b2\u01b3\u0005T"
          + "\u0000\u0000\u01b3\u01b5\u0003d2\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000"
          + "\u01b5\u01b8\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000\u0000"
          + "\u01b6\u01b7\u0001\u0000\u0000\u0000\u01b7\u01ba\u0001\u0000\u0000\u0000"
          + "\u01b8\u01b6\u0001\u0000\u0000\u0000\u01b9\u01b0\u0001\u0000\u0000\u0000"
          + "\u01b9\u01ba\u0001\u0000\u0000\u0000\u01ba\u01c4\u0001\u0000\u0000\u0000"
          + "\u01bb\u01c5\u0005U\u0000\u0000\u01bc\u01c0\u0005\\\u0000\u0000\u01bd"
          + "\u01bf\u0003(\u0014\u0000\u01be\u01bd\u0001\u0000\u0000\u0000\u01bf\u01c2"
          + "\u0001\u0000\u0000\u0000\u01c0\u01be\u0001\u0000\u0000\u0000\u01c0\u01c1"
          + "\u0001\u0000\u0000\u0000\u01c1\u01c3\u0001\u0000\u0000\u0000\u01c2\u01c0"
          + "\u0001\u0000\u0000\u0000\u01c3\u01c5\u0005]\u0000\u0000\u01c4\u01bb\u0001"
          + "\u0000\u0000\u0000\u01c4\u01bc\u0001\u0000\u0000\u0000\u01c5-\u0001\u0000"
          + "\u0000\u0000\u01c6\u01c7\u0005\u0014\u0000\u0000\u01c7\u01c9\u0003j5\u0000"
          + "\u01c8\u01c6\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000"
          + "\u01c9\u01cc\u0001\u0000\u0000\u0000\u01ca\u01cb\u00051\u0000\u0000\u01cb"
          + "\u01cd\u0003n7\u0000\u01cc\u01ca\u0001\u0000\u0000\u0000\u01cc\u01cd\u0001"
          + "\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ce\u01cf\u0005"
          + "&\u0000\u0000\u01cf\u01d3\u00030\u0018\u0000\u01d0\u01d1\u0005\"\u0000"
          + "\u0000\u01d1\u01d2\u0005\u0007\u0000\u0000\u01d2\u01d4\u00034\u001a\u0000"
          + "\u01d3\u01d0\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000"
          + "\u01d4/\u0001\u0000\u0000\u0000\u01d5\u01da\u00032\u0019\u0000\u01d6\u01d7"
          + "\u0005T\u0000\u0000\u01d7\u01d9\u00032\u0019\u0000\u01d8\u01d6\u0001\u0000"
          + "\u0000\u0000\u01d9\u01dc\u0001\u0000\u0000\u0000\u01da\u01d8\u0001\u0000"
          + "\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db1\u0001\u0000\u0000"
          + "\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dd\u01e0\u0003\u008aE\u0000"
          + "\u01de\u01df\u0005\u0003\u0000\u0000\u01df\u01e1\u0005m\u0000\u0000\u01e0"
          + "\u01de\u0001\u0000\u0000\u0000\u01e0\u01e1\u0001\u0000\u0000\u0000\u01e1"
          + "3\u0001\u0000\u0000\u0000\u01e2\u01e7\u00036\u001b\u0000\u01e3\u01e4\u0005"
          + "T\u0000\u0000\u01e4\u01e6\u00036\u001b\u0000\u01e5\u01e3\u0001\u0000\u0000"
          + "\u0000\u01e6\u01e9\u0001\u0000\u0000\u0000\u01e7\u01e5\u0001\u0000\u0000"
          + "\u0000\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e85\u0001\u0000\u0000\u0000"
          + "\u01e9\u01e7\u0001\u0000\u0000\u0000\u01ea\u01ec\u0005m\u0000\u0000\u01eb"
          + "\u01ed\u0007\u0002\u0000\u0000\u01ec\u01eb\u0001\u0000\u0000\u0000\u01ec"
          + "\u01ed\u0001\u0000\u0000\u0000\u01ed7\u0001\u0000\u0000\u0000\u01ee\u01ef"
          + "\u0005n\u0000\u0000\u01ef9\u0001\u0000\u0000\u0000\u01f0\u01f5\u0003<"
          + "\u001e\u0000\u01f1\u01f2\u0005!\u0000\u0000\u01f2\u01f4\u0003<\u001e\u0000"
          + "\u01f3\u01f1\u0001\u0000\u0000\u0000\u01f4\u01f7\u0001\u0000\u0000\u0000"
          + "\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000"
          + "\u01f6;\u0001\u0000\u0000\u0000\u01f7\u01f5\u0001\u0000\u0000\u0000\u01f8"
          + "\u01f9\u0003>\u001f\u0000\u01f9\u01fa\u0005Z\u0000\u0000\u01fa\u01fb\u0003"
          + "j5\u0000\u01fb\u0200\u0005[\u0000\u0000\u01fc\u01fd\u0005\\\u0000\u0000"
          + "\u01fd\u01fe\u0003n7\u0000\u01fe\u01ff\u0005]\u0000\u0000\u01ff\u0201"
          + "\u0001\u0000\u0000\u0000\u0200\u01fc\u0001\u0000\u0000\u0000\u0200\u0201"
          + "\u0001\u0000\u0000\u0000\u0201=\u0001\u0000\u0000\u0000\u0202\u0203\u0005"
          + "n\u0000\u0000\u0203?\u0001\u0000\u0000\u0000\u0204\u0206\u0005k\u0000"
          + "\u0000\u0205\u0204\u0001\u0000\u0000\u0000\u0205\u0206\u0001\u0000\u0000"
          + "\u0000\u0206\u0207\u0001\u0000\u0000\u0000\u0207\u0208\u0003H$\u0000\u0208"
          + "\u0209\u0005\u001e\u0000\u0000\u0209\u020a\u00038\u001c\u0000\u020a\u020b"
          + "\u0005O\u0000\u0000\u020b\u020c\u0003:\u001d\u0000\u020cA\u0001\u0000"
          + "\u0000\u0000\u020d\u0212\u0003d2\u0000\u020e\u020f\u0005!\u0000\u0000"
          + "\u020f\u0211\u0003d2\u0000\u0210\u020e\u0001\u0000\u0000\u0000\u0211\u0214"
          + "\u0001\u0000\u0000\u0000\u0212\u0210\u0001\u0000\u0000\u0000\u0212\u0213"
          + "\u0001\u0000\u0000\u0000\u0213C\u0001\u0000\u0000\u0000\u0214\u0212\u0001"
          + "\u0000\u0000\u0000\u0215\u0217\u0005k\u0000\u0000\u0216\u0215\u0001\u0000"
          + "\u0000\u0000\u0216\u0217\u0001\u0000\u0000\u0000\u0217\u0218\u0001\u0000"
          + "\u0000\u0000\u0218\u0219\u0003H$\u0000\u0219\u021a\u0005\b\u0000\u0000"
          + "\u021a\u021b\u0005n\u0000\u0000\u021b\u021c\u0005O\u0000\u0000\u021c\u021d"
          + "\u0003B!\u0000\u021d\u021e\u0005U\u0000\u0000\u021eE\u0001\u0000\u0000"
          + "\u0000\u021f\u0221\u0005k\u0000\u0000\u0220\u021f\u0001\u0000\u0000\u0000"
          + "\u0220\u0221\u0001\u0000\u0000\u0000\u0221\u0222\u0001\u0000\u0000\u0000"
          + "\u0222\u0223\u0003H$\u0000\u0223\u0224\u0003R)\u0000\u0224\u0225\u0003"
          + "T*\u0000\u0225G\u0001\u0000\u0000\u0000\u0226\u0228\u0003J%\u0000\u0227"
          + "\u0226\u0001\u0000\u0000\u0000\u0228\u022b\u0001\u0000\u0000\u0000\u0229"
          + "\u0227\u0001\u0000\u0000\u0000\u0229\u022a\u0001\u0000\u0000\u0000\u022a"
          + "I\u0001\u0000\u0000\u0000\u022b\u0229\u0001\u0000\u0000\u0000\u022c\u022f"
          + "\u0003L&\u0000\u022d\u022f\u0003P(\u0000\u022e\u022c\u0001\u0000\u0000"
          + "\u0000\u022e\u022d\u0001\u0000\u0000\u0000\u022fK\u0001\u0000\u0000\u0000"
          + "\u0230\u0231\u0007\u0003\u0000\u0000\u0231M\u0001\u0000\u0000\u0000\u0232"
          + "\u0233\u0007\u0004\u0000\u0000\u0233O\u0001\u0000\u0000\u0000\u0234\u0235"
          + "\u0005A\u0000\u0000\u0235\u0236\u0005^\u0000\u0000\u0236\u023b\u0003N"
          + "\'\u0000\u0237\u0238\u0005T\u0000\u0000\u0238\u023a\u0003N\'\u0000\u0239"
          + "\u0237\u0001\u0000\u0000\u0000\u023a\u023d\u0001\u0000\u0000\u0000\u023b"
          + "\u0239\u0001\u0000\u0000\u0000\u023b\u023c\u0001\u0000\u0000\u0000\u023c"
          + "\u023e\u0001\u0000\u0000\u0000\u023d\u023b\u0001\u0000\u0000\u0000\u023e"
          + "\u023f\u0005_\u0000\u0000\u023f\u0252\u0001\u0000\u0000\u0000\u0240\u0241"
          + "\u0005H\u0000\u0000\u0241\u0242\u0005^\u0000\u0000\u0242\u0243\u0005I"
          + "\u0000\u0000\u0243\u0252\u0005_\u0000\u0000\u0244\u0245\u0005J\u0000\u0000"
          + "\u0245\u024e\u0005^\u0000\u0000\u0246\u024b\u0003\u00a2Q\u0000\u0247\u0248"
          + "\u0005T\u0000\u0000\u0248\u024a\u0003\u00a2Q\u0000\u0249\u0247\u0001\u0000"
          + "\u0000\u0000\u024a\u024d\u0001\u0000\u0000\u0000\u024b\u0249\u0001\u0000"
          + "\u0000\u0000\u024b\u024c\u0001\u0000\u0000\u0000\u024c\u024f\u0001\u0000"
          + "\u0000\u0000\u024d\u024b\u0001\u0000\u0000\u0000\u024e\u0246\u0001\u0000"
          + "\u0000\u0000\u024e\u024f\u0001\u0000\u0000\u0000\u024f\u0250\u0001\u0000"
          + "\u0000\u0000\u0250\u0252\u0005_\u0000\u0000\u0251\u0234\u0001\u0000\u0000"
          + "\u0000\u0251\u0240\u0001\u0000\u0000\u0000\u0251\u0244\u0001\u0000\u0000"
          + "\u0000\u0252Q\u0001\u0000\u0000\u0000\u0253\u0256\u0005#\u0000\u0000\u0254"
          + "\u0256\u0003d2\u0000\u0255\u0253\u0001\u0000\u0000\u0000\u0255\u0254\u0001"
          + "\u0000\u0000\u0000\u0256\u0257\u0001\u0000\u0000\u0000\u0257\u0258\u0003"
          + "\u00c4b\u0000\u0258\u0259\u0005Z\u0000\u0000\u0259\u025a\u0003j5\u0000"
          + "\u025a\u025b\u0005[\u0000\u0000\u025bS\u0001\u0000\u0000\u0000\u025c\u027b"
          + "\u0005U\u0000\u0000\u025d\u025e\u0005\\\u0000\u0000\u025e\u025f\u0003"
          + "n7\u0000\u025f\u0260\u0005]\u0000\u0000\u0260\u027b\u0001\u0000\u0000"
          + "\u0000\u0261\u0262\u0005O\u0000\u0000\u0262\u0263\u0003\u0000\u0000\u0000"
          + "\u0263\u0271\u0005Z\u0000\u0000\u0264\u0265\u0003\u00c2a\u0000\u0265\u0266"
          + "\u0005W\u0000\u0000\u0266\u026e\u0005e\u0000\u0000\u0267\u0268\u0005T"
          + "\u0000\u0000\u0268\u0269\u0003\u00c2a\u0000\u0269\u026a\u0005W\u0000\u0000"
          + "\u026a\u026b\u0005e\u0000\u0000\u026b\u026d\u0001\u0000\u0000\u0000\u026c"
          + "\u0267\u0001\u0000\u0000\u0000\u026d\u0270\u0001\u0000\u0000\u0000\u026e"
          + "\u026c\u0001\u0000\u0000\u0000\u026e\u026f\u0001\u0000\u0000\u0000\u026f"
          + "\u0272\u0001\u0000\u0000\u0000\u0270\u026e\u0001\u0000\u0000\u0000\u0271"
          + "\u0264\u0001\u0000\u0000\u0000\u0271\u0272\u0001\u0000\u0000\u0000\u0272"
          + "\u0273\u0001\u0000\u0000\u0000\u0273\u0274\u0005[\u0000\u0000\u0274\u0276"
          + "\u0005Z\u0000\u0000\u0275\u0277\u0003f3\u0000\u0276\u0275\u0001\u0000"
          + "\u0000\u0000\u0276\u0277\u0001\u0000\u0000\u0000\u0277\u0278\u0001\u0000"
          + "\u0000\u0000\u0278\u0279\u0005[\u0000\u0000\u0279\u027b\u0001\u0000\u0000"
          + "\u0000\u027a\u025c\u0001\u0000\u0000\u0000\u027a\u025d\u0001\u0000\u0000"
          + "\u0000\u027a\u0261\u0001\u0000\u0000\u0000\u027bU\u0001\u0000\u0000\u0000"
          + "\u027c\u027e\u0005k\u0000\u0000\u027d\u027c\u0001\u0000\u0000\u0000\u027d"
          + "\u027e\u0001\u0000\u0000\u0000\u027e\u027f\u0001\u0000\u0000\u0000\u027f"
          + "\u0280\u0003H$\u0000\u0280\u0281\u0005\b\u0000\u0000\u0281\u028b\u0003"
          + "\u00be_\u0000\u0282\u0283\u0005\u000f\u0000\u0000\u0283\u0288\u0003d2"
          + "\u0000\u0284\u0285\u0005T\u0000\u0000\u0285\u0287\u0003d2\u0000\u0286"
          + "\u0284\u0001\u0000\u0000\u0000\u0287\u028a\u0001\u0000\u0000\u0000\u0288"
          + "\u0286\u0001\u0000\u0000\u0000\u0288\u0289\u0001\u0000\u0000\u0000\u0289"
          + "\u028c\u0001\u0000\u0000\u0000\u028a\u0288\u0001\u0000\u0000\u0000\u028b"
          + "\u0282\u0001\u0000\u0000\u0000\u028b\u028c\u0001\u0000\u0000\u0000\u028c"
          + "\u0296\u0001\u0000\u0000\u0000\u028d\u028e\u0005\u0019\u0000\u0000\u028e"
          + "\u0293\u0003d2\u0000\u028f\u0290\u0005T\u0000\u0000\u0290\u0292\u0003"
          + "d2\u0000\u0291\u028f\u0001\u0000\u0000\u0000\u0292\u0295\u0001\u0000\u0000"
          + "\u0000\u0293\u0291\u0001\u0000\u0000\u0000\u0293\u0294\u0001\u0000\u0000"
          + "\u0000\u0294\u0297\u0001\u0000\u0000\u0000\u0295\u0293\u0001\u0000\u0000"
          + "\u0000\u0296\u028d\u0001\u0000\u0000\u0000\u0296\u0297\u0001\u0000\u0000"
          + "\u0000\u0297\u0298\u0001\u0000\u0000\u0000\u0298\u029c\u0005\\\u0000\u0000"
          + "\u0299\u029b\u0003X,\u0000\u029a\u0299\u0001\u0000\u0000\u0000\u029b\u029e"
          + "\u0001\u0000\u0000\u0000\u029c\u029a\u0001\u0000\u0000\u0000\u029c\u029d"
          + "\u0001\u0000\u0000\u0000\u029d\u029f\u0001\u0000\u0000\u0000\u029e\u029c"
          + "\u0001\u0000\u0000\u0000\u029f\u02a0\u0005]\u0000\u0000\u02a0W\u0001\u0000"
          + "\u0000\u0000\u02a1\u02a5\u0003Z-\u0000\u02a2\u02a5\u0003F#\u0000\u02a3"
          + "\u02a5\u0003\\.\u0000\u02a4\u02a1\u0001\u0000\u0000\u0000\u02a4\u02a2"
          + "\u0001\u0000\u0000\u0000\u02a4\u02a3\u0001\u0000\u0000\u0000\u02a5Y\u0001"
          + "\u0000\u0000\u0000\u02a6\u02a8\u0005k\u0000\u0000\u02a7\u02a6\u0001\u0000"
          + "\u0000\u0000\u02a7\u02a8\u0001\u0000\u0000\u0000\u02a8\u02a9\u0001\u0000"
          + "\u0000\u0000\u02a9\u02aa\u0003H$\u0000\u02aa\u02ab\u0003\u00be_\u0000"
          + "\u02ab\u02ac\u0005Z\u0000\u0000\u02ac\u02ad\u0005[\u0000\u0000\u02ad\u02ae"
          + "\u0005\\\u0000\u0000\u02ae\u02af\u0003n7\u0000\u02af\u02b0\u0005]\u0000"
          + "\u0000\u02b0[\u0001\u0000\u0000\u0000\u02b1\u02b3\u0005k\u0000\u0000\u02b2"
          + "\u02b1\u0001\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000\u0000\u0000\u02b3"
          + "\u02b4\u0001\u0000\u0000\u0000\u02b4\u02b5\u0003H$\u0000\u02b5\u02b6\u0003"
          + "l6\u0000\u02b6\u02b7\u0005U\u0000\u0000\u02b7]\u0001\u0000\u0000\u0000"
          + "\u02b8\u02b9\u0006/\uffff\uffff\u0000\u02b9\u02bb\u0003\u00ba]\u0000\u02ba"
          + "\u02bc\u0003\u001a\r\u0000\u02bb\u02ba\u0001\u0000\u0000\u0000\u02bb\u02bc"
          + "\u0001\u0000\u0000\u0000\u02bc\u02c5\u0001\u0000\u0000\u0000\u02bd\u02be"
          + "\n\u0001\u0000\u0000\u02be\u02bf\u0005d\u0000\u0000\u02bf\u02c1\u0003"
          + "\u00ba]\u0000\u02c0\u02c2\u0003\u001a\r\u0000\u02c1\u02c0\u0001\u0000"
          + "\u0000\u0000\u02c1\u02c2\u0001\u0000\u0000\u0000\u02c2\u02c4\u0001\u0000"
          + "\u0000\u0000\u02c3\u02bd\u0001\u0000\u0000\u0000\u02c4\u02c7\u0001\u0000"
          + "\u0000\u0000\u02c5\u02c3\u0001\u0000\u0000\u0000\u02c5\u02c6\u0001\u0000"
          + "\u0000\u0000\u02c6_\u0001\u0000\u0000\u0000\u02c7\u02c5\u0001\u0000\u0000"
          + "\u0000\u02c8\u02c9\u0003^/\u0000\u02c9\u02ca\u0005d\u0000\u0000\u02ca"
          + "\u02cc\u0001\u0000\u0000\u0000\u02cb\u02c8\u0001\u0000\u0000\u0000\u02cb"
          + "\u02cc\u0001\u0000\u0000\u0000\u02cc\u02cd\u0001\u0000\u0000\u0000\u02cd"
          + "\u02cf\u0003\u00bc^\u0000\u02ce\u02d0\u0003\u001a\r\u0000\u02cf\u02ce"
          + "\u0001\u0000\u0000\u0000\u02cf\u02d0\u0001\u0000\u0000\u0000\u02d0a\u0001"
          + "\u0000\u0000\u0000\u02d1\u02d2\u0003^/\u0000\u02d2\u02d3\u0005d\u0000"
          + "\u0000\u02d3\u02d5\u0001\u0000\u0000\u0000\u02d4\u02d1\u0001\u0000\u0000"
          + "\u0000\u02d4\u02d5\u0001\u0000\u0000\u0000\u02d5\u02d6\u0001\u0000\u0000"
          + "\u0000\u02d6\u02da\u0003\u0014\n\u0000\u02d7\u02d8\u0005W\u0000\u0000"
          + "\u02d8\u02db\u0005e\u0000\u0000\u02d9\u02db\u0003\u001a\r\u0000\u02da"
          + "\u02d7\u0001\u0000\u0000\u0000\u02da\u02d9\u0001\u0000\u0000\u0000\u02da"
          + "\u02db\u0001\u0000\u0000\u0000\u02dbc\u0001\u0000\u0000\u0000\u02dc\u02dd"
          + "\u0003^/\u0000\u02dd\u02de\u0005d\u0000\u0000\u02de\u02e0\u0001\u0000"
          + "\u0000\u0000\u02df\u02dc\u0001\u0000\u0000\u0000\u02df\u02e0\u0001\u0000"
          + "\u0000\u0000\u02e0\u02e1\u0001\u0000\u0000\u0000\u02e1\u02e9\u0003\u00be"
          + "_\u0000\u02e2\u02e9\u0003\u00c0`\u0000\u02e3\u02e9\u0005\u0006\u0000\u0000"
          + "\u02e4\u02e9\u0005\u000b\u0000\u0000\u02e5\u02e9\u0005\u0011\u0000\u0000"
          + "\u02e6\u02e9\u0005\u001a\u0000\u0000\u02e7\u02e9\u0005*\u0000\u0000\u02e8"
          + "\u02df\u0001\u0000\u0000\u0000\u02e8\u02e2\u0001\u0000\u0000\u0000\u02e8"
          + "\u02e3\u0001\u0000\u0000\u0000\u02e8\u02e4\u0001\u0000\u0000\u0000\u02e8"
          + "\u02e5\u0001\u0000\u0000\u0000\u02e8\u02e6\u0001\u0000\u0000\u0000\u02e8"
          + "\u02e7\u0001\u0000\u0000\u0000\u02e9e\u0001\u0000\u0000\u0000\u02ea\u02ef"
          + "\u0003\u008aE\u0000\u02eb\u02ec\u0005T\u0000\u0000\u02ec\u02ee\u0003\u008a"
          + "E\u0000\u02ed\u02eb\u0001\u0000\u0000\u0000\u02ee\u02f1\u0001\u0000\u0000"
          + "\u0000\u02ef\u02ed\u0001\u0000\u0000\u0000\u02ef\u02f0\u0001\u0000\u0000"
          + "\u0000\u02f0g\u0001\u0000\u0000\u0000\u02f1\u02ef\u0001\u0000\u0000\u0000"
          + "\u02f2\u02f4\u0005k\u0000\u0000\u02f3\u02f2\u0001\u0000\u0000\u0000\u02f3"
          + "\u02f4\u0001\u0000\u0000\u0000\u02f4\u02f5\u0001\u0000\u0000\u0000\u02f5"
          + "\u02f6\u0003H$\u0000\u02f6\u02f7\u0005#\u0000\u0000\u02f7\u02f8\u0003"
          + "\u00c4b\u0000\u02f8\u02f9\u0005O\u0000\u0000\u02f9\u02fa\u0003\u00c2a"
          + "\u0000\u02fa\u02fb\u0005W\u0000\u0000\u02fb\u02fc\u0005e\u0000\u0000\u02fc"
          + "\u02fd\u0005U\u0000\u0000\u02fd\u0313\u0001\u0000\u0000\u0000\u02fe\u0300"
          + "\u0005k\u0000\u0000\u02ff\u02fe\u0001\u0000\u0000\u0000\u02ff\u0300\u0001"
          + "\u0000\u0000\u0000\u0300\u0301\u0001\u0000\u0000\u0000\u0301\u0302\u0003"
          + "H$\u0000\u0302\u0303\u0005\b\u0000\u0000\u0303\u0304\u0003\u00be_\u0000"
          + "\u0304\u0305\u0005O\u0000\u0000\u0305\u0306\u0003d2\u0000\u0306\u0307"
          + "\u0005U\u0000\u0000\u0307\u0313\u0001\u0000\u0000\u0000\u0308\u030a\u0005"
          + "k\u0000\u0000\u0309\u0308\u0001\u0000\u0000\u0000\u0309\u030a\u0001\u0000"
          + "\u0000\u0000\u030a\u030b\u0001\u0000\u0000\u0000\u030b\u030c\u0003H$\u0000"
          + "\u030c\u030d\u0005\u001d\u0000\u0000\u030d\u030e\u0003\u00ba]\u0000\u030e"
          + "\u030f\u0005O\u0000\u0000\u030f\u0310\u0003^/\u0000\u0310\u0311\u0005"
          + "U\u0000\u0000\u0311\u0313\u0001\u0000\u0000\u0000\u0312\u02f3\u0001\u0000"
          + "\u0000\u0000\u0312\u02ff\u0001\u0000\u0000\u0000\u0312\u0309\u0001\u0000"
          + "\u0000\u0000\u0313i\u0001\u0000\u0000\u0000\u0314\u0319\u0003l6\u0000"
          + "\u0315\u0316\u0005T\u0000\u0000\u0316\u0318\u0003l6\u0000\u0317\u0315"
          + "\u0001\u0000\u0000\u0000\u0318\u031b\u0001\u0000\u0000\u0000\u0319\u0317"
          + "\u0001\u0000\u0000\u0000\u0319\u031a\u0001\u0000\u0000\u0000\u031a\u031d"
          + "\u0001\u0000\u0000\u0000\u031b\u0319\u0001\u0000\u0000\u0000\u031c\u0314"
          + "\u0001\u0000\u0000\u0000\u031c\u031d\u0001\u0000\u0000\u0000\u031dk\u0001"
          + "\u0000\u0000\u0000\u031e\u031f\u0003d2\u0000\u031f\u0320\u0003\u0006\u0003"
          + "\u0000\u0320m\u0001\u0000\u0000\u0000\u0321\u0326\u0003r9\u0000\u0322"
          + "\u0323\u0005!\u0000\u0000\u0323\u0325\u0003n7\u0000\u0324\u0322\u0001"
          + "\u0000\u0000\u0000\u0325\u0328\u0001\u0000\u0000\u0000\u0326\u0324\u0001"
          + "\u0000\u0000\u0000\u0326\u0327\u0001\u0000\u0000\u0000\u0327o\u0001\u0000"
          + "\u0000\u0000\u0328\u0326\u0001\u0000\u0000\u0000\u0329\u0332\u0003v;\u0000"
          + "\u032a\u0332\u0003x<\u0000\u032b\u0332\u0003z=\u0000\u032c\u0332\u0003"
          + "|>\u0000\u032d\u0332\u0003~?\u0000\u032e\u0332\u0003\u0082A\u0000\u032f"
          + "\u0332\u0003\u0084B\u0000\u0330\u0332\u0003\u0086C\u0000\u0331\u0329\u0001"
          + "\u0000\u0000\u0000\u0331\u032a\u0001\u0000\u0000\u0000\u0331\u032b\u0001"
          + "\u0000\u0000\u0000\u0331\u032c\u0001\u0000\u0000\u0000\u0331\u032d\u0001"
          + "\u0000\u0000\u0000\u0331\u032e\u0001\u0000\u0000\u0000\u0331\u032f\u0001"
          + "\u0000\u0000\u0000\u0331\u0330\u0001\u0000\u0000\u0000\u0332q\u0001\u0000"
          + "\u0000\u0000\u0333\u0338\u0003t:\u0000\u0334\u0335\u0005\u0001\u0000\u0000"
          + "\u0335\u0337\u0003n7\u0000\u0336\u0334\u0001\u0000\u0000\u0000\u0337\u033a"
          + "\u0001\u0000\u0000\u0000\u0338\u0336\u0001\u0000\u0000\u0000\u0338\u0339"
          + "\u0001\u0000\u0000\u0000\u0339s\u0001\u0000\u0000\u0000\u033a\u0338\u0001"
          + "\u0000\u0000\u0000\u033b\u0340\u0003p8\u0000\u033c\u033d\u0005\u0016\u0000"
          + "\u0000\u033d\u033f\u0003n7\u0000\u033e\u033c\u0001\u0000\u0000\u0000\u033f"
          + "\u0342\u0001\u0000\u0000\u0000\u0340\u033e\u0001\u0000\u0000\u0000\u0340"
          + "\u0341\u0001\u0000\u0000\u0000\u0341u\u0001\u0000\u0000\u0000\u0342\u0340"
          + "\u0001\u0000\u0000\u0000\u0343\u0344\u0005Z\u0000\u0000\u0344\u0345\u0003"
          + "n7\u0000\u0345\u0346\u0005[\u0000\u0000\u0346w\u0001\u0000\u0000\u0000"
          + "\u0347\u0348\u0005\u0015\u0000\u0000\u0348\u0349\u0003n7\u0000\u0349\u034a"
          + "\u0005-\u0000\u0000\u034a\u034b\u0003n7\u0000\u034b\u034c\u0005\r\u0000"
          + "\u0000\u034c\u034d\u0003n7\u0000\u034dy\u0001\u0000\u0000\u0000\u034e"
          + "\u034f\u0005 \u0000\u0000\u034f\u0350\u0003n7\u0000\u0350{\u0001\u0000"
          + "\u0000\u0000\u0351\u0352\u0005\u000e\u0000\u0000\u0352\u0353\u0005Z\u0000"
          + "\u0000\u0353\u0354\u0003\u008aE\u0000\u0354\u0355\u0005[\u0000\u0000\u0355"
          + "\u037a\u0001\u0000\u0000\u0000\u0356\u0357\u0005\u000e\u0000\u0000\u0357"
          + "\u0358\u0005Z\u0000\u0000\u0358\u035b\u0003j5\u0000\u0359\u035a\u0005"
          + "c\u0000\u0000\u035a\u035c\u0003n7\u0000\u035b\u0359\u0001\u0000\u0000"
          + "\u0000\u035b\u035c\u0001\u0000\u0000\u0000\u035c\u035f\u0001\u0000\u0000"
          + "\u0000\u035d\u035e\u0005c\u0000\u0000\u035e\u0360\u0003n7\u0000\u035f"
          + "\u035d\u0001\u0000\u0000\u0000\u035f\u0360\u0001\u0000\u0000\u0000\u0360"
          + "\u0361\u0001\u0000\u0000\u0000\u0361\u0362\u0005[\u0000\u0000\u0362\u037a"
          + "\u0001\u0000\u0000\u0000\u0363\u0364\u0005\u0012\u0000\u0000\u0364\u0365"
          + "\u0005Z\u0000\u0000\u0365\u0368\u0003j5\u0000\u0366\u0367\u0005c\u0000"
          + "\u0000\u0367\u0369\u0003n7\u0000\u0368\u0366\u0001\u0000\u0000\u0000\u0368"
          + "\u0369\u0001\u0000\u0000\u0000\u0369\u036a\u0001\u0000\u0000\u0000\u036a"
          + "\u036b\u0005c\u0000\u0000\u036b\u036c\u0003n7\u0000\u036c\u036d\u0005"
          + "[\u0000\u0000\u036d\u037a\u0001\u0000\u0000\u0000\u036e\u036f\u0005\u0013"
          + "\u0000\u0000\u036f\u0370\u0005Z\u0000\u0000\u0370\u0373\u0003j5\u0000"
          + "\u0371\u0372\u0005c\u0000\u0000\u0372\u0374\u0003n7\u0000\u0373\u0371"
          + "\u0001\u0000\u0000\u0000\u0373\u0374\u0001\u0000\u0000\u0000\u0374\u0375"
          + "\u0001\u0000\u0000\u0000\u0375\u0376\u0005c\u0000\u0000\u0376\u0377\u0003"
          + "n7\u0000\u0377\u0378\u0005[\u0000\u0000\u0378\u037a\u0001\u0000\u0000"
          + "\u0000\u0379\u0351\u0001\u0000\u0000\u0000\u0379\u0356\u0001\u0000\u0000"
          + "\u0000\u0379\u0363\u0001\u0000\u0000\u0000\u0379\u036e\u0001\u0000\u0000"
          + "\u0000\u037a}\u0001\u0000\u0000\u0000\u037b\u037c\u0003\u008aE\u0000\u037c"
          + "\u037d\u0003\u0080@\u0000\u037d\u037e\u0003\u008aE\u0000\u037e\u007f\u0001"
          + "\u0000\u0000\u0000\u037f\u0380\u0007\u0005\u0000\u0000\u0380\u0081\u0001"
          + "\u0000\u0000\u0000\u0381\u0382\u0003\u008aE\u0000\u0382\u0383\u0005\u0019"
          + "\u0000\u0000\u0383\u0384\u0003d2\u0000\u0384\u0083\u0001\u0000\u0000\u0000"
          + "\u0385\u0386\u0003\u008aE\u0000\u0386\u0389\u0005\u0018\u0000\u0000\u0387"
          + "\u038a\u0003\u00b6[\u0000\u0388\u038a\u0003\u00b8\\\u0000\u0389\u0387"
          + "\u0001\u0000\u0000\u0000\u0389\u0388\u0001\u0000\u0000\u0000\u038a\u0085"
          + "\u0001\u0000\u0000\u0000\u038b\u038d\u0003\u00c2a\u0000\u038c\u038e\u0003"
          + "\u0088D\u0000\u038d\u038c\u0001\u0000\u0000\u0000\u038d\u038e\u0001\u0000"
          + "\u0000\u0000\u038e\u038f\u0001\u0000\u0000\u0000\u038f\u0391\u0005Z\u0000"
          + "\u0000\u0390\u0392\u0003f3\u0000\u0391\u0390\u0001\u0000\u0000\u0000\u0391"
          + "\u0392\u0001\u0000\u0000\u0000\u0392\u0393\u0001\u0000\u0000\u0000\u0393"
          + "\u0394\u0005[\u0000\u0000\u0394\u03a2\u0001\u0000\u0000\u0000\u0395\u0396"
          + "\u0003\u0092I\u0000\u0396\u0397\u0005X\u0000\u0000\u0397\u0399\u0003\u00c4"
          + "b\u0000\u0398\u039a\u0003\u0088D\u0000\u0399\u0398\u0001\u0000\u0000\u0000"
          + "\u0399\u039a\u0001\u0000\u0000\u0000\u039a\u039b\u0001\u0000\u0000\u0000"
          + "\u039b\u039d\u0005Z\u0000\u0000\u039c\u039e\u0003f3\u0000\u039d\u039c"
          + "\u0001\u0000\u0000\u0000\u039d\u039e\u0001\u0000\u0000\u0000\u039e\u039f"
          + "\u0001\u0000\u0000\u0000\u039f\u03a0\u0005[\u0000\u0000\u03a0\u03a2\u0001"
          + "\u0000\u0000\u0000\u03a1\u038b\u0001\u0000\u0000\u0000\u03a1\u0395\u0001"
          + "\u0000\u0000\u0000\u03a2\u0087\u0001\u0000\u0000\u0000\u03a3\u03a4\u0007"
          + "\u0006\u0000\u0000\u03a4\u0089\u0001\u0000\u0000\u0000\u03a5\u03aa\u0003"
          + "\u008cF\u0000\u03a6\u03a7\u0007\u0007\u0000\u0000\u03a7\u03a9\u0003\u008c"
          + "F\u0000\u03a8\u03a6\u0001\u0000\u0000\u0000\u03a9\u03ac\u0001\u0000\u0000"
          + "\u0000\u03aa\u03a8\u0001\u0000\u0000\u0000\u03aa\u03ab\u0001\u0000\u0000"
          + "\u0000\u03ab\u008b\u0001\u0000\u0000\u0000\u03ac\u03aa\u0001\u0000\u0000"
          + "\u0000\u03ad\u03b2\u0003\u008eG\u0000\u03ae\u03af\u0007\b\u0000\u0000"
          + "\u03af\u03b1\u0003\u008eG\u0000\u03b0\u03ae\u0001\u0000\u0000\u0000\u03b1"
          + "\u03b4\u0001\u0000\u0000\u0000\u03b2\u03b0\u0001\u0000\u0000\u0000\u03b2"
          + "\u03b3\u0001\u0000\u0000\u0000\u03b3\u008d\u0001\u0000\u0000\u0000\u03b4"
          + "\u03b2\u0001\u0000\u0000\u0000\u03b5\u03b8\u0003\u0090H\u0000\u03b6\u03b8"
          + "\u0003\u00a0P\u0000\u03b7\u03b5\u0001\u0000\u0000\u0000\u03b7\u03b6\u0001"
          + "\u0000\u0000\u0000\u03b8\u008f\u0001\u0000\u0000\u0000\u03b9\u03bd\u0005"
          + "S\u0000\u0000\u03ba\u03bd\u0003\u00a6S\u0000\u03bb\u03bd\u0003\u0092I"
          + "\u0000\u03bc\u03b9\u0001\u0000\u0000\u0000\u03bc\u03ba\u0001\u0000\u0000"
          + "\u0000\u03bc\u03bb\u0001\u0000\u0000\u0000\u03bd\u0091\u0001\u0000\u0000"
          + "\u0000\u03be\u03c2\u0003\u0098L\u0000\u03bf\u03c1\u0003\u0094J\u0000\u03c0"
          + "\u03bf\u0001\u0000\u0000\u0000\u03c1\u03c4\u0001\u0000\u0000\u0000\u03c2"
          + "\u03c0\u0001\u0000\u0000\u0000\u03c2\u03c3\u0001\u0000\u0000\u0000\u03c3"
          + "\u0093\u0001\u0000\u0000\u0000\u03c4\u03c2\u0001\u0000\u0000\u0000\u03c5"
          + "\u03c6\u0005X\u0000\u0000\u03c6\u03c7\u0005Z\u0000\u0000\u03c7\u03c8\u0003"
          + "d2\u0000\u03c8\u03c9\u0005[\u0000\u0000\u03c9\u03d6\u0001\u0000\u0000"
          + "\u0000\u03ca\u03cb\u0005X\u0000\u0000\u03cb\u03cd\u0003\u00c4b\u0000\u03cc"
          + "\u03ce\u0003\u0088D\u0000\u03cd\u03cc\u0001\u0000\u0000\u0000\u03cd\u03ce"
          + "\u0001\u0000\u0000\u0000\u03ce\u03cf\u0001\u0000\u0000\u0000\u03cf\u03d1"
          + "\u0005Z\u0000\u0000\u03d0\u03d2\u0003f3\u0000\u03d1\u03d0\u0001\u0000"
          + "\u0000\u0000\u03d1\u03d2\u0001\u0000\u0000\u0000\u03d2\u03d3\u0001\u0000"
          + "\u0000\u0000\u03d3\u03d4\u0005[\u0000\u0000\u03d4\u03d6\u0001\u0000\u0000"
          + "\u0000\u03d5\u03c5\u0001\u0000\u0000\u0000\u03d5\u03ca\u0001\u0000\u0000"
          + "\u0000\u03d6\u0095\u0001\u0000\u0000\u0000\u03d7\u03d9\u0003\u00c2a\u0000"
          + "\u03d8\u03da\u0003\u0088D\u0000\u03d9\u03d8\u0001\u0000\u0000\u0000\u03d9"
          + "\u03da\u0001\u0000\u0000\u0000\u03da\u03db\u0001\u0000\u0000\u0000\u03db"
          + "\u03dd\u0005Z\u0000\u0000\u03dc\u03de\u0003f3\u0000\u03dd\u03dc\u0001"
          + "\u0000\u0000\u0000\u03dd\u03de\u0001\u0000\u0000\u0000\u03de\u03df\u0001"
          + "\u0000\u0000\u0000\u03df\u03e0\u0005[\u0000\u0000\u03e0\u0097\u0001\u0000"
          + "\u0000\u0000\u03e1\u03ed\u0003\u009cN\u0000\u03e2\u03ed\u0003\u009eO\u0000"
          + "\u03e3\u03ed\u0003\u00a2Q\u0000\u03e4\u03ed\u0003\u00a4R\u0000\u03e5\u03ed"
          + "\u0003\u00a8T\u0000\u03e6\u03ed\u0003\u00aaU\u0000\u03e7\u03ed\u0003\u0096"
          + "K\u0000\u03e8\u03ed\u0003\u00b4Z\u0000\u03e9\u03ed\u0003\u009aM\u0000"
          + "\u03ea\u03ed\u0003\u00b6[\u0000\u03eb\u03ed\u0003\u00b8\\\u0000\u03ec"
          + "\u03e1\u0001\u0000\u0000\u0000\u03ec\u03e2\u0001\u0000\u0000\u0000\u03ec"
          + "\u03e3\u0001\u0000\u0000\u0000\u03ec\u03e4\u0001\u0000\u0000\u0000\u03ec"
          + "\u03e5\u0001\u0000\u0000\u0000\u03ec\u03e6\u0001\u0000\u0000\u0000\u03ec"
          + "\u03e7\u0001\u0000\u0000\u0000\u03ec\u03e8\u0001\u0000\u0000\u0000\u03ec"
          + "\u03e9\u0001\u0000\u0000\u0000\u03ec\u03ea\u0001\u0000\u0000\u0000\u03ec"
          + "\u03eb\u0001\u0000\u0000\u0000\u03ed\u0099\u0001\u0000\u0000\u0000\u03ee"
          + "\u03ef\u0005\u001f\u0000\u0000\u03ef\u03f0\u0005Z\u0000\u0000\u03f0\u03f1"
          + "\u0005[\u0000\u0000\u03f1\u009b\u0001\u0000\u0000\u0000\u03f2\u03f3\u0005"
          + "Z\u0000\u0000\u03f3\u03f4\u0003\u008aE\u0000\u03f4\u03f5\u0005[\u0000"
          + "\u0000\u03f5\u009d\u0001\u0000\u0000\u0000\u03f6\u03f7\u0007\t\u0000\u0000"
          + "\u03f7\u009f\u0001\u0000\u0000\u0000\u03f8\u03f9\u0005b\u0000\u0000\u03f9"
          + "\u03fd\u0003\u008aE\u0000\u03fa\u03fb\u0005R\u0000\u0000\u03fb\u03fd\u0003"
          + "\u008aE\u0000\u03fc\u03f8\u0001\u0000\u0000\u0000\u03fc\u03fa\u0001\u0000"
          + "\u0000\u0000\u03fd\u00a1\u0001\u0000\u0000\u0000\u03fe\u0402\u0003\u0006"
          + "\u0003\u0000\u03ff\u0402\u0005.\u0000\u0000\u0400\u0402\u0005%\u0000\u0000"
          + "\u0401\u03fe\u0001\u0000\u0000\u0000\u0401\u03ff\u0001\u0000\u0000\u0000"
          + "\u0401\u0400\u0001\u0000\u0000\u0000\u0402\u00a3\u0001\u0000\u0000\u0000"
          + "\u0403\u0409\u0005,\u0000\u0000\u0404\u0405\u0003d2\u0000\u0405\u0406"
          + "\u0005X\u0000\u0000\u0406\u0407\u0005,\u0000\u0000\u0407\u0409\u0001\u0000"
          + "\u0000\u0000\u0408\u0403\u0001\u0000\u0000\u0000\u0408\u0404\u0001\u0000"
          + "\u0000\u0000\u0409\u00a5\u0001\u0000\u0000\u0000\u040a\u040b\u0005Z\u0000"
          + "\u0000\u040b\u040c\u0003d2\u0000\u040c\u040d\u0005[\u0000\u0000\u040d"
          + "\u040e\u0003\u008aE\u0000\u040e\u00a7\u0001\u0000\u0000\u0000\u040f\u0414"
          + "\u0003\u00aeW\u0000\u0410\u0411\u0005^\u0000\u0000\u0411\u0412\u0003\u008a"
          + "E\u0000\u0412\u0413\u0005_\u0000\u0000\u0413\u0415\u0001\u0000\u0000\u0000"
          + "\u0414\u0410\u0001\u0000\u0000\u0000\u0414\u0415\u0001\u0000\u0000\u0000"
          + "\u0415\u0416\u0001\u0000\u0000\u0000\u0416\u0417\u0005Z\u0000\u0000\u0417"
          + "\u0425\u0003j5\u0000\u0418\u041a\u0005c\u0000\u0000\u0419\u041b\u0003"
          + "n7\u0000\u041a\u0419\u0001\u0000\u0000\u0000\u041a\u041b\u0001\u0000\u0000"
          + "\u0000\u041b\u0423\u0001\u0000\u0000\u0000\u041c\u041d\u0005c\u0000\u0000"
          + "\u041d\u0421\u00030\u0018\u0000\u041e\u041f\u0005\"\u0000\u0000\u041f"
          + "\u0420\u0005\u0007\u0000\u0000\u0420\u0422\u0003\u00b0X\u0000\u0421\u041e"
          + "\u0001\u0000\u0000\u0000\u0421\u0422\u0001\u0000\u0000\u0000\u0422\u0424"
          + "\u0001\u0000\u0000\u0000\u0423\u041c\u0001\u0000\u0000\u0000\u0423\u0424"
          + "\u0001\u0000\u0000\u0000\u0424\u0426\u0001\u0000\u0000\u0000\u0425\u0418"
          + "\u0001\u0000\u0000\u0000\u0425\u0426\u0001\u0000\u0000\u0000\u0426\u0427"
          + "\u0001\u0000\u0000\u0000\u0427\u0428\u0005[\u0000\u0000\u0428\u0447\u0001"
          + "\u0000\u0000\u0000\u0429\u042e\u0003\u00aeW\u0000\u042a\u042b\u0005^\u0000"
          + "\u0000\u042b\u042c\u0003\u008aE\u0000\u042c\u042d\u0005_\u0000\u0000\u042d"
          + "\u042f\u0001\u0000\u0000\u0000\u042e\u042a\u0001\u0000\u0000\u0000\u042e"
          + "\u042f\u0001\u0000\u0000\u0000\u042f\u0430\u0001\u0000\u0000\u0000\u0430"
          + "\u0431\u0005Z\u0000\u0000\u0431\u0435\u00030\u0018\u0000\u0432\u0433\u0005"
          + "\"\u0000\u0000\u0433\u0434\u0005\u0007\u0000\u0000\u0434\u0436\u0003\u00b0"
          + "X\u0000\u0435\u0432\u0001\u0000\u0000\u0000\u0435\u0436\u0001\u0000\u0000"
          + "\u0000\u0436\u0437\u0001\u0000\u0000\u0000\u0437\u0438\u0005[\u0000\u0000"
          + "\u0438\u0447\u0001\u0000\u0000\u0000\u0439\u043a\u00050\u0000\u0000\u043a"
          + "\u043b\u0005Z\u0000\u0000\u043b\u043c\u0003j5\u0000\u043c\u043e\u0005"
          + "c\u0000\u0000\u043d\u043f\u0003n7\u0000\u043e\u043d\u0001\u0000\u0000"
          + "\u0000\u043e\u043f\u0001\u0000\u0000\u0000\u043f\u0442\u0001\u0000\u0000"
          + "\u0000\u0440\u0441\u0005c\u0000\u0000\u0441\u0443\u00030\u0018\u0000\u0442"
          + "\u0440\u0001\u0000\u0000\u0000\u0442\u0443\u0001\u0000\u0000\u0000\u0443"
          + "\u0444\u0001\u0000\u0000\u0000\u0444\u0445\u0005[\u0000\u0000\u0445\u0447"
          + "\u0001\u0000\u0000\u0000\u0446\u040f\u0001\u0000\u0000\u0000\u0446\u0429"
          + "\u0001\u0000\u0000\u0000\u0446\u0439\u0001\u0000\u0000\u0000\u0447\u00a9"
          + "\u0001\u0000\u0000\u0000\u0448\u0449\u0005A\u0000\u0000\u0449\u044a\u0005"
          + "^\u0000\u0000\u044a\u044b\u0003\u00acV\u0000\u044b\u044c\u0005_\u0000"
          + "\u0000\u044c\u044d\u0005Z\u0000\u0000\u044d\u044e\u0003\u008aE\u0000\u044e"
          + "\u044f\u0005[\u0000\u0000\u044f\u00ab\u0001\u0000\u0000\u0000\u0450\u0451"
          + "\u0007\n\u0000\u0000\u0451\u00ad\u0001\u0000\u0000\u0000\u0452\u0453\u0007"
          + "\u000b\u0000\u0000\u0453\u00af\u0001\u0000\u0000\u0000\u0454\u0459\u0003"
          + "\u00b2Y\u0000\u0455\u0456\u0005T\u0000\u0000\u0456\u0458\u0003\u00b2Y"
          + "\u0000\u0457\u0455\u0001\u0000\u0000\u0000\u0458\u045b\u0001\u0000\u0000"
          + "\u0000\u0459\u0457\u0001\u0000\u0000\u0000\u0459\u045a\u0001\u0000\u0000"
          + "\u0000\u045a\u00b1\u0001\u0000\u0000\u0000\u045b\u0459\u0001\u0000\u0000"
          + "\u0000\u045c\u045e\u0003\u008aE\u0000\u045d\u045f\u0007\u0002\u0000\u0000"
          + "\u045e\u045d\u0001\u0000\u0000\u0000\u045e\u045f\u0001\u0000\u0000\u0000"
          + "\u045f\u00b3\u0001\u0000\u0000\u0000\u0460\u0461\u0005\u0002\u0000\u0000"
          + "\u0461\u0462\u0005Z\u0000\u0000\u0462\u046b\u0003j5\u0000\u0463\u0465"
          + "\u0005c\u0000\u0000\u0464\u0466\u0003n7\u0000\u0465\u0464\u0001\u0000"
          + "\u0000\u0000\u0465\u0466\u0001\u0000\u0000\u0000\u0466\u0469\u0001\u0000"
          + "\u0000\u0000\u0467\u0468\u0005c\u0000\u0000\u0468\u046a\u0003\u008aE\u0000"
          + "\u0469\u0467\u0001\u0000\u0000\u0000\u0469\u046a\u0001\u0000\u0000\u0000"
          + "\u046a\u046c\u0001\u0000\u0000\u0000\u046b\u0463\u0001\u0000\u0000\u0000"
          + "\u046b\u046c\u0001\u0000\u0000\u0000\u046c\u046d\u0001\u0000\u0000\u0000"
          + "\u046d\u046e\u0005[\u0000\u0000\u046e\u00b5\u0001\u0000\u0000\u0000\u046f"
          + "\u0470\u0005^\u0000\u0000\u0470\u0471\u0003\u008aE\u0000\u0471\u0472\u0005"
          + "Y\u0000\u0000\u0472\u0473\u0003\u008aE\u0000\u0473\u0474\u0005_\u0000"
          + "\u0000\u0474\u00b7\u0001\u0000\u0000\u0000\u0475\u0476\u0005^\u0000\u0000"
          + "\u0476\u047b\u0003\u008aE\u0000\u0477\u0478\u0005T\u0000\u0000\u0478\u047a"
          + "\u0003\u008aE\u0000\u0479\u0477\u0001\u0000\u0000\u0000\u047a\u047d\u0001"
          + "\u0000\u0000\u0000\u047b\u0479\u0001\u0000\u0000\u0000\u047b\u047c\u0001"
          + "\u0000\u0000\u0000\u047c\u047f\u0001\u0000\u0000\u0000\u047d\u047b\u0001"
          + "\u0000\u0000\u0000\u047e\u0480\u0005T\u0000\u0000\u047f\u047e\u0001\u0000"
          + "\u0000\u0000\u047f\u0480\u0001\u0000\u0000\u0000\u0480\u0481\u0001\u0000"
          + "\u0000\u0000\u0481\u0482\u0005_\u0000\u0000\u0482\u00b9\u0001\u0000\u0000"
          + "\u0000\u0483\u0484\u0003\u0014\n\u0000\u0484\u00bb\u0001\u0000\u0000\u0000"
          + "\u0485\u0486\u0005n\u0000\u0000\u0486\u00bd\u0001\u0000\u0000\u0000\u0487"
          + "\u0488\u0005n\u0000\u0000\u0488\u00bf\u0001\u0000\u0000\u0000\u0489\u048a"
          + "\u0005o\u0000\u0000\u048a\u00c1\u0001\u0000\u0000\u0000\u048b\u048c\u0003"
          + "^/\u0000\u048c\u048d\u0005d\u0000\u0000\u048d\u048f\u0001\u0000\u0000"
          + "\u0000\u048e\u048b\u0001\u0000\u0000\u0000\u048e\u048f\u0001\u0000\u0000"
          + "\u0000\u048f\u0490\u0001\u0000\u0000\u0000\u0490\u0491\u0003\u00c6c\u0000"
          + "\u0491\u00c3\u0001\u0000\u0000\u0000\u0492\u0495\u0005m\u0000\u0000\u0493"
          + "\u0495\u0003\u0002\u0001\u0000\u0494\u0492\u0001\u0000\u0000\u0000\u0494"
          + "\u0493\u0001\u0000\u0000\u0000\u0495\u00c5\u0001\u0000\u0000\u0000\u0496"
          + "\u049b\u0005m\u0000\u0000\u0497\u049b\u0005o\u0000\u0000\u0498\u049b\u0005"
          + "n\u0000\u0000\u0499\u049b\u0003\u0004\u0002\u0000\u049a\u0496\u0001\u0000"
          + "\u0000\u0000\u049a\u0497\u0001\u0000\u0000\u0000\u049a\u0498\u0001\u0000"
          + "\u0000\u0000\u049a\u0499\u0001\u0000\u0000\u0000\u049b\u00c7\u0001\u0000"
          + "\u0000\u0000\u049c\u049d\u0003\u0014\n\u0000\u049d\u00c9\u0001\u0000\u0000"
          + "\u0000\u0087\u00d0\u00d7\u00db\u00de\u00e6\u00ec\u00ef\u00fe\u0109\u0115"
          + "\u0117\u011f\u012b\u0135\u0139\u0142\u014d\u0152\u0155\u015a\u0162\u016e"
          + "\u0171\u0178\u017c\u017f\u0184\u018b\u0194\u0196\u019a\u01a1\u01ab\u01b6"
          + "\u01b9\u01c0\u01c4\u01c8\u01cc\u01d3\u01da\u01e0\u01e7\u01ec\u01f5\u0200"
          + "\u0205\u0212\u0216\u0220\u0229\u022e\u023b\u024b\u024e\u0251\u0255\u026e"
          + "\u0271\u0276\u027a\u027d\u0288\u028b\u0293\u0296\u029c\u02a4\u02a7\u02b2"
          + "\u02bb\u02c1\u02c5\u02cb\u02cf\u02d4\u02da\u02df\u02e8\u02ef\u02f3\u02ff"
          + "\u0309\u0312\u0319\u031c\u0326\u0331\u0338\u0340\u035b\u035f\u0368\u0373"
          + "\u0379\u0389\u038d\u0391\u0399\u039d\u03a1\u03aa\u03b2\u03b7\u03bc\u03c2"
          + "\u03cd\u03d1\u03d5\u03d9\u03dd\u03ec\u03fc\u0401\u0408\u0414\u041a\u0421"
          + "\u0423\u0425\u042e\u0435\u043e\u0442\u0446\u0459\u045e\u0465\u0469\u046b"
          + "\u047b\u047f\u048e\u0494\u049a";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
