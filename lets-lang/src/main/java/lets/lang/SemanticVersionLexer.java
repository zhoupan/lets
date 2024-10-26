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
public class SemanticVersionLexer extends Lexer {
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
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  private static String[] makeRuleNames() {
    return new String[] {
      "DIGIT",
      "POSITIVE_DIGIT",
      "LETTER",
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

  public SemanticVersionLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @Override
  public String getGrammarFileName() {
    return "SemanticVersionLexer.g4";
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
      "\u0004\u0000\u0011\u00c7\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"
          + "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"
          + "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"
          + "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"
          + "\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"
          + "\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"
          + "\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"
          + "\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"
          + "\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"
          + "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"
          + "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"
          + "\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"
          + "\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bU\b\b\u0001"
          + "\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"
          + "\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"
          + "\n\u0001\n\u0003\nk\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"
          + "\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"
          + "\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"
          + "\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0080\b\u000b\u0001\f"
          + "\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"
          + "\f\u0001\f\u0003\f\u008d\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"
          + "\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"
          + "\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"
          + "\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00a5\b\u000f"
          + "\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"
          + "\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"
          + "\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"
          + "\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00bc\b\u0012\n\u0012"
          + "\f\u0012\u00bf\t\u0012\u0003\u0012\u00c1\b\u0012\u0001\u0013\u0004\u0013"
          + "\u00c4\b\u0013\u000b\u0013\f\u0013\u00c5\u0000\u0000\u0014\u0001\u0000"
          + "\u0003\u0000\u0005\u0000\u0007\u0001\t\u0002\u000b\u0003\r\u0004\u000f"
          + "\u0005\u0011\u0006\u0013\u0007\u0015\b\u0017\t\u0019\n\u001b\u000b\u001d"
          + "\f\u001f\r!\u000e#\u000f%\u0010\'\u0011\u0001\u0000\u0018\u0001\u0000"
          + "09\u0001\u000019\u0002\u0000AZaz\u0002\u0000AAaa\u0002\u0000LLll\u0002"
          + "\u0000PPpp\u0002\u0000HHhh\u0002\u0000BBbb\u0002\u0000EEee\u0002\u0000"
          + "TTtt\u0002\u0000RRrr\u0002\u0000CCcc\u0002\u0000SSss\u0002\u0000NNnn\u0002"
          + "\u0000DDdd\u0002\u0000IIii\u0002\u0000OOoo\u0002\u0000VVvv\u0002\u0000"
          + "WWww\u0002\u0000MMmm\u0002\u0000YYyy\u0002\u0000GGgg\u0002\u0000UUuu\u0002"
          + "\u0000XXxx\u00cd\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"
          + "\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"
          + "\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"
          + "\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"
          + "\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"
          + "\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"
          + "\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"
          + "\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"
          + "\u0001\u0000\u0000\u0000\u0001)\u0001\u0000\u0000\u0000\u0003+\u0001\u0000"
          + "\u0000\u0000\u0005-\u0001\u0000\u0000\u0000\u0007/\u0001\u0000\u0000\u0000"
          + "\t1\u0001\u0000\u0000\u0000\u000b3\u0001\u0000\u0000\u0000\r5\u0001\u0000"
          + "\u0000\u0000\u000f;\u0001\u0000\u0000\u0000\u0011T\u0001\u0000\u0000\u0000"
          + "\u0013V\u0001\u0000\u0000\u0000\u0015j\u0001\u0000\u0000\u0000\u0017\u007f"
          + "\u0001\u0000\u0000\u0000\u0019\u008c\u0001\u0000\u0000\u0000\u001b\u008e"
          + "\u0001\u0000\u0000\u0000\u001d\u0094\u0001\u0000\u0000\u0000\u001f\u00a4"
          + "\u0001\u0000\u0000\u0000!\u00a6\u0001\u0000\u0000\u0000#\u00ab\u0001\u0000"
          + "\u0000\u0000%\u00c0\u0001\u0000\u0000\u0000\'\u00c3\u0001\u0000\u0000"
          + "\u0000)*\u0007\u0000\u0000\u0000*\u0002\u0001\u0000\u0000\u0000+,\u0007"
          + "\u0001\u0000\u0000,\u0004\u0001\u0000\u0000\u0000-.\u0007\u0002\u0000"
          + "\u0000.\u0006\u0001\u0000\u0000\u0000/0\u0005-\u0000\u00000\b\u0001\u0000"
          + "\u0000\u000012\u0005+\u0000\u00002\n\u0001\u0000\u0000\u000034\u0005."
          + "\u0000\u00004\f\u0001\u0000\u0000\u000056\u0007\u0003\u0000\u000067\u0007"
          + "\u0004\u0000\u000078\u0007\u0005\u0000\u000089\u0007\u0006\u0000\u0000"
          + "9:\u0007\u0003\u0000\u0000:\u000e\u0001\u0000\u0000\u0000;<\u0007\u0007"
          + "\u0000\u0000<=\u0007\b\u0000\u0000=>\u0007\t\u0000\u0000>?\u0007\u0003"
          + "\u0000\u0000?\u0010\u0001\u0000\u0000\u0000@A\u0007\n\u0000\u0000AU\u0007"
          + "\u000b\u0000\u0000BC\u0007\n\u0000\u0000CD\u0007\b\u0000\u0000DE\u0007"
          + "\u0004\u0000\u0000EF\u0007\b\u0000\u0000FG\u0007\u0003\u0000\u0000GH\u0007"
          + "\f\u0000\u0000HI\u0007\b\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0002"
          + "-.\u0000KL\u0007\u000b\u0000\u0000LM\u0007\u0003\u0000\u0000MN\u0007\r"
          + "\u0000\u0000NO\u0007\u000e\u0000\u0000OP\u0007\u000f\u0000\u0000PQ\u0007"
          + "\u000e\u0000\u0000QR\u0007\u0003\u0000\u0000RS\u0007\t\u0000\u0000SU\u0007"
          + "\b\u0000\u0000T@\u0001\u0000\u0000\u0000TB\u0001\u0000\u0000\u0000U\u0012"
          + "\u0001\u0000\u0000\u0000VW\u0007\f\u0000\u0000WX\u0007\r\u0000\u0000X"
          + "Y\u0007\u0003\u0000\u0000YZ\u0007\u0005\u0000\u0000Z[\u0007\f\u0000\u0000"
          + "[\\\u0007\u0006\u0000\u0000\\]\u0007\u0010\u0000\u0000]^\u0007\t\u0000"
          + "\u0000^\u0014\u0001\u0000\u0000\u0000_k\u0007\u0005\u0000\u0000`a\u0007"
          + "\u0005\u0000\u0000ab\u0007\n\u0000\u0000bk\u0007\b\u0000\u0000cd\u0007"
          + "\u0005\u0000\u0000de\u0007\n\u0000\u0000ef\u0007\b\u0000\u0000fg\u0007"
          + "\u0011\u0000\u0000gh\u0007\u000f\u0000\u0000hi\u0007\b\u0000\u0000ik\u0007"
          + "\u0012\u0000\u0000j_\u0001\u0000\u0000\u0000j`\u0001\u0000\u0000\u0000"
          + "jc\u0001\u0000\u0000\u0000k\u0016\u0001\u0000\u0000\u0000lm\u0007\u000e"
          + "\u0000\u0000mn\u0007\b\u0000\u0000n\u0080\u0007\u0011\u0000\u0000op\u0007"
          + "\u000e\u0000\u0000pq\u0007\b\u0000\u0000qr\u0007\u0011\u0000\u0000rs\u0007"
          + "\b\u0000\u0000s\u0080\u0007\u0004\u0000\u0000tu\u0007\u000e\u0000\u0000"
          + "uv\u0007\b\u0000\u0000vw\u0007\u0011\u0000\u0000wx\u0007\b\u0000\u0000"
          + "xy\u0007\u0004\u0000\u0000yz\u0007\u0010\u0000\u0000z{\u0007\u0005\u0000"
          + "\u0000{|\u0007\u0013\u0000\u0000|}\u0007\b\u0000\u0000}~\u0007\r\u0000"
          + "\u0000~\u0080\u0007\t\u0000\u0000\u007fl\u0001\u0000\u0000\u0000\u007f"
          + "o\u0001\u0000\u0000\u0000\u007ft\u0001\u0000\u0000\u0000\u0080\u0018\u0001"
          + "\u0000\u0000\u0000\u0081\u0082\u0007\u0013\u0000\u0000\u0082\u008d\u0007"
          + "\t\u0000\u0000\u0083\u0084\u0007\u0013\u0000\u0000\u0084\u0085\u0007\u000f"
          + "\u0000\u0000\u0085\u0086\u0007\u0004\u0000\u0000\u0086\u0087\u0007\b\u0000"
          + "\u0000\u0087\u0088\u0007\f\u0000\u0000\u0088\u0089\u0007\t\u0000\u0000"
          + "\u0089\u008a\u0007\u0010\u0000\u0000\u008a\u008b\u0007\r\u0000\u0000\u008b"
          + "\u008d\u0007\b\u0000\u0000\u008c\u0081\u0001\u0000\u0000\u0000\u008c\u0083"
          + "\u0001\u0000\u0000\u0000\u008d\u001a\u0001\u0000\u0000\u0000\u008e\u008f"
          + "\u0007\u000e\u0000\u0000\u008f\u0090\u0007\u0003\u0000\u0000\u0090\u0091"
          + "\u0007\u000f\u0000\u0000\u0091\u0092\u0007\u0004\u0000\u0000\u0092\u0093"
          + "\u0007\u0014\u0000\u0000\u0093\u001c\u0001\u0000\u0000\u0000\u0094\u0095"
          + "\u0007\r\u0000\u0000\u0095\u0096\u0007\u000f\u0000\u0000\u0096\u0097\u0007"
          + "\u0015\u0000\u0000\u0097\u0098\u0007\u0006\u0000\u0000\u0098\u0099\u0007"
          + "\t\u0000\u0000\u0099\u009a\u0007\u0004\u0000\u0000\u009a\u009b\u0007\u0014"
          + "\u0000\u0000\u009b\u001e\u0001\u0000\u0000\u0000\u009c\u009d\u0007\u0007"
          + "\u0000\u0000\u009d\u009e\u0007\u0004\u0000\u0000\u009e\u00a5\u0007\u000e"
          + "\u0000\u0000\u009f\u00a0\u0007\u0007\u0000\u0000\u00a0\u00a1\u0007\u0016"
          + "\u0000\u0000\u00a1\u00a2\u0007\u000f\u0000\u0000\u00a2\u00a3\u0007\u0004"
          + "\u0000\u0000\u00a3\u00a5\u0007\u000e\u0000\u0000\u00a4\u009c\u0001\u0000"
          + "\u0000\u0000\u00a4\u009f\u0001\u0000\u0000\u0000\u00a5 \u0001\u0000\u0000"
          + "\u0000\u00a6\u00a7\u0007\t\u0000\u0000\u00a7\u00a8\u0007\b\u0000\u0000"
          + "\u00a8\u00a9\u0007\f\u0000\u0000\u00a9\u00aa\u0007\t\u0000\u0000\u00aa"
          + "\"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0007\b\u0000\u0000\u00ac\u00ad"
          + "\u0007\u0017\u0000\u0000\u00ad\u00ae\u0007\u0005\u0000\u0000\u00ae\u00af"
          + "\u0007\b\u0000\u0000\u00af\u00b0\u0007\n\u0000\u0000\u00b0\u00b1\u0007"
          + "\u000f\u0000\u0000\u00b1\u00b2\u0007\u0013\u0000\u0000\u00b2\u00b3\u0007"
          + "\b\u0000\u0000\u00b3\u00b4\u0007\r\u0000\u0000\u00b4\u00b5\u0007\t\u0000"
          + "\u0000\u00b5\u00b6\u0007\u0003\u0000\u0000\u00b6\u00b7\u0007\u0004\u0000"
          + "\u0000\u00b7$\u0001\u0000\u0000\u0000\u00b8\u00c1\u00050\u0000\u0000\u00b9"
          + "\u00bd\u0003\u0003\u0001\u0000\u00ba\u00bc\u0003\u0001\u0000\u0000\u00bb"
          + "\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd"
          + "\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be"
          + "\u00c1\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0"
          + "\u00b8\u0001\u0000\u0000\u0000\u00c0\u00b9\u0001\u0000\u0000\u0000\u00c1"
          + "&\u0001\u0000\u0000\u0000\u00c2\u00c4\u0003\u0005\u0002\u0000\u00c3\u00c2"
          + "\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c3"
          + "\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6(\u0001"
          + "\u0000\u0000\u0000\t\u0000Tj\u007f\u008c\u00a4\u00bd\u00c0\u00c5\u0000";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
