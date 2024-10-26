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
package com.github.javaparser.resolution.types;

import com.github.javaparser.resolution.declarations.ResolvedTypeParameterDeclaration;
import java.util.*;
import java.util.stream.Collectors;

/**
 * An intersection type is defined in java as list of types separates by ampersands.
 *
 * @author Federico Tomassetti
 */
public class ResolvedIntersectionType implements ResolvedType {

  private List<ResolvedType> elements;

  public ResolvedIntersectionType(Collection<ResolvedType> elements) {
    if (elements.size() < 2) {
      throw new IllegalArgumentException(
          "An intersection type should have at least two elements. This has " + elements.size());
    }
    this.elements = new LinkedList<>(elements);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ResolvedIntersectionType that = (ResolvedIntersectionType) o;
    return new HashSet<>(elements).equals(new HashSet<>(that.elements));
  }

  @Override
  public int hashCode() {
    return new HashSet<>(elements).hashCode();
  }

  @Override
  public String describe() {
    return String.join(
        " & ", elements.stream().map(ResolvedType::describe).collect(Collectors.toList()));
  }

  @Override
  public boolean isAssignableBy(ResolvedType other) {
    return elements.stream().allMatch(e -> e.isAssignableBy(other));
  }

  @Override
  public ResolvedType replaceTypeVariables(
      ResolvedTypeParameterDeclaration tp,
      ResolvedType replaced,
      Map<ResolvedTypeParameterDeclaration, ResolvedType> inferredTypes) {
    List<ResolvedType> elementsReplaced =
        elements.stream()
            .map(e -> e.replaceTypeVariables(tp, replaced, inferredTypes))
            .collect(Collectors.toList());
    if (elementsReplaced.equals(elements)) {
      return this;
    }
    return new ResolvedIntersectionType(elementsReplaced);
  }

  /*
   * Returns the list of the resolved types
   */
  public List<ResolvedType> getElements() {
    return elements;
  }
}
