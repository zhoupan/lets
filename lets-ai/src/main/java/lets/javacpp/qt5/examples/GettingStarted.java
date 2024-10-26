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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import lets.javacpp.JavaCppUtils;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.qt.Qt5Widgets.QApplication;
import org.bytedeco.qt.Qt5Widgets.QTextEdit;

public class GettingStarted {
  private static IntPointer argc;
  private static PointerPointer argv;

  public static void main(String[] args) {
    String path = Loader.load(org.bytedeco.qt.global.Qt5Core.class);
    System.out.println("Load:Qt5Core=" + path);
    List<String> items = new ArrayList<String>();
    items.add("gettingstarted");
    items.add("-platformpluginpath");
    items.add(new File(path).getParent());
    // argc = new IntPointer(new int[]{3});
    argc = JavaCppUtils.ByRef(items.size());
    // argv = new PointerPointer("gettingstarted", "-platformpluginpath", new
    // File(path).getParent());
    argv = JavaCppUtils.CharPointerArray(items);
    QApplication app = new QApplication(argc, argv);

    QTextEdit textEdit = new QTextEdit();
    textEdit.show();

    System.exit(app.exec());
  }
}
