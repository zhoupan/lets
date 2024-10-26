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

import lets.core.logger.DefaultLoggerService;
import lets.core.logger.LoggerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.slf4j.helpers.MessageFormatter;

/** LoggerSupport. */
public class LoggerSupport {

  /** The print to system out. */
  public static boolean printToSystemOut = false;

  // The OFF level can only be used in configuration files to disable logging.
  // It has
  // no printing method associated with it in o.s.Logger interface.
  /** The Constant LOG_LEVEL_OFF. */
  public static final int LOG_LEVEL_OFF = Level.ERROR.toInt() + 10;

  /** loggerService. */
  public static final MutableValue<LoggerService> loggerService =
      new MutableValue<LoggerService>()
          .set(new DefaultLoggerService(LoggerFactory.getILoggerFactory()));

  /**
   * Println.
   *
   * @param pattern the pattern
   * @param args the args
   * @return the result support
   */
  public static ResultSupport printMessage(String pattern, Object... args) {
    ResultSupport result = new ResultSupport();
    try {
      if (printToSystemOut) {
        System.out.println(LoggerSupport.messageFormat(pattern, args));
      }
      LoggerSupport.info(pattern, args);
    } catch (Throwable e) {
      // ignore
    }
    return result;
  }

  /**
   * Println.
   *
   * @param e the e
   * @return the result support
   */
  public static ResultSupport println(Throwable e) {
    ResultSupport result = new ResultSupport();
    try {
      return println(ExceptionUtils.getStackTrace(e));
    } catch (Throwable ex) {
      // ignore
    }
    return result;
  }

  /**
   * Println.
   *
   * @param message the message
   * @return the result support
   */
  public static ResultSupport println(String message) {
    ResultSupport result = new ResultSupport();
    try {
      if (printToSystemOut) {
        System.out.println(message);
      }
      LoggerSupport.info(message);
    } catch (Throwable e) {
      // ignore
    }
    return result;
  }

  /**
   * Logger level from.
   *
   * @param level the level
   * @return the level
   */
  public static Level loggerLevelFrom(int level) {
    for (Level l : Level.values()) {
      if (level == l.toInt()) {
        return l;
      }
    }
    return Level.INFO;
  }

  /** The Constant getLogger(). */
  private static Logger logger = null;

  /**
   * Gets the logger.
   *
   * @param clasz the clasz
   * @return the logger
   */
  public static synchronized Logger getLogger(Class<?> clasz) {
    return LoggerFactory.getLogger(clasz);
  }

  /**
   * Gets the logger.
   *
   * @param name the name
   * @return the logger
   */
  public static synchronized Logger getLogger(String name) {
    return LoggerFactory.getLogger(name);
  }

  /**
   * Gets the logger.
   *
   * @return the logger
   */
  public static synchronized Logger getLogger() {
    if (logger == null) {
      logger = buildLogger();
    }
    return logger;
  }

  /** Sets the current log level debug. */
  public static synchronized void setCurrentLogLevelDebug() {
    setCurrentLogLevel(Level.DEBUG);
  }

  /** Sets the current log level info. */
  public static synchronized void setCurrentLogLevelInfo() {
    setCurrentLogLevel(Level.INFO);
  }

  /** Sets the current log level error. */
  public static synchronized void setCurrentLogLevelError() {
    setCurrentLogLevel(Level.ERROR);
  }

  /** Sets the current log level off. */
  public static synchronized void setCurrentLogLevelOff() {
    setCurrentLogLevel(Logger.ROOT_LOGGER_NAME, LOG_LEVEL_OFF);
  }

  /**
   * Sets the current log level.
   *
   * @param level the new current log level
   */
  public static synchronized void setCurrentLogLevel(Level level) {
    setCurrentLogLevel(Logger.ROOT_LOGGER_NAME, level);
  }

  /**
   * Sets the current log level.
   *
   * @param level the new current log level
   */
  public static synchronized void setCurrentLogLevel(int level) {
    setCurrentLogLevel(Logger.ROOT_LOGGER_NAME, level);
  }

