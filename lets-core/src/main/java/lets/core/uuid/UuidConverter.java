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

public class UuidConverter {

  public static BigInteger toBigInteger(UUID uuid) {
    return BigIntegerPairing.pair(
        BigInteger.valueOf(uuid.getMostSignificantBits()),
        BigInteger.valueOf(uuid.getLeastSignificantBits()));
  }

  public static UUID toUuid(BigInteger value) {
    BigInteger[] unpaired = BigIntegerPairing.unpair(value);
    return new UUID(unpaired[0].longValueExact(), unpaired[1].longValueExact());
  }
}
