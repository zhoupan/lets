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
package lets.core.event;

import java.util.Date;
import lets.core.ResultSupport;

/** The Class BaseEvent. */
public class BaseEvent {

  /** The meta. */
  public final EventMeta meta = new EventMeta();

  /**
   * Post.
   *
   * @return the result support
   */
  public ResultSupport post() {
    return EventBusUtils.post(this);
  }

  /**
   * From.
   *
   * @param who the who
   * @return the base event
   */
  public BaseEvent from(String who) {
    if (!this.meta.from.contains(who)) {
      this.meta.from.add(who);
    }
    return this;
  }

  /**
   * Checks if is from.
   *
   * @param who the who
   * @return true, if is from
   */
  public boolean isFrom(String who) {
    return this.meta.from.contains(who);
  }

  /**
   * From.
   *
   * @param who the who
   * @return the base event
   */
  public BaseEvent from(Class<?> who) {
    return this.from(who.getName());
  }

  /**
   * Checks if is from.
   *
   * @param who the who
   * @return true, if is from
   */
  public boolean isFrom(Class<?> who) {
    return this.isFrom(who.getName());
  }

  /**
   * To.
   *
   * @param who the who
   * @return the base event
   */
  public BaseEvent to(String who) {
    if (!this.meta.to.contains(who)) {
      this.meta.to.add(who);
    }
    return this;
  }

  /**
   * To.
   *
   * @param who the who
   * @return the base event
   */
  public BaseEvent to(Class<?> who) {
    return this.to(who.getName());
  }

  /**
   * Checks if is to.
   *
   * @param who the who
   * @return true, if is to
   */
  public boolean isTo(String who) {
    return this.meta.to.contains(who);
  }

  /**
   * Checks if is to.
   *
   * @param who the who
   * @return true, if is to
   */
  public boolean isTo(Class<?> who) {
    return this.isTo(who.getName());
  }

  /**
   * Purpose.
   *
   * @param purpose the purpose
   * @return the base event
   */
  public BaseEvent purpose(String purpose) {
    if (!this.meta.purpose.contains(purpose)) {
      this.meta.purpose.add(purpose);
    }
    return this;
  }

  /**
   * Purpose.
   *
   * @param purpose the purpose
   * @return the base event
   */
  public BaseEvent purpose(Class<?> purpose) {
    return this.purpose(purpose.getName());
  }

  /**
   * Checks if is purpose.
   *
   * @param purpose the purpose
   * @return true, if is purpose
   */
  public boolean isPurpose(String purpose) {
    return this.meta.purpose.contains(purpose);
  }

  /**
   * Checks if is purpose.
   *
   * @param purpose the purpose
   * @return true, if is purpose
   */
  public boolean isPurpose(Class<?> purpose) {
    return this.isPurpose(purpose.getName());
  }

  /**
   * Creates the at.
   *
   * @param date the date
   * @return the base event
   */
  public BaseEvent createAt(Date date) {
    this.meta.createAt.setValue(date);
    return this;
  }

  /**
   * Expired at.
   *
   * @param date the date
   * @return the base event
   */
  public BaseEvent expiredAt(Date date) {
    this.meta.expiredAt.setValue(date);
    return this;
  }

  /**
   * Checks if is expired.
   *
   * @param date the date
   * @return true, if is expired
   */
  public boolean isExpired(Date date) {
    return (this.meta.expiredAt.getValue() != null) && this.meta.expiredAt.getValue().before(date);
  }

  /**
   * Checks if is expired.
   *
   * @return true, if is expired
   */
  public boolean isExpired() {
    return this.isExpired(new Date());
  }
}
