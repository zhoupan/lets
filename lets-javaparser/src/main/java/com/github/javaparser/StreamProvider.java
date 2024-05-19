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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * NOTE : This generated class can be safely deleted if installing in a GWT installation (use
 * StringProvider instead)
 */
public class StreamProvider implements Provider {
  private Reader m_aReader;

  @Deprecated
  public StreamProvider(final InputStream stream, final String charsetName) throws IOException {
    this(new BufferedReader(new InputStreamReader(stream, charsetName)));
  }

  public StreamProvider(final InputStream stream, final java.nio.charset.Charset charset) {
    this(new BufferedReader(new InputStreamReader(stream, charset)));
  }

  public StreamProvider(final Reader reader) {
    m_aReader = reader;
  }

  public int read(final char[] aDest, final int nOfs, final int nLen) throws IOException {
    int result = m_aReader.read(aDest, nOfs, nLen);

    /* CBA -- Added 2014/03/29 --
       This logic allows the generated Java code to be easily translated to C# (via sharpen) -
       as in C# 0 represents end of file, and in Java, -1 represents end of file
       See : http://msdn.microsoft.com/en-us/library/9kstw824(v=vs.110).aspx
       ** Technically, this is not required for java but the overhead is extremely low compared to the code generation benefits.
    */
    if (result == 0) if (nOfs < aDest.length && nLen > 0) result = -1;

    return result;
  }

  public void close() throws IOException {
    if (m_aReader != null) m_aReader.close();
  }
}
/* ParserGeneratorCC - OriginalChecksum=3c8c8ca6c4294f1717fc87c9afb6995a (do not edit this line) */
