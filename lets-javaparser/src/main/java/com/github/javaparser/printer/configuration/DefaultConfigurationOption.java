/*
 * Copyright (c) 2011-2013 zhoupan (https://github.com/zhoupan).
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

import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration.ConfigOption;
import com.github.javaparser.utils.Utils;

/*
 * An option is a pair of ConfigOption and a currentValue
 */
public class DefaultConfigurationOption implements ConfigurationOption {

  ConfigOption configOption;

  Object currentValue;

  public DefaultConfigurationOption(ConfigOption configOption) {
    this(configOption, null);
  }

  public DefaultConfigurationOption(ConfigOption configOption, Object value) {
    this.configOption = configOption;
    if (value != null) value(value);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || !(o instanceof DefaultConfigurationOption)) return false;
    DefaultConfigurationOption other = (DefaultConfigurationOption) o;
    return configOption.equals(other.configOption);
  }

  @Override
  public int hashCode() {
    return configOption.hashCode();
  }

  /** Set a currentValue to an option */
  @Override
  public ConfigurationOption value(Object value) {
    Utils.assertNotNull(value);
    this.currentValue = value;
    // verify the currentValue's type
    if (!(configOption.type.isAssignableFrom(value.getClass()))) {
      throw new IllegalArgumentException(
          String.format("%s is not an instance of %s", value, configOption.type.getName()));
    }
    return this;
  }

  /** returns True if the option has a currentValue */
  @Override
  public boolean hasValue() {
    return this.currentValue != null;
  }

  /** returns the currentValue as an Integer */
  @Override
  public Integer asInteger() {
    return cast();
  }

  /** returns the currentValue as a String */
  @Override
  public String asString() {
    return cast();
  }

  /** returns the currentValue as a Boolean */
  @Override
  public Boolean asBoolean() {
    return cast();
  }

  @Override
  public <T extends Object> T asValue() {
    return cast();
  }

  private <T extends Object> T cast() {
    if (!hasValue())
      throw new IllegalArgumentException(
          String.format("The option %s has no currentValue", configOption.name()));
    if (configOption.type.isAssignableFrom(currentValue.getClass()))
      return (T) configOption.type.cast(currentValue);
    throw new IllegalArgumentException(
        String.format("%s cannot be cast to %s", currentValue, configOption.type.getName()));
  }
}
