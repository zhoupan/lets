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
package lets.core.data;

/**
 * Simple name-value holder.
 *
 * @param <N> the number type
 * @param <V> the value type
 */
public class NameValueSupport<N, V> implements java.io.Serializable {

  /** */
  private static final long serialVersionUID = 1L;

  /** The name. */
  protected N name;

  /** The value. */
  protected V value;

  /**
   * Simple static constructor.
   *
   * @param <T> the generic type
   * @param <R> the generic type
   * @param name the name
   * @param value the value
   * @return the name value support
   */
  @SuppressWarnings("rawtypes")
  public static <T, R> NameValueSupport of(T name, R value) {
    return new NameValueSupport<>(name, value);
  }

  /**
   * The Constructor.
   *
   * @param name the name
   * @param value the value
   */
  public NameValueSupport(N name, V value) {
    this.name = name;
    this.value = value;
  }

  /**
   * Returns name.
   *
   * @return the n
   */
  public N name() {
    return name;
  }

  /**
   * Returns value.
   *
   * @return the v
   */
  public V value() {
    return value;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public N getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the name
   */
  public void setName(N name) {
    this.name = name;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public V getValue() {
    return value;
  }

  /**
   * Sets the value.
   *
   * @param value the value
   */
  public void setValue(V value) {
    this.value = value;
  }

  /**
   * Equals.
   *
   * @param o the o
   * @return true, if equals
   */
  @SuppressWarnings("rawtypes")
  @Override
  public boolean equals(Object o) {
    if (this.getClass() != o.getClass()) {
      return false;
    }
    NameValueSupport that = (NameValueSupport) o;

    Object n1 = name();
    Object n2 = that.name();

    if (n1 == n2 || (n1 != null && n1.equals(n2))) {
      Object v1 = value();
      Object v2 = that.value();
      if (v1 == v2 || (v1 != null && v1.equals(v2))) {
        return true;
      }
    }
    return false;
  }

  /**
   * Hash code.
   *
   * @return the int
   */
  @Override
  public int hashCode() {
    return (name == null ? 0 : name.hashCode()) ^ (value == null ? 0 : value.hashCode());
  }
}
