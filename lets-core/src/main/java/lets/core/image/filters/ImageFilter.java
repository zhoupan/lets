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

import java.awt.image.BufferedImage;

/**
 * This interface is to be implemented by classes which performs an image filtering operation on a
 * {@link BufferedImage}.
 *
 * <p>The general contract for classes implementing {@link ImageFilter} is that they should not
 * change the contents of the {@link BufferedImage} which is given as the argument for the {@link
 * #apply(BufferedImage)} method.
 *
 * <p>The filter should make a copy of the given {@link BufferedImage}, and perform the filtering
 * operations on the copy, then return the copy.
 *
 * @author coobird
 */
public interface ImageFilter {
  /**
   * Applies a image filtering operation on an image.
   *
   * @param img The image to apply the filtering on.
   * @return The resulting image after applying this filter.
   */
  public BufferedImage apply(BufferedImage img);
}
