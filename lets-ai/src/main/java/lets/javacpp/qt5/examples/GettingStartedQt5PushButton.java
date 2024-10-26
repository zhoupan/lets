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
package lets.javacpp.qt5.examples;

import static org.bytedeco.qt.helper.Qt5Widgets.QAbstractButton_clicked;

import lets.javacpp.qt5.Qt5Utils;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.qt.Qt5Widgets.QApplication;
import org.bytedeco.qt.Qt5Widgets.QPushButton;
import org.bytedeco.qt.helper.Qt5Widgets;

public class GettingStartedQt5PushButton {
  private static IntPointer argc;
  private static PointerPointer argv;

  public static void main(String[] args) {
    try {
      QApplication app = Qt5Utils.QApplication("GettingStartedQt5CoreSupport");
      QPushButton button = new QPushButton(Qt5Utils.QString("&Exit"));
      Qt5Widgets.ClickedCallback c =
          new Qt5Widgets.ClickedCallback() {
            @Override
            public void clicked(boolean checked) {
              QApplication.exit();
            }
          };
      QAbstractButton_clicked(button, button, c, c.id);
      button.show();
      System.exit(app.exec());
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }
}
