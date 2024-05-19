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

import static com.github.javaparser.StaticJavaParser.parseTypeParameter;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.type.TypeParameter;

/**
 * A node that can have type parameters.
 *
 * <pre>
 *     class X {}        --&gt; typeParameters == []
 *     class X&lt;&gt; {}      --&gt; does not occur.
 *     class X&lt;C,D&gt; {}   --&gt; typeParameters = [C,D]
 * </pre>
 */
public interface NodeWithTypeParameters<N extends Node> {

  NodeList<TypeParameter> getTypeParameters();

  default TypeParameter getTypeParameter(int i) {
    return getTypeParameters().get(i);
  }

  @SuppressWarnings("unchecked")
  default N setTypeParameter(int i, TypeParameter typeParameter) {
    getTypeParameters().set(i, typeParameter);
    return (N) this;
  }

  @SuppressWarnings("unchecked")
  default N addTypeParameter(TypeParameter typeParameter) {
    getTypeParameters().add(typeParameter);
    return (N) this;
  }

  /** Adds a type parameter like {@code X extends Serializable} */
  default N addTypeParameter(String typeParameter) {
    return addTypeParameter(parseTypeParameter(typeParameter));
  }

  N setTypeParameters(NodeList<TypeParameter> typeParameters);

  default boolean isGeneric() {
    return getTypeParameters().size() > 0;
  }
}
