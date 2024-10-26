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
package lets.core.counter;

/**
 * 记数器
 *
 * @author zhoupan
 */
public interface Counter {

  /**
   * Increment the counter by 1
   *
   * @return the value after incrementing
   */
  long increment(String key);

  /**
   * Decrement the counter by 1
   *
   * @return the value after decrementing
   */
  long decrement(String key);

  /**
   * Returns the value of the counter and sets it to the new value
   *
   * @param newValue
   * @return Returns the old value
   */
  long getAndSet(String key, long newValue);

  /**
   * Gets current value of the counter
   *
   * @return current value of the counter
   */
  long getValue(String key);

  /**
   * Increment the counter by given amount
   *
   * @param amount
   * @return the value of the counter after incrementing
   */
  long increment(String key, long amount);

  /**
   * Decrement the counter by given amount
   *
   * @param amount
   * @return the value of the counter after decrementing
   */
  long decrement(String key, long amount);

  /**
   * Sets the value of the counter to the supplied value
   *
   * @param newValue
   */
  void setValue(String key, long newValue);
}
