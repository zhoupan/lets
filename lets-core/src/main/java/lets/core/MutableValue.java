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

/**
 * 目的:替代java.lang.Optional 1. since 1.8 引入了Optional对象 2. 低的android版本不支持1.8,需要android-retrofix
 *
 * @author zhoupan
 * @param <T> the generic type
 */
public class MutableValue<T> implements Mutable<T> {

  /** The value. */
  protected T value;

  /**
   * Gets the value.
   *
   * @return the value
   */
  @Override
  public T getValue() {
    return value;
  }

  /**
   * Gets the.
   *
   * @return the t
   */
  public T get() {
    return value;
  }

  /**
   * Sets the.
   *
   * @param value the value
   * @return the mutable value
   */
  public MutableValue<T> set(T value) {
    this.setValue(value);
    return this;
  }

  /**
   * Sets the value.
   *
   * @param value the new value
   */
  @Override
  public synchronized void setValue(T value) {
    this.value = value;
  }

  /**
   * Checks if is present.
   *
   * @return true, if is present
   */
  public synchronized boolean isPresent() {
    return this.value != null;
  }

  /**
   * Checks if is empty.
   *
   * @return true, if is empty
   */
  public synchronized boolean isEmpty() {
    return this.value == null;
  }

  /**
   * Of.
   *
   * @param <T> the generic type
   * @param value the value
   * @return the mutable value
   */
  public static <T> MutableValue<T> of(T value) {
    MutableValue<T> mv = new MutableValue<T>();
    mv.value = value;
    return mv;
  }

  /**
   * Empty.
   *
   * @param <T> the generic type
   * @return the mutable value
   */
  public static <T> MutableValue<T> empty() {
    MutableValue<T> mv = new MutableValue<T>();
    return mv;
  }

  /**
   * Hash code.
   *
   * @return the int
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  /**
   * Equals.
   *
   * @param obj the obj
   * @return true, if successful
   */
  @SuppressWarnings("rawtypes")
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    MutableValue other = (MutableValue) obj;
    if (value == null) {
      if (other.value != null) {
        return false;
      }
    } else if (!value.equals(other.value)) {
      return false;
    }
    return true;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "MutableValue [value=" + value + "]";
  }

  /**
   * Gets the display string.
   *
   * @return the display string
   */
  public String getDisplayString() {
    return this.getDisplayString("");
  }

  /**
   * 返回显示字符串.
   *
   * @param defaultValue 默认值(当值未设置的时候返回)
   * @return 如果值不为null,返回设置的值,否则返回默认值.
   */
  public String getDisplayString(String defaultValue) {
    try {
      if (this.isPresent()) {
        return this.get().toString();
      }
      return defaultValue;
    } catch (Throwable e) {
      LoggerSupport.error("{}", e);
      return defaultValue;
    }
  }
}
