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
package lets.core.image.makers;

import java.awt.image.BufferedImage;

/**
 * A {@link ImageMaker} which scales an image by a specified scaling factor when producing a
 * thumbnail.
 *
 * <p>Upon calculating the size of the thumbnail, if any of the dimensions are {@code 0}, then that
 * dimension will be promoted to {@code 1}. This will cause some resizing operations to not preserve
 * the aspect ratio of the original image.
 *
 * <p>
 *
 * <DL>
 *   <DT><B>Usage:</B>
 *   <DD>The following example demonstrates how to create a thumbnail which is 25% the size of the
 *       source image:
 *       <pre>
 * BufferedImage img = ImageIO.read(new File("sourceImage.jpg"));
 * BufferedImage thumbnail = new ScaledImageMaker().scale(0.25).make(img);
 * </pre>
 * </DL>
 *
 * It is also possible to independently specify the scaling factor for the width and height. (If the
 * two scaling factors are not equal then the aspect ratio of the original image will not be
 * preserved.)
 *
 * <p>
 *
 * <DL>
 *   <DT><B>Usage:</B>
 *   <DD>The following example demonstrates how to create a thumbnail which is scaled 50% in the
 *       width and 75% in the height:
 *       <pre>
 * BufferedImage img = ImageIO.read(new File("sourceImage.jpg"));
 * BufferedImage thumbnail = new ScaledImageMaker().scale(0.50, 0.75).make(img);
 * </pre>
 * </DL>
 *
 * <DL>
 *
 * @author coobird
 */
public final class ScaledImageMaker extends ImageMaker {
  private static final String PARAM_SCALE = "scale";

  /** The scaling factor to apply to the width when resizing an image to create a thumbnail. */
  private double widthFactor;

  /** The scaling factor to apply to the height when resizing an image to create a thumbnail. */
  private double heightFactor;

  /**
   * Creates an instance of {@code ScaledImageMaker} without the scaling factor specified.
   *
   * <p>To use this {@code ScaledImageMaker}, one must specify the scaling factor to use by calling
   * the {@link #scale(double)} method before generating a thumbnail.
   */
  public ScaledImageMaker() {
    super();
    ready.unset(PARAM_SCALE);
  }

  /**
   * Creates an instance of {@code ScaledImageMaker} with the specified scaling factor.
   *
   * @param factor The scaling factor to apply when resizing an image to create a thumbnail.
   */
  public ScaledImageMaker(double factor) {
    this();
    scale(factor);
  }

  /**
   * Creates an instance of {@code ScaledImageMaker} with the specified scaling factors for the
   * width and height.
   *
   * @param widthFactor The scaling factor to apply to the width when resizing an image to create a
   *     thumbnail.
   * @param heightFactor The scaling factor to apply to the height when resizing an image to create
   *     a thumbnail.
   * @since 0.3.10
   */
  public ScaledImageMaker(double widthFactor, double heightFactor) {
    this();
    scale(widthFactor, heightFactor);
  }

  /**
   * Sets the scaling factor for the thumbnail.
   *
   * <p>The aspect ratio of the resulting image is unaltered from the original.
   *
   * @param factor The scaling factor to apply when resizing an image to create a thumbnail.
   * @return A reference to this object.
   * @throws IllegalStateException If the scaling factor has already been previously set.
   */
  public ScaledImageMaker scale(double factor) {
    return scale(factor, factor);
  }

  /**
   * Sets the scaling factors for the thumbnail.
   *
   * @param widthFactor The scaling factor to apply to the width when resizing an image to create a
   *     thumbnail.
   * @param heightFactor The scaling factor to apply to the height when resizing an image to create
   *     a thumbnail.
   * @return A reference to this object.
   * @throws IllegalStateException If the scaling factor has already been previously set.
   * @since 0.3.10
   */
  public ScaledImageMaker scale(double widthFactor, double heightFactor) {
    if (ready.isSet(PARAM_SCALE)) {
      throw new IllegalStateException("The scaling factor has already been set.");
    }

    if (widthFactor <= 0 || heightFactor <= 0) {
      throw new IllegalArgumentException("The scaling factor must be greater than zero.");
    }

    this.widthFactor = widthFactor;
    this.heightFactor = heightFactor;
    ready.set(PARAM_SCALE);
    return this;
  }

  @Override
  public BufferedImage make(BufferedImage img) {
    int width = (int) Math.round(img.getWidth() * widthFactor);
    int height = (int) Math.round(img.getHeight() * heightFactor);

    width = (width == 0) ? 1 : width;
    height = (height == 0) ? 1 : height;

    return super.makeImage(img, width, height);
  }
}
