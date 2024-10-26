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
package lets.core.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.function.Consumer;
import lets.core.CoreUtils;
import lets.core.StringUtils;

/** StringNameValueList. */
public class StringNameValueList {
  /** The Constant LIST_NAME_SEPARATOR_DEFAULT. */
  public static final String LIST_NAME_SEPARATOR_DEFAULT = ":";

  /** The Constant LIST_NAME_SEPARATOR_COOKIE. */
  public static final String LIST_NAME_SEPARATOR_COOKIE = ": ";

  /** The Constant LIST_NAME_COOKIE. */
  public static final String LIST_NAME_COOKIE = "Cookie";

  /** The Constant ITEM_NAME_SEPARATOR_DEFAULT. */
  public static final String ITEM_NAME_SEPARATOR_DEFAULT = "=";

  /** The Constant ITEM_NAME_SEPARATOR_COOKIE. */
  public static final String ITEM_NAME_SEPARATOR_COOKIE = "=";

  /** The Constant ITEM_VALUE_SEPARATOR_DEFAULT. */
  public static final String ITEM_VALUE_SEPARATOR_DEFAULT = ";";

  /** The Constant ITEM_VALUE_SEPARATOR_COOKIE. */
  public static final String ITEM_VALUE_SEPARATOR_COOKIE = "; ";

  /** The name. */
  private String name = "";

  /** The value. */
  private String value = "";

  /** The list name separator. */
  private String listNameSeparator = LIST_NAME_SEPARATOR_DEFAULT;

  /** The item name separator. */
  private String itemNameSeparator = ITEM_NAME_SEPARATOR_DEFAULT;

  /** The item value separator. */
  private String itemValueSeparator = ITEM_VALUE_SEPARATOR_DEFAULT;

  /** The items. */
  private List<StringNameValue> items = new ArrayList<StringNameValue>();

  /**
   * Put.
   *
   * @param name the name
   * @param value the value
   * @return the string name value list
   */
  public StringNameValueList put(String name, String value) {
    StringNameValue item = new StringNameValue(name, value);
    if (!items.contains(item)) {
      items.add(item);
    }
    return this;
  }

  /**
   * Put all.
   *
   * @param map the map
   * @return the string name value list
   */
  public StringNameValueList putAll(Map<Object, Object> map) {
    Consumer<Entry<Object, Object>> action =
        new Consumer<Entry<Object, Object>>() {

          @Override
          public void accept(Entry<Object, Object> t) {
            Object key = t.getKey();
            Object value = t.getValue();
            if (CoreUtils.isNotEmpty(key)) {
              put(key.toString(), value != null ? value.toString() : "");
            }
          }
        };
    map.entrySet().forEach(action);
    return this;
  }

  /**
   * Name.
   *
   * @param name the name
   * @return the string name value list
   */
  public StringNameValueList name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Value.
   *
   * @param value the value
   * @return the string name value list
   */
  public StringNameValueList value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Sets the value.
   *
   * @param value the value
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Gets the item name separator.
   *
   * @return the item name separator
   */
  public String getItemNameSeparator() {
    return itemNameSeparator;
  }

  /**
   * Sets the item name separator.
   *
   * @param itemNameSeparator the item name separator
   */
  public void setItemNameSeparator(String itemNameSeparator) {
    this.itemNameSeparator = itemNameSeparator;
  }

  /**
   * Gets the item value separator.
   *
   * @return the item value separator
   */
  public String getItemValueSeparator() {
    return itemValueSeparator;
  }

  /**
   * Sets the item value separator.
   *
   * @param itemValueSeparator the item value separator
   */
  public void setItemValueSeparator(String itemValueSeparator) {
    this.itemValueSeparator = itemValueSeparator;
  }

  /**
   * Gets the items.
   *
   * @return the items
   */
  public List<StringNameValue> getItems() {
    return items;
  }

  /**
   * Sets the items.
   *
   * @param items the items
   */
  public void setItems(List<StringNameValue> items) {
    this.items = items;
  }

