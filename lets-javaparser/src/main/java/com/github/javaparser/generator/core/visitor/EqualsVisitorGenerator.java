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
package com.github.javaparser.generator.core.visitor;

import static com.github.javaparser.utils.CodeGenerationUtils.f;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.generator.VisitorGenerator;
import com.github.javaparser.metamodel.BaseNodeMetaModel;
import com.github.javaparser.metamodel.PropertyMetaModel;
import com.github.javaparser.utils.SourceRoot;

/** Generates JavaParser's EqualsVisitor. */
public class EqualsVisitorGenerator extends VisitorGenerator {
  public EqualsVisitorGenerator(SourceRoot sourceRoot) {
    super(
        sourceRoot,
        "com.github.javaparser.ast.visitor",
        "EqualsVisitor",
        "Boolean",
        "Visitable",
        true);
  }

  @Override
  protected void generateVisitMethodBody(
      BaseNodeMetaModel node, MethodDeclaration visitMethod, CompilationUnit compilationUnit) {
    visitMethod.getParameters().forEach(p -> p.setFinal(true));

    BlockStmt body = visitMethod.getBody().get();
    body.getStatements().clear();

    body.addStatement(f("final %s n2 = (%s) arg;", node.getTypeName(), node.getTypeName()));

    for (PropertyMetaModel field : node.getAllPropertyMetaModels()) {
      final String getter = field.getGetterMethodName() + "()";
      if (field.getNodeReference().isPresent()) {
        if (field.isNodeList()) {
          body.addStatement(f("if (!nodesEquals(n.%s, n2.%s)) return false;", getter, getter));
        } else {
          body.addStatement(f("if (!nodeEquals(n.%s, n2.%s)) return false;", getter, getter));
        }
      } else {
        body.addStatement(f("if (!objEquals(n.%s, n2.%s)) return false;", getter, getter));
      }
    }
    if (body.getStatements().size() == 1) {
      // Only the cast line was added, but nothing is using it, so remove it again.
      body.getStatements().clear();
    }
    body.addStatement("return true;");
  }
}
