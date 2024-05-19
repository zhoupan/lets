/*
 * Copyright (c) 2015-2016 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.symbolsolver.javaparsermodel.contexts;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.resolution.TypeSolver;
import java.util.Collections;
import java.util.List;

/**
 * @author Federico Tomassetti
 */
public class MethodContext extends AbstractMethodLikeDeclarationContext<MethodDeclaration> {

  ///
  /// Constructors
  ///

  public MethodContext(MethodDeclaration wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
  }

  @Override
  public List<Parameter> parametersExposedToChild(Node child) {
    // TODO/FIXME: Presumably the parameters must be exposed to all children and their descendants,
    // not just the direct child?
    if (wrappedNode.getBody().isPresent() && child == wrappedNode.getBody().get()) {
      return wrappedNode.getParameters();
    }
    return Collections.emptyList();
  }
}
