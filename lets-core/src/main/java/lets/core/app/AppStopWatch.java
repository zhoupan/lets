/*
 * Copyright (c) 2022 zhoupan (https://github.com/zhoupan).
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
package lets.core.app;

import lets.core.DurationFormatUtils;

/** Stop watch, inspired by the implementation in the Spring framework. */
public class AppStopWatch {

  public static AppStopWatch createStarted() {
    AppStopWatch sw = new AppStopWatch();
    sw.start();
    return sw;
  }

  /** The timestamp at which the stopwatch was started. */
  private long start;

  /** The timestamp at which the stopwatch was stopped. */
  private long stop;

  /** Starts the stop watch. */
  public void start() {
    start = System.currentTimeMillis();
  }

  /** Stops the stop watch. */
  public void stop() {
    stop = System.currentTimeMillis();
  }

  /**
   * @return The total run time in millis of the stop watch between start and stop calls.
   */
  public long getTotalTimeMillis() {
    return stop - start;
  }

  public String formatTime() {
    return DurationFormatUtils.formatDurationHMS(Math.abs(this.getTotalTimeMillis()));
  }

  @Override
  public String toString() {
    if (this.stop != 0) {
      return "StopWatch [TotalTimeMillis="
          + this.getTotalTimeMillis()
          + ",Duration="
          + this.formatTime()
          + "]";
    } else {
      return "StopWatch [start=" + start + ", stop=" + stop + "]";
    }
  }
}
