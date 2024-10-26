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

/**
 * Declaration of a parameter.
 *
 * @author Federico Tomassetti
 */
public interface ResolvedParameterDeclaration extends ResolvedValueDeclaration {

  @Override
  default boolean isParameter() {
    return true;
  }

  /** Necessary because parameters obtained through reflection could not have a name. */
  default boolean hasName() {
    return true;
  }

  @Override
  default ResolvedParameterDeclaration asParameter() {
    return this;
  }

  /** Is this parameter declared as variadic? */
  boolean isVariadic();

  /**
   * Describe the type of the parameter. In practice add three dots to the type name if the
   * parameter is variadic.
   */
  default String describeType() {
    if (isVariadic()) {
      return getType().asArrayType().getComponentType().describe() + "...";
    }
    return getType().describe();
  }
}
