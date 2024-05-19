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
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedTypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFactory;
import java.util.List;

/**
 * @author Federico Tomassetti
 */
public class ObjectCreationContext extends AbstractJavaParserContext<ObjectCreationExpr> {

  public ObjectCreationContext(ObjectCreationExpr wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
  }

  @Override
  public SymbolReference<ResolvedTypeDeclaration> solveType(
      String name, List<ResolvedType> typeArguments) {
    if (wrappedNode.hasScope()) {
      Expression scope = wrappedNode.getScope().get();
      ResolvedType scopeType = JavaParserFacade.get(typeSolver).getType(scope);
      // Be careful, the scope can be an object creation expression like <code>new inner().new
      // Other()</code>
      if (scopeType.isReferenceType()
          && scopeType.asReferenceType().getTypeDeclaration().isPresent()) {
        ResolvedReferenceTypeDeclaration scopeTypeDeclaration =
            scopeType.asReferenceType().getTypeDeclaration().get();
        for (ResolvedTypeDeclaration it : scopeTypeDeclaration.internalTypes()) {
          if (it.getName().equals(name)) {
            return SymbolReference.solved(it);
          }
        }
      }
    }
    // find first parent node that is not an object creation expression to avoid stack overflow
    // errors, see #1711
    Node parentNode = demandParentNode(wrappedNode);
    while (parentNode instanceof ObjectCreationExpr) {
      parentNode = demandParentNode(parentNode);
    }
    return JavaParserFactory.getContext(parentNode, typeSolver).solveType(name, typeArguments);
  }

  @Override
  public SymbolReference<? extends ResolvedValueDeclaration> solveSymbol(String name) {
    return JavaParserFactory.getContext(demandParentNode(wrappedNode), typeSolver)
        .solveSymbol(name);
  }

  @Override
  public SymbolReference<ResolvedMethodDeclaration> solveMethod(
      String name, List<ResolvedType> argumentsTypes, boolean staticOnly) {
    return JavaParserFactory.getContext(demandParentNode(wrappedNode), typeSolver)
        .solveMethod(name, argumentsTypes, false);
  }
}
