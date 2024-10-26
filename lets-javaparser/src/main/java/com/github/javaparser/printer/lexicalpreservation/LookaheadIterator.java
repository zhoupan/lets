/*
 * Copyright (c) 2013-2024 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.printer.lexicalpreservation;

import java.util.NoSuchElementException;

public interface LookaheadIterator<E> {

  /**
   * Returns the next element in iteration without advancing the underlying iterator. If the
   * iterator is already exhausted, null will be returned.
   *
   * <p>Note: this method does not throw a {@link NoSuchElementException} if the iterator is already
   * exhausted. If you want such a behavior, use {@link #element()} instead.
   *
   * <p>The rationale behind this is to follow the {@link java.util.Queue} interface which uses the
   * same terminology.
   *
   * @return the next element from the iterator
   */
  public E peek();

  /**
   * Returns the next element in iteration without advancing the underlying iterator. If the
   * iterator is already exhausted, null will be returned.
   *
   * @return the next element from the iterator
   * @throws NoSuchElementException if the iterator is already exhausted according to {@link
   *     #hasNext()}
   */
  public E element();
}
