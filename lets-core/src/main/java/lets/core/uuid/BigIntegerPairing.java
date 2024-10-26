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
import java.util.function.Function;

/**
 * Basing on snippet published by drmalex07
 *
 * <p>https://gist.github.com/drmalex07/9008c611ffde6cb2ef3a2db8668bc251
 */
class BigIntegerPairing {

  private static final BigInteger HALF = BigInteger.ONE.shiftLeft(64); // 2^64
  private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);

  private static Function<BigInteger, BigInteger> toUnsigned =
      value -> value.signum() < 0 ? value.add(HALF) : value;
  private static Function<BigInteger, BigInteger> toSigned =
      value -> MAX_LONG.compareTo(value) < 0 ? value.subtract(HALF) : value;

  static BigInteger pair(BigInteger hi, BigInteger lo) {
    BigInteger unsignedLo = toUnsigned.apply(lo);
    BigInteger unsignedHi = toUnsigned.apply(hi);
    return unsignedLo.add(unsignedHi.multiply(HALF));
  }

  static BigInteger[] unpair(BigInteger value) {
    BigInteger[] parts = value.divideAndRemainder(HALF);
    BigInteger signedHi = toSigned.apply(parts[0]);
    BigInteger signedLo = toSigned.apply(parts[1]);
    return new BigInteger[] {signedHi, signedLo};
  }
}
