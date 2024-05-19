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

import com.github.javaparser.ast.comments.CommentsCollection;
import com.github.javaparser.utils.LineSeparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/** The results given when parsing with an instance of JavaParser. */
public class ParseResult<T> {

  private final T result;

  private final List<Problem> problems;

  private final CommentsCollection commentsCollection;

  /**
   * General constructor.
   *
   * @param result the AST, or empty if it wasn't created.
   * @param problems a list of encountered parsing problems.
   */
  public ParseResult(T result, List<Problem> problems, CommentsCollection commentsCollection) {
    this.commentsCollection = commentsCollection;
    this.result = result;
    this.problems = problems;
  }

  /**
   * @return if parsing was successful, meaning no errors of any kind were encountered.
   */
  public boolean isSuccessful() {
    return problems.isEmpty() && result != null;
  }

  /** Calls the consumer with the result if parsing was succesful. */
  public void ifSuccessful(Consumer<T> consumer) {
    if (isSuccessful()) {
      consumer.accept(result);
    }
  }

  /**
   * @return the list of encountered parsing problems. Empty when no problems were encountered.
   */
  public List<Problem> getProblems() {
    return problems;
  }

  /**
   * @return the {@code i}'th encountered parsing problem. May throw <code>IndexOutOfBoundsException
   *     </code>.
   */
  public Problem getProblem(int i) {
    return getProblems().get(i);
  }

  /**
   * @return the complete collection of comments encountered while parsing.
   */
  public Optional<CommentsCollection> getCommentsCollection() {
    return Optional.ofNullable(commentsCollection);
  }

  /**
   * @return the AST of the parsed source code, or empty if parsing failed completely.
   */
  public Optional<T> getResult() {
    return Optional.ofNullable(result);
  }

  @Override
  public String toString() {
    if (isSuccessful()) {
      return "Parsing successful";
    }
    StringBuilder message = new StringBuilder("Parsing failed:").append(LineSeparator.SYSTEM);
    for (Problem problem : problems) {
      message.append(problem.toString()).append(LineSeparator.SYSTEM);
    }
    return message.toString();
  }
}
