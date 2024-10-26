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
package lets.core.validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jodd.vtor.Check;
import jodd.vtor.ValidationContext;
import jodd.vtor.Violation;
import jodd.vtor.Vtor;
import lets.core.CoreUtils;
import lets.core.LoggerSupport;
import lets.core.ResultSupport;
import lets.core.StringUtils;

/**
 * ValidatorSupport. 简化验证过程及结果返回
 *
 * @author zhoupan
 */
public class ValidatorSupport {

  /** The Constant VALUE. */
  private static final String VALUE = "value";

  /** The vc. */
  private final ValidationContext vc = new ValidationContext();

  /**
   * Validate.
   *
   * @param value the value
   * @return true, if successful
   */
  public boolean validate(Object value) {
    Map<String, Object> bean = new HashMap<String, Object>();
    bean.put(VALUE, value);
    Vtor vtor = Vtor.create();
    List<Violation> items = vtor.validate(this.vc, bean);
    return CoreUtils.isEmpty(items);
  }

  /**
   * Validate result.
   *
   * @param value the value
   * @return the result support
   */
  public ResultSupport validateResult(Object value) {
    ResultSupport result = new ResultSupport();
    try {
      // validate
      Map<String, Object> bean = new HashMap<String, Object>();
      bean.put(VALUE, value);
      Vtor vtor = Vtor.create();
      List<Violation> items = vtor.validate(this.vc, bean);

      // success
      result.setSuccess(CoreUtils.isEmpty(items));

      // message
      StringBuilder sb = new StringBuilder();
      if (CoreUtils.isNotEmpty(items)) {
        int index = 0;
        for (Violation v : items) {
          index++;
          LoggerSupport.debug(
              "{} value:{} constraint:{}", index, value, v.getCheck().getConstraint());
          if (v.getConstraint() instanceof RuleConstraint) {
            RuleConstraint rule = (RuleConstraint) v.getConstraint();
            if (StringUtils.isNotEmpty(rule.message)) {
              sb.append(rule.message);
            }
          }
        }
      }
      result.setMessage(sb.toString());
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * With rules.
   *
   * @param rules the rules
   * @return the validator support
   */
  public ValidatorSupport withRules(RuleConstraint... rules) {
    if (rules != null) {
      for (RuleConstraint rule : rules) {
        LoggerSupport.info("withRule:{}", rule);
        this.vc.add(new Check(VALUE, rule));
      }
    }
    return this;
  }

  /**
   * With rules.
   *
   * @param clasz the clasz
   * @return the validator support
   */
  public ValidatorSupport withRules(Class<?>... clasz) {
    if (clasz != null) {
      for (Class<?> cls : clasz) {
        try {
          RuleConstraint rule = RuleConstraint.fromClass(cls);
          this.withRules(rule);
        } catch (Throwable e) {
          LoggerSupport.error(e);
        }
      }
    }
    return this;
  }
}
