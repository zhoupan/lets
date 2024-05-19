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
package com.github.javaparser.ast.nodeTypes;

import static com.github.javaparser.StaticJavaParser.parseExpression;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.Expression;
import java.util.function.Function;

/** A node with arguments. */
public interface NodeWithArguments<N extends Node> {

  N setArguments(NodeList<Expression> arguments);

  NodeList<Expression> getArguments();

  default Expression getArgument(int i) {
    return getArguments().get(i);
  }

  @SuppressWarnings("unchecked")
  default N addArgument(String arg) {
    return addArgument(parseExpression(arg));
  }

  @SuppressWarnings("unchecked")
  default N addArgument(Expression arg) {
    getArguments().add(arg);
    return (N) this;
  }

  @SuppressWarnings("unchecked")
  default N setArgument(int i, Expression arg) {
    getArguments().set(i, arg);
    return (N) this;
  }

  /*
   * Returns the position of the argument in the object's argument list.
   */
  default int getArgumentPosition(Expression argument) {
    return getArgumentPosition(argument, expr -> expr);
  }

  /*
   * Returns the position of the {@code argument} in the object's argument
   * list, after converting the argument using the given {@code converter}
   * function.
   */
  default int getArgumentPosition(Expression argument, Function<Expression, Expression> converter) {
    if (argument == null) {
      throw new IllegalStateException();
    }
    for (int i = 0; i < getArguments().size(); i++) {
      Expression expression = getArguments().get(i);
      expression = converter.apply(expression);
      if (expression == argument) return i;
    }
    throw new IllegalStateException();
  }
}
