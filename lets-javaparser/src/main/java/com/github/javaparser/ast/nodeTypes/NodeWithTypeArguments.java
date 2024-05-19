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

import static com.github.javaparser.ast.NodeList.nodeList;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.metamodel.DerivedProperty;
import java.util.Optional;

/**
 * A node that can have type arguments.
 *
 * <p>
 *
 * <pre>
 *     new X();        --&gt; typeArguments == Optional is empty
 *     new X&lt;&gt;();      --&gt; typeArguments = [], diamondOperator = true
 *     new X&lt;C,D&gt;();   --&gt; typeArguments = [C,D], diamondOperator = false
 * </pre>
 *
 * Only ObjectCreationExpr uses the diamond operator. On other nodes it is treated the same as the
 * first case.
 */
public interface NodeWithTypeArguments<N extends Node> {

  /**
   * @return the types that can be found in the type arguments: {@code <String, Integer>}.
   */
  Optional<NodeList<Type>> getTypeArguments();

  /**
   * Allows you to set the generic arguments
   *
   * @param typeArguments The list of types of the generics, can be null
   */
  N setTypeArguments(NodeList<Type> typeArguments);

  /**
   * @return whether the type arguments look like {@code <>}.
   */
  @DerivedProperty
  default boolean isUsingDiamondOperator() {
    return getTypeArguments().isPresent() && getTypeArguments().get().isEmpty();
  }

  /** Sets the type arguments to {@code <>}. */
  @SuppressWarnings("unchecked")
  default N setDiamondOperator() {
    return setTypeArguments(new NodeList<>());
  }

  /** Removes all type arguments, including the surrounding {@code <>}. */
  @SuppressWarnings("unchecked")
  default N removeTypeArguments() {
    return setTypeArguments((NodeList<Type>) null);
  }

  @SuppressWarnings("unchecked")
  default N setTypeArguments(Type... typeArguments) {
    return setTypeArguments(nodeList(typeArguments));
  }
}
