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
package lets.ai.whispercpp.model;

public class WhisperModel {
  //    EModel type = EModel.MODEL_UNKNOWN;
  //
  //    WhisperHParams hparams;
  //    WhisperFilters filters;
  //
  //    // encoder.positional_embedding
  //    GgmlTensor e_pe;
  //
  //    // encoder.conv1
  //    GgmlTensor e_conv_1_w;
  //    GgmlTensor e_conv_1_b;
  //
  //    // encoder.conv2
  //    GgmlTensor e_conv_2_w;
  //    GgmlTensor e_conv_2_b;
  //
  //    // encoder.ln_post
  //    GgmlTensor e_ln_w;
  //    GgmlTensor e_ln_b;
  //
  //    // decoder.positional_embedding
  //    GgmlTensor d_pe;
  //
  //    // decoder.token_embedding
  //    GgmlTensor d_te;
  //
  //    // decoder.ln
  //    GgmlTensor d_ln_w;
  //    GgmlTensor d_ln_b;
  //
  //    std::vector<whisper_layer_encoder> layers_encoder;
  //    std::vector<whisper_layer_decoder> layers_decoder;
  //
  //    // context
  //    struct ggml_context * ctx;
  //
  //    // the model memory buffer is read-only and can be shared between processors
  //    std::vector<uint8_t> * buf;
  //
  //    // tensors
  //    int n_loaded;
  //    Map<String, GgmlTensor> tensors;
}
