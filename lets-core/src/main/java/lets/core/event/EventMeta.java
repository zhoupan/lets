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

import java.util.Date;
import java.util.Vector;
import lets.core.MutableObject;

public class EventMeta {

  public final Vector<String> purpose = new Vector<String>();
  public final Vector<String> from = new Vector<String>();
  public final Vector<String> to = new Vector<String>();
  public final MutableObject<Date> createAt = new MutableObject<Date>();
  public final MutableObject<Date> expiredAt = new MutableObject<Date>();

  @Override
  public String toString() {
    return "EventMeta [from="
        + from
        + ", to="
        + to
        + ", purpose="
        + purpose
        + ", createAt="
        + createAt
        + ", expiredAt="
        + expiredAt
        + "]";
  }
}
