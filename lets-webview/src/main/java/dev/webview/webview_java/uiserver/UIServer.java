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
package dev.webview.webview_java.uiserver;

import co.casterlabs.rhs.server.HttpListener;
import co.casterlabs.rhs.server.HttpResponse;
import co.casterlabs.rhs.server.HttpServer;
import co.casterlabs.rhs.server.HttpServerBuilder;
import co.casterlabs.rhs.session.HttpSession;
import co.casterlabs.rhs.session.WebsocketListener;
import co.casterlabs.rhs.session.WebsocketSession;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.function.Function;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

/**
 * Serves files to the local machine, useful for bundling your own UI with your Webview application.
 */
@Accessors(chain = true)
public class UIServer implements Closeable {
  private @Setter Function<HttpSession, HttpResponse> handler;

  private HttpServer server;

  private @Getter int port;
  private @Getter String localAddress;

  @SneakyThrows
  public UIServer() {
    String hostname = "localhost";

    // Find a random port.
    try (ServerSocket serverSocket = new ServerSocket()) {
      serverSocket.setReuseAddress(false);
      serverSocket.bind(new InetSocketAddress(hostname, 0), 1);
      this.port = serverSocket.getLocalPort();
    }

    this.localAddress = String.format("http://%s:%d", hostname, this.port);

    this.server =
        new HttpServerBuilder()
            .setHostname(hostname)
            .setPort(this.port)
            .build(
                new HttpListener() {
                  @Override
                  public @Nullable HttpResponse serveHttpSession(@NonNull HttpSession session) {
                    if (handler == null) {
                      return null;
                    } else {
                      return handler.apply(session);
                    }
                  }

                  @Override
                  public @Nullable WebsocketListener serveWebsocketSession(
                      @NonNull WebsocketSession session) {
                    return null; // Drop
                  }
                });
  }

  public UIServer start() throws IOException {
    this.server.start();
    return this;
  }

  @Override
  public void close() throws IOException {
    this.server.stop();
  }
}
