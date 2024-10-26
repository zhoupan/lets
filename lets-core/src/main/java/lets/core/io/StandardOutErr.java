/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import lets.core.CoreUtils;

/** StandardOutErr. */
public class StandardOutErr implements AutoCloseable {

  /** The output stream. */
  private final ByteArrayOutputStream outStream;

  /** The err stream. */
  private final ByteArrayOutputStream errStream;

  /** The charset. */
  private final Charset charset;

  /** The output. */
  private String out = "";

  /** The err. */
  private String err = "";

  /**
   * Instantiates a new standard out err.
   *
   * @param out the out
   * @param err the err
   * @param charset the charset
   */
  public StandardOutErr(ByteArrayOutputStream out, ByteArrayOutputStream err, Charset charset) {
    super();
    this.outStream = out;
    this.errStream = err;
    this.charset = charset;
  }

  /** Instantiates a new standard out err. */
  public StandardOutErr() {
    this(new ByteArrayOutputStream(), new ByteArrayOutputStream(), StandardCharsets.UTF_8);
  }

  /**
   * Close.
   *
   * @throws Exception the exception
   */
  @Override
  public void close() throws Exception {
    CoreUtils.closeQuietlyAll(this.outStream, this.errStream);
  }

  /**
   * Flush.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public void flush() throws IOException {
    this.outStream.flush();
    this.out = new String(this.outStream.toByteArray(), this.charset);
    this.errStream.flush();
    this.err = new String(this.errStream.toByteArray(), this.charset);
  }

  /**
   * Gets the charset.
   *
   * @return the charset
   */
  public Charset getCharset() {
    return charset;
  }

  /**
   * Gets the out.
   *
   * @return the out
   */
  public String getOut() {
    return out;
  }

  /**
   * Sets the out.
   *
   * @param out the new out
   */
  public void setOut(String out) {
    this.out = out;
  }

  /**
   * Gets the err.
   *
   * @return the err
   */
  public String getErr() {
    return err;
  }

  /**
   * Sets the err.
   *
   * @param err the new err
   */
  public void setErr(String err) {
    this.err = err;
  }

  /**
   * Gets the out stream.
   *
   * @return the out stream
   */
  public ByteArrayOutputStream getOutStream() {
    return outStream;
  }

  /**
   * Gets the err stream.
   *
   * @return the err stream
   */
  public ByteArrayOutputStream getErrStream() {
    return errStream;
  }
}
