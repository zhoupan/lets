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

public enum DesktopEnvironment {
  GNOME("GNOME"),
  BUDGIE("Budgie"),
  ENLIGHTEMENT("Enlightement"),
  KDE("KDE"),
  KDE4("KDE4"),
  KDE5("KDE5"),
  MATE("Mate"),
  UNITY("Unity"),
  CINNAMON("Cinnamon"),
  LUMINA("Lumina"),
  AQUA("Aqua"),
  AERO("Aero"),
  LUNA("Luna"),
  LXDE("LXDE"),
  XFCE("XFCE"),
  UNKNOWN("Unknown");

  private final String search;
  private String version;

  DesktopEnvironment(String search) {
    this.search = search;
  }

  public String getSearch() {
    return search;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getDisplayString() {
    String name = search;

    if (version != null) {
      name += " " + version;
    }

    return name;
  }

  public static DesktopEnvironment getFromString(String s) {
    for (DesktopEnvironment de : DesktopEnvironment.values()) {
      if (de.getSearch().equalsIgnoreCase(s)) {
        return de;
      }
    }

    return UNKNOWN;
  }
}
