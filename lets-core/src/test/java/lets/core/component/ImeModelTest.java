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
package lets.core.component;

import static org.junit.jupiter.api.Assertions.*;

import lets.core.DataResultSupport;
import lets.core.LoggerSupport;
import lets.core.RegExUtils;
import lets.core.ResultSupport;
import lets.core.component.ImeModel.ImeModelCancelListener;
import lets.core.component.ImeModel.ImeModelChangedListener;
import lets.core.component.ImeModel.ImeModelConfirmListener;
import org.junit.jupiter.api.Test;

/** The Class ImeModelTest. */
public class ImeModelTest
    implements ImeModelConfirmListener, ImeModelCancelListener, ImeModelChangedListener {

  /** The confirm. */
  public String confirm = "";

  /** The cancel. */
  public String cancel = "";

  /** The changed. */
  public String changed = "";

  /**
   * On cancel.
   *
   * @param t the t
   */
  @Override
  public void onCancel(ImeModel t) {
    cancel = t.value();
  }

  /**
   * On changed.
   *
   * @param t the t
   */
  @Override
  public void onChanged(ImeModel t) {
    this.changed = t.value();
  }

  /**
   * On confirm.
   *
   * @param t the t
   */
  @Override
  public void onConfirm(ImeModel t) {
    this.confirm = t.value();
  }

  /** Test ime model tag handlers. */
  @Test
  public void testImeModelTagHandlers() {
    ImeModel imeModel = ImeModel.create();
    DataResultSupport<String> result = imeModel.tag("0");
    assertTrue(result.isSuccess());
    assertEquals("0", imeModel.value());
    result = imeModel.tag("1");
    assertTrue(result.isSuccess());
    assertEquals("01", imeModel.value());
    result = imeModel.tag("DEL");
    assertTrue(result.isSuccess());
    assertEquals("0", imeModel.value());
    result = imeModel.tag("DEL");
    assertTrue(result.isSuccess());
    assertEquals("", imeModel.value());
    result = imeModel.tag("1");
    imeModel.tag(ImeModel.NumberSignedTagHandler.INSTANCE.tag);
    assertEquals("-1", imeModel.value());
    result = imeModel.tag(ImeModel.NumberSignedTagHandler.INSTANCE.tag);
    assertEquals("1", imeModel.value());
    imeModel.value("");
    String[] ips = new String[] {"1", "9", "2", ".", "1", "6", "8", ".", "1", ".", "1"};
    for (String tag : ips) {
      imeModel.tag(tag);
    }
    assertEquals("192.168.1.1", imeModel.builder.toString());
    imeModel.addConfirmListener(this);
    imeModel.addCancelListener(this);
    imeModel.addChangedListener(this);
    imeModel.value("");
    result = imeModel.tags(ips);
    assertEquals("192.168.1.1", imeModel.builder.toString());
    imeModel.tag(ImeModel.OkTagHandler.INSTANCE.tag);
    assertEquals("192.168.1.1", this.confirm);
  }

  /** Test ime mode integer min max. */
  @Test
  public void testImeModeIntegerMinMax() {
    ImeModel imeModel = ImeModel.createInteger(false);
    imeModel.config.max(10);
    imeModel.config.min(1);
    imeModel.config.validateOnTag = true;
    imeModel.fireImeModeConfigChange();
    DataResultSupport<String> result = imeModel.tag("1");
    assertTrue(result.isSuccess());
    assertEquals("1", result.getData());
    result = imeModel.tag("1");
    assertFalse(result.isSuccess());
    assertEquals("1", result.getData());
    result = imeModel.tag(ImeModel.OkTagHandler.INSTANCE.tag);
    assertTrue(result.isSuccess());
    assertEquals("1", result.getData());
    assertEquals("1", imeModel.value());
  }

  /** Test ime model validate. */
  @Test
  public void testImeModelValidate() {
    // String
    ImeModel imeModel = ImeModel.create();
    // MaxLength
    imeModel.config.maxLength(3);
    imeModel.fireImeModeConfigChange();
    imeModel.validateOnTag.set(true);
    assertTrue(imeModel.validate("1").isSuccess());
    assertTrue(imeModel.validate("12").isSuccess());
    assertTrue(imeModel.validate("123").isSuccess());
    assertFalse(imeModel.validate("1234").isSuccess());
    DataResultSupport<String> result = imeModel.tag("1");
    assertTrue(result.isSuccess());
    assertEquals("1", result.getData());
    result = imeModel.tag("2");
    assertEquals("12", result.getData());
    result = imeModel.tag("3");
    assertEquals("123", result.getData());
    result = imeModel.tag("4");
    assertEquals("123", imeModel.value());
    // wildcard
    imeModel.config.resetConstraints();
    imeModel.config.wildcard("*.*.*.*");
    imeModel.fireImeModeConfigChange();
    assertFalse(imeModel.validate("1.1.1").isSuccess());
    assertTrue(imeModel.validate("192.168.1.1").isSuccess());
    // regex
    imeModel.label.set("IPv4");
    imeModel.config.resetConstraints();
    imeModel.config.regex(RegExUtils.REGEX_IPV4_ADDRESS);
    imeModel.fireImeModeConfigChange();
    assertFalse(imeModel.validate("1.1.1").isSuccess());
    assertTrue(imeModel.validate("192.168.1.1").isSuccess());
    ResultSupport r = imeModel.validate("1.1.1");
    if (!r.isSuccess()) {
      LoggerSupport.error("validate:message={}", r.getMessage());
    }
    // Integer+Singed
    imeModel = ImeModel.createInteger(true);
    imeModel.tag("1");
    result = imeModel.tag(".");
    assertFalse(result.isSuccess());
    assertEquals("1", imeModel.value());
    result = imeModel.tagNumberSigned();
    assertTrue(result.isSuccess());
    assertEquals("-1", imeModel.value());
    result = imeModel.tagNumberSigned();
    assertTrue(result.isSuccess());
    assertEquals("1", imeModel.value());
    // Integer+Singed
    imeModel = ImeModel.createInteger(false);
    imeModel.tag("1");
    result = imeModel.tag(".");
    assertFalse(result.isSuccess());
    assertEquals("1", imeModel.value());
    result = imeModel.tagNumberSigned();
    assertFalse(result.isSuccess());
    assertEquals("1", imeModel.value());
    // BigDecimal scale
    imeModel = ImeModel.createBigDecimal(1);
    imeModel.tag("1");
    result = imeModel.tag(".");
    assertTrue(result.isSuccess());
    assertEquals("1.", imeModel.value());
    imeModel.validateOnTag.set(true);
    ResultSupport v = imeModel.validate("1..");
    assertFalse(v.isSuccess());
    result = imeModel.tag(".");
    assertEquals("1.", imeModel.value());
    result = imeModel.tag("1");
    assertEquals("1.1", imeModel.value());
    result = imeModel.tag("2");
    assertFalse(result.isSuccess());
    assertEquals("1.1", imeModel.value());
  }
}
