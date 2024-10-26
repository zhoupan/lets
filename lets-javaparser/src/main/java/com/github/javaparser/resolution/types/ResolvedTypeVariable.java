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
 * From JLS 4.4: A type variable is introduced by the declaration of a type parameter of a generic
 * class, interface, method, or constructor (§8.1.2, §9.1.2, §8.4.4, §8.8.4).
 *
 * @author Federico Tomassetti
 */
public class ResolvedTypeVariable implements ResolvedType {

  private ResolvedTypeParameterDeclaration typeParameter;

  public ResolvedTypeVariable(ResolvedTypeParameterDeclaration typeParameter) {
    this.typeParameter = typeParameter;
  }

  @Override
  public String toString() {
    return "TypeVariable {" + typeParameter.toString() + "}";
  }

  public String qualifiedName() {
    return this.typeParameter.getQualifiedName();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ResolvedTypeVariable that = (ResolvedTypeVariable) o;
    if (!typeParameter.getName().equals(that.typeParameter.getName())) return false;
    if (typeParameter.declaredOnType() != that.typeParameter.declaredOnType()) return false;
    if (typeParameter.declaredOnMethod() != that.typeParameter.declaredOnMethod()) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return typeParameter.hashCode();
  }

  @Override
  public boolean isArray() {
    return false;
  }

  @Override
  public ResolvedType replaceTypeVariables(
      ResolvedTypeParameterDeclaration tpToBeReplaced,
      ResolvedType replaced,
      Map<ResolvedTypeParameterDeclaration, ResolvedType> inferredTypes) {
    if (tpToBeReplaced.getName().equals(this.typeParameter.getName())) {
      inferredTypes.put(this.asTypeParameter(), replaced);
      return replaced;
    }
    return this;
  }

  @Override
  public boolean isReferenceType() {
    return false;
  }

  @Override
  public String describe() {
    return typeParameter.getName();
  }

  @Override
  public ResolvedTypeParameterDeclaration asTypeParameter() {
    return typeParameter;
  }

  @Override
  public ResolvedTypeVariable asTypeVariable() {
    return this;
  }

  @Override
  public boolean isTypeVariable() {
    return true;
  }

  @Override
  public boolean isAssignableBy(ResolvedType other) {
    if (other.isTypeVariable()) {
      return describe().equals(other.describe());
    }
    return true;
  }

  @Override
  public boolean mention(List<ResolvedTypeParameterDeclaration> typeParameters) {
    return typeParameters.contains(typeParameter);
  }

  // /
  // / Erasure
  // /
  // The erasure of a type variable (§4.4) is the erasure of its leftmost bound.
  // If no bound is declared for a type variable, Object is assumed.
  //
  @Override
  public ResolvedType erasure() {
    if (typeParameter.isBounded()) {
      return typeParameter.getBounds().get(0).getType();
    }
    return typeParameter.object();
  }

  /*
   * Returns the resolved type for a type variable.
   */
  @Override
  public ResolvedType solveGenericTypes(Context context) {
    return context.solveGenericType(describe()).orElse(this);
  }

  @Override
  public String toDescriptor() {
    return String.format("L%s;", qualifiedName());
  }
}
