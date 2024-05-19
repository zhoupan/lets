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
package com.github.javaparser.ast.validator;

import static com.github.javaparser.utils.CodeGenerationUtils.f;

import com.github.javaparser.Problem;
import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.nodeTypes.NodeWithTokenRange;
import com.github.javaparser.ast.validator.language_level_validations.UpgradeJavaMessage;
import java.util.function.Consumer;

/** A simple interface where validators can report found problems. */
public class ProblemReporter {

  private final Consumer<Problem> problemConsumer;

  public ProblemReporter(Consumer<Problem> problemConsumer) {
    this.problemConsumer = problemConsumer;
  }

  /**
   * Report a problem.
   *
   * @param message description of the problem
   * @param node the node in which the problem occurred, used to find the Range of the problem.
   */
  public void report(
      final NodeWithTokenRange<?> node, final UpgradeJavaMessage message, final Object... args) {
    this.report(node.getTokenRange().orElse(null), message.toString(), args);
  }

  /**
   * Report a problem.
   *
   * @param message description of the problem
   * @param node the node in which the problem occurred, used to find the Range of the problem.
   */
  public void report(NodeWithTokenRange<?> node, String message, Object... args) {
    this.report(node.getTokenRange().orElse(null), message, args);
  }

  public void report(TokenRange range, String message, Object... args) {
    problemConsumer.accept(new Problem(f(message, args), range, null));
  }
}
