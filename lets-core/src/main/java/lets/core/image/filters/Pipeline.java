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
package lets.core.image.filters;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lets.core.image.BufferedImages;

/**
 * An {@link ImageFilter} which will apply multiple {@link ImageFilter}s in a specific order.
 *
 * @author coobird
 */
public final class Pipeline implements ImageFilter {
  /** A list of image filters to apply. */
  private final List<ImageFilter> filtersToApply;

  /**
   * An unmodifiable list of image filters to apply. Used by the {@link #getFilters()} method.
   *
   * <p>This object is created by Collections.unmodifiableList which provides an unmodifiable view
   * of the original list.
   *
   * <p>Therefore, any changes to the original list will also be "visible" from this list as well.
   */
  private final List<ImageFilter> unmodifiableFiltersToApply;

  /** Instantiates a new {@link Pipeline} with no image filters to apply. */
  public Pipeline() {
    this(Collections.<ImageFilter>emptyList());
  }

  /**
   * Instantiates a new {@link Pipeline} with an array of {@link ImageFilter}s to apply.
   *
   * @param filters An array of {@link ImageFilter}s to apply.
   */
  public Pipeline(ImageFilter... filters) {
    this(Arrays.asList(filters));
  }

  /**
   * Instantiates a new {@link Pipeline} with a list of {@link ImageFilter}s to apply.
   *
   * @param filters A list of {@link ImageFilter}s to apply.
   */
  public Pipeline(List<ImageFilter> filters) {
    if (filters == null) {
      throw new NullPointerException("Cannot instantiate with a null" + "list of image filters.");
    }

    filtersToApply = new ArrayList<ImageFilter>(filters);
    unmodifiableFiltersToApply = Collections.unmodifiableList(filtersToApply);
  }

  /** Adds an {@code ImageFilter} to the pipeline. */
  public void add(ImageFilter filter) {
    if (filter == null) {
      throw new NullPointerException("An image filter must not be null.");
    }

    filtersToApply.add(filter);
  }

  /** Adds an {@code ImageFilter} to the beginning of the pipeline. */
  public void addFirst(ImageFilter filter) {
    if (filter == null) {
      throw new NullPointerException("An image filter must not be null.");
    }

    filtersToApply.add(0, filter);
  }

  /**
   * Adds a {@code List} of {@code ImageFilter}s to the pipeline.
   *
   * @param filters A list of filters to add to the pipeline.
   */
  public void addAll(List<ImageFilter> filters) {
    if (filters == null) {
      throw new NullPointerException("A list of image filters must not be null.");
    }

    filtersToApply.addAll(filters);
  }

  /**
   * Returns a list of {@link ImageFilter}s which will be applied by this {@link Pipeline}.
   *
   * @return A list of filters which are applied by this pipeline.
   */
  public List<ImageFilter> getFilters() {
    return unmodifiableFiltersToApply;
  }

  public BufferedImage apply(BufferedImage img) {
    if (filtersToApply.isEmpty()) {
      return img;
    }

    BufferedImage image = BufferedImages.copy(img);

    for (ImageFilter filter : filtersToApply) {
      image = filter.apply(image);
    }

    return image;
  }
}
