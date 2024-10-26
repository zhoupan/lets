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

import co.casterlabs.rhs.protocol.StandardHttpStatus;
import co.casterlabs.rhs.server.HttpResponse;
import co.casterlabs.rhs.session.HttpSession;
import co.casterlabs.rhs.util.MimeTypes;
import java.io.InputStream;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.NonNull;

/** A handler that serves UI files out of your jar. */
@AllArgsConstructor
public class ResourceHandler implements Function<HttpSession, HttpResponse> {
  private final @NonNull String resourceBase;

  public ResourceHandler() {
    this("");
  }

  @Override
  public HttpResponse apply(HttpSession session) {
    String path = this.resourceBase + session.getUri();
    String mimeType = MimeTypes.getMimeForType(path.substring(path.lastIndexOf('.') + 1));

    InputStream in = ResourceHandler.class.getResourceAsStream(path);

    if (in == null) {
      return HttpResponse.newFixedLengthResponse(StandardHttpStatus.NOT_FOUND);
    } else {
      return HttpResponse.newChunkedResponse(StandardHttpStatus.OK, in).setMimeType(mimeType);
    }
  }
}
