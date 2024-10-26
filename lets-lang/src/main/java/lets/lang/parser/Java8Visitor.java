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

import lets.lang.Java8Parser;
import lets.lang.Java8ParserBaseVisitor;

public class Java8Visitor extends Java8ParserBaseVisitor<Void> {

  protected Java8ParserController controller;

  public Java8Visitor() {
    this(new Java8ParserController());
  }

  public Java8Visitor(Java8ParserController controller) {
    this.controller = controller;
  }

  public Java8ParserController getController() {
    return controller;
  }

  @Override
  public Void visitCompilationUnit(Java8Parser.CompilationUnitContext ctx) {
    // compilationUnit
    // : packageDeclaration? importDeclaration* typeDeclaration* EOF
    // packageDeclaration
    // : packageModifier* 'package' packageName ';'
    return super.visitCompilationUnit(ctx);
  }

  @Override
  public Void visitPackageDeclaration(Java8Parser.PackageDeclarationContext ctx) {
    this.controller.visitPackageDeclaration(ctx);
    return super.visitPackageDeclaration(ctx);
  }

  @Override
  public Void visitImportDeclaration(Java8Parser.ImportDeclarationContext ctx) {
    this.controller.visitImportDeclaration(ctx);
    return super.visitImportDeclaration(ctx);
  }

  @Override
  public Void visitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
    // normalClassDeclaration
    // : classModifier* 'class' Identifier typeParameters? superclass? superinterfaces? classBody
    this.controller.visitNormalClassDeclaration(ctx);
    return super.visitNormalClassDeclaration(ctx);
  }

  @Override
  public Void visitNormalInterfaceDeclaration(Java8Parser.NormalInterfaceDeclarationContext ctx) {
    // normalInterfaceDeclaration
    // : interfaceModifier* 'interface' Identifier typeParameters? extendsInterfaces? interfaceBody
    this.controller.visitNormalInterfaceDeclaration(ctx);
    return super.visitNormalInterfaceDeclaration(ctx);
  }

  @Override
  public Void visitAnnotationTypeDeclaration(Java8Parser.AnnotationTypeDeclarationContext ctx) {
    return super.visitAnnotationTypeDeclaration(ctx);
  }

  @Override
  public Void visitEnumDeclaration(Java8Parser.EnumDeclarationContext ctx) {
    /**
     * enumDeclaration : classModifier* 'enum' Identifier superinterfaces? enumBody ;
     *
     * <p>enumBody : '{' enumConstantList? ','? enumBodyDeclarations? '}' ;
     *
     * <p>enumConstantList : enumConstant (',' enumConstant)* ;
     *
     * <p>enumConstant : enumConstantModifier* Identifier ('(' argumentList? ')')? classBody? ;
     *
     * <p>enumConstantModifier : annotation ;
     *
     * <p>enumBodyDeclarations : ';' classBodyDeclaration* ;
     */
    return super.visitEnumDeclaration(ctx);
  }
}
