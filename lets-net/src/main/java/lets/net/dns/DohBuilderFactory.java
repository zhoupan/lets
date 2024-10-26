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
package lets.net.dns;

import java.net.InetAddress;
import java.util.*;
import lets.net.dns.model.RequestMessage;

public class DohBuilderFactory {

  private static final Map<String, LinkedList<InetAddress>> DNS_CACHE = new HashMap<>();

  public static DohBuilderFactory newInstance() {
    return new DohBuilderFactory(new DohBuilder(DNS_CACHE));
  }

  private DohBuilder builder;

  private DohBuilderFactory(DohBuilder builder) {
    this.builder = builder;
  }

  public DohBuilder getBuilder() {
    return builder;
  }

  public void useCloudflarDOH() {
    this.builder.setRequestMessage(RequestSupplier.CLOUDFLARE);
  }

  public void useGoogleDOH() {
    this.builder.setRequestMessage(RequestSupplier.GOOGLE);
  }

  public void useAliDOH() {
    this.builder.setRequestMessage(RequestSupplier.ALIDNS);
  }

  public void useRequestMessage(RequestMessage message) {
    this.builder.setRequestMessage(message);
  }
}
