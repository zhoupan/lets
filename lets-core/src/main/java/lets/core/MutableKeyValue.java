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

/**
 * The Interface MutableKeyValue.
 *
 * @param <Key> the generic type
 * @param <Value> the generic type
 */
public interface MutableKeyValue<Key, Value> {

  /**
   * Gets the value of this mutable.
   *
   * @param key the key
   * @return the stored value
   */
  Value getValue(Key key);

  /**
   * Sets the value.
   *
   * @param key the key
   * @param value the value
   */
  void setValue(Key key, Value value);
}
