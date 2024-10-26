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
package com.github.javaparser.utils;

import com.github.javaparser.ast.type.PrimitiveType.Primitive;
import com.github.javaparser.ast.type.VoidType;
import java.lang.reflect.Method;
import java.util.Optional;

public class TypeUtils {

  /*
   * Returns the method descriptor (https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.3.3)
   * The method descriptor for the method: {@code Object m(int i, double d, Thread t) {...}}
   * is {@code (IDLjava/lang/Thread;)Ljava/lang/Object;}
   * Note that the internal forms of the binary names of Thread and Object are used.
   */
  public static String getMethodDescriptor(Method method) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(");
    for (Class<?> parameter : method.getParameterTypes()) {
      appendDescriptor(parameter, stringBuilder);
    }
    stringBuilder.append(")");
    appendDescriptor(method.getReturnType(), stringBuilder);
    return stringBuilder.toString();
  }

  private static void appendDescriptor(final Class<?> clazz, final StringBuilder stringBuilder) {
    Class<?> currentClass = clazz;
    while (currentClass.isArray()) {
      stringBuilder.append("[");
      currentClass = currentClass.getComponentType();
    }
    if (currentClass.isPrimitive()) {
      String descriptor = getPrimitiveTypeDescriptor(currentClass);
      stringBuilder.append(descriptor);
    } else {
      stringBuilder.append("L").append(currentClass.getName().replace(".", "/")).append(";");
    }
  }

  public static String getPrimitiveTypeDescriptor(final Class<?> clazz) {
    if (clazz == Void.TYPE || clazz == Void.class) {
      return new VoidType().toDescriptor();
    }
    String className = clazz.getSimpleName();
    Optional<Primitive> prim = Primitive.byTypeName(className);
    if (prim.isPresent()) {
      return prim.get().toDescriptor();
    }
    prim = Primitive.byBoxedTypeName(className);
    return prim.map(pType -> pType.toDescriptor())
        .orElseThrow(
            () ->
                new IllegalArgumentException(
                    String.format("Unknown primitive type \"%s\"", className)));
  }
}
