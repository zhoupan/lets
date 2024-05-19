/*
 * Copyright (c) 2013-2024 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.symbolsolver.utils;

import com.github.javaparser.utils.Utils;
import java.io.File;

public class FileUtils {

  /*
   * returns true if the filename exists otherwise return false
   */
  public static boolean isValidPath(String filename) {
    File file = new File(filename);
    return file.exists();
  }

  /*
   * returns the parent path from the filename as string
   */
  public static String getParentPath(String filename) {
    Utils.assertNotNull(filename);
    int lastIndex = filename.lastIndexOf(File.separator);
    return filename.substring(0, lastIndex);
  }
}
