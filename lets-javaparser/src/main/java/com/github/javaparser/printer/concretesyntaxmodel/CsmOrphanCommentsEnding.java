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
package com.github.javaparser.printer.concretesyntaxmodel;

import static com.github.javaparser.utils.PositionUtils.sortByBeginPosition;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.printer.SourcePrinter;
import java.util.LinkedList;
import java.util.List;

public class CsmOrphanCommentsEnding implements CsmElement {

  @Override
  public void prettyPrint(Node node, SourcePrinter printer) {
    List<Node> everything = new LinkedList<>();
    everything.addAll(node.getChildNodes());
    sortByBeginPosition(everything);
    if (everything.isEmpty()) {
      return;
    }
    int commentsAtEnd = 0;
    boolean findingComments = true;
    while (findingComments && commentsAtEnd < everything.size()) {
      Node last = everything.get(everything.size() - 1 - commentsAtEnd);
      findingComments = (last instanceof Comment);
      if (findingComments) {
        commentsAtEnd++;
      }
    }
    for (int i = 0; i < commentsAtEnd; i++) {
      Comment c = (Comment) everything.get(everything.size() - commentsAtEnd + i);
      CsmComment.process(c, printer);
    }
  }
}
