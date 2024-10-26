/*
 * Copyright (c) 2021 zhoupan (https://github.com/zhoupan).
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
package lets.core.collections.iterators;

import lets.core.collections.OrderedIterator;
import lets.core.collections.ResettableIterator;

/**
 * Provides an implementation of an empty ordered iterator.
 *
 * @since Commons Collections 3.1
 * @version $Revision: 646777 $ $Date: 2008-04-10 14:33:15 +0200 (Thu, 10 Apr 2008) $
 * @author Stephen Colebourne
 */
public class EmptyOrderedIterator extends AbstractEmptyIterator
    implements OrderedIterator, ResettableIterator {

  /**
   * Singleton instance of the iterator.
   *
   * @since Commons Collections 3.1
   */
  public static final OrderedIterator INSTANCE = new EmptyOrderedIterator();

  /** Constructor. */
  protected EmptyOrderedIterator() {
    super();
  }
}
