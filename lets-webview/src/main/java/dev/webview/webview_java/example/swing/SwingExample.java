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
package dev.webview.webview_java.example.swing;

import dev.webview.webview_java.AWTWebview;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/** do not support resize! */
public class SwingExample {

  public static void main(String[] args) {
    JFrame frame = new JFrame();

    // Using createAWT allows you to defer the creation of the webview until the
    // canvas is fully renderable.
    AWTWebview component = new AWTWebview(true);
    component.setOnInitialized(
        (wv) -> {
          // Calling `await echo(1,2,3)` will return `[1,2,3]`
          wv.bind(
              "echo",
              (arguments) -> {
                return arguments;
              });

          wv.loadURL("https://google.com");
          // wv.loadURL("https://baidu.com");
          // wv.loadURL(null);

          frame.addWindowListener(
              new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                  component.close();
                  frame.dispose();
                  System.exit(0);
                }
              });
        });

    frame.getContentPane().add(component, BorderLayout.CENTER);

    frame.setTitle("My Webview App");
    frame.setSize(800, 600);
    frame.setVisible(true);
  }
}