  /**
   * Builds the logger.
   *
   * @return the logger
   */
  public static Logger buildLogger() {
    return LoggerFactory.getLogger(LoggerSupport.class.getSimpleName());
  }

  /**
   * Sets the current log level.
   *
   * @param cls the cls
   * @param level the level
   */
  public static synchronized void setCurrentLogLevel(Class<?> cls, Level level) {
    setCurrentLogLevel(cls.getName(), level);
  }

  /**
   * Sets the current log level.
   *
   * @param name the name
   * @param level the level
   */
  public static synchronized void setCurrentLogLevel(String name, Level level) {
    try {
      LoggerSupport.info("setCurrentLogLevel: name={} level={}", name, level);
      CoreUtils.notImplemented();
    } catch (Throwable e) {
      LoggerSupport.info("setCurrentLogLevel: name={} level={}", name, level, e);
    }
  }

  public static Optional<Level> getLoggerLevelOptional(int level) {
    for (Level l : Level.values()) {
      if (l.toInt() == level) {
        return Optional.of(l);
      }
    }
    return Optional.empty();
  }

  /**
   * Sets the current log level.
   *
   * @param name the name
   * @param level the level
   */
  public static synchronized void setCurrentLogLevel(String name, int level) {
    try {
      LoggerSupport.info("setCurrentLogLevel: name={} level={}", name, level);
      if (loggerService.isPresent()) {
        loggerService.get().setLoggerLevel(name, level);
      }
    } catch (Throwable e) {
      LoggerSupport.info("setCurrentLogLevel: name={} level={}", name, level, e);
    }
  }

  /**
   * Sets the logger.
   *
   * @param logger the new logger
   */
  public static synchronized void setLogger(Logger logger) {
    LoggerSupport.logger = logger;
  }

  /**
   * Checks if is trace enabled.
   *
   * @return true, if checks if is trace enabled
   */
  public static boolean isTraceEnabled() {
    return false;
  }

  /**
   * Trace.
   *
   * @param msg the msg
   */
  public static void trace(String msg) {
    getLogger().trace(msg);
  }

  /**
   * Trace.
   *
   * @param format the format
   * @param arg the arg
   */
  public static void trace(String format, Object arg) {
    getLogger().trace(format, arg);
  }

  /**
   * Trace.
   *
   * @param format the format
   * @param arg1 the arg1
   * @param arg2 the arg2
   */
  public static void trace(String format, Object arg1, Object arg2) {
    getLogger().trace(format, arg1, arg2);
  }

  /**
   * Trace.
   *
   * @param format the format
   * @param arguments the arguments
   */
  public static void trace(String format, Object... arguments) {
    getLogger().trace(format, arguments);
  }

  /**
   * Trace.
   *
   * @param msg the msg
   * @param t the t
   */
  public static void trace(String msg, Throwable t) {
    getLogger().trace(msg, t);
  }

  /**
   * Checks if is debug enabled.
   *
   * @return true, if checks if is debug enabled
   */
  public static boolean isDebugEnabled() {
    return getLogger().isDebugEnabled();
  }

  /**
   * Debug.
   *
   * @param msg the msg
   */
  public static void debug(String msg) {
    getLogger().debug(msg);
  }

  /**
   * Debug.
   *
   * @param format the format
   * @param arg the arg
   */
  public static void debug(String format, Object arg) {
    getLogger().debug(format, arg);
  }

  /**
   * Debug.
   *
   * @param format the format
   * @param arg1 the arg1
   * @param arg2 the arg2
   */
  public static void debug(String format, Object arg1, Object arg2) {
    getLogger().debug(format, arg1, arg2);
  }

  /**
   * Debug.
   *
   * @param format the format
   * @param arguments the arguments
   */
  public static void debug(String format, Object... arguments) {
    getLogger().debug(format, arguments);
  }

  /**
   * Debug.
   *
   * @param msg the msg
   * @param t the t
   */
  public static void debug(String msg, Throwable t) {
    getLogger().debug(msg, t);
  }

