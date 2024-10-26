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
package lets.core.image.builders;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.List;
import lets.core.image.ImageParameter;
import lets.core.image.filters.ImageFilter;
import lets.core.image.geometry.Region;
import lets.core.image.resizers.DefaultResizerFactory;
import lets.core.image.resizers.FixedResizerFactory;
import lets.core.image.resizers.Resizer;
import lets.core.image.resizers.ResizerFactory;

/**
 * A builder for generating {@link ImageParameter}.
 *
 * <p>The default values assigned to the {@link ImageParameter} created by the {@link
 * ImageParameterBuilder} are as follows:
 *
 * <p>
 *
 * <dl>
 *   <dt>width
 *   <dd>Unassigned. Must be set by the {@link #size(int, int)} method.
 *   <dt>height
 *   <dd>Unassigned. Must be set by the {@link #size(int, int)} method.
 *   <dt>scaling factor
 *   <dd>Unassigned. Must be set by the {@link #scale(double)} method or {@link #scale(double,
 *       double)} method.
 *   <dt>source region
 *   <dd>Uses the entire source image.
 *   <dt>image type
 *   <dd>See {@link ImageParameter#DEFAULT_IMAGE_TYPE}. Same as {@link BufferedImage#TYPE_INT_ARGB}.
 *   <dt>aspect ratio
 *   <dd>Maintain the aspect ratio of the original image.
 *   <dt>output quality
 *   <dd>See {@link ImageParameter#DEFAULT_QUALITY}.
 *   <dt>output format
 *   <dd>See {@link ImageParameter#ORIGINAL_FORMAT}. Maintains the same image format as the original
 *       image.
 *   <dt>output format type
 *   <dd>See {@link ImageParameter#DEFAULT_FORMAT_TYPE}. Uses the default format type of the codec
 *       used to create the thumbnail image.
 *   <dt>image filters
 *   <dd>None.
 *   <dt>resizer factory
 *   <dd>{@link DefaultResizerFactory} is used.
 *   <dt>resizer
 *   <dd>The default {@link Resizer} returned by the {@link ResizerFactory}.
 *   <dt>use of Exif metadata for orientation
 *   <dd>Use the Exif metadata to determine the orientation of the thumbnail.
 * </dl>
 *
 * @author coobird
 */
public final class ImageParameterBuilder {
  private static final int UNINITIALIZED = -1;

  private int width = UNINITIALIZED;
  private int height = UNINITIALIZED;
  private double widthScalingFactor = Double.NaN;
  private double heightScalingFactor = Double.NaN;
  private int imageType = ImageParameter.DEFAULT_IMAGE_TYPE;
  private boolean keepAspectRatio = true;
  private float thumbnailQuality = ImageParameter.DEFAULT_QUALITY;
  private String thumbnailFormat = ImageParameter.ORIGINAL_FORMAT;
  private String thumbnailFormatType = ImageParameter.DEFAULT_FORMAT_TYPE;
  private List<ImageFilter> filters = Collections.emptyList();
  private ResizerFactory resizerFactory = DefaultResizerFactory.getInstance();
  private Region sourceRegion = null;
  private boolean fitWithinDimensions = true;
  private boolean useExifOrientation = true;

  /** Creates an instance of a {@link ImageParameterBuilder}. */
  public ImageParameterBuilder() {}

  /**
   * Sets the image type fo the thumbnail.
   *
   * @param type The image type of the thumbnail.
   * @return A reference to this object.
   */
  public ImageParameterBuilder imageType(int type) {
    imageType = type;
    return this;
  }

  /**
   * Sets the size of the thumbnail.
   *
   * @param size The dimensions of the thumbnail.
   * @return A reference to this object.
   */
  public ImageParameterBuilder size(Dimension size) {
    size(size.width, size.height);
    return this;
  }

