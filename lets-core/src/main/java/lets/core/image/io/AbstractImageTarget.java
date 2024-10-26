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
import lets.core.image.ImageParameter;

/**
 * An abstract class for {@link ImageTarget}s.
 *
 * @author coobird
 */
public abstract class AbstractImageTarget<T> implements ImageTarget<T> {
  /** The name of the format to output the image as. */
  protected String outputFormat;

  /** The parameters that should be used when storing the image. */
  protected ImageParameter param;

  /** Default constructor. */
  protected AbstractImageTarget() {}

  public void setOutputFormatName(String format) {
    outputFormat = format;
  }

  public void setImageParameter(ImageParameter param) {
    this.param = param;
  }

  public void write(BufferedImage img) throws IOException {
    if (img == null) {
      throw new NullPointerException("Cannot write a null image.");
    }

    if (ImageParameter.DETERMINE_FORMAT.equals(outputFormat)) {
      outputFormat = preferredOutputFormatName();
    }
  }

  public String preferredOutputFormatName() {
    return ImageParameter.ORIGINAL_FORMAT;
  }
}
