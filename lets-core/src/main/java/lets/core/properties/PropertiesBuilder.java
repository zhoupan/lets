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
package lets.core.properties;

import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import lets.core.ClassUtils;
import lets.core.CoreUtils;
import lets.core.collections.BeanMap;

/**
 * PropertiesBuilder.
 *
 * @author zhoupan
 */
public class PropertiesBuilder {

  /**
   * Of.
   *
   * @param builders the builders
   * @return the properties builder
   */
  public static PropertiesBuilder of(PropertiesBuilder... builders) {
    PropertiesBuilder builder = new PropertiesBuilder();
    builder.with(builders);
    return builder;
  }

  /**
   * Of.
   *
   * @param builders the builders
   * @return the properties builder
   */
  public static PropertiesBuilder of(Properties... builders) {
    PropertiesBuilder builder = new PropertiesBuilder();
    builder.with(builders);
    return builder;
  }

  /** The props. */
  protected final Properties props = new Properties();

  /**
   * Clean.
   *
   * @return the properties builder
   */
  public PropertiesBuilder clean() {
    this.props.clear();
    return this;
  }

  /**
   * Clone.
   *
   * @return the properties builder
   */
  public PropertiesBuilder clone() {
    return PropertiesBuilder.of(this);
  }

  /**
   * Sets the.
   *
   * @param key the key
   * @param value the value
   * @return the properties builder
   */
  public PropertiesBuilder with(String key, Object value) {
    this.props.put(key, value);
    return this;
  }

  /**
   * With.
   *
   * @param key the key
   * @param value the value
   * @param flatNested the flat nested
   * @return the properties builder
   */
  public PropertiesBuilder with(String key, Object value, boolean flatNested) {
    CoreUtils.checkState(CoreUtils.isNotBlank(key), "Key not allow blank.");
    if (value == null) {
      return this;
    }
    Class<?> classOfValue = value.getClass();
    if (flatNested) {
      if (ClassUtils.isPrimitiveOrWrapper(value.getClass()) || value instanceof String) {
        this.props.put(key, value);
      } else if (classOfValue.isArray()) {
        Object[] array = (Object[]) value;
        for (int index = 0; index < array.length; index++) {
          String keyNext = String.format("%s[%s]", key, index);
          Object valueNext = array[index];
          with(keyNext, valueNext, flatNested);
        }
      } else if (value instanceof List) {
        List<?> list = (List<?>) value;
        for (int index = 0; index < list.size(); index++) {
          String keyNext = String.format("%s[%s]", key, index);
          Object valueNext = list.get(index);
          with(keyNext, valueNext, flatNested);
        }
      } else {
        BeanMap bean = (value instanceof BeanMap) ? (BeanMap) value : BeanMap.create(value);
        for (Entry<String, Object> entry : bean.entry()) {
          String keyNext = entry.getKey();
          Object valueNext = entry.getValue();
          with(String.format("%s.%s", key, keyNext), valueNext, flatNested);
        }
      }
    } else {
      this.props.put(key, value);
    }
    return this;
  }

  /**
   * Sets the.
   *
   * @param key the key
   * @param value the value
   * @return the properties builder
   */
  public PropertiesBuilder with(String key, String value) {
    this.props.setProperty(key, value);
    return this;
  }

  /**
   * Sets the.
   *
   * @param items the items
   * @return the properties builder
   */
  public PropertiesBuilder with(Properties... items) {
    if (items != null) {
      for (Properties item : items) {
        if (item != null) {
          this.props.putAll(item);
        }
      }
    }
    return this;
  }

  /**
   * Sets the.
   *
   * @param items the items
   * @return the properties builder
   */
  public PropertiesBuilder with(PropertiesBuilder... items) {
    if (items != null) {
      for (PropertiesBuilder item : items) {
        if (item != null) {
          this.props.putAll(item.build());
        }
      }
    }
    return this;
  }

  /**
   * Checks for property.
   *
   * @param key the key
   * @return true, if successful
   */
  public boolean hasProperty(String key) {
    CoreUtils.checkState(CoreUtils.isNotBlank(key), "key not allow blank");
    return this.props.containsKey(key);
  }

  /**
   * Gets the int property.
   *
   * @param key the key
   * @param defaultValue the default value
   * @return the int property
   */
  public int getIntProperty(String key, int defaultValue) {
    CoreUtils.checkState(CoreUtils.isNotBlank(key), "key not allow blank");
    try {
      return Integer.valueOf(this.props.getProperty(key, "" + defaultValue));
    } catch (Throwable e) {
      return defaultValue;
    }
  }

  /**
   * Gets the long property.
   *
   * @param key the key
   * @param defaultValue the default value
   * @return the long property
   */
  public long getLongProperty(String key, long defaultValue) {
    CoreUtils.checkState(CoreUtils.isNotBlank(key), "key not allow blank");
    try {
      return Long.valueOf(this.props.getProperty(key, "" + defaultValue));
    } catch (Throwable e) {
      return defaultValue;
    }
  }

  /**
   * Gets the boolean property.
   *
   * @param key the key
   * @param defaultValue the default value
   * @return the boolean property
   */
  public boolean getBooleanProperty(String key, boolean defaultValue) {
    CoreUtils.checkState(CoreUtils.isNotBlank(key), "key not allow blank");
    try {
      return Boolean.valueOf(this.props.getProperty(key, "" + defaultValue));
    } catch (Throwable e) {
      return defaultValue;
    }
  }

  /**
   * Gets the string property.
   *
   * @param key the key
   * @param defaultValue the default value
   * @return the string property
   */
  public String getStringProperty(String key, String defaultValue) {
    CoreUtils.checkState(CoreUtils.isNotBlank(key), "key not allow blank");
    return this.props.getProperty(key, defaultValue);
  }

  /**
   * Gets the string property.
   *
   * @param key the key
   * @return the string property
   */
  public String getStringProperty(String key) {
    CoreUtils.checkState(CoreUtils.isNotBlank(key), "key not allow blank");
    return this.props.getProperty(key);
  }

  /**
   * Builds the.
   *
   * @return the properties
   */
  public Properties build() {
    return (Properties) this.props.clone();
  }

  /**
   * Builds the sorted.
   *
   * @return the sorted properties
   */
  public SortedProperties buildSorted() {
    SortedProperties sorted = new SortedProperties();
    sorted.putAll(this.build());
    return sorted;
  }
}
