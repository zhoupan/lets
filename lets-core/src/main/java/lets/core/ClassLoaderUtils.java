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

import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.util.Arrays;
import java.util.Optional;

/** Helps work with {@link ClassLoader}. */
public class ClassLoaderUtils {

  /**
   * Converts the given class loader to a String calling {@link #toString(URLClassLoader)}.
   *
   * @param classLoader to URLClassLoader to convert.
   * @return the formatted string.
   */
  public static String toString(final ClassLoader classLoader) {
    if (classLoader instanceof URLClassLoader) {
      return toString((URLClassLoader) classLoader);
    }
    return classLoader.toString();
  }

  /**
   * Converts the given URLClassLoader to a String in the format {@code "URLClassLoader.toString() +
   * [URL1, URL2, ...]"}.
   *
   * @param classLoader to URLClassLoader to convert.
   * @return the formatted string.
   */
  public static String toString(final URLClassLoader classLoader) {
    return classLoader + Arrays.toString(classLoader.getURLs());
  }

  public static ClassLoader getDefaultClassLoader() {
    try {
      ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
      if (contextClassLoader != null) {
        return contextClassLoader;
      }
    } catch (Throwable t) {
      ExceptionUtils.rethrowIfUnrecoverable(t);
      /* otherwise ignore */
    }
    return ClassLoader.getSystemClassLoader();
  }

  /**
   * Get the location from which the supplied object's class was loaded.
   *
   * @param object the object for whose class the location should be retrieved
   * @return an {@code Optional} containing the URL of the class' location; never {@code null} but
   *     potentially empty
   */
  public static Optional<URL> getLocation(Object object) {
    CoreUtils.checkNotNull(object, "object must not be null");
    // determine class loader
    ClassLoader loader = object.getClass().getClassLoader();
    if (loader == null) {
      loader = ClassLoader.getSystemClassLoader();
      while (loader != null && loader.getParent() != null) {
        loader = loader.getParent();
      }
    }
    // try finding resource by name
    if (loader != null) {
      String name = object.getClass().getName();
      name = name.replace(".", "/") + ".class";
      try {
        return Optional.ofNullable(loader.getResource(name));
      } catch (Throwable t) {
        ExceptionUtils.rethrowIfUnrecoverable(t);
        /* otherwise ignore */
      }
    }
    // try protection domain
    try {
      CodeSource codeSource = object.getClass().getProtectionDomain().getCodeSource();
      if (codeSource != null) {
        return Optional.ofNullable(codeSource.getLocation());
      }
    } catch (SecurityException ignore) {
      /* ignore */
    }
    return Optional.empty();
  }
}
