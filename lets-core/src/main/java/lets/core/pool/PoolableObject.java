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
package lets.core.pool;

import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoolableObject<T> implements Poolable {

  static final AtomicLong ID = new AtomicLong(0);

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final Slot slot;
  private final Long objectId = ID.incrementAndGet();
  private T object;

  public PoolableObject(Slot slot, T object) {
    super();
    this.slot = slot;
    this.object = object;
  }

  public Long getObjectId() {
    return objectId;
  }

  @Override
  public void release() {
    this.logger.info("release: objectId={} object={}", this.objectId, this.object);
    this.slot.release(this);
  }

  public Logger getLogger() {
    return logger;
  }

  public T getObject() {
    return object;
  }

  public void setObject(T object) {
    this.object = object;
  }

  public Slot getSlot() {
    return slot;
  }
}
