/*
 * Copyright (c) 2021 zhoupan (https://github.com/zhoupan).
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
package lets.core;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import lets.core.properties.SortedProperties;
import org.junit.jupiter.api.Test;

public class SystemUtilsTest {

  @Test
  public void systemUtils() {
    File tmpdir = SystemUtils.getJavaIoTmpDir();
    File user = SystemUtils.getUserDir();
    File userhome = SystemUtils.getUserHome();
    LoggerSupport.info("tempDir:{} user:{} home={}", tmpdir, user, userhome);
    DataResultSupport<List<String>> paths = SystemUtils.getPaths(Arrays.asList("."));
    LoggerSupport.info("paths={}", paths);
    paths.checkState();
    DataResultSupport<List<String>> pathExts = SystemUtils.getPathExts();
    LoggerSupport.info("pathExts={}", pathExts);
    pathExts.checkState();
    DataResultSupport<List<String>> whichJavas = SystemUtils.which("java");
    LoggerSupport.info("whichJavas={}", whichJavas);
    whichJavas = SystemUtils.which("java", Arrays.asList("d:\\java\\zulu19\\bin\\"));
    LoggerSupport.info("whichJavas={}", whichJavas);
    SortedProperties env = new SortedProperties();
    env.putAll(System.getenv());
    LoggerSupport.info("env {}", env.toLines());
    SortedProperties props = new SortedProperties();
    props.putAll(System.getProperties());
    LoggerSupport.info("props {}", props.toLines());
  }
}
