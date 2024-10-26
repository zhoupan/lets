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
package lets.core;

/**
 * 数据结果支持类.
 *
 * @author zhoupan
 * @param <Data> the generic type
 */
public class DataResultSupport<Data> extends ResultSupport {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The data. */
  private Data data;

  /**
   * Gets the data.
   *
   * @return the data
   */
  public Data getData() {
    return data;
  }

  /**
   * Sets the data.
   *
   * @param data the new data
   */
  public void setData(Data data) {
    this.data = data;
  }

  /**
   * Checks if is empty.
   *
   * @return true, if is empty
   */
  public boolean isEmpty() {
    return this.data == null;
  }

  /**
   * Checks if is present.
   *
   * @return true, if is present
   */
  public boolean isPresent() {
    return this.data != null;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "DataResultSupport [data="
        + data
        + ", getCode()="
        + this.getCode()
        + ", isSuccess()="
        + this.isSuccess()
        + ", getMessage()="
        + this.getMessage()
        + ", isStackTrace()="
        + this.isStackTrace()
        + ", getStackTraceMessage()="
        + this.getStackTraceMessage()
        + "]";
  }
}
