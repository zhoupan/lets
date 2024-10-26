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
package lets.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;
import lets.core.concurrent.ThreadUtils;
import lets.core.event.OnChangeListener;
import org.junit.jupiter.api.Test;

public class MutableDelayValueTest implements OnChangeListener<Integer> {

  @Test
  public void testMutableDelayValue() {
    MutableDelayValue<Integer> value =
        new MutableDelayValue<Integer>().withDelay(TimeUnit.SECONDS, 2);
    value.addOnChangeListener(this);
    // 设置值
    value.set(1);
    assertEquals(value.get().intValue(), 1);
    // 设置值;但延时设置成2s;新的值不会生效
    value.set(2);
    assertEquals(value.get().intValue(), 1);
    value.set(3);
    assertEquals(value.get().intValue(), 1);
    // 延时超时;新的值生效：4
    ThreadUtils.sleep(value.timeUnit.get(), value.duration.get());
    value.set(4);
    assertEquals(value.get().intValue(), 4);
    // 设置值;但延时设置成2s;新的值不会生效
    value.set(5);
    assertEquals(value.get().intValue(), 4);
    value.duration.set(10);
    value.set(6);
    value.set(7);
    value.set(8);
    ThreadUtils.sleep(value.timeUnit.get(), value.duration.get());
    value.set(10);
    assertEquals(value.get().intValue(), 10);
  }

  @Override
  public void onChange(Integer from, Integer to) {
    LoggerSupport.info("onChange:from={} to:{}", from, to);
  }
}
