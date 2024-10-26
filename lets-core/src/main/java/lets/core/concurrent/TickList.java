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

import java.util.Collection;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import lets.core.LoggerSupport;

public class TickList extends Thread {
  public final Vector<Tick> queue = new Vector<Tick>();
  public final AtomicLong period = new AtomicLong(TimeUnit.SECONDS.toMillis(1));
  public final AtomicBoolean interruptWhenQueueIsEmpty = new AtomicBoolean(false);
  public final AtomicLong delay = new AtomicLong(0);
  public final Vector<Tick> list = new Vector<Tick>();

  public static TickList restart(final TickList target) {
    if (!target.isInterrupted()) {
      target.interrupt();
    }
    TickList newInstance =
        new TickList()
            .period(target.period.get())
            .interruptWhenQueueIsEmpty(target.interruptWhenQueueIsEmpty.get());
    LoggerSupport.info("target:list:size:{}", target.list.size());
    for (Tick tick : target.list) {
      newInstance.ticks(tick);
    }
    return newInstance;
  }

  public TickList(long period, boolean interruptWhenQueueIsEmpty, Tick... ticks) {
    this.period.set(period);
    this.interruptWhenQueueIsEmpty.set(interruptWhenQueueIsEmpty);
    this.ticks(ticks);
  }

  public TickList(long period, boolean interruptWhenQueueIsEmpty, Vector<Tick> ticks) {
    this.period.set(period);
    this.interruptWhenQueueIsEmpty.set(interruptWhenQueueIsEmpty);
    this.ticks(ticks);
  }

  public TickList() {}

  public TickList period(int duration, TimeUnit unit) {
    this.period.set(unit.toMillis(duration));
    return this;
  }

  public TickList period(long period) {
    this.period.set(period);
    return this;
  }

  public TickList interruptWhenQueueIsEmpty(boolean value) {
    this.interruptWhenQueueIsEmpty.set(value);
    return this;
  }

  public TickList delay(int duration, TimeUnit unit) {
    this.delay.set(unit.toMillis(duration));
    return this;
  }

  public TickList delay(long delay) {
    this.delay.set(delay);
    return this;
  }

  public TickList ticks(Tick... ticks) {
    if (ticks != null) {
      for (Tick tick : ticks) {
        tick.reset();
        this.queue.add(tick);
        this.list.add(tick);
      }
    }
    return this;
  }

  public TickList ticks(Collection<Tick> ticks) {
    if (ticks != null) {
      for (Tick tick : ticks) {
        tick.reset();
        this.queue.add(tick);
        this.list.add(tick);
      }
    }
    return this;
  }

  @Override
  public void run() {
    while (!this.isInterrupted()) {
      try {
        Thread.sleep(this.period.get());
        LoggerSupport.debug("TickList is running");
        if (this.interruptWhenQueueIsEmpty.get() && this.queue.isEmpty()) {
          this.interrupt();
        }
        if (!this.queue.isEmpty()) {
          Tick tick = this.queue.get(0);
          if (tick != null) {
            try {
              tick.tick();
            } catch (InterruptedException e) {
              queue.remove(tick);
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

  public void clean() {
    this.queue.clear();
    this.list.clear();
  }

  public void stopQueueTicksQuilet() {
    for (int i = 0; i < this.queue.size(); i++) {
      try {
        Tick tick = this.queue.get(i);
        tick.stop();
      } catch (Throwable e) {
        LoggerSupport.error("StopQueueTicksQuilet:{}", e);
      }
    }
    this.clean();
  }
}
