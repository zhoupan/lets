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

/**
 * Callback for the text segment. Called on every newly generated text segment. Use the
 * whisper_full_...() functions to obtain the text segments.
 */
public interface WhisperNewSegmentCallback extends Callback {

  /**
   * Callback method for the text segment.
   *
   * @param ctx The whisper context.
   * @param state The whisper state.
   * @param n_new The number of newly generated text segments.
   * @param user_data User data.
   */
  void callback(Pointer ctx, Pointer state, int n_new, Pointer user_data);
}
