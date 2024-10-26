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
package lets.core.file;

import java.io.File;
import java.util.List;
import lets.core.DataResultSupport;
import lets.core.ResultSupport;

/** FileBackupSupport. */
public interface FileBackupSupport {

  /**
   * Backup to dir.
   *
   * @param targetDir the target dir
   * @return the result support
   */
  DataResultSupport<List<File>> backupToDir(File targetDir);

  /**
   * Backup to dirs.
   *
   * @param targetDirs the target dirs
   * @return the result support
   */
  ResultSupport backupToDirs(File... targetDirs);
}
