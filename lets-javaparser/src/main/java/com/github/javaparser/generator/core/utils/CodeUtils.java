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
package com.github.javaparser.generator.core.utils;

import com.github.javaparser.ast.type.Type;

public final class CodeUtils {

  private CodeUtils() {
    // This constructor is used to hide the public one
  }

  /**
   * Cast the value if the current type doesn't match the required type. <br>
   * Given the following example: <code>
   *     int withoutCast = 1;
   *     double withCast = (double) 1;
   * </code> The variable withoutCast doesn't need to be casted, since we have int as required type
   * and int as value type. While in the variable withCast we have double as required type and int
   * as value type.
   *
   * @param value The value to be returned.
   * @param requiredType The expected type to be casted if needed.
   * @param valueType The type of the value to be returned.
   * @return The value casted if needed.
   */
  public static String castValue(String value, Type requiredType, String valueType) {
    String requiredTypeName = requiredType.asString();
    if (requiredTypeName.equals(valueType)) return value;
    return String.format("(%s) %s", requiredTypeName, value);
  }
}
