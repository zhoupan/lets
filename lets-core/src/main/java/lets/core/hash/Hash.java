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
package lets.core.hash;

import lets.core.codec.binary.Hex;

/**
 * Hash值.
 *
 * @author zhoupan
 */
public class Hash {

  /** The algorithm. */
  protected final String algorithm;

  /** The value. */
  protected final byte[] value;

  /** The value hex string. */
  protected final String valueHexString;

  /**
   * Instantiates a new hash.
   *
   * @param algorithm the algorithm
   * @param value the value
   */
  public Hash(String algorithm, byte[] value) {
    super();
    this.algorithm = algorithm;
    this.value = value;
    this.valueHexString = Hex.encodeHexString(this.value);
  }

  /**
   * Gets the algorithm.
   *
   * @return the algorithm
   */
  public String getAlgorithm() {
    return algorithm;
  }

  /**
   * Gets the value.
   *
   * @return the value
   */
  public byte[] getValue() {
    return value;
  }

  /**
   * Gets the value hex string.
   *
   * @return the value hex string
   */
  public String getValueHexString() {
    return valueHexString;
  }
}
