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

/**
 * It is not possible to decide how to resolve a method invocation.
 *
 * @author Federico Tomassetti
 */
public class MethodAmbiguityException extends RuntimeException {

  /**
   * Create an instance from a description of the reason why there is ambiguity in this particular
   * case.
   */
  public MethodAmbiguityException(String description) {
    super(description);
  }
}
