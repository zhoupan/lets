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

import lets.core.image.ImageParameter;

/**
 * An abstract class for {@link ImageSource}s.
 *
 * @author coobird
 */
public abstract class AbstractImageSource<T> implements ImageSource<T> {
  /** The image format of the input image. */
  protected String inputFormatName;

  /** The parameters that should be used when retrieving the image. */
  protected ImageParameter param;

  /** Indicates whether the input has already been read. */
  protected boolean hasReadInput = false;

  /** Default constructor. */
  protected AbstractImageSource() {}

  /**
   * Indicates that the {@link ImageSource} has completed reading the input file, and returns the
   * value given in the argument.
   *
   * <p>This method should be used by implementation classes when returning the result of the {@link
   * #read()} method, as shown in the following example code:
   *
   * <pre>
   * return finishedReading(sourceImage);
   * </pre>
   *
   * @param <V> The return value type.
   * @param returnValue The return value of the {@link #read()} method.
   * @return The return value of the {@link #read()} method.
   */
  protected <V> V finishedReading(V returnValue) {
    hasReadInput = true;
    return returnValue;
  }

  public void setImageParameter(ImageParameter param) {
    this.param = param;
  }

  public String getInputFormatName() {
    if (!hasReadInput) {
      throw new IllegalStateException("Input has not been read yet.");
    }
    return inputFormatName;
  }
}
