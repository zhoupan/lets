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
package lets.core.os;

import lets.core.os.bsd.BSDOperatingSystem;
import lets.core.os.bsd.Flavor;
import lets.core.os.bsd.FlavorDetector;
import lets.core.os.linux.DistroDetector;
import lets.core.os.linux.LinuxDetector;
import lets.core.os.linux.LinuxOperatingSystem;
import lets.core.os.macos.MacOSDetector;
import lets.core.os.macos.MacOSOperatingSystem;
import lets.core.os.solaris.SolarisDetector;
import lets.core.os.solaris.SolarisOperatingSystem;
import lets.core.os.windows.WindowsDetector;
import lets.core.os.windows.WindowsOperatingSystem;

public enum OperatingSystem {
  WINDOWS("Windows", "win"),
  MACOS("macOS", "mac"),
  LINUX("Linux", "linux"),
  SOLARIS("Solaris", "solaris", "sunos"),
  BSD("BSD"),
  UNKNOWN("unknown", "unknown");

  private static AbstractOperatingSystem cache;

  private final String name;
  private final String[] search;

  OperatingSystem(String name, String... search) {
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

  /** Gets the operating system (Not linux distro) */
  public static OperatingSystem getOperatingSystem(String str) {
    str = str.toLowerCase();

    OperatingSystem os = null;

    for (OperatingSystem o : OperatingSystem.values()) {
      if (os != null) {
        break;
      }

      if (o.getName().equalsIgnoreCase(str)) {
        os = o;
        break;
      }

      for (String s : o.getSearch()) {
        if (str.contains(s)) {
          os = o;
          break;
        }
      }
    }

    return os;
  }

  public static AbstractOperatingSystem getOperatingSystem() {
    return getOperatingSystem(true);
  }

  /** Gets this machines operating system */
  public static AbstractOperatingSystem getOperatingSystem(boolean b) {
    AbstractOperatingSystem os = null;

    if (cache == null) {
      Flavor flavor = FlavorDetector.detect(b);

      if (flavor != null) {
        os = new BSDOperatingSystem(flavor);
      }

      if (LinuxDetector.detect(b)) {
        os = new LinuxOperatingSystem(DistroDetector.detect());
      }

      if (MacOSDetector.detect(b)) {
        os = new MacOSOperatingSystem();
      }

      if (WindowsDetector.detect(b)) {
        os = new WindowsOperatingSystem();
      }

      if (SolarisDetector.detect(b)) {
        os = new SolarisOperatingSystem();
      }

      if (os == null) {
        os = new UnknownOperatingSystem();
      }

      if (os instanceof UnixOperatingSystem) {
        UnixOperatingSystem uos = (UnixOperatingSystem) os;
        uos.setDetailed(Utils.getUname());
      }
      cache = os;
    } else {
      os = cache;
    }

    return os;
  }

  /** Forces reloading of data next time retreiving operating system */
  public static void clearCache() {
    cache = null;
  }

  public static boolean isUnix() {
    return isUnix(getOperatingSystem().getType());
  }

  public static boolean isUnix(OperatingSystem os) {
    return os == BSD || os == MACOS || os == LINUX || os == SOLARIS;
  }
}
