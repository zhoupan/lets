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
package com.github.javaparser.symbolsolver.reflectionmodel;

import com.github.javaparser.resolution.TypeSolver;
import com.github.javaparser.resolution.declarations.ResolvedPatternDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;

/**
 * WARNING: Implemented fairly blindly. Unsure if required or even appropriate. Use with extreme
 * caution.
 *
 * @author Roger Howell
 */
public class ReflectionPatternDeclaration implements ResolvedPatternDeclaration {

  private Class<?> type;
  private TypeSolver typeSolver;
  private String name;

  /**
   * @param type
   * @param typeSolver
   * @param name can potentially be null
   */
  public ReflectionPatternDeclaration(Class<?> type, TypeSolver typeSolver, String name) {
    this.type = type;
    this.typeSolver = typeSolver;
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean hasName() {
    return name != null;
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
  public boolean isPattern() {
    return true;
  }

  @Override
  public boolean isType() {
    return false;
  }

  @Override
  public ResolvedType getType() {
    return ReflectionFactory.typeUsageFor(type, typeSolver);
  }
}
