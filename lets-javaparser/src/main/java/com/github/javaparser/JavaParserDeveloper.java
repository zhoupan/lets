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
package com.github.javaparser;

import com.github.javaparser.generator.core.*;
import com.github.javaparser.generator.metamodel.MetaModelGenerator;
import com.github.javaparser.printer.DefaultPrettyPrinter;
import com.github.javaparser.printer.Printer;
import com.github.javaparser.printer.configuration.DefaultConfigurationOption;
import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration;
import com.github.javaparser.printer.configuration.PrinterConfiguration;
import com.github.javaparser.utils.Log;
import com.github.javaparser.utils.SourceRoot;
import java.io.File;

public class JavaParserDeveloper {

  public JavaParserDeveloper() {
    this.setLogToStdOut();
  }

  public void setLogToStdOut() {
    Log.setAdapter(new Log.StandardOutStandardErrorAdapter());
  }

  /**
   * generate MetaModel
   *
   * @param javaSrcRoot javaparser src root.
   */
  public void generateMetaModel(File javaSrcRoot) throws Exception {
    final ParserConfiguration parserConfiguration =
        new ParserConfiguration()
            .setLanguageLevel(ParserConfiguration.LanguageLevel.RAW)
            .setStoreTokens(false);
    final SourceRoot sourceRoot = new SourceRoot(javaSrcRoot.toPath(), parserConfiguration);
    PrinterConfiguration config =
        new DefaultPrinterConfiguration()
            .addOption(
                new DefaultConfigurationOption(
                    DefaultPrinterConfiguration.ConfigOption.END_OF_LINE_CHARACTER, ("\n")));
    Printer printer = new DefaultPrettyPrinter(config);
    sourceRoot.setPrinter(printer::print);
    StaticJavaParser.setConfiguration(parserConfiguration);
    new MetaModelGenerator(sourceRoot).generate();
    sourceRoot.saveAll();
  }

  public void generateCore(File javaSrcRoot, File generatedJavaCcRoot) throws Exception {
    final ParserConfiguration parserConfiguration =
        new ParserConfiguration().setLanguageLevel(ParserConfiguration.LanguageLevel.RAW);
    final SourceRoot sourceRoot = new SourceRoot(javaSrcRoot.toPath(), parserConfiguration);
    StaticJavaParser.setConfiguration(parserConfiguration);
    final SourceRoot generatedJavaCcSourceRoot =
        new SourceRoot(generatedJavaCcRoot.toPath(), parserConfiguration);
    new CoreGenerator().run(sourceRoot, generatedJavaCcSourceRoot);
    sourceRoot.saveAll();
  }

  public void generateCore(File javaSrcRoot) throws Exception {
    generateCore(javaSrcRoot, javaSrcRoot);
  }
}
