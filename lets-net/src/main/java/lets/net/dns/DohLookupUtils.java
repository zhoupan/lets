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
import java.util.ArrayList;
import java.util.List;
import lets.core.CoreUtils;
import lets.core.DataResultSupport;
import lets.core.collections.CollectionUtils;
import lets.net.dns.model.RequestMessage;

public class DohLookupUtils {

  public static void main(String[] args) {
    DataResultSupport<List<InetAddress>> lookup = lookup(RequestSupplier.ALIDNS, "google.com");
    if (lookup.isSuccess()) {
      System.out.println(
          String.format("%s %s", lookup.getData().get(0).getHostAddress(), "google.com"));
    }
    lookup = lookup(RequestSupplier.ALIDNS, "facebook.com");
    if (lookup.isSuccess()) {
      System.out.println(
          String.format("%s %s", lookup.getData().get(0).getHostAddress(), "facebook.com"));
    }
  }

  public static DataResultSupport<DohLookup> of(RequestMessage req) {
    DataResultSupport<DohLookup> result = new DataResultSupport<DohLookup>();
    try {
      DohBuilderFactory factory = DohBuilderFactory.newInstance();
      factory.useRequestMessage(req);
      result.setData(factory.getBuilder().build());
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public static DataResultSupport<List<InetAddress>> lookup(DohLookup lookup, String domain) {
    DataResultSupport<List<InetAddress>> result = new DataResultSupport<List<InetAddress>>();
    try {
      List<InetAddress> list = new ArrayList<InetAddress>();
      InetAddress[] items = lookup.lookupAllHostAddr(domain);
      for (InetAddress item : items) {
        list.add(item);
      }
      CoreUtils.checkState(CollectionUtils.isNotEmpty(list), "No InetAddress Founded.");
      result.setData(list);
      return result;
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public static DataResultSupport<List<InetAddress>> lookup(RequestMessage req, String domain) {
    DataResultSupport<List<InetAddress>> result = new DataResultSupport<List<InetAddress>>();
    try {
      DataResultSupport<DohLookup> of = of(req);
      of.checkState();
      return lookup(of.getData(), domain);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public static DataResultSupport<List<InetAddress>> lookup(String domain) {
    DataResultSupport<List<InetAddress>> result = new DataResultSupport<List<InetAddress>>();
    try {

    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
