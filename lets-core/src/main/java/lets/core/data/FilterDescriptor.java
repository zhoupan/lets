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

/**
 * The Class FilterDescriptor.
 *
 * @author zhoupan
 */
public class FilterDescriptor {

  /** The Constant LOGIC_AND. */
  public static final String LOGIC_AND = "and";

  /** The logic. */
  private String logic;

  /** The filters. */
  private List<FilterDescriptor> filters;

  /** The field. */
  private String field;

  /** The value. */
  private Object value;

  /** The operator. */
  private String operator;

  /** The ignore case. */
  private boolean ignoreCase = true;

  /** The Constructor. */
  public FilterDescriptor() {
    filters = new ArrayList<FilterDescriptor>();
  }

  /**
   * Gets the field.
   *
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Sets the field.
   *
   * @param field the field
   */
  public void setField(String field) {
    this.field = field;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public Object getValue() {
    return value;
  }

  /**
   * Sets the value.
   *
   * @param value the value
   */
  public void setValue(Object value) {
    this.value = value;
  }

  /**
   * Gets the operator.
   *
   * @return the operator
   */
  public String getOperator() {
    return operator;
  }

  /**
   * Sets the operator.
   *
   * @param operator the operator
   */
  public void setOperator(String operator) {
    this.operator = operator;
  }

  /**
   * Gets the logic.
   *
   * @return the logic
   */
  public String getLogic() {
    return logic;
  }

  /**
   * Sets the logic.
   *
   * @param logic the logic
   */
  public void setLogic(String logic) {
    this.logic = logic;
  }

  /**
   * Checks if is ignore case.
   *
   * @return true, if checks if is ignore case
   */
  public boolean isIgnoreCase() {
    return ignoreCase;
  }

  /**
   * Sets the ignore case.
   *
   * @param ignoreCase the ignore case
   */
  public void setIgnoreCase(boolean ignoreCase) {
    this.ignoreCase = ignoreCase;
  }

  /**
   * Gets the filters.
   *
   * @return the filters
   */
  public List<FilterDescriptor> getFilters() {
    return filters;
  }

  /**
   * And.
   *
   * @param field the field
   * @param operatorEnum the operator enum
   * @param value the value
   * @return the filter descriptor
   */
  public FilterDescriptor and(String field, FilterOperatorEnum operatorEnum, Object value) {
    FilterDescriptor fieldFilter = new FilterDescriptor();
    fieldFilter.setLogic(LOGIC_AND);
    fieldFilter.setField(field);
    fieldFilter.setOperator(operatorEnum.getValue());
    fieldFilter.setValue(value);
    this.getFilters().add(fieldFilter);
    return this;
  }

  /**
   * 是否设置了某个过滤条件.
   *
   * @param field
   * @return
   */
  public boolean hasFilterField(String field) {
    for (FilterDescriptor fd : this.getFilters()) {
      if (fd.getField().equals(field)) {
        return true;
      }
    }
    return false;
  }
}
