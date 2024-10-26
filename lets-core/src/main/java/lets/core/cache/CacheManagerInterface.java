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

/** 缓存管理接口. */
public interface CacheManagerInterface {

  /**
   * Gets the cache.
   *
   * @param namespace the namespace
   * @param cacheName the cache name
   * @return the cache
   */
  CacheInterface getCache(String namespace, String cacheName);

  /**
   * Gets the or create cache.
   *
   * @param namespace the namespace
   * @param cacheName the cache name
   * @return the or create cache
   */
  CacheInterface getOrCreateCache(String namespace, String cacheName);

  /**
   * Put cache.
   *
   * @param namespace the namespace
   * @param cacheName the cache name
   * @param cache the cache
   */
  void putCache(String namespace, String cacheName, CacheInterface cache);
}
