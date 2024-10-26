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

import java.util.Vector;
import lets.core.ArrayUtils;
import lets.core.StringUtils;

public class DefaultColumns {
  public final Vector<DefaultColumn> items = new Vector<DefaultColumn>();

  public Vector<DefaultColumn> getItems() {
    return items;
  }

  public int getColumnCount() {
    return this.items.size();
  }

  public DefaultColumn getColumn(int columnIndex) {
    return this.items.get(columnIndex);
  }

  public String getColumnName(int columnIndex) {
    return this.items.get(columnIndex).getName();
  }

  public DefaultColumn getColumnByName(String name) {
    for (DefaultColumn item : items) {
      if (StringUtils.equals(item.getName(), name)) {
        return item;
      }
    }
    return null;
  }

  public String getColumnLabel(int columnIndex) {
    return this.items.get(columnIndex).getLabel();
  }

  public Class<?> getColumnClass(int columnIndex) {
    try {
      return this.items.get(columnIndex).getDataType().asClass();
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String toString() {
    return "DefaultColumns [items=" + items + "]";
  }

  public DefaultColumns showColumns(boolean visiable, String... names) {
    for (DefaultColumn column : this.items) {
      if (ArrayUtils.contains(names, column.name)) {
        column.visiable = visiable;
      }
    }
    return this;
  }

  public DefaultColumns editColumns(boolean edit, String... names) {
    for (DefaultColumn column : this.items) {
      if (ArrayUtils.contains(names, column.name)) {
        column.editable = edit;
      }
    }
    return this;
  }
}
