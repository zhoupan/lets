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

import java.util.Date;

/** The Class VersionCheckOutput. */
public class VersionCheckOutput implements java.io.Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The version. */
  private String version;

  /** The comment. */
  private String comment;

  /** The at. */
  private Date at;

  /** The file. */
  private DownloadFile file;

  /** The url. */
  private String url;

  /**
   * Gets the version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Sets the version.
   *
   * @param version the new version
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * Gets the comment.
   *
   * @return the comment
   */
  public String getComment() {
    return comment;
  }

  /**
   * Sets the comment.
   *
   * @param comment the new comment
   */
  public void setComment(String comment) {
    this.comment = comment;
  }

  /**
   * Gets the at.
   *
   * @return the at
   */
  public Date getAt() {
    return at;
  }

  /**
   * Sets the at.
   *
   * @param at the new at
   */
  public void setAt(Date at) {
    this.at = at;
  }

  /**
   * Gets the file.
   *
   * @return the file
   */
  public DownloadFile getFile() {
    return file;
  }

  /**
   * Sets the file.
   *
   * @param file the new file
   */
  public void setFile(DownloadFile file) {
    this.file = file;
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
   * Hash code.
   *
   * @return the int
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((version == null) ? 0 : version.hashCode());
    return result;
  }

  /**
   * Equals.
   *
   * @param obj the obj
   * @return true, if successful
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    VersionCheckOutput other = (VersionCheckOutput) obj;
    if (version == null) {
      if (other.version != null) {
        return false;
      }
    } else if (!version.equals(other.version)) {
      return false;
    }
    return true;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "VersionCheckOutput [version="
        + version
        + ", comment="
        + comment
        + ", at="
        + at
        + ", file="
        + file
        + ", url="
        + url
        + "]";
  }
}
