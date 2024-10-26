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
package lets.core.image.filters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import lets.core.image.builders.BufferedImageBuilder;

/**
 * A class containing flip transformation filters.
 *
 * @author coobird
 */
public class Flip {

  /** An image filter which performs a horizontal flip of the image. */
  public static final ImageFilter HORIZONTAL =
      new ImageFilter() {
        public BufferedImage apply(BufferedImage img) {
          int width = img.getWidth();
          int height = img.getHeight();

          BufferedImage newImage = new BufferedImageBuilder(width, height).build();

          Graphics g = newImage.getGraphics();
          g.drawImage(img, width, 0, 0, height, 0, 0, width, height, null);
          g.dispose();

          return newImage;
        }
        ;
      };

  /** An image filter which performs a vertical flip of the image. */
  public static final ImageFilter VERTICAL =
      new ImageFilter() {
        public BufferedImage apply(BufferedImage img) {
          int width = img.getWidth();
          int height = img.getHeight();

          BufferedImage newImage = new BufferedImageBuilder(width, height).build();

          Graphics g = newImage.getGraphics();
          g.drawImage(img, 0, height, width, 0, 0, 0, width, height, null);
          g.dispose();

          return newImage;
        }
        ;
      };
}
