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
import com.github.javaparser.metamodel.CompilationUnitMetaModel;
import com.github.javaparser.metamodel.PropertyMetaModel;
import com.github.javaparser.utils.SeparatedItemStringBuilder;
import com.github.javaparser.utils.SourceRoot;

/** Generates JavaParser's CloneVisitor. */
public class CloneVisitorGenerator extends VisitorGenerator {

  public CloneVisitorGenerator(SourceRoot sourceRoot) {
    super(
        sourceRoot,
        "com.github.javaparser.ast.visitor",
        "CloneVisitor",
        "Visitable",
        "Object",
        true);
  }

  @Override
  protected void generateVisitMethodBody(
      BaseNodeMetaModel node, MethodDeclaration visitMethod, CompilationUnit compilationUnit) {
    visitMethod.getParameters().forEach(p -> p.setFinal(true));
    BlockStmt body = visitMethod.getBody().get();
    body.getStatements().clear();
    for (PropertyMetaModel field : node.getAllPropertyMetaModels()) {
      final String getter = field.getGetterMethodName() + "()";
      if (field.getNodeReference().isPresent()) {
        if (field.isOptional() && field.isNodeList()) {
          body.addStatement(
              f(
                  "NodeList<%s> %s = cloneList(n.%s.orElse(null), arg);",
                  field.getTypeNameGenerified(), field.getName(), getter));
        } else if (field.isNodeList()) {
          body.addStatement(
              f(
                  "NodeList<%s> %s = cloneList(n.%s, arg);",
                  field.getTypeNameGenerified(), field.getName(), getter));
        } else {
          body.addStatement(
              f(
                  "%s %s = cloneNode(n.%s, arg);",
                  field.getTypeNameGenerified(), field.getName(), getter));
        }
      }
    }
    SeparatedItemStringBuilder builder =
        new SeparatedItemStringBuilder(
            f("%s r = new %s(", node.getTypeNameGenerified(), node.getTypeNameGenerified()),
            ",",
            ");");
    builder.append("n.getTokenRange().orElse(null)");
    for (PropertyMetaModel field : node.getConstructorParameters()) {
      if ("comment".equals(field.getName())) {
        continue;
      }
      if (field.getNodeReference().isPresent()) {
        builder.append(field.getName());
      } else {
        builder.append(f("n.%s()", field.getGetterMethodName()));
      }
    }
    body.addStatement(builder.toString());
    if (node instanceof CompilationUnitMetaModel) {
      body.addStatement(
          "n.getStorage().ifPresent(s -> r.setStorage(s.getPath(), s.getEncoding()));");
    }
    body.addStatement("r.setComment(comment);");
    body.addStatement(
        "n.getOrphanComments().stream().map(Comment::clone).forEach(r::addOrphanComment);");
    body.addStatement("copyData(n, r);");
    body.addStatement("return r;");
  }
}
