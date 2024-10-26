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
package dev.webview.webview_java;

import java.io.PrintWriter;
import java.io.StringWriter;
import lombok.NonNull;

class _WebviewUtil {

  static String getExceptionStack(@NonNull Throwable e) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);

    e.printStackTrace(pw);

    String out = sw.toString();

    pw.flush();
    pw.close();
    sw.flush();

    return out.substring(0, out.length() - 2).replace("\r", "");
  }

  static String jsonEscape(@NonNull String input) {
    char[] chars = input.toCharArray();

    StringBuilder output = new StringBuilder();

    for (int i = 0; i < chars.length; i++) {
      char ch = chars[i];

      switch (ch) {
        case 0:
          {
            output.append("\\u0000");
            break;
          }

        case '\n':
          {
            output.append("\\n");
            break;
          }

        case '\t':
          {
            output.append("\\t");
            break;
          }

        case '\r':
          {
            output.append("\\r");
            break;
          }

        case '\\':
          {
            output.append("\\\\");
            break;
          }

        case '"':
          {
            output.append("\\\"");
            break;
          }

        case '\b':
          {
            output.append("\\b");
            break;
          }

        case '\f':
          {
            output.append("\\f");
            break;
          }

        default:
          {
            if (ch > 127) {
              output.append("\\u").append(String.format("%04x", (int) ch));
            } else {
              output.append(ch);
            }

            break;
          }
      }
    }

    return output.toString();
  }

  static String forceSafeChars(@NonNull String input) {
    char[] chars = input.toCharArray();

    StringBuilder output = new StringBuilder();

    for (int i = 0; i < chars.length; i++) {
      char ch = chars[i];

      switch (ch) {
        case 0:
          {
            output.append("\\u0000");
            break;
          }

        default:
          {
            if (ch > 127) {
              output.append("\\u").append(String.format("%04x", (int) ch));
            } else {
              output.append(ch);
            }

            break;
          }
      }
    }

    return output.toString();
  }
}
