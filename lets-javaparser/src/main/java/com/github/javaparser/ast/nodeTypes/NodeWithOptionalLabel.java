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

import static com.github.javaparser.utils.Utils.assertNonEmpty;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.SimpleName;
import java.util.Optional;

/** A node that has an optional label. */
public interface NodeWithOptionalLabel<T extends Node> {

  Optional<SimpleName> getLabel();

  T setLabel(SimpleName label);

  T removeLabel();

  default T setLabel(String label) {
    assertNonEmpty(label);
    return setLabel(new SimpleName(label));
  }

  default Optional<String> getLabelAsString() {
    return getLabel().flatMap(l -> Optional.of(l.getIdentifier()));
  }
}
