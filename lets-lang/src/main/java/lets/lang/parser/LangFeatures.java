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
package lets.lang.parser;

import com.github.javaparser.ast.CompilationUnit;
import java.io.File;
import lets.core.DataResultSupport;
import lets.core.NotImplementedException;

/** Language Features. */
public class LangFeatures {

  protected boolean modifierSupported = true;

  protected String sourceFileExtension = "";
  protected String sourceFileEncoding = "UTF-8";

  public boolean isModifierSupported() {
    return modifierSupported;
  }

  public void setModifierSupported(boolean modifierSupported) {
    this.modifierSupported = modifierSupported;
  }

  public String getSourceFileExtension() {
    return sourceFileExtension;
  }

  public void setSourceFileExtension(String sourceFileExtension) {
    this.sourceFileExtension = sourceFileExtension;
  }

  public String getSourceFileEncoding() {
    return sourceFileEncoding;
  }

  public void setSourceFileEncoding(String sourceFileEncoding) {
    this.sourceFileEncoding = sourceFileEncoding;
  }

  public DataResultSupport<CompilationUnit> compilationUnitFrom(File file) {
    DataResultSupport<CompilationUnit> result = new DataResultSupport<>();
    try {
      throw new NotImplementedException("compilationUnitFrom");
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }
}
