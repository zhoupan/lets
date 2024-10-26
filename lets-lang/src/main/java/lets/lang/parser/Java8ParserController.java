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

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import java.util.ArrayList;
import java.util.List;
import lets.core.DataResultSupport;
import lets.core.StringUtils;
import lets.lang.Java8Lexer;
import lets.lang.Java8Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Java8ParserController extends Antlr4Support<Java8Lexer, Java8Parser> {

  protected CompilationUnit compilationUnit = new CompilationUnit();

  public CompilationUnit getCompilationUnit() {
    return compilationUnit;
  }

  public void setCompilationUnit(CompilationUnit compilationUnit) {
    this.compilationUnit = compilationUnit;
  }

  @Override
  public Java8Lexer newLexer(CharStream input) {
    return new Java8Lexer(input);
  }

  @Override
  public Java8Parser newParser(TokenStream input) {
    return new Java8Parser(input);
  }

  public Java8Visitor visit(ParseTree tree) {
    Java8Visitor visitor = new Java8Visitor();
    visitor.visit(tree);
    return visitor;
  }

  public DataResultSupport<PackageDeclaration> parsePackageDeclaration(String code) {
    DataResultSupport<PackageDeclaration> resultSupport = new DataResultSupport<>();
    try {
      Java8Parser parser = this.newParserFromString(code);
      Java8Visitor visitor = visit(parser.packageDeclaration());
      resultSupport.setData(visitor.getController().compilationUnit.getPackageDeclaration().get());
    } catch (Throwable e) {
      resultSupport.onException(e);
    }
    return resultSupport;
  }

  public DataResultSupport<ImportDeclaration> parseImportDeclaration(String code) {
    DataResultSupport<ImportDeclaration> resultSupport = new DataResultSupport<>();
    try {
      Java8Parser parser = this.newParserFromString(code);
      Java8Visitor visitor = visit(parser.importDeclaration());
      resultSupport.setData(visitor.getController().compilationUnit.getImports().get(0));
    } catch (Throwable e) {
      resultSupport.onException(e);
    }
    return resultSupport;
  }

  public void visitPackageDeclaration(Java8Parser.PackageDeclarationContext ctx) {
    String packageName = ctx.packageName().getText();
    this.compilationUnit.setPackageDeclaration(packageName);
  }

  /**
   * importDeclaration : singleTypeImportDeclaration | typeImportOnDemandDeclaration |
   * singleStaticImportDeclaration | staticImportOnDemandDeclaration
   *
   * <p>singleTypeImportDeclaration : 'import' typeName ';' ;
   *
   * <p>typeImportOnDemandDeclaration : 'import' packageOrTypeName '.' '*' ';' ;
   *
   * <p>singleStaticImportDeclaration : 'import' 'static' typeName '.' Identifier ';' ;
   *
   * <p>staticImportOnDemandDeclaration : 'import' 'static' typeName '.' '*' ';' ;
   *
   * @param ctx
   */
  public void visitImportDeclaration(Java8Parser.ImportDeclarationContext ctx) {
    Java8Parser.SingleTypeImportDeclarationContext stid = ctx.singleTypeImportDeclaration();
    if (stid != null) {
      this.compilationUnit
          .getImports()
          .add(new ImportDeclaration(stid.typeName().getText(), false, false));
    }
    Java8Parser.TypeImportOnDemandDeclarationContext tiodd = ctx.typeImportOnDemandDeclaration();
    if (tiodd != null) {
      this.compilationUnit
          .getImports()
          .add(new ImportDeclaration(tiodd.packageOrTypeName().getText(), false, true));
    }
    Java8Parser.SingleStaticImportDeclarationContext ssid = ctx.singleStaticImportDeclaration();
    if (ssid != null) {
      this.compilationUnit
          .getImports()
          .add(new ImportDeclaration(ssid.typeName().getText(), true, false));
    }
    Java8Parser.StaticImportOnDemandDeclarationContext siodd =
        ctx.staticImportOnDemandDeclaration();
    if (siodd != null) {
      this.compilationUnit
          .getImports()
          .add(new ImportDeclaration(siodd.typeName().getText(), true, true));
    }
  }

  /**
   * classDeclaration : normalClassDeclaration | enumDeclaration ;
   *
   * <p>normalClassDeclaration : classModifier* 'class' Identifier typeParameters? superclass?
   * superinterfaces? classBody ;
   */
  public void visitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
    ClassOrInterfaceDeclaration c = new ClassOrInterfaceDeclaration();
    c.setInterface(false);
    List<Java8Parser.ClassModifierContext> modifierList = ctx.classModifier();
    List<Modifier.Keyword> keywordList = modifierKeywordListFrom(modifierList);
    if (!keywordList.isEmpty()) {
      c.setModifiers(keywordList.toArray(new Modifier.Keyword[keywordList.size()]));
    }
    c.setName(ctx.Identifier().getText());
    Java8Parser.TypeParametersContext typeParameters = ctx.typeParameters();
    if (typeParameters != null) {
      // typeParameters
      // : '<' typeParameterList '>'
      // ;

      // typeParameterList
      // : typeParameter (',' typeParameter)*
      // ;

      // typeParameter
      //    : typeParameterModifier* Identifier typeBound?
      //    ;
      //
      // typeParameterModifier
      //    : annotation
      //    ;
      //
      // typeBound
      //    : 'extends' typeVariable
      //    | 'extends' classOrInterfaceType additionalBound*
      //    ;

    }
    Java8Parser.SuperclassContext superclass = ctx.superclass();
    // superclass
    // : 'extends' classType
    // ;
    if (superclass != null) {
      DataResultSupport<ClassOrInterfaceType> extend =
          JavaParserUtils.parseClassOrInterfaceType(superclass.getText());
      if (extend.isSuccess()) {
        c.getExtendedTypes().add(extend.getData());
      }
    }
    // superinterfaces
    // : 'implements' interfaceTypeList
    // ;
    // interfaceTypeList
    // : interfaceType (',' interfaceType)*
    // ;
    Java8Parser.SuperinterfacesContext superinterfaces = ctx.superinterfaces();
    if (superinterfaces != null) {
      List<Java8Parser.InterfaceTypeContext> interfaceTypeList =
          superinterfaces.interfaceTypeList().interfaceType();
      for (Java8Parser.InterfaceTypeContext interfaceType : interfaceTypeList) {
        DataResultSupport<ClassOrInterfaceType> parseClassOrInterfaceType =
            JavaParserUtils.parseClassOrInterfaceType(interfaceType.getText());
        if (parseClassOrInterfaceType.isSuccess()) {
          c.getImplementedTypes().add(parseClassOrInterfaceType.getData());
        }
      }
    }

    this.compilationUnit.getTypes().add(c);
  }

  public List<Modifier.Keyword> modifierKeywordListFrom(
      List<Java8Parser.ClassModifierContext> modifierList) {
    List<Modifier.Keyword> items = new ArrayList<>();
    if (modifierList != null && !modifierList.isEmpty()) {
      List<String> keywordList = new ArrayList<String>();
      for (Java8Parser.ClassModifierContext classModifier : modifierList) {
        keywordList.add(classModifier.getText());
      }
      DataResultSupport<List<Modifier.Keyword>> keywords =
          JavaParserUtils.parseModifierKeywords(StringUtils.join(keywordList, " "));
      if (keywords.isSuccess() && !keywords.getData().isEmpty()) {
        List<Modifier.Keyword> keywordData = keywords.getData();
        items.addAll(keywordData);
      }
    }
    return items;
  }

  /**
   * interfaceDeclaration : normalInterfaceDeclaration | annotationTypeDeclaration ;
   *
   * <p>normalInterfaceDeclaration : interfaceModifier* 'interface' Identifier typeParameters?
   * extendsInterfaces? interfaceBody ;
   */
  public void visitNormalInterfaceDeclaration(Java8Parser.NormalInterfaceDeclarationContext ctx) {}

  /**
   * interfaceDeclaration : normalInterfaceDeclaration | annotationTypeDeclaration ;
   *
   * <p>annotationTypeDeclaration : interfaceModifier* '@' 'interface' Identifier annotationTypeBody
   * ;
   *
   * <p>annotationTypeBody : '{' annotationTypeMemberDeclaration* '}' ;
   *
   * <p>annotationTypeMemberDeclaration : annotationTypeElementDeclaration | constantDeclaration |
   * classDeclaration | interfaceDeclaration | ';' ;
   *
   * <p>annotationTypeElementDeclaration : annotationTypeElementModifier* unannType Identifier '('
   * ')' dims? defaultValue? ';' ;
   *
   * <p>annotationTypeElementModifier : annotation | 'public' | 'abstract' ;
   */
  public void visitAnnotationTypeDeclaration(Java8Parser.AnnotationTypeDeclarationContext ctx) {}

  public void visitEnumDeclaration(Java8Parser.EnumDeclarationContext ctx) {
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
  }
}
