/*
 * Copyright (c) 2007-2010 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.ast.validator.language_level_validations;

import com.github.javaparser.ParserConfiguration;

/**
 * Suggestion to upgrade the Java language level. A message that can be used to tell the user that a
 * feature is not available in the configured language level.
 *
 * @since 3.24.5
 */
public final class UpgradeJavaMessage {

  /** The reason why the language level must be upgraded. */
  private final String reason;

  /** The language level that must be configured. */
  private final ParserConfiguration.LanguageLevel level;

  /**
   * Contructor.
   *
   * @param reason The reason why the language level must be upgraded.
   * @param level The language level that must be configured.
   */
  UpgradeJavaMessage(final String reason, final ParserConfiguration.LanguageLevel level) {
    this.reason = reason;
    this.level = level;
  }

  @Override
  public String toString() {
    return String.format(
        "%s Pay attention that this feature is supported starting from '%s' language level. If you need that feature the language level must be configured in the configuration before parsing the source files.",
        this.reason, this.level.toString());
  }
}
