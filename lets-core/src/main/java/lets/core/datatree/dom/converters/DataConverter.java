/*
 * Copyright (c) 2017 zhoupan (https://github.com/zhoupan).
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
package lets.core.datatree.dom.converters;

/**
 * Functional Interface for F ("from" class) -&gt; T ("to" class) object converters.
 *
 * @param <T> target class
 * @param <F> source class
 * @author Andras Berkes [andras.berkes@programmer.net]
 */
@FunctionalInterface
public interface DataConverter<T, F> {

  /**
   * Converts "FROM" Object to "TO" format / class.
   *
   * @param from source object
   * @return converted object
   */
  public T convert(F from);
}
