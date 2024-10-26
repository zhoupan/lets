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

import java.util.HashMap;
import java.util.Map;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

/** StringTemplate. */
public class StringTemplate {

  /** The name. */
  private String name = "";

  /** The variables. */
  private Map<Object, Object> variables = new HashMap<Object, Object>();

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the variables.
   *
   * @param variables the variables
   */
  public void setVariables(Map<Object, Object> variables) {
    this.variables = variables;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the variables.
   *
   * @return the variables
   */
  public Map<Object, Object> getVariables() {
    return variables;
  }

  /**
   * With.
   *
   * @param variables the variables
   * @return the string template
   */
  public StringTemplate with(Map<String, Object> variables) {
    this.variables.putAll(variables);
    return this;
  }

  /**
   * With.
   *
   * @param key the key
   * @param value the value
   * @return the string template
   */
  public StringTemplate with(String key, Object value) {
    this.variables.put(key, value);
    return this;
  }

  /**
   * Render.
   *
   * @param st the st
   * @return the template result
   */
  public TemplateResult render(ST st) {
    TemplateResult result = new TemplateResult();
    try {
      result.setText(StringTemplateUtils.render(st, this.getVariables()));
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Render.
   *
   * @param template the template
   * @return the template result
   */
  public TemplateResult render(String template) {
    TemplateResult result = new TemplateResult();
    try {
      result.setText(StringTemplateUtils.render(template, this.getVariables()));
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Render.
   *
   * @param group the group
   * @param fullName the full name
   * @return the template result
   */
  public TemplateResult render(STGroup group, String fullName) {
    TemplateResult result = new TemplateResult();
    try {
      boolean isDefined = group.isDefined(fullName);
      if (!isDefined) {
        throw new RuntimeException(String.format("Template %s is not defined.", fullName));
      }
      ST st = group.getInstanceOf(fullName);
      return render(st);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Gets the full name.
   *
   * @return the full name
   */
  public String getFullName() {
    if (!this.name.startsWith("/")) {
      return "/" + this.name;
    }
    return this.getName();
  }

  /**
   * Render.
   *
   * @param group the group
   * @return the template result
   */
  public TemplateResult render(STGroup group) {
    return render(group, this.getFullName());
  }
}
