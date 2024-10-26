package lets.core;

import lets.core.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtils {

  public static DataResultSupport<List<String>> find(CharSequence input, Pattern pattern){
    DataResultSupport<List<String>> result=new DataResultSupport<List<String>>();
    try{
      List<String> items=new ArrayList<String>();
      Matcher m = pattern.matcher(input);
      while(m.find()){
        items.add(m.group());
      }
      result.setData(items);
    }catch(Throwable e){
      result.onException(e);
    }
    return result;
  }

  public static DataResultSupport<List<String>> find(File input, Charset charset, Pattern pattern){
    DataResultSupport<List<String>> result=new DataResultSupport<List<String>>();
    try{
      List<String> items=new ArrayList<String>();
      List<String> lines = FileUtils.readLines(input, charset);
      for(String line:lines){
        DataResultSupport<List<String>> find = find(line, pattern);
        if(find.isSuccess()){
          items.addAll(find.getData());
        }
      }
      result.setData(items);
    }catch(Throwable e){
      result.onException(e);
    }
    return result;
  }

}
