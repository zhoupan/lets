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

import io.bootique.di.Injector;
import javax.inject.Provider;
import lets.core.DataResultSupport;
import lets.core.ResultSupport;

/**
 * InjectorContainer.
 *
 * @author zhoupan
 */
public class InjectorContainer implements Container {

  /** The injector. */
  private final Injector injector;

  /**
   * Instantiates a new injector container.
   *
   * @param injector the injector
   */
  public InjectorContainer(Injector injector) {
    super();
    this.injector = injector;
  }

  /**
   * Gets the injector.
   *
   * @return the injector
   */
  public Injector getInjector() {
    return injector;
  }

  /**
   * Gets the single instance of InjectorContainer.
   *
   * @param <T> the generic type
   * @param type the type
   * @return single instance of InjectorContainer
   */
  @Override
  public <T> DataResultSupport<T> getInstance(Class<T> type) {
    DataResultSupport<T> result = new DataResultSupport<T>();
    try {
      result.setData(this.getInjector().getInstance(type));
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Gets the provider.
   *
   * @param <T> the generic type
   * @param type the type
   * @return the provider
   */
  @Override
  public <T> DataResultSupport<Provider<T>> getProvider(Class<T> type) {
    DataResultSupport<Provider<T>> result = new DataResultSupport<Provider<T>>();
    try {
      result.setData(this.getInjector().getProvider(type));
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Checks for provider.
   *
   * @param type the type
   * @return true, if successful
   */
  @Override
  public boolean hasProvider(Class<?> type) {
    return this.getInjector().hasProvider(type);
  }

  /**
   * Inject members.
   *
   * @param object the object
   * @return the result support
   */
  @Override
  public ResultSupport injectMembers(Object object) {
    ResultSupport result = new ResultSupport();
    try {
      this.getInjector().injectMembers(object);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Shutdown.
   *
   * @return the result support
   */
  @Override
  public ResultSupport shutdown() {
    ResultSupport result = new ResultSupport();
    try {
      this.getInjector().shutdown();
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
