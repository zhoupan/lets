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

public class Answer {

  /** Always matches name in the Question section */
  public String name;

  /**
   * A - Standard DNS RR type
   *
   * <p>The type of DNS record. These are defined here:
   * https://www.iana.org/assignments/dns-parameters/dns-parameters.xhtml#dns-parameters-4
   */
  public int type;

  /**
   * Record's time-to-live in seconds
   *
   * <p>The number of seconds the answer can be stored in cache before it is considered stale.
   */
  public int TTL;

  /**
   * Data for A - IP address as text
   *
   * <p>The value of the DNS record for the given name and type. The data will be in text for
   * standardized record types and in hex for unknown types.
   */
  public String data;
}
