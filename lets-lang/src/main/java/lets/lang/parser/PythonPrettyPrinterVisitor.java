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

import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.printer.configuration.PrinterConfiguration;
import java.util.function.Consumer;

public class PythonPrettyPrinterVisitor extends LangPrettyPrinterVisitor {
  public PythonPrettyPrinterVisitor(PrinterConfiguration configuration) {
    super(configuration, new LangSourcePrinter(configuration), new PythonFeatures());
  }

  @Override
  public void visit(final ImportDeclaration n, final Void arg) {
    printOrphanCommentsBeforeThisChildNode(n);
    printComment(n.getComment(), arg);
    // python no static import.
    // if (n.isStatic()) {
    //  printer.print("static ");
    // }
    if (n.isAsterisk()) {
      printer.print("from ");
      n.getName().accept(this, arg);
      printer.print(" import *");
    } else {
      n.getName()
          .getQualifier()
          .ifPresent(
              new Consumer<Name>() {
                @Override
                public void accept(Name name) {
                  printer.print("from ");
                  printer.print(name.asString());
                  printer.print(" ");
                }
              });

      printer.print("import ");
      printer.print(n.getName().getIdentifier());
    }
    printer.println();
    printOrphanCommentsEnding(n);
  }
}
