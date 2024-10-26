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

import static dev.webview.webview_java.WebviewNative.N;
import static dev.webview.webview_java.WebviewNative.WV_HINT_FIXED;
import static dev.webview.webview_java.WebviewNative.WV_HINT_MAX;
import static dev.webview.webview_java.WebviewNative.WV_HINT_MIN;
import static dev.webview.webview_java.WebviewNative.WV_HINT_NONE;

import co.casterlabs.commons.platform.Platform;
import com.sun.jna.Native;
import com.sun.jna.ptr.PointerByReference;
import dev.webview.webview_java.WebviewNative.BindCallback;
import java.awt.Component;
import java.io.Closeable;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

public class Webview implements Closeable, Runnable {

  @Deprecated public long $pointer;

  /**
   * Creates a new Webview. <br>
   * The default size will be set, and if the size is set again before loading the URL, a splash
   * will appear.<br>
   * eg:
   *
   * <pre>
   * <code>
   *   WebView wv = new WebView(true);
   *   wv.setSize(1280, 720);
   *   wv.loadURL("...")
   * </code>
   * </pre>
   *
   * It's recommended that setting size together:
   *
   * <pre>
   * <code>
   *   WebView wv = new WebView(true, 1280, 720);
   *   wv.loadURL("...")
   * </code>
   * </pre>
   *
   * @param debug Enables devtools/inspect element if true.
   * @see #Webview(boolean, int, int)
   */
  public Webview(boolean debug) {
    this(debug, (PointerByReference) null);
  }

  /**
   * Creates a new Webview.
   *
   * @param debug Enables devtools/inspect element if true.
   * @param width preset - width
   * @param height preset - height
   */
  public Webview(boolean debug, int width, int height) {
    this(debug, null, width, height);
  }

  /**
   * Creates a new Webview. <br>
   * The default size will be set, and if the size is set again before loading the URL, a splash
   * will appear.<br>
   * eg:
   *
   * <pre>
   * <code>
   *   WebView wv = new WebView(true);
   *   wv.setSize(1280, 720);
   *   wv.loadURL("...")
   * </code>
   * </pre>
   *
   * It's recommended that setting size together:
   *
   * <pre>
   * <code>
   *   WebView wv = new WebView(true, 1280, 720);
   *   wv.loadURL("...")
   * </code>
   * </pre>
   *
   * @param debug Enables devtools/inspect element if true.
   * @param target The target awt component, such as a {@link java.awt.JFrame} or {@link
   *     java.awt.Canvas}. Must be "drawable".
   * @see #Webview(boolean, PointerByReference, int, int)
   */
  public Webview(boolean debug, @NonNull Component target) {
    this(debug, new PointerByReference(Native.getComponentPointer(target)));
  }

  /**
   * @deprecated Use this only if you absolutely know what you're doing.
   */
  @Deprecated
  public Webview(boolean debug, @Nullable PointerByReference windowPointer) {
    this(debug, windowPointer, 800, 600);
  }

  /**
   * @deprecated Use this only if you absolutely know what you're doing.
   */
  @Deprecated
  public Webview(boolean debug, @Nullable PointerByReference windowPointer, int width, int height) {
    $pointer = N.webview_create(debug, windowPointer);

    this.loadURL(null);
    this.setSize(width, height);
  }

  /**
   * @deprecated Use this only if you absolutely know what you're doing.
   */
  @Deprecated
  public long getNativeWindowPointer() {
    return N.webview_get_window($pointer);
  }

  public void setHTML(@Nullable String html) {
    N.webview_set_html($pointer, html);
    //        this.eval(this.initScript);
  }

  public void loadURL(@Nullable String url) {
    if (url == null) {
      url = "about:blank";
    }

    N.webview_navigate($pointer, url);
    //        this.eval(this.initScript);
  }

  public void setTitle(@NonNull String title) {
    N.webview_set_title($pointer, title);
  }

  public void setMinSize(int width, int height) {
    N.webview_set_size($pointer, width, height, WV_HINT_MIN);
  }

  public void setMaxSize(int width, int height) {
    N.webview_set_size($pointer, width, height, WV_HINT_MAX);
  }

  public void setSize(int width, int height) {
    N.webview_set_size($pointer, width, height, WV_HINT_NONE);
  }

  public void setFixedSize(int width, int height) {
    N.webview_set_size($pointer, width, height, WV_HINT_FIXED);
  }

