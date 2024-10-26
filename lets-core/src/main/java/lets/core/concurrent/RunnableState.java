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

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import lets.core.LoggerSupport;
import lets.core.MutableValue;
import lets.core.StopWatch;

/**
 * 跟踪运行状态.
 *
 * @author zhoupan
 */
public class RunnableState {

  public static enum State {
    RUNNING {
      @Override
      boolean isStarted() {
        return true;
      }

      @Override
      boolean isStopped() {
        return false;
      }

      @Override
      boolean isSuspended() {
        return false;
      }
    },
    STOPPED {
      @Override
      boolean isStarted() {
        return false;
      }

      @Override
      boolean isStopped() {
        return true;
      }

      @Override
      boolean isSuspended() {
        return false;
      }
    },
    SUSPENDED {
      @Override
      boolean isStarted() {
        return true;
      }

      @Override
      boolean isStopped() {
        return false;
      }

      @Override
      boolean isSuspended() {
        return true;
      }
    },
    UNSTARTED {
      @Override
      boolean isStarted() {
        return false;
      }

      @Override
      boolean isStopped() {
        return true;
      }

      @Override
      boolean isSuspended() {
        return false;
      }
    };

    /**
     * Returns whether the runnableState is started. A suspended runnableState is also started
     * watch.
     *
     * @return boolean If the runnableState is started.
     */
    abstract boolean isStarted();

    /**
     * Returns whether the runnableState is stopped. The tik which's not yet started and explicitly
     * stopped tik is considered as stopped.
     *
     * @return boolean If the runnableState is stopped.
     */
    abstract boolean isStopped();

    /**
     * Returns whether the runnableState is suspended.
     *
     * @return boolean If the runnableState is suspended.
     */
    abstract boolean isSuspended();
  }

  /** The current running state of the runnableState. */
  protected State runningState = State.UNSTARTED;

  /** 跟踪目标停止状态.例如:虽然调用了停止方法,但canStop返回false, */
  protected final AtomicBoolean runnableOnStoped = new AtomicBoolean(false);

  protected final AtomicLong runningCounter = new AtomicLong(0);
  protected StopWatch stopWatch = StopWatch.create();

  /** */
  public final MutableValue<String> name =
      new MutableValue<String>().set(RunnableState.class.getName());

  public RunnableState() {}

  public StopWatch getStopWatch() {
    return stopWatch;
  }

  /**
   * Starts.
   *
   * <p>This method starts a new timing session, clearing any previous values.
   *
   * @throws IllegalStateException if the StopWatch is already running.
   */
  public void start() {
    if (this.runningState == State.STOPPED) {
      throw new IllegalStateException("Run must be reset before being restarted. ");
    }
    if (this.runningState != State.UNSTARTED) {
      throw new IllegalStateException("Run already started. ");
    }
    this.runningState = State.RUNNING;
    this.stopWatch.start();
    // 调用启动的业务逻辑
    this.onStart(this);
  }

  public boolean canStart() {
    if (this.runningState == State.STOPPED) {
      return false;
    }
    if (this.runningState != State.UNSTARTED) {
      return false;
    }
    return true;
  }

  public void restart() {
    this.reset();
    this.start();
  }

  /**
   * Stops.
   *
   * <p>This method ends a new timing session, allowing the time to be retrieved.
   *
   * @throws IllegalStateException if the StopWatch is not running.
   */
  public void stop() {
    if (this.runningState != State.RUNNING && this.runningState != State.SUSPENDED) {
      throw new IllegalStateException("Run is not running. ");
    }
    this.runningState = State.STOPPED;
    this.stopWatch.stop();
    try {
      didStop();
    } catch (InterruptedException e) {
      // Ignore.
    }
  }

  public void stopQuilet() {
    this.runningState = State.STOPPED;
    try {
      this.stopWatch.stop();
    } catch (Throwable e) {
      // Ignore
    }
    try {
      didStop();
    } catch (InterruptedException e) {
      // Ignore.
    }
  }

  public void didStop() throws InterruptedException {
    // 根据业务逻辑，决定是否满足停止运行的条件.
    boolean canStop = this.onDeterminateCanStop();
    if (canStop) {
      // 已经执行了停止的业务逻辑.
      if (this.runnableOnStoped.get()) {
        throw new InterruptedException("Stoped");
      } else {
        this.runnableOnStoped.set(true);
        if (!this.stopWatch.isStopped()) {
          this.stopWatch.stop();
        }
        // 调用停止的业务逻辑
        this.onStop(this);
        throw new InterruptedException("Stoped");
      }
    }
  }

  public boolean canStop() {
    if (this.runningState != State.RUNNING && this.runningState != State.SUSPENDED) {
      return false;
    }
    return true;
  }

