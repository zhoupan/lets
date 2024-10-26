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

/**
 * Toml TomlSerializer interface.
 *
 * @author Alexandre Grison
 */
public interface TomlSerializer {
  /**
   * Serializes the given Object to a TOML String.
   *
   * @param object the Object to be serialized
   * @return the TOML String representing the given Object.
   */
  String serialize(Object object);

  /**
   * Serializes the given Object to a TOML String.
   *
   * @param rootKey the root key (can be empty or null)
   * @param object the Object to be serialized
   * @return the TOML String representing the given Object.
   */
  String serialize(String rootKey, Object object);
}
