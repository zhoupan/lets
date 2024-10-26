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
package lets.core.hash;

/**
 * SHA-1 SHA-224 SHA-256 SHA-384 SHA-512 MD5 MD2.
 *
 * @author zhoupan
 */
public enum HashType {

  /** sha1. */
  SHA1("SHA-1", 0x8004, "SHA1", 20, "HmacSHA1", false),
  /** sha224. */
  SHA224("SHA-224", -1, "SHA224", 28, "HmacSHA224", true),
  /** sha256. */
  SHA256("SHA-256", 0x800C, "SHA256", 32, "HmacSHA256", false),
  /** sha384. */
  SHA384("SHA-384", 0x800D, "SHA384", 48, "HmacSHA384", false),
  /** sha512. */
  SHA512("SHA-512", 0x800E, "SHA512", 64, "HmacSHA512", false),
  /** md5. */
  MD5("MD5", -1, "MD5", 16, "HmacMD5", false),
  /** md2. */
  MD2("MD2", -1, "MD2", 16, "Hmac-MD2", true);

  /** The jce id. */
  public final String jceId;

  /** The ecma id. */
  public final int ecmaId;

  /** The ecma string. */
  public final String ecmaString;

  /** The hash size. */
  public final int hashSize;

  /** The jce hmac id. */
  public final String jceHmacId;

  /** The needs bouncy castle. */
  public final boolean needsBouncyCastle;

  /**
   * Instantiates a new hash algorithm.
   *
   * @param jceId the jce id
   * @param ecmaId the ecma id
   * @param ecmaString the ecma string
   * @param hashSize the hash size
   * @param jceHmacId the jce hmac id
   * @param needsBouncyCastle the needs bouncy castle
   */
  HashType(
      String jceId,
      int ecmaId,
      String ecmaString,
      int hashSize,
      String jceHmacId,
      boolean needsBouncyCastle) {
    this.jceId = jceId;
    this.ecmaId = ecmaId;
    this.ecmaString = ecmaString;
    this.hashSize = hashSize;
    this.jceHmacId = jceHmacId;
    this.needsBouncyCastle = needsBouncyCastle;
  }

  /**
   * From ecma id.
   *
   * @param ecmaId the ecma id
   * @return the hash algorithm
   */
  public static HashType fromEcmaId(int ecmaId) {
    for (HashType ha : values()) {
      if (ha.ecmaId == ecmaId) return ha;
    }
    throw new RuntimeException("hash algorithm not found");
  }

  /**
   * From ecma id.
   *
   * @param ecmaString the ecma string
   * @return the hash algorithm
   */
  public static HashType fromEcmaId(String ecmaString) {
    for (HashType ha : values()) {
      if (ha.ecmaString.equals(ecmaString)) return ha;
    }
    throw new RuntimeException("hash algorithm not found '" + ecmaString + "'");
  }

  /**
   * From string.
   *
   * @param string the string
   * @return the hash algorithm
   */
  public static HashType fromString(String string) {
    for (HashType ha : values()) {
      if (ha.ecmaString.equalsIgnoreCase(string) || ha.jceId.equalsIgnoreCase(string)) return ha;
    }
    throw new RuntimeException("hash algorithm not found '" + string + "'");
  }
}