  /**
   * Sets the script to be run on page load. Defaults to no nested access (false).
   *
   * @implNote This get's called AFTER window.load.
   * @param script
   * @see #setInitScript(String, boolean)
   */
  public void setInitScript(@NonNull String script) {
    this.setInitScript(script, false);
  }

  /**
   * Sets the script to be run on page load.
   *
   * @implNote This get's called AFTER window.load.
   * @param script
   * @param allowNestedAccess whether or not to inject the script into nested iframes.
   */
  public void setInitScript(@NonNull String script, boolean allowNestedAccess) {
    script =
        String.format(
            "(() => {\n"
                + "try {\n"
                + "if (window.top == window.self || %b) {\n"
                + "%s\n"
                + "}\n"
                + "} catch (e) {\n"
                + "console.error('[Webview]', 'An error occurred whilst evaluating init script:', %s, e);\n"
                + "}\n"
                + "})();",
            allowNestedAccess, script, '"' + _WebviewUtil.jsonEscape(script) + '"');

    N.webview_init($pointer, script);
  }

  /**
   * Executes the given script NOW.
   *
   * @param script
   */
  public void eval(@NonNull String script) {
    this.dispatch(
        () -> {
          N.webview_eval(
              $pointer,
              String.format(
                  "try {\n"
                      + "%s\n"
                      + "} catch (e) {\n"
                      + "console.error('[Webview]', 'An error occurred whilst evaluating script:', %s, e);\n"
                      + "}",
                  script, '"' + _WebviewUtil.jsonEscape(script) + '"'));
        });
  }

  /**
   * Binds a function to the JavaScript environment on page load.
   *
   * @implNote This get's called AFTER window.load.
   * @implSpec After calling the function in JavaScript you will get a Promise instead of the value.
   *     This is to prevent you from locking up the browser while waiting on your Java code to
   *     execute and generate a return value.
   * @param name The name to be used for the function, e.g "foo" to get foo().
   * @param handler The callback handler, accepts a JsonArray (which are all arguments passed to the
   *     function()) and returns a value which is of type JsonElement (can be null). Exceptions are
   *     automatically passed back to JavaScript.
   */
  public void bind(@NonNull String name, @NonNull WebviewBindCallback handler) {
    N.webview_bind(
        $pointer,
        name,
        new BindCallback() {
          @Override
          public void callback(long seq, String req, long arg) {
            try {
              req = _WebviewUtil.forceSafeChars(req);

              String result = handler.apply(req);
              if (result == null) {
                result = "null";
              }

              N.webview_return($pointer, seq, false, _WebviewUtil.forceSafeChars(result));
            } catch (Throwable e) {
              e.printStackTrace();

              String exceptionJson =
                  '"' + _WebviewUtil.jsonEscape(_WebviewUtil.getExceptionStack(e)) + '"';

              N.webview_return($pointer, seq, true, exceptionJson);
            }
          }
        },
        0);
  }

  /**
   * Unbinds a function, removing it from future pages.
   *
   * @param name The name of the function.
   */
  public void unbind(@NonNull String name) {
    N.webview_unbind($pointer, name);
  }

  /**
   * Executes an event on the event thread.
   *
   * @deprecated Use this only if you absolutely know what you're doing.
   */
  @Deprecated
  public void dispatch(@NonNull Runnable handler) {
    N.webview_dispatch(
        $pointer,
        ($pointer, arg) -> {
          handler.run();
        },
        0);
  }

  /**
   * Executes the webview event loop until the user presses "X" on the window.
   *
   * @see #close()
   */
  @Override
  public void run() {
    N.webview_run($pointer);
    N.webview_destroy($pointer);
  }

  /**
   * Executes the webview event loop asynchronously until the user presses "X" on the window.
   *
   * @see #close()
   */
  public void runAsync() {
    Thread t = new Thread(this);
    t.setDaemon(false);
    t.setName("Webview RunAsync Thread - #" + this.hashCode());
    t.start();
  }

  /** Closes the webview, call this to end the event loop and free up resources. */
  @Override
  public void close() {
    N.webview_terminate($pointer);
  }

  public void setDarkAppearance(boolean shouldAppearDark) {
    switch (Platform.osFamily) {
      case WINDOWS:
        _WindowsHelper.setWindowAppearance(this, shouldAppearDark);
        break;

      default: // NOOP
        break;
    }
  }

  public static String getVersion() {
    byte[] bytes = N.webview_version().version_number;
    int length = 0;
    for (byte b : bytes) {
      if (b == 0) {
        break;
      }
      length++;
    }
    return new String(bytes, 0, length);
  }
}
