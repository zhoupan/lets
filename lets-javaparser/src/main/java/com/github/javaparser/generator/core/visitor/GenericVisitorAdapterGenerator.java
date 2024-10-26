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

/** Generates JavaParser's VoidVisitorAdapter. */
public class GenericVisitorAdapterGenerator extends VisitorGenerator {

  public GenericVisitorAdapterGenerator(SourceRoot sourceRoot) {
    super(sourceRoot, "com.github.javaparser.ast.visitor", "GenericVisitorAdapter", "R", "A", true);
  }

  @Override
  protected void generateVisitMethodBody(
      BaseNodeMetaModel node, MethodDeclaration visitMethod, CompilationUnit compilationUnit) {
    visitMethod.getParameters().forEach(p -> p.setFinal(true));
    BlockStmt body = visitMethod.getBody().get();
    body.getStatements().clear();
    body.addStatement("R result;");
    final String resultCheck = "if (result != null) return result;";
    for (PropertyMetaModel field : node.getAllPropertyMetaModels()) {
      final String getter = field.getGetterMethodName() + "()";
      if (field.getNodeReference().isPresent()) {
        if (field.isOptional()) {
          body.addStatement(
              f(
                  "if (n.%s.isPresent()) {"
                      + "   result = n.%s.get().accept(this, arg);"
                      + "   %s"
                      + "}",
                  getter, getter, resultCheck));
        } else {
          body.addStatement(f("{ result = n.%s.accept(this, arg); %s }", getter, resultCheck));
        }
      }
    }
    body.addStatement("return null;");
  }
}
