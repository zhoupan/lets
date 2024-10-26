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

import org.slf4j.Logger;

/**
 * LoggerService.
 *
 * @author zhoupan
 */
public interface LoggerService {

  /**
   * Gets the logger.
   *
   * @param name the name
   * @return the logger
   */
  Logger getLogger(String name);

  /**
   * Gets the logger.
   *
   * @param clasz the clasz
   * @return the logger
   */
  Logger getLogger(Class<?> clasz);

  /**
   * Sets the logger level.
   *
   * @param name the name
   * @param level the level
   */
  void setLoggerLevel(String name, int level);
}
