/*
 * Copyright (c) 2023 zhoupan (https://github.com/zhoupan).
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
package lets.core;

import java.util.function.Predicate;

public class ClassFilter implements Predicate<Class<?>> {

  /** Create a {@link ClassFilter} instance that accepts all names but filters classes. */
  public static ClassFilter of(Predicate<Class<?>> classPredicate) {
    return of(name -> true, classPredicate);
  }

  /** Create a {@link ClassFilter} instance that filters by names and classes. */
  public static ClassFilter of(
      Predicate<String> namePredicate, Predicate<Class<?>> classPredicate) {
    return new ClassFilter(namePredicate, classPredicate);
  }

  private final Predicate<String> namePredicate;
  private final Predicate<Class<?>> classPredicate;

  private ClassFilter(Predicate<String> namePredicate, Predicate<Class<?>> classPredicate) {
    this.namePredicate = CoreUtils.checkNotNull(namePredicate, "name predicate must not be null");
    this.classPredicate =
        CoreUtils.checkNotNull(classPredicate, "class predicate must not be null");
  }

  /** Test name using the stored name predicate. */
  public boolean match(String name) {
    return namePredicate.test(name);
  }

  /** Test class using the stored class predicate. */
  public boolean match(Class<?> type) {
    return classPredicate.test(type);
  }

  /**
   * @implNote This implementation combines all tests stored in the predicates of this instance. Any
   *     new predicate must be added to this test method as well.
   */
  @Override
  public boolean test(Class<?> type) {
    return match(type.getName()) && match(type);
  }
}
