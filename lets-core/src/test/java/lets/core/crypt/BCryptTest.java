/*
 * Copyright (c) 2021 zhoupan (https://github.com/zhoupan).
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
package lets.core.crypt;

import static org.junit.jupiter.api.Assertions.*;

import jodd.util.BCrypt;
import jodd.util.Base32;
import jodd.util.Base64;
import lets.core.LoggerSupport;
import org.junit.jupiter.api.Test;

/** BCryptTest. */
public class BCryptTest {

  /** Usecase. */
  @Test
  public void usecase() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      sb.append("1245678");
      this.usecaseBCrypt(sb.toString(), 4);
      this.usecaseBCrypt(sb.toString(), 10);
      this.usecaseBase32(sb.toString());
      this.usecaseBase64(sb.toString());
    }
  }

  /**
   * Usecase.
   *
   * @param plainPwd the plain pwd
   * @param saltLength the salt length
   */
  public void usecaseBCrypt(String plainPwd, int saltLength) {
    String hashPwd = BCrypt.hashpw(plainPwd, BCrypt.gensalt(saltLength));
    boolean checkPwd = BCrypt.checkpw(plainPwd, hashPwd);
    assertTrue(checkPwd);
    LoggerSupport.info(
        "BCrypt plainPwd={} saltLength={} hashPwd={} hashLength={}",
        plainPwd,
        saltLength,
        hashPwd,
        hashPwd.length());
  }

  /**
   * Usecase base 64.
   *
   * @param plainPwd the plain pwd
   */
  public void usecaseBase64(String plainPwd) {
    String hashPwd = Base64.encodeToString(plainPwd.getBytes());
    LoggerSupport.info(
        "Base64 plainPwd={} hashPwd={} hashLength={}", plainPwd, hashPwd, hashPwd.length());
  }

  /**
   * Usecase base 32.
   *
   * @param plainPwd the plain pwd
   */
  public void usecaseBase32(String plainPwd) {
    String hashPwd = Base32.encode(plainPwd.getBytes());
    LoggerSupport.info(
        "Base32 plainPwd={} hashPwd={} hashLength={}", plainPwd, hashPwd, hashPwd.length());
  }
}
