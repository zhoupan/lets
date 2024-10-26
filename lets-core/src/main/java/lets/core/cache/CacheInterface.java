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
package lets.core.cache;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import lets.core.DataResultSupport;
import lets.core.ResultSupport;

/**
 * 缓存接口定义.
 *
 * @author zhoupan
 */
public interface CacheInterface {
  /**
   * Fetches a value from the cache.
   *
   * @param string key The unique key of this item in the cache.
   * @param mixed default Default value to return if the key does not exist. value.
   */
  public <K, V> V get(K key, V defaultValue);

  /**
   * Fetches a value from the cache.
   *
   * @param string key The unique key of this item in the cache.
   */
  public <K, V> Optional<V> get(K key);

  /**
   * Persists data in the cache, uniquely referenced by a key with an optional expiration TTL time.
   *
   * @param string key The key of the item to store.
   * @param value The value of the item to store, must be serializable.
   * @param ttl - time to live for key\value entry. If <code>0</code> then stores infinitely.
   * @param ttlUnit - time unit
   */
  public <K, V> ResultSupport set(K key, V value, long ttl, TimeUnit ttlUnit);

  /**
   * Delete an item from the cache by its unique key.
   *
   * @param key The unique cache key of the item to delete.
   */
  public <K> ResultSupport delete(K key);

  /** Wipes clean the entire cache's keys. */
  public ResultSupport clear();

  /**
   * Obtains multiple cache items by their unique keys.
   *
   * @param iterable keys A list of keys that can obtained in a single operation.
   * @param defaultValue default Default value to return for keys that do not exist.
   */
  public <K, V> DataResultSupport<List<V>> getMultiple(Iterator<K> keys, V defaultValue);

  /**
   * Persists a set of key => value pairs in the cache, with an optional TTL.
   *
   * @param iterable values A list of key => value pairs for a multiple-set operation.
   * @param ttl - time to live for key\value entry. If <code>0</code> then stores infinitely.
   * @param ttlUnit - time unit
   */
  public <K, V> ResultSupport setMultiple(Map<K, V> values, long ttl, TimeUnit ttlUnit);

  /**
   * Deletes multiple cache items in a single operation.
   *
   * @param iterable keys A list of string-based keys to be deleted.
   */
  public <K> ResultSupport deleteMultiple(Iterator<K> keys);

  /**
   * Determines whether an item is present in the cache.
   *
   * <p>NOTE: It is recommended that has() is only to be used for cache warming type purposes and
   * not to be used within your live applications operations for get/set, as this method is subject
   * to a race condition where your has() will return true and immediately after, another script can
   * remove it making the state of your app out of date.
   *
   * @param string key The cache item key.
   */
  public <K> boolean has(K key);
}
