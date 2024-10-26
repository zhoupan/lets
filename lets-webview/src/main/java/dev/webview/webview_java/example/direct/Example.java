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
package dev.webview.webview_java.example.direct;

import dev.webview.webview_java.Webview;

public class Example {

  public static void main(String[] args) {
    Webview wv =
        new Webview(true); // Can optionally be created with an AWT component to be painted on.

    // Calling `await echo(1,2,3)` will return `[1,2,3]`
    wv.bind(
        "echo",
        (arguments) -> {
          return arguments;
        });

    wv.setTitle("My Webview App");
    // wv.setSize(800, 600);

    // load a URL
    wv.loadURL("https://google.com");

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
