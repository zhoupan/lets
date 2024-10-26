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

public class DefaultColumn {
  public static final class DefaultColumnBuilder {
    DefaultColumn column = new DefaultColumn();
    public boolean indexSetted;

    public DefaultColumn build() {
      return this.column;
    }

    public DefaultColumnBuilder name(String name) {
      this.column.setName(name);
      return this;
    }

    public DefaultColumnBuilder label(String label) {
      this.column.setLabel(label);
      return this;
    }

    public DefaultColumnBuilder dataType(Class<?> dataType) {
      this.column.dataType.fromClass(dataType);
      return this;
    }

    public DefaultColumnBuilder editable(boolean editable) {
      this.column.setEditable(editable);
      return this;
    }

    public DefaultColumnBuilder index(int index) {
      this.column.setIndex(index);
      this.indexSetted = true;
      return this;
    }

    public DefaultColumnBuilder visiable(boolean visiable) {
      this.column.visiable = visiable;
      return this;
    }
  }

  protected String name;
  protected String label;
  protected DataType dataType = new DataType();
  protected int index;
  protected boolean editable;
  protected boolean visiable;
  public int width;
  public int height;
  public float weight;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DataType getDataType() {
    return dataType;
  }

  public void setDataType(DataType dataType) {
    this.dataType = dataType;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public boolean isEditable() {
    return editable;
  }

  public void setEditable(boolean editable) {
    this.editable = editable;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public boolean isVisiable() {
    return visiable;
  }

  public void setVisiable(boolean visiable) {
    this.visiable = visiable;
  }

  @Override
  public String toString() {
    return "DefaultColumn [index="
        + index
        + ", name="
        + name
        + ", label="
        + label
        + ", dataType="
        + dataType
        + ", editable="
        + editable
        + ", visiable="
        + visiable
        + "]";
  }
}
