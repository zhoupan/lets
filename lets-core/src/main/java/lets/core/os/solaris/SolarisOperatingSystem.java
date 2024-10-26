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
package lets.core.os.solaris;

import java.io.Serializable;
import lets.core.os.Arch;
import lets.core.os.OperatingSystem;
import lets.core.os.UnixOperatingSystem;

public class SolarisOperatingSystem extends UnixOperatingSystem implements Serializable {

  private static final long serialVersionUID = -9050140134144959153L;

  public SolarisOperatingSystem() {
    this(Arch.getArch());
  }

  public SolarisOperatingSystem(Arch arch) {
    super(OperatingSystem.SOLARIS, arch);
  }

  @Override
  public String getDisplayString() {
    return "Solaris";
  }
}
