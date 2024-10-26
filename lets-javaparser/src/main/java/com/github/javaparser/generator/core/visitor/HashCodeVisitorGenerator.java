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

import static com.github.javaparser.StaticJavaParser.parseStatement;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.generator.VisitorGenerator;
import com.github.javaparser.metamodel.BaseNodeMetaModel;
import com.github.javaparser.metamodel.PropertyMetaModel;
import com.github.javaparser.utils.SeparatedItemStringBuilder;
import com.github.javaparser.utils.SourceRoot;
import java.util.List;

/** Generates JavaParser's HashCodeVisitor. */
public class HashCodeVisitorGenerator extends VisitorGenerator {

  public HashCodeVisitorGenerator(SourceRoot sourceRoot) {
    super(
        sourceRoot,
        "com.github.javaparser.ast.visitor",
        "HashCodeVisitor",
        "Integer",
        "Void",
        true);
  }

  @Override
  protected void generateVisitMethodBody(
      BaseNodeMetaModel node, MethodDeclaration visitMethod, CompilationUnit compilationUnit) {
    visitMethod.getParameters().forEach(p -> p.setFinal(true));
    final BlockStmt body = visitMethod.getBody().get();
    body.getStatements().clear();
    final SeparatedItemStringBuilder builder =
        new SeparatedItemStringBuilder("return ", "* 31 +", ";");
    final List<PropertyMetaModel> propertyMetaModels = node.getAllPropertyMetaModels();
    if (propertyMetaModels.isEmpty()) {
      builder.append("0");
    } else {
      for (PropertyMetaModel field : propertyMetaModels) {
        final String getter = field.getGetterMethodName() + "()";
        // Is this field another AST node? Visit it.
        if (field.getNodeReference().isPresent()) {
          if (field.isOptional()) {
            builder.append("(n.%s.isPresent()? n.%s.get().accept(this, arg):0)", getter, getter);
          } else {
            builder.append("(n.%s.accept(this, arg))", getter);
          }
        } else {
          Class<?> type = field.getType();
          if (type.equals(boolean.class)) {
            builder.append("(n.%s?1:0)", getter);
          } else if (type.equals(int.class)) {
            builder.append("n.%s", getter);
          } else {
            builder.append("(n.%s.hashCode())", getter);
          }
        }
      }
    }
    body.addStatement(parseStatement(builder.toString()));
  }
}
