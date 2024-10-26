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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

  public static List<String> readProcess(String[] args) throws Exception {
    List<String> raw = new ArrayList<>();

    Process p = Runtime.getRuntime().exec(args);

    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line;

    while ((line = reader.readLine()) != null) {
      raw.add(line);
    }

    reader.close();

    return raw;
  }

  public static Map<String, String> mapFile(File file, String delimiter) throws Exception {
    Map<String, String> map = new HashMap<>();

    List<String> lines = readFile(file);

    for (String line : lines) {
      String[] split = line.split(delimiter);
      String key = split[0].trim();
      String value = split[1].trim();
      map.put(key, value);
    }

    return map;
  }

  public static List<String> readFile(File file) throws Exception {
    List<String> list = new ArrayList<>();

    if (file.exists()) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

      String line;

      while ((line = reader.readLine()) != null) {
        list.add(line);
      }

      reader.close();
    }

    return list;
  }

  /** Runs the command "uname -a" and reads the first line */
  public static String getUname() {
    String uname = null;

    try {
      Process p = Runtime.getRuntime().exec(new String[] {"uname", "-a"});
      BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
      uname = reader.readLine();
      reader.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return uname;
  }
}
