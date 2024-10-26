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
package com.github.javaparser.resolution.types;

public class ResolvedLambdaConstraintType implements ResolvedType {

  private ResolvedType bound;

  private ResolvedLambdaConstraintType(ResolvedType bound) {
    this.bound = bound;
  }

  @Override
  public String describe() {
    return "? super " + bound.describe();
  }

  public ResolvedType getBound() {
    return bound;
  }

  @Override
  public boolean isConstraint() {
    return true;
  }

  @Override
  public ResolvedLambdaConstraintType asConstraintType() {
    return this;
  }

  public static ResolvedLambdaConstraintType bound(ResolvedType bound) {
    return new ResolvedLambdaConstraintType(bound);
  }

  @Override
  public boolean isAssignableBy(ResolvedType other) {
    return bound.isAssignableBy(other);
  }

  @Override
  public String toString() {
    return "LambdaConstraintType{" + "bound=" + bound + '}';
  }
}
