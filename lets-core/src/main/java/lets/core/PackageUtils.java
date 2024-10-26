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

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.function.Function;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public final class PackageUtils {

  private PackageUtils() {
    /* no-op */
  }

  static final String DEFAULT_PACKAGE_NAME = "";

  /**
   * Get the package attribute for the supplied {@code type} using the supplied {@code function}.
   *
   * <p>This method only returns a non-empty {@link Optional} value holder if the class loader for
   * the supplied type created a {@link Package} object and the supplied function does not return
   * {@code null} when applied.
   *
   * @param type the type to get the package attribute for
   * @param function a function that computes the package attribute value (e.g., {@code
   *     Package::getImplementationTitle}); never {@code null}
   * @return an {@code Optional} containing the attribute value; never {@code null} but potentially
   *     empty
   * @see Class#getPackage()
   * @see Package#getImplementationTitle()
   * @see Package#getImplementationVersion()
   */
  public static Optional<String> getAttribute(Class<?> type, Function<Package, String> function) {
    CoreUtils.checkNotNull(type, "type must not be null");
    CoreUtils.checkNotNull(function, "function must not be null");
    return Optional.ofNullable(type.getPackage()).map(function);
  }

  /**
   * Get the value of the specified attribute name, specified as a string, or an empty {@link
   * Optional} if the attribute was not found. The attribute name is case-insensitive.
   *
   * <p>This method also returns an empty {@link Optional} value holder if any exception is caught
   * while loading the manifest file via the JAR file of the specified type.
   *
   * @param type the type to get the attribute for
   * @param name the attribute name as a string
   * @return an {@code Optional} containing the attribute value; never {@code null} but potentially
   *     empty
   * @see Manifest#getMainAttributes()
   */
  public static Optional<String> getAttribute(Class<?> type, String name) {
    CoreUtils.checkNotNull(type, "type must not be null");
    CoreUtils.checkNotBlank(name, "name must not be blank");
    try {
      URL jarUrl = type.getProtectionDomain().getCodeSource().getLocation();
      try (JarFile jarFile = new JarFile(new File(jarUrl.toURI()))) {
        Attributes mainAttributes = jarFile.getManifest().getMainAttributes();
        return Optional.ofNullable(mainAttributes.getValue(name));
      }
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
