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
import jodd.vtor.constraint.Min;

public class GreaterEqualConstraint implements ValidationConstraint<Min> {

  public GreaterEqualConstraint() {}

  public GreaterEqualConstraint(double min) {
    this.min = min;
  }

  // ---------------------------------------------------------------- properties

  protected double min;

  public double getMin() {
    return min;
  }

  public void setMin(double min) {
    this.min = min;
  }

  // ---------------------------------------------------------------- configure

  public void configure(Min annotation) {
    this.min = annotation.value();
  }

  // ---------------------------------------------------------------- valid

  public boolean isValid(ValidationConstraintContext vcc, Object value) {
    return validate(value, min);
  }

  public static boolean validate(Object value, double min) {
    if (value == null) {
      return true;
    }
    double val = Convert.toDoubleValue(value);
    return val >= min;
  }
}
