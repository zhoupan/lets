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

import static com.github.javaparser.StaticJavaParser.parseExplicitConstructorInvocationStmt;
import static com.github.javaparser.utils.CodeGenerationUtils.f;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.generator.NodeGenerator;
import com.github.javaparser.metamodel.BaseNodeMetaModel;
import com.github.javaparser.metamodel.PropertyMetaModel;
import com.github.javaparser.utils.SeparatedItemStringBuilder;
import com.github.javaparser.utils.SourceRoot;

public class MainConstructorGenerator extends NodeGenerator {
  public MainConstructorGenerator(SourceRoot sourceRoot) {
    super(sourceRoot);
  }

  @Override
  protected void generateNode(
      BaseNodeMetaModel nodeMetaModel,
      CompilationUnit nodeCu,
      ClassOrInterfaceDeclaration nodeCoid) {
    if (nodeMetaModel.is(Node.class)) {
      return;
    }
    ConstructorDeclaration constructor =
        new ConstructorDeclaration()
            .setPublic(true)
            .setName(nodeCoid.getNameAsString())
            .addParameter(TokenRange.class, "tokenRange")
            .setJavadocComment(
                "\n     * This constructor is used by the parser and is considered private.\n     ");

    BlockStmt body = constructor.getBody();

    SeparatedItemStringBuilder superCall = new SeparatedItemStringBuilder("super(", ", ", ");");
    superCall.append("tokenRange");
    for (PropertyMetaModel parameter : nodeMetaModel.getConstructorParameters()) {
      constructor.addParameter(parameter.getTypeNameForSetter(), parameter.getName());
      if (nodeMetaModel.getDeclaredPropertyMetaModels().contains(parameter)) {
        body.addStatement(f("%s(%s);", parameter.getSetterMethodName(), parameter.getName()));
      } else {
        superCall.append(parameter.getName());
      }
    }

    body.getStatements().addFirst(parseExplicitConstructorInvocationStmt(superCall.toString()));

    body.addStatement("customInitialization();");

    addOrReplaceWhenSameSignature(nodeCoid, constructor);
    nodeCu.addImport(TokenRange.class);
  }
}
