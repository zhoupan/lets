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
package lets.core.collections.comparators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * ComparatorChainTest.
 *
 * @author zhoupan
 */
public class ComparatorChainTest {

  /** The Class Person. */
  public static final class Person implements Comparable<Person> {

    /**
     * Items.
     *
     * @return the list
     */
    public static List<Person> fakeItems() {
      Person p1 = new Person(3, "Andy", 41);
      Person p2 = new Person(2, "Belly", 21);
      Person p3 = new Person(1, "Jim", 11);
      List<Person> items = new ArrayList<Person>();
      items.add(p1);
      items.add(p2);
      items.add(p3);
      return items;
    }

    /** The id. */
    public int id;

    /** The name. */
    public String name;

    /** The age. */
    public int age;

    /**
     * Instantiates a new person.
     *
     * @param id the id
     * @param name the name
     * @param age the age
     */
    public Person(int id, String name, int age) {
      super();
      this.id = id;
      this.name = name;
      this.age = age;
    }

    /**
     * Compare to.
     *
     * @param o the o
     * @return the int
     */
    @Override
    public int compareTo(Person o) {
      return Integer.compare(this.id, o.id);
    }
  }

  /** Test comparator chain. */
  @SuppressWarnings("unchecked")
  @Test
  public void testComparatorChain() {
    //    Person p1 = new Person(3, "Andy", 41);
    //    Person p2 = new Person(2, "Belly", 21);
    //    Person p3 = new Person(1, "Jim", 11);
    List<Person> items = Person.fakeItems();
    // 默认排序(实现Comparable接口) order by id asc
    Collections.sort(items);
    assertEquals(items.get(0).id, 1);
    assertEquals(items.get(1).id, 2);
    assertEquals(items.get(2).id, 3);
    // order by id asc.
    items = Person.fakeItems();
    ComparatorChain chain = new ComparatorChain(ComparableComparator.getInstance());
    Collections.sort(items, chain);
    assertEquals(items.get(0).id, 1);
    assertEquals(items.get(1).id, 2);
    assertEquals(items.get(2).id, 3);
    // order by id desc.
    chain = new ComparatorChain(ComparableComparator.getInstance(), true);
    Collections.sort(items, chain);
    assertEquals(items.get(0).id, 3);
    assertEquals(items.get(1).id, 2);
    assertEquals(items.get(2).id, 1);
  }
}
