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
package lets.core.os.macos;

import lets.core.os.VersionCompare;

public enum MacOSVersion implements VersionCompare {
  CHEETAH("Cheetah", "10.0", true),
  PUMA("Puma", "10.1", true),
  JAGUAR("Jaguar", "10.2", true),
  PANTHER("Panther", "10.3", true),
  TIGER("Tiger", "10.4", true),
  LEOPARD("Leopard", "10.5", true),
  SNOW_LEOPARD("Snow Leopard", "10.6", true),
  LION("Lion", "10.7", true),
  MOUNTAIN_LION("Mountain Lion", "10.8", true),
  MAVERICKS("Mavericks", "10.9", true),
  YOSEMITE("Yosemite", "10.10", true),
  EL_CAPITAN("El Capitan", "10.11", true),
  SIERRA("Sierra", "10.12"),
  HIGH_SIERRA("High Sierra", "10.13", true),
  MOJAVE("Mojave", "10.14", true);

  private final String search;
  private final String version;
  private final boolean isX;

  MacOSVersion(String search, String version) {
    this(search, version, false);
  }

  MacOSVersion(String search, String version, boolean isX) {
    this.search = search;
    this.version = version;
    this.isX = isX;
  }

  /** Returns codename, such as Yosemite */
  public String getDisplay() {
    return search;
  }

  /** Version of OS X, such as 10.10 */
  public String getVersion() {
    return version;
  }

  /**
   * Indicates if this is Mac OS X or the newer macOS
   *
   * @return if Mac OS X (<= 10.11)
   */
  public boolean isOSX() {
    return this.isX;
  }

  /** Gets MacOSVersion for this machine */
  public static MacOSVersion getFromString() {
    return getFromString(System.getProperty("os.version"));
  }

  /** Gets MacOSVersion from string Will detect "10.11.*" if parameter search is is "10.11" */
  public static MacOSVersion getFromString(String search) {
    // check for one with exact match
    MacOSVersion exactRes = getExactFromVersion(search);
    if (exactRes != null) {
      return exactRes;
    }

    for (MacOSVersion v : MacOSVersion.values()) {
      if (search.startsWith(v.getVersion())
          || v.getDisplay().toLowerCase().contains(search.toLowerCase())) {
        return v;
      }
    }

    return null;
  }

  /**
   * Gets MacOSVersion by doing an exact match on major and minor version. if parameter search is
   * "10.14.5", look for "10.14", considering MacOS history of version numbers
   */
  public static MacOSVersion getExactFromVersion(String search) {
    String[] versionSplit = search.split("\\.");
    if (versionSplit.length >= 2) {
      versionSplit = new String[] {versionSplit[0], versionSplit[1]};
    }
    String majorMinorVersion = String.join(".", versionSplit);
    for (MacOSVersion v : MacOSVersion.values()) {
      if (v.getVersion().equals(majorMinorVersion)) {
        return v;
      }
    }

    return null;
  }

  public static MacOSVersion getExact(String display, String version) {
    for (MacOSVersion v : MacOSVersion.values()) {
      if (v.getDisplay().equals(display) && v.getVersion().equals(version)) {
        return v;
      }
    }

    return null;
  }

  @Override
  public boolean isNewer(Enum<?> e) {
    return e.ordinal() > this.ordinal();
  }

  @Override
  public boolean isOlder(Enum<?> e) {
    return e.ordinal() < this.ordinal();
  }
}
