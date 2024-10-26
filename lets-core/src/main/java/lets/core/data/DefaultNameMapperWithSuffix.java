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

import lets.core.StringUtils;

/** DefaultNameMapperWithSuffix. */
public class DefaultNameMapperWithSuffix extends DefaultNameMapper {

  /** The suffix. */
  public final String suffix = PropertyNameMapper.UNDERCORE;

  /**
   * Gets the property name.
   *
   * @param columnName the column name
   * @return the property name
   */
  @Override
  public String getPropertyName(String columnName) {
    return super.getPropertyName(StringUtils.substringBeforeLast(columnName, this.suffix));
  }

  /**
   * Gets the column name.
   *
   * @param propertyName the property name
   * @return the column name
   */
  @Override
  public String getColumnName(String propertyName) {
    String columnName = String.format("%s%s", super.getColumnName(propertyName), this.suffix);
    return columnName;
  }
}
