/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class PatternUtilsTest {

  @Test
  public void findIPV4() {
    Pattern p = Pattern.compile(RegExUtils.REGEX_IPV4_ADDRESS_MULTIPLE);
    String input = "192.168.1.1 192.168.1.2";
    DataResultSupport<List<String>> find = PatternUtils.find(input, p);
    assertTrue(find.isSuccess());
    List<String> items = find.getData();
    assertEquals("192.168.1.1", items.get(0));
    assertEquals("192.168.1.2", items.get(1));
  }

  @Test
  public void findDomain() {
    Pattern p = Pattern.compile(RegExUtils.REGEX_DOMAIN_MULTIPLE);
    String input = "google.com github.com phx-a18.vpn.wlvpn.com";
    DataResultSupport<List<String>> find = PatternUtils.find(input, p);
    assertTrue(find.isSuccess());
    List<String> items = find.getData();
    assertEquals("google.com", items.get(0));
    assertEquals("github.com", items.get(1));
    assertEquals("phx-a18.vpn.wlvpn.com", items.get(2));
  }
}
