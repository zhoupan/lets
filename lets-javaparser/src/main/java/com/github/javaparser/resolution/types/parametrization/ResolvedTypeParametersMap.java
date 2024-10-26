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
package com.github.javaparser.resolution.types.parametrization;

import com.github.javaparser.resolution.declarations.ResolvedTypeParameterDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.resolution.types.ResolvedTypeVariable;
import java.util.*;

/**
 * A map of values associated to TypeParameters.
 *
 * @author Federico Tomassetti
 */
public class ResolvedTypeParametersMap {

  public static class Builder {

    private Map<String, ResolvedType> nameToValue;

    private Map<String, ResolvedTypeParameterDeclaration> nameToDeclaration;

    public Builder() {
      nameToValue = new HashMap<>();
      nameToDeclaration = new HashMap<>();
    }

    private Builder(
        Map<String, ResolvedType> nameToValue,
        Map<String, ResolvedTypeParameterDeclaration> nameToDeclaration) {
      this.nameToValue = new HashMap<>();
      this.nameToValue.putAll(nameToValue);
      this.nameToDeclaration = new HashMap<>();
      this.nameToDeclaration.putAll(nameToDeclaration);
    }

    public ResolvedTypeParametersMap build() {
      return new ResolvedTypeParametersMap(nameToValue, nameToDeclaration);
    }

    public Builder setValue(ResolvedTypeParameterDeclaration typeParameter, ResolvedType value) {
      // TODO: we shouldn't just silently overwrite existing types!
      String qualifiedName = typeParameter.getQualifiedName();
      nameToValue.put(qualifiedName, value);
      nameToDeclaration.put(qualifiedName, typeParameter);
      return this;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ResolvedTypeParametersMap)) return false;
    ResolvedTypeParametersMap that = (ResolvedTypeParametersMap) o;
    return nameToValue.equals(that.nameToValue) && nameToDeclaration.equals(that.nameToDeclaration);
  }

  @Override
  public int hashCode() {
    return nameToValue.hashCode();
  }

  @Override
  public String toString() {
    return "TypeParametersMap{" + "nameToValue=" + nameToValue + '}';
  }

  private Map<String, ResolvedType> nameToValue;

  private Map<String, ResolvedTypeParameterDeclaration> nameToDeclaration;

  public static ResolvedTypeParametersMap empty() {
    return new Builder().build();
  }

  private ResolvedTypeParametersMap(
      Map<String, ResolvedType> nameToValue,
      Map<String, ResolvedTypeParameterDeclaration> nameToDeclaration) {
    this.nameToValue = new HashMap<>();
    this.nameToValue.putAll(nameToValue);
    this.nameToDeclaration = new HashMap<>();
    this.nameToDeclaration.putAll(nameToDeclaration);
  }

  public ResolvedType getValue(ResolvedTypeParameterDeclaration typeParameter) {
    String qualifiedName = typeParameter.getQualifiedName();
    if (nameToValue.containsKey(qualifiedName)) {
      return nameToValue.get(qualifiedName);
    }
    return new ResolvedTypeVariable(typeParameter);
  }

  public Optional<ResolvedType> getValueBySignature(String signature) {
    if (nameToValue.containsKey(signature)) {
      return Optional.of(nameToValue.get(signature));
    }
    return Optional.empty();
  }

  public List<String> getNames() {
    return new ArrayList<>(nameToValue.keySet());
  }

  public List<ResolvedType> getTypes() {
    return new ArrayList<>(nameToValue.values());
  }

  public Builder toBuilder() {
    return new Builder(nameToValue, nameToDeclaration);
  }

  public boolean isEmpty() {
    return nameToValue.isEmpty();
  }

  public ResolvedType replaceAll(ResolvedType type) {
    Map<ResolvedTypeParameterDeclaration, ResolvedType> inferredTypes = new HashMap<>();
    for (ResolvedTypeParameterDeclaration typeParameterDeclaration :
        this.nameToDeclaration.values()) {
      type =
          type.replaceTypeVariables(
              typeParameterDeclaration, getValue(typeParameterDeclaration), inferredTypes);
    }
    return type;
  }
}
