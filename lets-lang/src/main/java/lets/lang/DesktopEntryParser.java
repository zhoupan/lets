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
public class DesktopEntryParser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int HASH = 1,
      LEFT_BRACKET = 2,
      NEWLINE = 3,
      SPACE = 4,
      COMMENT_TEXT = 5,
      GROUP_NAME = 6,
      RIGHT_BRACKET = 7,
      KEY_NAME = 8,
      EQUAL = 9,
      TRUE = 10,
      FALSE = 11,
      NUMBER = 12,
      SEMICOLON = 13,
      STRING = 14,
      AT = 15,
      DOT = 16,
      LANGUAGE = 17,
      UNDERSCORE = 18,
      AT_0 = 19,
      COUNTRY = 20,
      DOT_0 = 21,
      AT_1 = 22,
      ENCODING = 23,
      MODIFIER = 24;
  public static final int RULE_desktop_entry = 0,
      RULE_group = 1,
      RULE_group_header = 2,
      RULE_group_name = 3,
      RULE_entry = 4,
      RULE_key = 5,
      RULE_locale = 6,
      RULE_language_ = 7,
      RULE_country = 8,
      RULE_encoding = 9,
      RULE_modifier = 10,
      RULE_value = 11,
      RULE_string_ = 12,
      RULE_number = 13,
      RULE_true_ = 14,
      RULE_false_ = 15;

  private static String[] makeRuleNames() {
    return new String[] {
      "desktop_entry",
      "group",
      "group_header",
      "group_name",
      "entry",
      "key",
      "locale",
      "language_",
      "country",
      "encoding",
      "modifier",
      "value",
      "string_",
      "number",
      "true_",
      "false_"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null, null, "'['", null, null, null, null, "']'", null, "'='", "'true'", "'false'", null,
      "';'", null, null, null, null, "'_'"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      "HASH",
      "LEFT_BRACKET",
      "NEWLINE",
      "SPACE",
      "COMMENT_TEXT",
      "GROUP_NAME",
      "RIGHT_BRACKET",
      "KEY_NAME",
      "EQUAL",
      "TRUE",
      "FALSE",
      "NUMBER",
      "SEMICOLON",
      "STRING",
      "AT",
      "DOT",
      "LANGUAGE",
      "UNDERSCORE",
      "AT_0",
      "COUNTRY",
      "DOT_0",
      "AT_1",
      "ENCODING",
      "MODIFIER"
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
    return "DesktopEntryParser.g4";
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

  public DesktopEntryParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class Desktop_entryContext extends ParserRuleContext {
    public TerminalNode EOF() {
      return getToken(DesktopEntryParser.EOF, 0);
    }

    public List<GroupContext> group() {
      return getRuleContexts(GroupContext.class);
    }

    public GroupContext group(int i) {
      return getRuleContext(GroupContext.class, i);
    }

    public Desktop_entryContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_desktop_entry;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterDesktop_entry(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitDesktop_entry(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitDesktop_entry(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Desktop_entryContext desktop_entry() throws RecognitionException {
    Desktop_entryContext _localctx = new Desktop_entryContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_desktop_entry);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(35);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == LEFT_BRACKET) {
          {
            {
              setState(32);
              group();
            }
          }
          setState(37);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        setState(38);
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
  public static class GroupContext extends ParserRuleContext {
    public Group_headerContext group_header() {
      return getRuleContext(Group_headerContext.class, 0);
    }

    public List<EntryContext> entry() {
      return getRuleContexts(EntryContext.class);
    }

    public EntryContext entry(int i) {
      return getRuleContext(EntryContext.class, i);
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
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterGroup(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitGroup(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitGroup(this);
      else return visitor.visitChildren(this);
    }
  }

  public final GroupContext group() throws RecognitionException {
    GroupContext _localctx = new GroupContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_group);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(40);
        group_header();
        setState(44);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == KEY_NAME) {
          {
            {
              setState(41);
              entry();
            }
          }
          setState(46);
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
  public static class Group_headerContext extends ParserRuleContext {
    public TerminalNode LEFT_BRACKET() {
      return getToken(DesktopEntryParser.LEFT_BRACKET, 0);
    }

    public Group_nameContext group_name() {
      return getRuleContext(Group_nameContext.class, 0);
    }

    public TerminalNode RIGHT_BRACKET() {
      return getToken(DesktopEntryParser.RIGHT_BRACKET, 0);
    }

    public Group_headerContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_group_header;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterGroup_header(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitGroup_header(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitGroup_header(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Group_headerContext group_header() throws RecognitionException {
    Group_headerContext _localctx = new Group_headerContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_group_header);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(47);
        match(LEFT_BRACKET);
        setState(48);
        group_name();
        setState(49);
        match(RIGHT_BRACKET);
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
  public static class Group_nameContext extends ParserRuleContext {
    public TerminalNode GROUP_NAME() {
      return getToken(DesktopEntryParser.GROUP_NAME, 0);
    }

    public Group_nameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_group_name;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterGroup_name(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitGroup_name(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitGroup_name(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Group_nameContext group_name() throws RecognitionException {
    Group_nameContext _localctx = new Group_nameContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_group_name);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(51);
        match(GROUP_NAME);
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
  public static class EntryContext extends ParserRuleContext {
    public KeyContext key() {
      return getRuleContext(KeyContext.class, 0);
    }

    public TerminalNode EQUAL() {
      return getToken(DesktopEntryParser.EQUAL, 0);
    }

    public LocaleContext locale() {
      return getRuleContext(LocaleContext.class, 0);
    }

    public List<ValueContext> value() {
      return getRuleContexts(ValueContext.class);
    }

    public ValueContext value(int i) {
      return getRuleContext(ValueContext.class, i);
    }

    public List<TerminalNode> SEMICOLON() {
      return getTokens(DesktopEntryParser.SEMICOLON);
    }

    public TerminalNode SEMICOLON(int i) {
      return getToken(DesktopEntryParser.SEMICOLON, i);
    }

    public EntryContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_entry;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterEntry(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitEntry(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitEntry(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EntryContext entry() throws RecognitionException {
    EntryContext _localctx = new EntryContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_entry);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(53);
        key();
        setState(55);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == LEFT_BRACKET) {
          {
            setState(54);
            locale();
          }
        }

        setState(57);
        match(EQUAL);
        setState(59);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 23552L) != 0)) {
          {
            setState(58);
            value();
          }
        }

        setState(65);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(61);
                match(SEMICOLON);
                setState(62);
                value();
              }
            }
          }
          setState(67);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
        }
        setState(69);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == SEMICOLON) {
          {
            setState(68);
            match(SEMICOLON);
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
  public static class KeyContext extends ParserRuleContext {
    public TerminalNode KEY_NAME() {
      return getToken(DesktopEntryParser.KEY_NAME, 0);
    }

    public KeyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_key;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterKey(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitKey(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitKey(this);
      else return visitor.visitChildren(this);
    }
  }

  public final KeyContext key() throws RecognitionException {
    KeyContext _localctx = new KeyContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_key);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(71);
        match(KEY_NAME);
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
  public static class LocaleContext extends ParserRuleContext {
    public TerminalNode LEFT_BRACKET() {
      return getToken(DesktopEntryParser.LEFT_BRACKET, 0);
    }

    public Language_Context language_() {
      return getRuleContext(Language_Context.class, 0);
    }

    public TerminalNode RIGHT_BRACKET() {
      return getToken(DesktopEntryParser.RIGHT_BRACKET, 0);
    }

    public TerminalNode UNDERSCORE() {
      return getToken(DesktopEntryParser.UNDERSCORE, 0);
    }

    public CountryContext country() {
      return getRuleContext(CountryContext.class, 0);
    }

    public TerminalNode DOT() {
      return getToken(DesktopEntryParser.DOT, 0);
    }

    public EncodingContext encoding() {
      return getRuleContext(EncodingContext.class, 0);
    }

    public TerminalNode AT() {
      return getToken(DesktopEntryParser.AT, 0);
    }

    public ModifierContext modifier() {
      return getRuleContext(ModifierContext.class, 0);
    }

    public LocaleContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_locale;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterLocale(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitLocale(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitLocale(this);
      else return visitor.visitChildren(this);
    }
  }

  public final LocaleContext locale() throws RecognitionException {
    LocaleContext _localctx = new LocaleContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_locale);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(73);
        match(LEFT_BRACKET);
        setState(74);
        language_();
        setState(77);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == UNDERSCORE) {
          {
            setState(75);
            match(UNDERSCORE);
            setState(76);
            country();
          }
        }

        setState(81);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == DOT) {
          {
            setState(79);
            match(DOT);
            setState(80);
            encoding();
          }
        }

        setState(85);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == AT) {
          {
            setState(83);
            match(AT);
            setState(84);
            modifier();
          }
        }

        setState(87);
        match(RIGHT_BRACKET);
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
  public static class Language_Context extends ParserRuleContext {
    public TerminalNode LANGUAGE() {
      return getToken(DesktopEntryParser.LANGUAGE, 0);
    }

    public Language_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_language_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterLanguage_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitLanguage_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitLanguage_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final Language_Context language_() throws RecognitionException {
    Language_Context _localctx = new Language_Context(_ctx, getState());
    enterRule(_localctx, 14, RULE_language_);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(89);
        match(LANGUAGE);
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
  public static class CountryContext extends ParserRuleContext {
    public TerminalNode COUNTRY() {
      return getToken(DesktopEntryParser.COUNTRY, 0);
    }

    public CountryContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_country;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterCountry(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitCountry(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitCountry(this);
      else return visitor.visitChildren(this);
    }
  }

  public final CountryContext country() throws RecognitionException {
    CountryContext _localctx = new CountryContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_country);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(91);
        match(COUNTRY);
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
  public static class EncodingContext extends ParserRuleContext {
    public TerminalNode ENCODING() {
      return getToken(DesktopEntryParser.ENCODING, 0);
    }

    public EncodingContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_encoding;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterEncoding(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitEncoding(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitEncoding(this);
      else return visitor.visitChildren(this);
    }
  }

  public final EncodingContext encoding() throws RecognitionException {
    EncodingContext _localctx = new EncodingContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_encoding);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(93);
        match(ENCODING);
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
  public static class ModifierContext extends ParserRuleContext {
    public TerminalNode MODIFIER() {
      return getToken(DesktopEntryParser.MODIFIER, 0);
    }

    public ModifierContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_modifier;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterModifier(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitModifier(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitModifier(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ModifierContext modifier() throws RecognitionException {
    ModifierContext _localctx = new ModifierContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_modifier);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(95);
        match(MODIFIER);
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
  public static class ValueContext extends ParserRuleContext {
    public String_Context string_() {
      return getRuleContext(String_Context.class, 0);
    }

    public NumberContext number() {
      return getRuleContext(NumberContext.class, 0);
    }

    public True_Context true_() {
      return getRuleContext(True_Context.class, 0);
    }

    public False_Context false_() {
      return getRuleContext(False_Context.class, 0);
    }

    public ValueContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_value;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterValue(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitValue(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitValue(this);
      else return visitor.visitChildren(this);
    }
  }

  public final ValueContext value() throws RecognitionException {
    ValueContext _localctx = new ValueContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_value);
    try {
      setState(101);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case STRING:
          enterOuterAlt(_localctx, 1);
          {
            setState(97);
            string_();
          }
          break;
        case NUMBER:
          enterOuterAlt(_localctx, 2);
          {
            setState(98);
            number();
          }
          break;
        case TRUE:
          enterOuterAlt(_localctx, 3);
          {
            setState(99);
            true_();
          }
          break;
        case FALSE:
          enterOuterAlt(_localctx, 4);
          {
            setState(100);
            false_();
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
  public static class String_Context extends ParserRuleContext {
    public TerminalNode STRING() {
      return getToken(DesktopEntryParser.STRING, 0);
    }

    public String_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_string_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterString_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitString_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitString_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final String_Context string_() throws RecognitionException {
    String_Context _localctx = new String_Context(_ctx, getState());
    enterRule(_localctx, 24, RULE_string_);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(103);
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
  public static class NumberContext extends ParserRuleContext {
    public TerminalNode NUMBER() {
      return getToken(DesktopEntryParser.NUMBER, 0);
    }

    public NumberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_number;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterNumber(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitNumber(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitNumber(this);
      else return visitor.visitChildren(this);
    }
  }

  public final NumberContext number() throws RecognitionException {
    NumberContext _localctx = new NumberContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_number);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(105);
        match(NUMBER);
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
  public static class True_Context extends ParserRuleContext {
    public TerminalNode TRUE() {
      return getToken(DesktopEntryParser.TRUE, 0);
    }

    public True_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_true_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterTrue_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitTrue_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitTrue_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final True_Context true_() throws RecognitionException {
    True_Context _localctx = new True_Context(_ctx, getState());
    enterRule(_localctx, 28, RULE_true_);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(107);
        match(TRUE);
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
  public static class False_Context extends ParserRuleContext {
    public TerminalNode FALSE() {
      return getToken(DesktopEntryParser.FALSE, 0);
    }

    public False_Context(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_false_;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).enterFalse_(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof DesktopEntryParserListener)
        ((DesktopEntryParserListener) listener).exitFalse_(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof DesktopEntryParserVisitor)
        return ((DesktopEntryParserVisitor<? extends T>) visitor).visitFalse_(this);
      else return visitor.visitChildren(this);
    }
  }

  public final False_Context false_() throws RecognitionException {
    False_Context _localctx = new False_Context(_ctx, getState());
    enterRule(_localctx, 30, RULE_false_);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(109);
        match(FALSE);
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
      "\u0004\u0001\u0018p\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
          + "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"
          + "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"
          + "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"
          + "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"
          + "\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001\u0000"
          + "\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001+\b\u0001\n\u0001\f\u0001"
          + ".\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"
          + "\u0001\u0003\u0001\u0004\u0001\u0004\u0003\u00048\b\u0004\u0001\u0004"
          + "\u0001\u0004\u0003\u0004<\b\u0004\u0001\u0004\u0001\u0004\u0005\u0004"
          + "@\b\u0004\n\u0004\f\u0004C\t\u0004\u0001\u0004\u0003\u0004F\b\u0004\u0001"
          + "\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"
          + "\u0006N\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006R\b\u0006\u0001\u0006"
          + "\u0001\u0006\u0003\u0006V\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007"
          + "\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"
          + "\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bf\b\u000b\u0001\f\u0001"
          + "\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"
          + "\u000f\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"
          + "\u0014\u0016\u0018\u001a\u001c\u001e\u0000\u0000k\u0000#\u0001\u0000\u0000"
          + "\u0000\u0002(\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000\u0006"
          + "3\u0001\u0000\u0000\u0000\b5\u0001\u0000\u0000\u0000\nG\u0001\u0000\u0000"
          + "\u0000\fI\u0001\u0000\u0000\u0000\u000eY\u0001\u0000\u0000\u0000\u0010"
          + "[\u0001\u0000\u0000\u0000\u0012]\u0001\u0000\u0000\u0000\u0014_\u0001"
          + "\u0000\u0000\u0000\u0016e\u0001\u0000\u0000\u0000\u0018g\u0001\u0000\u0000"
          + "\u0000\u001ai\u0001\u0000\u0000\u0000\u001ck\u0001\u0000\u0000\u0000\u001e"
          + "m\u0001\u0000\u0000\u0000 \"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000"
          + "\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000"
          + "\u0000\u0000$&\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000&\'\u0005"
          + "\u0000\u0000\u0001\'\u0001\u0001\u0000\u0000\u0000(,\u0003\u0004\u0002"
          + "\u0000)+\u0003\b\u0004\u0000*)\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000"
          + "\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-\u0003\u0001"
          + "\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000/0\u0005\u0002\u0000\u0000"
          + "01\u0003\u0006\u0003\u000012\u0005\u0007\u0000\u00002\u0005\u0001\u0000"
          + "\u0000\u000034\u0005\u0006\u0000\u00004\u0007\u0001\u0000\u0000\u0000"
          + "57\u0003\n\u0005\u000068\u0003\f\u0006\u000076\u0001\u0000\u0000\u0000"
          + "78\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009;\u0005\t\u0000\u0000"
          + ":<\u0003\u0016\u000b\u0000;:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000"
          + "\u0000<A\u0001\u0000\u0000\u0000=>\u0005\r\u0000\u0000>@\u0003\u0016\u000b"
          + "\u0000?=\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000"
          + "\u0000\u0000AB\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001"
          + "\u0000\u0000\u0000DF\u0005\r\u0000\u0000ED\u0001\u0000\u0000\u0000EF\u0001"
          + "\u0000\u0000\u0000F\t\u0001\u0000\u0000\u0000GH\u0005\b\u0000\u0000H\u000b"
          + "\u0001\u0000\u0000\u0000IJ\u0005\u0002\u0000\u0000JM\u0003\u000e\u0007"
          + "\u0000KL\u0005\u0012\u0000\u0000LN\u0003\u0010\b\u0000MK\u0001\u0000\u0000"
          + "\u0000MN\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OP\u0005\u0010"
          + "\u0000\u0000PR\u0003\u0012\t\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000"
          + "\u0000\u0000RU\u0001\u0000\u0000\u0000ST\u0005\u000f\u0000\u0000TV\u0003"
          + "\u0014\n\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0001"
          + "\u0000\u0000\u0000WX\u0005\u0007\u0000\u0000X\r\u0001\u0000\u0000\u0000"
          + "YZ\u0005\u0011\u0000\u0000Z\u000f\u0001\u0000\u0000\u0000[\\\u0005\u0014"
          + "\u0000\u0000\\\u0011\u0001\u0000\u0000\u0000]^\u0005\u0017\u0000\u0000"
          + "^\u0013\u0001\u0000\u0000\u0000_`\u0005\u0018\u0000\u0000`\u0015\u0001"
          + "\u0000\u0000\u0000af\u0003\u0018\f\u0000bf\u0003\u001a\r\u0000cf\u0003"
          + "\u001c\u000e\u0000df\u0003\u001e\u000f\u0000ea\u0001\u0000\u0000\u0000"
          + "eb\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ed\u0001\u0000\u0000"
          + "\u0000f\u0017\u0001\u0000\u0000\u0000gh\u0005\u000e\u0000\u0000h\u0019"
          + "\u0001\u0000\u0000\u0000ij\u0005\f\u0000\u0000j\u001b\u0001\u0000\u0000"
          + "\u0000kl\u0005\n\u0000\u0000l\u001d\u0001\u0000\u0000\u0000mn\u0005\u000b"
          + "\u0000\u0000n\u001f\u0001\u0000\u0000\u0000\n#,7;AEMQUe";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
