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

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.GenericVisitor;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.generator.NodeGenerator;
import com.github.javaparser.metamodel.BaseNodeMetaModel;
import com.github.javaparser.utils.SourceRoot;

public class AcceptGenerator extends NodeGenerator {
  private final MethodDeclaration genericAccept;
  private final MethodDeclaration voidAccept;

  public AcceptGenerator(SourceRoot sourceRoot) {
    super(sourceRoot);
    genericAccept =
        parseBodyDeclaration(
                "@Override public <R, A> R accept(final GenericVisitor<R, A> v, final A arg) { return v.visit(this, arg); }")
            .asMethodDeclaration();
    voidAccept =
        parseBodyDeclaration(
                "@Override public <A> void accept(final VoidVisitor<A> v, final A arg) { v.visit(this, arg); }")
            .asMethodDeclaration();
  }

  @Override
  protected void generateNode(
      BaseNodeMetaModel nodeMetaModel,
      CompilationUnit nodeCu,
      ClassOrInterfaceDeclaration nodeCoid) {
    if (nodeMetaModel.isAbstract()) {
      return;
    }
    nodeCu.addImport(GenericVisitor.class);
    nodeCu.addImport(VoidVisitor.class);
    addOrReplaceWhenSameSignature(nodeCoid, genericAccept);
    addOrReplaceWhenSameSignature(nodeCoid, voidAccept);
  }
}
