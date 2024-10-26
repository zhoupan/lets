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
package com.github.javaparser;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;

/** Helper class for {@link GeneratedJavaParser} */
class RangedList<T extends Node> {

  /* A ranged list MUST be set to a begin and end,
  or these temporary values will leak out */
  TokenRange range = new TokenRange(JavaToken.INVALID, JavaToken.INVALID);

  NodeList<T> list;

  RangedList(NodeList<T> list) {
    this.list = list;
  }

  void beginAt(JavaToken begin) {
    range = range.withBegin(begin);
  }

  void endAt(JavaToken end) {
    range = range.withEnd(end);
  }

  void add(T t) {
    if (list == null) {
      list = new NodeList<>();
    }
    list.add(t);
  }
}
