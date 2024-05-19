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

public class StringProvider implements Provider {
  private String m_sStr;
  private int m_nPos = 0;
  private final int m_nLen;

  public StringProvider(final String sStr) {
    m_sStr = sStr;
    m_nLen = sStr.length();
  }

  public int read(final char[] aDest, final int nOfs, final int nLen) throws IOException {
    final int nLeft = m_nLen - m_nPos;
    if (nLeft <= 0) return -1;

    int nCharsRead = aDest.length - nOfs;
    if (nLen < nCharsRead) nCharsRead = nLen;
    if (nLeft < nCharsRead) nCharsRead = nLeft;

    m_sStr.getChars(m_nPos, m_nPos + nCharsRead, aDest, nOfs);
    m_nPos += nCharsRead;

    return nCharsRead;
  }

  public void close() {
    m_sStr = null;
  }
}
/* ParserGeneratorCC - OriginalChecksum=cb5e458568979f0fea5c8076233a429b (do not edit this line) */
