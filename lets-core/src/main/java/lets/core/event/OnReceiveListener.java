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
package lets.core.event;

import java.util.EventListener;

/**
 * The listener interface for receiving onReceive events.
 * The class that is interested in processing a onReceive
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addOnReceiveListener<code> method. When
 * the onReceive event occurs, that object's appropriate
 * method is invoked.
 *
 * @param <T> the generic type
 * @see OnReceiveEvent
 */
public interface OnReceiveListener<T> extends EventListener {

  /**
   * On receive.
   *
   * @param t the t
   */
  void onReceive(T t);
}
