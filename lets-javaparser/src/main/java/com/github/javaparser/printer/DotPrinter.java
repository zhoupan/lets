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
package com.github.javaparser.printer;

import static com.github.javaparser.utils.Utils.assertNotNull;
import static java.util.stream.Collectors.toList;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.metamodel.NodeMetaModel;
import com.github.javaparser.metamodel.PropertyMetaModel;
import com.github.javaparser.utils.LineSeparator;
import java.util.List;

/** Outputs a Graphviz diagram of the AST. */
public class DotPrinter {

  private int nodeCount;

  private final boolean outputNodeType;

  public DotPrinter(boolean outputNodeType) {
    this.outputNodeType = outputNodeType;
  }

  public String output(Node node) {
    nodeCount = 0;
    StringBuilder output = new StringBuilder();
    output.append("digraph {");
    output(node, null, "root", output);
    output.append(LineSeparator.SYSTEM + "}");
    return output.toString();
  }

  public void output(Node node, String parentNodeName, String name, StringBuilder builder) {
    assertNotNull(node);
    NodeMetaModel metaModel = node.getMetaModel();
    List<PropertyMetaModel> allPropertyMetaModels = metaModel.getAllPropertyMetaModels();
    List<PropertyMetaModel> attributes =
        allPropertyMetaModels.stream()
            .filter(PropertyMetaModel::isAttribute)
            .filter(PropertyMetaModel::isSingular)
            .collect(toList());
    List<PropertyMetaModel> subNodes =
        allPropertyMetaModels.stream()
            .filter(PropertyMetaModel::isNode)
            .filter(PropertyMetaModel::isSingular)
            .collect(toList());
    List<PropertyMetaModel> subLists =
        allPropertyMetaModels.stream().filter(PropertyMetaModel::isNodeList).collect(toList());
    String ndName = nextNodeName();
    if (outputNodeType)
      builder.append(
          LineSeparator.SYSTEM
              + ndName
              + " [label=\""
              + escape(name)
              + " ("
              + metaModel.getTypeName()
              + ")\"];");
    else builder.append(LineSeparator.SYSTEM + ndName + " [label=\"" + escape(name) + "\"];");
    if (parentNodeName != null)
      builder.append(LineSeparator.SYSTEM + parentNodeName + " -> " + ndName + ";");
    for (PropertyMetaModel a : attributes) {
      String attrName = nextNodeName();
      builder.append(
          LineSeparator.SYSTEM
              + attrName
              + " [label=\""
              + escape(a.getName())
              + "='"
              + escape(a.getValue(node).toString())
              + "'\"];");
      builder.append(LineSeparator.SYSTEM + ndName + " -> " + attrName + ";");
    }
    for (PropertyMetaModel sn : subNodes) {
      Node nd = (Node) sn.getValue(node);
      if (nd != null) output(nd, ndName, sn.getName(), builder);
    }
    for (PropertyMetaModel sl : subLists) {
      NodeList<? extends Node> nl = (NodeList<? extends Node>) sl.getValue(node);
      if (nl != null && nl.isNonEmpty()) {
        String ndLstName = nextNodeName();
        builder.append(
            LineSeparator.SYSTEM + ndLstName + " [label=\"" + escape(sl.getName()) + "\"];");
        builder.append(LineSeparator.SYSTEM + ndName + " -> " + ndLstName + ";");
        String slName = sl.getName().substring(0, sl.getName().length() - 1);
        for (Node nd : nl) output(nd, ndLstName, slName, builder);
      }
    }
  }

  private String nextNodeName() {
    return "n" + (nodeCount++);
  }

  private static String escape(String value) {
    return value.replace("\"", "\\\"");
  }
}
