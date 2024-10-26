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

import java.util.concurrent.atomic.AtomicLong;
import lets.core.DefaultMutableKeyValue.KeyValue;
import lets.core.event.OnChangedListener;
import org.junit.jupiter.api.Test;

/** The Class DefaultMutableKeyValueTest. */
public class DefaultMutableKeyValueTest {

  /** Test add on changed listener. */
  @Test
  public void testAddOnChangedListener() {
    DefaultMutableKeyValue<Byte, Boolean> switchStates =
        new DefaultMutableKeyValue<Byte, Boolean>();
    AtomicLong switchOnTimes = new AtomicLong(0);
    AtomicLong switchOffTimes = new AtomicLong(0);
    switchStates.addOnChangedListener(
        new OnChangedListener<KeyValue<Byte, Boolean>>() {

          @Override
          public void onChanged(KeyValue<Byte, Boolean> t) {
            byte i = t.getKey();
            boolean state = t.getValue();
            LoggerSupport.info("onChaged:{}", t);
            LoggerSupport.info("开关{}: {}", i, state ? "打开" : "关闭");
            if (state) {
              switchOnTimes.incrementAndGet();
            } else {
              switchOffTimes.incrementAndGet();
            }
          }
        });
    // 打开开关
    for (int i = 1; i < 10; i++) {
      switchStates.setValue((byte) 1, true);
      assertEquals(1, switchOnTimes.get());
    }
    // 关闭开关
    for (int i = 1; i < 10; i++) {
      switchStates.setValue((byte) 1, false);
      assertEquals(1, switchOffTimes.get());
    }
  }
}
