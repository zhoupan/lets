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

import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A union type is defined in java as list of types separates by pipes.
 *
 * @author Federico Tomassetti
 */
public class ResolvedUnionType implements ResolvedType {

  private List<ResolvedType> elements;

  public ResolvedUnionType(List<ResolvedType> elements) {
    if (elements.size() < 2) {
      throw new IllegalArgumentException(
          "An union type should have at least two elements. This has " + elements.size());
    }
    this.elements = new LinkedList<>(elements);
  }

  public Optional<ResolvedReferenceType> getCommonAncestor() {
    Optional<List<ResolvedReferenceType>> reduce =
        elements.stream()
            .map(ResolvedType::asReferenceType)
            .map(rt -> rt.getAllAncestors(ResolvedReferenceTypeDeclaration.breadthFirstFunc))
            .reduce(
                (a, b) -> {
                  ArrayList<ResolvedReferenceType> common = new ArrayList<>(a);
                  common.retainAll(b);
                  return common;
                });
    return reduce.orElse(new ArrayList<>()).stream().findFirst();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ResolvedUnionType that = (ResolvedUnionType) o;
    return new HashSet<>(elements).equals(new HashSet<>(that.elements));
  }

  @Override
  public int hashCode() {
    return new HashSet<>(elements).hashCode();
  }

  @Override
  public String describe() {
    return String.join(
        " | ", elements.stream().map(ResolvedType::describe).collect(Collectors.toList()));
  }

  @Override
  public boolean isAssignableBy(ResolvedType other) {
    return elements.stream().allMatch(e -> e.isAssignableBy(other));
  }

  @Override
  public boolean isUnionType() {
    return true;
  }

  @Override
  public ResolvedUnionType asUnionType() {
    return this;
  }

  /*
   * Returns the list of the resolved types
   */
  public List<ResolvedType> getElements() {
    return elements;
  }
}
