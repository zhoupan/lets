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

import io.bootique.di.DIRuntimeException;
import javax.inject.Provider;
import lets.core.DataResultSupport;
import lets.core.ResultSupport;

/**
 * A facade to the DI container.
 *
 * @author zhoupan
 */
public interface Container {

  /**
   * Returns a service instance bound in the container for a specific type. Throws {@link
   * DIRuntimeException} if the type is not bound, or an instance can not be created.
   *
   * @param <T> the generic type
   * @param type the type
   * @return single instance of Injector
   */
  <T> DataResultSupport<T> getInstance(Class<T> type);

  /**
   * Gets the provider.
   *
   * @param <T> the generic type
   * @param type the type
   * @return the provider
   */
  <T> DataResultSupport<Provider<T>> getProvider(Class<T> type);

  /**
   * Checks for provider.
   *
   * @param type binding type to check
   * @return is provider for given type registered
   */
  boolean hasProvider(Class<?> type);

  /**
   * Performs field injection on a given object, ignoring constructor injection. Since Injector
   * returns fully injected objects, this method is rarely used directly.
   *
   * <p>Note that using this method inside a custom DI {@link Provider} will most likely result in
   * double injection, as custom provider is wrapped in a field-injecting provider by the DI
   * container. Instead custom providers must initialize object properties manually, obtaining
   * dependencies from Injector.
   *
   * @param object the object
   */
  ResultSupport injectMembers(Object object);

  /**
   * A lifecycle method that let's the injector's services to clean up their state and release
   * resources. This method would normally generate a scope end event for the injector's one and
   * only singleton scope.
   */
  ResultSupport shutdown();
}
