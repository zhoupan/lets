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
package lets.core;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;

/**
 * DecimalSupport.
 *
 * <pre>
 * 1.四舍五入
 * 2.默认保留两位小数 DecimalSupport decimal = new DecimalSupport();
 * 3.可以定制保留几位小数 例如:保留3位小数 DecimalSupport decimal = new DecimalSupport(3);
 * <code>
 * DecimalSupport decimal = new DecimalSupport();
 * BigDecimal round = decimal.round(new BigDecimal("3.1415167"));
 * LogSupport.debug("round:{}->{}", new BigDecimal("3.1415167"), round);
 * LogSupport.debug("multiple:{}*3->{}", new BigDecimal("3.1415167"),decimal.multiple(new BigDecimal("3.1415167"), new BigDecimal("3")));
 * LogSupport.debug("divide:{}/3->{}", new BigDecimal("3.1415167"),decimal.divide(new BigDecimal("3.1415167"), new BigDecimal("3")));
 * LogSupport.debug("add:{}+{}->{}", new BigDecimal("3.1415167"), new BigDecimal("3.1415167"),decimal.add(new BigDecimal("3.1415167"), new BigDecimal("3.1415167")));
 * LogSupport.debug("subtract:{}-{}->{}", new BigDecimal("3.1415167"), new BigDecimal("1.1815167"),decimal.subtract(new BigDecimal("3.1415167"), new BigDecimal("1.1815167")));
 * </code>
 *
 * <pre>
 * round:3.1415167->3.14
 * multiple:3.1415167*3->9.42
 * divide:3.1415167/3->1.05
 * add:3.1415167+3.1415167->6.28
 * subtract:3.1415167-1.1815167->1.96
 * </pre>
 *
 * @author zhoupan
 */
public class DecimalSupport {

  /** The Constant caches. */
  private static final Map<Integer, DecimalSupport> caches =
      new java.util.concurrent.ConcurrentHashMap<Integer, DecimalSupport>();

  /**
   * Gets the scale.
   *
   * @param scale the scale
   * @return the scale
   */
  public static DecimalSupport getInstance(int scale) {
    if (caches.containsKey(scale)) {
      return caches.get(scale);
    }
    DecimalSupport obj = new DecimalSupport(scale);
    caches.put(scale, obj);
    return obj;
  }

  /** 默认保留几位小数. */
  public static final int SCALE_DEFAULT = 2;

  /** The math context. */
  private MathContext mathContext = MathContext.DECIMAL32;

  /** 保留一位小数. */
  private int scale = SCALE_DEFAULT;

  /** 四舍五入. */
  private int roundingMode = BigDecimal.ROUND_HALF_UP;

  /** Instantiates a new decimal support. */
  public DecimalSupport() {
    this(SCALE_DEFAULT);
  }

  /**
   * Instantiates a new decimal support.
   *
   * @param scale the scale
   */
  public DecimalSupport(int scale) {
    super();
    this.scale = scale;
  }

  /**
   * Gets the math context.
   *
   * @return the math context
   */
  public MathContext getMathContext() {
    return mathContext;
  }

  /**
   * Sets the math context.
   *
   * @param mathContext the new math context
   */
  public void setMathContext(MathContext mathContext) {
    this.mathContext = mathContext;
  }

  /**
   * Multiple.
   *
   * @param items the items
   * @return the big decimal
   */
  public BigDecimal multiple(BigDecimal... items) {
    BigDecimal result = BigDecimal.ONE;
    for (BigDecimal item : items) {
      result = result.multiply(this.round(item), this.mathContext);
    }
    return this.round(result);
  }

  /**
   * Divide.
   *
   * @param items the items
   * @return the big decimal
   */
  public BigDecimal divide(BigDecimal... items) {
    CoreUtils.checkState((items != null) && (items.length > 1), "必须指定至少两个数(除数和被除数)");
    BigDecimal result = null;
    for (BigDecimal item : items) {
      if (result == null) {
        result = item;
      } else {
        result = result.divide(this.round(item), this.mathContext);
      }
    }
    return this.round(result);
  }

  /**
   * Adds the.
   *
   * @param items the items
   * @return the big decimal
   */
  public BigDecimal add(BigDecimal... items) {
    BigDecimal result = BigDecimal.ZERO;
    for (BigDecimal item : items) {
      result = result.add(this.round(item));
    }
    return this.round(result);
  }

  /**
   * Subtract the.
   *
   * @param items the items
   * @return the big decimal
   */
  public BigDecimal subtract(BigDecimal... items) {
    CoreUtils.checkState((items != null) && (items.length > 1), "必须指定至少两个数(减数和被减数)");
    BigDecimal result = null;
    for (BigDecimal item : items) {
      if (result == null) {
        result = item;
      } else {
        result = result.subtract(this.round(item));
      }
    }
    return this.round(result);
  }

  /**
   * Round.
   *
   * @param item the item
   * @return the big decimal
   */
  public BigDecimal round(BigDecimal item) {
    return item.divide(BigDecimal.ONE, this.scale, this.roundingMode);
  }
}
