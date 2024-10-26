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

import java.util.concurrent.atomic.AtomicLong;
import lets.core.LoggerSupport;

public class Tick extends RunnableState {

  private final AtomicLong tickCurrent = new AtomicLong(0);
  private final AtomicLong tickMin = new AtomicLong(0);
  private final AtomicLong tickMax = new AtomicLong(0);

  private int tickMinInit = 0;
  private int tickMaxInit = 0;

  public Tick() {
    this(0, 0);
  }

  public Tick(int tickMinInit, int tickMaxInit) {
    super();
    this.tickMinInit = tickMinInit;
    this.tickMaxInit = tickMaxInit;
    this.reset();
    this.name.set(Tick.class.getName());
  }

  public Tick(Integer tickMaxInit) {
    this(0, tickMaxInit == null ? 0 : tickMaxInit);
  }

  public int getTickMinInit() {
    return tickMinInit;
  }

  public int getTickMaxInit() {
    return tickMaxInit;
  }

  /**
   * Resets the tik. Stops it if need be.
   *
   * <p>This method clears the internal values to allow the object to be reused.
   */
  public void reset() {
    super.reset();
    this.tickCurrent.set(0);
    this.tickMin.set(this.tickMinInit);
    this.tickMax.set(this.tickMaxInit);
  }

  public long tick() throws InterruptedException {
    super.run();
    this.onTick(this);
    return this.tickCurrent.incrementAndGet();
  }

  public long tickCurrent() {
    return tickCurrent.get();
  }

  public long tickMin() {
    return this.tickMin.get();
  }

  public long tickMax() {
    return this.tickMax.get();
  }

  public boolean hasTickMin() {
    return 0 < this.tickMin();
  }

  public boolean hasTickMax() {
    return 0 < this.tickMax();
  }

  public boolean onDeterminateCanStop() {
    if (this.hasTickMin() && (this.tickCurrent() < this.tickMin())) {
      return false;
    }
    return true;
  }

  public boolean onDeterminateMustStop() {
    if (this.hasTickMax() && (this.tickMax() <= this.tickCurrent())) {
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return this.name.get()
        + " [tickCurrent="
        + tickCurrent
        + ", tickMin="
        + tickMin
        + ", tickMax="
        + tickMax
        + ", runningState="
        + runningState
        + ", tickMinInit="
        + tickMinInit
        + ", tickMaxInit="
        + tickMaxInit
        + "]";
  }

  @Override
  public void onStart(RunnableState runnableState) {
    this.onStart(this);
  }

  @Override
  public void onStop(RunnableState runnableState) {
    this.onStop(this);
  }

  public void onStart(Tick tick) {
    LoggerSupport.debug("{}:onStart:{}", this.name.get(), tick);
  }

  public void onTick(Tick tick) {
    LoggerSupport.debug("{}:onTick:{}", this.name.get(), tick);
  }

  public void onStop(Tick tick) {
    LoggerSupport.debug("{}:onStop:{}", this.name.get(), tick);
  }
}
