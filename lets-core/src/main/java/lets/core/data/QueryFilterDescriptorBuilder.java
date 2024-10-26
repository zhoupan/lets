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

import java.util.ArrayList;
import java.util.List;
import lets.core.StringUtils;

/**
 * The Class QueryFilterDescriptorBuilder.
 *
 * @author zhoupan.
 */
public class QueryFilterDescriptorBuilder extends QueryFilterBuilder {

  /** The name mapper. */
  protected PropertyNameMapper nameMapper = new DefaultNameMapper();

  /**
   * Gets the name mapper.
   *
   * @return the name mapper
   */
  public PropertyNameMapper getNameMapper() {
    return nameMapper;
  }

  /**
   * Sets the name mapper.
   *
   * @param nameMapper the name mapper
   */
  public void setNameMapper(PropertyNameMapper nameMapper) {
    this.nameMapper = nameMapper;
  }

  /**
   * Gets the filter field suffix.
   *
   * @param filter the filter
   * @return the filter field suffix
   */
  protected String getFilterFieldSuffix(FilterDescriptor filter) {
    // 按目前的约定:相等不增加后缀.
    if (StringUtils.equalsIgnoreCase(FilterOperatorEnum.EQ.getValue(), filter.getOperator())) {
      return "";
    }
    return filter.getOperator().toUpperCase();
  }

  /**
   * Append filter.
   *
   * @param filterBuilder the filter builder
   * @param filter the filter
   */
  public void appendFilter(QueryFilterBuilder filterBuilder, FilterDescriptor filter) {
    if (filter != null
        && StringUtils.isNotBlank(filter.getField())
        && StringUtils.isNotBlank(filter.getOperator())
        && filter.getValue() != null) {
      filterBuilder.put(filter.getField() + getFilterFieldSuffix(filter), filter.getValue());
    }
    if (filter != null && filter.getFilters() != null) {
      for (FilterDescriptor f : filter.getFilters()) {
        appendFilter(filterBuilder, f);
      }
    }
  }

  /**
   * Append filter.
   *
   * @param filter the filter
   * @return the query filter descriptor builder
   */
  public QueryFilterDescriptorBuilder filter(FilterDescriptor filter) {
    this.appendFilter(this, filter);
    return this;
  }

  /**
   * Sort.
   *
   * @param filterBuilder the filter builder
   * @param sort the sort
   */
  public void sort(QueryFilterBuilder filterBuilder, List<SortDescriptor> sort) {
    List<OrderByField> orderByFields = new ArrayList<OrderByField>();
    if (sort != null && !sort.isEmpty()) {
      for (SortDescriptor entry : sort) {
        String field = entry.getField();
        String dir = entry.getDir();
        boolean isAscending = !StringUtils.equalsIgnoreCase("desc", dir);
        OrderByField orderField = new OrderByField(this.getNameMapper(), field, isAscending);
        orderByFields.add(orderField);
      }
    }
    if (orderByFields.size() > 0) {
      filterBuilder.orderBy(OrderByField.buildOrderBySql(orderByFields));
    }
  }

  /**
   * Sort.
   *
   * @param sort the sort
   * @return the query filter descriptor builder
   */
  public QueryFilterDescriptorBuilder sort(List<SortDescriptor> sort) {
    this.sort(this, sort);
    return this;
  }
}
