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

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import lets.core.image.geometry.Region;

/**
 * An {@link ImageSource} which uses a {@link BufferedImage} as the source image.
 *
 * @author coobird
 */
public class BufferedImageSource extends AbstractImageSource<BufferedImage> {
  /** The image that should be used as the source for making a thumbnail. */
  private final BufferedImage img;

  /**
   * Instantiates a {@link BufferedImageSource} object with the {@link BufferedImage} that should be
   * used as the source image for making thumbnails.
   *
   * @param img The source image.
   * @throws NullPointerException If the image is null.
   */
  public BufferedImageSource(BufferedImage img) {
    super();

    if (img == null) {
      throw new NullPointerException("Image cannot be null.");
    }

    this.img = img;
  }

  public BufferedImage read() throws IOException {
    inputFormatName = null;

    if (param != null && param.getSourceRegion() != null) {
      Region region = param.getSourceRegion();
      Rectangle r = region.calculate(img.getWidth(), img.getHeight());

      return finishedReading(img.getSubimage(r.x, r.y, r.width, r.height));
    } else {
      return finishedReading(img);
    }
  }

  public BufferedImage getSource() {
    return img;
  }
}
