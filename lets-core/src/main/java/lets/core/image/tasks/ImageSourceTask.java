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
package lets.core.image.tasks;

import java.awt.image.BufferedImage;
import java.io.IOException;
import lets.core.image.ImageParameter;
import lets.core.image.io.ImageSource;
import lets.core.image.io.ImageTarget;

/**
 * A {@link ImageTask} which holds an {@link ImageSource} from which the image is read or retrieved,
 * and an {@link ImageTarget} to which the thumbnail is stored or written.
 *
 * <p>This class will take care of handing off information from the {@link ImageSource} to the
 * {@link ImageTarget}. For example, the output format that should be used by the {@link
 * ImageTarget} will be handed off if the {@link ImageParameter#ORIGINAL_FORMAT} parameter is set.
 *
 * @author coobird
 * @param <S> The source class from which the source image is retrieved or read.
 * @param <D> The destination class to which the thumbnail is stored or written.
 */
public class ImageSourceTask<S, D> extends ImageTask<S, D> {
  /** The source from which the image is retrieved or read. */
  private final ImageSource<S> source;

  /** The destination to which the thumbnail is stored or written. */
  private final ImageTarget<D> destination;

  /**
   * Creates a {@link ImageTask} in which an image is retrived from the specified {@link
   * ImageSource} and written to the specified {@link ImageTarget}, using the parameters provided in
   * the specified {@link ImageParameter}.
   *
   * @param param The parameters to use to create the thumbnail.
   * @param source The source from which the image is retrieved or read from.
   * @param destination The destination to which the thumbnail is stored or written to.
   * @throws NullPointerException If either the parameter, {@link ImageSource} or {@link
   *     ImageTarget} is {@code null}.
   */
  public ImageSourceTask(ImageParameter param, ImageSource<S> source, ImageTarget<D> destination) {
    super(param);
    if (source == null) {
      throw new NullPointerException("ImageSource cannot be null.");
    }
    if (destination == null) {
      throw new NullPointerException("ImageTarget cannot be null.");
    }

    source.setImageParameter(param);
    this.source = source;

    destination.setImageParameter(param);
    this.destination = destination;
  }

  @Override
  public BufferedImage read() throws IOException {
    BufferedImage img = source.read();
    inputFormatName = source.getInputFormatName();
    return img;
  }

  @Override
  public void write(BufferedImage img) throws IOException {
    String paramOutputFormat = param.getOutputFormat();
    String formatName = null;

    if (ImageParameter.DETERMINE_FORMAT.equals(paramOutputFormat)) {
      paramOutputFormat = destination.preferredOutputFormatName();
    }

    if (paramOutputFormat == ImageParameter.ORIGINAL_FORMAT) {
      formatName = inputFormatName;
    } else {
      formatName = paramOutputFormat;
    }

    destination.setOutputFormatName(formatName);
    destination.write(img);
  }

  @Override
  public S getSource() {
    return source.getSource();
  }

  @Override
  public D getDestination() {
    return destination.getTarget();
  }
}
