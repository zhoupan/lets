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
package com.github.javaparser.ast.comments;

import static com.github.javaparser.ast.Node.NODE_BY_BEGIN_POSITION;

import com.github.javaparser.Range;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/** The comments contained in a certain parsed piece of source code. */
public class CommentsCollection {

  private final TreeSet<Comment> comments = new TreeSet<>(NODE_BY_BEGIN_POSITION);

  public CommentsCollection() {}

  public CommentsCollection(Collection<Comment> commentsToCopy) {
    comments.addAll(commentsToCopy);
  }

  public Set<LineComment> getLineComments() {
    return comments.stream()
        .filter(comment -> comment instanceof LineComment)
        .map(comment -> (LineComment) comment)
        .collect(Collectors.toCollection(() -> new TreeSet<>(NODE_BY_BEGIN_POSITION)));
  }

  public Set<BlockComment> getBlockComments() {
    return comments.stream()
        .filter(comment -> comment instanceof BlockComment)
        .map(comment -> (BlockComment) comment)
        .collect(Collectors.toCollection(() -> new TreeSet<>(NODE_BY_BEGIN_POSITION)));
  }

  public Set<JavadocComment> getJavadocComments() {
    return comments.stream()
        .filter(comment -> comment instanceof JavadocComment)
        .map(comment -> (JavadocComment) comment)
        .collect(Collectors.toCollection(() -> new TreeSet<>(NODE_BY_BEGIN_POSITION)));
  }

  public void addComment(Comment comment) {
    comments.add(comment);
  }

  public boolean contains(Comment comment) {
    if (!comment.hasRange()) {
      return false;
    }
    Range commentRange = comment.getRange().get();
    for (Comment c : getComments()) {
      if (!c.hasRange()) {
        return false;
      }
      Range cRange = c.getRange().get();
      // we tolerate a difference of one element in the end column:
      // it depends how \r and \n are calculated...
      if (cRange.begin.equals(commentRange.begin)
          && cRange.end.line == commentRange.end.line
          && Math.abs(cRange.end.column - commentRange.end.column) < 2) {
        return true;
      }
    }
    return false;
  }

  public TreeSet<Comment> getComments() {
    return comments;
  }

  public int size() {
    return comments.size();
  }

  public CommentsCollection minus(CommentsCollection other) {
    CommentsCollection result = new CommentsCollection();
    result.comments.addAll(
        comments.stream().filter(comment -> !other.contains(comment)).collect(Collectors.toList()));
    return result;
  }

  public CommentsCollection copy() {
    return new CommentsCollection(comments);
  }
}
