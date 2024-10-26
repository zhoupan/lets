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
package lets.core.image;

import java.awt.image.BufferedImage;
import lets.core.CoreUtils;
import lets.core.DataResultSupport;

/**
 * DefaultImage.
 *
 * @author zhoupan
 */
public class DefaultImage extends Image {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * The Constructor.
   *
   * @param image the image
   */
  public DefaultImage(BufferedImage image) {
    super();
    this.setImage(image);
  }

  /**
   * Gets the image info.
   *
   * @return the image info
   */
  @Override
  public DataResultSupport<ImageInfo> getImageInfo() {
    DataResultSupport<ImageInfo> result = new DataResultSupport<ImageInfo>();
    try {
      CoreUtils.notImplemented();
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
