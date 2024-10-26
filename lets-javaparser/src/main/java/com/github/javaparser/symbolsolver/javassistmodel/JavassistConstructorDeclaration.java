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
package com.github.javaparser.symbolsolver.javassistmodel;

import com.github.javaparser.ast.AccessSpecifier;
import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedConstructorDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedParameterDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedTypeParameterDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import java.util.List;
import javassist.CtConstructor;

/**
 * @author Fred Lefévère-Laoide
 */
public class JavassistConstructorDeclaration implements ResolvedConstructorDeclaration {

  private final CtConstructor ctConstructor;

  private final TypeSolver typeSolver;

  private final JavassistMethodLikeDeclarationAdapter methodLikeAdaper;

  public JavassistConstructorDeclaration(CtConstructor ctConstructor, TypeSolver typeSolver) {
    this.ctConstructor = ctConstructor;
    this.typeSolver = typeSolver;
    this.methodLikeAdaper =
        new JavassistMethodLikeDeclarationAdapter(ctConstructor, typeSolver, this);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName()
        + "{"
        + "ctConstructor="
        + ctConstructor.getName()
        + ", typeSolver="
        + typeSolver
        + '}';
  }

  @Override
  public String getName() {
    return ctConstructor.getName();
  }

  @Override
  public boolean isField() {
    return false;
  }

  @Override
  public boolean isParameter() {
    return false;
  }

  @Override
  public boolean isType() {
    return false;
  }

  @Override
  public ResolvedReferenceTypeDeclaration declaringType() {
    return JavassistFactory.toTypeDeclaration(ctConstructor.getDeclaringClass(), typeSolver);
  }

  @Override
  public int getNumberOfParams() {
    return methodLikeAdaper.getNumberOfParams();
  }

  @Override
  public ResolvedParameterDeclaration getParam(int i) {
    return methodLikeAdaper.getParam(i);
  }

  @Override
  public List<ResolvedTypeParameterDeclaration> getTypeParameters() {
    return methodLikeAdaper.getTypeParameters();
  }

  @Override
  public AccessSpecifier accessSpecifier() {
    return JavassistFactory.modifiersToAccessLevel(ctConstructor.getModifiers());
  }

  @Override
  public int getNumberOfSpecifiedExceptions() {
    return methodLikeAdaper.getNumberOfSpecifiedExceptions();
  }

  @Override
  public ResolvedType getSpecifiedException(int index) {
    return methodLikeAdaper.getSpecifiedException(index);
  }
}
