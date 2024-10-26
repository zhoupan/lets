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
package com.github.javaparser.printer.lexicalpreservation;

import com.github.javaparser.GeneratedJavaParserConstants;
import com.github.javaparser.Range;
import com.github.javaparser.ast.Node;
import java.util.Optional;

public abstract class TextElement implements TextElementMatcher, PrintableTextElement {

  abstract String expand();

  abstract boolean isToken(int tokenKind);

  final boolean isCommentToken() {
    return isToken(GeneratedJavaParserConstants.JAVADOC_COMMENT)
        || isToken(GeneratedJavaParserConstants.SINGLE_LINE_COMMENT)
        || isToken(GeneratedJavaParserConstants.MULTI_LINE_COMMENT);
  }

  @Override
  public boolean match(TextElement textElement) {
    return this.equals(textElement);
  }

  abstract boolean isNode(Node node);

  public abstract boolean isLiteral();

  public abstract boolean isWhiteSpace();

  public abstract boolean isSpaceOrTab();

  public abstract boolean isNewline();

  public abstract boolean isComment();

  public abstract boolean isSeparator();

  public abstract boolean isIdentifier();

  public abstract boolean isKeyword();

  public abstract boolean isPrimitive();

  public final boolean isWhiteSpaceOrComment() {
    return isWhiteSpace() || isComment();
  }

  /** Is this TextElement representing a child of the given class? */
  public abstract boolean isChildOfClass(Class<? extends Node> nodeClass);

  public boolean isChild() {
    return isChildOfClass(Node.class);
  }

  abstract Optional<Range> getRange();

  /**
   * Creates a {@link TextElementMatcher} that matches any TextElement with the same range as this
   * TextElement.<br>
   * This can be used to curry another TextElementMatcher.<br>
   * e.g. {@code someTextElementMatcher.and(textElement.matchByRange());}
   *
   * @return TextElementMatcher that matches any TextElement with the same Range
   */
  TextElementMatcher matchByRange() {
    return ( // We're missing range information. This may happen when a node is manually
        // instantiated. Don't be too harsh on that:
        TextElement textElement) ->
        getRange().flatMap(r1 -> textElement.getRange().map(r1::equals)).orElse(true);
  }
}
