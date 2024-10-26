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
package lets.core.jtoml;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Toml getter interface.
 *
 * @author Alexandre Grison
 */
public interface Getter {
  /**
   * Get the object.
   *
   * @param key the key where the object is located
   * @return the object located at the given key.
   */
  Object get(String key);

  /**
   * Get the string.
   *
   * @param key the key where the object is located
   * @return the string located at the given key.
   */
  String getString(String key);

  /**
   * Get the Long value.
   *
   * @param key the key where the object is located
   * @return the long located at the given key.
   */
  Long getLong(String key);

  /**
   * Get the double value.
   *
   * @param key the key where the object is located
   * @return the float located at the given key.
   */
  Double getDouble(String key);

  /**
   * Get the date (as Calendar)
   *
   * @param key the key where the object is located
   * @return the date located at the given key.
   */
  Calendar getDate(String key);

  /**
   * Get the list.
   *
   * @param key the key where the object is located
   * @return the list located at the given key.
   */
  List<Object> getList(String key);

  /**
   * Get a boolean.
   *
   * @param key the key where the object is located
   * @return the boolean located at the given key.
   */
  Boolean getBoolean(String key);

  /**
   * Get a Map.
   *
   * @param key the key where the object is located
   * @return the map located at the given key.
   */
  Map<String, Object> getMap(String key);

  /**
   * Get an object of a specific class.
   *
   * @param key the key where the object is located
   * @param clazz the class of the object
   * @param <T> the type
   * @return the object located at the given key.
   */
  <T> T getAs(String key, Class<T> clazz);
}
