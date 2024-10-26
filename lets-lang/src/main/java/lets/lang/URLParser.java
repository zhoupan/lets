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
public class URLParser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int T__0 = 1,
      T__1 = 2,
      T__2 = 3,
      T__3 = 4,
      T__4 = 5,
      T__5 = 6,
      T__6 = 7,
      T__7 = 8,
      T__8 = 9,
      T__9 = 10,
      T__10 = 11,
      DIGITS = 12,
      HEX = 13,
      STRING = 14,
      WS = 15;
  public static final int RULE_url = 0,
      RULE_uri = 1,
      RULE_scheme = 2,
      RULE_host = 3,
      RULE_hostname = 4,
      RULE_v6host = 5,
      RULE_port = 6,
      RULE_path = 7,
      RULE_user = 8,
      RULE_login = 9,
      RULE_password = 10,
      RULE_frag = 11,
      RULE_query = 12,
      RULE_search = 13,
      RULE_searchparameter = 14,
      RULE_string = 15;

  private static String[] makeRuleNames() {
    return new String[] {
      "url",
      "uri",
      "scheme",
      "host",
      "hostname",
      "v6host",
      "port",
      "path",
      "user",
      "login",
      "password",
      "frag",
      "query",
      "search",
      "searchparameter",
      "string"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null, "'://'", "':'", "'/'", "'['", "']'", "'::'", "'@'", "'#'", "'?'", "'&'", "'='"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null, null, null, null, null, null, null, null, null, null, null, null, "DIGITS", "HEX",
      "STRING", "WS"
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
    return "URL.g4";
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

  public URLParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class UrlContext extends ParserRuleContext {
    public UriContext uri() {
      return getRuleContext(UriContext.class, 0);
    }

    public TerminalNode EOF() {
      return getToken(URLParser.EOF, 0);
    }

    public UrlContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_url;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterUrl(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitUrl(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor) return ((URLVisitor<? extends T>) visitor).visitUrl(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UrlContext url() throws RecognitionException {
    UrlContext _localctx = new UrlContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_url);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(32);
        uri();
        setState(33);
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
  public static class UriContext extends ParserRuleContext {
    public SchemeContext scheme() {
      return getRuleContext(SchemeContext.class, 0);
    }

    public HostContext host() {
      return getRuleContext(HostContext.class, 0);
    }

    public LoginContext login() {
      return getRuleContext(LoginContext.class, 0);
    }

    public PortContext port() {
      return getRuleContext(PortContext.class, 0);
    }

    public QueryContext query() {
      return getRuleContext(QueryContext.class, 0);
    }

    public FragContext frag() {
      return getRuleContext(FragContext.class, 0);
    }

    public TerminalNode WS() {
      return getToken(URLParser.WS, 0);
    }

    public PathContext path() {
      return getRuleContext(PathContext.class, 0);
    }

    public UriContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_uri;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterUri(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitUri(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor) return ((URLVisitor<? extends T>) visitor).visitUri(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UriContext uri() throws RecognitionException {
    UriContext _localctx = new UriContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_uri);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(35);
        scheme();
        setState(36);
        match(T__0);
        setState(38);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
          case 1:
            {
              setState(37);
              login();
            }
            break;
        }
        setState(40);
        host();
        setState(43);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__1) {
          {
            setState(41);
            match(T__1);
            setState(42);
            port();
          }
        }

        setState(49);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__2) {
          {
            setState(45);
            match(T__2);
            setState(47);
            _errHandler.sync(this);
            _la = _input.LA(1);
            if (_la == DIGITS || _la == STRING) {
              {
                setState(46);
                path();
              }
            }
          }
        }

        setState(52);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__8) {
          {
            setState(51);
            query();
          }
        }

        setState(55);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__7) {
          {
            setState(54);
            frag();
          }
        }

        setState(58);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == WS) {
          {
            setState(57);
            match(WS);
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
  public static class SchemeContext extends ParserRuleContext {
    public StringContext string() {
      return getRuleContext(StringContext.class, 0);
    }

    public SchemeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_scheme;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterScheme(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitScheme(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor)
        return ((URLVisitor<? extends T>) visitor).visitScheme(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SchemeContext scheme() throws RecognitionException {
    SchemeContext _localctx = new SchemeContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_scheme);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(60);
        string();
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
  public static class HostContext extends ParserRuleContext {
    public HostnameContext hostname() {
      return getRuleContext(HostnameContext.class, 0);
    }

    public HostContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_host;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterHost(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitHost(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor) return ((URLVisitor<? extends T>) visitor).visitHost(this);
      else return visitor.visitChildren(this);
    }
  }

  public final HostContext host() throws RecognitionException {
    HostContext _localctx = new HostContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_host);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(63);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__2) {
          {
            setState(62);
            match(T__2);
          }
        }

        setState(65);
        hostname();
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
  public static class HostnameContext extends ParserRuleContext {
    public HostnameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_hostname;
    }

    public HostnameContext() {}

    public void copyFrom(HostnameContext ctx) {
      super.copyFrom(ctx);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class IPv6HostContext extends HostnameContext {
    public V6hostContext v6host() {
      return getRuleContext(V6hostContext.class, 0);
    }

    public IPv6HostContext(HostnameContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterIPv6Host(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitIPv6Host(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor)
        return ((URLVisitor<? extends T>) visitor).visitIPv6Host(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class DomainNameOrIPv4HostContext extends HostnameContext {
    public StringContext string() {
      return getRuleContext(StringContext.class, 0);
    }

    public DomainNameOrIPv4HostContext(HostnameContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterDomainNameOrIPv4Host(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitDomainNameOrIPv4Host(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor)
        return ((URLVisitor<? extends T>) visitor).visitDomainNameOrIPv4Host(this);
      else return visitor.visitChildren(this);
    }
  }

  public final HostnameContext hostname() throws RecognitionException {
    HostnameContext _localctx = new HostnameContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_hostname);
    try {
      setState(72);
      _errHandler.sync(this);
      switch (_input.LA(1)) {
        case DIGITS:
        case STRING:
          _localctx = new DomainNameOrIPv4HostContext(_localctx);
          enterOuterAlt(_localctx, 1);
          {
            setState(67);
            string();
          }
          break;
        case T__3:
          _localctx = new IPv6HostContext(_localctx);
          enterOuterAlt(_localctx, 2);
          {
            setState(68);
            match(T__3);
            setState(69);
            v6host();
            setState(70);
            match(T__4);
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
  public static class V6hostContext extends ParserRuleContext {
    public List<StringContext> string() {
      return getRuleContexts(StringContext.class);
    }

    public StringContext string(int i) {
      return getRuleContext(StringContext.class, i);
    }

    public List<TerminalNode> DIGITS() {
      return getTokens(URLParser.DIGITS);
    }

    public TerminalNode DIGITS(int i) {
      return getToken(URLParser.DIGITS, i);
    }

    public V6hostContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_v6host;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterV6host(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitV6host(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor)
        return ((URLVisitor<? extends T>) visitor).visitV6host(this);
      else return visitor.visitChildren(this);
    }
  }

  public final V6hostContext v6host() throws RecognitionException {
    V6hostContext _localctx = new V6hostContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_v6host);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(75);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__5) {
          {
            setState(74);
            match(T__5);
          }
        }

        setState(79);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 10, _ctx)) {
          case 1:
            {
              setState(77);
              string();
            }
            break;
          case 2:
            {
              setState(78);
              match(DIGITS);
            }
            break;
        }
        setState(88);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == T__1 || _la == T__5) {
          {
            {
              setState(81);
              _la = _input.LA(1);
              if (!(_la == T__1 || _la == T__5)) {
                _errHandler.recoverInline(this);
              } else {
                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                _errHandler.reportMatch(this);
                consume();
              }
              setState(84);
              _errHandler.sync(this);
              switch (getInterpreter().adaptivePredict(_input, 11, _ctx)) {
                case 1:
                  {
                    setState(82);
                    string();
                  }
                  break;
                case 2:
                  {
                    setState(83);
                    match(DIGITS);
                  }
                  break;
              }
            }
          }
          setState(90);
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
  public static class PortContext extends ParserRuleContext {
    public TerminalNode DIGITS() {
      return getToken(URLParser.DIGITS, 0);
    }

    public PortContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_port;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterPort(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitPort(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor) return ((URLVisitor<? extends T>) visitor).visitPort(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PortContext port() throws RecognitionException {
    PortContext _localctx = new PortContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_port);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(91);
        match(DIGITS);
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
  public static class PathContext extends ParserRuleContext {
    public List<StringContext> string() {
      return getRuleContexts(StringContext.class);
    }

    public StringContext string(int i) {
      return getRuleContext(StringContext.class, i);
    }

    public PathContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_path;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterPath(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitPath(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor) return ((URLVisitor<? extends T>) visitor).visitPath(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PathContext path() throws RecognitionException {
    PathContext _localctx = new PathContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_path);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(93);
        string();
        setState(98);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            {
              {
                setState(94);
                match(T__2);
                setState(95);
                string();
              }
            }
          }
          setState(100);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
        }
        setState(102);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__2) {
          {
            setState(101);
            match(T__2);
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
  public static class UserContext extends ParserRuleContext {
    public StringContext string() {
      return getRuleContext(StringContext.class, 0);
    }

    public UserContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_user;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterUser(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitUser(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor) return ((URLVisitor<? extends T>) visitor).visitUser(this);
      else return visitor.visitChildren(this);
    }
  }

  public final UserContext user() throws RecognitionException {
    UserContext _localctx = new UserContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_user);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(104);
        string();
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
  public static class LoginContext extends ParserRuleContext {
    public UserContext user() {
      return getRuleContext(UserContext.class, 0);
    }

    public PasswordContext password() {
      return getRuleContext(PasswordContext.class, 0);
    }

    public LoginContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_login;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterLogin(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitLogin(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor)
        return ((URLVisitor<? extends T>) visitor).visitLogin(this);
      else return visitor.visitChildren(this);
    }
  }

  public final LoginContext login() throws RecognitionException {
    LoginContext _localctx = new LoginContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_login);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(106);
        user();
        setState(109);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__1) {
          {
            setState(107);
            match(T__1);
            setState(108);
            password();
          }
        }

        setState(111);
        match(T__6);
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
  public static class PasswordContext extends ParserRuleContext {
    public StringContext string() {
      return getRuleContext(StringContext.class, 0);
    }

    public PasswordContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_password;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterPassword(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitPassword(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor)
        return ((URLVisitor<? extends T>) visitor).visitPassword(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PasswordContext password() throws RecognitionException {
    PasswordContext _localctx = new PasswordContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_password);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(113);
        string();
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
  public static class FragContext extends ParserRuleContext {
    public StringContext string() {
      return getRuleContext(StringContext.class, 0);
    }

    public TerminalNode DIGITS() {
      return getToken(URLParser.DIGITS, 0);
    }

    public FragContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_frag;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterFrag(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitFrag(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor) return ((URLVisitor<? extends T>) visitor).visitFrag(this);
      else return visitor.visitChildren(this);
    }
  }

  public final FragContext frag() throws RecognitionException {
    FragContext _localctx = new FragContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_frag);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(115);
        match(T__7);
        setState(118);
        _errHandler.sync(this);
        switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
          case 1:
            {
              setState(116);
              string();
            }
            break;
          case 2:
            {
              setState(117);
              match(DIGITS);
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
  public static class QueryContext extends ParserRuleContext {
    public SearchContext search() {
      return getRuleContext(SearchContext.class, 0);
    }

    public QueryContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_query;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterQuery(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitQuery(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor)
        return ((URLVisitor<? extends T>) visitor).visitQuery(this);
      else return visitor.visitChildren(this);
    }
  }

  public final QueryContext query() throws RecognitionException {
    QueryContext _localctx = new QueryContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_query);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(120);
        match(T__8);
        setState(121);
        search();
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
  public static class SearchContext extends ParserRuleContext {
    public List<SearchparameterContext> searchparameter() {
      return getRuleContexts(SearchparameterContext.class);
    }

    public SearchparameterContext searchparameter(int i) {
      return getRuleContext(SearchparameterContext.class, i);
    }

    public SearchContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_search;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterSearch(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitSearch(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor)
        return ((URLVisitor<? extends T>) visitor).visitSearch(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SearchContext search() throws RecognitionException {
    SearchContext _localctx = new SearchContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_search);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(123);
        searchparameter();
        setState(128);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la == T__9) {
          {
            {
              setState(124);
              match(T__9);
              setState(125);
              searchparameter();
            }
          }
          setState(130);
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
  public static class SearchparameterContext extends ParserRuleContext {
    public List<StringContext> string() {
      return getRuleContexts(StringContext.class);
    }

    public StringContext string(int i) {
      return getRuleContext(StringContext.class, i);
    }

    public TerminalNode DIGITS() {
      return getToken(URLParser.DIGITS, 0);
    }

    public TerminalNode HEX() {
      return getToken(URLParser.HEX, 0);
    }

    public SearchparameterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_searchparameter;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterSearchparameter(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitSearchparameter(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor)
        return ((URLVisitor<? extends T>) visitor).visitSearchparameter(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SearchparameterContext searchparameter() throws RecognitionException {
    SearchparameterContext _localctx = new SearchparameterContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_searchparameter);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(131);
        string();
        setState(138);
        _errHandler.sync(this);
        _la = _input.LA(1);
        if (_la == T__10) {
          {
            setState(132);
            match(T__10);
            setState(136);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 18, _ctx)) {
              case 1:
                {
                  setState(133);
                  string();
                }
                break;
              case 2:
                {
                  setState(134);
                  match(DIGITS);
                }
                break;
              case 3:
                {
                  setState(135);
                  match(HEX);
                }
                break;
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
  public static class StringContext extends ParserRuleContext {
    public TerminalNode STRING() {
      return getToken(URLParser.STRING, 0);
    }

    public TerminalNode DIGITS() {
      return getToken(URLParser.DIGITS, 0);
    }

    public StringContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_string;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).enterString(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof URLListener) ((URLListener) listener).exitString(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof URLVisitor)
        return ((URLVisitor<? extends T>) visitor).visitString(this);
      else return visitor.visitChildren(this);
    }
  }

  public final StringContext string() throws RecognitionException {
    StringContext _localctx = new StringContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_string);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(140);
        _la = _input.LA(1);
        if (!(_la == DIGITS || _la == STRING)) {
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

  public static final String _serializedATN =
      "\u0004\u0001\u000f\u008f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"
          + "\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"
          + "\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"
          + "\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"
          + "\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"
          + "\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"
          + "\u0001\u0003\u0001\'\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"
          + "\u0001,\b\u0001\u0001\u0001\u0001\u0001\u0003\u00010\b\u0001\u0003\u0001"
          + "2\b\u0001\u0001\u0001\u0003\u00015\b\u0001\u0001\u0001\u0003\u00018\b"
          + "\u0001\u0001\u0001\u0003\u0001;\b\u0001\u0001\u0002\u0001\u0002\u0001"
          + "\u0003\u0003\u0003@\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"
          + "\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004I\b\u0004\u0001"
          + "\u0005\u0003\u0005L\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005P\b\u0005"
          + "\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005U\b\u0005\u0005\u0005"
          + "W\b\u0005\n\u0005\f\u0005Z\t\u0005\u0001\u0006\u0001\u0006\u0001\u0007"
          + "\u0001\u0007\u0001\u0007\u0005\u0007a\b\u0007\n\u0007\f\u0007d\t\u0007"
          + "\u0001\u0007\u0003\u0007g\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"
          + "\t\u0003\tn\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"
          + "\u0001\u000b\u0003\u000bw\b\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001"
          + "\r\u0001\r\u0005\r\u007f\b\r\n\r\f\r\u0082\t\r\u0001\u000e\u0001\u000e"
          + "\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0089\b\u000e\u0003\u000e"
          + "\u008b\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0000\u0000\u0010\u0000"
          + "\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"
          + "\u001e\u0000\u0002\u0002\u0000\u0002\u0002\u0006\u0006\u0002\u0000\f\f"
          + "\u000e\u000e\u0093\u0000 \u0001\u0000\u0000\u0000\u0002#\u0001\u0000\u0000"
          + "\u0000\u0004<\u0001\u0000\u0000\u0000\u0006?\u0001\u0000\u0000\u0000\b"
          + "H\u0001\u0000\u0000\u0000\nK\u0001\u0000\u0000\u0000\f[\u0001\u0000\u0000"
          + "\u0000\u000e]\u0001\u0000\u0000\u0000\u0010h\u0001\u0000\u0000\u0000\u0012"
          + "j\u0001\u0000\u0000\u0000\u0014q\u0001\u0000\u0000\u0000\u0016s\u0001"
          + "\u0000\u0000\u0000\u0018x\u0001\u0000\u0000\u0000\u001a{\u0001\u0000\u0000"
          + "\u0000\u001c\u0083\u0001\u0000\u0000\u0000\u001e\u008c\u0001\u0000\u0000"
          + "\u0000 !\u0003\u0002\u0001\u0000!\"\u0005\u0000\u0000\u0001\"\u0001\u0001"
          + "\u0000\u0000\u0000#$\u0003\u0004\u0002\u0000$&\u0005\u0001\u0000\u0000"
          + "%\'\u0003\u0012\t\u0000&%\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000"
          + "\u0000\'(\u0001\u0000\u0000\u0000(+\u0003\u0006\u0003\u0000)*\u0005\u0002"
          + "\u0000\u0000*,\u0003\f\u0006\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000"
          + "\u0000\u0000,1\u0001\u0000\u0000\u0000-/\u0005\u0003\u0000\u0000.0\u0003"
          + "\u000e\u0007\u0000/.\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u0000"
          + "02\u0001\u0000\u0000\u00001-\u0001\u0000\u0000\u000012\u0001\u0000\u0000"
          + "\u000024\u0001\u0000\u0000\u000035\u0003\u0018\f\u000043\u0001\u0000\u0000"
          + "\u000045\u0001\u0000\u0000\u000057\u0001\u0000\u0000\u000068\u0003\u0016"
          + "\u000b\u000076\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u00008:\u0001"
          + "\u0000\u0000\u00009;\u0005\u000f\u0000\u0000:9\u0001\u0000\u0000\u0000"
          + ":;\u0001\u0000\u0000\u0000;\u0003\u0001\u0000\u0000\u0000<=\u0003\u001e"
          + "\u000f\u0000=\u0005\u0001\u0000\u0000\u0000>@\u0005\u0003\u0000\u0000"
          + "?>\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000"
          + "\u0000AB\u0003\b\u0004\u0000B\u0007\u0001\u0000\u0000\u0000CI\u0003\u001e"
          + "\u000f\u0000DE\u0005\u0004\u0000\u0000EF\u0003\n\u0005\u0000FG\u0005\u0005"
          + "\u0000\u0000GI\u0001\u0000\u0000\u0000HC\u0001\u0000\u0000\u0000HD\u0001"
          + "\u0000\u0000\u0000I\t\u0001\u0000\u0000\u0000JL\u0005\u0006\u0000\u0000"
          + "KJ\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000"
          + "\u0000MP\u0003\u001e\u000f\u0000NP\u0005\f\u0000\u0000OM\u0001\u0000\u0000"
          + "\u0000ON\u0001\u0000\u0000\u0000PX\u0001\u0000\u0000\u0000QT\u0007\u0000"
          + "\u0000\u0000RU\u0003\u001e\u000f\u0000SU\u0005\f\u0000\u0000TR\u0001\u0000"
          + "\u0000\u0000TS\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VQ\u0001"
          + "\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"
          + "XY\u0001\u0000\u0000\u0000Y\u000b\u0001\u0000\u0000\u0000ZX\u0001\u0000"
          + "\u0000\u0000[\\\u0005\f\u0000\u0000\\\r\u0001\u0000\u0000\u0000]b\u0003"
          + "\u001e\u000f\u0000^_\u0005\u0003\u0000\u0000_a\u0003\u001e\u000f\u0000"
          + "`^\u0001\u0000\u0000\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000"
          + "\u0000bc\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000db\u0001\u0000"
          + "\u0000\u0000eg\u0005\u0003\u0000\u0000fe\u0001\u0000\u0000\u0000fg\u0001"
          + "\u0000\u0000\u0000g\u000f\u0001\u0000\u0000\u0000hi\u0003\u001e\u000f"
          + "\u0000i\u0011\u0001\u0000\u0000\u0000jm\u0003\u0010\b\u0000kl\u0005\u0002"
          + "\u0000\u0000ln\u0003\u0014\n\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000"
          + "\u0000\u0000no\u0001\u0000\u0000\u0000op\u0005\u0007\u0000\u0000p\u0013"
          + "\u0001\u0000\u0000\u0000qr\u0003\u001e\u000f\u0000r\u0015\u0001\u0000"
          + "\u0000\u0000sv\u0005\b\u0000\u0000tw\u0003\u001e\u000f\u0000uw\u0005\f"
          + "\u0000\u0000vt\u0001\u0000\u0000\u0000vu\u0001\u0000\u0000\u0000w\u0017"
          + "\u0001\u0000\u0000\u0000xy\u0005\t\u0000\u0000yz\u0003\u001a\r\u0000z"
          + "\u0019\u0001\u0000\u0000\u0000{\u0080\u0003\u001c\u000e\u0000|}\u0005"
          + "\n\u0000\u0000}\u007f\u0003\u001c\u000e\u0000~|\u0001\u0000\u0000\u0000"
          + "\u007f\u0082\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080"
          + "\u0081\u0001\u0000\u0000\u0000\u0081\u001b\u0001\u0000\u0000\u0000\u0082"
          + "\u0080\u0001\u0000\u0000\u0000\u0083\u008a\u0003\u001e\u000f\u0000\u0084"
          + "\u0088\u0005\u000b\u0000\u0000\u0085\u0089\u0003\u001e\u000f\u0000\u0086"
          + "\u0089\u0005\f\u0000\u0000\u0087\u0089\u0005\r\u0000\u0000\u0088\u0085"
          + "\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0087"
          + "\u0001\u0000\u0000\u0000\u0089\u008b\u0001\u0000\u0000\u0000\u008a\u0084"
          + "\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u001d"
          + "\u0001\u0000\u0000\u0000\u008c\u008d\u0007\u0001\u0000\u0000\u008d\u001f"
          + "\u0001\u0000\u0000\u0000\u0014&+/147:?HKOTXbfmv\u0080\u0088\u008a";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
