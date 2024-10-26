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

import lets.javacpp.qt5.Qt5Utils;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.qt.Qt5Core.QString;
import org.bytedeco.qt.Qt5Widgets.QApplication;
import org.bytedeco.qt.Qt5Widgets.QMessageBox;

public class GettingStartedQt5Application {
  private static IntPointer argc;
  private static PointerPointer argv;

  public static void main(String[] args) {
    try {
      QApplication app = Qt5Utils.QApplication("GettingStartedQt5CoreSupport");
      // QApplication.aboutQt();
      QString title = Qt5Utils.QString("GettingStarted");
      QString message = Qt5Utils.QString("Qt5");
      QMessageBox.information(null, title, message);
      // System.exit(app.exec());
      QApplication.exit();
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }
}
