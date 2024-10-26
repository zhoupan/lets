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
package com.github.javaparser.resolution;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;

public interface SymbolResolver {

  /** For a reference it would find the corresponding declaration. */
  <T> T resolveDeclaration(Node node, Class<T> resultClass);

  /** For types it would find the corresponding resolved types. */
  <T> T toResolvedType(Type javaparserType, Class<T> resultClass);

  /** For an expression it would find the corresponding resolved type. */
  ResolvedType calculateType(Expression expression);

  /** For a node it would find the corresponding reference type declaration. */
  ResolvedReferenceTypeDeclaration toTypeDeclaration(Node node);
}
