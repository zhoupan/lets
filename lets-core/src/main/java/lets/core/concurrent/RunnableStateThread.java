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
import java.util.concurrent.atomic.AtomicLong;
import lets.core.LoggerSupport;

public class RunnableStateThread extends Thread {

  public final RunnableState state;
  public final AtomicLong period = new AtomicLong(TimeUnit.SECONDS.toMillis(1));

  public RunnableStateThread(RunnableState state) {
    super();
    this.state = state;
  }

  @Override
  public void run() {
    while (!this.isInterrupted()) {
      try {
        Thread.sleep(this.period.get());
        LoggerSupport.debug("{} is running", this.state.name.get());
        this.state.run();
      } catch (InterruptedException e) {
        this.interrupt();
      } catch (Throwable e) {
        LoggerSupport.error("{}", e);
      }
    }
  }
}
