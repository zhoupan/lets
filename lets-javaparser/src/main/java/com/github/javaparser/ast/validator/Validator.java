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

/**
 * A validator that can be run on a node to check for semantic errors. It is fully up to the
 * implementor how to do this.
 */
public interface Validator extends TypedValidator<Node> {

  /**
   * @param node the node that wants to be validated
   * @param problemReporter when found, validation errors can be reported here
   */
  void accept(Node node, ProblemReporter problemReporter);
}
