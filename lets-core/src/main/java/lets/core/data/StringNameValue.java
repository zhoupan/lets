/*
 * Copyright (c) 2021 zhoupan (https://github.com/zhoupan).
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
package lets.core.data;

import java.util.ArrayList;
import java.util.List;
import lets.core.StringUtils;

public class StringNameValue extends NameValueSupport<String, String> {
  public static final String LINE_ENDS = "\r\n";
  public static final String NAME_VALUE_SEPARATOR = "=";

  /** */
  private static final long serialVersionUID = 1L;

  public StringNameValue(String name, String value) {
    super(name, value);
  }

  @Override
  public String toString() {
    return "StringNameValue [name=" + name + ", value=" + value + "]";
  }

  public static String toLines(List<StringNameValue> nameValues) {
    StringBuilder sb = new StringBuilder();
    for (StringNameValue nameValue : nameValues) {
      sb.append(nameValue.getName())
          .append(NAME_VALUE_SEPARATOR)
          .append(nameValue.getValue())
          .append(LINE_ENDS);
    }
    return sb.toString();
  }

  public static List<StringNameValue> fromLines(String lines) {
    List<StringNameValue> nameValues = new ArrayList<StringNameValue>();
    String[] lineArray = StringUtils.split(lines, LINE_ENDS);
    if (lineArray != null) {
      for (String line : lineArray) {
        String name = StringUtils.substringBefore(line, NAME_VALUE_SEPARATOR);
        String value = StringUtils.substringAfter(line, NAME_VALUE_SEPARATOR);
        if (StringUtils.isNotBlank(name)) {
          StringNameValue nameValue = new StringNameValue(name, value);
          nameValues.add(nameValue);
        }
      }
    }
    return nameValues;
  }
}
