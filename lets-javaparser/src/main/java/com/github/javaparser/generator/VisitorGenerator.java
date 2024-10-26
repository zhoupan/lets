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
package com.github.javaparser.generator;

import static com.github.javaparser.ast.Modifier.Keyword.PUBLIC;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.metamodel.BaseNodeMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.utils.Log;
import com.github.javaparser.utils.SourceRoot;
import java.util.Optional;

/**
 * Makes it easier to generate visitor classes. It will create missing visit methods on the fly, and
 * will ask you to fill in the bodies of the visit methods.
 */
public abstract class VisitorGenerator extends Generator {

  private final String pkg;

  private final String visitorClassName;

  private final String returnType;

  private final String argumentType;

  private final boolean createMissingVisitMethods;

  protected VisitorGenerator(
      SourceRoot sourceRoot,
      String pkg,
      String visitorClassName,
      String returnType,
      String argumentType,
      boolean createMissingVisitMethods) {
    super(sourceRoot);
    this.pkg = pkg;
    this.visitorClassName = visitorClassName;
    this.returnType = returnType;
    this.argumentType = argumentType;
    this.createMissingVisitMethods = createMissingVisitMethods;
  }

  public final void generate() throws Exception {
    Log.info("Running %s", () -> getClass().getSimpleName());
    final CompilationUnit compilationUnit =
        sourceRoot.tryToParse(pkg, visitorClassName + ".java").getResult().get();
    Optional<ClassOrInterfaceDeclaration> visitorClassOptional =
        compilationUnit.getClassByName(visitorClassName);
    if (!visitorClassOptional.isPresent()) {
      visitorClassOptional = compilationUnit.getInterfaceByName(visitorClassName);
    }
    final ClassOrInterfaceDeclaration visitorClass = visitorClassOptional.get();
    JavaParserMetaModel.getNodeMetaModels().stream()
        .filter((baseNodeMetaModel) -> !baseNodeMetaModel.isAbstract())
        .forEach(node -> generateVisitMethodForNode(node, visitorClass, compilationUnit));
    after();
  }

  protected void after() throws Exception {}

  private void generateVisitMethodForNode(
      BaseNodeMetaModel node,
      ClassOrInterfaceDeclaration visitorClass,
      CompilationUnit compilationUnit) {
    final Optional<MethodDeclaration> existingVisitMethod =
        visitorClass.getMethods().stream()
            .filter(m -> "visit".equals(m.getNameAsString()))
            .filter(m -> m.getParameter(0).getType().toString().equals(node.getTypeName()))
            .findFirst();
    if (existingVisitMethod.isPresent()) {
      generateVisitMethodBody(node, existingVisitMethod.get(), compilationUnit);
    } else if (createMissingVisitMethods) {
      MethodDeclaration newVisitMethod =
          visitorClass
              .addMethod("visit")
              .addParameter(node.getTypeNameGenerified(), "n")
              .addParameter(argumentType, "arg")
              .setType(returnType);
      if (!visitorClass.isInterface()) {
        newVisitMethod
            .addAnnotation(new MarkerAnnotationExpr(new Name("Override")))
            .addModifier(PUBLIC);
      }
      generateVisitMethodBody(node, newVisitMethod, compilationUnit);
    }
  }

  protected abstract void generateVisitMethodBody(
      BaseNodeMetaModel node, MethodDeclaration visitMethod, CompilationUnit compilationUnit);
}
