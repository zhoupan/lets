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

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import lets.core.StringUtils;

public class PropertiesTreeWalker {

  public void walk(Properties props, IPropertiesTreeListener listener) {
    walk(null, props, listener, 0);
  }

  public void walk(String name, Properties props, IPropertiesTreeListener listener, int level) {
    boolean hasName = StringUtils.isNotEmpty(name);
    if (hasName) {
      listener.enter(name, props, level);
    } else {
      listener.enter(props, level);
    }

    for (Iterator<Entry<Object, Object>> it = props.entrySet().iterator(); it.hasNext(); ) {
      Entry<Object, Object> entry = it.next();
      Object key = entry.getKey();
      Object value = entry.getValue();
      if (value instanceof Properties) {
        Properties valueProps = (Properties) value;
        walk(key.toString(), valueProps, listener, level + 1);
      } else {
        listener.enter(key.toString(), value, level);
        listener.exit(key.toString(), value, level);
      }
    }
    if (hasName) {
      listener.exit(name, props, level);
    } else {
      listener.exit(props, level);
    }
  }
}
