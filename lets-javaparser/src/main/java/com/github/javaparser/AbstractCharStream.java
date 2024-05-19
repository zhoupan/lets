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
public abstract class AbstractCharStream implements CharStream {
  /** Default buffer size if nothing is specified */
  public static final int DEFAULT_BUF_SIZE = 4096;

  static final int hexval(final char c) throws java.io.IOException {
    switch (c) {
      case '0':
        return 0;
      case '1':
        return 1;
      case '2':
        return 2;
      case '3':
        return 3;
      case '4':
        return 4;
      case '5':
        return 5;
      case '6':
        return 6;
      case '7':
        return 7;
      case '8':
        return 8;
      case '9':
        return 9;
      case 'a':
      case 'A':
        return 10;
      case 'b':
      case 'B':
        return 11;
      case 'c':
      case 'C':
        return 12;
      case 'd':
      case 'D':
        return 13;
      case 'e':
      case 'E':
        return 14;
      case 'f':
      case 'F':
        return 15;
      default:
        throw new java.io.IOException("Invalid hex char '" + c + "' (=" + (int) c + ") provided!");
    }
  }

  /** Tab size for formatting. Usually in the range 1 to 8. */
  private int m_nTabSize = 1;

  /** Internal circular buffer */
  protected char[] buffer;

  /** Overall buffer size - same as buffer.length */
  protected int bufsize;

  /** Current read position in buffer. */
  protected int bufpos;

  /** The number of unoccupied buffer array positions */
  protected int available;

  /** The first array index (of `buffer`) that the current token starts */
  protected int tokenBegin;

  /** Characters in the backup/pushBack buffer */
  protected int inBuf;

  protected int maxNextCharInd;

  private int[] m_aBufLine;
  private int[] m_aBufColumn;

  // Current line number
  private int m_nLineNo;
  // Current column number
  private int m_nColumnNo;

  // Was the previous character a "\r" char?
  private boolean m_bPrevCharIsCR;
  // Was the previous character a "\n" char?
  private boolean m_bPrevCharIsLF;

  // Is line/column tracking enabled?
  private boolean m_bTrackLineColumn = true;

  /** Constructor. */
  public AbstractCharStream(final int nStartLine, final int nStartColumn, final int nBufferSize) {
    reInit(nStartLine, nStartColumn, nBufferSize);
  }

  /** Reinitialise. */
  public final void reInit(final int nStartLine, final int nStartColumn, final int nBufferSize) {
    m_nLineNo = nStartLine;
    m_nColumnNo = nStartColumn - 1;
    m_bPrevCharIsCR = false;
    m_bPrevCharIsLF = false;
    if (buffer == null || nBufferSize != buffer.length) {
      bufsize = nBufferSize;
      available = nBufferSize;
      buffer = new char[nBufferSize];
      m_aBufLine = new int[nBufferSize];
      m_aBufColumn = new int[nBufferSize];
    }
    maxNextCharInd = 0;
    inBuf = 0;
    tokenBegin = 0;
    bufpos = -1;
  }

  /**
   * Read from the underlying stream.
   *
   * @param aBuf the buffer to be filled
   * @param nOfs The offset into the buffer. 0-based
   * @param nLen Number of chars to read.
   * @return Number of effective chars read, or -1 on error.
   */
  protected abstract int streamRead(char[] aBuf, int nOfs, int nLen) throws java.io.IOException;

  /**
   * Close the underlying stream.
   *
   * @throws java.io.IOException If closing fails.
   */
  protected abstract void streamClose() throws java.io.IOException;

  // Override this method if you need more aggressive buffer size expansion
  protected int getBufSizeAfterExpansion() {
    // Double the size by default
    return bufsize * 2;
  }

