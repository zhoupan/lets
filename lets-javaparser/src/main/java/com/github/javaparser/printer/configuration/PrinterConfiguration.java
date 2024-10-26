/*
 * Copyright (c) 2013-2024 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.printer.configuration;

import java.util.Optional;
import java.util.Set;

/**
 * This interface defines the API for printer configuration. An option can be added or removed from
 * the configuration. An indentation can also be added to it.
 */
public interface PrinterConfiguration {

  /*
   * add or update an option
   */
  PrinterConfiguration addOption(ConfigurationOption option);

  /*
   * Remove an option
   */
  PrinterConfiguration removeOption(ConfigurationOption option);

  /*
   * True if an option is activated
   */
  boolean isActivated(ConfigurationOption option);

  /*
   * returns the specified option
   */
  Optional<ConfigurationOption> get(ConfigurationOption option);

  /*
   * returns all activated options
   */
  Set<ConfigurationOption> get();
}
