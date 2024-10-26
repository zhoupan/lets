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
 * JdbcTypeMapper.(JavaType和JdbcType之间的映射关系)
 *
 * @author zhoupan.
 */
public interface JdbcTypeMapper {

  /**
   * Gets the java type.
   *
   * @param jdbcType the jdbc type
   * @return the java type
   */
  Class<?> getJavaType(int jdbcType);

  /**
   * Gets the jdbc type.
   *
   * @param javaType the java type
   * @return the jdbc type
   */
  Integer getJdbcType(Class<?> javaType);
}
