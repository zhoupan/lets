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

public enum Arch {
  x86("x86", "i386", "i486", "i586", "i686"),
  x86_64("x86_64", "amd64", "k8"),
  ARM("ARM", "arm64"),
  UNKNOWN("Unknown");

  private final String[] search;

  Arch(String... search) {
    this.search = search;
  }

  public String getName() {
    return search[0];
  }

  public String[] getSearch() {
    return search;
  }

  /** Gets arch, either 64-bit or x86 */
  public static Arch getArch(String s) {
    for (Arch arch : Arch.values()) {
      for (String search : arch.getSearch()) {
        if (s.equalsIgnoreCase(search)) {
          return arch;
        }
      }
    }

    return Arch.UNKNOWN;
  }

  /** Gets this machines arch */
  public static Arch getArch() {
    return getArch(getArchString());
  }

  /** Same as System.getProperty("os.arch"); */
  public static String getArchString() {
    return System.getProperty("os.arch");
  }
}
