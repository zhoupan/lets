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

import java.util.Date;
import java.util.concurrent.TimeUnit;
import lets.core.event.EventListenerList;
import lets.core.event.OnChangeListener;

/**
 * 目的:替代java.lang.Optional 1. since 1.8 引入了Optional对象 2. 低的android版本不支持1.8,需要android-retrofix
 *
 * @author zhoupan
 * @param <T> the generic type
 */
public class MutableDelayValue<T> implements Mutable<T> {

  /** The value. */
  protected T value;

  /** The current value. */
  protected T currentValue;

  /** The time unit. */
  public final MutableValue<TimeUnit> timeUnit = new MutableValue<TimeUnit>().set(TimeUnit.SECONDS);

  /** The duration. */
  public final MutableValue<Integer> duration = new MutableValue<Integer>().set(0);

  /** The at. */
  public final MutableValue<Date> at = new MutableValue<Date>();

  /** The listener list. */
  protected EventListenerList listenerList = new EventListenerList();

  /** The name. */
  public final MutableValue<String> name = new MutableValue<String>();

  /** The fire change event only when not equals. */
  public final MutableValue<Boolean> fireChangeEventOnlyWhenNotEquals =
      new MutableValue<Boolean>().set(true);

  /**
   * Fire change event only when not equals.
   *
   * @param value the value
   * @return the mutable delay value
   */
  public MutableDelayValue<T> fireChangeEventOnlyWhenNotEquals(boolean value) {
    this.fireChangeEventOnlyWhenNotEquals.set(value);
    return this;
  }

  /**
   * Name.
   *
   * @param name the name
   * @return the mutable delay value
   */
  public MutableDelayValue<T> name(String name) {
    this.name.set(name);
    return this;
  }

  /**
   * With delay.
   *
   * @param timeUnit the time unit
   * @param duration the duration
   * @return the mutable delay value
   */
  public MutableDelayValue<T> withDelay(TimeUnit timeUnit, int duration) {
    this.timeUnit.set(timeUnit);
    this.duration.set(duration);
    return this;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  @Override
  public T getValue() {
    return value;
  }

  /**
   * Gets the.
   *
   * @return the t
   */
  public T get() {
    return value;
  }

  /**
   * Gets the current value.
   *
   * @return the current value
   */
  public T getCurrentValue() {
    return this.currentValue;
  }

  /**
   * Sets the current value.
   *
   * @param value the new current value
   */
  public void setCurrentValue(T value) {
    this.currentValue = value;
  }

  /**
   * Sets the.
   *
   * @param value the value
   * @return the mutable delay value
   */
  public MutableDelayValue<T> set(T value) {
    this.setValue(value);
    return this;
  }

  /**
   * Reset.
   *
   * @param value the value
   * @return the mutable delay value
   */
  public MutableDelayValue<T> reset(T value) {
    this.at.set(new Date());
    this.value = value;
    this.currentValue = value;
    return this;
  }

  /**
   * Sets the value.
   *
   * @param newValue the new value
   */
  @Override
  public synchronized void setValue(T newValue) {
    Date now = new Date();
    if (this.checkDelayEnabled()) {
      if (this.at.isEmpty() || (this.value == null)) {
        this.at.set(now);
        T from = this.value;
        this.value = newValue;
        this.fireChangeEvent(from, this.value);
      } else {
        Date delayDate =
            DateUtils.addMilliseconds(
                this.at.get(), (int) this.timeUnit.get().toMillis(this.duration.get()));
        if (now.after(delayDate)) {
          this.at.set(now);
          T from = this.value;
          this.value = newValue;
          this.fireChangeEvent(from, this.value);
        }
      }
    } else {
      T from = this.value;
      this.value = newValue;
      this.fireChangeEvent(from, this.value);
    }
  }

  /**
   * Check delay enabled.
   *
   * @return true, if successful
   */
  public synchronized boolean checkDelayEnabled() {
    return this.timeUnit.isPresent() && this.duration.isPresent() && (this.duration.get() > 0);
  }

  /**
   * Checks if is present.
   *
   * @return true, if is present
   */
  public synchronized boolean isPresent() {
    return this.value != null;
  }

  /**
   * Checks if is empty.
   *
   * @return true, if is empty
   */
  public synchronized boolean isEmpty() {
    return this.value == null;
  }

  /**
   * Hash code.
   *
   * @return the int
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  /**
   * Equals.
   *
   * @param obj the obj
   * @return true, if successful
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    MutableDelayValue other = (MutableDelayValue) obj;
    if (value == null) {
      if (other.value != null) {
        return false;
      }
    } else if (!value.equals(other.value)) {
      return false;
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
    return "MutableValue [value=" + value + "]";
  }

  /**
   * Gets the display string.
   *
   * @return the display string
   */
  public String getDisplayString() {
    return this.getDisplayString("");
  }

  /**
   * 返回显示字符串.
   *
   * @param defaultValue 默认值(当值未设置的时候返回)
   * @return 如果值不为null,返回设置的值,否则返回默认值.
   */
  public String getDisplayString(String defaultValue) {
    try {
      if (this.isPresent()) {
        return this.get().toString();
      }
      return defaultValue;
    } catch (Throwable e) {
      LoggerSupport.error("{}", e);
      return defaultValue;
    }
  }

  /**
   * Adds the on change listener.
   *
   * @param onChangeListener the on change listener
   */
  public void addOnChangeListener(OnChangeListener<T> onChangeListener) {
    this.removeOnChangeListener(onChangeListener);
    this.listenerList.add(OnChangeListener.class, onChangeListener);
  }

  /**
   * Removes the on change listener.
   *
   * @param onChangeListener the on change listener
   */
  public void removeOnChangeListener(OnChangeListener<T> onChangeListener) {
    this.listenerList.remove(OnChangeListener.class, onChangeListener);
  }

  /**
   * Fire change event.
   *
   * @param from the from
   * @param to the to
   */
  @SuppressWarnings("unchecked")
  public synchronized void fireChangeEvent(T from, T to) {
    // 检查新值和旧值是否相等.
    if (this.fireChangeEventOnlyWhenNotEquals.isPresent()
        && this.fireChangeEventOnlyWhenNotEquals.get()
        && ObjectUtils.equals(from, to)) {
      return;
    }
    for (OnChangeListener<T> listener : this.listenerList.getListeners(OnChangeListener.class)) {
      LoggerSupport.debug(
          "{} fireChangeEvent:{} -> {}", name.isPresent() ? name.get() : "", from, to);
      listener.onChange(from, to);
    }
  }
}
