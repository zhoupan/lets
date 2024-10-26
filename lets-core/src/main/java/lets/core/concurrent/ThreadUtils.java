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

import java.util.concurrent.TimeUnit;
import lets.core.ResultSupport;

public class ThreadUtils {

  public static void sleep(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException iex) {
      Thread.currentThread().interrupt();
    }
  }

  public static void sleep(TimeUnit unit, int duration) {
    sleep(unit.toMillis(duration));
  }

  public static ResultSupport stop(Thread... threads) {
    ResultSupport result = new ResultSupport();
    try {
      for (Thread thread : threads) {
        try {
          if (thread != null && !thread.isInterrupted()) {
            thread.interrupt();
          }
        } catch (Throwable e) {
          // ignore.
        }
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
