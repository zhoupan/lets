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

import java.math.BigDecimal;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoupan
 */
public class DefaultJdbcTypeMapper implements JdbcTypeMapper {

  protected Map<Integer, Class<?>> jdbcToJava = new HashMap<>();
  protected Map<Class<?>, Integer> javaToJdbc = new HashMap<>();

  public DefaultJdbcTypeMapper() {
    this.prepareJdbcToJava();
    this.prepareJavaToJdbc();
  }

  public void prepareJdbcToJava() {
    jdbcToJava.put(Types.TINYINT, Integer.class);
    jdbcToJava.put(Types.SMALLINT, Integer.class);
    jdbcToJava.put(Types.INTEGER, Integer.class);
    jdbcToJava.put(Types.BIGINT, Long.class);
    jdbcToJava.put(Types.REAL, Float.class);
    jdbcToJava.put(Types.FLOAT, Double.class);
    jdbcToJava.put(Types.DOUBLE, Double.class);
    jdbcToJava.put(Types.DECIMAL, BigDecimal.class);
    jdbcToJava.put(Types.NUMERIC, Long.class);
    jdbcToJava.put(Types.BIT, Integer.class);
    jdbcToJava.put(Types.CHAR, String.class);
    jdbcToJava.put(Types.VARCHAR, String.class);
    jdbcToJava.put(Types.LONGVARCHAR, String.class);
    jdbcToJava.put(Types.BINARY, Byte[].class);
    jdbcToJava.put(Types.VARBINARY, Byte[].class);
    jdbcToJava.put(Types.LONGVARBINARY, java.io.InputStream.class);
    jdbcToJava.put(Types.DATE, java.util.Date.class);
    jdbcToJava.put(Types.TIME, java.util.Date.class);
    jdbcToJava.put(Types.TIMESTAMP, java.util.Date.class);
    jdbcToJava.put(Types.CLOB, String.class);
    jdbcToJava.put(Types.BLOB, java.sql.Blob.class);
    jdbcToJava.put(Types.ARRAY, java.sql.Array.class);
    jdbcToJava.put(Types.REF, java.sql.Ref.class);
    jdbcToJava.put(Types.STRUCT, java.lang.Object.class);
    jdbcToJava.put(Types.JAVA_OBJECT, java.lang.Object.class);
  }

  public void prepareJavaToJdbc() {
    javaToJdbc.put(Integer.class, Types.INTEGER);
    javaToJdbc.put(Long.class, Types.BIGINT);
    javaToJdbc.put(Float.class, Types.REAL);
    javaToJdbc.put(Double.class, Types.DOUBLE);
    javaToJdbc.put(BigDecimal.class, Types.DECIMAL);
    javaToJdbc.put(String.class, Types.VARCHAR);
    javaToJdbc.put(Byte[].class, Types.VARBINARY);
    javaToJdbc.put(java.io.InputStream.class, Types.LONGVARBINARY);
    javaToJdbc.put(java.util.Date.class, Types.DATE);
  }

  @Override
  public Class<?> getJavaType(int jdbcType) {
    return this.jdbcToJava.get(jdbcType);
  }

  @Override
  public Integer getJdbcType(Class<?> javaType) {
    return this.javaToJdbc.get(javaType);
  }
}
