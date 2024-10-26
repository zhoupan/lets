/*
 * Copyright (c) 2013-2024 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser.symbolsolver.resolution.promotion;

import com.github.javaparser.resolution.promotion.ConditionalExprHandler;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.resolution.typeinference.TypeHelper;
import java.util.Arrays;
import java.util.HashSet;

public class ReferenceConditionalExprHandler implements ConditionalExprHandler {

  ResolvedType thenExpr;

  ResolvedType elseExpr;

  public ReferenceConditionalExprHandler(ResolvedType thenExpr, ResolvedType elseExpr) {
    this.thenExpr = thenExpr;
    this.elseExpr = elseExpr;
  }

  @Override
  public ResolvedType resolveType() {
    // If one of the second and third operands is of the null type and the type of the other is a
    // reference type, then the type of the conditional expression is that reference type.
    if (thenExpr.isNull()) {
      return elseExpr;
    }
    if (elseExpr.isNull()) {
      return thenExpr;
    }
    return TypeHelper.leastUpperBound(new HashSet<>(Arrays.asList(thenExpr, elseExpr)));
  }
}
