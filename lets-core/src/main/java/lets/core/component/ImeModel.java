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

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Pattern;
import jodd.util.Wildcard;
import jodd.vtor.Check;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;
import jodd.vtor.ValidationContext;
import jodd.vtor.Violation;
import jodd.vtor.Vtor;
import jodd.vtor.constraint.MaxLengthConstraint;
import jodd.vtor.constraint.MinLengthConstraint;
import jodd.vtor.constraint.NotBlankConstraint;
import jodd.vtor.constraint.WildcardMatchConstraint;
import lets.core.CoreUtils;
import lets.core.DataResultSupport;
import lets.core.DecimalSupport;
import lets.core.LoggerSupport;
import lets.core.MutableValue;
import lets.core.NumberUtils;
import lets.core.Range;
import lets.core.ResultSupport;
import lets.core.StringUtils;
import lets.core.contraint.GreaterEqualConstraint;
import lets.core.contraint.LessEqualConstraint;
import lets.core.event.EventListenerList;
import lets.core.event.OnCancelListener;
import lets.core.event.OnChangedListener;
import lets.core.event.OnConfirmListener;

/** The Class ImeModel. */
public class ImeModel {

  /** The Class ImeModelConfig. */
  @SuppressWarnings("rawtypes")
  public static class ImeModelConfig implements ValidationConstraint {

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
      return "ImeModelConfig [minLength="
          + minLength
          + ", maxLength="
          + maxLength
          + ", min="
          + min
          + ", max="
          + max
          + ", wildcard="
          + wildcard
          + ", regex="
          + regex
          + ", allowChars="
          + allowChars
          + ", classType="
          + classType
          + ", numberScale="
          + numberScale
          + ", validateOnTag="
          + validateOnTag
          + "]";
    }

    /** The min length. */
    public Integer minLength;

    /** The max length. */
    public Integer maxLength;

    /** The min. */
    public Double min;

    /** The max. */
    public Double max;

    /** The wildcard. */
    public String wildcard;

    /** The regex. */
    public String regex;

    /** The allow chars. */
    public String allowChars;

    /** The class type. */
    public String classType;

    /** The number scale. */
    public Integer numberScale;

    /** The validate on tag. */
    public boolean validateOnTag;

    /** The signed. */
    public boolean signed;

    /** The data type. */
    public DataType dataType;

    /** The message. */
    public StringBuilder message = new StringBuilder();

    /**
     * Reset constraints.
     *
     * @return the ime model config
     */
    public ImeModelConfig resetConstraints() {
      this.minLength = null;
      this.maxLength = null;
      this.min = null;
      this.max = null;
      this.wildcard = null;
      this.regex = null;
      this.allowChars = null;
      this.validateOnTag = false;
      this.signed = false;
      this.message = new StringBuilder();
      return this;
    }

    /**
     * For integer.
     *
     * @return the ime model config
     */
    public ImeModelConfig forInteger() {
      this.classType(Integer.class);
      return this;
    }

    /**
     * Min length.
     *
     * @param value the value
     * @return the ime model config
     */
    public ImeModelConfig minLength(int value) {
      this.minLength = value;
      return this;
    }

    /**
     * Max length.
     *
     * @param value the value
     * @return the ime model config
     */
    public ImeModelConfig maxLength(int value) {
      this.maxLength = value;
      return this;
    }

    /**
     * Min.
     *
     * @param value the value
     * @return the ime model config
     */
    public ImeModelConfig min(double value) {
      this.min = value;
      return this;
    }

    /**
     * Max.
     *
     * @param value the value
     * @return the ime model config
     */
    public ImeModelConfig max(double value) {
      this.max = value;
      return this;
    }

    /**
     * Allow chars.
     *
     * @param value the value
     * @return the ime model config
     */
    public ImeModelConfig allowChars(String value) {
      this.allowChars = value;
      return this;
    }

    /**
     * Wildcard.
     *
     * @param value the value
     * @return the ime model config
     */
    public ImeModelConfig wildcard(String value) {
      this.wildcard = value;
      return this;
    }

    /**
     * Regex.
     *
     * @param value the value
     * @return the ime model config
     */
    public ImeModelConfig regex(String value) {
      this.regex = value;
      return this;
    }

    /**
     * Class type.
     *
     * @param classType the class type
     * @return the ime model config
     */
    public ImeModelConfig classType(String classType) {
      this.dataType = new DataType();
      this.dataType.className = classType;
      this.classType = classType;
      return this;
    }

    /**
     * Class type.
     *
     * @param cls the cls
     * @return the ime model config
     */
    public ImeModelConfig classType(Class<?> cls) {
      return this.classType(cls.getName());
    }

    /**
     * Number scale.
     *
     * @param value the value
     * @return the ime model config
     */
    public ImeModelConfig numberScale(int value) {
      this.numberScale = value;
      if (StringUtils.isEmpty(this.classType)) {
        if (value > 0) {
          this.classType(BigDecimal.class);
        } else {
          this.classType(Integer.class);
        }
      }
      return this;
    }

