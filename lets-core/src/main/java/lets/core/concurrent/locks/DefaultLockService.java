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
package lets.core.concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import lets.core.CoreUtils;
import lets.core.LoggerSupport;
import lets.core.ResultSupport;

/**
 * DefaultLockService.
 *
 * @author zhoupan
 */
public class DefaultLockService implements LockService {

  /**
   * Builds the lock name.
   *
   * @param clasz the clasz
   * @param key the key
   * @return the string
   */
  protected String buildLockName(Class<?> clasz, Object key) {
    return String.format("[%s][%s]", clasz.getName(), key);
  }

  /**
   * Lock.
   *
   * @param clasz the clasz
   * @param key the key
   * @param runnable the runnable
   * @return the result support
   */
  @Override
  public ResultSupport lock(Class<?> clasz, Object key, Runnable runnable) {
    return this.lock(buildLockName(clasz, key), runnable);
  }

  /**
   * Lock.
   *
   * @param name the name
   * @param runnable the runnable
   * @return the result support
   */
  @Override
  public ResultSupport lock(String name, Runnable runnable) {
    ResultSupport result = new ResultSupport();
    try {
      Lock lock = getLock(name);
      if (lock.tryLock()) {
        try {
          runnable.run();
        } finally {
          lock.unlock();
        }
      } else {
        LoggerSupport.error("tryLock:{}失败", name);
        CoreUtils.checkState(false, "系统繁忙");
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  protected Lock getLock(String name) {
    Lock lock = Locks.JVM.writeLock(name);
    return lock;
  }

  @Override
  public ResultSupport lock(String name, Runnable runnable, long time, TimeUnit unit) {
    ResultSupport result = new ResultSupport();
    try {
      Lock lock = getLock(name);
      if (lock.tryLock(time, unit)) {
        try {
          runnable.run();
        } finally {
          lock.unlock();
        }
      } else {
        LoggerSupport.error("tryLock:{}失败", name);
        CoreUtils.checkState(false, "系统繁忙");
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
