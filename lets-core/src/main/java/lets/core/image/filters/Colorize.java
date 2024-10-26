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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import lets.core.image.builders.BufferedImageBuilder;

/**
 * An image filter which will add a color tint to an image.
 *
 * @author coobird
 */
public final class Colorize implements ImageFilter {
  /** The color to tint a target image with. */
  private final Color c;

  /**
   * Instantiates this filter with the color to use to tint the target image with.
   *
   * <p>Note: If the provided {@link Color} does not have an alpha channel (transparency channel),
   * then the target image will be painted with an opaque color, resulting in an image with only the
   * specified color.
   *
   * @param c Color to tint with.
   */
  public Colorize(Color c) {
    this.c = c;
  }

  /**
   * Instantiates this filter with the color to use to tint the target image with and the
   * transparency level provided as a {@code float} ranging from {@code 0.0f} to {@code 1.0f}, where
   * {@code 0.0f} indicates completely transparent, and {@code 1.0f} indicates completely opaque.
   *
   * @param c Color to tint with.
   * @param alpha The opacity of the tint.
   */
  public Colorize(Color c, float alpha) {
    this(c, (int) (255 * alpha));
  }

  /**
   * Instantiates this filter with the color to use to tint the target image with and the
   * transparency level provided as a {@code int} ranging from {@code 0} to {@code 255}, where
   * {@code 0} indicates completely transparent, and {@code 255} indicates completely opaque.
   *
   * @param c Color to tint with.
   * @param alpha The opacity of the tint.
   */
  public Colorize(Color c, int alpha) {
    if (alpha > 255 || alpha < 0) {
      throw new IllegalArgumentException(
          "Specified alpha value is outside the range of allowed " + "values.");
    }

    int r = c.getRed();
    int g = c.getGreen();
    int b = c.getBlue();
    int a = alpha;

    this.c = new Color(r, g, b, a);
  }

  public BufferedImage apply(BufferedImage img) {
    int width = img.getWidth();
    int height = img.getHeight();

    BufferedImage newImage = new BufferedImageBuilder(width, height).build();

    Graphics2D g = newImage.createGraphics();
    g.drawImage(img, 0, 0, null);

    g.setColor(c);
    g.fillRect(0, 0, width, height);

    g.dispose();

    return newImage;
  }
}
