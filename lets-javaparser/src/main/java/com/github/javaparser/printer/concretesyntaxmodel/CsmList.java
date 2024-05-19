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

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.observer.ObservableProperty;
import com.github.javaparser.printer.ConcreteSyntaxModel;
import com.github.javaparser.printer.SourcePrinter;
import java.util.Collection;
import java.util.Iterator;

public class CsmList implements CsmElement {

  private final ObservableProperty property;

  private final CsmElement separatorPost;

  private final CsmElement separatorPre;

  private final CsmElement preceeding;

  private final CsmElement following;

  public ObservableProperty getProperty() {
    return property;
  }

  public CsmElement getSeparatorPost() {
    return separatorPost;
  }

  public CsmElement getSeparatorPre() {
    return separatorPre;
  }

  public CsmElement getPreceeding() {
    return preceeding;
  }

  public CsmElement getFollowing() {
    return following;
  }

  public CsmList(ObservableProperty property, CsmElement separator) {
    this(property, new CsmNone(), separator, new CsmNone(), new CsmNone());
  }

  public CsmList(ObservableProperty property) {
    this(property, new CsmNone(), new CsmNone(), new CsmNone(), new CsmNone());
  }

  public CsmList(
      ObservableProperty property,
      CsmElement separatorPre,
      CsmElement separatorPost,
      CsmElement preceeding,
      CsmElement following) {
    this.property = property;
    this.separatorPre = separatorPre;
    this.separatorPost = separatorPost;
    this.preceeding = preceeding;
    this.following = following;
  }

  @Override
  public void prettyPrint(Node node, SourcePrinter printer) {
    if (property.isAboutNodes()) {
      NodeList<? extends Node> nodeList = property.getValueAsMultipleReference(node);
      if (nodeList == null) {
        return;
      }
      if (!nodeList.isEmpty() && preceeding != null) {
        preceeding.prettyPrint(node, printer);
      }
      for (int i = 0; i < nodeList.size(); i++) {
        if (separatorPre != null && i != 0) {
          separatorPre.prettyPrint(node, printer);
        }
        ConcreteSyntaxModel.genericPrettyPrint(nodeList.get(i), printer);
        if (separatorPost != null && i != (nodeList.size() - 1)) {
          separatorPost.prettyPrint(node, printer);
        }
      }
      if (!nodeList.isEmpty() && following != null) {
        following.prettyPrint(node, printer);
      }
    } else {
      Collection<?> values = property.getValueAsCollection(node);
      if (values == null) {
        return;
      }
      if (!values.isEmpty() && preceeding != null) {
        preceeding.prettyPrint(node, printer);
      }
      for (Iterator<?> it = values.iterator(); it.hasNext(); ) {
        if (separatorPre != null && it.hasNext()) {
          separatorPre.prettyPrint(node, printer);
        }
        printer.print(PrintingHelper.printToString(it.next()));
        if (separatorPost != null && it.hasNext()) {
          separatorPost.prettyPrint(node, printer);
        }
      }
      if (!values.isEmpty() && following != null) {
        following.prettyPrint(node, printer);
      }
    }
  }

  @Override
  public String toString() {
    return String.format("%s(property:%s)", this.getClass().getSimpleName(), getProperty());
  }
}
