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

import static org.junit.jupiter.api.Assertions.*;

import lets.core.component.DefaultColumn.DefaultColumnBuilder;
import org.junit.jupiter.api.Test;

public class TableModelTest {

  public static final class BeanFull {

    private int order;

    private String name;

    public int getOrder() {
      return order;
    }

    public void setOrder(int order) {
      this.order = order;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "BeanFull [order=" + order + ", name=" + name + "]";
    }
  }

  public static final class BeanSimple {

    public int order;

    public String name;

    @Override
    public String toString() {
      return "BeanSimple [order=" + order + ", name=" + name + "]";
    }
  }

  public void testTableModel() {
    DefaultTableModel table = new DefaultTableModel();
    table.column(new DefaultColumnBuilder().name("order").label("序号").dataType(Integer.class));
    table.column(new DefaultColumnBuilder().name("name").label("名称").dataType(String.class));
    for (int i = 0; i < 4; i++) {
      table.row((i + 1), String.format("%s%s", "名称", (i + 1)));
    }
    System.out.println(FlipTableConverters.fromTableModel(table));
  }

  @Test
  public void testBeanTableFull()
      throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    BeanTableModel<BeanFull> table = new BeanTableModel<BeanFull>().beanClass(BeanFull.class);
    table.column(new DefaultColumnBuilder().name("order").label("序号").dataType(Integer.class));
    table.column(new DefaultColumnBuilder().name("name").label("名称").dataType(String.class));
    for (int i = 0; i < 4; i++) {
      table.row((i + 1), String.format("%s%s", "名称", (i + 1)));
    }
    System.out.println(FlipTableConverters.fromTableModel(table));
    System.out.println(table);
  }

  @Test
  public void testBeanTableSimple()
      throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    BeanTableModel<BeanSimple> table = new BeanTableModel<BeanSimple>().beanClass(BeanSimple.class);
    table.column(new DefaultColumnBuilder().name("order").label("序号").dataType(Integer.class));
    table.column(new DefaultColumnBuilder().name("name").label("名称").dataType(String.class));
    for (int i = 0; i < 4; i++) {
      table.row((i + 1), String.format("%s%s", "名称", (i + 1)));
    }
    System.out.println(FlipTableConverters.fromTableModel(table));
    System.out.println(table);
  }
}
