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

import java.awt.Dimension;

/**
 * This class provides factory methods which provides suitable {@link Resizer}s for a given
 * situation.
 *
 * <dl>
 *   <dt>{@code Resizer}s returned by this {@code ResizerFactory}:
 *   <dd>The {@link Resizer}s returned by this {@link ResizerFactory} depends upon the size of the
 *       source and destination images. The conditions and the {@link Resizer}s returned are as
 *       follows:
 *       <ul>
 *         <li>Default via {@link #getResizer()}
 *             <ul>
 *               <li>{@link ProgressiveBilinearResizer}
 *             </ul>
 *         <li>Destination image has the same dimensions as the source image via {@link
 *             #getResizer(Dimension, Dimension)}
 *             <ul>
 *               <li>{@link NullResizer}
 *             </ul>
 *         <li>Both the width and height of the destination image is larger than the source image
 *             via {@link #getResizer(Dimension, Dimension)}
 *             <ul>
 *               <li>{@link BicubicResizer}
 *             </ul>
 *         <li>Both the width and height of the destination image is smaller in the source image by
 *             a factor larger than 2, via {@link #getResizer(Dimension, Dimension)}
 *             <ul>
 *               <li>{@link ProgressiveBilinearResizer}
 *             </ul>
 *         <li>Both the width and height of the destination image is smaller in the source image not
 *             by a factor larger than 2, via {@link #getResizer(Dimension, Dimension)}
 *             <ul>
 *               <li>{@link BilinearResizer}
 *             </ul>
 *         <li>Other conditions not described via {@link #getResizer(Dimension, Dimension)}
 *             <ul>
 *               <li>{@link ProgressiveBilinearResizer}
 *             </ul>
 *       </ul>
 * </dl>
 *
 * <DL>
 *   <DT><B>Usage:</B>
 *   <DD>The following example code demonstrates how to use {@link DefaultResizerFactory} in order
 *       to obtain the optimal {@link Resizer}, and using that in order to perform the resizing
 *       operation.
 *       <p>
 *       <pre>
 * BufferedImage sourceImage = new BufferedImageBuilder(400, 400).build();
 * BufferedImage destImage = new BufferedImageBuilder(200, 200).build();
 *
 * Dimension sourceSize = new Dimension(sourceImage.getWidth(), sourceImage.getHeight());
 * Dimension destSize = new Dimension(destImage.getWidth(), destImage.getHeight());
 *
 * // Obtain the optimal Resizer for this resizing operation.
 * Resizer resizer = DefaultResizerFactory.getInstance().getResizer(sourceSize, destSize);
 *
 * // Perform the resizing using the Resizer obtained from the ResizerFactory.
 * resizer.resize(sourceImage, destImage);
 * </pre>
 * </DL>
 *
 * When a specific {@link Resizer} is required, the {@link Resizers} {@code enum} is another way to
 * obtain {@link Resizer}s.
 *
 * <p>
 *
 * @see Resizers
 * @author coobird
 * @since 0.4.0
 */
public class DefaultResizerFactory implements ResizerFactory {
  private static final DefaultResizerFactory INSTANCE = new DefaultResizerFactory();

  /** This class is not intended to be instantiated via the constructor. */
  private DefaultResizerFactory() {}

  /**
   * Returns an instance of this class.
   *
   * @return An instance of this class.
   */
  public static ResizerFactory getInstance() {
    return INSTANCE;
  }

  public Resizer getResizer() {
    return Resizers.PROGRESSIVE;
  }

  public Resizer getResizer(Dimension originalSize, Dimension thumbnailSize) {
    int origWidth = originalSize.width;
    int origHeight = originalSize.height;
    int thumbWidth = thumbnailSize.width;
    int thumbHeight = thumbnailSize.height;

    if (thumbWidth < origWidth && thumbHeight < origHeight) {
      if (thumbWidth < (origWidth / 2) && thumbHeight < (origHeight / 2)) {
        return Resizers.PROGRESSIVE;
      } else {
        return Resizers.BILINEAR;
      }
    } else if (thumbWidth > origWidth && thumbHeight > origHeight) {
      return Resizers.BICUBIC;
    } else if (thumbWidth == origWidth && thumbHeight == origHeight) {
      return Resizers.NULL;
    } else {
      return getResizer();
    }
  }
}
