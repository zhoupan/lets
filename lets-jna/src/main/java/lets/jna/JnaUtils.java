package lets.jna;

import com.sun.jna.Platform;

public class JnaUtils {
  public static boolean is64BitPlatform(){
    return Platform.is64Bit();
  }
  public static boolean isWindows(){
    return Platform.isWindows();
  }
  public static boolean isLinux(){
    return Platform.isLinux();
  }
  public static boolean isMac(){
    return  Platform.isMac();
  }
  public static boolean isAndroid(){
    return Platform.isAndroid();
  }
  public static boolean isIntel(){
    return Platform.isIntel();
  }
  public static boolean isARM(){
    return Platform.isARM();
  }
}
