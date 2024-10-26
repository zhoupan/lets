/*
 * Copyright (c) 2022 zhoupan (https://github.com/zhoupan).
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
package lets.core.image.tasks;

import java.io.IOException;

/**
 * An exception used to indicate that the specified format could not be used in an operation.
 *
 * @author coobird
 */
public class UnsupportedFormatException extends IOException {
  /** An ID used for serialization. */
  private static final long serialVersionUID = 1254432584303852552L;

  /** The format name which was not supported. */
  private final String formatName;

  /** A constant which is used to indicate an unknown format. */
  public static final String UNKNOWN = "<unknown>";

  /**
   * Instantiates a {@link UnsupportedFormatException} with the unsupported format.
   *
   * @param formatName Format name.
   */
  public UnsupportedFormatException(String formatName) {
    super();
    this.formatName = formatName;
  }

  /**
   * Instantiates a {@link UnsupportedFormatException} with the unsupported format and a detailed
   * message.
   *
   * @param formatName Format name.
   * @param s A message detailing the exception.
   */
  public UnsupportedFormatException(String formatName, String s) {
    super(s);
    this.formatName = formatName;
  }

  /**
   * Returns the format name which is not supported.
   *
   * @return Format name.
   */
  public String getFormatName() {
    return formatName;
  }
}