  /**
   * Checks if is info enabled.
   *
   * @return true, if checks if is info enabled
   */
  public static boolean isInfoEnabled() {
    return getLogger().isInfoEnabled();
  }

  /**
   * Info.
   *
   * @param msg the msg
   */
  public static void info(String msg) {
    getLogger().info(msg);
  }

  /**
   * Info.
   *
   * @param format the format
   * @param arg the arg
   */
  public static void info(String format, Object arg) {
    getLogger().info(format, arg);
  }

  /**
   * Info.
   *
   * @param format the format
   * @param arg1 the arg1
   * @param arg2 the arg2
   */
  public static void info(String format, Object arg1, Object arg2) {
    getLogger().info(format, arg1, arg2);
  }

  /**
   * Info.
   *
   * @param format the format
   * @param arguments the arguments
   */
  public static void info(String format, Object... arguments) {
    getLogger().info(format, arguments);
  }

  /**
   * Info.
   *
   * @param msg the msg
   * @param t the t
   */
  public static void info(String msg, Throwable t) {
    getLogger().info(msg, t);
  }

  /**
   * Checks if is warn enabled.
   *
   * @return true, if checks if is warn enabled
   */
  public static boolean isWarnEnabled() {
    return getLogger().isWarnEnabled();
  }

  /**
   * Warn.
   *
   * @param msg the msg
   */
  public static void warn(String msg) {
    getLogger().warn(msg);
  }

  /**
   * Warn.
   *
   * @param format the format
   * @param arg the arg
   */
  public static void warn(String format, Object arg) {
    getLogger().warn(format, arg);
  }

  /**
   * Warn.
   *
   * @param format the format
   * @param arg1 the arg1
   * @param arg2 the arg2
   */
  public static void warn(String format, Object arg1, Object arg2) {
    getLogger().warn(format, arg1, arg2);
  }

  /**
   * Warn.
   *
   * @param format the format
   * @param arguments the arguments
   */
  public static void warn(String format, Object... arguments) {
    getLogger().warn(format, arguments);
  }

  /**
   * Warn.
   *
   * @param msg the msg
   * @param t the t
   */
  public static void warn(String msg, Throwable t) {
    getLogger().warn(msg, t);
  }

  /**
   * Checks if is error enabled.
   *
   * @return true, if checks if is error enabled
   */
  public static boolean isErrorEnabled() {
    return getLogger().isErrorEnabled();
  }

  /**
   * Error.
   *
   * @param msg the msg
   */
  public static void error(String msg) {
    getLogger().error(msg);
  }

  /**
   * Error.
   *
   * @param e the e
   */
  public static void error(Throwable e) {
    getLogger().error("{}", ExceptionUtils.getStackTrace(e));
  }

  /**
   * Error.
   *
   * @param logger the logger
   * @param e the e
   */
  public static void error(Logger logger, Throwable e) {
    getLogger().error("{}", ExceptionUtils.getStackTrace(e));
  }

  /**
   * Error.
   *
   * @param format the format
   * @param arg the arg
   */
  public static void error(String format, Object arg) {
    getLogger().error(format, arg);
  }

  /**
   * Error.
   *
   * @param format the format
   * @param arg1 the arg1
   * @param arg2 the arg2
   */
  public static void error(String format, Object arg1, Object arg2) {
    getLogger().error(format, arg1, arg2);
  }

  /**
   * Error.
   *
   * @param format the format
   * @param arguments the arguments
   */
  public static void error(String format, Object... arguments) {
    getLogger().error(format, arguments);
  }

  /**
   * Error.
   *
   * @param msg the msg
   * @param t the t
   */
  public static void error(String msg, Throwable t) {
    getLogger().error(msg, t);
  }

  /**
   * Message format.
   *
   * @param pattern the pattern
   * @param args the args
   * @return the string
   */
  public static String messageFormat(String pattern, Object... args) {
    return MessageFormatter.arrayFormat(pattern, args).getMessage();
  }

  /**
   * On logger event.
   *
   * @param event the event
   */
  public static void onLoggerEvent(LoggerEvent event) {}
}
