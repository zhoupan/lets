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
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.model.typesystem.ReferenceTypeImpl;
import com.github.javaparser.resolution.types.ResolvedArrayType;
import com.github.javaparser.resolution.types.ResolvedPrimitiveType;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.resolution.types.ResolvedVoidType;
import java.lang.reflect.Modifier;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * @author Federico Tomassetti
 */
public class JavassistFactory {

  public static ResolvedType typeUsageFor(CtClass ctClazz, TypeSolver typeSolver) {
    try {
      if (ctClazz.isArray()) {
        return new ResolvedArrayType(typeUsageFor(ctClazz.getComponentType(), typeSolver));
      }
      if (ctClazz.isPrimitive()) {
        if (ctClazz.getName().equals("void")) {
          return ResolvedVoidType.INSTANCE;
        }
        return ResolvedPrimitiveType.byName(ctClazz.getName());
      }
      if (ctClazz.isInterface()) {
        return new ReferenceTypeImpl(new JavassistInterfaceDeclaration(ctClazz, typeSolver));
      }
      if (ctClazz.isEnum()) {
        return new ReferenceTypeImpl(new JavassistEnumDeclaration(ctClazz, typeSolver));
      }
      return new ReferenceTypeImpl(new JavassistClassDeclaration(ctClazz, typeSolver));
    } catch (NotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static ResolvedReferenceTypeDeclaration toTypeDeclaration(
      CtClass ctClazz, TypeSolver typeSolver) {
    if (ctClazz.isAnnotation()) {
      return new JavassistAnnotationDeclaration(ctClazz, typeSolver);
    }
    if (ctClazz.isInterface()) {
      return new JavassistInterfaceDeclaration(ctClazz, typeSolver);
    }
    if (ctClazz.isEnum()) {
      return new JavassistEnumDeclaration(ctClazz, typeSolver);
    }
    if (ctClazz.isArray()) {
      throw new IllegalArgumentException("This method should not be called passing an array");
    }
    return new JavassistClassDeclaration(ctClazz, typeSolver);
  }

  static AccessSpecifier modifiersToAccessLevel(final int modifiers) {
    if (Modifier.isPublic(modifiers)) {
      return AccessSpecifier.PUBLIC;
    }
    if (Modifier.isProtected(modifiers)) {
      return AccessSpecifier.PROTECTED;
    }
    if (Modifier.isPrivate(modifiers)) {
      return AccessSpecifier.PRIVATE;
    }
    return AccessSpecifier.NONE;
  }
}
