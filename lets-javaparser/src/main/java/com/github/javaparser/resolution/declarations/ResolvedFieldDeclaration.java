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

/**
 * Declaration of a field.
 *
 * @author Federico Tomassetti
 */
public interface ResolvedFieldDeclaration extends ResolvedValueDeclaration, HasAccessSpecifier {

  /** Is the field static? */
  boolean isStatic();

  /** Is the field volatile? */
  boolean isVolatile();

  @Override
  default boolean isField() {
    return true;
  }

  @Override
  default ResolvedFieldDeclaration asField() {
    return this;
  }

  /** The type on which this field has been declared */
  ResolvedTypeDeclaration declaringType();
}
