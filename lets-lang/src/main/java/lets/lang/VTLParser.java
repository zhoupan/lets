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
public class VTLParser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int OPAR = 1,
      CPAR = 2,
      OBRACK = 3,
      CBRACK = 4,
      OBRACE = 5,
      CBRACE = 6,
      STRING = 7,
      INTEGER = 8,
      ID = 9,
      REFERENCE = 10,
      DOT = 11,
      COMMA = 12,
      ASSIGN = 13,
      EQ = 14,
      NE = 15,
      AND = 16,
      OR = 17,
      K_NULL = 18,
      ADD = 19,
      SUB = 20,
      MUL = 21,
      DIV = 22,
      MOD = 23,
      COLON = 24,
      FLOAT = 25,
      RANGE = 26,
      LT = 27,
      LE = 28,
      GT = 29,
      GE = 30,
      EXCL = 31,
      K_LT = 32,
      K_LE = 33,
      K_GT = 34,
      K_GE = 35,
      K_EQ = 36,
      K_NE = 37,
      K_TRUE = 38,
      K_FALSE = 39,
      K_AND = 40,
      K_OR = 41,
      K_NOT = 42,
      K_IN = 43,
      IF = 44,
      ELSEIF = 45,
      ELSE = 46,
      FOREACH = 47,
      SET = 48,
      END = 49,
      BREAK = 50,
      MACRO_ID = 51,
      MACRO = 52,
      STOP = 53,
      INCLUDE = 54,
      EVALUATE = 55,
      PARSE = 56,
      DEFINE = 57,
      ESCAPED_CHAR = 58,
      START_DIRECTIVE = 59,
      DOLLAR_EXCL_OBRACE = 60,
      DOLLAR_OBRACE = 61,
      DOLLAR_EXCL = 62,
      DOLLAR = 63,
      TEXT = 64,
      ESCAPED_BLOCK = 65,
      SNGLE_LINE_COMMENT = 66,
      VTL_COMMENT_BLOCK = 67,
      MULTI_LINE_COMMENT = 68,
      VAR_HASH = 69,
      CODE_SPACES = 70,
      FRM_DOT = 71,
      FRM_CBRACE = 72,
      CODE_K_LT = 73,
      CODE_K_LE = 74,
      CODE_K_GT = 75,
      CODE_K_GE = 76,
      CODE_K_EQ = 77,
      CODE_K_NE = 78,
      CODE_K_TRUE = 79,
      CODE_K_FALSE = 80,
      CODE_K_AND = 81,
      CODE_K_OR = 82,
      CODE_K_NOT = 83,
      CODE_K_NULL = 84,
      CODE_K_IN = 85,
      CODE_ADD = 86,
      CODE_SUB = 87,
      CODE_MUL = 88,
      CODE_DIV = 89,
      CODE_MOD = 90,
      CODE_EXCL = 91,
      CODE_OR = 92,
      CODE_AND = 93,
      CODE_ASSIGN = 94,
      CODE_EQ = 95,
      CODE_NEQ = 96,
      CODE_LT = 97,
      CODE_LE = 98,
      CODE_GT = 99,
      CODE_GE = 100,
      CODE_CPAR = 101,
      CODE_COLON = 102,
      CODE_RANGE = 103,
      CODE_OBRACK = 104,
      CODE_CBRACK = 105,
      CODE_OBRACE = 106,
      CODE_COMMA = 107;
  public static final int RULE_parse = 0,
      RULE_block = 1,
      RULE_atom = 2,
      RULE_formal = 3,
      RULE_variable = 4,
      RULE_property_or_method = 5,
      RULE_formal_property_or_method = 6,
      RULE_directive = 7,
      RULE_property_end = 8,
      RULE_expressions = 9,
      RULE_set_directive = 10,
      RULE_if_directive = 11,
      RULE_elseif_directive = 12,
      RULE_else_directive = 13,
      RULE_foreach_directive = 14,
      RULE_break_directive = 15,
      RULE_stop_directive = 16,
      RULE_custom_directive = 17,
      RULE_macro_directive = 18,
      RULE_parse_directive = 19,
      RULE_define_directive = 20,
      RULE_include_directive = 21,
      RULE_evaluate_directive = 22,
      RULE_macro_call_directive = 23,
      RULE_end = 24,
      RULE_expression = 25,
      RULE_list = 26,
      RULE_map = 27,
      RULE_map_entries = 28,
      RULE_map_entry = 29,
      RULE_id = 30;

  private static String[] makeRuleNames() {
    return new String[] {
      "parse",
      "block",
      "atom",
      "formal",
      "variable",
      "property_or_method",
      "formal_property_or_method",
      "directive",
      "property_end",
      "expressions",
      "set_directive",
      "if_directive",
      "elseif_directive",
      "else_directive",
      "foreach_directive",
      "break_directive",
      "stop_directive",
      "custom_directive",
      "macro_directive",
      "parse_directive",
      "define_directive",
      "include_directive",
      "evaluate_directive",
      "macro_call_directive",
      "end",
      "expression",
      "list",
      "map",
      "map_entries",
      "map_entry",
      "id"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
      null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
      null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
      null, null, null, null, null, null, null, null, null, null, null, null, null, null, "'#'",
      null, null, null, null, null, null, null, null, null, null, null, null, null, "'lt'", "'le'",
      "'gt'", "'ge'", "'eq'", "'ne'", "'true'", "'false'", "'and'", "'or'", "'not'", "'null'",
      "'in'", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'||'", "'&&'", "'='", "'=='", "'!='",
      "'<'", "'<='", "'>'", "'>='", "')'", "':'", "'..'", "'['", null, "'{'", "','"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      "OPAR",
      "CPAR",
      "OBRACK",
      "CBRACK",
      "OBRACE",
      "CBRACE",
      "STRING",
      "INTEGER",
      "ID",
      "REFERENCE",
      "DOT",
      "COMMA",
      "ASSIGN",
      "EQ",
      "NE",
      "AND",
      "OR",
      "K_NULL",
      "ADD",
      "SUB",
      "MUL",
      "DIV",
      "MOD",
      "COLON",
      "FLOAT",
      "RANGE",
      "LT",
      "LE",
      "GT",
      "GE",
      "EXCL",
      "K_LT",
      "K_LE",
      "K_GT",
      "K_GE",
      "K_EQ",
      "K_NE",
      "K_TRUE",
      "K_FALSE",
      "K_AND",
      "K_OR",
      "K_NOT",
      "K_IN",
      "IF",
      "ELSEIF",
      "ELSE",
      "FOREACH",
      "SET",
      "END",
      "BREAK",
      "MACRO_ID",
      "MACRO",
      "STOP",
      "INCLUDE",
      "EVALUATE",
      "PARSE",
      "DEFINE",
      "ESCAPED_CHAR",
      "START_DIRECTIVE",
      "DOLLAR_EXCL_OBRACE",
      "DOLLAR_OBRACE",
      "DOLLAR_EXCL",
      "DOLLAR",
      "TEXT",
      "ESCAPED_BLOCK",
      "SNGLE_LINE_COMMENT",
      "VTL_COMMENT_BLOCK",
      "MULTI_LINE_COMMENT",
      "VAR_HASH",
      "CODE_SPACES",
      "FRM_DOT",
      "FRM_CBRACE",
      "CODE_K_LT",
      "CODE_K_LE",
      "CODE_K_GT",
      "CODE_K_GE",
      "CODE_K_EQ",
      "CODE_K_NE",
      "CODE_K_TRUE",
      "CODE_K_FALSE",
      "CODE_K_AND",
      "CODE_K_OR",
      "CODE_K_NOT",
      "CODE_K_NULL",
      "CODE_K_IN",
      "CODE_ADD",
      "CODE_SUB",
      "CODE_MUL",
      "CODE_DIV",
      "CODE_MOD",
      "CODE_EXCL",
      "CODE_OR",
      "CODE_AND",
      "CODE_ASSIGN",
      "CODE_EQ",
      "CODE_NEQ",
      "CODE_LT",
      "CODE_LE",
      "CODE_GT",
      "CODE_GE",
      "CODE_CPAR",
      "CODE_COLON",
      "CODE_RANGE",
      "CODE_OBRACK",
      "CODE_CBRACK",
      "CODE_OBRACE",
      "CODE_COMMA"
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
    return "VTLParser.g4";
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

  public VTLParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class ParseContext extends ParserRuleContext {
    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public TerminalNode EOF() {
      return getToken(VTLParser.EOF, 0);
    }

    public ParseContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_parse;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).enterParse(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).exitParse(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitParse(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ParseContext parse() throws RecognitionException {
    ParseContext _localctx = new ParseContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_parse);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(62);
        block();
        setState(63);
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
  public static class BlockContext extends ParserRuleContext {
    public List<AtomContext> atom() {
      return getRuleContexts(AtomContext.class);
    }

    public AtomContext atom(int i) {
      return getRuleContext(AtomContext.class, i);
    }

    public BlockContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_block;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).enterBlock(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).exitBlock(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitBlock(this);
      else return visitor.visitChildren(this);
    }
  }

  public final BlockContext block() throws RecognitionException {
    BlockContext _localctx = new BlockContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_block);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(68);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (((((_la - 9)) & ~0x3f) == 0 && ((1L << (_la - 9)) & 142987948139216899L) != 0)) {
          {
            {
              setState(65);
              atom();
            }
          }
          setState(70);
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
  public static class AtomContext extends ParserRuleContext {
    public TerminalNode TEXT() {
      return getToken(VTLParser.TEXT, 0);
    }

    public TerminalNode ESCAPED_CHAR() {
      return getToken(VTLParser.ESCAPED_CHAR, 0);
    }

    public TerminalNode ESCAPED_BLOCK() {
      return getToken(VTLParser.ESCAPED_BLOCK, 0);
    }

    public VariableContext variable() {
      return getRuleContext(VariableContext.class, 0);
    }

    public FormalContext formal() {
      return getRuleContext(FormalContext.class, 0);
    }

    public Property_or_methodContext property_or_method() {
      return getRuleContext(Property_or_methodContext.class, 0);
    }

    public DirectiveContext directive() {
      return getRuleContext(DirectiveContext.class, 0);
    }

    public AtomContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_atom;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).enterAtom(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).exitAtom(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitAtom(this);
      else return visitor.visitChildren(this);
    }
  }

  public final AtomContext atom() throws RecognitionException {
    AtomContext _localctx = new AtomContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_atom);
    try {
      setState(78);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(71);
            match(TEXT);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(72);
            match(ESCAPED_CHAR);
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(73);
            match(ESCAPED_BLOCK);
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(74);
            variable();
          }
          break;
        case 5:
          enterOuterAlt(_localctx, 5);
          {
            setState(75);
            formal();
          }
          break;
        case 6:
          enterOuterAlt(_localctx, 6);
          {
            setState(76);
            property_or_method();
          }
          break;
        case 7:
          enterOuterAlt(_localctx, 7);
          {
            setState(77);
            directive();
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
  public static class FormalContext extends ParserRuleContext {
    public TerminalNode DOLLAR_OBRACE() {
      return getToken(VTLParser.DOLLAR_OBRACE, 0);
    }

    public Formal_property_or_methodContext formal_property_or_method() {
      return getRuleContext(Formal_property_or_methodContext.class, 0);
    }

    public TerminalNode CBRACE() {
      return getToken(VTLParser.CBRACE, 0);
    }

    public TerminalNode DOLLAR_EXCL_OBRACE() {
      return getToken(VTLParser.DOLLAR_EXCL_OBRACE, 0);
    }

    public IdContext id() {
      return getRuleContext(IdContext.class, 0);
    }

    public FormalContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_formal;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).enterFormal(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).exitFormal(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitFormal(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FormalContext formal() throws RecognitionException {
    FormalContext _localctx = new FormalContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_formal);
    try {
      setState(96);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(80);
            match(DOLLAR_OBRACE);
            setState(81);
            formal_property_or_method();
            setState(82);
            match(CBRACE);
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(84);
            match(DOLLAR_EXCL_OBRACE);
            setState(85);
            formal_property_or_method();
            setState(86);
            match(CBRACE);
          }
          break;
        case 3:
          enterOuterAlt(_localctx, 3);
          {
            setState(88);
            match(DOLLAR_OBRACE);
            setState(89);
            id();
            setState(90);
            match(CBRACE);
          }
          break;
        case 4:
          enterOuterAlt(_localctx, 4);
          {
            setState(92);
            match(DOLLAR_EXCL_OBRACE);
            setState(93);
            id();
            setState(94);
            match(CBRACE);
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
  public static class VariableContext extends ParserRuleContext {
    public TerminalNode DOLLAR() {
      return getToken(VTLParser.DOLLAR, 0);
    }

    public IdContext id() {
      return getRuleContext(IdContext.class, 0);
    }

    public TerminalNode DOT() {
      return getToken(VTLParser.DOT, 0);
    }

    public TerminalNode DOLLAR_EXCL() {
      return getToken(VTLParser.DOLLAR_EXCL, 0);
    }

    public TerminalNode REFERENCE() {
      return getToken(VTLParser.REFERENCE, 0);
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
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).enterVariable(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).exitVariable(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitVariable(this);
      else return visitor.visitChildren(this);
    }
  }

  public final VariableContext variable() throws RecognitionException {
    VariableContext _localctx = new VariableContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_variable);
    try {
      setState(112);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case DOLLAR:
          enterOuterAlt(_localctx, 1);
          {
            setState(98);
            match(DOLLAR);
            setState(99);
            id();
            setState(101);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
              case 1:
                {
                  setState(100);
                  match(DOT);
                }
                break;
            }
          }
          break;
        case DOLLAR_EXCL:
          enterOuterAlt(_localctx, 2);
          {
            setState(103);
            match(DOLLAR_EXCL);
            setState(104);
            id();
            setState(106);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
              case 1:
                {
                  setState(105);
                  match(DOT);
                }
                break;
            }
          }
          break;
        case REFERENCE:
          enterOuterAlt(_localctx, 3);
          {
            setState(108);
            match(REFERENCE);
            setState(110);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
              case 1:
                {
                  setState(109);
                  match(DOT);
                }
                break;
            }
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
  public static class Property_or_methodContext extends ParserRuleContext {
    public VariableContext variable() {
      return getRuleContext(VariableContext.class, 0);
    }

    public List<Property_endContext> property_end() {
      return getRuleContexts(Property_endContext.class);
    }

    public Property_endContext property_end(int i) {
      return getRuleContext(Property_endContext.class, i);
    }

    public Property_or_methodContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_property_or_method;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterProperty_or_method(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitProperty_or_method(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitProperty_or_method(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Property_or_methodContext property_or_method() throws RecognitionException {
    Property_or_methodContext _localctx = new Property_or_methodContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_property_or_method);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(114);
        variable();
        setState(116);
        _errHandler.sync(this);
        _alt = 1;
        do {
          switch (_alt) {
            case 1:
              {
                {
                  setState(115);
                  property_end();
                }
              }
              break;
            default:
              throw new NoViableAltException(this);
          }
          setState(118);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
        } while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER);
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
  public static class Formal_property_or_methodContext extends ParserRuleContext {
    public IdContext id() {
      return getRuleContext(IdContext.class, 0);
    }

    public List<Property_endContext> property_end() {
      return getRuleContexts(Property_endContext.class);
    }

    public Property_endContext property_end(int i) {
      return getRuleContext(Property_endContext.class, i);
    }

    public Formal_property_or_methodContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_formal_property_or_method;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterFormal_property_or_method(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitFormal_property_or_method(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitFormal_property_or_method(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Formal_property_or_methodContext formal_property_or_method()
      throws RecognitionException {
    Formal_property_or_methodContext _localctx =
        new Formal_property_or_methodContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_formal_property_or_method);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(120);
        id();
        setState(122);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(121);
              property_end();
            }
          }
          setState(124);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2058L) != 0));
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
  public static class DirectiveContext extends ParserRuleContext {
    public Set_directiveContext set_directive() {
      return getRuleContext(Set_directiveContext.class, 0);
    }

    public If_directiveContext if_directive() {
      return getRuleContext(If_directiveContext.class, 0);
    }

    public Foreach_directiveContext foreach_directive() {
      return getRuleContext(Foreach_directiveContext.class, 0);
    }

    public Break_directiveContext break_directive() {
      return getRuleContext(Break_directiveContext.class, 0);
    }

    public Stop_directiveContext stop_directive() {
      return getRuleContext(Stop_directiveContext.class, 0);
    }

    public Macro_directiveContext macro_directive() {
      return getRuleContext(Macro_directiveContext.class, 0);
    }

    public Parse_directiveContext parse_directive() {
      return getRuleContext(Parse_directiveContext.class, 0);
    }

    public Define_directiveContext define_directive() {
      return getRuleContext(Define_directiveContext.class, 0);
    }

    public Include_directiveContext include_directive() {
      return getRuleContext(Include_directiveContext.class, 0);
    }

    public Evaluate_directiveContext evaluate_directive() {
      return getRuleContext(Evaluate_directiveContext.class, 0);
    }

    public Macro_call_directiveContext macro_call_directive() {
      return getRuleContext(Macro_call_directiveContext.class, 0);
    }

    public Custom_directiveContext custom_directive() {
      return getRuleContext(Custom_directiveContext.class, 0);
    }

    public DirectiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterDirective(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).exitDirective(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitDirective(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DirectiveContext directive() throws RecognitionException {
    DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_directive);
    try {
      setState(138);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case SET:
          enterOuterAlt(_localctx, 1);
          {
            setState(126);
            set_directive();
          }
          break;
        case IF:
          enterOuterAlt(_localctx, 2);
          {
            setState(127);
            if_directive();
          }
          break;
        case FOREACH:
          enterOuterAlt(_localctx, 3);
          {
            setState(128);
            foreach_directive();
          }
          break;
        case BREAK:
          enterOuterAlt(_localctx, 4);
          {
            setState(129);
            break_directive();
          }
          break;
        case STOP:
          enterOuterAlt(_localctx, 5);
          {
            setState(130);
            stop_directive();
          }
          break;
        case MACRO:
          enterOuterAlt(_localctx, 6);
          {
            setState(131);
            macro_directive();
          }
          break;
        case PARSE:
          enterOuterAlt(_localctx, 7);
          {
            setState(132);
            parse_directive();
          }
          break;
        case DEFINE:
          enterOuterAlt(_localctx, 8);
          {
            setState(133);
            define_directive();
          }
          break;
        case INCLUDE:
          enterOuterAlt(_localctx, 9);
          {
            setState(134);
            include_directive();
          }
          break;
        case EVALUATE:
          enterOuterAlt(_localctx, 10);
          {
            setState(135);
            evaluate_directive();
          }
          break;
        case MACRO_ID:
          enterOuterAlt(_localctx, 11);
          {
            setState(136);
            macro_call_directive();
          }
          break;
        case ID:
          enterOuterAlt(_localctx, 12);
          {
            setState(137);
            custom_directive();
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
  public static class Property_endContext extends ParserRuleContext {
    public TerminalNode DOT() {
      return getToken(VTLParser.DOT, 0);
    }

    public TerminalNode ID() {
      return getToken(VTLParser.ID, 0);
    }

    public TerminalNode OBRACK() {
      return getToken(VTLParser.OBRACK, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode CBRACK() {
      return getToken(VTLParser.CBRACK, 0);
    }

    public TerminalNode OPAR() {
      return getToken(VTLParser.OPAR, 0);
    }

    public TerminalNode CPAR() {
      return getToken(VTLParser.CPAR, 0);
    }

    public ExpressionsContext expressions() {
      return getRuleContext(ExpressionsContext.class, 0);
    }

    public Property_endContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_property_end;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterProperty_end(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitProperty_end(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitProperty_end(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Property_endContext property_end() throws RecognitionException {
    Property_endContext _localctx = new Property_endContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_property_end);
    int _la;
    try {
      setState(151);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case DOT:
          enterOuterAlt(_localctx, 1);
          {
            setState(140);
            match(DOT);
            setState(141);
            match(ID);
          }
          break;
        case OBRACK:
          enterOuterAlt(_localctx, 2);
          {
            setState(142);
            match(OBRACK);
            setState(143);
            expression(0);
            setState(144);
            match(CBRACK);
          }
          break;
        case OPAR:
          enterOuterAlt(_localctx, 3);
          {
            setState(146);
            match(OPAR);
            setState(148);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4611668428353960024L) != 0)) {
              {
                setState(147);
                expressions();
              }
            }

            setState(150);
            match(CPAR);
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
  public static class ExpressionsContext extends ParserRuleContext {
    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(VTLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(VTLParser.COMMA, i);
    }

    public ExpressionsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expressions;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterExpressions(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitExpressions(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitExpressions(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExpressionsContext expressions() throws RecognitionException {
    ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_expressions);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(153);
        expression(0);
        setState(158);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(154);
              match(COMMA);
              setState(155);
              expression(0);
            }
          }
          setState(160);
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
  public static class Set_directiveContext extends ParserRuleContext {
    public TerminalNode SET() {
      return getToken(VTLParser.SET, 0);
    }

    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public TerminalNode ASSIGN() {
      return getToken(VTLParser.ASSIGN, 0);
    }

    public TerminalNode CPAR() {
      return getToken(VTLParser.CPAR, 0);
    }

    public Set_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_set_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterSet_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitSet_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitSet_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Set_directiveContext set_directive() throws RecognitionException {
    Set_directiveContext _localctx = new Set_directiveContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_set_directive);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(161);
        match(SET);
        setState(162);
        expression(0);
        setState(163);
        match(ASSIGN);
        setState(164);
        expression(0);
        setState(165);
        match(CPAR);
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
  public static class If_directiveContext extends ParserRuleContext {
    public TerminalNode IF() {
      return getToken(VTLParser.IF, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode CPAR() {
      return getToken(VTLParser.CPAR, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public EndContext end() {
      return getRuleContext(EndContext.class, 0);
    }

    public List<Elseif_directiveContext> elseif_directive() {
      return getRuleContexts(Elseif_directiveContext.class);
    }

    public Elseif_directiveContext elseif_directive(int i) {
      return getRuleContext(Elseif_directiveContext.class, i);
    }

    public Else_directiveContext else_directive() {
      return getRuleContext(Else_directiveContext.class, 0);
    }

    public If_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_if_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterIf_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitIf_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitIf_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final If_directiveContext if_directive() throws RecognitionException {
    If_directiveContext _localctx = new If_directiveContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_if_directive);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(167);
        match(IF);
        setState(168);
        expression(0);
        setState(169);
        match(CPAR);
        setState(170);
        block();
        setState(174);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == ELSEIF) {
          {
            {
              setState(171);
              elseif_directive();
            }
          }
          setState(176);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(178);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == ELSE) {
          {
            setState(177);
            else_directive();
          }
        }

        setState(180);
        end();
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
  public static class Elseif_directiveContext extends ParserRuleContext {
    public TerminalNode ELSEIF() {
      return getToken(VTLParser.ELSEIF, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode CPAR() {
      return getToken(VTLParser.CPAR, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public Elseif_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_elseif_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterElseif_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitElseif_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitElseif_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Elseif_directiveContext elseif_directive() throws RecognitionException {
    Elseif_directiveContext _localctx = new Elseif_directiveContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_elseif_directive);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(182);
        match(ELSEIF);
        setState(183);
        expression(0);
        setState(184);
        match(CPAR);
        setState(185);
        block();
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
  public static class Else_directiveContext extends ParserRuleContext {
    public TerminalNode ELSE() {
      return getToken(VTLParser.ELSE, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public Else_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_else_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterElse_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitElse_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitElse_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Else_directiveContext else_directive() throws RecognitionException {
    Else_directiveContext _localctx = new Else_directiveContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_else_directive);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(187);
        match(ELSE);
        setState(188);
        block();
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
  public static class Foreach_directiveContext extends ParserRuleContext {
    public TerminalNode FOREACH() {
      return getToken(VTLParser.FOREACH, 0);
    }

    public VariableContext variable() {
      return getRuleContext(VariableContext.class, 0);
    }

    public TerminalNode K_IN() {
      return getToken(VTLParser.K_IN, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode CPAR() {
      return getToken(VTLParser.CPAR, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public EndContext end() {
      return getRuleContext(EndContext.class, 0);
    }

    public Foreach_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_foreach_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterForeach_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitForeach_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitForeach_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Foreach_directiveContext foreach_directive() throws RecognitionException {
    Foreach_directiveContext _localctx = new Foreach_directiveContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_foreach_directive);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(190);
        match(FOREACH);
        setState(191);
        variable();
        setState(192);
        match(K_IN);
        setState(193);
        expression(0);
        setState(194);
        match(CPAR);
        setState(195);
        block();
        setState(196);
        end();
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
  public static class Break_directiveContext extends ParserRuleContext {
    public TerminalNode BREAK() {
      return getToken(VTLParser.BREAK, 0);
    }

    public Break_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_break_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterBreak_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitBreak_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitBreak_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Break_directiveContext break_directive() throws RecognitionException {
    Break_directiveContext _localctx = new Break_directiveContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_break_directive);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(198);
        match(BREAK);
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
  public static class Stop_directiveContext extends ParserRuleContext {
    public TerminalNode STOP() {
      return getToken(VTLParser.STOP, 0);
    }

    public Stop_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_stop_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterStop_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitStop_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitStop_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Stop_directiveContext stop_directive() throws RecognitionException {
    Stop_directiveContext _localctx = new Stop_directiveContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_stop_directive);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(200);
        match(STOP);
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
  public static class Custom_directiveContext extends ParserRuleContext {
    public TerminalNode ID() {
      return getToken(VTLParser.ID, 0);
    }

    public TerminalNode CPAR() {
      return getToken(VTLParser.CPAR, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public EndContext end() {
      return getRuleContext(EndContext.class, 0);
    }

    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public Custom_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_custom_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterCustom_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitCustom_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitCustom_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Custom_directiveContext custom_directive() throws RecognitionException {
    Custom_directiveContext _localctx = new Custom_directiveContext(_ctx, getState());
    enterRule(_localctx, 34, RULE_custom_directive);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(202);
        match(ID);
        setState(210);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
          case 1:
            {
              setState(206);
              _errHandler.sync(this);
              _la = _input.LA(1);
              while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4611668428353960024L) != 0)) {
                {
                  {
                    setState(203);
                    expression(0);
                  }
                }
                setState(208);
                _errHandler.sync(this);
                _la = _input.LA(1);
              }
              setState(209);
              match(CPAR);
            }
            break;
        }
        setState(215);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 17, _ctx)) {
          case 1:
            {
              setState(212);
              block();
              setState(213);
              end();
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
  public static class Macro_directiveContext extends ParserRuleContext {
    public TerminalNode MACRO() {
      return getToken(VTLParser.MACRO, 0);
    }

    public TerminalNode CPAR() {
      return getToken(VTLParser.CPAR, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public EndContext end() {
      return getRuleContext(EndContext.class, 0);
    }

    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public Macro_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_macro_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterMacro_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitMacro_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitMacro_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Macro_directiveContext macro_directive() throws RecognitionException {
    Macro_directiveContext _localctx = new Macro_directiveContext(_ctx, getState());
    enterRule(_localctx, 36, RULE_macro_directive);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(217);
        match(MACRO);
        setState(221);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4611668428353960024L) != 0)) {
          {
            {
              setState(218);
              expression(0);
            }
          }
          setState(223);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(224);
        match(CPAR);
        setState(225);
        block();
        setState(226);
        end();
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
  public static class Parse_directiveContext extends ParserRuleContext {
    public TerminalNode PARSE() {
      return getToken(VTLParser.PARSE, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode CPAR() {
      return getToken(VTLParser.CPAR, 0);
    }

    public Parse_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_parse_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterParse_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitParse_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitParse_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Parse_directiveContext parse_directive() throws RecognitionException {
    Parse_directiveContext _localctx = new Parse_directiveContext(_ctx, getState());
    enterRule(_localctx, 38, RULE_parse_directive);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(228);
        match(PARSE);
        setState(229);
        expression(0);
        setState(230);
        match(CPAR);
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
  public static class Define_directiveContext extends ParserRuleContext {
    public TerminalNode DEFINE() {
      return getToken(VTLParser.DEFINE, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode CPAR() {
      return getToken(VTLParser.CPAR, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public EndContext end() {
      return getRuleContext(EndContext.class, 0);
    }

    public Define_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_define_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterDefine_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitDefine_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitDefine_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Define_directiveContext define_directive() throws RecognitionException {
    Define_directiveContext _localctx = new Define_directiveContext(_ctx, getState());
    enterRule(_localctx, 40, RULE_define_directive);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(232);
        match(DEFINE);
        setState(233);
        expression(0);
        setState(234);
        match(CPAR);
        setState(235);
        block();
        setState(236);
        end();
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
  public static class Include_directiveContext extends ParserRuleContext {
    public TerminalNode INCLUDE() {
      return getToken(VTLParser.INCLUDE, 0);
    }

    public ExpressionsContext expressions() {
      return getRuleContext(ExpressionsContext.class, 0);
    }

    public TerminalNode CPAR() {
      return getToken(VTLParser.CPAR, 0);
    }

    public Include_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_include_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterInclude_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitInclude_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitInclude_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Include_directiveContext include_directive() throws RecognitionException {
    Include_directiveContext _localctx = new Include_directiveContext(_ctx, getState());
    enterRule(_localctx, 42, RULE_include_directive);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(238);
        match(INCLUDE);
        setState(239);
        expressions();
        setState(240);
        match(CPAR);
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
  public static class Evaluate_directiveContext extends ParserRuleContext {
    public TerminalNode EVALUATE() {
      return getToken(VTLParser.EVALUATE, 0);
    }

    public ExpressionContext expression() {
      return getRuleContext(ExpressionContext.class, 0);
    }

    public TerminalNode CPAR() {
      return getToken(VTLParser.CPAR, 0);
    }

    public Evaluate_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_evaluate_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterEvaluate_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitEvaluate_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitEvaluate_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Evaluate_directiveContext evaluate_directive() throws RecognitionException {
    Evaluate_directiveContext _localctx = new Evaluate_directiveContext(_ctx, getState());
    enterRule(_localctx, 44, RULE_evaluate_directive);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(242);
        match(EVALUATE);
        setState(243);
        expression(0);
        setState(244);
        match(CPAR);
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
  public static class Macro_call_directiveContext extends ParserRuleContext {
    public TerminalNode MACRO_ID() {
      return getToken(VTLParser.MACRO_ID, 0);
    }

    public TerminalNode CPAR() {
      return getToken(VTLParser.CPAR, 0);
    }

    public BlockContext block() {
      return getRuleContext(BlockContext.class, 0);
    }

    public EndContext end() {
      return getRuleContext(EndContext.class, 0);
    }

    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public Macro_call_directiveContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_macro_call_directive;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterMacro_call_directive(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitMacro_call_directive(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitMacro_call_directive(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Macro_call_directiveContext macro_call_directive() throws RecognitionException {
    Macro_call_directiveContext _localctx = new Macro_call_directiveContext(_ctx, getState());
    enterRule(_localctx, 46, RULE_macro_call_directive);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(246);
        match(MACRO_ID);
        setState(250);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4611668428353960024L) != 0)) {
          {
            {
              setState(247);
              expression(0);
            }
          }
          setState(252);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(253);
        match(CPAR);
        setState(254);
        block();
        setState(255);
        end();
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
  public static class EndContext extends ParserRuleContext {
    public TerminalNode END() {
      return getToken(VTLParser.END, 0);
    }

    public EndContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_end;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).enterEnd(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).exitEnd(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitEnd(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EndContext end() throws RecognitionException {
    EndContext _localctx = new EndContext(_ctx, getState());
    enterRule(_localctx, 48, RULE_end);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(257);
        match(END);
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
  public static class ExpressionContext extends ParserRuleContext {
    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public TerminalNode EXCL() {
      return getToken(VTLParser.EXCL, 0);
    }

    public TerminalNode K_NOT() {
      return getToken(VTLParser.K_NOT, 0);
    }

    public TerminalNode SUB() {
      return getToken(VTLParser.SUB, 0);
    }

    public ListContext list() {
      return getRuleContext(ListContext.class, 0);
    }

    public MapContext map() {
      return getRuleContext(MapContext.class, 0);
    }

    public Property_or_methodContext property_or_method() {
      return getRuleContext(Property_or_methodContext.class, 0);
    }

    public VariableContext variable() {
      return getRuleContext(VariableContext.class, 0);
    }

    public IdContext id() {
      return getRuleContext(IdContext.class, 0);
    }

    public TerminalNode STRING() {
      return getToken(VTLParser.STRING, 0);
    }

    public TerminalNode INTEGER() {
      return getToken(VTLParser.INTEGER, 0);
    }

    public TerminalNode FLOAT() {
      return getToken(VTLParser.FLOAT, 0);
    }

    public TerminalNode K_NULL() {
      return getToken(VTLParser.K_NULL, 0);
    }

    public TerminalNode MUL() {
      return getToken(VTLParser.MUL, 0);
    }

    public TerminalNode DIV() {
      return getToken(VTLParser.DIV, 0);
    }

    public TerminalNode MOD() {
      return getToken(VTLParser.MOD, 0);
    }

    public TerminalNode ADD() {
      return getToken(VTLParser.ADD, 0);
    }

    public TerminalNode EQ() {
      return getToken(VTLParser.EQ, 0);
    }

    public TerminalNode NE() {
      return getToken(VTLParser.NE, 0);
    }

    public TerminalNode K_EQ() {
      return getToken(VTLParser.K_EQ, 0);
    }

    public TerminalNode K_NE() {
      return getToken(VTLParser.K_NE, 0);
    }

    public TerminalNode LT() {
      return getToken(VTLParser.LT, 0);
    }

    public TerminalNode LE() {
      return getToken(VTLParser.LE, 0);
    }

    public TerminalNode GT() {
      return getToken(VTLParser.GT, 0);
    }

    public TerminalNode GE() {
      return getToken(VTLParser.GE, 0);
    }

    public TerminalNode K_LT() {
      return getToken(VTLParser.K_LT, 0);
    }

    public TerminalNode K_LE() {
      return getToken(VTLParser.K_LE, 0);
    }

    public TerminalNode K_GT() {
      return getToken(VTLParser.K_GT, 0);
    }

    public TerminalNode K_GE() {
      return getToken(VTLParser.K_GE, 0);
    }

    public TerminalNode AND() {
      return getToken(VTLParser.AND, 0);
    }

    public TerminalNode K_AND() {
      return getToken(VTLParser.K_AND, 0);
    }

    public TerminalNode OR() {
      return getToken(VTLParser.OR, 0);
    }

    public TerminalNode K_OR() {
      return getToken(VTLParser.K_OR, 0);
    }

    public TerminalNode RANGE() {
      return getToken(VTLParser.RANGE, 0);
    }

    public ExpressionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_expression;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterExpression(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitExpression(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitExpression(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ExpressionContext expression() throws RecognitionException {
    return expression(0);
  }

  private ExpressionContext expression(int _p) throws RecognitionException {
    ParserRuleContext _parentctx = _ctx;
    int _parentState = getState();
    ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
    ExpressionContext _prevctx = _localctx;
    int _startState = 50;
    enterRecursionRule(_localctx, 50, RULE_expression, _p);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(273);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 20, _ctx)) {
          case 1:
            {
              setState(260);
              _la = _input.LA(1);
              if (!(_la == EXCL || _la == K_NOT)) {
                _errHandler.recoverInline(this);
              } else {
                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                _errHandler.reportMatch(this);
                consume();
              }
              setState(261);
              expression(18);
            }
            break;
          case 2:
            {
              setState(262);
              match(SUB);
              setState(263);
              expression(17);
            }
            break;
          case 3:
            {
              setState(264);
              list();
            }
            break;
          case 4:
            {
              setState(265);
              map();
            }
            break;
          case 5:
            {
              setState(266);
              property_or_method();
            }
            break;
          case 6:
            {
              setState(267);
              variable();
            }
            break;
          case 7:
            {
              setState(268);
              id();
            }
            break;
          case 8:
            {
              setState(269);
              match(STRING);
            }
            break;
          case 9:
            {
              setState(270);
              match(INTEGER);
            }
            break;
          case 10:
            {
              setState(271);
              match(FLOAT);
            }
            break;
          case 11:
            {
              setState(272);
              match(K_NULL);
            }
            break;
        }
        _ctx.stop = _input.LT(-1);
        setState(298);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 22, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (_parseListeners != null) triggerExitRuleEvent();
            _prevctx = _localctx;
            {
              setState(296);
              _errHandler.sync(this);
              switch (getInterpreter().adaptivePredict(_input, 21, _ctx)) {
                case 1:
                  {
                    _localctx = new ExpressionContext(_parentctx, _parentState);
                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                    setState(275);
                    if (!(precpred(_ctx, 16)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 16)");
                    setState(276);
                    _la = _input.LA(1);
                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0))) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(277);
                    expression(17);
                  }
                  break;
                case 2:
                  {
                    _localctx = new ExpressionContext(_parentctx, _parentState);
                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                    setState(278);
                    if (!(precpred(_ctx, 15)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 15)");
                    setState(279);
                    _la = _input.LA(1);
                    if (!(_la == ADD || _la == SUB)) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(280);
                    expression(16);
                  }
                  break;
                case 3:
                  {
                    _localctx = new ExpressionContext(_parentctx, _parentState);
                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                    setState(281);
                    if (!(precpred(_ctx, 14)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 14)");
                    setState(282);
                    _la = _input.LA(1);
                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 206158479360L) != 0))) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(283);
                    expression(15);
                  }
                  break;
                case 4:
                  {
                    _localctx = new ExpressionContext(_parentctx, _parentState);
                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                    setState(284);
                    if (!(precpred(_ctx, 13)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 13)");
                    setState(285);
                    _la = _input.LA(1);
                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 66437775360L) != 0))) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(286);
                    expression(14);
                  }
                  break;
                case 5:
                  {
                    _localctx = new ExpressionContext(_parentctx, _parentState);
                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                    setState(287);
                    if (!(precpred(_ctx, 12)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 12)");
                    setState(288);
                    _la = _input.LA(1);
                    if (!(_la == AND || _la == K_AND)) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(289);
                    expression(13);
                  }
                  break;
                case 6:
                  {
                    _localctx = new ExpressionContext(_parentctx, _parentState);
                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                    setState(290);
                    if (!(precpred(_ctx, 11)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 11)");
                    setState(291);
                    _la = _input.LA(1);
                    if (!(_la == OR || _la == K_OR)) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                    setState(292);
                    expression(12);
                  }
                  break;
                case 7:
                  {
                    _localctx = new ExpressionContext(_parentctx, _parentState);
                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                    setState(293);
                    if (!(precpred(_ctx, 10)))
                      throw new FailedPredicateException(this, "precpred(_ctx, 10)");
                    setState(294);
                    match(RANGE);
                    setState(295);
                    expression(11);
                  }
                  break;
              }
            }
          }
          setState(300);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 22, _ctx);
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
  public static class ListContext extends ParserRuleContext {
    public TerminalNode OBRACK() {
      return getToken(VTLParser.OBRACK, 0);
    }

    public TerminalNode CBRACK() {
      return getToken(VTLParser.CBRACK, 0);
    }

    public ExpressionsContext expressions() {
      return getRuleContext(ExpressionsContext.class, 0);
    }

    public ListContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_list;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).enterList(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).exitList(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitList(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ListContext list() throws RecognitionException {
    ListContext _localctx = new ListContext(_ctx, getState());
    enterRule(_localctx, 52, RULE_list);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(301);
        match(OBRACK);
        setState(303);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4611668428353960024L) != 0)) {
          {
            setState(302);
            expressions();
          }
        }

        setState(305);
        match(CBRACK);
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
  public static class MapContext extends ParserRuleContext {
    public TerminalNode OBRACE() {
      return getToken(VTLParser.OBRACE, 0);
    }

    public TerminalNode CBRACE() {
      return getToken(VTLParser.CBRACE, 0);
    }

    public Map_entriesContext map_entries() {
      return getRuleContext(Map_entriesContext.class, 0);
    }

    public MapContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_map;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).enterMap(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).exitMap(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitMap(this);
      else return visitor.visitChildren(this);
    }
  }

  public final MapContext map() throws RecognitionException {
    MapContext _localctx = new MapContext(_ctx, getState());
    enterRule(_localctx, 54, RULE_map);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(307);
        match(OBRACE);
        setState(309);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4611668428353960024L) != 0)) {
          {
            setState(308);
            map_entries();
          }
        }

        setState(311);
        match(CBRACE);
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
  public static class Map_entriesContext extends ParserRuleContext {
    public List<Map_entryContext> map_entry() {
      return getRuleContexts(Map_entryContext.class);
    }

    public Map_entryContext map_entry(int i) {
      return getRuleContext(Map_entryContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(VTLParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(VTLParser.COMMA, i);
    }

    public Map_entriesContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_map_entries;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterMap_entries(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).exitMap_entries(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitMap_entries(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Map_entriesContext map_entries() throws RecognitionException {
    Map_entriesContext _localctx = new Map_entriesContext(_ctx, getState());
    enterRule(_localctx, 56, RULE_map_entries);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(313);
        map_entry();
        setState(318);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(314);
              match(COMMA);
              setState(315);
              map_entry();
            }
          }
          setState(320);
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
  public static class Map_entryContext extends ParserRuleContext {
    public List<ExpressionContext> expression() {
      return getRuleContexts(ExpressionContext.class);
    }

    public ExpressionContext expression(int i) {
      return getRuleContext(ExpressionContext.class, i);
    }

    public TerminalNode COLON() {
      return getToken(VTLParser.COLON, 0);
    }

    public Map_entryContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_map_entry;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener)
        ((VTLParserListener) listener).enterMap_entry(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).exitMap_entry(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitMap_entry(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Map_entryContext map_entry() throws RecognitionException {
    Map_entryContext _localctx = new Map_entryContext(_ctx, getState());
    enterRule(_localctx, 58, RULE_map_entry);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(321);
        expression(0);
        setState(322);
        match(COLON);
        setState(323);
        expression(0);
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
  public static class IdContext extends ParserRuleContext {
    public TerminalNode ID() {
      return getToken(VTLParser.ID, 0);
    }

    public TerminalNode K_LT() {
      return getToken(VTLParser.K_LT, 0);
    }

    public TerminalNode K_LE() {
      return getToken(VTLParser.K_LE, 0);
    }

    public TerminalNode K_GT() {
      return getToken(VTLParser.K_GT, 0);
    }

    public TerminalNode K_GE() {
      return getToken(VTLParser.K_GE, 0);
    }

    public TerminalNode K_EQ() {
      return getToken(VTLParser.K_EQ, 0);
    }

    public TerminalNode K_NE() {
      return getToken(VTLParser.K_NE, 0);
    }

    public TerminalNode K_TRUE() {
      return getToken(VTLParser.K_TRUE, 0);
    }

    public TerminalNode K_FALSE() {
      return getToken(VTLParser.K_FALSE, 0);
    }

    public TerminalNode K_AND() {
      return getToken(VTLParser.K_AND, 0);
    }

    public TerminalNode K_OR() {
      return getToken(VTLParser.K_OR, 0);
    }

    public TerminalNode K_NOT() {
      return getToken(VTLParser.K_NOT, 0);
    }

    public TerminalNode K_NULL() {
      return getToken(VTLParser.K_NULL, 0);
    }

    public TerminalNode K_IN() {
      return getToken(VTLParser.K_IN, 0);
    }

    public IdContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_id;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).enterId(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof VTLParserListener) ((VTLParserListener) listener).exitId(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof VTLParserVisitor)
        return ((VTLParserVisitor<? extends T>) visitor).visitId(this);
      else return visitor.visitChildren(this);
    }
  }

  public final IdContext id() throws RecognitionException {
    IdContext _localctx = new IdContext(_ctx, getState());
    enterRule(_localctx, 60, RULE_id);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(325);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 17587891339776L) != 0))) {
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

  public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
    switch (ruleIndex) {
      case 25:
        return expression_sempred((ExpressionContext) _localctx, predIndex);
    }
    return true;
  }

  private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
    switch (predIndex) {
      case 0:
        return precpred(_ctx, 16);
      case 1:
        return precpred(_ctx, 15);
      case 2:
        return precpred(_ctx, 14);
      case 3:
        return precpred(_ctx, 13);
      case 4:
        return precpred(_ctx, 12);
      case 5:
        return precpred(_ctx, 11);
      case 6:
        return precpred(_ctx, 10);
    }
    return true;
  }

  public static final String _serializedATN =
      "\u0004\u0001k\u0148\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
          + "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"
          + "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"
          + "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"
          + "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"
          + "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"
          + "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"
          + "\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"
          + "\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"
          + "\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"
          + "\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001C\b\u0001"
          + "\n\u0001\f\u0001F\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"
          + "\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002O\b\u0002\u0001\u0003"
          + "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"
          + "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"
          + "\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003a\b\u0003\u0001\u0004"
          + "\u0001\u0004\u0001\u0004\u0003\u0004f\b\u0004\u0001\u0004\u0001\u0004"
          + "\u0001\u0004\u0003\u0004k\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004"
          + "o\b\u0004\u0003\u0004q\b\u0004\u0001\u0005\u0001\u0005\u0004\u0005u\b"
          + "\u0005\u000b\u0005\f\u0005v\u0001\u0006\u0001\u0006\u0004\u0006{\b\u0006"
          + "\u000b\u0006\f\u0006|\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"
          + "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"
          + "\u0001\u0007\u0001\u0007\u0003\u0007\u008b\b\u0007\u0001\b\u0001\b\u0001"
          + "\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0095\b\b\u0001\b\u0003"
          + "\b\u0098\b\b\u0001\t\u0001\t\u0001\t\u0005\t\u009d\b\t\n\t\f\t\u00a0\t"
          + "\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"
          + "\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00ad\b\u000b\n\u000b"
          + "\f\u000b\u00b0\t\u000b\u0001\u000b\u0003\u000b\u00b3\b\u000b\u0001\u000b"
          + "\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"
          + "\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"
          + "\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"
          + "\u0001\u0011\u0001\u0011\u0005\u0011\u00cd\b\u0011\n\u0011\f\u0011\u00d0"
          + "\t\u0011\u0001\u0011\u0003\u0011\u00d3\b\u0011\u0001\u0011\u0001\u0011"
          + "\u0001\u0011\u0003\u0011\u00d8\b\u0011\u0001\u0012\u0001\u0012\u0005\u0012"
          + "\u00dc\b\u0012\n\u0012\f\u0012\u00df\t\u0012\u0001\u0012\u0001\u0012\u0001"
          + "\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"
          + "\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"
          + "\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"
          + "\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0005\u0017\u00f9\b\u0017\n"
          + "\u0017\f\u0017\u00fc\t\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"
          + "\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"
          + "\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"
          + "\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0112"
          + "\b\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"
          + "\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"
          + "\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"
          + "\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0129\b\u0019\n"
          + "\u0019\f\u0019\u012c\t\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u0130"
          + "\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0003\u001b\u0136"
          + "\b\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0005"
          + "\u001c\u013d\b\u001c\n\u001c\f\u001c\u0140\t\u001c\u0001\u001d\u0001\u001d"
          + "\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0000\u0001"
          + "2\u001f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"
          + "\u001a\u001c\u001e \"$&(*,.02468:<\u0000\b\u0002\u0000\u001f\u001f**\u0001"
          + "\u0000\u0015\u0017\u0001\u0000\u0013\u0014\u0002\u0000\u000e\u000f$%\u0002"
          + "\u0000\u001b\u001e #\u0002\u0000\u0010\u0010((\u0002\u0000\u0011\u0011"
          + "))\u0003\u0000\t\t\u0012\u0012 +\u0163\u0000>\u0001\u0000\u0000\u0000"
          + "\u0002D\u0001\u0000\u0000\u0000\u0004N\u0001\u0000\u0000\u0000\u0006`"
          + "\u0001\u0000\u0000\u0000\bp\u0001\u0000\u0000\u0000\nr\u0001\u0000\u0000"
          + "\u0000\fx\u0001\u0000\u0000\u0000\u000e\u008a\u0001\u0000\u0000\u0000"
          + "\u0010\u0097\u0001\u0000\u0000\u0000\u0012\u0099\u0001\u0000\u0000\u0000"
          + "\u0014\u00a1\u0001\u0000\u0000\u0000\u0016\u00a7\u0001\u0000\u0000\u0000"
          + "\u0018\u00b6\u0001\u0000\u0000\u0000\u001a\u00bb\u0001\u0000\u0000\u0000"
          + "\u001c\u00be\u0001\u0000\u0000\u0000\u001e\u00c6\u0001\u0000\u0000\u0000"
          + " \u00c8\u0001\u0000\u0000\u0000\"\u00ca\u0001\u0000\u0000\u0000$\u00d9"
          + "\u0001\u0000\u0000\u0000&\u00e4\u0001\u0000\u0000\u0000(\u00e8\u0001\u0000"
          + "\u0000\u0000*\u00ee\u0001\u0000\u0000\u0000,\u00f2\u0001\u0000\u0000\u0000"
          + ".\u00f6\u0001\u0000\u0000\u00000\u0101\u0001\u0000\u0000\u00002\u0111"
          + "\u0001\u0000\u0000\u00004\u012d\u0001\u0000\u0000\u00006\u0133\u0001\u0000"
          + "\u0000\u00008\u0139\u0001\u0000\u0000\u0000:\u0141\u0001\u0000\u0000\u0000"
          + "<\u0145\u0001\u0000\u0000\u0000>?\u0003\u0002\u0001\u0000?@\u0005\u0000"
          + "\u0000\u0001@\u0001\u0001\u0000\u0000\u0000AC\u0003\u0004\u0002\u0000"
          + "BA\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000"
          + "\u0000DE\u0001\u0000\u0000\u0000E\u0003\u0001\u0000\u0000\u0000FD\u0001"
          + "\u0000\u0000\u0000GO\u0005@\u0000\u0000HO\u0005:\u0000\u0000IO\u0005A"
          + "\u0000\u0000JO\u0003\b\u0004\u0000KO\u0003\u0006\u0003\u0000LO\u0003\n"
          + "\u0005\u0000MO\u0003\u000e\u0007\u0000NG\u0001\u0000\u0000\u0000NH\u0001"
          + "\u0000\u0000\u0000NI\u0001\u0000\u0000\u0000NJ\u0001\u0000\u0000\u0000"
          + "NK\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000"
          + "\u0000O\u0005\u0001\u0000\u0000\u0000PQ\u0005=\u0000\u0000QR\u0003\f\u0006"
          + "\u0000RS\u0005\u0006\u0000\u0000Sa\u0001\u0000\u0000\u0000TU\u0005<\u0000"
          + "\u0000UV\u0003\f\u0006\u0000VW\u0005\u0006\u0000\u0000Wa\u0001\u0000\u0000"
          + "\u0000XY\u0005=\u0000\u0000YZ\u0003<\u001e\u0000Z[\u0005\u0006\u0000\u0000"
          + "[a\u0001\u0000\u0000\u0000\\]\u0005<\u0000\u0000]^\u0003<\u001e\u0000"
          + "^_\u0005\u0006\u0000\u0000_a\u0001\u0000\u0000\u0000`P\u0001\u0000\u0000"
          + "\u0000`T\u0001\u0000\u0000\u0000`X\u0001\u0000\u0000\u0000`\\\u0001\u0000"
          + "\u0000\u0000a\u0007\u0001\u0000\u0000\u0000bc\u0005?\u0000\u0000ce\u0003"
          + "<\u001e\u0000df\u0005\u000b\u0000\u0000ed\u0001\u0000\u0000\u0000ef\u0001"
          + "\u0000\u0000\u0000fq\u0001\u0000\u0000\u0000gh\u0005>\u0000\u0000hj\u0003"
          + "<\u001e\u0000ik\u0005\u000b\u0000\u0000ji\u0001\u0000\u0000\u0000jk\u0001"
          + "\u0000\u0000\u0000kq\u0001\u0000\u0000\u0000ln\u0005\n\u0000\u0000mo\u0005"
          + "\u000b\u0000\u0000nm\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"
          + "oq\u0001\u0000\u0000\u0000pb\u0001\u0000\u0000\u0000pg\u0001\u0000\u0000"
          + "\u0000pl\u0001\u0000\u0000\u0000q\t\u0001\u0000\u0000\u0000rt\u0003\b"
          + "\u0004\u0000su\u0003\u0010\b\u0000ts\u0001\u0000\u0000\u0000uv\u0001\u0000"
          + "\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000w\u000b"
          + "\u0001\u0000\u0000\u0000xz\u0003<\u001e\u0000y{\u0003\u0010\b\u0000zy"
          + "\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000"
          + "\u0000|}\u0001\u0000\u0000\u0000}\r\u0001\u0000\u0000\u0000~\u008b\u0003"
          + "\u0014\n\u0000\u007f\u008b\u0003\u0016\u000b\u0000\u0080\u008b\u0003\u001c"
          + "\u000e\u0000\u0081\u008b\u0003\u001e\u000f\u0000\u0082\u008b\u0003 \u0010"
          + "\u0000\u0083\u008b\u0003$\u0012\u0000\u0084\u008b\u0003&\u0013\u0000\u0085"
          + "\u008b\u0003(\u0014\u0000\u0086\u008b\u0003*\u0015\u0000\u0087\u008b\u0003"
          + ",\u0016\u0000\u0088\u008b\u0003.\u0017\u0000\u0089\u008b\u0003\"\u0011"
          + "\u0000\u008a~\u0001\u0000\u0000\u0000\u008a\u007f\u0001\u0000\u0000\u0000"
          + "\u008a\u0080\u0001\u0000\u0000\u0000\u008a\u0081\u0001\u0000\u0000\u0000"
          + "\u008a\u0082\u0001\u0000\u0000\u0000\u008a\u0083\u0001\u0000\u0000\u0000"
          + "\u008a\u0084\u0001\u0000\u0000\u0000\u008a\u0085\u0001\u0000\u0000\u0000"
          + "\u008a\u0086\u0001\u0000\u0000\u0000\u008a\u0087\u0001\u0000\u0000\u0000"
          + "\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u0089\u0001\u0000\u0000\u0000"
          + "\u008b\u000f\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u000b\u0000\u0000"
          + "\u008d\u0098\u0005\t\u0000\u0000\u008e\u008f\u0005\u0003\u0000\u0000\u008f"
          + "\u0090\u00032\u0019\u0000\u0090\u0091\u0005\u0004\u0000\u0000\u0091\u0098"
          + "\u0001\u0000\u0000\u0000\u0092\u0094\u0005\u0001\u0000\u0000\u0093\u0095"
          + "\u0003\u0012\t\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001"
          + "\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0098\u0005"
          + "\u0002\u0000\u0000\u0097\u008c\u0001\u0000\u0000\u0000\u0097\u008e\u0001"
          + "\u0000\u0000\u0000\u0097\u0092\u0001\u0000\u0000\u0000\u0098\u0011\u0001"
          + "\u0000\u0000\u0000\u0099\u009e\u00032\u0019\u0000\u009a\u009b\u0005\f"
          + "\u0000\u0000\u009b\u009d\u00032\u0019\u0000\u009c\u009a\u0001\u0000\u0000"
          + "\u0000\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000"
          + "\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u0013\u0001\u0000\u0000"
          + "\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a2\u00050\u0000\u0000"
          + "\u00a2\u00a3\u00032\u0019\u0000\u00a3\u00a4\u0005\r\u0000\u0000\u00a4"
          + "\u00a5\u00032\u0019\u0000\u00a5\u00a6\u0005\u0002\u0000\u0000\u00a6\u0015"
          + "\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005,\u0000\u0000\u00a8\u00a9\u0003"
          + "2\u0019\u0000\u00a9\u00aa\u0005\u0002\u0000\u0000\u00aa\u00ae\u0003\u0002"
          + "\u0001\u0000\u00ab\u00ad\u0003\u0018\f\u0000\u00ac\u00ab\u0001\u0000\u0000"
          + "\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000"
          + "\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000"
          + "\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b3\u0003\u001a\r\u0000"
          + "\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000"
          + "\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5\u00030\u0018\u0000\u00b5"
          + "\u0017\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005-\u0000\u0000\u00b7\u00b8"
          + "\u00032\u0019\u0000\u00b8\u00b9\u0005\u0002\u0000\u0000\u00b9\u00ba\u0003"
          + "\u0002\u0001\u0000\u00ba\u0019\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005"
          + ".\u0000\u0000\u00bc\u00bd\u0003\u0002\u0001\u0000\u00bd\u001b\u0001\u0000"
          + "\u0000\u0000\u00be\u00bf\u0005/\u0000\u0000\u00bf\u00c0\u0003\b\u0004"
          + "\u0000\u00c0\u00c1\u0005+\u0000\u0000\u00c1\u00c2\u00032\u0019\u0000\u00c2"
          + "\u00c3\u0005\u0002\u0000\u0000\u00c3\u00c4\u0003\u0002\u0001\u0000\u00c4"
          + "\u00c5\u00030\u0018\u0000\u00c5\u001d\u0001\u0000\u0000\u0000\u00c6\u00c7"
          + "\u00052\u0000\u0000\u00c7\u001f\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005"
          + "5\u0000\u0000\u00c9!\u0001\u0000\u0000\u0000\u00ca\u00d2\u0005\t\u0000"
          + "\u0000\u00cb\u00cd\u00032\u0019\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000"
          + "\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000"
          + "\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d1\u0001\u0000\u0000\u0000"
          + "\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d3\u0005\u0002\u0000\u0000"
          + "\u00d2\u00ce\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000"
          + "\u00d3\u00d7\u0001\u0000\u0000\u0000\u00d4\u00d5\u0003\u0002\u0001\u0000"
          + "\u00d5\u00d6\u00030\u0018\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7"
          + "\u00d4\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8"
          + "#\u0001\u0000\u0000\u0000\u00d9\u00dd\u00054\u0000\u0000\u00da\u00dc\u0003"
          + "2\u0019\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc\u00df\u0001\u0000"
          + "\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000"
          + "\u0000\u0000\u00de\u00e0\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000"
          + "\u0000\u0000\u00e0\u00e1\u0005\u0002\u0000\u0000\u00e1\u00e2\u0003\u0002"
          + "\u0001\u0000\u00e2\u00e3\u00030\u0018\u0000\u00e3%\u0001\u0000\u0000\u0000"
          + "\u00e4\u00e5\u00058\u0000\u0000\u00e5\u00e6\u00032\u0019\u0000\u00e6\u00e7"
          + "\u0005\u0002\u0000\u0000\u00e7\'\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005"
          + "9\u0000\u0000\u00e9\u00ea\u00032\u0019\u0000\u00ea\u00eb\u0005\u0002\u0000"
          + "\u0000\u00eb\u00ec\u0003\u0002\u0001\u0000\u00ec\u00ed\u00030\u0018\u0000"
          + "\u00ed)\u0001\u0000\u0000\u0000\u00ee\u00ef\u00056\u0000\u0000\u00ef\u00f0"
          + "\u0003\u0012\t\u0000\u00f0\u00f1\u0005\u0002\u0000\u0000\u00f1+\u0001"
          + "\u0000\u0000\u0000\u00f2\u00f3\u00057\u0000\u0000\u00f3\u00f4\u00032\u0019"
          + "\u0000\u00f4\u00f5\u0005\u0002\u0000\u0000\u00f5-\u0001\u0000\u0000\u0000"
          + "\u00f6\u00fa\u00053\u0000\u0000\u00f7\u00f9\u00032\u0019\u0000\u00f8\u00f7"
          + "\u0001\u0000\u0000\u0000\u00f9\u00fc\u0001\u0000\u0000\u0000\u00fa\u00f8"
          + "\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fd"
          + "\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fd\u00fe"
          + "\u0005\u0002\u0000\u0000\u00fe\u00ff\u0003\u0002\u0001\u0000\u00ff\u0100"
          + "\u00030\u0018\u0000\u0100/\u0001\u0000\u0000\u0000\u0101\u0102\u00051"
          + "\u0000\u0000\u01021\u0001\u0000\u0000\u0000\u0103\u0104\u0006\u0019\uffff"
          + "\uffff\u0000\u0104\u0105\u0007\u0000\u0000\u0000\u0105\u0112\u00032\u0019"
          + "\u0012\u0106\u0107\u0005\u0014\u0000\u0000\u0107\u0112\u00032\u0019\u0011"
          + "\u0108\u0112\u00034\u001a\u0000\u0109\u0112\u00036\u001b\u0000\u010a\u0112"
          + "\u0003\n\u0005\u0000\u010b\u0112\u0003\b\u0004\u0000\u010c\u0112\u0003"
          + "<\u001e\u0000\u010d\u0112\u0005\u0007\u0000\u0000\u010e\u0112\u0005\b"
          + "\u0000\u0000\u010f\u0112\u0005\u0019\u0000\u0000\u0110\u0112\u0005\u0012"
          + "\u0000\u0000\u0111\u0103\u0001\u0000\u0000\u0000\u0111\u0106\u0001\u0000"
          + "\u0000\u0000\u0111\u0108\u0001\u0000\u0000\u0000\u0111\u0109\u0001\u0000"
          + "\u0000\u0000\u0111\u010a\u0001\u0000\u0000\u0000\u0111\u010b\u0001\u0000"
          + "\u0000\u0000\u0111\u010c\u0001\u0000\u0000\u0000\u0111\u010d\u0001\u0000"
          + "\u0000\u0000\u0111\u010e\u0001\u0000\u0000\u0000\u0111\u010f\u0001\u0000"
          + "\u0000\u0000\u0111\u0110\u0001\u0000\u0000\u0000\u0112\u012a\u0001\u0000"
          + "\u0000\u0000\u0113\u0114\n\u0010\u0000\u0000\u0114\u0115\u0007\u0001\u0000"
          + "\u0000\u0115\u0129\u00032\u0019\u0011\u0116\u0117\n\u000f\u0000\u0000"
          + "\u0117\u0118\u0007\u0002\u0000\u0000\u0118\u0129\u00032\u0019\u0010\u0119"
          + "\u011a\n\u000e\u0000\u0000\u011a\u011b\u0007\u0003\u0000\u0000\u011b\u0129"
          + "\u00032\u0019\u000f\u011c\u011d\n\r\u0000\u0000\u011d\u011e\u0007\u0004"
          + "\u0000\u0000\u011e\u0129\u00032\u0019\u000e\u011f\u0120\n\f\u0000\u0000"
          + "\u0120\u0121\u0007\u0005\u0000\u0000\u0121\u0129\u00032\u0019\r\u0122"
          + "\u0123\n\u000b\u0000\u0000\u0123\u0124\u0007\u0006\u0000\u0000\u0124\u0129"
          + "\u00032\u0019\f\u0125\u0126\n\n\u0000\u0000\u0126\u0127\u0005\u001a\u0000"
          + "\u0000\u0127\u0129\u00032\u0019\u000b\u0128\u0113\u0001\u0000\u0000\u0000"
          + "\u0128\u0116\u0001\u0000\u0000\u0000\u0128\u0119\u0001\u0000\u0000\u0000"
          + "\u0128\u011c\u0001\u0000\u0000\u0000\u0128\u011f\u0001\u0000\u0000\u0000"
          + "\u0128\u0122\u0001\u0000\u0000\u0000\u0128\u0125\u0001\u0000\u0000\u0000"
          + "\u0129\u012c\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000"
          + "\u012a\u012b\u0001\u0000\u0000\u0000\u012b3\u0001\u0000\u0000\u0000\u012c"
          + "\u012a\u0001\u0000\u0000\u0000\u012d\u012f\u0005\u0003\u0000\u0000\u012e"
          + "\u0130\u0003\u0012\t\u0000\u012f\u012e\u0001\u0000\u0000\u0000\u012f\u0130"
          + "\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132"
          + "\u0005\u0004\u0000\u0000\u01325\u0001\u0000\u0000\u0000\u0133\u0135\u0005"
          + "\u0005\u0000\u0000\u0134\u0136\u00038\u001c\u0000\u0135\u0134\u0001\u0000"
          + "\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000"
          + "\u0000\u0000\u0137\u0138\u0005\u0006\u0000\u0000\u01387\u0001\u0000\u0000"
          + "\u0000\u0139\u013e\u0003:\u001d\u0000\u013a\u013b\u0005\f\u0000\u0000"
          + "\u013b\u013d\u0003:\u001d\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013d"
          + "\u0140\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e"
          + "\u013f\u0001\u0000\u0000\u0000\u013f9\u0001\u0000\u0000\u0000\u0140\u013e"
          + "\u0001\u0000\u0000\u0000\u0141\u0142\u00032\u0019\u0000\u0142\u0143\u0005"
          + "\u0018\u0000\u0000\u0143\u0144\u00032\u0019\u0000\u0144;\u0001\u0000\u0000"
          + "\u0000\u0145\u0146\u0007\u0007\u0000\u0000\u0146=\u0001\u0000\u0000\u0000"
          + "\u001aDN`ejnpv|\u008a\u0094\u0097\u009e\u00ae\u00b2\u00ce\u00d2\u00d7"
          + "\u00dd\u00fa\u0111\u0128\u012a\u012f\u0135\u013e";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
