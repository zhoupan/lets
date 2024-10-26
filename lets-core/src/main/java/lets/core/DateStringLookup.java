/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Formats the current date with the format given in the key in a format compatible with {@link
 * java.text.SimpleDateFormat}.
 *
 * <p>Using a {@link StringLookup} from the {@link StringLookupFactory}:
 *
 * <pre>
 * StringLookupFactory.INSTANCE.dateStringLookup().lookup("yyyy-MM-dd");
 * </pre>
 *
 * <p>Using a {@link StringSubstitutor}:
 *
 * <pre>
 * StringSubstitutor.createInterpolator().replace("... ${date:yyyy-MM-dd} ..."));
 * </pre>
 *
 * <p>The above examples convert {@code "yyyy-MM-dd"} to today's date, for example, {@code
 * "2019-08-04"}.
 */
final class DateStringLookup extends AbstractStringLookup {

  /** Defines the singleton for this class. */
  static final DateStringLookup INSTANCE = new DateStringLookup();

  /** No need to build instances for now. */
  private DateStringLookup() {
    // empty
  }

  /**
   * Formats the given {@code date} long with the given {@code format}.
   *
   * @param dateMillis the date to format
   * @param format the format string for {@link SimpleDateFormat}.
   * @return The formatted date
   */
  private String formatDate(final long dateMillis, final String format) {
    FastDateFormat dateFormat = null;
    if (format != null) {
      try {
        dateFormat = FastDateFormat.getInstance(format);
      } catch (final Exception ex) {
        throw IllegalArgumentExceptions.format(ex, "Invalid date format: [%s]", format);
      }
    }
    if (dateFormat == null) {
      dateFormat = FastDateFormat.getInstance();
    }
    return dateFormat.format(new Date(dateMillis));
  }

  /**
   * Formats the current date with the format given in the key in a format compatible with {@link
   * java.text.SimpleDateFormat}.
   *
   * @param key the format to use. If null, the default {@link DateFormat} will be used.
   * @return The value of the environment variable.
   */
  @Override
  public String lookup(final String key) {
    return formatDate(System.currentTimeMillis(), key);
  }
}
