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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import lets.core.CoreUtils;
import lets.core.DataResultSupport;
import lets.core.io.IOUtils;
import lets.core.mimetypes.MimeTypes;

/**
 * InputStreamImage.
 *
 * @author zhoupan
 */
public class InputStreamImage extends Image {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The bytes. */
  private byte[] bytes;

  /**
   * The Constructor.
   *
   * @param inputStream the input stream
   * @throws IOException the IO exception
   */
  public InputStreamImage(InputStream inputStream) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    IOUtils.copy(inputStream, baos);
    baos.flush();
    CoreUtils.closeQuietlyAll(baos, inputStream);
    this.bytes = baos.toByteArray();
  }

  /**
   * Gets the image info.
   *
   * @return the image info
   */
  public DataResultSupport<ImageInfo> getImageInfo() {
    DataResultSupport<ImageInfo> buildImageInfo =
        ImageInfo.buildFromStrean(new ByteArrayInputStream(this.bytes));
    if (buildImageInfo.isSuccess()) {
      this.setType(MimeTypes.getInstance().getByType(buildImageInfo.getData().getMimeType()));
      try {
        this.setImage(ImageIO.read(new ByteArrayInputStream(this.bytes)));
      } catch (IOException e) {
        buildImageInfo.onException(e);
      }
    }
    return buildImageInfo;
  }
}
