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
package lets.ai.whispercpp;

import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import lets.ai.whispercpp.ggml.GgmlType;
import lets.ai.whispercpp.params.WhisperContextParams;

public class WhisperContext extends Structure {
  int t_load_us = 0;
  int t_start_us = 0;

  /** weight type (FP32 / FP16 / QX) */
  GgmlType wtype = GgmlType.GGML_TYPE_F16;

  /** intermediate type (FP32 or FP16) */
  GgmlType itype = GgmlType.GGML_TYPE_F16;

  //    WhisperModel model;
  public PointerByReference model;
  //    whisper_vocab vocab;
  //    whisper_state * state = nullptr;
  public PointerByReference vocab;
  public PointerByReference state;

  /** populated by whisper_init_from_file_with_params() */
  String path_model;

  WhisperContextParams params;

  //    public static class ByReference extends WhisperContext implements Structure.ByReference {
  //    }
  //
  //    public static class ByValue extends WhisperContext implements Structure.ByValue {
  //    }
  //
  //    @Override
  //    protected List<String> getFieldOrder() {
  //        return List.of("t_load_us", "t_start_us", "wtype", "itype", "model", "vocab", "state",
  // "path_model");
  //    }
}
