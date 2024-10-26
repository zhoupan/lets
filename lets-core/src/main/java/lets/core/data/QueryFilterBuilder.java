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

import java.util.Map;
import lets.core.StringUtils;

/**
 * QueryFilterBuilder.
 *
 * @author zhoupan.
 */
public class QueryFilterBuilder {

  /** The filter. */
  private QueryFilter filter = new QueryFilter();

  /**
   * Builds the.
   *
   * @return the query filter
   */
  public QueryFilter build() {
    return filter;
  }

  /**
   * Params.
   *
   * @param params the params
   * @return the query filter builder
   */
  public QueryFilterBuilder params(Map<String, Object> params) {
    filter.getParams().putAll(params);
    return this;
  }

  /**
   * Offset.
   *
   * @param offset the offset
   * @return the query filter builder
   */
  public QueryFilterBuilder offset(int offset) {
    filter.setOffset(offset);
    return this;
  }

  /**
   * Limit.
   *
   * @param limit the limit
   * @return the query filter builder
   */
  public QueryFilterBuilder limit(int limit) {
    filter.setLimit(limit);
    return this;
  }

  /**
   * Order by.
   *
   * @param orderBy the order by
   * @return the query filter builder
   */
  public QueryFilterBuilder orderBy(String orderBy) {
    filter.setOrderBy(orderBy);
    return this;
  }

  public QueryFilterBuilder put(String key, Object value) {
    filter.getParams().put(key, value);
    return this;
  }

  public QueryFilterBuilder putAll(Map<String, Object> params) {
    if (params == null) {
      return this;
    }
    filter.getParams().putAll(params);
    return this;
  }

  public QueryFilterBuilder remove(String key) {
    filter.getParams().remove(key);
    return this;
  }

  /**
   * 指定单个排序字段和排序方向.
   *
   * @param sort 排序字段.
   * @param order 排序方向(asc/desc).
   * @return
   */
  public QueryFilterBuilder sortAndOrder(String sort, String order) {
    if (StringUtils.isBlank(sort)) {
      return this;
    }
    StringBuilder orderBy = new StringBuilder();
    orderBy.append(sort);
    if (StringUtils.equalsIgnoreCase(QueryFilter.ORDER_BY_DESCENDING, order)) {
      orderBy.append(" ").append(QueryFilter.ORDER_BY_DESCENDING);
    }
    filter.setOrderBy(orderBy.toString());
    return this;
  }

  /**
   * 按指定的字段排序.
   *
   * @param fieldName 属性名称.
   * @param isAscending 是否升序
   * @return
   */
  public QueryFilterBuilder sortAndOrder(String fieldName, boolean isAscending) {
    return this.sortAndOrder(
        fieldName, isAscending ? QueryFilter.ORDER_BY_ASCENDING : QueryFilter.ORDER_BY_DESCENDING);
  }
}
