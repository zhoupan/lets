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
import static com.github.javaparser.utils.Utils.capitalize;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.generator.NodeGenerator;
import com.github.javaparser.metamodel.BaseNodeMetaModel;
import com.github.javaparser.metamodel.PropertyMetaModel;
import com.github.javaparser.utils.SourceRoot;

public class RemoveMethodGenerator extends NodeGenerator {

  public RemoveMethodGenerator(SourceRoot sourceRoot) {
    super(sourceRoot);
  }

  @Override
  protected void generateNode(
      BaseNodeMetaModel nodeMetaModel,
      CompilationUnit nodeCu,
      ClassOrInterfaceDeclaration nodeCoid) {
    MethodDeclaration removeNodeMethod =
        (MethodDeclaration) parseBodyDeclaration("public boolean remove(Node node) {}");
    nodeCu.addImport(Node.class);
    annotateWhenOverridden(nodeMetaModel, removeNodeMethod);
    final BlockStmt body = removeNodeMethod.getBody().get();
    body.addStatement("if (node == null) { return false; }");
    int numberPropertiesDeclared = 0;
    for (PropertyMetaModel property : nodeMetaModel.getDeclaredPropertyMetaModels()) {
      if (!property.isNode()) {
        continue;
      }
      String check;
      if (property.isNodeList()) {
        check = nodeListCheck(property);
      } else {
        if (property.isRequired()) {
          continue;
        }
        String removeAttributeMethodName =
            generateRemoveMethodForAttribute(nodeCoid, nodeMetaModel, property);
        check = attributeCheck(property, removeAttributeMethodName);
      }
      if (property.isOptional()) {
        check = f("if (%s != null) { %s }", property.getName(), check);
      }
      body.addStatement(check);
      numberPropertiesDeclared++;
    }
    if (nodeMetaModel.getSuperNodeMetaModel().isPresent()) {
      body.addStatement("return super.remove(node);");
    } else {
      body.addStatement("return false;");
    }
    if (!nodeMetaModel.isRootNode() && numberPropertiesDeclared == 0) {
      removeMethodWithSameSignature(nodeCoid, removeNodeMethod);
    } else {
      addOrReplaceWhenSameSignature(nodeCoid, removeNodeMethod);
    }
  }

  private String attributeCheck(PropertyMetaModel property, String removeAttributeMethodName) {
    return f(
        "if (node == %s) {" + "    %s();" + "    return true;\n" + "}",
        property.getName(), removeAttributeMethodName);
  }

  private String nodeListCheck(PropertyMetaModel property) {
    return f(
        "for (int i = 0; i < %s.size(); i++) {"
            + "  if (%s.get(i) == node) {"
            + "    %s.remove(i);"
            + "    return true;"
            + "  }"
            + "}",
        property.getName(), property.getName(), property.getName());
  }

  private String generateRemoveMethodForAttribute(
      ClassOrInterfaceDeclaration nodeCoid,
      BaseNodeMetaModel nodeMetaModel,
      PropertyMetaModel property) {
    final String methodName = "remove" + capitalize(property.getName());
    final MethodDeclaration removeMethod =
        (MethodDeclaration)
            parseBodyDeclaration(f("public %s %s() {}", nodeMetaModel.getTypeName(), methodName));
    final BlockStmt block = removeMethod.getBody().get();
    block.addStatement(
        f(
            "return %s((%s) null);",
            property.getSetterMethodName(), property.getTypeNameForSetter()));
    addOrReplaceWhenSameSignature(nodeCoid, removeMethod);
    return methodName;
  }
}
