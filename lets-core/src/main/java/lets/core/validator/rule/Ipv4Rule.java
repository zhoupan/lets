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
package lets.core.validator.rule;

import lets.core.RegExUtils;
import lets.core.validator.Rule;

/**
 * Ipv4Rule.
 *
 * @author zhoupan
 */
@Rule(name = "Ipv4Rule", message = "请输入有效的ip地址")
public class Ipv4Rule extends RegExRule {

  /** Instantiates a new ipv 4. */
  public Ipv4Rule() {
    super();
    this.withRegex(RegExUtils.REGEX_IPV4_ADDRESS);
  }
}
