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
package lets.core.formatter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

public class MessageFormatterTest {

  @Test
  public void testMessageFormatter() {
    FormattingTuple f1 = MessageFormatter.format("Hello {}", 1);
    assertEquals("Hello 1", f1.getMessage());
    assertArrayEquals(new Object[] {1}, f1.getArgArray());
    assertNull(f1.getThrowable());
    try {
      throw new IOException("IOException");
    } catch (Throwable e) {
      FormattingTuple f1e = MessageFormatter.format("Hello {} Exception:{}", 1, e);
      assertArrayEquals(new Object[] {1}, f1e.getArgArray());
      assertEquals(e, f1e.getThrowable());
    }
  }
}
