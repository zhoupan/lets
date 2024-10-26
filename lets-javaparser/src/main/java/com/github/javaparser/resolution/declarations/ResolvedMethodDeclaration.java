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
package com.github.javaparser.resolution.declarations;

import com.github.javaparser.resolution.types.ResolvedType;

/**
 * A declaration of a method (either in an interface, a class, an enum or an annotation).
 *
 * @author Federico Tomassetti
 */
public interface ResolvedMethodDeclaration extends ResolvedMethodLikeDeclaration {

  /**
   * The type of the value returned by the current method. This method can also be invoked for
   * methods returning void.
   */
  ResolvedType getReturnType();

  /** Is the method abstract? All interface methods not marked as default are abstract. */
  boolean isAbstract();

  /** Is this a default method? */
  boolean isDefaultMethod();

  /*
   * Is this method static?
   */
  boolean isStatic();

  /*
   * Returns the method descriptor (https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.3.3)
   * The method descriptor for the method: {@code Object m(int i, double d, Thread t) {...}}
   * is {@code (IDLjava/lang/Thread;)Ljava/lang/Object;}
   * Note that the internal forms of the binary names of Thread and Object are used.
   */
  String toDescriptor();

  /*
   * A method declaration d1 with return type R1 is return-type-substitutable
   * for another method d2 with return type R2 if any of the following is true:
   * If R1 is void then R2 is void.
   * If R1 is a primitive type then R2 is identical to R1.
   * If R1 is a reference type then one of the following is true:
   * R1, adapted to the type parameters of d2 (§8.4.4), is a subtype of R2.
   * R1 can be converted to a subtype of R2 by unchecked conversion (§5.1.9).
   * d1 does not have the same signature as d2 (§8.4.2), and R1 = |R2|.
   * TODO: Probably this method needs to refer to a method "isTypeSubstituable" implemented in ResolvedType
   */
  default boolean isReturnTypeSubstituable(ResolvedType otherResolvedType) {
    ResolvedType returnType = getReturnType();
    if (returnType.isVoid()) {
      return otherResolvedType.isVoid();
    }
    if (returnType.isPrimitive()) {
      return otherResolvedType.isPrimitive()
          && returnType.asPrimitive().equals(otherResolvedType.asPrimitive());
    }
    // If R1 is a reference type then one of the following is true:
    // R1, adapted to the type parameters of d2 (§8.4.4), is a subtype of R2.
    // Below we are trying to compare a reference type for example an Object to a type variable
    // let's say T
    // we can certainly simplify by saying that this is always true.
    if (otherResolvedType.isTypeVariable()) {
      return true;
    }
    // R1 can be converted to a subtype of R2 by unchecked conversion (§5.1.9).
    // d1 does not have the same signature as d2 (§8.4.2), and R1 = |R2|.
    if (returnType.describe().equals(otherResolvedType.erasure().describe())) {
      return true;
    }
    throw new UnsupportedOperationException(
        "Return-Type-Substituable must be implemented on reference type.");
  }
}
