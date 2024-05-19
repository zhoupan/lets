/*
 * Copyright (c) 2015-2016 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.symbolsolver.reflectionmodel;

import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedEnumConstantDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.model.typesystem.ReferenceTypeImpl;
import com.github.javaparser.resolution.types.ResolvedType;
import java.lang.reflect.Field;

public class ReflectionEnumConstantDeclaration implements ResolvedEnumConstantDeclaration {

  private Field enumConstant;
  private TypeSolver typeSolver;

  public ReflectionEnumConstantDeclaration(Field enumConstant, TypeSolver typeSolver) {
    if (!enumConstant.isEnumConstant()) {
      throw new IllegalArgumentException("The given field does not represent an enum constant");
    }
    this.enumConstant = enumConstant;
    this.typeSolver = typeSolver;
  }

  @Override
  public String getName() {
    return enumConstant.getName();
  }

  @Override
  public ResolvedType getType() {
    Class<?> enumClass = enumConstant.getDeclaringClass();
    ResolvedReferenceTypeDeclaration typeDeclaration =
        new ReflectionEnumDeclaration(enumClass, typeSolver);
    return new ReferenceTypeImpl(typeDeclaration);
  }
}
