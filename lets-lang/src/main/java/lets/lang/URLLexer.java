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

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({
  "all",
  "warnings",
  "unchecked",
  "unused",
  "cast",
  "CheckReturnValue",
  "this-escape"
})
public class URLLexer extends Lexer {
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
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  private static String[] makeRuleNames() {
    return new String[] {
      "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", "T__9", "T__10",
      "DIGITS", "HEX", "STRING", "WS"
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

  public URLLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
  public String[] getChannelNames() {
    return channelNames;
  }

  @Override
  public String[] getModeNames() {
    return modeNames;
  }

  @Override
  public ATN getATN() {
    return _ATN;
  }

  public static final String _serializedATN =
      "\u0004\u0000\u000fT\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"
          + "\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"
          + "\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"
          + "\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"
          + "\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001"
          + "\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"
          + "\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"
          + "\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"
          + "\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0004"
          + "\u000b:\b\u000b\u000b\u000b\f\u000b;\u0001\f\u0001\f\u0001\f\u0004\fA"
          + "\b\f\u000b\f\f\fB\u0001\r\u0001\r\u0003\rG\b\r\u0001\r\u0001\r\u0005\r"
          + "K\b\r\n\r\f\rN\t\r\u0001\u000e\u0004\u000eQ\b\u000e\u000b\u000e\f\u000e"
          + "R\u0000\u0000\u000f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"
          + "\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f"
          + "\u0019\r\u001b\u000e\u001d\u000f\u0001\u0000\u0005\u0001\u000009\u0003"
          + "\u000009AFaf\u0004\u000009AZaz~~\u0005\u0000++-.09AZaz\u0002\u0000\n\n"
          + "\r\rY\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"
          + "\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"
          + "\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"
          + "\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"
          + "\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"
          + "\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"
          + "\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"
          + "\u001d\u0001\u0000\u0000\u0000\u0001\u001f\u0001\u0000\u0000\u0000\u0003"
          + "#\u0001\u0000\u0000\u0000\u0005%\u0001\u0000\u0000\u0000\u0007\'\u0001"
          + "\u0000\u0000\u0000\t)\u0001\u0000\u0000\u0000\u000b+\u0001\u0000\u0000"
          + "\u0000\r.\u0001\u0000\u0000\u0000\u000f0\u0001\u0000\u0000\u0000\u0011"
          + "2\u0001\u0000\u0000\u0000\u00134\u0001\u0000\u0000\u0000\u00156\u0001"
          + "\u0000\u0000\u0000\u00179\u0001\u0000\u0000\u0000\u0019@\u0001\u0000\u0000"
          + "\u0000\u001bF\u0001\u0000\u0000\u0000\u001dP\u0001\u0000\u0000\u0000\u001f"
          + " \u0005:\u0000\u0000 !\u0005/\u0000\u0000!\"\u0005/\u0000\u0000\"\u0002"
          + "\u0001\u0000\u0000\u0000#$\u0005:\u0000\u0000$\u0004\u0001\u0000\u0000"
          + "\u0000%&\u0005/\u0000\u0000&\u0006\u0001\u0000\u0000\u0000\'(\u0005[\u0000"
          + "\u0000(\b\u0001\u0000\u0000\u0000)*\u0005]\u0000\u0000*\n\u0001\u0000"
          + "\u0000\u0000+,\u0005:\u0000\u0000,-\u0005:\u0000\u0000-\f\u0001\u0000"
          + "\u0000\u0000./\u0005@\u0000\u0000/\u000e\u0001\u0000\u0000\u000001\u0005"
          + "#\u0000\u00001\u0010\u0001\u0000\u0000\u000023\u0005?\u0000\u00003\u0012"
          + "\u0001\u0000\u0000\u000045\u0005&\u0000\u00005\u0014\u0001\u0000\u0000"
          + "\u000067\u0005=\u0000\u00007\u0016\u0001\u0000\u0000\u00008:\u0007\u0000"
          + "\u0000\u000098\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;9\u0001"
          + "\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<\u0018\u0001\u0000\u0000"
          + "\u0000=>\u0005%\u0000\u0000>?\u0007\u0001\u0000\u0000?A\u0007\u0001\u0000"
          + "\u0000@=\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B@\u0001\u0000"
          + "\u0000\u0000BC\u0001\u0000\u0000\u0000C\u001a\u0001\u0000\u0000\u0000"
          + "DG\u0007\u0002\u0000\u0000EG\u0003\u0019\f\u0000FD\u0001\u0000\u0000\u0000"
          + "FE\u0001\u0000\u0000\u0000GL\u0001\u0000\u0000\u0000HK\u0007\u0003\u0000"
          + "\u0000IK\u0003\u0019\f\u0000JH\u0001\u0000\u0000\u0000JI\u0001\u0000\u0000"
          + "\u0000KN\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000"
          + "\u0000\u0000M\u001c\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000"
          + "OQ\u0007\u0004\u0000\u0000PO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"
          + "\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000S\u001e\u0001"
          + "\u0000\u0000\u0000\u0007\u0000;BFJLR\u0000";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
