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

public interface ConfigurationOption {

  /*
   * Set a currentValue to an option
   */
  ConfigurationOption value(Object value);

  /*
   * returns True if the option has a currentValue
   */
  boolean hasValue();

  /*
   * returns the currentValue as an Integer
   */
  Integer asInteger();

  /*
   * returns the currentValue as a String
   */
  String asString();

  /*
   * returns the currentValue as a Boolean
   */
  Boolean asBoolean();

  <T extends Object> T asValue();
}
