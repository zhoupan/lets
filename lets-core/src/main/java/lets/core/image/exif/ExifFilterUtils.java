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
package lets.core.image.exif;

import lets.core.image.filters.Flip;
import lets.core.image.filters.ImageFilter;
import lets.core.image.filters.Pipeline;
import lets.core.image.filters.Rotation;

/**
 * An utility class which returns a suitable {@link ImageFilter} to perform the transformations
 * necessary to properly orient an image according to the Exif metadata.
 *
 * @author coobird
 */
public final class ExifFilterUtils {
  /** This class should not be instantiated. */
  private ExifFilterUtils() {}
  ;

  /**
   * Returns a {@link ImageFilter} which will perform the transformations required to properly
   * orient the thumbnail according to the Exif orientation.
   *
   * @param orientation The Exif orientation
   * @return {@link ImageFilter}s required to properly orient the image.
   */
  public static ImageFilter getFilterForOrientation(Orientation orientation) {
    Pipeline filters = new Pipeline();

    if (orientation == Orientation.TOP_RIGHT) {
      filters.add(Flip.HORIZONTAL);
    } else if (orientation == Orientation.BOTTOM_RIGHT) {
      filters.add(Rotation.ROTATE_180_DEGREES);
    } else if (orientation == Orientation.BOTTOM_LEFT) {
      filters.add(Rotation.ROTATE_180_DEGREES);
      filters.add(Flip.HORIZONTAL);
    } else if (orientation == Orientation.LEFT_TOP) {
      filters.add(Rotation.RIGHT_90_DEGREES);
      filters.add(Flip.HORIZONTAL);
    } else if (orientation == Orientation.RIGHT_TOP) {
      filters.add(Rotation.RIGHT_90_DEGREES);
    } else if (orientation == Orientation.RIGHT_BOTTOM) {
      filters.add(Rotation.LEFT_90_DEGREES);
      filters.add(Flip.HORIZONTAL);
    } else if (orientation == Orientation.LEFT_BOTTOM) {
      filters.add(Rotation.LEFT_90_DEGREES);
    }

    return filters;
  }
}
