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
package lets.core.concurrent;

import java.util.concurrent.atomic.AtomicLong;

/**
 * AbstractCallable.
 *
 * @author zhoupan
 * @param <V> the value type
 */
public abstract class AbstractCallable<V> implements CallableWithId<V> {

  /** The Constant counter. */
  private static final AtomicLong counter = new AtomicLong(0);

  /** The id. */
  private final String id;

  /**
   * Instantiates a new abstract callable.
   *
   * @param id the id
   */
  public AbstractCallable(String id) {
    super();
    this.id = id;
  }

  /** Instantiates a new abstract callable. */
  public AbstractCallable() {
    this(String.format("CallableWithId(%s)", counter.incrementAndGet()));
  }

  /**
   * Id.
   *
   * @return the string
   */
  @Override
  public String id() {
    return this.id;
  }
}
