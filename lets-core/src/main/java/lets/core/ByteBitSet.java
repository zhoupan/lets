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
package lets.core;

import java.util.BitSet;

/**
 * Byte位操作支持类.
 *
 * @author zhoupan
 */
public class ByteBitSet {

  /** The bit set. */
  protected BitSet bitSet = new BitSet(ByteUtils.BYTE_BITS);

  /**
   * With.
   *
   * @param other the other
   * @return the byte bit set
   */
  public ByteBitSet with(ByteBitSet other) {
    this.setBinaryString(other.getBinaryString());
    return this;
  }

  /**
   * Gets the binary string.
   *
   * @return the binary string
   */
  public String getBinaryString() {
    StringBuilder sb = new StringBuilder();
    for (int bit = ByteUtils.BYTE_BITS - 1; bit > -1; bit--) {
      sb.append(this.bitSet.get(bit) ? "1" : "0");
    }
    return sb.toString();
  }

  /**
   * Gets the hex string.
   *
   * @return the hex string
   */
  public String getHexString() {
    return ByteUtils.toHexString(this.bitSet.toByteArray());
  }

  /**
   * Sets the binary string.
   *
   * @param binaryString the new binary string
   */
  public void setBinaryString(String binaryString) {
    this.setValue(ByteUtils.fromBinaryString(binaryString));
  }

  /** The value. */
  protected byte value = 0x00;

  /**
   * Gets the value.
   *
   * @return the value
   */
  public byte getValue() {
    byte[] bytes = this.bitSet.toByteArray();
    if ((bytes != null) && (bytes.length == 1)) {
      this.value = bytes[0];
    } else {
      this.value = 0;
    }
    return value;
  }

  /**
   * Sets the value.
   *
   * @param value the new value
   */
  public void setValue(byte value) {
    this.bitSet.clear();
    String binaryString = StringUtils.reverse(ByteUtils.toBinaryString(value));
    int length = binaryString.length();
    for (int bitIndex = 0; bitIndex < length; bitIndex++) {
      char bitChar = binaryString.charAt(bitIndex);
      if (bitChar == '1') {
        bitSet.set(bitIndex, true);
      }
    }
    this.value = value;
  }

  /**
   * Sets the.
   *
   * @param bitIndex the bit index
   * @param value the value
   */
  public void set(int bitIndex, boolean value) {
    this.bitSet.set(bitIndex, value);
  }

  /**
   * Gets the.
   *
   * @param bitIndex the bit index
   * @return true, if successful
   */
  public boolean get(int bitIndex) {
    return this.bitSet.get(bitIndex);
  }

  /** Clean. */
  public void clean() {
    this.bitSet.clear();
  }

  /**
   * Hash code.
   *
   * @return the int
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((bitSet == null) ? 0 : bitSet.hashCode());
    return result;
  }

  /**
   * Equals.
   *
   * @param obj the obj
   * @return true, if successful
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    ByteBitSet other = (ByteBitSet) obj;
    if (bitSet == null) {
      if (other.bitSet != null) {
        return false;
      }
    } else if (!bitSet.equals(other.bitSet)) {
      return false;
    }
    return true;
  }
}
