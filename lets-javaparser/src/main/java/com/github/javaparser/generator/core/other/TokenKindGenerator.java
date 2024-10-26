/*
 * Copyright (c) 2007-2010 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.generator.core.other;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.EnumConstantDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.stmt.SwitchEntry;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.generator.Generator;
import com.github.javaparser.utils.Log;
import com.github.javaparser.utils.SourceRoot;

/** Generates the TokenKind enum from {@link com.github.javaparser.GeneratedJavaParserConstants} */
public class TokenKindGenerator extends Generator {

  private final SourceRoot generatedJavaCcSourceRoot;

  public TokenKindGenerator(SourceRoot sourceRoot, SourceRoot generatedJavaCcSourceRoot) {
    super(sourceRoot);
    this.generatedJavaCcSourceRoot = generatedJavaCcSourceRoot;
  }

  @Override
  public void generate() {
    Log.info("Running %s", () -> getClass().getSimpleName());
    final CompilationUnit javaTokenCu = sourceRoot.parse("com.github.javaparser", "JavaToken.java");
    final ClassOrInterfaceDeclaration javaToken =
        javaTokenCu
            .getClassByName("JavaToken")
            .orElseThrow(() -> new AssertionError("Can't find class in java file."));
    final EnumDeclaration kindEnum =
        javaToken
            .findFirst(EnumDeclaration.class, e -> "Kind".equals(e.getNameAsString()))
            .orElseThrow(() -> new AssertionError("Can't find class in java file."));
    kindEnum.getEntries().clear();
    annotateGenerated(kindEnum);
    final SwitchStmt valueOfSwitch =
        kindEnum
            .findFirst(SwitchStmt.class)
            .orElseThrow(() -> new AssertionError("Can't find valueOf switch."));
    valueOfSwitch.findAll(SwitchEntry.class).stream()
        .filter(e -> e.getLabels().isNonEmpty())
        .forEach(Node::remove);
    final CompilationUnit constantsCu =
        generatedJavaCcSourceRoot.parse(
            "com.github.javaparser", "GeneratedJavaParserConstants.java");
    final ClassOrInterfaceDeclaration constants =
        constantsCu
            .getInterfaceByName("GeneratedJavaParserConstants")
            .orElseThrow(() -> new AssertionError("Can't find class in java file."));
    for (BodyDeclaration<?> member : constants.getMembers()) {
      member
          .toFieldDeclaration()
          .filter(
              field -> {
                String javadoc = field.getJavadocComment().get().getContent();
                return javadoc.contains("RegularExpression Id") || javadoc.contains("End of File");
              })
          .map(field -> field.getVariable(0))
          .ifPresent(
              var -> {
                final String name = var.getNameAsString();
                final IntegerLiteralExpr kind = var.getInitializer().get().asIntegerLiteralExpr();
                generateEnumEntry(kindEnum, name, kind);
                generateValueOfEntry(valueOfSwitch, name, kind);
              });
    }
  }

  private void generateValueOfEntry(
      SwitchStmt valueOfSwitch, String name, IntegerLiteralExpr kind) {
    final SwitchEntry entry =
        new SwitchEntry(
            new NodeList<>(kind),
            SwitchEntry.Type.STATEMENT_GROUP,
            new NodeList<>(new ReturnStmt(name)),
            false);
    valueOfSwitch.getEntries().addFirst(entry);
  }

  private void generateEnumEntry(EnumDeclaration kindEnum, String name, IntegerLiteralExpr kind) {
    final EnumConstantDeclaration enumEntry = new EnumConstantDeclaration(name);
    enumEntry.getArguments().add(kind);
    kindEnum.addEntry(enumEntry);
  }
}
