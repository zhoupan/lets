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
package lets.core.converter;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import jodd.datetime.JDateTime;
import jodd.typeconverter.TypeConversionException;
import jodd.typeconverter.TypeConverter;
import jodd.typeconverter.TypeConverterManager;
import jodd.util.StringUtil;
import lets.core.DateUtils;
import lets.core.LoggerSupport;
import lets.core.StringUtils;

public class CustomizedDateConverter implements TypeConverter<Date> {
  public static final CustomizedDateConverter INSTANCE = new CustomizedDateConverter();
  public final Vector<String> customizedFormats = new Vector<String>();

  public CustomizedDateConverter() {
    super();
    this.customizedFormats.add("yyyy-MM-dd");
    this.customizedFormats.add("yyyy-MM-dd HH:mm");
    this.customizedFormats.add("yyyy-MM-dd HH:mm:ss");
  }

  public Date convert(Object value) {
    if (value == null) {
      return null;
    }
    if (value instanceof Date) {
      return (Date) value;
    }
    if (value instanceof Calendar) {
      return new Date(((Calendar) value).getTimeInMillis());
    }
    if (value instanceof JDateTime) {
      return ((JDateTime) value).convertToDate();
    }
    if (value instanceof Number) {
      return new Date(((Number) value).longValue());
    }
    String stringValue = value.toString().trim();
    if (StringUtils.isBlank(stringValue)) {
      return null;
    }
    try {
      return DateUtils.parseDateStrictly(
          stringValue, this.customizedFormats.toArray(new String[this.customizedFormats.size()]));
    } catch (Throwable e) {
      LoggerSupport.error("{}", e);
    }
    if (!StringUtil.containsOnlyDigits(stringValue)) {
      // try to parse default string format
      JDateTime jdt = new JDateTime(stringValue, JDateTime.DEFAULT_FORMAT);
      return jdt.convertToDate();
    }
    try {
      long milliseconds = Long.parseLong(stringValue);
      return new Date(milliseconds);
    } catch (NumberFormatException nfex) {
      throw new TypeConversionException(value, nfex);
    }
  }

  public void register() {
    TypeConverterManager.register(Date.class, INSTANCE);
  }
}
