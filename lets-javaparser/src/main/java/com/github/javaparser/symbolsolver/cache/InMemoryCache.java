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
package com.github.javaparser.symbolsolver.cache;

import com.github.javaparser.resolution.cache.Cache;
import com.github.javaparser.resolution.cache.CacheStats;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;

/**
 * A cache implementation that stores the information in memory. <br>
 * The current implementation stores the values in memory in a {@link WeakHashMap}.
 *
 * @param <K> The type of the key.
 * @param <V> The type of the value.
 */
public class InMemoryCache<K, V> implements Cache<K, V> {

  /**
   * Create a new instance for a cache in memory.
   *
   * @param <expectedK> The expected type for the key.
   * @param <expectedV> The expected type for the value.
   * @return A newly created instance of {@link InMemoryCache}.
   */
  public static <expectedK, expectedV> InMemoryCache<expectedK, expectedV> create() {
    return new InMemoryCache<>();
  }

  private final Map<K, V> mappedValues;

  private InMemoryCache() {
    mappedValues = Collections.synchronizedMap(new WeakHashMap<>());
  }

  @Override
  public void put(K key, V value) {
    mappedValues.put(key, value);
  }

  @Override
  public Optional<V> get(K key) {
    return Optional.ofNullable(mappedValues.get(key));
  }

  @Override
  public void remove(K key) {
    mappedValues.remove(key);
  }

  @Override
  public void removeAll() {
    mappedValues.clear();
  }

  @Override
  public boolean contains(K key) {
    return mappedValues.containsKey(key);
  }

  @Override
  public long size() {
    return mappedValues.size();
  }

  @Override
  public boolean isEmpty() {
    return mappedValues.isEmpty();
  }

  @Override
  public CacheStats stats() {
    return new DefaultCacheStats();
  }
}
