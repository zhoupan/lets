package lets.jna.windows;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.W32Errors;
import com.sun.jna.ptr.IntByReference;
import lets.core.DataResultSupport;

public class RegistryValueSupport {
  private RegistryKeySupport parent;

  private String name;
  private int type;

  private int error;
  public RegistryValueSupport(RegistryKeySupport parent, String name) {
    this.parent = parent;
    this.name=name;
    IntByReference lpcbData = new IntByReference();
    IntByReference lpType = new IntByReference();
    this.error= Advapi32.INSTANCE.RegQueryValueEx(parent.getRef().getValue(), name, 0,
      lpType, (Pointer) null, lpcbData);
    if (this.success()){
      this.type=lpType.getValue();
    }
  }

  public boolean success(){
    return this.error == W32Errors.ERROR_SUCCESS;
  }

  public RegistryKeySupport getParent() {
    return parent;
  }

  public String getName() {
    return name;
  }

  public DataResultSupport<String> getStringValue(){
    DataResultSupport<String> result=new DataResultSupport<String>();
    try{
       result.setData(Advapi32Util.registryGetStringValue(this.getParent().getRef().getValue(),this.getName()));
    }catch (Throwable e){
      result.onException(e);
    }
    return result;
  }

  public int getType() {
    return type;
  }

  public int getError() {
    return error;
  }
}
