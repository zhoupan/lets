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

import java.util.Properties;
import lets.core.DataResultSupport;
import lets.core.StringUtils;
import lets.core.data.NameValueSupport;

public class PropertiesUtils {

  public static DataResultSupport<CompareResult<NameValueSupport<String, String>>> compare(
      Properties source, Properties target) {
    DataResultSupport<CompareResult<NameValueSupport<String, String>>> result =
        new DataResultSupport<CompareResult<NameValueSupport<String, String>>>();
    CompareResult<NameValueSupport<String, String>> data =
        new CompareResult<NameValueSupport<String, String>>();
    try {
      result.setData(data);
      for (String sourceName : source.stringPropertyNames()) {
        String sourceValue = source.getProperty(sourceName);
        String targetValue = target.getProperty(sourceName);
        if (targetValue == null) {
          // Missing=>Remove
          data.withRemoved(NameValueSupport.of(sourceName, sourceValue));
        } else if (!StringUtils.equals(sourceValue, targetValue)) {
          // Changed
          data.withChanged(NameValueSupport.of(sourceName, targetValue));
        }
      }
      for (String targetName : target.stringPropertyNames()) {
        if (!source.containsKey(targetName)) {
          // Added
          String targetValue = target.getProperty(targetName);
          data.withAdded(NameValueSupport.of(targetName, targetValue));
        }
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
