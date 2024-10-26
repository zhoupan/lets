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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Date and time formatting utilities and constants.
 *
 * <p>Formatting is performed using the thread-safe {@link
 * lets.core.apache.commons.lang3.time.FastDateFormat} class.
 *
 * <p>Note that the JDK has a bug wherein calling Calendar.get(int) will override any previously
 * called Calendar.clear() calls. See LANG-755.
 *
 * @since 2.0
 */
public class DateFormatUtils {

  /** The UTC time zone (often referred to as GMT). This is private as it is mutable. */
  private static final TimeZone UTC_TIME_ZONE = FastTimeZone.getGmtTimeZone();

  /**
   * ISO 8601 formatter for date-time without time zone.
   *
   * <p>The format used is {@code yyyy-MM-dd'T'HH:mm:ss}. This format uses the default TimeZone in
   * effect at the time of loading DateFormatUtils class.
   *
   * @since 3.5
   */
  public static final FastDateFormat ISO_8601_EXTENDED_DATETIME_FORMAT =
      FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");

  /**
   * ISO 8601 formatter for date-time with time zone.
   *
   * <p>The format used is {@code yyyy-MM-dd'T'HH:mm:ssZZ}. This format uses the default TimeZone in
   * effect at the time of loading DateFormatUtils class.
   *
   * @since 3.5
   */
  public static final FastDateFormat ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT =
      FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");

  /**
   * ISO 8601 formatter for date without time zone.
   *
   * <p>The format used is {@code yyyy-MM-dd}. This format uses the default TimeZone in effect at
   * the time of loading DateFormatUtils class.
   *
   * @since 3.5
   */
  public static final FastDateFormat ISO_8601_EXTENDED_DATE_FORMAT =
      FastDateFormat.getInstance("yyyy-MM-dd");

  /**
   * ISO 8601 formatter for time without time zone.
   *
   * <p>The format used is {@code HH:mm:ss}. This format uses the default TimeZone in effect at the
   * time of loading DateFormatUtils class.
   *
   * @since 3.5
   */
  public static final FastDateFormat ISO_8601_EXTENDED_TIME_FORMAT =
      FastDateFormat.getInstance("HH:mm:ss");

  /**
   * ISO 8601 formatter for time with time zone.
   *
   * <p>The format used is {@code HH:mm:ssZZ}. This format uses the default TimeZone in effect at
   * the time of loading DateFormatUtils class.
   *
   * @since 3.5
   */
  public static final FastDateFormat ISO_8601_EXTENDED_TIME_TIME_ZONE_FORMAT =
      FastDateFormat.getInstance("HH:mm:ssZZ");

