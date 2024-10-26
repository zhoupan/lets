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
 * An interface to be implemented by classes which read or retrieve images from
 *
 * @param <T> The source class from which the source image is retrieved or read.
 * @author coobird
 */
public interface ImageSource<T> {
  /**
   * Retrieves the image from the source.
   *
   * @return The image.
   * @throws IOException When a problem occurs while reading or obtaining the image.
   */
  public BufferedImage read() throws IOException;

  /**
   * Returns the name of the image format.
   *
   * @return The image format name. If there is no image format information, then {@code null} will
   *     be returned.
   * @throws IllegalStateException If the source image has not been read yet.
   */
  public String getInputFormatName();

  /**
   * Sets the {@link ImageParameter} from which to retrieve parameters to use when retrieving the
   * image.
   *
   * @param param The {@link ImageParameter} with image reading parameters.
   */
  public void setImageParameter(ImageParameter param);

  /**
   * Returns the source from which the image is read or retrieved.
   *
   * @return The source of the image.
   */
  public T getSource();
}
