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
import java.io.File;
import java.io.IOException;
import lets.core.image.ImageParameter;
import lets.core.image.io.FileImageSource;
import lets.core.image.io.FileImageTarget;

/**
 * A thumbnail generation task which reads and writes data from and to a {@link File}.
 *
 * <p>Only the first image included in the image file will be read. Subsequent images included in
 * the image file will be ignored.
 *
 * @author coobird
 */
public class FileImageTask extends ImageTask<File, File> {
  /** The {@link ImageSourceTask} used to perform the task. */
  private final ImageSourceTask<File, File> task;

  /**
   * Creates a {@link ImageTask} in which image data is read from the specified {@link File} and is
   * output to a specified {@link File}, using the parameters provided in the specified {@link
   * ImageParameter}.
   *
   * @param param The parameters to use to create the thumbnail.
   * @param sourceFile The {@link File} from which image data is read.
   * @param destinationFile The {@link File} to which thumbnail is written.
   * @throws NullPointerException If the parameter is {@code null}.
   */
  public FileImageTask(ImageParameter param, File sourceFile, File destinationFile) {
    super(param);
    this.task =
        new ImageSourceTask<File, File>(
            param, new FileImageSource(sourceFile), new FileImageTarget(destinationFile));
  }

  @Override
  public BufferedImage read() throws IOException {
    return task.read();
  }

  @Override
  public void write(BufferedImage img) throws IOException {
    task.write(img);
  }

  @Override
  public ImageParameter getParam() {
    return task.getParam();
  }

  @Override
  public File getSource() {
    return task.getSource();
  }

  @Override
  public File getDestination() {
    return task.getDestination();
  }
}
