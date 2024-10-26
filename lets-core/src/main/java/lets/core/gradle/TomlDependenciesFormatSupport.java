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
package lets.core.gradle;

import java.io.File;
import java.io.IOException;
import lets.core.datatree.Tree;
import lets.core.datatree.TreeUtils;
import lets.core.datatree.dom.TreeWriterRegistry;
import lets.core.datatree.dom.adapters.TomlJtoml;
import lets.core.io.FileUtils;

public class TomlDependenciesFormatSupport {

  public static class TomlDependency {
    private String module;
    private String version;
    private String versionRef;

    public TomlDependency(String module, String version, String versionRef) {
      this.module = module;
      this.version = version;
      this.versionRef = versionRef;
    }

    public String getModule() {
      return module;
    }

    public void setModule(String module) {
      this.module = module;
    }

    public String getVersion() {
      return version;
    }

    public void setVersion(String version) {
      this.version = version;
    }

    public String getVersionRef() {
      return versionRef;
    }

    public void setVersionRef(String versionRef) {
      this.versionRef = versionRef;
    }
  }

  TomlJtoml tomlAdaptger = new TomlJtoml();

  public TomlDependenciesFormatSupport() {
    TreeWriterRegistry.setWriter("toml", tomlAdaptger);
  }

  public Tree readFile(File file) throws Exception {
    return new Tree(file);
  }

  public void writeFile(Tree node, File file) throws IOException {
    String content = TreeUtils.toTomlDependenciesFormat(node);
    FileUtils.writeStringToFile(file, content, "UTF-8");
  }

  public void writeTomlDependency(Tree v, TomlDependency dep) {
    v.put("versions." + dep.getVersionRef(), dep.getVersion());
    v.put("libraries." + dep.getVersionRef() + ".module", dep.getModule());
    v.put("libraries." + dep.getVersionRef() + ".version.ref", dep.getVersionRef());
  }

  public void writeTomlDependency(Tree v, String versionRef, String version) {
    v.put("versions." + versionRef, version);
  }
}
