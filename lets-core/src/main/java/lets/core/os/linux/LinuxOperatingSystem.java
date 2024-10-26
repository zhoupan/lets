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
package lets.core.os.linux;

import java.io.Serializable;
import lets.core.os.Arch;
import lets.core.os.OperatingSystem;
import lets.core.os.UnixOperatingSystem;

public class LinuxOperatingSystem extends UnixOperatingSystem implements Serializable {

  private static final long serialVersionUID = -1997336870542013705L;

  private final DistroSpec ds;

  public LinuxOperatingSystem(Distro d) {
    this(new DistroSpec(d), LinuxDetector.getLinuxArch());
  }

  public LinuxOperatingSystem(DistroSpec ds, Arch arch) {
    super(OperatingSystem.LINUX, arch);
    this.ds = ds;
  }

  public LinuxOperatingSystem() {
    this(Distro.getLocalDistroSpec(), LinuxDetector.getLinuxArch());
  }

  public LinuxOperatingSystem(DistroSpec ds) {
    this(ds, LinuxDetector.getLinuxArch());
  }

  public Distro getDistro() {
    return this.ds.getDistro();
  }

  public DistroSpec getDistroSpec() {
    return this.ds;
  }

  @Override
  public String getDisplayString() {
    Distro d = ds.getDistro();

    String name = d.getDisplayString();

    if (ds.getRelease() != null) {
      name += " " + ds.getRelease();
    }

    return name;
  }
}
