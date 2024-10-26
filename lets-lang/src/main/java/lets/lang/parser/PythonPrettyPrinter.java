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

import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.printer.configuration.PrinterConfiguration;

public class PythonPrettyPrinter extends LangPrettyPrinter {

  public VoidVisitor<Void> createDefaultVisitor(PrinterConfiguration config) {
    return new PythonPrettyPrinterVisitor(config);
  }

  public PythonPrettyPrinter() {
    super(new PythonPrinterConfiguration(), new PythonFeatures());
  }
}
