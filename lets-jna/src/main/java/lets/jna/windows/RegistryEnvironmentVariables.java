package lets.jna.windows;

import com.sun.jna.platform.win32.*;
import lets.core.DataResultSupport;
import lets.core.ResultSupport;
import lets.jna.EnvironmentVariables;

import java.util.Set;

public class RegistryEnvironmentVariables implements EnvironmentVariables,AutoCloseable {
  /** The Constant ENVIRONMENT_SUB_KEY. */
  public static final String ENVIRONMENT_SUB_KEY_USER = "Environment";
  public static final String ENVIRONMENT_SUB_KEY_SYSTEM = "System\\CurrentControlSet\\Control\\Session Manager\\Environment";
  private WinReg.HKEYByReference ref = new WinReg.HKEYByReference();
  private int error;
  public RegistryEnvironmentVariables(WinReg.HKEY root,String keyPath,int samDesiredExtra){
    this.error =Advapi32.INSTANCE.RegOpenKeyEx(root, keyPath, 0,
      WinNT.KEY_READ | samDesiredExtra , ref);
  }
  @Override
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

  @Override
  public DataResultSupport<String> getValue(String variable) {
    DataResultSupport<String> result=new DataResultSupport<String>();
    try{
      DataResultSupport<String> notExpaned = this.getValue(variable, false);
      if(!notExpaned.isEmpty()){
        return notExpaned;
      }
      return this.getValue(variable,true);
    }catch (Throwable e){
      result.onException(e);
    }
    return result;

  }

  @Override
  public DataResultSupport<String> getValue(String variable, boolean isExpanded) {
    DataResultSupport<String> result=new DataResultSupport<String>();
    try{
      if(isExpanded){
        result.setData(Advapi32Util.registryGetExpandableStringValue(this.ref.getValue(),variable));
      }else{
        result.setData(Advapi32Util.registryGetStringValue(this.ref.getValue(),variable));
      }
    }catch (Throwable e){
      result.onException(e);
    }
    return result;

   }

  @Override
  public ResultSupport setValue(String variable, String value, boolean isExpanded) {
    ResultSupport result=new ResultSupport();
    try{
      if(isExpanded){
        Advapi32Util.registrySetExpandableStringValue(this.ref.getValue(),variable,value);
      }else {
        Advapi32Util.registrySetStringValue(this.ref.getValue(), variable, value);
      }
    }catch (Throwable e){
      result.onException(e);
    }
    return result;
  }

  @Override
  public ResultSupport removeVariable(String variable) {
    ResultSupport result=new ResultSupport();
    try {
      Advapi32Util.registryDeleteKey(this.ref.getValue(), variable);
    }catch (Throwable e){
      result.onException(e);
    }
    return result;
  }

  @Override
  public DataResultSupport<Boolean> contains(String variable) {
    DataResultSupport<Boolean> result=new DataResultSupport<Boolean>();
    try{
      result.setData(Advapi32Util.registryKeyExists(this.ref.getValue(),variable));
    }catch(Throwable e){
      result.onException(e);
    }
    return result;
  }

  @Override
  public DataResultSupport<String[]> getVariableNames() {
    DataResultSupport<String[]> result=new DataResultSupport<String[]>();
    try{
      Set<String> set = Advapi32Util.registryGetValues(this.ref.getValue()).keySet();
      result.setData(set.toArray(new String[set.size()]));
    }catch (Throwable e){
      result.onException(e);
    }
    return result;
  }

  public DataResultSupport<String[]> getArray(String variable){
    DataResultSupport<String[]> result=new DataResultSupport<String[]>();
    try{
      result.setData(Advapi32Util.registryGetStringArray(this.ref.getValue(),variable));
    }catch (Throwable e){
      result.onException(e);
    }
    return result;
  }

  public ResultSupport setArray(String variable,String[]array){
    ResultSupport result=new ResultSupport();
    try{
      Advapi32Util.registrySetStringArray(this.ref.getValue(),variable,array);
    }catch (Throwable e){
      result.onException(e);
    }
    return result;
  }
}
