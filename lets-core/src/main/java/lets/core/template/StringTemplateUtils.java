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
package lets.core.template;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.stringtemplate.v4.ST;

/** StringTemplateUtils. */
public class StringTemplateUtils {

  /**
   * Render.
   *
   * @param template the template
   * @param contexts the contexts
   * @return the string
   */
  public static String render(String template, Map<Object, Object> contexts) {
    ST st = new ST(template);
    return render(st, contexts);
  }

  /**
   * Render.
   *
   * @param st the st
   * @param contexts the contexts
   * @return the string
   */
  public static String render(ST st, Map<Object, Object> contexts) {
    for (Iterator<Entry<Object, Object>> it = contexts.entrySet().iterator(); it.hasNext(); ) {
      Entry<Object, Object> entry = it.next();
      st.add(entry.getKey().toString(), entry.getValue());
    }
    return st.render();
  }

  /**
   * Render.
   *
   * @param template the template
   * @param contexts the contexts
   * @param tagStart the tag start
   * @param tagEnd the tag end
   * @return the string
   */
  public static String render(
      String template, Map<Object, Object> contexts, char tagStart, char tagEnd) {
    ST st = new ST(template, tagStart, tagEnd);
    return render(st, contexts);
  }
}
