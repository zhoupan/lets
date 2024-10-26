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
package lets.core.image.resizers;

import java.awt.image.BufferedImage;

/**
 * This enum can be used to select a specific {@link Resizer} in order to perform a resizing
 * operation.
 *
 * <p>The instance held by a value of this enum is a single instance. When using specific
 * implementations of {@link Resizer}s, it is preferable to obtain an instance of a {@link Resizer}
 * through this enum or the {@link DefaultResizerFactory} class in order to prevent many instances
 * of the {@link Resizer} class implementations from being instantiated.
 *
 * <p>
 *
 * <DL>
 *   <DT><B>Usage:</B>
 *   <DD>The following example code demonstrates how to use the {@link Resizers} enum in order to
 *       resize an image using bilinear interpolation:
 *       <p>
 *       <pre>
 * BufferedImage sourceImage = new BufferedImageBuilder(400, 400).build();
 * BufferedImage destImage = new BufferedImageBuilder(200, 200).build();
 *
 * Resizers.BILINEAR.resize(sourceImage, destImage);
 * </pre>
 * </DL>
 *
 * @see DefaultResizerFactory
 * @author coobird
 */
public enum Resizers implements Resizer {
  /**
   * A {@link Resizer} which does not perform resizing operations. The source image will be drawn at
   * the origin of the destination image.
   */
  NULL(new NullResizer()),

  /** A {@link Resizer} which performs resizing operations using bilinear interpolation. */
  BILINEAR(new BilinearResizer()),

  /** A {@link Resizer} which performs resizing operations using bicubic interpolation. */
  BICUBIC(new BicubicResizer()),

  /**
   * A {@link Resizer} which performs resizing operations using progressive bilinear scaling.
   *
   * <p>For details on this technique, refer to the documentation of the {@link
   * ProgressiveBilinearResizer} class.
   */
  PROGRESSIVE(new ProgressiveBilinearResizer());

  private final Resizer resizer;

  private Resizers(Resizer resizer) {
    this.resizer = resizer;
  }

  public void resize(BufferedImage srcImage, BufferedImage destImage) {
    resizer.resize(srcImage, destImage);
  }
}
