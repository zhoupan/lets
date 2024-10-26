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

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.printer.Printer;
import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration;
import com.github.javaparser.printer.configuration.PrinterConfiguration;

/** Pretty printer for AST nodes. */
public class LangPrettyPrinter implements Printer {

  protected PrinterConfiguration configuration;

  protected LangFeatures features;

  public VoidVisitor<Void> createDefaultVisitor(PrinterConfiguration config) {
    return new LangPrettyPrinterVisitor(config, this.createDefaultPrinter(config), this.features);
  }

  public PrinterConfiguration createDefaultConfiguration() {
    return new DefaultPrinterConfiguration();
  }

  public LangSourcePrinter createDefaultPrinter(PrinterConfiguration config) {
    return new LangSourcePrinter(config);
  }

  // Constructors

  /**
   * Build a new DefaultPrettyPrinter with a configuration.
   *
   * @param configuration Configuration to apply
   */
  public LangPrettyPrinter(PrinterConfiguration configuration, LangFeatures features) {
    this.configuration = configuration;
    this.features = features;
  }

  public LangPrettyPrinter(LangFeatures features) {
    this.configuration = this.createDefaultConfiguration();
    this.features = features;
  }

  // Methods
  /*
   * Returns the Printer configuration
   */
  public PrinterConfiguration getConfiguration() {
    return configuration;
  }

  /*
   * set or update the PrettyPrinter configuration
   */
  public Printer setConfiguration(PrinterConfiguration configuration) {
    this.configuration = configuration;
    return this;
  }

  @Override
  public String print(Node node) {
    VoidVisitor<Void> visitor = this.createDefaultVisitor(this.configuration);
    node.accept(visitor, null);
    return visitor.toString();
  }
}
