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
package dev.webview.webview_java.bridge;

import co.casterlabs.commons.io.streams.StreamUtil;
import co.casterlabs.rakurai.json.Rson;
import co.casterlabs.rakurai.json.element.JsonArray;
import co.casterlabs.rakurai.json.element.JsonElement;
import co.casterlabs.rakurai.json.element.JsonNull;
import co.casterlabs.rakurai.json.element.JsonObject;
import co.casterlabs.rakurai.json.element.JsonString;
import dev.webview.webview_java.Webview;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

public class WebviewBridge {
  private static String bridgeScript = "";

  static {
    try {
      bridgeScript =
          StreamUtil.toString(
              WebviewBridge.class.getResourceAsStream(
                  "/dev/webview/webview_java/bridge/BridgeScript.js"),
              StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  Map<String, JavascriptObject> objects = new HashMap<>();
  Webview webview;

  public WebviewBridge(@NonNull Webview webview) {
    this.webview = webview;

    this.webview.bind(
        "__bridgeInternal",
        (rawArgs) -> {
          JsonArray args = Rson.DEFAULT.fromJson(rawArgs, JsonArray.class);

          String type = args.getString(0);
          JsonObject data = args.getObject(1);

          switch (type) {
            case "INIT":
              {
                this.emit("init", JsonNull.INSTANCE);
                this.webview.eval("console.log('[Webview-Bridge]', 'Bridge init completed.');");
                return null;
              }

            case "GET":
              {
                String id = data.getString("id");
                String property = data.getString("property");
                return this.processGet(id, property).toString();
              }

            case "SET":
              {
                String id = data.getString("id");
                String property = data.getString("property");
                JsonElement newValue = data.get("newValue");
                this.processSet(id, property, newValue);
                return null;
              }

            case "INVOKE":
              {
                String id = data.getString("id");
                String function = data.getString("function");
                JsonArray arguments = data.getArray("arguments");
                return this.processInvoke(id, function, arguments).toString();
              }

            default:
              throw new IllegalArgumentException("Unknown IPC message: " + rawArgs);
          }
        });

    this.rebuildInitScript();
  }

  private void rebuildInitScript() {
    List<String> init = new LinkedList<>();
    init.add(bridgeScript);

    for (Map.Entry<String, JavascriptObject> entry : new ArrayList<>(this.objects.entrySet())) {
      if (!entry.getKey().contains(".")) {
        entry.getValue().getInitLines(entry.getKey(), this).forEach(init::add);
      }
    }

    init.add("console.log(\"[Webview-Bridge]\", \"Injected bridge script.\");");
    init.add("Bridge.__internal.sendMessageToJava(\"INIT\", {});");

    this.webview.setInitScript(String.join("\n\n", init), false);
  }

  public void defineObject(@NonNull String name, @NonNull JavascriptObject obj) {
    this.webview.eval(String.join("\n", obj.getInitLines(name, this)));
    this.rebuildInitScript();
  }

  public void emit(@NonNull String type, @NonNull JsonElement data) {
    this.webview.eval(
        String.format("window.Bridge.__internal.broadcast(%s,%s);", new JsonString(type), data));
  }

  private @Nullable JsonElement processGet(String id, String property) throws Throwable {
    for (JavascriptObject obj : this.objects.values()) {
      if (obj.getId().equals(id)) {
        return obj.get(property, this);
      }
    }
    return null;
  }

  private void processSet(String id, String property, JsonElement value) throws Throwable {
    for (JavascriptObject obj : this.objects.values()) {
      if (obj.getId().equals(id)) {
        obj.set(property, value, this);
        break;
      }
    }
  }

  private @Nullable JsonElement processInvoke(String id, String function, JsonArray args)
      throws Throwable {
    for (JavascriptObject obj : this.objects.values()) {
      if (obj.getId().equals(id)) {
        return obj.invoke(function, args, this);
      }
    }
    return null;
  }
}
