/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
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
package lets.javacpp;

import java.util.List;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.PointerPointer;

public class JavaCppUtils {

  /**
   * <code>
   * // cpp:
   * int &argc;
   * // java:
   * IntPointer argc;
   * </code>
   *
   * @param value
   * @return
   */
  public static IntPointer ByRef(int value) {
    return new IntPointer(new int[] {value});
  }

  /**
   * <code>
   * // cpp:
   * char *argv[];
   * // java:
   * PointerPointer argv;
   * </code>
   *
   * @param items
   * @return
   */
  public static PointerPointer CharPointerArray(String... items) {
    return new PointerPointer(items);
  }

  /**
   * <code>
   * // cpp:
   * char *argv[];
   * // java:
   * PointerPointer argv;
   * </code>
   *
   * @param items
   * @return
   */
  public static PointerPointer CharPointerArray(List<String> items) {
    String[] array = new String[items.size()];
    items.toArray(array);
    return new PointerPointer(array);
  }
}
