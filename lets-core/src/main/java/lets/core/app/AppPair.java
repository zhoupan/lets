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
package lets.core.app;

/**
 * AppPair.
 *
 * @param <F> the generic type
 * @param <S> the generic type
 */
public class AppPair<F, S> {

  /** The first. */
  private final F first;

  /** The second. */
  private final S second;

  /**
   * Instantiates a new pair.
   *
   * @param first the first
   * @param second the second
   */
  public AppPair(F first, S second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Of.
   *
   * @param <F> the generic type
   * @param <S> the generic type
   * @param f the f
   * @param s the s
   * @return the pair
   */
  public static <F, S> AppPair<F, S> of(F f, S s) {
    return new AppPair<F, S>(f, s);
  }

  /**
   * Equals.
   *
   * @param o the o
   * @return true, if successful
   */
  @SuppressWarnings("rawtypes")
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    } else if (o instanceof AppPair) {
      AppPair p = (AppPair) o;
      return equals(first, p.first) && equals(second, p.second);
    } else {
      return false;
    }
  }

  /**
   * Equals.
   *
   * @param a the a
   * @param b the b
   * @return true, if successful
   */
  private static boolean equals(Object a, Object b) {
    return a == b || (a != null && a.equals(b));
  }

  /**
   * Gets the first.
   *
   * @return the first
   */
  public F getFirst() {
    return first;
  }

  /**
   * Gets the second.
   *
   * @return the second
   */
  public S getSecond() {
    return second;
  }

  /**
   * Hash code.
   *
   * @return the int
   */
  @Override
  public int hashCode() {
    return 31 * (first != null ? first.hashCode() : 0) + (second != null ? second.hashCode() : 0);
  }
}
