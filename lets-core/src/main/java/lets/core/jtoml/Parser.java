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

import java.io.File;

/**
 * Toml Parser interface
 *
 * @author Alexandre Grison
 */
public interface Parser {
  /**
   * Parse the given String as TOML.
   *
   * @param string the string to be parsed.
   * @param <T> the return type.
   * @return the parsed structure
   */
  <T extends Parser & Getter> T parseString(String string);

  /**
   * Parse the given File as TOML.
   *
   * @param file the file to be parsed.
   * @param <T> the return type.
   * @return the parsed structure
   */
  <T extends Parser & Getter> T parseFile(File file);
}
