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
public class DesktopEntryLexer extends Lexer {
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
  public static final int COMMENT_MODE = 1,
      HEADER_MODE = 2,
      ENTRY_MODE = 3,
      KEY_MODE = 4,
      VALUE_MODE = 5,
      LOCALE_MODE = 6,
      COUNTRY_MODE = 7,
      ENCODING_MODE = 8,
      MODIFIER_MODE = 9;
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {
    "DEFAULT_MODE", "COMMENT_MODE", "HEADER_MODE", "ENTRY_MODE", "KEY_MODE",
    "VALUE_MODE", "LOCALE_MODE", "COUNTRY_MODE", "ENCODING_MODE", "MODIFIER_MODE"
  };

  private static String[] makeRuleNames() {
    return new String[] {
      "HASH",
      "LEFT_BRACKET",
      "NEWLINE",
      "SPACE",
      "COMMENT_TEXT",
      "NEWLINE_0",
      "GROUP_NAME",
      "NEWLINE_1",
      "RIGHT_BRACKET",
      "HASH_0",
      "KEY_NAME",
      "LEFT_BRACKET_0",
      "NEWLINE_2",
      "SPACE_0",
      "EQUAL",
      "LEFT_BRACKET_1",
      "SPACE_1",
      "TRUE",
      "FALSE",
      "NEWLINE_3",
      "NUMBER",
      "SEMICOLON",
      "SPACE_2",
      "STRING",
      "AT",
      "DOT",
      "LANGUAGE",
      "RIGHT_BRACKET_0",
      "UNDERSCORE",
      "AT_0",
      "COUNTRY",
      "DOT_0",
      "RIGHT_BRACKET_1",
      "AT_1",
      "ENCODING",
      "RIGHT_BRACKET_2",
      "MODIFIER",
      "RIGHT_BRACKET_3",
      "ASCII_PRINTABLE_NO_BRACKETS",
      "ESC_SEQ",
      "IDENTIFIER"
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

  public DesktopEntryLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @Override
  public String getGrammarFileName() {
    return "DesktopEntryLexer.g4";
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
      "\u0004\u0000\u0018\u011f\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff"
          + "\uffff\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff"
          + "\uffff\u0006\uffff\uffff\u0006\uffff\uffff\u0006\uffff\uffff\u0002\u0000"
          + "\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003"
          + "\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006"
          + "\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002"
          + "\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002"
          + "\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002"
          + "\u0011\u0007\u0011\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002"
          + "\u0014\u0007\u0014\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002"
          + "\u0017\u0007\u0017\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002"
          + "\u001a\u0007\u001a\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002"
          + "\u001d\u0007\u001d\u0002\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002"
          + " \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002"
          + "%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002(\u0007(\u0001\u0000\u0001"
          + "\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"
          + "\u0001\u0001\u0001\u0001\u0002\u0003\u0002g\b\u0002\u0001\u0002\u0001"
          + "\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0004\u0003n\b\u0003\u000b"
          + "\u0003\f\u0003o\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u0004u\b\u0004"
          + "\u000b\u0004\f\u0004v\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"
          + "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0004\u0006"
          + "\u0082\b\u0006\u000b\u0006\f\u0006\u0083\u0001\u0007\u0001\u0007\u0001"
          + "\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"
          + "\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"
          + "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"
          + "\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"
          + "\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"
          + "\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"
          + "\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"
          + "\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"
          + "\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"
          + "\u0013\u0001\u0014\u0004\u0014\u00c7\b\u0014\u000b\u0014\f\u0014\u00c8"
          + "\u0001\u0014\u0001\u0014\u0004\u0014\u00cd\b\u0014\u000b\u0014\f\u0014"
          + "\u00ce\u0003\u0014\u00d1\b\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001"
          + "\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0004"
          + "\u0017\u00dc\b\u0017\u000b\u0017\f\u0017\u00dd\u0001\u0018\u0001\u0018"
          + "\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"
          + "\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"
          + "\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d"
          + "\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f"
          + "\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001"
          + " \u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001"
          + "#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001"
          + "&\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0005(\u011b\b(\n(\f(\u011e\t"
          + "(\u0000\u0000)\n\u0001\f\u0002\u000e\u0003\u0010\u0004\u0012\u0005\u0014"
          + "\u0000\u0016\u0006\u0018\u0000\u001a\u0007\u001c\u0000\u001e\b \u0000"
          + "\"\u0000$\u0000&\t(\u0000*\u0000,\n.\u000b0\u00002\f4\r6\u00008\u000e"
          + ":\u000f<\u0010>\u0011@\u0000B\u0012D\u0013F\u0014H\u0015J\u0000L\u0016"
          + "N\u0017P\u0000R\u0018T\u0000V\u0000X\u0000Z\u0000\n\u0000\u0001\u0002"
          + "\u0003\u0004\u0005\u0006\u0007\b\t\b\u0002\u0000\t\t  \u0002\u0000\n\n"
          + "\r\r\u0001\u000009\u0004\u0000\n\n\r\r;;\\\\\u0003\u0000 Z\\\\^~\u0004"
          + "\u0000;;\\\\nnrt\u0002\u0000AZaz\u0004\u0000--09AZaz\u011c\u0000\n\u0001"
          + "\u0000\u0000\u0000\u0000\f\u0001\u0000\u0000\u0000\u0000\u000e\u0001\u0000"
          + "\u0000\u0000\u0000\u0010\u0001\u0000\u0000\u0000\u0001\u0012\u0001\u0000"
          + "\u0000\u0000\u0001\u0014\u0001\u0000\u0000\u0000\u0002\u0016\u0001\u0000"
          + "\u0000\u0000\u0002\u0018\u0001\u0000\u0000\u0000\u0002\u001a\u0001\u0000"
          + "\u0000\u0000\u0003\u001c\u0001\u0000\u0000\u0000\u0003\u001e\u0001\u0000"
          + "\u0000\u0000\u0003 \u0001\u0000\u0000\u0000\u0003\"\u0001\u0000\u0000"
          + "\u0000\u0003$\u0001\u0000\u0000\u0000\u0004&\u0001\u0000\u0000\u0000\u0004"
          + "(\u0001\u0000\u0000\u0000\u0004*\u0001\u0000\u0000\u0000\u0005,\u0001"
          + "\u0000\u0000\u0000\u0005.\u0001\u0000\u0000\u0000\u00050\u0001\u0000\u0000"
          + "\u0000\u00052\u0001\u0000\u0000\u0000\u00054\u0001\u0000\u0000\u0000\u0005"
          + "6\u0001\u0000\u0000\u0000\u00058\u0001\u0000\u0000\u0000\u0006:\u0001"
          + "\u0000\u0000\u0000\u0006<\u0001\u0000\u0000\u0000\u0006>\u0001\u0000\u0000"
          + "\u0000\u0006@\u0001\u0000\u0000\u0000\u0006B\u0001\u0000\u0000\u0000\u0007"
          + "D\u0001\u0000\u0000\u0000\u0007F\u0001\u0000\u0000\u0000\u0007H\u0001"
          + "\u0000\u0000\u0000\u0007J\u0001\u0000\u0000\u0000\bL\u0001\u0000\u0000"
          + "\u0000\bN\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000\u0000\tR\u0001"
          + "\u0000\u0000\u0000\tT\u0001\u0000\u0000\u0000\n\\\u0001\u0000\u0000\u0000"
          + "\fa\u0001\u0000\u0000\u0000\u000ef\u0001\u0000\u0000\u0000\u0010m\u0001"
          + "\u0000\u0000\u0000\u0012t\u0001\u0000\u0000\u0000\u0014z\u0001\u0000\u0000"
          + "\u0000\u0016\u0081\u0001\u0000\u0000\u0000\u0018\u0085\u0001\u0000\u0000"
          + "\u0000\u001a\u008b\u0001\u0000\u0000\u0000\u001c\u008d\u0001\u0000\u0000"
          + "\u0000\u001e\u0093\u0001\u0000\u0000\u0000 \u0097\u0001\u0000\u0000\u0000"
          + "\"\u009c\u0001\u0000\u0000\u0000$\u00a1\u0001\u0000\u0000\u0000&\u00a6"
          + "\u0001\u0000\u0000\u0000(\u00aa\u0001\u0000\u0000\u0000*\u00af\u0001\u0000"
          + "\u0000\u0000,\u00b4\u0001\u0000\u0000\u0000.\u00b9\u0001\u0000\u0000\u0000"
          + "0\u00bf\u0001\u0000\u0000\u00002\u00c6\u0001\u0000\u0000\u00004\u00d2"
          + "\u0001\u0000\u0000\u00006\u00d4\u0001\u0000\u0000\u00008\u00db\u0001\u0000"
          + "\u0000\u0000:\u00df\u0001\u0000\u0000\u0000<\u00e3\u0001\u0000\u0000\u0000"
          + ">\u00e7\u0001\u0000\u0000\u0000@\u00e9\u0001\u0000\u0000\u0000B\u00ee"
          + "\u0001\u0000\u0000\u0000D\u00f2\u0001\u0000\u0000\u0000F\u00f6\u0001\u0000"
          + "\u0000\u0000H\u00f8\u0001\u0000\u0000\u0000J\u00fc\u0001\u0000\u0000\u0000"
          + "L\u0101\u0001\u0000\u0000\u0000N\u0105\u0001\u0000\u0000\u0000P\u0107"
          + "\u0001\u0000\u0000\u0000R\u010c\u0001\u0000\u0000\u0000T\u010e\u0001\u0000"
          + "\u0000\u0000V\u0113\u0001\u0000\u0000\u0000X\u0115\u0001\u0000\u0000\u0000"
          + "Z\u0118\u0001\u0000\u0000\u0000\\]\u0005#\u0000\u0000]^\u0001\u0000\u0000"
          + "\u0000^_\u0006\u0000\u0000\u0000_`\u0006\u0000\u0001\u0000`\u000b\u0001"
          + "\u0000\u0000\u0000ab\u0005[\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0006"
          + "\u0001\u0002\u0000d\r\u0001\u0000\u0000\u0000eg\u0005\r\u0000\u0000fe"
          + "\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"
          + "\u0000hi\u0005\n\u0000\u0000ij\u0001\u0000\u0000\u0000jk\u0006\u0002\u0000"
          + "\u0000k\u000f\u0001\u0000\u0000\u0000ln\u0007\u0000\u0000\u0000ml\u0001"
          + "\u0000\u0000\u0000no\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"
          + "op\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qr\u0006\u0003\u0000"
          + "\u0000r\u0011\u0001\u0000\u0000\u0000su\b\u0001\u0000\u0000ts\u0001\u0000"
          + "\u0000\u0000uv\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001"
          + "\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0006\u0004\u0000\u0000"
          + "y\u0013\u0001\u0000\u0000\u0000z{\u0003\u000e\u0002\u0000{|\u0001\u0000"
          + "\u0000\u0000|}\u0006\u0005\u0000\u0000}~\u0006\u0005\u0003\u0000~\u007f"
          + "\u0006\u0005\u0004\u0000\u007f\u0015\u0001\u0000\u0000\u0000\u0080\u0082"
          + "\u0003V&\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000"
          + "\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000"
          + "\u0000\u0000\u0084\u0017\u0001\u0000\u0000\u0000\u0085\u0086\u0003\u000e"
          + "\u0002\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0006\u0007"
          + "\u0000\u0000\u0088\u0089\u0006\u0007\u0003\u0000\u0089\u008a\u0006\u0007"
          + "\u0005\u0000\u008a\u0019\u0001\u0000\u0000\u0000\u008b\u008c\u0005]\u0000"
          + "\u0000\u008c\u001b\u0001\u0000\u0000\u0000\u008d\u008e\u0003\n\u0000\u0000"
          + "\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0090\u0006\t\u0000\u0000\u0090"
          + "\u0091\u0006\t\u0006\u0000\u0091\u0092\u0006\t\u0001\u0000\u0092\u001d"
          + "\u0001\u0000\u0000\u0000\u0093\u0094\u0003Z(\u0000\u0094\u0095\u0001\u0000"
          + "\u0000\u0000\u0095\u0096\u0006\n\u0007\u0000\u0096\u001f\u0001\u0000\u0000"
          + "\u0000\u0097\u0098\u0003\f\u0001\u0000\u0098\u0099\u0001\u0000\u0000\u0000"
          + "\u0099\u009a\u0006\u000b\b\u0000\u009a\u009b\u0006\u000b\u0002\u0000\u009b"
          + "!\u0001\u0000\u0000\u0000\u009c\u009d\u0003\u000e\u0002\u0000\u009d\u009e"
          + "\u0001\u0000\u0000\u0000\u009e\u009f\u0006\f\u0000\u0000\u009f\u00a0\u0006"
          + "\f\u0003\u0000\u00a0#\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003\u0010"
          + "\u0003\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a4\u0006\r\u0000"
          + "\u0000\u00a4\u00a5\u0006\r\t\u0000\u00a5%\u0001\u0000\u0000\u0000\u00a6"
          + "\u00a7\u0005=\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9"
          + "\u0006\u000e\n\u0000\u00a9\'\u0001\u0000\u0000\u0000\u00aa\u00ab\u0003"
          + "\f\u0001\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad\u0006\u000f"
          + "\b\u0000\u00ad\u00ae\u0006\u000f\u000b\u0000\u00ae)\u0001\u0000\u0000"
          + "\u0000\u00af\u00b0\u0003\u0010\u0003\u0000\u00b0\u00b1\u0001\u0000\u0000"
          + "\u0000\u00b1\u00b2\u0006\u0010\u0000\u0000\u00b2\u00b3\u0006\u0010\t\u0000"
          + "\u00b3+\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005t\u0000\u0000\u00b5\u00b6"
          + "\u0005r\u0000\u0000\u00b6\u00b7\u0005u\u0000\u0000\u00b7\u00b8\u0005e"
          + "\u0000\u0000\u00b8-\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005f\u0000\u0000"
          + "\u00ba\u00bb\u0005a\u0000\u0000\u00bb\u00bc\u0005l\u0000\u0000\u00bc\u00bd"
          + "\u0005s\u0000\u0000\u00bd\u00be\u0005e\u0000\u0000\u00be/\u0001\u0000"
          + "\u0000\u0000\u00bf\u00c0\u0003\u000e\u0002\u0000\u00c0\u00c1\u0001\u0000"
          + "\u0000\u0000\u00c1\u00c2\u0006\u0013\u0000\u0000\u00c2\u00c3\u0006\u0013"
          + "\u0003\u0000\u00c3\u00c4\u0006\u0013\u0005\u0000\u00c41\u0001\u0000\u0000"
          + "\u0000\u00c5\u00c7\u0007\u0002\u0000\u0000\u00c6\u00c5\u0001\u0000\u0000"
          + "\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000"
          + "\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00d0\u0001\u0000\u0000"
          + "\u0000\u00ca\u00cc\u0005.\u0000\u0000\u00cb\u00cd\u0007\u0002\u0000\u0000"
          + "\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000"
          + "\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000"
          + "\u00cf\u00d1\u0001\u0000\u0000\u0000\u00d0\u00ca\u0001\u0000\u0000\u0000"
          + "\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d13\u0001\u0000\u0000\u0000\u00d2"
          + "\u00d3\u0005;\u0000\u0000\u00d35\u0001\u0000\u0000\u0000\u00d4\u00d5\u0003"
          + "\u0010\u0003\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7\u0006"
          + "\u0016\u0000\u0000\u00d7\u00d8\u0006\u0016\t\u0000\u00d87\u0001\u0000"
          + "\u0000\u0000\u00d9\u00dc\b\u0003\u0000\u0000\u00da\u00dc\u0003X\'\u0000"
          + "\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00da\u0001\u0000\u0000\u0000"
          + "\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000"
          + "\u00dd\u00de\u0001\u0000\u0000\u0000\u00de9\u0001\u0000\u0000\u0000\u00df"
          + "\u00e0\u0005@\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e2"
          + "\u0006\u0018\f\u0000\u00e2;\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005"
          + ".\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e6\u0006\u0019"
          + "\r\u0000\u00e6=\u0001\u0000\u0000\u0000\u00e7\u00e8\u0003Z(\u0000\u00e8"
          + "?\u0001\u0000\u0000\u0000\u00e9\u00ea\u0003\u001a\b\u0000\u00ea\u00eb"
          + "\u0001\u0000\u0000\u0000\u00eb\u00ec\u0006\u001b\u000e\u0000\u00ec\u00ed"
          + "\u0006\u001b\u0004\u0000\u00edA\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005"
          + "_\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f1\u0006\u001c"
          + "\u000f\u0000\u00f1C\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005@\u0000\u0000"
          + "\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f5\u0006\u001d\f\u0000\u00f5"
          + "E\u0001\u0000\u0000\u0000\u00f6\u00f7\u0003Z(\u0000\u00f7G\u0001\u0000"
          + "\u0000\u0000\u00f8\u00f9\u0005.\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000"
          + "\u0000\u00fa\u00fb\u0006\u001f\r\u0000\u00fbI\u0001\u0000\u0000\u0000"
          + "\u00fc\u00fd\u0003\u001a\b\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe"
          + "\u00ff\u0006 \u000e\u0000\u00ff\u0100\u0006 \u0004\u0000\u0100K\u0001"
          + "\u0000\u0000\u0000\u0101\u0102\u0005@\u0000\u0000\u0102\u0103\u0001\u0000"
          + "\u0000\u0000\u0103\u0104\u0006!\f\u0000\u0104M\u0001\u0000\u0000\u0000"
          + "\u0105\u0106\u0003Z(\u0000\u0106O\u0001\u0000\u0000\u0000\u0107\u0108"
          + "\u0003\u001a\b\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010a\u0006"
          + "#\u000e\u0000\u010a\u010b\u0006#\u0004\u0000\u010bQ\u0001\u0000\u0000"
          + "\u0000\u010c\u010d\u0003Z(\u0000\u010dS\u0001\u0000\u0000\u0000\u010e"
          + "\u010f\u0003\u001a\b\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0111"
          + "\u0006%\u000e\u0000\u0111\u0112\u0006%\u0004\u0000\u0112U\u0001\u0000"
          + "\u0000\u0000\u0113\u0114\u0007\u0004\u0000\u0000\u0114W\u0001\u0000\u0000"
          + "\u0000\u0115\u0116\u0005\\\u0000\u0000\u0116\u0117\u0007\u0005\u0000\u0000"
          + "\u0117Y\u0001\u0000\u0000\u0000\u0118\u011c\u0007\u0006\u0000\u0000\u0119"
          + "\u011b\u0007\u0007\u0000\u0000\u011a\u0119\u0001\u0000\u0000\u0000\u011b"
          + "\u011e\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011c"
          + "\u011d\u0001\u0000\u0000\u0000\u011d[\u0001\u0000\u0000\u0000\u011e\u011c"
          + "\u0001\u0000\u0000\u0000\u0014\u0000\u0001\u0002\u0003\u0004\u0005\u0006"
          + "\u0007\b\tfov\u0083\u00c8\u00ce\u00d0\u00db\u00dd\u011c\u0010\u0000\u0001"
          + "\u0000\u0005\u0001\u0000\u0002\u0002\u0000\u0007\u0003\u0000\u0004\u0000"
          + "\u0000\u0002\u0003\u0000\u0007\u0001\u0000\u0002\u0004\u0000\u0007\u0002"
          + "\u0000\u0007\u0004\u0000\u0002\u0005\u0000\u0005\u0006\u0000\u0002\t\u0000"
          + "\u0002\b\u0000\u0007\u0007\u0000\u0002\u0007\u0000";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}
