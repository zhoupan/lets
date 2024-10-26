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

import java.io.File;
import java.util.List;
import lets.core.os.OperatingSystem;
import lets.core.os.Utils;

public class MacOSDetector {

  public static boolean detect(boolean fallback) {
    File file = new File("/usr/bin/sw_vers");

    try {
      List<String> lines = Utils.readFile(file);

      for (String line : lines) {
        if (line.contains(OperatingSystem.MACOS.getName())) {
          return true;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (fallback) {
      String os = System.getProperty("os.name").toLowerCase();

      return os.contains("mac os x") || os.contains("macos");
    }

    return false;
  }
}
