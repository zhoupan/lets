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
package lets.core.properties;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import jodd.props.Props;
import lets.core.DataResultSupport;

public class PropsUtils {

  public static DataResultSupport<Props> from(File file) {
    return from(file, StandardCharsets.UTF_8.name());
  }

  public static DataResultSupport<Props> from(File file, String encoding) {
    DataResultSupport<Props> result = new DataResultSupport<Props>();
    try {
      Props props = new Props();
      result.setData(props);
      props.load(file, encoding);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public static DataResultSupport<Props> from(InputStream stream) {
    return from(stream, StandardCharsets.UTF_8.name());
  }

  public static DataResultSupport<Props> from(InputStream stream, String encoding) {
    DataResultSupport<Props> result = new DataResultSupport<Props>();
    try {
      Props props = new Props();
      result.setData(props);
      props.load(stream, encoding);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public static DataResultSupport<Props> fromString(String data) {
    DataResultSupport<Props> result = new DataResultSupport<Props>();
    try {
      Props props = new Props();
      result.setData(props);
      props.load(data);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
