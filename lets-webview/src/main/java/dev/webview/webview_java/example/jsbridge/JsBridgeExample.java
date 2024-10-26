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

import dev.webview.webview_java.Webview;
import dev.webview.webview_java.bridge.WebviewBridge;

public class JsBridgeExample {

  public static void main(String[] args) {
    Webview wv =
        new Webview(true); // Can optionally be created with an AWT component to be painted on.

    wv.setTitle("My Webview App");

    WebviewBridge bridge = new WebviewBridge(wv);
    // await jpp.a("a"), await jpp.b("a", "b"), await jpp.c(1024),
    // await jpp.count, jpp.count=10
    bridge.defineObject("jpp", new RandStr());

    // load a URL
    wv.loadURL("https://google.com");
    // wv.loadURL("https://baidu.com");
    // wv.loadURL(null);

    /*

    Or, load raw html from a file with:
    wv.setHTML("<h1>This is a test!<h1>");

    String htmlContent = loadContentFromFile("index.html");
    wv.setHTML(htmlContent);

     */

    wv.run(); // Run the webview event loop, the webview is fully disposed when this returns.
    wv.close(); // Free any resources allocated.
  }
}
