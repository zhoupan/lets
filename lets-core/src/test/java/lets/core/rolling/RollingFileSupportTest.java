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
package lets.core.rolling;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import lets.core.DataResultSupport;
import lets.core.LoggerSupport;
import lets.core.ResultSupport;
import lets.core.io.FileUtils;
import org.junit.jupiter.api.Test;

/** The Class RollingFileSupportTest. */
public class RollingFileSupportTest {

  /**
   * Test on start.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public void testOnStart() throws IOException {
    RollingFileSupport rolling = new RollingFileSupport();
    File dir = new File("target/rolling/1");
    rolling.withDir(dir);
    rolling.withFileExt(".txt");
    ResultSupport start = rolling.onStart();
    assertTrue(start.isSuccess());
    assertEquals(1, rolling.currentId());
    DataResultSupport<File> current = rolling.current();
    assertTrue(current.isSuccess());
    assertEquals("1.txt", current.getData().getName());
    assertEquals(2, rolling.currentIdIncrementAndGet().getData().longValue());
    assertEquals(2, rolling.currentId());
    current = rolling.current();
    assertTrue(current.isSuccess());
    assertEquals("2.txt", current.getData().getName());
    DataResultSupport<File> next = rolling.next();
    assertTrue(next.isSuccess());
    assertEquals("3.txt", next.getData().getName());
    next = rolling.next();
    assertTrue(next.isSuccess());
    assertEquals("4.txt", next.getData().getName());
    rolling.withRange(1, 3);
    assertEquals(1, rolling.currentId());
    current = rolling.current();
    assertTrue(current.isSuccess());
    assertEquals("1.txt", current.getData().getName());
    next = rolling.next();
    assertTrue(next.isSuccess());
    assertEquals("2.txt", next.getData().getName());
    next = rolling.next();
    assertTrue(next.isSuccess());
    assertEquals("3.txt", next.getData().getName());
    next = rolling.next();
    assertTrue(next.isSuccess());
    assertEquals("1.txt", next.getData().getName());
    next = rolling.next();
    assertTrue(next.isSuccess());
    assertEquals("2.txt", next.getData().getName());
    next = rolling.next();
    assertTrue(next.isSuccess());
    assertEquals("3.txt", next.getData().getName());
    FileUtils.deleteQuietly(dir);
    rolling.onStart();
    rolling.currentId(0);
    next = rolling.next();
    assertTrue(next.isSuccess());
    assertEquals("1.txt", next.getData().getName());
    FileUtils.writeStringToFile(next.getData(), rolling.currentId() + "", "UTF-8");
    next = rolling.next();
    assertTrue(next.isSuccess());
    assertEquals("2.txt", next.getData().getName());
    FileUtils.writeStringToFile(next.getData(), rolling.currentId() + "", "UTF-8");
    next = rolling.next();
    assertTrue(next.isSuccess());
    assertEquals("3.txt", next.getData().getName());
    FileUtils.writeStringToFile(next.getData(), rolling.currentId() + "", "UTF-8");
    DataResultSupport<List<File>> files = rolling.files();
    assertTrue(files.isSuccess());
    assertEquals(3, files.getData().size());
    LoggerSupport.info("files:{}", files);
  }

  /**
   * Test on resolve file.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Test
  public void testOnResolveFile() throws IOException {
    RollingFileSupport rolling = new RollingFileSupport();
    File dir = new File("target/rolling/logs");
    rolling.withDir(dir);
    rolling.withBaseName("log");
    rolling.withFileExt(".txt");
    ResultSupport start = rolling.onStart();
    assertTrue(start.isSuccess());
    assertEquals("log.1.txt", rolling.onResolveFileName(".txt"));
    assertEquals("log.1.zip", rolling.onResolveFileName(".zip"));
    DataResultSupport<File> next = rolling.next();
    assertTrue(next.isSuccess());
    assertEquals("log.2.txt", next.getData().getName());
    assertEquals("log.2.txt", rolling.onResolveFileName(".txt"));
    assertEquals("log.2.zip", rolling.onResolveFileName(".zip"));
  }
}
