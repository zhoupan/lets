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

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Map;

/**
 * Image resizer class using bicubic interpolation for the resizing operation.
 *
 * @author coobird
 */
public class BicubicResizer extends AbstractResizer {
  /** Instantiates a {@link BicubicResizer} with default rendering hints. */
  public BicubicResizer() {
    this(Collections.<RenderingHints.Key, Object>emptyMap());
  }

  /**
   * Instantiates a {@link BicubicResizer} with the specified rendering hints.
   *
   * @param hints Additional rendering hints to apply.
   */
  public BicubicResizer(Map<RenderingHints.Key, Object> hints) {
    super(RenderingHints.VALUE_INTERPOLATION_BICUBIC, hints);
  }

  /**
   * Resizes an image using bicubic interpolation.
   *
   * <p>If the source and/or destination image is {@code null}, then a {@link NullPointerException}
   * will be thrown.
   *
   * @param srcImage The source image.
   * @param destImage The destination image.
   * @throws NullPointerException When the source and/or the destination image is {@code null}.
   */
  @Override
  public void resize(BufferedImage srcImage, BufferedImage destImage) throws NullPointerException {
    super.resize(srcImage, destImage);
  }
}
