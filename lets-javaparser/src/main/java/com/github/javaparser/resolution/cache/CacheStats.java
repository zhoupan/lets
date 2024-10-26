/*
 * Copyright (c) 2013-2024 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.resolution.cache;

public interface CacheStats {

  /**
   * Returns the number of times lookup methods have returned either a cached or uncached value.
   * This is defined as {@code hitCount + missCount}.
   *
   * <p><b>Note:</b> the values of the metrics are undefined in case of overflow (though it is
   * guaranteed not to throw an exception). If you require specific handling, we recommend
   * implementing your own stats collector.
   */
  long requestCount();

  /** Returns the number of times lookup methods have returned a cached value. */
  long hitCount();

  /**
   * Returns the ratio of cache requests which were hits. This is defined as {@code hitCount /
   * requestCount}, or {@code 1.0} when {@code requestCount == 0}. Note that {@code hitRate +
   * missRate =~ 1.0}.
   */
  double hitRate();

  /**
   * Returns the number of times lookup methods have returned an uncached (newly loaded) value, or
   * null. Multiple concurrent calls to lookup methods on an absent value can result in multiple
   * misses, all returning the results of a single cache load operation.
   */
  long missCount();

  /**
   * Returns the ratio of cache requests which were misses. This is defined as {@code missCount /
   * requestCount}, or {@code 0.0} when {@code requestCount == 0}. Note that {@code hitRate +
   * missRate =~ 1.0}. Cache misses include all requests which weren't cache hits, including
   * requests which resulted in either successful or failed loading attempts, and requests which
   * waited for other threads to finish loading. It is thus the case that {@code missCount &gt;=
   * loadSuccessCount + loadExceptionCount}. Multiple concurrent misses for the same key will result
   * in a single load operation.
   */
  double missRate();

  /**
   * Returns the total number of times that lookup methods attempted to load new values. This
   * includes both successful load operations and those that threw exceptions. This is defined as
   * {@code loadSuccessCount + loadExceptionCount}.
   *
   * <p><b>Note:</b> the values of the metrics are undefined in case of overflow (though it is
   * guaranteed not to throw an exception). If you require specific handling, we recommend
   * implementing your own stats collector.
   */
  long loadCount();

  /**
   * Returns the number of times lookup methods have successfully loaded a new value. This is
   * usually incremented in conjunction with {@link #missCount}, though {@code missCount} is also
   * incremented when an exception is encountered during cache loading (see {@link
   * #loadExceptionCount}). Multiple concurrent misses for the same key will result in a single load
   * operation. This may be incremented not in conjunction with {@code missCount} if the load occurs
   * as a result of a refresh or if the cache loader returned more items than was requested. {@code
   * missCount} may also be incremented not in conjunction with this (nor {@link
   * #loadExceptionCount}) on calls to {@code getIfPresent}.
   */
  long loadSuccessCount();

  /**
   * Returns the number of times lookup methods threw an exception while loading a new value. This
   * is usually incremented in conjunction with {@code missCount}, though {@code missCount} is also
   * incremented when cache loading completes successfully (see {@link #loadSuccessCount}). Multiple
   * concurrent misses for the same key will result in a single load operation. This may be
   * incremented not in conjunction with {@code missCount} if the load occurs as a result of a
   * refresh or if the cache loader returned more items than was requested. {@code missCount} may
   * also be incremented not in conjunction with this (nor {@link #loadSuccessCount}) on calls to
   * {@code getIfPresent}.
   */
  long loadExceptionCount();

  /**
   * Returns the ratio of cache loading attempts which threw exceptions. This is defined as {@code
   * loadExceptionCount / (loadSuccessCount + loadExceptionCount)}, or {@code 0.0} when {@code
   * loadSuccessCount + loadExceptionCount == 0}.
   *
   * <p><b>Note:</b> the values of the metrics are undefined in case of overflow (though it is
   * guaranteed not to throw an exception). If you require specific handling, we recommend
   * implementing your own stats collector.
   */
  double loadExceptionRate();

  /**
   * Returns the total number of nanoseconds the cache has spent loading new values. This can be
   * used to calculate the miss penalty. This value is increased every time {@code loadSuccessCount}
   * or {@code loadExceptionCount} is incremented.
   */
  long totalLoadTime();

  /**
   * Returns the average time spent loading new values. This is defined as {@code totalLoadTime /
   * (loadSuccessCount + loadExceptionCount)}.
   *
   * <p><b>Note:</b> the values of the metrics are undefined in case of overflow (though it is
   * guaranteed not to throw an exception). If you require specific handling, we recommend
   * implementing your own stats collector.
   */
  double averageLoadPenalty();

  /**
   * Returns the number of times an entry has been evicted. This count does not include manual
   * invalidations.
   */
  long evictionCount();

  /**
   * Returns a new {@code ICacheStats} representing the difference between this {@code ICacheStats}
   * and {@code other}. Negative values, which aren't supported by {@code ICacheStats} will be
   * rounded up to zero.
   */
  CacheStats minus(CacheStats other);

  /**
   * Returns a new {@code ICacheStats} representing the sum of this {@code ICacheStats} and {@code
   * other}.
   *
   * <p><b>Note:</b> the values of the metrics are undefined in case of overflow (though it is
   * guaranteed not to throw an exception). If you require specific handling, we recommend
   * implementing your own stats collector.
   */
  CacheStats plus(CacheStats other);
}
