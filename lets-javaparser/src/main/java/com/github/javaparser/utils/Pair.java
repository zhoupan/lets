/*
 * Copyright (c) 2007-2010 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.utils;

import static com.github.javaparser.utils.CodeGenerationUtils.f;

import java.util.Objects;

/**
 * Simply a pair of objects.
 *
 * @param <A> type of object a.
 * @param <B> type of object b.
 */
public class Pair<A, B> {

  public final A a;

  public final B b;

  public Pair(A a, B b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pair<?, ?> pair = (Pair<?, ?>) o;
    if (!Objects.equals(a, pair.a)) return false;
    if (!Objects.equals(b, pair.b)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    int result = a != null ? a.hashCode() : 0;
    return 31 * result + (b != null ? b.hashCode() : 0);
  }

  @Override
  public String toString() {
    return f("<%s, %s>", a, b);
  }
}
