/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
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
package dev.webview.webview_java.bridge;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Lets you expose a property/field to Javascript. You can optionally disable get or sets, as well
 * as register a watcher (via watchForMutate) which can be used with the `__stores` feature. Note
 * that the return value will always be a Promise<T> to Javascript and WILL need to be awaited on.
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface JavascriptValue {

  String value() default "";

  boolean allowGet() default true;

  boolean allowSet() default true;

  boolean watchForMutate() default false;
}
