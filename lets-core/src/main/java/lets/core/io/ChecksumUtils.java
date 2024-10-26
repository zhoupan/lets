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
package lets.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;
import lets.core.io.output.NullOutputStream;

public class ChecksumUtils {

  /**
   * long csum = ChecksumUtils.checksum(file, new CRC32()).getValue();
   *
   * @param inputStream
   * @param checksum
   * @return
   * @throws IOException
   */
  public static Checksum checksum(final InputStream inputStream, final Checksum checksum)
      throws IOException {
    try (InputStream in = new CheckedInputStream(inputStream, checksum)) {
      IOUtils.copy(in, new NullOutputStream());
    }
    return checksum;
  }
}