  /**
   * Suspends for later resumption.
   *
   * <p>This method suspends the watch until it is resumed. The watch will not include time between
   * the suspend and resume calls in the total time.
   *
   * @throws IllegalStateException if the StopWatch is not currently running.
   */
  public void suspend() {
    if (this.runningState != State.RUNNING) {
      throw new IllegalStateException("Stopwatch must be running to suspend. ");
    }
    this.runningState = State.SUSPENDED;
    this.stopWatch.suspend();
  }

  public boolean canSuspend() {
    if (this.runningState != State.RUNNING) {
      return false;
    }
    return true;
  }

  /**
   * Resumes after a suspend.
   *
   * <p>This method resumes the watch after it was suspended. The watch will not include time
   * between the suspend and resume calls in the total time.
   *
   * @throws IllegalStateException if the StopWatch has not been suspended.
   */
  public void resume() {
    if (this.runningState != State.SUSPENDED) {
      throw new IllegalStateException("Stopwatch must be suspended to resume. ");
    }
    this.runningState = State.RUNNING;
    this.stopWatch.resume();
  }

  public boolean canResume() {
    if (this.runningState != State.SUSPENDED) {
      return false;
    }
    return true;
  }

  /**
   * Returns whether the StopWatch is started. A suspended StopWatch is also started watch.
   *
   * @return boolean If the StopWatch is started.
   * @since 3.2
   */
  public boolean isStarted() {
    return runningState.isStarted();
  }

  /**
   * Returns whether StopWatch is stopped. The tik which's not yet started and explicitly stopped
   * tik is considered as stopped.
   *
   * @return boolean If the StopWatch is stopped.
   * @since 3.2
   */
  public boolean isStopped() {
    return runningState.isStopped();
  }

  /**
   * Returns whether the StopWatch is suspended.
   *
   * @return boolean If the StopWatch is suspended.
   * @since 3.2
   */
  public boolean isSuspended() {
    return runningState.isSuspended();
  }

  /**
   * Resets. Stops it if need be.
   *
   * <p>This method clears the internal values to allow the object to be reused.
   */
  public void reset() {
    this.runningState = State.UNSTARTED;
    this.stopWatch.reset();
    this.runningCounter.set(0);
    this.runnableOnStoped.set(false);
  }

  public long runningCounter() {
    return this.runningCounter.get();
  }

  public void run() throws InterruptedException {
    // 暂停状态
    if (this.isSuspended()) {
      return;
    }
    // 调用了停止方法:达到了停止条件,中断
    if (this.runningState == State.STOPPED) {
      this.didStop();
    }
    // 如果未启动,则启动.
    if (this.runningState == State.UNSTARTED) {
      this.start();
    }
    // 运行状态,
    if (this.runningState == State.RUNNING) {
      // 调用决定是否应该停止运行的业务逻辑.
      if (this.onDeterminateMustStop()) {
        this.stop();
        throw new InterruptedException("Stoped");
      }
    }
    this.onRun(this);
    this.runningCounter.incrementAndGet();
  }

  public AtomicBoolean determinateMustStop = new AtomicBoolean(false);

  /**
   * 在运行状态,根据业务逻辑,决定是否必须停止当前的运行状态.
   *
   * @return
   */
  public boolean onDeterminateMustStop() {
    LoggerSupport.info("{}:onDeterminateMustStop:{}", this.name.get(), determinateMustStop);
    return determinateMustStop.get();
  }

  /**
   * 在停止状态,根据业务决定是否满足停止的业务条件.
   *
   * @return
   */
  public boolean onDeterminateCanStop() {
    boolean determinateCanStop = true;
    LoggerSupport.info("{}:onDeterminateCanStop:{}", this.name.get(), determinateCanStop);
    return determinateCanStop;
  }

  /**
   * 启动事件回调
   *
   * @param runnableState
   */
  public void onStart(RunnableState runnableState) {
    LoggerSupport.info("{}:onStart:{}", this.name.get(), runnableState);
  }

  /**
   * 运行事件回调
   *
   * @param runnableState
   */
  public void onRun(RunnableState runnableState) {
    // LoggerSupport.info("{}:onRun:{}", this.name.get(), runnableState);
  }

  /**
   * 停止事件回调
   *
   * @param runnableState
   */
  public void onStop(RunnableState runnableState) {
    LoggerSupport.info("{}:onStop:{}", this.name.get(), runnableState, this.stopWatch.formatTime());
  }

  @Override
  public String toString() {
    return " ["
        + name.get()
        + ", runningState="
        + runningState
        + ", runnableOnStoped="
        + runnableOnStoped
        + ", runningCounter="
        + runningCounter
        + "]";
  }
}
