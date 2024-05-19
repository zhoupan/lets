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
package com.github.javaparser.ast.visitor;

import com.github.javaparser.ast.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Iterate over all the nodes in (a part of) the AST. In contrast to the visit methods in Node,
 * these methods are implemented in a simple recursive way which should be more efficient. A
 * disadvantage is that they cannot be quit in the middle of their traversal.
 */
public abstract class TreeVisitor {

  public void visitLeavesFirst(Node node) {
    for (Node child : node.getChildNodes()) {
      visitLeavesFirst(child);
    }
    process(node);
  }

  /**
   * Performs a pre-order node traversal starting with a given node. When each node is visited,
   * {@link #process(Node)} is called for further processing.
   *
   * @param node The node at which the traversal begins.
   * @see <a href="https://en.wikipedia.org/wiki/Depth-first_search#Vertex_orderings">Pre-order
   *     traversal</a>
   */
  public void visitPreOrder(Node node) {
    process(node);
    new ArrayList<>(node.getChildNodes()).forEach(this::visitPreOrder);
  }

  /**
   * Performs a post-order node traversal starting with a given node. When each node is visited,
   * {@link #process(Node)} is called for further processing.
   *
   * @param node The node at which the traversal begins.
   * @see <a href="https://en.wikipedia.org/wiki/Depth-first_search#Vertex_orderings">Post-order
   *     traversal</a>
   */
  public void visitPostOrder(Node node) {
    new ArrayList<>(node.getChildNodes()).forEach(this::visitPostOrder);
    process(node);
  }

  /**
   * https://en.wikipedia.org/wiki/Breadth-first_search
   *
   * @param node the start node, and the first one that is passed to process(node).
   */
  public void visitBreadthFirst(Node node) {
    final Queue<Node> queue = new LinkedList<>();
    queue.offer(node);
    while (queue.size() > 0) {
      final Node head = queue.peek();
      for (Node child : head.getChildNodes()) {
        queue.offer(child);
      }
      process(queue.poll());
    }
  }

  /**
   * Process the given node.
   *
   * @param node The current node to process.
   */
  public abstract void process(Node node);

  /** Performs a simple traversal over all nodes that have the passed node as their parent. */
  public void visitDirectChildren(Node node) {
    new ArrayList<>(node.getChildNodes()).forEach(this::process);
  }
}
