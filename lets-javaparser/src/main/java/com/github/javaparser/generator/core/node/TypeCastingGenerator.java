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
package com.github.javaparser.generator.core.node;

import static com.github.javaparser.StaticJavaParser.parseBodyDeclaration;
import static com.github.javaparser.utils.CodeGenerationUtils.f;
import static com.github.javaparser.utils.Utils.set;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.generator.NodeGenerator;
import com.github.javaparser.metamodel.BaseNodeMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.utils.Pair;
import com.github.javaparser.utils.SourceRoot;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

public class TypeCastingGenerator extends NodeGenerator {
  private final Set<BaseNodeMetaModel> baseNodes =
      set(
          JavaParserMetaModel.statementMetaModel,
          JavaParserMetaModel.expressionMetaModel,
          JavaParserMetaModel.typeMetaModel,
          JavaParserMetaModel.moduleDirectiveMetaModel,
          JavaParserMetaModel.bodyDeclarationMetaModel,
          JavaParserMetaModel.commentMetaModel);

  public TypeCastingGenerator(SourceRoot sourceRoot) {
    super(sourceRoot);
  }

  @Override
  protected void generateNode(
      BaseNodeMetaModel nodeMetaModel, CompilationUnit nodeCu, ClassOrInterfaceDeclaration nodeCoid)
      throws Exception {
    Pair<CompilationUnit, ClassOrInterfaceDeclaration> baseCode = null;
    for (BaseNodeMetaModel baseNode : baseNodes) {
      if (nodeMetaModel == baseNode) {
        // We adjust the base models from the child nodes,
        // so we don't do anything when we *are* the base model.
        return;
      }
      if (nodeMetaModel.isInstanceOfMetaModel(baseNode)) {
        baseCode = parseNode(baseNode);
      }
    }

    if (baseCode == null) {
      // Node is not a child of one of the base nodes, so we don't want to generate this method for
      // it.
      return;
    }

    final String typeName = nodeMetaModel.getTypeName();
    final ClassOrInterfaceDeclaration baseCoid = baseCode.b;
    final CompilationUnit baseCu = baseCode.a;

    generateIsType(nodeMetaModel, baseCu, nodeCoid, baseCoid, typeName);
    generateAsType(nodeMetaModel, baseCu, nodeCoid, baseCoid, typeName);
    generateToType(nodeMetaModel, nodeCu, baseCu, nodeCoid, baseCoid, typeName);
    generateIfType(nodeMetaModel, nodeCu, baseCu, nodeCoid, baseCoid, typeName);
  }

  private void generateAsType(
      BaseNodeMetaModel nodeMetaModel,
      CompilationUnit baseCu,
      ClassOrInterfaceDeclaration nodeCoid,
      ClassOrInterfaceDeclaration baseCoid,
      String typeName) {
    baseCu.addImport("com.github.javaparser.utils.CodeGenerationUtils.f", true, false);

    final MethodDeclaration asTypeBaseMethod =
        (MethodDeclaration)
            parseBodyDeclaration(
                f(
                    "public %s as%s() { throw new IllegalStateException(f(\"%%s is not %s, it is %%s\", this, this.getClass().getSimpleName())); }",
                    typeName, typeName, typeName));
    final MethodDeclaration asTypeNodeMethod =
        (MethodDeclaration)
            parseBodyDeclaration(
                f("@Override public %s as%s() { return this; }", typeName, typeName));

    annotateWhenOverridden(nodeMetaModel, asTypeNodeMethod);

    addOrReplaceWhenSameSignature(baseCoid, asTypeBaseMethod);
    addOrReplaceWhenSameSignature(nodeCoid, asTypeNodeMethod);
  }

  private void generateToType(
      BaseNodeMetaModel nodeMetaModel,
      CompilationUnit nodeCu,
      CompilationUnit baseCu,
      ClassOrInterfaceDeclaration nodeCoid,
      ClassOrInterfaceDeclaration baseCoid,
      String typeName) {
    baseCu.addImport(Optional.class);
    nodeCu.addImport(Optional.class);

    final MethodDeclaration toTypeBaseMethod =
        (MethodDeclaration)
            parseBodyDeclaration(
                f(
                    "public Optional<%s> to%s() { return Optional.empty(); }",
                    typeName, typeName, typeName));
    final MethodDeclaration toTypeNodeMethod =
        (MethodDeclaration)
            parseBodyDeclaration(
                f(
                    "@Override public Optional<%s> to%s() { return Optional.of(this); }",
                    typeName, typeName));

    annotateWhenOverridden(nodeMetaModel, toTypeNodeMethod);

    addOrReplaceWhenSameSignature(baseCoid, toTypeBaseMethod);
    addOrReplaceWhenSameSignature(nodeCoid, toTypeNodeMethod);
  }

  private void generateIfType(
      BaseNodeMetaModel nodeMetaModel,
      CompilationUnit nodeCu,
      CompilationUnit baseCu,
      ClassOrInterfaceDeclaration nodeCoid,
      ClassOrInterfaceDeclaration baseCoid,
      String typeName) {
    baseCu.addImport(Consumer.class);
    nodeCu.addImport(Consumer.class);

    final MethodDeclaration ifTypeBaseMethod =
        (MethodDeclaration)
            parseBodyDeclaration(
                f("public void if%s(Consumer<%s> action) { }", typeName, typeName));
    final MethodDeclaration ifTypeNodeMethod =
        (MethodDeclaration)
            parseBodyDeclaration(
                f(
                    "public void if%s(Consumer<%s> action) { action.accept(this); }",
                    typeName, typeName));

    annotateWhenOverridden(nodeMetaModel, ifTypeNodeMethod);

    addOrReplaceWhenSameSignature(baseCoid, ifTypeBaseMethod);
    addOrReplaceWhenSameSignature(nodeCoid, ifTypeNodeMethod);
  }

  private void generateIsType(
      BaseNodeMetaModel nodeMetaModel,
      CompilationUnit baseCu,
      ClassOrInterfaceDeclaration nodeCoid,
      ClassOrInterfaceDeclaration baseCoid,
      String typeName) {
    final MethodDeclaration baseIsTypeMethod =
        (MethodDeclaration)
            parseBodyDeclaration(f("public boolean is%s() { return false; }", typeName));
    final MethodDeclaration overriddenIsTypeMethod =
        (MethodDeclaration)
            parseBodyDeclaration(f("@Override public boolean is%s() { return true; }", typeName));

    annotateWhenOverridden(nodeMetaModel, overriddenIsTypeMethod);

    addOrReplaceWhenSameSignature(nodeCoid, overriddenIsTypeMethod);
    addOrReplaceWhenSameSignature(baseCoid, baseIsTypeMethod);
  }
}
