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
package lets.core.properties;

import java.util.Properties;

public interface IPropertiesTreeListener {
  void enter(Properties props, int level);

  void exit(Properties props, int level);

  void enter(String name, Properties props, int level);

  void exit(String name, Properties props, int level);

  void enter(String name, Object value, int level);

  void exit(String name, Object value, int level);
}
