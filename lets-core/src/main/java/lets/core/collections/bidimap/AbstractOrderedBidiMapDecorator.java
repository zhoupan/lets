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
package lets.core.collections.bidimap;

import lets.core.collections.OrderedBidiMap;
import lets.core.collections.OrderedMapIterator;

/**
 * Provides a base decorator that enables additional functionality to be added to an OrderedBidiMap
 * via decoration.
 *
 * <p>Methods are forwarded directly to the decorated map.
 *
 * <p>This implementation does not perform any special processing with the map views. Instead it
 * simply returns the inverse from the wrapped map. This may be undesirable, for example if you are
 * trying to write a validating implementation it would provide a loophole around the validation.
 * But, you might want that loophole, so this class is kept simple.
 *
 * @since Commons Collections 3.0
 * @version $Revision: 646777 $ $Date: 2008-04-10 14:33:15 +0200 (Thu, 10 Apr 2008) $
 * @author Stephen Colebourne
 */
public abstract class AbstractOrderedBidiMapDecorator extends AbstractBidiMapDecorator
    implements OrderedBidiMap {

  /**
   * Constructor that wraps (not copies).
   *
   * @param map the map to decorate, must not be null
   * @throws IllegalArgumentException if the collection is null
   */
  protected AbstractOrderedBidiMapDecorator(OrderedBidiMap map) {
    super(map);
  }

  /**
   * Gets the map being decorated.
   *
   * @return the decorated map
   */
  protected OrderedBidiMap getOrderedBidiMap() {
    return (OrderedBidiMap) map;
  }

  // -----------------------------------------------------------------------
  public OrderedMapIterator orderedMapIterator() {
    return getOrderedBidiMap().orderedMapIterator();
  }

  public Object firstKey() {
    return getOrderedBidiMap().firstKey();
  }

  public Object lastKey() {
    return getOrderedBidiMap().lastKey();
  }

  public Object nextKey(Object key) {
    return getOrderedBidiMap().nextKey(key);
  }

  public Object previousKey(Object key) {
    return getOrderedBidiMap().previousKey(key);
  }

  public OrderedBidiMap inverseOrderedBidiMap() {
    return getOrderedBidiMap().inverseOrderedBidiMap();
  }
}
