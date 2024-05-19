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

import com.github.javaparser.ast.Node;

/** Runs a validator on all nodes of a certain type. */
public class SingleNodeTypeValidator<N extends Node> implements Validator {

  private final Class<N> type;

  private final TypedValidator<N> validator;

  public SingleNodeTypeValidator(Class<N> type, TypedValidator<N> validator) {
    this.type = type;
    this.validator = validator;
  }

  @Override
  public void accept(Node node, ProblemReporter problemReporter) {
    if (type.isInstance(node)) {
      validator.accept(type.cast(node), problemReporter);
    }
    node.findAll(type).forEach(n -> validator.accept(n, problemReporter));
  }
}
