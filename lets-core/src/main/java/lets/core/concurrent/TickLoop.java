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

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import lets.core.LoggerSupport;

/** The Class TickLoop. */
public class TickLoop extends TickList {

  /** The loop index. */
  private final AtomicInteger loopIndex = new AtomicInteger(0);

  /** Run. */
  @Override
  public void run() {
    if (this.delay.get() > 0) {
      LoggerSupport.debug("{}延时{}", this.getName(), this.delay.get());
      ThreadUtils.sleep(this.delay.get());
    }
    while (!this.isInterrupted()) {
      try {
        Thread.sleep(this.period.get());
        LoggerSupport.debug("TickLoop is running loopIndex:{}", this.loopIndex());

        if (this.interruptWhenQueueIsEmpty.get() && this.queue.isEmpty()) {
          this.interrupt();
        }

        if (!this.queue.isEmpty()) {
          int index = this.loopIndex();
          if ((0 <= index) && (index <= this.queue.size())) {
            Tick tick = this.queue.get(index);
            if (tick != null) {
              try {
                tick.tick();
              } catch (InterruptedException e) {
                // 当前tick停止,重置,等待下一次循环.
                tick.reset();
                this.loopIndex.incrementAndGet();
              }
            }
          }
        }
      } catch (InterruptedException e) {
        this.interrupt();
      } catch (Throwable e) {
        LoggerSupport.error("{}", e);
      }
    }
  }

  /**
   * 获取下一次循环的索引.
   *
   * @return the int
   */
  public int loopIndex() {
    int next = this.loopIndex.get();
    if (this.queue.size() <= next) {
      next = 0;
      this.loopIndex.set(next);
    }
    return next;
  }

  /** Stop loop ticks quilet. */
  public void stopLoopTicksQuilet() {
    try {
      for (Iterator<Tick> eachTick = this.queue.iterator(); eachTick.hasNext(); ) {
        try {
          LoggerSupport.debug("stopQueueTicksQuilet");
          eachTick.next().stopQuilet();
        } catch (Throwable e) {
          // ignore
          LoggerSupport.error("{}", e);
        }
      }
      this.queue.clear();
    } catch (Throwable e) {
      LoggerSupport.error("StopQueueTicksQuilet:{}", e);
    }
  }

  /**
   * Stop loop ticks quilet.
   *
   * @param loop the loop
   */
  public static void stopLoopTicksQuilet(TickLoop loop) {
    if (loop != null) {
      loop.stopLoopTicksQuilet();
    }
  }
}
