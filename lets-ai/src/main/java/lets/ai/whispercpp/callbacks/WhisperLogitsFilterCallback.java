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
package lets.ai.whispercpp.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import lets.ai.whispercpp.model.WhisperTokenData;

/**
 * Callback to filter logits. Can be used to modify the logits before sampling. If not null, called
 * after applying temperature to logits.
 */
public interface WhisperLogitsFilterCallback extends Callback {

  /**
   * Callback method to filter logits.
   *
   * @param ctx The whisper context.
   * @param state The whisper state.
   * @param tokens The array of whisper_token_data.
   * @param n_tokens The number of tokens.
   * @param logits The array of logits.
   * @param user_data User data.
   */
  void callback(
      Pointer ctx,
      Pointer state,
      WhisperTokenData[] tokens,
      int n_tokens,
      float[] logits,
      Pointer user_data);
}
