/*
 * Copyright (c) 2022 zhoupan (https://github.com/zhoupan).
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

/**
 * unix时间戳（英文为Unix epoch, Unix time, POSIX time 或 Unix
 * timestamp）是从1970年1月1日（UTC/GMT的午夜）开始所经过的秒数，不考虑闰秒。 UNIX时间戳的0按照ISO 8601规范为 ：1970-01-01T00:00:00Z.
 * 一个小时表示为UNIX时间戳格式为：3600秒；一天表示为UNIX时间戳为86400秒，闰秒不计算。
 *
 * @author zhoupan
 */
public class UnixTime {

  /**
   * To date.
   *
   * @param time the time
   * @return the date
   */
  public static Date toDate(UnixTime time) {
    return new Date(time.time * 1000);
  }

  /**
   * To date.
   *
   * @param unixTime the unix time
   * @return the date
   */
  public static Date toDate(long unixTime) {
    return new Date(unixTime * 1000);
  }

  /**
   * From date.
   *
   * @param date the date
   * @return the unix time
   */
  public static UnixTime fromDate(Date date) {
    UnixTime time = new UnixTime();
    time.setTime(date.getTime() / 1000);
    return time;
  }

  /**
   * From date.
   *
   * @param milliseconds the milliseconds
   * @return the unix time
   */
  public static UnixTime fromDate(long milliseconds) {
    return fromDate(new Date(milliseconds));
  }

  /**
   * Time.
   *
   * @return the int
   */
  public static int time() {
    return (int) fromDate(System.currentTimeMillis()).getTime();
  }

  /**
   * Time.
   *
   * @param date the date
   * @return the int
   */
  public static int time(Date date) {
    return (int) fromDate(date).getTime();
  }

  /** The time. */
  private long time;

  /**
   * Gets the time.
   *
   * @return the time
   */
  public long getTime() {
    return time;
  }

  /**
   * Sets the time.
   *
   * @param time the new time
   */
  public void setTime(long time) {
    this.time = time;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(this.time * 1000);
  }

  /**
   * To string.
   *
   * @param pattern the pattern
   * @return the string
   */
  public String toString(String pattern) {
    return DateFormatUtils.format(new Date(this.time * 1000), pattern);
  }

  /**
   * To string.
   *
   * @param unixTime the time
   * @param pattern the pattern
   * @return the string
   */
  public static String toString(Integer unixTime, String pattern) {
    if (unixTime != null) {
      return DateFormatUtils.format(UnixTime.toDate(unixTime), pattern);
    } else {
      return "";
    }
  }

  /**
   * To string.
   *
   * @param unixTime the time
   * @return the string
   */
  public static String toString(Integer unixTime) {
    return toString(unixTime, "yyyy-MM-dd HH:mm:ss");
  }

  /**
   * To date string.
   *
   * @param time the time
   * @return the string
   */
  public static String toDateString(Integer time) {
    return toString(time, "yyyy-MM-dd");
  }

  /**
   * 比较两个Unix时间的日期.例如: 2022-01-01 01:30:00和2022-01-01 08:30:00 忽略掉时间,日期是同一天,它们就是相等的
   *
   * @param left
   * @param right
   * @return
   */
  public static int compareDate(Integer left, Integer right) {
    String roundPattern = "yyyy-MM-dd";
    DataResultSupport<Date> leftDateRound =
        DateUtils.dateRound(toString(left, roundPattern), roundPattern);
    DataResultSupport<Date> rightDateRound =
        DateUtils.dateRound(toString(right, roundPattern), roundPattern);
    if (leftDateRound.isSuccess() && rightDateRound.isSuccess()) {
      return leftDateRound.getData().compareTo(rightDateRound.getData());
    }
    return left.compareTo(right);
  }
}
