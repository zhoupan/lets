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
package lets.core.os;

import java.io.Serializable;

public abstract class AbstractOperatingSystem implements Serializable {

  private static final long serialVersionUID = 7993846066826992068L;

  protected final OperatingSystem type;
  protected Arch arch;
  protected DesktopEnvironment de;

  public AbstractOperatingSystem(OperatingSystem type, Arch arch) {
    this.type = type;
    this.arch = arch;
  }

  public OperatingSystem getType() {
    return this.type;
  }

  public Arch getArch() {
    return this.arch;
  }

  public void setArch(Arch arch) {
    this.arch = arch;
  }

  public DesktopEnvironment getDesktopEnvironment() {
    if (de == null) {
      de = DEDetector.detect();
    }

    return de;
  }

  public void setDesktopEnvironment(DesktopEnvironment de) {
    this.de = de;
  }

  /** Returns display string */
  public abstract String getDisplayString();

  /** Returns detailed string */
  public abstract String getDetailedString();

  public final boolean isUnix() {
    return type == OperatingSystem.BSD
        || type == OperatingSystem.MACOS
        || type == OperatingSystem.LINUX
        || type == OperatingSystem.SOLARIS;
  }
}
