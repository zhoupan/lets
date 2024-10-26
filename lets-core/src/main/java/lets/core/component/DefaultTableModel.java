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
import lets.core.component.DefaultColumn.DefaultColumnBuilder;

public class DefaultTableModel implements TableModel {

  protected DefaultColumns columns = new DefaultColumns();
  protected Vector<Vector<Object>> rows = new Vector<Vector<Object>>();

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

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return this.rows.get(rowIndex).get(columnIndex);
  }

  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    this.rows.get(rowIndex).set(columnIndex, aValue);
  }

  public DefaultTableModel column(DefaultColumnBuilder columnBuilder) {
    DefaultColumn column = columnBuilder.build();
    if (columnBuilder.indexSetted) {
      this.columns.items.add(column.getIndex(), column);
    } else {
      column.setIndex(this.columns.items.size());
      this.columns.items.add(column);
    }
    return this;
  }

  public DefaultTableModel row(Map<String, Object> map) {
    Vector<Object> row = new Vector<Object>();
    for (int i = 0; i < this.getColumnCount(); i++) {
      String name = this.getColumnName(i);
      row.add(map.getOrDefault(name, null));
    }
    this.rows.add(row);
    return this;
  }

  public DefaultTableModel row(Object... args) {
    Vector<Object> row = new Vector<Object>();
    for (int i = 0; i < this.getColumnCount(); i++) {
      if (args != null && i < args.length) {
        row.add(args[i]);
      } else {
        row.add(null);
      }
    }
    this.rows.add(row);
    return this;
  }
}
