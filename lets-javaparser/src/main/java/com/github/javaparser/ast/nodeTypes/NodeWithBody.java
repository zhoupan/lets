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
package com.github.javaparser.ast.nodeTypes;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.EmptyStmt;
import com.github.javaparser.ast.stmt.Statement;

public interface NodeWithBody<N extends Node> {

  Statement getBody();

  N setBody(final Statement body);

  default BlockStmt createBlockStatementAsBody() {
    BlockStmt b = new BlockStmt();
    setBody(b);
    return b;
  }

  /**
   * @return true if the body is an {@link EmptyStmt} or an empty {@link BlockStmt}
   */
  default boolean hasEmptyBody() {
    Statement body = getBody();
    return body.toBlockStmt().map(bs -> bs.isEmpty()).orElse(body.isEmptyStmt());
  }
}
