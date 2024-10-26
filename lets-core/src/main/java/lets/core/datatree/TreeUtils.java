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
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import lets.core.DataResultSupport;
import lets.core.StringUtils;
import lets.core.gradle.TomlDependenciesFormatListener;
import lets.core.io.FileUtils;
import lets.core.properties.PropertiesTreeWalker;

public class TreeUtils {
  public static void toProperties(Tree node, Properties props) {
    if (node.isPrimitive()) {
      String key = node.getPath();
      String value = node.asString();
      if (value != null) {
        props.setProperty(key, value);
      }
    } else if (node.isStructure()) {
      for (Tree c : node) {
        toProperties(c, props);
      }
    }
  }

  public static void toTomlDependenciesProperties(Properties props, Properties toml) {

    for (Iterator<Map.Entry<Object, Object>> it = props.entrySet().iterator();
        ((Iterator<?>) it).hasNext(); ) {
      Map.Entry<Object, Object> entry = it.next();
      String key = entry.getKey().toString();
      String value = entry.getValue().toString();
      int countOfDot = StringUtils.countMatches(key, ".");
      if (countOfDot == 0) {
        toml.setProperty(key, value);
      } else if (countOfDot == 1) {
        // versions.guava=32.1.3-jre
        //
        // [versions]
        // guava = "1.0.0"
        String section = StringUtils.substringBefore(key, ".");
        Properties sectionProps = (Properties) toml.get(section);
        if (sectionProps == null) {
          sectionProps = new Properties();
          toml.put(section, sectionProps);
        }
        sectionProps.setProperty(StringUtils.substringAfter(key, "."), value);
      } else {
        // libraries.guava.module=com.google.guava:guava
        // libraries.guava.version.ref=guava

        // [libraries]
        // guava = { module = "com.google.guava:guava", version.ref = "guava" }

        String section = StringUtils.substringBefore(key, "."); // libraries
        String second = StringUtils.substringAfter(key, "."); // guava.version.ref
        String third = StringUtils.substringAfter(second, "."); // version.ref
        second = StringUtils.substringBefore(second, "."); // guava

        Properties sectionProps = (Properties) toml.get(section);
        if (sectionProps == null) {
          sectionProps = new Properties();
          toml.put(section, sectionProps);
        }
        Properties secondProps = (Properties) sectionProps.get(second);
        if (secondProps == null) {
          secondProps = new Properties();
          sectionProps.put(second, secondProps);
        }
        secondProps.setProperty(third, value);
      }
    }
  }

  public static String toTomlDependenciesFormat(Tree node) {
    Properties props = new Properties();
    toProperties(node, props);
    Properties toml = new Properties();
    toTomlDependenciesProperties(props, toml);
    TomlDependenciesFormatListener listener = new TomlDependenciesFormatListener();
    PropertiesTreeWalker walker = new PropertiesTreeWalker();
    walker.walk(toml, listener);
    return listener.getBuilder().toString();
  }

  public static DataResultSupport<Tree> fromYamlString(String yamlString) {
    DataResultSupport<Tree> result = new DataResultSupport<Tree>();
    try {
      Tree tree = new Tree(yamlString, "yaml");
      result.setData(tree);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * From yaml.
   *
   * @param yamlFile the yaml file
   * @param encoding the encoding
   * @return the data result support
   */
  public static DataResultSupport<Tree> fromYamlFile(File yamlFile, String encoding) {
    DataResultSupport<Tree> result = new DataResultSupport<Tree>();
    try {
      String yamlString = FileUtils.readFileToString(yamlFile, encoding);
      return fromYamlString(yamlString);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public static DataResultSupport<Tree> fromProperties(Properties props) {
    DataResultSupport<Tree> result = new DataResultSupport<Tree>();
    try {
      Tree tree = new Tree();
      for (String name : props.stringPropertyNames()) {
        String value = props.getProperty(name);
        tree.put(name, value);
      }
      result.setData(tree);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
