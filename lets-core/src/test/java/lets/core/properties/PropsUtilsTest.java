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

import java.util.Properties;
import jodd.props.Props;
import org.junit.jupiter.api.Test;

public class PropsUtilsTest {

  @Test
  public void howPropsWorks() {
    // Jodd Props is compatible with Java properties.
    Properties properties = new Properties();
    properties.setProperty("app.id", "demo");
    properties.setProperty("app.name", "Demo");
    properties.setProperty("app.site.url", "https://${app.id}.example.com");
    Props props = new Props();
    props.load(properties);

    assertEquals("demo", props.getValue("app.id"));
    assertEquals("Demo", props.getValue("app.name"));
    // Macros
    // The biggest Props strength are macros.
    // Macro is a reference to a value of some other key.
    // Macros are enclosed between ${ and }. Here is a simple example:
    assertEquals("https://demo.example.com", props.getValue("app.site.url"));

    // Section name is enclosed between [ and ].
    // Properties following a section definition belong to that section.
    // Section name is added as a prefix to section properties.
    // Section ends with empty section definition [] or with a new section start or end of the file.
    String sectionExample = "[app]\nid=demo\nname=Demo\nsite.url=https://${app.id}.example.com";
    props = new Props();
    props.load(sectionExample);
    assertEquals("demo", props.getValue("app.id"));
    assertEquals("Demo", props.getValue("app.name"));
    assertEquals("https://demo.example.com", props.getValue("app.site.url"));
  }
}
