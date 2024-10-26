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
import java.util.List;

/**
 * 值和文本对象支持.
 *
 * @author zhoupan
 * @param <Value>
 * @param <Text>
 */
public class ValueTextSupport<Value, Text> implements java.io.Serializable {

  /** */
  private static final long serialVersionUID = 1L;

  private Value value;
  private Text text;

  public ValueTextSupport(Value value, Text text) {
    super();
    this.value = value;
    this.text = text;
  }

  public Value getValue() {
    return value;
  }

  public void setValue(Value value) {
    this.value = value;
  }

  public Text getText() {
    return text;
  }

  public void setText(Text text) {
    this.text = text;
  }

  public void valueAndText(Value value, Text text) {
    this.setValue(value);
    this.setText(text);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((text == null) ? 0 : text.hashCode());
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ValueTextSupport other = (ValueTextSupport) obj;
    if (text == null) {
      if (other.text != null) return false;
    } else if (!text.equals(other.text)) return false;
    if (value == null) {
      if (other.value != null) return false;
    } else if (!value.equals(other.value)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "ValueTextSupport [value=" + value + ", text=" + text + "]";
  }

  @SuppressWarnings("unchecked")
  public static <Value, Text> List<ValueTextSupport<Value, Text>> buildFrom(Object... args) {
    List<ValueTextSupport<Value, Text>> items = new ArrayList<ValueTextSupport<Value, Text>>();
    for (int i = 0; i < args.length - 1; i = i + 2) {
      Value value = (Value) args[i];
      Text text = (Text) args[i + 1];
      items.add(new ValueTextSupport<Value, Text>(value, text));
    }
    return items;
  }

  public static <Value, Text> List<Value> buildValues(List<ValueTextSupport<Value, Text>> items) {
    List<Value> values = new ArrayList<>();
    for (ValueTextSupport<Value, Text> item : items) {
      values.add(item.getValue());
    }
    return values;
  }

  public static <Value, Text> List<Text> buildTexts(List<ValueTextSupport<Value, Text>> items) {
    List<Text> texts = new ArrayList<>();
    for (ValueTextSupport<Value, Text> item : items) {
      texts.add(item.getText());
    }
    return texts;
  }
}
