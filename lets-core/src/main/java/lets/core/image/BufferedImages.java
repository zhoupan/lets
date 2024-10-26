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
package lets.core.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * This class provides convenience methods for using {@link BufferedImage}s.
 *
 * @author coobird
 */
public final class BufferedImages {
  /** This class is not intended to be instantiated. */
  private BufferedImages() {}

  /**
   * Returns a {@link BufferedImage} which is a graphical copy of the specified image.
   *
   * @param img The image to copy.
   * @return A copy of the specified image.
   */
  public static BufferedImage copy(BufferedImage img) {
    return copy(img, img.getType());
  }

  /**
   * Returns a {@link BufferedImage} with the specified image type, where the graphical content is a
   * copy of the specified image.
   *
   * @param img The image to copy.
   * @param imageType The image type for the image to return.
   * @return A copy of the specified image.
   */
  public static BufferedImage copy(BufferedImage img, int imageType) {
    int width = img.getWidth();
    int height = img.getHeight();

    BufferedImage newImage = new BufferedImage(width, height, imageType);
    Graphics g = newImage.createGraphics();

    g.drawImage(img, 0, 0, null);

    g.dispose();

    return newImage;
  }
}
