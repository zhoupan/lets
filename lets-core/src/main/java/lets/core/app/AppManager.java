/*
 * Copyright (c) 2022 zhoupan (https://github.com/zhoupan).
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
package lets.core.app;

import java.util.Properties;
import lets.core.ClassUtils;
import lets.core.ObjectManager;
import lets.core.ResultSupport;
import lets.core.function.InputOutputCallback;
import lets.core.properties.PropertiesBuilder;

/**
 * AppManager.
 *
 * @author zhoupan
 * @param <T> the generic type
 */
public abstract class AppManager<T> extends ObjectManager<T> {

  /** The builder. */
  protected final PropertiesBuilder builder;

  /**
   * Builder.
   *
   * @return the properties builder
   */
  public PropertiesBuilder builder() {
    return this.builder;
  }

  /** Instantiates a new app manager. */
  public AppManager() {
    this(PropertiesBuilder.of(System.getProperties()));
  }

  /**
   * Instantiates a new app manager.
   *
   * @param builder the builder
   */
  public AppManager(PropertiesBuilder builder) {
    super();
    this.builder = builder;
  }

  /**
   * Instantiates a new app manager.
   *
   * @param props the props
   */
  public AppManager(Properties props) {
    this(PropertiesBuilder.of(props));
  }

  /**
   * Update.
   *
   * @return the result support
   */
  public ResultSupport update() {
    return this.update(this.builder().build());
  }

  public static <T, Manager extends AppManager<T>> Manager create(
      PropertiesBuilder pb, Class<Manager> appManagerImplClass, Class<T> appClass) {
    Manager appManager =
        ClassUtils.instantiate(
            appManagerImplClass, new Class<?>[] {PropertiesBuilder.class}, new Object[] {pb});
    return appManager;
  }

  public static <T, Manager extends AppManager<T>> Manager create(
      PropertiesBuilder pb,
      Class<Manager> appManagerImplClass,
      Class<T> appClass,
      InputOutputCallback<PropertiesBuilder, Manager> builder) {
    Manager appManager = builder.callback(pb);
    return appManager;
  }
}
