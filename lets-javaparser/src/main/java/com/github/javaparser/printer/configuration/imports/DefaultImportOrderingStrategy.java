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

import static java.util.Comparator.comparingInt;

import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.nodeTypes.NodeWithName;
import com.github.javaparser.printer.configuration.ImportOrderingStrategy;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultImportOrderingStrategy implements ImportOrderingStrategy {

  private boolean sortImportsAlphabetically = false;

  @Override
  public List<NodeList<ImportDeclaration>> sortImports(NodeList<ImportDeclaration> nodes) {

    if (sortImportsAlphabetically) {
      Comparator<ImportDeclaration> sortLogic =
          comparingInt((ImportDeclaration i) -> i.isStatic() ? 0 : 1)
              .thenComparing(NodeWithName::getNameAsString);
      nodes.sort(sortLogic);
    }

    return Collections.singletonList(nodes);
  }

  @Override
  public void setSortImportsAlphabetically(boolean sortImportsAlphabetically) {
    this.sortImportsAlphabetically = sortImportsAlphabetically;
  }

  @Override
  public boolean isSortImportsAlphabetically() {
    return sortImportsAlphabetically;
  }
}
