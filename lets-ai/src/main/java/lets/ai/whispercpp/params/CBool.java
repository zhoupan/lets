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
package lets.ai.whispercpp.params;

import com.sun.jna.IntegerType;
import java.util.function.BooleanSupplier;

public class CBool extends IntegerType implements BooleanSupplier {
  public static final int SIZE = 1;
  public static final CBool FALSE = new CBool(0);
  public static final CBool TRUE = new CBool(1);

  public CBool() {
    this(0);
  }

  public CBool(long value) {
    super(SIZE, value, true);
  }

  @Override
  public boolean getAsBoolean() {
    return intValue() == 1;
  }

  @Override
  public String toString() {
    return intValue() == 1 ? "true" : "false";
  }
}
