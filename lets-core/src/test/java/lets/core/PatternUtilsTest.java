package lets.core;

import lets.core.io.FileUtils;
import lets.core.io.FilenameUtils;
import lets.core.io.filefilter.WildcardFileFilter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PatternUtilsTest {

  @Test
  public void findIPV4(){
    Pattern p = Pattern.compile(RegExUtils.REGEX_IPV4_ADDRESS_MULTIPLE);
    String input="192.168.1.1 192.168.1.2";
    DataResultSupport<List<String>> find = PatternUtils.find(input, p);
    assertTrue(find.isSuccess());
    List<String> items = find.getData();
    assertEquals("192.168.1.1",items.get(0));
    assertEquals("192.168.1.2",items.get(1));
  }

  @Test
  public void findDomain(){
    Pattern p = Pattern.compile(RegExUtils.REGEX_DOMAIN_MULTIPLE);
    String input="google.com github.com phx-a18.vpn.wlvpn.com";
    DataResultSupport<List<String>> find = PatternUtils.find(input, p);
    assertTrue(find.isSuccess());
    List<String> items = find.getData();
    assertEquals("google.com",items.get(0));
    assertEquals("github.com",items.get(1));
    assertEquals("phx-a18.vpn.wlvpn.com",items.get(2));
  }
}
