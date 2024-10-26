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
package com.github.javaparser.symbolsolver.javaparsermodel.contexts;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedTypeDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserTypeParameter;
import java.util.List;

/**
 * Limited version of ClassOrInterfaceDeclarationContext that only resolves type parameters for use
 * by extends and implements part of declaration.
 */
public class ClassOrInterfaceDeclarationExtendsContext
    extends AbstractJavaParserContext<ClassOrInterfaceDeclaration> {

  public ClassOrInterfaceDeclarationExtendsContext(
      ClassOrInterfaceDeclaration wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
  }

  @Override
  public SymbolReference<ResolvedTypeDeclaration> solveType(
      String name, List<ResolvedType> typeArguments) {
    for (TypeParameter typeParameter : wrappedNode.getTypeParameters()) {
      if (typeParameter.getName().getId().equals(name)) {
        return SymbolReference.solved(new JavaParserTypeParameter(typeParameter, typeSolver));
      }
    }
    return super.solveType(name, typeArguments);
  }
}
