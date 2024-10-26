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
package lets.core.os.bsd;

import java.io.Serializable;
import lets.core.os.Arch;
import lets.core.os.OperatingSystem;
import lets.core.os.UnixOperatingSystem;
import lets.core.os.linux.LinuxDetector;

public class BSDOperatingSystem extends UnixOperatingSystem implements Serializable {

  private static final long serialVersionUID = 3409615002184682276L;

  private final Flavor flavor;

  public BSDOperatingSystem(Flavor flavor, Arch arch) {
    super(OperatingSystem.BSD, arch);
    this.flavor = flavor;
  }

  public BSDOperatingSystem() {
    this(Flavor.getLocalFlavor(), LinuxDetector.getLinuxArch());
  }

  public BSDOperatingSystem(Flavor flavor) {
    this(flavor, LinuxDetector.getLinuxArch());
  }

  public Flavor getFlavor() {
    return this.flavor;
  }

  @Override
  public String getDisplayString() {
    return flavor.getName();
  }
}
