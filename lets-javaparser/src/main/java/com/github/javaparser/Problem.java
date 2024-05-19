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

import com.github.javaparser.utils.LineSeparator;
import java.util.Comparator;
import java.util.Optional;

/** A problem that was encountered during parsing. */
public class Problem {

  private final String message;

  private final TokenRange location;

  private final Throwable cause;

  public Problem(String message, TokenRange location, Throwable cause) {
    assertNotNull(message);
    this.message = message;
    this.location = location;
    this.cause = cause;
  }

  @Override
  public String toString() {
    final StringBuilder str = new StringBuilder(getVerboseMessage());
    if (cause != null) {
      str.append(LineSeparator.SYSTEM).append("Problem stacktrace : ").append(LineSeparator.SYSTEM);
      for (int i = 0; i < cause.getStackTrace().length; i++) {
        StackTraceElement ste = cause.getStackTrace()[i];
        str.append("  ").append(ste.toString());
        if (i + 1 != cause.getStackTrace().length) str.append(LineSeparator.SYSTEM);
      }
    }
    return str.toString();
  }

  /**
   * @return the message that was passed into the constructor.
   */
  public String getMessage() {
    return message;
  }

  /**
   * @return the message plus location information.
   */
  public String getVerboseMessage() {
    return getLocation()
        .map(
            l ->
                l.getBegin().getRange().map(r -> r.begin.toString()).orElse("(line ?,col ?)")
                    + " "
                    + message)
        .orElse(message);
  }

  /**
   * @return the location that was passed into the constructor.
   */
  public Optional<TokenRange> getLocation() {
    return Optional.ofNullable(location);
  }

  /**
   * @return the cause that was passed into the constructor.
   */
  public Optional<Throwable> getCause() {
    return Optional.ofNullable(cause);
  }

  /** Sorts problems on position. */
  public static Comparator<Problem> PROBLEM_BY_BEGIN_POSITION =
      (a, b) -> {
        final Optional<Position> aBegin =
            a.getLocation().flatMap(l -> l.getBegin().getRange().map(r -> r.begin));
        final Optional<Position> bBegin =
            b.getLocation().flatMap(l -> l.getBegin().getRange().map(r -> r.begin));
        if (aBegin.isPresent() && bBegin.isPresent()) {
          return aBegin.get().compareTo(bBegin.get());
        }
        if (a.getLocation().isPresent() || b.getLocation().isPresent()) {
          if (a.getLocation().isPresent()) {
            return 1;
          }
          return -1;
        }
        return 0;
      };
}
