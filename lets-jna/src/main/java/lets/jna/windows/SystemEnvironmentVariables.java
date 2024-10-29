package lets.jna.windows;

import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinReg;

public class SystemEnvironmentVariables extends RegistryEnvironmentVariables{

  public SystemEnvironmentVariables(){
    super(WinReg.HKEY_LOCAL_MACHINE,RegistryEnvironmentVariables.ENVIRONMENT_SUB_KEY_SYSTEM, WinNT.KEY_WRITE);
  }
}
