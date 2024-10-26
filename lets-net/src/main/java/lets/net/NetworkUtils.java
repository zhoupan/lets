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
package lets.net;

import java.net.InetAddress;
import java.util.List;
import lets.core.DataResultSupport;
import lets.core.net.InetAddressUtils;
import lets.net.dns.DohLookupUtils;
import lets.net.dns.RequestSupplier;
import lets.net.dns.model.RequestMessage;
import org.xbill.DNS.Address;

public class NetworkUtils {
  public static DataResultSupport<InetAddress> getIPv4AddressForDomain(String domain) {
    DataResultSupport<InetAddress> result = new DataResultSupport<InetAddress>();
    try {
      InetAddress address = Address.getByName(domain);
      if (InetAddressUtils.isIPv4Address(address.getHostAddress())) {
        result.setData(address);
        return result;
      }
      // fallback DoH
      DataResultSupport<InetAddress> aliDoh = getIPv4AddressForDomainByAliDoh(domain);
      aliDoh.checkState();
      result.setData(aliDoh.getData());
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public static DataResultSupport<InetAddress> getIPv4AddressForDomainByDoh(
      RequestMessage req, String domain) {
    DataResultSupport<InetAddress> result = new DataResultSupport<InetAddress>();
    try {
      DataResultSupport<List<InetAddress>> lookup = DohLookupUtils.lookup(req, domain);
      lookup.checkState();
      result.setData(lookup.getData().get(0));
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public static DataResultSupport<InetAddress> getIPv4AddressForDomainByAliDoh(String domain) {
    return getIPv4AddressForDomainByDoh(RequestSupplier.ALIDNS, domain);
  }
}
