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

/**
 * A piece of text inside a Javadoc description.
 *
 * <p>For example in <code>A class totally unrelated to {@link String}, I swear!</code> we would
 * have two snippets: one before and one after the inline tag (<code>{@link String}</code>).
 */
public class JavadocSnippet implements JavadocDescriptionElement {

  private String text;

  public JavadocSnippet(String text) {
    if (text == null) {
      throw new NullPointerException();
    }
    this.text = text;
  }

  @Override
  public String toText() {
    return this.text;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JavadocSnippet that = (JavadocSnippet) o;
    return text.equals(that.text);
  }

  @Override
  public int hashCode() {
    return text.hashCode();
  }

  @Override
  public String toString() {
    return "JavadocSnippet{" + "text='" + text + '\'' + '}';
  }
}
