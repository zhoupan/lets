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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import lets.core.LoggerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** The Class TickQueue. */
public class TickQueue extends Thread {

  /** The queue. */
  public final BlockingQueue<Tick> queue = new LinkedBlockingQueue<Tick>();

  /** The period. */
  public final AtomicLong period = new AtomicLong(TimeUnit.SECONDS.toMillis(1));

  /** The interrupt when queue is empty. */
  public final AtomicBoolean interruptWhenQueueIsEmpty = new AtomicBoolean(false);

  /** The delay. */
  public final AtomicLong delay = new AtomicLong(0);

  /** The logger. */
  public final Logger logger = LoggerFactory.getLogger(TickQueue.class);

  /**
   * Instantiates a new tick queue.
   *
   * @param period the period
   * @param interruptWhenQueueIsEmpty the interrupt when queue is empty
   * @param ticks the ticks
   */
  public TickQueue(int period, boolean interruptWhenQueueIsEmpty, Tick... ticks) {
    this.period.set(period);
    this.interruptWhenQueueIsEmpty.set(interruptWhenQueueIsEmpty);
    this.ticks(ticks);
  }

  /** Instantiates a new tick queue. */
  public TickQueue() {
    this.logger.debug("create");
  }

  /**
   * Period.
   *
   * @param duration the duration
   * @param unit the unit
   * @return the tick queue
   */
  public TickQueue period(int duration, TimeUnit unit) {
    this.period.set(unit.toMillis(duration));
    return this;
  }

  /**
   * Period.
   *
   * @param period the period
   * @return the tick queue
   */
  public TickQueue period(long period) {
    this.period.set(period);
    return this;
  }

  /**
   * Interrupt when queue is empty.
   *
   * @param value the value
   * @return the tick queue
   */
  public TickQueue interruptWhenQueueIsEmpty(boolean value) {
    this.interruptWhenQueueIsEmpty.set(value);
    return this;
  }

  /**
   * Delay.
   *
   * @param duration the duration
   * @param unit the unit
   * @return the tick queue
   */
  public TickQueue delay(int duration, TimeUnit unit) {
    this.delay.set(unit.toMillis(duration));
    return this;
  }

  /**
   * Delay.
   *
   * @param delay the delay
   * @return the tick queue
   */
  public TickQueue delay(long delay) {
    this.delay.set(delay);
    return this;
  }

  /**
   * Ticks.
   *
   * @param ticks the ticks
   * @return the tick queue
   */
  public TickQueue ticks(Tick... ticks) {
    if (ticks != null) {
      for (Tick tick : ticks) {
        logger.debug("{}增加{}", this.getName(), tick.name.isPresent() ? tick.name.get() : "");
        this.queue.add(tick);
      }
    }
    return this;
  }

  /** Run. */
  @Override
  public void run() {
    if (this.delay.get() > 0) {
      logger.debug("{}延时{}", this.getName(), this.delay.get());
      ThreadUtils.sleep(this.delay.get());
    }
    while (!this.isInterrupted()) {
      try {
        Thread.sleep(this.period.get());
        logger.debug(
            "{}正在运行:队列大小:{}:中断当队列为空:{}",
            this.getName(),
            this.queue.size(),
            this.interruptWhenQueueIsEmpty.get());
        if (this.interruptWhenQueueIsEmpty.get() && this.queue.isEmpty()) {
          logger.debug(
              "{}中断:队列大小:{}:中断当队列为空:{}",
              this.getName(),
              this.queue.size(),
              this.interruptWhenQueueIsEmpty.get());
          this.interrupt();
        }
        Tick tick = this.queue.peek();
        if (tick != null) {
          try {
            logger.debug("{} {}", this.getName(), tick.name.isPresent() ? tick.name.get() : "");
            tick.tick();
          } catch (InterruptedException e) {
            logger.debug("{}移除{}", this.getName(), tick.name.isPresent() ? tick.name.get() : "");
            queue.remove(tick);
          }
        }
      } catch (InterruptedException e) {
        logger.debug(
            "{}中断:InterruptedException:队列大小:{}:中断当队列为空:{}",
            this.getName(),
            this.queue.size(),
            this.interruptWhenQueueIsEmpty.get());
        this.interrupt();
      } catch (Throwable e) {
        logger.debug(
            "{}错误:队列大小:{}:中断当队列为空:{}",
            this.getName(),
            this.queue.size(),
            this.interruptWhenQueueIsEmpty.get());
      }
    }
  }

  /** Stop queue ticks quilet. */
  public void stopQueueTicksQuilet() {
    try {
      for (Iterator<Tick> eachTick = this.queue.iterator(); eachTick.hasNext(); ) {
        try {
          logger.debug("stopQueueTicksQuilet");
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
   * Stop queue ticks quilet.
   *
   * @param queue the queue
   */
  public static void stopQueueTicksQuilet(TickQueue queue) {
    if (queue != null) {
      queue.stopQueueTicksQuilet();
    }
  }
}
