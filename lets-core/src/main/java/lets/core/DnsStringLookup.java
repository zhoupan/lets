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
package lets.core;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Looks up keys related to DNS entries like host name, canonical host name, host address.
 *
 * <p>The lookup keys are:
 *
 * <ul>
 *   <li><b>name|<em>address</em></b>: for the host name, for example {@code "name|93.184.216.34"}
 *       -> {@code "example.com"}.
 *   <li><b>canonical-name|<em>address</em></b>: for the canonical host name, for example {@code
 *       "name|93.184.216.34"} -> {@code "example.com"}.
 *   <li><b>address|<em>hostname</em></b>: for the host address, for example {@code
 *       "address|example.com"} -> {@code "93.184.216.34"}.
 *   <li><b><em>address</em></b>: same as {@code address|hostname}.
 * </ul>
 *
 * <p>Using a {@link StringLookup} from the {@link StringLookupFactory}:
 *
 * <pre>
 * StringLookupFactory.INSTANCE.dnsStringLookup().lookup("address|apache.org");
 * </pre>
 *
 * <p>Using a {@link StringSubstitutor}:
 *
 * <pre>
 * StringSubstitutor.createInterpolator().replace("... ${dns:address|apache.org} ..."));
 * </pre>
 *
 * <p>The above examples convert {@code "address|apache.org"} to {@code "95.216.24.32} (or {@code
 * "40.79.78.1"}).
 *
 * @since 1.8
 */
final class DnsStringLookup extends AbstractStringLookup {

  /** Defines the singleton for this class. */
  static final DnsStringLookup INSTANCE = new DnsStringLookup();

  /** No need to build instances for now. */
  private DnsStringLookup() {
    // empty
  }

  /**
   * Looks up the DNS value of the key.
   *
   * @param key the key to be looked up, may be null
   * @return The DNS value.
   */
  @Override
  public String lookup(final String key) {
    if (key == null) {
      return null;
    }
    final String[] keys = key.trim().split("\\|");
    final int keyLen = keys.length;
    final String subKey = keys[0].trim();
    final String subValue = keyLen < 2 ? key : keys[1].trim();
    try {
      final InetAddress inetAddress = InetAddress.getByName(subValue);
      switch (subKey) {
        case InetAddressKeys.KEY_NAME:
          return inetAddress.getHostName();
        case InetAddressKeys.KEY_CANONICAL_NAME:
          return inetAddress.getCanonicalHostName();
        case InetAddressKeys.KEY_ADDRESS:
          return inetAddress.getHostAddress();
        default:
          return inetAddress.getHostAddress();
      }
    } catch (final UnknownHostException e) {
      return null;
    }
  }
}
