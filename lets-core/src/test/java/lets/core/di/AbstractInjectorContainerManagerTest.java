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

import static org.junit.jupiter.api.Assertions.*;

import io.bootique.di.Binder;
import java.util.Properties;
import javax.inject.Inject;
import lets.core.DataResultSupport;
import lets.core.LoggerService;
import lets.core.ObjectUtils;
import lets.core.ResultSupport;
import lets.core.app.App;
import lets.core.app.AppLoggers;
import lets.core.logger.DefaultLoggerService;
import lets.core.properties.PropertiesBuilder;
import org.junit.jupiter.api.Test;

public class AbstractInjectorContainerManagerTest {

  AbstractInjectorContainerManager mgr =
      new AbstractInjectorContainerManager() {

        @Override
        public void onConfigure(Binder binder, Properties props) {
          binder.bind(App.class).to(ExampleApp.class);
          binder.bind(LoggerService.class).to(DefaultLoggerService.class);
          binder.bind(PropertiesBuilder.class).toInstance(this.builder);
          binder.bind(Container.class).toProviderInstance(this);
        }
      };

  @Inject Container container;

  @Inject LoggerService loggerService;

  @Inject PropertiesBuilder builder;

  @Test
  public void testOnConfigureGetInstanceInjectMembers() {
    // ResultSupport update = mgr.update();
    // assertTrue(update.getMessage(), update.isSuccess());
    Container container = mgr.get();
    assertNotNull(container);
    // getInstance
    DataResultSupport<App> app = container.getInstance(App.class);
    assertTrue(app.isSuccess());
    assertEquals(ExampleApp.class, app.getData().getClass());
    AppLoggers.GENERAL.info("ExampleApp:{}", app);
    DataResultSupport<LoggerService> loggerService = container.getInstance(LoggerService.class);
    assertTrue(loggerService.isSuccess());
    loggerService.getData().getLogger(getClass()).info("It Work");
    PropertiesBuilder builder = container.getInstance(PropertiesBuilder.class).getData();
    loggerService.getData().getLogger(getClass()).info("PropertiesBuilder:{}", builder.build());
    Container injectContainer = container.getInstance(Container.class).getData();
    assertTrue(ObjectUtils.equals(container, injectContainer));
    // injectMembers
    ResultSupport injectMembers = container.injectMembers(this);
    assertTrue(injectMembers.isSuccess());
    assertTrue(ObjectUtils.equals(container, AbstractInjectorContainerManagerTest.this.container));
    assertTrue(ObjectUtils.equals(builder, AbstractInjectorContainerManagerTest.this.builder));
  }
}
