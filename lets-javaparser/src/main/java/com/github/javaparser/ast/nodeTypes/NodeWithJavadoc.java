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
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.javadoc.Javadoc;
import java.util.Optional;

/** A node that can be documented with a Javadoc comment. */
public interface NodeWithJavadoc<N extends Node> {

  Optional<Comment> getComment();

  Node setComment(Comment comment);

  /**
   * Gets the JavadocComment for this node. You can set the JavadocComment by calling
   * setJavadocComment passing a JavadocComment.
   *
   * @return The JavadocComment for this node wrapped in an optional as it may be absent.
   */
  default Optional<JavadocComment> getJavadocComment() {
    return getComment()
        .filter(comment -> comment instanceof JavadocComment)
        .map(comment -> (JavadocComment) comment);
  }

  /**
   * Gets the Javadoc for this node. You can set the Javadoc by calling setJavadocComment passing a
   * Javadoc.
   *
   * @return The Javadoc for this node wrapped in an optional as it may be absent.
   */
  default Optional<Javadoc> getJavadoc() {
    return getJavadocComment().map(JavadocComment::parse);
  }

  /**
   * Use this to store additional information to this node.
   *
   * @param comment to be set
   */
  @SuppressWarnings("unchecked")
  default N setJavadocComment(String comment) {
    return setJavadocComment(new JavadocComment(comment));
  }

  default N setJavadocComment(JavadocComment comment) {
    setComment(comment);
    return (N) this;
  }

  default N setJavadocComment(String indentation, Javadoc javadoc) {
    return setJavadocComment(javadoc.toComment(indentation));
  }

  default N setJavadocComment(Javadoc javadoc) {
    return setJavadocComment(javadoc.toComment());
  }

  default boolean removeJavaDocComment() {
    return hasJavaDocComment() && getComment().get().remove();
  }

  default boolean hasJavaDocComment() {
    return getComment().isPresent() && getComment().get() instanceof JavadocComment;
  }
}
