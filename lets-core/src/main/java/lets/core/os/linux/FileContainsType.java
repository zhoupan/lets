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
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileContainsType extends SearchType {

  private final File file;
  private final String needle;

  public FileContainsType(String file, String needle) {
    this(new File(file), needle);
  }

  public FileContainsType(File file, String needle) {
    this.file = file;
    this.needle = needle;
  }

  @Override
  public boolean detect() {
    if (file.exists()) {
      try {
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String line;

        while ((line = reader.readLine()) != null) {
          if (line.toLowerCase().contains(needle.toLowerCase())) {
            reader.close();
            return true;
          }
        }

        reader.close();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    return false;
  }
}
