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
 * Lookups a String key for a String value.
 *
 * <p>This class represents the simplest form of a string to string map. It has a benefit over a map
 * in that it can create the result on demand based on the key.
 *
 * <p>For example, it would be possible to implement a lookup that used the key as a primary key,
 * and looked up the value on demand from the database.
 *
 * @since 1.3
 */
@FunctionalInterface
public interface StringLookup {

  /**
   * Looks up a String key to provide a String value.
   *
   * <p>The internal implementation may use any mechanism to return the value. The simplest
   * implementation is to use a Map. However, virtually any implementation is possible.
   *
   * <p>For example, it would be possible to implement a lookup that used the key as a primary key,
   * and looked up the value on demand from the database Or, a numeric based implementation could be
   * created that treats the key as an integer, increments the value and return the result as a
   * string - converting 1 to 2, 15 to 16 etc.
   *
   * <p>This method always returns a String, regardless of the underlying data, by converting it as
   * necessary. For example:
   *
   * <pre>
   * Map&lt;String, Object&gt; map = new HashMap&lt;String, Object&gt;();
   * map.put("number", new Integer(2));
   * assertEquals("2", StringLookupFactory.mapStringLookup(map).lookup("number"));
   * </pre>
   *
   * @param key the key to look up, may be null.
   * @return The matching value, null if no match.
   */
  String lookup(String key);
}
