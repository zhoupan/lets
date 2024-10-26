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
package lets.core.os.windows;

import java.io.Serializable;
import lets.core.os.AbstractOperatingSystem;
import lets.core.os.Arch;
import lets.core.os.OperatingSystem;

public class WindowsOperatingSystem extends AbstractOperatingSystem implements Serializable {

  private static final long serialVersionUID = 3629947448937163693L;

  private final WindowsVersion version;

  public WindowsOperatingSystem() {
    this(WindowsVersion.getFromString(), WindowsDetector.getArchWindows());
  }

  public WindowsOperatingSystem(String name, Arch arch) {
    this(WindowsVersion.getFromString(name), arch);
  }

  public WindowsOperatingSystem(String name) {
    this(WindowsVersion.getFromString(name), WindowsDetector.getArchWindows());
  }

  public WindowsOperatingSystem(WindowsVersion version, Arch arch) {
    super(OperatingSystem.WINDOWS, arch);
    this.version = version;
  }

  public WindowsOperatingSystem(WindowsVersion version) {
    this(version, WindowsDetector.getArchWindows());
  }

  public WindowsVersion getVersion() {
    return this.version;
  }

  @Override
  public String getDisplayString() {
    return version.getSearch();
  }

  @Override
  public String getDetailedString() {
    return version.getSearch();
  }
}
