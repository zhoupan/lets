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
import java.util.Optional;

/**
 * A cache implementation that does not store any information.
 *
 * @param <K> The key type.
 * @param <V> The value type.
 */
public class NoCache<K, V> implements Cache<K, V> {

  /**
   * Create a new instance.
   *
   * @param <expectedK> The expected type for the key.
   * @param <expectedV> The expected type for the value.
   * @return A newly created instance of {@link NoCache}.
   */
  public static <expectedK, expectedV> NoCache<expectedK, expectedV> create() {
    return new NoCache<>();
  }

  @Override
  public void put(K key, V value) {
    // Nothing to do here.
  }

  @Override
  public Optional<V> get(K key) {
    return Optional.empty();
  }

  @Override
  public void remove(K key) {
    // Nothing to do here.
  }

  @Override
  public void removeAll() {
    // Nothing to do here.
  }

  @Override
  public boolean contains(K key) {
    return false;
  }

  @Override
  public long size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public CacheStats stats() {
    return new DefaultCacheStats();
  }
}
