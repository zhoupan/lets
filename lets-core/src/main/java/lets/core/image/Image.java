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
import java.io.Serializable;
import lets.core.DataResultSupport;
import lets.core.mimetypes.MimeType;

public abstract class Image implements Serializable {

  private static final long serialVersionUID = 1L;
  protected BufferedImage image;
  protected MimeType type;

  public BufferedImage getImage() {
    return image;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }

  public MimeType getType() {
    return type;
  }

  public void setType(MimeType type) {
    this.type = type;
  }

  public int getHeight() {
    return image.getHeight();
  }

  public int getWidth() {
    return image.getWidth();
  }

  public abstract DataResultSupport<ImageInfo> getImageInfo();
}
