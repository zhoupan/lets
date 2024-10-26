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
package lets.core.image.io;

import java.awt.image.BufferedImage;
import java.io.IOException;
import lets.core.image.ImageParameter;

/**
 * An interface to be implemented by classes which stores the image resulting
 *
 * @author coobird
 */
public interface ImageTarget<T> {
  /**
   * Writes the resulting image to a destination.
   *
   * @param img The image to write or store.
   * @throws IOException When a problem occurs while writing or storing the image.
   * @throws NullPointerException If the image is {@code null}.
   */
  public void write(BufferedImage img) throws IOException;

  /**
   * Sets the output format of the resulting image.
   *
   * <p>For {@link ImageTarget}s which stores raw images, the format name specified by this method
   * may be ignored.
   *
   * @param format File format with which to store the image.
   */
  public void setOutputFormatName(String format);

  /**
   * Sets the {@link ImageParameter} from which to retrieve parameters to use when storing the
   * image.
   *
   * @param param The {@link ImageParameter} with image writing parameters.
   */
  public void setImageParameter(ImageParameter param);

  /**
   * Returns the output format to use from information provided for the output image.
   *
   * <p>If the output format cannot be determined, then {@link ImageParameter#ORIGINAL_FORMAT}
   * should be returned.
   */
  public String preferredOutputFormatName();

  /**
   * Returns the destination to which the be stored or written.
   *
   * @return The destination for the image.
   */
  public T getTarget();
}
