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
package lets.core;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Collection of utilities for working with {@code java.lang.Module} and friends. */
public class ModuleUtils {

  private static final Logger logger = LoggerFactory.getLogger(ModuleUtils.class);

  /**
   * Find all non-system boot modules names.
   *
   * @return a set of all such module names; never {@code null} but potentially empty
   */
  public static Set<String> findAllNonSystemBootModuleNames() {
    logger.info("Basic version of findAllNonSystemBootModuleNames() always returns an empty set!");
    return Collections.emptySet();
  }

  /**
   * Determine if the current Java runtime supports the Java Platform Module System.
   *
   * @return {@code true} if the Java Platform Module System is available, otherwise {@code false}
   */
  public static boolean isJavaPlatformModuleSystemAvailable() {
    return false;
  }

  /**
   * Return the name of the module that the class or interface is a member of.
   *
   * @param type class or interface to analyze
   * @return the module name; never {@code null} but potentially empty
   */
  public static Optional<String> getModuleName(Class<?> type) {
    return Optional.empty();
  }

  /**
   * Return the raw version of the module that the class or interface is a member of.
   *
   * @param type class or interface to analyze
   * @return the raw module version; never {@code null} but potentially empty
   */
  public static Optional<String> getModuleVersion(Class<?> type) {
    return Optional.empty();
  }

  /**
   * Find all classes for the given module name.
   *
   * @param moduleName the name of the module to scan; never {@code null} or <em>empty</em>
   * @param filter the class filter to apply; never {@code null}
   * @return an immutable list of all such classes found; never {@code null} but potentially empty
   */
  public static List<Class<?>> findAllClassesInModule(String moduleName, ClassFilter filter) {
    CoreUtils.checkNotBlank(moduleName, "Module name must not be null or empty");
    CoreUtils.checkNotNull(filter, "Class filter must not be null");
    logger.info("Basic version of findAllClassesInModule() always returns an empty list!");
    return Collections.emptyList();
  }
}
