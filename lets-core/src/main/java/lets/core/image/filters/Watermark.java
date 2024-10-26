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

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import lets.core.image.builders.BufferedImageBuilder;
import lets.core.image.geometry.Position;

/**
 * This class applies a watermark to an image.
 *
 * @author coobird
 */
public class Watermark implements ImageFilter {
  /** The position of the watermark. */
  private final Position position;

  /** The watermark image. */
  private final BufferedImage watermarkImg;

  /** The opacity of the watermark. */
  private final float opacity;

  /**
   * Instantiates a filter which applies a watermark to an image.
   *
   * @param position The position of the watermark.
   * @param watermarkImg The watermark image.
   * @param opacity The opacity of the watermark.
   *     <p>The value should be between {@code 0.0f} and {@code 1.0f}, where {@code 0.0f} is
   *     completely transparent, and {@code 1.0f} is completely opaque.
   */
  public Watermark(Position position, BufferedImage watermarkImg, float opacity) {
    if (position == null) {
      throw new NullPointerException("Position is null.");
    }
    if (watermarkImg == null) {
      throw new NullPointerException("Watermark image is null.");
    }
    if (opacity > 1.0f || opacity < 0.0f) {
      throw new IllegalArgumentException("Opacity is out of range of " + "between 0.0f and 1.0f.");
    }

    this.position = position;
    this.watermarkImg = watermarkImg;
    this.opacity = opacity;
  }

  public BufferedImage apply(BufferedImage img) {
    int width = img.getWidth();
    int height = img.getHeight();
    int type = img.getType();

    BufferedImage imgWithWatermark = new BufferedImageBuilder(width, height, type).build();

    int watermarkWidth = watermarkImg.getWidth();
    int watermarkHeight = watermarkImg.getHeight();

    Point p = position.calculate(width, height, watermarkWidth, watermarkHeight, 0, 0, 0, 0);

    Graphics2D g = imgWithWatermark.createGraphics();

    // Draw the actual image.
    g.drawImage(img, 0, 0, null);

    // Draw the watermark on top.
    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

    g.drawImage(watermarkImg, p.x, p.y, null);

    g.dispose();

    return imgWithWatermark;
  }
}
