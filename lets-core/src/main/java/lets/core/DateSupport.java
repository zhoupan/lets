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

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/** The Class DateSupport. */
public class DateSupport {

  /** The value. */
  private Date value;

  /**
   * Instantiates a new date support.
   *
   * @param value the value
   */
  public DateSupport(Date value) {
    super();
    this.value = value;
  }

  public DateSupport set(Date value) {
    this.value = value;
    return this;
  }

  public DateSupport set(Calendar calendar) {
    this.value = calendar.getTime();
    return this;
  }

  public DateSupport set(int year, int month, int day) {
    this.value = DateUtils.toDate(year, month, day);
    return this;
  }

  /**
   * Instantiates a new date support.
   *
   * @param year the year
   * @param month the month
   * @param day the day
   */

  /**
   * Instantiates a new date support.
   *
   * @param calendar the calendar
   */
  public DateSupport(Calendar calendar) {
    this.value = calendar.getTime();
  }

  /**
   * Instantiates a new date support.
   *
   * @param millis the millis
   */
  public DateSupport(long millis) {
    this.value = new Date(millis);
  }

  /**
   * Instantiates a new date support.
   *
   * @param year the year
   * @param month the month
   * @param day the day
   * @param hour the hour
   * @param minute the minute
   * @param second the second
   */
  public DateSupport(int year, int month, int day, int hour, int minute, int second) {
    this.value = DateUtils.toDate(year, month, day);
    setHour(hour);
    setMinute(minute);
    setSecond(second);
  }

  public DateSupport set(int year, int month, int day, int hour, int minute, int second) {
    this.value = DateUtils.toDate(year, month, day);
    setHour(hour);
    setMinute(minute);
    setSecond(second);
    return this;
  }

  /**
   * Sets the second.
   *
   * @param second the second
   * @return the date support
   */
  public DateSupport setSecond(int second) {
    this.value = DateUtils.setSeconds(this.value, second);
    return this;
  }

  /**
   * Sets the minute.
   *
   * @param minute the minute
   * @return the date support
   */
  public DateSupport setMinute(int minute) {
    this.value = DateUtils.setMinutes(this.value, minute);
    return this;
  }

  /**
   * Sets the hour.
   *
   * @param hour the hour
   * @return the date support
   */
  public DateSupport setHour(int hour) {
    this.value = DateUtils.setHours(this.value, hour);
    return this;
  }

  /**
   * Sets the day.
   *
   * @param second the second
   * @return the date support
   */
  public DateSupport setDay(int second) {
    this.value = DateUtils.setDays(this.value, second);
    return this;
  }

  /**
   * Sets the month.
   *
   * @param second the second
   * @return the date support
   */
  public DateSupport setMonth(int second) {
    this.value = DateUtils.setMonths(this.value, second);
    return this;
  }

  /**
   * Sets the year.
   *
   * @param second the second
   * @return the date support
   */
  public DateSupport setYear(int second) {
    this.value = DateUtils.setYears(this.value, second);
    return this;
  }

  /**
   * Round.
   *
   * @param format the format
   * @return the date support
   * @throws ParseException the parse exception
   */
  public DateSupport round(String format) throws ParseException {
    this.value = DateUtils.round(this.value, format);
    return this;
  }

  /**
   * Value.
   *
   * @return the date
   */
  public Date value() {
    return value;
  }
}
