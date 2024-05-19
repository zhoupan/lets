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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Generates JavaParser's GenericListVisitorAdapter. */
public class GenericListVisitorAdapterGenerator extends VisitorGenerator {
  public GenericListVisitorAdapterGenerator(SourceRoot sourceRoot) {
    super(
        sourceRoot,
        "com.github.javaparser.ast.visitor",
        "GenericListVisitorAdapter",
        "List<R>",
        "A",
        true);
  }

  @Override
  protected void generateVisitMethodBody(
      BaseNodeMetaModel node, MethodDeclaration visitMethod, CompilationUnit compilationUnit) {
    visitMethod.getParameters().forEach(p -> p.setFinal(true));

    BlockStmt body = visitMethod.getBody().get();
    body.getStatements().clear();
    body.addStatement("List<R> result = new ArrayList<>();");
    body.addStatement("List<R> tmp;");

    final String resultCheck = "if (tmp != null) result.addAll(tmp);";

    for (PropertyMetaModel field : node.getAllPropertyMetaModels()) {
      final String getter = field.getGetterMethodName() + "()";
      if (field.getNodeReference().isPresent()) {
        if (field.isOptional()) {
          body.addStatement(
              f(
                  "if (n.%s.isPresent()) {"
                      + "   tmp = n.%s.get().accept(this, arg);"
                      + "   %s"
                      + "}",
                  getter, getter, resultCheck));
        } else {
          body.addStatement(f("{ tmp = n.%s.accept(this, arg); %s }", getter, resultCheck));
        }
      }
    }
    body.addStatement("return result;");
    Arrays.stream(new Class<?>[] {List.class, ArrayList.class})
        .filter(
            c ->
                compilationUnit.getImports().stream()
                    .noneMatch(i -> c.getName().equals(i.getName().asString())))
        .forEach(compilationUnit::addImport);
  }
}
