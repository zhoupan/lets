/*
 * Copyright (c) 2021 zhoupan (https://github.com/zhoupan).
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
package lets.core.contraint;

import jodd.typeconverter.Convert;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;
import jodd.vtor.constraint.Max;

public class LessEqualConstraint implements ValidationConstraint<Max> {

  public LessEqualConstraint() {}

  public LessEqualConstraint(double max) {
    this.max = max;
  }

  // ---------------------------------------------------------------- properties

  protected double max;

  public double getMax() {
    return max;
  }

  public void setMax(double max) {
    this.max = max;
  }

  // ---------------------------------------------------------------- configure

  public void configure(Max annotation) {
    this.max = annotation.value();
  }

  // ---------------------------------------------------------------- valid

  public boolean isValid(ValidationConstraintContext vcc, Object value) {
    return validate(value, max);
  }

  public static boolean validate(Object value, double max) {
    if (value == null) {
      return true;
    }
    double val = Convert.toDoubleValue(value);
    return val <= max;
  }
}
