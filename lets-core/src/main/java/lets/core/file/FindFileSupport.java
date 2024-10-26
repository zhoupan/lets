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
package lets.core.file;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jodd.io.findfile.FindFile;
import jodd.io.findfile.WildcardFindFile;

/** FindFileSupport. */
public class FindFileSupport {

  /** The find file. */
  private final FindFile findFile = new WildcardFindFile();

  public FindFileSupport withRecursive(boolean recursive) {
    this.findFile.recursive(recursive);
    return this;
  }

  public FindFileSupport withIncludeDirs(boolean includeDirs) {
    this.findFile.includeDirs(includeDirs);
    return this;
  }

  /**
   * With search path.
   *
   * @param path the path
   * @return the find file support
   */
  public FindFileSupport withSearchPath(File path) {
    this.findFile.searchPath(path);
    return this;
  }

  /**
   * With wildcard.
   *
   * @param wildcards the wildcards
   * @return the find file support
   */
  public FindFileSupport withIncludeWildcard(String... wildcards) {
    this.findFile.include(wildcards);
    return this;
  }

  public FindFileSupport withIncludeWildcard(Set<String> wildcards) {
    for (String w : wildcards) {
      this.findFile.include(w);
    }
    return this;
  }

  public FindFileSupport withExcludeWildcard(String... wildcards) {
    this.findFile.exclude(wildcards);
    return this;
  }

  public FindFileSupport withExcludeWildcard(Set<String> wildcards) {
    for (String w : wildcards) {
      this.findFile.exclude(w);
    }
    return this;
  }

  public List<File> findAll() {
    return this.findFile.findAll();
  }

  public Set<File> findAllSet() {
    Set<File> files = new HashSet<File>();
    files.addAll(this.findAll());
    return files;
  }
}
