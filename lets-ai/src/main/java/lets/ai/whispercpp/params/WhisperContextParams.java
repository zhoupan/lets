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

import com.sun.jna.*;
import java.util.Arrays;
import java.util.List;

/**
 * Parameters for the whisper_init_from_file_with_params() function. If you change the order or add
 * new parameters, make sure to update the default values in whisper.cpp:
 * whisper_context_default_params()
 */
public class WhisperContextParams extends Structure {

  public WhisperContextParams(Pointer p) {
    super(p);
  }

  /** Use GPU for inference Number (default = true) */
  public CBool use_gpu;

  /** Use GPU for inference Number (default = true) */
  public void useGpu(boolean enable) {
    use_gpu = enable ? CBool.TRUE : CBool.FALSE;
  }

  @Override
  protected List<String> getFieldOrder() {
    return Arrays.asList("use_gpu");
  }
}