  /**
   * Sets the size of the thumbnail.
   *
   * @param width The width of the thumbnail.
   * @param height The height of the thumbnail.
   * @return A reference to this object.
   * @throws IllegalArgumentException If the widht or height is less than 0.
   */
  public ImageParameterBuilder size(int width, int height) {
    if (width < 0) {
      throw new IllegalArgumentException("Width must be greater than 0.");
    }
    if (height < 0) {
      throw new IllegalArgumentException("Height must be greater than 0.");
    }

    this.width = width;
    this.height = height;
    return this;
  }

  /**
   * Sets the scaling factor of the thumbnail.
   *
   * @param scalingFactor The scaling factor of the thumbnail.
   * @return A reference to this object.
   * @throws IllegalArgumentException If the scaling factor is not a rational number, or if it is
   *     less than {@code 0.0}.
   */
  public ImageParameterBuilder scale(double scalingFactor) {
    return scale(scalingFactor, scalingFactor);
  }

  /**
   * Sets the scaling factor of the thumbnail.
   *
   * @param widthScalingFactor The scaling factor to use for the width when creating the thumbnail.
   * @param heightScalingFactor The scaling factor to use for the height when creating the
   *     thumbnail.
   * @return A reference to this object.
   * @throws IllegalArgumentException If the scaling factor is not a rational number, or if it is
   *     less than {@code 0.0}.
   * @since 0.3.10
   */
  public ImageParameterBuilder scale(double widthScalingFactor, double heightScalingFactor) {
    if (widthScalingFactor <= 0.0 || heightScalingFactor <= 0.0) {
      throw new IllegalArgumentException("Scaling factor is less than or equal to 0.");
    } else if (Double.isNaN(widthScalingFactor) || Double.isInfinite(widthScalingFactor)) {
      throw new IllegalArgumentException("Scaling factor must be a rational number.");
    } else if (Double.isNaN(heightScalingFactor) || Double.isInfinite(heightScalingFactor)) {
      throw new IllegalArgumentException("Scaling factor must be a rational number.");
    }

    this.widthScalingFactor = widthScalingFactor;
    this.heightScalingFactor = heightScalingFactor;
    return this;
  }

  /**
   * Sets the region of the source image to use when creating a thumbnail.
   *
   * @param sourceRegion The region of the source image to use when creating a thumbnail.
   * @return A reference to this object.
   * @since 0.3.4
   */
  public ImageParameterBuilder region(Region sourceRegion) {
    this.sourceRegion = sourceRegion;
    return this;
  }

  /**
   * Sets whether or not the thumbnail is to maintain the aspect ratio of the original image.
   *
   * @param keep {@code true} if the aspect ratio of the original image is to be maintained in the
   *     thumbnail, {@code false} otherwise.
   * @return A reference to this object.
   */
  public ImageParameterBuilder keepAspectRatio(boolean keep) {
    this.keepAspectRatio = keep;
    return this;
  }

  /**
   * Sets the compression quality setting of the thumbnail.
   *
   * <p>An acceptable value is in the range of {@code 0.0f} to {@code 1.0f}, where {@code 0.0f} is
   * for the lowest quality setting and {@code 1.0f} for the highest quality setting.
   *
   * <p>If the default compression quality is to be used, then the value {@link
   * ImageParameter#DEFAULT_QUALITY} should be used.
   *
   * @param quality The compression quality setting of the thumbnail.
   * @return A reference to this object.
   */
  public ImageParameterBuilder quality(float quality) {
    this.thumbnailQuality = quality;
    return this;
  }

  /**
   * Sets the output format of the thumbnail.
   *
   * @param format The output format of the thumbnail.
   * @return A reference to this object.
   */
  public ImageParameterBuilder format(String format) {
    this.thumbnailFormat = format;
    return this;
  }

  /**
   * Sets the output format type of the thumbnail.
   *
   * @param formatType The output format type of the thumbnail.
   * @return A reference to this object.
   */
  public ImageParameterBuilder formatType(String formatType) {
    this.thumbnailFormatType = formatType;
    return this;
  }

