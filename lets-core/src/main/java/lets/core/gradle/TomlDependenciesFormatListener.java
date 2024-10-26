/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
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
package lets.core.gradle;

import java.util.Properties;
import lets.core.jtoml.Util;
import lets.core.properties.IPropertiesTreeListener;

// # https://docs.gradle.org/current/userguide/platforms.html#sub::toml-dependencies-format
public class TomlDependenciesFormatListener implements IPropertiesTreeListener {

  private final StringBuilder builder = new StringBuilder();

  public StringBuilder getBuilder() {
    return builder;
  }

  @Override
  public void enter(Properties props, int level) {}

  @Override
  public void exit(Properties props, int level) {}

  @Override
  public void enter(String name, Properties props, int level) {
    if (level == 0) {
      // key=value
    } else if (level == 1) {
      // [section]
      if (this.builder.length() > 0) {
        writeLineEndings();
      }
      writeSection(name);
      writeLineEndings();
    } else {
      writeName(name);
      writeDelimiter();
      writePropertiesStart();
    }
  }

  public void writePropertiesStart() {
    this.builder.append("{");
  }

  public void writeSection(String name) {
    writeSectionStart();
    writeName(name);
    writeSectionEnd();
  }

  public void writeSectionEnd() {
    this.builder.append("]");
  }

  public void writeSectionStart() {
    this.builder.append("[");
  }

  @Override
  public void exit(String name, Properties props, int level) {
    if (level == 0) {
      // key=value
    } else if (level == 1) {
      // [section]
      // name=value
    } else {
      // [section]
      // name={name=value,name=value}
      writePropertiesEnd();
    }
  }

  public void writePropertiesEnd() {
    this.builder.append("}");
  }

  @Override
  public void enter(String name, Object value, int level) {
    if (level == 0) {
      // key=value
      writeName(name);
      writeDelimiter();
      writeValue(value);
      writeLineEndings();
    } else if (level == 1) {
      writeName(name);
      writeDelimiter();
      writeValue(value);
      writeLineEndings();
    } else {
      // [section]
      // name={name=value,name=value}
      char lastChar = builder.charAt(this.builder.length() - 1);
      if (lastChar != '{' && lastChar != ',') {
        this.builder.append(",");
      }
      writeName(name);
      writeDelimiter();
      writeValue(value);
    }
  }

  public void writeLineEndings() {
    this.builder.append("\n");
  }

  public void writeDelimiter() {
    this.builder.append("=");
  }

  public void writeName(String name) {
    this.builder.append(name);
  }

  public void writeValue(Object value) {
    this.builder.append("\"");
    this.builder.append(Util.TomlString.escape(value.toString()));
    this.builder.append("\"");
  }

  @Override
  public void exit(String name, Object value, int level) {}
}
