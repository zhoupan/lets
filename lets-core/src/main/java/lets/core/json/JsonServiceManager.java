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
package lets.core.json;

import java.util.Properties;
import lets.core.ResultSupport;
import lets.core.app.AppManager;
import lets.core.properties.PropertiesBuilder;

/** JsonServiceManager. */
public abstract class JsonServiceManager extends AppManager<JsonService> {

  public JsonServiceManager() {
    this(PropertiesBuilder.of(System.getProperties()));
  }

  public JsonServiceManager(Properties props) {
    this(PropertiesBuilder.of(props));
  }

  public JsonServiceManager(PropertiesBuilder builder) {
    super(builder);
  }

  /**
   * Creates the.
   *
   * @param props the props
   * @return the json service
   */
  public abstract JsonService create(Properties props);

  /**
   * Close.
   *
   * @param object the object
   * @return the result support
   */
  @Override
  public ResultSupport close(JsonService object) {
    ResultSupport result = new ResultSupport();
    return result;
  }
}
