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
import java.util.Map;

/**
 * Array Type.
 *
 * @author Federico Tomassetti
 */
public class ResolvedArrayType implements ResolvedType {

  private ResolvedType baseType;

  public ResolvedArrayType(ResolvedType baseType) {
    this.baseType = baseType;
  }

  // /
  // / Object methods
  // /
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ResolvedArrayType that = (ResolvedArrayType) o;
    if (!baseType.equals(that.baseType)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return baseType.hashCode();
  }

  @Override
  public String toString() {
    return "ResolvedArrayType{" + baseType + "}";
  }

  // /
  // / Type methods
  // /
  @Override
  public ResolvedArrayType asArrayType() {
    return this;
  }

  @Override
  public boolean isArray() {
    return true;
  }

  @Override
  public String describe() {
    return baseType.describe() + "[]";
  }

  public ResolvedType getComponentType() {
    return baseType;
  }

  @Override
  // https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.2
  public boolean isAssignableBy(ResolvedType other) {
    if (other.isNull()) {
      return true;
    }
    if (other.isArray()) {
      if (baseType.isPrimitive() && other.asArrayType().getComponentType().isPrimitive()) {
        return baseType.equals(other.asArrayType().getComponentType());
      }
      // An array of primitive type is not assignable by an array of boxed type nor the reverse
      // An array of primitive type cannot be assigned to an array of Object
      if ((baseType.isPrimitive() && other.asArrayType().getComponentType().isReferenceType())
          || (baseType.isReferenceType() && other.asArrayType().getComponentType().isPrimitive())) {
        return false;
      }
      // An array can be assigned only to a variable of a compatible array type, or to
      // a variable of type Object, Cloneable or java.io.Serializable.
      return baseType.isAssignableBy(other.asArrayType().getComponentType());
    }
    return false;
  }

  @Override
  public ResolvedType replaceTypeVariables(
      ResolvedTypeParameterDeclaration tpToReplace,
      ResolvedType replaced,
      Map<ResolvedTypeParameterDeclaration, ResolvedType> inferredTypes) {
    ResolvedType baseTypeReplaced =
        baseType.replaceTypeVariables(tpToReplace, replaced, inferredTypes);
    if (baseTypeReplaced == baseType) {
      return this;
    }
    return new ResolvedArrayType(baseTypeReplaced);
  }

  // /
  // / Erasure
  // /
  // The erasure of an array type T[] is |T|[].
  @Override
  public ResolvedType erasure() {
    return new ResolvedArrayType(baseType.erasure());
  }

  @Override
  public String toDescriptor() {
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    sb.append(baseType.toDescriptor());
    return sb.toString();
  }
}