    /**
     * Signed.
     *
     * @param signed the signed
     * @return the ime model config
     */
    public ImeModelConfig signed(boolean signed) {
      this.signed = signed;
      return this;
    }

    /**
     * Configure.
     *
     * @param annotation the annotation
     */
    @Override
    public void configure(Annotation annotation) {}

    /**
     * Checks if is valid.
     *
     * @param vcc the vcc
     * @param value the value
     * @return true, if is valid
     */
    @Override
    public boolean isValid(ValidationConstraintContext vcc, Object value) {
      this.message = new StringBuilder();
      // Number
      if ((this.dataType != null) && this.dataType.typeOfNumber()) {
        if (!NumberUtils.isCreatable(value.toString())) {
          this.message.append("请输入数字");
          return false;
        }
        LoggerSupport.info(
            "{} value:{} isValid ", this.getClass().getSimpleName(), value, "typeOfNumber");
      }
      // Integer
      if ((this.dataType != null) && this.dataType.typeOfInteger()) {
        try {
          Integer.valueOf(value.toString());
        } catch (Throwable e) {
          this.message.append("请输入整数");
          return false;
        }
        LoggerSupport.info(
            "{} value:{} isValid ", this.getClass().getSimpleName(), value, "typeOfIneger");
      }
      // scaleLength>numberScale
      if ((value != null) && (this.dataType != null) && (this.numberScale != null)) {
        try {
          // 不允许多于1个小数点.
          int numOfDots = StringUtils.countMatches(value.toString(), ".");
          if (numOfDots > 1) {
            return false;
          }
          // 小数点后数字长度
          int scaleLength = 0;
          if (numOfDots > 0) {
            scaleLength = StringUtils.length(StringUtils.substringAfterLast(value.toString(), "."));
          }
          // 和指定的小数位数比较
          boolean pass = scaleLength <= this.numberScale;
          if (!pass) {
            this.message.append(String.format("只允许保留%s位小数", this.numberScale));
          }
          LoggerSupport.info(
              "{} value:{} scaleLength:{} isValid:{} numberScale {}",
              this.getClass().getSimpleName(),
              value,
              scaleLength,
              pass,
              this.numberScale);
          return pass;
        } catch (Throwable e) {
          LoggerSupport.debug("numberScale check:{}", e);
        }
      }
      // regex
      if ((value != null) && StringUtils.isNotBlank(this.regex)) {
        if (!Pattern.compile(this.regex).matcher(value.toString()).matches()) {
          return false;
        }
        LoggerSupport.info(
            "{} value:{} isValid regex {}", this.getClass().getSimpleName(), value, this.regex);
      }
      // wildcard
      if ((value != null) && StringUtils.isNotBlank(this.wildcard)) {
        if (!Wildcard.match(value.toString(), this.wildcard)) {
          return false;
        }
        LoggerSupport.info(
            "{} value:{} isValid wildcard {}",
            this.getClass().getSimpleName(),
            value,
            this.wildcard);
      }
      return true;
    }
  }

  /**
   * From.
   *
   * @param config the config
   * @return the ime model
   */
  public static ImeModel from(ImeModelConfig config) {
    ImeModel imeModel = new ImeModel(config);
    imeModel.fireImeModeConfigChange();
    return imeModel;
  }

  /**
   * Creates the.
   *
   * @return the ime model
   */
  public static ImeModel create() {
    return from(new ImeModelConfig().classType(String.class));
  }

  /**
   * Creates the integer.
   *
   * @return the ime model
   */
  public static ImeModel createInteger() {
    return createInteger(true);
  }

  /**
   * Creates the integer.
   *
   * @param signed the signed
   * @return the ime model
   */
  public static ImeModel createInteger(boolean signed) {
    return from(new ImeModelConfig().classType(Integer.class).signed(signed));
  }

  /**
   * Creates the integer with range.
   *
   * @param range the range
   * @return the ime model
   */
  public static ImeModel createIntegerWithRange(Range<Integer> range) {
    return from(
        new ImeModelConfig()
            .classType(Integer.class)
            .min(range.getMinimum())
            .max(range.getMaximum()));
  }

  /**
   * Creates the big decimal.
   *
   * @param scale the scale
   * @param signed the signed
   * @return the ime model
   */
  public static ImeModel createBigDecimal(int scale, boolean signed) {
    return from(new ImeModelConfig().classType(BigDecimal.class).numberScale(scale).signed(signed));
  }

  /**
   * Creates the big decimal.
   *
   * @param scale the scale
   * @return the ime model
   */
  public static ImeModel createBigDecimal(int scale) {
    return createBigDecimal(scale, true);
  }

  /** The Constant VALUE. */
  private static final String VALUE = "value";

  /**
   * The listener interface for receiving imeModelConfirm events. The class that
   * is interested in processing a imeModelConfirm event implements this
   * interface, and the object created with that class is registered with a
   * component using the component's <code>addImeModelConfirmListener<code>
   * method. When the imeModelConfirm event occurs, that object's appropriate
   * method is invoked.
   *
   * @see ImeModelConfirmEvent
   */
  public interface ImeModelConfirmListener extends OnConfirmListener<ImeModel> {}

  /**
   * The listener interface for receiving imeModelChanged events. The class that
   * is interested in processing a imeModelChanged event implements this
   * interface, and the object created with that class is registered with a
   * component using the component's <code>addImeModelChangedListener<code>
   * method. When the imeModelChanged event occurs, that object's appropriate
   * method is invoked.
   *
   * @see ImeModelChangedEvent
   */
  public interface ImeModelChangedListener extends OnChangedListener<ImeModel> {}

  /**
   * The listener interface for receiving imeModelCancel events. The class that is
   * interested in processing a imeModelCancel event implements this interface,
   * and the object created with that class is registered with a component using
   * the component's <code>addImeModelCancelListener<code> method. When the
   * imeModelCancel event occurs, that object's appropriate method is invoked.
   *
   * @see ImeModelCancelEvent
   */
  public interface ImeModelCancelListener extends OnCancelListener<ImeModel> {}

  /** The Interface ImeTagHandler. */
  public interface ImeTagHandler {

    /**
     * Accept tag.
     *
     * @param tag the tag
     * @return true, if successful
     */
    boolean acceptTag(String tag);

    /**
     * On tag.
     *
     * @param imeModel the ime model
     * @param tag the tag
     */
    void onTag(ImeModel imeModel, String tag);

    /**
     * 是否此TAG会修改imeModel内容.
     *
     * @return true, if successful
     */
    boolean acceptEdit();
  }

  /** The Class EscTagHandler. */
  public static class EscTagHandler implements ImeTagHandler {

    /** The Constant INSTANCE. */
    public static final EscTagHandler INSTANCE = new EscTagHandler();

    /** The tag. */
    public final String tag = "ESC";

    /**
     * Accept tag.
     *
     * @param tag the tag
     * @return true, if successful
     */
    @Override
    public boolean acceptTag(String tag) {
      return StringUtils.equalsIgnoreCase(this.tag, tag);
    }

    /**
     * On tag.
     *
     * @param imeModel the ime model
     * @param tag the tag
     */
    @Override
    public void onTag(ImeModel imeModel, String tag) {
      imeModel.fireCancel();
    }

    /**
     * Accept edit.
     *
     * @return true, if successful
     */
    @Override
    public boolean acceptEdit() {
      return false;
    }
  }

  /** The Class OkTagHandler. */
  public static class OkTagHandler implements ImeTagHandler {

    /** The Constant INSTANCE. */
    public static final OkTagHandler INSTANCE = new OkTagHandler();

    /** The tag. */
    public final String tag = "OK";

    /**
     * Accept tag.
     *
     * @param tag the tag
     * @return true, if successful
     */
    @Override
    public boolean acceptTag(String tag) {
      return StringUtils.equalsIgnoreCase(this.tag, tag);
    }

    /**
     * On tag.
     *
     * @param imeModel the ime model
     * @param tag the tag
     */
    @Override
    public void onTag(ImeModel imeModel, String tag) {
      imeModel.fireConfirm();
    }

    /**
     * Accept edit.
     *
     * @return true, if successful
     */
    @Override
    public boolean acceptEdit() {
      return false;
    }
  }

  /** The Class DelTagHandler. */
  public static class DelTagHandler implements ImeTagHandler {

    /** The Constant INSTANCE. */
    public static final DelTagHandler INSTANCE = new DelTagHandler();

    /** The tag. */
    public final String tag = "DEL";

    /**
     * Accept tag.
     *
     * @param tag the tag
     * @return true, if successful
     */
    @Override
    public boolean acceptTag(String tag) {
      return StringUtils.equalsIgnoreCase(this.tag, tag);
    }

    /**
     * On tag.
     *
     * @param imeModel the ime model
     * @param tag the tag
     */
    @Override
    public void onTag(ImeModel imeModel, String tag) {
      String currentValue = imeModel.value();
      if (StringUtils.length(currentValue) > 1) {
        imeModel.value(StringUtils.substring(currentValue, 0, -1));
      } else {
        imeModel.value("", false);
      }
    }

    /**
     * Accept edit.
     *
     * @return true, if successful
     */
    @Override
    public boolean acceptEdit() {
      return true;
    }
  }

  /**
   * 带符号的数字.
   *
   * @author zhoupan
   */
  public static class NumberSignedTagHandler implements ImeTagHandler {

    /** The Constant INSTANCE. */
    public static final NumberSignedTagHandler INSTANCE = new NumberSignedTagHandler();

    /** The tag. */
    public final String tag = "+/-";

    /**
     * Accept tag.
     *
     * @param tag the tag
     * @return true, if successful
     */
    @Override
    public boolean acceptTag(String tag) {
      return StringUtils.equalsIgnoreCase(this.tag, tag);
    }

    /**
     * On tag.
     *
     * @param imeModel the ime model
     * @param tag the tag
     */
    @Override
    public void onTag(ImeModel imeModel, String tag) {
      String currentValue = imeModel.value();
      LoggerSupport.debug(
          "onTag:{} isParsable:{} bigDecimal:{}",
          tag,
          NumberUtils.isParsable(currentValue),
          NumberUtils.createBigDecimal(currentValue));
      if (NumberUtils.isParsable(currentValue)) {
        // 负数去掉符号.
        if ((NumberUtils.createBigDecimal(currentValue).doubleValue() < 0)
            && StringUtils.startsWith(currentValue, "-")) {
          imeModel.value(StringUtils.substring(currentValue, 1));
        }
        // 正数取反
        if (NumberUtils.createBigDecimal(currentValue).doubleValue() > 0) {
          imeModel.value("-" + currentValue);
        }
      }
    }

    /**
     * Accept edit.
     *
     * @return true, if successful
     */
    @Override
    public boolean acceptEdit() {
      return true;
    }
  }

  /** The Class AllowCharsTagHandler. */
  public static class AllowCharsTagHandler implements ImeTagHandler {

    /** The Constant INSTANCE_0_9. */
    public static final AllowCharsTagHandler INSTANCE_0_9 = new AllowCharsTagHandler("0123456789");

    /** The Constant INSTANCE_0_9_PEROID. */
    public static final AllowCharsTagHandler INSTANCE_0_9_PEROID =
        new AllowCharsTagHandler("0123456789.");

    /** The allow chars. */
    public String allowChars;

    /**
     * Instantiates a new allow chars tag handler.
     *
     * @param allowChars the allow chars
     */
    public AllowCharsTagHandler(String allowChars) {
      super();
      this.allowChars = allowChars;
    }

    /** Instantiates a new allow chars tag handler. */
    public AllowCharsTagHandler() {
      this("");
    }

    /**
     * Allow chars.
     *
     * @param allowChars the allow chars
     * @return the allow chars tag handler
     */
    public AllowCharsTagHandler allowChars(String allowChars) {
      this.allowChars = allowChars;
      return this;
    }

    /**
     * Accept tag.
     *
     * @param tag the tag
     * @return true, if successful
     */
    @Override
    public boolean acceptTag(String tag) {
      return StringUtils.contains(this.allowChars, tag);
    }

    /**
     * On tag.
     *
     * @param imeModel the ime model
     * @param tag the tag
     */
    @Override
    public void onTag(ImeModel imeModel, String tag) {
      LoggerSupport.info(
          "{} onTag: tag={} value={} validateOnTag:{}",
          this.getClass().getSimpleName(),
          tag,
          imeModel.value(),
          imeModel.validateOnTag.get());
      // 组装临时值.
      StringBuilder sb = new StringBuilder();
      sb.append(imeModel.builder.toString());
      sb.append(tag);
      // 验证值.
      if (imeModel.validateOnTag.isPresent() && imeModel.validateOnTag.get()) {
        ResultSupport v = imeModel.validate(sb.toString());
        LoggerSupport.info(
            "{} onTag:{} validateOnTag validate:{} result:{} message:{}",
            this.getClass().getSimpleName(),
            tag,
            sb.toString(),
            v.isSuccess(),
            v.getMessage());
        if (v.isSuccess()) {
          imeModel.builder.append(tag);
          imeModel.fireChanged();
        }
      } else {
        imeModel.builder.append(tag);
        imeModel.fireChanged();
      }
    }

    /**
     * Accept edit.
     *
     * @return true, if successful
     */
    @Override
    public boolean acceptEdit() {
      return true;
    }
  }

  /** The builder. */
  public StringBuilder builder = new StringBuilder();

  /** The validation context. */
  public final MutableValue<ValidationContext> validationContext =
      new MutableValue<ValidationContext>().set(new ValidationContext());

  /** The tag handlers. */
  public final Vector<ImeTagHandler> tagHandlers = new Vector<ImeTagHandler>();

  /** The listener list. */
  public final EventListenerList listenerList = new EventListenerList();

  /** The validate on tag. */
  public MutableValue<Boolean> validateOnTag = new MutableValue<Boolean>().set(false);

  /** The config. */
  public final ImeModelConfig config;

  /** The field. */
  public final MutableValue<String> field = new MutableValue<String>();

  /** The label. */
  public final MutableValue<String> label = new MutableValue<String>();

  /**
   * Instantiates a new ime model.
   *
   * @param config the config
   */
  private ImeModel(ImeModelConfig config) {
    super();
    this.config = config;
  }

  /**
   * Adds the confirm listener.
   *
   * @param listener the listener
   */
  public void addConfirmListener(ImeModelConfirmListener listener) {
    this.listenerList.add(ImeModelConfirmListener.class, listener);
  }

  /**
   * Adds the changed listener.
   *
   * @param listener the listener
   */
  public void addChangedListener(ImeModelChangedListener listener) {
    this.listenerList.add(ImeModelChangedListener.class, listener);
  }

  /**
   * Adds the cancel listener.
   *
   * @param listener the listener
   */
  public void addCancelListener(ImeModelCancelListener listener) {
    this.listenerList.add(ImeModelCancelListener.class, listener);
  }

  /** Adds the default tag handlers. */
  public void addDefaultTagHandlers() {
    this.addTagHandler(ImeModel.OkTagHandler.INSTANCE);
    this.addTagHandler(ImeModel.EscTagHandler.INSTANCE);
    this.addTagHandler(ImeModel.DelTagHandler.INSTANCE);
  }

  /**
   * Fire ime mode config change.
   *
   * @return the result support
   */
  public ResultSupport fireImeModeConfigChange() {
    ResultSupport result = new ResultSupport();
    try {
      // 清空tagHandlers.
      this.clearTagHandlers();
      this.addDefaultTagHandlers();
      this.validateOnTag.set(this.config.validateOnTag);
      // 符号输入
      if (this.config.signed) {
        LoggerSupport.info(
            "{} fireImeModeConfigChange config.signed=true add ImeModel.NumberSignedTagHandler.INSTANCE",
            this.getClass().getSimpleName());
        this.addTagHandler(ImeModel.NumberSignedTagHandler.INSTANCE);
      }
      // 小数点
      if (this.config.dataType.typeOfNumber()) {
        if ((this.config.numberScale != null) && (this.config.numberScale > 0)) {
          this.validateOnTag.set(true);
          LoggerSupport.info(
              "{} fireImeModeConfigChange config.numberScale={} validateOnTag.set(true)",
              this.getClass().getSimpleName(),
              this.config.numberScale);
          LoggerSupport.info(
              "{} fireImeModeConfigChange add AllowCharsTagHandler.INSTANCE_0_9_PEROID",
              this.getClass().getSimpleName());
          this.addTagHandler(AllowCharsTagHandler.INSTANCE_0_9_PEROID);
        } else {
          LoggerSupport.info(
              "{} fireImeModeConfigChange add AllowCharsTagHandler.INSTANCE_0_9",
              this.getClass().getSimpleName());
          this.addTagHandler(AllowCharsTagHandler.INSTANCE_0_9);
        }
      }
      // 字符串.
      if (this.config.dataType.typeOfString()) {
        LoggerSupport.info(
            "{} fireImeModeConfigChange typeOfString add AllowCharsTagHandler.INSTANCE_0_9_PEROID",
            this.getClass().getSimpleName());
        LoggerSupport.info(
            "{} fireImeModeConfigChange typeOfString add ImeModel.NumberSignedTagHandler.INSTANCE",
            this.getClass().getSimpleName());
        this.addTagHandler(AllowCharsTagHandler.INSTANCE_0_9_PEROID);
        this.addTagHandler(ImeModel.NumberSignedTagHandler.INSTANCE);
        // TODO:实现其他字符串键盘
      }
      // validation
      this.cleanConstraints();
      // 字符串
      if (this.config.dataType.typeOfString()) {
        // 长度限制
        if (config.minLength != null) {
          LoggerSupport.info(
              "{} fireImeModeConfigChange typeOfString config.minLength={} add addMinLengthConstraint",
              this.getClass().getSimpleName(),
              config.minLength);
          this.addMinLengthConstraint(config.minLength);
        }
        if (config.maxLength != null) {
          LoggerSupport.info(
              "{} fireImeModeConfigChange typeOfString config.maxLength={} validateOnTag.set(true)",
              this.getClass().getSimpleName(),
              config.maxLength);
          this.validateOnTag.set(true);
          LoggerSupport.info(
              "{} fireImeModeConfigChange typeOfString config.maxLength={} add addMaxLengthConstraint",
              this.getClass().getSimpleName(),
              config.maxLength);
          this.addMaxLengthConstraint(config.maxLength);
        }
      }
      // 数字大小限制
      if (this.config.dataType.typeOfNumber()) {
        if (config.min != null) {
          LoggerSupport.info(
              "{} fireImeModeConfigChange typeOfNumber config.min={} add addMinConstraint",
              this.getClass().getSimpleName(),
              config.min);
          this.addMinConstraint(config.min);
        }
        if (config.max != null) {
          LoggerSupport.info(
              "{} fireImeModeConfigChange typeOfNumber config.max={} add addMaxConstraint",
              this.getClass().getSimpleName(),
              config.max);
          this.addMaxConstraint(config.max);
        }
      }
      // 通配符匹配
      if (StringUtils.isNotEmpty(config.wildcard)) {
        this.addWildcardMatchConstraint(config.wildcard);
      }
      // 其他配置限制
      this.addValidationConstraint(config);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /** Clear tag handlers. */
  public void clearTagHandlers() {
    this.tagHandlers.clear();
  }

  /**
   * Value.
   *
   * @return the string
   */
  public String value() {
    return this.builder.toString();
  }

  /**
   * Value.
   *
   * @param value the value
   * @return the result support
   */
  public ResultSupport value(String value) {
    return this.value(value, this.validateOnTag.get());
  }

  /**
   * Value.
   *
   * @param value the value
   * @param validate the validate
   * @return the result support
   */
  public ResultSupport value(String value, boolean validate) {
    ResultSupport result = new ResultSupport();
    try {
      if (validate) {
        ResultSupport v = this.validate(value);
        if (v.isSuccess()) {
          this.builder = new StringBuilder();
          this.builder.append(value);
          this.fireChanged();
        } else {
          LoggerSupport.debug("value:{} validate:{}", value, v.getMessage());
        }
        CoreUtils.checkState(v.isSuccess(), v.getMessage());
      } else {
        this.builder = new StringBuilder();
        this.builder.append(value);
        this.fireChanged();
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Fire cancel.
   *
   * @return the result support
   */
  public ResultSupport fireCancel() {
    ResultSupport result = new ResultSupport();
    try {
      this.onCancel();
      // 通知监听
      ImeModelCancelListener[] listeners =
          this.listenerList.getListeners(ImeModelCancelListener.class);
      if (listeners != null) {
        for (ImeModelCancelListener listener : listeners) {
          listener.onCancel(this);
        }
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /** On cancel. */
  public void onCancel() {
    LoggerSupport.debug("onCancel");
  }

  /**
   * Fire confirm.
   *
   * @return the result support
   */
  public ResultSupport fireConfirm() {
    ResultSupport result = new ResultSupport();
    try {
      this.onConfirm(this);
      // 通知监听
      ImeModelConfirmListener[] listeners =
          this.listenerList.getListeners(ImeModelConfirmListener.class);
      if (listeners != null) {
        for (ImeModelConfirmListener listener : listeners) {
          listener.onConfirm(this);
        }
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * On confirm.
   *
   * @param imeModel the ime model
   */
  public void onConfirm(ImeModel imeModel) {
    LoggerSupport.debug("onConfirm:{}", imeModel.builder.toString());
  }

  /**
   * Fire changed.
   *
   * @return the result support
   */
  public ResultSupport fireChanged() {
    ResultSupport result = new ResultSupport();
    try {
      this.onChanged(this);
      // 通知监听
      ImeModelChangedListener[] listeners =
          this.listenerList.getListeners(ImeModelChangedListener.class);
      if (listeners != null) {
        for (ImeModelChangedListener listener : listeners) {
          listener.onChanged(this);
        }
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * On changed.
   *
   * @param imeModel the ime model
   */
  public void onChanged(ImeModel imeModel) {
    LoggerSupport.debug("onChanged:{}", imeModel.builder.toString());
  }

  /**
   * Tag number signed.
   *
   * @return the data result support
   */
  public DataResultSupport<String> tagNumberSigned() {
    return this.tag(ImeModel.NumberSignedTagHandler.INSTANCE.tag);
  }

  /**
   * Tag OK.
   *
   * @return the data result support
   */
  public DataResultSupport<String> tagOK() {
    return this.tag(ImeModel.OkTagHandler.INSTANCE.tag);
  }

  /**
   * Tag esc.
   *
   * @return the data result support
   */
  public DataResultSupport<String> tagEsc() {
    return this.tag(ImeModel.EscTagHandler.INSTANCE.tag);
  }

  /**
   * Tag del.
   *
   * @return the data result support
   */
  public DataResultSupport<String> tagDel() {
    return this.tag(ImeModel.DelTagHandler.INSTANCE.tag);
  }

  /**
   * Tag.
   *
   * @param tag the tag
   * @return the data result support
   */
  public DataResultSupport<String> tag(String tag) {
    DataResultSupport<String> result = new DataResultSupport<String>();
    try {
      for (ImeTagHandler imeTagHandler : this.tagHandlers) {
        if (imeTagHandler.acceptTag(tag)) {
          String before = this.builder.toString();
          imeTagHandler.onTag(this, tag);
          String after = this.builder.toString();
          result.setData(after);
          // 通过比较之前和之后的数据,判断tag是否被接受
          if (imeTagHandler.acceptEdit()) {
            boolean accept = !StringUtils.equals(before, after);
            CoreUtils.checkState(accept, "tag:%s 输入被拒绝. before：%s after:%s", tag, before, after);
          }
          return result;
        }
      }
      CoreUtils.checkState(false, "不支持的输入:%s", tag);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Tags.
   *
   * @param tags the tags
   * @return the data result support
   */
  public DataResultSupport<String> tags(String... tags) {
    DataResultSupport<String> result = new DataResultSupport<String>();
    try {
      for (String tag : tags) {
        DataResultSupport<String> tagResult = this.tag(tag);
        CoreUtils.checkState(tagResult.isSuccess(), tagResult.getMessage());
      }
      result.setData(this.builder.toString());
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Adds the validation constraint.
   *
   * @param contraint the contraint
   * @return the ime model
   */
  @SuppressWarnings("rawtypes")
  public ImeModel addValidationConstraint(ValidationConstraint contraint) {
    if (this.validationContext.isEmpty()) {
      this.validationContext.set(new ValidationContext());
    }
    this.validationContext.get().add(new Check(VALUE, contraint));
    return this;
  }

  /**
   * Clean constraints.
   *
   * @return the ime model
   */
  public ImeModel cleanConstraints() {
    this.validationContext.set(new ValidationContext());
    return this;
  }

  /**
   * Adds the max length constraint.
   *
   * @param maxLength the max length
   * @return the ime model
   */
  public ImeModel addMaxLengthConstraint(int maxLength) {
    this.addValidationConstraint(new MaxLengthConstraint(maxLength));
    return this;
  }

  /**
   * Adds the min length constraint.
   *
   * @param minLength the min length
   * @return the ime model
   */
  public ImeModel addMinLengthConstraint(int minLength) {
    this.addValidationConstraint(new MinLengthConstraint(minLength));
    return this;
  }

  /**
   * Adds the max constraint.
   *
   * @param max the max
   * @return the ime model
   */
  public ImeModel addMaxConstraint(double max) {
    this.addValidationConstraint(new LessEqualConstraint(max));
    return this;
  }

  /**
   * Adds the min constraint.
   *
   * @param min the min
   * @return the ime model
   */
  public ImeModel addMinConstraint(double min) {
    this.addValidationConstraint(new GreaterEqualConstraint(min));
    return this;
  }

  /**
   * Adds the not blank constraint.
   *
   * @return the ime model
   */
  public ImeModel addNotBlankConstraint() {
    this.addValidationConstraint(new NotBlankConstraint());
    return this;
  }

  /**
   * Adds the wildcard match constraint.
   *
   * @param pattern the pattern
   * @return the ime model
   */
  public ImeModel addWildcardMatchConstraint(String pattern) {
    this.addValidationConstraint(new WildcardMatchConstraint(pattern));
    return this;
  }

  /**
   * Removes the tag handler.
   *
   * @param tagHandler the tag handler
   * @return the ime model
   */
  public ImeModel removeTagHandler(Class<?> tagHandler) {
    Vector<ImeTagHandler> toRemoves = new Vector<ImeTagHandler>();
    for (ImeTagHandler imeTagHandler : this.tagHandlers) {
      if (tagHandler.isInstance(imeTagHandler)) {
        toRemoves.add(imeTagHandler);
      }
    }
    this.tagHandlers.removeAll(toRemoves);
    return this;
  }

  /**
   * Adds the tag handler.
   *
   * @param tagHandler the tag handler
   * @return the ime model
   */
  public ImeModel addTagHandler(ImeTagHandler tagHandler) {
    if (!this.tagHandlers.contains(tagHandler)) {
      this.tagHandlers.add(tagHandler);
    }
    return this;
  }

  /**
   * Validate.
   *
   * @param target the target
   * @return the result support
   */
  public ResultSupport validate(String target) {
    ResultSupport result = new ResultSupport();
    try {
      LoggerSupport.info(
          "{} validate target:{} config:{}", this.getClass().getSimpleName(), target, this.config);
      if (this.validationContext.isEmpty()) {
        return result;
      }
      // 不允许为空:
      if (StringUtils.isEmpty(target)) {
        StringBuilder sb = new StringBuilder();
        String label = this.label.isPresent() ? this.label.get() : "";
        sb.append(LoggerSupport.messageFormat("输入{}值不允许为空.", label));
        CoreUtils.checkState(false, sb);
      }
      // 不为空则执行其他校验
      Vtor vtor = new Vtor();
      Map<String, Object> bean = new HashMap<String, Object>();
      bean.put(VALUE, target);
      vtor.validate(this.validationContext.get(), bean);
      List<Violation> vlist = vtor.getViolations();
      if ((vlist != null) && (vlist.size() > 0)) {
        StringBuilder sb = new StringBuilder();
        for (Violation v : vlist) {
          sb.append(this.violationToString(v));
        }
        CoreUtils.checkState(false, sb);
      }
    } catch (Throwable e) {
      LoggerSupport.error("validate:target:{} error:", target, e.getMessage());
      result.onException(e);
    }
    return result;
  }

  /**
   * Violation to string.
   *
   * @param v the v
   * @return the string
   */
  public String violationToString(Violation v) {
    StringBuilder sb = new StringBuilder();
    String label = this.label.isPresent() ? this.label.get() : "";
    sb.append(LoggerSupport.messageFormat("输入{}值无效.", label));
    if (v.getConstraint() instanceof ImeModelConfig) {
      ImeModelConfig config = (ImeModelConfig) v.getConstraint();
      if (config.message.length() > 0) {
        sb.append("(").append(config.message.toString()).append(")");
      }
    }
    if (v.getConstraint() instanceof LessEqualConstraint) {
      LessEqualConstraint c = (LessEqualConstraint) v.getConstraint();
      this.appendConstraintMesssage(label, sb, c);
    }
    if (v.getConstraint() instanceof GreaterEqualConstraint) {
      GreaterEqualConstraint c = (GreaterEqualConstraint) v.getConstraint();
      this.appendConstraintMesssage(label, sb, c);
    }
    if (v.getConstraint() instanceof MaxLengthConstraint) {
      MaxLengthConstraint c = (MaxLengthConstraint) v.getConstraint();
      this.appendConstraintMesssage(label, sb, c);
    }
    if (v.getConstraint() instanceof MinLengthConstraint) {
      MinLengthConstraint c = (MinLengthConstraint) v.getConstraint();
      this.appendConstraintMesssage(label, sb, c);
    }
    if (v.getConstraint() instanceof NotBlankConstraint) {
      NotBlankConstraint c = (NotBlankConstraint) v.getConstraint();
      this.appendConstraintMesssage(label, sb, c);
    }
    if (v.getConstraint() instanceof WildcardMatchConstraint) {
      WildcardMatchConstraint c = (WildcardMatchConstraint) v.getConstraint();
      this.appendConstraintMesssage(label, sb, c);
    }
    return sb.toString();
  }

  /**
   * Append constraint messsage.
   *
   * @param label the label
   * @param sb the sb
   * @param constraint the constraint
   * @return the result support
   */
  public ResultSupport appendConstraintMesssage(
      String label, StringBuilder sb, LessEqualConstraint constraint) {
    ResultSupport result = new ResultSupport();
    try {
      int scale = this.config.numberScale != null ? this.config.numberScale : 0;
      String roundValue =
          DecimalSupport.getInstance(scale).round(new BigDecimal(constraint.getMax())).toString();
      String message = LoggerSupport.messageFormat("({}必须小于等于{})", label, roundValue);
      sb.append(message);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Append constraint messsage.
   *
   * @param label the label
   * @param sb the sb
   * @param constraint the constraint
   * @return the result support
   */
  public ResultSupport appendConstraintMesssage(
      String label, StringBuilder sb, GreaterEqualConstraint constraint) {
    ResultSupport result = new ResultSupport();
    try {
      int scale = this.config.numberScale != null ? this.config.numberScale : 0;
      String roundValue =
          DecimalSupport.getInstance(scale).round(new BigDecimal(constraint.getMin())).toString();
      String message = LoggerSupport.messageFormat("({}必须大于等于{})", label, roundValue);
      sb.append(message);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Append constraint messsage.
   *
   * @param label the label
   * @param sb the sb
   * @param constraint the constraint
   * @return the result support
   */
  public ResultSupport appendConstraintMesssage(
      String label, StringBuilder sb, MaxLengthConstraint constraint) {
    ResultSupport result = new ResultSupport();
    try {
      String message = LoggerSupport.messageFormat("({}限制最大长度{})", label, constraint.getMax());
      sb.append(message);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Append constraint messsage.
   *
   * @param label the label
   * @param sb the sb
   * @param constraint the constraint
   * @return the result support
   */
  public ResultSupport appendConstraintMesssage(
      String label, StringBuilder sb, MinLengthConstraint constraint) {
    ResultSupport result = new ResultSupport();
    try {
      String message = LoggerSupport.messageFormat("({}限制最小长度{})", label, constraint.getMin());
      sb.append(message);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Append constraint messsage.
   *
   * @param label the label
   * @param sb the sb
   * @param constraint the constraint
   * @return the result support
   */
  public ResultSupport appendConstraintMesssage(
      String label, StringBuilder sb, NotBlankConstraint constraint) {
    ResultSupport result = new ResultSupport();
    try {
      String message = LoggerSupport.messageFormat("({}不允许为空)", label);
      sb.append(message);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Append constraint messsage.
   *
   * @param label the label
   * @param sb the sb
   * @param constraint the constraint
   * @return the result support
   */
  public ResultSupport appendConstraintMesssage(
      String label, StringBuilder sb, WildcardMatchConstraint constraint) {
    ResultSupport result = new ResultSupport();
    try {
      String message = LoggerSupport.messageFormat("({}不匹配模式{})", label, constraint.getPattern());
      sb.append(message);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
