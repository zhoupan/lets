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
import com.github.javaparser.ast.PackageDeclaration;
import lets.core.DataResultSupport;
import org.junit.jupiter.api.Test;

public class Java8ParserControllerTest {

  @Test
  public void java8ParserController() {
    Java8ParserController controller = new Java8ParserController();
    DataResultSupport<PackageDeclaration> pdr =
        controller.parsePackageDeclaration("package com.company.product;");
    assertTrue(pdr.isSuccess(), pdr.getMessage());
    PackageDeclaration pd = pdr.getData();
    assertEquals("com.company.product", pd.getNameAsString());

    DataResultSupport<ImportDeclaration> idr =
        controller.parseImportDeclaration("import com.company.core.StringUtils;");
    assertTrue(idr.isSuccess(), idr.getMessage());
    assertEquals("com.company.core.StringUtils", idr.getData().getNameAsString());
  }
}
