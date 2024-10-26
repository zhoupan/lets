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

import com.github.javaparser.ast.body.AnnotationDeclaration;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedTypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedValueDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserAnnotationDeclaration;
import java.util.List;

/**
 * @author Takeshi D. Itoh
 */
public class AnnotationDeclarationContext extends AbstractJavaParserContext<AnnotationDeclaration> {

  private JavaParserTypeDeclarationAdapter javaParserTypeDeclarationAdapter;

  public AnnotationDeclarationContext(AnnotationDeclaration wrappedNode, TypeSolver typeSolver) {
    super(wrappedNode, typeSolver);
    this.javaParserTypeDeclarationAdapter =
        new JavaParserTypeDeclarationAdapter(wrappedNode, typeSolver, getDeclaration(), this);
  }

  @Override
  public SymbolReference<? extends ResolvedValueDeclaration> solveSymbol(String name) {
    if (typeSolver == null) throw new IllegalArgumentException();
    if (this.getDeclaration().hasField(name)) {
      return SymbolReference.solved(this.getDeclaration().getField(name));
    }
    // then to parent
    return solveSymbolInParentContext(name);
  }

  @Override
  public SymbolReference<ResolvedTypeDeclaration> solveType(
      String name, List<ResolvedType> resolvedTypes) {
    return javaParserTypeDeclarationAdapter.solveType(name, resolvedTypes);
  }

  @Override
  public SymbolReference<ResolvedMethodDeclaration> solveMethod(
      String name, List<ResolvedType> argumentsTypes, boolean staticOnly) {
    return javaParserTypeDeclarationAdapter.solveMethod(name, argumentsTypes, staticOnly);
  }

  ///
  /// Private methods
  ///
  private ResolvedReferenceTypeDeclaration getDeclaration() {
    return new JavaParserAnnotationDeclaration(this.wrappedNode, typeSolver);
  }
}
