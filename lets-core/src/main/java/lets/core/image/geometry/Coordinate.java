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

import java.awt.Point;

/**
 * This class calculates the position of an image which is to be enclosed, using an absolute
 * coordinate at which the image should be located.
 *
 * @author coobird
 */
public final class Coordinate implements Position {
  /** The horizontal position of the image to be enclosed. */
  private final int x;

  /** The vertical position of the image to be enclosed. */
  private final int y;

  /**
   * Instantiates an object which calculates the position of an image, using the given coordinates.
   *
   * @param x The horizontal component of the top-left corner of the image to be enclosed.
   * @param y The vertical component of the top-left corner of the image to be enclosed.
   */
  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Point calculate(
      int enclosingWidth,
      int enclosingHeight,
      int width,
      int height,
      int insetLeft,
      int insetRight,
      int insetTop,
      int insetBottom) {
    int x = this.x + insetLeft;
    int y = this.y + insetTop;

    return new Point(x, y);
  }
}
