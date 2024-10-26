/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
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
package lets.javacpp.qt5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import lets.core.CoreUtils;
import lets.core.StringUtils;
import org.bytedeco.javacpp.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Qt5CoreSupport {
  private String applicationName;
  private boolean noGui;

  private File coreDirectory;
  private File platformPluginDirectory;

  protected Logger logger = LoggerFactory.getLogger(Qt5CoreSupport.class);

  public Qt5CoreSupport(String applicationName, boolean noGui) {
    CoreUtils.checkState(
        StringUtils.isNotEmpty(applicationName), "application name not allow empty.");
    this.applicationName = applicationName;
    this.noGui = noGui;
    // c:\Users\<username>\.javacpp\cache\qt-5.15.2-1.5.8-windows-x86_64.jar\org\bytedeco\qt\windows-x86_64\jniQt5Core.dll
    String path = Loader.load(org.bytedeco.qt.global.Qt5Core.class);
    this.logger.info("Loader.load(Qt5Core):{}", path);
    this.coreDirectory = new File(path).getParentFile();
    this.logger.info("Core Directory:{}", this.coreDirectory);
    // c:\Users\<username>\.javacpp\cache\qt-5.15.2-1.5.8-windows-x86_64.jar\org\bytedeco\qt\windows-x86_64\qwindows.dll
    this.platformPluginDirectory = this.coreDirectory;
    this.logger.info("Platform Plugin Directory:{}", this.platformPluginDirectory);
  }

  public List<String> buildArguments() {
    List<String> args = new ArrayList<String>();
    args.add(this.applicationName);
    if (this.noGui) {
      args.add("-no-gui");
    }
    if (this.platformPluginDirectory != null) {
      args.add("-platformpluginpath");
      args.add(this.platformPluginDirectory.getAbsolutePath());
    }
    this.logger.info("buildArguments:{}", args);
    return args;
  }
}
