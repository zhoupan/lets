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
package lets.core.net;

import java.net.InetSocketAddress;
import java.net.Socket;
import lets.core.ResultSupport;
import lets.core.io.IOUtils;

/**
 * NetworkUtils.
 *
 * @author zhoupan
 */
public class NetUtils {

  /**
   * Check connection.
   *
   * @param ip the ip
   * @param port the port
   * @param timeout the timeout
   * @return true, if successful
   */
  public static ResultSupport checkConnection(String ip, int port, int timeout) {
    ResultSupport result = new ResultSupport();
    Socket socket = null;
    try {
      socket = new Socket();
      socket.connect(new InetSocketAddress(ip, port), timeout);
      result.setSuccess(socket.isConnected() && !socket.isClosed());
    } catch (Exception e) {
      result.onException(e);
    } finally {
      IOUtils.closeQuietly(socket);
    }
    return result;
  }
}
