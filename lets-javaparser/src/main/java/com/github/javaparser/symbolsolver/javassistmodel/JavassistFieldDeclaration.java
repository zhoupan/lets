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

import com.github.javaparser.ast.AccessSpecifier;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedFieldDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedTypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedTypeParametrizable;
import com.github.javaparser.resolution.types.ResolvedType;
import java.lang.reflect.Modifier;
import javassist.CtField;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.SignatureAttribute;

/**
 * @author Federico Tomassetti
 */
public class JavassistFieldDeclaration implements ResolvedFieldDeclaration {
  private CtField ctField;
  private TypeSolver typeSolver;

  public JavassistFieldDeclaration(CtField ctField, TypeSolver typeSolver) {
    this.ctField = ctField;
    this.typeSolver = typeSolver;
  }

  @Override
  public ResolvedType getType() {
    try {
      String signature = ctField.getGenericSignature();
      if (signature == null) {
        signature = ctField.getSignature();
      }
      SignatureAttribute.Type genericSignatureType = SignatureAttribute.toTypeSignature(signature);
      return JavassistUtils.signatureTypeToType(
          genericSignatureType, typeSolver, (ResolvedTypeParametrizable) declaringType());
    } catch (BadBytecode e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean isStatic() {
    return Modifier.isStatic(ctField.getModifiers());
  }

  @Override
  public boolean isVolatile() {
    return Modifier.isVolatile(ctField.getModifiers());
  }

  @Override
  public String getName() {
    return ctField.getName();
  }

  @Override
  public boolean isField() {
    return true;
  }

  @Override
  public boolean isParameter() {
    return false;
  }

  @Override
  public boolean isType() {
    return false;
  }

  @Override
  public AccessSpecifier accessSpecifier() {
    return JavassistFactory.modifiersToAccessLevel(ctField.getModifiers());
  }

  @Override
  public ResolvedTypeDeclaration declaringType() {
    return JavassistFactory.toTypeDeclaration(ctField.getDeclaringClass(), typeSolver);
  }
}
