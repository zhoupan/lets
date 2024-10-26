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
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.PackageDeclaration;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import lets.core.DataResultSupport;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class JavaParserUtilsTest {

  @Test
  public void parse() {
    // the JavaParser class provides a full API for producing an AST from code
    // the StaticJavaParser class provides a quick and simple API for producing an AST from code.
    // the CompilationUnit is the root of the AST
    // the Visitors are classes which are used to find specific parts of the AST
    // Our visitor is going to extend a class named VoidVisitorAdaptor.
    // Although that sounds like an odd name we can break in down into its constituent parts.
    // The Void means we’re not expecting the visit to return anything,
    // i.e. this visitor may produce a side effect,
    // but will not operate on the underlying tree.
    // There are other types of visitors that will do this, which we will come to later.

    // package com.company.product;
    DataResultSupport<PackageDeclaration> pdr =
        JavaParserUtils.parsePackageDeclaration("package com.company.product;");
    assertTrue(pdr.isSuccess(), pdr.getMessage());
    PackageDeclaration pd = pdr.getData();
    assertEquals("com.company.product", pd.getNameAsString());

    // import com.company.core.StringUtils;
    DataResultSupport<ImportDeclaration> idr =
        JavaParserUtils.parseImportDeclaration("import com.company.core.StringUtils;");
    assertTrue(idr.isSuccess(), idr.getMessage());
    ImportDeclaration id = idr.getData();
    assertEquals("com.company.core.StringUtils", id.getNameAsString());
    assertFalse(id.isStatic());
    assertFalse(id.isAsterisk());
    // import com.company.core.*;
    idr = JavaParserUtils.parseImportDeclaration("import com.company.core.*;");
    assertTrue(idr.isSuccess(), idr.getMessage());
    id = idr.getData();
    assertEquals("com.company.core", id.getNameAsString());
    assertFalse(id.isStatic());
    assertTrue(id.isAsterisk());
    // import static com.company.core.StringUtils.*;
    idr = JavaParserUtils.parseImportDeclaration("import static com.company.core.StringUtils.*;");
    assertTrue(idr.isSuccess(), idr.getMessage());
    id = idr.getData();
    assertEquals("com.company.core.StringUtils", id.getNameAsString());
    assertTrue(id.isStatic());
    assertTrue(id.isAsterisk());
    // public final static
    DataResultSupport<Modifier.Keyword> mkr = JavaParserUtils.parseModifierKeyword("public");
    assertTrue(mkr.isSuccess(), mkr.getMessage());
    Modifier.Keyword mk = mkr.getData();
    assertEquals(Modifier.Keyword.PUBLIC, mk);
    mkr = JavaParserUtils.parseModifierKeyword("final");
    assertTrue(mkr.isSuccess(), mkr.getMessage());
    mk = mkr.getData();
    assertEquals(Modifier.Keyword.FINAL, mk);
    mkr = JavaParserUtils.parseModifierKeyword("static");
    assertTrue(mkr.isSuccess(), mkr.getMessage());
    mk = mkr.getData();
    assertEquals(Modifier.Keyword.STATIC, mk);

    DataResultSupport<List<Modifier.Keyword>> mksr =
        JavaParserUtils.parseModifierKeywords("public static final");
    assertTrue(mksr.isSuccess(), mksr.getMessage());
    List<Modifier.Keyword> mks = mksr.getData();
    assertTrue(mks.contains(Modifier.Keyword.PUBLIC));
    assertTrue(mks.contains(Modifier.Keyword.STATIC));
    assertTrue(mks.contains(Modifier.Keyword.FINAL));
  }

  @Disabled
  public void testMigratingFromJUnit4ToJUnit5() {
    File file = new File("src/test/java/example/junit4/ExampleTest.java");
    File target = new File("target/ExampleTest.java");
    MigratingFromJUnit4ToJUnit5 migrating = new MigratingFromJUnit4ToJUnit5();
    DataResultSupport<File> result =
        migrating.process(file, StandardCharsets.UTF_8, target, StandardCharsets.UTF_8);
    assertTrue(result.isSuccess(), result.getMessage());
  }
}
