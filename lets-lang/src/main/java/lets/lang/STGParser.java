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
public class STGParser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int DOC_COMMENT = 1,
      BLOCK_COMMENT = 2,
      LINE_COMMENT = 3,
      TMPL_COMMENT = 4,
      HORZ_WS = 5,
      VERT_WS = 6,
      ID = 7,
      STRING = 8,
      BIGSTRING = 9,
      BIGSTRING_NO_NL = 10,
      ANON_TEMPLATE = 11,
      TMPL_ASSIGN = 12,
      ASSIGN = 13,
      DOT = 14,
      COMMA = 15,
      COLON = 16,
      LPAREN = 17,
      RPAREN = 18,
      LBRACK = 19,
      RBRACK = 20,
      AT = 21,
      TRUE = 22,
      FALSE = 23,
      ELLIPSIS = 24,
      DELIMITERS = 25,
      IMPORT = 26,
      DEFAULT = 27,
      KEY = 28,
      VALUE = 29,
      FIRST = 30,
      LAST = 31,
      REST = 32,
      TRUNC = 33,
      STRIP = 34,
      TRIM = 35,
      LENGTH = 36,
      STRLEN = 37,
      REVERSE = 38,
      GROUP = 39,
      WRAP = 40,
      ANCHOR = 41,
      SEPARATOR = 42;
  public static final int RULE_group = 0,
      RULE_delimiters = 1,
      RULE_imports = 2,
      RULE_template_ = 3,
      RULE_formalArgs = 4,
      RULE_formalArg = 5,
      RULE_dict_ = 6,
      RULE_dictPairs = 7,
      RULE_keyValuePair = 8,
      RULE_defaultValuePair = 9,
      RULE_keyValue = 10;

  private static String[] makeRuleNames() {
    return new String[] {
      "group",
      "delimiters",
      "imports",
      "template_",
      "formalArgs",
      "formalArg",
      "dict_",
      "dictPairs",
      "keyValuePair",
      "defaultValuePair",
      "keyValue"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      "'delimiters'",
      "'import'",
      "'default'",
      "'key'",
      "'value'",
      "'first'",
      "'last'",
      "'rest'",
      "'trunc'",
      "'strip'",
      "'trim'",
      "'length'",
      "'strlen'",
      "'reverse'",
      "'group'",
      "'wrap'",
      "'anchor'",
      "'separator'"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      "DOC_COMMENT",
      "BLOCK_COMMENT",
      "LINE_COMMENT",
      "TMPL_COMMENT",
      "HORZ_WS",
      "VERT_WS",
      "ID",
      "STRING",
      "BIGSTRING",
      "BIGSTRING_NO_NL",
      "ANON_TEMPLATE",
      "TMPL_ASSIGN",
      "ASSIGN",
      "DOT",
      "COMMA",
      "COLON",
      "LPAREN",
      "RPAREN",
      "LBRACK",
      "RBRACK",
      "AT",
      "TRUE",
      "FALSE",
      "ELLIPSIS",
      "DELIMITERS",
      "IMPORT",
      "DEFAULT",
      "KEY",
      "VALUE",
      "FIRST",
      "LAST",
      "REST",
      "TRUNC",
      "STRIP",
      "TRIM",
      "LENGTH",
      "STRLEN",
      "REVERSE",
      "GROUP",
      "WRAP",
      "ANCHOR",
      "SEPARATOR"
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
    return "STGParser.g4";
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

  public STGParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class GroupContext extends ParserRuleContext {
    public TerminalNode EOF() {
      return getToken(STGParser.EOF, 0);
    }

    public DelimitersContext delimiters() {
      return getRuleContext(DelimitersContext.class, 0);
    }

    public ImportsContext imports() {
      return getRuleContext(ImportsContext.class, 0);
    }

    public List<Template_Context> template_() {
      return getRuleContexts(Template_Context.class);
    }

    public Template_Context template_(int i) {
      return getRuleContext(Template_Context.class, i);
    }

    public List<Dict_Context> dict_() {
      return getRuleContexts(Dict_Context.class);
    }

    public Dict_Context dict_(int i) {
      return getRuleContext(Dict_Context.class, i);
    }

    public GroupContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_group;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener) ((STGParserListener) listener).enterGroup(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener) ((STGParserListener) listener).exitGroup(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof STGParserVisitor)
        return ((STGParserVisitor<? extends T>) visitor).visitGroup(this);
      else return visitor.visitChildren(this);
    }
  }

  public final GroupContext group() throws RecognitionException {
    GroupContext _localctx = new GroupContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_group);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(23);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == DELIMITERS) {
          {
            setState(22);
            delimiters();
          }
        }

        setState(26);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == IMPORT) {
          {
            setState(25);
            imports();
          }
        }

        setState(30);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            setState(30);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
              case 1:
                {
                  setState(28);
                  template_();
                }
                break;
              case 2:
                {
                  setState(29);
                  dict_();
                }
                break;
            }
          }
          setState(32);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while (_la == ID || _la == AT);
        setState(34);
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
  public static class DelimitersContext extends ParserRuleContext {
    public TerminalNode DELIMITERS() {
      return getToken(STGParser.DELIMITERS, 0);
    }

    public List<TerminalNode> STRING() {
      return getTokens(STGParser.STRING);
    }

    public TerminalNode STRING(int i) {
      return getToken(STGParser.STRING, i);
    }

    public TerminalNode COMMA() {
      return getToken(STGParser.COMMA, 0);
    }

    public DelimitersContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_delimiters;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener)
        ((STGParserListener) listener).enterDelimiters(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener)
        ((STGParserListener) listener).exitDelimiters(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof STGParserVisitor)
        return ((STGParserVisitor<? extends T>) visitor).visitDelimiters(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DelimitersContext delimiters() throws RecognitionException {
    DelimitersContext _localctx = new DelimitersContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_delimiters);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(36);
        match(DELIMITERS);
        setState(37);
        match(STRING);
        setState(38);
        match(COMMA);
        setState(39);
        match(STRING);
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
  public static class ImportsContext extends ParserRuleContext {
    public List<TerminalNode> IMPORT() {
      return getTokens(STGParser.IMPORT);
    }

    public TerminalNode IMPORT(int i) {
      return getToken(STGParser.IMPORT, i);
    }

    public List<TerminalNode> STRING() {
      return getTokens(STGParser.STRING);
    }

    public TerminalNode STRING(int i) {
      return getToken(STGParser.STRING, i);
    }

    public ImportsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_imports;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener) ((STGParserListener) listener).enterImports(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener) ((STGParserListener) listener).exitImports(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof STGParserVisitor)
        return ((STGParserVisitor<? extends T>) visitor).visitImports(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ImportsContext imports() throws RecognitionException {
    ImportsContext _localctx = new ImportsContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_imports);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(43);
        _errHandler.sync(this);
        _la = _input.LA(1);
        do {
          {
            {
              setState(41);
              match(IMPORT);
              setState(42);
              match(STRING);
            }
          }
          setState(45);
          _errHandler.sync(this);
          _la = _input.LA(1);
        } while (_la == IMPORT);
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
  public static class Template_Context extends ParserRuleContext {
    public TerminalNode TMPL_ASSIGN() {
      return getToken(STGParser.TMPL_ASSIGN, 0);
    }

    public TerminalNode STRING() {
      return getToken(STGParser.STRING, 0);
    }

    public TerminalNode BIGSTRING() {
      return getToken(STGParser.BIGSTRING, 0);
    }

    public TerminalNode BIGSTRING_NO_NL() {
      return getToken(STGParser.BIGSTRING_NO_NL, 0);
    }

    public TerminalNode AT() {
      return getToken(STGParser.AT, 0);
    }

    public List<TerminalNode> ID() {
      return getTokens(STGParser.ID);
    }

    public TerminalNode ID(int i) {
      return getToken(STGParser.ID, i);
    }

    public TerminalNode DOT() {
      return getToken(STGParser.DOT, 0);
    }

    public TerminalNode LPAREN() {
      return getToken(STGParser.LPAREN, 0);
    }

    public TerminalNode RPAREN() {
      return getToken(STGParser.RPAREN, 0);
    }

    public FormalArgsContext formalArgs() {
      return getRuleContext(FormalArgsContext.class, 0);
    }

    public Template_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_template_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener)
        ((STGParserListener) listener).enterTemplate_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener) ((STGParserListener) listener).exitTemplate_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof STGParserVisitor)
        return ((STGParserVisitor<? extends T>) visitor).visitTemplate_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Template_Context template_() throws RecognitionException {
    Template_Context _localctx = new Template_Context(_ctx, getState());
    enterRule(_localctx, 6, RULE_template_);
    int _la;
    try {
      setState(66);
      _errHandler.sync(this);
      switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
        case 1:
          enterOuterAlt(_localctx, 1);
          {
            setState(59);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
              case AT:
                {
                  setState(47);
                  match(AT);
                  setState(48);
                  match(ID);
                  setState(49);
                  match(DOT);
                  setState(50);
                  match(ID);
                  setState(51);
                  match(LPAREN);
                  setState(52);
                  match(RPAREN);
                }
                break;
              case ID:
                {
                  setState(53);
                  match(ID);
                  setState(54);
                  match(LPAREN);
                  setState(56);
                  _errHandler.sync(this);
                  _la = _input.LA(1);
                  if (_la == ID) {
                    {
                      setState(55);
                      formalArgs();
                    }
                  }

                  setState(58);
                  match(RPAREN);
                }
                break;
              default:
                throw new NoViableAltException(this);
            }
            setState(61);
            match(TMPL_ASSIGN);
            setState(62);
            _la = _input.LA(1);
            if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0))) {
              _errHandler.recoverInline(this);
            } else {
              if (_input.LA(1) == Token.EOF) matchedEOF = true;
              _errHandler.reportMatch(this);
              consume();
            }
          }
          break;
        case 2:
          enterOuterAlt(_localctx, 2);
          {
            setState(63);
            match(ID);
            setState(64);
            match(TMPL_ASSIGN);
            setState(65);
            match(ID);
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
  public static class FormalArgsContext extends ParserRuleContext {
    public List<FormalArgContext> formalArg() {
      return getRuleContexts(FormalArgContext.class);
    }

    public FormalArgContext formalArg(int i) {
      return getRuleContext(FormalArgContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(STGParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(STGParser.COMMA, i);
    }

    public FormalArgsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_formalArgs;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener)
        ((STGParserListener) listener).enterFormalArgs(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener)
        ((STGParserListener) listener).exitFormalArgs(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof STGParserVisitor)
        return ((STGParserVisitor<? extends T>) visitor).visitFormalArgs(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FormalArgsContext formalArgs() throws RecognitionException {
    FormalArgsContext _localctx = new FormalArgsContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_formalArgs);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(68);
        formalArg();
        setState(73);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == COMMA) {
          {
            {
              setState(69);
              match(COMMA);
              setState(70);
              formalArg();
            }
          }
          setState(75);
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
  public static class FormalArgContext extends ParserRuleContext {
    public TerminalNode ID() {
      return getToken(STGParser.ID, 0);
    }

    public TerminalNode ASSIGN() {
      return getToken(STGParser.ASSIGN, 0);
    }

    public TerminalNode STRING() {
      return getToken(STGParser.STRING, 0);
    }

    public TerminalNode ANON_TEMPLATE() {
      return getToken(STGParser.ANON_TEMPLATE, 0);
    }

    public TerminalNode TRUE() {
      return getToken(STGParser.TRUE, 0);
    }

    public TerminalNode FALSE() {
      return getToken(STGParser.FALSE, 0);
    }

    public TerminalNode LBRACK() {
      return getToken(STGParser.LBRACK, 0);
    }

    public TerminalNode RBRACK() {
      return getToken(STGParser.RBRACK, 0);
    }

    public FormalArgContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_formalArg;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener)
        ((STGParserListener) listener).enterFormalArg(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener) ((STGParserListener) listener).exitFormalArg(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof STGParserVisitor)
        return ((STGParserVisitor<? extends T>) visitor).visitFormalArg(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FormalArgContext formalArg() throws RecognitionException {
    FormalArgContext _localctx = new FormalArgContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_formalArg);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(76);
        match(ID);
        setState(88);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 9, _ctx)) {
          case 1:
            {
              setState(77);
              match(ASSIGN);
              setState(78);
              match(STRING);
            }
            break;
          case 2:
            {
              setState(79);
              match(ASSIGN);
              setState(80);
              match(ANON_TEMPLATE);
            }
            break;
          case 3:
            {
              setState(81);
              match(ASSIGN);
              setState(82);
              match(TRUE);
            }
            break;
          case 4:
            {
              setState(83);
              match(ASSIGN);
              setState(84);
              match(FALSE);
            }
            break;
          case 5:
            {
              setState(85);
              match(ASSIGN);
              setState(86);
              match(LBRACK);
              setState(87);
              match(RBRACK);
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
  public static class Dict_Context extends ParserRuleContext {
    public TerminalNode ID() {
      return getToken(STGParser.ID, 0);
    }

    public TerminalNode TMPL_ASSIGN() {
      return getToken(STGParser.TMPL_ASSIGN, 0);
    }

    public TerminalNode LBRACK() {
      return getToken(STGParser.LBRACK, 0);
    }

    public DictPairsContext dictPairs() {
      return getRuleContext(DictPairsContext.class, 0);
    }

    public TerminalNode RBRACK() {
      return getToken(STGParser.RBRACK, 0);
    }

    public Dict_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_dict_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener) ((STGParserListener) listener).enterDict_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener) ((STGParserListener) listener).exitDict_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof STGParserVisitor)
        return ((STGParserVisitor<? extends T>) visitor).visitDict_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Dict_Context dict_() throws RecognitionException {
    Dict_Context _localctx = new Dict_Context(_ctx, getState());
    enterRule(_localctx, 12, RULE_dict_);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(90);
        match(ID);
        setState(91);
        match(TMPL_ASSIGN);
        setState(92);
        match(LBRACK);
        setState(93);
        dictPairs();
        setState(94);
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
  public static class DictPairsContext extends ParserRuleContext {
    public List<KeyValuePairContext> keyValuePair() {
      return getRuleContexts(KeyValuePairContext.class);
    }

    public KeyValuePairContext keyValuePair(int i) {
      return getRuleContext(KeyValuePairContext.class, i);
    }

    public List<TerminalNode> COMMA() {
      return getTokens(STGParser.COMMA);
    }

    public TerminalNode COMMA(int i) {
      return getToken(STGParser.COMMA, i);
    }

    public DefaultValuePairContext defaultValuePair() {
      return getRuleContext(DefaultValuePairContext.class, 0);
    }

    public DictPairsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_dictPairs;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener)
        ((STGParserListener) listener).enterDictPairs(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener) ((STGParserListener) listener).exitDictPairs(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof STGParserVisitor)
        return ((STGParserVisitor<? extends T>) visitor).visitDictPairs(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DictPairsContext dictPairs() throws RecognitionException {
    DictPairsContext _localctx = new DictPairsContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_dictPairs);
    int _la;
    try {
      int _alt;
      setState(109);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case STRING:
          enterOuterAlt(_localctx, 1);
          {
            setState(96);
            keyValuePair();
            setState(101);
            _errHandler.sync(this);
            _alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
            while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
              if (_alt == 1) {
                {
                  {
                    setState(97);
                    match(COMMA);
                    setState(98);
                    keyValuePair();
                  }
                }
              }
              setState(103);
              _errHandler.sync(this);
              _alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
            }
            setState(106);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == COMMA) {
              {
                setState(104);
                match(COMMA);
                setState(105);
                defaultValuePair();
              }
            }
          }
          break;
        case DEFAULT:
          enterOuterAlt(_localctx, 2);
          {
            setState(108);
            defaultValuePair();
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
  public static class KeyValuePairContext extends ParserRuleContext {
    public TerminalNode STRING() {
      return getToken(STGParser.STRING, 0);
    }

    public TerminalNode COLON() {
      return getToken(STGParser.COLON, 0);
    }

    public KeyValueContext keyValue() {
      return getRuleContext(KeyValueContext.class, 0);
    }

    public KeyValuePairContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_keyValuePair;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener)
        ((STGParserListener) listener).enterKeyValuePair(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener)
        ((STGParserListener) listener).exitKeyValuePair(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof STGParserVisitor)
        return ((STGParserVisitor<? extends T>) visitor).visitKeyValuePair(this);
      else return visitor.visitChildren(this);
    }
  }

  public final KeyValuePairContext keyValuePair() throws RecognitionException {
    KeyValuePairContext _localctx = new KeyValuePairContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_keyValuePair);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(111);
        match(STRING);
        setState(112);
        match(COLON);
        setState(113);
        keyValue();
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
  public static class DefaultValuePairContext extends ParserRuleContext {
    public TerminalNode DEFAULT() {
      return getToken(STGParser.DEFAULT, 0);
    }

    public TerminalNode COLON() {
      return getToken(STGParser.COLON, 0);
    }

    public KeyValueContext keyValue() {
      return getRuleContext(KeyValueContext.class, 0);
    }

    public DefaultValuePairContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_defaultValuePair;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener)
        ((STGParserListener) listener).enterDefaultValuePair(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener)
        ((STGParserListener) listener).exitDefaultValuePair(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof STGParserVisitor)
        return ((STGParserVisitor<? extends T>) visitor).visitDefaultValuePair(this);
      else return visitor.visitChildren(this);
    }
  }

  public final DefaultValuePairContext defaultValuePair() throws RecognitionException {
    DefaultValuePairContext _localctx = new DefaultValuePairContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_defaultValuePair);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(115);
        match(DEFAULT);
        setState(116);
        match(COLON);
        setState(117);
        keyValue();
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
  public static class KeyValueContext extends ParserRuleContext {
    public TerminalNode BIGSTRING() {
      return getToken(STGParser.BIGSTRING, 0);
    }

    public TerminalNode BIGSTRING_NO_NL() {
      return getToken(STGParser.BIGSTRING_NO_NL, 0);
    }

    public TerminalNode ANON_TEMPLATE() {
      return getToken(STGParser.ANON_TEMPLATE, 0);
    }

    public TerminalNode STRING() {
      return getToken(STGParser.STRING, 0);
    }

    public TerminalNode TRUE() {
      return getToken(STGParser.TRUE, 0);
    }

    public TerminalNode FALSE() {
      return getToken(STGParser.FALSE, 0);
    }

    public TerminalNode LBRACK() {
      return getToken(STGParser.LBRACK, 0);
    }

    public TerminalNode RBRACK() {
      return getToken(STGParser.RBRACK, 0);
    }

    public TerminalNode KEY() {
      return getToken(STGParser.KEY, 0);
    }

    public KeyValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_keyValue;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener) ((STGParserListener) listener).enterKeyValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof STGParserListener) ((STGParserListener) listener).exitKeyValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof STGParserVisitor)
        return ((STGParserVisitor<? extends T>) visitor).visitKeyValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final KeyValueContext keyValue() throws RecognitionException {
    KeyValueContext _localctx = new KeyValueContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_keyValue);
    try {
      setState(128);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case BIGSTRING:
          enterOuterAlt(_localctx, 1);
          {
            setState(119);
            match(BIGSTRING);
          }
          break;
        case BIGSTRING_NO_NL:
          enterOuterAlt(_localctx, 2);
          {
            setState(120);
            match(BIGSTRING_NO_NL);
          }
          break;
        case ANON_TEMPLATE:
          enterOuterAlt(_localctx, 3);
          {
            setState(121);
            match(ANON_TEMPLATE);
          }
          break;
        case STRING:
          enterOuterAlt(_localctx, 4);
          {
            setState(122);
            match(STRING);
          }
          break;
        case TRUE:
          enterOuterAlt(_localctx, 5);
          {
            setState(123);
            match(TRUE);
          }
          break;
        case FALSE:
          enterOuterAlt(_localctx, 6);
          {
            setState(124);
            match(FALSE);
          }
          break;
        case LBRACK:
          enterOuterAlt(_localctx, 7);
          {
            setState(125);
            match(LBRACK);
            setState(126);
            match(RBRACK);
          }
          break;
        case KEY:
          enterOuterAlt(_localctx, 8);
          {
            setState(127);
            match(KEY);
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

  public static final String _serializedATN =
      "\u0004\u0001*\u0083\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
          + "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"
          + "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"
          + "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0003\u0000\u0018"
          + "\b\u0000\u0001\u0000\u0003\u0000\u001b\b\u0000\u0001\u0000\u0001\u0000"
          + "\u0004\u0000\u001f\b\u0000\u000b\u0000\f\u0000 \u0001\u0000\u0001\u0000"
          + "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"
          + "\u0001\u0002\u0004\u0002,\b\u0002\u000b\u0002\f\u0002-\u0001\u0003\u0001"
          + "\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"
          + "\u0003\u0001\u0003\u0003\u00039\b\u0003\u0001\u0003\u0003\u0003<\b\u0003"
          + "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"
          + "C\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004H\b\u0004\n\u0004"
          + "\f\u0004K\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"
          + "\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"
          + "\u0005\u0001\u0005\u0003\u0005Y\b\u0005\u0001\u0006\u0001\u0006\u0001"
          + "\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"
          + "\u0007\u0005\u0007d\b\u0007\n\u0007\f\u0007g\t\u0007\u0001\u0007\u0001"
          + "\u0007\u0003\u0007k\b\u0007\u0001\u0007\u0003\u0007n\b\u0007\u0001\b\u0001"
          + "\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"
          + "\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0081\b\n\u0001"
          + "\n\u0000\u0000\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"
          + "\u0000\u0001\u0001\u0000\b\n\u008f\u0000\u0017\u0001\u0000\u0000\u0000"
          + "\u0002$\u0001\u0000\u0000\u0000\u0004+\u0001\u0000\u0000\u0000\u0006B"
          + "\u0001\u0000\u0000\u0000\bD\u0001\u0000\u0000\u0000\nL\u0001\u0000\u0000"
          + "\u0000\fZ\u0001\u0000\u0000\u0000\u000em\u0001\u0000\u0000\u0000\u0010"
          + "o\u0001\u0000\u0000\u0000\u0012s\u0001\u0000\u0000\u0000\u0014\u0080\u0001"
          + "\u0000\u0000\u0000\u0016\u0018\u0003\u0002\u0001\u0000\u0017\u0016\u0001"
          + "\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u001a\u0001"
          + "\u0000\u0000\u0000\u0019\u001b\u0003\u0004\u0002\u0000\u001a\u0019\u0001"
          + "\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u001e\u0001"
          + "\u0000\u0000\u0000\u001c\u001f\u0003\u0006\u0003\u0000\u001d\u001f\u0003"
          + "\f\u0006\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001d\u0001\u0000"
          + "\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000"
          + " !\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0005\u0000\u0000"
          + "\u0001#\u0001\u0001\u0000\u0000\u0000$%\u0005\u0019\u0000\u0000%&\u0005"
          + "\b\u0000\u0000&\'\u0005\u000f\u0000\u0000\'(\u0005\b\u0000\u0000(\u0003"
          + "\u0001\u0000\u0000\u0000)*\u0005\u001a\u0000\u0000*,\u0005\b\u0000\u0000"
          + "+)\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000"
          + "\u0000-.\u0001\u0000\u0000\u0000.\u0005\u0001\u0000\u0000\u0000/0\u0005"
          + "\u0015\u0000\u000001\u0005\u0007\u0000\u000012\u0005\u000e\u0000\u0000"
          + "23\u0005\u0007\u0000\u000034\u0005\u0011\u0000\u00004<\u0005\u0012\u0000"
          + "\u000056\u0005\u0007\u0000\u000068\u0005\u0011\u0000\u000079\u0003\b\u0004"
          + "\u000087\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0001\u0000"
          + "\u0000\u0000:<\u0005\u0012\u0000\u0000;/\u0001\u0000\u0000\u0000;5\u0001"
          + "\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0005\f\u0000\u0000>C\u0007"
          + "\u0000\u0000\u0000?@\u0005\u0007\u0000\u0000@A\u0005\f\u0000\u0000AC\u0005"
          + "\u0007\u0000\u0000B;\u0001\u0000\u0000\u0000B?\u0001\u0000\u0000\u0000"
          + "C\u0007\u0001\u0000\u0000\u0000DI\u0003\n\u0005\u0000EF\u0005\u000f\u0000"
          + "\u0000FH\u0003\n\u0005\u0000GE\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000"
          + "\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\t\u0001\u0000"
          + "\u0000\u0000KI\u0001\u0000\u0000\u0000LX\u0005\u0007\u0000\u0000MN\u0005"
          + "\r\u0000\u0000NY\u0005\b\u0000\u0000OP\u0005\r\u0000\u0000PY\u0005\u000b"
          + "\u0000\u0000QR\u0005\r\u0000\u0000RY\u0005\u0016\u0000\u0000ST\u0005\r"
          + "\u0000\u0000TY\u0005\u0017\u0000\u0000UV\u0005\r\u0000\u0000VW\u0005\u0013"
          + "\u0000\u0000WY\u0005\u0014\u0000\u0000XM\u0001\u0000\u0000\u0000XO\u0001"
          + "\u0000\u0000\u0000XQ\u0001\u0000\u0000\u0000XS\u0001\u0000\u0000\u0000"
          + "XU\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y\u000b\u0001\u0000"
          + "\u0000\u0000Z[\u0005\u0007\u0000\u0000[\\\u0005\f\u0000\u0000\\]\u0005"
          + "\u0013\u0000\u0000]^\u0003\u000e\u0007\u0000^_\u0005\u0014\u0000\u0000"
          + "_\r\u0001\u0000\u0000\u0000`e\u0003\u0010\b\u0000ab\u0005\u000f\u0000"
          + "\u0000bd\u0003\u0010\b\u0000ca\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000"
          + "\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fj\u0001\u0000"
          + "\u0000\u0000ge\u0001\u0000\u0000\u0000hi\u0005\u000f\u0000\u0000ik\u0003"
          + "\u0012\t\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kn\u0001"
          + "\u0000\u0000\u0000ln\u0003\u0012\t\u0000m`\u0001\u0000\u0000\u0000ml\u0001"
          + "\u0000\u0000\u0000n\u000f\u0001\u0000\u0000\u0000op\u0005\b\u0000\u0000"
          + "pq\u0005\u0010\u0000\u0000qr\u0003\u0014\n\u0000r\u0011\u0001\u0000\u0000"
          + "\u0000st\u0005\u001b\u0000\u0000tu\u0005\u0010\u0000\u0000uv\u0003\u0014"
          + "\n\u0000v\u0013\u0001\u0000\u0000\u0000w\u0081\u0005\t\u0000\u0000x\u0081"
          + "\u0005\n\u0000\u0000y\u0081\u0005\u000b\u0000\u0000z\u0081\u0005\b\u0000"
          + "\u0000{\u0081\u0005\u0016\u0000\u0000|\u0081\u0005\u0017\u0000\u0000}"
          + "~\u0005\u0013\u0000\u0000~\u0081\u0005\u0014\u0000\u0000\u007f\u0081\u0005"
          + "\u001c\u0000\u0000\u0080w\u0001\u0000\u0000\u0000\u0080x\u0001\u0000\u0000"
          + "\u0000\u0080y\u0001\u0000\u0000\u0000\u0080z\u0001\u0000\u0000\u0000\u0080"
          + "{\u0001\u0000\u0000\u0000\u0080|\u0001\u0000\u0000\u0000\u0080}\u0001"
          + "\u0000\u0000\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0015\u0001"
          + "\u0000\u0000\u0000\u000e\u0017\u001a\u001e -8;BIXejm\u0080";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
