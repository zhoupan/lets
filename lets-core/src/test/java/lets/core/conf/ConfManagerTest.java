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
package lets.core.conf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ConfManagerTest {

  @Test
  public void test() {
    // 默认读取application.properties
    ConfManager mgr = new ConfManager();
    Conf conf = mgr.get();
    assertNotNull(conf);
    // app
    assertEquals("lets.product.app", conf.getConfig().getString("app.id"));
    assertEquals("App", conf.getConfig().getString("app.name"));
    assertEquals("1.0", conf.getConfig().getString("app.version"));
    // test.app
    assertEquals("lets.product.app.test", conf.getString("test", "app.id"));
    assertEquals("Test App", conf.getString("test", "app.name"));
    assertEquals("1.0", conf.getString("test", "app.version"));
    // prod.app
    assertEquals("lets.product.app", conf.getString("prod", "app.id"));
    assertEquals("App", conf.getString("prod", "app.name"));
    assertEquals("1.0", conf.getString("test", "app.version"));
    App app = Conf.create(conf.getConfig("app"), App.class);
    assertEquals("App", app.getName());
    assertEquals("1.0", app.getVersion());
    App appTest = Conf.create(conf.getConfig(), "test", "app", App.class);
    assertEquals("Test App", appTest.getName());
    // test.app.version没有定义，应该读取app.version=1.0
    assertEquals("1.0", appTest.getVersion());
    App appProd = Conf.create(conf.getConfig("prod", "app"), App.class);
    assertEquals("App", appProd.getName());
    assertEquals("Test App", conf.getConfig("test", "app").getString("name"));
    // prod.app.name没有定义，应该读取app.name
    assertEquals("App", conf.getConfig("prod", "app").getString("name"));
  }

  @Test
  public void testWebapp() {
    // 读取web-app.properties
    ConfManager mgr = new ConfManager();
    mgr.builder().with(Conf.CONFIG_RESOURCE_BASENAME_KEY, "web-app");
    mgr.update();
    Conf conf = mgr.get();
    assertNotNull(conf);
    // app
    assertEquals("lets.product.webapp", conf.getConfig().getString("app.id"));
    assertEquals("WebApp", conf.getConfig().getString("app.name"));
    assertEquals("1.0", conf.getConfig().getString("app.version"));
    // test.app
    assertEquals("lets.product.webapp.test", conf.getString("test", "app.id"));
    assertEquals("Test WebApp", conf.getString("test", "app.name"));
    assertEquals("1.0", conf.getString("test", "app.version"));
    // prod.app
    assertEquals("lets.product.webapp", conf.getString("prod", "app.id"));
    assertEquals("WebApp", conf.getString("prod", "app.name"));
    assertEquals("1.0", conf.getString("test", "app.version"));
    App app = Conf.create(conf.getConfig("app"), App.class);
    assertEquals("WebApp", app.getName());
    App appTest = Conf.create(conf.getConfig("test", "app"), App.class);
    assertEquals("Test WebApp", appTest.getName());
    App appProd = Conf.create(conf.getConfig("prod", "app"), App.class);
    assertEquals("WebApp", appProd.getName());
  }
}
