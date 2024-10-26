package lets.net;

import lets.core.DataResultSupport;
import org.xbill.DNS.Address;

import java.net.InetAddress;

public class NetworkUtils {
  public static DataResultSupport<InetAddress> getInetAddressForDomain(String domain){
    DataResultSupport<InetAddress> result=new DataResultSupport<InetAddress>();
    try{
      result.setData(Address.getByName(domain));
    }catch(Throwable e){
      result.onException(e);
    }
    return result;
  }
}
