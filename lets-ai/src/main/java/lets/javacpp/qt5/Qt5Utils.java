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
package lets.javacpp.qt5;

import java.util.List;
import lets.javacpp.JavaCppUtils;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.qt.Qt5Core.QCoreApplication;
import org.bytedeco.qt.Qt5Core.QString;
import org.bytedeco.qt.Qt5Widgets.QApplication;

public class Qt5Utils {
  public static QString QString(String s) {
    return QString.fromUtf8(s);
  }

  public static QApplication QApplication(String applicationName) {
    Qt5CoreSupport qt5CoreSupport = new Qt5CoreSupport("GettingStartedQt5CoreSupport", false);
    List<String> arguments = qt5CoreSupport.buildArguments();
    IntPointer argc = JavaCppUtils.ByRef(arguments.size());
    PointerPointer argv = JavaCppUtils.CharPointerArray(arguments);
    return new QApplication(argc, argv);
  }

  public static QCoreApplication QCoreApplication(String applicationName) {
    Qt5CoreSupport qt5CoreSupport = new Qt5CoreSupport("GettingStartedQt5CoreSupport", true);
    List<String> arguments = qt5CoreSupport.buildArguments();
    IntPointer argc = JavaCppUtils.ByRef(arguments.size());
    PointerPointer argv = JavaCppUtils.CharPointerArray(arguments);
    return new QCoreApplication(argc, argv);
  }
}
