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

import static org.junit.jupiter.api.Assertions.*;

import com.github.javaparser.ast.ImportDeclaration;
import lets.core.DataResultSupport;
import lets.core.StringUtils;
import org.junit.jupiter.api.Test;

public class PythonPrettyPrinterTest {

  JavaFeatures java = new JavaFeatures();
  PythonFeatures python = new PythonFeatures();

  @Test
  public void imports() {
    // java: import java.lang.String;
    // python: from java.lang import String
    PythonPrettyPrinter pythonPrinter = new PythonPrettyPrinter();
    DataResultSupport<ImportDeclaration> idr =
        JavaParserUtils.parseImportDeclaration("import java.lang.String;");
    assertTrue(idr.isSuccess(), idr.getMessage());
    String pythonCode = pythonPrinter.print(idr.getData());
    assertTrue(StringUtils.startsWith(pythonCode, "from java.lang import String"));

    // java: import java.lang.*;
    // python: from java.lang import *;
    idr = JavaParserUtils.parseImportDeclaration("import java.lang.*;");
    assertTrue(idr.isSuccess(), idr.getMessage());
    pythonCode = pythonPrinter.print(idr.getData());
    assertTrue(StringUtils.startsWith(pythonCode, "from java.lang import *"));
  }
}
