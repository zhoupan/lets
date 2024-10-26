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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ByteUtilsTest {

  @Test
  public void testGetLowerByteGetHighByteGetByte() {
    byte cmd = 0x10;
    byte cmdLower = ByteUtils.getLowerByte(cmd);
    byte cmdHigh = ByteUtils.getHighByte(cmd);
    assertEquals(0x00, cmdLower);
    assertEquals(0x10, cmdHigh);
    byte verify = (byte) 0xEF;
    byte verifyLower = ByteUtils.getLowerByte(verify);
    byte verifyHigh = ByteUtils.getHighByte(verify);
    assertEquals((byte) 0x0F, verifyLower);
    assertEquals((byte) 0xE0, verifyHigh);
    assertEquals(cmd, ByteUtils.getByte(cmdHigh, cmdLower));
    assertEquals(verify, ByteUtils.getByte(verifyHigh, verifyLower));
  }

  @Test
  public void testFromHexString() {
    assertArrayEquals(
        new byte[] {0x2B, 0x44, (byte) 0xEF, (byte) 0xD9}, ByteUtils.fromHexString("2B44EFD9"));
    assertArrayEquals(
        new byte[] {0x2B, 0x44, (byte) 0xEF, (byte) 0xD9}, ByteUtils.fromHexString("2B 44 EF D9"));
    assertArrayEquals(
        new byte[] {0x2B, 0x44, (byte) 0xEF, (byte) 0xD9},
        ByteUtils.fromHexString("0x2B 0x44 0xEF 0xD9"));
  }

  @Test
  public void testToHexString() {
    assertEquals("EF", ByteUtils.toHexString((byte) 0xEF));
  }

  @Test
  public void testToHexStringByteArray() {
    assertEquals("10EF", ByteUtils.toHexString(new byte[] {0x10, (byte) 0xEF}));
    assertEquals("10 EF", ByteUtils.toHexString(new byte[] {0x10, (byte) 0xEF}, " "));
  }

  @Test
  public void testToBinaryAndFromBinary1() {
    String bitString = "00000001";
    byte bit = ByteUtils.fromBinaryString(bitString);
    assertTrue(bit == 0x1);
    assertEquals(bitString, ByteUtils.toBinaryString(bit));
  }

  @Test
  public void testToBinaryAndFromBinary0() {
    String bitString = "00000000";
    byte bit = ByteUtils.fromBinaryString(bitString);
    assertTrue(bit == 0x0);
    assertEquals(bitString, ByteUtils.toBinaryString(bit));
  }
}
