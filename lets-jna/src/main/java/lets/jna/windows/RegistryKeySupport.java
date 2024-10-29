package lets.jna.windows;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.*;
import com.sun.jna.ptr.IntByReference;
import lets.core.DataResultSupport;
import lets.core.ResultSupport;

import java.util.ArrayList;
import java.util.List;

public class RegistryKeySupport implements AutoCloseable{
  private WinReg.HKEYByReference ref = new WinReg.HKEYByReference();
  private DataResultSupport<Advapi32Util.InfoKey> info;
  private List<RegistryValueSupport> values=new ArrayList<RegistryValueSupport>();

  private int error;
  public static DataResultSupport<Advapi32Util.InfoKey> registryQueryInfoKey(WinReg.HKEY root,int samDesiredExtra){
    DataResultSupport<Advapi32Util.InfoKey> result=new DataResultSupport<Advapi32Util.InfoKey>();
    try{
      result.setData(Advapi32Util.registryQueryInfoKey(root,WinNT.KEY_READ | samDesiredExtra));
    }catch(Throwable e){
      result.onException(e);
    }
    return result;
  }
  public RegistryKeySupport(WinReg.HKEY root,String keyPath,int samDesiredExtra){
    this.error = Advapi32.INSTANCE.RegOpenKeyEx(root, keyPath, 0,
      WinNT.KEY_READ | samDesiredExtra , ref);
    this.info=registryQueryInfoKey(root,samDesiredExtra);
    if(this.info.isSuccess()){
     for(String name:Advapi32Util.registryGetValues(this.ref.getValue()).keySet()){
      RegistryValueSupport value=new RegistryValueSupport(this,name);
      if(value.success()){
        this.values.add(value);
      }
     }
    }
  }
  public int getSubKeyCount(){
    if(this.info.isSuccess()){
      return this.info.getData().lpcSubKeys.getValue();
    }else{
      return 0;
    }
  }
  public int getValueCount(){
    if(this.info.isSuccess()){
      return this.info.getData().lpcValues.getValue();
    }else{
      return 0;
    }
  }

  public void close() throws Exception {
    ResultSupport result=new ResultSupport();
    try {
      if (error == W32Errors.ERROR_SUCCESS) {
        error = Advapi32.INSTANCE.RegCloseKey(ref.getValue());
        if (error != W32Errors.ERROR_SUCCESS) {
          throw new Win32Exception(error);
        }
      }
    }catch(Throwable e){
      result.onException(e);
    }
  }

  public WinReg.HKEYByReference getRef() {
    return ref;
  }

  public DataResultSupport<Advapi32Util.InfoKey> getInfo() {
    return info;
  }

  public int getError() {
    return error;
  }

  public boolean success(){
    return this.error == W32Errors.ERROR_SUCCESS;
  }

  public List<RegistryValueSupport> getValues() {
    return values;
  }
}
