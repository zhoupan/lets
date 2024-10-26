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
package lets.core.datatree;

import java.io.File;
import java.io.IOException;
import lets.core.DataResultSupport;
import lets.core.data.NameValueSupport;
import lets.core.datatree.dom.TreeReaderRegistry;
import lets.core.datatree.dom.TreeWriterRegistry;
import lets.core.datatree.dom.adapters.PropertiesBuiltin;
import lets.core.datatree.dom.adapters.TomlJtoml;
import lets.core.datatree.dom.adapters.XmlBuiltin;
import lets.core.datatree.dom.adapters.YamlJackson;
import lets.core.io.FileUtils;
import lets.core.properties.CompareResult;
import lets.core.properties.PropertiesUtils;
import lets.core.properties.SortedProperties;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/** see: <a href="https://berkesa.github.io/datatree/introduction.html">datatree introduction</a> */
public class TreeUtilsTest {

  @Test
  public void testDataTree() throws IOException {
    Tree v = new Tree();
    v.put("versions.guava", "32.1.3-jre");
    v.put("libraries.guava.module", "com.google.guava:guava");
    v.put("libraries.guava.version.ref", "guava");
    // Default:TreeWriter:JSON
    // toJson
    String json = v.toString();
    System.out.println(json);
    String format = "toml";
    TomlJtoml tomlAdaptger = new TomlJtoml();
    TreeWriterRegistry.setWriter("toml", tomlAdaptger);
    // toToml
    String toml = v.toString(tomlAdaptger);
    System.out.println(toml);
    // PropertiesBuiltin
    PropertiesBuiltin propertiesBuiltinAdapter = new PropertiesBuiltin();
    String props = v.toString(propertiesBuiltinAdapter);
    System.out.println(props);
    String xmlBuildin = v.toString(new XmlBuiltin());
    System.out.println(xmlBuildin);
    // Yaml
    String yamlJackson = v.toString(new YamlJackson());
    System.out.println(yamlJackson);
    // formYamlString
    TreeReaderRegistry.setReader("yaml", new YamlJackson());
    DataResultSupport<Tree> fromYaml = TreeUtils.fromYamlString(yamlJackson);
    Assert.assertTrue(fromYaml.getMessage(), fromYaml.isSuccess());
    SortedProperties sortedProps = new SortedProperties();
    TreeUtils.toProperties(fromYaml.getData(), sortedProps);
    System.out.println(sortedProps.toLines());
    // System.out.println(TreeUtils.toTomlDependenciesFormat(v));

  }

  @Test
  public void testYamlCompare() throws IOException {
    Tree v = new Tree();
    File config = new File("e:\\whbkd\\whbkd-case-shared\\whbkd-case-shared-station\\config\\");
    File applicationYmlFile = new File(config, "application.yml");
    SortedProperties sortedApplicationProps = new SortedProperties();
    DataResultSupport<Tree> fromFile = TreeUtils.fromYamlFile(applicationYmlFile, "UTF-8");
    Assert.assertTrue(fromFile.getMessage(), fromFile.isSuccess());
    TreeUtils.toProperties(fromFile.getData(), sortedApplicationProps);

    File devFile = new File(config, "application-dev.yml");
    fromFile = TreeUtils.fromYamlFile(devFile, "UTF-8");
    Assert.assertTrue(fromFile.getMessage(), fromFile.isSuccess());
    SortedProperties sortedApplicationPropsDev = new SortedProperties();
    TreeUtils.toProperties(fromFile.getData(), sortedApplicationPropsDev);

    File prodFile = new File(config, "application-prod.yml");
    fromFile = TreeUtils.fromYamlFile(prodFile, "UTF-8");
    Assert.assertTrue(fromFile.getMessage(), fromFile.isSuccess());
    SortedProperties sortedApplicationPropsProd = new SortedProperties();
    TreeUtils.toProperties(fromFile.getData(), sortedApplicationPropsProd);

    File localFile = new File(config, "application-local.yml");
    fromFile = TreeUtils.fromYamlFile(localFile, "UTF-8");
    Assert.assertTrue(fromFile.getMessage(), fromFile.isSuccess());
    SortedProperties sortedApplicationPropsLocal = new SortedProperties();
    TreeUtils.toProperties(fromFile.getData(), sortedApplicationPropsLocal);

    sortedApplicationPropsDev.putAll(sortedApplicationProps);
    sortedApplicationPropsProd.putAll(sortedApplicationProps);
    sortedApplicationPropsLocal.putAll(sortedApplicationProps);

    DataResultSupport<CompareResult<NameValueSupport<String, String>>> compared =
        PropertiesUtils.compare(sortedApplicationPropsDev, sortedApplicationPropsProd);
    SortedProperties changed = new SortedProperties();
    if (!compared.getData().getChanged().isEmpty()) {
      for (NameValueSupport<String, String> nv : compared.getData().getChanged()) {
        changed.setProperty(nv.getName(), nv.getValue());
      }
    }
    File changedFile = new File(config, "prod.properties");
    changed.store(changedFile);

    compared = PropertiesUtils.compare(sortedApplicationPropsDev, sortedApplicationPropsLocal);
    changed = new SortedProperties();
    if (!compared.getData().getChanged().isEmpty()) {
      for (NameValueSupport<String, String> nv : compared.getData().getChanged()) {
        changed.setProperty(nv.getName(), nv.getValue());
      }
    }
    changedFile = new File(config, "local.properties");
    changed.store(changedFile);

    DataResultSupport<Tree> devTree = TreeUtils.fromProperties(sortedApplicationPropsDev);
    Assert.assertTrue(devTree.getMessage(), devTree.isSuccess());

    YamlJackson yj = new YamlJackson();
    String yaml = devTree.getData().toString(yj);
    File devFileFull = new File(config, "application-dev-full.yml");
    FileUtils.writeStringToFile(devFileFull, yaml, "UTF-8");
  }
}
