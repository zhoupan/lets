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

public interface TableModel {
  /**
   * Returns the number of rows in the model. A <code>Table</code> uses this method to determine how
   * many rows it should display. This method should be quick, as it is called frequently during
   * rendering.
   *
   * @return the number of rows in the model
   * @see #getColumnCount
   */
  public int getRowCount();

  /**
   * Returns the number of columns in the model. A <code>Table</code> uses this method to determine
   * how many columns it should create and display by default.
   *
   * @return the number of columns in the model
   * @see #getRowCount
   */
  public int getColumnCount();

  /**
   * Returns the name of the column at <code>columnIndex</code>. This is used to initialize the
   * table's column header name. Note: this name does not need to be unique; two columns in a table
   * can have the same name.
   *
   * @param columnIndex the index of the column
   * @return the name of the column
   */
  public String getColumnName(int columnIndex);

  /**
   * Returns the most specific superclass for all the cell values in the column. This is used by the
   * <code>Table</code> to set up a default renderer and editor for the column.
   *
   * @param columnIndex the index of the column
   * @return the common ancestor class of the object values in the model.
   */
  public Class<?> getColumnClass(int columnIndex);

  /**
   * Returns true if the cell at <code>rowIndex</code> and <code>columnIndex</code> is editable.
   * Otherwise, <code>setValueAt</code> on the cell will not change the value of that cell.
   *
   * @param rowIndex the row whose value to be queried
   * @param columnIndex the column whose value to be queried
   * @return true if the cell is editable
   * @see #setValueAt
   */
  public boolean isCellEditable(int rowIndex, int columnIndex);

  /**
   * Returns the value for the cell at <code>columnIndex</code> and <code>rowIndex</code>.
   *
   * @param rowIndex the row whose value is to be queried
   * @param columnIndex the column whose value is to be queried
   * @return the value Object at the specified cell
   */
  public Object getValueAt(int rowIndex, int columnIndex);

  /**
   * Sets the value in the cell at <code>columnIndex</code> and <code>rowIndex</code> to <code>
   * aValue</code>.
   *
   * @param aValue the new value
   * @param rowIndex the row whose value is to be changed
   * @param columnIndex the column whose value is to be changed
   * @see #getValueAt
   * @see #isCellEditable
   */
  public void setValueAt(Object aValue, int rowIndex, int columnIndex);
}
