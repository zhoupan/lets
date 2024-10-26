/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
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
package lets.core;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lets.core.io.FileUtils;

public class PatternUtils {

  public static DataResultSupport<List<String>> find(CharSequence input, Pattern pattern) {
    DataResultSupport<List<String>> result = new DataResultSupport<List<String>>();
    try {
      List<String> items = new ArrayList<String>();
      Matcher m = pattern.matcher(input);
      while (m.find()) {
        items.add(m.group());
      }
      result.setData(items);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public static DataResultSupport<List<String>> find(File input, Charset charset, Pattern pattern) {
    DataResultSupport<List<String>> result = new DataResultSupport<List<String>>();
    try {
      List<String> items = new ArrayList<String>();
      List<String> lines = FileUtils.readLines(input, charset);
      for (String line : lines) {
        DataResultSupport<List<String>> find = find(line, pattern);
        if (find.isSuccess()) {
          items.addAll(find.getData());
        }
      }
      result.setData(items);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
