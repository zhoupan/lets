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
package com.github.javaparser.symbolsolver.resolution.typeinference.bounds;

import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.resolution.typeinference.Bound;
import com.github.javaparser.symbolsolver.resolution.typeinference.InferenceVariable;
import com.github.javaparser.symbolsolver.resolution.typeinference.InferenceVariableSubstitution;
import java.util.List;
import java.util.Set;

/**
 * Capture(G&lt;A1, ..., An&gt;): The variables α1, ..., αn represent the result of capture
 * conversion (§5.1.10) applied to G&lt;A1, ..., An&gt; (where A1, ..., An may be types or wildcards
 * and may mention inference variables).
 *
 * @author Federico Tomassetti
 */
public class CapturesBound extends Bound {
  private List<InferenceVariable> inferenceVariables;
  private List<ResolvedType> typesOrWildcards;

  public CapturesBound(
      List<InferenceVariable> inferenceVariables, List<ResolvedType> typesOrWildcards) {
    this.inferenceVariables = inferenceVariables;
    this.typesOrWildcards = typesOrWildcards;
  }

  @Override
  public boolean isSatisfied(InferenceVariableSubstitution inferenceVariableSubstitution) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Set<InferenceVariable> usedInferenceVariables() {
    throw new UnsupportedOperationException();
  }

  public List<InferenceVariable> getInferenceVariables() {
    return inferenceVariables;
  }

  public List<ResolvedType> getTypesOrWildcards() {
    return typesOrWildcards;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CapturesBound that = (CapturesBound) o;

    if (!inferenceVariables.equals(that.inferenceVariables)) return false;
    return typesOrWildcards.equals(that.typesOrWildcards);
  }

  @Override
  public int hashCode() {
    int result = inferenceVariables.hashCode();
    result = 31 * result + typesOrWildcards.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "CapturesBound{"
        + "inferenceVariables="
        + inferenceVariables
        + ", typesOrWildcards="
        + typesOrWildcards
        + '}';
  }
}
