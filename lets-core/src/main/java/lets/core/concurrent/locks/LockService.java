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
import lets.core.ResultSupport;

/**
 * 锁服务.
 *
 * @author zhoupan
 */
public interface LockService {

  /**
   * Lock.
   *
   * @param clasz the clasz
   * @param key the key
   * @param runnable the runnable
   * @return the result support
   */
  ResultSupport lock(Class<?> clasz, Object key, Runnable runnable);

  /**
   * Lock.
   *
   * @param name the name
   * @param runnable the runnable
   * @return the result support
   */
  ResultSupport lock(String name, Runnable runnable);

  /**
   * Lock.
   *
   * @param name the name
   * @param runnable the runnable
   * @param time the time
   * @param unit the unit
   * @return the result support
   */
  public ResultSupport lock(String name, Runnable runnable, long time, TimeUnit unit);
}
