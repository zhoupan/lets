/*
 * Copyright (c) 2021 zhoupan (https://github.com/zhoupan).
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

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * Internal use only.
 *
 * <p>Provides utilities for {@link Charset}.
 *
 * <p>Package private since Apache Commons IO already provides a Charsets because {@link Charset} is
 * in {@code java.nio.charset}.
 *
 * @since 3.10
 */
public class Charsets {

  /**
   * Returns the given {@code charset} or the default Charset if {@code charset} is null.
   *
   * @param charset a Charset or null.
   * @return the given {@code charset} or the default Charset if {@code charset} is null.
   */
  static Charset toCharset(final Charset charset) {
    return charset == null ? Charset.defaultCharset() : charset;
  }

  /**
   * Returns the given {@code charset} or the default Charset if {@code charset} is null.
   *
   * @param charsetName a Charset or null.
   * @return the given {@code charset} or the default Charset if {@code charset} is null.
   * @throws UnsupportedCharsetException If no support for the named charset is available in this
   *     instance of the Java virtual machine
   */
  static Charset toCharset(final String charsetName) {
    return charsetName == null ? Charset.defaultCharset() : Charset.forName(charsetName);
  }

  /**
   * Returns the given {@code charset} or the default Charset if {@code charset} is null.
   *
   * @param charsetName a Charset or null.
   * @return the given {@code charset} or the default Charset if {@code charset} is null.
   */
  static String toCharsetName(final String charsetName) {
    return charsetName == null ? Charset.defaultCharset().name() : charsetName;
  }
}
