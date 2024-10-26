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
package lets.core.os;

import lets.core.function.InputOutputCallback;

/**
 * MultipleOperatingSystemFunction
 *
 * @author zhoupan
 * @param <Input> the generic type
 * @param <Output> the generic type
 */
public interface MultipleOperatingSystemFunction<Input, Output>
    extends InputOutputCallback<Input, Output> {

  /**
   * Callback.
   *
   * @param input the input
   * @return the output
   */
  default Output callback(Input input) {
    AbstractOperatingSystem os = OperatingSystem.getOperatingSystem();
    return callback(os, input);
  }

  /**
   * Callback.
   *
   * @param os the os
   * @param input the input
   * @return the output
   */
  Output callback(AbstractOperatingSystem os, Input input);
}
