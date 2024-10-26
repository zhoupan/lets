/*
 * Copyright (c) 2022 zhoupan (https://github.com/zhoupan).
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
package lets.core;

/**
 * EnumUtils provides the operations for {@link EnumValue} such as Parse, value of...
 *
 * @author zhoupan
 */
public abstract class EnumValueUtils {

  /**
   * Parse the bounded value into ValuedEnum.
   *
   * @param <T> the generic type
   * @param <V> the value type
   * @param clz the clz
   * @param value the value
   * @return the t
   */
  public static <T extends EnumValue<V>, V> T parse(Class<T> clz, V value) {
    CoreUtils.checkNotNull(clz, "clz can not be null");
    if (value == null) {
      return null;
    }

    for (T t : clz.getEnumConstants()) {
      if (value.equals(t.value())) {
        return t;
      }
    }
    return null;
  }

  /**
   * Text of.
   *
   * @param <T> the generic type
   * @param <V> the value type
   * @param clz the clz
   * @param value the value
   * @param textDefault the text default
   * @return the string
   */
  public static <T extends EnumValue<V>, V> String textOf(
      Class<T> clz, V value, String textDefault) {
    T v = parse(clz, value);
    if (v != null) {
      return v.text();
    } else {
      return textDefault;
    }
  }

  /**
   * Text of.
   *
   * @param <T> the generic type
   * @param <V> the value type
   * @param clz the clz
   * @param value the value
   * @return the string
   */
  public static <T extends EnumValue<V>, V> String textOf(Class<T> clz, V value) {
    return textOf(clz, value, "");
  }

  /**
   * Null-safe valueOf function.
   *
   * @param <T> the generic type
   * @param enumType the enum type
   * @param name the name
   * @return the t
   */
  public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) {
    if (name == null) {
      return null;
    }
    return Enum.valueOf(enumType, name);
  }
}
