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
package com.github.javaparser.resolution.declarations;

import com.github.javaparser.resolution.types.ResolvedReferenceType;
import java.util.List;
import java.util.Optional;

/**
 * Declaration of a Class (not an interface or an enum).
 *
 * <p>Note that it can be associated to a Node AST because anonymous class declarations return an
 * incompatible node type, compared to classic class declarations.
 *
 * @author Federico Tomassetti
 */
public interface ResolvedClassDeclaration
    extends ResolvedReferenceTypeDeclaration, ResolvedTypeParametrizable, HasAccessSpecifier {

  /** This method should always return true. */
  @Override
  default boolean isClass() {
    return true;
  }

  /**
   * This is a ReferenceTypeUsage because it could contain type typeParametersValues. For example:
   * {@code class A extends B<Integer, String>}.
   *
   * <p>Note that only the Object class should not have a superclass and therefore return empty.
   */
  Optional<ResolvedReferenceType> getSuperClass();

  /**
   * Return all the interfaces implemented directly by this class. It does not include the
   * interfaces implemented by superclasses or extended by the interfaces implemented.
   */
  List<ResolvedReferenceType> getInterfaces();

  /**
   * Get all superclasses, with all the type typeParametersValues expressed as functions of the type
   * typeParametersValues of this declaration.
   */
  List<ResolvedReferenceType> getAllSuperClasses();

  /**
   * Return all the interfaces implemented by this class, either directly or indirectly, including
   * the interfaces extended by interfaces it implements.
   *
   * <p>Get all interfaces, with all the type typeParametersValues expressed as functions of the
   * type typeParametersValues of this declaration.
   */
  List<ResolvedReferenceType> getAllInterfaces();

  // /
  // / Constructors
  // /
  /**
   * List of constructors available for the class. This list should also include the default
   * constructor.
   */
  @Override
  List<ResolvedConstructorDeclaration> getConstructors();
}
