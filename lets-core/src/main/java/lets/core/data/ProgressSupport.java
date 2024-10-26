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
package lets.core.data;

/**
 * ProgressSupport.
 *
 * @author zhoupan
 */
public class ProgressSupport {

  /** The max. */
  private long max;

  /** The progress. */
  private long progress;

  /**
   * Gets the max.
   *
   * @return the max
   */
  public long getMax() {
    return max;
  }

  /**
   * Sets the max.
   *
   * @param max the new max
   */
  public void setMax(long max) {
    this.max = max;
  }

  /**
   * Gets the progress.
   *
   * @return the progress
   */
  public long getProgress() {
    return progress;
  }

  /**
   * Sets the progress.
   *
   * @param progress the new progress
   */
  public void setProgress(long progress) {
    this.progress = progress;
  }
}
