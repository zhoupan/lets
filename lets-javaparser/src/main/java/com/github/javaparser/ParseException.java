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

/**
 * This exception is thrown when parse errors are encountered. You can explicitly create objects of
 * this exception type by calling the method generateParseException in the generated parser.
 *
 * <p>You can modify this class to customize your error reporting mechanisms so long as you retain
 * the public fields.
 */
public class ParseException extends Exception {
  private static final String INDENT = "    ";

  /**
   * The end of line string (we do not use System.getProperty("") so that we are compatible with
   * Android/GWT);
   */
  protected static final String EOL = "\n";

  public ParseException(
      final Token currentTokenVal,
      final int[][] expectedTokenSequencesVal,
      final String[] tokenImageVal) {
    this(currentTokenVal, expectedTokenSequencesVal, tokenImageVal, null);
  }

  /**
   * This constructor is used by the method "generateParseException" in the generated parser.
   * Calling this constructor generates a new object of this type with the fields "currentToken",
   * "expectedTokenSequences", and "tokenImage" set.
   */
  public ParseException(
      final Token currentTokenVal,
      final int[][] expectedTokenSequencesVal,
      final String[] tokenImageVal,
      final String lexicalStateName) {
    super(_initialise(currentTokenVal, expectedTokenSequencesVal, tokenImageVal, lexicalStateName));
    currentToken = currentTokenVal;
    expectedTokenSequences = expectedTokenSequencesVal;
    tokenImage = tokenImageVal;
  }

  /**
   * The following constructors are for use by you for whatever purpose you can think of.
   * Constructing the exception in this manner makes the exception behave in the normal way - i.e.,
   * as documented in the class "Throwable". The fields "errorToken", "expectedTokenSequences", and
   * "tokenImage" do not contain relevant information. The JavaCC generated code does not use these
   * constructors.
   */
  public ParseException() {
    super();
  }

  /** Constructor with message. */
  public ParseException(String message) {
    super(message);
  }

  /**
   * This is the last token that has been consumed successfully. If this object has been created due
   * to a parse error, the token followng this token will (therefore) be the first error token.
   */
  public Token currentToken;

  /**
   * Each entry in this array is an array of integers. Each array of integers represents a sequence
   * of tokens (by their ordinal values) that is expected at this point of the parse.
   */
  public int[][] expectedTokenSequences;

  /**
   * This is a reference to the "tokenImage" array of the generated parser within which the parse
   * error occurred. This array is defined in the generated ...Constants interface.
   */
  public String[] tokenImage;

  /**
   * It uses "currentToken" and "expectedTokenSequences" to generate a parse error message and
   * returns it. If this object has been created due to a parse error, and you do not catch it (it
   * gets thrown from the parser) the correct error message gets displayed.
   */
  private static String _initialise(
      final Token currentToken,
      final int[][] expectedTokenSequences,
      final String[] tokenImage,
      final String lexicalStateName) {
    StringBuilder expected = new StringBuilder();

    int maxSize = 0;
    java.util.TreeSet<String> sortedOptions = new java.util.TreeSet<String>();
    for (int i = 0; i < expectedTokenSequences.length; i++) {
      if (maxSize < expectedTokenSequences[i].length) maxSize = expectedTokenSequences[i].length;
      for (int j = 0; j < expectedTokenSequences[i].length; j++)
        sortedOptions.add(tokenImage[expectedTokenSequences[i][j]]);
    }

    for (String option : sortedOptions) expected.append(INDENT).append(option).append(EOL);

    StringBuilder sb = new StringBuilder();
    sb.append("Encountered unexpected token:");

    Token tok = currentToken.next;
    for (int i = 0; i < maxSize; i++) {
      String tokenText = tok.image;
      String escapedTokenText = add_escapes(tokenText);
      if (i != 0) sb.append(' ');
      if (tok.kind == 0) {
        sb.append(tokenImage[0]);
        break;
      }
      sb.append(" \"");
      sb.append(escapedTokenText);
      sb.append("\"");
      sb.append(" " + tokenImage[tok.kind]);
      tok = tok.next;
    }
    sb.append(EOL)
        .append(INDENT)
        .append("at line ")
        .append(currentToken.next.beginLine)
        .append(", column ")
        .append(currentToken.next.beginColumn);
    sb.append(".").append(EOL);

    if (expectedTokenSequences.length == 0) {
      // Nothing to add here
    } else {
      sb.append(EOL)
          .append("Was expecting")
          .append(expectedTokenSequences.length == 1 ? ":" : " one of:")
          .append(EOL)
          .append(EOL)
          .append(expected);
    }
    // 2013/07/30 --> Seems to be inaccurate as represents the readahead state, not the lexical
    // state BEFORE the unknown token
    //    if (lexicalStateName != null) {
    //    	sb.append(EOL).append("** Lexical State :
    // ").append(lexicalStateName).append(EOL).append(EOL);
    //    }

    return sb.toString();
  }

  /**
   * Used to convert raw characters to their escaped version when these raw version cannot be used
   * as part of an ASCII string literal.
   */
  static String add_escapes(String str) {
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
            retval.append("\\u" + s.substring(s.length() - 4, s.length()));
          } else {
            retval.append(ch);
          }
          continue;
      }
    }
    return retval.toString();
  }
}
/* ParserGeneratorCC - OriginalChecksum=074c630155957bb293002ca03cb928a3 (do not edit this line) */
