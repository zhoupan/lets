package lets.net;

import lets.core.DataResultSupport;
import lets.core.PatternUtils;
import lets.core.RegExUtils;
import lets.core.io.FileUtils;
import lets.core.io.FilenameUtils;
import lets.core.io.filefilter.WildcardFileFilter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Pattern;

public class NetworkUtilsTest {
  @Test
  public void findDomainInFile(){
    Pattern p = Pattern.compile(RegExUtils.REGEX_DOMAIN_MULTIPLE);
    File dir=new File("e:\\github\\DomainVPN\\FastVPN20241023\\fastvpn-serverListTCP-all-20241023\\");
    File[] files = dir.listFiles((FilenameFilter) new WildcardFileFilter("*.ovpn"));
    StringBuilder full=new StringBuilder();
    File fullFile=new File(dir, "full.txt");
    for(File file:files){
      File txtFile=new File(dir, FilenameUtils.getBaseName(file.getName())+".txt");
      StringBuilder sb=new StringBuilder();
      sb.append("#").append(FilenameUtils.getBaseName(file.getName()));
      sb.append("\n");
      DataResultSupport<List<String>> find = PatternUtils.find(file, StandardCharsets.UTF_8, p);
      if(!find.isSuccess()){
        continue;
      }
      for(String domain:find.getData()){
        DataResultSupport<InetAddress> address = NetworkUtils.getInetAddressForDomain(domain);
        if(!address.isSuccess()){
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
      }catch (Throwable e){
        e.printStackTrace();
      }
    }

    try{
      FileUtils.writeStringToFile(fullFile, full.toString(), StandardCharsets.UTF_8);
    }catch(Throwable e){
      e.printStackTrace();
    }
  }
}
