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

import java.io.File;
import java.io.FilenameFilter;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Pattern;
import lets.core.DataResultSupport;
import lets.core.PatternUtils;
import lets.core.RegExUtils;
import lets.core.io.FileUtils;
import lets.core.io.FilenameUtils;
import lets.core.io.filefilter.WildcardFileFilter;
import org.junit.jupiter.api.Test;

public class NetworkUtilsTest {
  @Test
  public void findDomainInFile() {
    Pattern p = Pattern.compile(RegExUtils.REGEX_DOMAIN_MULTIPLE);
    File dir =
        new File("e:\\github\\DomainVPN\\FastVPN20241023\\fastvpn-serverListTCP-all-20241023\\");
    File[] files = dir.listFiles((FilenameFilter) new WildcardFileFilter("*.ovpn"));
    StringBuilder full = new StringBuilder();
    File fullFile = new File(dir, "full.txt");
    for (File file : files) {
      File txtFile = new File(dir, FilenameUtils.getBaseName(file.getName()) + ".txt");
      StringBuilder sb = new StringBuilder();
      sb.append("#").append(FilenameUtils.getBaseName(file.getName()));
      sb.append("\n");
      DataResultSupport<List<String>> find = PatternUtils.find(file, StandardCharsets.UTF_8, p);
      if (!find.isSuccess()) {
        continue;
      }
      for (String domain : find.getData()) {
        DataResultSupport<InetAddress> address = NetworkUtils.getIPv4AddressForDomain(domain);
        if (!address.isSuccess()) {
          continue;
        }
        sb.append(address.getData().getHostAddress());
        sb.append(" ");
        sb.append(domain);
        sb.append("\n");
      }
      full.append(sb.toString());
      full.append("\n");
      try {
        FileUtils.writeStringToFile(txtFile, sb.toString(), StandardCharsets.UTF_8);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }

    try {
      FileUtils.writeStringToFile(fullFile, full.toString(), StandardCharsets.UTF_8);
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }
}
