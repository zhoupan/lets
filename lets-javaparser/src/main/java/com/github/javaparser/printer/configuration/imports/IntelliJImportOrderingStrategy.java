/*
 * Copyright (c) 2013-2024 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.printer.configuration.imports;

import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import com.github.javaparser.printer.configuration.ImportOrderingStrategy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntelliJImportOrderingStrategy implements ImportOrderingStrategy {

  private boolean sortImportsAlphabetically = false;

  @Override
  public List<NodeList<ImportDeclaration>> sortImports(NodeList<ImportDeclaration> nodes) {
    NodeList<ImportDeclaration> otherImports = new NodeList<>();
    NodeList<ImportDeclaration> javaImports = new NodeList<>();
    NodeList<ImportDeclaration> staticImports = new NodeList<>();
    for (ImportDeclaration importDeclaration : nodes) {
      // Check if is a static import
      if (importDeclaration.isStatic()) {
        staticImports.add(importDeclaration);
        continue;
      }
      String importName = importDeclaration.getNameAsString();
      if (importName.startsWith("java.") || importName.startsWith("javax.")) {
        javaImports.add(importDeclaration);
      } else {
        otherImports.add(importDeclaration);
      }
    }
    if (sortImportsAlphabetically) {
      Comparator<ImportDeclaration> sortLogic = Comparator.comparing(NodeWithName::getNameAsString);
      otherImports.sort(sortLogic);
      javaImports.sort(sortLogic);
      staticImports.sort(sortLogic);
    }
    return Arrays.asList(otherImports, javaImports, staticImports);
  }

  @Override
  public void setSortImportsAlphabetically(boolean sortAlphabetically) {
    sortImportsAlphabetically = sortAlphabetically;
  }

  @Override
  public boolean isSortImportsAlphabetically() {
    return sortImportsAlphabetically;
  }
}
