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

import java.time.Duration;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import lets.core.CoreUtils;
import lets.core.ResultSupport;
import lets.core.StringUtils;
import lets.core.failsafe.FailsafeSupport;

/**
 * ExecutorServiceSupport. 1.场景(submitMaxNumberOfTask):限制任务最大数量(超过一定数量的任务拒绝执行)
 * 2.场景(submitLastTask):提交任务到指定的队列,拉取队列尾部的任务执行,清空队列.(例如:短时间内,多次更新某个状态值,只需要以最后一次提交的数据为准) 3.场景:超时限制
 * (默认1分钟)
 *
 * @author zhoupan
 */
public class ExecutorServiceSupport {

  /** The executorSupport. */
  private final ExecutorService executor;

  /** key:任务id,value:队列. */
  protected final Map<String, Deque<Runnable>> dequeMaps =
      new ConcurrentHashMap<String, Deque<Runnable>>();

  /** 任务超时. */
  protected Duration durationOfTimeout = Duration.ofMinutes(1);

  /**
   * With duration of timeout.
   *
   * @param timeout the timeout
   * @return the executor service support
   */
  public ExecutorServiceSupport withDurationOfTimeout(Duration timeout) {
    CoreUtils.checkState(timeout != null, "timeout required.");
    this.durationOfTimeout = timeout;
    return this;
  }

  /**
   * Instantiates a new executorSupport service support.
   *
   * @param executor the executor
   * @param timeout the timeout
   */
  public ExecutorServiceSupport(ExecutorService executor, Duration timeout) {
    super();
    CoreUtils.checkState(timeout != null, "timeout required.");
    CoreUtils.checkState(executor != null, "executor required.");
    this.executor = executor;
    this.durationOfTimeout = timeout;
  }

  /** Instantiates a new executorSupport service support. */
  public ExecutorServiceSupport() {
    this(Executors.newSingleThreadExecutor(), Duration.ofMinutes(1));
  }

  /**
   * Gets the deque by id.
   *
   * @param id the id
   * @return the deque by id
   */
  public synchronized Deque<Runnable> getDequeByTaskId(String id) {
    CoreUtils.checkState(StringUtils.isNotBlank(id), "id not allow blank.");
    if (this.dequeMaps.containsKey(id)) {
      return this.dequeMaps.get(id);
    }
    Deque<Runnable> value = new LinkedBlockingDeque<Runnable>();
    this.dequeMaps.put(id, value);
    return value;
  }

  /**
   * Submit.
   *
   * @param runnable the runnable
   * @return the result support
   */
  public ResultSupport submit(final Runnable runnable) {
    return this.submit(runnable, this.durationOfTimeout);
  }

  /**
   * Submit.
   *
   * @param runnable the runnable
   * @param timeout the timeout
   * @return the result support
   */
  public ResultSupport submit(final Runnable runnable, Duration timeout) {
    ResultSupport result = new ResultSupport();
    try {
      this.executor.submit(
          () -> new FailsafeSupport().setDurationOfTimeout(timeout).withTimeout(runnable));
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * 提交指定任务,限制任务最大数量.
   *
   * @param taskId 任务id.
   * @param maxNumberOfTask the limit number
   * @param runnable 任务.
   * @return the result support
   */
  public ResultSupport submitWithLimitMaxNumberOfTask(
      String taskId, long maxNumberOfTask, final Runnable runnable) {
    return this.submitWithLimitMaxNumberOfTask(
        taskId, maxNumberOfTask, runnable, this.durationOfTimeout);
  }

  /**
   * 提交指定任务,限制任务最大数量.
   *
   * @param taskId the task id
   * @param maxNumberOfTask the max number of task
   * @param runnable the runnable
   * @param timeout the timeout
   * @return the result support
   */
  public ResultSupport submitWithLimitMaxNumberOfTask(
      String taskId, long maxNumberOfTask, final Runnable runnable, Duration timeout) {
    ResultSupport result = new ResultSupport();
    try {
      Deque<Runnable> deque = this.getDequeByTaskId(taskId);
      CoreUtils.checkState(
          deque.size() < maxNumberOfTask,
          "Reject:任务%s队列满:maxNumberOfTask=%s",
          taskId,
          maxNumberOfTask);
      this.executor.submit(
          new AbstractRunnable(taskId) {

            @Override
            public void run() {
              try {
                deque.add(runnable);
                new FailsafeSupport().setDurationOfTimeout(timeout).withTimeout(runnable);
              } finally {
                deque.remove(runnable);
              }
            }
          });
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Wait task deque empty.
   *
   * @param taskId the task id
   * @return the result support
   */
  public ResultSupport waitTaskDequeEmpty(String taskId) {
    ResultSupport result = new ResultSupport();
    try {
      Deque<Runnable> de = this.getDequeByTaskId(taskId);
      while (!de.isEmpty()) {
        ThreadUtils.sleep(TimeUnit.SECONDS, 1);
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Wait task deque empty.
   *
   * @param taskId the task id
   * @param timeout the timeout
   * @return the result support
   */
  public ResultSupport waitTaskDequeEmpty(String taskId, Duration timeout) {
    return new FailsafeSupport()
        .setDurationOfTimeout(timeout)
        .withTimeout(() -> this.waitTaskDequeEmpty(taskId));
  }

  /**
   * 提交任务到指定的队列,拉取队列尾部的任务执行,清空队列.
   *
   * @param taskId the task id
   * @param runnable the runnable
   * @return the result support
   */
  public ResultSupport submitLastTask(String taskId, final Runnable runnable) {
    return this.submitLastTask(taskId, runnable, this.durationOfTimeout);
  }

  /**
   * 提交任务到指定的队列,拉取队列尾部的任务执行,清空队列.
   *
   * @param taskId the task id
   * @param runnable the runnable
   * @param timeout the timeout
   * @return the result support
   */
  public ResultSupport submitLastTask(String taskId, final Runnable runnable, Duration timeout) {
    ResultSupport result = new ResultSupport();
    try {
      Deque<Runnable> deque = this.getDequeByTaskId(taskId);
      deque.add(runnable);
      this.executor.submit(
          new AbstractRunnable(taskId) {

            @Override
            public void run() {
              Runnable last = deque.pollLast();
              if (last != null) {
                deque.clear();
                new FailsafeSupport().setDurationOfTimeout(timeout).withTimeout(runnable);
              }
            }
          });

    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
