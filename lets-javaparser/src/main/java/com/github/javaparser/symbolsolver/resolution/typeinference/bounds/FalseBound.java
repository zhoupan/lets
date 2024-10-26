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

import com.github.javaparser.symbolsolver.resolution.typeinference.Bound;
import com.github.javaparser.symbolsolver.resolution.typeinference.InferenceVariable;
import com.github.javaparser.symbolsolver.resolution.typeinference.InferenceVariableSubstitution;
import java.util.Collections;
import java.util.Set;

/**
 * No valid choice of inference variables exists.
 *
 * @author Federico Tomassetti
 */
public class FalseBound extends Bound {

  private static FalseBound INSTANCE = new FalseBound();

  private FalseBound() {}

  public static FalseBound getInstance() {
    return INSTANCE;
  }

  @Override
  public String toString() {
    return "FalseBound{}";
  }

  @Override
  public boolean isSatisfied(InferenceVariableSubstitution inferenceVariableSubstitution) {
    return false;
  }

  @Override
  public Set<InferenceVariable> usedInferenceVariables() {
    return Collections.emptySet();
  }
}
