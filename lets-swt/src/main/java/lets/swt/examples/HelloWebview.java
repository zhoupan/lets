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
package lets.swt.examples;

import com.sun.jna.*;
import com.sun.jna.ptr.PointerByReference;
import dev.webview.webview_java.Webview;
import java.awt.*;
import lets.swt.SwtUtils;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class HelloWebview {

  private static long getWindowIdFromShell(Shell shell) {
    long handle = shell.handle;
    // long topWidget = OS._gtk_widget_get_toplevel(handle);
    // long topWindow = OS._gtk_widget_get_window(topWidget);
    // long topXid = OS._gdk_x11_window_get_xid(topWindow);
    // return topXid;
    return handle;
  }

  public static void main(String[] args) throws ClassNotFoundException {
    String url = "https://oschina.net";
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setSize(1024, 768);
    shell.setLayout(new GridLayout(1, false));
    Pointer pointer = new Pointer(shell.handle);
    PointerByReference pointerRef = new com.sun.jna.ptr.PointerByReference(pointer);
    Webview webview = new Webview(true, pointerRef);
    webview.loadURL(url);
    shell.open();
    SwtUtils.shellDisplay(shell);
  }
}
