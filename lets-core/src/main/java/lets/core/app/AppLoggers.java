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
package lets.core.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

/**
 * AppLoggers.
 *
 * @author zhoupan
 */
public class AppLoggers {

  /** The persistence. */
  public static Logger PERSISTENCE = LoggerFactory.getLogger("Persistence");

  /** The cache. */
  public static Logger CACHE = LoggerFactory.getLogger("Cache");

  /** The general. */
  public static Logger GENERAL = LoggerFactory.getLogger("General");

  /**
   * Message format.
   *
   * @param pattern the pattern
   * @param args the args
   * @return the string
   */
  public static String messageFormat(String pattern, Object... args) {
    return MessageFormatter.arrayFormat(pattern, args).getMessage();
  }
}
