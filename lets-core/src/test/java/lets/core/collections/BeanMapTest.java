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
package lets.core.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.jupiter.api.Test;

/**
 * BeanMapTest.
 *
 * @author zhoupan
 */
public class BeanMapTest {

  /** The Class Bean. */
  public static final class Bean {

    /** The id. */
    public Long id;

    /** The code. */
    public String code;

    /** The date. */
    public Date date;
  }

  /** Work when no getter and setter. */
  @Test
  public void workWhenNoGetterAndSetter() {
    Bean bean = new Bean();
    bean.id = 1L;
    bean.code = "bean1";
    bean.date = new Date();
    BeanMap beanMap = new BeanMap(bean);
    // no getter
    assertEquals(bean.id, beanMap.get("id"));
    assertEquals(bean.code, beanMap.get("code"));
    assertEquals(bean.date, beanMap.get("date"));
    // no setter
    beanMap.put("id", 2L);
    beanMap.put("code", "bean2");
    assertEquals(bean.id, new Long(2L));
    assertEquals(bean.code, "bean2");
  }
}
