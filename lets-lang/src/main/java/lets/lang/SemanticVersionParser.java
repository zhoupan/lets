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
public class SemanticVersionParser extends Parser {
  static {
    RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int DASH = 1,
      PLUS = 2,
      DOT = 3,
      ALPHA = 4,
      BETA = 5,
      RC = 6,
      SNAPSHOT = 7,
      PREVIEW = 8,
      DEV = 9,
      MILESTONE = 10,
      DAILY = 11,
      NIGHTLY = 12,
      BUILD = 13,
      TEST = 14,
      EXPERIMENTAL = 15,
      NUMBER = 16,
      IDENTIFIER = 17;
  public static final int RULE_tag = 0,
      RULE_build = 1,
      RULE_preRelease = 2,
      RULE_versionCore = 3,
      RULE_semver = 4;

  private static String[] makeRuleNames() {
    return new String[] {"tag", "build", "preRelease", "versionCore", "semver"};
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {
      null,
      "'-'",
      "'+'",
      "'.'",
      "'alpha'",
      "'beta'",
      null,
      "'snapshot'",
      null,
      null,
      null,
      "'daily'",
      "'nightly'",
      null,
      "'test'",
      "'experimental'"
    };
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      "DASH",
      "PLUS",
      "DOT",
      "ALPHA",
      "BETA",
      "RC",
      "SNAPSHOT",
      "PREVIEW",
      "DEV",
      "MILESTONE",
      "DAILY",
      "NIGHTLY",
      "BUILD",
      "TEST",
      "EXPERIMENTAL",
      "NUMBER",
      "IDENTIFIER"
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
    return "SemanticVersionParser.g4";
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

  public SemanticVersionParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @SuppressWarnings("CheckReturnValue")
  public static class TagContext extends ParserRuleContext {
    public TerminalNode ALPHA() {
      return getToken(SemanticVersionParser.ALPHA, 0);
    }

    public TerminalNode BETA() {
      return getToken(SemanticVersionParser.BETA, 0);
    }

    public TerminalNode RC() {
      return getToken(SemanticVersionParser.RC, 0);
    }

    public TerminalNode SNAPSHOT() {
      return getToken(SemanticVersionParser.SNAPSHOT, 0);
    }

    public TerminalNode PREVIEW() {
      return getToken(SemanticVersionParser.PREVIEW, 0);
    }

    public TerminalNode DEV() {
      return getToken(SemanticVersionParser.DEV, 0);
    }

    public TerminalNode MILESTONE() {
      return getToken(SemanticVersionParser.MILESTONE, 0);
    }

    public TerminalNode DAILY() {
      return getToken(SemanticVersionParser.DAILY, 0);
    }

    public TerminalNode NIGHTLY() {
      return getToken(SemanticVersionParser.NIGHTLY, 0);
    }

    public TerminalNode BUILD() {
      return getToken(SemanticVersionParser.BUILD, 0);
    }

    public TerminalNode TEST() {
      return getToken(SemanticVersionParser.TEST, 0);
    }

    public TerminalNode EXPERIMENTAL() {
      return getToken(SemanticVersionParser.EXPERIMENTAL, 0);
    }

    public TagContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_tag;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterTag(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitTag(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor).visitTag(this);
      else return visitor.visitChildren(this);
    }
  }

  public final TagContext tag() throws RecognitionException {
    TagContext _localctx = new TagContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_tag);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(10);
        _la = _input.LA(1);
        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 65520L) != 0))) {
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
  public static class BuildContext extends ParserRuleContext {
    public BuildContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_build;
    }

    public BuildContext() {}

    public void copyFrom(BuildContext ctx) {
      super.copyFrom(ctx);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BuildNumberContext extends BuildContext {
    public Token value;

    public TerminalNode NUMBER() {
      return getToken(SemanticVersionParser.NUMBER, 0);
    }

    public BuildNumberContext(BuildContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterBuildNumber(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitBuildNumber(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor).visitBuildNumber(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BuildIdentifierExtendedContext extends BuildContext {
    public BuildContext left;
    public BuildContext right;

    public List<BuildContext> build() {
      return getRuleContexts(BuildContext.class);
    }

    public BuildContext build(int i) {
      return getRuleContext(BuildContext.class, i);
    }

    public TerminalNode DOT() {
      return getToken(SemanticVersionParser.DOT, 0);
    }

    public TerminalNode DASH() {
      return getToken(SemanticVersionParser.DASH, 0);
    }

    public BuildIdentifierExtendedContext(BuildContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterBuildIdentifierExtended(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitBuildIdentifierExtended(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor)
            .visitBuildIdentifierExtended(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BuildDashContext extends BuildContext {
    public TerminalNode DASH() {
      return getToken(SemanticVersionParser.DASH, 0);
    }

    public BuildDashContext(BuildContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterBuildDash(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitBuildDash(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor).visitBuildDash(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BuildIdentifierContext extends BuildContext {
    public Token value;

    public TerminalNode IDENTIFIER() {
      return getToken(SemanticVersionParser.IDENTIFIER, 0);
    }

    public BuildIdentifierContext(BuildContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterBuildIdentifier(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitBuildIdentifier(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor).visitBuildIdentifier(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class BuildTaggedContext extends BuildContext {
    public Token version;

    public TagContext tag() {
      return getRuleContext(TagContext.class, 0);
    }

    public TerminalNode DOT() {
      return getToken(SemanticVersionParser.DOT, 0);
    }

    public TerminalNode DASH() {
      return getToken(SemanticVersionParser.DASH, 0);
    }

    public TerminalNode NUMBER() {
      return getToken(SemanticVersionParser.NUMBER, 0);
    }

    public TerminalNode IDENTIFIER() {
      return getToken(SemanticVersionParser.IDENTIFIER, 0);
    }

    public BuildTaggedContext(BuildContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterBuildTagged(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitBuildTagged(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor).visitBuildTagged(this);
      else return visitor.visitChildren(this);
    }
  }

  public final BuildContext build() throws RecognitionException {
    return build(0);
  }

  private BuildContext build(int _p) throws RecognitionException {
    ParserRuleContext _parentctx = _ctx;
    int _parentState = getState();
    BuildContext _localctx = new BuildContext(_ctx, _parentState);
    BuildContext _prevctx = _localctx;
    int _startState = 2;
    enterRecursionRule(_localctx, 2, RULE_build, _p);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(23);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case NUMBER:
            {
              _localctx = new BuildNumberContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;

              setState(13);
              ((BuildNumberContext) _localctx).value = match(NUMBER);
            }
            break;
          case DASH:
            {
              _localctx = new BuildDashContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(14);
              match(DASH);
            }
            break;
          case ALPHA:
          case BETA:
          case RC:
          case SNAPSHOT:
          case PREVIEW:
          case DEV:
          case MILESTONE:
          case DAILY:
          case NIGHTLY:
          case BUILD:
          case TEST:
          case EXPERIMENTAL:
            {
              _localctx = new BuildTaggedContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(15);
              tag();
              setState(17);
              _errHandler.sync(this);
              switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                case 1:
                  {
                    setState(16);
                    _la = _input.LA(1);
                    if (!(_la == DASH || _la == DOT)) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                  }
                  break;
              }
              setState(20);
              _errHandler.sync(this);
              switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                  {
                    setState(19);
                    ((BuildTaggedContext) _localctx).version = _input.LT(1);
                    _la = _input.LA(1);
                    if (!(_la == NUMBER || _la == IDENTIFIER)) {
                      ((BuildTaggedContext) _localctx).version =
                          (Token) _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                  }
                  break;
              }
            }
            break;
          case IDENTIFIER:
            {
              _localctx = new BuildIdentifierContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(22);
              ((BuildIdentifierContext) _localctx).value = match(IDENTIFIER);
            }
            break;
          default:
            throw new NoViableAltException(this);
        }
        _ctx.stop = _input.LT(-1);
        setState(32);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (_parseListeners != null) triggerExitRuleEvent();
            _prevctx = _localctx;
            {
              {
                _localctx =
                    new BuildIdentifierExtendedContext(new BuildContext(_parentctx, _parentState));
                ((BuildIdentifierExtendedContext) _localctx).left = _prevctx;
                pushNewRecursionContext(_localctx, _startState, RULE_build);
                setState(25);
                if (!(precpred(_ctx, 1)))
                  throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                setState(27);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                  case 1:
                    {
                      setState(26);
                      _la = _input.LA(1);
                      if (!(_la == DASH || _la == DOT)) {
                        _errHandler.recoverInline(this);
                      } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                      }
                    }
                    break;
                }
                setState(29);
                ((BuildIdentifierExtendedContext) _localctx).right = build(2);
              }
            }
          }
          setState(34);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
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
  public static class PreReleaseContext extends ParserRuleContext {
    public PreReleaseContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_preRelease;
    }

    public PreReleaseContext() {}

    public void copyFrom(PreReleaseContext ctx) {
      super.copyFrom(ctx);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PreReleaseDashContext extends PreReleaseContext {
    public TerminalNode DASH() {
      return getToken(SemanticVersionParser.DASH, 0);
    }

    public PreReleaseDashContext(PreReleaseContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterPreReleaseDash(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitPreReleaseDash(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor).visitPreReleaseDash(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PreReleaseIdentifierContext extends PreReleaseContext {
    public Token value;

    public TerminalNode IDENTIFIER() {
      return getToken(SemanticVersionParser.IDENTIFIER, 0);
    }

    public PreReleaseIdentifierContext(PreReleaseContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterPreReleaseIdentifier(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitPreReleaseIdentifier(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor)
            .visitPreReleaseIdentifier(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PreReleaseTaggedContext extends PreReleaseContext {
    public Token version;

    public TagContext tag() {
      return getRuleContext(TagContext.class, 0);
    }

    public TerminalNode DOT() {
      return getToken(SemanticVersionParser.DOT, 0);
    }

    public TerminalNode DASH() {
      return getToken(SemanticVersionParser.DASH, 0);
    }

    public TerminalNode NUMBER() {
      return getToken(SemanticVersionParser.NUMBER, 0);
    }

    public TerminalNode IDENTIFIER() {
      return getToken(SemanticVersionParser.IDENTIFIER, 0);
    }

    public PreReleaseTaggedContext(PreReleaseContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterPreReleaseTagged(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitPreReleaseTagged(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor).visitPreReleaseTagged(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PreReleaseIdentifierExtendedContext extends PreReleaseContext {
    public PreReleaseContext left;
    public PreReleaseContext right;

    public List<PreReleaseContext> preRelease() {
      return getRuleContexts(PreReleaseContext.class);
    }

    public PreReleaseContext preRelease(int i) {
      return getRuleContext(PreReleaseContext.class, i);
    }

    public TerminalNode DOT() {
      return getToken(SemanticVersionParser.DOT, 0);
    }

    public TerminalNode DASH() {
      return getToken(SemanticVersionParser.DASH, 0);
    }

    public PreReleaseIdentifierExtendedContext(PreReleaseContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterPreReleaseIdentifierExtended(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitPreReleaseIdentifierExtended(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor)
            .visitPreReleaseIdentifierExtended(this);
      else return visitor.visitChildren(this);
    }
  }

  @SuppressWarnings("CheckReturnValue")
  public static class PreReleaseNumberContext extends PreReleaseContext {
    public Token value;

    public TerminalNode NUMBER() {
      return getToken(SemanticVersionParser.NUMBER, 0);
    }

    public PreReleaseNumberContext(PreReleaseContext ctx) {
      copyFrom(ctx);
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterPreReleaseNumber(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitPreReleaseNumber(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor).visitPreReleaseNumber(this);
      else return visitor.visitChildren(this);
    }
  }

  public final PreReleaseContext preRelease() throws RecognitionException {
    return preRelease(0);
  }

  private PreReleaseContext preRelease(int _p) throws RecognitionException {
    ParserRuleContext _parentctx = _ctx;
    int _parentState = getState();
    PreReleaseContext _localctx = new PreReleaseContext(_ctx, _parentState);
    PreReleaseContext _prevctx = _localctx;
    int _startState = 4;
    enterRecursionRule(_localctx, 4, RULE_preRelease, _p);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
        setState(46);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case NUMBER:
            {
              _localctx = new PreReleaseNumberContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;

              setState(36);
              ((PreReleaseNumberContext) _localctx).value = match(NUMBER);
            }
            break;
          case DASH:
            {
              _localctx = new PreReleaseDashContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(37);
              match(DASH);
            }
            break;
          case ALPHA:
          case BETA:
          case RC:
          case SNAPSHOT:
          case PREVIEW:
          case DEV:
          case MILESTONE:
          case DAILY:
          case NIGHTLY:
          case BUILD:
          case TEST:
          case EXPERIMENTAL:
            {
              _localctx = new PreReleaseTaggedContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(38);
              tag();
              setState(40);
              _errHandler.sync(this);
              switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                case 1:
                  {
                    setState(39);
                    _la = _input.LA(1);
                    if (!(_la == DASH || _la == DOT)) {
                      _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                  }
                  break;
              }
              setState(43);
              _errHandler.sync(this);
              switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
                case 1:
                  {
                    setState(42);
                    ((PreReleaseTaggedContext) _localctx).version = _input.LT(1);
                    _la = _input.LA(1);
                    if (!(_la == NUMBER || _la == IDENTIFIER)) {
                      ((PreReleaseTaggedContext) _localctx).version =
                          (Token) _errHandler.recoverInline(this);
                    } else {
                      if (_input.LA(1) == Token.EOF) matchedEOF = true;
                      _errHandler.reportMatch(this);
                      consume();
                    }
                  }
                  break;
              }
            }
            break;
          case IDENTIFIER:
            {
              _localctx = new PreReleaseIdentifierContext(_localctx);
              _ctx = _localctx;
              _prevctx = _localctx;
              setState(45);
              ((PreReleaseIdentifierContext) _localctx).value = match(IDENTIFIER);
            }
            break;
          default:
            throw new NoViableAltException(this);
        }
        _ctx.stop = _input.LT(-1);
        setState(55);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
          if (_alt == 1) {
            if (_parseListeners != null) triggerExitRuleEvent();
            _prevctx = _localctx;
            {
              {
                _localctx =
                    new PreReleaseIdentifierExtendedContext(
                        new PreReleaseContext(_parentctx, _parentState));
                ((PreReleaseIdentifierExtendedContext) _localctx).left = _prevctx;
                pushNewRecursionContext(_localctx, _startState, RULE_preRelease);
                setState(48);
                if (!(precpred(_ctx, 1)))
                  throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                setState(50);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 8, _ctx)) {
                  case 1:
                    {
                      setState(49);
                      _la = _input.LA(1);
                      if (!(_la == DASH || _la == DOT)) {
                        _errHandler.recoverInline(this);
                      } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                      }
                    }
                    break;
                }
                setState(52);
                ((PreReleaseIdentifierExtendedContext) _localctx).right = preRelease(2);
              }
            }
          }
          setState(57);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
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
  public static class VersionCoreContext extends ParserRuleContext {
    public Token major;
    public Token minor;
    public Token patch;

    public List<TerminalNode> DOT() {
      return getTokens(SemanticVersionParser.DOT);
    }

    public TerminalNode DOT(int i) {
      return getToken(SemanticVersionParser.DOT, i);
    }

    public List<TerminalNode> NUMBER() {
      return getTokens(SemanticVersionParser.NUMBER);
    }

    public TerminalNode NUMBER(int i) {
      return getToken(SemanticVersionParser.NUMBER, i);
    }

    public VersionCoreContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_versionCore;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterVersionCore(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitVersionCore(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor).visitVersionCore(this);
      else return visitor.visitChildren(this);
    }
  }

  public final VersionCoreContext versionCore() throws RecognitionException {
    VersionCoreContext _localctx = new VersionCoreContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_versionCore);
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(58);
        ((VersionCoreContext) _localctx).major = match(NUMBER);
        setState(59);
        match(DOT);
        setState(60);
        ((VersionCoreContext) _localctx).minor = match(NUMBER);
        setState(61);
        match(DOT);
        setState(62);
        ((VersionCoreContext) _localctx).patch = match(NUMBER);
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
  public static class SemverContext extends ParserRuleContext {
    public VersionCoreContext versionCore() {
      return getRuleContext(VersionCoreContext.class, 0);
    }

    public TerminalNode EOF() {
      return getToken(SemanticVersionParser.EOF, 0);
    }

    public TerminalNode DASH() {
      return getToken(SemanticVersionParser.DASH, 0);
    }

    public PreReleaseContext preRelease() {
      return getRuleContext(PreReleaseContext.class, 0);
    }

    public TerminalNode PLUS() {
      return getToken(SemanticVersionParser.PLUS, 0);
    }

    public BuildContext build() {
      return getRuleContext(BuildContext.class, 0);
    }

    public SemverContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }

    @Override
    public int getRuleIndex() {
      return RULE_semver;
    }

    @Override
    public void enterRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).enterSemver(this);
    }

    @Override
    public void exitRule(ParseTreeListener listener) {
      if (listener instanceof SemanticVersionParserListener)
        ((SemanticVersionParserListener) listener).exitSemver(this);
    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
      if (visitor instanceof SemanticVersionParserVisitor)
        return ((SemanticVersionParserVisitor<? extends T>) visitor).visitSemver(this);
      else return visitor.visitChildren(this);
    }
  }

  public final SemverContext semver() throws RecognitionException {
    SemverContext _localctx = new SemverContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_semver);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
        setState(64);
        versionCore();
        setState(73);
        _errHandler.sync(this);
        switch (_input.LA(1)) {
          case DASH:
            {
              setState(65);
              match(DASH);
              setState(66);
              preRelease(0);
              setState(69);
              _errHandler.sync(this);
              _la = _input.LA(1);
              if (_la == PLUS) {
                {
                  setState(67);
                  match(PLUS);
                  setState(68);
                  build(0);
                }
              }
            }
            break;
          case PLUS:
            {
              setState(71);
              match(PLUS);
              setState(72);
              build(0);
            }
            break;
          case EOF:
            break;
          default:
            break;
        }
        setState(75);
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

  public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
    switch (ruleIndex) {
      case 1:
        return build_sempred((BuildContext) _localctx, predIndex);
      case 2:
        return preRelease_sempred((PreReleaseContext) _localctx, predIndex);
    }
    return true;
  }

  private boolean build_sempred(BuildContext _localctx, int predIndex) {
    switch (predIndex) {
      case 0:
        return precpred(_ctx, 1);
    }
    return true;
  }

  private boolean preRelease_sempred(PreReleaseContext _localctx, int predIndex) {
    switch (predIndex) {
      case 1:
        return precpred(_ctx, 1);
    }
    return true;
  }

  public static final String _serializedATN =
      "\u0004\u0001\u0011N\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
          + "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"
          + "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"
          + "\u0001\u0003\u0001\u0012\b\u0001\u0001\u0001\u0003\u0001\u0015\b\u0001"
          + "\u0001\u0001\u0003\u0001\u0018\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001"
          + "\u001c\b\u0001\u0001\u0001\u0005\u0001\u001f\b\u0001\n\u0001\f\u0001\""
          + "\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"
          + "\u0002)\b\u0002\u0001\u0002\u0003\u0002,\b\u0002\u0001\u0002\u0003\u0002"
          + "/\b\u0002\u0001\u0002\u0001\u0002\u0003\u00023\b\u0002\u0001\u0002\u0005"
          + "\u00026\b\u0002\n\u0002\f\u00029\t\u0002\u0001\u0003\u0001\u0003\u0001"
          + "\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"
          + "\u0004\u0001\u0004\u0001\u0004\u0003\u0004F\b\u0004\u0001\u0004\u0001"
          + "\u0004\u0003\u0004J\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0000"
          + "\u0002\u0002\u0004\u0005\u0000\u0002\u0004\u0006\b\u0000\u0003\u0001\u0000"
          + "\u0004\u000f\u0002\u0000\u0001\u0001\u0003\u0003\u0001\u0000\u0010\u0011"
          + "Y\u0000\n\u0001\u0000\u0000\u0000\u0002\u0017\u0001\u0000\u0000\u0000"
          + "\u0004.\u0001\u0000\u0000\u0000\u0006:\u0001\u0000\u0000\u0000\b@\u0001"
          + "\u0000\u0000\u0000\n\u000b\u0007\u0000\u0000\u0000\u000b\u0001\u0001\u0000"
          + "\u0000\u0000\f\r\u0006\u0001\uffff\uffff\u0000\r\u0018\u0005\u0010\u0000"
          + "\u0000\u000e\u0018\u0005\u0001\u0000\u0000\u000f\u0011\u0003\u0000\u0000"
          + "\u0000\u0010\u0012\u0007\u0001\u0000\u0000\u0011\u0010\u0001\u0000\u0000"
          + "\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0014\u0001\u0000\u0000"
          + "\u0000\u0013\u0015\u0007\u0002\u0000\u0000\u0014\u0013\u0001\u0000\u0000"
          + "\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015\u0018\u0001\u0000\u0000"
          + "\u0000\u0016\u0018\u0005\u0011\u0000\u0000\u0017\f\u0001\u0000\u0000\u0000"
          + "\u0017\u000e\u0001\u0000\u0000\u0000\u0017\u000f\u0001\u0000\u0000\u0000"
          + "\u0017\u0016\u0001\u0000\u0000\u0000\u0018 \u0001\u0000\u0000\u0000\u0019"
          + "\u001b\n\u0001\u0000\u0000\u001a\u001c\u0007\u0001\u0000\u0000\u001b\u001a"
          + "\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d"
          + "\u0001\u0000\u0000\u0000\u001d\u001f\u0003\u0002\u0001\u0002\u001e\u0019"
          + "\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001"
          + "\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u0003\u0001\u0000\u0000"
          + "\u0000\" \u0001\u0000\u0000\u0000#$\u0006\u0002\uffff\uffff\u0000$/\u0005"
          + "\u0010\u0000\u0000%/\u0005\u0001\u0000\u0000&(\u0003\u0000\u0000\u0000"
          + "\')\u0007\u0001\u0000\u0000(\'\u0001\u0000\u0000\u0000()\u0001\u0000\u0000"
          + "\u0000)+\u0001\u0000\u0000\u0000*,\u0007\u0002\u0000\u0000+*\u0001\u0000"
          + "\u0000\u0000+,\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-/\u0005"
          + "\u0011\u0000\u0000.#\u0001\u0000\u0000\u0000.%\u0001\u0000\u0000\u0000"
          + ".&\u0001\u0000\u0000\u0000.-\u0001\u0000\u0000\u0000/7\u0001\u0000\u0000"
          + "\u000002\n\u0001\u0000\u000013\u0007\u0001\u0000\u000021\u0001\u0000\u0000"
          + "\u000023\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000046\u0003\u0004"
          + "\u0002\u000250\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001"
          + "\u0000\u0000\u000078\u0001\u0000\u0000\u00008\u0005\u0001\u0000\u0000"
          + "\u000097\u0001\u0000\u0000\u0000:;\u0005\u0010\u0000\u0000;<\u0005\u0003"
          + "\u0000\u0000<=\u0005\u0010\u0000\u0000=>\u0005\u0003\u0000\u0000>?\u0005"
          + "\u0010\u0000\u0000?\u0007\u0001\u0000\u0000\u0000@I\u0003\u0006\u0003"
          + "\u0000AB\u0005\u0001\u0000\u0000BE\u0003\u0004\u0002\u0000CD\u0005\u0002"
          + "\u0000\u0000DF\u0003\u0002\u0001\u0000EC\u0001\u0000\u0000\u0000EF\u0001"
          + "\u0000\u0000\u0000FJ\u0001\u0000\u0000\u0000GH\u0005\u0002\u0000\u0000"
          + "HJ\u0003\u0002\u0001\u0000IA\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000"
          + "\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0005\u0000"
          + "\u0000\u0001L\t\u0001\u0000\u0000\u0000\f\u0011\u0014\u0017\u001b (+."
          + "27EI";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
