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

import static com.github.javaparser.ast.NodeList.toNodeList;

import com.github.javaparser.ast.AccessSpecifier;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import java.util.Arrays;
import java.util.List;

/** A Node with Modifiers. Note that not all modifiers may be valid for this node. */
public interface NodeWithModifiers<N extends Node> {

  /**
   * Return the modifiers of this variable declaration. Warning: modifying the returned set will not
   * trigger observers, you have to use setModifiers for that.
   *
   * @return modifiers
   * @see Modifier
   */
  NodeList<Modifier> getModifiers();

  N setModifiers(NodeList<Modifier> modifiers);

  @SuppressWarnings("unchecked")
  default N addModifier(Modifier.Keyword... newModifiers) {
    NodeList<Modifier> existingModifiers = new NodeList<>(getModifiers());
    for (Modifier.Keyword newModifier : newModifiers) {
      boolean alreadyPresent =
          existingModifiers.stream().anyMatch(m -> m.getKeyword() == newModifier);
      if (!alreadyPresent) {
        existingModifiers.add(new Modifier(newModifier));
      }
    }
    setModifiers(existingModifiers);
    return (N) this;
  }

  @SuppressWarnings("unchecked")
  default N removeModifier(Modifier.Keyword... modifiersToRemove) {
    List<Modifier.Keyword> modifiersToRemoveAsList = Arrays.asList(modifiersToRemove);
    NodeList<Modifier> remaining =
        getModifiers().stream()
            .filter(
                existingModifier ->
                    !modifiersToRemoveAsList.contains(existingModifier.getKeyword()))
            .collect(toNodeList());
    setModifiers(remaining);
    return (N) this;
  }

  default N setModifier(Modifier.Keyword m, boolean set) {
    if (set) {
      return addModifier(m);
    }
    return removeModifier(m);
  }

  /**
   * @param modifier the modifer being searched for
   * @return true if the modifier has been explicitly added to this node, else false
   */
  default boolean hasModifier(Modifier.Keyword modifier) {
    for (Modifier m : getModifiers()) {
      if (m.getKeyword() == modifier) {
        return true;
      }
    }
    return false;
  }

  /** Creates a list of modifier nodes corresponding to the keywords passed, and set it. */
  default N setModifiers(final Modifier.Keyword... modifiers) {
    return setModifiers(Arrays.stream(modifiers).map(Modifier::new).collect(toNodeList()));
  }

  /**
   * @return the access specifier as far as it can be derived from the modifiers. Does not take
   *     anything else into account (like "interface methods are implicitly public")
   */
  default AccessSpecifier getAccessSpecifier() {
    for (Modifier modifier : getModifiers()) {
      switch (modifier.getKeyword()) {
        case PUBLIC:
          return AccessSpecifier.PUBLIC;
        case PROTECTED:
          return AccessSpecifier.PROTECTED;
        case PRIVATE:
          return AccessSpecifier.PRIVATE;
      }
    }
    return AccessSpecifier.NONE;
  }
}
