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
package dev.webview.webview_java;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.platform.win32.WinDef.BOOL;
import com.sun.jna.platform.win32.WinDef.BOOLByReference;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.PointerByReference;

class _WindowsHelper {

  @SuppressWarnings("deprecation")
  static void setWindowAppearance(Webview webview, boolean shouldBeDark) {
    // References:
    // https://docs.microsoft.com/en-us/windows/win32/api/dwmapi/nf-dwmapi-dwmsetwindowattribute
    // https://winscp.net/forum/viewtopic.php?t=30088
    // https://gist.github.com/rossy/ebd83ba8f22339ce25ef68bfc007dfd2
    //
    // This is the code that we're mimicking (in c):
    /*
    DwmSetWindowAttribute(
        hwnd,
        DWMWA_USE_IMMERSIVE_DARK_MODE,
        &(BOOL) { TRUE },
        sizeof(BOOL)
    );
    InvalidateRect(hwnd, null, FALSE);
    */

    HWND hwnd = new HWND(new Pointer(webview.getNativeWindowPointer()));
    BOOLByReference pvAttribute = new BOOLByReference(new BOOL(shouldBeDark));

    DWM.N.DwmSetWindowAttribute(hwnd, DWM.DWMWA_USE_IMMERSIVE_DARK_MODE, pvAttribute, BOOL.SIZE);

    DWM.N.DwmSetWindowAttribute(
        hwnd, DWM.DWMWA_USE_IMMERSIVE_DARK_MODE_BEFORE_20H1, pvAttribute, BOOL.SIZE);

    User32.N.InvalidateRect(hwnd, null, 0); // Repaint
  }

  private static interface DWM extends Library {
    static final DWM N = Native.load("dwmapi", DWM.class);

    static final int DWMWA_USE_IMMERSIVE_DARK_MODE_BEFORE_20H1 = 19;
    static final int DWMWA_USE_IMMERSIVE_DARK_MODE = 20;

    int DwmSetWindowAttribute(HWND hwnd, int dwAttribute, PointerType pvAttribute, int cbAttribute);
  }

  private static interface User32 extends Library {
    static final User32 N = Native.load("user32", User32.class);

    int InvalidateRect(HWND hwnd, PointerByReference rect, int erase);
  }
}
