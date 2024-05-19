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

/**
 * The special type void.
 *
 * @author Federico Tomassetti
 */
public class ResolvedVoidType implements ResolvedType {

  public static final ResolvedType INSTANCE = new ResolvedVoidType();

  private ResolvedVoidType() {}

  @Override
  public String describe() {
    return "void";
  }

  @Override
  public boolean isAssignableBy(ResolvedType other) {
    // According to https://docs.oracle.com/javase/specs/jls/se16/html/jls-14.html#jls-14.8:
    // """
    // Note that the Java programming language does not allow a "cast to void" - void is not a type
    // - so the
    // traditional C trick of writing an expression statement such as:
    //
    // (void)... ;  // incorrect!
    //
    // does not work.
    // """
    //
    // In short, nothing can be assign to "void".
    return false;
  }

  @Override
  public boolean isVoid() {
    return true;
  }

  @Override
  public String toDescriptor() {
    return "V";
  }
}
