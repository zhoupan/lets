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
package lets.core.di;

import java.util.ArrayList;
import java.util.List;

/** The Class Application. */
public class Application {

  /** The container. */
  private ComponentContainer container;

  /** The Constant instance. */
  private static final Application instance = new Application();

  /**
   * Gets the single instance of Application.
   *
   * @return single instance of Application
   */
  public static Application getInstance() {
    return instance;
  }

  /**
   * Gets the container.
   *
   * @return the container
   */
  public ComponentContainer getContainer() {
    return this.container;
  }

  /**
   * Sets the container.
   *
   * @param container the new container
   */
  public void setContainer(ComponentContainer container) {
    this.container = container;
  }

  /**
   * Gets the bean.
   *
   * @param key the key
   * @return the bean
   */
  public <T> T getBean(String key) {
    return getContainer().getComponent(key);
  }

  public <T> T getBean(Class<T> key) {
    return getContainer().getComponent(key);
  }

  /**
   * Gets the service.
   *
   * @param <T> the generic type
   * @param key the key
   * @return the service
   */
  public <T> T getService(Class<T> key) {
    return (T) getBean(key);
  }

  /**
   * Gets the services.
   *
   * @param <T> the generic type
   * @param key the key
   * @return the services
   */
  public <T> List<T> getServices(Class<T> key) {
    List<T> beans = new ArrayList<T>();
    beans.addAll(this.getContainer().getComponents(key).values());
    return beans;
  }

  /**
   * Checks if is container available.
   *
   * @return true, if checks if is container available
   */
  public static boolean isContainerAvailable() {
    return Application.getInstance().getContainer() != null;
  }
}
