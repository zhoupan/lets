package lets.jna.windows;

import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinReg;

public class UserEnvironmentVariables extends RegistryEnvironmentVariables{

  public UserEnvironmentVariables(){
    super(WinReg.HKEY_CURRENT_USER,RegistryEnvironmentVariables.ENVIRONMENT_SUB_KEY_USER, WinNT.KEY_WRITE);
  }
}
