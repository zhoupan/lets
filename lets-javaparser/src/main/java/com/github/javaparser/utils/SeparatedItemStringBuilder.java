/*
 * Copyright (c) 2007-2010 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.utils;

/**
 * Builds a string containing a list of items with a prefix, a postfix, and a separator. <br>
 * Example: (1,2,3) which has prefix "(", separator ",", postfix ")" and the items 1 through 3.
 *
 * <p>Java 8 offers the very nice Collectors.joining(String, String, String) which does the same
 * thing.
 */
public class SeparatedItemStringBuilder {

  private final String separator;

  private final String postfix;

  private boolean hasItems = false;

  private StringBuilder builder;

  public SeparatedItemStringBuilder(String prefix, String separator, String postfix) {
    builder = new StringBuilder(prefix);
    this.separator = separator;
    this.postfix = postfix;
  }

  /**
   * Add one item. Either pass a string, or a format for String.format and corresponding arguments.
   */
  public SeparatedItemStringBuilder append(CharSequence format, Object... args) {
    if (hasItems) {
      builder.append(separator);
    }
    builder.append(String.format(format.toString(), args));
    hasItems = true;
    return this;
  }

  public boolean hasItems() {
    return hasItems;
  }

  /** Convert the builder into its final string representation. */
  @Override
  public String toString() {
    // This order of toStringing avoids debuggers from making a mess.
    return builder.toString() + postfix;
  }
}