  protected void expandBuff(final boolean bWrapAround) {
    // Get the new buffer size
    final int nNewBufSize = getBufSizeAfterExpansion();

    final char[] newbuffer = new char[nNewBufSize];
    final int[] newbufline = new int[nNewBufSize];
    final int[] newbufcolumn = new int[nNewBufSize];

    // Number of chars to be preserved
    final int nPreservedChars = bufsize - tokenBegin;

    if (bWrapAround) {
      // Move from offset "tokenBegin" to offset 0
      // arraycopy(src, srcPos, dest, destPos, length)

      // copy the "tail end" to the "start" (index 0) of the new buffer array
      System.arraycopy(buffer, tokenBegin, newbuffer, 0, nPreservedChars);

      // copy the remaining "wrap around" content of the buffer from the start of the original
      // buffer (starting at srcPos index 0)
      System.arraycopy(buffer, 0, newbuffer, nPreservedChars, bufpos);

      // swap the new buffer in place of the old buffer
      buffer = newbuffer;

      System.arraycopy(m_aBufLine, tokenBegin, newbufline, 0, nPreservedChars);
      System.arraycopy(m_aBufLine, 0, newbufline, nPreservedChars, bufpos);
      m_aBufLine = newbufline;

      System.arraycopy(m_aBufColumn, tokenBegin, newbufcolumn, 0, nPreservedChars);
      System.arraycopy(m_aBufColumn, 0, newbufcolumn, nPreservedChars, bufpos);
      m_aBufColumn = newbufcolumn;

      bufpos += nPreservedChars;
      maxNextCharInd = bufpos;
    } else {
      // Move from offset "tokenBegin" to offset 0

      System.arraycopy(buffer, tokenBegin, newbuffer, 0, nPreservedChars);
      buffer = newbuffer;

      System.arraycopy(m_aBufLine, tokenBegin, newbufline, 0, nPreservedChars);
      m_aBufLine = newbufline;

      System.arraycopy(m_aBufColumn, tokenBegin, newbufcolumn, 0, nPreservedChars);
      m_aBufColumn = newbufcolumn;

      bufpos -= tokenBegin;
      maxNextCharInd = bufpos;
    }

    // Increase buffer size
    bufsize = nNewBufSize;
    available = nNewBufSize;
    tokenBegin = 0;
  }

  protected final void internalAdjustBuffSize() {
    final int nHalfBufferSize = bufsize / 2;
    if (available == bufsize) {
      if (tokenBegin < 0) {
        // If this method is called from "beginToken()"
        // Just refill the buffer from the start
        bufpos = 0;
        maxNextCharInd = 0;
      } else if (tokenBegin > nHalfBufferSize) {
        // The token started in the second half - fill the front part
        bufpos = 0;
        maxNextCharInd = 0;

        // Available bytes are > 50%
        available = tokenBegin;
      } else {
        // Token starts in the first half
        // just append to existing buffer
        expandBuff(false);
      }
    } else {
      // A token was read across array boundaries
      if (available > tokenBegin) {
        available = bufsize;
      } else if ((tokenBegin - available) < nHalfBufferSize) {
        expandBuff(true);
      } else {
        available = tokenBegin;
      }
    }
  }

  protected void fillBuff() throws java.io.IOException {
    if (maxNextCharInd == available) internalAdjustBuffSize();

    try {
      // Read from underlying stream
      final int nCharsRead = streamRead(buffer, maxNextCharInd, available - maxNextCharInd);
      if (nCharsRead == -1) {
        // We reached the end of the file
        streamClose();

        // Caught down below and re-thrown
        throw new java.io.IOException("PGCC end of stream");
      }
      maxNextCharInd += nCharsRead;
    } catch (final java.io.IOException ex) {
      --bufpos;
      // ?What is the reason of this? Backup of 0 does nothing
      backup(0);
      if (tokenBegin == -1) {
        // Error occurred in "beginToken()"
        tokenBegin = bufpos;
      }
      throw ex;
    }
  }

  protected final void internalSetBufLineColumn(final int nLine, final int nColumn) {
    m_aBufLine[bufpos] = nLine;
    m_aBufColumn[bufpos] = nColumn;
  }

  protected final void internalUpdateLineColumn(final char c) {
    m_nColumnNo++;

    if (m_bPrevCharIsLF) {
      // It's a "\r\n" or "\n"
      // Start of a new line
      m_bPrevCharIsLF = false;
      m_nColumnNo = 1;
      m_nLineNo++;
    } else if (m_bPrevCharIsCR) {
      m_bPrevCharIsCR = false;
      if (c == '\n') {
        // It's a "\r\n"
        m_bPrevCharIsLF = true;
      } else {
        // It's only a "\r"
        m_nColumnNo = 1;
        m_nLineNo++;
      }
    }

    switch (c) {
      case '\r':
        m_bPrevCharIsCR = true;
        break;
      case '\n':
        m_bPrevCharIsLF = true;
        break;
      case '\t':
        m_nColumnNo--;
        m_nColumnNo += (m_nTabSize - (m_nColumnNo % m_nTabSize));
        break;
    }

    internalSetBufLineColumn(m_nLineNo, m_nColumnNo);
  }

