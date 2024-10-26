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
package com.github.javaparser.symbolsolver.javaparsermodel;

import com.github.javaparser.resolution.UnsolvedSymbolException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/*
 * This class allows exceptions to be handled either by casting particular exceptions
 * or by throwing new runtime exceptions.
 */
public class FailureHandler {

  private static final Map<
          Class<? extends Throwable>, Function<Throwable, ? extends RuntimeException>>
      FAILURE_CONVERTER = new HashMap<>();

  static {
    FAILURE_CONVERTER.put(UnsolvedSymbolException.class, (Throwable th) -> (RuntimeException) th);
  }

  public RuntimeException handle(Throwable th) {
    return handle(th, null);
  }

  public RuntimeException handle(Throwable th, String message) {
    // searching for exact mapping
    Function<Throwable, ? extends RuntimeException> converter =
        FAILURE_CONVERTER.get(findRootCause(th).getClass());
    if (converter != null) {
      return converter.apply(th);
    }
    // handle runtime exceptions
    if (RuntimeException.class.isAssignableFrom(th.getClass())) {
      return (RuntimeException) th;
    }
    return getRuntimeExceptionFrom(findRootCause(th), message);
  }

  protected final <E extends Throwable> E findRootCause(Throwable failure) {
    while (failure != null) {
      if (isRootCause(failure)) {
        return (E) failure;
      }
      failure = failure.getCause();
    }
    return null;
  }

  private boolean isRootCause(Throwable th) {
    return th.getCause() == null;
  }

  private RuntimeException getRuntimeExceptionFrom(Throwable th, String message) {
    if (message == null || message.isEmpty()) return new RuntimeException(findRootCause(th));
    return new RuntimeException(message, findRootCause(th));
  }
}
