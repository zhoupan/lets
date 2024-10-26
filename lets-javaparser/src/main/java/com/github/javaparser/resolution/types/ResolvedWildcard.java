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

import com.github.javaparser.resolution.Context;
import com.github.javaparser.resolution.declarations.ResolvedTypeParameterDeclaration;
import java.util.List;
import java.util.Map;

/**
 * A wildcard can be: - unbounded (?) - have a lower bound (? super Number) - have an upper bound (?
 * extends Number) It is not possible to have both a lower and an upper bound at the same time.
 *
 * @author Federico Tomassetti
 */
public class ResolvedWildcard implements ResolvedType {

  public static ResolvedWildcard UNBOUNDED = new ResolvedWildcard(null, null);

  private BoundType type;

  private ResolvedType boundedType;

  private ResolvedWildcard(BoundType type, ResolvedType boundedType) {
    if (type == null && boundedType != null) {
      throw new IllegalArgumentException();
    }
    if (type != null && boundedType == null) {
      throw new IllegalArgumentException();
    }
    this.type = type;
    this.boundedType = boundedType;
  }

  public static ResolvedWildcard superBound(ResolvedType type) {
    return new ResolvedWildcard(BoundType.SUPER, type);
  }

  public static ResolvedWildcard extendsBound(ResolvedType type) {
    return new ResolvedWildcard(BoundType.EXTENDS, type);
  }

  @Override
  public String toString() {
    return "WildcardUsage{" + "type=" + type + ", boundedType=" + boundedType + '}';
  }

  @Override
  public boolean isWildcard() {
    return true;
  }

  @Override
  public ResolvedWildcard asWildcard() {
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ResolvedWildcard)) return false;
    ResolvedWildcard that = (ResolvedWildcard) o;
    if (boundedType != null ? !boundedType.equals(that.boundedType) : that.boundedType != null)
      return false;
    if (type != that.type) return false;
    return true;
  }

  @Override
  public int hashCode() {
    int result = type != null ? type.hashCode() : 0;
    result = 31 * result + (boundedType != null ? boundedType.hashCode() : 0);
    return result;
  }

  @Override
  public String describe() {
    if (type == null) {
      return "?";
    }
    if (type == BoundType.SUPER) {
      return "? super " + boundedType.describe();
    }
    if (type == BoundType.EXTENDS) {
      return "? extends " + boundedType.describe();
    }
    throw new UnsupportedOperationException();
  }

  public boolean isSuper() {
    return type == BoundType.SUPER;
  }

  public boolean isExtends() {
    return type == BoundType.EXTENDS;
  }

  public boolean isBounded() {
    return isSuper() || isExtends();
  }

  public ResolvedType getBoundedType() {
    if (boundedType == null) {
      throw new IllegalStateException();
    }
    return boundedType;
  }

  @Override
  public boolean isAssignableBy(ResolvedType other) {
    if (boundedType == null) {
      // return other.isReferenceType() &&
      // other.asReferenceType().getQualifiedName().equals(Object.class.getCanonicalName());
      return false;
    }
    if (type == BoundType.SUPER) {
      return boundedType.isAssignableBy(other);
    }
    if (type == BoundType.EXTENDS) {
      return false;
    }
    throw new RuntimeException();
  }

  @Override
  public ResolvedType replaceTypeVariables(
      ResolvedTypeParameterDeclaration tpToReplace,
      ResolvedType replaced,
      Map<ResolvedTypeParameterDeclaration, ResolvedType> inferredTypes) {
    if (replaced == null) {
      throw new IllegalArgumentException();
    }
    if (boundedType == null) {
      return this;
    }
    ResolvedType boundedTypeReplaced =
        boundedType.replaceTypeVariables(tpToReplace, replaced, inferredTypes);
    if (boundedTypeReplaced == null) {
      throw new RuntimeException();
    }
    if (boundedTypeReplaced != boundedType) {
      return new ResolvedWildcard(type, boundedTypeReplaced);
    }
    return this;
  }

  @Override
  public boolean mention(List<ResolvedTypeParameterDeclaration> typeParameters) {
    return boundedType != null && boundedType.mention(typeParameters);
  }

  public boolean isUpperBounded() {
    return isExtends();
  }

  public boolean isLowerBounded() {
    return isSuper();
  }

  public enum BoundType {
    SUPER,
    EXTENDS
  }

  /*
   * Returns the bounded resolved type.
   */
  @Override
  public ResolvedType solveGenericTypes(Context context) {
    if (isExtends() || isSuper()) {
      ResolvedType boundResolved = getBoundedType().solveGenericTypes(context);
      if (isExtends()) {
        return ResolvedWildcard.extendsBound(boundResolved);
      }
      return ResolvedWildcard.superBound(boundResolved);
    }
    return this;
  }

  //
  // Erasure
  //
  // The erasure of a type variable (§4.4) is the erasure of its leftmost bound.
  // This method returns null if no bound is declared. This is probably a limitation.
  //
  @Override
  public ResolvedType erasure() {
    return boundedType;
  }
}
