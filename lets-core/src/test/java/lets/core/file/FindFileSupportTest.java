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
import java.util.List;
import org.junit.jupiter.api.Test;

public class FindFileSupportTest {

  @Test
  public void testFindAll() {
    File path = new File("e:\\target\\velocity");
    FindFileSupport find = new FindFileSupport();
    find.withRecursive(true);
    find.withSearchPath(path);
    find.withIncludeWildcard("**/*.g4");
    List<File> javaFiles = find.findAll();
    for (File javaFile : javaFiles) {
      System.out.println("javaFile:" + javaFile.getAbsolutePath());
    }
  }
}
