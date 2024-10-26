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
package com.github.javaparser.resolution;

import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.model.SymbolReference;

/**
 * An element able to find TypeDeclaration from their name. TypeSolvers are organized in
 * hierarchies.
 *
 * @author Federico Tomassetti
 */
public interface TypeSolver {

  String JAVA_LANG_OBJECT = Object.class.getCanonicalName();

  /** Get the root of the hierarchy of type solver. */
  default TypeSolver getRoot() {
    if (getParent() == null) {
      return this;
    }
    return getParent().getRoot();
  }

  /** Parent of the this TypeSolver. This can return null. */
  TypeSolver getParent();

  /** Set the parent of this TypeSolver. */
  void setParent(TypeSolver parent);

  /**
   * Try to solve the type with the given name. It always return a SymbolReference which can be
   * solved or unsolved.
   */
  SymbolReference<ResolvedReferenceTypeDeclaration> tryToSolveType(String name);

  /**
   * Solve the given type. Either the type is found and returned or an UnsolvedSymbolException is
   * thrown.
   */
  default ResolvedReferenceTypeDeclaration solveType(String name) throws UnsolvedSymbolException {
    SymbolReference<ResolvedReferenceTypeDeclaration> ref = tryToSolveType(name);
    if (ref.isSolved()) {
      return ref.getCorrespondingDeclaration();
    }
    throw new UnsolvedSymbolException(name, this.toString());
  }

  /**
   * @return A resolved reference to {@code java.lang.Object}
   */
  default ResolvedReferenceTypeDeclaration getSolvedJavaLangObject()
      throws UnsolvedSymbolException {
    return solveType(JAVA_LANG_OBJECT);
  }

  default boolean hasType(String name) {
    return tryToSolveType(name).isSolved();
  }
}
