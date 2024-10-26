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

import java.util.Map;
import java.util.Vector;
import jodd.bean.BeanUtilBean;
import jodd.util.ClassUtil;
import lets.core.CoreUtils;
import lets.core.component.DefaultColumn.DefaultColumnBuilder;

public class BeanTableModel<Bean> implements TableModel {

  public final DefaultColumns columns = new DefaultColumns();
  public Vector<Bean> rows = new Vector<Bean>();
  public DataType beanClass = new DataType();

  public BeanTableModel() {
    super();
    this.beanClass.fromClass(CoreUtils.getSuperClassGenericType(this.getClass()));
  }

  public BeanTableModel<Bean> beanClass(Class<?> beanClass) {
    this.beanClass.fromClass(beanClass);
    return this;
  }

  @Override
  public int getRowCount() {
    return this.rows.size();
  }

  @Override
  public int getColumnCount() {
    return this.columns.getColumnCount();
  }

  @Override
  public String getColumnName(int columnIndex) {
    return this.columns.getColumnName(columnIndex);
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return this.columns.getColumnClass(columnIndex);
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    if (this.columns.getColumn(columnIndex).isEditable()) {
      return true;
    }
    return false;
  }

  public Bean getRow(int rowIndex) {
    return this.rows.get(rowIndex);
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Bean bean = this.rows.get(rowIndex);
    String name = this.getColumnName(columnIndex);
    return BeanUtilBean.pojo.getProperty(bean, name);
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Bean bean = this.rows.get(rowIndex);
    String name = this.getColumnName(columnIndex);
    BeanUtilBean.pojo.setProperty(bean, name, aValue);
  }

  public void setValutAtByColumnName(int rowIndex, String columnName, Object aValue) {
    DefaultColumn column = this.columns.getColumnByName(columnName);
    CoreUtils.checkState(column != null, "列名%s不存在", columnName);
    setValueAt(aValue, rowIndex, column.index);
  }

  public BeanTableModel<Bean> column(DefaultColumnBuilder columnBuilder) {
    DefaultColumn column = columnBuilder.build();
    if (columnBuilder.indexSetted) {
      this.columns.items.add(column.getIndex(), column);
    } else {
      column.setIndex(this.columns.items.size());
      this.columns.items.add(column);
    }
    return this;
  }

  @SuppressWarnings("unchecked")
  public BeanTableModel<Bean> row(Map<String, Object> map)
      throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    Bean bean = (Bean) ClassUtil.newInstance(this.beanClass.asClass());
    for (int i = 0; i < this.getColumnCount(); i++) {
      String name = this.getColumnName(i);
      BeanUtilBean.pojo.setProperty(bean, name, map.getOrDefault(name, null));
    }
    this.rows.add(bean);
    return this;
  }

  @SuppressWarnings("unchecked")
  public BeanTableModel<Bean> row(Object... args)
      throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    Bean bean = (Bean) ClassUtil.newInstance(this.beanClass.asClass());
    for (int i = 0; i < this.getColumnCount(); i++) {
      if (args != null && i < args.length) {
        Object arg = args[i];
        String name = this.getColumnName(i);
        BeanUtilBean.pojo.setProperty(bean, name, arg);
      }
    }
    this.rows.add(bean);
    return this;
  }

  @Override
  public String toString() {
    return "BeanTableModel [columns="
        + columns
        + ", rows="
        + rows
        + ", beanClass="
        + beanClass
        + "]";
  }
}
