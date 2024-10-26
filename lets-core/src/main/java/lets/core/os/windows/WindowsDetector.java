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

import lets.core.os.Arch;
import lets.core.os.OperatingSystem;

public class WindowsDetector {

  public static boolean detect(boolean fallback) {
    if (fallback) {
      return System.getProperty("os.name")
          .toLowerCase()
          .contains(OperatingSystem.WINDOWS.getPrimarySearch());
    }

    return false;
  }

  public static Arch getArchWindows() {
    if (System.getenv("ProgramFiles(x86)") != null) {
      return Arch.x86_64;
    }

    return Arch.getArch(System.getProperty("os.arch"));
  }
}
