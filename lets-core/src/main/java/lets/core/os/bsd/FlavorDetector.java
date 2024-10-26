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

import java.io.File;
import java.util.List;
import lets.core.os.Utils;

public class FlavorDetector {

  public static Flavor detect(boolean fallback) {
    Flavor flavor;

    List<String> file = null;

    try {
      file = Utils.readFile(new File("/var/run/dmesg.boot"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    if (file != null) {
      for (String line : file) {
        flavor = Flavor.getFlavorFromString(line);

        if (flavor != null) {
          return flavor;
        }
      }
    }

    if (fallback) {
      String prop = System.getProperty("os.name");

      flavor = Flavor.getFlavorFromString(prop);

      if (flavor != null) {
        return flavor;
      }
    }

    return null;
  }
}
