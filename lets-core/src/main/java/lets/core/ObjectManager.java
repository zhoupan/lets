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
package lets.core;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Provider;
import lets.core.function.InputOutputCallback;

/**
 * ObjectManager.
 *
 * @author zhoupan
 * @param <T> the generic type
 */
public abstract class ObjectManager<T> implements Provider<T>, AutoCloseable {

  /** The props ref. */
  private final AtomicReference<Properties> propsRef = new AtomicReference<Properties>();

  /** The object ref. */
  private final AtomicReference<T> objectRef = new AtomicReference<T>();

  /** Instantiates a new object manager. */
  public ObjectManager() {
    this.propsRef.set(new Properties());
  }

  /**
   * Checks if is present.
   *
   * @return true, if is present
   */
  public boolean isPresent() {
    return this.objectRef.get() != null;
  }

  /**
   * Gets the.
   *
   * @return the t
   */
  public T get() {
    return this.getOrCreate();
  }

  /**
   * Gets the or create.
   *
   * @return the or create
   */
  public final synchronized T getOrCreate() {
    if (this.isPresent()) {
      return this.objectRef.get();
    } else {
      T value = this.create(this.getProperties());
      CoreUtils.checkState(value != null, "Create object not allow null.");
      this.objectRef.set(value);
      return value;
    }
  }

  /**
   * Gets the properties.
   *
   * @return the properties
   */
  public Properties getProperties() {
    return (Properties) this.propsRef.get().clone();
  }

  /**
   * Update.
   *
   * @param props the props
   * @return the result support
   */
  public ResultSupport update(Properties props) {
    return update(props, true);
  }

  /**
   * Update.
   *
   * @param props the props
   * @param smart the smart
   * @return the result support
   */
  public final ResultSupport update(Properties props, boolean smart) {
    ResultSupport result = new ResultSupport();
    try {
      CoreUtils.checkState(props != null, "props not allow null.");
      Properties currentProps = this.getProperties();
      Properties updatedProps = (Properties) props.clone();
      boolean shouldSet = true;
      // 检测属性是否已经改变
      if (smart) {
        if (this.isPresent() && currentProps.equals(updatedProps)) {
          // 属性没有改变,无需设置
          shouldSet = false;
        }
      }
      if (shouldSet) {
        this.propsRef.set(updatedProps);
        return this.open();
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Open.
   *
   * @return the result support
   */
  public final synchronized ResultSupport open() {
    ResultSupport result = new ResultSupport();
    try {
      // close
      if (this.isPresent()) {
        this.close(this.get());
        this.objectRef.set(null);
      }
      // create
      T value = this.create(this.getProperties());
      CoreUtils.checkState(value != null, "Create object not allow null.");
      // set
      this.objectRef.set(value);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * 根据属性创建对象.
   *
   * @param props the props
   * @return the t
   */
  public abstract T create(Properties props);

  /**
   * Close.
   *
   * @return the result support
   */
  public final ResultSupport closeObject() {
    ResultSupport close = new ResultSupport();
    try {
      if (this.get() != null) {
        close = this.close(this.get());
        this.objectRef.set(null);
      }
    } catch (Throwable e) {
      close.onException(e);
    }
    return close;
  }

  /**
   * Close.
   *
   * @param object the object
   * @return the result support
   */
  public abstract ResultSupport close(T object);

  /**
   * Close.
   *
   * @throws Exception the exception
   */
  public void close() throws Exception {
    ResultSupport closeObject = this.closeObject();
    CoreUtils.checkState(closeObject.isSuccess(), closeObject.getMessage());
  }

  /**
   * Unit of work.
   *
   * @param consumer the consumer
   * @return the result support
   */
  public ResultSupport unitOfWork(Consumer<T> consumer) {
    ResultSupport result = new ResultSupport();
    T object = null;
    try {
      object = this.get();
      CoreUtils.checkState(object != null, "No Object Available.");
      consumer.accept(object);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Unit of work.
   *
   * @param <Output> the generic type
   * @param consumer the consumer
   * @return the data result support
   */
  public <Output> DataResultSupport<Output> unitOfWork(InputOutputCallback<T, Output> consumer) {
    DataResultSupport<Output> result = new DataResultSupport<Output>();
    T object = null;
    try {
      object = this.get();
      CoreUtils.checkState(object != null, "No Object Available.");
      result.setData(consumer.callback(object));
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
