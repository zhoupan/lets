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
package lets.core.uuid;

import java.util.UUID;

/** Class to convert UUID to url Friendly IDs basing on Url62 */
public class FriendlyId {

  /**
   * Create FriendlyId id
   *
   * @return Friendly Id encoded UUID
   */
  public static String createFriendlyId() {
    return Url62.encode(UUID.randomUUID());
  }

  /**
   * Encode UUID to FriendlyId id
   *
   * @param uuid UUID to be encoded
   * @return Friendly Id encoded UUID
   */
  public static String toFriendlyId(UUID uuid) {
    return Url62.encode(uuid);
  }

  /**
   * Decode Friendly Id to UUID
   *
   * @param friendlyId encoded UUID
   * @return decoded UUID
   */
  public static UUID toUuid(String friendlyId) {
    return Url62.decode(friendlyId);
  }
}
