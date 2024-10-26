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
package lets.core.validator.rule;

import lets.core.RegExUtils;
import lets.core.StringUtils;
import lets.core.validator.RuleConstraint;

/**
 * RegExRule.
 *
 * @author zhoupan
 */
public class RegExRule extends RuleConstraint {

  /** The regex. */
  public String regex;

  /**
   * With regex.
   *
   * @param value the value
   * @return the reg ex rule constraint
   */
  public RegExRule withRegex(String value) {
    this.regex = value;
    return this;
  }

  /**
   * Validate.
   *
   * @param value the value
   * @return true, if successful
   */
  @Override
  public boolean validate(Object value) {
    if (StringUtils.isNotBlank(this.regex) && (value != null)) {
      return RegExUtils.compileOrGet(this.regex).matcher(value.toString()).matches();
    }
    return super.validate(value);
  }
}
