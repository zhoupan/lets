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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ByteBitSetTest {
  @Test
  public void bitSet_00000001() {
    String binary = "00000001";
    int bitIndex = 0;
    boolean bitBoolean = true;
    ByteBitSet bitSet = new ByteBitSet();
    bitSet.set(bitIndex, bitBoolean);
    byte bitByte = bitSet.getValue();
    assertEquals(bitBoolean, bitSet.get(bitIndex));
    assertEquals(binary, bitSet.getBinaryString());
    assertEquals(binary, ByteUtils.toBinaryString(bitByte));

    ByteBitSet other = new ByteBitSet();
    other.setBinaryString(binary);
    assertEquals(binary, other.getBinaryString());
    assertEquals(bitBoolean, other.get(bitIndex));
    assertEquals(bitByte, other.getValue());

    assertEquals(bitSet, other);
  }

  @Test
  public void bitSet_00000010() {
    String binary = "00000010";
    int bitIndex = 1;
    boolean bitBoolean = true;
    ByteBitSet bitSet = new ByteBitSet();
    bitSet.set(bitIndex, bitBoolean);
    byte bitByte = bitSet.getValue();
    assertEquals(bitBoolean, bitSet.get(bitIndex));
    assertEquals(binary, bitSet.getBinaryString());
    assertEquals(binary, ByteUtils.toBinaryString(bitByte));

    ByteBitSet other = new ByteBitSet();
    other.setBinaryString(binary);
    assertEquals(binary, other.getBinaryString());
    assertEquals(bitBoolean, other.get(bitIndex));
    assertEquals(bitByte, other.getValue());

    assertEquals(bitSet, other);
  }

  @Test
  public void bitSet_00000100() {
    String binary = "00000100";
    int bitIndex = 2;
    boolean bitBoolean = true;
    ByteBitSet bitSet = new ByteBitSet();
    bitSet.set(bitIndex, bitBoolean);
    byte bitByte = bitSet.getValue();
    assertEquals(bitBoolean, bitSet.get(bitIndex));
    assertEquals(binary, bitSet.getBinaryString());
    assertEquals(binary, ByteUtils.toBinaryString(bitByte));

    ByteBitSet other = new ByteBitSet();
    other.setBinaryString(binary);
    assertEquals(binary, other.getBinaryString());
    assertEquals(bitBoolean, other.get(bitIndex));
    assertEquals(bitByte, other.getValue());

    assertEquals(bitSet, other);
  }

  @Test
  public void bitSet_00001000() {
    String binary = "00001000";
    int bitIndex = 3;
    boolean bitBoolean = true;
    ByteBitSet bitSet = new ByteBitSet();
    bitSet.set(bitIndex, bitBoolean);
    byte bitByte = bitSet.getValue();
    assertEquals(bitBoolean, bitSet.get(bitIndex));
    assertEquals(binary, bitSet.getBinaryString());
    assertEquals(binary, ByteUtils.toBinaryString(bitByte));

    ByteBitSet other = new ByteBitSet();
    other.setBinaryString(binary);
    assertEquals(binary, other.getBinaryString());
    assertEquals(bitBoolean, other.get(bitIndex));
    assertEquals(bitByte, other.getValue());

    assertEquals(bitSet, other);
  }

  @Test
  public void bitSet_00010000() {
    String binary = "00010000";
    int bitIndex = 4;
    boolean bitBoolean = true;
    ByteBitSet bitSet = new ByteBitSet();
    bitSet.set(bitIndex, bitBoolean);
    byte bitByte = bitSet.getValue();
    assertEquals(bitBoolean, bitSet.get(bitIndex));
    assertEquals(binary, bitSet.getBinaryString());
    assertEquals(binary, ByteUtils.toBinaryString(bitByte));

    ByteBitSet other = new ByteBitSet();
    other.setBinaryString(binary);
    assertEquals(binary, other.getBinaryString());
    assertEquals(bitBoolean, other.get(bitIndex));
    assertEquals(bitByte, other.getValue());

    assertEquals(bitSet, other);
  }

  @Test
  public void bitSet_00100000() {
    String binary = "00100000";
    int bitIndex = 5;
    boolean bitBoolean = true;
    ByteBitSet bitSet = new ByteBitSet();
    bitSet.set(bitIndex, bitBoolean);
    byte bitByte = bitSet.getValue();
    assertEquals(bitBoolean, bitSet.get(bitIndex));
    assertEquals(binary, bitSet.getBinaryString());
    assertEquals(binary, ByteUtils.toBinaryString(bitByte));

    ByteBitSet other = new ByteBitSet();
    other.setBinaryString(binary);
    assertEquals(binary, other.getBinaryString());
    assertEquals(bitBoolean, other.get(bitIndex));
    assertEquals(bitByte, other.getValue());

    assertEquals(bitSet, other);
  }

  @Test
  public void bitSet_01000000() {
    String binary = "01000000";
    int bitIndex = 6;
    boolean bitBoolean = true;
    ByteBitSet bitSet = new ByteBitSet();
    bitSet.set(bitIndex, bitBoolean);
    byte bitByte = bitSet.getValue();
    assertEquals(bitBoolean, bitSet.get(bitIndex));
    assertEquals(binary, bitSet.getBinaryString());
    assertEquals(binary, ByteUtils.toBinaryString(bitByte));

    ByteBitSet other = new ByteBitSet();
    other.setBinaryString(binary);
    assertEquals(binary, other.getBinaryString());
    assertEquals(bitBoolean, other.get(bitIndex));
    assertEquals(bitByte, other.getValue());

    assertEquals(bitSet, other);
  }

  @Test
  public void bitSet_10000000() {
    String binary = "10000000";
    int bitIndex = 7;
    boolean bitBoolean = true;
    ByteBitSet bitSet = new ByteBitSet();
    bitSet.set(bitIndex, bitBoolean);
    byte bitByte = bitSet.getValue();
    assertEquals(bitBoolean, bitSet.get(bitIndex));
    assertEquals(binary, bitSet.getBinaryString());
    assertEquals(binary, ByteUtils.toBinaryString(bitByte));
    LoggerSupport.info("binary:{} hex:{}", bitSet.getBinaryString(), bitSet.getHexString());
    ByteBitSet other = new ByteBitSet();
    other.setBinaryString(binary);
    assertEquals(binary, other.getBinaryString());
    assertEquals(bitBoolean, other.get(bitIndex));
    assertEquals(bitByte, other.getValue());

    assertEquals(bitSet, other);

    bitSet.set(bitIndex, false);
    bitByte = bitSet.getValue();
    LoggerSupport.info("binary:{} hex:{}", bitSet.getBinaryString(), bitSet.getHexString());
    assertEquals(false, bitSet.get(bitIndex));
    assertEquals("00000000", bitSet.getBinaryString());
    assertEquals("00000000", ByteUtils.toBinaryString(bitByte));
  }
}
