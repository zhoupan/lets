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
package lets.core.app.model;

/** DownloadFile. */
public class DownloadFile {

  /** The filename. */
  private String filename;

  /** The size. */
  private long size;

  /** The crc 32. */
  private String crc32;

  /** The url. */
  private String url;

  /**
   * Gets the filename.
   *
   * @return the filename
   */
  public String getFilename() {
    return filename;
  }

  /**
   * Sets the filename.
   *
   * @param filename the new filename
   */
  public void setFilename(String filename) {
    this.filename = filename;
  }

  /**
   * Gets the size.
   *
   * @return the size
   */
  public long getSize() {
    return size;
  }

  /**
   * Sets the size.
   *
   * @param size the new size
   */
  public void setSize(long size) {
    this.size = size;
  }

  /**
   * Gets the crc 32.
   *
   * @return the crc 32
   */
  public String getCrc32() {
    return crc32;
  }

  /**
   * Sets the crc 32.
   *
   * @param crc32 the new crc 32
   */
  public void setCrc32(String crc32) {
    this.crc32 = crc32;
  }

  /**
   * Gets the url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the url.
   *
   * @param url the new url
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "DownloadFile [filename="
        + filename
        + ", size="
        + size
        + ", crc32="
        + crc32
        + ", url="
        + url
        + "]";
  }
}
