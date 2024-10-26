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
package dev.webview.webview_java.example.jsbridge;

import dev.webview.webview_java.bridge.*;
import java.util.Random;

public class RandStr extends JavascriptObject {
  private static final Random random = new Random();

  /*
   * 'public' modifier need!
   * get: await jpp.count
   * set: jpp.count = 10
   */
  @JavascriptValue public int count;

  @JavascriptFunction
  public String a(String in) {
    return in;
  }

  @JavascriptFunction
  public String[] b(String ina, String inb) {
    String[] re = new String[] {ina, inb};
    return re;
  }

  @JavascriptFunction
  public String c(Integer argss) {
    if (argss == null) {
      return "[\"single string test\"]";
    }

    int size = argss;
    byte[] bs = new byte[size];

    for (int i = 0; i < bs.length; i++) {
      bs[i] = (byte) (random.nextInt(26) + 'a');
    }
    String randomStr = new String(bs);
    return randomStr;
  }

  // To test if changes on count(jpp.count=10) has effect on java object (result: yes)
  @JavascriptFunction
  public int getCountValue() {
    return count;
  }
}
