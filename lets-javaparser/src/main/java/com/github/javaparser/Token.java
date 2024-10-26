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

/** Describes the input token stream. */
public class Token extends TokenBase implements java.io.Serializable {

  /**
   * The version identifier for this Serializable class. Increment only if the <i>serialized</i>
   * form of the class changes.
   */
  private static final long serialVersionUID = 1L;

  /**
   * An integer that describes the kind of this token. This numbering system is determined by
   * JavaCCParser, and a table of these numbers is stored in the file ...Constants.java.
   */
  public int kind;

  /** The line number of the first character of this Token. */
  public int beginLine;

  /** The column number of the first character of this Token. */
  public int beginColumn;

  /** The line number of the last character of this Token. */
  public int endLine;

  /** The column number of the last character of this Token. */
  public int endColumn;

  /** The string image of the token. */
  public String image;

  /**
   * A reference to the next regular (non-special) token from the input stream. If this is the last
   * token from the input stream, or if the token manager has not read tokens beyond this one, this
   * field is set to null. This is true only if this token is also a regular token. Otherwise, see
   * below for a description of the contents of this field.
   */
  public Token next;

  /**
   * This field is used to access special tokens that occur prior to this token, but after the
   * immediately preceding regular (non-special) token. If there are no such special tokens, this
   * field is set to null. When there are more than one such special token, this field refers to the
   * last of these special tokens, which in turn refers to the next previous special token through
   * its specialToken field, and so on until the first special token (whose specialToken field is
   * null). The next fields of special tokens refer to other special tokens that immediately follow
   * it (without an intervening regular token). If there is no such token, this field is null.
   */
  public Token specialToken;

  /** No-argument constructor */
  public Token() {}

  /** Constructs a new token for the specified Image. */
  public Token(final int nKind) {
    this(nKind, null);
  }

  /** Constructs a new token for the specified Image and Kind. */
  public Token(final int nKind, final String sImage) {
    this.kind = nKind;
    this.image = sImage;
  }

  /**
   * An optional attribute value of the Token. Tokens which are not used as syntactic sugar will
   * often contain meaningful values that will be used later on by the compiler or interpreter. This
   * attribute value is often different from the image. Any subclass of Token that actually wants to
   * return a non-null value can override this method as appropriate.
   */
  public Object getValue() {
    return null;
  }

  /** Returns the image. */
  @Override
  public String toString() {
    return image;
  }

  /**
   * Returns a new Token object, by default. However, if you want, you can create and return
   * subclass objects based on the value of ofKind. Simply add the cases to the switch for all those
   * special cases. For example, if you have a subclass of Token called IDToken that you want to
   * create if ofKind is ID, simply add something like :
   *
   * <p>case MyParserConstants.ID : return new IDToken(ofKind, image);
   *
   * <p>to the following switch statement. Then you can cast matchedToken variable to the
   * appropriate type and use sit in your lexical actions.
   */
  public static Token newToken(int ofKind, String image) {
    switch (ofKind) {
      default:
        return new Token(ofKind, image);
    }
  }

  public static Token newToken(int ofKind) {
    return newToken(ofKind, null);
  }
}
/* ParserGeneratorCC - OriginalChecksum=737ca41fec273c409fee8aeddd114f25 (do not edit this line) */
