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
package com.github.javaparser.symbolsolver.javassistmodel;

import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedEnumConstantDeclaration;
import com.github.javaparser.resolution.model.typesystem.ReferenceTypeImpl;
import com.github.javaparser.resolution.types.ResolvedType;
import javassist.CtField;
import javassist.bytecode.AccessFlag;

/**
 * @author Federico Tomassetti
 */
public class JavassistEnumConstantDeclaration implements ResolvedEnumConstantDeclaration {

  private CtField ctField;
  private TypeSolver typeSolver;
  private ResolvedType type;

  public JavassistEnumConstantDeclaration(CtField ctField, TypeSolver typeSolver) {
    if (ctField == null) {
      throw new IllegalArgumentException();
    }
    if ((ctField.getFieldInfo2().getAccessFlags() & AccessFlag.ENUM) == 0) {
      throw new IllegalArgumentException(
          "Trying to instantiate a JavassistEnumConstantDeclaration with something which is not an enum field: "
              + ctField.toString());
    }
    this.ctField = ctField;
    this.typeSolver = typeSolver;
  }

  @Override
  public String getName() {
    return ctField.getName();
  }

  @Override
  public ResolvedType getType() {
    if (type == null) {
      type =
          new ReferenceTypeImpl(
              new JavassistEnumDeclaration(ctField.getDeclaringClass(), typeSolver));
    }
    return type;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName()
        + "{"
        + "ctField="
        + ctField.getName()
        + ", typeSolver="
        + typeSolver
        + '}';
  }
}
