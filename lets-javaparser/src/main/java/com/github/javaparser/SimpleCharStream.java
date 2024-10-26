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

/**
 * An implementation of interface CharStream, where the stream is assumed to contain only ASCII
 * characters (without unicode processing).
 */
public class SimpleCharStream extends AbstractCharStream {

  private Provider inputStream;

  @Override
  protected int streamRead(final char[] aBuf, final int nOfs, final int nLen)
      throws java.io.IOException {
    return inputStream.read(aBuf, nOfs, nLen);
  }

  @Override
  protected void streamClose() throws java.io.IOException {
    inputStream.close();
  }

  /** Constructor. */
  public SimpleCharStream(
      final Provider dstream, final int startline, final int startcolumn, final int buffersize) {
    super(startline, startcolumn, buffersize);
    inputStream = dstream;
  }

  /** Constructor. */
  public SimpleCharStream(final Provider dstream, final int startline, final int startcolumn) {
    this(dstream, startline, startcolumn, DEFAULT_BUF_SIZE);
  }

  /** Constructor. */
  public SimpleCharStream(final Provider dstream) {
    this(dstream, 1, 1, DEFAULT_BUF_SIZE);
  }

  /** Reinitialise. */
  public void reInit(
      final Provider dstream, final int startline, final int startcolumn, final int buffersize) {
    inputStream = dstream;
    super.reInit(startline, startcolumn, buffersize);
  }

  /** Reinitialise. */
  public void reInit(final Provider dstream, final int startline, final int startcolumn) {
    reInit(dstream, startline, startcolumn, DEFAULT_BUF_SIZE);
  }

  /** Reinitialise. */
  public void reInit(final Provider dstream) {
    reInit(dstream, 1, 1, DEFAULT_BUF_SIZE);
  }
}
/* ParserGeneratorCC - OriginalChecksum=fef927740b55b4849bacd21ff4655dde (do not edit this line) */
