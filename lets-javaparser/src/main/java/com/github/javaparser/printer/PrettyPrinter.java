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

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.printer.configuration.PrettyPrinterConfiguration;
import com.github.javaparser.printer.configuration.PrinterConfiguration;
import java.util.function.Function;

/**
 * Pretty printer for AST nodes. This class is no longer acceptable to use because it is not
 * sufficiently configurable and it is too tied to a specific implementation
 *
 * <p>Use {@link Printer interface or DefaultPrettyPrinter default implementation } instead.
 *
 * @deprecated This class could be removed in a future version. Use default DefaultPrettyPrinter.
 */
@Deprecated
public class PrettyPrinter implements Printer {

  private PrinterConfiguration configuration;

  private Function<PrettyPrinterConfiguration, VoidVisitor<Void>> visitorFactory;

  public PrettyPrinter() {
    this(new PrettyPrinterConfiguration());
  }

  public PrettyPrinter(PrettyPrinterConfiguration configuration) {
    this(configuration, PrettyPrintVisitor::new);
  }

  public PrettyPrinter(
      PrettyPrinterConfiguration configuration,
      Function<PrettyPrinterConfiguration, VoidVisitor<Void>> visitorFactory) {
    this.configuration = configuration;
    this.visitorFactory = visitorFactory;
  }

  /*
   * Returns the PrettyPrinter configuration
   */
  public PrinterConfiguration getConfiguration() {
    return configuration;
  }

  /*
   * set or update the PrettyPrinter configuration
   */
  public Printer setConfiguration(PrinterConfiguration configuration) {
    if (!(configuration instanceof PrettyPrinterConfiguration))
      throw new IllegalArgumentException(
          "PrettyPrinter must be configured with a PrettyPrinterConfiguration class");
    this.configuration = configuration;
    return this;
  }

  @Override
  public String print(Node node) {
    final VoidVisitor<Void> visitor =
        visitorFactory.apply((PrettyPrinterConfiguration) configuration);
    node.accept(visitor, null);
    return visitor.toString();
  }
}
