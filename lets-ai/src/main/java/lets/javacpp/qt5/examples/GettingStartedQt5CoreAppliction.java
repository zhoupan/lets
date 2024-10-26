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
import org.bytedeco.qt.Qt5Core.QCoreApplication;

public class GettingStartedQt5CoreAppliction {
  private static IntPointer argc;
  private static PointerPointer argv;

  public static void main(String[] args) {
    try {
      QCoreApplication app = Qt5Utils.QCoreApplication("GettingStartedQt5CoreSupport");
      QCoreApplication.exit();
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }
}
