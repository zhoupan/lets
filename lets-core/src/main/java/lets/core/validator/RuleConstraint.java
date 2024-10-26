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

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;
import lets.core.ClassUtils;
import lets.core.CoreUtils;
import lets.core.LoggerSupport;
import lets.core.StringUtils;

/**
 * RuleConstraint.
 *
 * @author zhoupan
 */
public class RuleConstraint implements ValidationConstraint<Rule>, Validator {

  /** The targets. */
  private static Map<Class<?>, RuleConstraint> caches =
      new ConcurrentHashMap<Class<?>, RuleConstraint>();

  /**
   * From class.
   *
   * @param target the target
   * @return the rule constraint
   */
  public static RuleConstraint fromClass(Class<?> target) {
    if (caches.containsKey(target)) {
      return caches.get(target);
    }
    RuleConstraint instance = new RuleConstraint().withClass(target);
    caches.put(target, instance);
    return instance;
  }

  /** The id. */
  public String id = "";

  /** The name. */
  public String name = "";

  /** The message. */
  public String message = "";

  /** The impl. */
  private Object impl;

  /** The impl validator. */
  private Validator implValidator;

  /** The impl validate method. */
  private Method implValidateMethod;

  /** Instantiates a new rule constraint. */
  public RuleConstraint() {
    super();
  }

  /**
   * Prefer rule name.
   *
   * @param input the input
   * @return the string
   */
  public static String preferRuleName(String input) {
    String fullName = input;
    if (StringUtils.contains(fullName, "$")) {
      fullName = StringUtils.substringAfterLast(fullName, "$");
    }

    if (StringUtils.contains(fullName, ".")) {
      fullName = StringUtils.substringAfterLast(fullName, ".");
    }

    if (StringUtils.endsWith(fullName, "Constraint")) {
      fullName = StringUtils.substringBeforeLast(fullName, "Constraint");
    }

    if (StringUtils.endsWith(fullName, "Rule")) {
      fullName = StringUtils.substringBeforeLast(fullName, "Rule");
    }

    fullName = StringUtils.uncapitalize(fullName);
    return StringUtils.isNotEmpty(fullName) ? fullName : input;
  }

  /**
   * With id.
   *
   * @param value the value
   * @return the rule constraint
   */
  public Validator withId(String value) {
    this.id = value;
    return this;
  }

  /**
   * With name.
   *
   * @param value the value
   * @return the rule constraint
   */
  public Validator withName(String value) {
    this.name = value;
    return this;
  }

  /**
   * With message.
   *
   * @param value the value
   * @return the rule constraint
   */
  public Validator withMessage(String value) {
    this.message = value;
    return this;
  }

  /**
   * With class.
   *
   * @param target the target
   * @return the rule constraint
   */
  public RuleConstraint withClass(Class<?> target) {
    this.id = target.getName();
    this.name = preferRuleName(target.getSimpleName());
    if (target.isAnnotationPresent(Rule.class)) {
      Rule rule = target.getAnnotation(Rule.class);
      this.withRule(rule);
    }
    try {
      this.impl = ClassUtils.instantiate(target);
      if (this.impl instanceof Validator) {
        this.implValidator = (Validator) this.impl;
      } else {
        try {
          this.implValidateMethod = ClassUtils.getPublicMethod(target, "validate", Object.class);
        } catch (Throwable e) {
          // ignore
          CoreUtils.checkState(
              false,
              "target class should implements Validator interface or provider validate(Object value) method.");
        }
      }
    } catch (Throwable e) {
      LoggerSupport.error("{}", e);
    }
    return this;
  }

  /**
   * With rule.
   *
   * @param rule the rule
   * @return the rule constraint
   */
  public Validator withRule(Rule rule) {
    if (rule != null) {
      String ruleId = rule.id();
      String ruleName = rule.name();
      String ruleMessage = rule.message();
      if (StringUtils.isNotEmpty(ruleId)) {
        this.withId(ruleId);
      }
      if (StringUtils.isNotEmpty(ruleName)) {
        this.withName(ruleName);
      }
      if (StringUtils.isNotEmpty(ruleMessage)) {
        this.withMessage(ruleMessage);
      }
    }
    return this;
  }

  /**
   * Configure.
   *
   * @param rule the rule
   */
  @Override
  public void configure(Rule rule) {
    this.id = rule.id();
    this.name = rule.name();
    this.message = rule.message();
  }

  /**
   * Checks if is valid.
   *
   * @param vcc the vcc
   * @param value the value
   * @return true, if is valid
   */
  @Override
  public boolean isValid(ValidationConstraintContext vcc, Object value) {
    return this.validate(value);
  }

  /**
   * Validate.
   *
   * @param value the value
   * @return true, if successful
   */
  @Override
  public boolean validate(Object value) {
    if (this.implValidator != null) {
      return this.implValidator.validate(value);
    }
    if (this.implValidateMethod != null) {
      try {
        return (boolean) this.implValidateMethod.invoke(this.impl, value);
      } catch (Throwable e) {
        // ignore
        LoggerSupport.error("implValidateMethod.invoke(this.impl,value) throw exception :{}", e);
      }
    }
    return true;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "RuleConstraint [id=" + id + ", name=" + name + ", message=" + message + "]";
  }
}
