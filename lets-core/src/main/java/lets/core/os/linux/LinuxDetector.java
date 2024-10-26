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
package lets.core.os.linux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import lets.core.os.Arch;
import lets.core.os.OperatingSystem;

public class LinuxDetector {

  public static boolean detect(boolean fallback) {
    if (fallback) {
      return System.getProperty("os.name")
          .toLowerCase()
          .contains(OperatingSystem.LINUX.getPrimarySearch());
    }

    return false;
  }

  public static Arch getLinuxArch() {
    InputStream is = null;
    try {
      final Process process = Runtime.getRuntime().exec(new String[] {"uname", "-m"});
      is = process.getInputStream();
      return Arch.getArch(convert(is));
    } catch (IOException exception) {
      return Arch.getArch(System.getProperty("os.arch"));
    } finally {
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private static String convert(InputStream inputStream) throws IOException {

    StringBuilder stringBuilder = new StringBuilder();
    String line = null;

    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
      while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line);
      }
    }

    return stringBuilder.toString();
  }
}
