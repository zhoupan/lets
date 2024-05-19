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

import static com.github.javaparser.resolution.Navigator.demandParentNode;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserSymbolDeclaration;
import java.util.Collections;
import java.util.List;

public class ForEachStatementContext extends AbstractJavaParserContext<ForEachStmt> {

  public ForEachStatementContext(ForEachStmt wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
  }

  @Override
  public SymbolReference<? extends ResolvedValueDeclaration> solveSymbol(String name) {
    if (wrappedNode.getVariable().getVariables().size() != 1) {
      throw new IllegalStateException();
    }
    VariableDeclarator variableDeclarator = wrappedNode.getVariable().getVariables().get(0);
    if (variableDeclarator.getName().getId().equals(name)) {
      return SymbolReference.solved(
          JavaParserSymbolDeclaration.localVar(variableDeclarator, typeSolver));
    }
    if (demandParentNode(wrappedNode) instanceof BlockStmt) {
      return StatementContext.solveInBlock(name, typeSolver, wrappedNode);
    }
    return solveSymbolInParentContext(name);
  }

  @Override
  public SymbolReference<ResolvedMethodDeclaration> solveMethod(
      String name, List<ResolvedType> argumentsTypes, boolean staticOnly) {
    // TODO: Document why staticOnly is forced to be false.
    return solveMethodInParentContext(name, argumentsTypes, false);
  }

  @Override
  public List<VariableDeclarator> localVariablesExposedToChild(Node child) {
    if (child == wrappedNode.getBody()) {
      return wrappedNode.getVariable().getVariables();
    }
    return Collections.emptyList();
  }
}
