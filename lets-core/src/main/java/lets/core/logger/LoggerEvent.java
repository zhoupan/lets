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
package lets.core.logger;

import java.util.Date;
import org.slf4j.event.Level;

/**
 * LoggerEvent.
 *
 * @author zhoupan
 */
public class LoggerEvent {

  /** The id. */
  private Long id;

  /** The level. */
  private Level level = Level.INFO;

  /** The logger name. */
  private String loggerName;

  /** The message. */
  private String message;

  /** The thread name. */
  private String threadName = Thread.currentThread().getName();

  /** The logger at. */
  private Date loggerAt = new Date();

  /** The throwable. */
  private Throwable throwable;

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the level.
   *
   * @return the level
   */
  public Level getLevel() {
    return level;
  }

  /**
   * Sets the level.
   *
   * @param level the new level
   */
  public void setLevel(Level level) {
    this.level = level;
  }

  /**
   * Gets the logger name.
   *
   * @return the logger name
   */
  public String getLoggerName() {
    return loggerName;
  }

  /**
   * Sets the logger name.
   *
   * @param loggerName the new logger name
   */
  public void setLoggerName(String loggerName) {
    this.loggerName = loggerName;
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
   * Gets the thread name.
   *
   * @return the thread name
   */
  public String getThreadName() {
    return threadName;
  }

  /**
   * Sets the thread name.
   *
   * @param threadName the new thread name
   */
  public void setThreadName(String threadName) {
    this.threadName = threadName;
  }

  /**
   * Gets the logger at.
   *
   * @return the logger at
   */
  public Date getLoggerAt() {
    return loggerAt;
  }

  /**
   * Sets the logger at.
   *
   * @param loggerAt the new logger at
   */
  public void setLoggerAt(Date loggerAt) {
    this.loggerAt = loggerAt;
  }

  /**
   * Gets the throwable.
   *
   * @return the throwable
   */
  public Throwable getThrowable() {
    return throwable;
  }

  /**
   * Sets the throwable.
   *
   * @param throwable the new throwable
   */
  public void setThrowable(Throwable throwable) {
    this.throwable = throwable;
  }

  /**
   * Name.
   *
   * @param cls the cls
   * @return the logger event
   */
  public LoggerEvent name(Class<?> cls) {
    return name(cls.getName());
  }

  /**
   * Name.
   *
   * @param name the name
   * @return the logger event
   */
  public LoggerEvent name(String name) {
    this.setLoggerName(name);
    return this;
  }

  /**
   * Message.
   *
   * @param message the message
   * @return the logger event
   */
  public LoggerEvent message(String message) {
    this.setMessage(message);
    return this;
  }

  /**
   * Level.
   *
   * @param level the level
   * @return the logger event
   */
  public LoggerEvent level(Level level) {
    this.level = level;
    return this;
  }

  /**
   * Throwable.
   *
   * @param e the e
   * @return the logger event
   */
  public LoggerEvent throwable(Throwable e) {
    this.throwable = e;
    return this;
  }

  /**
   * At.
   *
   * @param date the date
   * @return the logger event
   */
  public LoggerEvent at(Date date) {
    this.setLoggerAt(date);
    return this;
  }
}
