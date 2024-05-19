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
package com.github.javaparser.ast.visitor;

public interface Visitable {

  /**
   * Accept method for visitor support.
   *
   * @param <R> the type of the return value of the visitor
   * @param <A> the type the user argument passed to the visitor
   * @param v the visitor implementation
   * @param arg the argument passed to the visitor (of type A)
   * @return the result of the visit (of type R)
   */
  <R, A> R accept(GenericVisitor<R, A> v, A arg);

  /**
   * Accept method for visitor support.
   *
   * @param <A> the type the argument passed for the visitor
   * @param v the visitor implementation
   * @param arg any value relevant for the visitor (of type A)
   */
  <A> void accept(VoidVisitor<A> v, A arg);
}
