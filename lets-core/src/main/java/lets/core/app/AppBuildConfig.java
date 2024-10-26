/*
 * Copyright (c) 2021 zhoupan (https://github.com/zhoupan).
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
package lets.core.app;

import java.util.Properties;
import lets.core.CoreUtils;
import lets.core.properties.SortedProperties;

/** The Class AppBuildConfig. */
public class AppBuildConfig {

  /** The debug. */
  public boolean debug = true;

  /** The application id. */
  public String applicationId;

  /** The build type. */
  public String buildType = "debug";

  /** The version code. */
  public int versionCode = 1;

  /** The version name. */
  public String versionName = "1.0.0";

  /** The rest service base url. */
  public String restServiceBaseUrl;

  /** The props. */
  public final Properties props = new Properties();

  /** The print to system out. */
  public boolean printToSystemOut = true;

  /** The print to system file. */
  public boolean printToSystemFile = true;

  /**
   * Apply props.
   *
   * @param lines the lines
   * @param lineEnds the line ends
   */
  public void applyProps(String lines, String lineEnds) {
    this.applyProps(SortedProperties.fromLines(lines, lineEnds));
  }

  /**
   * Apply props.
   *
   * @param props the props
   */
  public void applyProps(Properties props) {
    this.props.putAll(props);
    CoreUtils.extend(this, props);
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "AppBuildConfig [debug="
        + debug
        + ", applicationId="
        + applicationId
        + ", buildType="
        + buildType
        + ", versionCode="
        + versionCode
        + ", versionName="
        + versionName
        + ", restServiceBaseUrl="
        + restServiceBaseUrl
        + ", props="
        + props
        + "]";
  }
}
