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
package com.github.javaparser.printer.configuration;

import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import java.util.List;

public interface ImportOrderingStrategy {

  /**
   * Sort the list of imports into groups.
   *
   * <p>Consider that we have the following list of imports as argument: <br>
   *
   * <pre>
   * import java.util.List;
   * import com.github.javaparser.ast.NodeList;
   * import com.github.javaparser.ast.ImportDeclaration;
   * </pre>
   *
   * <p>And we want the imports to look like this: (Note the spacing between imports)
   *
   * <pre>
   * import java.util.List;
   *
   * import com.github.javaparser.ast.NodeList;
   * import com.github.javaparser.ast.ImportDeclaration;
   * </pre>
   *
   * <p>In this case, we have two groups of imports. The first group contains only import for
   * java.util.List, while the second group contains NodeList and ImportDeclaration.
   *
   * <p>For this example this method should return 2 groups in the list, and the first group should
   * have exactly 1 import, while the second group should have 2 imports.
   *
   * @param imports The imports to be ordered.
   * @return The group of sorted imports.
   */
  List<NodeList<ImportDeclaration>> sortImports(NodeList<ImportDeclaration> imports);

  void setSortImportsAlphabetically(boolean sortAlphabetically);

  boolean isSortImportsAlphabetically();
}
