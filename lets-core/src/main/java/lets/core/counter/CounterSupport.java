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

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 简单的记数器支持类.
 *
 * @author zhoupan
 */
public class CounterSupport implements java.io.Serializable, Counter {

  /** */
  private static final long serialVersionUID = 1L;

  Map<String, AtomicLong> map = new java.util.concurrent.ConcurrentHashMap<String, AtomicLong>();

  public synchronized AtomicLong get(String key) {
    if (!map.containsKey(key)) {
      map.put(key, new AtomicLong(0));
    }
    return map.get(key);
  }

  public Long next(String key) {
    return this.get(key).incrementAndGet();
  }

  @Override
  public long increment(String key) {
    return this.get(key).incrementAndGet();
  }

  @Override
  public long decrement(String key) {
    return this.get(key).decrementAndGet();
  }

  @Override
  public long getAndSet(String key, long newValue) {
    return this.get(key).getAndSet(newValue);
  }

  @Override
  public long getValue(String key) {
    return this.get(key).longValue();
  }

  @Override
  public long increment(String key, long amount) {
    return this.get(key).addAndGet(amount);
  }

  @Override
  public long decrement(String key, long amount) {
    return this.increment(key, -amount);
  }

  @Override
  public void setValue(String key, long newValue) {
    this.get(key).set(newValue);
  }
}
