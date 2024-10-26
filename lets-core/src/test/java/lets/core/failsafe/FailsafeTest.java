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
package lets.core.failsafe;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import lets.core.CoreUtils;
import lets.core.LoggerSupport;
import lets.core.RandomUtils;
import lets.core.ResultSupport;
import lets.core.StopWatch;
import lets.core.concurrent.ThreadUtils;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import net.jodah.failsafe.Timeout;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

/** The Class FailsafeTest. */
public class FailsafeTest {

  /** The logger. */
  public final Logger logger = LoggerSupport.getLogger(this.getClass());

  /**
   * Hardwork.
   *
   * @param what the what
   * @param timeUnit the time unit
   * @param peroid the peroid
   * @return the result support
   */
  public ResultSupport hardwork(String what, TimeUnit timeUnit, int peroid) {
    ResultSupport result = new ResultSupport();
    StopWatch sw = StopWatch.createStarted();
    try {
      this.logger.info("开始:{}", what);
      ThreadUtils.sleep(timeUnit, peroid);
      this.logger.info("完成:{} 耗时:{}", what, sw.formatTime());
    } catch (Throwable e) {
      this.logger.error("出错:{}", what);
      result.onException(e);
    }
    return result;
  }

  /**
   * Hardwork throw.
   *
   * @param what the what
   * @param timeUnit the time unit
   * @param from the from
   * @param to the to
   * @return the result support
   */
  public ResultSupport hardworkRandom(String what, TimeUnit timeUnit, int from, int to) {
    this.logger.info("hardworkRandom:{} from={} to={}", what, from, to);
    CoreUtils.checkState(from >= 0, "from must>=0");
    CoreUtils.checkState(to > from, "to must> from");
    ResultSupport result = new ResultSupport();
    StopWatch sw = StopWatch.createStarted();
    this.logger.info("开始:{}", what);
    ThreadUtils.sleep(timeUnit, RandomUtils.nextInt(from, to));
    this.logger.info("完成:{} 耗时:{}", what, sw.formatTime());
    return result;
  }

  /**
   * Hardwork failsafeOnBackgroud.
   *
   * @param what the what
   * @param timeUnit the time unit
   * @param peroid the peroid
   * @return the result support
   */
  public ResultSupport hardworkFailsafe(String what, TimeUnit timeUnit, int peroid) {
    ResultSupport result = new ResultSupport();
    try {
      Timeout<ResultSupport> retryPolicy = Timeout.of(Duration.ofSeconds(5));
      retryPolicy.withInterrupt(true);
      return Failsafe.with(retryPolicy).get(() -> this.hardwork(what, timeUnit, peroid));
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Gets the started.
   *
   * @return the started
   */
  public void getStartedWithRetry() {
    // Getting Started
    // To start, we’ll create a retry policy that defines which failures should be
    // handled and when retries should be performed:
    RetryPolicy<ResultSupport> retryPolicy =
        new RetryPolicy<ResultSupport>().withDelay(Duration.ofSeconds(1)).withMaxRetries(3);
    // We can then execute a Runnable or Supplier with retries:
    // Run with retries
    Failsafe.with(retryPolicy).run(() -> this.hardworkRandom("Searching", TimeUnit.SECONDS, 1, 5));
    // Get with retries
    ResultSupport result =
        Failsafe.with(retryPolicy)
            .get(() -> this.hardworkRandom("Searching", TimeUnit.SECONDS, 5, 1));
    this.logger.info("success={} message={}", result.isSuccess(), result.getMessage());
  }

  /**
   * Gets the started with timeout.
   *
   * @return the started with timeout
   */
  public void getStartedWithTimeout() {
    // Getting Started
    // Timeouts allow you to fail an execution with TimeoutExceededException if it
    // takes too long to complete:
    Timeout<ResultSupport> timeoutPolicy = Timeout.of(Duration.ofSeconds(5));
    // You can also interrupt an execution if it times out:
    timeoutPolicy.withInterrupt(true);
    Failsafe.with(timeoutPolicy).run(() -> this.hardwork("Searching", TimeUnit.SECONDS, 1));
    Failsafe.with(timeoutPolicy).run(() -> this.hardwork("Searching", TimeUnit.SECONDS, 5));
    Failsafe.with(timeoutPolicy).run(() -> this.hardwork("Searching", TimeUnit.SECONDS, 10));
    Failsafe.with(timeoutPolicy).run(() -> this.hardwork("Searching", TimeUnit.SECONDS, 15));
  }

  /**
   * Gets the started with timeout wrapper.
   *
   * @return the started with timeout wrapper
   */
  @Test
  public void getStartedWithTimeoutWrapper() {
    // Getting Started
    // Timeouts allow you to fail an execution with TimeoutExceededException if it
    // takes too long to complete:
    Timeout<ResultSupport> timeoutPolicy = Timeout.of(Duration.ofSeconds(5));
    // You can also interrupt an execution if it times out:
    timeoutPolicy.withInterrupt(true);
    ResultSupport result = this.hardworkFailsafe("Searching", TimeUnit.SECONDS, 1);
    assertTrue(result.isSuccess());
    result = this.hardworkFailsafe("Searching", TimeUnit.SECONDS, 5);
    assertTrue(result.isSuccess());
    result = this.hardworkFailsafe("Searching", TimeUnit.SECONDS, 10);
    assertFalse(result.isSuccess());
    result = this.hardworkFailsafe("Searching", TimeUnit.SECONDS, 15);
    assertFalse(result.isSuccess());
  }
}
