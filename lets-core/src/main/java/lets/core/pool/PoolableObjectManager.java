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

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import lets.core.Consumer;
import lets.core.CoreUtils;
import lets.core.DataResultSupport;
import lets.core.ObjectManager;
import lets.core.ResultSupport;
import lets.core.function.InputOutputCallback;
import lets.core.properties.PropertiesBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PoolableObjectManager
 *
 * @author zhoupan
 * @param <T>
 */
public abstract class PoolableObjectManager<T> extends ObjectManager<T>
    implements Allocator<PoolableObject<T>> {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final AtomicLong allocateCounter = new AtomicLong(0L);

  private final Config<PoolableObject<T>> config = new Config<PoolableObject<T>>();

  protected final PropertiesBuilder builder;

  private final Map<Long, PoolableObject<T>> holders =
      new ConcurrentHashMap<Long, PoolableObject<T>>();

  public PoolableObjectManager() {
    this(PropertiesBuilder.of(System.getProperties()));
  }

  public PoolableObjectManager(PropertiesBuilder builder) {
    super();
    this.builder = builder;
  }

  public final PropertiesBuilder builder() {
    return this.builder;
  }

  public void onConfig(Config<PoolableObject<T>> config) {
    config.setAllocator(this);
  }

  private Pool<PoolableObject<T>> pool;

  public synchronized Pool<PoolableObject<T>> pool() {
    if (this.pool == null) {
      this.pool = this.createPool();
    }
    return this.pool;
  }

  public Pool<PoolableObject<T>> createPool() {
    this.onConfig(this.config);
    return new BlazePool<PoolableObject<T>>(config);
  }

  @Override
  public PoolableObject<T> allocate(Slot slot) throws Exception {
    this.logger.info("allocate:{}", this.allocateCounter.incrementAndGet());
    PoolableObject<T> poolableObject = new PoolableObject<T>(slot, create());
    this.holders.put(poolableObject.getObjectId(), poolableObject);
    return poolableObject;
  }

  public void expire(Long objectId) {
    PoolableObject<T> value = this.holders.get(objectId);
    if (value != null) {
      value.getSlot().expire(value);
      this.holders.remove(objectId);
    }
  }

  public void expireAll() {
    for (Long objectId : this.holders.keySet()) {
      this.expire(objectId);
    }
  }

  public T create() {
    this.update(this.builder.build(), false);
    return this.get();
  }

  @Override
  public void deallocate(PoolableObject<T> poolable) throws Exception {
    this.logger.info("deallocate: allocateCounter={}", this.allocateCounter.decrementAndGet());
  }

  public Config<PoolableObject<T>> getConfig() {
    return config;
  }

  public Logger getLogger() {
    return logger;
  }

  @Override
  public ResultSupport close(T object) {
    ResultSupport result = new ResultSupport();
    try {
      Collection<PoolableObject<T>> objects = this.holders.values();
      for (PoolableObject<T> obj : objects) {
        if (Objects.equals(object, obj.getObject())) {
          this.deallocate(obj);
        }
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public ResultSupport unitOfWork(long timeout, TimeUnit unit, Consumer<T> consumer) {
    ResultSupport result = new ResultSupport();
    PoolableObject<T> poolObject = null;
    try {
      poolObject = this.pool().claim(new Timeout(timeout, unit));
      CoreUtils.checkState(
          poolObject != null && poolObject.getObject() != null, "No PoolableObject Available.");
      consumer.accept(poolObject.getObject());
    } catch (Throwable e) {
      result.onException(e);
    } finally {
      PoolUtils.releaseQuietly(poolObject);
    }
    return result;
  }

  public <Output> DataResultSupport<Output> unitOfWork(
      long timeout, TimeUnit unit, InputOutputCallback<T, Output> consumer) {
    DataResultSupport<Output> result = new DataResultSupport<Output>();
    PoolableObject<T> poolObject = null;
    try {
      poolObject = this.pool().claim(new Timeout(timeout, unit));
      CoreUtils.checkState(
          poolObject != null && poolObject.getObject() != null, "No PoolableObject Available.");
      result.setData(consumer.callback(poolObject.getObject()));
    } catch (Throwable e) {
      result.onException(e);
    } finally {
      PoolUtils.releaseQuietly(poolObject);
    }
    return result;
  }
}
