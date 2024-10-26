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
 * ByteUtils.
 *
 * @author zhoupan.
 */
public class ByteUtils {

  /** 一个字节8位. */
  public static final int BYTE_BITS = 8;

  /**
   * Unsigned.
   *
   * @param value the value
   * @return the int
   */
  public static int unsigned(byte value) {
    return value & 0xFF;
  }

  /**
   * 低半字节.
   *
   * @param value the value
   * @return the lower byte
   */
  public static byte getLowerByte(byte value) {
    return (byte) (value & 0x0f);
  }

  /**
   * 高半字节.
   *
   * @param value the value
   * @return the high byte
   */
  public static byte getHighByte(byte value) {
    return (byte) (value & 0xf0);
  }

  /**
   * 根据高半字节、低半字节返回整个字节.
   *
   * @param high 高半字节
   * @param low 低半字节
   * @return the byte
   */
  public static byte getByte(byte high, byte low) {
    return (byte) (0xF0 & high | 0x0F & low);
  }

  /**
   * 将指定字符串hexString，以每两个字符分割转换为16进制形式 如： <code>
   * fromHexString("2B44EFD9")={0x2B, 0x44, 0xEF, 0xD9}.
   * fromHexString("2B 44 EF D9")={0x2B, 0x44, 0xEF, 0xD9}.
   * fromHexString("0x2B 0x44 0xEF 0xD9")={0x2B, 0x44, 0xEF, 0xD9}.
   * </code>
   *
   * @param hexString String .例如:"2B44EFD9"
   * @return byte[] 例如:byte[]{0x2B, 0x44, 0xEF, 0xD9}
   */
  public static byte[] fromHexString(String hexString) {
    // 替换掉空格,0x
    hexString =
        StringUtils.replaceEach(hexString, new String[] {" ", "0x"}, new String[] {"", ""})
            .toUpperCase();
    int size = hexString.length() / 2;
    byte[] bytes = new byte[size];
    byte[] tmp = hexString.getBytes();
    for (int i = 0; i < size; i++) {
      bytes[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
    }
    return bytes;
  }

  /**
   * 将两个ASCII字符合成一个字节； 如："EF"--> 0xEF.
   *
   * @param left byte 例如: 0xE
   * @param right byte 例如: 0xF
   * @return byte 例如: 0xEF
   */
  private static byte uniteBytes(byte left, byte right) {
    byte leftByte = Byte.decode("0x" + new String(new byte[] {left})).byteValue();
    leftByte = (byte) (leftByte << 4);
    byte rightByte = Byte.decode("0x" + new String(new byte[] {right})).byteValue();
    byte result = (byte) (leftByte ^ rightByte);
    return result;
  }

  /**
   * To hex string.
   *
   * @param data the data
   * @return the string
   */
  public static String toHexString(byte data) {
    String hex = Integer.toHexString(data & 0xFF);
    if (hex.length() == 1) {
      hex = '0' + hex;
    }
    return hex.toUpperCase();
  }

  /**
   * Hex dump.
   *
   * @param data the data
   * @return the string
   */
  public static String toHexString(byte[] data) {
    return toHexString(data, "");
  }

  /**
   * Hex dump.
   *
   * @param data the data
   * @param separator the separator
   * @return the string
   */
  public static String toHexString(byte[] data, String separator) {
    StringBuilder sb = new StringBuilder();
    if (data != null) {
      for (int i = 0; i < data.length; i++) {
        String hex = Integer.toHexString(data[i] & 0xFF);
        if (hex.length() == 1) {
          hex = '0' + hex;
        }
        if (separator != null && i > 0) {
          sb.append(separator);
        }
        sb.append(hex.toUpperCase());
      }
    }
    return sb.toString();
  }

  /**
   * To binary string.
   *
   * @param data the data
   * @return the string
   */
  public static String toBinaryString(byte data) {
    return toBinaryString(new byte[] {data});
  }

  /**
   * To binary string.
   *
   * @param data the data
   * @return the string
   */
  public static String toBinaryString(byte[] data) {
    return toBinaryString(data, "");
  }

  /**
   * To binary string.
   *
   * @param data the data
   * @param separator the separator
   * @return the string
   */
  public static String toBinaryString(byte[] data, String separator) {
    StringBuilder sb = new StringBuilder();
    if (data != null) {
      for (int i = 0; i < data.length; i++) {
        String binary = Integer.toBinaryString(data[i] & 0xFF);
        // 补齐零
        if (binary.length() < BYTE_BITS) {
          sb.append(StringUtils.repeat('0', BYTE_BITS - binary.length()));
        }
        sb.append(binary);
        if (separator != null && i > 0) {
          sb.append(separator);
        }
      }
    }
    return sb.toString();
  }

  /**
   * From binary string.
   *
   * @param binaryString the binary string
   * @return the byte
   */
  public static byte fromBinaryString(String binaryString) {
    int bitSize = StringUtils.length(binaryString);
    CoreUtils.checkState(bitSize == BYTE_BITS, "binaryString长度必须是%s", BYTE_BITS);
    BitSet bitSet = new BitSet(BYTE_BITS);
    // 位数顺序是从右往左,反转一下,简化逻辑
    binaryString = StringUtils.reverse(binaryString);
    // 依次设置每位的状态
    for (int bitIndex = 0; bitIndex < bitSize; bitIndex++) {
      char bitChar = binaryString.charAt(bitIndex);
      CoreUtils.checkState(bitChar == '0' || bitChar == '1', "binaryString只允许出现0或者1.");
      if (bitChar == '1') {
        bitSet.set(bitIndex, true);
      }
    }
    // 转换成byte
    byte[] bytes = bitSet.toByteArray();
    if (bytes != null && bytes.length > 0) {
      return bytes[0];
    } else {
      return 0;
    }
  }
}
