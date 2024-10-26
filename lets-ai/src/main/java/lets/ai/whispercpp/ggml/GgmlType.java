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
package lets.ai.whispercpp.ggml;

public enum GgmlType {
  GGML_TYPE_F32,
  GGML_TYPE_F16,
  GGML_TYPE_Q4_0,
  GGML_TYPE_Q4_1,
  REMOVED_GGML_TYPE_Q4_2, // support has been removed
  REMOVED_GGML_TYPE_Q4_3, // support has been removed
  GGML_TYPE_Q5_0,
  GGML_TYPE_Q5_1,
  GGML_TYPE_Q8_0,
  GGML_TYPE_Q8_1,
  GGML_TYPE_I8,
  GGML_TYPE_I16,
  GGML_TYPE_I32,
  GGML_TYPE_COUNT,
}
