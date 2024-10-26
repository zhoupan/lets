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

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class BeamSearchParams extends Structure {
  /**
   * ref: <a
   * href="https://github.com/openai/whisper/blob/f82bc59f5ea234d4b97fb2860842ed38519f7e65/whisper/transcribe.py#L265">...</a>
   */
  public int beam_size;

  /** ref: <a href="https://arxiv.org/pdf/2204.05424.pdf">...</a> */
  public float patience;

  @Override
  protected List<String> getFieldOrder() {
    return Arrays.asList("beam_size", "patience");
  }
}
