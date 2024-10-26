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
package lets.core.image.geometry;

import java.awt.Dimension;

/**
 * A {@link Size} object which indicates that the size of the enclosed object should be the
 * specified absolute size.
 *
 * @author coobird
 * @since 0.3.4
 */
public class AbsoluteSize implements Size {
  /** The size of the object. */
  private final Dimension size;

  /**
   * Instantiates an object which indicates size of an object.
   *
   * @param size Size of the enclosed object.
   * @throws NullPointerException If the size is {@code null}.
   */
  public AbsoluteSize(Dimension size) {
    if (size == null) {
      throw new NullPointerException("Size cannot be null.");
    }
    this.size = new Dimension(size);
  }

  /**
   * Instantiates an object which indicates size of an object.
   *
   * @param width Width of the enclosed object.
   * @param height Height of the enclosed object.
   * @throws IllegalArgumentException If the width and/or height is less than or equal to {@code 0}.
   */
  public AbsoluteSize(int width, int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be greater than 0.");
    }
    this.size = new Dimension(width, height);
  }

  public Dimension calculate(int width, int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be greater than 0.");
    }
    return new Dimension(size);
  }

  /**
   * Returns a {@code String} representation of this object.
   *
   * @return {@code String} representation of this object.
   */
  @Override
  public String toString() {
    return "AbsoluteSize [width=" + size.width + ", height=" + size.height + "]";
  }
}
