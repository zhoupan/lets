/*
 * Copyright (c) 2007-2010 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser;

/** Token Manager Error. */
public class TokenMgrException extends RuntimeException {

  /**
   * The version identifier for this Serializable class. Increment only if the <i>serialized</i>
   * form of the class changes.
   */
  private static final long serialVersionUID = 1L;

  /*
   * Ordinals for various reasons why an Error of this type can be thrown.
   */
  /** Lexical error occurred. */
  public static final int LEXICAL_ERROR = 0;

  /** An attempt was made to create a second instance of a static token manager. */
  public static final int STATIC_LEXER_ERROR = 1;

  /** Tried to change to an invalid lexical state. */
  public static final int INVALID_LEXICAL_STATE = 2;

  /** Detected (and bailed out of) an infinite loop in the token manager. */
  public static final int LOOP_DETECTED = 3;

  /** Indicates the reason why the exception is thrown. It will have one of the above 4 values. */
  int errorCode;

  /**
   * Replaces unprintable characters by their escaped (or unicode escaped) equivalents in the given
   * string
   */
  protected static final String addEscapes(String str) {
    StringBuilder retval = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      final char ch = str.charAt(i);
      switch (ch) {
        case '\b':
          retval.append("\\b");
          continue;
        case '\t':
          retval.append("\\t");
          continue;
        case '\n':
          retval.append("\\n");
          continue;
        case '\f':
          retval.append("\\f");
          continue;
        case '\r':
          retval.append("\\r");
          continue;
        case '\"':
          retval.append("\\\"");
          continue;
        case '\'':
          retval.append("\\\'");
          continue;
        case '\\':
          retval.append("\\\\");
          continue;
        default:
          if (ch < 0x20 || ch > 0x7e) {
            String s = "0000" + Integer.toString(ch, 16);
            retval.append("\\u").append(s.substring(s.length() - 4, s.length()));
          } else {
            retval.append(ch);
          }
          continue;
      }
    }
    return retval.toString();
  }

  /**
   * Returns a detailed message for the Error when it is thrown by the token manager to indicate a
   * lexical error. Parameters : EOFSeen : indicates if EOF caused the lexical error curLexState :
   * lexical state in which this error occurred errorLine : line number when the error occurred
   * errorColumn : column number when the error occurred errorAfter : prefix that was seen before
   * this error occurred curchar : the offending character Note: You can customize the lexical error
   * message by modifying this method.
   */
  protected static String LexicalErr(
      boolean EOFSeen,
      int lexState,
      int errorLine,
      int errorColumn,
      String errorAfter,
      int curChar) {
    char curChar1 = (char) curChar;
    return ("Lexical error at line "
        + errorLine
        + ", column "
        + errorColumn
        + ".  Encountered: "
        + (EOFSeen
            ? "<EOF> "
            : ("\"" + addEscapes(String.valueOf(curChar1)) + "\"") + " (" + curChar + "), ")
        + "after : \""
        + addEscapes(errorAfter)
        + "\"");
  }

  /**
   * You can also modify the body of this method to customize your error messages. For example,
   * cases like LOOP_DETECTED and INVALID_LEXICAL_STATE are not of end-users concern, so you can
   * return something like :
   *
   * <p>"Internal Error : Please file a bug report .... "
   *
   * <p>from this method for such cases in the release version of your parser.
   */
  @Override
  public String getMessage() {
    return super.getMessage();
  }

  /*
   * Constructors of various flavors follow.
   */
  /** No arg constructor. */
  public TokenMgrException() {}

  /** Constructor with message and reason. */
  public TokenMgrException(String message, int reason) {
    super(message);
    errorCode = reason;
  }

  /** Full Constructor. */
  public TokenMgrException(
      boolean EOFSeen,
      int lexState,
      int errorLine,
      int errorColumn,
      String errorAfter,
      int curChar,
      int reason) {
    this(LexicalErr(EOFSeen, lexState, errorLine, errorColumn, errorAfter, curChar), reason);
  }
}
/* ParserGeneratorCC - OriginalChecksum=74199550df5cbac71405d032b587a1ea (do not edit this line) */
