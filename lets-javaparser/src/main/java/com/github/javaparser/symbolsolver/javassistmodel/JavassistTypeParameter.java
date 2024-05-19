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

import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedMethodLikeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedTypeParameterDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedTypeParametrizable;
import com.github.javaparser.resolution.model.typesystem.ReferenceTypeImpl;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javassist.bytecode.SignatureAttribute;

/**
 * @author Federico Tomassetti
 */
public class JavassistTypeParameter implements ResolvedTypeParameterDeclaration {

  private SignatureAttribute.TypeParameter wrapped;
  private TypeSolver typeSolver;
  private ResolvedTypeParametrizable container;

  public JavassistTypeParameter(
      SignatureAttribute.TypeParameter wrapped,
      ResolvedTypeParametrizable container,
      TypeSolver typeSolver) {
    this.wrapped = wrapped;
    this.typeSolver = typeSolver;
    this.container = container;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ResolvedTypeParameterDeclaration)) return false;

    ResolvedTypeParameterDeclaration that = (ResolvedTypeParameterDeclaration) o;

    if (!getQualifiedName().equals(that.getQualifiedName())) {
      return false;
    }
    if (declaredOnType() == that.declaredOnType()) {
      return true;
    }
    // TODO check bounds
    return declaredOnMethod() == that.declaredOnMethod();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getQualifiedName(), declaredOnType(), declaredOnMethod());
  }

  @Override
  public String toString() {
    return "JavassistTypeParameter{" + wrapped.getName() + '}';
  }

  @Override
  public String getName() {
    return wrapped.getName();
  }

  @Override
  public String getContainerQualifiedName() {
    if (this.container instanceof ResolvedReferenceTypeDeclaration) {
      return ((ResolvedReferenceTypeDeclaration) this.container).getQualifiedName();
    }
    if (this.container instanceof ResolvedMethodLikeDeclaration) {
      return ((ResolvedMethodLikeDeclaration) this.container).getQualifiedName();
    }
    throw new UnsupportedOperationException();
  }

  @Override
  public String getContainerId() {
    return getContainerQualifiedName();
  }

  @Override
  public ResolvedTypeParametrizable getContainer() {
    return this.container;
  }

  @Override
  public List<ResolvedTypeParameterDeclaration.Bound> getBounds() {
    List<Bound> bounds = new ArrayList<>();
    SignatureAttribute.ObjectType classBound = wrapped.getClassBound();
    if (classBound != null) {
      bounds.add(
          Bound.extendsBound(
              JavassistUtils.signatureTypeToType(classBound, typeSolver, getContainer())));
    }
    for (SignatureAttribute.ObjectType ot : wrapped.getInterfaceBound()) {
      bounds.add(
          Bound.extendsBound(JavassistUtils.signatureTypeToType(ot, typeSolver, getContainer())));
    }
    return bounds;
  }

  @Override
  public Optional<ResolvedReferenceTypeDeclaration> containerType() {
    if (container instanceof ResolvedReferenceTypeDeclaration) {
      return Optional.of((ResolvedReferenceTypeDeclaration) container);
    }
    return Optional.empty();
  }

  @Override
  public ResolvedReferenceType object() {
    return new ReferenceTypeImpl(typeSolver.getSolvedJavaLangObject());
  }
}
