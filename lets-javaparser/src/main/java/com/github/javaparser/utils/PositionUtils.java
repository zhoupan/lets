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
package com.github.javaparser.utils;

import static java.lang.Integer.signum;

import com.github.javaparser.Position;
import com.github.javaparser.Range;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations;
import java.util.Comparator;
import java.util.List;

public final class PositionUtils {

  private PositionUtils() {
    // prevent instantiation
  }

  public static <T extends Node> void sortByBeginPosition(List<T> nodes) {
    sortByBeginPosition(nodes, false);
  }

  public static <T extends Node> void sortByBeginPosition(NodeList<T> nodes) {
    sortByBeginPosition(nodes, false);
  }

  public static <T extends Node> void sortByBeginPosition(
      List<T> nodes, final boolean ignoringAnnotations) {
    nodes.sort((o1, o2) -> PositionUtils.compare(o1, o2, ignoringAnnotations));
  }

  public static boolean areInOrder(Node a, Node b) {
    return areInOrder(a, b, false);
  }

  public static boolean areInOrder(Node a, Node b, boolean ignoringAnnotations) {
    return compare(a, b, ignoringAnnotations) <= 0;
  }

  private static int compare(Node a, Node b, boolean ignoringAnnotations) {
    if (a.hasRange() && !b.hasRange()) {
      return -1;
    }
    if (!a.hasRange() && b.hasRange()) {
      return 1;
    }
    if (!a.hasRange() && !b.hasRange()) {
      return 0;
    }
    if (ignoringAnnotations) {
      int signLine =
          signum(
              beginLineWithoutConsideringAnnotation(a) - beginLineWithoutConsideringAnnotation(b));
      if (signLine == 0) {
        return signum(
            beginColumnWithoutConsideringAnnotation(a)
                - beginColumnWithoutConsideringAnnotation(b));
      }
      return signLine;
    }
    Position aBegin = a.getBegin().get();
    Position bBegin = b.getBegin().get();
    int signLine = signum(aBegin.line - bBegin.line);
    if (signLine == 0) {
      return signum(aBegin.column - bBegin.column);
    }
    return signLine;
  }

  public static AnnotationExpr getLastAnnotation(Node node) {
    if (node instanceof NodeWithAnnotations) {
      NodeList<AnnotationExpr> annotations =
          NodeList.nodeList(((NodeWithAnnotations<?>) node).getAnnotations());
      if (annotations.isEmpty()) {
        return null;
      }
      sortByBeginPosition(annotations);
      return annotations.get(annotations.size() - 1);
    }
    return null;
  }

  private static int beginLineWithoutConsideringAnnotation(Node node) {
    return firstNonAnnotationNode(node).getRange().get().begin.line;
  }

  private static int beginColumnWithoutConsideringAnnotation(Node node) {
    return firstNonAnnotationNode(node).getRange().get().begin.column;
  }

  private static Node firstNonAnnotationNode(Node node) {

    if (node instanceof ClassOrInterfaceDeclaration) {
      // Modifiers appear before the class name --
      ClassOrInterfaceDeclaration casted = (ClassOrInterfaceDeclaration) node;
      Modifier earliestModifier =
          casted.getModifiers().stream()
              .filter(modifier -> modifier.hasRange())
              .min(Comparator.comparing(o -> o.getRange().get().begin))
              .orElse(null);
      if (earliestModifier == null) {
        return casted.getName();
      }
      return earliestModifier;
    }
    if (node instanceof MethodDeclaration) {
      // Modifiers appear before the class name --
      MethodDeclaration casted = (MethodDeclaration) node;
      Modifier earliestModifier =
          casted.getModifiers().stream()
              .filter(modifier -> modifier.hasRange())
              .min(Comparator.comparing(o -> o.getRange().get().begin))
              .orElse(null);
      if (earliestModifier == null) {
        return casted.getType();
      }
      return earliestModifier;
    }
    if (node instanceof FieldDeclaration) {
      // Modifiers appear before the class name --
      FieldDeclaration casted = (FieldDeclaration) node;
      Modifier earliestModifier =
          casted.getModifiers().stream()
              .filter(modifier -> modifier.hasRange())
              .min(Comparator.comparing(o -> o.getRange().get().begin))
              .orElse(null);
      if (earliestModifier == null) {
        return casted.getVariable(0).getType();
      }
      return earliestModifier;
    }
    return node;
  }

  /**
   * Compare the position of two nodes. Optionally include annotations within the range checks. This
   * method takes into account whether the nodes are within the same compilation unit.
   *
   * <p>Note that this performs a "strict contains", where the container must extend beyond the
   * other node in both directions (otherwise it would count as an overlap, rather than "contain").
   *
   * <p>If `ignoringAnnotations` is false, annotations on the container are ignored. For this
   * reason, where `container == other`, the raw `other` may extend beyond the sans-annotations
   * `container` thus return false.
   */
  public static boolean nodeContains(Node container, Node other, boolean ignoringAnnotations) {
    if (!container.hasRange()) {
      throw new IllegalArgumentException(
          "Cannot compare the positions of nodes if container node does not have a range.");
    }
    if (!other.hasRange()) {
      throw new IllegalArgumentException(
          "Cannot compare the positions of nodes if contained node does not have a range.");
    }
    // // FIXME: Not all nodes seem to have the compilation unit available?
    // if (!Objects.equals(container.findCompilationUnit(), other.findCompilationUnit())) {
    // // Allow the check to complete if they are both within a known CU (i.e. the CUs are the
    // same),
    // // ... or both not within a CU (i.e. both are Optional.empty())
    // return false;
    // }
    final boolean nodeCanHaveAnnotations = container instanceof NodeWithAnnotations;
    // final boolean hasAnnotations = PositionUtils.getLastAnnotation(container) != null;
    if (!ignoringAnnotations || PositionUtils.getLastAnnotation(container) == null) {
      // No special consideration required - perform simple range check.
      return container.containsWithinRange(other);
    }
    if (!container.containsWithinRange(other)) {
      return false;
    }
    if (!nodeCanHaveAnnotations) {
      return true;
    }
    // If the node is contained, but it comes immediately after the annotations,
    // let's not consider it contained (i.e. it must be "strictly contained").
    Node nodeWithoutAnnotations = firstNonAnnotationNode(container);
    Range rangeWithoutAnnotations =
        container.getRange().get().withBegin(nodeWithoutAnnotations.getBegin().get());
    return rangeWithoutAnnotations. // .contains(other.getRange().get());
        strictlyContains(other.getRange().get());
  }
}
