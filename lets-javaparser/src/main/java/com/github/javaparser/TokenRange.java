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

import static com.github.javaparser.utils.Utils.assertNotNull;

import java.util.Iterator;
import java.util.Optional;

/** The range of tokens covered by this node. */
public class TokenRange implements Iterable<JavaToken> {

  public static final TokenRange INVALID = new TokenRange(JavaToken.INVALID, JavaToken.INVALID);

  private final JavaToken begin;

  private final JavaToken end;

  public TokenRange(JavaToken begin, JavaToken end) {
    this.begin = assertNotNull(begin);
    this.end = assertNotNull(end);
  }

  public JavaToken getBegin() {
    return begin;
  }

  public JavaToken getEnd() {
    return end;
  }

  public Optional<Range> toRange() {
    if (begin.hasRange() && end.hasRange()) {
      return Optional.of(new Range(begin.getRange().get().begin, end.getRange().get().end));
    }
    return Optional.empty();
  }

  public TokenRange withBegin(JavaToken begin) {
    return new TokenRange(assertNotNull(begin), end);
  }

  public TokenRange withEnd(JavaToken end) {
    return new TokenRange(begin, assertNotNull(end));
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (JavaToken t : this) {
      result.append(t.getText());
    }
    return result.toString();
  }

  @Override
  public Iterator<JavaToken> iterator() {
    return new Iterator<JavaToken>() {

      private boolean hasNext = true;

      private JavaToken current = begin;

      @Override
      public boolean hasNext() {
        return hasNext;
      }

      @Override
      public JavaToken next() {
        JavaToken retval = current;
        if (current == null) {
          throw new IllegalStateException("Attempting to move past end of range.");
        }
        if (current == end) {
          hasNext = false;
        }
        current = current.getNextToken().orElse(null);
        if (current == null && hasNext) {
          throw new IllegalStateException("End token is not linked to begin token.");
        }
        return retval;
      }
    };
  }
}
