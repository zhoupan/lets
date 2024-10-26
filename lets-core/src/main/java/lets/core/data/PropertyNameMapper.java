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
 * PropertyNameMapper. Java Bean 属性名称和数据库字段名称的映射.
 *
 * @author zhoupan
 */
public interface PropertyNameMapper {

  /** The Constant UNDERCORE. */
  public static final String UNDERCORE = "_";

  /**
   * Gets the property name.
   *
   * @param columnName the column name
   * @return the property name
   */
  public String getPropertyName(String columnName);

  /**
   * Gets the column name.
   *
   * @param propertyName the property name
   * @return the column name
   */
  public String getColumnName(String propertyName);
}
