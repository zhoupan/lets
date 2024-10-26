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
package com.github.javaparser.javadoc;

import static com.github.javaparser.utils.Utils.nextWord;
import static com.github.javaparser.utils.Utils.screamingToCamelCase;

import com.github.javaparser.javadoc.description.JavadocDescription;
import java.util.Optional;

/**
 * A block tag.
 *
 * <p>Typically they are found at the end of Javadoc comments.
 *
 * <p>Examples: {@code @see AnotherClass} {@code @since v0.0.1} {@code @author Jim O'Java}
 */
public class JavadocBlockTag {

  /**
   * The type of tag: it could either correspond to a known tag (param, return, etc.) or represent
   * an unknown tag.
   */
  public enum Type {
    AUTHOR,
    DEPRECATED,
    EXCEPTION,
    PARAM,
    RETURN,
    SEE,
    SERIAL,
    SERIAL_DATA,
    SERIAL_FIELD,
    SINCE,
    THROWS,
    VERSION,
    UNKNOWN;

    Type() {
      this.keyword = screamingToCamelCase(name());
    }

    private String keyword;

    boolean hasName() {
      return this == PARAM || this == EXCEPTION || this == THROWS;
    }

    static Type fromName(String tagName) {
      for (Type t : Type.values()) {
        if (t.keyword.equals(tagName)) {
          return t;
        }
      }
      return UNKNOWN;
    }
  }

  private Type type;

  private JavadocDescription content;

  private Optional<String> name = Optional.empty();

  private String tagName;

  public JavadocBlockTag(Type type, String content) {
    this.type = type;
    this.tagName = type.keyword;
    if (type.hasName()) {
      this.name = Optional.of(nextWord(content));
      content = content.substring(this.name.get().length()).trim();
    }
    this.content = JavadocDescription.parseText(content);
  }

  public JavadocBlockTag(String tagName, String content) {
    this(Type.fromName(tagName), content);
    this.tagName = tagName;
  }

  public static JavadocBlockTag createParamBlockTag(String paramName, String content) {
    return new JavadocBlockTag(Type.PARAM, paramName + " " + content);
  }

  public Type getType() {
    return type;
  }

  public JavadocDescription getContent() {
    return content;
  }

  public Optional<String> getName() {
    return name;
  }

  public String getTagName() {
    return tagName;
  }

  public String toText() {
    StringBuilder sb = new StringBuilder();
    sb.append("@");
    sb.append(tagName);
    name.ifPresent(s -> sb.append(" ").append(s));
    if (!content.isEmpty()) {
      sb.append(" ");
      sb.append(content.toText());
    }
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    JavadocBlockTag that = (JavadocBlockTag) o;
    if (type != that.type) return false;
    if (!content.equals(that.content)) return false;
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    int result = type.hashCode();
    result = 31 * result + content.hashCode();
    result = 31 * result + name.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "JavadocBlockTag{"
        + "type="
        + type
        + ", content='"
        + content
        + '\''
        + ", name="
        + name
        + '}';
  }
}
