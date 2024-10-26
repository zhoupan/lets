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
package lets.core.os.windows;

import lets.core.os.VersionCompare;

public enum WindowsVersion implements VersionCompare {
  UNKNOWN("Unknown Windows"),
  WIN2000("Windows 2000"),
  WINXP("Windows XP"),
  WINSERVER2003(
      "Windows 2003"), // Note that Windows Server 2003 identifies itself only as Windows 2003
  WINVISTA("Windows Vista"),
  WINSERVER2008("Windows Server 2008"),
  WIN7("Windows 7"),
  WIN81("Windows 8.1"),
  WIN8("Windows 8"),
  WINSERVER2012("Windows Server 2012"),
  WIN10("Windows 10");

  private final String search;

  WindowsVersion(String search) {
    this.search = search;
  }

  public String getSearch() {
    return search;
  }

  /** Returns WindowsVersion for current machine */
  public static WindowsVersion getFromString() {
    return getFromString(System.getProperty("os.name"));
  }

  /**
   * @param search Can only be strings like "windows 8", not version number
   * @return WindowsVersion from string
   */
  public static WindowsVersion getFromString(String search) {
    for (WindowsVersion v : WindowsVersion.values()) {
      if (v != UNKNOWN && v.getSearch().equalsIgnoreCase(search)) {
        return v;
      }
    }

    return UNKNOWN;
  }

  @Override
  public boolean isNewer(Enum<?> e) {
    return this.ordinal() > e.ordinal();
  }

  @Override
  public boolean isOlder(Enum<?> e) {
    return this.ordinal() < e.ordinal();
  }
}
