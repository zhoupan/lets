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
import lets.core.MutableValue;
import lets.core.ResultSupport;
import lets.core.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tick控制器.
 *
 * @author zhoupan
 */
public class TickController {

  /** The logger. */
  protected transient Logger logger = LoggerFactory.getLogger(TickController.class);

  /** The tick queue. */
  protected TickQueue tickQueue;

  /** The tick loop. */
  protected TickLoop tickLoop;

  /** The stop wath. */
  final StopWatch stopWath = new StopWatch();

  /** The delay. */
  public final AtomicLong delay = new AtomicLong(0);

  /** The peroid. */
  public final AtomicLong peroid = new AtomicLong(TimeUnit.SECONDS.toMillis(1));

  /**
   * With peroid.
   *
   * @param unit the unit
   * @param peroid the peroid
   * @return the tick controller
   */
  public TickController withPeroid(TimeUnit unit, int peroid) {
    this.peroid.set(unit.toMillis(peroid));
    return this;
  }

  /**
   * With delay.
   *
   * @param unit the unit
   * @param peroid the peroid
   * @return the tick controller
   */
  public TickController withDelay(TimeUnit unit, int peroid) {
    this.delay.set(unit.toMillis(peroid));
    return this;
  }

  /** The name. */
  public final MutableValue<String> name =
      new MutableValue<String>().set(TickController.class.getSimpleName());

  /**
   * With name.
   *
   * @param value the value
   * @return the tick controller
   */
  public TickController withName(String value) {
    this.name.set(value);
    return this;
  }

  /**
   * Name.
   *
   * @return the string
   */
  public String name() {
    if (this.name.isPresent()) {
      return this.name.get();
    }
    return this.getClass().getSimpleName();
  }

  /**
   * Sets the tick name.
   *
   * @param tick the tick
   * @param purpose the purpose
   */
  public void setTickName(Tick tick, String purpose) {
    tick.name.set(
        String.format(
            "Ticker:%s:%s:%s",
            new Object[] {this.getClass().getSimpleName(), this.name(), purpose}));
  }

  /**
   * Sets the name.
   *
   * @param tick the tick
   * @param purpose the purpose
   */
  public void setName(Thread tick, String purpose) {
    tick.setName(
        String.format(
            "Thread:%s:%s:%s",
            new Object[] {this.getClass().getSimpleName(), this.name(), purpose}));
  }

  /** Instantiates a new base device controller. */
  public TickController() {
    super();
  }

  /**
   * Gets the or create queue.
   *
   * @return the or create queue
   */
  public synchronized TickQueue getOrCreateQueue() {
    if ((this.tickQueue == null) || this.tickQueue.isInterrupted()) {
      this.tickQueue = new TickQueue();
      this.tickQueue.period(this.onPeriod());
      this.tickQueue.delay(this.delay.get());
      this.setName(this.tickQueue, "队列");
      this.tickQueue.start();
    }
    return this.tickQueue;
  }

  /**
   * On period.
   *
   * @return the long
   */
  public long onPeriod() {
    return this.peroid.get();
  }

  /**
   * Gets the or create loop.
   *
   * @return the or create loop
   */
  public synchronized TickLoop getOrCreateLoop() {
    if ((this.tickLoop == null) || this.tickLoop.isInterrupted()) {
      this.tickLoop = new TickLoop();
      this.tickLoop.period(this.onPeriod());
      this.tickLoop.delay(this.delay.get());
      this.setName(this.tickLoop, "循环");
      this.tickLoop.start();
    }
    return this.tickLoop;
  }

  /**
   * On start.
   *
   * @param unit the unit
   * @param peroid the peroid
   * @param delay the delay
   * @param runnable the runnable
   */
  public void onStartRepeatJob(TimeUnit unit, int peroid, long delay, Runnable runnable) {
    this.onStop();
    this.peroid.set(unit.toMillis(peroid));
    this.delay.set(delay);
    this.getOrCreateLoop()
        .ticks(
            new Tick() {

              @Override
              public void onTick(Tick tick) {
                try {
                  runnable.run();
                } catch (Throwable e) {
                  LoggerSupport.error("{}", e);
                }
              }
            });
  }

  /**
   * On start repeat job.
   *
   * @param runnable the runnable
   */
  public void onStartRepeatJob(Runnable runnable) {
    this.onStop();
    this.getOrCreateLoop()
        .ticks(
            new Tick() {

              @Override
              public void onTick(Tick tick) {
                try {
                  runnable.run();
                } catch (Throwable e) {
                  LoggerSupport.error("{}", e);
                }
              }
            });
  }

  /**
   * On pull.
   *
   * @return the result support
   */
  public ResultSupport onPull() {
    ResultSupport result = new ResultSupport();
    try {

    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /** On stop. */
  public void onStop() {
    ThreadUtils.stop(this.tickQueue, this.tickLoop);
    this.tickLoop = null;
    this.tickQueue = null;
  }
}
