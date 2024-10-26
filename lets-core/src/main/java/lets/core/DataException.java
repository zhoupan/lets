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
 * 数据异常.
 *
 * @author zhoupan
 */
public class DataException extends RuntimeException {

  /** */
  private static final long serialVersionUID = 1L;

  /** 状态.(0表示成功;其他表示错误). */
  private int code = 0;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public DataException(int code, String msg) {
    super(msg);
    this.code = code;
  }

  /**
   * The Constructor.
   *
   * @param msg the msg
   */
  public DataException(String msg) {
    this(500, msg);
  }
}
