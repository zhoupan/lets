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

public class Response {
  /**
   * The Response Code of the DNS Query. These are defined here:
   * https://www.iana.org/assignments/dns-parameters/dns-parameters.xhtml#dns-parameters-6
   *
   * <p>0 -> NOERROR - Standard DNS response code (32 bit integer). 2 -> SERVFAIL - Standard DNS
   * response code (32 bit integer).
   */
  public int Status;

  /**
   * *Whether the response is truncated If true, it means the truncated bit was set. This happens
   * when the DNS answer is larger than a single UDP or TCP packet. TC will almost always be false
   * with Cloudflare DNS over HTTPS because Cloudflare supports the maximum response size.
   */
  public boolean TC;

  /**
   * Always true for Google Public DNS If true, it means the Recursive Desired bit was set. This is
   * always set to true for Cloudflare DNS over HTTPS.
   */
  public boolean RD;

  /**
   * Always true for Google Public DNS If true, it means the Recursion Available bit was set. This
   * is always set to true for Cloudflare DNS over HTTPS.
   */
  public boolean RA;

  /**
   * Whether all response data was validated with DNSSEC If true, it means that every record in the
   * answer was verified with DNSSEC.
   */
  public boolean AD;

  /**
   * Whether the client asked to disable DNSSEC If true, the client asked to disable DNSSEC
   * validation. In this case, Cloudflare will still fetch the DNSSEC-related records, but it will
   * not attempt to validate the records.
   */
  public boolean CD;

  // public Question Question[];
  public Answer Answer[];
  public String Additional[];

  /** IP address / scope prefix-length */
  public String edns_client_subnet;

  public String Comment;
}
