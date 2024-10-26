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
import com.typesafe.config.ConfigFactory;
import java.util.Properties;
import lets.core.ResultSupport;
import lets.core.app.AppManager;
import lets.core.properties.PropertiesBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * see: <a href="https://github.com/lightbend/config">config</a>
 *
 * @author zhoupan
 */
public class ConfManager extends AppManager<Conf> {

  /** The logger. */
  private final Logger logger = LoggerFactory.getLogger(getClass());

  public Logger getLogger() {
    return logger;
  }

  public ConfManager() {
    this(PropertiesBuilder.of(System.getProperties()));
  }

  public ConfManager(Properties props) {
    this(PropertiesBuilder.of(props));
  }

  public ConfManager(PropertiesBuilder builder) {
    super(builder);
  }

  /**
   * Creates the.
   *
   * @param props the props
   * @return the conf
   */
  @Override
  public Conf create(Properties props) {
    Config config = onLoadConfig(props);
    Conf conf = new Conf(config);
    return conf;
  }

  /**
   * Standard behavior The convenience method ConfigFactory.load() loads the following (first-listed
   * are higher priority): <code>system properties
   * application.conf (all resources on classpath with this name)
   * application.json (all resources on classpath with this name)
   * application.properties (all resources on classpath with this name)
   * reference.conf (all resources on classpath with this name)
   * The idea is that libraries and frameworks should ship with a reference.conf in their jar.
   * </code> Applications should provide an application.conf, or if they want to create multiple
   * configurations in a single JVM, they could use ConfigFactory.load("myapp") to load their own
   * myapp.conf.
   *
   * @param props
   * @return
   */
  public Config onLoadConfig(Properties props) {
    PropertiesBuilder pb = PropertiesBuilder.of(props);
    String resourceBasename =
        pb.getStringProperty(
            Conf.CONFIG_RESOURCE_BASENAME_KEY, Conf.CONFIG_RESOURCE_BASENAME_DEFAULT);
    Config config = ConfigFactory.load(resourceBasename);
    return config;
  }

  /**
   * Close.
   *
   * @param object the object
   * @return the result support
   */
  @Override
  public ResultSupport close(Conf object) {
    ResultSupport result = new ResultSupport();
    return result;
  }
}
