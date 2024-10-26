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

import lets.core.os.linux.LinuxOperatingSystem;
import lets.core.os.macos.MacOSOperatingSystem;
import lets.core.os.windows.WindowsOperatingSystem;

/**
 * AbstractMultipleOperatingSystemFunction.
 *
 * @author zhoupan
 * @param <Input> the generic type
 * @param <Output> the generic type
 */
public abstract class AbstractMultipleOperatingSystemFunction<Input, Output>
    implements MultipleOperatingSystemFunction<Input, Output> {

  /**
   * Callback.
   *
   * @param os the os
   * @param input the input
   * @return the output
   */
  @Override
  public Output callback(AbstractOperatingSystem os, Input input) {
    if (os.getType() == OperatingSystem.WINDOWS) {
      WindowsOperatingSystem wos = (WindowsOperatingSystem) os;
      Output output = onWindows(wos, input);
      if (output != null) {
        return output;
      }
    } else if (os.getType() == OperatingSystem.MACOS) {
      MacOSOperatingSystem xos = (MacOSOperatingSystem) os;
      Output output = onMacOS(xos, input);
      if (output != null) {
        return output;
      }
    } else if (os.getType() == OperatingSystem.LINUX) {
      LinuxOperatingSystem los = (LinuxOperatingSystem) os;
      Output output = onLinux(los, input);
      if (output != null) {
        return output;
      }
    }
    return onFallback(os, input);
  }

  /**
   * On windows.
   *
   * @param os the os
   * @param input the input
   * @return the output
   */
  public abstract Output onWindows(WindowsOperatingSystem os, Input input);

  /**
   * On mac OS.
   *
   * @param os the os
   * @param input the input
   * @return the output
   */
  public abstract Output onMacOS(MacOSOperatingSystem os, Input input);

  /**
   * On linux.
   *
   * @param os the os
   * @param input the input
   * @return the output
   */
  public abstract Output onLinux(LinuxOperatingSystem os, Input input);

  /**
   * On fallback.
   *
   * @param os the os
   * @param input the input
   * @return the output
   */
  public abstract Output onFallback(AbstractOperatingSystem os, Input input);
}
