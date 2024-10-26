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

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValue;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import lets.core.CoreUtils;
import lets.core.StringUtils;

public class Conf {
  public static final String CONFIG_RESOURCE_BASENAME_KEY = "config.resourceBasename";
  public static final String CONFIG_RESOURCE_BASENAME_DEFAULT = "application";
  public static final String CONFIG_OVERRIDE_WITH_ENV_PROPERTY_NAME =
      "config.override_with_env_vars";

  private final Config config;

  public Conf(Config config) {
    super();
    this.config = config;
  }

  public Config getConfig() {
    return config;
  }

  public Config getConfig(String path) {
    return this.getConfig(path, false);
  }

  public Config getConfig(String path, boolean lookup) {
    if (this.config.hasPath(path)) {
      return this.config.getConfig(path);
    }
    if (lookup) {
      String p = path;
      while (StringUtils.contains(p, ".")) {
        p = StringUtils.substringAfter(p, ".");
        if (this.config.hasPath(p)) {
          return this.config.getConfig(p);
        }
      }
    }
    return this.config;
  }

  public Config getConfig(String prefix, String path) {
    String finalPath = String.format("%s.%s", prefix, path);
    if (this.config.hasPath(finalPath)) {
      return this.config.getConfig(finalPath);
    }
    return this.config.getConfig(path);
  }

  public String getString(String prefix, String path) {
    String finalPath = String.format("%s.%s", prefix, path);
    if (this.config.hasPath(finalPath)) {
      return this.config.getString(finalPath);
    }
    return this.config.getString(path);
  }

  public static <T> T create(Config config, Class<T> clazz) {
    T object = CoreUtils.getClassInstanceQuiet(clazz);
    mergeConfigToBean(config, object);
    return object;
  }

  public static <T> T create(Config config, String prefix, String path, Class<T> clazz) {
    T object = CoreUtils.getClassInstanceQuiet(clazz);
    merge(config, prefix, path, object);
    return object;
  }

  public static void merge(Config config, String prefix, String path, Object configBean) {
    String finalPath = String.format("%s.%s", prefix, path);
    if (config.hasPath(path)) {
      mergeConfigToBean(config.getConfig(path), configBean);
    }
    if (config.hasPath(finalPath)) {
      mergeConfigToBean(config.getConfig(finalPath), configBean);
    }
  }

  public static void mergeConfigToBean(Config config, Object configBean) {
    CoreUtils.overrideProperties(configBean, toProperties(config));
  }

  public static void mergeConfigPathToBean(Config config, String configPath, Object configBean) {
    if (config.hasPath(configPath)) {
      mergeConfigToBean(config.getConfig(configPath), configBean);
    }
  }

  public static Properties toProperties(Config config) {
    Properties props = new Properties();
    for (Iterator<Entry<String, ConfigValue>> it = config.entrySet().iterator(); it.hasNext(); ) {
      Entry<String, ConfigValue> entry = it.next();
      props.put(entry.getKey(), entry.getValue().unwrapped());
    }
    return props;
  }
}
