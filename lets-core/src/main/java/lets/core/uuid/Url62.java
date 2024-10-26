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

import java.math.BigInteger;
import java.util.UUID;

/** Class to convert UUID to Url62 IDs */
public class Url62 {

  /**
   * Encode UUID to Url62 id
   *
   * @param uuid UUID to be encoded
   * @return url62 encoded UUID
   */
  public static String encode(UUID uuid) {
    BigInteger pair = UuidConverter.toBigInteger(uuid);
    return Base62.encode(pair);
  }

  /**
   * Decode url62 id to UUID
   *
   * @param id url62 encoded id
   * @return decoded UUID
   */
  public static UUID decode(String id) {
    BigInteger decoded = Base62.decode(id);
    return UuidConverter.toUuid(decoded);
  }
}
