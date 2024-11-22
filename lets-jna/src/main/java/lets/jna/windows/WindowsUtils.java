package lets.jna.windows;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.*;
import com.sun.jna.ptr.IntByReference;
import lets.core.DataResultSupport;
import lets.core.ResultSupport;
import lets.core.StringUtils;

import java.util.ArrayList;

public class WindowsUtils {

  public static void main(String[] args) throws Exception {
    try (UserEnvironmentVariables item = new UserEnvironmentVariables()) {
      // 遍历
      DataResultSupport<String[]> names = item.getVariableNames();
      System.out.println("Names:" + names.isSuccess());
      if (names.isSuccess()) {
        System.out.println("Names:" + names.getData().length);
      }
      for (String name : item.getVariableNames().getData()) {
        // 读取
        String value = item.getValue(name).getData();
        System.out.println(String.format("%s:%s", name, value));
      }
      DataResultSupport<String> path = item.getValue("PATH");
      if (path.isSuccess()) {
        System.out.println("PATH:" + path.getData());
      }
      DataResultSupport<String[]> pathArray=item.getArray("PATH");
      if(pathArray.isSuccess()){
        System.out.println("PATHArray:" + StringUtils.join(pathArray.getData(),"\n"));
      }else{
        System.out.println("PATHArray:" + pathArray.getMessage());
      }
      ResultSupport set = item.setValue("lets", "1.0.0",false);
      if (set.isSuccess()) {
        DataResultSupport<String> get = item.getValue("lets", false);
        if (get.isSuccess()) {
          System.out.println("lets:" + get.getData());
        } else {
          System.out.println("lets:get:" + get.getMessage());
        }
      } else {
        System.err.println("lets:set:" + set.getMessage());
      }
    }

    try(RegistryKeySupport key=new RegistryKeySupport(WinReg.HKEY_CURRENT_USER,RegistryEnvironmentVariables.ENVIRONMENT_SUB_KEY_USER,WinNT.KEY_WRITE)){
      for(RegistryValueSupport value: key.getValues()){
        System.out.println(String.format("Value: type="+value.getType()+" name="+value.getName()));
        System.out.println(value.getStringValue().getData());
      }
    }
  }
}
