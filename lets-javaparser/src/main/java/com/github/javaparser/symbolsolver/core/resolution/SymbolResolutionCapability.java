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
package com.github.javaparser.symbolsolver.core.resolution;

import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;

/**
 * Allows for an implementing declaration type to support solving for field <i>(symbol)</i> usage.
 */
public interface SymbolResolutionCapability {

  /**
   * @param name Field / symbol name.
   * @param typeSolver Symbol solver to resolve type usage.
   * @return Symbol reference of the resolved value.
   */
  SymbolReference<? extends ResolvedValueDeclaration> solveSymbol(
      String name, TypeSolver typeSolver);
}
