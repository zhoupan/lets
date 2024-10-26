/*
 * Copyright (c) 2023 zhoupan (https://github.com/zhoupan).
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
package lets.core.classpath;

import io.avaje.classpath.scanner.Resource;
import io.avaje.classpath.scanner.core.Scanner;
import java.util.List;
import java.util.function.Predicate;
import lets.core.DataResultSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ScannerSupport 支持<a
 * href="https://mvnrepository.com/artifact/io.avaje/classpath-scanner">classpath-scanner</a> <code>
 *
 * </code>
 *
 * @author zhoupan
 */
public class ScannerSupport {

  protected Scanner scanner;

  private final Logger logger = LoggerFactory.getLogger(getClass());

  public ScannerSupport() {
    this(Thread.currentThread().getContextClassLoader());
  }

  public ScannerSupport(ClassLoader classLoader) {
    super();
    this.scanner = new Scanner(classLoader);
  }

  public DataResultSupport<List<Resource>> scanForResources(
      String location, Predicate<String> predicate) {
    DataResultSupport<List<Resource>> result = new DataResultSupport<List<Resource>>();
    try {
      result.setData(this.scanner.scanForResources(location, predicate));
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public DataResultSupport<List<Class<?>>> scanForClasses(
      String location, Predicate<Class<?>> predicate) {
    DataResultSupport<List<Class<?>>> result = new DataResultSupport<List<Class<?>>>();
    try {
      this.logger.info("scanForClasses: location={}", location);
      result.setData(this.scanner.scanForClasses(location, predicate));
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
