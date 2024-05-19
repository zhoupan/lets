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
package com.github.javaparser.generator.metamodel;

import static java.lang.reflect.Modifier.isAbstract;

import com.github.javaparser.ast.NodeList;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Optional;

/** A hacky thing that collects flags we need from AST types to generate the metamodel. */
class AstTypeAnalysis {
  final boolean isAbstract;
  boolean isOptional = false;
  boolean isNodeList = false;
  boolean isSelfType = false;
  Class<?> innerType;

  AstTypeAnalysis(Type type) {
    if (type instanceof Class<?>) {
      TypeVariable<? extends Class<?>>[] typeParameters = ((Class<?>) type).getTypeParameters();
      if (typeParameters.length > 0) {
        isSelfType = true;
      }
    } else {
      while (type instanceof ParameterizedType) {
        ParameterizedType t = (ParameterizedType) type;
        Type currentOuterType = t.getRawType();
        if (currentOuterType == NodeList.class) {
          isNodeList = true;
        }
        if (currentOuterType == Optional.class) {
          isOptional = true;
        }

        if (t.getActualTypeArguments()[0] instanceof WildcardType) {
          type = t.getRawType();
          isSelfType = true;
          break;
        }
        type = t.getActualTypeArguments()[0];
      }
    }
    innerType = (Class<?>) type;
    isAbstract = isAbstract(innerType.getModifiers());
  }
}
