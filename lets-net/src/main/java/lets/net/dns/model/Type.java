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
package lets.net.dns.model;

/**
 * RR type can be represented as a number in [1, 65535] or a canonical string (case-insensitive,
 * such as A or aaaa). You can use 255 for 'ANY' queries but be aware that this is not a replacement
 * for sending queries for both A and AAAA or MX records. Authoritative name servers need not return
 * all records for such queries; some do not respond, and others (such as cloudflare.com) return
 * only HINFO.
 *
 * <p>0 0x0000 RRTYPE zero is used as a special indicator for the SIG RR [RFC2931], [RFC4034] and in
 * other circumstances and must never be allocated for ordinary use.
 *
 * <p>1-127 0x0000-0x007F Expert Review (see mailing list information in [RFC6895]) or Standards
 * Action data TYPEs
 *
 * <p>128-255 0x0080-0x00FF Expert Review (see mailing list information in [RFC6895]) or Standards
 * Action Q TYPEs, Meta TYPEs
 *
 * <p>256-61439 0x0100-0xEFFF Expert Review (see mailing list information in [RFC6895]) or Standards
 * Action data RRTYPEs
 *
 * <p>61440-65279 0xF000-0xFEFF Reserved for future use (IETF Review required to define use)
 *
 * <p>65280-65534 0xFF00-0xFFFE Reserved for Private Use 65535 0xFFFF Reserved (Standards Action)
 *
 * @author salem
 */
public enum Type {
  /** IPv4 */
  A(1),

  /** IPv6 */
  AAAA(28),

  /**
   * You can use 255 for 'ANY' queries but be aware that this is not a replacement for sending
   * queries for both A and AAAA or MX records.
   */
  ANY(255);

  int code;

  private Type(int code) {
    this.code = code;
  }

  public static Type Resolve(int code) {
    switch (code) {
      case 1:
        return Type.A;
      case 28:
        return Type.AAAA;
      case 255:
      default:
        return Type.ANY;
    }
  }

  @Override
  public String toString() {
    return name();
  }
}
