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
 * A {@link ImageMaker} which resizes an image to a specified dimension when producing a thumbnail.
 *
 * <p>Optionally, if the aspect ratio of the thumbnail is to be maintained the same as the original
 * image (by calling the {@link #keepAspectRatio(boolean)} method with the value {@code true}), then
 * the dimensions specified by the {@link #size(int, int)} method, {@link #FixedSizeImageMaker(int,
 * int)} or {@link #FixedSizeImageMaker(int, int, boolean)} constructor will be used as the maximum
 * constraint of dimensions of the thumbnail.
 *
 * <p>In other words, when the aspect ratio is to be kept constant, then thumbnails which are
 * created will be sized to fit inside the dimensions specified by the size parameter.
 *
 * <p>Upon calculating the size of the thumbnail, if any of the dimensions are {@code 0}, then that
 * dimension will be promoted to {@code 1}, regardless of whether the aspect ratio of the original
 * image is to be maintained. This will lead to some thumbnails not preserving the aspect ratio of
 * the original image, even if {@link #keepAspectRatio(boolean)} has been {@code true}.
 *
 * <p>
 *
 * <DL>
 *   <DT><B>Usage:</B>
 *   <DD>The following example demonstrates how to create a thumbnail which fits within 200 pixels
 *       by 200 pixels, while preserving the aspect ratio of the source image:
 *       <pre>
 * BufferedImage img = ImageIO.read(new File("sourceImage.jpg"));
 *
 * BufferedImage thumbnail = new FixedSizeImageMaker().size(200, 200).keepAspectRatio(true).make(img);
 * </pre>
 * </DL>
 *
 * @author coobird
 */
public final class FixedSizeImageMaker extends ImageMaker {
  private static final String PARAM_SIZE = "size";
  private static final String PARAM_KEEP_RATIO = "keepRatio";
  private static final String PARAM_FIT_WITHIN = "fitWithinDimensions";

  private int width;
  private int height;
  private boolean keepRatio;
  private boolean fitWithinDimensions;

  /**
   * Creates a {@link FixedSizeImageMaker}.
   *
   * <p>The size of the resulting thumbnail, and whether or not the aspect ratio of the original
   * image should be maintained in the thumbnail must be set before this instance is able to produce
   * thumbnails.
   */
  public FixedSizeImageMaker() {
    super();
    ready.unset(PARAM_SIZE);
    ready.unset(PARAM_KEEP_RATIO);
    ready.unset(PARAM_FIT_WITHIN);
  }

  /**
   * Creates a {@link FixedSizeImageMaker} which creates thumbnails with the specified size.
   *
   * <p>Before this instance is able to produce thumbnails, whether or not the aspect ratio of the
   * original image should be maintained in the thumbnail must be specified by calling the {@link
   * #keepAspectRatio(boolean)} method.
   *
   * @param width The width of the thumbnail to produce.
   * @param height The height of the thumbnails to produce.
   */
  public FixedSizeImageMaker(int width, int height) {
    this();
    size(width, height);
  }

  /**
   * Creates a {@link FixedSizeImageMaker} which creates thumbnails with the specified size. Whether
   * or not the aspect ratio of the original image should be preserved by the thumbnail is also
   * specified at instantiation.
   *
   * @param width The width of the thumbnail to produce.
   * @param height The height of the thumbnails to produce.
   * @param aspectRatio Whether or not to maintain the aspect ratio in the thumbnail the same as the
   *     original image.
   *     <p>If {@code true} is specified, then the thumbnail image will have the same aspect ratio
   *     as the original image.
   */
  public FixedSizeImageMaker(int width, int height, boolean aspectRatio) {
    this();
    size(width, height);
    keepAspectRatio(aspectRatio);
  }

  /**
   * Creates a {@link FixedSizeImageMaker} which creates thumbnails with the specified size. Whether
   * or not the aspect ratio of the original image should be preserved by the thumbnail, and whether
   * to fit the thumbnail within the given dimensions is also specified at instantiation.
   *
   * @param width The width of the thumbnail to produce.
   * @param height The height of the thumbnails to produce.
   * @param aspectRatio Whether or not to maintain the aspect ratio in the thumbnail the same as the
   *     original image.
   *     <p>If {@code true} is specified, then the thumbnail image will have the same aspect ratio
   *     as the original image.
   * @param fit Whether or not to fit the thumbnail within the specified dimensions.
   *     <p>If {@code true} is specified, then the thumbnail will be sized to fit within the
   *     specified {@code width} and {@code height}.
   */
  public FixedSizeImageMaker(int width, int height, boolean aspectRatio, boolean fit) {
    this();
    size(width, height);
    keepAspectRatio(aspectRatio);
    fitWithinDimensions(fit);
  }

  /**
   * Sets the size of the thumbnail to produce.
   *
   * @param width The width of the thumbnail to produce.
   * @param height The height of the thumbnails to produce.
   * @return A reference to this object.
   * @throws IllegalStateException If the size has already been previously set, or if the {@code
   *     width} or {@code height} is less than or equal to zero.
   */
  public FixedSizeImageMaker size(int width, int height) {
    if (ready.isSet(PARAM_SIZE)) {
      throw new IllegalStateException("The size has already been set.");
    }

    if (width <= 0) {
      throw new IllegalArgumentException("Width must be greater than zero.");
    }
    if (height <= 0) {
      throw new IllegalArgumentException("Height must be greater than zero.");
    }

    this.width = width;
    this.height = height;

    ready.set(PARAM_SIZE);
    return this;
  }

  /**
   * Sets whether or not the thumbnail is to maintain the aspect ratio of the original image.
   *
   * @param keep Whether or not to maintain the aspect ratio in the thumbnail the same as the
   *     original image.
   *     <p>If {@code true} is specified, then the thumbnail image will have the same aspect ratio
   *     as the original image.
   * @return A reference to this object.
   * @throws IllegalStateException If whether to keep the aspect ratio has already been previously
   *     set.
   */
  public FixedSizeImageMaker keepAspectRatio(boolean keep) {
    if (ready.isSet(PARAM_KEEP_RATIO)) {
      throw new IllegalStateException("Whether to keep the aspect ratio has already been set.");
    }
    this.keepRatio = keep;

    ready.set(PARAM_KEEP_RATIO);
    return this;
  }

  /**
   * Sets whether or not the thumbnail should fit within the specified dimensions.
   *
   * <p>When the dimensions of a thumbnail will exceed the specified dimensions, with the aspect
   * ratio of the original being preserved, then if this method was called with {@code false}, then
   * the resulting thumbnail will have the larger dimension align with the specified dimension, and
   * the other will exceed the given dimension.
   *
   * <p>When {@link #keepAspectRatio(boolean)} is {@code false}, then calling this method with
   * {@code true} or {@code false} makes no difference, as the thumbnail dimensions will be exactly
   * the given dimensions.
   *
   * @param fit Whether or not to maintain the aspect ratio in the thumbnail the same as the
   *     original image.
   *     <p>If {@code true} is specified, then the thumbnail image will have the same aspect ratio
   *     as the original image.
   * @return A reference to this object.
   * @throws IllegalStateException If whether to keep the aspect ratio has already been previously
   *     set.
   * @since 0.4.0
   */
  public FixedSizeImageMaker fitWithinDimensions(boolean fit) {
    if (ready.isSet(PARAM_FIT_WITHIN)) {
      throw new IllegalStateException("Whether to fit within dimensions has already been set.");
    }
    this.fitWithinDimensions = fit;

    ready.set(PARAM_FIT_WITHIN);
    return this;
  }

  @Override
  public BufferedImage make(BufferedImage img) {
    int targetWidth = this.width;
    int targetHeight = this.height;

    if (keepRatio) {
      int sourceWidth = img.getWidth();
      int sourceHeight = img.getHeight();

      double sourceRatio = (double) sourceWidth / (double) sourceHeight;
      double targetRatio = (double) targetWidth / (double) targetHeight;

      /*
       * If the ratios are not the same, then the appropriate width and height must be picked.
       */
      if (Double.compare(sourceRatio, targetRatio) != 0) {
        if (fitWithinDimensions) {
          if (sourceRatio > targetRatio) {
            targetWidth = width;
            targetHeight = (int) Math.round(targetWidth / sourceRatio);
          } else {
            targetWidth = (int) Math.round(targetHeight * sourceRatio);
            targetHeight = height;
          }
        } else {
          if (sourceRatio > targetRatio) {
            targetWidth = (int) Math.round(targetHeight * sourceRatio);
            targetHeight = height;
          } else {
            targetWidth = width;
            targetHeight = (int) Math.round(targetWidth / sourceRatio);
          }
        }
      }
    }

    targetWidth = (targetWidth == 0) ? 1 : targetWidth;
    targetHeight = (targetHeight == 0) ? 1 : targetHeight;

    return super.makeImage(img, targetWidth, targetHeight);
  }
}
