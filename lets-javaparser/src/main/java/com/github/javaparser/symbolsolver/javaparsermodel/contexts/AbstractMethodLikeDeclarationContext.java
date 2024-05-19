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
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.nodeTypes.NodeWithParameters;
import com.github.javaparser.ast.nodeTypes.NodeWithTypeParameters;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.resolution.SymbolDeclarator;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedTypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.resolution.model.Value;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.resolution.types.ResolvedTypeVariable;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFactory;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserTypeParameter;
import java.util.List;
import java.util.Optional;

/**
 * @author Federico Tomassetti
 */
public abstract class AbstractMethodLikeDeclarationContext<
        T extends Node & NodeWithParameters<T> & NodeWithTypeParameters<T>>
    extends AbstractJavaParserContext<T> {

  public AbstractMethodLikeDeclarationContext(T wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
  }

  @Override
  public final SymbolReference<? extends ResolvedValueDeclaration> solveSymbol(String name) {
    for (Parameter parameter : wrappedNode.getParameters()) {
      SymbolDeclarator sb = JavaParserFactory.getSymbolDeclarator(parameter, typeSolver);
      SymbolReference<? extends ResolvedValueDeclaration> symbolReference =
          AbstractJavaParserContext.solveWith(sb, name);
      if (symbolReference.isSolved()) {
        return symbolReference;
      }
    }

    // if nothing is found we should ask the parent context
    return solveSymbolInParentContext(name);
  }

  @Override
  public final Optional<ResolvedType> solveGenericType(String name) {
    // First check if the method-like declaration has type parameters defined.
    // For example: {@code public <T> boolean containsAll(Collection<T> c);}
    for (TypeParameter tp : wrappedNode.getTypeParameters()) {
      if (tp.getName().getId().equals(name)) {
        return Optional.of(new ResolvedTypeVariable(new JavaParserTypeParameter(tp, typeSolver)));
      }
    }

    // If no generic types on the method declaration, continue to solve elsewhere as usual.
    return solveGenericTypeInParentContext(name);
  }

  @Override
  public final Optional<Value> solveSymbolAsValue(String name) {
    for (Parameter parameter : wrappedNode.getParameters()) {
      SymbolDeclarator sb = JavaParserFactory.getSymbolDeclarator(parameter, typeSolver);
      Optional<Value> symbolReference = solveWithAsValue(sb, name);
      if (symbolReference.isPresent()) {
        // Perform parameter type substitution as needed
        return symbolReference;
      }
    }

    // if nothing is found we should ask the parent context
    return solveSymbolAsValueInParentContext(name);
  }

  @Override
  public final SymbolReference<ResolvedTypeDeclaration> solveType(
      String name, List<ResolvedType> typeArguments) {
    // TODO: Is null check required?
    if (wrappedNode.getTypeParameters() != null) {
      for (TypeParameter tp : wrappedNode.getTypeParameters()) {
        if (tp.getName().getId().equals(name)) {
          return SymbolReference.solved(new JavaParserTypeParameter(tp, typeSolver));
        }
      }
    }

    // Local types
    List<TypeDeclaration> localTypes = wrappedNode.findAll(TypeDeclaration.class);
    for (TypeDeclaration<?> localType : localTypes) {
      if (localType.getName().getId().equals(name)) {
        return SymbolReference.solved(
            JavaParserFacade.get(typeSolver).getTypeDeclaration(localType));
      }
      if (name.startsWith(String.format("%s.", localType.getName()))) {
        return JavaParserFactory.getContext(localType, typeSolver)
            .solveType(name.substring(localType.getName().getId().length() + 1));
      }
    }

    return solveTypeInParentContext(name, typeArguments);
  }

  @Override
  public final SymbolReference<ResolvedMethodDeclaration> solveMethod(
      String name, List<ResolvedType> argumentsTypes, boolean staticOnly) {
    // TODO: Document why staticOnly is forced to be false.
    return solveMethodInParentContext(name, argumentsTypes, false);
  }
}
