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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lets.core.event.EventListenerList;
import lets.core.event.OnChangedListener;

/**
 * The Class DefaultMutableKeyValue.
 *
 * @param <Key> the generic type
 * @param <Value> the generic type
 */
public class DefaultMutableKeyValue<Key, Value> implements MutableKeyValue<Key, Value> {

  /**
   * The Class KeyValueHolder.
   *
   * @param <Key> the generic type
   * @param <Value> the generic type
   */
  public static final class KeyValue<Key, Value> {

    /** The key. */
    private final Key key;

    /** The value. */
    private final Value value;

    /**
     * Instantiates a new key value holder.
     *
     * @param key the key
     * @param value the value
     */
    public KeyValue(Key key, Value value) {
      super();
      this.key = key;
      this.value = value;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public Key getKey() {
      return key;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public Value getValue() {
      return value;
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
      result = (prime * result) + ((key == null) ? 0 : key.hashCode());
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
      KeyValue other = (KeyValue) obj;
      if (key == null) {
        if (other.key != null) {
          return false;
        }
      } else if (!key.equals(other.key)) {
        return false;
      }
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
      return "KeyValue [key=" + key + ", value=" + value + "]";
    }
  }

  /** The holder. */
  private final Map<Key, Value> holder = new ConcurrentHashMap<Key, Value>();

  /** The listener list. */
  protected EventListenerList listenerList = new EventListenerList();

  /** The name. */
  public final MutableValue<String> name = new MutableValue<String>();

  /** The fire changed event only when not equals. */
  public final MutableValue<Boolean> fireChangedEventOnlyWhenNotEquals =
      new MutableValue<Boolean>().set(true);

  /**
   * Gets the value.
   *
   * @param key the key
   * @return the value
   */
  @Override
  public Value getValue(Key key) {
    return holder.get(key);
  }

  /**
   * Sets the value.
   *
   * @param key the key
   * @param value the value
   */
  @Override
  public void setValue(Key key, Value value) {
    Value fromValue = this.getValue(key);
    Value toValue = value;
    boolean valueEquals = ObjectUtils.equals(fromValue, toValue);
    if (!valueEquals) {
      this.holder.put(key, value);
    }
    if (this.fireChangedEventOnlyWhenNotEquals.isPresent()
        && this.fireChangedEventOnlyWhenNotEquals.get()
        && valueEquals) {
      return;
    }

    KeyValue<Key, Value> keyValue = new KeyValue<Key, Value>(key, value);
    this.fireChangedEvent(keyValue);
  }

  /**
   * Adds the on change listener.
   *
   * @param onChangeListener the on change listener
   */
  public void addOnChangedListener(OnChangedListener<KeyValue<Key, Value>> onChangeListener) {
    this.removeOnChangedListener(onChangeListener);
    this.listenerList.add(OnChangedListener.class, onChangeListener);
  }

  /**
   * Removes the on change listener.
   *
   * @param onChangeListener the on change listener
   */
  public void removeOnChangedListener(OnChangedListener<KeyValue<Key, Value>> onChangeListener) {
    this.listenerList.remove(OnChangedListener.class, onChangeListener);
  }

  /**
   * Fire change event.
   *
   * @param keyValue the key value
   */
  @SuppressWarnings("unchecked")
  public void fireChangedEvent(KeyValue<Key, Value> keyValue) {
    for (OnChangedListener<KeyValue<Key, Value>> listener :
        this.listenerList.getListeners(OnChangedListener.class)) {
      listener.onChanged(keyValue);
    }
  }
}
