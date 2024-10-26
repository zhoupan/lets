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
package lets.core.image.io;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * An {@link ImageTarget} which stores the resulting to a {@link BufferedImage}.
 *
 * @author coobird
 */
public class BufferedImageTarget extends AbstractImageTarget<BufferedImage> {
  /** The {@link BufferedImage} which holds the thumbnail. */
  private BufferedImage img;

  /** Indicates whether the thumbnail has been written to this object. */
  private boolean written = false;

  @Override
  public void write(BufferedImage img) throws IOException {
    super.write(img);

    this.img = img;
    written = true;
  }

  /**
   * Returns the thumbnail.
   *
   * @return The thumbnail.
   * @throws IllegalStateException If a thumbnail has not been stored to this {@link
   *     BufferedImageTarget} yet.
   */
  public BufferedImage getTarget() {
    if (!written) {
      throw new IllegalStateException("BufferedImageTarget has not been written to yet.");
    }
    return img;
  }

  @Override
  public void setOutputFormatName(String format) {
    // do nothing
  }
}
