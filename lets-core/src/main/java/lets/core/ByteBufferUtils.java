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

import java.nio.ByteBuffer;

/**
 * ByteBufferUtils.
 *
 * @author zhoupan
 */
public class ByteBufferUtils {

  /**
   * Allocate.
   *
   * @param capacity the capacity
   * @param direct the direct
   * @return the byte buffer
   */
  public static ByteBuffer allocate(final int capacity, final boolean direct) {
    return direct ? ByteBuffer.allocateDirect(capacity) : ByteBuffer.allocate(capacity);
  }

  /**
   * Wrap.
   *
   * @param binary the binary
   * @return the byte buffer
   */
  public static ByteBuffer wrap(final byte[] binary) {
    return (binary == null) ? null : ByteBuffer.wrap(binary);
  }

  /**
   * Sub.
   *
   * @param byteBuffer the byte buffer
   * @param offset the offset
   * @param length the length
   * @return the byte buffer
   */
  public static ByteBuffer sub(final ByteBuffer byteBuffer, int offset, int length) {
    byte[] bytes = byteBuffer.array();
    byte[] sub = ArrayUtils.subarray(bytes, offset, offset + length);
    return ByteBuffer.wrap(sub);
  }
}
