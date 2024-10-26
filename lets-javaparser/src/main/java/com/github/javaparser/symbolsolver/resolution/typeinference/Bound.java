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
package com.github.javaparser.symbolsolver.resolution.typeinference;

import com.github.javaparser.symbolsolver.resolution.typeinference.bounds.FalseBound;
import java.util.Optional;
import java.util.Set;

/**
 * Bounds are defined for Inference Variables.
 *
 * @author Federico Tomassetti
 */
public abstract class Bound {

  ///
  /// Creation of bounds
  ///
  static Bound falseBound() {
    return FalseBound.getInstance();
  }

  ///
  /// Satisfiability
  ///
  /**
   * A bound is satisfied by an inference variable substitution if, after applying the substitution,
   * the assertion is true.
   */
  public abstract boolean isSatisfied(InferenceVariableSubstitution inferenceVariableSubstitution);

  ///
  /// Classification of bounds
  ///
  /**
   * Given a bound of the form α = T or T = α, we say T is an instantiation of α.
   *
   * <p>Return empty if it is not an instantiation. Otherwise it returns the variable of which this
   * is an instantiation.
   */
  public Optional<Instantiation> isAnInstantiation() {
    return Optional.empty();
  }

  boolean isAnInstantiationFor(InferenceVariable v) {
    return isAnInstantiation().isPresent()
        && isAnInstantiation().get().getInferenceVariable().equals(v);
  }

  /**
   * Given a bound of the form α &lt;: T, we say T is a proper upper bound of α.
   *
   * <p>Return empty if it is not a proper upper bound. Otherwise it returns the variable of which
   * this is an proper upper bound.
   */
  public Optional<ProperUpperBound> isProperUpperBound() {
    return Optional.empty();
  }

  /**
   * Given a bound of the form T &lt;: α, we say T is a proper lower bound of α.
   *
   * <p>Return empty if it is not a proper lower bound. Otherwise it returns the variable of which
   * this is an proper lower bound.
   */
  public Optional<ProperLowerBound> isProperLowerBound() {
    return Optional.empty();
  }

  Optional<ProperLowerBound> isProperLowerBoundFor(InferenceVariable inferenceVariable) {
    Optional<ProperLowerBound> partial = isProperLowerBound();
    if (partial.isPresent() && partial.get().getInferenceVariable().equals(inferenceVariable)) {
      return partial;
    }
    return Optional.empty();
  }

  Optional<ProperUpperBound> isProperUpperBoundFor(InferenceVariable inferenceVariable) {
    Optional<ProperUpperBound> partial = isProperUpperBound();
    if (partial.isPresent() && partial.get().getInferenceVariable().equals(inferenceVariable)) {
      return partial;
    }
    return Optional.empty();
  }

  /**
   * Other bounds relate two inference variables, or an inference variable to a type that contains
   * inference variables. Such bounds, of the form S = T or S &lt;: T, are called dependencies.
   */
  public boolean isADependency() {
    return false;
  }

  boolean isThrowsBoundOn(InferenceVariable inferenceVariable) {
    return false;
  }

  ///
  /// Other methods
  ///
  public abstract Set<InferenceVariable> usedInferenceVariables();
}
