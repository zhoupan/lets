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
package com.github.javaparser.symbolsolver.logic;

import com.github.javaparser.resolution.MethodUsage;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedTypeParameterDeclaration;
import com.github.javaparser.resolution.logic.FunctionalInterfaceLogic;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.utils.Pair;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Common ancestor for most types.
 *
 * @author Federico Tomassetti
 */
public abstract class AbstractTypeDeclaration implements ResolvedReferenceTypeDeclaration {

  /*
   * Returns all methods which have distinct "enhanced" signature declared in this type and all members.
   * An "enhanced" signature include the return type which is used sometimes to identify functional interfaces.
   * This is a different implementation from the previous one which returned all methods which have a distinct
   * signature (based on method name and qualified parameter types)
   */
  @Override
  public final Set<MethodUsage> getAllMethods() {
    Set<MethodUsage> methods = new HashSet<>();
    Set<String> methodsSignatures = new HashSet<>();
    for (ResolvedMethodDeclaration methodDeclaration : getDeclaredMethods()) {
      MethodUsage methodUsage = new MethodUsage(methodDeclaration);
      methods.add(methodUsage);
      String signature = methodUsage.getSignature();
      String returnType = methodUsage.getDeclaration().getReturnType().describe();
      String enhancedSignature = String.format("%s %s", returnType, signature);
      methodsSignatures.add(enhancedSignature);
    }
    for (ResolvedReferenceType ancestor : getAllAncestors()) {
      List<Pair<ResolvedTypeParameterDeclaration, ResolvedType>> typeParametersMap =
          ancestor.getTypeParametersMap();
      for (MethodUsage mu : ancestor.getDeclaredMethods()) {
        // replace type parameters to be able to filter away overridden generified methods
        MethodUsage methodUsage = mu;
        for (Pair<ResolvedTypeParameterDeclaration, ResolvedType> p : typeParametersMap) {
          methodUsage = methodUsage.replaceTypeParameter(p.a, p.b);
        }
        String signature = methodUsage.getSignature();
        String returnType = methodUsage.getDeclaration().getReturnType().describe();
        String enhancedSignature = String.format("%s %s", returnType, signature);
        if (!methodsSignatures.contains(enhancedSignature)) {
          methodsSignatures.add(enhancedSignature);
          methods.add(mu);
        }
      }
    }
    return methods;
  }

  @Override
  public final boolean isFunctionalInterface() {
    return FunctionalInterfaceLogic.getFunctionalMethod(this).isPresent();
  }
}
