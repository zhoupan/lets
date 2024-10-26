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
package lets.core.image.resizers.configurations;

import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;

/**
 * An enum which is used to specify the alpha interpolation settings of the resizing operations.
 *
 * @author coobird
 */
public enum AlphaInterpolation implements ResizerConfiguration {
  /** A hint used to emphasize speed when performing alpha interpolation. */
  SPEED(RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED),

  /** A hint used to emphasize quality when performing alpha interpolation. */
  QUALITY(RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY),

  /** A hint which indicates to use the default alpha interpolation settings. */
  DEFAULT(RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT),
  ;

  /** The field used to hold the rendering hint. */
  private final Object value;

  /**
   * Instantiates this enum.
   *
   * @param value The rendering hint value.
   */
  private AlphaInterpolation(Object value) {
    this.value = value;
  }

  public Key getKey() {
    return RenderingHints.KEY_ALPHA_INTERPOLATION;
  }

  public Object getValue() {
    return value;
  }
}
