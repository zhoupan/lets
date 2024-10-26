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

import java.awt.image.BufferedImage;
import java.io.IOException;
import lets.core.image.ImageParameter;

/**
 * This class is used by {@link ImageTask} implementations which is used when creating thumbnails
 * from external sources and destinations.
 *
 * <p>If the image handled by a {@link ImageTask} contains multiple images, only the first image
 * will be read by the {@link #read()} method. Any subsequent images will be ignored.
 *
 * @param <S> The class from which the image is retrieved or read.
 * @param <D> The class to which the thumbnail is stored or written.
 * @author coobird
 */
public abstract class ImageTask<S, D> {
  /** The parameters to use when creating a thumbnail. */
  protected final ImageParameter param;

  /**
   * String indicating the image format of the input image.
   *
   * <p>To be used for situtions where the output image format should be the same as the input image
   * format.
   */
  protected String inputFormatName;

  /** Constant used to obtain the first image when reading an image file. */
  protected static final int FIRST_IMAGE_INDEX = 0;

  /**
   * Instantiates a {@link ImageTask} with the parameters to use when creating thumbnails.
   *
   * @param param The parameters to use when creating thumbnails.
   * @throws NullPointerException If the parameter is {@code null}.
   */
  protected ImageTask(ImageParameter param) {
    if (param == null) {
      throw new NullPointerException("The parameter is null.");
    }
    this.param = param;
  }

  /**
   * Reads a source image.
   *
   * @return The image which was obtained from the source.
   * @throws IOException Thrown when an I/O problem occurs when reading from the image source.
   */
  /*
   * Future changes note: The public interface of this method may have to be changed to support reading images tile-by-tile. This change may
   * be required in order to support large images.
   */
  public abstract BufferedImage read() throws IOException;

  /**
   * Writes the thumbnail to the destination.
   *
   * @param img The image to write.
   * @throws UnsupportedFormatException When an image file which is to be read or written is
   *     unsupported.
   * @throws IOException Thrown when an I/O problem occurs when writing the image.
   */
  public abstract void write(BufferedImage img) throws IOException;

  /**
   * Returns the {@link ImageParameter} for this {@link ImageTask}, used when performing a thumbnail
   * generation operation.
   *
   * @return The parameters to use when generating thumbnails.
   */
  public ImageParameter getParam() {
    return param;
  }

  /**
   * Returns the source from which the source image is retrieved or read.
   *
   * @return The source.
   */
  public abstract S getSource();

  /**
   * Returns the destination to which the thumbnail is stored or written.
   *
   * @return The destination.
   */
  public abstract D getDestination();
}
