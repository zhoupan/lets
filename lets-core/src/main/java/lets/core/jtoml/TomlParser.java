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

import java.util.Map;

/**
 * Toml Parser interface.
 *
 * <p>Every parser should implement that interface.
 *
 * <p>See: The <a href="https://github.com/mojombo/toml">TOML GitHub</a> project for more
 * information about it.
 *
 * @author Alexandre Grison
 */
public interface TomlParser {
  /**
   * Parses the given TOML String.
   *
   * @param tomlString the TOML String
   * @return a Map representing the given TOML structure.
   */
  Map<String, Object> parse(String tomlString);
}
