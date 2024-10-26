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

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Map.Entry;
import jodd.bean.BeanUtil;
import lets.core.LoggerSupport;
import lets.core.StringUtils;
import org.junit.jupiter.api.Test;

public class PropertiesBuilderTest {

  @Test
  public void testWithFlatNested() {
    App app = new App();
    app.setId("demo");
    app.setName("Demo App");
    Site site = new Site();
    site.setId("demo.site");
    site.setName("demo.site");
    site.setUrl("www.demo.site");
    Node node = new Node();
    node.setId("node.site");
    node.setName("node.site");
    node.setHost("localhost");
    node.setPort(80);
    site.setNode(node);
    app.setSite(site);
    PropertiesBuilder pb = new PropertiesBuilder();
    pb.with("app", app, true);
    SortedProperties props = pb.buildSorted();
    System.out.println(props.toLines());
    assertEquals(app.getId(), props.getProperty("app.id"));
    assertEquals(site.getId(), props.getProperty("app.site.id"));
    assertEquals(node.getId(), props.getProperty("app.site.node.id"));
    Developer one = new Developer();
    one.setName("one");
    one.setEmail("one@demo.site");
    Developer two = new Developer();
    two.setName("two");
    two.setEmail("two@demo.site");
    // array,list
    app.setDeveloperArray(new Developer[] {one, two});
    app.setDeveloperList(Arrays.asList(app.getDeveloperArray()));
    pb = new PropertiesBuilder();
    pb.with("app", app, true);
    props = pb.buildSorted();
    System.out.println(props.toLines());
    assertEquals(app.getId(), props.getProperty("app.id"));
    assertEquals(site.getId(), props.getProperty("app.site.id"));
    assertEquals(node.getId(), props.getProperty("app.site.node.id"));
    App newApp = new App();
    for (Entry<Object, Object> entry : props.entrySet()) {
      LoggerSupport.info("Entry key={} value={}", entry.getKey(), entry.getValue());
      String key = StringUtils.substringAfter(entry.getKey().toString(), "app.");
      String value = entry.getValue().toString();
      try {
        BeanUtil.forced.setProperty(newApp, key, value);
      } catch (Throwable e) {
        LoggerSupport.error("setProperty key={} value={} {}", key, value, e);
      }
    }
    pb = new PropertiesBuilder();
    pb.with("newApp", newApp, true);
    props = pb.buildSorted();
    System.out.println(props.toLines());
    assertNotNull(newApp.getDeveloperArray());
    assertNotNull(newApp.getDeveloperList());
    assertEquals(2, newApp.getDeveloperArray().length);
    assertEquals(2, newApp.getDeveloperList().size());
  }
}
