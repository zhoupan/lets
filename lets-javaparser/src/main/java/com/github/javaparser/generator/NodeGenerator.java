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

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.metamodel.BaseNodeMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.utils.Log;
import com.github.javaparser.utils.Pair;
import com.github.javaparser.utils.SourceRoot;
import java.util.Arrays;

/**
 * Makes it easier to generate code in the core AST nodes. The generateNode method will get every
 * node type passed to it, ready for modification.
 */
public abstract class NodeGenerator extends Generator {

  protected NodeGenerator(SourceRoot sourceRoot) {
    super(sourceRoot);
  }

  public final void generate() throws Exception {
    Log.info("Running %s", () -> getClass().getSimpleName());
    for (BaseNodeMetaModel nodeMetaModel : JavaParserMetaModel.getNodeMetaModels()) {
      Pair<CompilationUnit, ClassOrInterfaceDeclaration> result = parseNode(nodeMetaModel);
      generateNode(nodeMetaModel, result.a, result.b);
    }
    after();
  }

  protected Pair<CompilationUnit, ClassOrInterfaceDeclaration> parseNode(
      BaseNodeMetaModel nodeMetaModel) {
    CompilationUnit nodeCu =
        sourceRoot.parse(nodeMetaModel.getPackageName(), nodeMetaModel.getTypeName() + ".java");
    ClassOrInterfaceDeclaration nodeCoid =
        nodeCu
            .getClassByName(nodeMetaModel.getTypeName())
            .orElseThrow(() -> new AssertionError("Can't find class"));
    return new Pair<>(nodeCu, nodeCoid);
  }

  /**
   * Annotate a method with the {@link Override} annotation, if it overrides other method.
   *
   * @param nodeMetaModel The current meta model.
   * @param methodDeclaration The method declaration.
   */
  protected void annotateWhenOverridden(
      BaseNodeMetaModel nodeMetaModel, MethodDeclaration methodDeclaration) {
    Class<? extends Node> type = nodeMetaModel.getType();
    Class<?> superClass = type.getSuperclass();
    boolean isOverriding =
        Arrays.stream(superClass.getMethods())
            .filter(m -> m.getName().equals(methodDeclaration.getNameAsString()))
            .anyMatch(m -> m.getParameters().length == methodDeclaration.getParameters().size());
    if (isOverriding) {
      annotateOverridden(methodDeclaration);
    }
  }

  protected void after() throws Exception {}

  protected abstract void generateNode(
      BaseNodeMetaModel nodeMetaModel, CompilationUnit nodeCu, ClassOrInterfaceDeclaration nodeCoid)
      throws Exception;
}
