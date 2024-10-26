/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package lets.lang.parser;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import lets.core.CoreUtils;
import lets.core.DataResultSupport;
import lets.core.StringUtils;

public class JavaParserUtils {

  public static DataResultSupport<CompilationUnit> compilationUnitFrom(
      File file, Charset encoding) {
    DataResultSupport<CompilationUnit> resultSupport = new DataResultSupport<>();
    try {
      resultSupport.setData(StaticJavaParser.parse(file, encoding));
    } catch (Throwable e) {
      resultSupport.onException(e);
    }
    return resultSupport;
  }

  public static DataResultSupport<CompilationUnit> compilationUnitFrom(File file) {
    DataResultSupport<CompilationUnit> resultSupport = new DataResultSupport<>();
    try {
      resultSupport.setData(StaticJavaParser.parse(file));
    } catch (Throwable e) {
      resultSupport.onException(e);
    }
    return resultSupport;
  }

  public static DataResultSupport<CompilationUnit> compilationUnitFromCode(String code) {
    DataResultSupport<CompilationUnit> resultSupport = new DataResultSupport<>();
    try {
      resultSupport.setData(StaticJavaParser.parse(code));
    } catch (Throwable e) {
      resultSupport.onException(e);
    }
    return resultSupport;
  }

  public static DataResultSupport<CompilationUnit> compilationUnitFrom(CompilationUnit code) {
    DataResultSupport<CompilationUnit> resultSupport = new DataResultSupport<>();
    try {
      resultSupport.setData(StaticJavaParser.parse(code.toString()));
    } catch (Throwable e) {
      resultSupport.onException(e);
    }
    return resultSupport;
  }

  public static DataResultSupport<PackageDeclaration> parsePackageDeclaration(String code) {
    DataResultSupport<PackageDeclaration> resultSupport = new DataResultSupport<>();
    try {
      resultSupport.setData(StaticJavaParser.parsePackageDeclaration(code));
    } catch (Throwable e) {
      resultSupport.onException(e);
    }
    return resultSupport;
  }

  public static DataResultSupport<ImportDeclaration> parseImportDeclaration(String code) {
    DataResultSupport<ImportDeclaration> resultSupport = new DataResultSupport<>();
    try {
      resultSupport.setData(StaticJavaParser.parseImport(code));
    } catch (Throwable e) {
      resultSupport.onException(e);
    }
    return resultSupport;
  }

  public static DataResultSupport<ClassOrInterfaceType> parseClassOrInterfaceType(String code) {
    DataResultSupport<ClassOrInterfaceType> resultSupport = new DataResultSupport<>();
    try {
      resultSupport.setData(StaticJavaParser.parseClassOrInterfaceType(code));
    } catch (Throwable e) {
      resultSupport.onException(e);
    }
    return resultSupport;
  }

  public static DataResultSupport<Modifier.Keyword> parseModifierKeyword(String keyword) {
    DataResultSupport<Modifier.Keyword> result = new DataResultSupport<Modifier.Keyword>();
    try {
      for (Modifier.Keyword value : Modifier.Keyword.values()) {
        if (StringUtils.equalsIgnoreCase(keyword, value.asString())) {
          result.setData(value);
          return result;
        }
      }
      CoreUtils.checkState(false, "Unsupported Keyword:" + keyword);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  public static DataResultSupport<List<Modifier.Keyword>> parseModifierKeywords(String code) {
    DataResultSupport<List<Modifier.Keyword>> result = new DataResultSupport<>();
    List<Modifier.Keyword> keywords = new ArrayList<>();
    result.setData(keywords);
    try {
      String[] parts = StringUtils.split(code, " ");
      for (String part : parts) {
        DataResultSupport<Modifier.Keyword> partKeyword = parseModifierKeyword(part);
        if (partKeyword.isSuccess()) {
          keywords.add(partKeyword.getData());
        }
      }
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
