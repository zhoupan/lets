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

import io.bootique.di.BQModule;
import io.bootique.di.Binder;
import io.bootique.di.DIBootstrap;
import io.bootique.di.Injector;
import java.util.Properties;
import lets.core.ResultSupport;
import lets.core.app.AppManager;

/**
 * InjectorContainerManager.
 *
 * @author zhoupan
 */
public abstract class AbstractInjectorContainerManager extends AppManager<Container>
    implements BQModule {

  /**
   * Creates the.
   *
   * @param props the props
   * @return the container
   */
  @Override
  public Container create(Properties props) {
    Injector injector = this.buildInjector(props);
    InjectorContainer container = new InjectorContainer(injector);
    return container;
  }

  /**
   * Builds the injector.
   *
   * @param props the props
   * @return the injector
   */
  public Injector buildInjector(Properties props) {
    Injector injector =
        DIBootstrap.injectorBuilder(
                (binder) -> {
                  onConfigure(binder, props);
                })
            .build();
    return injector;
  }

  /**
   * Close.
   *
   * @param object the object
   * @return the result support
   */
  @Override
  public ResultSupport close(Container object) {
    ResultSupport result = new ResultSupport();
    try {
      result = object.shutdown();
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Configure.
   *
   * @param binder the binder
   */
  @Override
  public void configure(Binder binder) {
    // 忽略,通过onConfigure方法配置.
  }

  /**
   * On configure.
   *
   * @param binder the binder
   * @param props the props
   */
  public abstract void onConfigure(Binder binder, Properties props);
}
