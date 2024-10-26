/*
 * Copyright (c) 2007-2010 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser;

import java.io.IOException;

/** Abstract interface for reading from a stream. The buffering should be done internally. */
public interface Provider extends java.io.Closeable {

  /**
   * Reads characters into an array
   *
   * @param aDest Destination buffer. May not be <code>null</code>.
   * @param nOfs Offset at which to start storing characters. Must be &ge; 0.
   * @param nLen The maximum possible number of characters to read. Must be &ge; 0.
   * @return The number of characters read, or -1 at the end of the stream
   * @exception IOException if reading fails
   */
  int read(char[] aDest, int nOfs, int nLen) throws IOException;
}
/* ParserGeneratorCC - OriginalChecksum=8ad574022f17e4116136afaffdd938fc (do not edit this line) */
