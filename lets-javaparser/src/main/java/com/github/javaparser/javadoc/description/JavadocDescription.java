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
package com.github.javaparser.javadoc.description;

import com.github.javaparser.utils.Pair;
import java.util.LinkedList;
import java.util.List;

/**
 * A javadoc text, potentially containing inline tags.
 *
 * <p>For example <code>This class is totally unrelated to {@link com.github.javaparser.Range}
 * </code>
 */
public class JavadocDescription {

  private List<JavadocDescriptionElement> elements;

  public static JavadocDescription parseText(String text) {
    JavadocDescription instance = new JavadocDescription();
    int index = 0;
    Pair<Integer, Integer> nextInlineTagPos;
    while ((nextInlineTagPos = indexOfNextInlineTag(text, index)) != null) {
      if (nextInlineTagPos.a != index) {
        instance.addElement(new JavadocSnippet(text.substring(index, nextInlineTagPos.a)));
      }
      instance.addElement(
          JavadocInlineTag.fromText(text.substring(nextInlineTagPos.a, nextInlineTagPos.b + 1)));
      index = nextInlineTagPos.b + 1;
    }
    if (index < text.length()) {
      instance.addElement(new JavadocSnippet(text.substring(index)));
    }
    return instance;
  }

  private static Pair<Integer, Integer> indexOfNextInlineTag(String text, int start) {
    int index = text.indexOf("{@", start);
    if (index == -1) {
      return null;
    }
    // we are interested only in complete inline tags
    int closeIndex = text.indexOf("}", index);
    if (closeIndex == -1) {
      return null;
    }
    return new Pair<>(index, closeIndex);
  }

  public JavadocDescription() {
    elements = new LinkedList<>();
  }

  public JavadocDescription(List<JavadocDescriptionElement> elements) {
    this();
    this.elements.addAll(elements);
  }

  public boolean addElement(JavadocDescriptionElement element) {
    return this.elements.add(element);
  }

  public List<JavadocDescriptionElement> getElements() {
    return this.elements;
  }

  public String toText() {
    StringBuilder sb = new StringBuilder();
    elements.forEach(e -> sb.append(e.toText()));
    return sb.toString();
  }

  public boolean isEmpty() {
    return toText().isEmpty();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JavadocDescription that = (JavadocDescription) o;
    return elements.equals(that.elements);
  }

  @Override
  public int hashCode() {
    return elements.hashCode();
  }

  @Override
  public String toString() {
    return "JavadocDescription{" + "elements=" + elements + '}';
  }
}
