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
package com.github.javaparser.ast.validator;

import com.github.javaparser.ast.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** A validator that will call a collection of validators. */
public class Validators implements Validator {

  private final List<Validator> validators = new ArrayList<>();

  public Validators(Validator... validators) {
    this.validators.addAll(Arrays.asList(validators));
  }

  public List<Validator> getValidators() {
    return validators;
  }

  public Validators remove(Validator validator) {
    if (!validators.remove(validator)) {
      throw new AssertionError("Trying to remove a validator that isn't there.");
    }
    return this;
  }

  public Validators replace(Validator oldValidator, Validator newValidator) {
    remove(oldValidator);
    add(newValidator);
    return this;
  }

  public Validators add(Validator newValidator) {
    validators.add(newValidator);
    return this;
  }

  @Override
  public void accept(Node node, ProblemReporter problemReporter) {
    validators.forEach(v -> v.accept(node, problemReporter));
  }
}
