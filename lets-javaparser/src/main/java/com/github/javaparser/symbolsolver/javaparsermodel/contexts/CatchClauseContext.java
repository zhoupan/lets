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
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.resolution.SymbolDeclarator;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.resolution.model.Value;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFactory;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Fred Lefévère-Laoide
 */
public class CatchClauseContext extends AbstractJavaParserContext<CatchClause> {

  public CatchClauseContext(CatchClause wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
  }

  @Override
  public final SymbolReference<? extends ResolvedValueDeclaration> solveSymbol(String name) {
    SymbolDeclarator sb =
        JavaParserFactory.getSymbolDeclarator(wrappedNode.getParameter(), typeSolver);
    SymbolReference<? extends ResolvedValueDeclaration> symbolReference =
        AbstractJavaParserContext.solveWith(sb, name);
    if (symbolReference.isSolved()) {
      return symbolReference;
    }
    // if nothing is found we should ask the parent context
    return solveSymbolInParentContext(name);
  }

  @Override
  public final Optional<Value> solveSymbolAsValue(String name) {
    SymbolDeclarator sb =
        JavaParserFactory.getSymbolDeclarator(wrappedNode.getParameter(), typeSolver);
    Optional<Value> symbolReference = solveWithAsValue(sb, name);
    if (symbolReference.isPresent()) {
      // Perform parameter type substitution as needed
      return symbolReference;
    }
    // if nothing is found we should ask the parent context
    return solveSymbolAsValueInParentContext(name);
  }

  @Override
  public final SymbolReference<ResolvedMethodDeclaration> solveMethod(
      String name, List<ResolvedType> argumentsTypes, boolean staticOnly) {
    // TODO: Document why staticOnly is forced to be false.
    return solveMethodInParentContext(name, argumentsTypes, false);
  }

  @Override
  public List<VariableDeclarator> localVariablesExposedToChild(Node child) {
    return Collections.emptyList();
  }

  @Override
  public List<Parameter> parametersExposedToChild(Node child) {
    // TODO/FIXME: Presumably the parameters must be exposed to all children and their descendants,
    // not just the direct child?
    if (child == getWrappedNode().getBody()) {
      return Collections.singletonList(getWrappedNode().getParameter());
    }
    return Collections.emptyList();
  }
}
