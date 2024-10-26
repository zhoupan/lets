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
package lets.core.component;

import java.math.BigDecimal;

public class DataType {

  public String className;

  public DataType fromClass(Class<?> clasz) {
    this.className = clasz.getName();
    return this;
  }

  public Class<?> asClass() throws ClassNotFoundException {
    return Class.forName(this.className);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((className == null) ? 0 : className.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    DataType other = (DataType) obj;
    if (className == null) {
      if (other.className != null) return false;
    } else if (!className.equals(other.className)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "DataType [className=" + className + "]";
  }

  public boolean typeOf(Class<?> clasz) {
    if (clasz == null) {
      return false;
    }
    return clasz.getName().equals(this.className);
  }

  public boolean typeOfBoolean() {
    return typeOf(Boolean.class);
  }

  public boolean extendOf(Class<?> clasz) {
    try {
      return clasz.isAssignableFrom(this.asClass());
    } catch (Throwable e) {
      return false;
    }
  }

  public boolean typeOfNumber() {
    return this.extendOf(Number.class);
  }

  public boolean typeOfInteger() {
    return typeOf(Integer.class);
  }

  public boolean typeOfString() {
    return typeOf(String.class);
  }

  public boolean typeOfBigDecimal() {
    return typeOf(BigDecimal.class);
  }
}
