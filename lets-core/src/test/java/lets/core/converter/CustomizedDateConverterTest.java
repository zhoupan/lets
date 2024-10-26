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
package lets.core.converter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import jodd.datetime.JDateTime;
import lets.core.DateUtils;
import org.junit.jupiter.api.Test;

public class CustomizedDateConverterTest {

  @Test
  public void testCustomizedDateConverter() {
    CustomizedDateConverter.INSTANCE.register();
    this.check("2021-01-01", "yyyy-MM-dd", new JDateTime().set(2021, 1, 1).convertToDate());
    this.check(
        "2021-01-01 18:45",
        "yyyy-MM-dd HH:mm",
        new JDateTime().set(2021, 1, 1).setTime(18, 45, 0, 0).convertToDate());
    this.check(
        "2021-01-01 18:45:15",
        "yyyy-MM-dd HH:mm:ss",
        new JDateTime().set(2021, 1, 1).setTime(18, 45, 15, 0).convertToDate());
    Date sourceDate = CustomizedDateConverter.INSTANCE.convert("");
    assertNull(sourceDate);
  }

  public void check(String source, String format, Date targetDate) {
    try {
      Date sourceDate = DateUtils.parseDate(source, format);
      assertEquals(sourceDate, targetDate);
    } catch (RuntimeException e) {
      fail(e.getMessage());
    }
    Date sourceDate = CustomizedDateConverter.INSTANCE.convert(source);
    assertEquals(sourceDate, targetDate);
  }
}
