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

import lets.net.dns.model.RequestMessage;

public enum RequestSupplier implements RequestMessage {
  GOOGLE(
      "https://dns.google.com/resolve?",
      "dns.google.com",
      new byte[] {(byte) 216, (byte) 58, (byte) 205, (byte) 174},
      443,
      new String[] {"accept: application/dns-json", "Connection: keep-alive"},
      true),
  CLOUDFLARE(
      "https://cloudflare-dns.com/dns-query?",
      "cloudflare-dns.com",
      new byte[] {(byte) 1, (byte) 1, (byte) 1, (byte) 1},
      443,
      new String[] {"accept: application/dns-json", "Connection: keep-alive"},
      false),
  ALIDNS(
      "https://dns.alidns.com/resolve?",
      "dns.alidns.com",
      new byte[] {(byte) 223, (byte) 6, (byte) 6, (byte) 6},
      443,
      new String[] {"accept: application/dns-json", "Connection: keep-alive"},
      false);

  RequestSupplier(
      String url, String hostname, byte[] hostIP, int port, String[] headers, boolean close) {
    this.url = url;
    this.hostname = hostname;
    this.hostIP = hostIP;
    this.port = port;
    this.headers = headers;
    this.closeConnection = close;
  }

  private String url;
  private String hostname;
  private byte[] hostIP;
  private int port;
  private String[] headers;
  private boolean closeConnection;

  @Override
  public String getUrl() {
    return url;
  }

  @Override
  public String getHostName() {
    return hostname;
  }

  @Override
  public byte[] getHostIP() {
    return hostIP;
  }

  @Override
  public int getPort() {
    return port;
  }

  @Override
  public String[] getHeaders() {
    return headers;
  }

  @Override
  public boolean closeConnection() {
    return closeConnection;
  }
}
