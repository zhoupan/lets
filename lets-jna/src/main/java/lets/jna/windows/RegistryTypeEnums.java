package lets.jna.windows;

import lets.core.EnumSupport;
import lets.core.IntegerEnumSupport;

public class RegistryTypeEnums {
  public static final IntegerEnumSupport NONE = new IntegerEnumSupport(0,"NONE","");
  public static final IntegerEnumSupport SZ = new IntegerEnumSupport(1,"SZ","");
  public static final IntegerEnumSupport EXPAND_SZ = new IntegerEnumSupport(2,"EXPAND_SZ","");
  public static final IntegerEnumSupport BINARY = new IntegerEnumSupport(3,"BINARY","");
  public static final IntegerEnumSupport DWORD = new IntegerEnumSupport(4,"DWORD","");
  public static final IntegerEnumSupport DWORD_LITTLE_ENDIAN = new IntegerEnumSupport(4,"DWORD_LITTLE_ENDIAN","");
  public static final IntegerEnumSupport DWORD_BIG_ENDIAN = new IntegerEnumSupport(5,"DWORD_BIG_ENDIAN","");
  public static final IntegerEnumSupport LINK = new IntegerEnumSupport(6,"LINK","");
  public static final IntegerEnumSupport MULTI_SZ = new IntegerEnumSupport(7,"MULTI_SZ","");
  public static final IntegerEnumSupport RESOURCE_LIST = new IntegerEnumSupport(8,"RESOURCE_LIST","");
  public static final IntegerEnumSupport FULL_RESOURCE_DESCRIPTOR = new IntegerEnumSupport(9,"FULL_RESOURCE_DESCRIPTOR","");
  public static final IntegerEnumSupport RESOURCE_REQUIREMENTS_LIST = new IntegerEnumSupport(10,"RESOURCE_REQUIREMENTS_LIST","");
  public static final IntegerEnumSupport QWORD = new IntegerEnumSupport(11,"QWORD","");

}
