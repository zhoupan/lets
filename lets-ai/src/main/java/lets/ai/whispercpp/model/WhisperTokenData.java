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

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/** Structure representing token data. */
public class WhisperTokenData extends Structure {

  /** Token ID. */
  public int id;

  /** Forced timestamp token ID. */
  public int tid;

  /** Probability of the token. */
  public float p;

  /** Log probability of the token. */
  public float plog;

  /** Probability of the timestamp token. */
  public float pt;

  /** Sum of probabilities of all timestamp tokens. */
  public float ptsum;

  /**
   * Start time of the token (token-level timestamp data). Do not use if you haven't computed
   * token-level timestamps.
   */
  public long t0;

  /**
   * End time of the token (token-level timestamp data). Do not use if you haven't computed
   * token-level timestamps.
   */
  public long t1;

  /** Voice length of the token. */
  public float vlen;

  @Override
  protected List<String> getFieldOrder() {
    return Arrays.asList("id", "tid", "p", "plog", "pt", "ptsum", "t0", "t1", "vlen");
  }
}