  /**
   * Sets the {@link ImageFilter}s to apply to the thumbnail.
   *
   * <p>These filters will be applied after the original image is resized.
   *
   * @param filters The output format type of the thumbnail.
   * @return A reference to this object.
   */
  public ImageParameterBuilder filters(List<ImageFilter> filters) {
    if (filters == null) {
      throw new NullPointerException("Filters is null.");
    }

    this.filters = filters;
    return this;
  }

  /**
   * Sets the {@link Resizer} to use when performing the resizing operation to create the thumbnail.
   *
   * <p>Calling this method after {@link #resizerFactory(ResizerFactory)} will cause the {@link
   * ResizerFactory} used by the resulting {@link ImageParameter} to only return the specified
   * {@link Resizer}.
   *
   * @param resizer The {@link Resizer} to use when creating the thumbnail.
   * @return A reference to this object.
   */
  public ImageParameterBuilder resizer(Resizer resizer) {
    if (resizer == null) {
      throw new NullPointerException("Resizer is null.");
    }

    this.resizerFactory = new FixedResizerFactory(resizer);
    return this;
  }

  /**
   * Sets the {@link ResizerFactory} to use to obtain a {@link Resizer} when performing the resizing
   * operation to create the thumbnail.
   *
   * <p>Calling this method after {@link #resizer(Resizer)} could result in {@link Resizer}s not
   * specified in the {@code resizer} method to be used when creating thumbnails.
   *
   * @param resizerFactory The {@link ResizerFactory} to use when obtaining a {@link Resizer} to
   *     create the thumbnail.
   * @return A reference to this object.
   * @since 0.4.0
   */
  public ImageParameterBuilder resizerFactory(ResizerFactory resizerFactory) {
    if (resizerFactory == null) {
      throw new NullPointerException("Resizer is null.");
    }

    this.resizerFactory = resizerFactory;
    return this;
  }

  /**
   * Sets whether or not the thumbnail should fit within the specified dimensions.
   *
   * @param fit {@code true} if the thumbnail should be sized to fit within the specified
   *     dimensions, if the thumbnail is going to exceed those dimensions.
   * @return A reference to this object.
   * @since 0.4.0
   */
  public ImageParameterBuilder fitWithinDimensions(boolean fit) {
    this.fitWithinDimensions = fit;
    return this;
  }

  /**
   * Sets whether or not the Exif metadata should be used to determine the orientation of the
   * thumbnail.
   *
   * @param use {@code true} if the Exif metadata should be used to determine the orientation of the
   *     thumbnail, {@code false} otherwise.
   * @return A reference to this object.
   * @since 0.4.3
   */
  public ImageParameterBuilder useExifOrientation(boolean use) {
    this.useExifOrientation = use;
    return this;
  }

  /**
   * Returns a {@link ImageParameter} from the parameters which are currently set.
   *
   * <p>This method will throw a {@link IllegalArgumentException} required parameters for the {@link
   * ImageParameter} have not been set.
   *
   * @return A {@link ImageParameter} with parameters set through the use of this builder.
   * @throws IllegalStateException If neither the size nor the scaling factor has been set.
   */
  public ImageParameter build() {
    if (!Double.isNaN(widthScalingFactor)) {
      // If scaling factor has been set.
      return new ImageParameter(
          widthScalingFactor,
          heightScalingFactor,
          sourceRegion,
          keepAspectRatio,
          thumbnailFormat,
          thumbnailFormatType,
          thumbnailQuality,
          imageType,
          filters,
          resizerFactory,
          fitWithinDimensions,
          useExifOrientation);

    } else if (width != UNINITIALIZED && height != UNINITIALIZED) {
      return new ImageParameter(
          new Dimension(width, height),
          sourceRegion,
          keepAspectRatio,
          thumbnailFormat,
          thumbnailFormatType,
          thumbnailQuality,
          imageType,
          filters,
          resizerFactory,
          fitWithinDimensions,
          useExifOrientation);
    } else {
      throw new IllegalStateException("The size nor the scaling factor has been set.");
    }
  }
}