  public char readChar() throws java.io.IOException {
    if (inBuf > 0) {
      // Something is left from last backup
      --inBuf;

      ++bufpos;
      if (bufpos == bufsize) {
        // Buffer overflow
        bufpos = 0;
      }

      return buffer[bufpos];
    }

    ++bufpos;
    if (bufpos >= maxNextCharInd) fillBuff();

    final char c = buffer[bufpos];

    if (m_bTrackLineColumn) internalUpdateLineColumn(c);
    return c;
  }

  public char beginToken() throws java.io.IOException {
    tokenBegin = -1;
    final char c = readChar();
    tokenBegin = bufpos;
    return c;
  }

  public int getBeginColumn() {
    return m_aBufColumn[tokenBegin];
  }

  public int getBeginLine() {
    return m_aBufLine[tokenBegin];
  }

  public int getEndColumn() {
    return m_aBufColumn[bufpos];
  }

  public int getEndLine() {
    return m_aBufLine[bufpos];
  }

  public void backup(final int nAmount) {
    if (nAmount > bufsize)
      throw new IllegalStateException(
          "Cannot back "
              + nAmount
              + " chars which is larger than the internal buffer size ("
              + bufsize
              + ")");

    inBuf += nAmount;
    bufpos -= nAmount;
    if (bufpos < 0) {
      // Buffer underflow (modulo)
      bufpos += bufsize;
    }
  }

  public String getImage() {
    if (bufpos >= tokenBegin) {
      // from tokenBegin to bufpos
      return new String(buffer, tokenBegin, bufpos - tokenBegin + 1);
    }

    // from tokenBegin to bufsize, and from 0 to bufpos
    return new String(buffer, tokenBegin, bufsize - tokenBegin) + new String(buffer, 0, bufpos + 1);
  }

  public char[] getSuffix(final int len) {
    char[] ret = new char[len];
    if ((bufpos + 1) >= len) {
      // one piece
      System.arraycopy(buffer, bufpos - len + 1, ret, 0, len);
    } else {
      // Wrap around
      final int nPart1 = len - bufpos - 1;
      System.arraycopy(buffer, bufsize - nPart1, ret, 0, nPart1);
      System.arraycopy(buffer, 0, ret, nPart1, bufpos + 1);
    }
    return ret;
  }

  public void done() {
    buffer = null;
    m_aBufLine = null;
    m_aBufColumn = null;
  }

  public final int getTabSize() {
    return m_nTabSize;
  }

  public final void setTabSize(final int nTabSize) {
    m_nTabSize = nTabSize;
  }

  /**
   * Method to adjust line and column numbers for the start of a token. This is used internally to
   */
  public final void adjustBeginLineColumn(final int nNewLine, final int newCol) {
    int start = tokenBegin;
    int newLine = nNewLine;

    int len;
    if (bufpos >= tokenBegin) {
      len = bufpos - tokenBegin + inBuf + 1;
    } else {
      len = bufsize - tokenBegin + bufpos + 1 + inBuf;
    }

    int i = 0;
    int j = 0;
    int k = 0;
    int nextColDiff = 0;
    int columnDiff = 0;

    // TODO disassemble meaning and split up
    while (i < len && m_aBufLine[j = start % bufsize] == m_aBufLine[k = ++start % bufsize]) {
      m_aBufLine[j] = newLine;
      nextColDiff = columnDiff + m_aBufColumn[k] - m_aBufColumn[j];
      m_aBufColumn[j] = newCol + columnDiff;
      columnDiff = nextColDiff;
      i++;
    }

    if (i < len) {
      m_aBufLine[j] = newLine++;
      m_aBufColumn[j] = newCol + columnDiff;

      while (i++ < len) {
        // TODO disassemble meaning and split up
        if (m_aBufLine[j = start % bufsize] != m_aBufLine[++start % bufsize])
          m_aBufLine[j] = newLine++;
        else m_aBufLine[j] = newLine;
      }
    }

    m_nLineNo = m_aBufLine[j];
    m_nColumnNo = m_aBufColumn[j];
  }

  /**
   * @return the current line number. 0-based.
   */
  protected final int getLine() {
    return m_nLineNo;
  }

  /**
   * @return the current column number. 0-based.
   */
  protected final int getColumn() {
    return m_nColumnNo;
  }

  public final boolean isTrackLineColumn() {
    return m_bTrackLineColumn;
  }

  public final void setTrackLineColumn(final boolean bTrackLineColumn) {
    m_bTrackLineColumn = bTrackLineColumn;
  }
}
/* ParserGeneratorCC - OriginalChecksum=dda55bea450209d44ed1c1b42fa41824 (do not edit this line) */
