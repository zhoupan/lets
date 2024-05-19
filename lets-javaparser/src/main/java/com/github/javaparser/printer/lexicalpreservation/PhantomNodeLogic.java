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
package com.github.javaparser.printer.lexicalpreservation;

import static java.util.Collections.synchronizedMap;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.observer.AstObserver;
import com.github.javaparser.ast.observer.AstObserverAdapter;
import com.github.javaparser.ast.type.UnknownType;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * We want to recognize and ignore "phantom" nodes, like the fake type of variable in
 * FieldDeclaration
 *
 * @deprecated This class is no longer used phantom node are now an attribute of each node
 */
@Deprecated
public class PhantomNodeLogic {

  private static final int LEVELS_TO_EXPLORE = 3;

  private static final Map<Node, Boolean> isPhantomNodeCache =
      synchronizedMap(new IdentityHashMap<>());

  private static final AstObserver cacheCleaner =
      new AstObserverAdapter() {

        @Override
        public void parentChange(Node observedNode, Node previousParent, Node newParent) {
          isPhantomNodeCache.remove(observedNode);
        }
      };

  static boolean isPhantomNode(Node node) {
    if (isPhantomNodeCache.containsKey(node)) {
      return isPhantomNodeCache.get(node);
    }
    if (node instanceof UnknownType) {
      return true;
    }
    boolean res =
        (node.getParentNode().isPresent()
                && node.getParentNode().get().hasRange()
                && node.hasRange()
                && !node.getParentNode().get().getRange().get().contains(node.getRange().get())
            || inPhantomNode(node, LEVELS_TO_EXPLORE));
    isPhantomNodeCache.put(node, res);
    node.register(cacheCleaner);
    return res;
  }

  /**
   * A node contained in a phantom node is also a phantom node. We limit how many levels up we check
   * just for performance reasons.
   */
  private static boolean inPhantomNode(Node node, int levels) {
    return node.getParentNode().isPresent()
        && (isPhantomNode(node.getParentNode().get())
            || inPhantomNode(node.getParentNode().get(), levels - 1));
  }

  /**
   * Clean up the cache used by the LexicalPreserving logic. This should only be used once you're
   * done printing all parsed data with a JavaParser's configuration
   * setLexicalPreservationEnabled=true.
   */
  public static void cleanUpCache() {
    isPhantomNodeCache.clear();
  }
}
