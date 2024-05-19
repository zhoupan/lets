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
import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration;
import com.github.javaparser.printer.configuration.PrinterConfiguration;
import java.util.function.Function;

/** Pretty printer for AST nodes. */
public class DefaultPrettyPrinter implements Printer {

  private PrinterConfiguration configuration;

  // visitor factory
  Function<PrinterConfiguration, VoidVisitor<Void>> visitorFactory;

  // static methods
  private static Function<PrinterConfiguration, VoidVisitor<Void>> createDefaultVisitor() {
    return (config) -> new DefaultPrettyPrinterVisitor(config, new SourcePrinter(config));
  }

  private static PrinterConfiguration createDefaultConfiguration() {
    return new DefaultPrinterConfiguration();
  }

  // Constructors
  /** Build a new DefaultPrettyPrinter with a default configuration and a default factory */
  public DefaultPrettyPrinter() {
    this(createDefaultConfiguration());
  }

  /**
   * Build a new DefaultPrettyPrinter with a configuration and a default factory
   *
   * @param configuration
   */
  public DefaultPrettyPrinter(PrinterConfiguration configuration) {
    this(createDefaultVisitor(), configuration);
  }

  /**
   * Build a new DefaultPrettyPrinter with a configuration and a factory to create a visitor to
   * browse the nodes of the AST
   *
   * @param visitorFactory
   * @param configuration Configuration to apply
   */
  public DefaultPrettyPrinter(
      Function<PrinterConfiguration, VoidVisitor<Void>> visitorFactory,
      PrinterConfiguration configuration) {
    this.configuration = configuration;
    this.visitorFactory = visitorFactory;
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
    // lazy initialization of visitor which can have a state (like a buffer)
    VoidVisitor<Void> visitor = visitorFactory.apply(configuration);
    node.accept(visitor, null);
    return visitor.toString();
  }
}
