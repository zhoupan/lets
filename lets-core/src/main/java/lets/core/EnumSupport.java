package lets.core;

public class EnumSupport<TCode> {
 private TCode code;
 private String message;
 private String description;

 public EnumSupport(TCode code, String message, String description) {
  super();
  this.code = code;
  this.message = message;
  this.description = description;
 }

 public TCode code() {
  return this.code;
 }

 public String message() {
  return this.message;
 }

 public String description() {
  return this.description;
 }

 @Override
 public String toString() {
  return "EnumSupport [code=" + code + ", message=" + message + ", description=" + description + "]";
 }

 public EnumSupport(EnumSupport<TCode> copyFrom, String description) {
  this(copyFrom.code(), copyFrom.message(), description);
 }

 /**
  * 返回当前的代码是否和指定的对象的代码相等
  *
  * @param that
  * @return
  */
 public boolean is(EnumSupport<TCode> that) {
  return this.code().equals(that.code());
 }

}
