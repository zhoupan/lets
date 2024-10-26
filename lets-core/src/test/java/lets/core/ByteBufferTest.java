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

import java.nio.ByteBuffer;
import org.junit.jupiter.api.Test;

/** The Class ByteBufferTest. */
public class ByteBufferTest {

  /** Usecase. */
  @Test
  public void usecase() {
    // "下发指令RS485 （U11）" 0xBB bodySize mode data 0x44
    ByteBuffer buffer = ByteBuffer.allocate(5);
    buffer.put((byte) 0xBB);
    buffer.put((byte) 2);
    buffer.put((byte) 0);
    buffer.put((byte) 1);
    buffer.put((byte) 0x44);
    byte[] bytes = buffer.array();
    assertEquals((byte) 0xBB, bytes[0]);
    assertEquals((byte) 2, bytes[1]);
    assertEquals((byte) 0, bytes[2]);
    assertEquals((byte) 1, bytes[3]);
    assertEquals((byte) 0x44, bytes[4]);
    ByteBuffer wrapper = ByteBuffer.wrap(bytes);
    assertEquals(5, wrapper.remaining());
    assertEquals((byte) 0xBB, wrapper.get());
    assertEquals(4, wrapper.remaining());
    assertEquals((byte) 2, wrapper.get());
    assertEquals(3, wrapper.remaining());
    assertEquals((byte) 0, wrapper.get());
    assertEquals(2, wrapper.remaining());
    assertEquals((byte) 1, wrapper.get());
    assertEquals(1, wrapper.remaining());
    assertEquals((byte) 0x44, wrapper.get());
    assertEquals(0, wrapper.remaining());
    assertEquals((byte) 0xBB, wrapper.get(0));
    assertEquals((byte) 2, wrapper.get(1));
    assertEquals((byte) 0, wrapper.get(2));
    assertEquals((byte) 1, wrapper.get(3));
    assertEquals((byte) 0x44, wrapper.get(4));
    ByteBuffer sub = ByteBufferUtils.sub(buffer, 2, 2);
    assertEquals(2, sub.remaining());
    assertEquals((byte) 0, sub.get());
    assertEquals(1, sub.remaining());
    assertEquals((byte) 1, sub.get());
    assertEquals(0, sub.remaining());
  }
}
