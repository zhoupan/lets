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
 * A {@link ResizerFactory} that returns a specific {@link Resizer} unconditionally.
 *
 * @author coobird
 * @since 0.4.0
 */
public class FixedResizerFactory implements ResizerFactory {
  /** The resizer which is to be returned unconditionally by this class. */
  private final Resizer resizer;

  /**
   * Creates an instance of the {@link FixedResizerFactory} which returns the speicifed {@link
   * Resizer} under all circumstances.
   *
   * @param resizer The {@link Resizer} instance that is to be returned under all circumstances.
   */
  public FixedResizerFactory(Resizer resizer) {
    this.resizer = resizer;
  }

  public Resizer getResizer() {
    return resizer;
  }

  public Resizer getResizer(Dimension originalSize, Dimension thumbnailSize) {
    return resizer;
  }
}
