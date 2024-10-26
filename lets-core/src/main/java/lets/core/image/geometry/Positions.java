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
import lets.core.image.filters.Caption;
import lets.core.image.filters.ImageFilter;
import lets.core.image.filters.Watermark;

/**
 * An enum of predefined {@link Position}s.
 *
 * <p>Primary use of this enum is for selecting a position to place watermarks (using the {@link
 * Watermark} class), captions (using the {@link Caption} class) and other {@link ImageFilter}s.
 *
 * @author coobird
 */
public enum Positions implements Position {
  /**
   * Calculates the {@link Point} at which an enclosed image should be placed if it is to be placed
   * at the top left-hand corner of the enclosing image.
   */
  TOP_LEFT() {
    public Point calculate(
        int enclosingWidth,
        int enclosingHeight,
        int width,
        int height,
        int insetLeft,
        int insetRight,
        int insetTop,
        int insetBottom) {
      int x = insetLeft;
      int y = insetTop;
      return new Point(x, y);
    }
  },

  /**
   * Calculates the {@link Point} at which an enclosed image should be placed if it is to be
   * horizontally centered at the top of the enclosing image.
   */
  TOP_CENTER() {
    public Point calculate(
        int enclosingWidth,
        int enclosingHeight,
        int width,
        int height,
        int insetLeft,
        int insetRight,
        int insetTop,
        int insetBottom) {
      int x = (enclosingWidth / 2) - (width / 2);
      int y = insetTop;
      return new Point(x, y);
    }
  },

  /**
   * Calculates the {@link Point} at which an enclosed image should be placed if it is to be placed
   * at the top right-hand corner of the enclosing image.
   */
  TOP_RIGHT() {
    public Point calculate(
        int enclosingWidth,
        int enclosingHeight,
        int width,
        int height,
        int insetLeft,
        int insetRight,
        int insetTop,
        int insetBottom) {
      int x = enclosingWidth - width - insetRight;
      int y = insetTop;
      return new Point(x, y);
    }
  },

  /**
   * Calculates the {@link Point} at which an enclosed image should be placed if it is to be placed
   * vertically centered at the left-hand corner of the enclosing image.
   */
  CENTER_LEFT() {
    public Point calculate(
        int enclosingWidth,
        int enclosingHeight,
        int width,
        int height,
        int insetLeft,
        int insetRight,
        int insetTop,
        int insetBottom) {
      int x = insetLeft;
      int y = (enclosingHeight / 2) - (height / 2);
      return new Point(x, y);
    }
  },

  /**
   * Calculates the {@link Point} at which an enclosed image should be placed horizontally and
   * vertically centered in the enclosing image.
   */
  CENTER() {
    public Point calculate(
        int enclosingWidth,
        int enclosingHeight,
        int width,
        int height,
        int insetLeft,
        int insetRight,
        int insetTop,
        int insetBottom) {
      int x = (enclosingWidth / 2) - (width / 2);
      int y = (enclosingHeight / 2) - (height / 2);
      return new Point(x, y);
    }
  },

  /**
   * Calculates the {@link Point} at which an enclosed image should be placed if it is to be placed
   * vertically centered at the right-hand corner of the enclosing image.
   */
  CENTER_RIGHT() {
    public Point calculate(
        int enclosingWidth,
        int enclosingHeight,
        int width,
        int height,
        int insetLeft,
        int insetRight,
        int insetTop,
        int insetBottom) {
      int x = enclosingWidth - width - insetRight;
      int y = (enclosingHeight / 2) - (height / 2);
      return new Point(x, y);
    }
  },

  /**
   * Calculates the {@link Point} at which an enclosed image should be placed if it is to be placed
   * at the bottom left-hand corner of the enclosing image.
   */
  BOTTOM_LEFT() {
    public Point calculate(
        int enclosingWidth,
        int enclosingHeight,
        int width,
        int height,
        int insetLeft,
        int insetRight,
        int insetTop,
        int insetBottom) {
      int x = insetLeft;
      int y = enclosingHeight - height - insetBottom;
      return new Point(x, y);
    }
  },

  /**
   * Calculates the {@link Point} at which an enclosed image should be placed if it is to be
   * horizontally centered at the bottom of the enclosing image.
   */
  BOTTOM_CENTER() {
    public Point calculate(
        int enclosingWidth,
        int enclosingHeight,
        int width,
        int height,
        int insetLeft,
        int insetRight,
        int insetTop,
        int insetBottom) {
      int x = (enclosingWidth / 2) - (width / 2);
      int y = enclosingHeight - height - insetBottom;
      return new Point(x, y);
    }
  },

  /**
   * Calculates the {@link Point} at which an enclosed image should be placed if it is to be placed
   * at the bottom right-hand corner of the enclosing image.
   */
  BOTTOM_RIGHT() {
    public Point calculate(
        int enclosingWidth,
        int enclosingHeight,
        int width,
        int height,
        int insetLeft,
        int insetRight,
        int insetTop,
        int insetBottom) {
      int x = enclosingWidth - width - insetRight;
      int y = enclosingHeight - height - insetBottom;
      return new Point(x, y);
    }
  },
  ;
}
