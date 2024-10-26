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
package lets.core.crypto;

/**
 * BCryptPasswordEncoder.
 *
 * @author zhoupan
 */
public class BCryptPasswordEncoder implements PasswordEncoder {

  /** The log rounds. */
  private int logRounds = 10;

  /**
   * Gets the log rounds.
   *
   * @return the log rounds
   */
  public int getLogRounds() {
    return logRounds;
  }

  /**
   * Sets the log rounds.
   *
   * @param logRounds the new log rounds
   */
  public void setLogRounds(int logRounds) {
    this.logRounds = logRounds;
  }

  /**
   * Encode.
   *
   * @param rawPassword the raw password
   * @return the string
   */
  @Override
  public String encode(CharSequence rawPassword) {
    return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(this.logRounds));
  }

  /**
   * Matches.
   *
   * @param rawPassword the raw password
   * @param encodedPassword the encoded password
   * @return true, if successful
   */
  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
  }
}
