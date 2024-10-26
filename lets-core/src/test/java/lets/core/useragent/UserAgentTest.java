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
package lets.core.useragent;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** The Class UserAgentTest. */
public class UserAgentTest {

  /** Test parse user agent windows. */
  @Test
  public void testParseUserAgentWindows() {
    String useragentString =
        "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36";
    UserAgent useragent = UserAgent.parseUserAgentString(useragentString);
    assertTrue(useragent.getOperatingSystem().isWindows());
    assertTrue(useragent.getOperatingSystem().isComputer());
  }

  /** Test parse user agent android. */
  @Test
  public void testParseUserAgentAndroid() {
    String useragentString =
        "Dalvik/2.1.0 (Linux; U; Android 7.0; Android SDK built for x86 Build/NYC)";
    UserAgent useragent = UserAgent.parseUserAgentString(useragentString);
    assertTrue(useragent.getOperatingSystem().isAndroid());
  }

  /** Test parse user agent lower case. */
  @Test
  public void testParseUserAgentLowerCase() {
    String useragentString = "android";
    UserAgent useragent = UserAgent.parseUserAgentString(useragentString);
    assertTrue(useragent.getOperatingSystem().isAndroid());
    useragentString = "windows";
    useragent = UserAgent.parseUserAgentString(useragentString);
    assertTrue(useragent.getOperatingSystem().isWindows());
    useragentString = "linux";
    useragent = UserAgent.parseUserAgentString(useragentString);
    assertTrue(useragent.getOperatingSystem().isLinux());
    useragentString = "ios";
    useragent = UserAgent.parseUserAgentString(useragentString);
    assertTrue(useragent.getOperatingSystem().isiOS());
  }

  /** Test parse user agent. */
  @Test
  public void testParseUserAgent() {
    String useragentString = "Android";
    UserAgent useragent = UserAgent.parseUserAgentString(useragentString);
    assertTrue(useragent.getOperatingSystem().isAndroid());
    useragentString = "Windows";
    useragent = UserAgent.parseUserAgentString(useragentString);
    assertTrue(useragent.getOperatingSystem().isWindows());
    useragentString = "Linux";
    useragent = UserAgent.parseUserAgentString(useragentString);
    assertTrue(useragent.getOperatingSystem().isLinux());
    useragentString = "iOS";
    useragent = UserAgent.parseUserAgentString(useragentString);
    assertTrue(useragent.getOperatingSystem().isiOS());
  }
}
