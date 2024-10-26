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

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** RegExUtilsTest. */
public class RegExUtilsTest {

  /** Test is IPv4 address. */
  @Test
  public void testIsIPv4Address() {
    assertTrue(RegExUtils.isIpv4Address("192.168.1.1"));
    assertFalse(RegExUtils.isIpv4Address("192.168.1.a"));
    assertFalse(RegExUtils.isIpv4Address("19216811"));
  }
  @Test
  public void testSearch(){
    Matcher m = Pattern.compile(RegExUtils.REGEX_IPV4_ADDRESS).matcher("192.168.1.1 192.168.1.2");
    while(m.find()){
      String ip= m.group();
      System.out.println(ip);
    }
  }
}
