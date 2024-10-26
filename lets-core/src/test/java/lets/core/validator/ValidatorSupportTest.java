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

import static org.junit.jupiter.api.Assertions.*;

import lets.core.LoggerSupport;
import lets.core.ResultSupport;
import lets.core.validator.rule.Ipv4Rule;
import org.junit.jupiter.api.Test;

/** ValidatorSupportTest. */
public class ValidatorSupportTest {

  /** The Class TestConstraint. */
  public static class TestConstraint extends RuleConstraint {

    /**
     * Validate.
     *
     * @param value the value
     * @return true, if successful
     */
    @Override
    public boolean validate(Object value) {
      return this.getClass().getName().equals(value.toString());
    }
  }

  /** The Class TestRule. */
  public static class TestRule extends RuleConstraint {

    /**
     * Validate.
     *
     * @param value the value
     * @return true, if successful
     */
    @Override
    public boolean validate(Object value) {
      return this.getClass().getName().equals(value.toString());
    }
  }

  /** The Class TestRuleConstraint. */
  public static class TestRuleConstraint extends RuleConstraint {

    /**
     * Validate.
     *
     * @param value the value
     * @return true, if successful
     */
    @Override
    public boolean validate(Object value) {
      return this.getClass().getName().equals(value.toString());
    }
  }

  /** The Class TestAnnotationRule. */
  @Rule(message = "TestAnnotationMessage")
  public static class TestAnnotationRule extends RuleConstraint {}

  /** Prefer rule name. */
  @Test
  public void preferRuleName() {
    String name = RuleConstraint.preferRuleName("Abc");
    assertEquals("abc", name);
    name = RuleConstraint.preferRuleName(TestConstraint.class.getName());
    assertEquals("test", name);
    name = RuleConstraint.preferRuleName(TestRule.class.getName());
    assertEquals("test", name);
    name = RuleConstraint.preferRuleName(TestRuleConstraint.class.getName());
    assertEquals("test", name);
  }

  /** Rule annotation. */
  @Test
  public void fromClass() {
    RuleConstraint rule = RuleConstraint.fromClass(TestConstraint.class);
    assertEquals("test", rule.name);
    assertTrue(rule.validate(rule.id));
    rule = RuleConstraint.fromClass(TestRule.class);
    assertEquals("test", rule.name);
    assertTrue(rule.validate(rule.id));
    rule = RuleConstraint.fromClass(TestRuleConstraint.class);
    assertEquals("test", rule.name);
    assertTrue(rule.validate(rule.id));
    rule = RuleConstraint.fromClass(TestAnnotationRule.class);
    assertEquals("testAnnotation", rule.name);
    assertEquals("TestAnnotationMessage", rule.message);
    assertTrue(rule.validate(rule.id));
  }

  /** Test validate. */
  @Test
  public void testValidate() {
    ValidatorSupport v = new ValidatorSupport();
    Ipv4Rule ipv4 = new Ipv4Rule();
    assertTrue(ipv4.validate("192.168.1.1"));
    assertFalse(ipv4.validate("192.168.1.a"));
    v.withRules(Ipv4Rule.class);
    assertTrue(v.validate("192.168.1.1"));
    ResultSupport result = v.validateResult("192.168.1.1");
    LoggerSupport.info(
        "value=192.168.1.1 result={} message={}", result.isSuccess(), result.getMessage());
    result = v.validateResult("192.168.1.a");
    LoggerSupport.info(
        "value=192.168.1.a result={} message={}", result.isSuccess(), result.getMessage());
    result = v.validateResult("192.168.1.a");
    LoggerSupport.info(
        "value=192.168.1.a result={} message={}", result.isSuccess(), result.getMessage());
    result = v.validateResult("192.168.1.b");
    LoggerSupport.info(
        "value=192.168.1.b result={} message={}", result.isSuccess(), result.getMessage());
    result = v.validateResult("192.168.1.b");
    LoggerSupport.info(
        "value=192.168.1.b result={} message={}", result.isSuccess(), result.getMessage());
    result = v.validateResult("192.168.1.c");
    LoggerSupport.info(
        "value=192.168.1.c result={} message={}", result.isSuccess(), result.getMessage());
    result = v.validateResult("192.168.1.c");
    LoggerSupport.info(
        "value=192.168.1.c result={} message={}", result.isSuccess(), result.getMessage());
    assertEquals(
        RuleConstraint.fromClass(Ipv4Rule.class).message,
        v.validateResult("192.168.1.a").getMessage());
    // 默认通过设置消息
    RuleConstraint rule = RuleConstraint.fromClass(Ipv4Rule.class);
    assertEquals("Ipv4Rule", rule.name);
    assertEquals("请输入有效的ip地址", rule.message);
    // 通过代码强制设置消息.
    rule.withMessage("请输入有效的IPv4地址");
    rule = RuleConstraint.fromClass(Ipv4Rule.class);
    assertEquals("请输入有效的IPv4地址", rule.message);
    result = v.validateResult("192.168.1.b");
    LoggerSupport.info(
        "value=192.168.1.b result={} message={}", result.isSuccess(), result.getMessage());
    assertEquals("请输入有效的IPv4地址", result.getMessage());
  }
}
