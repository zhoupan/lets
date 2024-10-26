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
 * This interface is implemented by classes which calculate how to position an object inside of an
 * enclosing object.
 *
 * @author coobird
 */
public interface Position {
  /**
   * Calculates the position of an object enclosed by an enclosing object.
   *
   * @param enclosingWidth The width of the enclosing object that is to contain the enclosed object.
   * @param enclosingHeight The height of the enclosing object that is to contain the enclosed
   *     object.
   * @param width The width of the object that is to be placed inside an enclosing object.
   * @param height The height of the object that is to be placed inside an enclosing object.
   * @param insetLeft The inset on the left-hand side of the object to be enclosed.
   * @param insetRight The inset on the right-hand side of the object to be enclosed.
   * @param insetTop The inset on the top side of the object to be enclosed.
   * @param insetBottom The inset on the bottom side of the object to be enclosed.
   * @return The position to place the object.
   */
  public Point calculate(
      int enclosingWidth,
      int enclosingHeight,
      int width,
      int height,
      int insetLeft,
      int insetRight,
      int insetTop,
      int insetBottom);
}
