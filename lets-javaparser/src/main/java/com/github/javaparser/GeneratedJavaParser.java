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
package com.github.javaparser;

import static com.github.javaparser.GeneratedJavaParser.*;
import static com.github.javaparser.GeneratedJavaParserTokenManagerBase.*;
import static com.github.javaparser.JavaToken.INVALID;
import static com.github.javaparser.Position.*;
import static com.github.javaparser.Range.*;
import static com.github.javaparser.ast.Node.Parsedness.UNPARSABLE;
import static com.github.javaparser.ast.NodeList.*;
import static com.github.javaparser.ast.stmt.SwitchEntry.Type.*;
import static com.github.javaparser.ast.type.ArrayType.*;
import static com.github.javaparser.utils.Utils.*;

import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.modules.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.*;
import com.github.javaparser.utils.*;
import java.io.*;
import java.util.*;

@Generated("JavaCC")
final class GeneratedJavaParser extends GeneratedJavaParserBase
    implements GeneratedJavaParserConstants {
  /* Returns the JavaParser specific token type of the last matched token */
  JavaToken token() {
    return token.javaToken;
  }

  /* Returns the last matched token */
  Token getCurrentToken() {
    return token;
  }

  /* Changes the amount by which the horizontal position is increased when a tab character is encountered.
  One by default.*/
  void setTabSize(int size) {
    jj_input_stream.setTabSize(size);
  }

  @Override
  GeneratedJavaParserTokenManager getTokenSource() {
    return token_source;
  }

  public final CompilationUnit CompilationUnit() throws ParseException {
    PackageDeclaration packageDeclaration = null;
    NodeList<ImportDeclaration> imports = emptyNodeList();
    ImportDeclaration in = null;
    NodeList<TypeDeclaration<?>> types = emptyNodeList();
    ModifierHolder modifier;
    TypeDeclaration<?> typeDeclaration = null;
    ModuleDeclaration module = null;
    try {
      label_1:
      while (true) {
        if (jj_2_1(2)) {
        } else {
          break label_1;
        }
        jj_consume_token(SEMICOLON);
      }
      if (jj_2_2(2147483647)) {
        packageDeclaration = PackageDeclaration();
      } else {
        ;
      }
      label_2:
      while (true) {
        switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
          case ABSTRACT:
          case CLASS:
          case _DEFAULT:
          case ENUM:
          case FINAL:
          case IMPORT:
          case INTERFACE:
          case NATIVE:
          case NON_SEALED:
          case PRIVATE:
          case PROTECTED:
          case PUBLIC:
          case RECORD:
          case SEALED:
          case STATIC:
          case STRICTFP:
          case SYNCHRONIZED:
          case TRANSIENT:
          case VOLATILE:
          case OPEN:
          case MODULE:
          case TRANSITIVE:
          case SEMICOLON:
          case AT:
            {
              break;
            }
          default:
            jj_la1[0] = jj_gen;
            break label_2;
        }
        switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
          case IMPORT:
            {
              in = ImportDeclaration();
              imports = add(imports, in);
              break;
            }
          case ABSTRACT:
          case CLASS:
          case _DEFAULT:
          case ENUM:
          case FINAL:
          case INTERFACE:
          case NATIVE:
          case NON_SEALED:
          case PRIVATE:
          case PROTECTED:
          case PUBLIC:
          case RECORD:
          case SEALED:
          case STATIC:
          case STRICTFP:
          case SYNCHRONIZED:
          case TRANSIENT:
          case VOLATILE:
          case OPEN:
          case MODULE:
          case TRANSITIVE:
          case SEMICOLON:
          case AT:
            {
              modifier = Modifiers();
              switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                case CLASS:
                case INTERFACE:
                  {
                    typeDeclaration = ClassOrInterfaceDeclaration(modifier);
                    types = add(types, typeDeclaration);
                    break;
                  }
                case RECORD:
                  {
                    typeDeclaration = RecordDeclaration(modifier);
                    types = add(types, typeDeclaration);
                    break;
                  }
                case ENUM:
                  {
                    typeDeclaration = EnumDeclaration(modifier);
                    types = add(types, typeDeclaration);
                    break;
                  }
                case AT:
                  {
                    typeDeclaration = AnnotationTypeDeclaration(modifier);
                    types = add(types, typeDeclaration);
                    break;
                  }
                case OPEN:
                case MODULE:
                  {
                    module = ModuleDeclaration(modifier);
                    break;
                  }
                case SEMICOLON:
                  {
                    jj_consume_token(SEMICOLON);
                    break;
                  }
                default:
                  jj_la1[1] = jj_gen;
                  jj_consume_token(-1);
                  throw new ParseException();
              }
              break;
            }
          default:
            jj_la1[2] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
        }
      }
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case 0:
          {
            jj_consume_token(0);
            break;
          }
        case CTRL_Z:
          {
            jj_consume_token(CTRL_Z);
            break;
          }
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
      {
        if ("" != null)
          return new CompilationUnit(
              range(token_source.getHomeToken(), token()),
              packageDeclaration,
              imports,
              types,
              module);
      }
    } catch (ParseException e) {
      recover(EOF, e);
      final CompilationUnit compilationUnit =
          new CompilationUnit(
              range(token_source.getHomeToken(), token()),
              null,
              new NodeList<ImportDeclaration>(),
              new NodeList<TypeDeclaration<?>>(),
              null);
      compilationUnit.setParsed(UNPARSABLE);
      {
        if ("" != null) return compilationUnit;
      }
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-7.html#jls-7.4.1
   *
   * <pre>{@code
   * PackageDeclaration:
   *     {PackageModifier} package Identifier {. Identifier} ;
   * PackageModifier:
   *     Annotation
   * }</pre>
   */
  public final PackageDeclaration PackageDeclaration() throws ParseException {
    NodeList<AnnotationExpr> annotations = new NodeList<AnnotationExpr>();
    Name name;
    JavaToken begin = INVALID;
    AnnotationExpr ann;
    label_3:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case AT:
          {
            break;
          }
        default:
          jj_la1[4] = jj_gen;
          break label_3;
      }
      ann = Annotation();
      annotations = add(annotations, ann);
      begin = orIfInvalid(begin, ann);
    }
    jj_consume_token(PACKAGE);
    begin = orIfInvalid(begin, token());
    name = Name();
    jj_consume_token(SEMICOLON);
    {
      if ("" != null) return new PackageDeclaration(range(begin, token()), annotations, name);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Import declaration types are not differentiated in the class hierarchy.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-7.html#jls-7.5
   *
   * <pre>{@code
   * ImportDeclaration:
   *     SingleTypeImportDeclaration
   *     TypeImportOnDemandDeclaration
   *     SingleStaticImportDeclaration
   *     StaticImportOnDemandDeclaration
   * }</pre>
   *
   * Note that the JLS terminology "On Demand" and JavaParser terminology "Asterisk" are equivalent
   *
   * <pre>{@code
   * SingleTypeImportDeclaration:
   *     import TypeName ;
   * TypeImportOnDemandDeclaration:
   *     import PackageOrTypeName . * ;
   * SingleStaticImportDeclaration:
   *     import static TypeName . Identifier ;
   * StaticImportOnDemandDeclaration:
   *     import static TypeName . * ;
   * }</pre>
   */
  public final ImportDeclaration ImportDeclaration() throws ParseException {
    Name name;
    boolean isStatic = false;
    boolean isAsterisk = false;
    JavaToken begin;
    jj_consume_token(IMPORT);
    begin = token();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case STATIC:
        {
          jj_consume_token(STATIC);
          isStatic = true;
          break;
        }
      default:
        jj_la1[5] = jj_gen;
        ;
    }
    name = Name();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case DOT:
        {
          jj_consume_token(DOT);
          jj_consume_token(STAR);
          isAsterisk = true;
          break;
        }
      default:
        jj_la1[6] = jj_gen;
        ;
    }
    jj_consume_token(SEMICOLON);
    {
      if ("" != null)
        return new ImportDeclaration(range(begin, token()), name, isStatic, isAsterisk);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /*
   * Modifiers. We match all modifiers in a single rule to reduce the chances of
   * syntax errors for simple modifier mistakes. It will also enable us to give
   * better error messages.
   * Class Modifiers: https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.1.1
   * <pre>{@code
   *     ClassModifier:
   *         (one of)
   *         Annotation public protected private
   *         abstract static final strictfp
   * }</pre>
   * Field Modifiers: https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.3.1
   * <pre>{@code
   *     FieldModifier:
   *         (one of)
   *         Annotation public protected private
   *         static final transient volatile
   * }</pre>
   * Method Modifiers: https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.4.3
   * <pre>{@code
   *     MethodModifier:
   *         (one of)
   *         Annotation public protected private
   *         abstract static final synchronized native strictfp
   * }</pre>
   * Constructor Modifiers: https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.8.3
   * <pre>{@code
   *     ConstructorModifier:
   *         (one of)
   *         Annotation public protected private
   * }</pre>
   */
  public final ModifierHolder Modifiers() throws ParseException {
    JavaToken begin = INVALID;
    NodeList<Modifier> modifiers = new NodeList<Modifier>();
    NodeList<AnnotationExpr> annotations = new NodeList<AnnotationExpr>();
    AnnotationExpr ann;
    label_4:
    while (true) {
      if (jj_2_3(2)) {
      } else {
        break label_4;
      }
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case PUBLIC:
          {
            jj_consume_token(PUBLIC);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.PUBLIC));
            begin = orIfInvalid(begin, token());
            break;
          }
        case STATIC:
          {
            jj_consume_token(STATIC);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.STATIC));
            begin = orIfInvalid(begin, token());
            break;
          }
        case PROTECTED:
          {
            jj_consume_token(PROTECTED);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.PROTECTED));
            begin = orIfInvalid(begin, token());
            break;
          }
        case PRIVATE:
          {
            jj_consume_token(PRIVATE);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.PRIVATE));
            begin = orIfInvalid(begin, token());
            break;
          }
        case FINAL:
          {
            jj_consume_token(FINAL);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.FINAL));
            begin = orIfInvalid(begin, token());
            break;
          }
        case ABSTRACT:
          {
            jj_consume_token(ABSTRACT);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.ABSTRACT));
            begin = orIfInvalid(begin, token());
            break;
          }
        case SYNCHRONIZED:
          {
            jj_consume_token(SYNCHRONIZED);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.SYNCHRONIZED));
            begin = orIfInvalid(begin, token());
            break;
          }
        case NATIVE:
          {
            jj_consume_token(NATIVE);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.NATIVE));
            begin = orIfInvalid(begin, token());
            break;
          }
        case TRANSIENT:
          {
            jj_consume_token(TRANSIENT);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.TRANSIENT));
            begin = orIfInvalid(begin, token());
            break;
          }
        case VOLATILE:
          {
            jj_consume_token(VOLATILE);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.VOLATILE));
            begin = orIfInvalid(begin, token());
            break;
          }
        case STRICTFP:
          {
            jj_consume_token(STRICTFP);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.STRICTFP));
            begin = orIfInvalid(begin, token());
            break;
          }
        case TRANSITIVE:
          {
            jj_consume_token(TRANSITIVE);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.TRANSITIVE));
            begin = orIfInvalid(begin, token());
            break;
          }
        case _DEFAULT:
          {
            jj_consume_token(_DEFAULT);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.DEFAULT));
            begin = orIfInvalid(begin, token());
            break;
          }
        case SEALED:
          {
            jj_consume_token(SEALED);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.SEALED));
            begin = orIfInvalid(begin, token());
            break;
          }
        case NON_SEALED:
          {
            jj_consume_token(NON_SEALED);
            add(modifiers, new Modifier(tokenRange(), Modifier.Keyword.NON_SEALED));
            begin = orIfInvalid(begin, token());
            break;
          }
        case AT:
          {
            ann = Annotation();
            annotations = add(annotations, ann);
            begin = orIfInvalid(begin, ann);
            break;
          }
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    {
      if ("" != null) return new ModifierHolder(begin, modifiers, annotations);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /*
   * Declaration syntax follows.
   */

  /**
   * <strong> Note that this grammar is deliberately permissive. As a result, this grammar allows
   * any combinations of class/interface and extends/implements (e.g. an interface implementing an
   * interface). </strong> Validations of these combinations are handled at the same time as
   * validating language features used. Also note that JavaParser handles the
   * hierarchy/specialisations of classes, interfaces, and enums differently to the JLS.
   *
   * <ul>
   *   <li>This {@code ClassOrInterfaceDeclaration} refers to the {@code NormalClassDeclaration} and
   *       {@code NormalInterfaceDeclaration},
   *   <li>while {@code AnnotationTypeDeclaration}, {@code EnumDeclaration}, and {@code
   *       RecordDeclaration} are handled separately within this grammar.
   * </ul>
   *
   * https://docs.oracle.com/javase/specs/jls/se17/html/jls-8.html#jls-8.1
   *
   * <pre>{@code
   * ClassDeclaration:
   *     NormalClassDeclaration
   *     EnumDeclaration
   *     RecordDeclaration
   * NormalClassDeclaration:
   *     {ClassModifier} class TypeIdentifier [TypeParameters] [Superclass] [Superinterfaces] ClassBody
   * }</pre>
   *
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.1
   *
   * <pre>{@code
   * InterfaceDeclaration:
   *     NormalInterfaceDeclaration
   *     AnnotationTypeDeclaration
   * NormalInterfaceDeclaration:
   *     {InterfaceModifier} interface TypeIdentifier [TypeParameters] [ExtendsInterfaces] InterfaceBody
   * }</pre>
   */
  public final ClassOrInterfaceDeclaration ClassOrInterfaceDeclaration(ModifierHolder modifier)
      throws ParseException {
    boolean isInterface;
    SimpleName name;
    RangedList<TypeParameter> typePar = new RangedList<TypeParameter>(emptyNodeList());
    NodeList<ClassOrInterfaceType> extList = emptyNodeList();
    NodeList<ClassOrInterfaceType> impList = emptyNodeList();
    NodeList<ClassOrInterfaceType> permitsList = emptyNodeList();
    NodeList<BodyDeclaration<?>> members = emptyNodeList();
    JavaToken begin = modifier.begin;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case CLASS:
        {
          jj_consume_token(CLASS);
          isInterface = false;
          break;
        }
      case INTERFACE:
        {
          jj_consume_token(INTERFACE);
          isInterface = true;
          break;
        }
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    begin = orIfInvalid(begin, token());
    name = SimpleName();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case LT:
        {
          typePar = TypeParameters();
          break;
        }
      default:
        jj_la1[9] = jj_gen;
        ;
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case EXTENDS:
        {
          extList = ExtendsList();
          break;
        }
      default:
        jj_la1[10] = jj_gen;
        ;
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case IMPLEMENTS:
        {
          impList = ImplementsList();
          break;
        }
      default:
        jj_la1[11] = jj_gen;
        ;
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case PERMITS:
        {
          permitsList = PermitsList();
          break;
        }
      default:
        jj_la1[12] = jj_gen;
        ;
    }
    members = ClassOrInterfaceBody();
    {
      if ("" != null)
        return new ClassOrInterfaceDeclaration(
            range(begin, token()),
            modifier.modifiers,
            modifier.annotations,
            isInterface,
            name,
            typePar.list,
            extList,
            impList,
            permitsList,
            members);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se17/html/jls-8.html#jls-8.10
   *
   * <pre>{@code
   * RecordDeclaration:
   *    {ClassModifier} `record` TypeIdentifier [TypeParameters]
   *      RecordHeader [ClassImplements] RecordBody
   *
   *  RecordHeader:
   *   `(` [RecordComponentList] `)`
   *
   *  RecordComponentList:
   *   RecordComponent { `,` RecordComponent}
   *
   *  RecordComponent:
   *   {RecordComponentModifier} UnannType Identifier
   *   VariableArityRecordComponent
   *
   *  VariableArityRecordComponent:
   *   {RecordComponentModifier} UnannType {Annotation} `...` Identifier
   *
   *  RecordComponentModifier:
   *   Annotation
   *
   *  RecordBody:
   *    `{` {RecordBodyDeclaration} `}`
   *
   *  RecordBodyDeclaration:
   *    ClassBodyDeclaration
   *    CompactConstructorDeclaration
   *
   *  CompactConstructorDeclaration:
   *    {ConstructorModifier} SimpleTypeName ConstructorBody
   * }</pre>
   */
  public final RecordDeclaration RecordDeclaration(ModifierHolder modifier) throws ParseException {
    SimpleName name;
    Pair<NodeList<Parameter>, ReceiverParameter> parameters;
    RangedList<TypeParameter> typePar = new RangedList<TypeParameter>(emptyNodeList());
    NodeList<ClassOrInterfaceType> impList = emptyNodeList();
    NodeList<BodyDeclaration<?>> members = emptyNodeList();
    JavaToken begin = modifier.begin;
    jj_consume_token(RECORD);
    begin = orIfInvalid(begin, token());
    name = SimpleName();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case LT:
        {
          typePar = TypeParameters();
          break;
        }
      default:
        jj_la1[13] = jj_gen;
        ;
    }
    parameters = Parameters();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case IMPLEMENTS:
        {
          impList = ImplementsList();
          break;
        }
      default:
        jj_la1[14] = jj_gen;
        ;
    }
    members = RecordBody();
    {
      if ("" != null)
        return new RecordDeclaration(
            range(begin, token()),
            modifier.modifiers,
            modifier.annotations,
            name,
            parameters.a,
            typePar.list,
            impList,
            members,
            parameters.b);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.1.4
   *
   * <pre>{@code
   * Superclass:
   *     extends ClassType
   * }</pre>
   *
   * For convenience: https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.3
   *
   * <pre>{@code
   * ClassOrInterfaceType:
   *     ClassType
   *     InterfaceType
   * ClassType:
   *     {Annotation} TypeIdentifier [TypeArguments]
   *     PackageName . {Annotation} TypeIdentifier [TypeArguments]
   *     ClassOrInterfaceType . {Annotation} TypeIdentifier [TypeArguments]
   * InterfaceType:
   *     ClassType
   * }</pre>
   */
  public final NodeList<ClassOrInterfaceType> ExtendsList() throws ParseException {
    boolean extendsMoreThanOne = false;
    NodeList<ClassOrInterfaceType> ret = new NodeList<ClassOrInterfaceType>();
    ClassOrInterfaceType cit;
    jj_consume_token(EXTENDS);
    cit = AnnotatedClassOrInterfaceType();
    ret.add(cit);
    label_5:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case COMMA:
          {
            break;
          }
        default:
          jj_la1[15] = jj_gen;
          break label_5;
      }
      jj_consume_token(COMMA);
      cit = AnnotatedClassOrInterfaceType();
      ret.add(cit);
      extendsMoreThanOne = true;
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.1.5
   *
   * <pre>{@code
   * Superinterfaces:
   *     implements InterfaceTypeList
   * InterfaceTypeList:
   *     InterfaceType {, InterfaceType}
   * }</pre>
   *
   * For convenience: https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.3
   *
   * <pre>{@code
   * ClassOrInterfaceType:
   *     ClassType
   *     InterfaceType
   * ClassType:
   *     {Annotation} TypeIdentifier [TypeArguments]
   *     PackageName . {Annotation} TypeIdentifier [TypeArguments]
   *     ClassOrInterfaceType . {Annotation} TypeIdentifier [TypeArguments]
   * InterfaceType:
   *     ClassType
   * }</pre>
   */
  public final NodeList<ClassOrInterfaceType> ImplementsList() throws ParseException {
    NodeList<ClassOrInterfaceType> ret = new NodeList<ClassOrInterfaceType>();
    ClassOrInterfaceType cit;
    jj_consume_token(IMPLEMENTS);
    cit = AnnotatedClassOrInterfaceType();
    ret.add(cit);
    label_6:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case COMMA:
          {
            break;
          }
        default:
          jj_la1[16] = jj_gen;
          break label_6;
      }
      jj_consume_token(COMMA);
      cit = AnnotatedClassOrInterfaceType();
      ret.add(cit);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.1.5
   *
   * <pre>{@code
   * ClassPermits:
   *     permits TypeName {, TypeName}
   * }</pre>
   *
   * For convenience: https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.3
   *
   * <pre>{@code
   * ClassOrInterfaceType:
   *     ClassType
   *     InterfaceType
   * ClassType:
   *     {Annotation} TypeIdentifier [TypeArguments]
   *     PackageName . {Annotation} TypeIdentifier [TypeArguments]
   *     ClassOrInterfaceType . {Annotation} TypeIdentifier [TypeArguments]
   * InterfaceType:
   *     ClassType
   * }</pre>
   */
  public final NodeList<ClassOrInterfaceType> PermitsList() throws ParseException {
    NodeList<ClassOrInterfaceType> ret = new NodeList<ClassOrInterfaceType>();
    ClassOrInterfaceType cit;
    jj_consume_token(PERMITS);
    cit = AnnotatedClassOrInterfaceType();
    ret.add(cit);
    label_7:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case COMMA:
          {
            break;
          }
        default:
          jj_la1[17] = jj_gen;
          break label_7;
      }
      jj_consume_token(COMMA);
      cit = AnnotatedClassOrInterfaceType();
      ret.add(cit);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.9
   *
   * <pre>{@code
   * EnumDeclaration:
   *     {ClassModifier} enum TypeIdentifier [Superinterfaces] EnumBody
   * }</pre>
   *
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.9.1
   *
   * <pre>{@code
   * EnumBody:
   *     { [EnumConstantList] [,] [EnumBodyDeclarations] }
   * EnumConstantList:
   *     EnumConstant {, EnumConstant}
   * EnumConstant:
   *     {EnumConstantModifier} Identifier [( [ArgumentList] )] [ClassBody]
   * EnumConstantModifier:
   *     Annotation
   * }</pre>
   *
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.9.2
   *
   * <pre>{@code
   * EnumBodyDeclarations:
   *     ; {ClassBodyDeclaration}
   * }</pre>
   */
  public final EnumDeclaration EnumDeclaration(ModifierHolder modifier) throws ParseException {
    SimpleName name;
    NodeList<ClassOrInterfaceType> impList = emptyNodeList();
    EnumConstantDeclaration entry;
    NodeList<EnumConstantDeclaration> entries = emptyNodeList();
    BodyDeclaration<?> member;
    NodeList<BodyDeclaration<?>> members = emptyNodeList();
    JavaToken begin = modifier.begin;
    jj_consume_token(ENUM);
    begin = orIfInvalid(begin, token());
    name = SimpleName();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case IMPLEMENTS:
        {
          impList = ImplementsList();
          break;
        }
      default:
        jj_la1[18] = jj_gen;
        ;
    }
    jj_consume_token(LBRACE);
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case ENUM:
      case PERMITS:
      case RECORD:
      case SEALED:
      case STRICTFP:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case IDENTIFIER:
      case AT:
        {
          entry = EnumConstantDeclaration();
          entries.add(entry);
          label_8:
          while (true) {
            if (jj_2_4(2)) {
            } else {
              break label_8;
            }
            jj_consume_token(COMMA);
            entry = EnumConstantDeclaration();
            entries.add(entry);
          }
          break;
        }
      default:
        jj_la1[19] = jj_gen;
        ;
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case COMMA:
        {
          jj_consume_token(COMMA);
          break;
        }
      default:
        jj_la1[20] = jj_gen;
        ;
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case SEMICOLON:
        {
          jj_consume_token(SEMICOLON);
          label_9:
          while (true) {
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case ABSTRACT:
              case BOOLEAN:
              case BYTE:
              case CHAR:
              case CLASS:
              case _DEFAULT:
              case DOUBLE:
              case ENUM:
              case FINAL:
              case FLOAT:
              case INT:
              case INTERFACE:
              case LONG:
              case NATIVE:
              case NON_SEALED:
              case PERMITS:
              case PRIVATE:
              case PROTECTED:
              case PUBLIC:
              case RECORD:
              case SEALED:
              case SHORT:
              case STATIC:
              case STRICTFP:
              case SYNCHRONIZED:
              case TRANSIENT:
              case VOID:
              case VOLATILE:
              case YIELD:
              case REQUIRES:
              case TO:
              case WITH:
              case OPEN:
              case OPENS:
              case USES:
              case MODULE:
              case EXPORTS:
              case PROVIDES:
              case TRANSITIVE:
              case WHEN:
              case IDENTIFIER:
              case LBRACE:
              case SEMICOLON:
              case AT:
              case LT:
                {
                  break;
                }
              default:
                jj_la1[21] = jj_gen;
                break label_9;
            }
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case ABSTRACT:
              case BOOLEAN:
              case BYTE:
              case CHAR:
              case CLASS:
              case _DEFAULT:
              case DOUBLE:
              case ENUM:
              case FINAL:
              case FLOAT:
              case INT:
              case INTERFACE:
              case LONG:
              case NATIVE:
              case NON_SEALED:
              case PERMITS:
              case PRIVATE:
              case PROTECTED:
              case PUBLIC:
              case RECORD:
              case SEALED:
              case SHORT:
              case STATIC:
              case STRICTFP:
              case SYNCHRONIZED:
              case TRANSIENT:
              case VOID:
              case VOLATILE:
              case YIELD:
              case REQUIRES:
              case TO:
              case WITH:
              case OPEN:
              case OPENS:
              case USES:
              case MODULE:
              case EXPORTS:
              case PROVIDES:
              case TRANSITIVE:
              case WHEN:
              case IDENTIFIER:
              case LBRACE:
              case AT:
              case LT:
                {
                  member = ClassOrInterfaceBodyDeclaration();
                  members = add(members, member);
                  break;
                }
              case SEMICOLON:
                {
                  jj_consume_token(SEMICOLON);
                  break;
                }
              default:
                jj_la1[22] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
          }
          break;
        }
      default:
        jj_la1[23] = jj_gen;
        ;
    }
    jj_consume_token(RBRACE);
    {
      if ("" != null)
        return new EnumDeclaration(
            range(begin, token()),
            modifier.modifiers,
            modifier.annotations,
            name,
            impList,
            entries,
            members);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that the {@code EnumConstantModifier} is defined as an {@code Annotation}.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.9.1
   *
   * <pre>{@code
   * EnumConstant:
   *     {EnumConstantModifier} Identifier [( [ArgumentList] )] [ClassBody]
   * EnumConstantModifier:
   *     Annotation
   * }</pre>
   *
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.9.2
   *
   * <pre>{@code
   * EnumBodyDeclarations:
   *     ; {ClassBodyDeclaration}
   * }</pre>
   */
  public final EnumConstantDeclaration EnumConstantDeclaration() throws ParseException {
    NodeList<AnnotationExpr> annotations = new NodeList<AnnotationExpr>();
    AnnotationExpr ann;
    SimpleName name;
    NodeList<Expression> args = emptyNodeList();
    NodeList<BodyDeclaration<?>> classBody = emptyNodeList();
    JavaToken begin = INVALID;
    label_10:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case AT:
          {
            break;
          }
        default:
          jj_la1[24] = jj_gen;
          break label_10;
      }
      ann = Annotation();
      annotations = add(annotations, ann);
      begin = orIfInvalid(begin, ann);
    }
    name = SimpleName();
    begin = orIfInvalid(begin, token());
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case LPAREN:
        {
          args = Arguments();
          break;
        }
      default:
        jj_la1[25] = jj_gen;
        ;
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case LBRACE:
        {
          classBody = ClassOrInterfaceBody();
          break;
        }
      default:
        jj_la1[26] = jj_gen;
        ;
    }
    {
      if ("" != null)
        return new EnumConstantDeclaration(
            range(begin, token()), annotations, name, args, classBody);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * If the list inside the returned RangedList is null, there are no brackets. If it is empty,
   * there are brackets, but nothing is in them <>. The normal case is that it contains
   * TypeParameters, like <A, B, C>.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.1.2
   *
   * <pre>{@code
   * TypeParameters:
   *     < TypeParameterList >
   * TypeParameterList:
   *     TypeParameter {, TypeParameter}
   * }</pre>
   *
   * For Convenience: https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.4
   *
   * <pre>{@code
   * TypeParameter:
   *     {TypeParameterModifier} TypeIdentifier [TypeBound]
   * TypeParameterModifier:
   *     Annotation
   * TypeBound:
   *     extends TypeVariable
   *     extends ClassOrInterfaceType {AdditionalBound}
   * AdditionalBound:
   *     & InterfaceType
   * }</pre>
   */
  public final RangedList<TypeParameter> TypeParameters() throws ParseException {
    RangedList<TypeParameter> ret = new RangedList<TypeParameter>(new NodeList<TypeParameter>());
    TypeParameter tp;
    NodeList<AnnotationExpr> annotations;
    jj_consume_token(LT);
    ret.beginAt(token());
    annotations = Annotations();
    tp = TypeParameter(annotations);
    ret.add(tp);
    annotations = null;
    label_11:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case COMMA:
          {
            break;
          }
        default:
          jj_la1[27] = jj_gen;
          break label_11;
      }
      jj_consume_token(COMMA);
      annotations = Annotations();
      tp = TypeParameter(annotations);
      ret.add(tp);
      annotations = null;
    }
    jj_consume_token(GT);
    ret.endAt(token());
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that the {@code TypeParameterModifier} is defined as an {@code Annotation}. Note that the
   * annotations are passed as a parameter to this grammar entry.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.4
   *
   * <pre>{@code
   * TypeParameter:
   *     {TypeParameterModifier} TypeIdentifier [TypeBound]
   * TypeParameterModifier:
   *     Annotation
   * TypeBound:
   *     extends TypeVariable
   *     extends ClassOrInterfaceType {AdditionalBound}
   * AdditionalBound:
   *     & InterfaceType
   * }</pre>
   */
  public final TypeParameter TypeParameter(NodeList<AnnotationExpr> annotations)
      throws ParseException {
    SimpleName name;
    NodeList<ClassOrInterfaceType> typeBound = emptyNodeList();
    JavaToken begin;
    // Annotations are passed as a parameter to this grammar entry.
    name = SimpleName();
    begin = token();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case EXTENDS:
        {
          typeBound = TypeBound();
          break;
        }
      default:
        jj_la1[28] = jj_gen;
        ;
    }
    {
      if ("" != null) return new TypeParameter(range(begin, token()), name, typeBound, annotations);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.4
   *
   * <pre>{@code
   * TypeBound:
   *     extends TypeVariable
   *     extends ClassOrInterfaceType {AdditionalBound}
   * AdditionalBound:
   *     & InterfaceType
   * }</pre>
   *
   * For Convenience: https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.3
   *
   * <pre>{@code
   * ClassOrInterfaceType:
   *     ClassType
   *     InterfaceType
   * ClassType:
   *     {Annotation} TypeIdentifier [TypeArguments]
   *     PackageName . {Annotation} TypeIdentifier [TypeArguments]
   *     ClassOrInterfaceType . {Annotation} TypeIdentifier [TypeArguments]
   * InterfaceType:
   *     ClassType
   * TypeVariable:
   *     {Annotation} TypeIdentifier
   * }</pre>
   */
  public final NodeList<ClassOrInterfaceType> TypeBound() throws ParseException {
    NodeList<ClassOrInterfaceType> ret = emptyNodeList();
    ClassOrInterfaceType cit;
    jj_consume_token(EXTENDS);
    cit = AnnotatedClassOrInterfaceType();
    ret.add(cit);
    label_12:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case BIT_AND:
          {
            break;
          }
        default:
          jj_la1[29] = jj_gen;
          break label_12;
      }
      jj_consume_token(BIT_AND);
      cit = AnnotatedClassOrInterfaceType();
      ret.add(cit);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.1.6
   *
   * <pre>{@code
   * ClassBody:
   *     { {ClassBodyDeclaration} }
   * ClassBodyDeclaration:
   *     ClassMemberDeclaration
   *     InstanceInitializer
   *     StaticInitializer
   *     ConstructorDeclaration
   * ClassMemberDeclaration:
   *     FieldDeclaration
   *     MethodDeclaration
   *     ClassDeclaration
   *     InterfaceDeclaration
   *     ;
   * }</pre>
   *
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.1.4
   *
   * <pre>{@code
   * InterfaceBody:
   *     { {InterfaceMemberDeclaration} }
   * InterfaceMemberDeclaration:
   *     ConstantDeclaration
   *     InterfaceMethodDeclaration
   *     ClassDeclaration
   *     InterfaceDeclaration
   *     ;
   * }</pre>
   */
  public final NodeList<BodyDeclaration<?>> ClassOrInterfaceBody() throws ParseException {
    NodeList<BodyDeclaration<?>> ret = emptyNodeList();
    BodyDeclaration member;
    jj_consume_token(LBRACE);
    label_13:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case ABSTRACT:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CLASS:
        case _DEFAULT:
        case DOUBLE:
        case ENUM:
        case FINAL:
        case FLOAT:
        case INT:
        case INTERFACE:
        case LONG:
        case NATIVE:
        case NON_SEALED:
        case PERMITS:
        case PRIVATE:
        case PROTECTED:
        case PUBLIC:
        case RECORD:
        case SEALED:
        case SHORT:
        case STATIC:
        case STRICTFP:
        case SYNCHRONIZED:
        case TRANSIENT:
        case VOID:
        case VOLATILE:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case IDENTIFIER:
        case LBRACE:
        case SEMICOLON:
        case AT:
        case LT:
          {
            break;
          }
        default:
          jj_la1[30] = jj_gen;
          break label_13;
      }
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case ABSTRACT:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CLASS:
        case _DEFAULT:
        case DOUBLE:
        case ENUM:
        case FINAL:
        case FLOAT:
        case INT:
        case INTERFACE:
        case LONG:
        case NATIVE:
        case NON_SEALED:
        case PERMITS:
        case PRIVATE:
        case PROTECTED:
        case PUBLIC:
        case RECORD:
        case SEALED:
        case SHORT:
        case STATIC:
        case STRICTFP:
        case SYNCHRONIZED:
        case TRANSIENT:
        case VOID:
        case VOLATILE:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case IDENTIFIER:
        case LBRACE:
        case AT:
        case LT:
          {
            member = ClassOrInterfaceBodyDeclaration();
            ret.add(member);
            break;
          }
        case SEMICOLON:
          {
            jj_consume_token(SEMICOLON);
            break;
          }
        default:
          jj_la1[31] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    jj_consume_token(RBRACE);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Everything that can go into a "regular" class or interface declaration, can also (usually) be
   * included within a record. Exceptions to this are handled within the validators.
   *
   * <p>Note: This is HEAVILY based on ClassOrInterfaceBody() and ClassOrInterfaceBodyDeclaration(),
   * and there may be some scope/potential to optimise this and merge some parts together.
   *
   * <p>https://docs.oracle.com/javase/specs/jls/se16/html/jls-8.html#jls-8.10.2
   */
  public final NodeList<BodyDeclaration<?>> RecordBody() throws ParseException {
    NodeList<BodyDeclaration<?>> ret = emptyNodeList();
    BodyDeclaration member;
    jj_consume_token(LBRACE);
    label_14:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case ABSTRACT:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CLASS:
        case _DEFAULT:
        case DOUBLE:
        case ENUM:
        case FINAL:
        case FLOAT:
        case INT:
        case INTERFACE:
        case LONG:
        case NATIVE:
        case NON_SEALED:
        case PERMITS:
        case PRIVATE:
        case PROTECTED:
        case PUBLIC:
        case RECORD:
        case SEALED:
        case SHORT:
        case STATIC:
        case STRICTFP:
        case SYNCHRONIZED:
        case TRANSIENT:
        case VOID:
        case VOLATILE:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case IDENTIFIER:
        case LBRACE:
        case SEMICOLON:
        case AT:
        case LT:
          {
            break;
          }
        default:
          jj_la1[32] = jj_gen;
          break label_14;
      }
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case ABSTRACT:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CLASS:
        case _DEFAULT:
        case DOUBLE:
        case ENUM:
        case FINAL:
        case FLOAT:
        case INT:
        case INTERFACE:
        case LONG:
        case NATIVE:
        case NON_SEALED:
        case PERMITS:
        case PRIVATE:
        case PROTECTED:
        case PUBLIC:
        case RECORD:
        case SEALED:
        case SHORT:
        case STATIC:
        case STRICTFP:
        case SYNCHRONIZED:
        case TRANSIENT:
        case VOID:
        case VOLATILE:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case IDENTIFIER:
        case LBRACE:
        case AT:
        case LT:
          {
            member = RecordBodyDeclaration();
            ret.add(member);
            break;
          }
        case SEMICOLON:
          {
            jj_consume_token(SEMICOLON);
            break;
          }
        default:
          jj_la1[33] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    jj_consume_token(RBRACE);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Almost identical to ClassOrInterfaceBodyDeclaration, but: - with a
   * CompactConstructorDeclaration As a result, there may be some scope/potential to optimize this
   * and merge some parts together.
   *
   * <p>https://docs.oracle.com/javase/specs/jls/se16/html/jls-8.html#jls-8.10.2
   *
   * <pre>{@code
   * RecordBody:
   *     { {RecordBodyDeclaration} }
   * RecordBodyDeclaration:
   *     ClassBodyDeclaration
   *     CompactConstructorDeclaration
   * }</pre>
   *
   * For convenience: https://docs.oracle.com/javase/specs/jls/se16/html/jls-8.html#jls-8.10.2
   *
   * <pre>{@code
   * ClassBodyDeclaration:
   *     ClassMemberDeclaration
   *     InstanceInitializer
   *     StaticInitializer
   *     ConstructorDeclaration
   * ClassMemberDeclaration:
   *     FieldDeclaration
   *     MethodDeclaration
   *     ClassDeclaration
   *     InterfaceDeclaration
   *     ;
   * }</pre>
   */
  public final BodyDeclaration<?> RecordBodyDeclaration() throws ParseException {
    ModifierHolder modifiers;
    BodyDeclaration<?> ret;
    if (jj_2_11(2)) {
      ret = InitializerDeclaration();
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case ABSTRACT:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CLASS:
        case _DEFAULT:
        case DOUBLE:
        case ENUM:
        case FINAL:
        case FLOAT:
        case INT:
        case INTERFACE:
        case LONG:
        case NATIVE:
        case NON_SEALED:
        case PERMITS:
        case PRIVATE:
        case PROTECTED:
        case PUBLIC:
        case RECORD:
        case SEALED:
        case SHORT:
        case STATIC:
        case STRICTFP:
        case SYNCHRONIZED:
        case TRANSIENT:
        case VOID:
        case VOLATILE:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case IDENTIFIER:
        case AT:
        case LT:
          {
            // Just get all the modifiers out of the way. If you want to do
            // more checks, pass the modifiers down to the member
            modifiers = Modifiers();
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case CLASS:
              case INTERFACE:
                {
                  ret = ClassOrInterfaceDeclaration(modifiers);
                  break;
                }
              default:
                jj_la1[34] = jj_gen;
                if (jj_2_5(2147483647)) {
                  ret = EnumDeclaration(modifiers);
                } else if (jj_2_6(2147483647)) {
                  ret = RecordDeclaration(modifiers);
                } else if (jj_2_7(2147483647)) {
                  ret = AnnotationTypeDeclaration(modifiers);
                } else if (jj_2_8(2147483647)) {
                  ret = CompactConstructorDeclaration(modifiers);
                } else if (jj_2_9(2147483647)) {
                  ret = ConstructorDeclaration(modifiers);
                } else if (jj_2_10(2147483647)) {
                  ret = FieldDeclaration(modifiers);
                } else {
                  switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                    case BOOLEAN:
                    case BYTE:
                    case CHAR:
                    case DOUBLE:
                    case ENUM:
                    case FLOAT:
                    case INT:
                    case LONG:
                    case PERMITS:
                    case RECORD:
                    case SEALED:
                    case SHORT:
                    case STRICTFP:
                    case VOID:
                    case YIELD:
                    case REQUIRES:
                    case TO:
                    case WITH:
                    case OPEN:
                    case OPENS:
                    case USES:
                    case MODULE:
                    case EXPORTS:
                    case PROVIDES:
                    case TRANSITIVE:
                    case WHEN:
                    case IDENTIFIER:
                    case AT:
                    case LT:
                      {
                        ret = MethodDeclaration(modifiers);
                        break;
                      }
                    default:
                      jj_la1[35] = jj_gen;
                      jj_consume_token(-1);
                      throw new ParseException();
                  }
                }
            }
            break;
          }
        default:
          jj_la1[36] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://openjdk.java.net/jeps/359#Grammar
   *
   * <pre>{@code
   * CompactConstructorDeclaration:
   *   {Annotation} {ConstructorModifier} [TypeParameters] SimpleTypeName
   *     [Throws] ConstructorBody
   * }</pre>
   */
  public final CompactConstructorDeclaration CompactConstructorDeclaration(ModifierHolder modifier)
      throws ParseException {
    RangedList<TypeParameter> typeParameters = new RangedList<TypeParameter>(emptyNodeList());
    SimpleName name;
    Pair<NodeList<Parameter>, ReceiverParameter> parameters =
        new Pair<NodeList<Parameter>, ReceiverParameter>(emptyNodeList(), null);
    NodeList<ReferenceType> throws_ = emptyNodeList();
    ExplicitConstructorInvocationStmt exConsInv = null;
    NodeList<Statement> stmts = emptyNodeList();
    JavaToken begin = modifier.begin;
    JavaToken blockBegin = INVALID;
    ReferenceType throwType;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case LT:
        {
          typeParameters = TypeParameters();
          begin = orIfInvalid(begin, typeParameters.range.getBegin());
          break;
        }
      default:
        jj_la1[37] = jj_gen;
        ;
    }
    // Modifiers matched in the caller
    name = SimpleName();
    begin = orIfInvalid(begin, typeParameters.range.getBegin());
    begin = orIfInvalid(begin, token());
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case THROWS:
        {
          jj_consume_token(THROWS);
          throwType = AnnotatedReferenceType();
          throws_ = add(throws_, throwType);
          label_15:
          while (true) {
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case COMMA:
                {
                  break;
                }
              default:
                jj_la1[38] = jj_gen;
                break label_15;
            }
            jj_consume_token(COMMA);
            throwType = AnnotatedReferenceType();
            throws_ = add(throws_, throwType);
          }
          break;
        }
      default:
        jj_la1[39] = jj_gen;
        ;
    }
    jj_consume_token(LBRACE);
    blockBegin = token();
    if (jj_2_12(2147483647)) {
      exConsInv = ExplicitConstructorInvocation();
    } else {
      ;
    }
    stmts = Statements();
    jj_consume_token(RBRACE);
    if (exConsInv != null) {
      stmts = prepend(stmts, exConsInv);
    }
    {
      if ("" != null)
        return new CompactConstructorDeclaration(
            range(begin, token()),
            modifier.modifiers,
            modifier.annotations,
            typeParameters.list,
            name,
            throws_,
            new BlockStmt(range(blockBegin, token()), stmts));
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that {@code ClassDeclaration} and {@code InterfaceDeclaration} (in the JLS) include enum
   * and annotation declarations. Note that {@code InstanceInitializer} and {@code
   * StaticInitializer} are treated as an {@code Initializer} with an optional {@code static}
   * modifier in JavaParser. TODO: Investigate the {@code ClassBodyDeclaration} parts existing
   * within an interface - is permitting this a potential problem?
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.1.6
   *
   * <pre>{@code
   * ClassBody:
   *     { {ClassBodyDeclaration} }
   * ClassBodyDeclaration:
   *     ClassMemberDeclaration
   *     InstanceInitializer
   *     StaticInitializer
   *     ConstructorDeclaration
   * ClassMemberDeclaration:
   *     FieldDeclaration
   *     MethodDeclaration
   *     ClassDeclaration
   *     InterfaceDeclaration
   *     ;
   * }</pre>
   *
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.1.4
   *
   * <pre>{@code
   * InterfaceBody:
   *     { {InterfaceMemberDeclaration} }
   * InterfaceMemberDeclaration:
   *     ConstantDeclaration
   *     InterfaceMethodDeclaration
   *     ClassDeclaration
   *     InterfaceDeclaration
   *     ;
   * }</pre>
   */
  public final BodyDeclaration<?> ClassOrInterfaceBodyDeclaration() throws ParseException {
    ModifierHolder modifiers;
    BodyDeclaration<?> ret;
    if (jj_2_18(2)) {
      ret = InitializerDeclaration();
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case ABSTRACT:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CLASS:
        case _DEFAULT:
        case DOUBLE:
        case ENUM:
        case FINAL:
        case FLOAT:
        case INT:
        case INTERFACE:
        case LONG:
        case NATIVE:
        case NON_SEALED:
        case PERMITS:
        case PRIVATE:
        case PROTECTED:
        case PUBLIC:
        case RECORD:
        case SEALED:
        case SHORT:
        case STATIC:
        case STRICTFP:
        case SYNCHRONIZED:
        case TRANSIENT:
        case VOID:
        case VOLATILE:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case IDENTIFIER:
        case AT:
        case LT:
          {
            // Just get all the modifiers out of the way. If you want to do
            // more checks, pass the modifiers down to the member
            modifiers = Modifiers();
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case CLASS:
              case INTERFACE:
                {
                  ret = ClassOrInterfaceDeclaration(modifiers);
                  break;
                }
              default:
                jj_la1[40] = jj_gen;
                if (jj_2_13(2147483647)) {
                  ret = RecordDeclaration(modifiers);
                } else if (jj_2_14(2147483647)) {
                  ret = EnumDeclaration(modifiers);
                } else if (jj_2_15(2147483647)) {
                  ret = AnnotationTypeDeclaration(modifiers);
                } else if (jj_2_16(2147483647)) {
                  ret = ConstructorDeclaration(modifiers);
                } else if (jj_2_17(2147483647)) {
                  ret = FieldDeclaration(modifiers);
                } else {
                  switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                    case BOOLEAN:
                    case BYTE:
                    case CHAR:
                    case DOUBLE:
                    case ENUM:
                    case FLOAT:
                    case INT:
                    case LONG:
                    case PERMITS:
                    case RECORD:
                    case SEALED:
                    case SHORT:
                    case STRICTFP:
                    case VOID:
                    case YIELD:
                    case REQUIRES:
                    case TO:
                    case WITH:
                    case OPEN:
                    case OPENS:
                    case USES:
                    case MODULE:
                    case EXPORTS:
                    case PROVIDES:
                    case TRANSITIVE:
                    case WHEN:
                    case IDENTIFIER:
                    case AT:
                    case LT:
                      {
                        ret = MethodDeclaration(modifiers);
                        break;
                      }
                    default:
                      jj_la1[41] = jj_gen;
                      jj_consume_token(-1);
                      throw new ParseException();
                  }
                }
            }
            break;
          }
        default:
          jj_la1[42] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.3
   *
   * <pre>{@code
   * FieldDeclaration:
   *     {FieldModifier} UnannType VariableDeclaratorList ;
   * VariableDeclaratorList:
   *     VariableDeclarator {, VariableDeclarator}
   * VariableDeclarator:
   *     VariableDeclaratorId [= VariableInitializer]
   * VariableDeclaratorId:
   *     Identifier [Dims]
   * VariableInitializer:
   *     Expression
   *     ArrayInitializer
   * }</pre>
   */
  public final FieldDeclaration FieldDeclaration(ModifierHolder modifier) throws ParseException {
    Type partialType;
    NodeList<VariableDeclarator> variables = new NodeList<VariableDeclarator>();
    VariableDeclarator val;
    // Modifiers are already matched in the caller
    partialType = Type(emptyNodeList());
    val = VariableDeclarator(partialType);
    variables.add(val);
    label_16:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case COMMA:
          {
            break;
          }
        default:
          jj_la1[43] = jj_gen;
          break label_16;
      }
      jj_consume_token(COMMA);
      val = VariableDeclarator(partialType);
      variables.add(val);
    }
    jj_consume_token(SEMICOLON);
    JavaToken begin = orIfInvalid(modifier.begin, partialType);
    {
      if ("" != null)
        return new FieldDeclaration(
            range(begin, token()), modifier.modifiers, modifier.annotations, variables);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.3
   *
   * <pre>{@code
   * VariableDeclarator:
   *     VariableDeclaratorId [= VariableInitializer]
   * VariableDeclaratorId:
   *     Identifier [Dims]
   * VariableInitializer:
   *     Expression
   *     ArrayInitializer
   * }</pre>
   */
  public final VariableDeclarator VariableDeclarator(Type partialType) throws ParseException {
    Pair<SimpleName, List<ArrayBracketPair>> id;
    Expression init = null;
    id = VariableDeclaratorId();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case ASSIGN:
        {
          jj_consume_token(ASSIGN);
          init = VariableInitializer();
          break;
        }
      default:
        jj_la1[44] = jj_gen;
        ;
    }
    {
      if ("" != null)
        return new VariableDeclarator(
            range(id.a, token()), juggleArrayType(partialType, id.b), id.a, init);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.3
   *
   * <pre>{@code
   * VariableDeclaratorId:
   *     Identifier [Dims]
   * }</pre>
   *
   * For convenience: https://docs.oracle.com/javase/specs/jls/se15/html/jls-3.html#jls-Identifier
   *
   * <pre>{@code
   * Identifier:
   *     IdentifierChars but not a Keyword or BooleanLiteral or NullLiteral
   * IdentifierChars:
   *     JavaLetter {JavaLetterOrDigit}
   * JavaLetter:
   *     any Unicode character that is a "Java letter"
   * JavaLetterOrDigit:
   *     any Unicode character that is a "Java letter-or-digit"
   * }</pre>
   *
   * For convenience: https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-Dims
   *
   * <pre>{@code
   * Dims:
   *     {Annotation} [ ] {{Annotation} [ ]}
   * }</pre>
   */
  public final Pair<SimpleName, List<ArrayBracketPair>> VariableDeclaratorId()
      throws ParseException {
    SimpleName name;
    JavaToken begin;
    ArrayBracketPair arrayBracketPair;
    List<ArrayBracketPair> arrayBracketPairs = new ArrayList<ArrayBracketPair>(0);
    name = SimpleName();
    begin = token();
    label_17:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case LBRACKET:
        case AT:
          {
            break;
          }
        default:
          jj_la1[45] = jj_gen;
          break label_17;
      }
      arrayBracketPair = ArrayBracketPair(Origin.NAME);
      arrayBracketPairs = add(arrayBracketPairs, arrayBracketPair);
    }
    if (storeTokens) {
      name.setTokenRange(name.getTokenRange().get().withEnd(token()));
    }
    {
      if ("" != null) return new Pair(name, arrayBracketPairs);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.3
   *
   * <pre>{@code
   * VariableInitializer:
   *     Expression
   *     ArrayInitializer
   * }</pre>
   */
  public final Expression VariableInitializer() throws ParseException {
    Expression ret;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case LBRACE:
        {
          ret = ArrayInitializer();
          break;
        }
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case DOUBLE:
      case ENUM:
      case FALSE:
      case FLOAT:
      case INT:
      case LONG:
      case NEW:
      case NULL:
      case PERMITS:
      case RECORD:
      case SEALED:
      case SHORT:
      case STRICTFP:
      case SUPER:
      case SWITCH:
      case THIS:
      case TRUE:
      case VOID:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case LONG_LITERAL:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case CHARACTER_LITERAL:
      case STRING_LITERAL:
      case TEXT_BLOCK_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case AT:
      case BANG:
      case TILDE:
      case INCR:
      case DECR:
      case PLUS:
      case MINUS:
        {
          ret = Expression();
          break;
        }
      default:
        jj_la1[46] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * An array initializer is written as a comma-separated list of expressions, enclosed by braces {
   * and }. A trailing comma may appear after the last expression in an array initializer and is
   * ignored. https://docs.oracle.com/javase/specs/jls/se15/html/jls-10.html#jls-10.6
   *
   * <pre>{@code
   * ArrayInitializer:
   *     { [VariableInitializerList] [,] }
   * VariableInitializerList:
   *     VariableInitializer {, VariableInitializer}
   * }</pre>
   *
   * <pre>{@code
   * VariableInitializer:
   *     Expression
   *     ArrayInitializer
   * }</pre>
   */
  public final ArrayInitializerExpr ArrayInitializer() throws ParseException {
    NodeList<Expression> values = emptyNodeList();
    Expression val;
    JavaToken begin;
    jj_consume_token(LBRACE);
    begin = token();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case DOUBLE:
      case ENUM:
      case FALSE:
      case FLOAT:
      case INT:
      case LONG:
      case NEW:
      case NULL:
      case PERMITS:
      case RECORD:
      case SEALED:
      case SHORT:
      case STRICTFP:
      case SUPER:
      case SWITCH:
      case THIS:
      case TRUE:
      case VOID:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case LONG_LITERAL:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case CHARACTER_LITERAL:
      case STRING_LITERAL:
      case TEXT_BLOCK_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case LBRACE:
      case AT:
      case BANG:
      case TILDE:
      case INCR:
      case DECR:
      case PLUS:
      case MINUS:
        {
          val = VariableInitializer();
          values = add(values, val);
          label_18:
          while (true) {
            if (jj_2_19(2)) {
            } else {
              break label_18;
            }
            jj_consume_token(COMMA);
            val = VariableInitializer();
            values = add(values, val);
          }
          break;
        }
      default:
        jj_la1[47] = jj_gen;
        ;
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case COMMA:
        {
          jj_consume_token(COMMA);
          break;
        }
      default:
        jj_la1[48] = jj_gen;
        ;
    }
    jj_consume_token(RBRACE);
    {
      if ("" != null) return new ArrayInitializerExpr(range(begin, token()), values);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.4
   *
   * <pre>{@code
   * MethodDeclaration:
   *     {MethodModifier} MethodHeader MethodBody
   * MethodHeader:
   *     Result MethodDeclarator [Throws]
   *     TypeParameters {Annotation} Result MethodDeclarator [Throws]
   * MethodDeclarator:
   *     Identifier ( [ReceiverParameter ,] [FormalParameterList] ) [Dims]
   * ReceiverParameter:
   *     {Annotation} UnannType [Identifier .] this
   * }</pre>
   */
  public final MethodDeclaration MethodDeclaration(ModifierHolder modifier) throws ParseException {
    RangedList<TypeParameter> typeParameters = new RangedList<TypeParameter>(emptyNodeList());
    Type type;
    SimpleName name;
    Pair<NodeList<Parameter>, ReceiverParameter> parameters =
        new Pair<NodeList<Parameter>, ReceiverParameter>(emptyNodeList(), null);
    ArrayBracketPair arrayBracketPair;
    List<ArrayBracketPair> arrayBracketPairs = new ArrayList<ArrayBracketPair>(0);
    NodeList<ReferenceType> throws_ = emptyNodeList();
    BlockStmt body = null;
    NodeList<AnnotationExpr> annotations;
    JavaToken begin = modifier.begin;
    ReferenceType throwType;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case LT:
        {
          typeParameters = TypeParameters();
          begin = orIfInvalid(begin, typeParameters.range.getBegin());
          break;
        }
      default:
        jj_la1[49] = jj_gen;
        ;
    }
    annotations = Annotations();
    modifier.annotations.addAll(annotations);
    begin = orIfInvalid(begin, nodeListBegin(annotations));
    type = ResultType(emptyNodeList());
    begin = orIfInvalid(begin, type);
    name = SimpleName();
    parameters = Parameters();
    label_19:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case LBRACKET:
        case AT:
          {
            break;
          }
        default:
          jj_la1[50] = jj_gen;
          break label_19;
      }
      arrayBracketPair = ArrayBracketPair(Origin.NAME);
      arrayBracketPairs = add(arrayBracketPairs, arrayBracketPair);
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case THROWS:
        {
          jj_consume_token(THROWS);
          throwType = AnnotatedReferenceType();
          throws_ = add(throws_, throwType);
          label_20:
          while (true) {
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case COMMA:
                {
                  break;
                }
              default:
                jj_la1[51] = jj_gen;
                break label_20;
            }
            jj_consume_token(COMMA);
            throwType = AnnotatedReferenceType();
            throws_ = add(throws_, throwType);
          }
          break;
        }
      default:
        jj_la1[52] = jj_gen;
        ;
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case LBRACE:
        {
          body = Block();
          break;
        }
      case SEMICOLON:
        {
          jj_consume_token(SEMICOLON);
          break;
        }
      default:
        jj_la1[53] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    type = juggleArrayType(type, arrayBracketPairs);
    {
      if ("" != null)
        return new MethodDeclaration(
            range(begin, token()),
            modifier.modifiers,
            modifier.annotations,
            typeParameters.list,
            type,
            name,
            parameters.a,
            throws_,
            body,
            parameters.b);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  // TODO: JLS Has type and unannotated type, while JavaParser has type and annotated type.
  public final ReferenceType AnnotatedReferenceType() throws ParseException {
    NodeList<AnnotationExpr> annotations;
    ReferenceType type;
    annotations = Annotations();
    type = ReferenceType(annotations);
    {
      if ("" != null) return type;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  // TODO: JLS Has type and unannotated type, while JavaParser has type and annotated type.
  public final Type AnnotatedType() throws ParseException {
    NodeList<AnnotationExpr> annotations;
    Type type;
    annotations = Annotations();
    type = Type(annotations);
    {
      if ("" != null) return type;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * The JLS refers to parameters as {@code FormalParameter}.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.4.1
   *
   * <pre>{@code
   * FormalParameterList:
   *     FormalParameter {, FormalParameter}
   * FormalParameter:
   *     {VariableModifier} UnannType VariableDeclaratorId
   *     VariableArityParameter
   * VariableArityParameter:
   *     {VariableModifier} UnannType {Annotation} ... Identifier
   * VariableModifier:
   *     Annotation
   *     final
   * }</pre>
   *
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.4
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-ReceiverParameter
   *
   * <pre>{@code
   * MethodDeclarator:
   *     Identifier ( [ReceiverParameter ,] [FormalParameterList] ) [Dims]
   * ReceiverParameter:
   *     {Annotation} UnannType [Identifier .] this
   * }</pre>
   */
  public final Pair<NodeList<Parameter>, ReceiverParameter> Parameters() throws ParseException {
    NodeList<Parameter> ret = emptyNodeList();
    Parameter par;
    ReceiverParameter rp = null;
    jj_consume_token(LPAREN);
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case ABSTRACT:
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case _DEFAULT:
      case DOUBLE:
      case ENUM:
      case FINAL:
      case FLOAT:
      case INT:
      case LONG:
      case NATIVE:
      case NON_SEALED:
      case PERMITS:
      case PRIVATE:
      case PROTECTED:
      case PUBLIC:
      case RECORD:
      case SEALED:
      case SHORT:
      case STATIC:
      case STRICTFP:
      case SYNCHRONIZED:
      case TRANSIENT:
      case VOLATILE:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case IDENTIFIER:
      case AT:
        {
          if (jj_2_20(2147483647)) {
            rp = ReceiverParameter();
          } else {
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case ABSTRACT:
              case BOOLEAN:
              case BYTE:
              case CHAR:
              case _DEFAULT:
              case DOUBLE:
              case ENUM:
              case FINAL:
              case FLOAT:
              case INT:
              case LONG:
              case NATIVE:
              case NON_SEALED:
              case PERMITS:
              case PRIVATE:
              case PROTECTED:
              case PUBLIC:
              case RECORD:
              case SEALED:
              case SHORT:
              case STATIC:
              case STRICTFP:
              case SYNCHRONIZED:
              case TRANSIENT:
              case VOLATILE:
              case YIELD:
              case REQUIRES:
              case TO:
              case WITH:
              case OPEN:
              case OPENS:
              case USES:
              case MODULE:
              case EXPORTS:
              case PROVIDES:
              case TRANSITIVE:
              case WHEN:
              case IDENTIFIER:
              case AT:
                {
                  par = Parameter();
                  ret = add(ret, par);
                  break;
                }
              default:
                jj_la1[54] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
          }
          label_21:
          while (true) {
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case COMMA:
                {
                  break;
                }
              default:
                jj_la1[55] = jj_gen;
                break label_21;
            }
            jj_consume_token(COMMA);
            par = Parameter();
            ret = add(ret, par);
          }
          break;
        }
      default:
        jj_la1[56] = jj_gen;
        ;
    }
    jj_consume_token(RPAREN);
    {
      if ("" != null) return new Pair(ret, rp);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note: Similar, but not identical to, {@code FormalParameter}. Note: Distinction between {@code
   * LambdaParameters} and {@code InferredLambdaParameters} is presence of types.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.27.1
   *
   * <pre>{@code
   * LambdaParameters:
   *     ( [LambdaParameterList] )
   *     Identifier
   * LambdaParameterList:
   *     LambdaParameter {, LambdaParameter}
   *     Identifier {, Identifier}
   * LambdaParameter:
   *     {VariableModifier} LambdaParameterType VariableDeclaratorId
   *     VariableArityParameter
   * LambdaParameterType:
   *     UnannType
   *     var
   * }</pre>
   *
   * For Convenience:
   *
   * <pre>{@code
   * VariableArityParameter:
   *      {VariableModifier} UnannType {Annotation} ... Identifier
   * VariableModifier:
   *     Annotation
   *     final
   * VariableDeclaratorId:
   *     Identifier [Dims]
   * Dims:
   *     {Annotation} [ ] {{Annotation} [ ]}
   * }</pre>
   */
  public final NodeList<Parameter> LambdaParameters() throws ParseException {
    NodeList<Parameter> ret = null;
    Parameter par;
    par = Parameter();
    ret = add(ret, par);
    label_22:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case COMMA:
          {
            break;
          }
        default:
          jj_la1[57] = jj_gen;
          break label_22;
      }
      jj_consume_token(COMMA);
      par = Parameter();
      ret = add(ret, par);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note: Similar, but not identical to, {@code FormalParameter}. Note: Distinction between {@code
   * LambdaParameters} and {@code InferredLambdaParameters} is presence of types.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.27.1
   *
   * <pre>{@code
   * LambdaParameters:
   *     ( [LambdaParameterList] )
   *     Identifier
   * LambdaParameterList:
   *     LambdaParameter {, LambdaParameter}
   *     Identifier {, Identifier}
   * LambdaParameter:
   *     {VariableModifier} LambdaParameterType VariableDeclaratorId
   *     VariableArityParameter
   * LambdaParameterType:
   *     UnannType
   *     var
   * }</pre>
   *
   * For Convenience:
   *
   * <pre>{@code
   * VariableArityParameter:
   *      {VariableModifier} UnannType {Annotation} ... Identifier
   * VariableModifier:
   *     Annotation
   *     final
   * VariableDeclaratorId:
   *     Identifier [Dims]
   * Dims:
   *     {Annotation} [ ] {{Annotation} [ ]}
   * }</pre>
   */
  public final NodeList<Parameter> InferredLambdaParameters() throws ParseException {
    NodeList<Parameter> ret = null;
    Pair<SimpleName, List<ArrayBracketPair>> id;
    id = VariableDeclaratorId();
    ret =
        add(
            ret,
            new Parameter(
                range(id.a, id.a),
                new NodeList<Modifier>(),
                emptyNodeList(),
                new UnknownType(),
                false,
                emptyNodeList(),
                id.a));
    label_23:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case COMMA:
          {
            break;
          }
        default:
          jj_la1[58] = jj_gen;
          break label_23;
      }
      jj_consume_token(COMMA);
      id = VariableDeclaratorId();
      ret =
          add(
              ret,
              new Parameter(
                  range(id.a, id.a),
                  new NodeList<Modifier>(),
                  emptyNodeList(),
                  new UnknownType(),
                  false,
                  emptyNodeList(),
                  id.a));
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.4.1
   *
   * <pre>{@code
   * FormalParameter:
   *     {VariableModifier} UnannType VariableDeclaratorId
   *     VariableArityParameter
   * VariableArityParameter:
   *     {VariableModifier} UnannType {Annotation} ... Identifier
   * VariableModifier:
   *     Annotation
   *     final
   * }</pre>
   */
  public final Parameter Parameter() throws ParseException {
    ModifierHolder modifier;
    Type partialType;
    boolean isVarArg = false;
    Pair<SimpleName, List<ArrayBracketPair>> id;
    NodeList<AnnotationExpr> varArgAnnotations = emptyNodeList();
    modifier = Modifiers();
    partialType = Type(emptyNodeList());
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case ELLIPSIS:
      case AT:
        {
          varArgAnnotations = Annotations();
          jj_consume_token(ELLIPSIS);
          isVarArg = true;
          break;
        }
      default:
        jj_la1[59] = jj_gen;
        ;
    }
    id = VariableDeclaratorId();
    JavaToken begin = orIfInvalid(modifier.begin, partialType);
    {
      if ("" != null)
        return new Parameter(
            range(begin, token()),
            modifier.modifiers,
            modifier.annotations,
            juggleArrayType(partialType, id.b),
            isVarArg,
            varArgAnnotations,
            id.a);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.4
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-ReceiverParameter
   *
   * <pre>{@code
   * MethodDeclarator:
   *     Identifier ( [ReceiverParameter ,] [FormalParameterList] ) [Dims]
   * ReceiverParameter:
   *     {Annotation} UnannType [Identifier .] this
   * }</pre>
   */
  public final ReceiverParameter ReceiverParameter() throws ParseException {
    Type partialType;
    Name id;
    NodeList<AnnotationExpr> annotations = emptyNodeList();
    annotations = Annotations();
    partialType = Type(emptyNodeList());
    id = ReceiverParameterId();
    {
      if ("" != null)
        return new ReceiverParameter(range(partialType, token()), annotations, partialType, id);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.4
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-ReceiverParameter
   *
   * <pre>{@code
   * MethodDeclarator:
   *     Identifier ( [ReceiverParameter ,] [FormalParameterList] ) [Dims]
   * ReceiverParameter:
   *     {Annotation} UnannType [Identifier .] this
   * }</pre>
   */
  public final Name ReceiverParameterId() throws ParseException {
    Name ret = null;
    if (jj_2_21(2147483647)) {
      ret = Name();
      jj_consume_token(DOT);
    } else {
      ;
    }
    jj_consume_token(THIS);
    {
      if ("" != null) return new Name(tokenRange(), ret, token.image);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.8
   *
   * <pre>{@code
   * ConstructorDeclaration:
   *     {ConstructorModifier} ConstructorDeclarator [Throws] ConstructorBody
   * ConstructorDeclarator:
   *     [TypeParameters] SimpleTypeName ( [ReceiverParameter ,] [FormalParameterList] )
   * SimpleTypeName:
   *     TypeIdentifier
   * }</pre>
   *
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.8.7
   *
   * <pre>{@code
   * ConstructorBody:
   *     { [ExplicitConstructorInvocation] [BlockStatements] }
   * }</pre>
   *
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.8.7.1
   *
   * <pre>{@code
   * ExplicitConstructorInvocation:
   *     [TypeArguments] this ( [ArgumentList] ) ;
   *     [TypeArguments] super ( [ArgumentList] ) ;
   *     ExpressionName . [TypeArguments] super ( [ArgumentList] ) ;
   *     Primary . [TypeArguments] super ( [ArgumentList] ) ;
   * }</pre>
   */
  public final ConstructorDeclaration ConstructorDeclaration(ModifierHolder modifier)
      throws ParseException {
    RangedList<TypeParameter> typeParameters = new RangedList<TypeParameter>(emptyNodeList());
    SimpleName name;
    Pair<NodeList<Parameter>, ReceiverParameter> parameters =
        new Pair<NodeList<Parameter>, ReceiverParameter>(emptyNodeList(), null);
    NodeList<ReferenceType> throws_ = emptyNodeList();
    ExplicitConstructorInvocationStmt exConsInv = null;
    NodeList<Statement> stmts = emptyNodeList();
    JavaToken begin = modifier.begin;
    JavaToken blockBegin = INVALID;
    ReferenceType throwType;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case LT:
        {
          typeParameters = TypeParameters();
          begin = orIfInvalid(begin, typeParameters.range.getBegin());
          break;
        }
      default:
        jj_la1[60] = jj_gen;
        ;
    }
    // Modifiers matched in the caller
    name = SimpleName();
    begin = orIfInvalid(begin, typeParameters.range.getBegin());
    begin = orIfInvalid(begin, token());
    parameters = Parameters();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case THROWS:
        {
          jj_consume_token(THROWS);
          throwType = AnnotatedReferenceType();
          throws_ = add(throws_, throwType);
          label_24:
          while (true) {
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case COMMA:
                {
                  break;
                }
              default:
                jj_la1[61] = jj_gen;
                break label_24;
            }
            jj_consume_token(COMMA);
            throwType = AnnotatedReferenceType();
            throws_ = add(throws_, throwType);
          }
          break;
        }
      default:
        jj_la1[62] = jj_gen;
        ;
    }
    jj_consume_token(LBRACE);
    blockBegin = token();
    if (jj_2_22(2147483647)) {
      exConsInv = ExplicitConstructorInvocation();
    } else {
      ;
    }
    stmts = Statements();
    jj_consume_token(RBRACE);
    if (exConsInv != null) {
      stmts = prepend(stmts, exConsInv);
    }
    {
      if ("" != null)
        return new ConstructorDeclaration(
            range(begin, token()),
            modifier.modifiers,
            modifier.annotations,
            typeParameters.list,
            name,
            parameters.a,
            throws_,
            new BlockStmt(range(blockBegin, token()), stmts),
            parameters.b);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.8.7.1
   *
   * <pre>{@code
   * ExplicitConstructorInvocation:
   *     [TypeArguments] this ( [ArgumentList] ) ;
   *     [TypeArguments] super ( [ArgumentList] ) ;
   *     ExpressionName . [TypeArguments] super ( [ArgumentList] ) ;
   *     Primary . [TypeArguments] super ( [ArgumentList] ) ;
   * }</pre>
   *
   * The same, but aligned on {@code super}, to emphasise how this grammar relates:
   *
   * <pre>{@code
   * ExplicitConstructorInvocation:
   *     [TypeArguments] this ( [ArgumentList] ) ;
   *                      [TypeArguments] super ( [ArgumentList] ) ;
   *     ExpressionName . [TypeArguments] super ( [ArgumentList] ) ;
   *            Primary . [TypeArguments] super ( [ArgumentList] ) ;
   * }</pre>
   */
  public final ExplicitConstructorInvocationStmt ExplicitConstructorInvocation()
      throws ParseException {
    boolean isThis = false;
    NodeList<Expression> args;
    Expression expr = null;
    RangedList<Type> typeArgs = new RangedList<Type>(null);
    JavaToken begin = INVALID;
    if (jj_2_24(2147483647)) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case LT:
          {
            typeArgs = TypeArguments();
            begin = typeArgs.range.getBegin();
            break;
          }
        default:
          jj_la1[63] = jj_gen;
          ;
      }
      jj_consume_token(THIS);
      begin = orIfInvalid(begin, token());
      isThis = true;
      args = Arguments();
      jj_consume_token(SEMICOLON);
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case DOUBLE:
        case ENUM:
        case FALSE:
        case FLOAT:
        case INT:
        case LONG:
        case NEW:
        case NULL:
        case PERMITS:
        case RECORD:
        case SEALED:
        case SHORT:
        case STRICTFP:
        case SUPER:
        case THIS:
        case TRUE:
        case VOID:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case LONG_LITERAL:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case TEXT_BLOCK_LITERAL:
        case IDENTIFIER:
        case LPAREN:
        case AT:
        case LT:
          {
            if (jj_2_23(2147483647)) {
              expr = PrimaryExpressionWithoutSuperSuffix();
              jj_consume_token(DOT);
              begin = orIfInvalid(begin, expr);
            } else {
              ;
            }
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case LT:
                {
                  typeArgs = TypeArguments();
                  begin = orIfInvalid(begin, typeArgs.range.getBegin());
                  break;
                }
              default:
                jj_la1[64] = jj_gen;
                ;
            }
            jj_consume_token(SUPER);
            begin = orIfInvalid(begin, token());
            args = Arguments();
            jj_consume_token(SEMICOLON);
            break;
          }
        default:
          jj_la1[65] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    {
      if ("" != null)
        return new ExplicitConstructorInvocationStmt(
            range(begin, token()), typeArgs.list, isThis, expr, args);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.5
   *
   * <pre>{@code
   * Statement:
   *     StatementWithoutTrailingSubstatement
   *     LabeledStatement
   *     IfThenStatement
   *     IfThenElseStatement
   *     WhileStatement
   *     ForStatement
   * StatementNoShortIf:
   *     StatementWithoutTrailingSubstatement
   *     LabeledStatementNoShortIf
   *     IfThenElseStatementNoShortIf
   *     WhileStatementNoShortIf
   *     ForStatementNoShortIf
   * StatementWithoutTrailingSubstatement:
   *     Block
   *     EmptyStatement
   *     ExpressionStatement
   *     AssertStatement
   *     SwitchStatement
   *     DoStatement
   *     BreakStatement
   *     ContinueStatement
   *     ReturnStatement
   *     SynchronizedStatement
   *     ThrowStatement
   *     TryStatement
   *     YieldStatement
   * }</pre>
   */
  public final NodeList<Statement> Statements() throws ParseException {
    NodeList<Statement> ret = emptyNodeList();
    Statement stmt;
    label_25:
    while (true) {
      if (jj_2_25(2)) {
      } else {
        break label_25;
      }
      stmt = BlockStatement();
      ret = add(ret, stmt);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.6
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.
   *
   * <pre>{@code
   * InstanceInitializer:
   *     Block
   * }</pre>
   *
   * <pre>{@code
   * StaticInitializer:
   *     static Block
   * }</pre>
   */
  public final InitializerDeclaration InitializerDeclaration() throws ParseException {
    BlockStmt body;
    JavaToken begin = INVALID;
    boolean isStatic = false;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case STATIC:
        {
          jj_consume_token(STATIC);
          isStatic = true;
          begin = token();
          break;
        }
      default:
        jj_la1[66] = jj_gen;
        ;
    }
    body = Block();
    begin = orIfInvalid(begin, body);
    {
      if ("" != null) return new InitializerDeclaration(range(begin, token()), isStatic, body);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /*
   * Type, name and expression syntax follows.
   */

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.1
   * <pre>{@code
   *     Type:
   *         PrimitiveType
   *         ReferenceType
   * }<pre>
   */
  public final Type Type(NodeList<AnnotationExpr> annotations) throws ParseException {
    Type ret;
    if (jj_2_26(2147483647)) {
      ret = ReferenceType(annotations);
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case DOUBLE:
        case FLOAT:
        case INT:
        case LONG:
        case SHORT:
          {
            ret = PrimitiveType(annotations);
            break;
          }
        default:
          jj_la1[67] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * // TODO: JLS Has type and unannotated type, while JavaParser has type and annotated type.
   * Note that an array of primitives is considered a reference type.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.1
   * <pre>{@code
   *     ReferenceType:
   *         ClassOrInterfaceType
   *         TypeVariable
   *         ArrayType
   *     ClassOrInterfaceType:
   *         ClassType
   *         InterfaceType
   *     ClassType:
   *         {Annotation} TypeIdentifier [TypeArguments]
   *         PackageName . {Annotation} TypeIdentifier [TypeArguments]
   *         ClassOrInterfaceType . {Annotation} TypeIdentifier [TypeArguments]
   *     InterfaceType:
   *         ClassType
   *     TypeVariable:
   *         {Annotation} TypeIdentifier
   *     ArrayType:
   *         PrimitiveType Dims
   *         ClassOrInterfaceType Dims
   *         TypeVariable Dims
   *     Dims:
   *         {Annotation} [ ] {{Annotation} [ ]}
   * }<pre>
   */
  public final ReferenceType ReferenceType(NodeList<AnnotationExpr> annotations)
      throws ParseException {
    Type type;
    ArrayBracketPair arrayBracketPair;
    List<ArrayBracketPair> arrayBracketPairs = new ArrayList<ArrayBracketPair>(0);
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case DOUBLE:
      case FLOAT:
      case INT:
      case LONG:
      case SHORT:
        {
          // Note that an array of primitives is considered a reference type.
          type = PrimitiveType(annotations);
          label_26:
          while (true) {
            arrayBracketPair = ArrayBracketPair(Origin.TYPE);
            arrayBracketPairs = add(arrayBracketPairs, arrayBracketPair);
            if (jj_2_27(2147483647)) {
            } else {
              break label_26;
            }
          }
          break;
        }
      case ENUM:
      case PERMITS:
      case RECORD:
      case SEALED:
      case STRICTFP:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case IDENTIFIER:
        {
          type = ClassOrInterfaceType(annotations);
          label_27:
          while (true) {
            if (jj_2_28(2147483647)) {
            } else {
              break label_27;
            }
            arrayBracketPair = ArrayBracketPair(Origin.TYPE);
            arrayBracketPairs = add(arrayBracketPairs, arrayBracketPair);
          }
          break;
        }
      default:
        jj_la1[68] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return (ReferenceType) wrapInArrayTypes(type, arrayBracketPairs);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Array bracket pairs is referred to as {@code Dims} within the JLS.
   *
   * <pre>{@code
   * Dims:
   *     {Annotation} [ ] {{Annotation} [ ]}
   * }</pre>
   */
  public final ArrayBracketPair ArrayBracketPair(Origin origin) throws ParseException {
    NodeList<AnnotationExpr> annotations;
    JavaToken begin = INVALID;
    annotations = Annotations();
    jj_consume_token(LBRACKET);
    begin = orIfInvalid(begin, token());
    jj_consume_token(RBRACKET);
    {
      if ("" != null) return new ArrayBracketPair(range(begin, token()), origin, annotations);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.9
   *
   * <blockquote>
   *
   * An intersection type takes the form T1 & ... & Tn (n > 0), where Ti (1 ≤ i ≤ n) are types.
   *
   * </blockquote>
   */
  public final IntersectionType IntersectionType(NodeList<AnnotationExpr> annotations)
      throws ParseException {
    JavaToken begin = INVALID;
    ReferenceType elementType;
    NodeList<ReferenceType> elements = emptyNodeList();
    elementType = ReferenceType(annotations);
    begin = orIfInvalid(begin, elementType);
    elements = add(elements, elementType);
    jj_consume_token(BIT_AND);
    label_28:
    while (true) {
      elementType = AnnotatedReferenceType();
      elements = add(elements, elementType);
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case DOUBLE:
        case ENUM:
        case FLOAT:
        case INT:
        case LONG:
        case PERMITS:
        case RECORD:
        case SEALED:
        case SHORT:
        case STRICTFP:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case IDENTIFIER:
        case AT:
          {
            break;
          }
        default:
          jj_la1[69] = jj_gen;
          break label_28;
      }
    }
    {
      if ("" != null) return new IntersectionType(range(begin, token()), elements);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  // TODO: JLS Has type and unannotated type, while JavaParser has type and annotated type.
  public final ClassOrInterfaceType AnnotatedClassOrInterfaceType() throws ParseException {
    NodeList<AnnotationExpr> annotations = new NodeList<AnnotationExpr>();
    ClassOrInterfaceType cit;
    annotations = Annotations();
    cit = ClassOrInterfaceType(annotations);
    {
      if ("" != null) return cit;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  // TODO: JLS Has type and unannotated type, while JavaParser has type and annotated type.
  public final ClassOrInterfaceType ClassOrInterfaceType(NodeList<AnnotationExpr> firstAnnotations)
      throws ParseException {
    ClassOrInterfaceType ret;
    SimpleName name;
    RangedList<Type> typeArgs = new RangedList<Type>(null);
    JavaToken begin;
    NodeList<AnnotationExpr> annotations = new NodeList<AnnotationExpr>();
    name = SimpleName();
    begin = token();
    if (jj_2_29(2)) {
      typeArgs = TypeArguments();
    } else {
      ;
    }
    ret =
        new ClassOrInterfaceType(
            range(begin, token()), null, name, typeArgs.list, firstAnnotations);
    typeArgs = new RangedList<Type>(null);
    label_29:
    while (true) {
      if (jj_2_30(2)) {
      } else {
        break label_29;
      }
      jj_consume_token(DOT);
      annotations = Annotations();
      name = SimpleName();
      if (jj_2_31(2)) {
        typeArgs = TypeArguments();
      } else {
        ;
      }
      ret = new ClassOrInterfaceType(range(begin, token()), ret, name, typeArgs.list, annotations);
      typeArgs = new RangedList<Type>(null);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.5.1
   * <pre>{@code
   *     TypeArguments:
   *         < TypeArgumentList >
   *     TypeArgumentList:
   *         TypeArgument {, TypeArgument}
   *     TypeArgument:
   *         ReferenceType
   *         Wildcard
   * }<pre>
   */
  public final RangedList<Type> TypeArguments() throws ParseException {
    RangedList<Type> ret = new RangedList<Type>(new NodeList<Type>());
    Type type;
    jj_consume_token(LT);
    ret.beginAt(token());
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case DOUBLE:
      case ENUM:
      case FLOAT:
      case INT:
      case LONG:
      case PERMITS:
      case RECORD:
      case SEALED:
      case SHORT:
      case STRICTFP:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case IDENTIFIER:
      case AT:
      case HOOK:
        {
          type = TypeArgument();
          ret.add(type);
          label_30:
          while (true) {
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case COMMA:
                {
                  break;
                }
              default:
                jj_la1[70] = jj_gen;
                break label_30;
            }
            jj_consume_token(COMMA);
            type = TypeArgument();
            ret.add(type);
          }
          break;
        }
      default:
        jj_la1[71] = jj_gen;
        ;
    }
    jj_consume_token(GT);
    ret.endAt(token());
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.5.1
   * <pre>{@code
   *     TypeArguments:
   *         < TypeArgumentList >
   *     TypeArgumentList:
   *         TypeArgument {, TypeArgument}
   *     TypeArgument:
   *         ReferenceType
   *         Wildcard
   * }<pre>
   */
  public final Type TypeArgument() throws ParseException {
    Type ret;
    NodeList<AnnotationExpr> annotations;
    annotations = Annotations();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case DOUBLE:
      case ENUM:
      case FLOAT:
      case INT:
      case LONG:
      case PERMITS:
      case RECORD:
      case SEALED:
      case SHORT:
      case STRICTFP:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case IDENTIFIER:
        {
          ret = Type(annotations);
          break;
        }
      case HOOK:
        {
          ret = Wildcard(annotations);
          break;
        }
      default:
        jj_la1[72] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.5.1
   * <pre>{@code
   *     Wildcard:
   *         {Annotation} ? [WildcardBounds]
   *     WildcardBounds:
   *         extends ReferenceType
   *         super ReferenceType
   * }<pre>
   */
  public final WildcardType Wildcard(NodeList<AnnotationExpr> firstAnnotations)
      throws ParseException {
    ReferenceType ext = null;
    ReferenceType sup = null;
    JavaToken begin;
    NodeList<AnnotationExpr> annotations = new NodeList<AnnotationExpr>();
    jj_consume_token(HOOK);
    begin = token();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case EXTENDS:
      case SUPER:
        {
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
            case EXTENDS:
              {
                jj_consume_token(EXTENDS);
                annotations = Annotations();
                ext = ReferenceType(annotations);
                break;
              }
            case SUPER:
              {
                jj_consume_token(SUPER);
                annotations = Annotations();
                sup = ReferenceType(annotations);
                break;
              }
            default:
              jj_la1[73] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
          }
          break;
        }
      default:
        jj_la1[74] = jj_gen;
        ;
    }
    {
      if ("" != null) return new WildcardType(range(begin, token()), ext, sup, firstAnnotations);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that {@code char} and {@code byte} are treated as an {@code IntegralType}, which is a subtype of {@code NumericType}.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-4.html#jls-4.2
   * <pre>{@code
   *     PrimitiveType:
   *         {Annotation} NumericType
   *         {Annotation} boolean
   *     NumericType:
   *         IntegralType
   *         FloatingPointType
   *     IntegralType:
   *         (one of)
   *         byte short int long char
   *     FloatingPointType:
   *         (one of)
   *         float double
   * }<pre>
   */
  public final PrimitiveType PrimitiveType(NodeList<AnnotationExpr> annotations)
      throws ParseException {
    PrimitiveType ret;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case BOOLEAN:
        {
          jj_consume_token(BOOLEAN);
          ret = new PrimitiveType(tokenRange(), PrimitiveType.Primitive.BOOLEAN, annotations);
          break;
        }
      case CHAR:
        {
          jj_consume_token(CHAR);
          ret = new PrimitiveType(tokenRange(), PrimitiveType.Primitive.CHAR, annotations);
          break;
        }
      case BYTE:
        {
          jj_consume_token(BYTE);
          ret = new PrimitiveType(tokenRange(), PrimitiveType.Primitive.BYTE, annotations);
          break;
        }
      case SHORT:
        {
          jj_consume_token(SHORT);
          ret = new PrimitiveType(tokenRange(), PrimitiveType.Primitive.SHORT, annotations);
          break;
        }
      case INT:
        {
          jj_consume_token(INT);
          ret = new PrimitiveType(tokenRange(), PrimitiveType.Primitive.INT, annotations);
          break;
        }
      case LONG:
        {
          jj_consume_token(LONG);
          ret = new PrimitiveType(tokenRange(), PrimitiveType.Primitive.LONG, annotations);
          break;
        }
      case FLOAT:
        {
          jj_consume_token(FLOAT);
          ret = new PrimitiveType(tokenRange(), PrimitiveType.Primitive.FLOAT, annotations);
          break;
        }
      case DOUBLE:
        {
          jj_consume_token(DOUBLE);
          ret = new PrimitiveType(tokenRange(), PrimitiveType.Primitive.DOUBLE, annotations);
          break;
        }
      default:
        jj_la1[75] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.4.5
   * <pre>{@code
   *     Result:
   *         UnannType
   *         void
   * }<pre>
   */
  public final Type ResultType(NodeList<AnnotationExpr> annotations) throws ParseException {
    Type ret;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case VOID:
        {
          jj_consume_token(VOID);
          ret = new VoidType(tokenRange());
          break;
        }
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case DOUBLE:
      case ENUM:
      case FLOAT:
      case INT:
      case LONG:
      case PERMITS:
      case RECORD:
      case SEALED:
      case SHORT:
      case STRICTFP:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case IDENTIFIER:
        {
          ret = Type(annotations);
          break;
        }
      default:
        jj_la1[76] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * A {@code SimpleName} is just an identifier. A {@code Name} can be a {@code SimpleName} or a
   * {@code SimpleName} with qualifiers (e.g. a class or object reference). Note that no
   * disambiguation is made as to exactly what type of name it is - e.g. whether it is a package,
   * subclass, or field. That happens within JavaParser, rather than the grammar.
   */
  public final Name Name() throws ParseException {
    Name ret;
    Identifier();
    ret = new Name(tokenRange(), null, token.image);
    label_31:
    while (true) {
      if (jj_2_32(2)) {
      } else {
        break label_31;
      }
      jj_consume_token(DOT);
      Identifier();
      ret = new Name(range(ret, token()), ret, token.image);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * A {@code SimpleName} is just an identifier. A {@code Name} can be a {@code SimpleName} or a
   * {@code SimpleName} with qualifiers (e.g. a class or object reference). Note that no
   * disambiguation is made as to exactly what type of name it is - e.g. whether it is a package,
   * subclass, or field. That happens within JavaParser, rather than the grammar.
   */
  public final SimpleName SimpleName() throws ParseException {
    SimpleName ret;
    Identifier();
    ret = new SimpleName(tokenRange(), token.image);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-3.html#jls-3.8
   *
   * <pre>{@code
   * Identifier:
   *     IdentifierChars but not a Keyword or BooleanLiteral or NullLiteral
   * IdentifierChars:
   *     JavaLetter {JavaLetterOrDigit}
   * JavaLetter:
   *     any Unicode character that is a "Java letter"
   * }</pre>
   *
   * For Convenience: https://docs.oracle.com/javase/specs/jls/se15/html/jls-3.html#jls-3.9
   *
   * <blockquote>
   *
   * 51 character sequences, formed from ASCII letters, are reserved for use as keywords and cannot
   * be used as identifiers (§3.8).
   *
   * </blockquote>
   *
   * <pre>{@code
   * Keyword:
   *     (one of)
   *
   *     abstract   continue   for          new         switch
   *     assert     default    if           package     synchronized
   *     boolean    do         goto         private     this
   *     break      double     implements   protected   throw
   *     byte       else       import       public      throws
   *     case       enum       instanceof   return      transient
   *     catch      extends    int          short       try
   *     char       final      interface    static      void
   *     class      finally    long         strictfp    volatile
   *     const      float      native       super       while
   *     _ (underscore)
   * }</pre>
   */
  public final String Identifier() throws ParseException {
    String ret;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case MODULE:
        {
          jj_consume_token(MODULE);
          break;
        }
      case REQUIRES:
        {
          jj_consume_token(REQUIRES);
          break;
        }
      case TO:
        {
          jj_consume_token(TO);
          break;
        }
      case WITH:
        {
          jj_consume_token(WITH);
          break;
        }
      case OPEN:
        {
          jj_consume_token(OPEN);
          break;
        }
      case OPENS:
        {
          jj_consume_token(OPENS);
          break;
        }
      case USES:
        {
          jj_consume_token(USES);
          break;
        }
      case EXPORTS:
        {
          jj_consume_token(EXPORTS);
          break;
        }
      case PROVIDES:
        {
          jj_consume_token(PROVIDES);
          break;
        }
      case TRANSITIVE:
        {
          jj_consume_token(TRANSITIVE);
          break;
        }
      case ENUM:
        {
          jj_consume_token(ENUM);
          break;
        }
      case STRICTFP:
        {
          jj_consume_token(STRICTFP);
          break;
        }
      case YIELD:
        {
          jj_consume_token(YIELD);
          break;
        }
      case RECORD:
        {
          jj_consume_token(RECORD);
          break;
        }
      case PERMITS:
        {
          jj_consume_token(PERMITS);
          break;
        }
      case SEALED:
        {
          jj_consume_token(SEALED);
          break;
        }
      case WHEN:
        {
          jj_consume_token(WHEN);
          break;
        }
      case IDENTIFIER:
        {
          jj_consume_token(IDENTIFIER);
          break;
        }
      default:
        jj_la1[77] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    ret = token.image;
    setTokenKind(IDENTIFIER);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /*
   * Expression syntax follows.
   */
  public final Expression Expression() throws ParseException {
    Expression ret;
    AssignExpr.Operator op;
    Expression value;
    Statement lambdaBody = null;
    RangedList<Type> typeArgs = new RangedList<Type>(null);
    ret = ConditionalExpression();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case DOUBLECOLON:
      case ASSIGN:
      case ARROW:
      case PLUSASSIGN:
      case MINUSASSIGN:
      case STARASSIGN:
      case SLASHASSIGN:
      case ANDASSIGN:
      case ORASSIGN:
      case XORASSIGN:
      case REMASSIGN:
      case LSHIFTASSIGN:
      case RSIGNEDSHIFTASSIGN:
      case RUNSIGNEDSHIFTASSIGN:
        {
          if (jj_2_33(2)) {
            op = AssignmentOperator();
            value = Expression();
            ret = new AssignExpr(range(ret, token()), ret, value, op);
          } else {
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case ARROW:
                {
                  jj_consume_token(ARROW);
                  lambdaBody = LambdaBody();
                  ret = generateLambda(ret, lambdaBody);
                  break;
                }
              case DOUBLECOLON:
                {
                  jj_consume_token(DOUBLECOLON);
                  switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                    case LT:
                      {
                        typeArgs = TypeArguments();
                        break;
                      }
                    default:
                      jj_la1[78] = jj_gen;
                      ;
                  }
                  switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                    case ENUM:
                    case PERMITS:
                    case RECORD:
                    case SEALED:
                    case STRICTFP:
                    case YIELD:
                    case REQUIRES:
                    case TO:
                    case WITH:
                    case OPEN:
                    case OPENS:
                    case USES:
                    case MODULE:
                    case EXPORTS:
                    case PROVIDES:
                    case TRANSITIVE:
                    case WHEN:
                    case IDENTIFIER:
                      {
                        Identifier();
                        break;
                      }
                    case NEW:
                      {
                        jj_consume_token(NEW);
                        break;
                      }
                    default:
                      jj_la1[79] = jj_gen;
                      jj_consume_token(-1);
                      throw new ParseException();
                  }
                  ret =
                      new MethodReferenceExpr(range(ret, token()), ret, typeArgs.list, token.image);
                  break;
                }
              default:
                jj_la1[80] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
          }
          break;
        }
      default:
        jj_la1[81] = jj_gen;
        ;
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.26
   * <pre>{@code
   *     AssignmentExpression:
   *         ConditionalExpression
   *         Assignment
   *     Assignment:
   *         LeftHandSide AssignmentOperator Expression
   *     LeftHandSide:
   *         ExpressionName
   *         FieldAccess
   *         ArrayAccess
   *     AssignmentOperator:
   *         (one of)
   *         =  *=  /=  %=  +=  -=  <<=  >>=  >>>=  &=  ^=  |=
   * }<pre>
   */
  public final AssignExpr.Operator AssignmentOperator() throws ParseException {
    AssignExpr.Operator ret;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case ASSIGN:
        {
          jj_consume_token(ASSIGN);
          ret = AssignExpr.Operator.ASSIGN;
          break;
        }
      case STARASSIGN:
        {
          jj_consume_token(STARASSIGN);
          ret = AssignExpr.Operator.MULTIPLY;
          break;
        }
      case SLASHASSIGN:
        {
          jj_consume_token(SLASHASSIGN);
          ret = AssignExpr.Operator.DIVIDE;
          break;
        }
      case REMASSIGN:
        {
          jj_consume_token(REMASSIGN);
          ret = AssignExpr.Operator.REMAINDER;
          break;
        }
      case PLUSASSIGN:
        {
          jj_consume_token(PLUSASSIGN);
          ret = AssignExpr.Operator.PLUS;
          break;
        }
      case MINUSASSIGN:
        {
          jj_consume_token(MINUSASSIGN);
          ret = AssignExpr.Operator.MINUS;
          break;
        }
      case LSHIFTASSIGN:
        {
          jj_consume_token(LSHIFTASSIGN);
          ret = AssignExpr.Operator.LEFT_SHIFT;
          break;
        }
      case RSIGNEDSHIFTASSIGN:
        {
          jj_consume_token(RSIGNEDSHIFTASSIGN);
          ret = AssignExpr.Operator.SIGNED_RIGHT_SHIFT;
          break;
        }
      case RUNSIGNEDSHIFTASSIGN:
        {
          jj_consume_token(RUNSIGNEDSHIFTASSIGN);
          ret = AssignExpr.Operator.UNSIGNED_RIGHT_SHIFT;
          break;
        }
      case ANDASSIGN:
        {
          jj_consume_token(ANDASSIGN);
          ret = AssignExpr.Operator.BINARY_AND;
          break;
        }
      case XORASSIGN:
        {
          jj_consume_token(XORASSIGN);
          ret = AssignExpr.Operator.XOR;
          break;
        }
      case ORASSIGN:
        {
          jj_consume_token(ORASSIGN);
          ret = AssignExpr.Operator.BINARY_OR;
          break;
        }
      default:
        jj_la1[82] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * // TODO: Examine further re: missing(?) {@code LambdaExpression} or whether it is permissive enough to include it.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.25
   * <pre>{@code
   *     ConditionalExpression:
   *         ConditionalOrExpression
   *         ConditionalOrExpression ? Expression : ConditionalExpression
   *         ConditionalOrExpression ? Expression : LambdaExpression
   * }<pre>
   */
  public final Expression ConditionalExpression() throws ParseException {
    Expression ret;
    Expression left;
    Expression right;
    ret = ConditionalOrExpression();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case HOOK:
        {
          jj_consume_token(HOOK);
          left = Expression();
          jj_consume_token(COLON);
          right = Expression();
          ret = new ConditionalExpr(range(ret, token()), ret, left, right);
          break;
        }
      default:
        jj_la1[83] = jj_gen;
        ;
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * <strong>
   * Note subtle distinctions between inclusive and exclusive expressions.
   * </strong>
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.24
   * <pre>{@code
   *     ConditionalOrExpression:
   *         ConditionalAndExpression
   *         ConditionalOrExpression || ConditionalAndExpression
   * }<pre>
   */
  public final Expression ConditionalOrExpression() throws ParseException {
    Expression ret;
    Expression right;
    // First consider a higher-precedence operator, before considering the token as the left-hand
    // part of this expression.
    ret = ConditionalAndExpression();
    label_32:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case SC_OR:
          {
            break;
          }
        default:
          jj_la1[84] = jj_gen;
          break label_32;
      }
      jj_consume_token(SC_OR);
      right = ConditionalAndExpression();
      ret = new BinaryExpr(range(ret, token()), ret, right, BinaryExpr.Operator.OR);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * <strong>
   * Note subtle distinctions between inclusive and exclusive expressions.
   * </strong>
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.23
   * <pre>{@code
   *     ConditionalAndExpression:
   *         InclusiveOrExpression
   *         ConditionalAndExpression && InclusiveOrExpression
   * }<pre>
   * For Convenience:
   * <pre>{@code
   *     AndExpression:
   *         EqualityExpression
   *         AndExpression & EqualityExpression
   *     ExclusiveOrExpression:
   *         AndExpression
   *         ExclusiveOrExpression ^ AndExpression
   *     InclusiveOrExpression:
   *         ExclusiveOrExpression
   *         InclusiveOrExpression | ExclusiveOrExpression
   * }<pre>
   */
  public final Expression ConditionalAndExpression() throws ParseException {
    Expression ret;
    Expression right;
    // First consider a higher-precedence operator, before considering the token as the left-hand
    // part of this expression.
    ret = InclusiveOrExpression();
    label_33:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case SC_AND:
          {
            break;
          }
        default:
          jj_la1[85] = jj_gen;
          break label_33;
      }
      jj_consume_token(SC_AND);
      right = InclusiveOrExpression();
      ret = new BinaryExpr(range(ret, token()), ret, right, BinaryExpr.Operator.AND);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * <strong>
   * Note subtle distinctions between inclusive and exclusive expressions.
   * </strong>
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.22
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-InclusiveOrExpression
   * <pre>{@code
   *     AndExpression:
   *         EqualityExpression
   *         AndExpression & EqualityExpression
   *     ExclusiveOrExpression:
   *         AndExpression
   *         ExclusiveOrExpression ^ AndExpression
   *     InclusiveOrExpression:
   *         ExclusiveOrExpression
   *         InclusiveOrExpression | ExclusiveOrExpression
   * }<pre>
   */
  public final Expression InclusiveOrExpression() throws ParseException {
    Expression ret;
    Expression right;
    // First consider a higher-precedence operator, before considering the token as the left-hand
    // part of this expression.
    ret = ExclusiveOrExpression();
    label_34:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case BIT_OR:
          {
            break;
          }
        default:
          jj_la1[86] = jj_gen;
          break label_34;
      }
      jj_consume_token(BIT_OR);
      right = ExclusiveOrExpression();
      ret = new BinaryExpr(range(ret, token()), ret, right, BinaryExpr.Operator.BINARY_OR);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * <strong>
   * Note subtle distinctions between inclusive and exclusive expressions.
   * </strong>
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.22
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-ExclusiveOrExpression
   * <pre>{@code
   *     AndExpression:
   *         EqualityExpression
   *         AndExpression & EqualityExpression
   *     ExclusiveOrExpression:
   *         AndExpression
   *         ExclusiveOrExpression ^ AndExpression
   *     InclusiveOrExpression:
   *         ExclusiveOrExpression
   *         InclusiveOrExpression | ExclusiveOrExpression
   * }<pre>
   */
  public final Expression ExclusiveOrExpression() throws ParseException {
    Expression ret;
    Expression right;
    // First consider a higher-precedence operator, before considering the token as the left-hand
    // part of this expression.
    ret = AndExpression();
    label_35:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case XOR:
          {
            break;
          }
        default:
          jj_la1[87] = jj_gen;
          break label_35;
      }
      jj_consume_token(XOR);
      right = AndExpression();
      ret = new BinaryExpr(range(ret, token()), ret, right, BinaryExpr.Operator.XOR);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * <strong>
   * Note subtle distinctions between inclusive and exclusive expressions.
   * </strong>
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.22
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-AndExpression
   * <pre>{@code
   *     AndExpression:
   *         EqualityExpression
   *         AndExpression & EqualityExpression
   *     ExclusiveOrExpression:
   *         AndExpression
   *         ExclusiveOrExpression ^ AndExpression
   *     InclusiveOrExpression:
   *         ExclusiveOrExpression
   *         InclusiveOrExpression | ExclusiveOrExpression
   * }<pre>
   */
  public final Expression AndExpression() throws ParseException {
    Expression ret;
    Expression right;
    // First consider a higher-precedence operator, before considering the token as the left-hand
    // part of this expression.
    ret = EqualityExpression();
    label_36:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case BIT_AND:
          {
            break;
          }
        default:
          jj_la1[88] = jj_gen;
          break label_36;
      }
      jj_consume_token(BIT_AND);
      right = EqualityExpression();
      ret = new BinaryExpr(range(ret, token()), ret, right, BinaryExpr.Operator.BINARY_AND);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * // Note that instanceof is a {@code RelationalExpression} within the JLS, which differs from JavaParser
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.21
   * <pre>{@code
   *     EqualityExpression:
   *         RelationalExpression
   *         EqualityExpression == RelationalExpression
   *         EqualityExpression != RelationalExpression
   * }<pre>
   * For Convenience:
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.20
   * <pre>{@code
   *     RelationalExpression:
   *         ShiftExpression
   *         RelationalExpression < ShiftExpression
   *         RelationalExpression > ShiftExpression
   *         RelationalExpression <= ShiftExpression
   *         RelationalExpression >= ShiftExpression
   *         RelationalExpression instanceof ReferenceType
   * }<pre>
   */
  public final Expression EqualityExpression() throws ParseException {
    Expression ret;
    Expression right;
    BinaryExpr.Operator op;
    // First consider a higher-precedence operator, before considering the token as the left-hand
    // part of this expression.
    // Note that instanceof is a {@code RelationalExpression} within the JLS, which differs from
    // JavaParser
    ret = InstanceOfExpression();
    label_37:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case EQ:
        case NE:
          {
            break;
          }
        default:
          jj_la1[89] = jj_gen;
          break label_37;
      }
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case EQ:
          {
            jj_consume_token(EQ);
            op = BinaryExpr.Operator.EQUALS;
            break;
          }
        case NE:
          {
            jj_consume_token(NE);
            op = BinaryExpr.Operator.NOT_EQUALS;
            break;
          }
        default:
          jj_la1[90] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
      right = InstanceOfExpression();
      ret = new BinaryExpr(range(ret, token()), ret, right, op);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final PatternExpr PatternExpression() throws ParseException {
    PatternExpr ret;
    ret = TypePatternExpression();
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://openjdk.java.net/jeps/375
   * The instanceof grammar is extended accordingly:
   * <pre>{@code
   *     Pattern:
   *         ReferenceType Identifier
   * }<pre>
   */
  public final TypePatternExpr TypePatternExpression() throws ParseException {
    ModifierHolder modifier;
    ReferenceType type;
    SimpleName name;
    modifier = Modifiers();
    type = ReferenceType(modifier.annotations);
    name = SimpleName();
    {
      if ("" != null)
        return new TypePatternExpr(range(type, token()), modifier.modifiers, type, name);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * // Note that instanceof is a {@code RelationalExpression} within the JLS, which differs from JavaParser
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.20
   * <pre>{@code
   *     RelationalExpression:
   *         ShiftExpression
   *         RelationalExpression < ShiftExpression
   *         RelationalExpression > ShiftExpression
   *         RelationalExpression <= ShiftExpression
   *         RelationalExpression >= ShiftExpression
   *         RelationalExpression instanceof ReferenceType
   * }<pre>
   */
  public final Expression InstanceOfExpression() throws ParseException {
    Expression ret;
    ReferenceType type;
    NodeList<AnnotationExpr> annotations;
    PatternExpr pattern;
    ret = RelationalExpression();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case INSTANCEOF:
        {
          jj_consume_token(INSTANCEOF);
          if (jj_2_34(2147483647)) {
            pattern = PatternExpression();
            ret = new InstanceOfExpr(range(ret, token()), ret, pattern.getType(), pattern);
          } else {
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case BOOLEAN:
              case BYTE:
              case CHAR:
              case DOUBLE:
              case ENUM:
              case FLOAT:
              case INT:
              case LONG:
              case PERMITS:
              case RECORD:
              case SEALED:
              case SHORT:
              case STRICTFP:
              case YIELD:
              case REQUIRES:
              case TO:
              case WITH:
              case OPEN:
              case OPENS:
              case USES:
              case MODULE:
              case EXPORTS:
              case PROVIDES:
              case TRANSITIVE:
              case WHEN:
              case IDENTIFIER:
              case AT:
                {
                  type = AnnotatedReferenceType();
                  ret = new InstanceOfExpr(range(ret, token()), ret, type, null);
                  break;
                }
              default:
                jj_la1[91] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
          }
          break;
        }
      default:
        jj_la1[92] = jj_gen;
        ;
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * // Note that instanceof is a {@code RelationalExpression} within the JLS, which differs from JavaParser
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.20
   * <pre>{@code
   *     RelationalExpression:
   *         ShiftExpression
   *         RelationalExpression < ShiftExpression
   *         RelationalExpression > ShiftExpression
   *         RelationalExpression <= ShiftExpression
   *         RelationalExpression >= ShiftExpression
   *         RelationalExpression instanceof ReferenceType
   * }<pre>
   * // Note that JDK 13/14 introduce pattern Matching for instanceof
   * https://openjdk.java.net/jeps/375
   * The instanceof grammar is extended accordingly:
   * <pre>{@code
   *     RelationalExpression:
   *         ...
   *         RelationalExpression instanceof ReferenceType
   *         RelationalExpression instanceof Pattern
   *
   *     Pattern:
   *         ReferenceType Identifier
   * }<pre>
   */
  public final Expression RelationalExpression() throws ParseException {
    Expression ret;
    Expression right;
    BinaryExpr.Operator op;
    ret = ShiftExpression();
    label_38:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case LT:
        case GE:
        case LE:
        case GT:
          {
            break;
          }
        default:
          jj_la1[93] = jj_gen;
          break label_38;
      }
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case LT:
          {
            jj_consume_token(LT);
            op = BinaryExpr.Operator.LESS;
            break;
          }
        case GT:
          {
            jj_consume_token(GT);
            op = BinaryExpr.Operator.GREATER;
            break;
          }
        case LE:
          {
            jj_consume_token(LE);
            op = BinaryExpr.Operator.LESS_EQUALS;
            break;
          }
        case GE:
          {
            jj_consume_token(GE);
            op = BinaryExpr.Operator.GREATER_EQUALS;
            break;
          }
        default:
          jj_la1[94] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
      right = ShiftExpression();
      ret = new BinaryExpr(range(ret, token()), ret, right, op);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.19
   * <pre>{@code
   *     ShiftExpression:
   *         AdditiveExpression
   *         ShiftExpression << AdditiveExpression
   *         ShiftExpression >> AdditiveExpression
   *         ShiftExpression >>> AdditiveExpression
   * }<pre>
   */
  public final Expression ShiftExpression() throws ParseException {
    Expression ret;
    Expression right;
    BinaryExpr.Operator op;
    ret = AdditiveExpression();
    label_39:
    while (true) {
      if (jj_2_35(1)) {
      } else {
        break label_39;
      }
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case LSHIFT:
          {
            jj_consume_token(LSHIFT);
            op = BinaryExpr.Operator.LEFT_SHIFT;
            break;
          }
        default:
          jj_la1[95] = jj_gen;
          if (jj_2_36(1)) {
            RSIGNEDSHIFT();
            op = BinaryExpr.Operator.SIGNED_RIGHT_SHIFT;
          } else if (jj_2_37(1)) {
            RUNSIGNEDSHIFT();
            op = BinaryExpr.Operator.UNSIGNED_RIGHT_SHIFT;
          } else {
            jj_consume_token(-1);
            throw new ParseException();
          }
      }
      right = AdditiveExpression();
      ret = new BinaryExpr(range(ret, token()), ret, right, op);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.18
   * <pre>{@code
   *     AdditiveExpression:
   *         MultiplicativeExpression
   *         AdditiveExpression + MultiplicativeExpression
   *         AdditiveExpression - MultiplicativeExpression
   * }<pre>
   */
  public final Expression AdditiveExpression() throws ParseException {
    Expression ret;
    Expression right;
    BinaryExpr.Operator op;
    ret = MultiplicativeExpression();
    label_40:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case PLUS:
        case MINUS:
          {
            break;
          }
        default:
          jj_la1[96] = jj_gen;
          break label_40;
      }
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case PLUS:
          {
            jj_consume_token(PLUS);
            op = BinaryExpr.Operator.PLUS;
            break;
          }
        case MINUS:
          {
            jj_consume_token(MINUS);
            op = BinaryExpr.Operator.MINUS;
            break;
          }
        default:
          jj_la1[97] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
      right = MultiplicativeExpression();
      ret = new BinaryExpr(range(ret, token()), ret, right, op);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.17
   * <pre>{@code
   *     MultiplicativeExpression:
   *         UnaryExpression
   *         MultiplicativeExpression * UnaryExpression
   *         MultiplicativeExpression / UnaryExpression
   *         MultiplicativeExpression % UnaryExpression
   * }<pre>
   */
  public final Expression MultiplicativeExpression() throws ParseException {
    Expression ret;
    Expression right;
    BinaryExpr.Operator op;
    ret = UnaryExpression();
    label_41:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case STAR:
        case SLASH:
        case REM:
          {
            break;
          }
        default:
          jj_la1[98] = jj_gen;
          break label_41;
      }
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case STAR:
          {
            jj_consume_token(STAR);
            op = BinaryExpr.Operator.MULTIPLY;
            break;
          }
        case SLASH:
          {
            jj_consume_token(SLASH);
            op = BinaryExpr.Operator.DIVIDE;
            break;
          }
        case REM:
          {
            jj_consume_token(REM);
            op = BinaryExpr.Operator.REMAINDER;
            break;
          }
        default:
          jj_la1[99] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
      right = UnaryExpression();
      ret = new BinaryExpr(range(ret, token()), ret, right, op);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.15
   * <pre>{@code
   *     UnaryExpression:
   *         PreIncrementExpression
   *         PreDecrementExpression
   *         + UnaryExpression
   *         - UnaryExpression
   *         UnaryExpressionNotPlusMinus
   *     PreIncrementExpression:
   *         ++ UnaryExpression
   *     PreDecrementExpression:
   *         -- UnaryExpression
   *     UnaryExpressionNotPlusMinus:
   *         PostfixExpression
   *         ~ UnaryExpression
   *         ! UnaryExpression
   *         CastExpression
   *         SwitchExpression
   * }<pre>
   */
  public final Expression UnaryExpression() throws ParseException {
    Expression ret;
    UnaryExpr.Operator op;
    JavaToken begin = INVALID;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case INCR:
        {
          ret = PreIncrementExpression();
          break;
        }
      case DECR:
        {
          ret = PreDecrementExpression();
          break;
        }
      case PLUS:
      case MINUS:
        {
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
            case PLUS:
              {
                jj_consume_token(PLUS);
                op = UnaryExpr.Operator.PLUS;
                begin = token();
                break;
              }
            case MINUS:
              {
                jj_consume_token(MINUS);
                op = UnaryExpr.Operator.MINUS;
                begin = token();
                break;
              }
            default:
              jj_la1[100] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
          }
          ret = UnaryExpression();
          ret = new UnaryExpr(range(begin, token()), ret, op);
          break;
        }
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case DOUBLE:
      case ENUM:
      case FALSE:
      case FLOAT:
      case INT:
      case LONG:
      case NEW:
      case NULL:
      case PERMITS:
      case RECORD:
      case SEALED:
      case SHORT:
      case STRICTFP:
      case SUPER:
      case SWITCH:
      case THIS:
      case TRUE:
      case VOID:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case LONG_LITERAL:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case CHARACTER_LITERAL:
      case STRING_LITERAL:
      case TEXT_BLOCK_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case AT:
      case BANG:
      case TILDE:
        {
          ret = UnaryExpressionNotPlusMinus();
          break;
        }
      default:
        jj_la1[101] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.15
   * <pre>{@code
   *     PreIncrementExpression:
   *         ++ UnaryExpression
   * }<pre>
   */
  public final Expression PreIncrementExpression() throws ParseException {
    Expression ret;
    JavaToken begin = INVALID;
    jj_consume_token(INCR);
    begin = token();
    ret = UnaryExpression();
    ret = new UnaryExpr(range(begin, token()), ret, UnaryExpr.Operator.PREFIX_INCREMENT);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.15
   * <pre>{@code
   *     PreDecrementExpression:
   *         -- UnaryExpression
   * }<pre>
   */
  public final Expression PreDecrementExpression() throws ParseException {
    Expression ret;
    JavaToken begin;
    jj_consume_token(DECR);
    begin = token();
    ret = UnaryExpression();
    ret = new UnaryExpr(range(begin, token()), ret, UnaryExpr.Operator.PREFIX_DECREMENT);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.15
   * <pre>{@code
   *     UnaryExpressionNotPlusMinus:
   *         PostfixExpression
   *         ~ UnaryExpression
   *         ! UnaryExpression
   *         CastExpression
   *         SwitchExpression
   * }<pre>
   */
  public final Expression UnaryExpressionNotPlusMinus() throws ParseException {
    Expression ret;
    UnaryExpr.Operator op;
    JavaToken begin = INVALID;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case BANG:
      case TILDE:
        {
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
            case TILDE:
              {
                jj_consume_token(TILDE);
                op = UnaryExpr.Operator.BITWISE_COMPLEMENT;
                begin = token();
                break;
              }
            case BANG:
              {
                jj_consume_token(BANG);
                op = UnaryExpr.Operator.LOGICAL_COMPLEMENT;
                begin = token();
                break;
              }
            default:
              jj_la1[102] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
          }
          ret = UnaryExpression();
          ret = new UnaryExpr(range(begin, token()), ret, op);
          break;
        }
      default:
        jj_la1[103] = jj_gen;
        if (jj_2_38(2147483647)) {
          ret = CastExpression();
        } else {
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case ENUM:
            case FALSE:
            case FLOAT:
            case INT:
            case LONG:
            case NEW:
            case NULL:
            case PERMITS:
            case RECORD:
            case SEALED:
            case SHORT:
            case STRICTFP:
            case SUPER:
            case THIS:
            case TRUE:
            case VOID:
            case YIELD:
            case REQUIRES:
            case TO:
            case WITH:
            case OPEN:
            case OPENS:
            case USES:
            case MODULE:
            case EXPORTS:
            case PROVIDES:
            case TRANSITIVE:
            case WHEN:
            case LONG_LITERAL:
            case INTEGER_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
            case TEXT_BLOCK_LITERAL:
            case IDENTIFIER:
            case LPAREN:
            case AT:
              {
                ret = PostfixExpression();
                break;
              }
            case SWITCH:
              {
                ret = SwitchExpression();
                break;
              }
            default:
              jj_la1[104] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
          }
        }
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.15
   * <pre>{@code
   *     PostfixExpression:
   *         Primary
   *         ExpressionName
   *         PostIncrementExpression
   *         PostDecrementExpression
   * }<pre>
   */
  public final Expression PostfixExpression() throws ParseException {
    Expression ret;
    UnaryExpr.Operator op;
    ret = PrimaryExpression();
    if (jj_2_39(2)) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case INCR:
          {
            jj_consume_token(INCR);
            op = UnaryExpr.Operator.POSTFIX_INCREMENT;
            break;
          }
        case DECR:
          {
            jj_consume_token(DECR);
            op = UnaryExpr.Operator.POSTFIX_DECREMENT;
            break;
          }
        default:
          jj_la1[105] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
      ret = new UnaryExpr(range(ret, token()), ret, op);
    } else {
      ;
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.16
   * <pre>{@code
   *     CastExpression:
   *         ( PrimitiveType ) UnaryExpression
   *         ( ReferenceType {AdditionalBound} ) UnaryExpressionNotPlusMinus
   *         ( ReferenceType {AdditionalBound} ) LambdaExpression
   * }<pre>
   * For Convenience:
   * <pre>{@code
   *     AdditionalBound:
   *         & InterfaceType
   * }<pre>
   */
  public final Expression CastExpression() throws ParseException {
    Expression ret;
    ReferenceType referenceType;
    PrimitiveType primitiveType;
    JavaToken begin = INVALID;
    NodeList<AnnotationExpr> annotations;
    NodeList<ReferenceType> typesOfMultiCast = emptyNodeList();
    jj_consume_token(LPAREN);
    begin = token();
    annotations = Annotations();
    if (jj_2_40(2)) {
      primitiveType = PrimitiveType(annotations);
      jj_consume_token(RPAREN);
      ret = UnaryExpression();
      ret = new CastExpr(range(begin, token()), primitiveType, ret);
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case DOUBLE:
        case ENUM:
        case FLOAT:
        case INT:
        case LONG:
        case PERMITS:
        case RECORD:
        case SEALED:
        case SHORT:
        case STRICTFP:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case IDENTIFIER:
          {
            // ( ReferenceType {AdditionalBound} ) UnaryExpressionNotPlusMinus
            // ( ReferenceType {AdditionalBound} ) LambdaExpression
            referenceType = ReferenceType(annotations);
            typesOfMultiCast = add(typesOfMultiCast, referenceType);
            label_42:
            while (true) {
              switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                case BIT_AND:
                  {
                    break;
                  }
                default:
                  jj_la1[106] = jj_gen;
                  break label_42;
              }
              jj_consume_token(BIT_AND);
              referenceType = AnnotatedReferenceType();
              typesOfMultiCast = add(typesOfMultiCast, referenceType);
            }
            jj_consume_token(RPAREN);
            ret = UnaryExpressionNotPlusMinus();
            if (typesOfMultiCast.size() > 1) {
              ret =
                  new CastExpr(
                      range(begin, token()),
                      new IntersectionType(
                          range(
                              typesOfMultiCast.get(0),
                              typesOfMultiCast.get(typesOfMultiCast.size() - 1)),
                          typesOfMultiCast),
                      ret);
            } else {
              ret = new CastExpr(range(begin, token()), referenceType, ret);
            }
            break;
          }
        default:
          jj_la1[107] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.8
   * <pre>{@code
   *     Primary:
   *         PrimaryNoNewArray
   *         ArrayCreationExpression
   *     PrimaryNoNewArray:
   *         Literal
   *         ClassLiteral
   *         this
   *         TypeName . this
   *         ( Expression )
   *         ClassInstanceCreationExpression
   *         FieldAccess
   *         ArrayAccess
   *         MethodInvocation
   *         MethodReference
   * }<pre>
   */
  public final Expression PrimaryExpression() throws ParseException {
    Expression ret;
    ret = PrimaryPrefix();
    label_43:
    while (true) {
      if (jj_2_41(2)) {
      } else {
        break label_43;
      }
      ret = PrimarySuffix(ret);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * // TODO: Unclear exactly which part of the JLS this relates to - a JavaParser-specific thing
   * with no 1:1 mapping, perhaps?
   */
  public final Expression PrimaryExpressionWithoutSuperSuffix() throws ParseException {
    Expression ret;
    ret = PrimaryPrefix();
    label_44:
    while (true) {
      if (jj_2_42(2147483647)) {
      } else {
        break label_44;
      }
      ret = PrimarySuffixWithoutSuper(ret);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * // TODO: Unclear exactly which part of the JLS this relates to - a JavaParser-specific thing
   * with no 1:1 mapping, perhaps?
   */
  public final Expression PrimaryPrefix() throws ParseException {
    Expression ret = null;
    SimpleName name;
    RangedList<Type> typeArgs = new RangedList<Type>(null);
    NodeList<Expression> args = emptyNodeList();
    NodeList<Parameter> params = emptyNodeList();
    boolean hasArgs = false;
    boolean isLambda = false;
    Type type;
    JavaToken begin;
    Parameter p = null;
    SimpleName id = null;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case FALSE:
      case NULL:
      case TRUE:
      case LONG_LITERAL:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case CHARACTER_LITERAL:
      case STRING_LITERAL:
      case TEXT_BLOCK_LITERAL:
        {
          ret = Literal();
          break;
        }
      case THIS:
        {
          jj_consume_token(THIS);
          ret = new ThisExpr(tokenRange(), null);
          break;
        }
      case SUPER:
        {
          jj_consume_token(SUPER);
          ret = new SuperExpr(tokenRange(), null);
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
            case DOT:
              {
                jj_consume_token(DOT);
                switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                  case LT:
                    {
                      typeArgs = TypeArguments();
                      break;
                    }
                  default:
                    jj_la1[108] = jj_gen;
                    ;
                }
                name = SimpleName();
                switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                  case LPAREN:
                    {
                      args = Arguments();
                      hasArgs = true;
                      break;
                    }
                  default:
                    jj_la1[109] = jj_gen;
                    ;
                }
                if (hasArgs) {
                  ret = new MethodCallExpr(range(ret, token()), ret, typeArgs.list, name, args);
                } else {
                  ret = new FieldAccessExpr(range(ret, token()), ret, emptyNodeList(), name);
                }
                break;
              }
            case DOUBLECOLON:
              {
                jj_consume_token(DOUBLECOLON);
                switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                  case LT:
                    {
                      typeArgs = TypeArguments();
                      break;
                    }
                  default:
                    jj_la1[110] = jj_gen;
                    ;
                }
                switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                  case ENUM:
                  case PERMITS:
                  case RECORD:
                  case SEALED:
                  case STRICTFP:
                  case YIELD:
                  case REQUIRES:
                  case TO:
                  case WITH:
                  case OPEN:
                  case OPENS:
                  case USES:
                  case MODULE:
                  case EXPORTS:
                  case PROVIDES:
                  case TRANSITIVE:
                  case WHEN:
                  case IDENTIFIER:
                    {
                      Identifier();
                      break;
                    }
                  case NEW:
                    {
                      jj_consume_token(NEW);
                      break;
                    }
                  default:
                    jj_la1[111] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                ret = new MethodReferenceExpr(range(ret, token()), ret, typeArgs.list, token.image);
                break;
              }
            default:
              jj_la1[112] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
          }
          break;
        }
      case LPAREN:
        {
          jj_consume_token(LPAREN);
          begin = token();
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
            case RPAREN:
              {
                jj_consume_token(RPAREN);
                ret = new LambdaExpr(range(begin, token()), params, new BlockStmt(), true);
                break;
              }
            default:
              jj_la1[113] = jj_gen;
              if (jj_2_43(2147483647)) {
                params = LambdaParameters();
                jj_consume_token(RPAREN);
                ret = new LambdaExpr(range(begin, token()), params, new BlockStmt(), true);
              } else if (jj_2_44(2147483647)) {
                params = InferredLambdaParameters();
                jj_consume_token(RPAREN);
                ret = new LambdaExpr(range(begin, token()), params, new BlockStmt(), true);
              } else {
                switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                  case BOOLEAN:
                  case BYTE:
                  case CHAR:
                  case DOUBLE:
                  case ENUM:
                  case FALSE:
                  case FLOAT:
                  case INT:
                  case LONG:
                  case NEW:
                  case NULL:
                  case PERMITS:
                  case RECORD:
                  case SEALED:
                  case SHORT:
                  case STRICTFP:
                  case SUPER:
                  case SWITCH:
                  case THIS:
                  case TRUE:
                  case VOID:
                  case YIELD:
                  case REQUIRES:
                  case TO:
                  case WITH:
                  case OPEN:
                  case OPENS:
                  case USES:
                  case MODULE:
                  case EXPORTS:
                  case PROVIDES:
                  case TRANSITIVE:
                  case WHEN:
                  case LONG_LITERAL:
                  case INTEGER_LITERAL:
                  case FLOATING_POINT_LITERAL:
                  case CHARACTER_LITERAL:
                  case STRING_LITERAL:
                  case TEXT_BLOCK_LITERAL:
                  case IDENTIFIER:
                  case LPAREN:
                  case AT:
                  case BANG:
                  case TILDE:
                  case INCR:
                  case DECR:
                  case PLUS:
                  case MINUS:
                    {
                      // This could still be a lambda expression, but this is handled after matching
                      // -> elsewhere
                      ret = Expression();
                      jj_consume_token(RPAREN);
                      ret = new EnclosedExpr(range(begin, token()), ret);
                      break;
                    }
                  default:
                    jj_la1[114] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
              }
          }
          break;
        }
      case NEW:
        {
          ret = AllocationExpression(null);
          break;
        }
      default:
        jj_la1[118] = jj_gen;
        if (jj_2_45(2147483647)) {
          type = ResultType(emptyNodeList());
          jj_consume_token(DOT);
          jj_consume_token(CLASS);
          ret = new ClassExpr(range(type, token()), type);
        } else if (jj_2_46(2147483647)) {
          type = AnnotatedType();
          jj_consume_token(DOUBLECOLON);
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
            case LT:
              {
                typeArgs = TypeArguments();
                break;
              }
            default:
              jj_la1[115] = jj_gen;
              ;
          }
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
            case ENUM:
            case PERMITS:
            case RECORD:
            case SEALED:
            case STRICTFP:
            case YIELD:
            case REQUIRES:
            case TO:
            case WITH:
            case OPEN:
            case OPENS:
            case USES:
            case MODULE:
            case EXPORTS:
            case PROVIDES:
            case TRANSITIVE:
            case WHEN:
            case IDENTIFIER:
              {
                Identifier();
                break;
              }
            case NEW:
              {
                jj_consume_token(NEW);
                break;
              }
            default:
              jj_la1[116] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
          }
          ret = new TypeExpr(range(type, type), type);
          ret = new MethodReferenceExpr(range(ret, token()), ret, typeArgs.list, token.image);
        } else {
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
            case ENUM:
            case PERMITS:
            case RECORD:
            case SEALED:
            case STRICTFP:
            case YIELD:
            case REQUIRES:
            case TO:
            case WITH:
            case OPEN:
            case OPENS:
            case USES:
            case MODULE:
            case EXPORTS:
            case PROVIDES:
            case TRANSITIVE:
            case WHEN:
            case IDENTIFIER:
              {
                name = SimpleName();
                begin = token();
                switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                  case LPAREN:
                    {
                      args = Arguments();
                      hasArgs = true;
                      break;
                    }
                  default:
                    jj_la1[117] = jj_gen;
                    ;
                }
                if (hasArgs) {
                  ret = new MethodCallExpr(range(begin, token()), null, null, name, args);
                } else {
                  ret = new NameExpr(name);
                }
                break;
              }
            default:
              jj_la1[119] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
          }
        }
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * // TODO: Unclear exactly which part of the JLS this relates to - a JavaParser-specific thing
   * with no 1:1 mapping, perhaps?
   */
  public final Expression PrimarySuffix(Expression scope) throws ParseException {
    Expression ret;
    if (jj_2_47(2)) {
      ret = PrimarySuffixWithoutSuper(scope);
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case DOT:
          {
            jj_consume_token(DOT);
            jj_consume_token(SUPER);
            ret = new SuperExpr(range(scope, token()), scopeToName(scope));
            break;
          }
        default:
          jj_la1[120] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * // TODO: Unclear exactly which part of the JLS this relates to - a JavaParser-specific thing
   * with no 1:1 mapping, perhaps?
   */
  public final Expression PrimarySuffixWithoutSuper(Expression scope) throws ParseException {
    Expression ret;
    RangedList<Type> typeArgs = new RangedList<Type>(null);
    NodeList<Expression> args = emptyNodeList();
    boolean hasArgs = false;
    SimpleName name;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case DOT:
        {
          jj_consume_token(DOT);
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
            case THIS:
              {
                jj_consume_token(THIS);
                ret = new ThisExpr(range(scope, token()), scopeToName(scope));
                break;
              }
            case NEW:
              {
                ret = AllocationExpression(scope);
                break;
              }
            default:
              jj_la1[123] = jj_gen;
              if (jj_2_48(2147483647)) {
                switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                  case LT:
                    {
                      typeArgs = TypeArguments();
                      break;
                    }
                  default:
                    jj_la1[121] = jj_gen;
                    ;
                }
                name = SimpleName();
                switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                  case LPAREN:
                    {
                      args = Arguments();
                      hasArgs = true;
                      break;
                    }
                  default:
                    jj_la1[122] = jj_gen;
                    ;
                }
                if (hasArgs) {
                  ret = new MethodCallExpr(range(scope, token()), scope, typeArgs.list, name, args);
                } else {
                  ret = new FieldAccessExpr(range(scope, token()), scope, typeArgs.list, name);
                }
              } else {
                jj_consume_token(-1);
                throw new ParseException();
              }
          }
          break;
        }
      case LBRACKET:
        {
          jj_consume_token(LBRACKET);
          ret = Expression();
          jj_consume_token(RBRACKET);
          ret = new ArrayAccessExpr(range(scope, token()), scope, ret);
          break;
        }
      default:
        jj_la1[124] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that a Long Literal is defined as an {@code IntegerLiteral}, suffixed by "L"
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-3.html#jls-3.10.1
   *
   * <pre>{@code
   * Literal:
   *     IntegerLiteral
   *     FloatingPointLiteral
   *     BooleanLiteral
   *     CharacterLiteral
   *     StringLiteral
   *     TextBlock
   *     NullLiteral
   * }</pre>
   */
  public final Expression Literal() throws ParseException {
    Expression ret;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case INTEGER_LITERAL:
        {
          jj_consume_token(INTEGER_LITERAL);
          ret = new IntegerLiteralExpr(tokenRange(), token.image);
          break;
        }
      case LONG_LITERAL:
        {
          jj_consume_token(LONG_LITERAL);
          ret = new LongLiteralExpr(tokenRange(), token.image);
          break;
        }
      case FLOATING_POINT_LITERAL:
        {
          jj_consume_token(FLOATING_POINT_LITERAL);
          ret = new DoubleLiteralExpr(tokenRange(), token.image);
          break;
        }
      case CHARACTER_LITERAL:
        {
          jj_consume_token(CHARACTER_LITERAL);
          ret = new CharLiteralExpr(tokenRange(), unquote(token.image));
          break;
        }
      case STRING_LITERAL:
        {
          jj_consume_token(STRING_LITERAL);
          ret = new StringLiteralExpr(tokenRange(), unquote(token.image));
          break;
        }
      case TEXT_BLOCK_LITERAL:
        {
          jj_consume_token(TEXT_BLOCK_LITERAL);
          ret = new TextBlockLiteralExpr(tokenRange(), unTripleQuote(token.image));
          break;
        }
      case FALSE:
      case TRUE:
        {
          ret = BooleanLiteral();
          break;
        }
      case NULL:
        {
          ret = NullLiteral();
          break;
        }
      default:
        jj_la1[125] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-3.html#jls-3.10.3
   *
   * <pre>{@code
   * BooleanLiteral:
   *     (one of)
   *     true false
   * }</pre>
   */
  public final Expression BooleanLiteral() throws ParseException {
    Expression ret;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case TRUE:
        {
          jj_consume_token(TRUE);
          ret = new BooleanLiteralExpr(tokenRange(), true);
          break;
        }
      case FALSE:
        {
          jj_consume_token(FALSE);
          ret = new BooleanLiteralExpr(tokenRange(), false);
          break;
        }
      default:
        jj_la1[126] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-3.html#jls-3.10.8
   *
   * <pre>{@code
   * NullLiteral:
   *     null
   * }</pre>
   */
  public final Expression NullLiteral() throws ParseException {
    jj_consume_token(NULL);
    {
      if ("" != null) return new NullLiteralExpr(tokenRange());
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.12
   *
   * <pre>{@code
   * MethodInvocation:
   *     MethodName ( [ArgumentList] )
   *     TypeName . [TypeArguments] Identifier ( [ArgumentList] )
   *     ExpressionName . [TypeArguments] Identifier ( [ArgumentList] )
   *     Primary . [TypeArguments] Identifier ( [ArgumentList] )
   *     super . [TypeArguments] Identifier ( [ArgumentList] )
   *     TypeName . super . [TypeArguments] Identifier ( [ArgumentList] )
   * ArgumentList:
   *     Expression {, Expression}
   * }</pre>
   */
  public final NodeList<Expression> Arguments() throws ParseException {
    NodeList<Expression> ret = emptyNodeList();
    jj_consume_token(LPAREN);
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case DOUBLE:
      case ENUM:
      case FALSE:
      case FLOAT:
      case INT:
      case LONG:
      case NEW:
      case NULL:
      case PERMITS:
      case RECORD:
      case SEALED:
      case SHORT:
      case STRICTFP:
      case SUPER:
      case SWITCH:
      case THIS:
      case TRUE:
      case VOID:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case LONG_LITERAL:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case CHARACTER_LITERAL:
      case STRING_LITERAL:
      case TEXT_BLOCK_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case AT:
      case BANG:
      case TILDE:
      case INCR:
      case DECR:
      case PLUS:
      case MINUS:
        {
          ret = ArgumentList();
          break;
        }
      default:
        jj_la1[127] = jj_gen;
        ;
    }
    jj_consume_token(RPAREN);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.12
   *
   * <pre>{@code
   * ArgumentList:
   *     Expression {, Expression}
   * }</pre>
   */
  public final NodeList<Expression> ArgumentList() throws ParseException {
    NodeList<Expression> ret = emptyNodeList();
    Expression expr;
    expr = Expression();
    ret.add(expr);
    label_45:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case COMMA:
          {
            break;
          }
        default:
          jj_la1[128] = jj_gen;
          break label_45;
      }
      jj_consume_token(COMMA);
      expr = Expression();
      ret.add(expr);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.9
   *
   * <pre>{@code
   * ClassInstanceCreationExpression:
   *     UnqualifiedClassInstanceCreationExpression
   *     ExpressionName . UnqualifiedClassInstanceCreationExpression
   *     Primary . UnqualifiedClassInstanceCreationExpression
   * UnqualifiedClassInstanceCreationExpression:
   *     new [TypeArguments] ClassOrInterfaceTypeToInstantiate ( [ArgumentList] ) [ClassBody]
   * ClassOrInterfaceTypeToInstantiate:
   *     {Annotation} Identifier {. {Annotation} Identifier} [TypeArgumentsOrDiamond]
   * TypeArgumentsOrDiamond:
   *     TypeArguments
   *     <>
   * }</pre>
   *
   * For Convenience:
   *
   * <pre>{@code
   * ArgumentList:
   *     Expression {, Expression}
   * }</pre>
   *
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.10
   *
   * <pre>{@code
   * ArrayCreationExpression:
   *     new PrimitiveType DimExprs [Dims]
   *     new ClassOrInterfaceType DimExprs [Dims]
   *     new PrimitiveType Dims ArrayInitializer
   *     new ClassOrInterfaceType Dims ArrayInitializer
   * DimExprs:
   *     DimExpr {DimExpr}
   * DimExpr:
   *     {Annotation} [ Expression ]
   * }</pre>
   *
   * For Convenience:
   *
   * <pre>{@code
   * Dims:
   *     {Annotation} [ ] {{Annotation} [ ]}
   * }</pre>
   */
  public final Expression AllocationExpression(Expression scope) throws ParseException {
    Expression ret;
    Type type;
    RangedList<Type> typeArgs = new RangedList<Type>(null);
    NodeList<BodyDeclaration<?>> anonymousBody = null;
    NodeList<Expression> args;
    JavaToken begin = INVALID;
    NodeList<AnnotationExpr> annotations = new NodeList<AnnotationExpr>();
    jj_consume_token(NEW);
    if (scope == null) {
      begin = token();
    } else {
      begin = orIfInvalid(begin, scope);
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case LT:
        {
          typeArgs = TypeArguments();
          break;
        }
      default:
        jj_la1[129] = jj_gen;
        ;
    }
    annotations = Annotations();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case DOUBLE:
      case FLOAT:
      case INT:
      case LONG:
      case SHORT:
        {
          // new array of primitives
          type = PrimitiveType(annotations);
          ret = ArrayCreation(begin, type);
          break;
        }
      case ENUM:
      case PERMITS:
      case RECORD:
      case SEALED:
      case STRICTFP:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case IDENTIFIER:
        {
          // new reference type e.g. class (or an array of those)
          type = ClassOrInterfaceType(annotations);
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
            case LBRACKET:
            case AT:
              {
                // new Integer[6] -- the array doesn't have parameters.
                ret = ArrayCreation(begin, type);
                break;
              }
            case LPAREN:
              {
                // new Integer(6) -- not an array if parameters being passed.
                args = Arguments();
                if (jj_2_49(2)) {
                  anonymousBody = ClassOrInterfaceBody();
                } else {
                  ;
                }
                ret =
                    new ObjectCreationExpr(
                        range(begin, token()),
                        scope,
                        (ClassOrInterfaceType) type,
                        typeArgs.list,
                        args,
                        anonymousBody);
                break;
              }
            default:
              jj_la1[130] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
          }
          break;
        }
      default:
        jj_la1[131] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.10
   *
   * <pre>{@code
   * ArrayCreationExpression:
   *     new PrimitiveType DimExprs [Dims]
   *     new ClassOrInterfaceType DimExprs [Dims]
   *     new PrimitiveType Dims ArrayInitializer
   *     new ClassOrInterfaceType Dims ArrayInitializer
   * DimExprs:
   *     DimExpr {DimExpr}
   * DimExpr:
   *     {Annotation} [ Expression ]
   * }</pre>
   *
   * For Convenience:
   *
   * <pre>{@code
   * Dims:
   *     {Annotation} [ ] {{Annotation} [ ]}
   * }</pre>
   */
  public final ArrayCreationExpr ArrayCreation(JavaToken begin, Type type) throws ParseException {
    Expression expr = null;
    ArrayInitializerExpr arrayInitializerExpr = null;
    NodeList<Expression> inits = emptyNodeList();
    List<NodeList<AnnotationExpr>> accum = new ArrayList<NodeList<AnnotationExpr>>();
    NodeList<AnnotationExpr> annotations = new NodeList<AnnotationExpr>();
    JavaToken arrayCreationLevelStart = INVALID;
    List<TokenRange> levelRanges = new ArrayList<TokenRange>();
    label_46:
    while (true) {
      annotations = Annotations();
      jj_consume_token(LBRACKET);
      arrayCreationLevelStart =
          annotations.isEmpty()
              ? token()
              : orIfInvalid(arrayCreationLevelStart, annotations.get(0));
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case DOUBLE:
        case ENUM:
        case FALSE:
        case FLOAT:
        case INT:
        case LONG:
        case NEW:
        case NULL:
        case PERMITS:
        case RECORD:
        case SEALED:
        case SHORT:
        case STRICTFP:
        case SUPER:
        case SWITCH:
        case THIS:
        case TRUE:
        case VOID:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case LONG_LITERAL:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case TEXT_BLOCK_LITERAL:
        case IDENTIFIER:
        case LPAREN:
        case AT:
        case BANG:
        case TILDE:
        case INCR:
        case DECR:
        case PLUS:
        case MINUS:
          {
            expr = Expression();
            break;
          }
        default:
          jj_la1[132] = jj_gen;
          ;
      }
      accum = add(accum, annotations);
      inits = add(inits, expr);
      annotations = null;
      expr = null;
      jj_consume_token(RBRACKET);
      levelRanges.add(range(arrayCreationLevelStart, token()));
      if (jj_2_50(2)) {
      } else {
        break label_46;
      }
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case LBRACE:
        {
          arrayInitializerExpr = ArrayInitializer();
          break;
        }
      default:
        jj_la1[133] = jj_gen;
        ;
    }
    {
      if ("" != null)
        return juggleArrayCreation(
            range(begin, token()), levelRanges, type, inits, accum, arrayInitializerExpr);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /*
   * Statement syntax follows.
   */

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.5
   *
   * <pre>{@code
   * Statement:
   *     StatementWithoutTrailingSubstatement
   *     LabeledStatement
   *     IfThenStatement
   *     IfThenElseStatement
   *     WhileStatement
   *     ForStatement
   * StatementNoShortIf:
   *     StatementWithoutTrailingSubstatement
   *     LabeledStatementNoShortIf
   *     IfThenElseStatementNoShortIf
   *     WhileStatementNoShortIf
   *     ForStatementNoShortIf
   * StatementWithoutTrailingSubstatement:
   *     Block
   *     EmptyStatement
   *     ExpressionStatement
   *     AssertStatement
   *     SwitchStatement
   *     DoStatement
   *     BreakStatement
   *     ContinueStatement
   *     ReturnStatement
   *     SynchronizedStatement
   *     ThrowStatement
   *     TryStatement
   *     YieldStatement
   * }</pre>
   */
  public final Statement Statement() throws ParseException {
    Statement ret;
    try {
      if (jj_2_51(2)) {
        ret = LabeledStatement();
      } else {
        switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
          case ASSERT:
            {
              ret = AssertStatement();
              break;
            }
          default:
            jj_la1[134] = jj_gen;
            if (jj_2_52(3)) {
              ret = YieldStatement();
            } else {
              switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                case LBRACE:
                  {
                    ret = Block();
                    break;
                  }
                case SEMICOLON:
                  {
                    ret = EmptyStatement();
                    break;
                  }
                case BOOLEAN:
                case BYTE:
                case CHAR:
                case DOUBLE:
                case ENUM:
                case FALSE:
                case FLOAT:
                case INT:
                case LONG:
                case NEW:
                case NULL:
                case PERMITS:
                case RECORD:
                case SEALED:
                case SHORT:
                case STRICTFP:
                case SUPER:
                case THIS:
                case TRUE:
                case VOID:
                case YIELD:
                case REQUIRES:
                case TO:
                case WITH:
                case OPEN:
                case OPENS:
                case USES:
                case MODULE:
                case EXPORTS:
                case PROVIDES:
                case TRANSITIVE:
                case WHEN:
                case LONG_LITERAL:
                case INTEGER_LITERAL:
                case FLOATING_POINT_LITERAL:
                case CHARACTER_LITERAL:
                case STRING_LITERAL:
                case TEXT_BLOCK_LITERAL:
                case IDENTIFIER:
                case LPAREN:
                case AT:
                case INCR:
                case DECR:
                  {
                    ret = StatementExpression();
                    break;
                  }
                case SWITCH:
                  {
                    ret = SwitchStatement();
                    break;
                  }
                case IF:
                  {
                    ret = IfStatement();
                    break;
                  }
                case WHILE:
                  {
                    ret = WhileStatement();
                    break;
                  }
                case DO:
                  {
                    ret = DoStatement();
                    break;
                  }
                case FOR:
                  {
                    ret = ForStatement();
                    break;
                  }
                case BREAK:
                  {
                    ret = BreakStatement();
                    break;
                  }
                case CONTINUE:
                  {
                    ret = ContinueStatement();
                    break;
                  }
                case RETURN:
                  {
                    ret = ReturnStatement();
                    break;
                  }
                case THROW:
                  {
                    ret = ThrowStatement();
                    break;
                  }
                case SYNCHRONIZED:
                  {
                    ret = SynchronizedStatement();
                    break;
                  }
                case TRY:
                  {
                    ret = TryStatement();
                    break;
                  }
                default:
                  jj_la1[135] = jj_gen;
                  jj_consume_token(-1);
                  throw new ParseException();
              }
            }
        }
      }
      {
        if ("" != null) return ret;
      }
    } catch (ParseException e) {
      TokenRange errorRange = recoverStatement(SEMICOLON, LBRACE, RBRACE, e);
      {
        if ("" != null) return new UnparsableStmt(errorRange);
      }
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.10
   *
   * <pre>{@code
   * AssertStatement:
   *     assert Expression ;
   *     assert Expression : Expression ;
   * }</pre>
   */
  public final AssertStmt AssertStatement() throws ParseException {
    Expression check;
    Expression msg = null;
    JavaToken begin;
    jj_consume_token(ASSERT);
    begin = token();
    check = Expression();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case COLON:
        {
          jj_consume_token(COLON);
          msg = Expression();
          break;
        }
      default:
        jj_la1[136] = jj_gen;
        ;
    }
    jj_consume_token(SEMICOLON);
    {
      if ("" != null) return new AssertStmt(range(begin, token()), check, msg);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * // TODO: Examine more closely.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.7
   *
   * <pre>{@code
   * LabeledStatement:
   *     Identifier : Statement
   * LabeledStatementNoShortIf:
   *     Identifier : StatementNoShortIf
   * }</pre>
   */
  public final LabeledStmt LabeledStatement() throws ParseException {
    SimpleName label;
    Statement stmt;
    JavaToken begin;
    label = SimpleName();
    begin = token();
    jj_consume_token(COLON);
    stmt = Statement();
    {
      if ("" != null) return new LabeledStmt(range(begin, token()), label, stmt);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.2
   *
   * <pre>{@code
   * Block:
   *     { [BlockStatements] }
   * BlockStatements:
   *     BlockStatement {BlockStatement}
   * BlockStatement:
   *     LocalVariableDeclarationStatement
   *     ClassDeclaration
   *     Statement
   * }</pre>
   */
  public final BlockStmt Block() throws ParseException {
    NodeList<Statement> stmts = emptyNodeList();
    JavaToken begin;
    jj_consume_token(LBRACE);
    begin = token();
    try {
      stmts = Statements();
      jj_consume_token(RBRACE);
      {
        if ("" != null) return new BlockStmt(range(begin, token()), stmts);
      }
    } catch (ParseException e) {
      recover(RBRACE, e);
      BlockStmt block = new BlockStmt(range(begin, token()), new NodeList<Statement>());
      block.setParsed(UNPARSABLE);
      {
        if ("" != null) return block;
      }
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Classes inside body statements can only be abstract or final. The semantic checks must check
   * it. TODO/FIXME: Note that the JLS specifies {@code ClassDeclaration} (thus {@code
   * NormalClassDeclaration} and {@code EnumDeclaration}, but not interface. TODO/FIXME: Is this a
   * bug in the grammar?
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-Statement
   *
   * <pre>{@code
   * Block:
   *     { [BlockStatements] }
   * BlockStatements:
   *     BlockStatement {BlockStatement}
   * BlockStatement:
   *     LocalVariableDeclarationStatement
   *     ClassDeclaration
   *     Statement
   * }</pre>
   *
   * For Convenience: https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.1
   *
   * <pre>{@code
   * ClassDeclaration:
   *     NormalClassDeclaration
   *     EnumDeclaration
   * NormalClassDeclaration:
   *     {ClassModifier} class TypeIdentifier [TypeParameters] [Superclass] [Superinterfaces] ClassBody
   * }</pre>
   *
   * For Convenience: https://docs.oracle.com/javase/specs/jls/se15/html/jls-8.html#jls-8.9
   *
   * <pre>{@code
   * EnumDeclaration:
   *     {ClassModifier} enum TypeIdentifier [Superinterfaces] EnumBody
   * }</pre>
   */
  public final Statement BlockStatement() throws ParseException {
    Statement ret;
    Expression expr;
    ClassOrInterfaceDeclaration typeDecl;
    RecordDeclaration recordDeclaration;
    ModifierHolder modifier;
    try {
      if (jj_2_53(2147483647)) {
        // TODO/FIXME: Is this a bug in the grammar? JLS specifies class or enum, not interface.
        modifier = Modifiers();
        typeDecl = ClassOrInterfaceDeclaration(modifier);
        ret = new LocalClassDeclarationStmt(range(typeDecl, token()), typeDecl);
      } else if (jj_2_54(2147483647)) {
        modifier = Modifiers();
        recordDeclaration = RecordDeclaration(modifier);
        ret = new LocalRecordDeclarationStmt(range(recordDeclaration, token()), recordDeclaration);
      } else if (jj_2_55(2147483647)) {
        ret = YieldStatement();
      } else if (jj_2_56(2147483647)) {
        expr = VariableDeclarationExpression();
        jj_consume_token(SEMICOLON);
        ret = new ExpressionStmt(range(expr, token()), expr);
      } else {
        switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
          case ASSERT:
          case BOOLEAN:
          case BREAK:
          case BYTE:
          case CHAR:
          case CONTINUE:
          case DO:
          case DOUBLE:
          case ENUM:
          case FALSE:
          case FLOAT:
          case FOR:
          case IF:
          case INT:
          case LONG:
          case NEW:
          case NULL:
          case PERMITS:
          case RECORD:
          case RETURN:
          case SEALED:
          case SHORT:
          case STRICTFP:
          case SUPER:
          case SWITCH:
          case SYNCHRONIZED:
          case THIS:
          case THROW:
          case TRUE:
          case TRY:
          case VOID:
          case WHILE:
          case YIELD:
          case REQUIRES:
          case TO:
          case WITH:
          case OPEN:
          case OPENS:
          case USES:
          case MODULE:
          case EXPORTS:
          case PROVIDES:
          case TRANSITIVE:
          case WHEN:
          case LONG_LITERAL:
          case INTEGER_LITERAL:
          case FLOATING_POINT_LITERAL:
          case CHARACTER_LITERAL:
          case STRING_LITERAL:
          case TEXT_BLOCK_LITERAL:
          case IDENTIFIER:
          case LPAREN:
          case LBRACE:
          case SEMICOLON:
          case AT:
          case INCR:
          case DECR:
            {
              ret = Statement();
              break;
            }
          default:
            jj_la1[137] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
        }
      }
      {
        if ("" != null) return ret;
      }
    } catch (ParseException e) {
      TokenRange errorRange = recoverStatement(SEMICOLON, LBRACE, RBRACE, e);
      {
        if ("" != null) return new UnparsableStmt(errorRange);
      }
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final VariableDeclarationExpr VariableDeclarationExpression() throws ParseException {
    ModifierHolder modifier;
    Type partialType;
    NodeList<VariableDeclarator> variables = new NodeList<VariableDeclarator>();
    VariableDeclarator var;
    modifier = Modifiers();
    partialType = Type(emptyNodeList());
    var = VariableDeclarator(partialType);
    variables.add(var);
    label_47:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case COMMA:
          {
            break;
          }
        default:
          jj_la1[138] = jj_gen;
          break label_47;
      }
      jj_consume_token(COMMA);
      var = VariableDeclarator(partialType);
      variables.add(var);
    }
    JavaToken begin = orIfInvalid(modifier.begin, partialType);
    {
      if ("" != null)
        return new VariableDeclarationExpr(
            range(begin, token()), modifier.modifiers, modifier.annotations, variables);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.6
   *
   * <pre>{@code
   * EmptyStatement:
   *     ;
   * }</pre>
   */
  public final EmptyStmt EmptyStatement() throws ParseException {
    jj_consume_token(SEMICOLON);
    {
      if ("" != null) return new EmptyStmt(tokenRange());
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.27.2
   *
   * <pre>{@code
   * LambdaBody:
   *     Expression
   *     Block
   * }</pre>
   */
  public final Statement LambdaBody() throws ParseException {
    Expression expr;
    Statement n = null;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case DOUBLE:
      case ENUM:
      case FALSE:
      case FLOAT:
      case INT:
      case LONG:
      case NEW:
      case NULL:
      case PERMITS:
      case RECORD:
      case SEALED:
      case SHORT:
      case STRICTFP:
      case SUPER:
      case SWITCH:
      case THIS:
      case TRUE:
      case VOID:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case LONG_LITERAL:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case CHARACTER_LITERAL:
      case STRING_LITERAL:
      case TEXT_BLOCK_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case AT:
      case BANG:
      case TILDE:
      case INCR:
      case DECR:
      case PLUS:
      case MINUS:
        {
          expr = Expression();
          n = new ExpressionStmt(range(expr, token()), expr);
          break;
        }
      case LBRACE:
        {
          n = Block();
          break;
        }
      default:
        jj_la1[139] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return n;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final ExpressionStmt StatementExpression() throws ParseException {
    Expression expr;
    AssignExpr.Operator op;
    Expression value;
    RangedList<Type> typeArgs = new RangedList<Type>(null);
    Statement lambdaBody;
    if (jj_2_57(2)) {
      expr = PreIncrementExpression();
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case DECR:
          {
            expr = PreDecrementExpression();
            break;
          }
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case DOUBLE:
        case ENUM:
        case FALSE:
        case FLOAT:
        case INT:
        case LONG:
        case NEW:
        case NULL:
        case PERMITS:
        case RECORD:
        case SEALED:
        case SHORT:
        case STRICTFP:
        case SUPER:
        case THIS:
        case TRUE:
        case VOID:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case LONG_LITERAL:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case TEXT_BLOCK_LITERAL:
        case IDENTIFIER:
        case LPAREN:
        case AT:
          {
            expr = PrimaryExpression();
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case ASSIGN:
              case INCR:
              case DECR:
              case PLUSASSIGN:
              case MINUSASSIGN:
              case STARASSIGN:
              case SLASHASSIGN:
              case ANDASSIGN:
              case ORASSIGN:
              case XORASSIGN:
              case REMASSIGN:
              case LSHIFTASSIGN:
              case RSIGNEDSHIFTASSIGN:
              case RUNSIGNEDSHIFTASSIGN:
                {
                  switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                    case INCR:
                      {
                        jj_consume_token(INCR);
                        expr =
                            new UnaryExpr(
                                range(expr, token()), expr, UnaryExpr.Operator.POSTFIX_INCREMENT);
                        break;
                      }
                    case DECR:
                      {
                        jj_consume_token(DECR);
                        expr =
                            new UnaryExpr(
                                range(expr, token()), expr, UnaryExpr.Operator.POSTFIX_DECREMENT);
                        break;
                      }
                    case ASSIGN:
                    case PLUSASSIGN:
                    case MINUSASSIGN:
                    case STARASSIGN:
                    case SLASHASSIGN:
                    case ANDASSIGN:
                    case ORASSIGN:
                    case XORASSIGN:
                    case REMASSIGN:
                    case LSHIFTASSIGN:
                    case RSIGNEDSHIFTASSIGN:
                    case RUNSIGNEDSHIFTASSIGN:
                      {
                        op = AssignmentOperator();
                        value = Expression();
                        expr = new AssignExpr(range(expr, token()), expr, value, op);
                        break;
                      }
                    default:
                      jj_la1[140] = jj_gen;
                      jj_consume_token(-1);
                      throw new ParseException();
                  }
                  break;
                }
              default:
                jj_la1[141] = jj_gen;
                ;
            }
            break;
          }
        default:
          jj_la1[142] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    jj_consume_token(SEMICOLON);
    {
      if ("" != null) return new ExpressionStmt(range(expr, token()), expr);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that the {@code SwitchExpression} and {@code SwitchStatemnt} are similar but different. //
   * TODO: Why/How? // TODO: Examine more closely.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.11
   *
   * <pre>{@code
   * SwitchStatement:
   *     switch ( Expression ) SwitchBlock
   * }</pre>
   *
   * For Convenience:
   *
   * <pre>{@code
   * SwitchBlock:
   *     { SwitchRule {SwitchRule} }
   *     { {SwitchBlockStatementGroup} {SwitchLabel :} }
   * SwitchRule:
   *     SwitchLabel -> Expression ;
   *     SwitchLabel -> Block
   *     SwitchLabel -> ThrowStatement
   * SwitchBlockStatementGroup:
   *     SwitchLabel : {SwitchLabel :} BlockStatements
   * SwitchLabel:
   *     case CaseConstant {, CaseConstant}
   *     default
   * CaseConstant:
   *     ConditionalExpression
   * }</pre>
   */
  public final SwitchStmt SwitchStatement() throws ParseException {
    Expression selector;
    SwitchEntry entry;
    NodeList<SwitchEntry> entries = emptyNodeList();
    JavaToken begin;
    jj_consume_token(SWITCH);
    begin = token();
    jj_consume_token(LPAREN);
    selector = Expression();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    label_48:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case CASE:
        case _DEFAULT:
          {
            break;
          }
        default:
          jj_la1[143] = jj_gen;
          break label_48;
      }
      entry = SwitchEntry();
      entries = add(entries, entry);
    }
    jj_consume_token(RBRACE);
    {
      if ("" != null) return new SwitchStmt(range(begin, token()), selector, entries);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that the {@code SwitchExpression} and {@code SwitchStatemnt} are similar but different. //
   * TODO: Why/How? // TODO: Examine more closely.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-15.html#jls-15.28
   *
   * <pre>{@code
   * SwitchExpression:
   *     switch ( Expression ) SwitchBlock
   * }</pre>
   *
   * For Convenience:
   *
   * <pre>{@code
   * SwitchBlock:
   *     { SwitchRule {SwitchRule} }
   *     { {SwitchBlockStatementGroup} {SwitchLabel :} }
   * SwitchRule:
   *     SwitchLabel -> Expression ;
   *     SwitchLabel -> Block
   *     SwitchLabel -> ThrowStatement
   * SwitchBlockStatementGroup:
   *     SwitchLabel : {SwitchLabel :} BlockStatements
   * SwitchLabel:
   *     case CaseConstant {, CaseConstant}
   *     default
   * CaseConstant:
   *     ConditionalExpression
   * }</pre>
   */
  public final SwitchExpr SwitchExpression() throws ParseException {
    Expression selector;
    SwitchEntry entry;
    NodeList<SwitchEntry> entries = emptyNodeList();
    JavaToken begin;
    jj_consume_token(SWITCH);
    begin = token();
    jj_consume_token(LPAREN);
    selector = Expression();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    label_49:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case CASE:
        case _DEFAULT:
          {
            break;
          }
        default:
          jj_la1[144] = jj_gen;
          break label_49;
      }
      entry = SwitchEntry();
      entries = add(entries, entry);
    }
    jj_consume_token(RBRACE);
    {
      if ("" != null) return new SwitchExpr(range(begin, token()), selector, entries);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that the {@code SwitchBlock} (JLS) and {@code SwitchEntry} (JavaParser) are equivlent. //
   * TODO: Examine more closely.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.11.1
   *
   * <pre>{@code
   * SwitchBlock:
   *     { SwitchRule {SwitchRule} }
   *     { {SwitchBlockStatementGroup} {SwitchLabel :} }
   * SwitchRule:
   *     SwitchLabel -> Expression ;
   *     SwitchLabel -> Block
   *     SwitchLabel -> ThrowStatement
   * SwitchBlockStatementGroup:
   *     SwitchLabel : {SwitchLabel :} BlockStatements
   * SwitchLabel:
   *     case CaseConstant {, CaseConstant}
   *     case null [, default]
   *     case CasePattern [Guard]
   *     default
   * CaseConstant:
   *     ConditionalExpression
   * CasePattern:
   *     Pattern
   * Guard:
   *     when Expression
   * }</pre>
   */
  public final SwitchEntry SwitchEntry() throws ParseException {
    Expression label = null;
    NodeList<Expression> labels = emptyNodeList();
    NodeList<Statement> stmts = emptyNodeList();
    JavaToken begin;
    SwitchEntry ret;
    Statement stmt = null;
    boolean isDefault = false;
    Expression guard = null;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case CASE:
        {
          jj_consume_token(CASE);
          begin = token();
          if (jj_2_58(3)) {
            label = NullLiteral();
            labels = add(labels, label);
            jj_consume_token(COMMA);
            jj_consume_token(_DEFAULT);
            isDefault = true;
          } else if (jj_2_59(3)) {
            label = PatternExpression();
            labels = add(labels, label);
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case WHEN:
                {
                  jj_consume_token(WHEN);
                  guard = ConditionalExpression();
                  break;
                }
              default:
                jj_la1[145] = jj_gen;
                ;
            }
          } else {
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case BOOLEAN:
              case BYTE:
              case CHAR:
              case DOUBLE:
              case ENUM:
              case FALSE:
              case FLOAT:
              case INT:
              case LONG:
              case NEW:
              case NULL:
              case PERMITS:
              case RECORD:
              case SEALED:
              case SHORT:
              case STRICTFP:
              case SUPER:
              case SWITCH:
              case THIS:
              case TRUE:
              case VOID:
              case YIELD:
              case REQUIRES:
              case TO:
              case WITH:
              case OPEN:
              case OPENS:
              case USES:
              case MODULE:
              case EXPORTS:
              case PROVIDES:
              case TRANSITIVE:
              case WHEN:
              case LONG_LITERAL:
              case INTEGER_LITERAL:
              case FLOATING_POINT_LITERAL:
              case CHARACTER_LITERAL:
              case STRING_LITERAL:
              case TEXT_BLOCK_LITERAL:
              case IDENTIFIER:
              case LPAREN:
              case AT:
              case BANG:
              case TILDE:
              case INCR:
              case DECR:
              case PLUS:
              case MINUS:
                {
                  label = ConditionalExpression();
                  labels = add(labels, label);
                  label_50:
                  while (true) {
                    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                      case COMMA:
                        {
                          break;
                        }
                      default:
                        jj_la1[146] = jj_gen;
                        break label_50;
                    }
                    jj_consume_token(COMMA);
                    label = ConditionalExpression();
                    labels = add(labels, label);
                  }
                  break;
                }
              default:
                jj_la1[147] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
          }
          break;
        }
      case _DEFAULT:
        {
          jj_consume_token(_DEFAULT);
          begin = token();
          isDefault = true;
          break;
        }
      default:
        jj_la1[148] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case COLON:
        {
          jj_consume_token(COLON);
          stmts = Statements();
          ret =
              new SwitchEntry(
                  range(begin, token()), labels, STATEMENT_GROUP, stmts, isDefault, guard);
          break;
        }
      case ARROW:
        {
          jj_consume_token(ARROW);
          switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case ENUM:
            case FALSE:
            case FLOAT:
            case INT:
            case LONG:
            case NEW:
            case NULL:
            case PERMITS:
            case RECORD:
            case SEALED:
            case SHORT:
            case STRICTFP:
            case SUPER:
            case THIS:
            case TRUE:
            case VOID:
            case YIELD:
            case REQUIRES:
            case TO:
            case WITH:
            case OPEN:
            case OPENS:
            case USES:
            case MODULE:
            case EXPORTS:
            case PROVIDES:
            case TRANSITIVE:
            case WHEN:
            case LONG_LITERAL:
            case INTEGER_LITERAL:
            case FLOATING_POINT_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
            case TEXT_BLOCK_LITERAL:
            case IDENTIFIER:
            case LPAREN:
            case AT:
            case INCR:
            case DECR:
              {
                stmt = StatementExpression();
                TokenRange r = range(begin, token());
                stmts.add(stmt);
                ret = new SwitchEntry(r, labels, EXPRESSION, stmts, isDefault, guard);
                break;
              }
            case LBRACE:
              {
                stmt = Block();
                TokenRange r = range(begin, token());
                stmts.add(stmt);
                ret = new SwitchEntry(r, labels, BLOCK, stmts, isDefault, guard);
                break;
              }
            case THROW:
              {
                stmt = ThrowStatement();
                TokenRange r = range(begin, token());
                stmts.add(stmt);
                ret = new SwitchEntry(r, labels, THROWS_STATEMENT, stmts, isDefault, guard);
                break;
              }
            default:
              jj_la1[149] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
          }
          break;
        }
      default:
        jj_la1[150] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.9
   *
   * <pre>{@code
   * IfThenStatement:
   *     if ( Expression ) Statement
   * IfThenElseStatement:
   *     if ( Expression ) StatementNoShortIf else Statement
   * IfThenElseStatementNoShortIf:
   *     if ( Expression ) StatementNoShortIf else StatementNoShortIf
   * }</pre>
   */
  public final IfStmt IfStatement() throws ParseException {
    Expression condition;
    Statement thenStmt;
    Statement elseStmt = null;
    JavaToken begin;
    jj_consume_token(IF);
    begin = token();
    jj_consume_token(LPAREN);
    condition = Expression();
    jj_consume_token(RPAREN);
    thenStmt = Statement();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case ELSE:
        {
          jj_consume_token(ELSE);
          elseStmt = Statement();
          break;
        }
      default:
        jj_la1[151] = jj_gen;
        ;
    }
    {
      if ("" != null) return new IfStmt(range(begin, token()), condition, thenStmt, elseStmt);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.12
   *
   * <pre>{@code
   * WhileStatement:
   *     while ( Expression ) Statement
   * WhileStatementNoShortIf:
   *     while ( Expression ) StatementNoShortIf
   * }</pre>
   */
  public final WhileStmt WhileStatement() throws ParseException {
    Expression condition;
    Statement body;
    JavaToken begin;
    jj_consume_token(WHILE);
    begin = token();
    jj_consume_token(LPAREN);
    condition = Expression();
    jj_consume_token(RPAREN);
    body = Statement();
    {
      if ("" != null) return new WhileStmt(range(begin, token()), condition, body);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.12
   *
   * <pre>{@code
   * DoStatement:
   *     do Statement while ( Expression ) ;
   * }</pre>
   */
  public final DoStmt DoStatement() throws ParseException {
    Expression condition;
    Statement body;
    JavaToken begin;
    jj_consume_token(DO);
    begin = token();
    body = Statement();
    jj_consume_token(WHILE);
    jj_consume_token(LPAREN);
    condition = Expression();
    jj_consume_token(RPAREN);
    jj_consume_token(SEMICOLON);
    {
      if ("" != null) return new DoStmt(range(begin, token()), body, condition);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.14
   *
   * <pre>{@code
   * ForStatement:
   *     BasicForStatement
   *     EnhancedForStatement
   * ForStatementNoShortIf:
   *     BasicForStatementNoShortIf
   *     EnhancedForStatementNoShortIf
   * }</pre>
   */
  public final Statement ForStatement() throws ParseException {
    VariableDeclarationExpr varExpr = null;
    Expression expr = null;
    NodeList<Expression> init = emptyNodeList();
    NodeList<Expression> update = emptyNodeList();
    Statement body;
    JavaToken begin;
    jj_consume_token(FOR);
    begin = token();
    jj_consume_token(LPAREN);
    if (jj_2_60(2147483647)) {
      varExpr = VariableDeclarationExpression();
      jj_consume_token(COLON);
      expr = Expression();
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case ABSTRACT:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case _DEFAULT:
        case DOUBLE:
        case ENUM:
        case FALSE:
        case FINAL:
        case FLOAT:
        case INT:
        case LONG:
        case NATIVE:
        case NEW:
        case NON_SEALED:
        case NULL:
        case PERMITS:
        case PRIVATE:
        case PROTECTED:
        case PUBLIC:
        case RECORD:
        case SEALED:
        case SHORT:
        case STATIC:
        case STRICTFP:
        case SUPER:
        case SWITCH:
        case SYNCHRONIZED:
        case THIS:
        case TRANSIENT:
        case TRUE:
        case VOID:
        case VOLATILE:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case LONG_LITERAL:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case TEXT_BLOCK_LITERAL:
        case IDENTIFIER:
        case LPAREN:
        case SEMICOLON:
        case AT:
        case BANG:
        case TILDE:
        case INCR:
        case DECR:
        case PLUS:
        case MINUS:
          {
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case ABSTRACT:
              case BOOLEAN:
              case BYTE:
              case CHAR:
              case _DEFAULT:
              case DOUBLE:
              case ENUM:
              case FALSE:
              case FINAL:
              case FLOAT:
              case INT:
              case LONG:
              case NATIVE:
              case NEW:
              case NON_SEALED:
              case NULL:
              case PERMITS:
              case PRIVATE:
              case PROTECTED:
              case PUBLIC:
              case RECORD:
              case SEALED:
              case SHORT:
              case STATIC:
              case STRICTFP:
              case SUPER:
              case SWITCH:
              case SYNCHRONIZED:
              case THIS:
              case TRANSIENT:
              case TRUE:
              case VOID:
              case VOLATILE:
              case YIELD:
              case REQUIRES:
              case TO:
              case WITH:
              case OPEN:
              case OPENS:
              case USES:
              case MODULE:
              case EXPORTS:
              case PROVIDES:
              case TRANSITIVE:
              case WHEN:
              case LONG_LITERAL:
              case INTEGER_LITERAL:
              case FLOATING_POINT_LITERAL:
              case CHARACTER_LITERAL:
              case STRING_LITERAL:
              case TEXT_BLOCK_LITERAL:
              case IDENTIFIER:
              case LPAREN:
              case AT:
              case BANG:
              case TILDE:
              case INCR:
              case DECR:
              case PLUS:
              case MINUS:
                {
                  init = ForInit();
                  break;
                }
              default:
                jj_la1[152] = jj_gen;
                ;
            }
            jj_consume_token(SEMICOLON);
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case BOOLEAN:
              case BYTE:
              case CHAR:
              case DOUBLE:
              case ENUM:
              case FALSE:
              case FLOAT:
              case INT:
              case LONG:
              case NEW:
              case NULL:
              case PERMITS:
              case RECORD:
              case SEALED:
              case SHORT:
              case STRICTFP:
              case SUPER:
              case SWITCH:
              case THIS:
              case TRUE:
              case VOID:
              case YIELD:
              case REQUIRES:
              case TO:
              case WITH:
              case OPEN:
              case OPENS:
              case USES:
              case MODULE:
              case EXPORTS:
              case PROVIDES:
              case TRANSITIVE:
              case WHEN:
              case LONG_LITERAL:
              case INTEGER_LITERAL:
              case FLOATING_POINT_LITERAL:
              case CHARACTER_LITERAL:
              case STRING_LITERAL:
              case TEXT_BLOCK_LITERAL:
              case IDENTIFIER:
              case LPAREN:
              case AT:
              case BANG:
              case TILDE:
              case INCR:
              case DECR:
              case PLUS:
              case MINUS:
                {
                  expr = Expression();
                  break;
                }
              default:
                jj_la1[153] = jj_gen;
                ;
            }
            jj_consume_token(SEMICOLON);
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case BOOLEAN:
              case BYTE:
              case CHAR:
              case DOUBLE:
              case ENUM:
              case FALSE:
              case FLOAT:
              case INT:
              case LONG:
              case NEW:
              case NULL:
              case PERMITS:
              case RECORD:
              case SEALED:
              case SHORT:
              case STRICTFP:
              case SUPER:
              case SWITCH:
              case THIS:
              case TRUE:
              case VOID:
              case YIELD:
              case REQUIRES:
              case TO:
              case WITH:
              case OPEN:
              case OPENS:
              case USES:
              case MODULE:
              case EXPORTS:
              case PROVIDES:
              case TRANSITIVE:
              case WHEN:
              case LONG_LITERAL:
              case INTEGER_LITERAL:
              case FLOATING_POINT_LITERAL:
              case CHARACTER_LITERAL:
              case STRING_LITERAL:
              case TEXT_BLOCK_LITERAL:
              case IDENTIFIER:
              case LPAREN:
              case AT:
              case BANG:
              case TILDE:
              case INCR:
              case DECR:
              case PLUS:
              case MINUS:
                {
                  update = ForUpdate();
                  break;
                }
              default:
                jj_la1[154] = jj_gen;
                ;
            }
            break;
          }
        default:
          jj_la1[155] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    jj_consume_token(RPAREN);
    body = Statement();
    if (varExpr != null) {
      {
        if ("" != null) return new ForEachStmt(range(begin, token()), varExpr, expr, body);
      }
    }
    {
      if ("" != null) return new ForStmt(range(begin, token()), init, expr, update, body);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.14
   *
   * <pre>{@code
   * BasicForStatement:
   *     for ( [ForInit] ; [Expression] ; [ForUpdate] ) Statement
   * BasicForStatementNoShortIf:
   *     for ( [ForInit] ; [Expression] ; [ForUpdate] ) StatementNoShortIf
   * ForInit:
   *     StatementExpressionList
   *     LocalVariableDeclaration
   * ForUpdate:
   *     StatementExpressionList
   * StatementExpressionList:
   *     StatementExpression {, StatementExpression}
   * }</pre>
   */
  public final NodeList<Expression> ForInit() throws ParseException {
    NodeList<Expression> ret;
    Expression expr;
    if (jj_2_61(2147483647)) {
      expr = VariableDeclarationExpression();
      ret = new NodeList<Expression>();
      ret.add(expr);
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case DOUBLE:
        case ENUM:
        case FALSE:
        case FLOAT:
        case INT:
        case LONG:
        case NEW:
        case NULL:
        case PERMITS:
        case RECORD:
        case SEALED:
        case SHORT:
        case STRICTFP:
        case SUPER:
        case SWITCH:
        case THIS:
        case TRUE:
        case VOID:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case LONG_LITERAL:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case TEXT_BLOCK_LITERAL:
        case IDENTIFIER:
        case LPAREN:
        case AT:
        case BANG:
        case TILDE:
        case INCR:
        case DECR:
        case PLUS:
        case MINUS:
          {
            ret = ExpressionList();
            break;
          }
        default:
          jj_la1[156] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.14
   *
   * <pre>{@code
   * BasicForStatement:
   *     for ( [ForInit] ; [Expression] ; [ForUpdate] ) Statement
   * BasicForStatementNoShortIf:
   *     for ( [ForInit] ; [Expression] ; [ForUpdate] ) StatementNoShortIf
   * ForInit:
   *     StatementExpressionList
   *     LocalVariableDeclaration
   * ForUpdate:
   *     StatementExpressionList
   * StatementExpressionList:
   *     StatementExpression {, StatementExpression}
   * }</pre>
   */
  public final NodeList<Expression> ExpressionList() throws ParseException {
    NodeList<Expression> ret = new NodeList<Expression>();
    Expression expr;
    expr = Expression();
    ret.add(expr);
    label_51:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case COMMA:
          {
            break;
          }
        default:
          jj_la1[157] = jj_gen;
          break label_51;
      }
      jj_consume_token(COMMA);
      expr = Expression();
      ret.add(expr);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.14
   *
   * <pre>{@code
   * BasicForStatement:
   *     for ( [ForInit] ; [Expression] ; [ForUpdate] ) Statement
   * BasicForStatementNoShortIf:
   *     for ( [ForInit] ; [Expression] ; [ForUpdate] ) StatementNoShortIf
   * ForInit:
   *     StatementExpressionList
   *     LocalVariableDeclaration
   * ForUpdate:
   *     StatementExpressionList
   * StatementExpressionList:
   *     StatementExpression {, StatementExpression}
   * }</pre>
   */
  public final NodeList<Expression> ForUpdate() throws ParseException {
    NodeList<Expression> ret;
    ret = ExpressionList();
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.15
   *
   * <pre>{@code
   * BreakStatement:
   *     break [Identifier] ;
   * }</pre>
   */
  public final BreakStmt BreakStatement() throws ParseException {
    SimpleName label = null;
    JavaToken begin;
    jj_consume_token(BREAK);
    begin = token();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case ENUM:
      case PERMITS:
      case RECORD:
      case SEALED:
      case STRICTFP:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case IDENTIFIER:
        {
          label = SimpleName();
          break;
        }
      default:
        jj_la1[158] = jj_gen;
        ;
    }
    jj_consume_token(SEMICOLON);
    {
      if ("" != null) return new BreakStmt(range(begin, token()), label);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.21
   *
   * <pre>{@code
   * YieldStatement:
   *     yield Expression ;
   * }</pre>
   */
  public final YieldStmt YieldStatement() throws ParseException {
    Expression value;
    JavaToken begin;
    jj_consume_token(YIELD);
    begin = token();
    value = Expression();
    jj_consume_token(SEMICOLON);
    {
      if ("" != null) return new YieldStmt(range(begin, token()), value);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.16
   *
   * <pre>{@code
   * ContinueStatement:
   *     continue [Identifier] ;
   * }</pre>
   */
  public final ContinueStmt ContinueStatement() throws ParseException {
    SimpleName label = null;
    JavaToken begin;
    jj_consume_token(CONTINUE);
    begin = token();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case ENUM:
      case PERMITS:
      case RECORD:
      case SEALED:
      case STRICTFP:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case IDENTIFIER:
        {
          label = SimpleName();
          break;
        }
      default:
        jj_la1[159] = jj_gen;
        ;
    }
    jj_consume_token(SEMICOLON);
    {
      if ("" != null) return new ContinueStmt(range(begin, token()), label);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.17
   *
   * <pre>{@code
   * ReturnStatement:
   *     return [Expression] ;
   * }</pre>
   */
  public final ReturnStmt ReturnStatement() throws ParseException {
    Expression expr = null;
    JavaToken begin;
    jj_consume_token(RETURN);
    begin = token();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case DOUBLE:
      case ENUM:
      case FALSE:
      case FLOAT:
      case INT:
      case LONG:
      case NEW:
      case NULL:
      case PERMITS:
      case RECORD:
      case SEALED:
      case SHORT:
      case STRICTFP:
      case SUPER:
      case SWITCH:
      case THIS:
      case TRUE:
      case VOID:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case LONG_LITERAL:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case CHARACTER_LITERAL:
      case STRING_LITERAL:
      case TEXT_BLOCK_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case AT:
      case BANG:
      case TILDE:
      case INCR:
      case DECR:
      case PLUS:
      case MINUS:
        {
          expr = Expression();
          break;
        }
      default:
        jj_la1[160] = jj_gen;
        ;
    }
    jj_consume_token(SEMICOLON);
    {
      if ("" != null) return new ReturnStmt(range(begin, token()), expr);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.18
   *
   * <pre>{@code
   * ThrowStatement:
   *     throw Expression ;
   * }</pre>
   */
  public final ThrowStmt ThrowStatement() throws ParseException {
    Expression expr;
    JavaToken begin;
    jj_consume_token(THROW);
    begin = token();
    expr = Expression();
    jj_consume_token(SEMICOLON);
    {
      if ("" != null) return new ThrowStmt(range(begin, token()), expr);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.19
   *
   * <pre>{@code
   * SynchronizedStatement:
   *     synchronized ( Expression ) Block
   * }</pre>
   */
  public final SynchronizedStmt SynchronizedStatement() throws ParseException {
    Expression expr;
    BlockStmt body;
    JavaToken begin;
    jj_consume_token(SYNCHRONIZED);
    begin = token();
    jj_consume_token(LPAREN);
    expr = Expression();
    jj_consume_token(RPAREN);
    body = Block();
    {
      if ("" != null) return new SynchronizedStmt(range(begin, token()), expr, body);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * // TODO: Examine more closely.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.20
   * <pre>{@code
   *     TryStatement:
   *         try Block Catches
   *         try Block [Catches] Finally
   *         TryWithResourcesStatement
   *     Catches:
   *         CatchClause {CatchClause}
   *     CatchClause:
   *         catch ( CatchFormalParameter ) Block
   *     CatchFormalParameter:
   *        {VariableModifier} CatchType VariableDeclaratorId
   *     CatchType:
   *         UnannClassType {| ClassType}
   *     Finally:
   *         finally Block
   * }<pre>
   * For Convenience:
   * <pre>{@code
   *     VariableModifier:
   *         Annotation
   *         final
   *     VariableDeclaratorId:
   *         Identifier [Dims]
   *     Dims:
   *         {Annotation} [ ] {{Annotation} [ ]}
   * }<pre>
   */
  public final TryStmt TryStatement() throws ParseException {
    NodeList<Expression> resources = emptyNodeList();
    BlockStmt tryBlock;
    BlockStmt finallyBlock = null;
    NodeList<CatchClause> catchs = emptyNodeList();
    BlockStmt catchBlock;
    ModifierHolder exceptModifier;
    ReferenceType exceptionType;
    NodeList<ReferenceType> exceptionTypes = emptyNodeList();
    Pair<SimpleName, List<ArrayBracketPair>> exceptId;
    JavaToken begin;
    JavaToken catchBegin;
    JavaToken typesBegin;
    JavaToken paramEnd;
    Type type;
    jj_consume_token(TRY);
    begin = token();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case LPAREN:
        {
          resources = ResourceSpecification();
          break;
        }
      default:
        jj_la1[161] = jj_gen;
        ;
    }
    tryBlock = Block();
    label_52:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case CATCH:
          {
            break;
          }
        default:
          jj_la1[162] = jj_gen;
          break label_52;
      }
      jj_consume_token(CATCH);
      catchBegin = token();
      jj_consume_token(LPAREN);
      exceptModifier = Modifiers();
      typesBegin = exceptModifier.begin;
      exceptionType = ReferenceType(emptyNodeList());
      exceptionTypes.add(exceptionType);
      typesBegin = orIfInvalid(typesBegin, token());
      label_53:
      while (true) {
        switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
          case BIT_OR:
            {
              break;
            }
          default:
            jj_la1[163] = jj_gen;
            break label_53;
        }
        jj_consume_token(BIT_OR);
        exceptionType = AnnotatedReferenceType();
        exceptionTypes.add(exceptionType);
      }
      exceptId = VariableDeclaratorId();
      paramEnd = token();
      jj_consume_token(RPAREN);
      catchBlock = Block();
      if (exceptionTypes.size() > 1) {
        type =
            new UnionType(
                range(exceptionTypes.get(0), exceptionTypes.get(exceptionTypes.size() - 1)),
                exceptionTypes);
      } else {
        type = (Type) exceptionTypes.get(0);
      }
      Parameter catchType =
          new Parameter(
              range(typesBegin, paramEnd),
              exceptModifier.modifiers,
              exceptModifier.annotations,
              type,
              false,
              emptyNodeList(),
              exceptId.a);
      catchs = add(catchs, new CatchClause(range(catchBegin, token()), catchType, catchBlock));
      exceptionTypes = emptyNodeList();
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case FINALLY:
        {
          jj_consume_token(FINALLY);
          finallyBlock = Block();
          break;
        }
      default:
        jj_la1[164] = jj_gen;
        ;
    }
    {
      if ("" != null)
        return new TryStmt(range(begin, token()), resources, tryBlock, catchs, finallyBlock);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.20.3
   * <pre>{@code
   *     TryWithResourcesStatement:
   *         try ResourceSpecification Block [Catches] [Finally]
   *     ResourceSpecification:
   *         ( ResourceList [;] )
   *     ResourceList:
   *         Resource {; Resource}
   *     Resource:
   *         {VariableModifier} LocalVariableType Identifier = Expression
   *         VariableAccess
   *     VariableAccess:
   *         ExpressionName
   *         FieldAccess
   * }<pre>
   * For Convenience:
   * <pre>{@code
   *     VariableModifier:
   *         Annotation
   *         final
   *     LocalVariableType:
   *         UnannType
   *         var
   * }<pre>
   */
  public final NodeList<Expression> ResourceSpecification() throws ParseException {
    NodeList<Expression> variables;
    jj_consume_token(LPAREN);
    variables = Resources();
    if (jj_2_62(2)) {
      jj_consume_token(SEMICOLON);
    } else {
      ;
    }
    jj_consume_token(RPAREN);
    {
      if ("" != null) return variables;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.20.3
   * <pre>{@code
   *     ResourceList:
   *         Resource {; Resource}
   *     Resource:
   *         {VariableModifier} LocalVariableType Identifier = Expression
   *         VariableAccess
   *     VariableAccess:
   *         ExpressionName
   *         FieldAccess
   * }<pre>
   * For Convenience:
   * <pre>{@code
   *     VariableModifier:
   *         Annotation
   *         final
   *     LocalVariableType:
   *         UnannType
   *         var
   * }<pre>
   */
  public final NodeList<Expression> Resources() throws ParseException {
    NodeList<Expression> expressions = new NodeList<Expression>();
    Expression expr;
    expr = Resource();
    expressions.add(expr);
    label_54:
    while (true) {
      if (jj_2_63(2)) {
      } else {
        break label_54;
      }
      jj_consume_token(SEMICOLON);
      expr = Resource();
      expressions.add(expr);
    }
    {
      if ("" != null) return expressions;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * // TODO: Examine more closely.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-14.html#jls-14.20.3
   * <pre>{@code
   *     Resource:
   *         {VariableModifier} LocalVariableType Identifier = Expression
   *         VariableAccess
   *     VariableAccess:
   *         ExpressionName
   *         FieldAccess
   * }<pre>
   * For Convenience:
   * <pre>{@code
   *     VariableModifier:
   *         Annotation
   *         final
   *     LocalVariableType:
   *         UnannType
   *         var
   * }<pre>
   */
  public final Expression Resource() throws ParseException {
    Expression expr;
    if (jj_2_64(2147483647)) {
      /*this is a bit more lenient than we need to be, e.g. allowing access modifiers like private*/
      expr = VariableDeclarationExpression();
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case DOUBLE:
        case ENUM:
        case FALSE:
        case FLOAT:
        case INT:
        case LONG:
        case NEW:
        case NULL:
        case PERMITS:
        case RECORD:
        case SEALED:
        case SHORT:
        case STRICTFP:
        case SUPER:
        case THIS:
        case TRUE:
        case VOID:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case LONG_LITERAL:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case TEXT_BLOCK_LITERAL:
        case IDENTIFIER:
        case LPAREN:
        case AT:
          {
            expr = PrimaryExpression();
            break;
          }
        default:
          jj_la1[165] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    {
      if ("" != null) return expr;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /* We use productions to match >>>, >> and > so that we can keep the
   * type declaration syntax with generics clean
   */
  public final void RUNSIGNEDSHIFT() throws ParseException {
    if (getToken(1).kind == GT && getToken(1).realKind == RUNSIGNEDSHIFT) {

    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(GT);
    jj_consume_token(GT);
    jj_consume_token(GT);
  }

  public final void RSIGNEDSHIFT() throws ParseException {
    if (getToken(1).kind == GT && getToken(1).realKind == RSIGNEDSHIFT) {

    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(GT);
    jj_consume_token(GT);
  }

  /*  ANNOTATION SYNTAX - Annotation syntax follows. */

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.7
   * <pre>{@code
   *     Annotation:
   *         NormalAnnotation
   *         MarkerAnnotation
   *         SingleElementAnnotation
   * }<pre>
   */
  public final NodeList<AnnotationExpr> Annotations() throws ParseException {
    NodeList<AnnotationExpr> annotations = new NodeList<AnnotationExpr>();
    AnnotationExpr annotation;
    label_55:
    while (true) {
      if (jj_2_65(2147483647)) {
      } else {
        break label_55;
      }
      annotation = Annotation();
      annotations = add(annotations, annotation);
    }
    {
      if ("" != null) return annotations;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.7
   * <pre>{@code
   *     Annotation:
   *         NormalAnnotation
   *         MarkerAnnotation
   *         SingleElementAnnotation
   * }<pre>
   * For Convenience:
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.7.1
   * <pre>{@code
   *     NormalAnnotation:
   *         @ TypeName ( [ElementValuePairList] )
   *     ElementValuePairList:
   *         ElementValuePair {, ElementValuePair}
   *     ElementValuePair:
   *         Identifier = ElementValue
   *     ElementValue:
   *         ConditionalExpression
   *         ElementValueArrayInitializer
   *         Annotation
   *     ElementValueArrayInitializer:
   *         { [ElementValueList] [,] }
   *     ElementValueList:
   *         ElementValue {, ElementValue}
   * }<pre>
   * For Convenience:
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.7.2
   * <blockquote>
   * It [The marker annotation] is shorthand for the normal annotation:
   * {@code @TypeName()}
   * </blockquote>
   * <pre>{@code
   *     MarkerAnnotation:
   *         @ TypeName
   * }<pre>
   * For Convenience:
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.7.3
   * <blockquote>
   * It [The single element annotation] is shorthand for the normal annotation:
   * {@code @TypeName(value = ElementValue)}
   * </blockquote>
   * <pre>{@code
   *     SingleElementAnnotation:
   *         @ TypeName ( ElementValue )
   * }<pre>
   */
  public final AnnotationExpr Annotation() throws ParseException {
    AnnotationExpr ret;
    Name name;
    NodeList<MemberValuePair> pairs = emptyNodeList();
    JavaToken begin;
    Expression memberVal;
    jj_consume_token(AT);
    begin = token();
    name = Name();
    if (jj_2_66(2147483647)) {
      jj_consume_token(LPAREN);
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case ENUM:
        case PERMITS:
        case RECORD:
        case SEALED:
        case STRICTFP:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case IDENTIFIER:
          {
            pairs = MemberValuePairs();
            break;
          }
        default:
          jj_la1[166] = jj_gen;
          ;
      }
      jj_consume_token(RPAREN);
      ret = new NormalAnnotationExpr(range(begin, token()), name, pairs);
    } else if (jj_2_67(2147483647)) {
      jj_consume_token(LPAREN);
      memberVal = MemberValue();
      jj_consume_token(RPAREN);
      ret = new SingleMemberAnnotationExpr(range(begin, token()), name, memberVal);
    } else {
      ret = new MarkerAnnotationExpr(range(begin, token()), name);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that {@code MemberValuePairs} (JavaParser) is synonymous with {@code ElementValuePairList} (JLS)
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.7.1
   * <pre>{@code
   *     NormalAnnotation:
   *         @ TypeName ( [ElementValuePairList] )
   *     ElementValuePairList:
   *         ElementValuePair {, ElementValuePair}
   *     ElementValuePair:
   *         Identifier = ElementValue
   * }<pre>
   */
  public final NodeList<MemberValuePair> MemberValuePairs() throws ParseException {
    NodeList<MemberValuePair> ret = new NodeList<MemberValuePair>();
    MemberValuePair pair;
    pair = MemberValuePair();
    ret.add(pair);
    label_56:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case COMMA:
          {
            break;
          }
        default:
          jj_la1[167] = jj_gen;
          break label_56;
      }
      jj_consume_token(COMMA);
      pair = MemberValuePair();
      ret.add(pair);
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that {@code MemberValuePair} (JavaParser) is synonymous with {@code ElementValuePair} (JLS)
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.7.1
   * <pre>{@code
   *     ElementValuePair:
   *         Identifier = ElementValue
   *     ElementValue:
   *         ConditionalExpression
   *         ElementValueArrayInitializer
   *         Annotation
   *     ElementValueArrayInitializer:
   *         { [ElementValueList] [,] }
   *     ElementValueList:
   *         ElementValue {, ElementValue}
   * }<pre>
   */
  public final MemberValuePair MemberValuePair() throws ParseException {
    SimpleName name;
    Expression value;
    JavaToken begin;
    name = SimpleName();
    begin = token();
    jj_consume_token(ASSIGN);
    value = MemberValue();
    {
      if ("" != null) return new MemberValuePair(range(begin, token()), name, value);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that {@code MemberValue} (JavaParser) is synonymous with {@code ElementValue} (JLS)
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.7.1
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-ElementValue
   * <pre>{@code
   *     ElementValue:
   *         ConditionalExpression
   *         ElementValueArrayInitializer
   *         Annotation
   *     ElementValueArrayInitializer:
   *         { [ElementValueList] [,] }
   *     ElementValueList:
   *         ElementValue {, ElementValue}
   * }<pre>
   */
  public final Expression MemberValue() throws ParseException {
    Expression ret;
    if (jj_2_68(2147483647)) {
      ret = Annotation();
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case LBRACE:
          {
            ret = MemberValueArrayInitializer();
            break;
          }
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case DOUBLE:
        case ENUM:
        case FALSE:
        case FLOAT:
        case INT:
        case LONG:
        case NEW:
        case NULL:
        case PERMITS:
        case RECORD:
        case SEALED:
        case SHORT:
        case STRICTFP:
        case SUPER:
        case SWITCH:
        case THIS:
        case TRUE:
        case VOID:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case LONG_LITERAL:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case TEXT_BLOCK_LITERAL:
        case IDENTIFIER:
        case LPAREN:
        case AT:
        case BANG:
        case TILDE:
        case INCR:
        case DECR:
        case PLUS:
        case MINUS:
          {
            ret = ConditionalExpression();
            break;
          }
        default:
          jj_la1[168] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that {@code MemberValueArrayInitializer} (JavaParser) is synonymous with {@code ElementValueArrayInitializer} (JLS)
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.7.1
   * <pre>{@code
   *     ElementValueArrayInitializer:
   *         { [ElementValueList] [,] }
   *     ElementValueList:
   *         ElementValue {, ElementValue}
   * }<pre>
   */
  public final Expression MemberValueArrayInitializer() throws ParseException {
    NodeList<Expression> ret = emptyNodeList();
    Expression member;
    JavaToken begin;
    jj_consume_token(LBRACE);
    begin = token();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case BOOLEAN:
      case BYTE:
      case CHAR:
      case DOUBLE:
      case ENUM:
      case FALSE:
      case FLOAT:
      case INT:
      case LONG:
      case NEW:
      case NULL:
      case PERMITS:
      case RECORD:
      case SEALED:
      case SHORT:
      case STRICTFP:
      case SUPER:
      case SWITCH:
      case THIS:
      case TRUE:
      case VOID:
      case YIELD:
      case REQUIRES:
      case TO:
      case WITH:
      case OPEN:
      case OPENS:
      case USES:
      case MODULE:
      case EXPORTS:
      case PROVIDES:
      case TRANSITIVE:
      case WHEN:
      case LONG_LITERAL:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case CHARACTER_LITERAL:
      case STRING_LITERAL:
      case TEXT_BLOCK_LITERAL:
      case IDENTIFIER:
      case LPAREN:
      case LBRACE:
      case AT:
      case BANG:
      case TILDE:
      case INCR:
      case DECR:
      case PLUS:
      case MINUS:
        {
          member = MemberValue();
          ret.add(member);
          label_57:
          while (true) {
            if (jj_2_69(2)) {
            } else {
              break label_57;
            }
            jj_consume_token(COMMA);
            member = MemberValue();
            ret.add(member);
          }
          break;
        }
      default:
        jj_la1[169] = jj_gen;
        ;
    }
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case COMMA:
        {
          jj_consume_token(COMMA);
          break;
        }
      default:
        jj_la1[170] = jj_gen;
        ;
    }
    jj_consume_token(RBRACE);
    {
      if ("" != null) return new ArrayInitializerExpr(range(begin, token()), ret);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /* ANNOTATION TYPES */

  /**
   * <blockquote>
   * An annotation type declaration specifies a new annotation type, a special kind of interface type.
   * To distinguish an annotation type declaration from a normal interface declaration, the keyword interface is preceded by an at-sign (@).
   * </blockquote>
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.6
   * <pre>{@code
   *     AnnotationTypeDeclaration:
   *         {InterfaceModifier} @ interface TypeIdentifier AnnotationTypeBody
   * }<pre>
   */
  public final AnnotationDeclaration AnnotationTypeDeclaration(ModifierHolder modifier)
      throws ParseException {
    SimpleName name;
    NodeList<BodyDeclaration<?>> members = emptyNodeList();
    JavaToken begin = modifier.begin;
    jj_consume_token(AT);
    begin = orIfInvalid(begin, token());
    jj_consume_token(INTERFACE);
    name = SimpleName();
    members = AnnotationTypeBody();
    {
      if ("" != null)
        return new AnnotationDeclaration(
            range(begin, token()), modifier.modifiers, modifier.annotations, name, members);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.6.1
   * <pre>{@code
   *     AnnotationTypeBody:
   *         { {AnnotationTypeMemberDeclaration} }
   *     AnnotationTypeMemberDeclaration:
   *         AnnotationTypeElementDeclaration
   *         ConstantDeclaration
   *         ClassDeclaration
   *         InterfaceDeclaration
   *         ;
   * }<pre>
   */
  public final NodeList<BodyDeclaration<?>> AnnotationTypeBody() throws ParseException {
    NodeList<BodyDeclaration<?>> ret = emptyNodeList();
    BodyDeclaration member;
    jj_consume_token(LBRACE);
    label_58:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case ABSTRACT:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CLASS:
        case _DEFAULT:
        case DOUBLE:
        case ENUM:
        case FINAL:
        case FLOAT:
        case INT:
        case INTERFACE:
        case LONG:
        case NATIVE:
        case NON_SEALED:
        case PERMITS:
        case PRIVATE:
        case PROTECTED:
        case PUBLIC:
        case RECORD:
        case SEALED:
        case SHORT:
        case STATIC:
        case STRICTFP:
        case SYNCHRONIZED:
        case TRANSIENT:
        case VOLATILE:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case IDENTIFIER:
        case SEMICOLON:
        case AT:
          {
            break;
          }
        default:
          jj_la1[171] = jj_gen;
          break label_58;
      }
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case ABSTRACT:
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case CLASS:
        case _DEFAULT:
        case DOUBLE:
        case ENUM:
        case FINAL:
        case FLOAT:
        case INT:
        case INTERFACE:
        case LONG:
        case NATIVE:
        case NON_SEALED:
        case PERMITS:
        case PRIVATE:
        case PROTECTED:
        case PUBLIC:
        case RECORD:
        case SEALED:
        case SHORT:
        case STATIC:
        case STRICTFP:
        case SYNCHRONIZED:
        case TRANSIENT:
        case VOLATILE:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case IDENTIFIER:
        case AT:
          {
            member = AnnotationBodyDeclaration();
            ret = addWhenNotNull(ret, member);
            break;
          }
        case SEMICOLON:
          {
            jj_consume_token(SEMICOLON);
            break;
          }
        default:
          jj_la1[172] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    jj_consume_token(RBRACE);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that {@code AnnotationTypeMemberDeclaration} (JLS) and {@code AnnotationBodyDeclaration} (JavaParser) are synonymous.
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.6.1
   * <pre>{@code
   *     AnnotationTypeBody:
   *         { {AnnotationTypeMemberDeclaration} }
   *     AnnotationTypeMemberDeclaration:
   *         AnnotationTypeElementDeclaration
   *         ConstantDeclaration
   *         ClassDeclaration
   *         InterfaceDeclaration
   *         ;
   *     AnnotationTypeElementDeclaration:
   *         {AnnotationTypeElementModifier} UnannType Identifier ( ) [Dims] [DefaultValue] ;
   *     AnnotationTypeElementModifier:
   *         (one of)
   *         Annotation public
   *         abstract
   * }<pre>
   * For Convenience:
   * <pre>{@code
   *     Dims:
   *         {Annotation} [ ] {{Annotation} [ ]}
   * }<pre>
   */
  public final BodyDeclaration<?> AnnotationBodyDeclaration() throws ParseException {
    ModifierHolder modifier;
    BodyDeclaration ret;
    modifier = Modifiers();
    if (jj_2_70(2147483647)) {
      ret = AnnotationTypeMemberDeclaration(modifier);
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case CLASS:
        case INTERFACE:
          {
            ret = ClassOrInterfaceDeclaration(modifier);
            break;
          }
        default:
          jj_la1[173] = jj_gen;
          if (jj_2_71(2147483647)) {
            ret = EnumDeclaration(modifier);
          } else {
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case AT:
                {
                  ret = AnnotationTypeDeclaration(modifier);
                  break;
                }
              case BOOLEAN:
              case BYTE:
              case CHAR:
              case DOUBLE:
              case ENUM:
              case FLOAT:
              case INT:
              case LONG:
              case PERMITS:
              case RECORD:
              case SEALED:
              case SHORT:
              case STRICTFP:
              case YIELD:
              case REQUIRES:
              case TO:
              case WITH:
              case OPEN:
              case OPENS:
              case USES:
              case MODULE:
              case EXPORTS:
              case PROVIDES:
              case TRANSITIVE:
              case WHEN:
              case IDENTIFIER:
                {
                  ret = FieldDeclaration(modifier);
                  break;
                }
              default:
                jj_la1[174] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
          }
      }
    }
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * Note that {@code AnnotationTypeElementDeclaration} (JLS) and {@code AnnotationTypeMemberDeclaration} (JavaParser) are synonymous.
   * // TODO/FIXME: Consider missing `[Dims] (present in the JLS, but not the JavaParser grammar)
   * // TODO/FIXME: {AnnotationTypeElementModifier} UnannType Identifier ( ) [Dims] [DefaultValue] ;
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.6.1
   * <pre>{@code
   *     AnnotationTypeElementDeclaration:
   *         {AnnotationTypeElementModifier} UnannType Identifier ( ) [Dims] [DefaultValue] ;
   *     AnnotationTypeElementModifier:
   *         (one of)
   *         Annotation public
   *         abstract
   * }<pre>
   * For Convenience:
   * <pre>{@code
   *     Dims:
   *         {Annotation} [ ] {{Annotation} [ ]}
   * }<pre>
   */
  public final AnnotationMemberDeclaration AnnotationTypeMemberDeclaration(ModifierHolder modifier)
      throws ParseException {
    Type type;
    SimpleName name;
    Expression defaultVal = null;
    // TODO/FIXME: Consider missing `[Dims] (present in the JLS, but not the JavaParser grammar)
    // TODO/FIXME: {AnnotationTypeElementModifier} UnannType Identifier ( ) [Dims] [DefaultValue] ;
    type = Type(emptyNodeList());
    name = SimpleName();
    jj_consume_token(LPAREN);
    jj_consume_token(RPAREN);
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case _DEFAULT:
        {
          defaultVal = DefaultValue();
          break;
        }
      default:
        jj_la1[175] = jj_gen;
        ;
    }
    jj_consume_token(SEMICOLON);
    JavaToken begin = orIfInvalid(modifier.begin, type);
    {
      if ("" != null)
        return new AnnotationMemberDeclaration(
            range(begin, token()),
            modifier.modifiers,
            modifier.annotations,
            type,
            name,
            defaultVal);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.6.2
   * <pre>{@code
   *     DefaultValue:
   *     default ElementValue
   * }<pre>
   * For Convenience:
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-9.7.1
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-9.html#jls-ElementValue
   * <pre>{@code
   *     ElementValue:
   *         ConditionalExpression
   *         ElementValueArrayInitializer
   *         Annotation
   *     ElementValueArrayInitializer:
   *         { [ElementValueList] [,] }
   *     ElementValueList:
   *         ElementValue {, ElementValue}
   * }<pre>
   */
  public final Expression DefaultValue() throws ParseException {
    Expression ret;
    jj_consume_token(_DEFAULT);
    ret = MemberValue();
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /* MODULES - Module syntax follows */

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-7.html#jls-ModuleDirective
   * <pre>{@code
   *     ModuleDirective:
   *         requires {RequiresModifier} ModuleName ;
   *         exports PackageName [to ModuleName {, ModuleName}] ;
   *         opens PackageName [to ModuleName {, ModuleName}] ;
   *         uses TypeName ;
   *         provides TypeName with TypeName {, TypeName} ;
   *     RequiresModifier:
   *         (one of)
   *         transitive static
   * }<pre>
   */
  public final ModuleDirective ModuleDirective() throws ParseException {
    ModifierHolder modifiers;
    Name name;
    Name tmpName;
    NodeList<Name> names = emptyNodeList();
    JavaToken begin;
    ModuleDirective directive;
    JavaToken transitiveExceptionalToken;
    if (jj_2_72(2147483647)) {
      jj_consume_token(REQUIRES);
      begin = token();
      jj_consume_token(TRANSITIVE);
      transitiveExceptionalToken = token();
      setTokenKind(IDENTIFIER);
      jj_consume_token(SEMICOLON);
      directive =
          new ModuleRequiresDirective(
              range(begin, token()),
              new NodeList<Modifier>(),
              new Name(
                  range(transitiveExceptionalToken, transitiveExceptionalToken),
                  null,
                  transitiveExceptionalToken.getText()));
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case REQUIRES:
          {
            jj_consume_token(REQUIRES);
            begin = token();
            modifiers = Modifiers();
            name = Name();
            jj_consume_token(SEMICOLON);
            directive =
                new ModuleRequiresDirective(range(begin, token()), modifiers.modifiers, name);
            break;
          }
        case EXPORTS:
          {
            jj_consume_token(EXPORTS);
            begin = token();
            name = Name();
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case TO:
                {
                  jj_consume_token(TO);
                  tmpName = Name();
                  names.add(tmpName);
                  label_59:
                  while (true) {
                    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                      case COMMA:
                        {
                          break;
                        }
                      default:
                        jj_la1[176] = jj_gen;
                        break label_59;
                    }
                    jj_consume_token(COMMA);
                    tmpName = Name();
                    names.add(tmpName);
                  }
                  break;
                }
              default:
                jj_la1[177] = jj_gen;
                ;
            }
            jj_consume_token(SEMICOLON);
            directive = new ModuleExportsDirective(range(begin, token()), name, names);
            break;
          }
        case OPENS:
          {
            jj_consume_token(OPENS);
            begin = token();
            name = Name();
            switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
              case TO:
                {
                  jj_consume_token(TO);
                  tmpName = Name();
                  names.add(tmpName);
                  label_60:
                  while (true) {
                    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                      case COMMA:
                        {
                          break;
                        }
                      default:
                        jj_la1[178] = jj_gen;
                        break label_60;
                    }
                    jj_consume_token(COMMA);
                    tmpName = Name();
                    names.add(tmpName);
                  }
                  break;
                }
              default:
                jj_la1[179] = jj_gen;
                ;
            }
            jj_consume_token(SEMICOLON);
            directive = new ModuleOpensDirective(range(begin, token()), name, names);
            break;
          }
        case USES:
          {
            jj_consume_token(USES);
            begin = token();
            name = Name();
            jj_consume_token(SEMICOLON);
            directive = new ModuleUsesDirective(range(begin, token()), name);
            break;
          }
        case PROVIDES:
          {
            jj_consume_token(PROVIDES);
            begin = token();
            name = Name();
            jj_consume_token(WITH);
            tmpName = Name();
            names.add(tmpName);
            label_61:
            while (true) {
              switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
                case COMMA:
                  {
                    break;
                  }
                default:
                  jj_la1[180] = jj_gen;
                  break label_61;
              }
              jj_consume_token(COMMA);
              tmpName = Name();
              names.add(tmpName);
            }
            jj_consume_token(SEMICOLON);
            directive = new ModuleProvidesDirective(range(begin, token()), name, names);
            break;
          }
        default:
          jj_la1[181] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    {
      if ("" != null) return directive;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /**
   * https://docs.oracle.com/javase/specs/jls/se15/html/jls-7.html#jls-7.7
   * <pre>{@code
   *     ModuleDeclaration:
   *         {Annotation} [open] module Identifier {. Identifier} { {ModuleDirective} }
   * }<pre>
   */
  public final ModuleDeclaration ModuleDeclaration(ModifierHolder modifier) throws ParseException {
    NodeList<ModuleDirective> directives = new NodeList<ModuleDirective>();
    boolean open = false;
    ModuleDirective directive;
    Name name;
    JavaToken begin = modifier.begin;
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case OPEN:
        {
          jj_consume_token(OPEN);
          open = true;
          begin = orIfInvalid(begin, token());
          break;
        }
      default:
        jj_la1[182] = jj_gen;
        ;
    }
    jj_consume_token(MODULE);
    begin = orIfInvalid(begin, token());
    name = Name();
    jj_consume_token(LBRACE);
    label_62:
    while (true) {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case REQUIRES:
        case OPENS:
        case USES:
        case EXPORTS:
        case PROVIDES:
          {
            break;
          }
        default:
          jj_la1[183] = jj_gen;
          break label_62;
      }
      directive = ModuleDirective();
      directives = add(directives, directive);
    }
    jj_consume_token(RBRACE);
    {
      if ("" != null)
        return new ModuleDeclaration(
            range(begin, token()), modifier.annotations, name, open, directives);
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  /* Rules for matching partial inputs.
   * These rules are needed to properly terminate them -
   * if we simply use the usual rules, they will ignore everything in the provider
   * after they matched their desired input, which will lead to unexpected behaviour
   */
  public final BlockStmt BlockParseStart() throws ParseException {
    BlockStmt ret;
    ret = Block();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final Statement BlockStatementParseStart() throws ParseException {
    Statement ret;
    if (jj_2_73(3)) {
      ret = BlockStatement();
    } else {
      switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
        case BOOLEAN:
        case BYTE:
        case CHAR:
        case DOUBLE:
        case ENUM:
        case FALSE:
        case FLOAT:
        case INT:
        case LONG:
        case NEW:
        case NULL:
        case PERMITS:
        case RECORD:
        case SEALED:
        case SHORT:
        case STRICTFP:
        case SUPER:
        case THIS:
        case TRUE:
        case VOID:
        case YIELD:
        case REQUIRES:
        case TO:
        case WITH:
        case OPEN:
        case OPENS:
        case USES:
        case MODULE:
        case EXPORTS:
        case PROVIDES:
        case TRANSITIVE:
        case WHEN:
        case LONG_LITERAL:
        case INTEGER_LITERAL:
        case FLOATING_POINT_LITERAL:
        case CHARACTER_LITERAL:
        case STRING_LITERAL:
        case TEXT_BLOCK_LITERAL:
        case IDENTIFIER:
        case LPAREN:
        case AT:
        case LT:
          {
            ret = ExplicitConstructorInvocation();
            break;
          }
        default:
          jj_la1[184] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
      }
    }
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final ImportDeclaration ImportDeclarationParseStart() throws ParseException {
    ImportDeclaration ret;
    ret = ImportDeclaration();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final Expression ExpressionParseStart() throws ParseException {
    Expression ret;
    ret = Expression();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final AnnotationExpr AnnotationParseStart() throws ParseException {
    AnnotationExpr ret;
    ret = Annotation();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final BodyDeclaration<?> AnnotationBodyDeclarationParseStart() throws ParseException {
    BodyDeclaration<?> ret;
    ret = AnnotationBodyDeclaration();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final BodyDeclaration<?> ClassOrInterfaceBodyDeclarationParseStart()
      throws ParseException {
    BodyDeclaration<?> ret;
    ret = ClassOrInterfaceBodyDeclaration();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final ClassOrInterfaceType ClassOrInterfaceTypeParseStart() throws ParseException {
    ClassOrInterfaceType ret;
    ret = AnnotatedClassOrInterfaceType();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final Type ResultTypeParseStart() throws ParseException {
    NodeList<AnnotationExpr> annotations;
    Type ret;
    annotations = Annotations();
    ret = ResultType(annotations);
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final VariableDeclarationExpr VariableDeclarationExpressionParseStart()
      throws ParseException {
    VariableDeclarationExpr ret;
    ret = VariableDeclarationExpression();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final ExplicitConstructorInvocationStmt ExplicitConstructorInvocationParseStart()
      throws ParseException {
    ExplicitConstructorInvocationStmt ret;
    ret = ExplicitConstructorInvocation();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final Name NameParseStart() throws ParseException {
    Name ret;
    ret = Name();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final SimpleName SimpleNameParseStart() throws ParseException {
    SimpleName ret;
    ret = SimpleName();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final Parameter ParameterParseStart() throws ParseException {
    Parameter ret;
    ret = Parameter();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final PackageDeclaration PackageDeclarationParseStart() throws ParseException {
    PackageDeclaration ret;
    ret = PackageDeclaration();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final TypeDeclaration<?> TypeDeclarationParseStart() throws ParseException {
    TypeDeclaration<?> ret;
    ModifierHolder modifier;
    modifier = Modifiers();
    switch (jj_ntk == -1 ? jj_ntk_f() : jj_ntk) {
      case CLASS:
      case INTERFACE:
        {
          ret = ClassOrInterfaceDeclaration(modifier);
          break;
        }
      case ENUM:
        {
          ret = EnumDeclaration(modifier);
          break;
        }
      case AT:
        {
          ret = AnnotationTypeDeclaration(modifier);
          break;
        }
      default:
        jj_la1[185] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final ModuleDeclaration ModuleDeclarationParseStart() throws ParseException {
    ModuleDeclaration ret;
    ModifierHolder modifiers;
    modifiers = Modifiers();
    ret = ModuleDeclaration(modifiers);
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final ModuleDirective ModuleDirectiveParseStart() throws ParseException {
    ModuleDirective ret;
    ret = ModuleDirective();
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final TypeParameter TypeParameterParseStart() throws ParseException {
    TypeParameter ret;
    NodeList<AnnotationExpr> annotations;
    annotations = Annotations();
    ret = TypeParameter(annotations);
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  public final MethodDeclaration MethodDeclarationParseStart() throws ParseException {
    MethodDeclaration ret;
    ModifierHolder modifier;
    modifier = Modifiers();
    ret = MethodDeclaration(modifier);
    jj_consume_token(0);
    {
      if ("" != null) return ret;
    }
    throw new IllegalStateException("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_1());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(0, xla);
    }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_2());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(1, xla);
    }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_3());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(2, xla);
    }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_4());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(3, xla);
    }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_5());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(4, xla);
    }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_6());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(5, xla);
    }
  }

  private boolean jj_2_7(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_7());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(6, xla);
    }
  }

  private boolean jj_2_8(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_8());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(7, xla);
    }
  }

  private boolean jj_2_9(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_9());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(8, xla);
    }
  }

  private boolean jj_2_10(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_10());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(9, xla);
    }
  }

  private boolean jj_2_11(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_11());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(10, xla);
    }
  }

  private boolean jj_2_12(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_12());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(11, xla);
    }
  }

  private boolean jj_2_13(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_13());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(12, xla);
    }
  }

  private boolean jj_2_14(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_14());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(13, xla);
    }
  }

  private boolean jj_2_15(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_15());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(14, xla);
    }
  }

  private boolean jj_2_16(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_16());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(15, xla);
    }
  }

  private boolean jj_2_17(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_17());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(16, xla);
    }
  }

  private boolean jj_2_18(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_18());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(17, xla);
    }
  }

  private boolean jj_2_19(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_19());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(18, xla);
    }
  }

  private boolean jj_2_20(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_20());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(19, xla);
    }
  }

  private boolean jj_2_21(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_21());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(20, xla);
    }
  }

  private boolean jj_2_22(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_22());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(21, xla);
    }
  }

  private boolean jj_2_23(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_23());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(22, xla);
    }
  }

  private boolean jj_2_24(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_24());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(23, xla);
    }
  }

  private boolean jj_2_25(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_25());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(24, xla);
    }
  }

  private boolean jj_2_26(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_26());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(25, xla);
    }
  }

  private boolean jj_2_27(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_27());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(26, xla);
    }
  }

  private boolean jj_2_28(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_28());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(27, xla);
    }
  }

  private boolean jj_2_29(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_29());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(28, xla);
    }
  }

  private boolean jj_2_30(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_30());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(29, xla);
    }
  }

  private boolean jj_2_31(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_31());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(30, xla);
    }
  }

  private boolean jj_2_32(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_32());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(31, xla);
    }
  }

  private boolean jj_2_33(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_33());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(32, xla);
    }
  }

  private boolean jj_2_34(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_34());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(33, xla);
    }
  }

  private boolean jj_2_35(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_35());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(34, xla);
    }
  }

  private boolean jj_2_36(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_36());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(35, xla);
    }
  }

  private boolean jj_2_37(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_37());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(36, xla);
    }
  }

  private boolean jj_2_38(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_38());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(37, xla);
    }
  }

  private boolean jj_2_39(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_39());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(38, xla);
    }
  }

  private boolean jj_2_40(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_40());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(39, xla);
    }
  }

  private boolean jj_2_41(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_41());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(40, xla);
    }
  }

  private boolean jj_2_42(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_42());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(41, xla);
    }
  }

  private boolean jj_2_43(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_43());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(42, xla);
    }
  }

  private boolean jj_2_44(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_44());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(43, xla);
    }
  }

  private boolean jj_2_45(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_45());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(44, xla);
    }
  }

  private boolean jj_2_46(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_46());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(45, xla);
    }
  }

  private boolean jj_2_47(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_47());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(46, xla);
    }
  }

  private boolean jj_2_48(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_48());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(47, xla);
    }
  }

  private boolean jj_2_49(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_49());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(48, xla);
    }
  }

  private boolean jj_2_50(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_50());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(49, xla);
    }
  }

  private boolean jj_2_51(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_51());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(50, xla);
    }
  }

  private boolean jj_2_52(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_52());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(51, xla);
    }
  }

  private boolean jj_2_53(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_53());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(52, xla);
    }
  }

  private boolean jj_2_54(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_54());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(53, xla);
    }
  }

  private boolean jj_2_55(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_55());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(54, xla);
    }
  }

  private boolean jj_2_56(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_56());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(55, xla);
    }
  }

  private boolean jj_2_57(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_57());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(56, xla);
    }
  }

  private boolean jj_2_58(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_58());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(57, xla);
    }
  }

  private boolean jj_2_59(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_59());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(58, xla);
    }
  }

  private boolean jj_2_60(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_60());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(59, xla);
    }
  }

  private boolean jj_2_61(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_61());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(60, xla);
    }
  }

  private boolean jj_2_62(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_62());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(61, xla);
    }
  }

  private boolean jj_2_63(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_63());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(62, xla);
    }
  }

  private boolean jj_2_64(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_64());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(63, xla);
    }
  }

  private boolean jj_2_65(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_65());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(64, xla);
    }
  }

  private boolean jj_2_66(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_66());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(65, xla);
    }
  }

  private boolean jj_2_67(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_67());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(66, xla);
    }
  }

  private boolean jj_2_68(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_68());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(67, xla);
    }
  }

  private boolean jj_2_69(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_69());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(68, xla);
    }
  }

  private boolean jj_2_70(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_70());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(69, xla);
    }
  }

  private boolean jj_2_71(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_71());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(70, xla);
    }
  }

  private boolean jj_2_72(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_72());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(71, xla);
    }
  }

  private boolean jj_2_73(int xla) {
    jj_la = xla;
    jj_scanpos = token;
    jj_lastpos = token;
    try {
      return (!jj_3_73());
    } catch (LookaheadSuccess ls) {
      return true;
    } finally {
      jj_save(72, xla);
    }
  }

  private boolean jj_3R_159() {
    if (jj_scan_token(ASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_160() {
    if (jj_scan_token(STARASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_161() {
    if (jj_scan_token(SLASHASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_461() {
    if (jj_scan_token(FINALLY)) return true;
    if (jj_3R_142()) return true;
    return false;
  }

  private boolean jj_3R_473() {
    if (jj_scan_token(FINALLY)) return true;
    if (jj_3R_142()) return true;
    return false;
  }

  private boolean jj_3R_162() {
    if (jj_scan_token(REMASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_163() {
    if (jj_scan_token(PLUSASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_164() {
    if (jj_scan_token(MINUSASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_165() {
    if (jj_scan_token(LSHIFTASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_166() {
    if (jj_scan_token(RSIGNEDSHIFTASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_167() {
    if (jj_scan_token(RUNSIGNEDSHIFTASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_168() {
    if (jj_scan_token(ANDASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_169() {
    if (jj_scan_token(XORASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_170() {
    if (jj_scan_token(ORASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_253() {
    if (jj_scan_token(NEW)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_316()) jj_scanpos = xsp;
    if (jj_3R_101()) return true;
    xsp = jj_scanpos;
    if (jj_3R_317()) {
      jj_scanpos = xsp;
      if (jj_3R_318()) return true;
    }
    return false;
  }

  private boolean jj_3R_316() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_116() {
    if (jj_3R_88()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_188()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_317() {
    if (jj_3R_112()) return true;
    if (jj_3R_354()) return true;
    return false;
  }

  private boolean jj_3R_318() {
    if (jj_3R_156()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_355()) {
      jj_scanpos = xsp;
      if (jj_3R_356()) return true;
    }
    return false;
  }

  private boolean jj_3R_188() {
    if (jj_3R_140()) return true;
    return false;
  }

  private boolean jj_3R_171() {
    if (jj_3R_225()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_286()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_355() {
    if (jj_3R_354()) return true;
    return false;
  }

  private boolean jj_3R_286() {
    if (jj_scan_token(HOOK)) return true;
    if (jj_3R_104()) return true;
    if (jj_scan_token(COLON)) return true;
    if (jj_3R_104()) return true;
    return false;
  }

  private boolean jj_3R_386() {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_411()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_62()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_356() {
    if (jj_3R_205()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_49()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3_62() {
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3_49() {
    if (jj_3R_120()) return true;
    return false;
  }

  private boolean jj_3R_93() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_146()) {
      jj_scanpos = xsp;
      if (jj_3R_147()) return true;
    }
    return false;
  }

  private boolean jj_3R_146() {
    if (jj_3R_211()) return true;
    return false;
  }

  private boolean jj_3R_147() {
    if (jj_3R_104()) return true;
    return false;
  }

  private boolean jj_3R_225() {
    if (jj_3R_277()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_340()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_340() {
    if (jj_scan_token(SC_OR)) return true;
    if (jj_3R_277()) return true;
    return false;
  }

  private boolean jj_3R_411() {
    if (jj_3R_130()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_63()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3_63() {
    if (jj_scan_token(SEMICOLON)) return true;
    if (jj_3R_130()) return true;
    return false;
  }

  private boolean jj_3R_354() {
    Token xsp;
    if (jj_3_50()) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_50()) {
        jj_scanpos = xsp;
        break;
      }
    }
    xsp = jj_scanpos;
    if (jj_3R_383()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3_50() {
    if (jj_3R_101()) return true;
    if (jj_scan_token(LBRACKET)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_121()) jj_scanpos = xsp;
    if (jj_scan_token(RBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_211() {
    if (jj_scan_token(LBRACE)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_375()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(108)) jj_scanpos = xsp;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_383() {
    if (jj_3R_211()) return true;
    return false;
  }

  private boolean jj_3R_121() {
    if (jj_3R_104()) return true;
    return false;
  }

  private boolean jj_3R_375() {
    if (jj_3R_93()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_19()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3_19() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_93()) return true;
    return false;
  }

  private boolean jj_3R_277() {
    if (jj_3R_334()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_372()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_130() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_194()) {
      jj_scanpos = xsp;
      if (jj_3R_195()) return true;
    }
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_372() {
    if (jj_scan_token(SC_AND)) return true;
    if (jj_3R_334()) return true;
    return false;
  }

  private boolean jj_3R_194() {
    if (jj_3R_126()) return true;
    return false;
  }

  private boolean jj_3_64() {
    if (jj_3R_124()) return true;
    if (jj_3R_84()) return true;
    if (jj_3R_131()) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_3R_63()) return true;
    return false;
  }

  private boolean jj_3R_195() {
    if (jj_3R_237()) return true;
    return false;
  }

  private boolean jj_3R_393() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_408()) jj_scanpos = xsp;
    if (jj_3R_101()) return true;
    if (jj_3R_117()) return true;
    if (jj_3R_88()) return true;
    if (jj_3R_90()) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_448()) {
        jj_scanpos = xsp;
        break;
      }
    }
    xsp = jj_scanpos;
    if (jj_3R_449()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3R_450()) {
      jj_scanpos = xsp;
      if (jj_scan_token(107)) return true;
    }
    return false;
  }

  private boolean jj_3R_408() {
    if (jj_3R_137()) return true;
    return false;
  }

  private boolean jj_3R_108() {
    jj_lookingAhead = true;
    jj_semLA = getToken(1).kind == GT && getToken(1).realKind == RUNSIGNEDSHIFT;
    jj_lookingAhead = false;
    if (!jj_semLA || jj_3R_174()) return true;
    if (jj_scan_token(GT)) return true;
    if (jj_scan_token(GT)) return true;
    if (jj_scan_token(GT)) return true;
    return false;
  }

  private boolean jj_3R_223() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_51()) {
      jj_scanpos = xsp;
      if (jj_3R_260()) {
        jj_scanpos = xsp;
        if (jj_3_52()) {
          jj_scanpos = xsp;
          if (jj_3R_261()) {
            jj_scanpos = xsp;
            if (jj_3R_262()) {
              jj_scanpos = xsp;
              if (jj_3R_263()) {
                jj_scanpos = xsp;
                if (jj_3R_264()) {
                  jj_scanpos = xsp;
                  if (jj_3R_265()) {
                    jj_scanpos = xsp;
                    if (jj_3R_266()) {
                      jj_scanpos = xsp;
                      if (jj_3R_267()) {
                        jj_scanpos = xsp;
                        if (jj_3R_268()) {
                          jj_scanpos = xsp;
                          if (jj_3R_269()) {
                            jj_scanpos = xsp;
                            if (jj_3R_270()) {
                              jj_scanpos = xsp;
                              if (jj_3R_271()) {
                                jj_scanpos = xsp;
                                if (jj_3R_272()) {
                                  jj_scanpos = xsp;
                                  if (jj_3R_273()) {
                                    jj_scanpos = xsp;
                                    if (jj_3R_274()) return true;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  private boolean jj_3R_448() {
    if (jj_3R_140()) return true;
    return false;
  }

  private boolean jj_3R_449() {
    if (jj_scan_token(THROWS)) return true;
    if (jj_3R_278()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_465()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_334() {
    if (jj_3R_363()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_394()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_107() {
    jj_lookingAhead = true;
    jj_semLA = getToken(1).kind == GT && getToken(1).realKind == RSIGNEDSHIFT;
    jj_lookingAhead = false;
    if (!jj_semLA || jj_3R_173()) return true;
    if (jj_scan_token(GT)) return true;
    if (jj_scan_token(GT)) return true;
    return false;
  }

  private boolean jj_3_51() {
    if (jj_3R_122()) return true;
    return false;
  }

  private boolean jj_3R_174() {
    return false;
  }

  private boolean jj_3R_465() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_278()) return true;
    return false;
  }

  private boolean jj_3R_450() {
    if (jj_3R_142()) return true;
    return false;
  }

  private boolean jj_3R_260() {
    if (jj_3R_319()) return true;
    return false;
  }

  private boolean jj_3_52() {
    if (jj_3R_123()) return true;
    return false;
  }

  private boolean jj_3R_394() {
    if (jj_scan_token(BIT_OR)) return true;
    if (jj_3R_363()) return true;
    return false;
  }

  private boolean jj_3R_261() {
    if (jj_3R_142()) return true;
    return false;
  }

  private boolean jj_3R_262() {
    if (jj_3R_320()) return true;
    return false;
  }

  private boolean jj_3R_263() {
    if (jj_3R_321()) return true;
    return false;
  }

  private boolean jj_3R_264() {
    if (jj_3R_322()) return true;
    return false;
  }

  private boolean jj_3R_63() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_134()) {
        jj_scanpos = xsp;
        break;
      }
    }
    if (jj_scan_token(PACKAGE)) return true;
    if (jj_3R_95()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_173() {
    return false;
  }

  private boolean jj_3R_265() {
    if (jj_3R_323()) return true;
    return false;
  }

  private boolean jj_3R_266() {
    if (jj_3R_324()) return true;
    return false;
  }

  private boolean jj_3R_134() {
    if (jj_3R_135()) return true;
    return false;
  }

  private boolean jj_3R_267() {
    if (jj_3R_325()) return true;
    return false;
  }

  private boolean jj_3R_268() {
    if (jj_3R_326()) return true;
    return false;
  }

  private boolean jj_3R_269() {
    if (jj_3R_327()) return true;
    return false;
  }

  private boolean jj_3R_270() {
    if (jj_3R_328()) return true;
    return false;
  }

  private boolean jj_3R_271() {
    if (jj_3R_329()) return true;
    return false;
  }

  private boolean jj_3R_272() {
    if (jj_3R_330()) return true;
    return false;
  }

  private boolean jj_3R_278() {
    if (jj_3R_101()) return true;
    if (jj_3R_202()) return true;
    return false;
  }

  private boolean jj_3R_273() {
    if (jj_3R_331()) return true;
    return false;
  }

  private boolean jj_3R_274() {
    if (jj_3R_332()) return true;
    return false;
  }

  private boolean jj_3R_101() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_157()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_157() {
    if (jj_3R_135()) return true;
    return false;
  }

  private boolean jj_3R_118() {
    if (jj_3R_101()) return true;
    if (jj_3R_84()) return true;
    return false;
  }

  private boolean jj_3R_319() {
    if (jj_scan_token(ASSERT)) return true;
    if (jj_3R_104()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_376()) jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_363() {
    if (jj_3R_387()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_409()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_376() {
    if (jj_scan_token(COLON)) return true;
    if (jj_3R_104()) return true;
    return false;
  }

  private boolean jj_3_65() {
    if (jj_scan_token(AT)) return true;
    return false;
  }

  private boolean jj_3R_409() {
    if (jj_scan_token(XOR)) return true;
    if (jj_3R_387()) return true;
    return false;
  }

  private boolean jj_3R_122() {
    if (jj_3R_88()) return true;
    if (jj_scan_token(COLON)) return true;
    if (jj_3R_223()) return true;
    return false;
  }

  private boolean jj_3R_90() {
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_145()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_387() {
    if (jj_3R_402()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_417()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_145() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_208()) {
      jj_scanpos = xsp;
      if (jj_3R_209()) return true;
    }
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_210()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_417() {
    if (jj_scan_token(BIT_AND)) return true;
    if (jj_3R_402()) return true;
    return false;
  }

  private boolean jj_3R_208() {
    if (jj_3R_94()) return true;
    return false;
  }

  private boolean jj_3R_209() {
    if (jj_3R_115()) return true;
    return false;
  }

  private boolean jj_3R_210() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_115()) return true;
    return false;
  }

  private boolean jj_3R_142() {
    if (jj_scan_token(LBRACE)) return true;
    if (jj_3R_203()) return true;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3_20() {
    if (jj_3R_94()) return true;
    return false;
  }

  private boolean jj_3R_135() {
    if (jj_scan_token(AT)) return true;
    if (jj_3R_95()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_239()) {
      jj_scanpos = xsp;
      if (jj_3R_240()) {
        jj_scanpos = xsp;
        if (jj_3R_241()) return true;
      }
    }
    return false;
  }

  private boolean jj_3R_239() {
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_297()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_124() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_3()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_297() {
    if (jj_3R_347()) return true;
    return false;
  }

  private boolean jj_3R_240() {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_133()) return true;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3_3() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_64()) {
      jj_scanpos = xsp;
      if (jj_3R_65()) {
        jj_scanpos = xsp;
        if (jj_3R_66()) {
          jj_scanpos = xsp;
          if (jj_3R_67()) {
            jj_scanpos = xsp;
            if (jj_3R_68()) {
              jj_scanpos = xsp;
              if (jj_3R_69()) {
                jj_scanpos = xsp;
                if (jj_3R_70()) {
                  jj_scanpos = xsp;
                  if (jj_3R_71()) {
                    jj_scanpos = xsp;
                    if (jj_3R_72()) {
                      jj_scanpos = xsp;
                      if (jj_3R_73()) {
                        jj_scanpos = xsp;
                        if (jj_3R_74()) {
                          jj_scanpos = xsp;
                          if (jj_3R_75()) {
                            jj_scanpos = xsp;
                            if (jj_3R_76()) {
                              jj_scanpos = xsp;
                              if (jj_3R_77()) {
                                jj_scanpos = xsp;
                                if (jj_3R_78()) {
                                  jj_scanpos = xsp;
                                  if (jj_3R_79()) return true;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  private boolean jj_3_66() {
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_132()) {
      jj_scanpos = xsp;
      if (jj_scan_token(102)) return true;
    }
    return false;
  }

  private boolean jj_3R_402() {
    if (jj_3R_412()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_422()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_241() {
    return false;
  }

  private boolean jj_3R_64() {
    if (jj_scan_token(PUBLIC)) return true;
    return false;
  }

  private boolean jj_3R_65() {
    if (jj_scan_token(STATIC)) return true;
    return false;
  }

  private boolean jj_3R_132() {
    if (jj_3R_82()) return true;
    if (jj_scan_token(ASSIGN)) return true;
    return false;
  }

  private boolean jj_3_67() {
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3R_422() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_426()) {
      jj_scanpos = xsp;
      if (jj_3R_427()) return true;
    }
    if (jj_3R_412()) return true;
    return false;
  }

  private boolean jj_3R_66() {
    if (jj_scan_token(PROTECTED)) return true;
    return false;
  }

  private boolean jj_3R_67() {
    if (jj_scan_token(PRIVATE)) return true;
    return false;
  }

  private boolean jj_3R_68() {
    if (jj_scan_token(FINAL)) return true;
    return false;
  }

  private boolean jj_3R_426() {
    if (jj_scan_token(EQ)) return true;
    return false;
  }

  private boolean jj_3R_314() {
    if (jj_3R_115()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_352()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_69() {
    if (jj_scan_token(ABSTRACT)) return true;
    return false;
  }

  private boolean jj_3R_427() {
    if (jj_scan_token(NE)) return true;
    return false;
  }

  private boolean jj_3R_70() {
    if (jj_scan_token(SYNCHRONIZED)) return true;
    return false;
  }

  private boolean jj_3R_352() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_115()) return true;
    return false;
  }

  private boolean jj_3R_71() {
    if (jj_scan_token(NATIVE)) return true;
    return false;
  }

  private boolean jj_3R_105() {
    if (jj_3R_172()) return true;
    return false;
  }

  private boolean jj_3R_72() {
    if (jj_scan_token(TRANSIENT)) return true;
    return false;
  }

  private boolean jj_3R_347() {
    if (jj_3R_379()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_380()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_73() {
    if (jj_scan_token(VOLATILE)) return true;
    return false;
  }

  private boolean jj_3R_74() {
    if (jj_scan_token(STRICTFP)) return true;
    return false;
  }

  private boolean jj_3R_75() {
    if (jj_scan_token(TRANSITIVE)) return true;
    return false;
  }

  private boolean jj_3R_380() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_379()) return true;
    return false;
  }

  private boolean jj_3R_76() {
    if (jj_scan_token(_DEFAULT)) return true;
    return false;
  }

  private boolean jj_3R_77() {
    if (jj_scan_token(SEALED)) return true;
    return false;
  }

  private boolean jj_3R_78() {
    if (jj_scan_token(NON_SEALED)) return true;
    return false;
  }

  private boolean jj_3R_98() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_151()) {
      jj_scanpos = xsp;
      if (jj_3R_152()) {
        jj_scanpos = xsp;
        if (jj_3R_153()) {
          jj_scanpos = xsp;
          if (jj_3R_154()) {
            jj_scanpos = xsp;
            if (jj_3R_155()) return true;
          }
        }
      }
    }
    return false;
  }

  private boolean jj_3R_79() {
    if (jj_3R_135()) return true;
    return false;
  }

  private boolean jj_3R_172() {
    if (jj_3R_124()) return true;
    if (jj_3R_202()) return true;
    if (jj_3R_88()) return true;
    return false;
  }

  private boolean jj_3R_151() {
    if (jj_3R_124()) return true;
    if (jj_3R_221()) return true;
    return false;
  }

  private boolean jj_3R_152() {
    if (jj_3R_124()) return true;
    if (jj_3R_222()) return true;
    return false;
  }

  private boolean jj_3R_379() {
    if (jj_3R_88()) return true;
    if (jj_scan_token(ASSIGN)) return true;
    if (jj_3R_133()) return true;
    return false;
  }

  private boolean jj_3_53() {
    if (jj_3R_124()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(19)) {
      jj_scanpos = xsp;
      if (jj_scan_token(39)) return true;
    }
    return false;
  }

  private boolean jj_3R_153() {
    if (jj_3R_123()) return true;
    return false;
  }

  private boolean jj_3R_315() {
    if (jj_3R_116()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_353()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_154() {
    if (jj_3R_126()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3_54() {
    if (jj_3R_124()) return true;
    if (jj_scan_token(RECORD)) return true;
    if (jj_3R_88()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_125()) jj_scanpos = xsp;
    if (jj_3R_90()) return true;
    return false;
  }

  private boolean jj_3R_155() {
    if (jj_3R_223()) return true;
    return false;
  }

  private boolean jj_3R_353() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_116()) return true;
    return false;
  }

  private boolean jj_3_55() {
    if (jj_3R_123()) return true;
    return false;
  }

  private boolean jj_3R_412() {
    if (jj_3R_420()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_425()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3_56() {
    if (jj_3R_126()) return true;
    return false;
  }

  private boolean jj_3R_126() {
    if (jj_3R_124()) return true;
    if (jj_3R_84()) return true;
    if (jj_3R_131()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_192()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_425() {
    if (jj_scan_token(INSTANCEOF)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_430()) {
      jj_scanpos = xsp;
      if (jj_3R_431()) return true;
    }
    return false;
  }

  private boolean jj_3R_133() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_197()) {
      jj_scanpos = xsp;
      if (jj_3R_198()) {
        jj_scanpos = xsp;
        if (jj_3R_199()) return true;
      }
    }
    return false;
  }

  private boolean jj_3R_430() {
    if (jj_3R_105()) return true;
    return false;
  }

  private boolean jj_3R_192() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_131()) return true;
    return false;
  }

  private boolean jj_3R_221() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_258()) {
      jj_scanpos = xsp;
      if (jj_3R_259()) return true;
    }
    if (jj_3R_88()) return true;
    xsp = jj_scanpos;
    if (jj_3R_292()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3R_293()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3R_294()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3R_295()) jj_scanpos = xsp;
    if (jj_3R_120()) return true;
    return false;
  }

  private boolean jj_3R_431() {
    if (jj_3R_278()) return true;
    return false;
  }

  private boolean jj_3R_197() {
    if (jj_3R_135()) return true;
    return false;
  }

  private boolean jj_3R_258() {
    if (jj_scan_token(CLASS)) return true;
    return false;
  }

  private boolean jj_3R_115() {
    if (jj_3R_124()) return true;
    if (jj_3R_84()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_187()) jj_scanpos = xsp;
    if (jj_3R_116()) return true;
    return false;
  }

  private boolean jj_3R_198() {
    if (jj_3R_238()) return true;
    return false;
  }

  private boolean jj_3R_259() {
    if (jj_scan_token(INTERFACE)) return true;
    return false;
  }

  private boolean jj_3_34() {
    if (jj_3R_105()) return true;
    return false;
  }

  private boolean jj_3R_199() {
    if (jj_3R_171()) return true;
    return false;
  }

  private boolean jj_3R_292() {
    if (jj_3R_137()) return true;
    return false;
  }

  private boolean jj_3R_293() {
    if (jj_3R_344()) return true;
    return false;
  }

  private boolean jj_3R_294() {
    if (jj_3R_345()) return true;
    return false;
  }

  private boolean jj_3R_295() {
    if (jj_3R_346()) return true;
    return false;
  }

  private boolean jj_3R_187() {
    if (jj_3R_101()) return true;
    if (jj_scan_token(ELLIPSIS)) return true;
    return false;
  }

  private boolean jj_3_68() {
    if (jj_scan_token(AT)) return true;
    return false;
  }

  private boolean jj_3R_125() {
    if (jj_3R_137()) return true;
    return false;
  }

  private boolean jj_3R_320() {
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_238() {
    if (jj_scan_token(LBRACE)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_396()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(108)) jj_scanpos = xsp;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_396() {
    if (jj_3R_133()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_69()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_341() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_373()) {
      jj_scanpos = xsp;
      if (jj_3R_374()) return true;
    }
    return false;
  }

  private boolean jj_3R_420() {
    if (jj_3R_424()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_429()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_94() {
    if (jj_3R_101()) return true;
    if (jj_3R_84()) return true;
    if (jj_3R_148()) return true;
    return false;
  }

  private boolean jj_3_69() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_133()) return true;
    return false;
  }

  private boolean jj_3R_373() {
    if (jj_3R_104()) return true;
    return false;
  }

  private boolean jj_3R_429() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_433()) {
      jj_scanpos = xsp;
      if (jj_3R_434()) {
        jj_scanpos = xsp;
        if (jj_3R_435()) {
          jj_scanpos = xsp;
          if (jj_3R_436()) return true;
        }
      }
    }
    if (jj_3R_424()) return true;
    return false;
  }

  private boolean jj_3R_374() {
    if (jj_3R_142()) return true;
    return false;
  }

  private boolean jj_3R_433() {
    if (jj_scan_token(LT)) return true;
    return false;
  }

  private boolean jj_3R_434() {
    if (jj_scan_token(GT)) return true;
    return false;
  }

  private boolean jj_3R_435() {
    if (jj_scan_token(LE)) return true;
    return false;
  }

  private boolean jj_3R_436() {
    if (jj_scan_token(GE)) return true;
    return false;
  }

  private boolean jj_3R_321() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_57()) {
      jj_scanpos = xsp;
      if (jj_3R_357()) {
        jj_scanpos = xsp;
        if (jj_3R_358()) return true;
      }
    }
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_148() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_212()) jj_scanpos = xsp;
    if (jj_scan_token(THIS)) return true;
    return false;
  }

  private boolean jj_3_57() {
    if (jj_3R_127()) return true;
    return false;
  }

  private boolean jj_3R_212() {
    if (jj_3R_95()) return true;
    if (jj_scan_token(DOT)) return true;
    return false;
  }

  private boolean jj_3R_390() {
    if (jj_scan_token(AT)) return true;
    if (jj_scan_token(INTERFACE)) return true;
    if (jj_3R_88()) return true;
    if (jj_3R_444()) return true;
    return false;
  }

  private boolean jj_3R_222() {
    if (jj_scan_token(RECORD)) return true;
    if (jj_3R_88()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_296()) jj_scanpos = xsp;
    if (jj_3R_90()) return true;
    xsp = jj_scanpos;
    if (jj_3R_437()) jj_scanpos = xsp;
    if (jj_3R_438()) return true;
    return false;
  }

  private boolean jj_3R_357() {
    if (jj_3R_289()) return true;
    return false;
  }

  private boolean jj_3R_358() {
    if (jj_3R_237()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_385()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_296() {
    if (jj_3R_137()) return true;
    return false;
  }

  private boolean jj_3R_424() {
    if (jj_3R_428()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_35()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_437() {
    if (jj_3R_345()) return true;
    return false;
  }

  private boolean jj_3_21() {
    if (jj_3R_95()) return true;
    return false;
  }

  private boolean jj_3R_385() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_399()) {
      jj_scanpos = xsp;
      if (jj_3R_400()) {
        jj_scanpos = xsp;
        if (jj_3R_401()) return true;
      }
    }
    return false;
  }

  private boolean jj_3R_399() {
    if (jj_scan_token(INCR)) return true;
    return false;
  }

  private boolean jj_3R_400() {
    if (jj_scan_token(DECR)) return true;
    return false;
  }

  private boolean jj_3_35() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_106()) {
      jj_scanpos = xsp;
      if (jj_3_36()) {
        jj_scanpos = xsp;
        if (jj_3_37()) return true;
      }
    }
    if (jj_3R_428()) return true;
    return false;
  }

  private boolean jj_3R_401() {
    if (jj_3R_103()) return true;
    if (jj_3R_104()) return true;
    return false;
  }

  private boolean jj_3R_106() {
    if (jj_scan_token(LSHIFT)) return true;
    return false;
  }

  private boolean jj_3_36() {
    if (jj_3R_107()) return true;
    return false;
  }

  private boolean jj_3_37() {
    if (jj_3R_108()) return true;
    return false;
  }

  private boolean jj_3R_444() {
    if (jj_scan_token(LBRACE)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_463()) {
        jj_scanpos = xsp;
        break;
      }
    }
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_463() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_477()) {
      jj_scanpos = xsp;
      if (jj_scan_token(107)) return true;
    }
    return false;
  }

  private boolean jj_3R_477() {
    if (jj_3R_481()) return true;
    return false;
  }

  private boolean jj_3R_428() {
    if (jj_3R_432()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_439()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_344() {
    if (jj_scan_token(EXTENDS)) return true;
    if (jj_3R_348()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_454()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_391() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_407()) jj_scanpos = xsp;
    if (jj_3R_88()) return true;
    if (jj_3R_90()) return true;
    xsp = jj_scanpos;
    if (jj_3R_445()) jj_scanpos = xsp;
    if (jj_scan_token(LBRACE)) return true;
    xsp = jj_scanpos;
    if (jj_3R_446()) jj_scanpos = xsp;
    if (jj_3R_203()) return true;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_407() {
    if (jj_3R_137()) return true;
    return false;
  }

  private boolean jj_3R_454() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_348()) return true;
    return false;
  }

  private boolean jj_3R_439() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_452()) {
      jj_scanpos = xsp;
      if (jj_3R_453()) return true;
    }
    if (jj_3R_432()) return true;
    return false;
  }

  private boolean jj_3R_445() {
    if (jj_scan_token(THROWS)) return true;
    if (jj_3R_278()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_464()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_322() {
    if (jj_scan_token(SWITCH)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_104()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_scan_token(LBRACE)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_458()) {
        jj_scanpos = xsp;
        break;
      }
    }
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_452() {
    if (jj_scan_token(PLUS)) return true;
    return false;
  }

  private boolean jj_3R_453() {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  private boolean jj_3R_464() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_278()) return true;
    return false;
  }

  private boolean jj_3R_446() {
    if (jj_3R_87()) return true;
    return false;
  }

  private boolean jj_3R_458() {
    if (jj_3R_388()) return true;
    return false;
  }

  private boolean jj_3_22() {
    if (jj_3R_87()) return true;
    return false;
  }

  private boolean jj_3R_481() {
    if (jj_3R_124()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_490()) {
      jj_scanpos = xsp;
      if (jj_3R_491()) {
        jj_scanpos = xsp;
        if (jj_3R_492()) {
          jj_scanpos = xsp;
          if (jj_3R_493()) {
            jj_scanpos = xsp;
            if (jj_3R_494()) return true;
          }
        }
      }
    }
    return false;
  }

  private boolean jj_3R_432() {
    if (jj_3R_193()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_451()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_345() {
    if (jj_scan_token(IMPLEMENTS)) return true;
    if (jj_3R_348()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_455()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_490() {
    if (jj_3R_497()) return true;
    return false;
  }

  private boolean jj_3R_451() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_466()) {
      jj_scanpos = xsp;
      if (jj_3R_467()) {
        jj_scanpos = xsp;
        if (jj_3R_468()) return true;
      }
    }
    if (jj_3R_193()) return true;
    return false;
  }

  private boolean jj_3R_455() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_348()) return true;
    return false;
  }

  private boolean jj_3R_491() {
    if (jj_3R_221()) return true;
    return false;
  }

  private boolean jj_3R_492() {
    if (jj_3R_389()) return true;
    return false;
  }

  private boolean jj_3R_466() {
    if (jj_scan_token(STAR)) return true;
    return false;
  }

  private boolean jj_3R_467() {
    if (jj_scan_token(SLASH)) return true;
    return false;
  }

  private boolean jj_3R_493() {
    if (jj_3R_390()) return true;
    return false;
  }

  private boolean jj_3_70() {
    if (jj_3R_84()) return true;
    if (jj_3R_82()) return true;
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3R_468() {
    if (jj_scan_token(REM)) return true;
    return false;
  }

  private boolean jj_3R_494() {
    if (jj_3R_392()) return true;
    return false;
  }

  private boolean jj_3_71() {
    if (jj_scan_token(ENUM)) return true;
    return false;
  }

  private boolean jj_3R_87() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_143()) {
      jj_scanpos = xsp;
      if (jj_3R_144()) return true;
    }
    return false;
  }

  private boolean jj_3R_143() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_204()) jj_scanpos = xsp;
    if (jj_scan_token(THIS)) return true;
    if (jj_3R_205()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_338() {
    if (jj_scan_token(SWITCH)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_104()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_scan_token(LBRACE)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_364()) {
        jj_scanpos = xsp;
        break;
      }
    }
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_204() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_144() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_206()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3R_207()) jj_scanpos = xsp;
    if (jj_scan_token(SUPER)) return true;
    if (jj_3R_205()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_346() {
    if (jj_scan_token(PERMITS)) return true;
    if (jj_3R_348()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_456()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3_24() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_97()) jj_scanpos = xsp;
    if (jj_scan_token(THIS)) return true;
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3R_364() {
    if (jj_3R_388()) return true;
    return false;
  }

  private boolean jj_3R_456() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_348()) return true;
    return false;
  }

  private boolean jj_3R_206() {
    if (jj_3R_96()) return true;
    if (jj_scan_token(DOT)) return true;
    return false;
  }

  private boolean jj_3R_97() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_193() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_233()) {
      jj_scanpos = xsp;
      if (jj_3R_234()) {
        jj_scanpos = xsp;
        if (jj_3R_235()) {
          jj_scanpos = xsp;
          if (jj_3R_236()) return true;
        }
      }
    }
    return false;
  }

  private boolean jj_3R_207() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_497() {
    if (jj_3R_84()) return true;
    if (jj_3R_88()) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_scan_token(RPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_501()) jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_233() {
    if (jj_3R_127()) return true;
    return false;
  }

  private boolean jj_3R_501() {
    if (jj_3R_503()) return true;
    return false;
  }

  private boolean jj_3_23() {
    if (jj_3R_96()) return true;
    if (jj_scan_token(DOT)) return true;
    return false;
  }

  private boolean jj_3R_234() {
    if (jj_3R_289()) return true;
    return false;
  }

  private boolean jj_3R_235() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_290()) {
      jj_scanpos = xsp;
      if (jj_3R_291()) return true;
    }
    if (jj_3R_193()) return true;
    return false;
  }

  private boolean jj_3R_290() {
    if (jj_scan_token(PLUS)) return true;
    return false;
  }

  private boolean jj_3R_291() {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  private boolean jj_3R_236() {
    if (jj_3R_227()) return true;
    return false;
  }

  private boolean jj_3R_127() {
    if (jj_scan_token(INCR)) return true;
    if (jj_3R_193()) return true;
    return false;
  }

  private boolean jj_3R_389() {
    if (jj_scan_token(ENUM)) return true;
    if (jj_3R_88()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_441()) jj_scanpos = xsp;
    if (jj_scan_token(LBRACE)) return true;
    xsp = jj_scanpos;
    if (jj_3R_442()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(108)) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3R_443()) jj_scanpos = xsp;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_441() {
    if (jj_3R_345()) return true;
    return false;
  }

  private boolean jj_3R_388() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_403()) {
      jj_scanpos = xsp;
      if (jj_3R_404()) return true;
    }
    xsp = jj_scanpos;
    if (jj_3R_405()) {
      jj_scanpos = xsp;
      if (jj_3R_406()) return true;
    }
    return false;
  }

  private boolean jj_3R_503() {
    if (jj_scan_token(_DEFAULT)) return true;
    if (jj_3R_133()) return true;
    return false;
  }

  private boolean jj_3R_203() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_25()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_442() {
    if (jj_3R_80()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_4()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3_25() {
    if (jj_3R_98()) return true;
    return false;
  }

  private boolean jj_3R_403() {
    if (jj_scan_token(CASE)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_58()) {
      jj_scanpos = xsp;
      if (jj_3_59()) {
        jj_scanpos = xsp;
        if (jj_3R_413()) return true;
      }
    }
    return false;
  }

  private boolean jj_3_4() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_80()) return true;
    return false;
  }

  private boolean jj_3R_443() {
    if (jj_scan_token(SEMICOLON)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_462()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_289() {
    if (jj_scan_token(DECR)) return true;
    if (jj_3R_193()) return true;
    return false;
  }

  private boolean jj_3R_462() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_476()) {
      jj_scanpos = xsp;
      if (jj_scan_token(107)) return true;
    }
    return false;
  }

  private boolean jj_3R_476() {
    if (jj_3R_285()) return true;
    return false;
  }

  private boolean jj_3_58() {
    if (jj_3R_128()) return true;
    if (jj_scan_token(COMMA)) return true;
    if (jj_scan_token(_DEFAULT)) return true;
    return false;
  }

  private boolean jj_3R_86() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_141()) jj_scanpos = xsp;
    if (jj_3R_142()) return true;
    return false;
  }

  private boolean jj_3R_141() {
    if (jj_scan_token(STATIC)) return true;
    return false;
  }

  private boolean jj_3_59() {
    if (jj_3R_105()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_129()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_227() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_279()) {
      jj_scanpos = xsp;
      if (jj_3R_280()) {
        jj_scanpos = xsp;
        if (jj_3R_281()) {
          jj_scanpos = xsp;
          if (jj_3R_282()) return true;
        }
      }
    }
    return false;
  }

  private boolean jj_3R_129() {
    if (jj_scan_token(WHEN)) return true;
    if (jj_3R_171()) return true;
    return false;
  }

  private boolean jj_3R_413() {
    if (jj_3R_171()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_421()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_279() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_335()) {
      jj_scanpos = xsp;
      if (jj_3R_336()) return true;
    }
    if (jj_3R_193()) return true;
    return false;
  }

  private boolean jj_3R_404() {
    if (jj_scan_token(_DEFAULT)) return true;
    return false;
  }

  private boolean jj_3R_80() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_136()) {
        jj_scanpos = xsp;
        break;
      }
    }
    if (jj_3R_88()) return true;
    xsp = jj_scanpos;
    if (jj_3R_474()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3R_475()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_136() {
    if (jj_3R_135()) return true;
    return false;
  }

  private boolean jj_3R_405() {
    if (jj_scan_token(COLON)) return true;
    if (jj_3R_203()) return true;
    return false;
  }

  private boolean jj_3R_421() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_171()) return true;
    return false;
  }

  private boolean jj_3R_335() {
    if (jj_scan_token(TILDE)) return true;
    return false;
  }

  private boolean jj_3R_474() {
    if (jj_3R_205()) return true;
    return false;
  }

  private boolean jj_3R_280() {
    if (jj_3R_109()) return true;
    return false;
  }

  private boolean jj_3R_336() {
    if (jj_scan_token(BANG)) return true;
    return false;
  }

  private boolean jj_3R_475() {
    if (jj_3R_120()) return true;
    return false;
  }

  private boolean jj_3R_406() {
    if (jj_scan_token(ARROW)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_414()) {
      jj_scanpos = xsp;
      if (jj_3R_415()) {
        jj_scanpos = xsp;
        if (jj_3R_416()) return true;
      }
    }
    return false;
  }

  private boolean jj_3R_84() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_138()) {
      jj_scanpos = xsp;
      if (jj_3R_139()) return true;
    }
    return false;
  }

  private boolean jj_3R_281() {
    if (jj_3R_337()) return true;
    return false;
  }

  private boolean jj_3_72() {
    if (jj_scan_token(REQUIRES)) return true;
    if (jj_scan_token(TRANSITIVE)) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_282() {
    if (jj_3R_338()) return true;
    return false;
  }

  private boolean jj_3R_138() {
    if (jj_3R_202()) return true;
    return false;
  }

  private boolean jj_3R_414() {
    if (jj_3R_321()) return true;
    return false;
  }

  private boolean jj_3R_139() {
    if (jj_3R_112()) return true;
    return false;
  }

  private boolean jj_3_38() {
    if (jj_3R_109()) return true;
    return false;
  }

  private boolean jj_3R_415() {
    if (jj_3R_142()) return true;
    return false;
  }

  private boolean jj_3_26() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_99()) {
      jj_scanpos = xsp;
      if (jj_3R_100()) return true;
    }
    return false;
  }

  private boolean jj_3R_99() {
    if (jj_3R_112()) return true;
    if (jj_3R_101()) return true;
    if (jj_scan_token(LBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_416() {
    if (jj_3R_330()) return true;
    return false;
  }

  private boolean jj_3R_337() {
    if (jj_3R_237()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_39()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3_39() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_110()) {
      jj_scanpos = xsp;
      if (jj_3R_111()) return true;
    }
    return false;
  }

  private boolean jj_3R_110() {
    if (jj_scan_token(INCR)) return true;
    return false;
  }

  private boolean jj_3R_111() {
    if (jj_scan_token(DECR)) return true;
    return false;
  }

  private boolean jj_3R_137() {
    if (jj_scan_token(LT)) return true;
    if (jj_3R_101()) return true;
    if (jj_3R_200()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_201()) {
        jj_scanpos = xsp;
        break;
      }
    }
    if (jj_scan_token(GT)) return true;
    return false;
  }

  private boolean jj_3R_201() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_101()) return true;
    if (jj_3R_200()) return true;
    return false;
  }

  private boolean jj_3R_202() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_243()) {
      jj_scanpos = xsp;
      if (jj_3R_244()) return true;
    }
    return false;
  }

  private boolean jj_3R_323() {
    if (jj_scan_token(IF)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_104()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_223()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_459()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_243() {
    if (jj_3R_112()) return true;
    Token xsp;
    if (jj_3R_299()) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_299()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_244() {
    if (jj_3R_156()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_300()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_299() {
    if (jj_3R_140()) return true;
    return false;
  }

  private boolean jj_3R_459() {
    if (jj_scan_token(ELSE)) return true;
    if (jj_3R_223()) return true;
    return false;
  }

  private boolean jj_3R_109() {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_101()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_40()) {
      jj_scanpos = xsp;
      if (jj_3R_175()) return true;
    }
    return false;
  }

  private boolean jj_3R_100() {
    if (jj_3R_156()) return true;
    return false;
  }

  private boolean jj_3R_300() {
    if (jj_3R_140()) return true;
    return false;
  }

  private boolean jj_3_40() {
    if (jj_3R_112()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_193()) return true;
    return false;
  }

  private boolean jj_3_27() {
    if (jj_3R_101()) return true;
    if (jj_scan_token(LBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_200() {
    if (jj_3R_88()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_242()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3_28() {
    if (jj_3R_101()) return true;
    if (jj_scan_token(LBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_175() {
    if (jj_3R_202()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_226()) {
        jj_scanpos = xsp;
        break;
      }
    }
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_227()) return true;
    return false;
  }

  private boolean jj_3R_242() {
    if (jj_3R_298()) return true;
    return false;
  }

  private boolean jj_3R_140() {
    if (jj_3R_101()) return true;
    if (jj_scan_token(LBRACKET)) return true;
    if (jj_scan_token(RBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_324() {
    if (jj_scan_token(WHILE)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_104()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_223()) return true;
    return false;
  }

  private boolean jj_3R_226() {
    if (jj_scan_token(BIT_AND)) return true;
    if (jj_3R_278()) return true;
    return false;
  }

  private boolean jj_3_73() {
    if (jj_3R_98()) return true;
    return false;
  }

  private boolean jj_3R_325() {
    if (jj_scan_token(DO)) return true;
    if (jj_3R_223()) return true;
    if (jj_scan_token(WHILE)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_104()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_298() {
    if (jj_scan_token(EXTENDS)) return true;
    if (jj_3R_348()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_349()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_348() {
    if (jj_3R_101()) return true;
    if (jj_3R_156()) return true;
    return false;
  }

  private boolean jj_3R_237() {
    if (jj_3R_149()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_41()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_349() {
    if (jj_scan_token(BIT_AND)) return true;
    if (jj_3R_348()) return true;
    return false;
  }

  private boolean jj_3_41() {
    if (jj_3R_113()) return true;
    return false;
  }

  private boolean jj_3R_156() {
    if (jj_3R_88()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_29()) jj_scanpos = xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_30()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3_29() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_96() {
    if (jj_3R_149()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_150()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_326() {
    if (jj_scan_token(FOR)) return true;
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_377()) {
      jj_scanpos = xsp;
      if (jj_3R_378()) return true;
    }
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_223()) return true;
    return false;
  }

  private boolean jj_3R_150() {
    if (jj_3R_114()) return true;
    return false;
  }

  private boolean jj_3_30() {
    if (jj_scan_token(DOT)) return true;
    if (jj_3R_101()) return true;
    if (jj_3R_88()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_31()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3_31() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_377() {
    if (jj_3R_126()) return true;
    if (jj_scan_token(COLON)) return true;
    if (jj_3R_104()) return true;
    return false;
  }

  private boolean jj_3_42() {
    if (jj_3R_114()) return true;
    return false;
  }

  private boolean jj_3R_378() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_395()) jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON)) return true;
    xsp = jj_scanpos;
    if (jj_3R_470()) jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON)) return true;
    xsp = jj_scanpos;
    if (jj_3R_471()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_395() {
    if (jj_3R_410()) return true;
    return false;
  }

  private boolean jj_3_60() {
    if (jj_3R_126()) return true;
    if (jj_scan_token(COLON)) return true;
    return false;
  }

  private boolean jj_3R_470() {
    if (jj_3R_104()) return true;
    return false;
  }

  private boolean jj_3R_120() {
    if (jj_scan_token(LBRACE)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_191()) {
        jj_scanpos = xsp;
        break;
      }
    }
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_471() {
    if (jj_3R_479()) return true;
    return false;
  }

  private boolean jj_3R_149() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_213()) {
      jj_scanpos = xsp;
      if (jj_3R_214()) {
        jj_scanpos = xsp;
        if (jj_3R_215()) {
          jj_scanpos = xsp;
          if (jj_3R_216()) {
            jj_scanpos = xsp;
            if (jj_3R_217()) {
              jj_scanpos = xsp;
              if (jj_3R_218()) {
                jj_scanpos = xsp;
                if (jj_3R_219()) {
                  jj_scanpos = xsp;
                  if (jj_3R_220()) return true;
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  private boolean jj_3R_191() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_231()) {
      jj_scanpos = xsp;
      if (jj_scan_token(107)) return true;
    }
    return false;
  }

  private boolean jj_3R_231() {
    if (jj_3R_285()) return true;
    return false;
  }

  private boolean jj_3R_102() {
    if (jj_scan_token(LT)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_158()) jj_scanpos = xsp;
    if (jj_scan_token(GT)) return true;
    return false;
  }

  private boolean jj_3R_213() {
    if (jj_3R_246()) return true;
    return false;
  }

  private boolean jj_3R_214() {
    if (jj_scan_token(THIS)) return true;
    return false;
  }

  private boolean jj_3R_215() {
    if (jj_scan_token(SUPER)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_247()) {
      jj_scanpos = xsp;
      if (jj_3R_248()) return true;
    }
    return false;
  }

  private boolean jj_3R_158() {
    if (jj_3R_224()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_257()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_257() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_224()) return true;
    return false;
  }

  private boolean jj_3R_247() {
    if (jj_scan_token(DOT)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_310()) jj_scanpos = xsp;
    if (jj_3R_88()) return true;
    xsp = jj_scanpos;
    if (jj_3R_311()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_310() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_311() {
    if (jj_3R_205()) return true;
    return false;
  }

  private boolean jj_3R_438() {
    if (jj_scan_token(LBRACE)) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_440()) {
        jj_scanpos = xsp;
        break;
      }
    }
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_248() {
    if (jj_scan_token(DOUBLECOLON)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_312()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3R_313()) {
      jj_scanpos = xsp;
      if (jj_scan_token(42)) return true;
    }
    return false;
  }

  private boolean jj_3R_410() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_418()) {
      jj_scanpos = xsp;
      if (jj_3R_419()) return true;
    }
    return false;
  }

  private boolean jj_3R_312() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_313() {
    if (jj_3R_82()) return true;
    return false;
  }

  private boolean jj_3R_440() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_457()) {
      jj_scanpos = xsp;
      if (jj_scan_token(107)) return true;
    }
    return false;
  }

  private boolean jj_3R_457() {
    if (jj_3R_469()) return true;
    return false;
  }

  private boolean jj_3R_216() {
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_249()) {
      jj_scanpos = xsp;
      if (jj_3R_250()) {
        jj_scanpos = xsp;
        if (jj_3R_251()) {
          jj_scanpos = xsp;
          if (jj_3R_252()) return true;
        }
      }
    }
    return false;
  }

  private boolean jj_3R_224() {
    if (jj_3R_101()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_275()) {
      jj_scanpos = xsp;
      if (jj_3R_276()) return true;
    }
    return false;
  }

  private boolean jj_3R_418() {
    if (jj_3R_126()) return true;
    return false;
  }

  private boolean jj_3R_249() {
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_419() {
    if (jj_3R_423()) return true;
    return false;
  }

  private boolean jj_3R_275() {
    if (jj_3R_84()) return true;
    return false;
  }

  private boolean jj_3R_250() {
    if (jj_3R_314()) return true;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_276() {
    if (jj_3R_333()) return true;
    return false;
  }

  private boolean jj_3_61() {
    if (jj_3R_124()) return true;
    if (jj_3R_84()) return true;
    if (jj_3R_82()) return true;
    return false;
  }

  private boolean jj_3R_251() {
    if (jj_3R_315()) return true;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3_43() {
    if (jj_3R_115()) return true;
    return false;
  }

  private boolean jj_3R_252() {
    if (jj_3R_104()) return true;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3R_217() {
    if (jj_3R_253()) return true;
    return false;
  }

  private boolean jj_3R_218() {
    if (jj_3R_117()) return true;
    if (jj_scan_token(DOT)) return true;
    if (jj_scan_token(CLASS)) return true;
    return false;
  }

  private boolean jj_3_44() {
    if (jj_3R_116()) return true;
    if (jj_scan_token(COMMA)) return true;
    return false;
  }

  private boolean jj_3R_333() {
    if (jj_scan_token(HOOK)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_384()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_219() {
    if (jj_3R_118()) return true;
    if (jj_scan_token(DOUBLECOLON)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_254()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3R_255()) {
      jj_scanpos = xsp;
      if (jj_scan_token(42)) return true;
    }
    return false;
  }

  private boolean jj_3R_423() {
    if (jj_3R_104()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_496()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_254() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3_45() {
    if (jj_3R_117()) return true;
    if (jj_scan_token(DOT)) return true;
    if (jj_scan_token(CLASS)) return true;
    return false;
  }

  private boolean jj_3R_255() {
    if (jj_3R_82()) return true;
    return false;
  }

  private boolean jj_3R_384() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_397()) {
      jj_scanpos = xsp;
      if (jj_3R_398()) return true;
    }
    return false;
  }

  private boolean jj_3R_397() {
    if (jj_scan_token(EXTENDS)) return true;
    if (jj_3R_101()) return true;
    if (jj_3R_202()) return true;
    return false;
  }

  private boolean jj_3R_496() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_104()) return true;
    return false;
  }

  private boolean jj_3R_398() {
    if (jj_scan_token(SUPER)) return true;
    if (jj_3R_101()) return true;
    if (jj_3R_202()) return true;
    return false;
  }

  private boolean jj_3R_220() {
    if (jj_3R_88()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_256()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3_46() {
    if (jj_3R_118()) return true;
    if (jj_scan_token(DOUBLECOLON)) return true;
    return false;
  }

  private boolean jj_3R_469() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_11()) {
      jj_scanpos = xsp;
      if (jj_3R_478()) return true;
    }
    return false;
  }

  private boolean jj_3R_256() {
    if (jj_3R_205()) return true;
    return false;
  }

  private boolean jj_3_11() {
    if (jj_3R_86()) return true;
    return false;
  }

  private boolean jj_3R_478() {
    if (jj_3R_124()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_482()) {
      jj_scanpos = xsp;
      if (jj_3R_483()) {
        jj_scanpos = xsp;
        if (jj_3R_484()) {
          jj_scanpos = xsp;
          if (jj_3R_485()) {
            jj_scanpos = xsp;
            if (jj_3R_486()) {
              jj_scanpos = xsp;
              if (jj_3R_487()) {
                jj_scanpos = xsp;
                if (jj_3R_488()) {
                  jj_scanpos = xsp;
                  if (jj_3R_489()) return true;
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  private boolean jj_3R_113() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_47()) {
      jj_scanpos = xsp;
      if (jj_3R_184()) return true;
    }
    return false;
  }

  private boolean jj_3R_482() {
    if (jj_3R_221()) return true;
    return false;
  }

  private boolean jj_3R_483() {
    if (jj_3R_389()) return true;
    return false;
  }

  private boolean jj_3R_479() {
    if (jj_3R_423()) return true;
    return false;
  }

  private boolean jj_3_47() {
    if (jj_3R_114()) return true;
    return false;
  }

  private boolean jj_3R_484() {
    if (jj_3R_222()) return true;
    return false;
  }

  private boolean jj_3R_112() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_176()) {
      jj_scanpos = xsp;
      if (jj_3R_177()) {
        jj_scanpos = xsp;
        if (jj_3R_178()) {
          jj_scanpos = xsp;
          if (jj_3R_179()) {
            jj_scanpos = xsp;
            if (jj_3R_180()) {
              jj_scanpos = xsp;
              if (jj_3R_181()) {
                jj_scanpos = xsp;
                if (jj_3R_182()) {
                  jj_scanpos = xsp;
                  if (jj_3R_183()) return true;
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  private boolean jj_3R_184() {
    if (jj_scan_token(DOT)) return true;
    if (jj_scan_token(SUPER)) return true;
    return false;
  }

  private boolean jj_3R_485() {
    if (jj_3R_390()) return true;
    return false;
  }

  private boolean jj_3_5() {
    if (jj_scan_token(ENUM)) return true;
    return false;
  }

  private boolean jj_3R_486() {
    if (jj_3R_495()) return true;
    return false;
  }

  private boolean jj_3R_176() {
    if (jj_scan_token(BOOLEAN)) return true;
    return false;
  }

  private boolean jj_3_6() {
    if (jj_scan_token(RECORD)) return true;
    return false;
  }

  private boolean jj_3R_177() {
    if (jj_scan_token(CHAR)) return true;
    return false;
  }

  private boolean jj_3R_487() {
    if (jj_3R_391()) return true;
    return false;
  }

  private boolean jj_3R_178() {
    if (jj_scan_token(BYTE)) return true;
    return false;
  }

  private boolean jj_3_7() {
    if (jj_scan_token(AT)) return true;
    if (jj_scan_token(INTERFACE)) return true;
    return false;
  }

  private boolean jj_3R_179() {
    if (jj_scan_token(SHORT)) return true;
    return false;
  }

  private boolean jj_3R_488() {
    if (jj_3R_392()) return true;
    return false;
  }

  private boolean jj_3R_180() {
    if (jj_scan_token(INT)) return true;
    return false;
  }

  private boolean jj_3R_327() {
    if (jj_scan_token(BREAK)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_359()) jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_489() {
    if (jj_3R_393()) return true;
    return false;
  }

  private boolean jj_3_8() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_81()) jj_scanpos = xsp;
    if (jj_3R_82()) return true;
    if (jj_scan_token(LBRACE)) return true;
    return false;
  }

  private boolean jj_3R_114() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_185()) {
      jj_scanpos = xsp;
      if (jj_3R_186()) return true;
    }
    return false;
  }

  private boolean jj_3R_181() {
    if (jj_scan_token(LONG)) return true;
    return false;
  }

  private boolean jj_3R_359() {
    if (jj_3R_88()) return true;
    return false;
  }

  private boolean jj_3R_81() {
    if (jj_3R_137()) return true;
    return false;
  }

  private boolean jj_3R_182() {
    if (jj_scan_token(FLOAT)) return true;
    return false;
  }

  private boolean jj_3_9() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_83()) jj_scanpos = xsp;
    if (jj_3R_82()) return true;
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3R_183() {
    if (jj_scan_token(DOUBLE)) return true;
    return false;
  }

  private boolean jj_3R_185() {
    if (jj_scan_token(DOT)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_228()) {
      jj_scanpos = xsp;
      if (jj_3R_229()) {
        jj_scanpos = xsp;
        if (jj_3R_230()) return true;
      }
    }
    return false;
  }

  private boolean jj_3R_83() {
    if (jj_3R_137()) return true;
    return false;
  }

  private boolean jj_3_10() {
    if (jj_3R_84()) return true;
    if (jj_3R_82()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_85()) {
        jj_scanpos = xsp;
        break;
      }
    }
    xsp = jj_scanpos;
    if (jj_scan_token(108)) {
      jj_scanpos = xsp;
      if (jj_scan_token(113)) {
        jj_scanpos = xsp;
        if (jj_scan_token(107)) return true;
      }
    }
    return false;
  }

  private boolean jj_3R_228() {
    if (jj_scan_token(THIS)) return true;
    return false;
  }

  private boolean jj_3R_229() {
    if (jj_3R_253()) return true;
    return false;
  }

  private boolean jj_3R_230() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_283()) jj_scanpos = xsp;
    if (jj_3R_88()) return true;
    xsp = jj_scanpos;
    if (jj_3R_284()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_123() {
    if (jj_scan_token(YIELD)) return true;
    if (jj_3R_104()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_117() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_189()) {
      jj_scanpos = xsp;
      if (jj_3R_190()) return true;
    }
    return false;
  }

  private boolean jj_3R_283() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_495() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_498()) jj_scanpos = xsp;
    if (jj_3R_88()) return true;
    xsp = jj_scanpos;
    if (jj_3R_499()) jj_scanpos = xsp;
    if (jj_scan_token(LBRACE)) return true;
    xsp = jj_scanpos;
    if (jj_3R_500()) jj_scanpos = xsp;
    if (jj_3R_203()) return true;
    if (jj_scan_token(RBRACE)) return true;
    return false;
  }

  private boolean jj_3R_284() {
    if (jj_3R_205()) return true;
    return false;
  }

  private boolean jj_3R_498() {
    if (jj_3R_137()) return true;
    return false;
  }

  private boolean jj_3R_189() {
    if (jj_scan_token(VOID)) return true;
    return false;
  }

  private boolean jj_3R_186() {
    if (jj_scan_token(LBRACKET)) return true;
    if (jj_3R_104()) return true;
    if (jj_scan_token(RBRACKET)) return true;
    return false;
  }

  private boolean jj_3R_190() {
    if (jj_3R_84()) return true;
    return false;
  }

  private boolean jj_3_48() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_119()) jj_scanpos = xsp;
    if (jj_3R_82()) return true;
    return false;
  }

  private boolean jj_3R_499() {
    if (jj_scan_token(THROWS)) return true;
    if (jj_3R_278()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_502()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_85() {
    if (jj_3R_140()) return true;
    return false;
  }

  private boolean jj_3R_119() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_502() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_278()) return true;
    return false;
  }

  private boolean jj_3R_500() {
    if (jj_3R_87()) return true;
    return false;
  }

  private boolean jj_3R_328() {
    if (jj_scan_token(CONTINUE)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_360()) jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_360() {
    if (jj_3R_88()) return true;
    return false;
  }

  private boolean jj_3R_95() {
    if (jj_3R_82()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_32()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3_12() {
    if (jj_3R_87()) return true;
    return false;
  }

  private boolean jj_3_32() {
    if (jj_scan_token(DOT)) return true;
    if (jj_3R_82()) return true;
    return false;
  }

  private boolean jj_3R_246() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_302()) {
      jj_scanpos = xsp;
      if (jj_3R_303()) {
        jj_scanpos = xsp;
        if (jj_3R_304()) {
          jj_scanpos = xsp;
          if (jj_3R_305()) {
            jj_scanpos = xsp;
            if (jj_3R_306()) {
              jj_scanpos = xsp;
              if (jj_3R_307()) {
                jj_scanpos = xsp;
                if (jj_3R_308()) {
                  jj_scanpos = xsp;
                  if (jj_3R_309()) return true;
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  private boolean jj_3R_302() {
    if (jj_scan_token(INTEGER_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_303() {
    if (jj_scan_token(LONG_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_329() {
    if (jj_scan_token(RETURN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_361()) jj_scanpos = xsp;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_304() {
    if (jj_scan_token(FLOATING_POINT_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_361() {
    if (jj_3R_104()) return true;
    return false;
  }

  private boolean jj_3R_305() {
    if (jj_scan_token(CHARACTER_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_88() {
    if (jj_3R_82()) return true;
    return false;
  }

  private boolean jj_3R_306() {
    if (jj_scan_token(STRING_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_307() {
    if (jj_scan_token(TEXT_BLOCK_LITERAL)) return true;
    return false;
  }

  private boolean jj_3R_308() {
    if (jj_3R_351()) return true;
    return false;
  }

  private boolean jj_3R_309() {
    if (jj_3R_128()) return true;
    return false;
  }

  private boolean jj_3R_330() {
    if (jj_scan_token(THROW)) return true;
    if (jj_3R_104()) return true;
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_351() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_381()) {
      jj_scanpos = xsp;
      if (jj_3R_382()) return true;
    }
    return false;
  }

  private boolean jj_3R_285() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_18()) {
      jj_scanpos = xsp;
      if (jj_3R_339()) return true;
    }
    return false;
  }

  private boolean jj_3R_381() {
    if (jj_scan_token(TRUE)) return true;
    return false;
  }

  private boolean jj_3_18() {
    if (jj_3R_86()) return true;
    return false;
  }

  private boolean jj_3R_382() {
    if (jj_scan_token(FALSE)) return true;
    return false;
  }

  private boolean jj_3R_339() {
    if (jj_3R_124()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_365()) {
      jj_scanpos = xsp;
      if (jj_3R_366()) {
        jj_scanpos = xsp;
        if (jj_3R_367()) {
          jj_scanpos = xsp;
          if (jj_3R_368()) {
            jj_scanpos = xsp;
            if (jj_3R_369()) {
              jj_scanpos = xsp;
              if (jj_3R_370()) {
                jj_scanpos = xsp;
                if (jj_3R_371()) return true;
              }
            }
          }
        }
      }
    }
    return false;
  }

  private boolean jj_3R_331() {
    if (jj_scan_token(SYNCHRONIZED)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_104()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_142()) return true;
    return false;
  }

  private boolean jj_3R_128() {
    if (jj_scan_token(NULL)) return true;
    return false;
  }

  private boolean jj_3R_365() {
    if (jj_3R_221()) return true;
    return false;
  }

  private boolean jj_3R_82() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(75)) {
      jj_scanpos = xsp;
      if (jj_scan_token(69)) {
        jj_scanpos = xsp;
        if (jj_scan_token(70)) {
          jj_scanpos = xsp;
          if (jj_scan_token(71)) {
            jj_scanpos = xsp;
            if (jj_scan_token(72)) {
              jj_scanpos = xsp;
              if (jj_scan_token(73)) {
                jj_scanpos = xsp;
                if (jj_scan_token(74)) {
                  jj_scanpos = xsp;
                  if (jj_scan_token(76)) {
                    jj_scanpos = xsp;
                    if (jj_scan_token(77)) {
                      jj_scanpos = xsp;
                      if (jj_scan_token(78)) {
                        jj_scanpos = xsp;
                        if (jj_scan_token(26)) {
                          jj_scanpos = xsp;
                          if (jj_scan_token(55)) {
                            jj_scanpos = xsp;
                            if (jj_scan_token(68)) {
                              jj_scanpos = xsp;
                              if (jj_scan_token(50)) {
                                jj_scanpos = xsp;
                                if (jj_scan_token(46)) {
                                  jj_scanpos = xsp;
                                  if (jj_scan_token(52)) {
                                    jj_scanpos = xsp;
                                    if (jj_scan_token(79)) {
                                      jj_scanpos = xsp;
                                      if (jj_scan_token(98)) return true;
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  private boolean jj_3R_366() {
    if (jj_3R_222()) return true;
    return false;
  }

  private boolean jj_3R_367() {
    if (jj_3R_389()) return true;
    return false;
  }

  private boolean jj_3R_368() {
    if (jj_3R_390()) return true;
    return false;
  }

  private boolean jj_3R_369() {
    if (jj_3R_391()) return true;
    return false;
  }

  private boolean jj_3_13() {
    if (jj_scan_token(RECORD)) return true;
    if (jj_3R_88()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_89()) jj_scanpos = xsp;
    if (jj_3R_90()) return true;
    return false;
  }

  private boolean jj_3R_370() {
    if (jj_3R_392()) return true;
    return false;
  }

  private boolean jj_3_14() {
    if (jj_scan_token(ENUM)) return true;
    return false;
  }

  private boolean jj_3R_371() {
    if (jj_3R_393()) return true;
    return false;
  }

  private boolean jj_3_15() {
    if (jj_scan_token(AT)) return true;
    if (jj_scan_token(INTERFACE)) return true;
    return false;
  }

  private boolean jj_3_16() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_91()) jj_scanpos = xsp;
    if (jj_3R_82()) return true;
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3R_91() {
    if (jj_3R_137()) return true;
    return false;
  }

  private boolean jj_3R_205() {
    if (jj_scan_token(LPAREN)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_245()) jj_scanpos = xsp;
    if (jj_scan_token(RPAREN)) return true;
    return false;
  }

  private boolean jj_3_17() {
    if (jj_3R_84()) return true;
    if (jj_3R_82()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_92()) {
        jj_scanpos = xsp;
        break;
      }
    }
    xsp = jj_scanpos;
    if (jj_scan_token(108)) {
      jj_scanpos = xsp;
      if (jj_scan_token(113)) {
        jj_scanpos = xsp;
        if (jj_scan_token(107)) return true;
      }
    }
    return false;
  }

  private boolean jj_3R_245() {
    if (jj_3R_301()) return true;
    return false;
  }

  private boolean jj_3R_89() {
    if (jj_3R_137()) return true;
    return false;
  }

  private boolean jj_3R_104() {
    if (jj_3R_171()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_232()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_392() {
    if (jj_3R_84()) return true;
    if (jj_3R_131()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_447()) {
        jj_scanpos = xsp;
        break;
      }
    }
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  private boolean jj_3R_301() {
    if (jj_3R_104()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_350()) {
        jj_scanpos = xsp;
        break;
      }
    }
    return false;
  }

  private boolean jj_3R_232() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_33()) {
      jj_scanpos = xsp;
      if (jj_3R_287()) {
        jj_scanpos = xsp;
        if (jj_3R_288()) return true;
      }
    }
    return false;
  }

  private boolean jj_3R_447() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_131()) return true;
    return false;
  }

  private boolean jj_3R_92() {
    if (jj_3R_140()) return true;
    return false;
  }

  private boolean jj_3_33() {
    if (jj_3R_103()) return true;
    if (jj_3R_104()) return true;
    return false;
  }

  private boolean jj_3R_350() {
    if (jj_scan_token(COMMA)) return true;
    if (jj_3R_104()) return true;
    return false;
  }

  private boolean jj_3R_332() {
    if (jj_scan_token(TRY)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_362()) jj_scanpos = xsp;
    if (jj_3R_142()) return true;
    xsp = jj_scanpos;
    if (jj_3R_460()) {
      jj_scanpos = xsp;
      if (jj_3R_461()) return true;
    }
    return false;
  }

  private boolean jj_3R_287() {
    if (jj_scan_token(ARROW)) return true;
    if (jj_3R_341()) return true;
    return false;
  }

  private boolean jj_3R_362() {
    if (jj_3R_386()) return true;
    return false;
  }

  private boolean jj_3R_288() {
    if (jj_scan_token(DOUBLECOLON)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_342()) jj_scanpos = xsp;
    xsp = jj_scanpos;
    if (jj_3R_343()) {
      jj_scanpos = xsp;
      if (jj_scan_token(42)) return true;
    }
    return false;
  }

  private boolean jj_3R_460() {
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_472()) {
        jj_scanpos = xsp;
        break;
      }
    }
    xsp = jj_scanpos;
    if (jj_3R_473()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_342() {
    if (jj_3R_102()) return true;
    return false;
  }

  private boolean jj_3R_343() {
    if (jj_3R_82()) return true;
    return false;
  }

  private boolean jj_3R_472() {
    if (jj_scan_token(CATCH)) return true;
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_124()) return true;
    if (jj_3R_202()) return true;
    Token xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_480()) {
        jj_scanpos = xsp;
        break;
      }
    }
    if (jj_3R_116()) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_3R_142()) return true;
    return false;
  }

  private boolean jj_3R_131() {
    if (jj_3R_116()) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_196()) jj_scanpos = xsp;
    return false;
  }

  private boolean jj_3R_196() {
    if (jj_scan_token(ASSIGN)) return true;
    if (jj_3R_93()) return true;
    return false;
  }

  private boolean jj_3R_480() {
    if (jj_scan_token(BIT_OR)) return true;
    if (jj_3R_278()) return true;
    return false;
  }

  private boolean jj_3R_103() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_159()) {
      jj_scanpos = xsp;
      if (jj_3R_160()) {
        jj_scanpos = xsp;
        if (jj_3R_161()) {
          jj_scanpos = xsp;
          if (jj_3R_162()) {
            jj_scanpos = xsp;
            if (jj_3R_163()) {
              jj_scanpos = xsp;
              if (jj_3R_164()) {
                jj_scanpos = xsp;
                if (jj_3R_165()) {
                  jj_scanpos = xsp;
                  if (jj_3R_166()) {
                    jj_scanpos = xsp;
                    if (jj_3R_167()) {
                      jj_scanpos = xsp;
                      if (jj_3R_168()) {
                        jj_scanpos = xsp;
                        if (jj_3R_169()) {
                          jj_scanpos = xsp;
                          if (jj_3R_170()) return true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }

  /** Generated Token Manager. */
  public GeneratedJavaParserTokenManager token_source;

  SimpleCharStream jj_input_stream;

  /** Current token. */
  public Token token;

  /** Next token. */
  public Token jj_nt;

  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;

  /** Whether we are looking ahead. */
  private boolean jj_lookingAhead = false;

  private boolean jj_semLA;
  private int jj_gen;
  private final int[] jj_la1 = new int[186];
  private static int[] jj_la1_0;
  private static int[] jj_la1_1;
  private static int[] jj_la1_2;
  private static int[] jj_la1_3;
  private static int[] jj_la1_4;

  static {
    jj_la1_init_0();
    jj_la1_init_1();
    jj_la1_init_2();
    jj_la1_init_3();
    jj_la1_init_4();
  }

  private static void jj_la1_init_0() {
    jj_la1_0 =
        new int[] {
          0x24480800,
          0x4080000,
          0x24480800,
          0x1,
          0x0,
          0x0,
          0x0,
          0x20400800,
          0x80000,
          0x0,
          0x8000000,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x4000000,
          0x0,
          0xa54ca800,
          0xa54ca800,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x8000000,
          0x0,
          0xa54ca800,
          0xa54ca800,
          0xa54ca800,
          0xa54ca800,
          0x80000,
          0x8504a000,
          0xa54ca800,
          0x0,
          0x0,
          0x0,
          0x80000,
          0x8504a000,
          0xa54ca800,
          0x0,
          0x0,
          0x0,
          0x9504a000,
          0x9504a000,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0xa544a800,
          0x0,
          0xa544a800,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x9504a000,
          0x0,
          0x8104a000,
          0x8504a000,
          0x8504a000,
          0x0,
          0x8504a000,
          0x8504a000,
          0x8000000,
          0x8000000,
          0x8104a000,
          0x8504a000,
          0x4000000,
          0x0,
          0x4000000,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x8504a000,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x9504a000,
          0x0,
          0x0,
          0x9504a000,
          0x0,
          0x0,
          0x8504a000,
          0x0,
          0x0,
          0x0,
          0x4000000,
          0x0,
          0x0,
          0x9504a000,
          0x0,
          0x4000000,
          0x0,
          0x10000000,
          0x4000000,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x10000000,
          0x10000000,
          0x9504a000,
          0x0,
          0x0,
          0x0,
          0x8504a000,
          0x9504a000,
          0x0,
          0x1000,
          0x95a4e000,
          0x0,
          0x95a4f000,
          0x0,
          0x9504a000,
          0x0,
          0x0,
          0x9504a000,
          0x410000,
          0x410000,
          0x0,
          0x0,
          0x9504a000,
          0x410000,
          0x9504a000,
          0x0,
          0x2000000,
          0xb544a800,
          0x9504a000,
          0x9504a000,
          0xb544a800,
          0x9504a000,
          0x0,
          0x4000000,
          0x4000000,
          0x9504a000,
          0x0,
          0x20000,
          0x0,
          0x40000000,
          0x9504a000,
          0x4000000,
          0x0,
          0x9504a000,
          0x9504a000,
          0x0,
          0xa54ca800,
          0xa54ca800,
          0x80000,
          0x8504a000,
          0x400000,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x9504a000,
          0x4080000,
        };
  }

  private static void jj_la1_init_1() {
    jj_la1_1 =
        new int[] {
          0x44d78a90,
          0x40080,
          0x44d78a90,
          0x0,
          0x0,
          0x400000,
          0x0,
          0x44d38a00,
          0x80,
          0x0,
          0x0,
          0x8,
          0x4000,
          0x0,
          0x8,
          0x0,
          0x0,
          0x0,
          0x8,
          0x944000,
          0x0,
          0x44f7cbc0,
          0x44f7cbc0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x44f7cbc0,
          0x44f7cbc0,
          0x44f7cbc0,
          0x44f7cbc0,
          0x80,
          0xb44140,
          0x44f7cbc0,
          0x0,
          0x0,
          0x20000000,
          0x80,
          0xb44140,
          0x44f7cbc0,
          0x0,
          0x0,
          0x0,
          0x8bb45540,
          0x8bb45540,
          0x0,
          0x0,
          0x0,
          0x0,
          0x20000000,
          0x0,
          0x44f7cb40,
          0x0,
          0x44f7cb40,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x20000000,
          0x0,
          0x0,
          0x89b45540,
          0x400000,
          0x200140,
          0xb44140,
          0xb44140,
          0x0,
          0xb44140,
          0xb44140,
          0x1000000,
          0x1000000,
          0x200140,
          0xb44140,
          0x944000,
          0x0,
          0x944400,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0xb44140,
          0x20,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x8bb45540,
          0x0,
          0x0,
          0x8bb45540,
          0x0,
          0x0,
          0xb44140,
          0x0,
          0x0,
          0x0,
          0x944400,
          0x0,
          0x0,
          0x8bb45540,
          0x0,
          0x944400,
          0x0,
          0x89001400,
          0x944000,
          0x0,
          0x0,
          0x0,
          0x8000400,
          0x0,
          0x80001000,
          0x80000000,
          0x8bb45540,
          0x0,
          0x0,
          0x0,
          0xb44140,
          0x8bb45540,
          0x0,
          0x0,
          0x9fbc5545,
          0x0,
          0x9fbc5545,
          0x0,
          0x8bb45540,
          0x0,
          0x0,
          0x89b45540,
          0x0,
          0x0,
          0x0,
          0x0,
          0x8bb45540,
          0x0,
          0x99b45540,
          0x0,
          0x0,
          0xcff7df40,
          0x8bb45540,
          0x8bb45540,
          0xcff7df40,
          0x8bb45540,
          0x0,
          0x944000,
          0x944000,
          0x8bb45540,
          0x0,
          0x0,
          0x0,
          0x0,
          0x89b45540,
          0x944000,
          0x0,
          0x8bb45540,
          0x8bb45540,
          0x0,
          0x44f7cbc0,
          0x44f7cbc0,
          0x80,
          0xb44140,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x89b45540,
          0x80,
        };
  }

  private static void jj_la1_init_2() {
    jj_la1_2 =
        new int[] {
          0x4904,
          0x900,
          0x4904,
          0x0,
          0x0,
          0x0,
          0x0,
          0x4004,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0xfff0,
          0x0,
          0xfff6,
          0xfff6,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0xfff6,
          0xfff6,
          0xfff6,
          0xfff6,
          0x0,
          0xfff2,
          0xfff6,
          0x0,
          0x0,
          0x0,
          0x0,
          0xfff2,
          0xfff6,
          0x0,
          0x0,
          0x0,
          0x6043fff2,
          0x6043fff2,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0xfff4,
          0x0,
          0xfff4,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x6043fff2,
          0x0,
          0x0,
          0xfff0,
          0xfff0,
          0x0,
          0xfff0,
          0xfff0,
          0x0,
          0x0,
          0x0,
          0xfff2,
          0xfff0,
          0x0,
          0xfff0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0xfff0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x6043fff2,
          0x0,
          0x0,
          0x6043fff2,
          0x0,
          0x0,
          0xfff0,
          0x0,
          0x0,
          0x0,
          0xfff0,
          0x0,
          0x0,
          0x6043fff2,
          0x0,
          0xfff0,
          0x0,
          0x60430000,
          0xfff0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x60430000,
          0x0,
          0x6043fff2,
          0x0,
          0x0,
          0x0,
          0xfff0,
          0x6043fff2,
          0x0,
          0x0,
          0x6043fffb,
          0x0,
          0x6043fffb,
          0x0,
          0x6043fff2,
          0x0,
          0x0,
          0x6043fff2,
          0x0,
          0x0,
          0x8000,
          0x0,
          0x6043fff2,
          0x0,
          0x6043fff2,
          0x0,
          0x0,
          0x6043fff6,
          0x6043fff2,
          0x6043fff2,
          0x6043fff6,
          0x6043fff2,
          0x0,
          0xfff0,
          0xfff0,
          0x6043fff2,
          0x0,
          0x0,
          0x0,
          0x0,
          0x6043fff2,
          0xfff0,
          0x0,
          0x6043fff2,
          0x6043fff2,
          0x0,
          0xfff4,
          0xfff4,
          0x0,
          0xfff0,
          0x0,
          0x0,
          0x40,
          0x0,
          0x40,
          0x0,
          0x3620,
          0x100,
          0x3620,
          0x6043fff2,
          0x0,
        };
  }

  private static void jj_la1_init_3() {
    jj_la1_3 =
        new int[] {
          0x8800,
          0x8800,
          0x8800,
          0x0,
          0x8000,
          0x0,
          0x2000,
          0x8000,
          0x0,
          0x40000,
          0x0,
          0x0,
          0x0,
          0x40000,
          0x0,
          0x1000,
          0x1000,
          0x1000,
          0x0,
          0x8004,
          0x1000,
          0x48884,
          0x48884,
          0x800,
          0x8000,
          0x20,
          0x80,
          0x1000,
          0x0,
          0x0,
          0x48884,
          0x48884,
          0x48884,
          0x48884,
          0x0,
          0x48004,
          0x48004,
          0x40000,
          0x1000,
          0x0,
          0x0,
          0x48004,
          0x48004,
          0x1000,
          0x20000,
          0x8200,
          0xc01880a5,
          0xc01880a5,
          0x1000,
          0x40000,
          0x8200,
          0x1000,
          0x0,
          0x880,
          0x8004,
          0x1000,
          0x8004,
          0x1000,
          0x1000,
          0xc000,
          0x40000,
          0x1000,
          0x0,
          0x40000,
          0x40000,
          0x48025,
          0x0,
          0x0,
          0x4,
          0x8004,
          0x1000,
          0x208004,
          0x200004,
          0x0,
          0x0,
          0x0,
          0x4,
          0x4,
          0x40000,
          0x4,
          0x810000,
          0x830000,
          0x20000,
          0x200000,
          0x20000000,
          0x10000000,
          0x0,
          0x0,
          0x0,
          0x9000000,
          0x9000000,
          0x8004,
          0x0,
          0x6040000,
          0x6040000,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0x0,
          0xc0188025,
          0x180000,
          0x180000,
          0x8025,
          0xc0000000,
          0x0,
          0x4,
          0x40000,
          0x20,
          0x40000,
          0x4,
          0x12000,
          0x40,
          0xc0188025,
          0x40000,
          0x4,
          0x20,
          0x21,
          0x4,
          0x2000,
          0x40000,
          0x20,
          0x0,
          0x2200,
          0x1,
          0x0,
          0xc0188025,
          0x1000,
          0x40000,
          0x8220,
          0x4,
          0xc0188025,
          0x80,
          0x0,
          0xc00088a5,
          0x400000,
          0xc00088a5,
          0x1000,
          0xc01880a5,
          0xc0020000,
          0xc0020000,
          0x80008025,
          0x0,
          0x0,
          0x0,
          0x1000,
          0xc0188025,
          0x0,
          0xc00080a5,
          0xc00000,
          0x0,
          0xc0188025,
          0xc0188025,
          0xc0188025,
          0xc0188825,
          0xc0188025,
          0x1000,
          0x4,
          0x4,
          0xc0188025,
          0x20,
          0x0,
          0x0,
          0x0,
          0x8025,
          0x4,
          0x1000,
          0xc01880a5,
          0xc01880a5,
          0x1000,
          0x8804,
          0x8804,
          0x0,
          0x8004,
          0x0,
          0x1000,
          0x0,
          0x1000,
          0x0,
          0x1000,
          0x0,
          0x0,
          0x0,
          0x48025,
          0x8000,
        };
  }

  private static void jj_la1_init_4() {
    jj_la1_4 =
        new int[] {
          0x0, 0x0, 0x0, 0x800000, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
          0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x10, 0x0, 0x0, 0x0, 0x0, 0x0,
          0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x3, 0x3, 0x0, 0x0, 0x0, 0x0, 0x0,
          0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
          0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0xffe00, 0xffe00, 0x0, 0x0, 0x0, 0x20,
          0x40, 0x10, 0x0, 0x0, 0x0, 0x0, 0x400000, 0x400000, 0x100, 0x3, 0x3, 0x8c, 0x8c, 0x3, 0x3,
          0x0, 0x0, 0x0, 0x0, 0x10, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x3, 0x0, 0x0, 0x0, 0x0, 0x0,
          0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x3, 0x0, 0x0, 0x0, 0x0, 0x3, 0x0, 0x0, 0x0, 0x0, 0x0,
          0x0, 0x3, 0xffe00, 0xffe00, 0x0, 0x0, 0x0, 0x0, 0x0, 0x3, 0x0, 0x0, 0x0, 0x0, 0x3, 0x3,
          0x3, 0x3, 0x3, 0x0, 0x0, 0x0, 0x3, 0x0, 0x0, 0x20, 0x0, 0x0, 0x0, 0x0, 0x3, 0x3, 0x0, 0x0,
          0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
        };
  }

  private final JJCalls[] jj_2_rtns = new JJCalls[73];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /**
   * Constructor with InputStream.
   *
   * @param stream char stream
   */
  public GeneratedJavaParser(final Provider stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new GeneratedJavaParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 186; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /**
   * Constructor with InputStream.
   *
   * @param sDSL String representation to be parsed
   */
  public GeneratedJavaParser(final String sDSL) {
    this(new StringProvider(sDSL));
  }

  /**
   * Reinitialise.
   *
   * @param sDSL String representation to be parsed
   */
  public void ReInit(final String sDSL) {
    ReInit(new StringProvider(sDSL));
  }

  /**
   * Reinitialise
   *
   * @param stream char stream
   */
  public void ReInit(final Provider stream) {
    if (jj_input_stream == null) {
      jj_input_stream = new SimpleCharStream(stream, 1, 1);
    } else {
      jj_input_stream.reInit(stream, 1, 1);
    }
    if (token_source == null) {
      token_source = new GeneratedJavaParserTokenManager(jj_input_stream);
    }

    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 186; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /**
   * Constructor with generated Token Manager.
   *
   * @param tm Token manager to use
   */
  public GeneratedJavaParser(final GeneratedJavaParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 186; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /**
   * Reinitialise
   *
   * @param tm Token manager to use
   */
  public void ReInit(final GeneratedJavaParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 186; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(final int kind) throws ParseException {
    final Token oldToken = token;
    if (token.next != null) token = token.next;
    else {
      token.next = token_source.getNextToken();
      token = token.next;
    }
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  private static final class LookaheadSuccess extends IllegalStateException {}

  private final LookaheadSuccess jj_ls = new LookaheadSuccess();

  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0;
      Token tok = token;
      while (tok != null && tok != jj_scanpos) {
        i++;
        tok = tok.next;
      }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }

  /**
   * @return the next Token.
   */
  public final Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  /**
   * @param index index to be retrieved
   * @return the specific Token.
   */
  public final Token getToken(final int index) {
    Token t = jj_lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next == null) t.next = token_source.getNextToken();
      t = t.next;
    }
    return t;
  }

  private int jj_ntk_f() {
    final Token nt = jj_nt = token.next;
    final int ret;
    if (nt == null) {
      token.next = token_source.getNextToken();
      ret = jj_ntk = token.next.kind;
    } else ret = jj_ntk = nt.kind;
    return ret;
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) {
      return;
    }

    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];

      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }

      for (final int[] oldentry : jj_expentries) {
        if (oldentry.length == jj_expentry.length) {
          boolean isMatched = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              isMatched = false;
              break;
            }
          }
          if (isMatched) {
            jj_expentries.add(jj_expentry);
            break;
          }
        }
      }

      if (pos != 0) {
        jj_endpos = pos;
        jj_lasttokens[jj_endpos - 1] = kind;
      }
    }
  }

  /**
   * Generate ParseException.
   *
   * @return new Exception object. Never <code>null</code>
   */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[152];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 186; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1 << j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1 << j)) != 0) {
            la1tokens[32 + j] = true;
          }
          if ((jj_la1_2[i] & (1 << j)) != 0) {
            la1tokens[64 + j] = true;
          }
          if ((jj_la1_3[i] & (1 << j)) != 0) {
            la1tokens[96 + j] = true;
          }
          if ((jj_la1_4[i] & (1 << j)) != 0) {
            la1tokens[128 + j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 152; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(
        token,
        exptokseq,
        tokenImage,
        token_source == null
            ? null
            : GeneratedJavaParserTokenManager.lexStateNames[token_source.curLexState]);
  }

  /**
   * @return Always <code>false</code>.
   */
  public final boolean trace_enabled() {
    return false;
  }

  /** Enable tracing. */
  public final void enable_tracing() {}

  /** Disable tracing. */
  public final void disable_tracing() {}

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 73; i++) {
      try {
        JJCalls p = jj_2_rtns[i];
        do {
          if (p.gen > jj_gen) {
            jj_la = p.arg;
            jj_scanpos = p.first;
            jj_lastpos = p.first;
            switch (i) {
              case 0:
                jj_3_1();
                break;
              case 1:
                jj_3_2();
                break;
              case 2:
                jj_3_3();
                break;
              case 3:
                jj_3_4();
                break;
              case 4:
                jj_3_5();
                break;
              case 5:
                jj_3_6();
                break;
              case 6:
                jj_3_7();
                break;
              case 7:
                jj_3_8();
                break;
              case 8:
                jj_3_9();
                break;
              case 9:
                jj_3_10();
                break;
              case 10:
                jj_3_11();
                break;
              case 11:
                jj_3_12();
                break;
              case 12:
                jj_3_13();
                break;
              case 13:
                jj_3_14();
                break;
              case 14:
                jj_3_15();
                break;
              case 15:
                jj_3_16();
                break;
              case 16:
                jj_3_17();
                break;
              case 17:
                jj_3_18();
                break;
              case 18:
                jj_3_19();
                break;
              case 19:
                jj_3_20();
                break;
              case 20:
                jj_3_21();
                break;
              case 21:
                jj_3_22();
                break;
              case 22:
                jj_3_23();
                break;
              case 23:
                jj_3_24();
                break;
              case 24:
                jj_3_25();
                break;
              case 25:
                jj_3_26();
                break;
              case 26:
                jj_3_27();
                break;
              case 27:
                jj_3_28();
                break;
              case 28:
                jj_3_29();
                break;
              case 29:
                jj_3_30();
                break;
              case 30:
                jj_3_31();
                break;
              case 31:
                jj_3_32();
                break;
              case 32:
                jj_3_33();
                break;
              case 33:
                jj_3_34();
                break;
              case 34:
                jj_3_35();
                break;
              case 35:
                jj_3_36();
                break;
              case 36:
                jj_3_37();
                break;
              case 37:
                jj_3_38();
                break;
              case 38:
                jj_3_39();
                break;
              case 39:
                jj_3_40();
                break;
              case 40:
                jj_3_41();
                break;
              case 41:
                jj_3_42();
                break;
              case 42:
                jj_3_43();
                break;
              case 43:
                jj_3_44();
                break;
              case 44:
                jj_3_45();
                break;
              case 45:
                jj_3_46();
                break;
              case 46:
                jj_3_47();
                break;
              case 47:
                jj_3_48();
                break;
              case 48:
                jj_3_49();
                break;
              case 49:
                jj_3_50();
                break;
              case 50:
                jj_3_51();
                break;
              case 51:
                jj_3_52();
                break;
              case 52:
                jj_3_53();
                break;
              case 53:
                jj_3_54();
                break;
              case 54:
                jj_3_55();
                break;
              case 55:
                jj_3_56();
                break;
              case 56:
                jj_3_57();
                break;
              case 57:
                jj_3_58();
                break;
              case 58:
                jj_3_59();
                break;
              case 59:
                jj_3_60();
                break;
              case 60:
                jj_3_61();
                break;
              case 61:
                jj_3_62();
                break;
              case 62:
                jj_3_63();
                break;
              case 63:
                jj_3_64();
                break;
              case 64:
                jj_3_65();
                break;
              case 65:
                jj_3_66();
                break;
              case 66:
                jj_3_67();
                break;
              case 67:
                jj_3_68();
                break;
              case 68:
                jj_3_69();
                break;
              case 69:
                jj_3_70();
                break;
              case 70:
                jj_3_71();
                break;
              case 71:
                jj_3_72();
                break;
              case 72:
                jj_3_73();
                break;
            }
          }
          p = p.next;
        } while (p != null);
      } catch (LookaheadSuccess ls) {
        /* ignore */
      }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) {
        p.next = new JJCalls();
        p = p.next;
        break;
      }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la;
    p.first = token;
    p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }
}
