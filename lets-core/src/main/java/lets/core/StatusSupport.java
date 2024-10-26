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
package lets.core;

/**
 * 操作结果.
 *
 * @author zhoupan.
 */
public class StatusSupport implements java.io.Serializable {

  /** 默认成功状态代码. */
  public static final int STATUS_SUCCESS = HttpStatus.OK.value();

  /** 默认失败状态代码. */
  public static final int STATUS_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();

  public static StatusSupport build(boolean isSuccess, String message) {
    StatusSupport result = new StatusSupport();
    if (isSuccess) {
      result.onSuccess(message);
    } else {
      result.onException(message);
    }
    return result;
  }

  public static StatusSupport build(ResultSupport result) {
    StatusSupport status = new StatusSupport();
    if (result.isSuccess()) {
      status.onSuccess(result.getMessage());
    } else {
      status.onException(result.getMessage());
    }
    return status;
  }

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** 状态代码(200表示成功,其他表示失败). */
  private int status = STATUS_SUCCESS;

  /** 是否成功. */
  private boolean success = true;

  /** 成功、错误消息. */
  private String message = "操作成功";

  /**
   * Gets the status.
   *
   * @return the status
   */
  public int getStatus() {
    return status;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(int status) {
    this.status = status;
  }

  /**
   * Checks if is success.
   *
   * @return true, if is success
   */
  public boolean isSuccess() {
    return success;
  }

  /**
   * Sets the success.
   *
   * @param success the new success
   */
  public void setSuccess(boolean success) {
    this.success = success;
  }

  /**
   * Gets the message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Sets the message.
   *
   * @param message the new message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * 设置异常结果.
   *
   * @param e 异常.
   */
  public void onException(Throwable e) {
    if (e instanceof StatusException) {
      this.onException((StatusException) e);
      return;
    }
    this.setSuccess(false);
    this.setMessage(e.getMessage());
    this.setStatus(STATUS_ERROR);
    LoggerSupport.error("{}", CoreUtils.getStackTrace(e));
  }

  /**
   * 设置异常结果.
   *
   * @param message 异常消息.
   */
  public void onException(String message) {
    this.setSuccess(false);
    this.setMessage(message);
    this.setStatus(STATUS_ERROR);
  }

  /**
   * 设置异常结果.
   *
   * @param message the message
   * @param e the e
   */
  public void onException(String message, Throwable e) {
    this.setSuccess(false);
    this.setStatus(STATUS_ERROR);
    String cause = e.getMessage();
    if (CoreUtils.isBlank(cause)) {
      this.setMessage(message);
    } else {
      this.setMessage(String.format("%s %s", message, cause));
    }
    LoggerSupport.error("{}", CoreUtils.getStackTrace(e));
  }

  /**
   * 设置成功结果.
   *
   * @param message 成功消息.
   */
  public void onSuccess(String message) {
    this.setSuccess(true);
    this.setMessage(message);
    this.setStatus(STATUS_SUCCESS);
  }

  /**
   * On exception.
   *
   * @param e the StatusException
   */
  public void onException(StatusException e) {
    this.setSuccess(false);
    this.setStatus(e.getStatus());
    this.setMessage(e.getMessage());
  }

  /**
   * On status.
   *
   * @param httpStatus the http status
   */
  public void onStatus(HttpStatus httpStatus) {
    this.setSuccess(httpStatus.is2xxSuccessful());
    this.setStatus(httpStatus.value());
    this.setMessage(httpStatus.getReasonPhrase());
  }

  /** 检查是否成功,不成功抛出异常. */
  public void checkState() {
    CoreUtils.checkState(this.isSuccess(), this.getMessage());
  }

  @Override
  public String toString() {
    return "StatusSupport [status="
        + status
        + ", success="
        + success
        + ", message="
        + message
        + "]";
  }

  public boolean hasMessage() {
    return StringUtils.isNotEmpty(this.message);
  }
}
