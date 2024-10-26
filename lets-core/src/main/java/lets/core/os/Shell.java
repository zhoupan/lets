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

import java.io.File;

public enum Shell {
  COMMAND_PROMPT("cmd"),
  TCSH("/bin/tcsh"),
  BASH("/bin/bash"),
  DEFAULT("/bin/sh");

  private final String path;

  Shell(String path) {
    this.path = path;
  }

  public String getPath() {
    return this.path;
  }

  /** Gets default shell for this operating system */
  public static Shell getShell() {
    return getShell(OperatingSystem.getOperatingSystem());
  }

  /**
   * Gets shell from operating system
   *
   * @param os the os to check for
   * @return Default shell, or /bin/sh if not found
   */
  public static Shell getShell(AbstractOperatingSystem os) {
    Shell shell;

    if (os.getType() == OperatingSystem.WINDOWS) {
      shell = COMMAND_PROMPT;
    } else if (os.getType() == OperatingSystem.BSD) {
      shell = TCSH;
    } else {
      shell = BASH;
    }

    if (os.getType() != OperatingSystem.WINDOWS) {
      File file = new File(shell.getPath());

      if (!file.exists()) {
        shell = DEFAULT;
      }
    }

    return shell;
  }
}