  /**
   * SMTP (and probably other) date headers.
   *
   * <p>The format used is {@code EEE, dd MMM yyyy HH:mm:ss Z} in US locale. This format uses the
   * default TimeZone in effect at the time of loading DateFormatUtils class.
   */
  public static final FastDateFormat SMTP_DATETIME_FORMAT =
      FastDateFormat.getInstance("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);

  /**
   * Formats this date in the standard ISO yyyy-MM-dd HH:mm:ss format.
   *
   * @param date The date to format.
   * @return The date in ISO format. An empty string if the date is null.
   */
  public static String formatDateAsIsoString(Date date) {
    if (date == null) {
      return "";
    }
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
  }

  /**
   * Formats the time of this date in the standard ISO HH:mm:ss format.
   *
   * @param date The date to format.
   * @return The time in ISO format. An empty string if the time is null.
   */
  public static String formatTimeAsIsoString(Date date) {
    if (date == null) {
      return "";
    }
    return new SimpleDateFormat("HH:mm:ss").format(date);
  }

  // -----------------------------------------------------------------------
  /**
   * DateFormatUtils instances should NOT be constructed in standard programming.
   *
   * <p>This constructor is public to permit tools that require a JavaBean instance to operate.
   */
  public DateFormatUtils() {
    super();
  }

  /**
   * Formats a date/time into a specific pattern using the UTC time zone.
   *
   * @param millis the date to format expressed in milliseconds
   * @param pattern the pattern to use to format the date, not null
   * @return the formatted date
   */
  public static String formatUTC(final long millis, final String pattern) {
    return format(new Date(millis), pattern, UTC_TIME_ZONE, null);
  }

  /**
   * Formats a date/time into a specific pattern using the UTC time zone.
   *
   * @param date the date to format, not null
   * @param pattern the pattern to use to format the date, not null
   * @return the formatted date
   */
  public static String formatUTC(final Date date, final String pattern) {
    return format(date, pattern, UTC_TIME_ZONE, null);
  }

  /**
   * Formats a date/time into a specific pattern using the UTC time zone.
   *
   * @param millis the date to format expressed in milliseconds
   * @param pattern the pattern to use to format the date, not null
   * @param locale the locale to use, may be {@code null}
   * @return the formatted date
   */
  public static String formatUTC(final long millis, final String pattern, final Locale locale) {
    return format(new Date(millis), pattern, UTC_TIME_ZONE, locale);
  }

  /**
   * Formats a date/time into a specific pattern using the UTC time zone.
   *
   * @param date the date to format, not null
   * @param pattern the pattern to use to format the date, not null
   * @param locale the locale to use, may be {@code null}
   * @return the formatted date
   */
  public static String formatUTC(final Date date, final String pattern, final Locale locale) {
    return format(date, pattern, UTC_TIME_ZONE, locale);
  }

  /**
   * Formats a date/time into a specific pattern.
   *
   * @param millis the date to format expressed in milliseconds
   * @param pattern the pattern to use to format the date, not null
   * @return the formatted date
   */
  public static String format(final long millis, final String pattern) {
    return format(new Date(millis), pattern, null, null);
  }

  /**
   * Formats a date/time into a specific pattern.
   *
   * @param date the date to format, not null
   * @param pattern the pattern to use to format the date, not null
   * @return the formatted date
   */
  public static String format(final Date date, final String pattern) {
    return format(date, pattern, null, null);
  }

  /**
   * Formats a calendar into a specific pattern.
   *
   * @param calendar the calendar to format, not null
   * @param pattern the pattern to use to format the calendar, not null
   * @return the formatted calendar
   * @see FastDateFormat#format(Calendar)
   * @since 2.4
   */
  public static String format(final Calendar calendar, final String pattern) {
    return format(calendar, pattern, null, null);
  }

  /**
   * Formats a date/time into a specific pattern in a time zone.
   *
   * @param millis the time expressed in milliseconds
   * @param pattern the pattern to use to format the date, not null
   * @param timeZone the time zone to use, may be {@code null}
   * @return the formatted date
   */
  public static String format(final long millis, final String pattern, final TimeZone timeZone) {
    return format(new Date(millis), pattern, timeZone, null);
  }

  /**
   * Formats a date/time into a specific pattern in a time zone.
   *
   * @param date the date to format, not null
   * @param pattern the pattern to use to format the date, not null
   * @param timeZone the time zone to use, may be {@code null}
   * @return the formatted date
   */
  public static String format(final Date date, final String pattern, final TimeZone timeZone) {
    return format(date, pattern, timeZone, null);
  }

  /**
   * Formats a calendar into a specific pattern in a time zone.
   *
   * @param calendar the calendar to format, not null
   * @param pattern the pattern to use to format the calendar, not null
   * @param timeZone the time zone to use, may be {@code null}
   * @return the formatted calendar
   * @see FastDateFormat#format(Calendar)
   * @since 2.4
   */
  public static String format(
      final Calendar calendar, final String pattern, final TimeZone timeZone) {
    return format(calendar, pattern, timeZone, null);
  }

  /**
   * Formats a date/time into a specific pattern in a locale.
   *
   * @param millis the date to format expressed in milliseconds
   * @param pattern the pattern to use to format the date, not null
   * @param locale the locale to use, may be {@code null}
   * @return the formatted date
   */
  public static String format(final long millis, final String pattern, final Locale locale) {
    return format(new Date(millis), pattern, null, locale);
  }

  /**
   * Formats a date/time into a specific pattern in a locale.
   *
   * @param date the date to format, not null
   * @param pattern the pattern to use to format the date, not null
   * @param locale the locale to use, may be {@code null}
   * @return the formatted date
   */
  public static String format(final Date date, final String pattern, final Locale locale) {
    return format(date, pattern, null, locale);
  }

  /**
   * Formats a calendar into a specific pattern in a locale.
   *
   * @param calendar the calendar to format, not null
   * @param pattern the pattern to use to format the calendar, not null
   * @param locale the locale to use, may be {@code null}
   * @return the formatted calendar
   * @see FastDateFormat#format(Calendar)
   * @since 2.4
   */
  public static String format(final Calendar calendar, final String pattern, final Locale locale) {
    return format(calendar, pattern, null, locale);
  }

  /**
   * Formats a date/time into a specific pattern in a time zone and locale.
   *
   * @param millis the date to format expressed in milliseconds
   * @param pattern the pattern to use to format the date, not null
   * @param timeZone the time zone to use, may be {@code null}
   * @param locale the locale to use, may be {@code null}
   * @return the formatted date
   */
  public static String format(
      final long millis, final String pattern, final TimeZone timeZone, final Locale locale) {
    return format(new Date(millis), pattern, timeZone, locale);
  }

  /**
   * Formats a date/time into a specific pattern in a time zone and locale.
   *
   * @param date the date to format, not null
   * @param pattern the pattern to use to format the date, not null, not null
   * @param timeZone the time zone to use, may be {@code null}
   * @param locale the locale to use, may be {@code null}
   * @return the formatted date
   */
  public static String format(
      final Date date, final String pattern, final TimeZone timeZone, final Locale locale) {
    final FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale);
    return df.format(date);
  }

  /**
   * Formats a calendar into a specific pattern in a time zone and locale.
   *
   * @param calendar the calendar to format, not null
   * @param pattern the pattern to use to format the calendar, not null
   * @param timeZone the time zone to use, may be {@code null}
   * @param locale the locale to use, may be {@code null}
   * @return the formatted calendar
   * @see FastDateFormat#format(Calendar)
   * @since 2.4
   */
  public static String format(
      final Calendar calendar, final String pattern, final TimeZone timeZone, final Locale locale) {
    final FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale);
    return df.format(calendar);
  }
}
