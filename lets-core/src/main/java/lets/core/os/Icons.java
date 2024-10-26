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

import java.io.File;
import java.net.MalformedURLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import lets.core.os.bsd.BSDOperatingSystem;
import lets.core.os.bsd.Flavor;
import lets.core.os.linux.Distro;
import lets.core.os.linux.LinuxOperatingSystem;
import lets.core.os.windows.WindowsOperatingSystem;
import lets.core.os.windows.WindowsVersion;

public class Icons {

  public static Icon getIcon() {
    return getIcon(OperatingSystem.getOperatingSystem());
  }

  @SuppressWarnings("deprecation")
  public static Icon getIcon(AbstractOperatingSystem os) {
    String icon = getIconString(os);

    try {
      return new ImageIcon(new File("icons/" + icon + ".png").toURL());
    } catch (MalformedURLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String getIconString() {
    return getIconString(OperatingSystem.getOperatingSystem());
  }

  public static String getIconString(AbstractOperatingSystem os) {
    String icon;

    if (os == null || os.getType() == OperatingSystem.UNKNOWN) {
      icon = "os_unknown";
    } else if (os.getType() == OperatingSystem.WINDOWS) {
      WindowsOperatingSystem wos = (WindowsOperatingSystem) os;
      if (wos.getVersion() == WindowsVersion.WIN8
          || wos.getVersion() == WindowsVersion.WIN81
          || wos.getVersion() == WindowsVersion.WIN10
          || wos.getVersion() == WindowsVersion.WINSERVER2012) {
        icon = "os_win8";
      } else if (wos.getVersion() == WindowsVersion.WINXP) {
        icon = "os_winxp";
      } else if (wos.getVersion().getSearch().startsWith("Windows 200")) {
        icon = "os_win2000";
      } else {
        icon = "os_win";
      }
    } else if (os.getType() == OperatingSystem.LINUX) {
      LinuxOperatingSystem los = (LinuxOperatingSystem) os;
      Distro d = los.getDistro();
      if (d == null || d == Distro.UNKNOWN) {
        icon = "os_linux";
      } else {
        icon = "dist_" + d.getName().toLowerCase().replace(" ", "").replace("linux", "");
      }
    } else if (os.getType() == OperatingSystem.BSD) {
      BSDOperatingSystem bos = (BSDOperatingSystem) os;

      if (bos.getFlavor() == Flavor.UNKNOWN || bos.getFlavor() == null) {
        icon = "bsd_unknown";
      } else {
        icon = "bsd_" + bos.getFlavor().getName().toLowerCase().replace(" ", "");
      }
    } else {
      icon = "os_" + os.getType().getName().toLowerCase().replace(" ", "");
    }

    return icon;
  }
}
