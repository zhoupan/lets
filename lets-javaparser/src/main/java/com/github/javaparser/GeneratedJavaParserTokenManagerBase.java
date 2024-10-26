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

import static com.github.javaparser.GeneratedJavaParserConstants.*;

import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.ast.comments.LineComment;

/** Base class for {@link com.github.javaparser.GeneratedJavaParserTokenManager} */
abstract class GeneratedJavaParserTokenManagerBase {

  /** Create a TokenRange that spans exactly one token */
  private static TokenRange tokenRange(Token token) {
    JavaToken javaToken = token.javaToken;
    return new TokenRange(javaToken, javaToken);
  }

  /**
   * Since comments are completely captured in a single token, including their delimiters,
   * deconstruct them here so we can turn them into nodes later on.
   */
  static Comment createCommentFromToken(Token token) {
    String commentText = token.image;
    if (token.kind == JAVADOC_COMMENT) {
      return new JavadocComment(
          tokenRange(token), commentText.substring(3, commentText.length() - 2));
    } else if (token.kind == MULTI_LINE_COMMENT) {
      return new BlockComment(
          tokenRange(token), commentText.substring(2, commentText.length() - 2));
    } else if (token.kind == SINGLE_LINE_COMMENT) {
      return new LineComment(tokenRange(token), commentText.substring(2));
    }
    throw new AssertionError("Unexpectedly got passed a non-comment token.");
  }
}
