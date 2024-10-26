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
 * This exception is thrown when a symbol cannot be resolved.
 *
 * @author Federico Tomassetti
 */
public class UnsolvedSymbolException extends RuntimeException {

  /** The name of the symbol that could not be resolved. */
  private String name;

  /**
   * Additional information that provides more details on the context that a symbol could not be
   * resolved in, or {@code null} if there is no contextual information, or if the contextual
   * information is unknown.
   */
  private String context;

  /**
   * The throwable that caused this {@code UnsolvedSymbolException} to get thrown, or {@code null}
   * if this {@code UnsolvedSymbolException} was not caused by another throwable, or if the
   * causative throwable is unknown.
   */
  private Throwable cause;

  public UnsolvedSymbolException(String name) {
    this(name, null, null);
  }

  public UnsolvedSymbolException(String name, String context) {
    this(name, context, null);
  }

  public UnsolvedSymbolException(String name, Throwable cause) {
    this(name, null, cause);
  }

  public UnsolvedSymbolException(String name, String context, Throwable cause) {
    super("Unsolved symbol" + (context != null ? " in " + context : "") + " : " + name, cause);
    this.name = name;
    this.context = context;
    this.cause = cause;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "UnsolvedSymbolException{"
        + "context='"
        + context
        + "'"
        + ", name='"
        + name
        + "'"
        + ", cause='"
        + cause
        + "'"
        + "}";
  }
}
