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
package lets.core.version;

import static org.junit.jupiter.api.Assertions.*;

import lets.core.CoreUtils;
import org.junit.jupiter.api.Test;

/** The Class VersionSupportTest. */
public class VersionSupportTest {

  /** Test parse. */
  @Test
  public void testParse() {
    VersionSupport v1 = VersionSupport.parse("1.0.20210716");
    assertEquals(1, v1.getMajor());
    assertEquals(0, v1.getMinor());
    assertEquals(20210716, v1.getMicro());
    assertNull(v1.getQualifier());
    VersionSupport v2 = VersionSupport.parse("1.0.20210716");
    assertEquals(v1, v2);
    VersionSupport v3 = VersionSupport.parse("1.1.20210716");
    CoreUtils.checkState(v3.compareTo(v2) > 0, "%s>%s", v3, v2);
    assertEquals("1.0", v1.getAsStringMajorMinor());
    assertEquals("1.0.20210716", v1.getAsStringMajorMinorMicro());
    assertEquals("1.0.20210716", v1.getAsString());
  }

  /** Test parse. */
  @Test
  public void testParseWithQualifier() {
    VersionSupport v1 = VersionSupport.parse("1.0.20210716-SNAPSHOP");
    assertEquals(1, v1.getMajor());
    assertEquals(0, v1.getMinor());
    assertEquals(20210716, v1.getMicro());
    assertEquals("SNAPSHOP", v1.getQualifier());
    VersionSupport v2 = VersionSupport.parse("1.0.20210716-SNAPSHOP");
    assertEquals(v1, v2);
    VersionSupport v3 = VersionSupport.parse("1.1.20210716-SNAPSHOP");
    CoreUtils.checkState(v3.compareTo(v2) > 0, "%s>%s", v3, v2);
    assertEquals("1.0", v1.getAsStringMajorMinor());
    assertEquals("1.0.20210716", v1.getAsStringMajorMinorMicro());
    assertEquals("1.0.20210716-SNAPSHOP", v1.getAsString());
    assertEquals("1.0.20210716.SNAPSHOP", v1.getAsString(true, "."));
  }
}
