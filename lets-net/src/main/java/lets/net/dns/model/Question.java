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

public class Question {

  /** FQDN with trailing dot The record name requested */
  String name;

  /**
   * The type of DNS record requested. These are defined here:
   * https://www.iana.org/assignments/dns-parameters/dns-parameters.xhtml#dns-parameters-4
   *
   * <p>1 -> A - Standard DNS RR type 16 -> TXT - Standard DNS RR type 99 -> SPF - Standard DNS RR
   * type
   */
  String type;
}
