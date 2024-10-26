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
package lets.core.image.resizers;

import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Map;

/**
 * A {@link Resizer} which does not actually resize the image.
 *
 * <p>The source image will be drawn at the origin of the destination image.
 *
 * @author coobird
 * @since 0.4.0
 */
public class NullResizer extends AbstractResizer {
  /**
   * Instantiates the {@code NullResizer} which draws the source image at the origin of the
   * destination image.
   */
  public NullResizer() {
    this(RenderingHints.VALUE_INTERPOLATION_BILINEAR, Collections.<Key, Object>emptyMap());
  }

  /**
   * This constructor is {@code private} to prevent the rendering hints from being set, as this
   * {@link Resizer} does not perform any resizing.
   *
   * @param interpolationValue Not used.
   * @param hints Not used.
   */
  private NullResizer(Object interpolationValue, Map<Key, Object> hints) {
    super(interpolationValue, hints);
  }

  @Override
  public void resize(BufferedImage srcImage, BufferedImage destImage) {
    super.performChecks(srcImage, destImage);

    Graphics g = destImage.getGraphics();
    g.drawImage(srcImage, 0, 0, null);
    g.dispose();
  }
}
