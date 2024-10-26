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
 * This interface is implemented by all classes which will return a {@link Resizer} that should be
 * used when creating a thumbnail.
 *
 * @author coobird
 * @since 0.4.0
 */
public interface ResizerFactory {
  /**
   * Returns the default {@link Resizer}.
   *
   * @return The default {@code Resizer}.
   */
  public Resizer getResizer();

  /**
   * Returns a suitable {@link Resizer}, given the {@link Dimension}s of the original image and the
   * thumbnail image.
   *
   * @param originalSize The size of the original image.
   * @param thumbnailSize The size of the thumbnail.
   * @return The suitable {@code Resizer} to perform the resizing operation for the given condition.
   */
  public Resizer getResizer(Dimension originalSize, Dimension thumbnailSize);
}
