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

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.generator.NodeGenerator;
import com.github.javaparser.metamodel.BaseNodeMetaModel;
import com.github.javaparser.metamodel.JavaParserMetaModel;
import com.github.javaparser.utils.SourceRoot;

public class GetMetaModelGenerator extends NodeGenerator {
  public GetMetaModelGenerator(SourceRoot sourceRoot) {
    super(sourceRoot);
  }

  @Override
  protected void generateNode(
      BaseNodeMetaModel nodeMetaModel,
      CompilationUnit nodeCu,
      ClassOrInterfaceDeclaration nodeCoid) {
    final MethodDeclaration getMetaModelMethod =
        (MethodDeclaration)
            parseBodyDeclaration(
                f(
                    "%s public %s getMetaModel() { return JavaParserMetaModel.%s; }",
                    nodeMetaModel.isRootNode() ? "" : "@Override",
                    nodeMetaModel.getClass().getSimpleName(),
                    nodeMetaModel.getMetaModelFieldName()));

    addOrReplaceWhenSameSignature(nodeCoid, getMetaModelMethod);
    nodeCu.addImport(nodeMetaModel.getClass().getName());
    nodeCu.addImport(JavaParserMetaModel.class);
  }
}
