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

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import lets.core.DataResultSupport;
import lets.core.mimetypes.MimeTypes;

/**
 * FileImage.
 *
 * @author zhoupan
 */
public class FileImage extends Image {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The file. */
  private File file;

  /**
   * The Constructor.
   *
   * @param file the file
   * @throws IOException the IO exception
   */
  public FileImage(File file) throws IOException {
    this.file = file;
  }

  /**
   * The Constructor.
   *
   * @param url the url
   * @throws IOException the IO exception
   */
  public FileImage(String url) throws IOException {
    this(new File(url));
  }

  /**
   * Gets the file.
   *
   * @return the file
   */
  public File getFile() {
    return file;
  }

  public DataResultSupport<ImageInfo> getImageInfo() {
    DataResultSupport<ImageInfo> buildImageInfo = ImageInfo.buildFromFile(this.file);
    if (buildImageInfo.isSuccess()) {
      this.setType(MimeTypes.getInstance().getByType(buildImageInfo.getData().getMimeType()));
      try {
        this.setImage(ImageIO.read(this.file));
      } catch (IOException e) {
        buildImageInfo.onException(e);
      }
    }
    return buildImageInfo;
  }
}
