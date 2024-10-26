/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
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
 * Shorthands creating {@link IllegalArgumentException} instances using formatted strings.
 *
 * @since 1.3
 */
final class IllegalArgumentExceptions {

  /**
   * Creates an {@link IllegalArgumentException} with a message formatted with {@link
   * String#format(String,Object...)}.
   *
   * @param format See {@link String#format(String,Object...)}
   * @param args See {@link String#format(String,Object...)}
   * @return an {@link IllegalArgumentException} with a message formatted with {@link
   *     String#format(String,Object...)}
   */
  static IllegalArgumentException format(final String format, final Object... args) {
    return new IllegalArgumentException(String.format(format, args));
  }

  /**
   * Creates an {@link IllegalArgumentException} with a message formatted with {@link
   * String#format(String,Object...)}.
   *
   * @param t the throwable cause
   * @param format See {@link String#format(String,Object...)}
   * @param args See {@link String#format(String,Object...)}
   * @return an {@link IllegalArgumentException} with a message formatted with {@link
   *     String#format(String,Object...)}
   */
  static IllegalArgumentException format(
      final Throwable t, final String format, final Object... args) {
    return new IllegalArgumentException(String.format(format, args), t);
  }

  /** No need to build instances. */
  private IllegalArgumentExceptions() {
    // empty
  }
}