  /**
   * List name separator.
   *
   * @param separator the separator
   * @return the string name value list
   */
  public StringNameValueList listNameSeparator(String separator) {
    this.listNameSeparator = separator;
    return this;
  }

  /**
   * Item name separator.
   *
   * @param separator the separator
   * @return the string name value list
   */
  public StringNameValueList itemNameSeparator(String separator) {
    this.itemNameSeparator = separator;
    return this;
  }

  /**
   * Item value separator.
   *
   * @param separator the separator
   * @return the string name value list
   */
  public StringNameValueList itemValueSeparator(String separator) {
    this.itemValueSeparator = separator;
    return this;
  }

  /**
   * Parses the.
   *
   * @param rawText the rawText
   * @return the string name value list
   */
  public StringNameValueList parse(String rawText) {
    if (StringUtils.contains(rawText, this.listNameSeparator)) {
      this.name = StringUtils.substringBefore(rawText, this.listNameSeparator);
      this.value = StringUtils.substringAfter(rawText, this.listNameSeparator);
    } else {
      this.value = rawText;
    }
    String[] lines = null;
    if (StringUtils.contains(this.value, this.itemValueSeparator)) {
      lines = StringUtils.split(this.value, this.itemValueSeparator);
    } else {
      lines = new String[] {this.value};
    }
    if (lines == null) {
      return this;
    }
    for (String line : lines) {
      StringNameValue nameValue = this.paraseNameValue(line);
      if (nameValue != null) {
        this.items.add(nameValue);
      }
    }
    return this;
  }

  /**
   * Parses the name value.
   *
   * @param text the text
   * @param itemNameSeparator the item name separator
   * @return the string name value
   */
  public static StringNameValue parseNameValue(String text, String itemNameSeparator) {
    String name = StringUtils.substringBefore(text, itemNameSeparator);
    String value = StringUtils.substringAfter(text, itemNameSeparator);
    return new StringNameValue(name, value);
  }

  /**
   * Parses the cookies.
   *
   * @param text the text
   * @return the string name value list
   */
  public static StringNameValueList parseCookies(String text) {
    return new StringNameValueList()
        .name(LIST_NAME_COOKIE)
        .itemNameSeparator(ITEM_NAME_SEPARATOR_COOKIE)
        .itemValueSeparator(ITEM_VALUE_SEPARATOR_COOKIE)
        .parse(text);
  }

  /**
   * Parase name value.
   *
   * @param text the text
   * @return the string name value
   */
  public StringNameValue paraseNameValue(String text) {
    return parseNameValue(text, this.itemNameSeparator);
  }

  /**
   * Gets the item text.
   *
   * @return the item text
   */
  public String getItemText() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < this.items.size(); i++) {
      StringNameValue nameValue = this.items.get(i);
      if (i > 0) {
        sb.append(this.itemValueSeparator);
      }
      sb.append(nameValue.getName());
      sb.append(this.itemNameSeparator);
      sb.append(nameValue.getValue());
    }
    return sb.toString();
  }

  /**
   * Gets the full text.
   *
   * @return the full text
   */
  public String getFullText() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.name).append(this.listNameSeparator).append(this.getItemText());
    return sb.toString();
  }

  /**
   * As properties.
   *
   * @return the properties
   */
  public Properties asProperties() {
    Properties props = new Properties();
    for (StringNameValue item : this.items) {
      props.put(item.getName(), item.getValue());
    }
    return props;
  }

  /**
   * As map.
   *
   * @return the map< string, string>
   */
  public Map<String, String> asMap() {
    Map<String, String> props = new HashMap<String, String>();
    for (StringNameValue item : this.items) {
      props.put(item.getName(), item.getValue());
    }
    return props;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("StringNameValueList [name=").append(name).append(", value=").append(value);
    if (!this.items.isEmpty()) {
      sb.append(", items=").append(this.items);
    }
    sb.append("]");
    return sb.toString();
  }
}
