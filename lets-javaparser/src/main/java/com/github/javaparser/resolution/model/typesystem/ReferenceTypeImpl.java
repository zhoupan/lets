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
package com.github.javaparser.resolution.model.typesystem;

import com.github.javaparser.resolution.MethodUsage;
import com.github.javaparser.resolution.declarations.ResolvedFieldDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedTypeParameterDeclaration;
import com.github.javaparser.resolution.logic.FunctionalInterfaceLogic;
import com.github.javaparser.resolution.model.LambdaArgumentTypePlaceholder;
import com.github.javaparser.resolution.types.ResolvedReferenceType;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.resolution.types.ResolvedTypeTransformer;
import com.github.javaparser.resolution.types.ResolvedTypeVariable;
import com.github.javaparser.resolution.types.parametrization.ResolvedTypeParametersMap;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Federico Tomassetti
 */
public class ReferenceTypeImpl extends ResolvedReferenceType {

  private static final String[] ASSIGNABLE_REFERENCE_TYPE = {
    "java.lang.Object", "java.lang.Cloneable", "java.io.Serializable"
  };

  public static ResolvedReferenceType undeterminedParameters(
      ResolvedReferenceTypeDeclaration typeDeclaration) {
    return new ReferenceTypeImpl(
        typeDeclaration,
        typeDeclaration.getTypeParameters().stream()
            .map(ResolvedTypeVariable::new)
            .collect(Collectors.toList()));
  }

  @Override
  protected ResolvedReferenceType create(
      ResolvedReferenceTypeDeclaration typeDeclaration,
      List<ResolvedType> typeParametersCorrected) {
    return new ReferenceTypeImpl(typeDeclaration, typeParametersCorrected);
  }

  @Override
  protected ResolvedReferenceType create(ResolvedReferenceTypeDeclaration typeDeclaration) {
    return new ReferenceTypeImpl(typeDeclaration);
  }

  public ReferenceTypeImpl(ResolvedReferenceTypeDeclaration typeDeclaration) {
    super(typeDeclaration);
  }

  public ReferenceTypeImpl(
      ResolvedReferenceTypeDeclaration typeDeclaration, List<ResolvedType> typeArguments) {
    super(typeDeclaration, typeArguments);
  }

  @Override
  public ResolvedTypeParameterDeclaration asTypeParameter() {
    return this.typeDeclaration.asTypeParameter();
  }

  /** This method checks if ThisType t = new OtherType() would compile. */
  @Override
  public boolean isAssignableBy(ResolvedType other) {
    if (other instanceof NullType) {
      return !this.isPrimitive();
    }
    // everything is assignable to Object except void
    if (!other.isVoid() && this.isJavaLangObject()) {
      return true;
    }
    // consider boxing
    if (other.isPrimitive()) {
      if (this.isJavaLangObject()) {
        return true;
      }
      // Check if 'other' can be boxed to match this type
      if (isCorrespondingBoxingType(other.describe())) return true;
      // All numeric types extend Number
      return other.isNumericType()
          && this.isReferenceType()
          && this.asReferenceType().getQualifiedName().equals(Number.class.getCanonicalName());
    }
    if (other instanceof LambdaArgumentTypePlaceholder) {
      return FunctionalInterfaceLogic.isFunctionalInterfaceType(this);
    }
    if (other.isReferenceType()) {
      ResolvedReferenceType otherRef = other.asReferenceType();
      if (compareConsideringTypeParameters(otherRef)) {
        return true;
      }
      for (ResolvedReferenceType otherAncestor : otherRef.getAllAncestors()) {
        if (compareConsideringTypeParameters(otherAncestor)) {
          return true;
        }
      }
      return false;
    }
    if (other.isTypeVariable()) {
      for (ResolvedTypeParameterDeclaration.Bound bound :
          other.asTypeVariable().asTypeParameter().getBounds()) {
        if (bound.isExtends()) {
          if (this.isAssignableBy(bound.getType())) {
            return true;
          }
        }
      }
      return false;
    }
    if (other.isConstraint()) {
      return isAssignableBy(other.asConstraintType().getBound());
    }
    if (other.isWildcard()) {
      if (this.isJavaLangObject()) {
        return true;
      }
      if (other.asWildcard().isExtends()) {
        return isAssignableBy(other.asWildcard().getBoundedType());
      }
      return false;
    }
    if (other.isUnionType()) {
      Optional<ResolvedReferenceType> common = other.asUnionType().getCommonAncestor();
      return common.map(ancestor -> isAssignableBy(ancestor)).orElse(false);
    }
    // An array can be assigned only to a variable of a compatible array type,
    // or to a variable of type Object, Cloneable or java.io.Serializable.
    if (other.isArray()) {
      return isAssignableByReferenceType(getQualifiedName());
    }
    return false;
  }

