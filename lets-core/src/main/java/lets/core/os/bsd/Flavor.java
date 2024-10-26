/*
 * Copyright (c) 2022 zhoupan (https://github.com/zhoupan).
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
package lets.core.os.bsd;

import lets.core.os.UnsupportedOperatingSystemException;

public enum Flavor {
  FREEBS("FreeBSD"),
  OPENBSD("OpenBSD"),
  NETBSD("NetBSD"),
  DRAGONFLYBSD("DragonFlyBSD", "DragonFly"),
  UNKNOWN("Unknown BSD", "BSD");

  private final String name;
  private final String[] search;

  Flavor(String name, String... search) {
    this.name = name;
    this.search = search;
  }

  public String getName() {
    return this.name;
  }

  public String[] getSearch() {
    return this.search;
  }

  public String getPrimarySearch() {
    return this.search[0];
  }

  public static Flavor getFlavorFromString(String s) {
    for (Flavor d : values()) {
      if (d.getName().toLowerCase().contains(s.toLowerCase())) {
        return d;
      }

      for (String search : d.getSearch()) {
        if (search.toLowerCase().contains(s.toLowerCase())) {
          return d;
        }
      }
    }

    return null;
  }

  public static Flavor getLocalFlavor() throws UnsupportedOperatingSystemException {
    return FlavorDetector.detect(true);
  }
}
