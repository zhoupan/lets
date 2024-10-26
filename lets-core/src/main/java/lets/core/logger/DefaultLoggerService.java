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

import jodd.bean.BeanUtil;
import lets.core.LoggerService;
import lets.core.LoggerSupport;
import lets.core.StringUtils;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.Util;

/**
 * DefaultLoggerService.
 *
 * @author zhoupan
 */
public class DefaultLoggerService implements LoggerService {

  /** The logger factory. */
  private ILoggerFactory loggerFactory;

  public DefaultLoggerService() {
    this(LoggerFactory.getILoggerFactory());
  }

  /**
   * Instantiates a new default logger service.
   *
   * @param loggerFactory the logger factory
   */
  public DefaultLoggerService(ILoggerFactory loggerFactory) {
    super();
    this.loggerFactory = loggerFactory;
  }

  /**
   * Gets the logger.
   *
   * @param name the name
   * @return the logger
   */
  public Logger getLogger(String name) {
    return this.loggerFactory.getLogger(name);
  }

  /**
   * Gets the logger.
   *
   * @param clasz the clasz
   * @return the logger
   */
  public Logger getLogger(Class<?> clasz) {
    return getLogger(clasz.getName());
  }

  @Override
  public void setLoggerLevel(String name, int level) {
    LoggerSupport.printMessage("setLoggerLevel: name={} level={}", name, level);
    String loggerName = name = StringUtils.defaultIfBlank(name, Logger.ROOT_LOGGER_NAME);
    Logger logger = this.getLogger(loggerName);
    try {
      if (BeanUtil.pojo.hasProperty(logger, "currentLogLevel")) {
        BeanUtil.pojo.setProperty(logger, "currentLogLevel", level);
      }
      if (BeanUtil.pojo.hasProperty(logger, "level")) {
        BeanUtil.pojo.setProperty(logger, "level", level);
      }
    } catch (Throwable e) {
      Util.report(
          LoggerSupport.messageFormat(
              "setLoggerLevel: name={} level={} impl={}", name, level, logger.getClass().getName()),
          e);
    }
  }
}
