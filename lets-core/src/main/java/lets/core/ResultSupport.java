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
 * Result of operation.
 *
 * @author zhoupan.
 */
public class ResultSupport implements java.io.Serializable {

  /** The Constant MESSAGE_SUCCESS. */
  public static final String MESSAGE_SUCCESS = "operation successfully completed.";

  /** The Constant MESSAGE_ERROR. */
  public static final String MESSAGE_ERROR = "operation failure.";

  /** default success code. */
  public static final int CODE_SUCCESS = 0;

  /** default error code. */
  public static final int CODE_ERROR = 500;

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** code (0 for success, others for failure). */
  private int code;

  /** if it is successful. */
  private boolean success = true;

  /** Success and error messages. */
  private String message = MESSAGE_SUCCESS;

  /** Stacktrace. */
  private boolean stackTrace;

  /** Stack trace message. */
  private String stackTraceMessage = "";

  /**
   * Gets the code.
   *
   * @return the code
   */
  public int getCode() {
    return code;
  }

  /**
   * Sets the code.
   *
   * @param code the new code
   */
  public void setCode(int code) {
    this.code = code;
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
   * Checks if is stack trace.
   *
   * @return true, if is stack trace
   */
  public boolean isStackTrace() {
    return stackTrace;
  }

  /**
   * Sets the stack trace.
   *
   * @param stackTrace the new stack trace
   */
  public void setStackTrace(boolean stackTrace) {
    this.stackTrace = stackTrace;
  }

  /**
   * Gets the stack trace message.
   *
   * @return the stack trace message
   */
  public String getStackTraceMessage() {
    return stackTraceMessage;
  }

  /**
   * Sets the stack trace message.
   *
   * @param stackTraceMessage the new stack trace message
   */
  public void setStackTraceMessage(String stackTraceMessage) {
    this.stackTraceMessage = stackTraceMessage;
  }

  /**
   * 设置异常结果.
   *
   * @param e 异常.
   */
  public void onException(Throwable e) {
    this.onException("", e);
  }

  /**
   * 设置异常结果.
   *
   * @param message 异常消息.
   */
  public void onException(String message) {
    this.setSuccess(false);
    this.setMessage(message);
    this.setCode(CODE_ERROR);
    LoggerSupport.println(message);
  }

  /**
   * 设置异常结果.
   *
   * @param message the message
   * @param e the e
   */
  public void onException(String message, Throwable e) {
    this.setSuccess(false);
    this.setCode(CODE_ERROR);
    String cause = e.getMessage();
    if (StringUtils.isBlank(cause)) {
      this.setMessage(message);
    } else {
      this.setMessage(String.format("%s %s", message, cause));
    }
    this.onStackTrace(e);
    LoggerSupport.println(e.getMessage());
  }

  /**
   * 设置成功结果.
   *
   * @param message 成功消息.
   */
  public void onSuccess(String message) {
    this.setSuccess(true);
    this.setMessage(message);
    this.setCode(CODE_SUCCESS);
    this.onStackTraceEmpty();
  }

  /**
   * On exception.
   *
   * @param e the e
   */
  public void onException(DataException e) {
    this.setSuccess(false);
    this.setCode(e.getCode());
    this.setMessage(e.getMessage());
    this.onStackTrace(e);
  }

  /**
   * On stack trace.
   *
   * @param e the e
   */
  public void onStackTrace(Throwable e) {
    this.setStackTrace(true);
    this.setStackTraceMessage(ExceptionUtils.getStackTrace(e));
    LoggerSupport.error(e);
  }

  /** On stack trace empty. */
  public void onStackTraceEmpty() {
    this.setStackTrace(false);
    this.setStackTraceMessage("");
  }

  /** Check state. */
  public void checkState() {
    CoreUtils.checkState(this.isSuccess(), this.getMessage());
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "ResultSupport [code="
        + code
        + ", success="
        + success
        + ", message="
        + message
        + ", stackTrace="
        + stackTrace
        + ", stackTraceMessage="
        + stackTraceMessage
        + "]";
  }
}
