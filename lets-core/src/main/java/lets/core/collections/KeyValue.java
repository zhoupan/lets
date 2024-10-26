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
package lets.core.collections;

/**
 * Defines a simple key value pair.
 *
 * <p>A Map Entry has considerable additional semantics over and above a simple key-value pair. This
 * interface defines the minimum key value, with just the two get methods.
 *
 * @since Commons Collections 3.0
 * @version $Revision: 646777 $ $Date: 2008-04-10 14:33:15 +0200 (Thu, 10 Apr 2008) $
 * @author Stephen Colebourne
 */
public interface KeyValue {

  /**
   * Gets the key from the pair.
   *
   * @return the key
   */
  Object getKey();

  /**
   * Gets the value from the pair.
   *
   * @return the value
   */
  Object getValue();
}
