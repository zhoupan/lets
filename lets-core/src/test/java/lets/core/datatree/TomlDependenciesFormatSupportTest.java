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
package lets.core.datatree;

import java.io.File;
import java.io.IOException;
import lets.core.gradle.TomlDependenciesFormatSupport;
import org.junit.jupiter.api.Test;

public class TomlDependenciesFormatSupportTest {

  @Test
  public void testTomlDependenciesFormatSupport() throws IOException {
    Tree v = new Tree();
    TomlDependenciesFormatSupport support = new TomlDependenciesFormatSupport();
    TomlDependenciesFormatSupport.TomlDependency dep =
        new TomlDependenciesFormatSupport.TomlDependency(
            "com.google.guava:guava", "32.1.3-jre", "guava");
    support.writeTomlDependency(v, dep);
    support.writeFile(v, new File("target/test.toml"));
  }
}
