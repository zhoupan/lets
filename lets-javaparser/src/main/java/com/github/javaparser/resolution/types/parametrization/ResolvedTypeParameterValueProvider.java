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
import com.github.javaparser.resolution.types.ResolvedWildcard;
import java.util.Optional;

/**
 * @author Federico Tomassetti
 */
public interface ResolvedTypeParameterValueProvider {

  /** Calculate the value for the given type parameter. It could be inherited. */
  Optional<ResolvedType> typeParamValue(ResolvedTypeParameterDeclaration typeParameterDeclaration);

  /**
   * Replace the type typeParametersValues present in the given type with the ones for which this
   * type has a value.
   */
  default ResolvedType useThisTypeParametersOnTheGivenType(ResolvedType type) {
    if (type.isTypeVariable()) {
      ResolvedTypeParameterDeclaration typeParameter = type.asTypeParameter();
      if (typeParameter.declaredOnType()) {
        Optional<ResolvedType> typeParam = typeParamValue(typeParameter);
        if (typeParam.isPresent()) {
          ResolvedType resolvedTypeParam = typeParam.get();
          // Try to avoid an infinite loop when the type is a wildcard type bounded by a type
          // variable like "? super T"
          if (resolvedTypeParam.isWildcard()
              && (!resolvedTypeParam.asWildcard().equals(ResolvedWildcard.UNBOUNDED)
                  && type.equals(resolvedTypeParam.asWildcard().getBoundedType()))) {
            return type;
          }
          type = resolvedTypeParam;
        }
      }
    }
    if (type.isWildcard() && type.asWildcard().isBounded()) {
      if (type.asWildcard().isExtends()) {
        return ResolvedWildcard.extendsBound(
            useThisTypeParametersOnTheGivenType(type.asWildcard().getBoundedType()));
      }
      return ResolvedWildcard.superBound(
          useThisTypeParametersOnTheGivenType(type.asWildcard().getBoundedType()));
    }
    if (type.isReferenceType()) {
      type =
          type.asReferenceType().transformTypeParameters(this::useThisTypeParametersOnTheGivenType);
    }
    return type;
  }

  Optional<ResolvedType> getGenericParameterByName(String name);
}
