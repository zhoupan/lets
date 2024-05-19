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
import static java.util.Collections.singletonList;

import com.github.javaparser.utils.LineSeparator;
import java.util.List;

/** Thrown when parsing problems occur during parsing with the static methods on JavaParser. */
public class ParseProblemException extends RuntimeException {

  /** The problems that were encountered during parsing */
  private final List<Problem> problems;

  public ParseProblemException(List<Problem> problems) {
    super(createMessage(assertNotNull(problems)));
    this.problems = problems;
  }

  public ParseProblemException(Throwable throwable) {
    this(singletonList(new Problem(throwable.getMessage(), null, throwable)));
  }

  private static String createMessage(List<Problem> problems) {
    StringBuilder message = new StringBuilder();
    for (Problem problem : problems) {
      message.append(problem.toString()).append(LineSeparator.SYSTEM);
    }
    return message.toString();
  }

  public List<Problem> getProblems() {
    return problems;
  }
}