  private boolean isAssignableByReferenceType(String qname) {
    return Stream.of(ASSIGNABLE_REFERENCE_TYPE).anyMatch(ref -> ref.equals(qname));
  }

  @Override
  public Set<MethodUsage> getDeclaredMethods() {
    // TODO replace variables
    Set<MethodUsage> methods = new HashSet<>();
    getTypeDeclaration()
        .ifPresent(
            referenceTypeDeclaration -> {
              for (ResolvedMethodDeclaration methodDeclaration :
                  referenceTypeDeclaration.getDeclaredMethods()) {
                MethodUsage methodUsage = new MethodUsage(methodDeclaration);
                methods.add(methodUsage);
              }
            });
    return methods;
  }

  @Override
  public ResolvedType toRawType() {
    if (this.isRawType()) {
      return this;
    }
    return new ReferenceTypeImpl(typeDeclaration, Collections.emptyList());
  }

  @Override
  public boolean mention(List<ResolvedTypeParameterDeclaration> typeParameters) {
    return typeParametersValues().stream().anyMatch(tp -> tp.mention(typeParameters));
  }

  /** Execute a transformation on all the type parameters of this element. */
  @Override
  public ResolvedType transformTypeParameters(ResolvedTypeTransformer transformer) {
    ResolvedType result = this;
    int i = 0;
    for (ResolvedType tp : this.typeParametersValues()) {
      ResolvedType transformedTp = transformer.transform(tp);
      // Identity comparison on purpose
      if (transformedTp != tp) {
        List<ResolvedType> typeParametersCorrected =
            result.asReferenceType().typeParametersValues();
        typeParametersCorrected.set(i, transformedTp);
        result = create(typeDeclaration, typeParametersCorrected);
      }
      i++;
    }
    return result;
  }

  /*
   * Get all ancestors with the default traverser (depth first)
   */
  @Override
  public List<ResolvedReferenceType> getAllAncestors() {
    return getAllAncestors(ResolvedReferenceTypeDeclaration.depthFirstFunc);
  }

  @Override
  public List<ResolvedReferenceType> getAllAncestors(
      Function<ResolvedReferenceTypeDeclaration, List<ResolvedReferenceType>> traverser) {
    // We need to go through the inheritance line and propagate the type parameters
    List<ResolvedReferenceType> ancestors = typeDeclaration.getAllAncestors(traverser);
    ancestors =
        ancestors.stream()
            .map(a -> typeParametersMap().replaceAll(a).asReferenceType())
            .collect(Collectors.toList());
    return ancestors;
  }

  @Override
  public List<ResolvedReferenceType> getDirectAncestors() {
    // We need to go through the inheritance line and propagate the type parameters
    List<ResolvedReferenceType> ancestors = typeDeclaration.getAncestors();
    ancestors =
        ancestors.stream()
            .map(a -> typeParametersMap().replaceAll(a).asReferenceType())
            .collect(Collectors.toList());
    // Conditionally re-insert java.lang.Object as an ancestor.
    if (this.getTypeDeclaration().isPresent()) {
      ResolvedReferenceTypeDeclaration thisTypeDeclaration = this.getTypeDeclaration().get();
      // The superclass of interfaces is always null
      if (thisTypeDeclaration.isClass()) {
        Optional<ResolvedReferenceType> optionalSuperClass =
            thisTypeDeclaration.asClass().getSuperClass();
        boolean superClassIsJavaLangObject =
            optionalSuperClass.isPresent() && optionalSuperClass.get().isJavaLangObject();
        boolean thisIsJavaLangObject = thisTypeDeclaration.asClass().isJavaLangObject();
        if (superClassIsJavaLangObject && !thisIsJavaLangObject) {
          ancestors.add(optionalSuperClass.get());
        }
      }
    }
    return ancestors;
  }

  @Override
  public ResolvedReferenceType deriveTypeParameters(ResolvedTypeParametersMap typeParametersMap) {
    return create(typeDeclaration, typeParametersMap);
  }

  @Override
  public Set<ResolvedFieldDeclaration> getDeclaredFields() {
    Set<ResolvedFieldDeclaration> allFields = new LinkedHashSet<>();
    if (getTypeDeclaration().isPresent()) {
      allFields.addAll(getTypeDeclaration().get().getDeclaredFields());
    }
    return allFields;
  }
}
